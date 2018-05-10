package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.Callable;

public final class CompletableErrorSupplier extends Completable {
    final Callable<? extends Throwable> f34736a;

    public CompletableErrorSupplier(Callable<? extends Throwable> callable) {
        this.f34736a = callable;
    }

    protected final void subscribeActual(CompletableObserver completableObserver) {
        Throwable th;
        try {
            th = (Throwable) ObjectHelper.m26573a(this.f34736a.call(), "The error returned is null");
        } catch (Throwable th2) {
            th = th2;
            Exceptions.m26521b(th);
        }
        EmptyDisposable.m38049a(th, completableObserver);
    }
}
