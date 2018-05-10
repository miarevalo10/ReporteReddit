package com.nytimes.android.external.store3.base.impl;

import io.reactivex.functions.Consumer;

final /* synthetic */ class RealInternalStore$$Lambda$11 implements Consumer {
    private final RealInternalStore f15680a;

    private RealInternalStore$$Lambda$11(RealInternalStore realInternalStore) {
        this.f15680a = realInternalStore;
    }

    public static Consumer m15695a(RealInternalStore realInternalStore) {
        return new RealInternalStore$$Lambda$11(realInternalStore);
    }

    public final void accept(Object obj) {
        this.f15680a.f18669f.onNext(obj);
    }
}
