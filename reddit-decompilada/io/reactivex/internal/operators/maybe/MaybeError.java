package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposables;

public final class MaybeError<T> extends Maybe<T> {
    final Throwable f35571a;

    public MaybeError(Throwable th) {
        this.f35571a = th;
    }

    protected final void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        maybeObserver.onSubscribe(Disposables.m26514b());
        maybeObserver.onError(this.f35571a);
    }
}
