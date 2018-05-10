package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.internal.zzbg;
import java.util.Arrays;

public final class zzh<O extends ApiOptions> {
    public final Api<O> f5839a;
    private final boolean f5840b = true;
    private final int f5841c;
    private final O f5842d;

    private zzh(Api<O> api) {
        this.f5839a = api;
        this.f5842d = null;
        this.f5841c = System.identityHashCode(this);
    }

    private zzh(Api<O> api, O o) {
        this.f5839a = api;
        this.f5842d = o;
        this.f5841c = Arrays.hashCode(new Object[]{this.f5839a, this.f5842d});
    }

    public static <O extends ApiOptions> zzh<O> m4766a(Api<O> api) {
        return new zzh(api);
    }

    public static <O extends ApiOptions> zzh<O> m4767a(Api<O> api, O o) {
        return new zzh(api, o);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzh)) {
            return false;
        }
        zzh com_google_android_gms_common_api_internal_zzh = (zzh) obj;
        return !this.f5840b && !com_google_android_gms_common_api_internal_zzh.f5840b && zzbg.m4806a(this.f5839a, com_google_android_gms_common_api_internal_zzh.f5839a) && zzbg.m4806a(this.f5842d, com_google_android_gms_common_api_internal_zzh.f5842d);
    }

    public final int hashCode() {
        return this.f5841c;
    }
}
