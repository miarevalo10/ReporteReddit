package com.google.android.gms.internal;

import android.os.RemoteException;
import android.text.TextUtils;

final class zzcko implements Runnable {
    private /* synthetic */ boolean f7118a = true;
    private /* synthetic */ boolean f7119b;
    private /* synthetic */ zzcha f7120c;
    private /* synthetic */ zzcgi f7121d;
    private /* synthetic */ String f7122e;
    private /* synthetic */ zzckg f7123f;

    zzcko(zzckg com_google_android_gms_internal_zzckg, boolean z, zzcha com_google_android_gms_internal_zzcha, zzcgi com_google_android_gms_internal_zzcgi, String str) {
        this.f7123f = com_google_android_gms_internal_zzckg;
        this.f7119b = z;
        this.f7120c = com_google_android_gms_internal_zzcha;
        this.f7121d = com_google_android_gms_internal_zzcgi;
        this.f7122e = str;
    }

    public final void run() {
        zzche e = this.f7123f.f17888c;
        if (e == null) {
            this.f7123f.mo1828t().f17816a.m5693a("Discarding data. Failed to send event to service");
            return;
        }
        if (this.f7118a) {
            this.f7123f.m18414a(e, this.f7119b ? null : this.f7120c, this.f7121d);
        } else {
            try {
                if (TextUtils.isEmpty(this.f7122e)) {
                    e.mo1840a(this.f7120c, this.f7121d);
                } else {
                    e.mo1841a(this.f7120c, this.f7122e, this.f7123f.mo1828t().m18184y());
                }
            } catch (RemoteException e2) {
                this.f7123f.mo1828t().f17816a.m5694a("Failed to send event to the service", e2);
            }
        }
        this.f7123f.m18395E();
    }
}
