package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.zzbl;
import com.google.android.gms.ads.internal.zzbs;
import com.google.android.gms.ads.internal.zzv;
import java.util.concurrent.Callable;

final class zzanu implements Callable<zzanh> {
    private /* synthetic */ Context f6645a;
    private /* synthetic */ zzapa f6646b;
    private /* synthetic */ String f6647c;
    private /* synthetic */ boolean f6648d;
    private /* synthetic */ boolean f6649e;
    private /* synthetic */ zzcv f6650f;
    private /* synthetic */ zzakd f6651g;
    private /* synthetic */ zznu f6652h;
    private /* synthetic */ zzbl f6653i;
    private /* synthetic */ zzv f6654j;
    private /* synthetic */ zzis f6655k;

    zzanu(Context context, zzapa com_google_android_gms_internal_zzapa, String str, boolean z, boolean z2, zzcv com_google_android_gms_internal_zzcv, zzakd com_google_android_gms_internal_zzakd, zznu com_google_android_gms_internal_zznu, zzbl com_google_android_gms_ads_internal_zzbl, zzv com_google_android_gms_ads_internal_zzv, zzis com_google_android_gms_internal_zzis) {
        this.f6645a = context;
        this.f6646b = com_google_android_gms_internal_zzapa;
        this.f6647c = str;
        this.f6648d = z;
        this.f6649e = z2;
        this.f6650f = com_google_android_gms_internal_zzcv;
        this.f6651g = com_google_android_gms_internal_zzakd;
        this.f6652h = com_google_android_gms_internal_zznu;
        this.f6653i = com_google_android_gms_ads_internal_zzbl;
        this.f6654j = com_google_android_gms_ads_internal_zzv;
        this.f6655k = com_google_android_gms_internal_zzis;
    }

    public final /* synthetic */ Object call() throws Exception {
        zzanh com_google_android_gms_internal_zzanw = new zzanw(zzanx.m20306a(this.f6645a, this.f6646b, this.f6647c, this.f6648d, this.f6650f, this.f6651g, this.f6652h, this.f6653i, this.f6654j, this.f6655k));
        com_google_android_gms_internal_zzanw.setWebViewClient(zzbs.m4488g().mo3436a(com_google_android_gms_internal_zzanw, this.f6649e));
        com_google_android_gms_internal_zzanw.setWebChromeClient(zzbs.m4488g().mo3441c(com_google_android_gms_internal_zzanw));
        return com_google_android_gms_internal_zzanw;
    }
}
