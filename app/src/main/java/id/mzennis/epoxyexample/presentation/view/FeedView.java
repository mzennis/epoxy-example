package id.mzennis.epoxyexample.presentation.view;

import java.util.ArrayList;

import id.mzennis.epoxyexample.presentation.view.model.FeedModel;

/**
 * Created by meyta on 04/01/18.
 */

public interface FeedView extends BaseView {
    /**
     * Show a view with a progress bar indicating a loading process.
     */
    void showLoading();

    /**
     * Hide a loading view.
     */
    void hideLoading();

    /**
     * Show a retry view in case of an error when retrieving data.
     */
    void showRetry();

    /**
     * Hide a retry view shown if there was an error when retrieving data.
     */
    void hideRetry();

    void showFeedCollection(ArrayList<FeedModel> feedModels);
}
