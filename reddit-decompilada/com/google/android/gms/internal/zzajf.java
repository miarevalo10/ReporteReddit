package com.google.android.gms.internal;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.google.android.gms.common.internal.zzbq;

@zzzv
public final class zzajf {
    Handler f6443a = null;
    private HandlerThread f6444b = null;
    private int f6445c = 0;
    private final Object f6446d = new Object();

    public final Looper m5300a() {
        Looper looper;
        synchronized (this.f6446d) {
            if (this.f6445c != 0) {
                zzbq.m4809a(this.f6444b, (Object) "Invalid state: mHandlerThread should already been initialized.");
            } else if (this.f6444b == null) {
                zzagf.m13278a("Starting the looper thread.");
                this.f6444b = new HandlerThread("LooperProvider");
                this.f6444b.start();
                this.f6443a = new Handler(this.f6444b.getLooper());
                zzagf.m13278a("Looper thread started.");
            } else {
                zzagf.m13278a("Resuming the looper thread");
                this.f6446d.notifyAll();
            }
            this.f6445c++;
            looper = this.f6444b.getLooper();
        }
        return looper;
    }
}
