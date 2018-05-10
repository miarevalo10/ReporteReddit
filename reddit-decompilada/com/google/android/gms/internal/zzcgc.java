package com.google.android.gms.internal;

import android.os.Looper;
import com.google.android.gms.common.internal.zzbq;

public final class zzcgc {
    public static Looper m5617a() {
        zzbq.m4814a(Looper.myLooper() != null, (Object) "Can't create handler inside thread that has not called Looper.prepare()");
        return Looper.myLooper();
    }

    public static Looper m5618a(Looper looper) {
        return looper != null ? looper : m5617a();
    }
}
