package com.reddit.frontpage.util.kotlin;

import com.reddit.common.rx.Thread;
import io.reactivex.Completable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0012\u0010\u0004\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0005"}, d2 = {"observeOn", "Lio/reactivex/Completable;", "thread", "Lcom/reddit/common/rx/Thread;", "subscribeOn", "app_standardRelease"}, k = 2, mv = {1, 1, 9})
/* compiled from: Completables.kt */
public final class CompletablesKt {
    public static final Completable m24073a(Completable completable, Thread thread) {
        Intrinsics.m26847b(completable, "$receiver");
        Intrinsics.m26847b(thread, "thread");
        Object subscribeOn = completable.subscribeOn(thread.a());
        Intrinsics.m26843a(subscribeOn, "subscribeOn(thread.scheduler)");
        return subscribeOn;
    }

    public static final Completable m24074b(Completable completable, Thread thread) {
        Intrinsics.m26847b(completable, "$receiver");
        Intrinsics.m26847b(thread, "thread");
        Object observeOn = completable.observeOn(thread.a());
        Intrinsics.m26843a(observeOn, "observeOn(thread.scheduler)");
        return observeOn;
    }
}
