package com.nytimes.android.external.store3.base.impl;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;

final class RepeatWhenEmits<T> implements ObservableTransformer<T, T> {
    private final Observable f15696a;

    public final ObservableSource<T> m15709a(Observable<T> observable) {
        return observable.repeatWhen(RepeatWhenEmits$$Lambda$1.m15705a(this));
    }
}
