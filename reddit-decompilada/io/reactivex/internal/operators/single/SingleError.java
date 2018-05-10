package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.Callable;

public final class SingleError<T> extends Single<T> {
    final Callable<? extends Throwable> f35807a;

    public SingleError(Callable<? extends Throwable> callable) {
        this.f35807a = callable;
    }

    protected final void subscribeActual(SingleObserver<? super T> singleObserver) {
        Throwable th;
        try {
            th = (Throwable) ObjectHelper.m26573a(this.f35807a.call(), "Callable returned null throwable. Null values are generally not allowed in 2.x operators and sources.");
        } catch (Throwable th2) {
            th = th2;
            Exceptions.m26521b(th);
        }
        EmptyDisposable.m38052a(th, (SingleObserver) singleObserver);
    }
}
