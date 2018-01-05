package id.mzennis.epoxyexample.presentation.view.presenter;

import javax.inject.Inject;

import id.mzennis.epoxyexample.domain.interactor.GetFeedsUseCase;
import id.mzennis.epoxyexample.presentation.config.ActivityScope;
import id.mzennis.epoxyexample.presentation.view.FeedView;
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

    public void loadFeed(String id) {
        this.feedView.hideRetry();
        this.feedView.showLoading();
        this.getFeedData(id);
    }

    private void getFeedData(String id) {
        this.feedsUseCase.execute(new FeedSubscriber(this.feedView), id);
    }

    @Override
    public void destroy() {
        this.feedsUseCase.dispose();
        this.feedView = null;
    }
}
