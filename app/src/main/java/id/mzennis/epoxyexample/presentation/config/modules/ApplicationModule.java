package id.mzennis.epoxyexample.presentation.config.modules;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

import id.mzennis.epoxyexample.data.executor.JobExecutor;
import id.mzennis.epoxyexample.data.network.ApiService;
import id.mzennis.epoxyexample.data.network.RetrofitFactory;
import id.mzennis.epoxyexample.domain.executor.PostExecutionThread;
import id.mzennis.epoxyexample.domain.executor.ThreadExecutor;
import id.mzennis.epoxyexample.presentation.MainApplication;
import id.mzennis.epoxyexample.presentation.UIThread;
/**
 * Created by meyta on 13/12/17.
 */

@Module
public class ApplicationModule {

    private final MainApplication application;

    public ApplicationModule(MainApplication application) {
        this.application = application;
    }

    @Provides @Singleton
    Context provideApplicationContext() {
        return this.application;
    }

    @Provides @Singleton
    JobExecutor provideJobExexutor() {
        return new JobExecutor();
    }

    @Provides @Singleton
    ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor) {
        return jobExecutor;
    }

    @Provides @Singleton
    PostExecutionThread providePostExecutionThread(UIThread uiThread) {
        return uiThread;
    }

    @Provides @Singleton
    ApiService provideApiService() {
        return new ApiService(RetrofitFactory.API_BASE_URL_LIVE);
    }
}
