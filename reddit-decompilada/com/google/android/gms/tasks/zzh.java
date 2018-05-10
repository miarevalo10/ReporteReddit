package com.google.android.gms.tasks;

final class zzh implements Runnable {
    private /* synthetic */ Task f8217a;
    private /* synthetic */ zzg f8218b;

    zzh(zzg com_google_android_gms_tasks_zzg, Task task) {
        this.f8218b = com_google_android_gms_tasks_zzg;
        this.f8217a = task;
    }

    public final void run() {
        synchronized (this.f8218b.f14816b) {
            if (this.f8218b.f14817c != null) {
                OnFailureListener b = this.f8218b.f14817c;
                this.f8217a.mo2313d();
                b.mo3580a();
            }
        }
    }
}
