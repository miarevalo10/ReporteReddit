package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

public final class MaybeFromRunnable<T> extends Maybe<T> implements Callable<T> {
    final Runnable f35591a;

    public MaybeFromRunnable(Runnable runnable) {
        this.f35591a = runnable;
    }

    protected final void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        Disposable a = Disposables.m26512a();
        maybeObserver.onSubscribe(a);
        if (!a.mo5627b()) {
            try {
                this.f35591a.run();
                if (!a.mo5627b()) {
                    maybeObserver.onComplete();
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
        this.f35591a.run();
        return null;
    }
}
