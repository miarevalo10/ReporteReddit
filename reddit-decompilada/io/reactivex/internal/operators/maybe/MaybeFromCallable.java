package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

public final class MaybeFromCallable<T> extends Maybe<T> implements Callable<T> {
    final Callable<? extends T> f35586a;

    public MaybeFromCallable(Callable<? extends T> callable) {
        this.f35586a = callable;
    }

    protected final void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        Disposable a = Disposables.m26512a();
        maybeObserver.onSubscribe(a);
        if (!a.mo5627b()) {
            try {
                Object call = this.f35586a.call();
                if (!a.mo5627b()) {
                    if (call == null) {
                        maybeObserver.onComplete();
                        return;
                    }
                    maybeObserver.onSuccess(call);
                }
            } catch (Throwable th) {
                Exceptions.m26521b(th);
                if (a.mo5627b()) {
                    RxJavaPlugins.m26757a(th);
                } else {
                    maybeObserver.onError(th);
                }
            }
        }
    }

    public final T call() throws Exception {
        return this.f35586a.call();
    }
}
