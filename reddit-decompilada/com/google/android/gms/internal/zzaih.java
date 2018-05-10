package com.google.android.gms.internal;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class zzaih implements OnClickListener {
    private /* synthetic */ int f6404a;
    private /* synthetic */ int f6405b;
    private /* synthetic */ int f6406c;
    private /* synthetic */ zzaig f6407d;

    zzaih(zzaig com_google_android_gms_internal_zzaig, int i, int i2, int i3) {
        this.f6407d = com_google_android_gms_internal_zzaig;
        this.f6404a = i;
        this.f6405b = i2;
        this.f6406c = i3;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (i == this.f6404a) {
            this.f6407d.m5267b();
            return;
        }
        if (i == this.f6405b) {
            if (((Boolean) zzkb.m6350f().m6488a(zznh.cy)).booleanValue()) {
                zzaig.m5268b(this.f6407d);
                return;
            }
        }
        if (i == this.f6406c) {
            if (((Boolean) zzkb.m6350f().m6488a(zznh.cz)).booleanValue()) {
                zzaig.m5269c(this.f6407d);
            }
        }
    }
}
