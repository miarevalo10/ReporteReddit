package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.zzbl;
import com.google.android.gms.ads.internal.zzv;

@zzzv
public final class zzanr {
    public static zzakv<zzanh> m5463a(Context context, zzakd com_google_android_gms_internal_zzakd, String str, zzcv com_google_android_gms_internal_zzcv, zzv com_google_android_gms_ads_internal_zzv) {
        return zzakl.m5379a(zzakl.m5377a(null), new zzans(context, com_google_android_gms_internal_zzcv, com_google_android_gms_internal_zzakd, com_google_android_gms_ads_internal_zzv, str), zzala.f6511a);
    }

    public static zzanh m5464a(Context context, zzapa com_google_android_gms_internal_zzapa, String str, boolean z, boolean z2, zzcv com_google_android_gms_internal_zzcv, zzakd com_google_android_gms_internal_zzakd, zznu com_google_android_gms_internal_zznu, zzbl com_google_android_gms_ads_internal_zzbl, zzv com_google_android_gms_ads_internal_zzv, zzis com_google_android_gms_internal_zzis) throws zzanv {
        try {
            return (zzanh) zzajk.m5303a(new zzanu(context, com_google_android_gms_internal_zzapa, str, z, z2, com_google_android_gms_internal_zzcv, com_google_android_gms_internal_zzakd, com_google_android_gms_internal_zznu, com_google_android_gms_ads_internal_zzbl, com_google_android_gms_ads_internal_zzv, com_google_android_gms_internal_zzis));
        } catch (Throwable th) {
            zzanv com_google_android_gms_internal_zzanv = new zzanv("Webview initialization failed.", th);
        }
    }
}
