package com.google.android.gms.internal;

final class zzcks implements Runnable {
    private /* synthetic */ boolean f7143a;
    private /* synthetic */ zzcln f7144b;
    private /* synthetic */ zzcgi f7145c;
    private /* synthetic */ zzckg f7146d;

    zzcks(zzckg com_google_android_gms_internal_zzckg, boolean z, zzcln com_google_android_gms_internal_zzcln, zzcgi com_google_android_gms_internal_zzcgi) {
        this.f7146d = com_google_android_gms_internal_zzckg;
        this.f7143a = z;
        this.f7144b = com_google_android_gms_internal_zzcln;
        this.f7145c = com_google_android_gms_internal_zzcgi;
    }

    public final void run() {
        zzche e = this.f7146d.f17888c;
        if (e == null) {
            this.f7146d.mo1828t().f17816a.m5693a("Discarding data. Failed to set user attribute");
            return;
        }
        this.f7146d.m18414a(e, this.f7143a ? null : this.f7144b, this.f7145c);
        this.f7146d.m18395E();
    }
}
