package com.reddit.frontpage.util.kotlin;

import com.reddit.common.rx.Thread;
import io.reactivex.Single;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a$\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004\u001a$\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0006"}, d2 = {"observeOn", "Lio/reactivex/Single;", "T", "thread", "Lcom/reddit/common/rx/Thread;", "subscribeOn", "app_standardRelease"}, k = 2, mv = {1, 1, 9})
/* compiled from: Singles.kt */
public final class SinglesKt {
    public static final <T> Single<T> m24093a(Single<T> single, Thread thread) {
        Intrinsics.m26847b(single, "$receiver");
        Intrinsics.m26847b(thread, "thread");
        Object subscribeOn = single.subscribeOn(thread.a());
        Intrinsics.m26843a(subscribeOn, "subscribeOn(thread.scheduler)");
        return subscribeOn;
    }

    public static final <T> Single<T> m24094b(Single<T> single, Thread thread) {
        Intrinsics.m26847b(single, "$receiver");
        Intrinsics.m26847b(thread, "thread");
        Object observeOn = single.observeOn(thread.a());
        Intrinsics.m26843a(observeOn, "observeOn(thread.scheduler)");
        return observeOn;
    }
}
