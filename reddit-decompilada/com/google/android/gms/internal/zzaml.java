package com.google.android.gms.internal;

import android.os.Looper;

final class zzaml implements Runnable {
    zzaml() {
    }

    public final void run() {
        Looper.myLooper().quit();
    }
}
