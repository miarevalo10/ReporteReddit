package com.google.android.gms.internal;

import android.os.Handler;
import java.util.concurrent.Executor;

final class zzj implements Executor {
    private /* synthetic */ Handler f7737a;

    zzj(Handler handler) {
        this.f7737a = handler;
    }

    public final void execute(Runnable runnable) {
        this.f7737a.post(runnable);
    }
}
