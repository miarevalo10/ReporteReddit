package com.google.android.gms.internal;

import java.util.Iterator;
import java.util.Map.Entry;

final class zzfhj<T> implements zzfhv<T> {
    private final zzfhe f14449a;
    private final zzfin<?, ?> f14450b;
    private final boolean f14451c;
    private final zzffn<?> f14452d;

    private zzfhj(Class<T> cls, zzfin<?, ?> com_google_android_gms_internal_zzfin___, zzffn<?> com_google_android_gms_internal_zzffn_, zzfhe com_google_android_gms_internal_zzfhe) {
        this.f14450b = com_google_android_gms_internal_zzfin___;
        this.f14451c = com_google_android_gms_internal_zzffn_.mo1898a((Class) cls);
        this.f14452d = com_google_android_gms_internal_zzffn_;
        this.f14449a = com_google_android_gms_internal_zzfhe;
    }

    static <T> zzfhj<T> m13873a(Class<T> cls, zzfin<?, ?> com_google_android_gms_internal_zzfin___, zzffn<?> com_google_android_gms_internal_zzffn_, zzfhe com_google_android_gms_internal_zzfhe) {
        return new zzfhj(cls, com_google_android_gms_internal_zzfin___, com_google_android_gms_internal_zzffn_, com_google_android_gms_internal_zzfhe);
    }

    public final void mo1912a(T t, zzfji com_google_android_gms_internal_zzfji) {
        Iterator b = this.f14452d.mo1897a((Object) t).m5997b();
        while (b.hasNext()) {
            Entry entry = (Entry) b.next();
            zzffs com_google_android_gms_internal_zzffs = (zzffs) entry.getKey();
            if (com_google_android_gms_internal_zzffs.m6000c() == zzfjd.MESSAGE && !com_google_android_gms_internal_zzffs.m6001d()) {
                if (!com_google_android_gms_internal_zzffs.m6002e()) {
                    int a;
                    Object c;
                    if (entry instanceof zzfgi) {
                        a = com_google_android_gms_internal_zzffs.m5998a();
                        c = ((zzfgg) ((zzfgi) entry).f7423a.getValue()).m6030c();
                    } else {
                        a = com_google_android_gms_internal_zzffs.m5998a();
                        c = entry.getValue();
                    }
                    com_google_android_gms_internal_zzfji.mo1896a(a, c);
                }
            }
            throw new IllegalStateException("Found invalid MessageSet item.");
        }
        zzfin com_google_android_gms_internal_zzfin = this.f14450b;
        com_google_android_gms_internal_zzfin.mo1921a(com_google_android_gms_internal_zzfin.mo1920a(t), com_google_android_gms_internal_zzfji);
    }

    public final int mo1911a(T t) {
        zzfin com_google_android_gms_internal_zzfin = this.f14450b;
        int i = 0;
        int b = com_google_android_gms_internal_zzfin.mo1922b(com_google_android_gms_internal_zzfin.mo1920a(t)) + 0;
        if (!this.f14451c) {
            return b;
        }
        t = this.f14452d.mo1897a((Object) t);
        int i2 = 0;
        while (i < t.f7398a.m6071b()) {
            i2 += zzffq.m5992a(t.f7398a.m6072b(i));
            i++;
        }
        for (Entry a : t.f7398a.m6073c()) {
            i2 += zzffq.m5992a(a);
        }
        return b + i2;
    }
}
