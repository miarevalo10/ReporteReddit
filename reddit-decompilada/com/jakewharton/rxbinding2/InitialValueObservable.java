package com.jakewharton.rxbinding2;

import io.reactivex.Observable;
import io.reactivex.Observer;

public abstract class InitialValueObservable<T> extends Observable<T> {
    public abstract T mo4086a();

    public abstract void mo4087a(Observer<? super T> observer);

    protected final void subscribeActual(Observer<? super T> observer) {
        mo4087a(observer);
        observer.onNext(mo4086a());
    }
}
