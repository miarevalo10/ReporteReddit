package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.zzbs;
import com.google.android.gms.ads.internal.zzv;

final /* synthetic */ class zzans implements zzakg {
    private final Context f14201a;
    private final zzcv f14202b;
    private final zzakd f14203c;
    private final zzv f14204d;
    private final String f14205e;

    zzans(Context context, zzcv com_google_android_gms_internal_zzcv, zzakd com_google_android_gms_internal_zzakd, zzv com_google_android_gms_ads_internal_zzv, String str) {
        this.f14201a = context;
        this.f14202b = com_google_android_gms_internal_zzcv;
        this.f14203c = com_google_android_gms_internal_zzakd;
        this.f14204d = com_google_android_gms_ads_internal_zzv;
        this.f14205e = str;
    }

    public final zzakv mo1516a(Object obj) {
        Context context = this.f14201a;
        zzcv com_google_android_gms_internal_zzcv = this.f14202b;
        zzakd com_google_android_gms_internal_zzakd = this.f14203c;
        zzv com_google_android_gms_ads_internal_zzv = this.f14204d;
        obj = this.f14205e;
        zzbs.m4487f();
        zzanh a = zzanr.m5464a(context, zzapa.m5484a(), "", false, false, com_google_android_gms_internal_zzcv, com_google_android_gms_internal_zzakd, null, null, com_google_android_gms_ads_internal_zzv, zzis.m6322a());
        zzakv a2 = zzale.m17802a(a);
        a.mo4019w().f6617d = new zzant(a2);
        a.loadUrl(obj);
        return a2;
    }
}
