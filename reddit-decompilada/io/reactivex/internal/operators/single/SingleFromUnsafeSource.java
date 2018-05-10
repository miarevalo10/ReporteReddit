package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;

public final class SingleFromUnsafeSource<T> extends Single<T> {
    final SingleSource<T> f35825a;

    public SingleFromUnsafeSource(SingleSource<T> singleSource) {
        this.f35825a = singleSource;
    }

    protected final void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f35825a.subscribe(singleObserver);
    }
}
