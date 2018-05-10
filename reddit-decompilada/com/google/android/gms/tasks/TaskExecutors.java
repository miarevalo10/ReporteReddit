package com.google.android.gms.tasks;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

public final class TaskExecutors {
    public static final Executor f8213a = new zza();
    static final Executor f8214b = new zzm();

    static final class zza implements Executor {
        private final Handler f8212a = new Handler(Looper.getMainLooper());

        public final void execute(Runnable runnable) {
            this.f8212a.post(runnable);
        }
    }
}
