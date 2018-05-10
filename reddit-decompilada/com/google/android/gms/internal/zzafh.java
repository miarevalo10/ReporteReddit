package com.google.android.gms.internal;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class zzafh implements ThreadFactory {
    private final AtomicInteger f6272a = new AtomicInteger(1);

    zzafh() {
    }

    public final Thread newThread(Runnable runnable) {
        int andIncrement = this.f6272a.getAndIncrement();
        StringBuilder stringBuilder = new StringBuilder(42);
        stringBuilder.append("AdWorker(SCION_TASK_EXECUTOR) #");
        stringBuilder.append(andIncrement);
        return new Thread(runnable, stringBuilder.toString());
    }
}
