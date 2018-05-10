package com.nytimes.android.external.store3.base.impl;

import io.reactivex.functions.Function;

final /* synthetic */ class RepeatWhenEmits$$Lambda$2 implements Function {
    private final RepeatWhenEmits f15695a;

    private RepeatWhenEmits$$Lambda$2(RepeatWhenEmits repeatWhenEmits) {
        this.f15695a = repeatWhenEmits;
    }

    public static Function m15706a(RepeatWhenEmits repeatWhenEmits) {
        return new RepeatWhenEmits$$Lambda$2(repeatWhenEmits);
    }

    public final Object apply(Object obj) {
        return this.f15695a.f15696a;
    }
}
