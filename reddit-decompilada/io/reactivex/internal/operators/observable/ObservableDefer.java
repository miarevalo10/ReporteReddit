package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.Callable;

public final class ObservableDefer<T> extends Observable<T> {
    final Callable<? extends ObservableSource<? extends T>> f35659a;

    public ObservableDefer(Callable<? extends ObservableSource<? extends T>> callable) {
        this.f35659a = callable;
    }

    public final void subscribeActual(Observer<? super T> observer) {
        try {
            ((ObservableSource) ObjectHelper.m26573a(this.f35659a.call(), "null ObservableSource supplied")).subscribe(observer);
        } catch (Throwable th) {
            Exceptions.m26521b(th);
            EmptyDisposable.m38051a(th, (Observer) observer);
        }
    }
}
