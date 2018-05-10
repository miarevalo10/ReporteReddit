package io.reactivex.rxkotlin;

import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.plugins.RxJavaPlugins;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 1, 8})
/* compiled from: subscribers.kt */
final class SubscribersKt$onErrorStub$1 extends Lambda implements Function1<Throwable, Unit> {
    public static final SubscribersKt$onErrorStub$1 f38165a = new SubscribersKt$onErrorStub$1();

    SubscribersKt$onErrorStub$1() {
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        Throwable th = (Throwable) obj;
        Intrinsics.m26847b(th, "it");
        RxJavaPlugins.m26757a((Throwable) new OnErrorNotImplementedException(th));
        return Unit.f25273a;
    }
}
