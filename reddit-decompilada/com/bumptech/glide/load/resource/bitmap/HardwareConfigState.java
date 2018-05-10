package com.bumptech.glide.load.resource.bitmap;

import android.util.Log;
import java.io.File;

final class HardwareConfigState {
    private static final File f3539a = new File("/proc/self/fd");
    private static volatile HardwareConfigState f3540d;
    private volatile int f3541b;
    private volatile boolean f3542c = true;

    static HardwareConfigState m3044a() {
        if (f3540d == null) {
            synchronized (HardwareConfigState.class) {
                if (f3540d == null) {
                    f3540d = new HardwareConfigState();
                }
            }
        }
        return f3540d;
    }

    private HardwareConfigState() {
    }

    final synchronized boolean m3045b() {
        int i = this.f3541b + 1;
        this.f3541b = i;
        if (i >= 50) {
            boolean z = false;
            this.f3541b = 0;
            int length = f3539a.list().length;
            if (length < 700) {
                z = true;
            }
            this.f3542c = z;
            if (!this.f3542c && Log.isLoggable("Downsampler", 5)) {
                StringBuilder stringBuilder = new StringBuilder("Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors ");
                stringBuilder.append(length);
                stringBuilder.append(", limit 700");
                Log.w("Downsampler", stringBuilder.toString());
            }
        }
        return this.f3542c;
    }
}
