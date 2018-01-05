package id.mzennis.epoxyexample.presentation.view.presenter;

import android.util.Log;

import com.google.gson.Gson;

import javax.inject.Inject;

import id.mzennis.epoxyexample.domain.exception.DefaultErrorBundle;
import id.mzennis.epoxyexample.domain.exception.ErrorBundle;
import id.mzennis.epoxyexample.domain.interactor.DefaultObserver;
import id.mzennis.epoxyexample.domain.interactor.GetFeedsUseCase;
import id.mzennis.epoxyexample.domain.model.feed.FeedDomain;
import id.mzennis.epoxyexample.presentation.config.ActivityScope;
import id.mzennis.epoxyexample.presentation.exception.ErrorMessageFactory;
import id.mzennis.epoxyexample.presentation.view.FeedView;
import id.mzennis.epoxyexample.presentation.view.model.FeedPresentation;
import id.mzennis.epoxyexample.presentation.view.subscriber.FeedSubscriber;


/**
 * Created by meyta on 04/01/18.
 */

@ActivityScope
public class FeedPresenter implements Presenter<FeedView> {

    private FeedView feedView;

    private final GetFeedsUseCase feedsUseCase;

    @Inject
    public FeedPresenter(GetFeedsUseCase feedsUseCase) {
        this.feedsUseCase = feedsUseCase;
    }


    @Override
    public void setView(FeedView view) {
        this.feedView = view;
    }

    @Override
    public void resume() {}

    @Override
    public void pause() {}

    private void loadFeed(String id) {
        this.feedView.hideRetry();
        this.feedView.showLoading();
        this.getFeedData(id);
    }

    private void showFeedCollectionInView(FeedPresentation feed) {
        Gson gson = new Gson();
        String result = gson.toJson(feed, FeedPresentation.class);
        Log.e(this.getClass().getSimpleName()+".ProductShop", result);
    }

    public void getFeedData(String id) {
        this.feedsUseCase.execute(new FeedSubscriber(this.feedView), id);
    }

    @Override
    public void destroy() {
        this.feedsUseCase.dispose();
        this.feedView = null;
    }
}
