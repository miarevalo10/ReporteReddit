package com.google.android.gms.internal;

import java.util.HashMap;

public final class zzdl extends zzbt<Integer, Long> {
    public Long f14289a;
    public Long f14290b;

    public zzdl(String str) {
        mo1771a(str);
    }

    protected final HashMap<Integer, Long> mo1770a() {
        HashMap<Integer, Long> hashMap = new HashMap();
        hashMap.put(Integer.valueOf(0), this.f14289a);
        hashMap.put(Integer.valueOf(1), this.f14290b);
        return hashMap;
    }

    protected final void mo1771a(String str) {
        HashMap b = zzbt.m5576b(str);
        if (b != null) {
            this.f14289a = (Long) b.get(Integer.valueOf(0));
            this.f14290b = (Long) b.get(Integer.valueOf(1));
        }
    }
}
