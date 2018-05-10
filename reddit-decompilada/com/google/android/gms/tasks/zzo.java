package com.google.android.gms.tasks;

import java.util.concurrent.Callable;

final class zzo implements Runnable {
    private /* synthetic */ zzn f8224a;
    private /* synthetic */ Callable f8225b;

    zzo(zzn com_google_android_gms_tasks_zzn, Callable callable) {
        this.f8224a = com_google_android_gms_tasks_zzn;
        this.f8225b = callable;
    }

    public final void run() {
        try {
            this.f8224a.m14528a(this.f8225b.call());
        } catch (Exception e) {
            this.f8224a.m14527a(e);
        }
    }
}
