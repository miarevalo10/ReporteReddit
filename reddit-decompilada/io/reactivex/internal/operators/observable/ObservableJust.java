package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.internal.fuseable.ScalarCallable;
import io.reactivex.internal.operators.observable.ObservableScalarXMap.ScalarDisposable;

public final class ObservableJust<T> extends Observable<T> implements ScalarCallable<T> {
    private final T f35696a;

    public ObservableJust(T t) {
        this.f35696a = t;
    }

    protected final void subscribeActual(Observer<? super T> observer) {
        Object scalarDisposable = new ScalarDisposable(observer, this.f35696a);
        observer.onSubscribe(scalarDisposable);
        scalarDisposable.run();
    }

    public final T call() {
        return this.f35696a;
    }
}
