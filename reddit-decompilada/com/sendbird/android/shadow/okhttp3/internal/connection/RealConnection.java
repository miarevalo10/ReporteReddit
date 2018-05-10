package com.sendbird.android.shadow.okhttp3.internal.connection;

import com.sendbird.android.shadow.okhttp3.Address;
import com.sendbird.android.shadow.okhttp3.CertificatePinner;
import com.sendbird.android.shadow.okhttp3.Connection;
import com.sendbird.android.shadow.okhttp3.ConnectionPool;
import com.sendbird.android.shadow.okhttp3.ConnectionSpec;
import com.sendbird.android.shadow.okhttp3.EventListener;
import com.sendbird.android.shadow.okhttp3.Handshake;
import com.sendbird.android.shadow.okhttp3.HttpUrl;
import com.sendbird.android.shadow.okhttp3.Protocol;
import com.sendbird.android.shadow.okhttp3.Route;
import com.sendbird.android.shadow.okhttp3.internal.Internal;
import com.sendbird.android.shadow.okhttp3.internal.Util;
import com.sendbird.android.shadow.okhttp3.internal.http2.ErrorCode;
import com.sendbird.android.shadow.okhttp3.internal.http2.Http2Connection;
import com.sendbird.android.shadow.okhttp3.internal.http2.Http2Connection.Listener;
import com.sendbird.android.shadow.okhttp3.internal.http2.Http2Stream;
import com.sendbird.android.shadow.okhttp3.internal.platform.Platform;
import com.sendbird.android.shadow.okhttp3.internal.tls.OkHostnameVerifier;
import com.sendbird.android.shadow.okhttp3.internal.ws.RealWebSocket.Streams;
import com.sendbird.android.shadow.okio.BufferedSink;
import com.sendbird.android.shadow.okio.BufferedSource;
import com.sendbird.android.shadow.okio.Okio;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.Socket;
import java.net.UnknownServiceException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;

public final class RealConnection extends Listener implements Connection {
    public final Route f30391a;
    public Socket f30392b;
    public Socket f30393c;
    public Handshake f30394d;
    Http2Connection f30395e;
    public BufferedSource f30396f;
    public BufferedSink f30397g;
    public boolean f30398h;
    public int f30399i;
    public int f30400j = 1;
    public final List<Reference<StreamAllocation>> f30401k = new ArrayList();
    public long f30402l = Long.MAX_VALUE;
    private final ConnectionPool f30403n;
    private Protocol f30404o;

    class C24721 extends Streams {
        final /* synthetic */ StreamAllocation f30389a;
        final /* synthetic */ RealConnection f30390b;

        public C24721(RealConnection realConnection, BufferedSource bufferedSource, BufferedSink bufferedSink, StreamAllocation streamAllocation) {
            this.f30390b = realConnection;
            this.f30389a = streamAllocation;
            super(bufferedSource, bufferedSink);
        }

        public void close() throws IOException {
            this.f30389a.m25412a(true, this.f30389a.m25407a(), null);
        }
    }

