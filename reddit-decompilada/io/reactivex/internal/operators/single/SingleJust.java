package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposables;

public final class SingleJust<T> extends Single<T> {
    final T f35827a;

    public SingleJust(T t) {
        this.f35827a = t;
    }

    protected final void subscribeActual(SingleObserver<? super T> singleObserver) {
        singleObserver.onSubscribe(Disposables.m26514b());
        singleObserver.onSuccess(this.f35827a);
    }
}
