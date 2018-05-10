package com.sendbird.android.shadow.okhttp3.internal.connection;

import com.sendbird.android.shadow.okhttp3.Address;
import com.sendbird.android.shadow.okhttp3.Call;
import com.sendbird.android.shadow.okhttp3.ConnectionPool;
import com.sendbird.android.shadow.okhttp3.EventListener;
import com.sendbird.android.shadow.okhttp3.Interceptor.Chain;
import com.sendbird.android.shadow.okhttp3.OkHttpClient;
import com.sendbird.android.shadow.okhttp3.Route;
import com.sendbird.android.shadow.okhttp3.internal.Internal;
import com.sendbird.android.shadow.okhttp3.internal.Util;
import com.sendbird.android.shadow.okhttp3.internal.connection.RouteSelector.Selection;
import com.sendbird.android.shadow.okhttp3.internal.http.HttpCodec;
import com.sendbird.android.shadow.okhttp3.internal.http1.Http1Codec;
import com.sendbird.android.shadow.okhttp3.internal.http2.ConnectionShutdownException;
import com.sendbird.android.shadow.okhttp3.internal.http2.ErrorCode;
import com.sendbird.android.shadow.okhttp3.internal.http2.Http2Codec;
import com.sendbird.android.shadow.okhttp3.internal.http2.StreamResetException;
import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Proxy.Type;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class StreamAllocation {
    public static final /* synthetic */ boolean f23406k = true;
    public final Address f23407a;
    public Selection f23408b;
    public Route f23409c;
    public final ConnectionPool f23410d;
    public final Call f23411e;
    public final EventListener f23412f;
    public final RouteSelector f23413g;
    public RealConnection f23414h;
    public boolean f23415i;
    public HttpCodec f23416j;
    private final Object f23417l;
    private int f23418m;
    private boolean f23419n;
    private boolean f23420o;

    public static final class StreamAllocationReference extends WeakReference<StreamAllocation> {
        public final Object f23405a;

        StreamAllocationReference(StreamAllocation streamAllocation, Object obj) {
            super(streamAllocation);
            this.f23405a = obj;
        }
    }

    public StreamAllocation(ConnectionPool connectionPool, Address address, Call call, EventListener eventListener, Object obj) {
        this.f23410d = connectionPool;
        this.f23407a = address;
        this.f23411e = call;
        this.f23412f = eventListener;
        this.f23413g = new RouteSelector(address, m25406e(), call, eventListener);
        this.f23417l = obj;
    }

    public final HttpCodec m25408a(OkHttpClient okHttpClient, Chain chain, boolean z) {
        try {
            HttpCodec http2Codec;
            z = m25404a(chain.mo5331b(), chain.mo5332c(), chain.mo5333d(), okHttpClient.f23283y, z);
            if (z.f30395e != null) {
                http2Codec = new Http2Codec(okHttpClient, chain, this, z.f30395e);
            } else {
                z.f30393c.setSoTimeout(chain.mo5332c());
                z.f30396f.mo5323a().mo5385a((long) chain.mo5332c(), TimeUnit.MILLISECONDS);
                z.f30397g.mo5334a().mo5385a((long) chain.mo5333d(), TimeUnit.MILLISECONDS);
                http2Codec = new Http1Codec(okHttpClient, this, z.f30396f, z.f30397g);
            }
            synchronized (this.f23410d) {
                this.f23416j = http2Codec;
            }
            return http2Codec;
        } catch (OkHttpClient okHttpClient2) {
            throw new RouteException(okHttpClient2);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.sendbird.android.shadow.okhttp3.internal.connection.RealConnection m25404a(int r4, int r5, int r6, boolean r7, boolean r8) throws java.io.IOException {
        /*
        r3 = this;
    L_0x0000:
        r0 = r3.m25403a(r4, r5, r6, r7);
        r1 = r3.f23410d;
        monitor-enter(r1);
        r2 = r0.f30399i;	 Catch:{ all -> 0x0019 }
        if (r2 != 0) goto L_0x000d;
    L_0x000b:
        monitor-exit(r1);	 Catch:{ all -> 0x0019 }
        return r0;
    L_0x000d:
        monitor-exit(r1);	 Catch:{ all -> 0x0019 }
        r1 = r0.m31367a(r8);
        if (r1 != 0) goto L_0x0018;
    L_0x0014:
        r3.m25415d();
        goto L_0x0000;
    L_0x0018:
        return r0;
    L_0x0019:
        r4 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0019 }
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.okhttp3.internal.connection.StreamAllocation.a(int, int, int, boolean, boolean):com.sendbird.android.shadow.okhttp3.internal.connection.RealConnection");
    }

    private RealConnection m25403a(int i, int i2, int i3, boolean z) throws IOException {
        boolean z2;
        Socket socket;
        List list;
        RealConnection realConnection;
        boolean z3;
        Route route;
        synchronized (this.f23410d) {
            Socket socket2;
            RealConnection realConnection2;
            try {
                if (r1.f23420o) {
                    throw new IllegalStateException("released");
                } else if (r1.f23416j != null) {
                    throw new IllegalStateException("codec != null");
                } else if (r1.f23415i) {
                    throw new IOException("Canceled");
                } else {
                    realConnection2 = r1.f23414h;
                    if (f23406k || Thread.holdsLock(r1.f23410d)) {
                        RealConnection realConnection3 = r1.f23414h;
                        z2 = true;
                        socket2 = null;
                        boolean z4 = false;
                        if (realConnection3 == null || !realConnection3.f30398h) {
                            socket = null;
                        } else {
                            socket = m25409a(false, false, true);
                        }
                        list = r1.f23414h;
                        if (list != null) {
                            realConnection2 = r1.f23414h;
                        } else {
                            list = realConnection2;
                            realConnection2 = null;
                        }
                        if (!r1.f23419n) {
                            list = socket2;
                        }
                        if (realConnection2 == null) {
                            Internal internal = Internal.instance;
                            ConnectionPool connectionPool = r1.f23410d;
                            int i4 = r1.f23407a;
                            internal.get(connectionPool, i4, r1, socket2);
                            if (r1.f23414h != null) {
                                realConnection = r1.f23414h;
                                z3 = z2;
                                route = socket2;
                            } else {
                                route = r1.f23409c;
                                realConnection = realConnection2;
                            }
                        } else {
                            realConnection = realConnection2;
                            route = socket2;
                        }
                        z3 = z4;
                    } else {
                        throw new AssertionError();
                    }
                }
            } finally {
                boolean z5 = 
/*
Method generation error in method: com.sendbird.android.shadow.okhttp3.internal.connection.StreamAllocation.a(int, int, int, boolean):com.sendbird.android.shadow.okhttp3.internal.connection.RealConnection
jadx.core.utils.exceptions.CodegenException: Error generate insn: ?: MERGE  (r0_7 'z5' boolean) = (r0_6 'z5' boolean), (r6_5 boolean) in method: com.sendbird.android.shadow.okhttp3.internal.connection.StreamAllocation.a(int, int, int, boolean):com.sendbird.android.shadow.okhttp3.internal.connection.RealConnection
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:226)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:203)
	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:100)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:50)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:297)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
	at jadx.core.codegen.RegionGen.makeSynchronizedRegion(RegionGen.java:227)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:183)
	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:328)
	at jadx.core.codegen.ClassGen.addMethods(ClassGen.java:265)
	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:228)
	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:118)
	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:83)
	at jadx.core.codegen.CodeGen.visit(CodeGen.java:19)
	at jadx.core.ProcessClass.process(ProcessClass.java:43)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
Caused by: jadx.core.utils.exceptions.CodegenException: MERGE can be used only in fallback mode
	at jadx.core.codegen.InsnGen.fallbackOnlyInsn(InsnGen.java:530)
	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:514)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
	... 28 more

*/

                public final void m25412a(boolean z, HttpCodec httpCodec, IOException iOException) {
                    RealConnection realConnection;
                    Socket a;
                    EventListener.m25254r();
                    synchronized (this.f23410d) {
                        if (httpCodec != null) {
                            if (httpCodec == this.f23416j) {
                                if (!z) {
                                    realConnection = this.f23414h;
                                    realConnection.f30399i++;
                                }
                                realConnection = this.f23414h;
                                a = m25409a(z, false, true);
                                if (this.f23414h != null) {
                                    realConnection = null;
                                }
                                httpCodec = this.f23420o;
                            }
                        }
                        iOException = new StringBuilder("expected ");
                        iOException.append(this.f23416j);
                        iOException.append(" but was ");
                        iOException.append(httpCodec);
                        throw new IllegalStateException(iOException.toString());
                    }
                    Util.m25367a(a);
                    if (realConnection != null) {
                        EventListener.m25246j();
                    }
                    if (iOException != null) {
                        EventListener.m25256t();
                        return;
                    }
                    if (httpCodec != null) {
                        EventListener.m25255s();
                    }
                }

                public final HttpCodec m25407a() {
                    HttpCodec httpCodec;
                    synchronized (this.f23410d) {
                        httpCodec = this.f23416j;
                    }
                    return httpCodec;
                }

                private RouteDatabase m25406e() {
                    return Internal.instance.routeDatabase(this.f23410d);
                }

                public final synchronized RealConnection m25413b() {
                    return this.f23414h;
                }

                public final void m25414c() {
                    Socket a;
                    synchronized (this.f23410d) {
                        RealConnection realConnection = this.f23414h;
                        a = m25409a(false, true, false);
                        if (this.f23414h != null) {
                            realConnection = null;
                        }
                    }
                    Util.m25367a(a);
                    if (realConnection != null) {
                        EventListener.m25246j();
                    }
                }

                public final void m25415d() {
                    Socket a;
                    synchronized (this.f23410d) {
                        RealConnection realConnection = this.f23414h;
                        a = m25409a(true, false, false);
                        if (this.f23414h != null) {
                            realConnection = null;
                        }
                    }
                    Util.m25367a(a);
                    if (realConnection != null) {
                        EventListener.m25246j();
                    }
                }

                public final Socket m25409a(boolean z, boolean z2, boolean z3) {
                    if (f23406k || Thread.holdsLock(this.f23410d)) {
                        if (z3) {
                            this.f23416j = null;
                        }
                        if (z2) {
                            this.f23420o = true;
                        }
                        if (this.f23414h) {
                            if (z) {
                                this.f23414h.f30398h = true;
                            }
                            if (!this.f23416j && (this.f23420o || this.f23414h.f30398h)) {
                                m25405a(this.f23414h);
                                if (this.f23414h.f30401k.isEmpty()) {
                                    this.f23414h.f30402l = System.nanoTime();
                                    if (Internal.instance.connectionBecameIdle(this.f23410d, this.f23414h)) {
                                        z = this.f23414h.f30393c;
                                        this.f23414h = null;
                                        return z;
                                    }
                                }
                                z = false;
                                this.f23414h = null;
                                return z;
                            }
                        }
                        return false;
                    }
                    throw new AssertionError();
                }

                public final void m25411a(IOException iOException) {
                    RealConnection realConnection;
                    Socket a;
                    synchronized (this.f23410d) {
                        boolean z;
                        if (iOException instanceof StreamResetException) {
                            StreamResetException streamResetException = (StreamResetException) iOException;
                            if (streamResetException.f23537a == ErrorCode.REFUSED_STREAM) {
                                this.f23418m++;
                            }
                            if (streamResetException.f23537a != ErrorCode.REFUSED_STREAM || this.f23418m > 1) {
                                this.f23409c = null;
                            }
                            z = null;
                            realConnection = this.f23414h;
                            a = m25409a(z, false, true);
                            if (!(this.f23414h == null && this.f23419n)) {
                                realConnection = null;
                            }
                        } else {
                            if (this.f23414h != null && (!this.f23414h.m31368b() || (iOException instanceof ConnectionShutdownException))) {
                                if (this.f23414h.f30399i == 0) {
                                    if (!(this.f23409c == null || iOException == null)) {
                                        RouteSelector routeSelector = this.f23413g;
                                        Route route = this.f23409c;
                                        if (!(route.f23322b.type() == Type.DIRECT || routeSelector.f23397a.f23043g == null)) {
                                            routeSelector.f23397a.f23043g.connectFailed(routeSelector.f23397a.f23037a.m25292a(), route.f23322b.address(), iOException);
                                        }
                                        routeSelector.f23398b.m25394a(route);
                                    }
                                    this.f23409c = null;
                                }
                            }
                            z = null;
                            realConnection = this.f23414h;
                            a = m25409a(z, false, true);
                            realConnection = null;
                        }
                        z = 1;
                        realConnection = this.f23414h;
                        a = m25409a(z, false, true);
                        realConnection = null;
                    }
                    Util.m25367a(a);
                    if (realConnection != null) {
                        EventListener.m25246j();
                    }
                }

                public final void m25410a(RealConnection realConnection, boolean z) {
                    if (!f23406k && !Thread.holdsLock(this.f23410d)) {
                        throw new AssertionError();
                    } else if (this.f23414h != null) {
                        throw new IllegalStateException();
                    } else {
                        this.f23414h = realConnection;
                        this.f23419n = z;
                        realConnection.f30401k.add(new StreamAllocationReference(this, this.f23417l));
                    }
                }

                private void m25405a(RealConnection realConnection) {
                    int size = realConnection.f30401k.size();
                    for (int i = 0; i < size; i++) {
                        if (((Reference) realConnection.f30401k.get(i)).get() == this) {
                            realConnection.f30401k.remove(i);
                            return;
                        }
                    }
                    throw new IllegalStateException();
                }

                public final String toString() {
                    RealConnection b = m25413b();
                    return b != null ? b.toString() : this.f23407a.toString();
                }
            }
