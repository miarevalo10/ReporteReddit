package com.sendbird.android.shadow.okhttp3.internal.http;

import com.sendbird.android.shadow.okhttp3.Cookie;
import com.sendbird.android.shadow.okhttp3.CookieJar;
import com.sendbird.android.shadow.okhttp3.Interceptor;
import com.sendbird.android.shadow.okhttp3.Interceptor.Chain;
import com.sendbird.android.shadow.okhttp3.MediaType;
import com.sendbird.android.shadow.okhttp3.Request;
import com.sendbird.android.shadow.okhttp3.Request.Builder;
import com.sendbird.android.shadow.okhttp3.RequestBody;
import com.sendbird.android.shadow.okhttp3.Response;
import com.sendbird.android.shadow.okhttp3.internal.Util;
import com.sendbird.android.shadow.okhttp3.internal.Version;
import com.sendbird.android.shadow.okio.GzipSource;
import com.sendbird.android.shadow.okio.Okio;
import com.sendbird.android.shadow.okio.Source;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.io.IOException;
import java.util.List;

public final class BridgeInterceptor implements Interceptor {
    private final CookieJar f30405a;

    public BridgeInterceptor(CookieJar cookieJar) {
        this.f30405a = cookieJar;
    }

    public final Response mo5325a(Chain chain) throws IOException {
        int i;
        Request a = chain.mo5329a();
        Builder newBuilder = a.newBuilder();
        RequestBody body = a.body();
        if (body != null) {
            MediaType a2 = body.mo5211a();
            if (a2 != null) {
                newBuilder.m25317a("Content-Type", a2.toString());
            }
            long b = body.mo5213b();
            if (b != -1) {
                newBuilder.m25317a("Content-Length", Long.toString(b));
                newBuilder.m25319b("Transfer-Encoding");
            } else {
                newBuilder.m25317a("Transfer-Encoding", "chunked");
                newBuilder.m25319b("Content-Length");
            }
        }
        int i2 = 0;
        if (a.header("Host") == null) {
            newBuilder.m25317a("Host", Util.m25358a(a.url(), false));
        }
        if (a.header("Connection") == null) {
            newBuilder.m25317a("Connection", "Keep-Alive");
        }
        if (a.header(HttpRequest.HEADER_ACCEPT_ENCODING) == null && a.header("Range") == null) {
            newBuilder.m25317a(HttpRequest.HEADER_ACCEPT_ENCODING, HttpRequest.ENCODING_GZIP);
            i = 1;
        } else {
            i = 0;
        }
        CookieJar cookieJar = this.f30405a;
        a.url();
        List b2 = cookieJar.mo5300b();
        if (!b2.isEmpty()) {
            String str = "Cookie";
            StringBuilder stringBuilder = new StringBuilder();
            int size = b2.size();
            while (i2 < size) {
                if (i2 > 0) {
                    stringBuilder.append("; ");
                }
                Cookie cookie = (Cookie) b2.get(i2);
                stringBuilder.append(cookie.f23173a);
                stringBuilder.append('=');
                stringBuilder.append(cookie.f23174b);
                i2++;
            }
            newBuilder.m25317a(str, stringBuilder.toString());
        }
        if (a.header("User-Agent") == null) {
            newBuilder.m25317a("User-Agent", Version.m25381a());
        }
        chain = chain.mo5330a(newBuilder.m25318a());
        HttpHeaders.m25430a(this.f30405a, a.url(), chain.f23313f);
        Response.Builder a3 = chain.m25332a();
        a3.f23296a = a;
        if (i != 0 && HttpRequest.ENCODING_GZIP.equalsIgnoreCase(chain.m25333a(HttpRequest.HEADER_CONTENT_ENCODING)) && HttpHeaders.m25435d(chain)) {
            Source gzipSource = new GzipSource(chain.f23314g.mo5298c());
            a3.m25327a(chain.f23313f.m25267a().m25263b(HttpRequest.HEADER_CONTENT_ENCODING).m25263b("Content-Length").m25262a());
            a3.f23302g = new RealResponseBody(chain.m25333a("Content-Type"), -1, Okio.m25615a(gzipSource));
        }
        return a3.m25330a();
    }
}
