package com.google.android.gms.internal;

import com.reddit.datalibrary.frontpage.job.RedditJobManager;
import java.io.IOException;

public abstract class zzffb {
    private static volatile boolean f7385e = true;
    int f7386a;
    int f7387b;
    int f7388c;
    private boolean f7389d;

    private zzffb() {
        this.f7387b = 100;
        this.f7388c = RedditJobManager.f10810d;
        this.f7389d = false;
    }

    public static zzffb m5963a(byte[] bArr) {
        return m5964a(bArr, 0, bArr.length, false);
    }

    static zzffb m5964a(byte[] bArr, int i, int i2, boolean z) {
        zzffb com_google_android_gms_internal_zzffd = new zzffd(bArr, i, i2, z, (byte) 0);
        try {
            com_google_android_gms_internal_zzffd.mo1881b(i2);
            return com_google_android_gms_internal_zzffd;
        } catch (Throwable e) {
            throw new IllegalArgumentException(e);
        }
    }

    public abstract int mo1878a() throws IOException;

    public abstract <T extends zzffu<T, ?>> T mo1879a(T t, zzffm com_google_android_gms_internal_zzffm) throws IOException;

    public abstract void mo1880a(int i) throws zzfge;

    public abstract int mo1881b(int i) throws zzfge;

    public abstract long mo1882b() throws IOException;

    public abstract long mo1883c() throws IOException;

    public abstract void mo1884c(int i);

    public abstract int mo1885d() throws IOException;

    public abstract boolean mo1886e() throws IOException;

    public abstract String mo1887f() throws IOException;

    public abstract zzfes mo1888g() throws IOException;

    public abstract int mo1889h() throws IOException;

    public abstract int mo1890i() throws IOException;

    public abstract int mo1891j() throws IOException;

    abstract long mo1892k() throws IOException;

    public abstract boolean mo1893l() throws IOException;

    public abstract int mo1894m();
}
