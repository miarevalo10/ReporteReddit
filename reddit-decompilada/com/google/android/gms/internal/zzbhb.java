package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzbq;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public final class zzbhb implements ThreadFactory {
    private final String f6703a;
    private final int f6704b;
    private final AtomicInteger f6705c;
    private final ThreadFactory f6706d;

    public zzbhb(String str) {
        this(str, (byte) 0);
    }

    private zzbhb(String str, byte b) {
        this.f6705c = new AtomicInteger();
        this.f6706d = Executors.defaultThreadFactory();
        this.f6703a = (String) zzbq.m4809a((Object) str, (Object) "Name must not be null");
        this.f6704b = 0;
    }

    public final Thread newThread(Runnable runnable) {
        Thread newThread = this.f6706d.newThread(new zzbhc(runnable));
        String str = this.f6703a;
        int andIncrement = this.f6705c.getAndIncrement();
        StringBuilder stringBuilder = new StringBuilder(13 + String.valueOf(str).length());
        stringBuilder.append(str);
        stringBuilder.append("[");
        stringBuilder.append(andIncrement);
        stringBuilder.append("]");
        newThread.setName(stringBuilder.toString());
        return newThread;
    }
}