    public RealConnection(ConnectionPool connectionPool, Route route) {
        this.f30403n = connectionPool;
        this.f30391a = route;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m31362a(int r18, int r19, int r20, boolean r21) {
        /*
        r17 = this;
        r1 = r17;
        r2 = r1.f30404o;
        if (r2 == 0) goto L_0x000e;
    L_0x0006:
        r2 = new java.lang.IllegalStateException;
        r3 = "already connected";
        r2.<init>(r3);
        throw r2;
    L_0x000e:
        r2 = r1.f30391a;
        r2 = r2.f23321a;
        r2 = r2.f23042f;
        r3 = new com.sendbird.android.shadow.okhttp3.internal.connection.ConnectionSpecSelector;
        r3.<init>(r2);
        r4 = r1.f30391a;
        r4 = r4.f23321a;
        r4 = r4.f23045i;
        if (r4 != 0) goto L_0x0066;
    L_0x0021:
        r4 = com.sendbird.android.shadow.okhttp3.ConnectionSpec.f23163c;
        r2 = r2.contains(r4);
        if (r2 != 0) goto L_0x0036;
    L_0x0029:
        r2 = new com.sendbird.android.shadow.okhttp3.internal.connection.RouteException;
        r3 = new java.net.UnknownServiceException;
        r4 = "CLEARTEXT communication not enabled for client";
        r3.<init>(r4);
        r2.<init>(r3);
        throw r2;
    L_0x0036:
        r2 = r1.f30391a;
        r2 = r2.f23321a;
        r2 = r2.f23037a;
        r2 = r2.f23215b;
        r4 = com.sendbird.android.shadow.okhttp3.internal.platform.Platform.m25549b();
        r4 = r4.mo5375b(r2);
        if (r4 != 0) goto L_0x0066;
    L_0x0048:
        r3 = new com.sendbird.android.shadow.okhttp3.internal.connection.RouteException;
        r4 = new java.net.UnknownServiceException;
        r5 = new java.lang.StringBuilder;
        r6 = "CLEARTEXT communication to ";
        r5.<init>(r6);
        r5.append(r2);
        r2 = " not permitted by network security policy";
        r5.append(r2);
        r2 = r5.toString();
        r4.<init>(r2);
        r3.<init>(r4);
        throw r3;
    L_0x0066:
        r2 = 0;
        r4 = r2;
    L_0x0068:
        r5 = 0;
        r6 = 1;
        r7 = r1.f30391a;	 Catch:{ IOException -> 0x0222 }
        r7 = r7.m25340a();	 Catch:{ IOException -> 0x0222 }
        if (r7 == 0) goto L_0x0174;
    L_0x0072:
        r7 = new com.sendbird.android.shadow.okhttp3.Request$Builder;	 Catch:{ IOException -> 0x0222 }
        r7.<init>();	 Catch:{ IOException -> 0x0222 }
        r8 = r1.f30391a;	 Catch:{ IOException -> 0x0222 }
        r8 = r8.f23321a;	 Catch:{ IOException -> 0x0222 }
        r8 = r8.f23037a;	 Catch:{ IOException -> 0x0222 }
        r7 = r7.m25314a(r8);	 Catch:{ IOException -> 0x0222 }
        r8 = "Host";
        r9 = r1.f30391a;	 Catch:{ IOException -> 0x0222 }
        r9 = r9.f23321a;	 Catch:{ IOException -> 0x0222 }
        r9 = r9.f23037a;	 Catch:{ IOException -> 0x0222 }
        r9 = com.sendbird.android.shadow.okhttp3.internal.Util.m25358a(r9, r6);	 Catch:{ IOException -> 0x0222 }
        r7 = r7.m25317a(r8, r9);	 Catch:{ IOException -> 0x0222 }
        r8 = "Proxy-Connection";
        r9 = "Keep-Alive";
        r7 = r7.m25317a(r8, r9);	 Catch:{ IOException -> 0x0222 }
        r8 = "User-Agent";
        r9 = com.sendbird.android.shadow.okhttp3.internal.Version.m25381a();	 Catch:{ IOException -> 0x0222 }
        r7 = r7.m25317a(r8, r9);	 Catch:{ IOException -> 0x0222 }
        r7 = r7.m25318a();	 Catch:{ IOException -> 0x0222 }
        r8 = r7.url();	 Catch:{ IOException -> 0x0222 }
        r17.m31359a(r18, r19);	 Catch:{ IOException -> 0x0222 }
        r9 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0222 }
        r10 = "CONNECT ";
        r9.<init>(r10);	 Catch:{ IOException -> 0x0222 }
        r8 = com.sendbird.android.shadow.okhttp3.internal.Util.m25358a(r8, r6);	 Catch:{ IOException -> 0x0222 }
        r9.append(r8);	 Catch:{ IOException -> 0x0222 }
        r8 = " HTTP/1.1";
        r9.append(r8);	 Catch:{ IOException -> 0x0222 }
        r8 = r9.toString();	 Catch:{ IOException -> 0x0222 }
        r9 = new com.sendbird.android.shadow.okhttp3.internal.http1.Http1Codec;	 Catch:{ IOException -> 0x0222 }
        r10 = r1.f30396f;	 Catch:{ IOException -> 0x0222 }
        r11 = r1.f30397g;	 Catch:{ IOException -> 0x0222 }
        r9.<init>(r2, r2, r10, r11);	 Catch:{ IOException -> 0x0222 }
        r10 = r1.f30396f;	 Catch:{ IOException -> 0x0222 }
        r10 = r10.mo5323a();	 Catch:{ IOException -> 0x0222 }
        r11 = r19;
        r12 = (long) r11;
        r14 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ IOException -> 0x0171 }
        r10.mo5385a(r12, r14);	 Catch:{ IOException -> 0x0171 }
        r10 = r1.f30397g;	 Catch:{ IOException -> 0x0171 }
        r10 = r10.mo5334a();	 Catch:{ IOException -> 0x0171 }
        r12 = r20;
        r13 = (long) r12;
        r15 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ IOException -> 0x0220 }
        r10.mo5385a(r13, r15);	 Catch:{ IOException -> 0x0220 }
        r10 = r7.headers();	 Catch:{ IOException -> 0x0220 }
        r9.m31396a(r10, r8);	 Catch:{ IOException -> 0x0220 }
        r9.mo5343b();	 Catch:{ IOException -> 0x0220 }
        r8 = r9.mo5338a(r5);	 Catch:{ IOException -> 0x0220 }
        r8.f23296a = r7;	 Catch:{ IOException -> 0x0220 }
        r7 = r8.m25330a();	 Catch:{ IOException -> 0x0220 }
        r13 = com.sendbird.android.shadow.okhttp3.internal.http.HttpHeaders.m25427a(r7);	 Catch:{ IOException -> 0x0220 }
        r15 = -1;
        r8 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1));
        if (r8 != 0) goto L_0x010a;
    L_0x0108:
        r13 = 0;
    L_0x010a:
        r8 = r9.m31394a(r13);	 Catch:{ IOException -> 0x0220 }
        r9 = 2147483647; // 0x7fffffff float:NaN double:1.060997895E-314;
        r10 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ IOException -> 0x0220 }
        com.sendbird.android.shadow.okhttp3.internal.Util.m25368a(r8, r9, r10);	 Catch:{ IOException -> 0x0220 }
        r8.close();	 Catch:{ IOException -> 0x0220 }
        r8 = r7.f23310c;	 Catch:{ IOException -> 0x0220 }
        r9 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r8 == r9) goto L_0x014a;
    L_0x011f:
        r9 = 407; // 0x197 float:5.7E-43 double:2.01E-321;
        if (r8 == r9) goto L_0x0139;
    L_0x0123:
        r8 = new java.io.IOException;	 Catch:{ IOException -> 0x0220 }
        r9 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0220 }
        r10 = "Unexpected response code for CONNECT: ";
        r9.<init>(r10);	 Catch:{ IOException -> 0x0220 }
        r7 = r7.f23310c;	 Catch:{ IOException -> 0x0220 }
        r9.append(r7);	 Catch:{ IOException -> 0x0220 }
        r7 = r9.toString();	 Catch:{ IOException -> 0x0220 }
        r8.<init>(r7);	 Catch:{ IOException -> 0x0220 }
        throw r8;	 Catch:{ IOException -> 0x0220 }
    L_0x0139:
        r7 = r1.f30391a;	 Catch:{ IOException -> 0x0220 }
        r7 = r7.f23321a;	 Catch:{ IOException -> 0x0220 }
        r7 = r7.f23040d;	 Catch:{ IOException -> 0x0220 }
        r7.mo5287a();	 Catch:{ IOException -> 0x0220 }
        r7 = new java.io.IOException;	 Catch:{ IOException -> 0x0220 }
        r8 = "Failed to authenticate with proxy";
        r7.<init>(r8);	 Catch:{ IOException -> 0x0220 }
        throw r7;	 Catch:{ IOException -> 0x0220 }
    L_0x014a:
        r7 = r1.f30396f;	 Catch:{ IOException -> 0x0220 }
        r7 = r7.mo6552b();	 Catch:{ IOException -> 0x0220 }
        r7 = r7.mo6562d();	 Catch:{ IOException -> 0x0220 }
        if (r7 == 0) goto L_0x0169;
    L_0x0156:
        r7 = r1.f30397g;	 Catch:{ IOException -> 0x0220 }
        r7 = r7.mo6552b();	 Catch:{ IOException -> 0x0220 }
        r7 = r7.mo6562d();	 Catch:{ IOException -> 0x0220 }
        if (r7 != 0) goto L_0x0163;
    L_0x0162:
        goto L_0x0169;
    L_0x0163:
        r7 = r1.f30392b;	 Catch:{ IOException -> 0x0220 }
        if (r7 != 0) goto L_0x017b;
    L_0x0167:
        goto L_0x01f1;
    L_0x0169:
        r7 = new java.io.IOException;	 Catch:{ IOException -> 0x0220 }
        r8 = "TLS tunnel buffered too many bytes!";
        r7.<init>(r8);	 Catch:{ IOException -> 0x0220 }
        throw r7;	 Catch:{ IOException -> 0x0220 }
    L_0x0171:
        r0 = move-exception;
        goto L_0x0225;
    L_0x0174:
        r11 = r19;
        r12 = r20;
        r17.m31359a(r18, r19);	 Catch:{ IOException -> 0x0220 }
    L_0x017b:
        r7 = r1.f30391a;	 Catch:{ IOException -> 0x0220 }
        r7 = r7.f23321a;	 Catch:{ IOException -> 0x0220 }
        r7 = r7.f23045i;	 Catch:{ IOException -> 0x0220 }
        if (r7 != 0) goto L_0x018c;
    L_0x0183:
        r7 = com.sendbird.android.shadow.okhttp3.Protocol.HTTP_1_1;	 Catch:{ IOException -> 0x0220 }
        r1.f30404o = r7;	 Catch:{ IOException -> 0x0220 }
        r7 = r1.f30392b;	 Catch:{ IOException -> 0x0220 }
        r1.f30393c = r7;	 Catch:{ IOException -> 0x0220 }
        goto L_0x01ee;
    L_0x018c:
        com.sendbird.android.shadow.okhttp3.EventListener.m25241e();	 Catch:{ IOException -> 0x0220 }
        r1.m31360a(r3);	 Catch:{ IOException -> 0x0220 }
        com.sendbird.android.shadow.okhttp3.EventListener.m25242f();	 Catch:{ IOException -> 0x0220 }
        r7 = r1.f30404o;	 Catch:{ IOException -> 0x0220 }
        r8 = com.sendbird.android.shadow.okhttp3.Protocol.HTTP_2;	 Catch:{ IOException -> 0x0220 }
        if (r7 != r8) goto L_0x01ee;
    L_0x019b:
        r7 = r1.f30393c;	 Catch:{ IOException -> 0x0220 }
        r7.setSoTimeout(r5);	 Catch:{ IOException -> 0x0220 }
        r7 = new com.sendbird.android.shadow.okhttp3.internal.http2.Http2Connection$Builder;	 Catch:{ IOException -> 0x0220 }
        r7.<init>();	 Catch:{ IOException -> 0x0220 }
        r8 = r1.f30393c;	 Catch:{ IOException -> 0x0220 }
        r9 = r1.f30391a;	 Catch:{ IOException -> 0x0220 }
        r9 = r9.f23321a;	 Catch:{ IOException -> 0x0220 }
        r9 = r9.f23037a;	 Catch:{ IOException -> 0x0220 }
        r9 = r9.f23215b;	 Catch:{ IOException -> 0x0220 }
        r10 = r1.f30396f;	 Catch:{ IOException -> 0x0220 }
        r13 = r1.f30397g;	 Catch:{ IOException -> 0x0220 }
        r7.f23469a = r8;	 Catch:{ IOException -> 0x0220 }
        r7.f23470b = r9;	 Catch:{ IOException -> 0x0220 }
        r7.f23471c = r10;	 Catch:{ IOException -> 0x0220 }
        r7.f23472d = r13;	 Catch:{ IOException -> 0x0220 }
        r7.f23473e = r1;	 Catch:{ IOException -> 0x0220 }
        r8 = new com.sendbird.android.shadow.okhttp3.internal.http2.Http2Connection;	 Catch:{ IOException -> 0x0220 }
        r8.<init>(r7);	 Catch:{ IOException -> 0x0220 }
        r1.f30395e = r8;	 Catch:{ IOException -> 0x0220 }
        r7 = r1.f30395e;	 Catch:{ IOException -> 0x0220 }
        r8 = r7.f23494q;	 Catch:{ IOException -> 0x0220 }
        r8.m25508a();	 Catch:{ IOException -> 0x0220 }
        r8 = r7.f23494q;	 Catch:{ IOException -> 0x0220 }
        r9 = r7.f23490m;	 Catch:{ IOException -> 0x0220 }
        r8.m25517b(r9);	 Catch:{ IOException -> 0x0220 }
        r8 = r7.f23490m;	 Catch:{ IOException -> 0x0220 }
        r8 = r8.m25529b();	 Catch:{ IOException -> 0x0220 }
        r9 = 65535; // 0xffff float:9.1834E-41 double:3.23786E-319;
        if (r8 == r9) goto L_0x01e4;
    L_0x01dd:
        r10 = r7.f23494q;	 Catch:{ IOException -> 0x0220 }
        r8 = r8 - r9;
        r8 = (long) r8;	 Catch:{ IOException -> 0x0220 }
        r10.m25509a(r5, r8);	 Catch:{ IOException -> 0x0220 }
    L_0x01e4:
        r8 = new java.lang.Thread;	 Catch:{ IOException -> 0x0220 }
        r7 = r7.f23495r;	 Catch:{ IOException -> 0x0220 }
        r8.<init>(r7);	 Catch:{ IOException -> 0x0220 }
        r8.start();	 Catch:{ IOException -> 0x0220 }
    L_0x01ee:
        com.sendbird.android.shadow.okhttp3.EventListener.m25243g();	 Catch:{ IOException -> 0x0220 }
    L_0x01f1:
        r2 = r1.f30391a;
        r2 = r2.m25340a();
        if (r2 == 0) goto L_0x020a;
    L_0x01f9:
        r2 = r1.f30392b;
        if (r2 != 0) goto L_0x020a;
    L_0x01fd:
        r2 = new java.net.ProtocolException;
        r3 = "Too many tunnel connections attempted: 21";
        r2.<init>(r3);
        r3 = new com.sendbird.android.shadow.okhttp3.internal.connection.RouteException;
        r3.<init>(r2);
        throw r3;
    L_0x020a:
        r2 = r1.f30395e;
        if (r2 == 0) goto L_0x021f;
    L_0x020e:
        r2 = r1.f30403n;
        monitor-enter(r2);
        r3 = r1.f30395e;	 Catch:{ all -> 0x021b }
        r3 = r3.m25469a();	 Catch:{ all -> 0x021b }
        r1.f30400j = r3;	 Catch:{ all -> 0x021b }
        monitor-exit(r2);	 Catch:{ all -> 0x021b }
        return;
    L_0x021b:
        r0 = move-exception;
        r3 = r0;
        monitor-exit(r2);	 Catch:{ all -> 0x021b }
        throw r3;
    L_0x021f:
        return;
    L_0x0220:
        r0 = move-exception;
        goto L_0x0227;
    L_0x0222:
        r0 = move-exception;
        r11 = r19;
    L_0x0225:
        r12 = r20;
    L_0x0227:
        r7 = r0;
        r8 = r1.f30393c;
        com.sendbird.android.shadow.okhttp3.internal.Util.m25367a(r8);
        r8 = r1.f30392b;
        com.sendbird.android.shadow.okhttp3.internal.Util.m25367a(r8);
        r1.f30393c = r2;
        r1.f30392b = r2;
        r1.f30396f = r2;
        r1.f30397g = r2;
        r1.f30394d = r2;
        r1.f30404o = r2;
        r1.f30395e = r2;
        com.sendbird.android.shadow.okhttp3.EventListener.m25244h();
        if (r4 != 0) goto L_0x024c;
    L_0x0245:
        r4 = new com.sendbird.android.shadow.okhttp3.internal.connection.RouteException;
        r4.<init>(r7);
    L_0x024a:
        r8 = r4;
        goto L_0x0254;
    L_0x024c:
        r8 = r4.f23394a;
        com.sendbird.android.shadow.okhttp3.internal.connection.RouteException.m25397a(r7, r8);
        r4.f23394a = r7;
        goto L_0x024a;
    L_0x0254:
        if (r21 == 0) goto L_0x0281;
    L_0x0256:
        r3.f23391d = r6;
        r9 = r3.f23390c;
        if (r9 == 0) goto L_0x027b;
    L_0x025c:
        r9 = r7 instanceof java.net.ProtocolException;
        if (r9 != 0) goto L_0x027b;
    L_0x0260:
        r9 = r7 instanceof java.io.InterruptedIOException;
        if (r9 != 0) goto L_0x027b;
    L_0x0264:
        r9 = r7 instanceof javax.net.ssl.SSLHandshakeException;
        if (r9 == 0) goto L_0x0270;
    L_0x0268:
        r10 = r7.getCause();
        r10 = r10 instanceof java.security.cert.CertificateException;
        if (r10 != 0) goto L_0x027b;
    L_0x0270:
        r10 = r7 instanceof javax.net.ssl.SSLPeerUnverifiedException;
        if (r10 != 0) goto L_0x027b;
    L_0x0274:
        if (r9 != 0) goto L_0x027a;
    L_0x0276:
        r7 = r7 instanceof javax.net.ssl.SSLProtocolException;
        if (r7 == 0) goto L_0x027b;
    L_0x027a:
        r5 = r6;
    L_0x027b:
        if (r5 != 0) goto L_0x027e;
    L_0x027d:
        goto L_0x0281;
    L_0x027e:
        r4 = r8;
        goto L_0x0068;
    L_0x0281:
        throw r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.okhttp3.internal.connection.RealConnection.a(int, int, int, boolean):void");
    }

    private void m31359a(int i, int i2) throws IOException {
        Socket socket;
        Proxy proxy = this.f30391a.f23322b;
        Address address = this.f30391a.f23321a;
        if (proxy.type() != Type.DIRECT) {
            if (proxy.type() != Type.HTTP) {
                socket = new Socket(proxy);
                this.f30392b = socket;
                EventListener.m25240d();
                this.f30392b.setSoTimeout(i2);
                Platform.m25549b().mo5372a(this.f30392b, this.f30391a.f23323c, i);
                this.f30396f = Okio.m25615a(Okio.m25625b(this.f30392b));
                this.f30397g = Okio.m25614a(Okio.m25619a(this.f30392b));
            }
        }
        socket = address.f23039c.createSocket();
        this.f30392b = socket;
        EventListener.m25240d();
        this.f30392b.setSoTimeout(i2);
        try {
            Platform.m25549b().mo5372a(this.f30392b, this.f30391a.f23323c, i);
            try {
                this.f30396f = Okio.m25615a(Okio.m25625b(this.f30392b));
                this.f30397g = Okio.m25614a(Okio.m25619a(this.f30392b));
            } catch (int i3) {
                if ("throw with null exception".equals(i3.getMessage()) != 0) {
                    throw new IOException(i3);
                }
            }
        } catch (int i32) {
            StringBuilder stringBuilder = new StringBuilder("Failed to connect to ");
            stringBuilder.append(this.f30391a.f23323c);
            i2 = new ConnectException(stringBuilder.toString());
            i2.initCause(i32);
            throw i2;
        }
    }

    private void m31360a(ConnectionSpecSelector connectionSpecSelector) throws IOException {
        AssertionError e;
        Address address = this.f30391a.f23321a;
        String str = null;
        try {
            Socket socket = (SSLSocket) address.f23045i.createSocket(this.f30392b, address.f23037a.f23215b, address.f23037a.f23216c, true);
            try {
                ConnectionSpec connectionSpec;
                int size = connectionSpecSelector.f23388a.size();
                for (int i = connectionSpecSelector.f23389b; i < size; i++) {
                    connectionSpec = (ConnectionSpec) connectionSpecSelector.f23388a.get(i);
                    if (connectionSpec.m25220a(socket)) {
                        connectionSpecSelector.f23389b = i + 1;
                        break;
                    }
                }
                connectionSpec = null;
                if (connectionSpec == null) {
                    StringBuilder stringBuilder = new StringBuilder("Unable to find acceptable protocols. isFallback=");
                    stringBuilder.append(connectionSpecSelector.f23391d);
                    stringBuilder.append(", modes=");
                    stringBuilder.append(connectionSpecSelector.f23388a);
                    stringBuilder.append(", supported protocols=");
                    stringBuilder.append(Arrays.toString(socket.getEnabledProtocols()));
                    throw new UnknownServiceException(stringBuilder.toString());
                }
                connectionSpecSelector.f23390c = connectionSpecSelector.m25393a(socket);
                Internal.instance.apply(connectionSpec, socket, connectionSpecSelector.f23391d);
                if (connectionSpec.f23166e != null) {
                    Platform.m25549b().mo5373a((SSLSocket) socket, address.f23037a.f23215b, address.f23041e);
                }
                socket.startHandshake();
                connectionSpecSelector = Handshake.m25258a(socket.getSession());
                if (address.f23046j.verify(address.f23037a.f23215b, socket.getSession())) {
                    address.f23047k.m25209a(address.f23037a.f23215b, connectionSpecSelector.f23194c);
                    if (connectionSpec.f23166e) {
                        str = Platform.m25549b().mo5369a((SSLSocket) socket);
                    }
                    this.f30393c = socket;
                    this.f30396f = Okio.m25615a(Okio.m25625b(this.f30393c));
                    this.f30397g = Okio.m25614a(Okio.m25619a(this.f30393c));
                    this.f30394d = connectionSpecSelector;
                    if (str != null) {
                        connectionSpecSelector = Protocol.m25312a(str);
                    } else {
                        connectionSpecSelector = Protocol.HTTP_1_1;
                    }
                    this.f30404o = connectionSpecSelector;
                    if (socket != null) {
                        Platform.m25549b().mo5376b((SSLSocket) socket);
                        return;
                    }
                    return;
                }
                Certificate certificate = (X509Certificate) connectionSpecSelector.f23194c.get(0);
                StringBuilder stringBuilder2 = new StringBuilder("Hostname ");
                stringBuilder2.append(address.f23037a.f23215b);
                stringBuilder2.append(" not verified:\n    certificate: ");
                stringBuilder2.append(CertificatePinner.m25208a(certificate));
                stringBuilder2.append("\n    DN: ");
                stringBuilder2.append(certificate.getSubjectDN().getName());
                stringBuilder2.append("\n    subjectAltNames: ");
                stringBuilder2.append(OkHostnameVerifier.m25573a(certificate));
                throw new SSLPeerUnverifiedException(stringBuilder2.toString());
            } catch (AssertionError e2) {
                e = e2;
                str = socket;
                try {
                    if (Util.m25370a(e)) {
                        throw new IOException(e);
                    }
                    throw e;
                } catch (Throwable th) {
                    connectionSpecSelector = th;
                    socket = str;
                    if (socket != null) {
                        Platform.m25549b().mo5376b((SSLSocket) socket);
                    }
                    Util.m25367a(socket);
                    throw connectionSpecSelector;
                }
            } catch (Throwable th2) {
                connectionSpecSelector = th2;
                if (socket != null) {
                    Platform.m25549b().mo5376b((SSLSocket) socket);
                }
                Util.m25367a(socket);
                throw connectionSpecSelector;
            }
        } catch (AssertionError e3) {
            e = e3;
            if (Util.m25370a(e)) {
                throw new IOException(e);
            }
            throw e;
        }
    }

    public final boolean m31365a(com.sendbird.android.shadow.okhttp3.Address r5, com.sendbird.android.shadow.okhttp3.Route r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r4 = this;
        r0 = r4.f30401k;
        r0 = r0.size();
        r1 = r4.f30400j;
        r2 = 0;
        if (r0 >= r1) goto L_0x007f;
    L_0x000b:
        r0 = r4.f30398h;
        if (r0 == 0) goto L_0x0010;
    L_0x000f:
        goto L_0x007f;
    L_0x0010:
        r0 = com.sendbird.android.shadow.okhttp3.internal.Internal.instance;
        r1 = r4.f30391a;
        r1 = r1.f23321a;
        r0 = r0.equalsNonHost(r1, r5);
        if (r0 != 0) goto L_0x001d;
    L_0x001c:
        return r2;
    L_0x001d:
        r0 = r5.f23037a;
        r0 = r0.f23215b;
        r1 = r4.f30391a;
        r1 = r1.f23321a;
        r1 = r1.f23037a;
        r1 = r1.f23215b;
        r0 = r0.equals(r1);
        r1 = 1;
        if (r0 == 0) goto L_0x0031;
    L_0x0030:
        return r1;
    L_0x0031:
        r0 = r4.f30395e;
        if (r0 != 0) goto L_0x0036;
    L_0x0035:
        return r2;
    L_0x0036:
        if (r6 != 0) goto L_0x0039;
    L_0x0038:
        return r2;
    L_0x0039:
        r0 = r6.f23322b;
        r0 = r0.type();
        r3 = java.net.Proxy.Type.DIRECT;
        if (r0 == r3) goto L_0x0044;
    L_0x0043:
        return r2;
    L_0x0044:
        r0 = r4.f30391a;
        r0 = r0.f23322b;
        r0 = r0.type();
        r3 = java.net.Proxy.Type.DIRECT;
        if (r0 == r3) goto L_0x0051;
    L_0x0050:
        return r2;
    L_0x0051:
        r0 = r4.f30391a;
        r0 = r0.f23323c;
        r3 = r6.f23323c;
        r0 = r0.equals(r3);
        if (r0 != 0) goto L_0x005e;
    L_0x005d:
        return r2;
    L_0x005e:
        r6 = r6.f23321a;
        r6 = r6.f23046j;
        r0 = com.sendbird.android.shadow.okhttp3.internal.tls.OkHostnameVerifier.f23565a;
        if (r6 == r0) goto L_0x0067;
    L_0x0066:
        return r2;
    L_0x0067:
        r6 = r5.f23037a;
        r6 = r4.m31366a(r6);
        if (r6 != 0) goto L_0x0070;
    L_0x006f:
        return r2;
    L_0x0070:
        r6 = r5.f23047k;	 Catch:{ SSLPeerUnverifiedException -> 0x007e }
        r5 = r5.f23037a;	 Catch:{ SSLPeerUnverifiedException -> 0x007e }
        r5 = r5.f23215b;	 Catch:{ SSLPeerUnverifiedException -> 0x007e }
        r0 = r4.f30394d;	 Catch:{ SSLPeerUnverifiedException -> 0x007e }
        r0 = r0.f23194c;	 Catch:{ SSLPeerUnverifiedException -> 0x007e }
        r6.m25209a(r5, r0);	 Catch:{ SSLPeerUnverifiedException -> 0x007e }
        return r1;
    L_0x007e:
        return r2;
    L_0x007f:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.okhttp3.internal.connection.RealConnection.a(com.sendbird.android.shadow.okhttp3.Address, com.sendbird.android.shadow.okhttp3.Route):boolean");
    }

    public final Route mo5326a() {
        return this.f30391a;
    }

    public final boolean m31367a(boolean r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r4 = this;
        r0 = r4.f30393c;
        r0 = r0.isClosed();
        r1 = 0;
        if (r0 != 0) goto L_0x0053;
    L_0x0009:
        r0 = r4.f30393c;
        r0 = r0.isInputShutdown();
        if (r0 != 0) goto L_0x0053;
    L_0x0011:
        r0 = r4.f30393c;
        r0 = r0.isOutputShutdown();
        if (r0 == 0) goto L_0x001a;
    L_0x0019:
        goto L_0x0053;
    L_0x001a:
        r0 = r4.f30395e;
        r2 = 1;
        if (r0 == 0) goto L_0x0029;
    L_0x001f:
        r5 = r4.f30395e;
        r5 = r5.m25478b();
        if (r5 != 0) goto L_0x0028;
    L_0x0027:
        return r2;
    L_0x0028:
        return r1;
    L_0x0029:
        if (r5 == 0) goto L_0x0052;
    L_0x002b:
        r5 = r4.f30393c;	 Catch:{ SocketTimeoutException -> 0x0052, IOException -> 0x0051 }
        r5 = r5.getSoTimeout();	 Catch:{ SocketTimeoutException -> 0x0052, IOException -> 0x0051 }
        r0 = r4.f30393c;	 Catch:{ all -> 0x004a }
        r0.setSoTimeout(r2);	 Catch:{ all -> 0x004a }
        r0 = r4.f30396f;	 Catch:{ all -> 0x004a }
        r0 = r0.mo6562d();	 Catch:{ all -> 0x004a }
        if (r0 == 0) goto L_0x0044;
    L_0x003e:
        r0 = r4.f30393c;	 Catch:{ SocketTimeoutException -> 0x0052, IOException -> 0x0051 }
        r0.setSoTimeout(r5);	 Catch:{ SocketTimeoutException -> 0x0052, IOException -> 0x0051 }
        return r1;	 Catch:{ SocketTimeoutException -> 0x0052, IOException -> 0x0051 }
    L_0x0044:
        r0 = r4.f30393c;	 Catch:{ SocketTimeoutException -> 0x0052, IOException -> 0x0051 }
        r0.setSoTimeout(r5);	 Catch:{ SocketTimeoutException -> 0x0052, IOException -> 0x0051 }
        return r2;	 Catch:{ SocketTimeoutException -> 0x0052, IOException -> 0x0051 }
    L_0x004a:
        r0 = move-exception;	 Catch:{ SocketTimeoutException -> 0x0052, IOException -> 0x0051 }
        r3 = r4.f30393c;	 Catch:{ SocketTimeoutException -> 0x0052, IOException -> 0x0051 }
        r3.setSoTimeout(r5);	 Catch:{ SocketTimeoutException -> 0x0052, IOException -> 0x0051 }
        throw r0;	 Catch:{ SocketTimeoutException -> 0x0052, IOException -> 0x0051 }
    L_0x0051:
        return r1;
    L_0x0052:
        return r2;
    L_0x0053:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.okhttp3.internal.connection.RealConnection.a(boolean):boolean");
    }

    public final void mo5328a(Http2Stream http2Stream) throws IOException {
        http2Stream.m25495a(ErrorCode.REFUSED_STREAM);
    }

    public final void mo5327a(Http2Connection http2Connection) {
        synchronized (this.f30403n) {
            this.f30400j = http2Connection.m25469a();
        }
    }

    public final boolean m31368b() {
        return this.f30395e != null;
    }

    public final String toString() {
        Object obj;
        StringBuilder stringBuilder = new StringBuilder("Connection{");
        stringBuilder.append(this.f30391a.f23321a.f23037a.f23215b);
        stringBuilder.append(":");
        stringBuilder.append(this.f30391a.f23321a.f23037a.f23216c);
        stringBuilder.append(", proxy=");
        stringBuilder.append(this.f30391a.f23322b);
        stringBuilder.append(" hostAddress=");
        stringBuilder.append(this.f30391a.f23323c);
        stringBuilder.append(" cipherSuite=");
        if (this.f30394d != null) {
            obj = this.f30394d.f23193b;
        } else {
            obj = "none";
        }
        stringBuilder.append(obj);
        stringBuilder.append(" protocol=");
        stringBuilder.append(this.f30404o);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public final boolean m31366a(HttpUrl httpUrl) {
        if (httpUrl.f23216c != this.f30391a.f23321a.f23037a.f23216c) {
            return false;
        }
        if (httpUrl.f23215b.equals(this.f30391a.f23321a.f23037a.f23215b)) {
            return true;
        }
        if (this.f30394d != null) {
            OkHostnameVerifier okHostnameVerifier = OkHostnameVerifier.f23565a;
            if (OkHostnameVerifier.m25576a(httpUrl.f23215b, (X509Certificate) this.f30394d.f23194c.get(0)) != null) {
                return true;
            }
        }
        return false;
    }
}
