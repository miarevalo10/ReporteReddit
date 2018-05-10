package com.nytimes.android.external.store3.base.impl;

import io.reactivex.functions.Function;

final /* synthetic */ class RealInternalStore$$Lambda$9 implements Function {
    private final RealInternalStore f15691a;
    private final Object f15692b;

    private RealInternalStore$$Lambda$9(RealInternalStore realInternalStore, Object obj) {
        this.f15691a = realInternalStore;
        this.f15692b = obj;
    }

    public static Function m15702a(RealInternalStore realInternalStore, Object obj) {
        return new RealInternalStore$$Lambda$9(realInternalStore, obj);
    }

    public final Object apply(Object obj) {
        return this.f15691a.f18667d.mo2709a(this.f15692b, obj).flatMap(RealInternalStore$$Lambda$13.m15697a(this.f15691a, this.f15692b));
    }
}
