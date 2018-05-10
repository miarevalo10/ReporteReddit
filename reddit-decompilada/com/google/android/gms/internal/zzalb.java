package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

final class zzalb implements Executor {
    private final Handler f6515a = new Handler(Looper.getMainLooper());

    zzalb() {
    }

    public final void execute(Runnable runnable) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            runnable.run();
        } else {
            this.f6515a.post(runnable);
        }
    }
}
