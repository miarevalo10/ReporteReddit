package com.nytimes.android.external.store3.base.impl;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

final /* synthetic */ class RepeatWhenEmits$$Lambda$1 implements Function {
    private final RepeatWhenEmits f15694a;

    private RepeatWhenEmits$$Lambda$1(RepeatWhenEmits repeatWhenEmits) {
        this.f15694a = repeatWhenEmits;
    }

    public static Function m15705a(RepeatWhenEmits repeatWhenEmits) {
        return new RepeatWhenEmits$$Lambda$1(repeatWhenEmits);
    }

    public final Object apply(Object obj) {
        return ((Observable) obj).switchMap(RepeatWhenEmits$$Lambda$2.m15706a(this.f15694a));
    }
}
