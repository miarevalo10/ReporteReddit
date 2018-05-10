package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposables;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.Callable;

public final class MaybeErrorCallable<T> extends Maybe<T> {
    final Callable<? extends Throwable> f35572a;

    public MaybeErrorCallable(Callable<? extends Throwable> callable) {
        this.f35572a = callable;
    }

    protected final void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        Throwable th;
        maybeObserver.onSubscribe(Disposables.m26514b());
        try {
            th = (Throwable) ObjectHelper.m26573a(this.f35572a.call(), "Callable returned null throwable. Null values are generally not allowed in 2.x operators and sources.");
        } catch (Throwable th2) {
            th = th2;
            Exceptions.m26521b(th);
        }
        maybeObserver.onError(th);
    }
}
