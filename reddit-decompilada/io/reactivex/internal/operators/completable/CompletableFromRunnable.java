package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.exceptions.Exceptions;

public final class CompletableFromRunnable extends Completable {
    final Runnable f34743a;

    public CompletableFromRunnable(Runnable runnable) {
        this.f34743a = runnable;
    }

    protected final void subscribeActual(CompletableObserver completableObserver) {
        Disposable a = Disposables.m26512a();
        completableObserver.onSubscribe(a);
        try {
            this.f34743a.run();
            if (!a.mo5627b()) {
                completableObserver.onComplete();
            }
        } catch (Throwable th) {
            Exceptions.m26521b(th);
            if (!a.mo5627b()) {
                completableObserver.onError(th);
            }
        }
    }
}
