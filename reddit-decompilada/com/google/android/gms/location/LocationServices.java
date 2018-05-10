package com.google.android.gms.location;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zzf;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.zzm;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzceb;
import com.google.android.gms.internal.zzceq;
import com.google.android.gms.internal.zzcfk;
import com.google.android.gms.internal.zzcfv;

public class LocationServices {
    public static final Api<Object> f8202a = new Api("LocationServices.API", f8207f, f8206e);
    @Deprecated
    public static final FusedLocationProviderApi f8203b = new zzceb();
    @Deprecated
    public static final GeofencingApi f8204c = new zzceq();
    @Deprecated
    public static final SettingsApi f8205d = new zzcfv();
    private static final zzf<zzcfk> f8206e = new zzf();
    private static final com.google.android.gms.common.api.Api.zza<zzcfk, Object> f8207f = new zzy();

    public static abstract class zza<R extends Result> extends zzm<R, zzcfk> {
        public zza(GoogleApiClient googleApiClient) {
            super(LocationServices.f8202a, googleApiClient);
        }

        public final /* bridge */ /* synthetic */ void mo3421a(Object obj) {
            super.m12826a((Result) obj);
        }
    }

    public static zzcfk m6840a(GoogleApiClient googleApiClient) {
        boolean z = false;
        zzbq.m4818b(googleApiClient != null, "GoogleApiClient parameter is required.");
        zzcfk com_google_android_gms_internal_zzcfk = (zzcfk) googleApiClient.mo1587a(f8206e);
        if (com_google_android_gms_internal_zzcfk != null) {
            z = true;
        }
        zzbq.m4814a(z, (Object) "GoogleApiClient is not configured to use the LocationServices.API Api. Pass thisinto GoogleApiClient.Builder#addApi() to use this feature.");
        return com_google_android_gms_internal_zzcfk;
    }
}
