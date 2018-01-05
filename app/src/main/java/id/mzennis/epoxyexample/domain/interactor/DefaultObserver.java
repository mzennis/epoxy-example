package id.mzennis.epoxyexample.domain.interactor;

import id.mzennis.epoxyexample.presentation.view.BaseView;
import io.reactivex.observers.DisposableObserver;

/**
 * Created by meyta on 04/01/18.
 */

public class DefaultObserver<T, P extends BaseView> extends DisposableObserver<T> {

    public P view;

    public DefaultObserver(P view) {
        this.view = view;
    }

    @Override
    public void onNext(T value) {}

    @Override
    public void onError(Throwable e) {}

    @Override
    public void onComplete() {}
}
