package com.nytimes.android.external.store3.base.impl;

import io.reactivex.functions.Consumer;

final /* synthetic */ class RealInternalStore$$Lambda$4 implements Consumer {
    private final RealInternalStore f15687a;
    private final Object f15688b;

    private RealInternalStore$$Lambda$4(RealInternalStore realInternalStore, Object obj) {
        this.f15687a = realInternalStore;
        this.f15688b = obj;
    }

    public static Consumer m15699a(RealInternalStore realInternalStore, Object obj) {
        return new RealInternalStore$$Lambda$4(realInternalStore, obj);
    }

    public final void accept(Object obj) {
        RealInternalStore.m19621b(this.f15687a, this.f15688b, obj);
    }
}
