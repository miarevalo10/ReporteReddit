package com.google.android.gms.common.api.internal;

final class zzdc implements Runnable {
    private /* synthetic */ LifecycleCallback f5827a;
    private /* synthetic */ String f5828b;
    private /* synthetic */ zzdb f5829c;

    zzdc(zzdb com_google_android_gms_common_api_internal_zzdb, LifecycleCallback lifecycleCallback, String str) {
        this.f5829c = com_google_android_gms_common_api_internal_zzdb;
        this.f5827a = lifecycleCallback;
        this.f5828b = str;
    }

    public final void run() {
        if (this.f5829c.f17309c > 0) {
            this.f5827a.mo1614a(this.f5829c.f17310d != null ? this.f5829c.f17310d.getBundle(this.f5828b) : null);
        }
        if (this.f5829c.f17309c >= 2) {
            this.f5827a.mo1615b();
        }
        if (this.f5829c.f17309c >= 3) {
            this.f5827a.mo3411c();
        }
        if (this.f5829c.f17309c >= 4) {
            this.f5827a.mo1617d();
        }
        this.f5829c.f17309c;
    }
}
