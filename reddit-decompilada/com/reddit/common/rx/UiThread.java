package com.reddit.common.rx;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/reddit/common/rx/UiThread;", "Lcom/reddit/common/rx/PostExecutionThread;", "()V", "scheduler", "Lio/reactivex/Scheduler;", "getScheduler", "()Lio/reactivex/Scheduler;", "common_release"}, k = 1, mv = {1, 1, 9})
/* compiled from: UiThread.kt */
public final class UiThread implements PostExecutionThread {
    public final Scheduler mo3777a() {
        Scheduler a = AndroidSchedulers.a();
        Intrinsics.a(a, "AndroidSchedulers.mainThread()");
        return a;
    }
}
