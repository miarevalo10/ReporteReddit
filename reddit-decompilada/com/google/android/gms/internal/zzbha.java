package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

public final class zzbha implements Executor {
    private final Handler f6702a;

    public zzbha(Looper looper) {
        this.f6702a = new Handler(looper);
    }

    public final void execute(Runnable runnable) {
        this.f6702a.post(runnable);
    }
}
