package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.Callable;

public final class MaybeDefer<T> extends Maybe<T> {
    final Callable<? extends MaybeSource<? extends T>> f35558a;

    public MaybeDefer(Callable<? extends MaybeSource<? extends T>> callable) {
        this.f35558a = callable;
    }

    protected final void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        try {
            ((MaybeSource) ObjectHelper.m26573a(this.f35558a.call(), "The maybeSupplier returned a null MaybeSource")).subscribe(maybeObserver);
        } catch (Throwable th) {
            Exceptions.m26521b(th);
            EmptyDisposable.m38050a(th, (MaybeObserver) maybeObserver);
        }
    }
}
