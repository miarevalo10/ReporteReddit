package com.google.android.gms.internal;

import java.util.HashMap;

public final class zzcz extends zzbt<Integer, Long> {
    public long f14275a;
    public long f14276b;

    public zzcz() {
        this.f14275a = -1;
        this.f14276b = -1;
    }

    public zzcz(String str) {
        this();
        mo1771a(str);
    }

    protected final HashMap<Integer, Long> mo1770a() {
        HashMap<Integer, Long> hashMap = new HashMap();
        hashMap.put(Integer.valueOf(0), Long.valueOf(this.f14275a));
        hashMap.put(Integer.valueOf(1), Long.valueOf(this.f14276b));
        return hashMap;
    }

    protected final void mo1771a(String str) {
        HashMap b = zzbt.m5576b(str);
        if (b != null) {
            this.f14275a = ((Long) b.get(Integer.valueOf(0))).longValue();
            this.f14276b = ((Long) b.get(Integer.valueOf(1))).longValue();
        }
    }
}
