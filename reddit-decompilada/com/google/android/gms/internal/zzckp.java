package com.google.android.gms.internal;

import android.os.RemoteException;
import android.text.TextUtils;

final class zzckp implements Runnable {
    private /* synthetic */ boolean f7124a = true;
    private /* synthetic */ boolean f7125b;
    private /* synthetic */ zzcgl f7126c;
    private /* synthetic */ zzcgi f7127d;
    private /* synthetic */ zzcgl f7128e;
    private /* synthetic */ zzckg f7129f;

    zzckp(zzckg com_google_android_gms_internal_zzckg, boolean z, zzcgl com_google_android_gms_internal_zzcgl, zzcgi com_google_android_gms_internal_zzcgi, zzcgl com_google_android_gms_internal_zzcgl2) {
        this.f7129f = com_google_android_gms_internal_zzckg;
        this.f7125b = z;
        this.f7126c = com_google_android_gms_internal_zzcgl;
        this.f7127d = com_google_android_gms_internal_zzcgi;
        this.f7128e = com_google_android_gms_internal_zzcgl2;
    }

    public final void run() {
        zzche e = this.f7129f.f17888c;
        if (e == null) {
            this.f7129f.mo1828t().f17816a.m5693a("Discarding data. Failed to send conditional user property to service");
            return;
        }
        if (this.f7124a) {
            this.f7129f.m18414a(e, this.f7125b ? null : this.f7126c, this.f7127d);
        } else {
            try {
                if (TextUtils.isEmpty(this.f7128e.f17774a)) {
                    e.mo1839a(this.f7126c, this.f7127d);
                } else {
                    e.mo1838a(this.f7126c);
                }
            } catch (RemoteException e2) {
                this.f7129f.mo1828t().f17816a.m5694a("Failed to send conditional user property to the service", e2);
            }
        }
        this.f7129f.m18395E();
    }
}
