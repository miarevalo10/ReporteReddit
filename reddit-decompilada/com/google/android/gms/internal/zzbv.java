package com.google.android.gms.internal;

import java.util.HashMap;

public final class zzbv extends zzbt<Integer, Object> {
    public String f14209a;
    public long f14210b;
    public String f14211c;
    public String f14212d;
    public String f14213e;

    public zzbv() {
        this.f14209a = "E";
        this.f14210b = -1;
        this.f14211c = "E";
        this.f14212d = "E";
        this.f14213e = "E";
    }

    public zzbv(String str) {
        this();
        mo1771a(str);
    }

    protected final HashMap<Integer, Object> mo1770a() {
        HashMap<Integer, Object> hashMap = new HashMap();
        hashMap.put(Integer.valueOf(0), this.f14209a);
        hashMap.put(Integer.valueOf(4), this.f14213e);
        hashMap.put(Integer.valueOf(3), this.f14212d);
        hashMap.put(Integer.valueOf(2), this.f14211c);
        hashMap.put(Integer.valueOf(1), Long.valueOf(this.f14210b));
        return hashMap;
    }

    protected final void mo1771a(String str) {
        HashMap b = zzbt.m5576b(str);
        if (b != null) {
            this.f14209a = b.get(Integer.valueOf(0)) == null ? "E" : (String) b.get(Integer.valueOf(0));
            this.f14210b = b.get(Integer.valueOf(1)) == null ? -1 : ((Long) b.get(Integer.valueOf(1))).longValue();
            this.f14211c = b.get(Integer.valueOf(2)) == null ? "E" : (String) b.get(Integer.valueOf(2));
            this.f14212d = b.get(Integer.valueOf(3)) == null ? "E" : (String) b.get(Integer.valueOf(3));
            this.f14213e = b.get(Integer.valueOf(4)) == null ? "E" : (String) b.get(Integer.valueOf(4));
        }
    }
}
