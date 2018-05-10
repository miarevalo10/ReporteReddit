package com.google.android.gms.internal;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

final class zzyr implements Runnable {
    private /* synthetic */ AtomicInteger f8171a;
    private /* synthetic */ int f8172b;
    private /* synthetic */ zzalf f8173c;
    private /* synthetic */ List f8174d;

    zzyr(AtomicInteger atomicInteger, int i, zzalf com_google_android_gms_internal_zzalf, List list) {
        this.f8171a = atomicInteger;
        this.f8172b = i;
        this.f8173c = com_google_android_gms_internal_zzalf;
        this.f8174d = list;
    }

    public final void run() {
        if (this.f8171a.incrementAndGet() >= this.f8172b) {
            try {
                this.f8173c.m13330b(zzym.m6809a(this.f8174d));
            } catch (Throwable e) {
                zzakb.m5369c("Unable to convert list of futures to a future of list", e);
            }
        }
    }
}
