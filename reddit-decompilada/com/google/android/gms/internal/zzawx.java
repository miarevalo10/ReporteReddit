package com.google.android.gms.internal;

import com.google.android.gms.auth.api.proxy.ProxyApi;
import com.google.android.gms.auth.api.proxy.ProxyApi.ProxyResult;
import com.google.android.gms.auth.api.proxy.ProxyRequest;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.internal.zzbq;

public final class zzawx implements ProxyApi {
    public final PendingResult<ProxyResult> performProxyRequest(GoogleApiClient googleApiClient, ProxyRequest proxyRequest) {
        zzbq.m4808a((Object) googleApiClient);
        zzbq.m4808a((Object) proxyRequest);
        return googleApiClient.mo1597b(new zzawy(googleApiClient, proxyRequest));
    }
}
