package com.nytimes.android.external.store3.base.impl;

import java.util.concurrent.Callable;

final /* synthetic */ class RealInternalStore$$Lambda$7 implements Callable {
    private final RealInternalStore f10244a;
    private final Object f10245b;

    private RealInternalStore$$Lambda$7(RealInternalStore realInternalStore, Object obj) {
        this.f10244a = realInternalStore;
        this.f10245b = obj;
    }

    public static Callable m8703a(RealInternalStore realInternalStore, Object obj) {
        return new RealInternalStore$$Lambda$7(realInternalStore, obj);
    }

    public final Object call() {
        return this.f10244a.m19628e(this.f10245b);
    }
}
