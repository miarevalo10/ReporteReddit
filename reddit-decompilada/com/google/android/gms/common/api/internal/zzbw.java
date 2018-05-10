package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.Result;

public final class zzbw<O extends ApiOptions> extends zzak {
    private final GoogleApi<O> f17303a;

    public zzbw(GoogleApi<O> googleApi) {
        super("Method is not supported by connectionless client. APIs supporting connectionless client must not call this method.");
        this.f17303a = googleApi;
    }

    public final <A extends zzb, R extends Result, T extends zzm<R, A>> T mo1588a(T t) {
        return this.f17303a.zza((zzm) t);
    }

    public final void mo1593a(zzdg com_google_android_gms_common_api_internal_zzdg) {
    }

    public final Context mo1596b() {
        return this.f17303a.getApplicationContext();
    }

    public final <A extends zzb, T extends zzm<? extends Result, A>> T mo1597b(T t) {
        return this.f17303a.zzb((zzm) t);
    }

    public final void mo1598b(zzdg com_google_android_gms_common_api_internal_zzdg) {
    }

    public final Looper mo1599c() {
        return this.f17303a.getLooper();
    }
}
