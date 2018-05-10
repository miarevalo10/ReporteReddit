package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzbq;
import java.util.List;
import java.util.Map;

final class zzcht implements Runnable {
    private final zzchs f6904a;
    private final int f6905b;
    private final Throwable f6906c;
    private final byte[] f6907d;
    private final String f6908e;
    private final Map<String, List<String>> f6909f;

    private zzcht(String str, zzchs com_google_android_gms_internal_zzchs, int i, Throwable th, byte[] bArr, Map<String, List<String>> map) {
        zzbq.m4808a((Object) com_google_android_gms_internal_zzchs);
        this.f6904a = com_google_android_gms_internal_zzchs;
        this.f6905b = i;
        this.f6906c = th;
        this.f6907d = bArr;
        this.f6908e = str;
        this.f6909f = map;
    }

    public final void run() {
        this.f6904a.mo1849a(this.f6908e, this.f6905b, this.f6906c, this.f6907d, this.f6909f);
    }
}
