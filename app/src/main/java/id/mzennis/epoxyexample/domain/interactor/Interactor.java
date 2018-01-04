package id.mzennis.epoxyexample.domain.interactor;

import org.reactivestreams.Subscriber;

import id.mzennis.epoxyexample.domain.interactor.param.RequestParams;
import io.reactivex.Observable;

/**
 * Created by meyta on 03/01/18.
 */

public interface Interactor<T> {

    void execute(RequestParams requestParams, Subscriber<T> subscriber);

    Observable<T> getExecuteObservable(RequestParams requestParams);
}

