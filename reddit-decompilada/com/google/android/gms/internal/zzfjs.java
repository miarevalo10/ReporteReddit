package com.google.android.gms.internal;

import java.io.IOException;

public abstract class zzfjs {
    protected volatile int f7556Y = -1;

    public static final <T extends zzfjs> T m6203a(T t, byte[] bArr) throws zzfjr {
        return m6204a(t, bArr, bArr.length);
    }

    static <T extends zzfjs> T m6204a(T t, byte[] bArr, int i) throws zzfjr {
        try {
            zzfjj a = zzfjj.m6130a(bArr, i);
            t.mo3478a(a);
            a.m6135a(0);
            return t;
        } catch (zzfjr e) {
            throw e;
        } catch (Throwable e2) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).", e2);
        }
    }

    public static final byte[] m6205a(zzfjs com_google_android_gms_internal_zzfjs) {
        byte[] bArr = new byte[com_google_android_gms_internal_zzfjs.m6211e()];
        try {
            zzfjk a = zzfjk.m6158a(bArr, bArr.length);
            com_google_android_gms_internal_zzfjs.mo1928a(a);
            a.m6171a();
            return bArr;
        } catch (Throwable e) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e);
        }
    }

    protected int mo1927a() {
        return 0;
    }

    public abstract zzfjs mo3478a(zzfjj com_google_android_gms_internal_zzfjj) throws IOException;

    public void mo1928a(zzfjk com_google_android_gms_internal_zzfjk) throws IOException {
    }

    public zzfjs mo1929c() throws CloneNotSupportedException {
        return (zzfjs) super.clone();
    }

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return mo1929c();
    }

    public final int m6210d() {
        if (this.f7556Y < 0) {
            m6211e();
        }
        return this.f7556Y;
    }

    public final int m6211e() {
        int a = mo1927a();
        this.f7556Y = a;
        return a;
    }

    public String toString() {
        return zzfjt.m6212a(this);
    }
}
