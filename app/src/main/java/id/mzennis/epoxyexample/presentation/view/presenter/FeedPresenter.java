package id.mzennis.epoxyexample.presentation.view.presenter;

import android.util.Log;

import com.google.gson.Gson;

import javax.inject.Inject;

import id.mzennis.epoxyexample.domain.interactor.DefaultObserver;
import id.mzennis.epoxyexample.domain.interactor.GetFeedsUseCase;
import id.mzennis.epoxyexample.domain.model.feed.FeedDomain;
import id.mzennis.epoxyexample.presentation.config.ActivityScope;
import id.mzennis.epoxyexample.presentation.view.FeedView;


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
    public void resume() {

    }

    @Override
    public void pause() {

    }

    private void showProductsCollectionInView(FeedDomain feedDomain) {
        Gson gson = new Gson();
        String result = gson.toJson(feedDomain, FeedDomain.class);
        Log.e(this.getClass().getSimpleName()+".ProductShop", result);
    }

    public void getSearchResult(String q) {
        this.feedsUseCase.execute(new ProductListObserver(), q);
    }

    @Override
    public void destroy() {
        this.feedsUseCase.dispose();
    }

    private final class ProductListObserver extends DefaultObserver<FeedDomain> {

        @Override
        public void onComplete() {
        }

        @Override
        public void onNext(FeedDomain feedDomain) {
            FeedPresenter.this.showProductsCollectionInView(feedDomain);
        }

        @Override
        public void onError(Throwable e) {
            Log.e(this.getClass().getSimpleName(), e.getMessage());
        }
    }
}
