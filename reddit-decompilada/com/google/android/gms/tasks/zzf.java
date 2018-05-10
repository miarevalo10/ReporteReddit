package com.google.android.gms.tasks;

final class zzf implements Runnable {
    private /* synthetic */ Task f8215a;
    private /* synthetic */ zze f8216b;

    zzf(zze com_google_android_gms_tasks_zze, Task task) {
        this.f8216b = com_google_android_gms_tasks_zze;
        this.f8215a = task;
    }

    public final void run() {
        synchronized (this.f8216b.f14813b) {
            if (this.f8216b.f14814c != null) {
                this.f8216b.f14814c.mo1558a(this.f8215a);
            }
        }
    }
}
