package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.Callable;

public final class ObservableError<T> extends Observable<T> {
    final Callable<? extends Throwable> f35668a;

    public ObservableError(Callable<? extends Throwable> callable) {
        this.f35668a = callable;
    }

    public final void subscribeActual(Observer<? super T> observer) {
        Throwable th;
        try {
            th = (Throwable) ObjectHelper.m26573a(this.f35668a.call(), "Callable returned null throwable. Null values are generally not allowed in 2.x operators and sources.");
        } catch (Throwable th2) {
            th = th2;
            Exceptions.m26521b(th);
        }
        EmptyDisposable.m38051a(th, (Observer) observer);
    }
}
