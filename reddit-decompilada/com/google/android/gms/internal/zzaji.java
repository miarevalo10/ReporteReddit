package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzbs;

@zzzv
public final class zzaji {
    private long f6449a;
    private long f6450b = Long.MIN_VALUE;
    private Object f6451c = new Object();

    public zzaji(long j) {
        this.f6449a = j;
    }

    public final boolean m5301a() {
        synchronized (this.f6451c) {
            long b = zzbs.m4492k().mo1633b();
            if (this.f6450b + this.f6449a > b) {
                return false;
            }
            this.f6450b = b;
            return true;
        }
    }
}
