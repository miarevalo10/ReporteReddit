package com.reddit.frontpage.di.module;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

final /* synthetic */ class OkHttpModule$$Lambda$0 implements HostnameVerifier {
    static final HostnameVerifier f20249a = new OkHttpModule$$Lambda$0();

    private OkHttpModule$$Lambda$0() {
    }

    public final boolean verify(String str, SSLSession sSLSession) {
        return true;
    }
}
