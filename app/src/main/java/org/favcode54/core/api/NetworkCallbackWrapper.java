package org.favcode54.core.api;

import rx.Subscriber;

public abstract class NetworkCallbackWrapper<T> extends Subscriber<T> {

    public abstract void onSuccess(T t);

    public abstract void onErrorOccured(Throwable throwable);

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onNext(T t) {

    }
}
