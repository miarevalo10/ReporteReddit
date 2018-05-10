package com.nytimes.android.external.store3.base.impl;

import io.reactivex.functions.Function;

final /* synthetic */ class RealInternalStore$$Lambda$10 implements Function {
    private final RealInternalStore f15678a;
    private final Object f15679b;

    private RealInternalStore$$Lambda$10(RealInternalStore realInternalStore, Object obj) {
        this.f15678a = realInternalStore;
        this.f15679b = obj;
    }

    public static Function m15694a(RealInternalStore realInternalStore, Object obj) {
        return new RealInternalStore$$Lambda$10(realInternalStore, obj);
    }

    public final Object apply(Object obj) {
        return RealInternalStore.m19618a(this.f15678a, this.f15679b, (Throwable) obj);
    }
}
