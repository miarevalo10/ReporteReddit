package com.google.android.gms.ads.internal;

import android.content.Context;
import android.view.View;
import com.google.android.gms.internal.zzafo;
import com.google.android.gms.internal.zzanh;
import com.google.android.gms.internal.zzano;
import com.google.android.gms.internal.zzgp;

final class zzal implements zzano {
    private /* synthetic */ zzafo f13767a;
    private /* synthetic */ zzak f13768b;

    zzal(zzak com_google_android_gms_ads_internal_zzak, zzafo com_google_android_gms_internal_zzafo) {
        this.f13768b = com_google_android_gms_ads_internal_zzak;
        this.f13767a = com_google_android_gms_internal_zzafo;
    }

    public final void mo1515a() {
        Context context = this.f13768b.e.f5600c;
        zzanh com_google_android_gms_internal_zzanh = this.f13767a.f6289b;
        if (com_google_android_gms_internal_zzanh == null) {
            throw null;
        }
        new zzgp(context, (View) com_google_android_gms_internal_zzanh).m6265a(this.f13767a.f6289b);
    }
}
