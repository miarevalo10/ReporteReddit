package com.nytimes.android.external.store3.base.impl;

import io.reactivex.functions.Action;

final /* synthetic */ class RealInternalStore$$Lambda$12 implements Action {
    private final RealInternalStore f15681a;
    private final Object f15682b;

    private RealInternalStore$$Lambda$12(RealInternalStore realInternalStore, Object obj) {
        this.f15681a = realInternalStore;
        this.f15682b = obj;
    }

    public static Action m15696a(RealInternalStore realInternalStore, Object obj) {
        return new RealInternalStore$$Lambda$12(realInternalStore, obj);
    }

    public final void run() {
        this.f15681a.f18664a.invalidate(this.f15682b);
    }
}
