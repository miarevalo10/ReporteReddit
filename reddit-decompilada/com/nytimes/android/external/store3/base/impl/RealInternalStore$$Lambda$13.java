package com.nytimes.android.external.store3.base.impl;

import io.reactivex.functions.Function;

final /* synthetic */ class RealInternalStore$$Lambda$13 implements Function {
    private final RealInternalStore f15683a;
    private final Object f15684b;

    private RealInternalStore$$Lambda$13(RealInternalStore realInternalStore, Object obj) {
        this.f15683a = realInternalStore;
        this.f15684b = obj;
    }

    public static Function m15697a(RealInternalStore realInternalStore, Object obj) {
        return new RealInternalStore$$Lambda$13(realInternalStore, obj);
    }

    public final Object apply(Object obj) {
        return this.f15683a.m19625d(this.f15684b).toSingle();
    }
}
