package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.internal.zzr;
import com.google.android.gms.internal.zzcxd;
import com.google.android.gms.internal.zzcxe;

public final class zzz<O extends ApiOptions> extends GoogleApi<O> {
    private final zze f13989a;
    private final zzt f13990b;
    private final zzr f13991c;
    private final zza<? extends zzcxd, zzcxe> f13992d;

    public zzz(Context context, Api<O> api, Looper looper, zze com_google_android_gms_common_api_Api_zze, zzt com_google_android_gms_common_api_internal_zzt, zzr com_google_android_gms_common_internal_zzr, zza<? extends zzcxd, zzcxe> com_google_android_gms_common_api_Api_zza__extends_com_google_android_gms_internal_zzcxd__com_google_android_gms_internal_zzcxe) {
        super(context, api, looper);
        this.f13989a = com_google_android_gms_common_api_Api_zze;
        this.f13990b = com_google_android_gms_common_api_internal_zzt;
        this.f13991c = com_google_android_gms_common_internal_zzr;
        this.f13992d = com_google_android_gms_common_api_Api_zza__extends_com_google_android_gms_internal_zzcxd__com_google_android_gms_internal_zzcxe;
        this.zzfmi.m4727a((GoogleApi) this);
    }

    public final zzcv zza(Context context, Handler handler) {
        return new zzcv(context, handler, this.f13991c, this.f13992d);
    }

    public final zze zza(Looper looper, zzbo<O> com_google_android_gms_common_api_internal_zzbo_O) {
        this.f13990b.f13971b = com_google_android_gms_common_api_internal_zzbo_O;
        return this.f13989a;
    }
}
