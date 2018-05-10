package com.google.android.gms.internal;

import android.os.Process;

final class zzbhc implements Runnable {
    private final Runnable f6707a;
    private final int f6708b = 0;

    public zzbhc(Runnable runnable) {
        this.f6707a = runnable;
    }

    public final void run() {
        Process.setThreadPriority(this.f6708b);
        this.f6707a.run();
    }
}
