package com.google.android.gms.internal;

@zzzv
final class zzamr implements Runnable {
    boolean f6581a = false;
    private zzamd f6582b;

    zzamr(zzamd com_google_android_gms_internal_zzamd) {
        this.f6582b = com_google_android_gms_internal_zzamd;
    }

    final void m5425a() {
        zzahn.f6379a.removeCallbacks(this);
        zzahn.f6379a.postDelayed(this, 250);
    }

    public final void run() {
        if (!this.f6581a) {
            zzamd com_google_android_gms_internal_zzamd = this.f6582b;
            if (com_google_android_gms_internal_zzamd.f14151b != null) {
                long currentPosition = (long) com_google_android_gms_internal_zzamd.f14151b.getCurrentPosition();
                if (com_google_android_gms_internal_zzamd.f14152c != currentPosition && currentPosition > 0) {
                    float f = ((float) currentPosition) / 1000.0f;
                    com_google_android_gms_internal_zzamd.m13357a("timeupdate", "time", String.valueOf(f));
                    com_google_android_gms_internal_zzamd.f14152c = currentPosition;
                }
            }
            m5425a();
        }
    }
}
