package com.nytimes.android.external.store3.base.impl;

import java.util.concurrent.Callable;

final /* synthetic */ class RealInternalStore$$Lambda$2 implements Callable {
    private final RealInternalStore f10242a;
    private final Object f10243b;

    private RealInternalStore$$Lambda$2(RealInternalStore realInternalStore, Object obj) {
        this.f10242a = realInternalStore;
        this.f10243b = obj;
    }

    public static Callable m8702a(RealInternalStore realInternalStore, Object obj) {
        return new RealInternalStore$$Lambda$2(realInternalStore, obj);
    }

    public final Object call() {
        return RealInternalStore.m19627e(this.f10242a, this.f10243b);
    }
}
