package com.google.android.gms.common.api;

import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.common.api.internal.zzco;
import com.google.android.gms.common.internal.zzbq;

public final class PendingResults {

    static final class zzc<R extends Result> extends BasePendingResult<R> {
        public zzc(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        protected final R mo3409a(Status status) {
            throw new UnsupportedOperationException("Creating failed results is not supported");
        }
    }

    public static <R extends Result> OptionalPendingResult<R> m4674a(R r, GoogleApiClient googleApiClient) {
        zzbq.m4809a((Object) r, (Object) "Result must not be null");
        PendingResult com_google_android_gms_common_api_PendingResults_zzc = new zzc(googleApiClient);
        com_google_android_gms_common_api_PendingResults_zzc.m12826a((Result) r);
        return new zzco(com_google_android_gms_common_api_PendingResults_zzc);
    }
}
