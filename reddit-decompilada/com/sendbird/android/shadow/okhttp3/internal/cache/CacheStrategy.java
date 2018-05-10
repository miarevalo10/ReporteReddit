package com.sendbird.android.shadow.okhttp3.internal.cache;

import com.sendbird.android.shadow.okhttp3.Request;
import com.sendbird.android.shadow.okhttp3.Response;
import com.sendbird.android.shadow.okhttp3.internal.http.HttpDate;
import com.sendbird.android.shadow.okhttp3.internal.http.HttpHeaders;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.util.Date;

public final class CacheStrategy {
    public final Request f23364a;
    public final Response f23365b;

    public static class Factory {
        final long f23352a;
        final Request f23353b;
        final Response f23354c;
        Date f23355d;
        String f23356e;
        Date f23357f;
        String f23358g;
        Date f23359h;
        long f23360i;
        long f23361j;
        String f23362k;
        int f23363l = -1;

        public Factory(long j, Request request, Response response) {
            this.f23352a = j;
            this.f23353b = request;
            this.f23354c = response;
            if (response != null) {
                this.f23360i = response.f23318k;
                this.f23361j = response.f23319l;
                j = response.f23313f;
                request = j.f23197a.length / 2;
                for (int i = 0; i < request; i++) {
                    response = j.m25268a(i);
                    String b = j.m25270b(i);
                    if (HttpRequest.HEADER_DATE.equalsIgnoreCase(response)) {
                        this.f23355d = HttpDate.m25424a(b);
                        this.f23356e = b;
                    } else if (HttpRequest.HEADER_EXPIRES.equalsIgnoreCase(response)) {
                        this.f23359h = HttpDate.m25424a(b);
                    } else if (HttpRequest.HEADER_LAST_MODIFIED.equalsIgnoreCase(response)) {
                        this.f23357f = HttpDate.m25424a(b);
                        this.f23358g = b;
                    } else if (HttpRequest.HEADER_ETAG.equalsIgnoreCase(response)) {
                        this.f23362k = b;
                    } else if ("Age".equalsIgnoreCase(response) != null) {
                        this.f23363l = HttpHeaders.m25432b(b, -1);
                    }
                }
            }
        }

        static boolean m25382a(Request request) {
            if (request.header("If-Modified-Since") == null) {
                if (request.header(HttpRequest.HEADER_IF_NONE_MATCH) == null) {
                    return null;
                }
            }
            return true;
        }
    }

    CacheStrategy(Request request, Response response) {
        this.f23364a = request;
        this.f23365b = response;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean m25383a(com.sendbird.android.shadow.okhttp3.Response r3, com.sendbird.android.shadow.okhttp3.Request r4) {
        /*
        r0 = r3.f23310c;
        r1 = 0;
        switch(r0) {
            case 200: goto L_0x0029;
            case 203: goto L_0x0029;
            case 204: goto L_0x0029;
            case 300: goto L_0x0029;
            case 301: goto L_0x0029;
            case 302: goto L_0x0007;
            case 307: goto L_0x0007;
            case 308: goto L_0x0029;
            case 404: goto L_0x0029;
            case 405: goto L_0x0029;
            case 410: goto L_0x0029;
            case 414: goto L_0x0029;
            case 501: goto L_0x0029;
            default: goto L_0x0006;
        };
    L_0x0006:
        goto L_0x003c;
    L_0x0007:
        r0 = "Expires";
        r0 = r3.m25333a(r0);
        if (r0 != 0) goto L_0x0029;
    L_0x000f:
        r0 = r3.m25334b();
        r0 = r0.f23077e;
        r2 = -1;
        if (r0 != r2) goto L_0x0029;
    L_0x0018:
        r0 = r3.m25334b();
        r0 = r0.f23079g;
        if (r0 != 0) goto L_0x0029;
    L_0x0020:
        r0 = r3.m25334b();
        r0 = r0.f23078f;
        if (r0 != 0) goto L_0x0029;
    L_0x0028:
        goto L_0x003c;
    L_0x0029:
        r3 = r3.m25334b();
        r3 = r3.f23076d;
        if (r3 != 0) goto L_0x003b;
    L_0x0031:
        r3 = r4.cacheControl();
        r3 = r3.f23076d;
        if (r3 != 0) goto L_0x003b;
    L_0x0039:
        r3 = 1;
        return r3;
    L_0x003b:
        return r1;
    L_0x003c:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.okhttp3.internal.cache.CacheStrategy.a(com.sendbird.android.shadow.okhttp3.Response, com.sendbird.android.shadow.okhttp3.Request):boolean");
    }
}
