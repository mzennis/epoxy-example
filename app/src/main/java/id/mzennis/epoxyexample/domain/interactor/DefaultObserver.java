package id.mzennis.epoxyexample.domain.interactor;

import io.reactivex.observers.DisposableObserver;

/**
 * Created by meyta on 04/01/18.
 */

public class DefaultObserver<T> extends DisposableObserver<T> {

    @Override
    public void onNext(T value) {}

    @Override
    public void onError(Throwable e) {}

    @Override
    public void onComplete() {}
}
