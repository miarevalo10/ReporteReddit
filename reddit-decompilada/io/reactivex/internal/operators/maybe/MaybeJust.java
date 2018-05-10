package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposables;
import io.reactivex.internal.fuseable.ScalarCallable;

public final class MaybeJust<T> extends Maybe<T> implements ScalarCallable<T> {
    final T f35595a;

    public MaybeJust(T t) {
        this.f35595a = t;
    }

    protected final void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        maybeObserver.onSubscribe(Disposables.m26514b());
        maybeObserver.onSuccess(this.f35595a);
    }

    public final T call() {
        return this.f35595a;
    }
}
