package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.DeferredScalarDisposable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public final class ObservableFromFuture<T> extends Observable<T> {
    final Future<? extends T> f35674a;
    final long f35675b;
    final TimeUnit f35676c;

    public ObservableFromFuture(Future<? extends T> future, long j, TimeUnit timeUnit) {
        this.f35674a = future;
        this.f35675b = j;
        this.f35676c = timeUnit;
    }

    public final void subscribeActual(Observer<? super T> observer) {
        DeferredScalarDisposable deferredScalarDisposable = new DeferredScalarDisposable(observer);
        observer.onSubscribe(deferredScalarDisposable);
        if (!deferredScalarDisposable.mo5627b()) {
            try {
                deferredScalarDisposable.m39624a(ObjectHelper.m26573a(this.f35676c != null ? this.f35674a.get(this.f35675b, this.f35676c) : this.f35674a.get(), "Future returned null"));
            } catch (Throwable th) {
                Exceptions.m26521b(th);
                if (!deferredScalarDisposable.mo5627b()) {
                    observer.onError(th);
                }
            }
        }
    }
}
