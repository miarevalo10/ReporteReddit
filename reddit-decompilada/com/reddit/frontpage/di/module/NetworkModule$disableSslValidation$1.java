package com.reddit.frontpage.di.module;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Ljavax/net/ssl/SSLSession;", "verify"}, k = 3, mv = {1, 1, 9})
/* compiled from: NetworkModule.kt */
final class NetworkModule$disableSslValidation$1 implements HostnameVerifier {
    public static final NetworkModule$disableSslValidation$1 f20248a = new NetworkModule$disableSslValidation$1();

    NetworkModule$disableSslValidation$1() {
    }

    public final boolean verify(String str, SSLSession sSLSession) {
        return true;
    }
}
