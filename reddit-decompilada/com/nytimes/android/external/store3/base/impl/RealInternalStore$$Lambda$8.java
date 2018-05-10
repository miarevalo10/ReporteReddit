package com.nytimes.android.external.store3.base.impl;

import java.util.concurrent.Callable;

final /* synthetic */ class RealInternalStore$$Lambda$8 implements Callable {
    private final RealInternalStore f10246a;
    private final Object f10247b;

    private RealInternalStore$$Lambda$8(RealInternalStore realInternalStore, Object obj) {
        this.f10246a = realInternalStore;
        this.f10247b = obj;
    }

    public static Callable m8704a(RealInternalStore realInternalStore, Object obj) {
        return new RealInternalStore$$Lambda$8(realInternalStore, obj);
    }

    public final Object call() {
        return this.f10246a.f18671h.mo2915a(this.f10247b).flatMap(RealInternalStore$$Lambda$9.m15702a(this.f10246a, this.f10247b)).onErrorResumeNext(RealInternalStore$$Lambda$10.m15694a(this.f10246a, this.f10247b)).doOnSuccess(RealInternalStore$$Lambda$11.m15695a(this.f10246a)).doAfterTerminate(RealInternalStore$$Lambda$12.m15696a(this.f10246a, this.f10247b)).cache();
    }
}
