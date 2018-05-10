package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.internal.disposables.EmptyDisposable;

public final class SingleNever extends Single<Object> {
    public static final Single<Object> f35832a = new SingleNever();

    private SingleNever() {
    }

    protected final void subscribeActual(SingleObserver<? super Object> singleObserver) {
        singleObserver.onSubscribe(EmptyDisposable.NEVER);
    }
}
