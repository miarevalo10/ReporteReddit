package com.google.android.gms.tasks;

final class zzj implements Runnable {
    private /* synthetic */ Task f8219a;
    private /* synthetic */ zzi f8220b;

    zzj(zzi com_google_android_gms_tasks_zzi, Task task) {
        this.f8220b = com_google_android_gms_tasks_zzi;
        this.f8219a = task;
    }

    public final void run() {
        synchronized (this.f8220b.f14819b) {
            if (this.f8220b.f14820c != null) {
                OnSuccessListener b = this.f8220b.f14820c;
                this.f8219a.mo2312c();
                b.mo3581b();
            }
        }
    }
}
