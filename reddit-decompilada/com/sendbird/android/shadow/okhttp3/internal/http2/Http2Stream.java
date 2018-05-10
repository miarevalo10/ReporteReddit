package com.sendbird.android.shadow.okhttp3.internal.http2;

import com.sendbird.android.shadow.okio.AsyncTimeout;
import com.sendbird.android.shadow.okio.Buffer;
import com.sendbird.android.shadow.okio.BufferedSource;
import com.sendbird.android.shadow.okio.Sink;
import com.sendbird.android.shadow.okio.Source;
import com.sendbird.android.shadow.okio.Timeout;
import java.io.EOFException;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.List;

public final class Http2Stream {
    static final /* synthetic */ boolean f23504l = true;
    long f23505a = 0;
    long f23506b;
    final int f23507c;
    final Http2Connection f23508d;
    List<Header> f23509e;
    boolean f23510f;
    final FramingSource f23511g;
    final FramingSink f23512h;
    final StreamTimeout f23513i = new StreamTimeout(this);
    final StreamTimeout f23514j = new StreamTimeout(this);
    ErrorCode f23515k = null;
    private final List<Header> f23516m;

    final class FramingSink implements Sink {
        static final /* synthetic */ boolean f30498c = true;
        boolean f30499a;
        boolean f30500b;
        final /* synthetic */ Http2Stream f30501d;
        private final Buffer f30502e = new Buffer();

        static {
            Class cls = Http2Stream.class;
        }

        FramingSink(Http2Stream http2Stream) {
            this.f30501d = http2Stream;
        }

        public final void a_(Buffer buffer, long j) throws IOException {
            if (f30498c || !Thread.holdsLock(this.f30501d)) {
                this.f30502e.a_(buffer, j);
                while (this.f30502e.f34625b >= 16384) {
                    m31430a(null);
                }
                return;
            }
            throw new AssertionError();
        }

        private void m31430a(boolean z) throws IOException {
            synchronized (this.f30501d) {
                this.f30501d.f23514j.at_();
                while (this.f30501d.f23506b <= 0 && !this.f30500b && !this.f30499a && this.f30501d.f23515k == null) {
                    try {
                        this.f30501d.m25505h();
                    } finally {
                        this.f30501d.f23514j.m35445b();
                    }
                }
                this.f30501d.m25504g();
                long min = Math.min(this.f30501d.f23506b, this.f30502e.f34625b);
                Http2Stream http2Stream = this.f30501d;
                http2Stream.f23506b -= min;
            }
            this.f30501d.f23514j.at_();
            try {
                Http2Connection http2Connection = this.f30501d.f23508d;
                int i = this.f30501d.f23507c;
                z = z && min == this.f30502e.f34625b;
                http2Connection.m25474a(i, z, this.f30502e, min);
            } finally {
                this.f30501d.f23514j.m35445b();
            }
        }

        public final void flush() throws IOException {
            if (f30498c || !Thread.holdsLock(this.f30501d)) {
                synchronized (this.f30501d) {
                    this.f30501d.m25504g();
                }
                while (this.f30502e.f34625b > 0) {
                    m31430a(false);
                    this.f30501d.f23508d.f23494q.m25516b();
                }
                return;
            }
            throw new AssertionError();
        }

