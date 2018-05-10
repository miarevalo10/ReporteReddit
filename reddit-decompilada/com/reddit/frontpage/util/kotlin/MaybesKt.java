package com.reddit.frontpage.util.kotlin;

import com.reddit.common.rx.Thread;
import io.reactivex.Maybe;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a$\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004\u001a$\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0006"}, d2 = {"observeOn", "Lio/reactivex/Maybe;", "T", "thread", "Lcom/reddit/common/rx/Thread;", "subscribeOn", "app_standardRelease"}, k = 2, mv = {1, 1, 9})
/* compiled from: Maybes.kt */
public final class MaybesKt {
    public static final <T> Maybe<T> m24087a(Maybe<T> maybe, Thread thread) {
        Intrinsics.m26847b(maybe, "$receiver");
        Intrinsics.m26847b(thread, "thread");
        Object subscribeOn = maybe.subscribeOn(thread.a());
        Intrinsics.m26843a(subscribeOn, "subscribeOn(thread.scheduler)");
        return subscribeOn;
    }

    public static final <T> Maybe<T> m24088b(Maybe<T> maybe, Thread thread) {
        Intrinsics.m26847b(maybe, "$receiver");
        Intrinsics.m26847b(thread, "thread");
        Object observeOn = maybe.observeOn(thread.a());
        Intrinsics.m26843a(observeOn, "observeOn(thread.scheduler)");
        return observeOn;
    }
}
