package com.google.android.gms.internal;

import java.util.HashMap;

public final class zzdk extends zzbt<Integer, Object> {
    public Long f14286a;
    public Boolean f14287b;
    public Boolean f14288c;

    public zzdk(String str) {
        mo1771a(str);
    }

    protected final HashMap<Integer, Object> mo1770a() {
        HashMap<Integer, Object> hashMap = new HashMap();
        hashMap.put(Integer.valueOf(0), this.f14286a);
        hashMap.put(Integer.valueOf(1), this.f14287b);
        hashMap.put(Integer.valueOf(2), this.f14288c);
        return hashMap;
    }

    protected final void mo1771a(String str) {
        HashMap b = zzbt.m5576b(str);
        if (b != null) {
            this.f14286a = (Long) b.get(Integer.valueOf(0));
            this.f14287b = (Boolean) b.get(Integer.valueOf(1));
            this.f14288c = (Boolean) b.get(Integer.valueOf(2));
        }
    }
}
