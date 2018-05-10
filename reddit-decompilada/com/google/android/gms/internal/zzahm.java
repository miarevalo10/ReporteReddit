package com.google.android.gms.internal;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class zzahm implements ThreadFactory {
    private final AtomicInteger f6377a = new AtomicInteger(1);
    private /* synthetic */ String f6378b;

    zzahm(String str) {
        this.f6378b = str;
    }

    public final Thread newThread(Runnable runnable) {
        String str = this.f6378b;
        int andIncrement = this.f6377a.getAndIncrement();
        StringBuilder stringBuilder = new StringBuilder(23 + String.valueOf(str).length());
        stringBuilder.append("AdWorker(");
        stringBuilder.append(str);
        stringBuilder.append(") #");
        stringBuilder.append(andIncrement);
        return new Thread(runnable, stringBuilder.toString());
    }
}
