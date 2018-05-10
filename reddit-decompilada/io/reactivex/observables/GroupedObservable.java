package io.reactivex.observables;

import io.reactivex.Observable;

public abstract class GroupedObservable<K, T> extends Observable<T> {
    final K f35939b;

    protected GroupedObservable(K k) {
        this.f35939b = k;
    }
}