        public final Timeout mo5334a() {
            return this.f30501d.f23514j;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void close() throws java.io.IOException {
            /*
            r8 = this;
            r0 = f30498c;
            if (r0 != 0) goto L_0x0012;
        L_0x0004:
            r0 = r8.f30501d;
            r0 = java.lang.Thread.holdsLock(r0);
            if (r0 == 0) goto L_0x0012;
        L_0x000c:
            r0 = new java.lang.AssertionError;
            r0.<init>();
            throw r0;
        L_0x0012:
            r0 = r8.f30501d;
            monitor-enter(r0);
            r1 = r8.f30499a;	 Catch:{ all -> 0x0062 }
            if (r1 == 0) goto L_0x001b;
        L_0x0019:
            monitor-exit(r0);	 Catch:{ all -> 0x0062 }
            return;
        L_0x001b:
            monitor-exit(r0);	 Catch:{ all -> 0x0062 }
            r0 = r8.f30501d;
            r0 = r0.f23512h;
            r0 = r0.f30500b;
            r1 = 1;
            if (r0 != 0) goto L_0x004a;
        L_0x0025:
            r0 = r8.f30502e;
            r2 = r0.f34625b;
            r4 = 0;
            r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
            if (r0 <= 0) goto L_0x003b;
        L_0x002f:
            r0 = r8.f30502e;
            r2 = r0.f34625b;
            r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
            if (r0 <= 0) goto L_0x004a;
        L_0x0037:
            r8.m31430a(r1);
            goto L_0x002f;
        L_0x003b:
            r0 = r8.f30501d;
            r2 = r0.f23508d;
            r0 = r8.f30501d;
            r3 = r0.f23507c;
            r4 = 1;
            r5 = 0;
            r6 = 0;
            r2.m25474a(r3, r4, r5, r6);
        L_0x004a:
            r2 = r8.f30501d;
            monitor-enter(r2);
            r8.f30499a = r1;	 Catch:{ all -> 0x005f }
            monitor-exit(r2);	 Catch:{ all -> 0x005f }
            r0 = r8.f30501d;
            r0 = r0.f23508d;
            r0 = r0.f23494q;
            r0.m25516b();
            r0 = r8.f30501d;
            r0.m25503f();
            return;
        L_0x005f:
            r0 = move-exception;
            monitor-exit(r2);	 Catch:{ all -> 0x005f }
            throw r0;
        L_0x0062:
            r1 = move-exception;
            monitor-exit(r0);	 Catch:{ all -> 0x0062 }
            throw r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.okhttp3.internal.http2.Http2Stream.FramingSink.close():void");
        }
    }

    private final class FramingSource implements Source {
        static final /* synthetic */ boolean f30503c = true;
        boolean f30504a;
        boolean f30505b;
        final /* synthetic */ Http2Stream f30506d;
        private final Buffer f30507e = new Buffer();
        private final Buffer f30508f = new Buffer();
        private final long f30509g;

        static {
            Class cls = Http2Stream.class;
        }

        FramingSource(Http2Stream http2Stream, long j) {
            this.f30506d = http2Stream;
            this.f30509g = j;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final long mo5322a(com.sendbird.android.shadow.okio.Buffer r8, long r9) throws java.io.IOException {
            /*
            r7 = this;
            r0 = 0;
            r2 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1));
            if (r2 >= 0) goto L_0x001a;
        L_0x0006:
            r8 = new java.lang.IllegalArgumentException;
            r0 = new java.lang.StringBuilder;
            r1 = "byteCount < 0: ";
            r0.<init>(r1);
            r0.append(r9);
            r9 = r0.toString();
            r8.<init>(r9);
            throw r8;
        L_0x001a:
            r2 = r7.f30506d;
            monitor-enter(r2);
            r7.m31432b();	 Catch:{ all -> 0x00c4 }
            r3 = r7.f30504a;	 Catch:{ all -> 0x00c4 }
            if (r3 == 0) goto L_0x002c;
        L_0x0024:
            r8 = new java.io.IOException;	 Catch:{ all -> 0x00c4 }
            r9 = "stream closed";
            r8.<init>(r9);	 Catch:{ all -> 0x00c4 }
            throw r8;	 Catch:{ all -> 0x00c4 }
        L_0x002c:
            r3 = r7.f30506d;	 Catch:{ all -> 0x00c4 }
            r3 = r3.f23515k;	 Catch:{ all -> 0x00c4 }
            if (r3 == 0) goto L_0x003c;
        L_0x0032:
            r8 = new com.sendbird.android.shadow.okhttp3.internal.http2.StreamResetException;	 Catch:{ all -> 0x00c4 }
            r9 = r7.f30506d;	 Catch:{ all -> 0x00c4 }
            r9 = r9.f23515k;	 Catch:{ all -> 0x00c4 }
            r8.<init>(r9);	 Catch:{ all -> 0x00c4 }
            throw r8;	 Catch:{ all -> 0x00c4 }
        L_0x003c:
            r3 = r7.f30508f;	 Catch:{ all -> 0x00c4 }
            r3 = r3.f34625b;	 Catch:{ all -> 0x00c4 }
            r3 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1));
            if (r3 != 0) goto L_0x0048;
        L_0x0044:
            r8 = -1;
            monitor-exit(r2);	 Catch:{ all -> 0x00c4 }
            return r8;
        L_0x0048:
            r3 = r7.f30508f;	 Catch:{ all -> 0x00c4 }
            r4 = r7.f30508f;	 Catch:{ all -> 0x00c4 }
            r4 = r4.f34625b;	 Catch:{ all -> 0x00c4 }
            r9 = java.lang.Math.min(r9, r4);	 Catch:{ all -> 0x00c4 }
            r8 = r3.mo5322a(r8, r9);	 Catch:{ all -> 0x00c4 }
            r10 = r7.f30506d;	 Catch:{ all -> 0x00c4 }
            r3 = r10.f23505a;	 Catch:{ all -> 0x00c4 }
            r3 = r3 + r8;
            r10.f23505a = r3;	 Catch:{ all -> 0x00c4 }
            r10 = r7.f30506d;	 Catch:{ all -> 0x00c4 }
            r3 = r10.f23505a;	 Catch:{ all -> 0x00c4 }
            r10 = r7.f30506d;	 Catch:{ all -> 0x00c4 }
            r10 = r10.f23508d;	 Catch:{ all -> 0x00c4 }
            r10 = r10.f23490m;	 Catch:{ all -> 0x00c4 }
            r10 = r10.m25529b();	 Catch:{ all -> 0x00c4 }
            r10 = r10 / 2;
            r5 = (long) r10;	 Catch:{ all -> 0x00c4 }
            r10 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1));
            if (r10 < 0) goto L_0x0085;
        L_0x0072:
            r10 = r7.f30506d;	 Catch:{ all -> 0x00c4 }
            r10 = r10.f23508d;	 Catch:{ all -> 0x00c4 }
            r3 = r7.f30506d;	 Catch:{ all -> 0x00c4 }
            r3 = r3.f23507c;	 Catch:{ all -> 0x00c4 }
            r4 = r7.f30506d;	 Catch:{ all -> 0x00c4 }
            r4 = r4.f23505a;	 Catch:{ all -> 0x00c4 }
            r10.m25472a(r3, r4);	 Catch:{ all -> 0x00c4 }
            r10 = r7.f30506d;	 Catch:{ all -> 0x00c4 }
            r10.f23505a = r0;	 Catch:{ all -> 0x00c4 }
        L_0x0085:
            monitor-exit(r2);	 Catch:{ all -> 0x00c4 }
            r10 = r7.f30506d;
            r10 = r10.f23508d;
            monitor-enter(r10);
            r2 = r7.f30506d;	 Catch:{ all -> 0x00c1 }
            r2 = r2.f23508d;	 Catch:{ all -> 0x00c1 }
            r3 = r2.f23488k;	 Catch:{ all -> 0x00c1 }
            r3 = r3 + r8;
            r2.f23488k = r3;	 Catch:{ all -> 0x00c1 }
            r2 = r7.f30506d;	 Catch:{ all -> 0x00c1 }
            r2 = r2.f23508d;	 Catch:{ all -> 0x00c1 }
            r2 = r2.f23488k;	 Catch:{ all -> 0x00c1 }
            r4 = r7.f30506d;	 Catch:{ all -> 0x00c1 }
            r4 = r4.f23508d;	 Catch:{ all -> 0x00c1 }
            r4 = r4.f23490m;	 Catch:{ all -> 0x00c1 }
            r4 = r4.m25529b();	 Catch:{ all -> 0x00c1 }
            r4 = r4 / 2;
            r4 = (long) r4;	 Catch:{ all -> 0x00c1 }
            r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
            if (r2 < 0) goto L_0x00bf;
        L_0x00ab:
            r2 = r7.f30506d;	 Catch:{ all -> 0x00c1 }
            r2 = r2.f23508d;	 Catch:{ all -> 0x00c1 }
            r3 = 0;
            r4 = r7.f30506d;	 Catch:{ all -> 0x00c1 }
            r4 = r4.f23508d;	 Catch:{ all -> 0x00c1 }
            r4 = r4.f23488k;	 Catch:{ all -> 0x00c1 }
            r2.m25472a(r3, r4);	 Catch:{ all -> 0x00c1 }
            r2 = r7.f30506d;	 Catch:{ all -> 0x00c1 }
            r2 = r2.f23508d;	 Catch:{ all -> 0x00c1 }
            r2.f23488k = r0;	 Catch:{ all -> 0x00c1 }
        L_0x00bf:
            monitor-exit(r10);	 Catch:{ all -> 0x00c1 }
            return r8;
        L_0x00c1:
            r8 = move-exception;
            monitor-exit(r10);	 Catch:{ all -> 0x00c1 }
            throw r8;
        L_0x00c4:
            r8 = move-exception;
            monitor-exit(r2);	 Catch:{ all -> 0x00c4 }
            throw r8;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.okhttp3.internal.http2.Http2Stream.FramingSource.a(com.sendbird.android.shadow.okio.Buffer, long):long");
        }

        private void m31432b() throws IOException {
            this.f30506d.f23513i.at_();
            while (this.f30508f.f34625b == 0 && !this.f30505b && !this.f30504a && this.f30506d.f23515k == null) {
                try {
                    this.f30506d.m25505h();
                } catch (Throwable th) {
                    this.f30506d.f23513i.m35445b();
                }
            }
            this.f30506d.f23513i.m35445b();
        }

        final void m31435a(BufferedSource bufferedSource, long j) throws IOException {
            if (f30503c || !Thread.holdsLock(this.f30506d)) {
                while (j > 0) {
                    boolean z;
                    Object obj;
                    Object obj2;
                    synchronized (this.f30506d) {
                        z = this.f30505b;
                        obj = null;
                        obj2 = this.f30508f.f34625b + j > this.f30509g ? 1 : null;
                    }
                    if (obj2 != null) {
                        bufferedSource.mo6568g(j);
                        this.f30506d.m25497b(ErrorCode.FLOW_CONTROL_ERROR);
                        return;
                    } else if (z) {
                        bufferedSource.mo6568g(j);
                        return;
                    } else {
                        long a = bufferedSource.mo5322a(this.f30507e, j);
                        if (a == -1) {
                            throw new EOFException();
                        }
                        j -= a;
                        synchronized (this.f30506d) {
                            if (this.f30508f.f34625b == 0) {
                                obj = 1;
                            }
                            this.f30508f.mo6548a(this.f30507e);
                            if (obj != null) {
                                this.f30506d.notifyAll();
                            }
                        }
                    }
                }
                return;
            }
            throw new AssertionError();
        }

        public final Timeout mo5323a() {
            return this.f30506d.f23513i;
        }

        public final void close() throws IOException {
            synchronized (this.f30506d) {
                this.f30504a = true;
                this.f30508f.m35504r();
                this.f30506d.notifyAll();
            }
            this.f30506d.m25503f();
        }
    }

    class StreamTimeout extends AsyncTimeout {
        final /* synthetic */ Http2Stream f34622a;

        StreamTimeout(Http2Stream http2Stream) {
            this.f34622a = http2Stream;
        }

        protected final void mo6546a() {
            this.f34622a.m25497b(ErrorCode.CANCEL);
        }

        protected final IOException mo6545a(IOException iOException) {
            IOException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        public final void m35445b() throws IOException {
            if (au_()) {
                throw mo6545a(null);
            }
        }
    }

    Http2Stream(int i, Http2Connection http2Connection, boolean z, boolean z2, List<Header> list) {
        if (http2Connection == null) {
            throw new NullPointerException("connection == null");
        } else if (list == null) {
            throw new NullPointerException("requestHeaders == null");
        } else {
            this.f23507c = i;
            this.f23508d = http2Connection;
            this.f23506b = (long) http2Connection.f23491n.m25529b();
            this.f23511g = new FramingSource(this, (long) http2Connection.f23490m.m25529b());
            this.f23512h = new FramingSink(this);
            this.f23511g.f30505b = z2;
            this.f23512h.f30500b = z;
            this.f23516m = list;
        }
    }

    public final synchronized boolean m25496a() {
        if (this.f23515k != null) {
            return false;
        }
        if ((this.f23511g.f30505b || this.f23511g.f30504a) && ((this.f23512h.f30500b || this.f23512h.f30499a) && this.f23510f)) {
            return false;
        }
        return true;
    }

    public final boolean m25498b() {
        return this.f23508d.f23479b == ((this.f23507c & 1) == 1);
    }

    public final synchronized List<Header> m25499c() throws IOException {
        List<Header> list;
        if (m25498b()) {
            this.f23513i.at_();
            while (this.f23509e == null && this.f23515k == null) {
                try {
                    m25505h();
                } finally {
                    this.f23513i.m35445b();
                }
            }
            list = this.f23509e;
            if (list != null) {
                this.f23509e = null;
            } else {
                throw new StreamResetException(this.f23515k);
            }
        }
        throw new IllegalStateException("servers cannot read response headers");
        return list;
    }

    public final Sink m25501d() {
        synchronized (this) {
            if (this.f23510f || m25498b()) {
            } else {
                throw new IllegalStateException("reply before requesting the sink");
            }
        }
        return this.f23512h;
    }

    public final void m25495a(ErrorCode errorCode) throws IOException {
        if (m25493d(errorCode)) {
            this.f23508d.m25477b(this.f23507c, errorCode);
        }
    }

    public final void m25497b(ErrorCode errorCode) {
        if (m25493d(errorCode)) {
            this.f23508d.m25473a(this.f23507c, errorCode);
        }
    }

    private boolean m25493d(ErrorCode errorCode) {
        if (f23504l || !Thread.holdsLock(this)) {
            synchronized (this) {
                if (this.f23515k != null) {
                    return false;
                } else if (this.f23511g.f30505b && this.f23512h.f30500b) {
                    return false;
                } else {
                    this.f23515k = errorCode;
                    notifyAll();
                    this.f23508d.m25476b(this.f23507c);
                    return true;
                }
            }
        }
        throw new AssertionError();
    }

    final void m25502e() {
        if (f23504l || !Thread.holdsLock(this)) {
            boolean a;
            synchronized (this) {
                this.f23511g.f30505b = true;
                a = m25496a();
                notifyAll();
            }
            if (!a) {
                this.f23508d.m25476b(this.f23507c);
                return;
            }
            return;
        }
        throw new AssertionError();
    }

    final synchronized void m25500c(ErrorCode errorCode) {
        if (this.f23515k == null) {
            this.f23515k = errorCode;
            notifyAll();
        }
    }

    final void m25503f() throws IOException {
        if (f23504l || !Thread.holdsLock(this)) {
            Object obj;
            boolean a;
            synchronized (this) {
                obj = (!this.f23511g.f30505b && this.f23511g.f30504a && (this.f23512h.f30500b || this.f23512h.f30499a)) ? 1 : null;
                a = m25496a();
            }
            if (obj != null) {
                m25495a(ErrorCode.CANCEL);
                return;
            }
            if (!a) {
                this.f23508d.m25476b(this.f23507c);
            }
            return;
        }
        throw new AssertionError();
    }

    final void m25494a(long j) {
        this.f23506b += j;
        if (j > 0) {
            notifyAll();
        }
    }

    final void m25504g() throws IOException {
        if (this.f23512h.f30499a) {
            throw new IOException("stream closed");
        } else if (this.f23512h.f30500b) {
            throw new IOException("stream finished");
        } else if (this.f23515k != null) {
            throw new StreamResetException(this.f23515k);
        }
    }

    final void m25505h() throws java.io.InterruptedIOException {
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
        r1 = this;
        r1.wait();	 Catch:{ InterruptedException -> 0x0004 }
        return;
    L_0x0004:
        r0 = new java.io.InterruptedIOException;
        r0.<init>();
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.okhttp3.internal.http2.Http2Stream.h():void");
    }
}
