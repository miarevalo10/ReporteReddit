package io.reactivex.rxkotlin;

import io.reactivex.functions.Action;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 8})
/* compiled from: subscribers.kt */
final class SubscribersKt$sam$Action$fd62537c implements Action {
    private final /* synthetic */ Function0 f32483a;

    SubscribersKt$sam$Action$fd62537c(Function0 function0) {
        this.f32483a = function0;
    }

    public final /* synthetic */ void run() {
        Intrinsics.m26843a(this.f32483a.invoke(), "invoke(...)");
    }
}
