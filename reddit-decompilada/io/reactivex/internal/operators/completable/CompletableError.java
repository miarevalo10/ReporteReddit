package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.internal.disposables.EmptyDisposable;

public final class CompletableError extends Completable {
    final Throwable f34735a;

    public CompletableError(Throwable th) {
        this.f34735a = th;
    }

    protected final void subscribeActual(CompletableObserver completableObserver) {
        EmptyDisposable.m38049a(this.f34735a, completableObserver);
    }
}
