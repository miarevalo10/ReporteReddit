package com.google.android.gms.internal;

import android.os.Handler;
import com.google.android.gms.common.internal.zzbq;

abstract class zzcgs {
    private static volatile Handler f6829b;
    private final zzcim f6830a;
    private final Runnable f6831c = new zzcgt(this);
    private volatile long f6832d;
    private boolean f6833e = true;

    zzcgs(zzcim com_google_android_gms_internal_zzcim) {
        zzbq.m4808a((Object) com_google_android_gms_internal_zzcim);
        this.f6830a = com_google_android_gms_internal_zzcim;
    }

    public abstract void mo1850a();

    public final boolean m5665b() {
        return this.f6832d != 0;
    }

    public final void m5666c() {
        this.f6832d = 0;
        m5662d().removeCallbacks(this.f6831c);
    }

    public final void m5664a(long j) {
        m5666c();
        if (j >= 0) {
            this.f6832d = this.f6830a.f6982i.mo1632a();
            if (!m5662d().postDelayed(this.f6831c, j)) {
                this.f6830a.m5754e().f17816a.m5694a("Failed to schedule delayed post. time", Long.valueOf(j));
            }
        }
    }

    private final Handler m5662d() {
        if (f6829b != null) {
            return f6829b;
        }
        Handler handler;
        synchronized (zzcgs.class) {
            if (f6829b == null) {
                f6829b = new Handler(this.f6830a.f6974a.getMainLooper());
            }
            handler = f6829b;
        }
        return handler;
    }
}
