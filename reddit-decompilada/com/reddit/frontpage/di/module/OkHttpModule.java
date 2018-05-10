package com.reddit.frontpage.di.module;

import com.jakewharton.byteunits.DecimalByteUnit;
import com.reddit.datalibrary.frontpage.data.feature.settings.InternalSettings;
import com.reddit.datalibrary.frontpage.redditauth.redditclient.WebSocketClient;
import com.reddit.datalibrary.frontpage.requests.api.v1.OkHttpStack;
import com.reddit.datalibrary.frontpage.requests.images.AdCookieExtractor;
import com.reddit.datalibrary.frontpage.requests.images.ProgressMonitorBus;
import com.reddit.frontpage.FrontpageApplication;
import java.io.File;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;
import javax.inject.Named;
import javax.inject.Singleton;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import timber.log.Timber;

public class OkHttpModule {
    private static final File f20251a = FrontpageApplication.f27402a.getCacheDir();
    private static final long f20252b = DecimalByteUnit.c.a(100);

    class C17841 implements X509TrustManager {
        final /* synthetic */ OkHttpModule f20250a;

        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        }

        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        }

        C17841(OkHttpModule okHttpModule) {
            this.f20250a = okHttpModule;
        }

        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }

    @Singleton
    @Named("no_redirects")
    static OkHttpStack m22355a(@Named("no_redirects") OkHttpClient okHttpClient) {
        return new OkHttpStack(okHttpClient);
    }

    @Singleton
    @Named("no_body_logging")
    static OkHttpStack m22356b(@Named("no_body_logging") OkHttpClient okHttpClient) {
        return new OkHttpStack(okHttpClient);
    }

    @Singleton
    static WebSocketClient m22358c(@Named("web_socket") OkHttpClient okHttpClient) {
        return new WebSocketClient(okHttpClient);
    }

    final Builder m22359a() {
        Builder builder = new Builder();
        if (f20251a != null) {
            builder.cache(new Cache(new File(f20251a, "reddit"), f20252b));
        } else {
            Timber.d("Not using cache: directory was null", new Object[0]);
        }
        builder.addNetworkInterceptor(ProgressMonitorBus.b());
        if (InternalSettings.a().e() == null) {
            builder.addNetworkInterceptor(new AdCookieExtractor());
        }
        builder.connectTimeout(7500, TimeUnit.MILLISECONDS);
        builder.readTimeout(7500, TimeUnit.MILLISECONDS);
        builder.writeTimeout(7500, TimeUnit.MILLISECONDS);
        builder.retryOnConnectionFailure(false);
        if ("release".equals("stage") || "release".equals("dev")) {
            TrustManager[] trustManagerArr = new TrustManager[]{new C17841(this)};
            try {
                SSLContext instance = SSLContext.getInstance("SSL");
                instance.init(null, trustManagerArr, new SecureRandom());
                builder.sslSocketFactory(instance.getSocketFactory());
                builder.hostnameVerifier(OkHttpModule$$Lambda$0.f20249a);
            } catch (Throwable e) {
                Timber.c(e, "Failed to accept all SSL certificates", new Object[0]);
            }
        }
        return builder;
    }
}
