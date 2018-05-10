package com.google.android.gms.internal;

final class zzaoc implements Runnable {
    private /* synthetic */ int f6659a;
    private /* synthetic */ int f6660b;
    private /* synthetic */ boolean f6661c;
    private /* synthetic */ boolean f6662d;
    private /* synthetic */ zzaoa f6663e;

    zzaoc(zzaoa com_google_android_gms_internal_zzaoa, int i, int i2, boolean z, boolean z2) {
        this.f6663e = com_google_android_gms_internal_zzaoa;
        this.f6659a = i;
        this.f6660b = i2;
        this.f6661c = z;
        this.f6662d = z2;
    }

    public final void run() {
        synchronized (this.f6663e.f17581b) {
            boolean z = false;
            boolean z2 = this.f6659a != this.f6660b;
            boolean z3 = !this.f6663e.f17590k && this.f6660b == 1;
            boolean z4 = z2 && this.f6660b == 1;
            boolean z5 = z2 && this.f6660b == 2;
            z2 = z2 && this.f6660b == 3;
            boolean z6 = this.f6661c != this.f6662d;
            zzaoa com_google_android_gms_internal_zzaoa = this.f6663e;
            if (this.f6663e.f17590k || z3) {
                z = true;
            }
            com_google_android_gms_internal_zzaoa.f17590k = z;
            if (this.f6663e.f17589j == null) {
                return;
            }
            if (z3) {
                try {
                    this.f6663e.f17589j.mo2050a();
                } catch (Throwable e) {
                    zzakb.m5369c("Unable to call onVideoStart()", e);
                }
            }
            if (z4) {
                try {
                    this.f6663e.f17589j.mo2052b();
                } catch (Throwable e2) {
                    zzakb.m5369c("Unable to call onVideoPlay()", e2);
                }
            }
            if (z5) {
                try {
                    this.f6663e.f17589j.mo2053c();
                } catch (Throwable e22) {
                    zzakb.m5369c("Unable to call onVideoPause()", e22);
                }
            }
            if (z2) {
                try {
                    this.f6663e.f17589j.mo2054d();
                } catch (Throwable e3) {
                    zzakb.m5369c("Unable to call onVideoEnd()", e3);
                }
            }
            if (z6) {
                try {
                    this.f6663e.f17589j.mo2051a(this.f6662d);
                } catch (Throwable e32) {
                    zzakb.m5369c("Unable to call onVideoMute()", e32);
                }
            }
        }
        return;
    }
}
