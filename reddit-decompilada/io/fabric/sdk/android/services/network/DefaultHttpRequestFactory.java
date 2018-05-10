package io.fabric.sdk.android.services.network;

import io.fabric.sdk.android.DefaultLogger;
import io.fabric.sdk.android.Logger;
import java.util.Collections;
import java.util.Locale;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

public class DefaultHttpRequestFactory implements HttpRequestFactory {
    private final Logger f31019a;
    private PinningInfoProvider f31020b;
    private SSLSocketFactory f31021c;
    private boolean f31022d;

    public DefaultHttpRequestFactory() {
        this(new DefaultLogger((byte) 0));
    }

    public DefaultHttpRequestFactory(Logger logger) {
        this.f31019a = logger;
    }

    public final void mo5601a(PinningInfoProvider pinningInfoProvider) {
        if (this.f31020b != pinningInfoProvider) {
            this.f31020b = pinningInfoProvider;
            m31978a();
        }
    }

    private synchronized void m31978a() {
        this.f31022d = false;
        this.f31021c = null;
    }

    public final HttpRequest mo5599a(HttpMethod httpMethod, String str) {
        return mo5600a(httpMethod, str, Collections.emptyMap());
    }

    public final HttpRequest mo5600a(HttpMethod httpMethod, String str, Map<String, String> map) {
        boolean z = true;
        switch (httpMethod) {
            case GET:
                httpMethod = HttpRequest.get((CharSequence) str, (Map) map, true);
                break;
            case POST:
                httpMethod = HttpRequest.post((CharSequence) str, (Map) map, true);
                break;
            case PUT:
                httpMethod = HttpRequest.put((CharSequence) str);
                break;
            case DELETE:
                httpMethod = HttpRequest.delete((CharSequence) str);
                break;
            default:
                throw new IllegalArgumentException("Unsupported HTTP method!");
        }
        if (str == null || str.toLowerCase(Locale.US).startsWith("https") == null) {
            z = false;
        }
        if (z && this.f31020b != null) {
            str = m31979b();
            if (str != null) {
                ((HttpsURLConnection) httpMethod.getConnection()).setSSLSocketFactory(str);
            }
        }
        return httpMethod;
    }

    private synchronized SSLSocketFactory m31979b() {
        if (this.f31021c == null && !this.f31022d) {
            this.f31021c = m31980c();
        }
        return this.f31021c;
    }

    private synchronized SSLSocketFactory m31980c() {
        SSLSocketFactory a;
        this.f31022d = true;
        try {
            a = NetworkUtils.m26413a(this.f31020b);
            this.f31019a.mo5562a("Fabric", "Custom SSL pinning enabled");
        } catch (Throwable e) {
            this.f31019a.mo5568c("Fabric", "Exception while validating pinned certs", e);
            return null;
        }
        return a;
    }
}
