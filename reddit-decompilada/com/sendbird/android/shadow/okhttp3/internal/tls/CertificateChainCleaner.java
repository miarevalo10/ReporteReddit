package com.sendbird.android.shadow.okhttp3.internal.tls;

import com.sendbird.android.shadow.okhttp3.internal.platform.Platform;
import java.security.cert.Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.X509TrustManager;

public abstract class CertificateChainCleaner {
    public abstract List<Certificate> mo5365a(List<Certificate> list, String str) throws SSLPeerUnverifiedException;

    public static CertificateChainCleaner m25565a(X509TrustManager x509TrustManager) {
        return Platform.m25549b().mo5367a(x509TrustManager);
    }
}
