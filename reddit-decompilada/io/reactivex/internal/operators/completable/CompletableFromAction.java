package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;

public final class CompletableFromAction extends Completable {
    final Action f34737a;

    public CompletableFromAction(Action action) {
        this.f34737a = action;
    }

    protected final void subscribeActual(CompletableObserver completableObserver) {
        Disposable a = Disposables.m26512a();
        completableObserver.onSubscribe(a);
        try {
            this.f34737a.run();
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
