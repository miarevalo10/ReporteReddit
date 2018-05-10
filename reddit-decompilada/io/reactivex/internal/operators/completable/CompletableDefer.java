package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.Callable;

public final class CompletableDefer extends Completable {
    final Callable<? extends CompletableSource> f34721a;

    public CompletableDefer(Callable<? extends CompletableSource> callable) {
        this.f34721a = callable;
    }

    protected final void subscribeActual(CompletableObserver completableObserver) {
        try {
            ((CompletableSource) ObjectHelper.m26573a(this.f34721a.call(), "The completableSupplier returned a null CompletableSource")).subscribe(completableObserver);
        } catch (Throwable th) {
            Exceptions.m26521b(th);
            EmptyDisposable.m38049a(th, completableObserver);
        }
    }
}
