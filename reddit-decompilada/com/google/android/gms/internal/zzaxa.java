package com.google.android.gms.internal;

import com.google.android.gms.auth.api.proxy.ProxyApi.ProxyResult;
import com.google.android.gms.auth.api.proxy.ProxyResponse;
import com.google.android.gms.common.api.Status;

final class zzaxa implements ProxyResult {
    private Status f17615a;
    private ProxyResponse f17616b;

    public zzaxa(ProxyResponse proxyResponse) {
        this.f17616b = proxyResponse;
        this.f17615a = Status.f17263a;
    }

    public zzaxa(Status status) {
        this.f17615a = status;
    }

    public final Status k_() {
        return this.f17615a;
    }
}
