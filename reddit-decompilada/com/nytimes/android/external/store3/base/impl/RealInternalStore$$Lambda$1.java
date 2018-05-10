package com.nytimes.android.external.store3.base.impl;

import java.util.concurrent.Callable;

final /* synthetic */ class RealInternalStore$$Lambda$1 implements Callable {
    private final RealInternalStore f10240a;
    private final Object f10241b;

    private RealInternalStore$$Lambda$1(RealInternalStore realInternalStore, Object obj) {
        this.f10240a = realInternalStore;
        this.f10241b = obj;
    }

    public static Callable m8701a(RealInternalStore realInternalStore, Object obj) {
        return new RealInternalStore$$Lambda$1(realInternalStore, obj);
    }

    public final Object call() {
        return this.f10240a.m19622c(this.f10241b);
    }
}
