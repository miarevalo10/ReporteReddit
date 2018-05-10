package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.exceptions.Exceptions;
import java.util.concurrent.Callable;

public final class CompletableFromCallable extends Completable {
    final Callable<?> f34738a;

    public CompletableFromCallable(Callable<?> callable) {
        this.f34738a = callable;
    }

    protected final void subscribeActual(CompletableObserver completableObserver) {
        Disposable a = Disposables.m26512a();
        completableObserver.onSubscribe(a);
        try {
            this.f34738a.call();
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
