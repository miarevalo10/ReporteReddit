package com.google.firebase.iid;

import android.content.BroadcastReceiver.PendingResult;
import android.content.Intent;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

final class zzd {
    final Intent f8632a;
    private final PendingResult f8633b;
    private boolean f8634c = false;
    private final ScheduledFuture<?> f8635d;

    zzd(Intent intent, PendingResult pendingResult, ScheduledExecutorService scheduledExecutorService) {
        this.f8632a = intent;
        this.f8633b = pendingResult;
        this.f8635d = scheduledExecutorService.schedule(new zze(this, intent), 9500, TimeUnit.MILLISECONDS);
    }

    final synchronized void m7379a() {
        if (!this.f8634c) {
            this.f8633b.finish();
            this.f8635d.cancel(false);
            this.f8634c = true;
        }
    }
}
