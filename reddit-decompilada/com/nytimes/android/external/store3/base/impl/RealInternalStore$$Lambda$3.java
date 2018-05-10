package com.nytimes.android.external.store3.base.impl;

import io.reactivex.functions.Function;

final /* synthetic */ class RealInternalStore$$Lambda$3 implements Function {
    private final RealInternalStore f15685a;
    private final Object f15686b;

    private RealInternalStore$$Lambda$3(RealInternalStore realInternalStore, Object obj) {
        this.f15685a = realInternalStore;
        this.f15686b = obj;
    }

    public static Function m15698a(RealInternalStore realInternalStore, Object obj) {
        return new RealInternalStore$$Lambda$3(realInternalStore, obj);
    }

    public final Object apply(Object obj) {
        return this.f15685a.f18668e.apply(this.f15686b, obj);
    }
}
