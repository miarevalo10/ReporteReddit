package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.DeferredScalarDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

public final class ObservableFromCallable<T> extends Observable<T> implements Callable<T> {
    final Callable<? extends T> f35673a;

    public ObservableFromCallable(Callable<? extends T> callable) {
        this.f35673a = callable;
    }

    public final void subscribeActual(Observer<? super T> observer) {
        DeferredScalarDisposable deferredScalarDisposable = new DeferredScalarDisposable(observer);
        observer.onSubscribe(deferredScalarDisposable);
        if (!deferredScalarDisposable.mo5627b()) {
            try {
                deferredScalarDisposable.m39624a(ObjectHelper.m26573a(this.f35673a.call(), "Callable returned null"));
            } catch (Throwable th) {
                Exceptions.m26521b(th);
                if (deferredScalarDisposable.mo5627b()) {
                    RxJavaPlugins.m26757a(th);
                } else {
                    observer.onError(th);
                }
            }
        }
    }

    public final T call() throws Exception {
        return ObjectHelper.m26573a(this.f35673a.call(), "The callable returned a null value");
    }
}
