package com.sendbird.android.shadow.okhttp3.internal.http;

import com.sendbird.android.shadow.okhttp3.Address;
import com.sendbird.android.shadow.okhttp3.CertificatePinner;
import com.sendbird.android.shadow.okhttp3.HttpUrl;
import com.sendbird.android.shadow.okhttp3.Interceptor;
import com.sendbird.android.shadow.okhttp3.OkHttpClient;
import com.sendbird.android.shadow.okhttp3.Request;
import com.sendbird.android.shadow.okhttp3.Response;
import com.sendbird.android.shadow.okhttp3.internal.connection.StreamAllocation;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;

public final class RetryAndFollowUpInterceptor implements Interceptor {
    public StreamAllocation f30422a;
    public Object f30423b;
    public volatile boolean f30424c;
    private final OkHttpClient f30425d;
    private final boolean f30426e;

    public RetryAndFollowUpInterceptor(OkHttpClient okHttpClient, boolean z) {
        this.f30425d = okHttpClient;
        this.f30426e = z;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.sendbird.android.shadow.okhttp3.Response mo5325a(com.sendbird.android.shadow.okhttp3.Interceptor.Chain r15) throws java.io.IOException {
        /*
        r14 = this;
        r0 = r15.mo5329a();
        r15 = (com.sendbird.android.shadow.okhttp3.internal.http.RealInterceptorChain) r15;
        r7 = r15.f30411e;
        r8 = r15.f30412f;
        r9 = new com.sendbird.android.shadow.okhttp3.internal.connection.StreamAllocation;
        r1 = r14.f30425d;
        r2 = r1.f23279u;
        r1 = r0.url();
        r3 = r14.m31380a(r1);
        r6 = r14.f30423b;
        r1 = r9;
        r4 = r7;
        r5 = r8;
        r1.<init>(r2, r3, r4, r5, r6);
        r14.f30422a = r9;
        r9 = 0;
        r10 = 0;
        r2 = r9;
        r1 = r10;
    L_0x0026:
        r3 = r14.f30424c;
        if (r3 == 0) goto L_0x0037;
    L_0x002a:
        r15 = r14.f30422a;
        r15.m25414c();
        r15 = new java.io.IOException;
        r0 = "Canceled";
        r15.<init>(r0);
        throw r15;
    L_0x0037:
        r3 = r14.f30422a;	 Catch:{ RouteException -> 0x020e, IOException -> 0x01ff }
        r3 = r15.m31373a(r0, r3, r10, r10);	 Catch:{ RouteException -> 0x020e, IOException -> 0x01ff }
        if (r1 == 0) goto L_0x0060;
    L_0x003f:
        r0 = r3.m25332a();
        r1 = r1.m25332a();
        r1.f23302g = r10;
        r1 = r1.m25330a();
        r3 = r1.f23314g;
        if (r3 == 0) goto L_0x0059;
    L_0x0051:
        r15 = new java.lang.IllegalArgumentException;
        r0 = "priorResponse.body != null";
        r15.<init>(r0);
        throw r15;
    L_0x0059:
        r0.f23305j = r1;
        r0 = r0.m25330a();
        goto L_0x0061;
    L_0x0060:
        r0 = r3;
    L_0x0061:
        if (r0 != 0) goto L_0x0069;
    L_0x0063:
        r15 = new java.lang.IllegalStateException;
        r15.<init>();
        throw r15;
    L_0x0069:
        r1 = r14.f30422a;
        r1 = r1.m25413b();
        if (r1 == 0) goto L_0x0076;
    L_0x0071:
        r1 = r1.mo5326a();
        goto L_0x0077;
    L_0x0076:
        r1 = r10;
    L_0x0077:
        r3 = r0.f23310c;
        r4 = r0.f23308a;
        r4 = r4.method();
        switch(r3) {
            case 300: goto L_0x00e0;
            case 301: goto L_0x00e0;
            case 302: goto L_0x00e0;
            case 303: goto L_0x00e0;
            case 307: goto L_0x00d0;
            case 308: goto L_0x00d0;
            case 401: goto L_0x00c5;
            case 407: goto L_0x00a3;
            case 408: goto L_0x0084;
            default: goto L_0x0082;
        };
    L_0x0082:
        goto L_0x0167;
    L_0x0084:
        r1 = r14.f30425d;
        r1 = r1.f23283y;
        if (r1 == 0) goto L_0x0167;
    L_0x008a:
        r1 = r0.f23308a;
        r1 = r1.body();
        r1 = r1 instanceof com.sendbird.android.shadow.okhttp3.internal.http.UnrepeatableRequestBody;
        if (r1 != 0) goto L_0x0167;
    L_0x0094:
        r1 = r0.f23317j;
        if (r1 == 0) goto L_0x00a0;
    L_0x0098:
        r1 = r0.f23317j;
        r1 = r1.f23310c;
        r3 = 408; // 0x198 float:5.72E-43 double:2.016E-321;
        if (r1 == r3) goto L_0x0167;
    L_0x00a0:
        r1 = r0.f23308a;
        goto L_0x00cd;
    L_0x00a3:
        if (r1 == 0) goto L_0x00a8;
    L_0x00a5:
        r1 = r1.f23322b;
        goto L_0x00ac;
    L_0x00a8:
        r1 = r14.f30425d;
        r1 = r1.f23262d;
    L_0x00ac:
        r1 = r1.type();
        r3 = java.net.Proxy.Type.HTTP;
        if (r1 == r3) goto L_0x00bc;
    L_0x00b4:
        r15 = new java.net.ProtocolException;
        r0 = "Received HTTP_PROXY_AUTH (407) code while not using proxy";
        r15.<init>(r0);
        throw r15;
    L_0x00bc:
        r1 = r14.f30425d;
        r1 = r1.f23277s;
        r1 = r1.mo5287a();
        goto L_0x00cd;
    L_0x00c5:
        r1 = r14.f30425d;
        r1 = r1.f23278t;
        r1 = r1.mo5287a();
    L_0x00cd:
        r11 = r1;
        goto L_0x0168;
    L_0x00d0:
        r1 = "GET";
        r1 = r4.equals(r1);
        if (r1 != 0) goto L_0x00e0;
    L_0x00d8:
        r1 = "HEAD";
        r1 = r4.equals(r1);
        if (r1 == 0) goto L_0x0167;
    L_0x00e0:
        r1 = r14.f30425d;
        r1 = r1.f23282x;
        if (r1 == 0) goto L_0x0167;
    L_0x00e6:
        r1 = "Location";
        r1 = r0.m25333a(r1);
        if (r1 == 0) goto L_0x0167;
    L_0x00ee:
        r3 = r0.f23308a;
        r3 = r3.url();
        r1 = r3.m25294c(r1);
        if (r1 == 0) goto L_0x00ff;
    L_0x00fa:
        r1 = r1.m25279b();
        goto L_0x0100;
    L_0x00ff:
        r1 = r10;
    L_0x0100:
        if (r1 == 0) goto L_0x0167;
    L_0x0102:
        r3 = r1.f23214a;
        r5 = r0.f23308a;
        r5 = r5.url();
        r5 = r5.f23214a;
        r3 = r3.equals(r5);
        if (r3 != 0) goto L_0x0118;
    L_0x0112:
        r3 = r14.f30425d;
        r3 = r3.f23281w;
        if (r3 == 0) goto L_0x0167;
    L_0x0118:
        r3 = r0.f23308a;
        r3 = r3.newBuilder();
        r5 = com.sendbird.android.shadow.okhttp3.internal.http.HttpMethod.m25438c(r4);
        if (r5 == 0) goto L_0x0152;
    L_0x0124:
        r5 = com.sendbird.android.shadow.okhttp3.internal.http.HttpMethod.m25439d(r4);
        r6 = com.sendbird.android.shadow.okhttp3.internal.http.HttpMethod.m25440e(r4);
        if (r6 == 0) goto L_0x0134;
    L_0x012e:
        r4 = "GET";
        r3.m25316a(r4, r10);
        goto L_0x0141;
    L_0x0134:
        if (r5 == 0) goto L_0x013d;
    L_0x0136:
        r6 = r0.f23308a;
        r6 = r6.body();
        goto L_0x013e;
    L_0x013d:
        r6 = r10;
    L_0x013e:
        r3.m25316a(r4, r6);
    L_0x0141:
        if (r5 != 0) goto L_0x0152;
    L_0x0143:
        r4 = "Transfer-Encoding";
        r3.m25319b(r4);
        r4 = "Content-Length";
        r3.m25319b(r4);
        r4 = "Content-Type";
        r3.m25319b(r4);
    L_0x0152:
        r4 = m31381a(r0, r1);
        if (r4 != 0) goto L_0x015d;
    L_0x0158:
        r4 = "Authorization";
        r3.m25319b(r4);
    L_0x015d:
        r1 = r3.m25314a(r1);
        r1 = r1.m25318a();
        goto L_0x00cd;
    L_0x0167:
        r11 = r10;
    L_0x0168:
        if (r11 != 0) goto L_0x0174;
    L_0x016a:
        r15 = r14.f30426e;
        if (r15 != 0) goto L_0x0173;
    L_0x016e:
        r15 = r14.f30422a;
        r15.m25414c();
    L_0x0173:
        return r0;
    L_0x0174:
        r1 = r0.f23314g;
        com.sendbird.android.shadow.okhttp3.internal.Util.m25366a(r1);
        r12 = r2 + 1;
        r1 = 20;
        if (r12 <= r1) goto L_0x0198;
    L_0x017f:
        r15 = r14.f30422a;
        r15.m25414c();
        r15 = new java.net.ProtocolException;
        r0 = new java.lang.StringBuilder;
        r1 = "Too many follow-up requests: ";
        r0.<init>(r1);
        r0.append(r12);
        r0 = r0.toString();
        r15.<init>(r0);
        throw r15;
    L_0x0198:
        r1 = r11.body();
        r1 = r1 instanceof com.sendbird.android.shadow.okhttp3.internal.http.UnrepeatableRequestBody;
        if (r1 == 0) goto L_0x01af;
    L_0x01a0:
        r15 = r14.f30422a;
        r15.m25414c();
        r15 = new java.net.HttpRetryException;
        r1 = "Cannot retry streamed HTTP body";
        r0 = r0.f23310c;
        r15.<init>(r1, r0);
        throw r15;
    L_0x01af:
        r1 = r11.url();
        r1 = m31381a(r0, r1);
        if (r1 != 0) goto L_0x01d7;
    L_0x01b9:
        r1 = r14.f30422a;
        r1.m25414c();
        r13 = new com.sendbird.android.shadow.okhttp3.internal.connection.StreamAllocation;
        r1 = r14.f30425d;
        r2 = r1.f23279u;
        r1 = r11.url();
        r3 = r14.m31380a(r1);
        r6 = r14.f30423b;
        r1 = r13;
        r4 = r7;
        r5 = r8;
        r1.<init>(r2, r3, r4, r5, r6);
        r14.f30422a = r13;
        goto L_0x01f8;
    L_0x01d7:
        r1 = r14.f30422a;
        r1 = r1.m25407a();
        if (r1 == 0) goto L_0x01f8;
    L_0x01df:
        r15 = new java.lang.IllegalStateException;
        r1 = new java.lang.StringBuilder;
        r2 = "Closing the body of ";
        r1.<init>(r2);
        r1.append(r0);
        r0 = " didn't close its backing stream. Bad interceptor?";
        r1.append(r0);
        r0 = r1.toString();
        r15.<init>(r0);
        throw r15;
    L_0x01f8:
        r1 = r0;
        r0 = r11;
        r2 = r12;
        goto L_0x0026;
    L_0x01fd:
        r15 = move-exception;
        goto L_0x021a;
    L_0x01ff:
        r3 = move-exception;
        r4 = r3 instanceof com.sendbird.android.shadow.okhttp3.internal.http2.ConnectionShutdownException;	 Catch:{ all -> 0x01fd }
        if (r4 != 0) goto L_0x0206;
    L_0x0204:
        r4 = 1;
        goto L_0x0207;
    L_0x0206:
        r4 = r9;
    L_0x0207:
        r4 = r14.m31382a(r3, r4, r0);	 Catch:{ all -> 0x01fd }
        if (r4 != 0) goto L_0x0026;
    L_0x020d:
        throw r3;	 Catch:{ all -> 0x01fd }
    L_0x020e:
        r3 = move-exception;
        r4 = r3.f23394a;	 Catch:{ all -> 0x01fd }
        r4 = r14.m31382a(r4, r9, r0);	 Catch:{ all -> 0x01fd }
        if (r4 != 0) goto L_0x0026;
    L_0x0217:
        r15 = r3.f23394a;	 Catch:{ all -> 0x01fd }
        throw r15;	 Catch:{ all -> 0x01fd }
    L_0x021a:
        r0 = r14.f30422a;
        r0.m25411a(r10);
        r0 = r14.f30422a;
        r0.m25414c();
        throw r15;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.okhttp3.internal.http.RetryAndFollowUpInterceptor.a(com.sendbird.android.shadow.okhttp3.Interceptor$Chain):com.sendbird.android.shadow.okhttp3.Response");
    }

    private Address m31380a(HttpUrl httpUrl) {
        HostnameVerifier hostnameVerifier;
        SSLSocketFactory sSLSocketFactory;
        CertificatePinner certificatePinner;
        RetryAndFollowUpInterceptor retryAndFollowUpInterceptor = this;
        HttpUrl httpUrl2 = httpUrl;
        if (httpUrl.m25293b()) {
            SSLSocketFactory sSLSocketFactory2 = retryAndFollowUpInterceptor.f30425d.f23273o;
            hostnameVerifier = retryAndFollowUpInterceptor.f30425d.f23275q;
            sSLSocketFactory = sSLSocketFactory2;
            certificatePinner = retryAndFollowUpInterceptor.f30425d.f23276r;
        } else {
            sSLSocketFactory = null;
            hostnameVerifier = sSLSocketFactory;
            certificatePinner = hostnameVerifier;
        }
        return new Address(httpUrl2.f23215b, httpUrl2.f23216c, retryAndFollowUpInterceptor.f30425d.f23280v, retryAndFollowUpInterceptor.f30425d.f23272n, sSLSocketFactory, hostnameVerifier, certificatePinner, retryAndFollowUpInterceptor.f30425d.f23277s, retryAndFollowUpInterceptor.f30425d.f23262d, retryAndFollowUpInterceptor.f30425d.f23263e, retryAndFollowUpInterceptor.f30425d.f23264f, retryAndFollowUpInterceptor.f30425d.f23268j);
    }

    private boolean m31382a(IOException iOException, boolean z, Request request) {
        this.f30422a.m25411a(iOException);
        if (!this.f30425d.f23283y) {
            return false;
        }
        if (z && (request.body() instanceof UnrepeatableRequestBody) != null) {
            return false;
        }
        if ((iOException instanceof ProtocolException) == null) {
            if ((iOException instanceof InterruptedIOException) != null) {
                if ((iOException instanceof SocketTimeoutException) != null) {
                    if (z) {
                    }
                }
            } else if (!(iOException instanceof SSLHandshakeException) || !(iOException.getCause() instanceof CertificateException)) {
                if ((iOException instanceof SSLPeerUnverifiedException) != null) {
                }
            }
            iOException = 1;
            if (iOException == null) {
                return false;
            }
            iOException = this.f30422a;
            if (!(iOException.f23409c || (iOException.f23408b && iOException.f23408b.m25398a()))) {
                if (iOException.f23413g.m25401a() != null) {
                    iOException = null;
                    if (iOException != null) {
                        return false;
                    }
                    return true;
                }
            }
            iOException = 1;
            if (iOException != null) {
                return true;
            }
            return false;
        }
        iOException = null;
        if (iOException == null) {
            return false;
        }
        iOException = this.f30422a;
        if (iOException.f23413g.m25401a() != null) {
            iOException = null;
            if (iOException != null) {
                return false;
            }
            return true;
        }
        iOException = 1;
        if (iOException != null) {
            return true;
        }
        return false;
    }

    private static boolean m31381a(Response response, HttpUrl httpUrl) {
        response = response.f23308a.url();
        return (response.f23215b.equals(httpUrl.f23215b) && response.f23216c == httpUrl.f23216c && response.f23214a.equals(httpUrl.f23214a) != null) ? true : null;
    }
}
