package com.google.android.gms.common.api.internal;

final class zzch implements Runnable {
    private /* synthetic */ LifecycleCallback f5807a;
    private /* synthetic */ String f5808b;
    private /* synthetic */ zzcg f5809c;

    zzch(zzcg com_google_android_gms_common_api_internal_zzcg, LifecycleCallback lifecycleCallback, String str) {
        this.f5809c = com_google_android_gms_common_api_internal_zzcg;
        this.f5807a = lifecycleCallback;
        this.f5808b = str;
    }

    public final void run() {
        if (this.f5809c.f13941c > 0) {
            this.f5807a.mo1614a(this.f5809c.f13942d != null ? this.f5809c.f13942d.getBundle(this.f5808b) : null);
        }
        if (this.f5809c.f13941c >= 2) {
            this.f5807a.mo1615b();
        }
        if (this.f5809c.f13941c >= 3) {
            this.f5807a.mo3411c();
        }
        if (this.f5809c.f13941c >= 4) {
            this.f5807a.mo1617d();
        }
        this.f5809c.f13941c;
    }
}
