package com.sendbird.android.shadow.okhttp3.internal.ws;

import com.sendbird.android.shadow.okhttp3.Call;
import com.sendbird.android.shadow.okhttp3.Callback;
import com.sendbird.android.shadow.okhttp3.Protocol;
import com.sendbird.android.shadow.okhttp3.Request;
import com.sendbird.android.shadow.okhttp3.Response;
import com.sendbird.android.shadow.okhttp3.WebSocket;
import com.sendbird.android.shadow.okhttp3.WebSocketListener;
import com.sendbird.android.shadow.okhttp3.internal.Internal;
import com.sendbird.android.shadow.okhttp3.internal.Util;
import com.sendbird.android.shadow.okhttp3.internal.connection.RealConnection.C24721;
import com.sendbird.android.shadow.okhttp3.internal.ws.WebSocketReader.FrameCallback;
import com.sendbird.android.shadow.okio.Buffer;
import com.sendbird.android.shadow.okio.BufferedSink;
import com.sendbird.android.shadow.okio.BufferedSource;
import com.sendbird.android.shadow.okio.ByteString;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class RealWebSocket implements WebSocket, FrameCallback {
    public static final List<Protocol> f30532a = Collections.singletonList(Protocol.HTTP_1_1);
    static final /* synthetic */ boolean f30533o = true;
    public final Request f30534b;
    final WebSocketListener f30535c;
    final Random f30536d;
    public final String f30537e;
    public Call f30538f;
    WebSocketReader f30539g;
    WebSocketWriter f30540h;
    ScheduledExecutorService f30541i;
    Streams f30542j;
    final ArrayDeque<Object> f30543k = new ArrayDeque();
    boolean f30544l;
    int f30545m;
    int f30546n;
    private final Runnable f30547p;
    private final ArrayDeque<ByteString> f30548q = new ArrayDeque();
    private long f30549r;
    private boolean f30550s;
    private ScheduledFuture<?> f30551t;
    private int f30552u = -1;
    private String f30553v;

    class C20441 implements Runnable {
        final /* synthetic */ RealWebSocket f23566a;

        C20441(RealWebSocket realWebSocket) {
            this.f23566a = realWebSocket;
        }

        public void run() {
            do {
                try {
                } catch (Exception e) {
                    this.f23566a.m31480a(e);
                    return;
                }
            } while (this.f23566a.m31487e());
        }
    }

    final class CancelRunnable implements Runnable {
        final /* synthetic */ RealWebSocket f23567a;

        CancelRunnable(RealWebSocket realWebSocket) {
            this.f23567a = realWebSocket;
        }

        public final void run() {
            this.f23567a.mo5377a();
        }
    }

    static final class Close {
        final int f23568a;
        final ByteString f23569b;
        final long f23570c = 60000;

        Close(int i, ByteString byteString) {
            this.f23568a = i;
            this.f23569b = byteString;
        }
    }

    static final class Message {
        final int f23571a = 1;
        final ByteString f23572b;

        Message(ByteString byteString) {
            this.f23572b = byteString;
        }
    }

    private final class PingRunnable implements Runnable {
        final /* synthetic */ RealWebSocket f23573a;

        PingRunnable(RealWebSocket realWebSocket) {
            this.f23573a = realWebSocket;
        }

        public final void run() {
            RealWebSocket realWebSocket = this.f23573a;
            synchronized (realWebSocket) {
                if (realWebSocket.f30544l) {
                    return;
                }
                WebSocketWriter webSocketWriter = realWebSocket.f30540h;
                try {
                    webSocketWriter.m25590a(9, ByteString.f23602b);
                } catch (Exception e) {
                    realWebSocket.m31480a(e);
                }
            }
        }
    }

    public static abstract class Streams implements Closeable {
        public final boolean f23574c = true;
        public final BufferedSource f23575d;
        public final BufferedSink f23576e;

        public Streams(BufferedSource bufferedSource, BufferedSink bufferedSink) {
            this.f23575d = bufferedSource;
            this.f23576e = bufferedSink;
        }
    }

    class C24862 implements Callback {
        final /* synthetic */ Request f30529a;
        final /* synthetic */ int f30530b;
        final /* synthetic */ RealWebSocket f30531c;

        public C24862(RealWebSocket realWebSocket, Request request, int i) {
            this.f30531c = realWebSocket;
            this.f30529a = request;
            this.f30530b = i;
        }

        public final void mo5208a(Call call, Response response) {
            try {
                RealWebSocket realWebSocket = this.f30531c;
                StringBuilder stringBuilder;
                if (response.f23310c != 101) {
                    stringBuilder = new StringBuilder("Expected HTTP 101 response but was '");
                    stringBuilder.append(response.f23310c);
                    stringBuilder.append(" ");
                    stringBuilder.append(response.f23311d);
                    stringBuilder.append("'");
                    throw new ProtocolException(stringBuilder.toString());
                }
                String a = response.m25333a("Connection");
                if ("Upgrade".equalsIgnoreCase(a)) {
                    a = response.m25333a("Upgrade");
                    if ("websocket".equalsIgnoreCase(a)) {
                        a = response.m25333a("Sec-WebSocket-Accept");
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append(realWebSocket.f30537e);
                        stringBuilder2.append("258EAFA5-E914-47DA-95CA-C5AB0DC85B11");
                        String b = ByteString.m25595a(stringBuilder2.toString()).mo5400d().mo5398b();
                        if (b.equals(a)) {
                            call = Internal.instance.streamAllocation(call);
                            call.m25415d();
                            response = call.m25413b();
                            Streams c24721 = new C24721(response, response.f30396f, response.f30397g, call);
                            try {
                                this.f30531c.f30535c.mo5238a(this.f30531c);
                                response = new StringBuilder("OkHttp WebSocket ");
                                response.append(this.f30529a.url().m25300h());
                                String stringBuilder3 = response.toString();
                                Object obj = this.f30531c;
                                long j = (long) this.f30530b;
                                synchronized (obj) {
                                    obj.f30542j = c24721;
                                    obj.f30540h = new WebSocketWriter(c24721.f23574c, c24721.f23576e, obj.f30536d);
                                    obj.f30541i = new ScheduledThreadPoolExecutor(1, Util.m25364a(stringBuilder3, false));
                                    if (j != 0) {
                                        obj.f30541i.scheduleAtFixedRate(new PingRunnable(obj), j, j, TimeUnit.MILLISECONDS);
                                    }
                                    if (obj.f30543k.isEmpty() == null) {
                                        obj.m31486d();
                                    }
                                }
                                obj.f30539g = new WebSocketReader(c24721.f23574c, c24721.f23575d, obj);
                                call.m25413b().f30393c.setSoTimeout(0);
                                this.f30531c.m31482b();
                                return;
                            } catch (Exception e) {
                                this.f30531c.m31480a(e);
                                return;
                            }
                        }
                        stringBuilder2 = new StringBuilder("Expected 'Sec-WebSocket-Accept' header value '");
                        stringBuilder2.append(b);
                        stringBuilder2.append("' but was '");
                        stringBuilder2.append(a);
                        stringBuilder2.append("'");
                        throw new ProtocolException(stringBuilder2.toString());
                    }
                    stringBuilder = new StringBuilder("Expected 'Upgrade' header value 'websocket' but was '");
                    stringBuilder.append(a);
                    stringBuilder.append("'");
                    throw new ProtocolException(stringBuilder.toString());
                }
                stringBuilder = new StringBuilder("Expected 'Connection' header value 'Upgrade' but was '");
                stringBuilder.append(a);
                stringBuilder.append("'");
                throw new ProtocolException(stringBuilder.toString());
            } catch (Exception e2) {
                this.f30531c.m31480a(e2);
                Util.m25366a((Closeable) response);
            }
        }

        public final void mo5209a(Call call, IOException iOException) {
            this.f30531c.m31480a((Exception) iOException);
        }
    }

    public RealWebSocket(Request request, WebSocketListener webSocketListener, Random random) {
        if (HttpRequest.METHOD_GET.equals(request.method())) {
            this.f30534b = request;
            this.f30535c = webSocketListener;
            this.f30536d = random;
            byte[] bArr = new byte[16];
            random.nextBytes(bArr);
            this.f30537e = ByteString.m25596a(bArr).mo5398b();
            this.f30547p = new C20441(this);
            return;
        }
        random = new StringBuilder("Request must be GET: ");
        random.append(request.method());
        throw new IllegalArgumentException(random.toString());
    }

    public final void mo5377a() {
        this.f30538f.mo5320b();
    }

    public final void m31482b() throws IOException {
        while (this.f30552u == -1) {
            WebSocketReader webSocketReader = this.f30539g;
            webSocketReader.m25586a();
            if (webSocketReader.f23585i) {
                webSocketReader.m25588b();
            } else {
                int i = webSocketReader.f23581e;
                if (i == 1 || i == 2) {
                    Buffer buffer = new Buffer();
                    webSocketReader.m25587a(buffer);
                    if (i == 1) {
                        webSocketReader.f23579c.mo5383c(buffer.m35501o());
                    } else {
                        buffer.m35500n();
                    }
                } else {
                    StringBuilder stringBuilder = new StringBuilder("Unknown opcode: ");
                    stringBuilder.append(Integer.toHexString(i));
                    throw new ProtocolException(stringBuilder.toString());
                }
            }
        }
    }

    public final void mo5383c(String str) throws IOException {
        this.f30535c.mo5239a(str);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void mo5379a(com.sendbird.android.shadow.okio.ByteString r2) {
        /*
        r1 = this;
        monitor-enter(r1);
        r0 = r1.f30544l;	 Catch:{ all -> 0x0024 }
        if (r0 != 0) goto L_0x0022;
    L_0x0005:
        r0 = r1.f30550s;	 Catch:{ all -> 0x0024 }
        if (r0 == 0) goto L_0x0012;
    L_0x0009:
        r0 = r1.f30543k;	 Catch:{ all -> 0x0024 }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x0024 }
        if (r0 == 0) goto L_0x0012;
    L_0x0011:
        goto L_0x0022;
    L_0x0012:
        r0 = r1.f30548q;	 Catch:{ all -> 0x0024 }
        r0.add(r2);	 Catch:{ all -> 0x0024 }
        r1.m31486d();	 Catch:{ all -> 0x0024 }
        r2 = r1.f30545m;	 Catch:{ all -> 0x0024 }
        r2 = r2 + 1;
        r1.f30545m = r2;	 Catch:{ all -> 0x0024 }
        monitor-exit(r1);
        return;
    L_0x0022:
        monitor-exit(r1);
        return;
    L_0x0024:
        r2 = move-exception;
        monitor-exit(r1);
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.okhttp3.internal.ws.RealWebSocket.a(com.sendbird.android.shadow.okio.ByteString):void");
    }

    public final synchronized void mo5382c() {
        this.f30546n++;
    }

    public final void mo5378a(int i, String str) {
        Closeable closeable;
        if (i == -1) {
            throw new IllegalArgumentException();
        }
        synchronized (this) {
            if (this.f30552u != -1) {
                throw new IllegalStateException("already closed");
            }
            this.f30552u = i;
            this.f30553v = str;
            if (this.f30550s == null || this.f30543k.isEmpty() == null) {
                closeable = null;
            } else {
                closeable = this.f30542j;
                this.f30542j = null;
                if (this.f30551t != null) {
                    this.f30551t.cancel(false);
                }
                this.f30541i.shutdown();
            }
        }
        if (closeable != null) {
            try {
                this.f30535c.mo5237a(i);
            } catch (Throwable th) {
                Util.m25366a(closeable);
            }
        }
        Util.m25366a(closeable);
    }

    public final boolean mo5380a(String str) {
        if (str != null) {
            return m31476b(ByteString.m25595a(str));
        }
        throw new NullPointerException("text == null");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized boolean m31476b(com.sendbird.android.shadow.okio.ByteString r7) {
        /*
        r6 = this;
        monitor-enter(r6);
        r0 = r6.f30544l;	 Catch:{ all -> 0x003e }
        r1 = 0;
        if (r0 != 0) goto L_0x003c;
    L_0x0006:
        r0 = r6.f30550s;	 Catch:{ all -> 0x003e }
        if (r0 == 0) goto L_0x000b;
    L_0x000a:
        goto L_0x003c;
    L_0x000b:
        r2 = r6.f30549r;	 Catch:{ all -> 0x003e }
        r0 = r7.mo5405h();	 Catch:{ all -> 0x003e }
        r4 = (long) r0;	 Catch:{ all -> 0x003e }
        r2 = r2 + r4;
        r4 = 16777216; // 0x1000000 float:2.3509887E-38 double:8.289046E-317;
        r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r0 <= 0) goto L_0x0022;
    L_0x001a:
        r7 = 1001; // 0x3e9 float:1.403E-42 double:4.946E-321;
        r0 = 0;
        r6.m31475b(r7, r0);	 Catch:{ all -> 0x003e }
        monitor-exit(r6);
        return r1;
    L_0x0022:
        r0 = r6.f30549r;	 Catch:{ all -> 0x003e }
        r2 = r7.mo5405h();	 Catch:{ all -> 0x003e }
        r2 = (long) r2;	 Catch:{ all -> 0x003e }
        r0 = r0 + r2;
        r6.f30549r = r0;	 Catch:{ all -> 0x003e }
        r0 = r6.f30543k;	 Catch:{ all -> 0x003e }
        r1 = new com.sendbird.android.shadow.okhttp3.internal.ws.RealWebSocket$Message;	 Catch:{ all -> 0x003e }
        r1.<init>(r7);	 Catch:{ all -> 0x003e }
        r0.add(r1);	 Catch:{ all -> 0x003e }
        r6.m31486d();	 Catch:{ all -> 0x003e }
        r7 = 1;
        monitor-exit(r6);
        return r7;
    L_0x003c:
        monitor-exit(r6);
        return r1;
    L_0x003e:
        r7 = move-exception;
        monitor-exit(r6);
        throw r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.okhttp3.internal.ws.RealWebSocket.b(com.sendbird.android.shadow.okio.ByteString):boolean");
    }

    public final boolean mo5381b(String str) {
        return m31475b(1000, str);
    }

    private synchronized boolean m31475b(int i, String str) {
        WebSocketProtocol.m25580b(i);
        ByteString byteString = null;
        if (str != null) {
            byteString = ByteString.m25595a(str);
            if (((long) byteString.mo5405h()) > 123) {
                StringBuilder stringBuilder = new StringBuilder("reason.size() > 123: ");
                stringBuilder.append(str);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
        }
        if (this.f30544l == null) {
            if (this.f30550s == null) {
                this.f30550s = true;
                this.f30543k.add(new Close(i, byteString));
                m31486d();
                return true;
            }
        }
        return false;
    }

    final void m31486d() {
        if (!f30533o && !Thread.holdsLock(this)) {
            throw new AssertionError();
        } else if (this.f30541i != null) {
            this.f30541i.execute(this.f30547p);
        }
    }

    final boolean m31487e() throws java.io.IOException {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Exception block dominator not found, method:com.sendbird.android.shadow.okhttp3.internal.ws.RealWebSocket.e():boolean. bs: [B:23:0x0052, B:55:0x00ce]
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:86)
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
        r11 = this;
        monitor-enter(r11);
        r0 = r11.f30544l;	 Catch:{ all -> 0x00ec }
        r1 = 0;	 Catch:{ all -> 0x00ec }
        if (r0 == 0) goto L_0x0008;	 Catch:{ all -> 0x00ec }
    L_0x0006:
        monitor-exit(r11);	 Catch:{ all -> 0x00ec }
        return r1;	 Catch:{ all -> 0x00ec }
    L_0x0008:
        r0 = r11.f30540h;	 Catch:{ all -> 0x00ec }
        r2 = r11.f30548q;	 Catch:{ all -> 0x00ec }
        r2 = r2.poll();	 Catch:{ all -> 0x00ec }
        r2 = (com.sendbird.android.shadow.okio.ByteString) r2;	 Catch:{ all -> 0x00ec }
        r3 = 0;	 Catch:{ all -> 0x00ec }
        if (r2 != 0) goto L_0x004a;	 Catch:{ all -> 0x00ec }
    L_0x0015:
        r4 = r11.f30543k;	 Catch:{ all -> 0x00ec }
        r4 = r4.poll();	 Catch:{ all -> 0x00ec }
        r5 = r4 instanceof com.sendbird.android.shadow.okhttp3.internal.ws.RealWebSocket.Close;	 Catch:{ all -> 0x00ec }
        if (r5 == 0) goto L_0x0044;	 Catch:{ all -> 0x00ec }
    L_0x001f:
        r5 = r11.f30552u;	 Catch:{ all -> 0x00ec }
        r6 = -1;	 Catch:{ all -> 0x00ec }
        if (r5 == r6) goto L_0x002f;	 Catch:{ all -> 0x00ec }
    L_0x0024:
        r6 = r11.f30542j;	 Catch:{ all -> 0x00ec }
        r11.f30542j = r3;	 Catch:{ all -> 0x00ec }
        r3 = r11.f30541i;	 Catch:{ all -> 0x00ec }
        r3.shutdown();	 Catch:{ all -> 0x00ec }
        r3 = r6;	 Catch:{ all -> 0x00ec }
        goto L_0x004c;	 Catch:{ all -> 0x00ec }
    L_0x002f:
        r6 = r11.f30541i;	 Catch:{ all -> 0x00ec }
        r7 = new com.sendbird.android.shadow.okhttp3.internal.ws.RealWebSocket$CancelRunnable;	 Catch:{ all -> 0x00ec }
        r7.<init>(r11);	 Catch:{ all -> 0x00ec }
        r8 = r4;	 Catch:{ all -> 0x00ec }
        r8 = (com.sendbird.android.shadow.okhttp3.internal.ws.RealWebSocket.Close) r8;	 Catch:{ all -> 0x00ec }
        r8 = r8.f23570c;	 Catch:{ all -> 0x00ec }
        r10 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ all -> 0x00ec }
        r6 = r6.schedule(r7, r8, r10);	 Catch:{ all -> 0x00ec }
        r11.f30551t = r6;	 Catch:{ all -> 0x00ec }
        goto L_0x004c;	 Catch:{ all -> 0x00ec }
    L_0x0044:
        if (r4 != 0) goto L_0x0048;	 Catch:{ all -> 0x00ec }
    L_0x0046:
        monitor-exit(r11);	 Catch:{ all -> 0x00ec }
        return r1;	 Catch:{ all -> 0x00ec }
    L_0x0048:
        r5 = r1;	 Catch:{ all -> 0x00ec }
        goto L_0x004c;	 Catch:{ all -> 0x00ec }
    L_0x004a:
        r5 = r1;	 Catch:{ all -> 0x00ec }
        r4 = r3;	 Catch:{ all -> 0x00ec }
    L_0x004c:
        monitor-exit(r11);	 Catch:{ all -> 0x00ec }
        r6 = 1;
        if (r2 == 0) goto L_0x005a;
    L_0x0050:
        r1 = 10;
        r0.m25590a(r1, r2);	 Catch:{ all -> 0x0057 }
        goto L_0x00da;	 Catch:{ all -> 0x0057 }
    L_0x0057:
        r0 = move-exception;	 Catch:{ all -> 0x0057 }
        goto L_0x00e8;	 Catch:{ all -> 0x0057 }
    L_0x005a:
        r2 = r4 instanceof com.sendbird.android.shadow.okhttp3.internal.ws.RealWebSocket.Message;	 Catch:{ all -> 0x0057 }
        if (r2 == 0) goto L_0x00a6;	 Catch:{ all -> 0x0057 }
    L_0x005e:
        r2 = r4;	 Catch:{ all -> 0x0057 }
        r2 = (com.sendbird.android.shadow.okhttp3.internal.ws.RealWebSocket.Message) r2;	 Catch:{ all -> 0x0057 }
        r2 = r2.f23572b;	 Catch:{ all -> 0x0057 }
        r4 = (com.sendbird.android.shadow.okhttp3.internal.ws.RealWebSocket.Message) r4;	 Catch:{ all -> 0x0057 }
        r4 = r4.f23571a;	 Catch:{ all -> 0x0057 }
        r5 = r2.mo5405h();	 Catch:{ all -> 0x0057 }
        r7 = (long) r5;	 Catch:{ all -> 0x0057 }
        r5 = r0.f23595g;	 Catch:{ all -> 0x0057 }
        if (r5 == 0) goto L_0x0078;	 Catch:{ all -> 0x0057 }
    L_0x0070:
        r0 = new java.lang.IllegalStateException;	 Catch:{ all -> 0x0057 }
        r1 = "Another message writer is active. Did you call close()?";	 Catch:{ all -> 0x0057 }
        r0.<init>(r1);	 Catch:{ all -> 0x0057 }
        throw r0;	 Catch:{ all -> 0x0057 }
    L_0x0078:
        r0.f23595g = r6;	 Catch:{ all -> 0x0057 }
        r5 = r0.f23594f;	 Catch:{ all -> 0x0057 }
        r5.f30554a = r4;	 Catch:{ all -> 0x0057 }
        r4 = r0.f23594f;	 Catch:{ all -> 0x0057 }
        r4.f30555b = r7;	 Catch:{ all -> 0x0057 }
        r4 = r0.f23594f;	 Catch:{ all -> 0x0057 }
        r4.f30556c = r6;	 Catch:{ all -> 0x0057 }
        r4 = r0.f23594f;	 Catch:{ all -> 0x0057 }
        r4.f30557d = r1;	 Catch:{ all -> 0x0057 }
        r0 = r0.f23594f;	 Catch:{ all -> 0x0057 }
        r0 = com.sendbird.android.shadow.okio.Okio.m25614a(r0);	 Catch:{ all -> 0x0057 }
        r0.mo6557c(r2);	 Catch:{ all -> 0x0057 }
        r0.close();	 Catch:{ all -> 0x0057 }
        monitor-enter(r11);	 Catch:{ all -> 0x0057 }
        r0 = r11.f30549r;	 Catch:{ all -> 0x00a3 }
        r2 = r2.mo5405h();	 Catch:{ all -> 0x00a3 }
        r4 = (long) r2;	 Catch:{ all -> 0x00a3 }
        r0 = r0 - r4;	 Catch:{ all -> 0x00a3 }
        r11.f30549r = r0;	 Catch:{ all -> 0x00a3 }
        monitor-exit(r11);	 Catch:{ all -> 0x00a3 }
        goto L_0x00da;	 Catch:{ all -> 0x00a3 }
    L_0x00a3:
        r0 = move-exception;	 Catch:{ all -> 0x00a3 }
        monitor-exit(r11);	 Catch:{ all -> 0x00a3 }
        throw r0;	 Catch:{ all -> 0x0057 }
    L_0x00a6:
        r1 = r4 instanceof com.sendbird.android.shadow.okhttp3.internal.ws.RealWebSocket.Close;	 Catch:{ all -> 0x0057 }
        if (r1 == 0) goto L_0x00e2;	 Catch:{ all -> 0x0057 }
    L_0x00aa:
        r4 = (com.sendbird.android.shadow.okhttp3.internal.ws.RealWebSocket.Close) r4;	 Catch:{ all -> 0x0057 }
        r1 = r4.f23568a;	 Catch:{ all -> 0x0057 }
        r2 = r4.f23569b;	 Catch:{ all -> 0x0057 }
        r4 = com.sendbird.android.shadow.okio.ByteString.f23602b;	 Catch:{ all -> 0x0057 }
        if (r1 != 0) goto L_0x00b6;	 Catch:{ all -> 0x0057 }
    L_0x00b4:
        if (r2 == 0) goto L_0x00cc;	 Catch:{ all -> 0x0057 }
    L_0x00b6:
        if (r1 == 0) goto L_0x00bb;	 Catch:{ all -> 0x0057 }
    L_0x00b8:
        com.sendbird.android.shadow.okhttp3.internal.ws.WebSocketProtocol.m25580b(r1);	 Catch:{ all -> 0x0057 }
    L_0x00bb:
        r4 = new com.sendbird.android.shadow.okio.Buffer;	 Catch:{ all -> 0x0057 }
        r4.<init>();	 Catch:{ all -> 0x0057 }
        r4.m35469c(r1);	 Catch:{ all -> 0x0057 }
        if (r2 == 0) goto L_0x00c8;	 Catch:{ all -> 0x0057 }
    L_0x00c5:
        r4.m35454a(r2);	 Catch:{ all -> 0x0057 }
    L_0x00c8:
        r4 = r4.m35500n();	 Catch:{ all -> 0x0057 }
    L_0x00cc:
        r1 = 8;
        r0.m25590a(r1, r4);	 Catch:{ all -> 0x00de }
        r0.f23592d = r6;	 Catch:{ all -> 0x0057 }
        if (r3 == 0) goto L_0x00da;	 Catch:{ all -> 0x0057 }
    L_0x00d5:
        r0 = r11.f30535c;	 Catch:{ all -> 0x0057 }
        r0.mo5237a(r5);	 Catch:{ all -> 0x0057 }
    L_0x00da:
        com.sendbird.android.shadow.okhttp3.internal.Util.m25366a(r3);
        return r6;
    L_0x00de:
        r1 = move-exception;
        r0.f23592d = r6;	 Catch:{ all -> 0x0057 }
        throw r1;	 Catch:{ all -> 0x0057 }
    L_0x00e2:
        r0 = new java.lang.AssertionError;	 Catch:{ all -> 0x0057 }
        r0.<init>();	 Catch:{ all -> 0x0057 }
        throw r0;	 Catch:{ all -> 0x0057 }
    L_0x00e8:
        com.sendbird.android.shadow.okhttp3.internal.Util.m25366a(r3);
        throw r0;
    L_0x00ec:
        r0 = move-exception;
        monitor-exit(r11);	 Catch:{ all -> 0x00ec }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.okhttp3.internal.ws.RealWebSocket.e():boolean");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m31480a(java.lang.Exception r4) {
        /*
        r3 = this;
        monitor-enter(r3);
        r0 = r3.f30544l;	 Catch:{ all -> 0x0031 }
        if (r0 == 0) goto L_0x0007;
    L_0x0005:
        monitor-exit(r3);	 Catch:{ all -> 0x0031 }
        return;
    L_0x0007:
        r0 = 1;
        r3.f30544l = r0;	 Catch:{ all -> 0x0031 }
        r0 = r3.f30542j;	 Catch:{ all -> 0x0031 }
        r1 = 0;
        r3.f30542j = r1;	 Catch:{ all -> 0x0031 }
        r1 = r3.f30551t;	 Catch:{ all -> 0x0031 }
        if (r1 == 0) goto L_0x0019;
    L_0x0013:
        r1 = r3.f30551t;	 Catch:{ all -> 0x0031 }
        r2 = 0;
        r1.cancel(r2);	 Catch:{ all -> 0x0031 }
    L_0x0019:
        r1 = r3.f30541i;	 Catch:{ all -> 0x0031 }
        if (r1 == 0) goto L_0x0022;
    L_0x001d:
        r1 = r3.f30541i;	 Catch:{ all -> 0x0031 }
        r1.shutdown();	 Catch:{ all -> 0x0031 }
    L_0x0022:
        monitor-exit(r3);	 Catch:{ all -> 0x0031 }
        r1 = r3.f30535c;	 Catch:{ all -> 0x002c }
        r1.mo5240a(r4);	 Catch:{ all -> 0x002c }
        com.sendbird.android.shadow.okhttp3.internal.Util.m25366a(r0);
        return;
    L_0x002c:
        r4 = move-exception;
        com.sendbird.android.shadow.okhttp3.internal.Util.m25366a(r0);
        throw r4;
    L_0x0031:
        r4 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0031 }
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.okhttp3.internal.ws.RealWebSocket.a(java.lang.Exception):void");
    }
}
