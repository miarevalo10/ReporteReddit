package io.reactivex.rxkotlin;

import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 8})
/* compiled from: subscribers.kt */
final class SubscribersKt$sam$Consumer$2b2a3ebc implements Consumer {
    private final /* synthetic */ Function1 f32484a;

    SubscribersKt$sam$Consumer$2b2a3ebc(Function1 function1) {
        this.f32484a = function1;
    }

    public final /* synthetic */ void accept(T t) {
        Intrinsics.m26843a(this.f32484a.mo6492a(t), "invoke(...)");
    }
}
