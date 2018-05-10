package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;

public final class ObservableFromUnsafeSource<T> extends Observable<T> {
    final ObservableSource<T> f35681a;

    public ObservableFromUnsafeSource(ObservableSource<T> observableSource) {
        this.f35681a = observableSource;
    }

    protected final void subscribeActual(Observer<? super T> observer) {
        this.f35681a.subscribe(observer);
    }
}
