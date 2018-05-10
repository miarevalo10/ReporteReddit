package com.google.android.gms.internal;

import android.os.Process;
import com.google.android.gms.ads.internal.zzbs;
import java.util.concurrent.Callable;

final class zzahk implements Runnable {
    private /* synthetic */ zzalf f6373a;
    private /* synthetic */ Callable f6374b;

    zzahk(zzalf com_google_android_gms_internal_zzalf, Callable callable) {
        this.f6373a = com_google_android_gms_internal_zzalf;
        this.f6374b = callable;
    }

    public final void run() {
        try {
            Process.setThreadPriority(10);
            this.f6373a.m13330b(this.f6374b.call());
        } catch (Throwable e) {
            zzbs.m4490i().m13246a(e, "AdThreadPool.submit");
            this.f6373a.m13329a(e);
        }
    }
}
