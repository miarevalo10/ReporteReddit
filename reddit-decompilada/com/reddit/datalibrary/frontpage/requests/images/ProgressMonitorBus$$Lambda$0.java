package com.reddit.datalibrary.frontpage.requests.images;

import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.Response;

final /* synthetic */ class ProgressMonitorBus$$Lambda$0 implements Interceptor {
    static final Interceptor f16346a = new ProgressMonitorBus$$Lambda$0();

    private ProgressMonitorBus$$Lambda$0() {
    }

    public final Response intercept(Chain chain) {
        return ProgressMonitorBus.m9344a(chain);
    }
}
