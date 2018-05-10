package com.google.android.gms.internal;

final class zzagc implements Runnable {
    private /* synthetic */ zzagb f6368a;

    zzagc(zzagb com_google_android_gms_internal_zzagb) {
        this.f6368a = com_google_android_gms_internal_zzagb;
    }

    public final void run() {
        this.f6368a.f14099b = Thread.currentThread();
        this.f6368a.mo3384a();
    }
}
