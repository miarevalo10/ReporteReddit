package io.reactivex.flowables;

import io.reactivex.Flowable;

public abstract class GroupedFlowable<K, T> extends Flowable<T> {
    final K f34702a;

    protected GroupedFlowable(K k) {
        this.f34702a = k;
    }
}
