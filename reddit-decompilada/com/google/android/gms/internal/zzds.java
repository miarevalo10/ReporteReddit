package com.google.android.gms.internal;

import java.util.HashMap;

public final class zzds extends zzbt<Integer, Long> {
    public Long f14314a;
    public Long f14315b;
    public Long f14316c;

    public zzds(String str) {
        mo1771a(str);
    }

    protected final HashMap<Integer, Long> mo1770a() {
        HashMap<Integer, Long> hashMap = new HashMap();
        hashMap.put(Integer.valueOf(0), this.f14314a);
        hashMap.put(Integer.valueOf(1), this.f14315b);
        hashMap.put(Integer.valueOf(2), this.f14316c);
        return hashMap;
    }

    protected final void mo1771a(String str) {
        HashMap b = zzbt.m5576b(str);
        if (b != null) {
            this.f14314a = (Long) b.get(Integer.valueOf(0));
            this.f14315b = (Long) b.get(Integer.valueOf(1));
            this.f14316c = (Long) b.get(Integer.valueOf(2));
        }
    }
}
