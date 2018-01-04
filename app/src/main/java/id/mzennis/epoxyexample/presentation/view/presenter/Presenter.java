package id.mzennis.epoxyexample.presentation.view.presenter;

import id.mzennis.epoxyexample.presentation.view.BaseView;

/**
 * Created by meyta on 04/01/18.
 */

public interface Presenter<T extends BaseView> {

    void setView(T view);
    /**
     * Method that control the lifecycle of the view. It should be called in the view's
     * (Activity or Fragment) onResume() method.
     */
    void resume();

    /**
     * Method that control the lifecycle of the view. It should be called in the view's
     * (Activity or Fragment) onPause() method.
     */
    void pause();

    /**
     * Method that control the lifecycle of the view. It should be called in the view's
     * (Activity or Fragment) onDestroy() method.
     */
    void destroy();
}