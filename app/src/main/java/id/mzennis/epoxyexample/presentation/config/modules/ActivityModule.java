package id.mzennis.epoxyexample.presentation.config.modules;

import android.app.Activity;
import android.content.Context;

import dagger.Module;
import dagger.Provides;
import id.mzennis.epoxyexample.data.factory.FeedFactory;
import id.mzennis.epoxyexample.data.mapper.FeedMapper;
import id.mzennis.epoxyexample.data.mapper.FeedPresentationMapper;
import id.mzennis.epoxyexample.data.network.ApiService;
import id.mzennis.epoxyexample.data.repository.FeedRepository;
import id.mzennis.epoxyexample.data.repository.FeedRepositoryImpl;
import id.mzennis.epoxyexample.domain.executor.PostExecutionThread;
import id.mzennis.epoxyexample.domain.executor.ThreadExecutor;
import id.mzennis.epoxyexample.domain.interactor.GetFeedsUseCase;
import id.mzennis.epoxyexample.presentation.config.ActivityScope;

/**
 * Created by meyta on 13/12/17.
 */

@Module
public class ActivityModule {

    private final Activity activity;

    @Provides @ActivityScope
    Activity activity() {
        return this.activity;
    }


    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides @ActivityScope
    FeedMapper provideFeedMapper() {
        return new FeedMapper();
    }

    @Provides @ActivityScope
    FeedFactory provideFeedFactory(Context context,
                                   ApiService apiService,
                                   FeedMapper feedMapper) {
        return new FeedFactory(context, apiService, feedMapper);
    }

    @Provides @ActivityScope
    FeedPresentationMapper provideFeedPresentationMapper() {
        return new FeedPresentationMapper();
    }

    @Provides @ActivityScope
    FeedRepositoryImpl provideFeedRepositoryImpl(FeedFactory feedFactory, FeedPresentationMapper feedPresentationMapper) {
        return new FeedRepositoryImpl(feedFactory, feedPresentationMapper);
    }

    @Provides @ActivityScope
    FeedRepository provideFeedRepository(FeedRepositoryImpl repository) {
        return repository;
    }

    @Provides @ActivityScope
    GetFeedsUseCase provideGetFeedUseCase(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, FeedRepository feedRepository) {
        return new GetFeedsUseCase(threadExecutor, postExecutionThread, feedRepository);
    }
}
