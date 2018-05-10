package com.sendbird.android.shadow.okhttp3.internal.http2;

import com.reddit.datalibrary.frontpage.job.RedditJobManager;
import com.sendbird.android.shadow.okhttp3.internal.NamedRunnable;
import com.sendbird.android.shadow.okhttp3.internal.Util;
import com.sendbird.android.shadow.okio.Buffer;
import com.sendbird.android.shadow.okio.BufferedSink;
import com.sendbird.android.shadow.okio.BufferedSource;
import com.sendbird.android.shadow.okio.ByteString;
import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class Http2Connection implements Closeable {
    static final ExecutorService f23477a = new ThreadPoolExecutor(0, RedditJobManager.f10810d, 60, TimeUnit.SECONDS, new SynchronousQueue(), Util.m25364a("OkHttp Http2Connection", true));
    static final /* synthetic */ boolean f23478t = true;
    final boolean f23479b;
    final Listener f23480c;
    final Map<Integer, Http2Stream> f23481d = new LinkedHashMap();
    final String f23482e;
    int f23483f;
    int f23484g;
    boolean f23485h;
    final ExecutorService f23486i;
    final PushObserver f23487j;
    long f23488k = 0;
    long f23489l;
    public Settings f23490m = new Settings();
    final Settings f23491n = new Settings();
    boolean f23492o = false;
    final Socket f23493p;
    public final Http2Writer f23494q;
    public final ReaderRunnable f23495r;
    final Set<Integer> f23496s = new LinkedHashSet();
    private Map<Integer, Ping> f23497u;
    private int f23498v;

    public static class Builder {
        public Socket f23469a;
        public String f23470b;
        public BufferedSource f23471c;
        public BufferedSink f23472d;
        public Listener f23473e = Listener.f23476m;
        PushObserver f23474f = PushObserver.f23534a;
        boolean f23475g = true;
    }

    public static abstract class Listener {
        public static final Listener f23476m = new C24801();

        class C24801 extends Listener {
            C24801() {
            }

            public final void mo5328a(Http2Stream http2Stream) throws IOException {
                http2Stream.m25495a(ErrorCode.REFUSED_STREAM);
            }
        }

        public void mo5327a(Http2Connection http2Connection) {
        }

        public abstract void mo5328a(Http2Stream http2Stream) throws IOException;
    }

    class C24753 extends NamedRunnable {
        final /* synthetic */ boolean f30465a = true;
        final /* synthetic */ int f30466c;
        final /* synthetic */ int f30467d;
        final /* synthetic */ Ping f30468e;
        final /* synthetic */ Http2Connection f30469f;

        C24753(Http2Connection http2Connection, String str, Object[] objArr, int i, int i2) {
            this.f30469f = http2Connection;
            this.f30466c = i;
            this.f30467d = i2;
            this.f30468e = null;
            super(str, objArr);
        }

        public final void mo5317b() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r10 = this;
            r0 = r10.f30469f;	 Catch:{ IOException -> 0x002f }
            r1 = r10.f30465a;	 Catch:{ IOException -> 0x002f }
            r2 = r10.f30466c;	 Catch:{ IOException -> 0x002f }
            r3 = r10.f30467d;	 Catch:{ IOException -> 0x002f }
            r4 = r10.f30468e;	 Catch:{ IOException -> 0x002f }
            r5 = r0.f23494q;	 Catch:{ IOException -> 0x002f }
            monitor-enter(r5);	 Catch:{ IOException -> 0x002f }
            if (r4 == 0) goto L_0x0026;
        L_0x000f:
            r6 = r4.f23532b;	 Catch:{ all -> 0x0024 }
            r8 = -1;	 Catch:{ all -> 0x0024 }
            r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));	 Catch:{ all -> 0x0024 }
            if (r6 == 0) goto L_0x001d;	 Catch:{ all -> 0x0024 }
        L_0x0017:
            r0 = new java.lang.IllegalStateException;	 Catch:{ all -> 0x0024 }
            r0.<init>();	 Catch:{ all -> 0x0024 }
            throw r0;	 Catch:{ all -> 0x0024 }
        L_0x001d:
            r6 = java.lang.System.nanoTime();	 Catch:{ all -> 0x0024 }
            r4.f23532b = r6;	 Catch:{ all -> 0x0024 }
            goto L_0x0026;	 Catch:{ all -> 0x0024 }
        L_0x0024:
            r0 = move-exception;	 Catch:{ all -> 0x0024 }
            goto L_0x002d;	 Catch:{ all -> 0x0024 }
        L_0x0026:
            r0 = r0.f23494q;	 Catch:{ all -> 0x0024 }
            r0.m25513a(r1, r2, r3);	 Catch:{ all -> 0x0024 }
            monitor-exit(r5);	 Catch:{ all -> 0x0024 }
            return;	 Catch:{ all -> 0x0024 }
        L_0x002d:
            monitor-exit(r5);	 Catch:{ all -> 0x0024 }
            throw r0;	 Catch:{ IOException -> 0x002f }
        L_0x002f:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.okhttp3.internal.http2.Http2Connection.3.b():void");
        }
    }

    class C24764 extends NamedRunnable {
        final /* synthetic */ int f30470a;
        final /* synthetic */ List f30471c;
        final /* synthetic */ Http2Connection f30472d;

        C24764(Http2Connection http2Connection, String str, Object[] objArr, int i, List list) {
            this.f30472d = http2Connection;
            this.f30470a = i;
            this.f30471c = list;
            super(str, objArr);
        }

        public final void mo5317b() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r3 = this;
            r0 = r3.f30472d;
            r0 = r0.f23487j;
            r0.mo5353a();
            r0 = r3.f30472d;	 Catch:{ IOException -> 0x0027 }
            r0 = r0.f23494q;	 Catch:{ IOException -> 0x0027 }
            r1 = r3.f30470a;	 Catch:{ IOException -> 0x0027 }
            r2 = com.sendbird.android.shadow.okhttp3.internal.http2.ErrorCode.CANCEL;	 Catch:{ IOException -> 0x0027 }
            r0.m25510a(r1, r2);	 Catch:{ IOException -> 0x0027 }
            r0 = r3.f30472d;	 Catch:{ IOException -> 0x0027 }
            monitor-enter(r0);	 Catch:{ IOException -> 0x0027 }
            r1 = r3.f30472d;	 Catch:{ all -> 0x0024 }
            r1 = r1.f23496s;	 Catch:{ all -> 0x0024 }
            r2 = r3.f30470a;	 Catch:{ all -> 0x0024 }
            r2 = java.lang.Integer.valueOf(r2);	 Catch:{ all -> 0x0024 }
            r1.remove(r2);	 Catch:{ all -> 0x0024 }
            monitor-exit(r0);	 Catch:{ all -> 0x0024 }
            return;	 Catch:{ all -> 0x0024 }
        L_0x0024:
            r1 = move-exception;	 Catch:{ all -> 0x0024 }
            monitor-exit(r0);	 Catch:{ all -> 0x0024 }
            throw r1;	 Catch:{ IOException -> 0x0027 }
        L_0x0027:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.okhttp3.internal.http2.Http2Connection.4.b():void");
        }
    }

    class C24775 extends NamedRunnable {
        final /* synthetic */ int f30473a;
        final /* synthetic */ List f30474c;
        final /* synthetic */ boolean f30475d;
        final /* synthetic */ Http2Connection f30476e;

        C24775(Http2Connection http2Connection, String str, Object[] objArr, int i, List list, boolean z) {
            this.f30476e = http2Connection;
            this.f30473a = i;
            this.f30474c = list;
            this.f30475d = z;
            super(str, objArr);
        }

        public final void mo5317b() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r3 = this;
            r0 = r3.f30476e;
            r0 = r0.f23487j;
            r0.mo5355b();
            r0 = r3.f30476e;	 Catch:{ IOException -> 0x0027 }
            r0 = r0.f23494q;	 Catch:{ IOException -> 0x0027 }
            r1 = r3.f30473a;	 Catch:{ IOException -> 0x0027 }
            r2 = com.sendbird.android.shadow.okhttp3.internal.http2.ErrorCode.CANCEL;	 Catch:{ IOException -> 0x0027 }
            r0.m25510a(r1, r2);	 Catch:{ IOException -> 0x0027 }
            r0 = r3.f30476e;	 Catch:{ IOException -> 0x0027 }
            monitor-enter(r0);	 Catch:{ IOException -> 0x0027 }
            r1 = r3.f30476e;	 Catch:{ all -> 0x0024 }
            r1 = r1.f23496s;	 Catch:{ all -> 0x0024 }
            r2 = r3.f30473a;	 Catch:{ all -> 0x0024 }
            r2 = java.lang.Integer.valueOf(r2);	 Catch:{ all -> 0x0024 }
            r1.remove(r2);	 Catch:{ all -> 0x0024 }
            monitor-exit(r0);	 Catch:{ all -> 0x0024 }
            return;	 Catch:{ all -> 0x0024 }
        L_0x0024:
            r1 = move-exception;	 Catch:{ all -> 0x0024 }
            monitor-exit(r0);	 Catch:{ all -> 0x0024 }
            throw r1;	 Catch:{ IOException -> 0x0027 }
        L_0x0027:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.okhttp3.internal.http2.Http2Connection.5.b():void");
        }
    }

    class C24786 extends NamedRunnable {
        final /* synthetic */ int f30477a;
        final /* synthetic */ Buffer f30478c;
        final /* synthetic */ int f30479d;
        final /* synthetic */ boolean f30480e;
        final /* synthetic */ Http2Connection f30481f;

        C24786(Http2Connection http2Connection, String str, Object[] objArr, int i, Buffer buffer, int i2, boolean z) {
            this.f30481f = http2Connection;
            this.f30477a = i;
            this.f30478c = buffer;
            this.f30479d = i2;
            this.f30480e = z;
            super(str, objArr);
        }

        public final void mo5317b() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r3 = this;
            r0 = r3.f30481f;	 Catch:{ IOException -> 0x002b }
            r0 = r0.f23487j;	 Catch:{ IOException -> 0x002b }
            r1 = r3.f30478c;	 Catch:{ IOException -> 0x002b }
            r2 = r3.f30479d;	 Catch:{ IOException -> 0x002b }
            r0.mo5354a(r1, r2);	 Catch:{ IOException -> 0x002b }
            r0 = r3.f30481f;	 Catch:{ IOException -> 0x002b }
            r0 = r0.f23494q;	 Catch:{ IOException -> 0x002b }
            r1 = r3.f30477a;	 Catch:{ IOException -> 0x002b }
            r2 = com.sendbird.android.shadow.okhttp3.internal.http2.ErrorCode.CANCEL;	 Catch:{ IOException -> 0x002b }
            r0.m25510a(r1, r2);	 Catch:{ IOException -> 0x002b }
            r0 = r3.f30481f;	 Catch:{ IOException -> 0x002b }
            monitor-enter(r0);	 Catch:{ IOException -> 0x002b }
            r1 = r3.f30481f;	 Catch:{ all -> 0x0028 }
            r1 = r1.f23496s;	 Catch:{ all -> 0x0028 }
            r2 = r3.f30477a;	 Catch:{ all -> 0x0028 }
            r2 = java.lang.Integer.valueOf(r2);	 Catch:{ all -> 0x0028 }
            r1.remove(r2);	 Catch:{ all -> 0x0028 }
            monitor-exit(r0);	 Catch:{ all -> 0x0028 }
            return;	 Catch:{ all -> 0x0028 }
        L_0x0028:
            r1 = move-exception;	 Catch:{ all -> 0x0028 }
            monitor-exit(r0);	 Catch:{ all -> 0x0028 }
            throw r1;	 Catch:{ IOException -> 0x002b }
        L_0x002b:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.okhttp3.internal.http2.Http2Connection.6.b():void");
        }
    }

    class C24797 extends NamedRunnable {
        final /* synthetic */ int f30482a;
        final /* synthetic */ ErrorCode f30483c;
        final /* synthetic */ Http2Connection f30484d;

        C24797(Http2Connection http2Connection, String str, Object[] objArr, int i, ErrorCode errorCode) {
            this.f30484d = http2Connection;
            this.f30482a = i;
            this.f30483c = errorCode;
            super(str, objArr);
        }

        public final void mo5317b() {
            this.f30484d.f23487j.mo5356c();
            synchronized (this.f30484d) {
                this.f30484d.f23496s.remove(Integer.valueOf(this.f30482a));
            }
        }
    }

    class ReaderRunnable extends NamedRunnable implements Handler {
        final Http2Reader f30490a;
        final /* synthetic */ Http2Connection f30491c;

        ReaderRunnable(Http2Connection http2Connection, Http2Reader http2Reader) {
            this.f30491c = http2Connection;
            super("OkHttp %s", http2Connection.f23482e);
            this.f30490a = http2Reader;
        }

        protected final void mo5317b() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r10 = this;
            r0 = com.sendbird.android.shadow.okhttp3.internal.http2.ErrorCode.INTERNAL_ERROR;
            r1 = com.sendbird.android.shadow.okhttp3.internal.http2.ErrorCode.INTERNAL_ERROR;
            r2 = r10.f30490a;	 Catch:{ IOException -> 0x0077 }
            r3 = r2.f23501c;	 Catch:{ IOException -> 0x0077 }
            r4 = 1;	 Catch:{ IOException -> 0x0077 }
            r5 = 0;	 Catch:{ IOException -> 0x0077 }
            if (r3 == 0) goto L_0x001b;	 Catch:{ IOException -> 0x0077 }
        L_0x000c:
            r2 = r2.m25492a(r4, r10);	 Catch:{ IOException -> 0x0077 }
            if (r2 != 0) goto L_0x005c;	 Catch:{ IOException -> 0x0077 }
        L_0x0012:
            r2 = "Required SETTINGS preface not received";	 Catch:{ IOException -> 0x0077 }
            r3 = new java.lang.Object[r5];	 Catch:{ IOException -> 0x0077 }
            r2 = com.sendbird.android.shadow.okhttp3.internal.http2.Http2.m25465b(r2, r3);	 Catch:{ IOException -> 0x0077 }
            throw r2;	 Catch:{ IOException -> 0x0077 }
        L_0x001b:
            r2 = r2.f23500b;	 Catch:{ IOException -> 0x0077 }
            r3 = com.sendbird.android.shadow.okhttp3.internal.http2.Http2.f23465a;	 Catch:{ IOException -> 0x0077 }
            r3 = r3.mo5405h();	 Catch:{ IOException -> 0x0077 }
            r6 = (long) r3;	 Catch:{ IOException -> 0x0077 }
            r2 = r2.mo6560c(r6);	 Catch:{ IOException -> 0x0077 }
            r3 = com.sendbird.android.shadow.okhttp3.internal.http2.Http2Reader.f23499a;	 Catch:{ IOException -> 0x0077 }
            r6 = java.util.logging.Level.FINE;	 Catch:{ IOException -> 0x0077 }
            r3 = r3.isLoggable(r6);	 Catch:{ IOException -> 0x0077 }
            if (r3 == 0) goto L_0x0045;	 Catch:{ IOException -> 0x0077 }
        L_0x0032:
            r3 = com.sendbird.android.shadow.okhttp3.internal.http2.Http2Reader.f23499a;	 Catch:{ IOException -> 0x0077 }
            r6 = "<< CONNECTION %s";	 Catch:{ IOException -> 0x0077 }
            r7 = new java.lang.Object[r4];	 Catch:{ IOException -> 0x0077 }
            r8 = r2.mo5403f();	 Catch:{ IOException -> 0x0077 }
            r7[r5] = r8;	 Catch:{ IOException -> 0x0077 }
            r6 = com.sendbird.android.shadow.okhttp3.internal.Util.m25360a(r6, r7);	 Catch:{ IOException -> 0x0077 }
            r3.fine(r6);	 Catch:{ IOException -> 0x0077 }
        L_0x0045:
            r3 = com.sendbird.android.shadow.okhttp3.internal.http2.Http2.f23465a;	 Catch:{ IOException -> 0x0077 }
            r3 = r3.equals(r2);	 Catch:{ IOException -> 0x0077 }
            if (r3 != 0) goto L_0x005c;	 Catch:{ IOException -> 0x0077 }
        L_0x004d:
            r3 = "Expected a connection header but was %s";	 Catch:{ IOException -> 0x0077 }
            r4 = new java.lang.Object[r4];	 Catch:{ IOException -> 0x0077 }
            r2 = r2.mo5394a();	 Catch:{ IOException -> 0x0077 }
            r4[r5] = r2;	 Catch:{ IOException -> 0x0077 }
            r2 = com.sendbird.android.shadow.okhttp3.internal.http2.Http2.m25465b(r3, r4);	 Catch:{ IOException -> 0x0077 }
            throw r2;	 Catch:{ IOException -> 0x0077 }
        L_0x005c:
            r2 = r10.f30490a;	 Catch:{ IOException -> 0x0077 }
            r2 = r2.m25492a(r5, r10);	 Catch:{ IOException -> 0x0077 }
            if (r2 != 0) goto L_0x005c;	 Catch:{ IOException -> 0x0077 }
        L_0x0064:
            r2 = com.sendbird.android.shadow.okhttp3.internal.http2.ErrorCode.NO_ERROR;	 Catch:{ IOException -> 0x0077 }
            r0 = com.sendbird.android.shadow.okhttp3.internal.http2.ErrorCode.CANCEL;	 Catch:{ IOException -> 0x0073 }
            r1 = r10.f30491c;	 Catch:{ IOException -> 0x006d }
        L_0x006a:
            r1.m25475a(r2, r0);	 Catch:{ IOException -> 0x006d }
        L_0x006d:
            r0 = r10.f30490a;
            com.sendbird.android.shadow.okhttp3.internal.Util.m25366a(r0);
            return;
        L_0x0073:
            r0 = r2;
            goto L_0x0077;
        L_0x0075:
            r2 = move-exception;
            goto L_0x0082;
        L_0x0077:
            r2 = com.sendbird.android.shadow.okhttp3.internal.http2.ErrorCode.PROTOCOL_ERROR;	 Catch:{ all -> 0x0075 }
            r0 = com.sendbird.android.shadow.okhttp3.internal.http2.ErrorCode.PROTOCOL_ERROR;	 Catch:{ all -> 0x007e }
            r1 = r10.f30491c;	 Catch:{ IOException -> 0x006d }
            goto L_0x006a;
        L_0x007e:
            r0 = move-exception;
            r9 = r2;
            r2 = r0;
            r0 = r9;
        L_0x0082:
            r3 = r10.f30491c;	 Catch:{ IOException -> 0x0087 }
            r3.m25475a(r0, r1);	 Catch:{ IOException -> 0x0087 }
        L_0x0087:
            r0 = r10.f30490a;
            com.sendbird.android.shadow.okhttp3.internal.Util.m25366a(r0);
            throw r2;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.okhttp3.internal.http2.Http2Connection.ReaderRunnable.b():void");
        }

        public final void mo5351a(boolean z, int i, BufferedSource bufferedSource, int i2) throws IOException {
            if (Http2Connection.m25468d(i)) {
                Http2Connection http2Connection = this.f30491c;
                Buffer buffer = new Buffer();
                long j = (long) i2;
                bufferedSource.mo6550a(j);
                bufferedSource.mo5322a(buffer, j);
                if (buffer.f34625b != j) {
                    i = new StringBuilder();
                    i.append(buffer.f34625b);
                    i.append(" != ");
                    i.append(i2);
                    throw new IOException(i.toString());
                }
                http2Connection.f23486i.execute(new C24786(http2Connection, "OkHttp %s Push Data[%s]", new Object[]{http2Connection.f23482e, Integer.valueOf(i)}, i, buffer, i2, z));
                return;
            }
            Http2Stream a = this.f30491c.m25470a(i);
            if (a == null) {
                this.f30491c.m25473a(i, ErrorCode.PROTOCOL_ERROR);
                bufferedSource.mo6568g((long) i2);
            } else if (Http2Stream.f23504l != 0 || Thread.holdsLock(a) == 0) {
                a.f23511g.m31435a(bufferedSource, (long) i2);
                if (z) {
                    a.m25502e();
                }
            } else {
                throw new AssertionError();
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void mo5352a(boolean r13, int r14, java.util.List<com.sendbird.android.shadow.okhttp3.internal.http2.Header> r15) {
            /*
            r12 = this;
            r0 = com.sendbird.android.shadow.okhttp3.internal.http2.Http2Connection.m25468d(r14);
            r1 = 0;
            r2 = 1;
            r3 = 2;
            if (r0 == 0) goto L_0x0028;
        L_0x0009:
            r5 = r12.f30491c;
            r0 = r5.f23486i;
            r11 = new com.sendbird.android.shadow.okhttp3.internal.http2.Http2Connection$5;
            r6 = "OkHttp %s Push Headers[%s]";
            r7 = new java.lang.Object[r3];
            r3 = r5.f23482e;
            r7[r1] = r3;
            r1 = java.lang.Integer.valueOf(r14);
            r7[r2] = r1;
            r4 = r11;
            r8 = r14;
            r9 = r15;
            r10 = r13;
            r4.<init>(r5, r6, r7, r8, r9, r10);
            r0.execute(r11);
            return;
        L_0x0028:
            r0 = r12.f30491c;
            monitor-enter(r0);
            r4 = r12.f30491c;	 Catch:{ all -> 0x00cd }
            r4 = r4.m25470a(r14);	 Catch:{ all -> 0x00cd }
            if (r4 != 0) goto L_0x0085;
        L_0x0033:
            r4 = r12.f30491c;	 Catch:{ all -> 0x00cd }
            r4 = r4.f23485h;	 Catch:{ all -> 0x00cd }
            if (r4 == 0) goto L_0x003b;
        L_0x0039:
            monitor-exit(r0);	 Catch:{ all -> 0x00cd }
            return;
        L_0x003b:
            r4 = r12.f30491c;	 Catch:{ all -> 0x00cd }
            r4 = r4.f23483f;	 Catch:{ all -> 0x00cd }
            if (r14 > r4) goto L_0x0043;
        L_0x0041:
            monitor-exit(r0);	 Catch:{ all -> 0x00cd }
            return;
        L_0x0043:
            r4 = r14 % 2;
            r5 = r12.f30491c;	 Catch:{ all -> 0x00cd }
            r5 = r5.f23484g;	 Catch:{ all -> 0x00cd }
            r5 = r5 % r3;
            if (r4 != r5) goto L_0x004e;
        L_0x004c:
            monitor-exit(r0);	 Catch:{ all -> 0x00cd }
            return;
        L_0x004e:
            r10 = new com.sendbird.android.shadow.okhttp3.internal.http2.Http2Stream;	 Catch:{ all -> 0x00cd }
            r6 = r12.f30491c;	 Catch:{ all -> 0x00cd }
            r7 = 0;
            r4 = r10;
            r5 = r14;
            r8 = r13;
            r9 = r15;
            r4.<init>(r5, r6, r7, r8, r9);	 Catch:{ all -> 0x00cd }
            r13 = r12.f30491c;	 Catch:{ all -> 0x00cd }
            r13.f23483f = r14;	 Catch:{ all -> 0x00cd }
            r13 = r12.f30491c;	 Catch:{ all -> 0x00cd }
            r13 = r13.f23481d;	 Catch:{ all -> 0x00cd }
            r15 = java.lang.Integer.valueOf(r14);	 Catch:{ all -> 0x00cd }
            r13.put(r15, r10);	 Catch:{ all -> 0x00cd }
            r13 = com.sendbird.android.shadow.okhttp3.internal.http2.Http2Connection.f23477a;	 Catch:{ all -> 0x00cd }
            r15 = new com.sendbird.android.shadow.okhttp3.internal.http2.Http2Connection$ReaderRunnable$1;	 Catch:{ all -> 0x00cd }
            r4 = "OkHttp %s stream %d";
            r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x00cd }
            r5 = r12.f30491c;	 Catch:{ all -> 0x00cd }
            r5 = r5.f23482e;	 Catch:{ all -> 0x00cd }
            r3[r1] = r5;	 Catch:{ all -> 0x00cd }
            r14 = java.lang.Integer.valueOf(r14);	 Catch:{ all -> 0x00cd }
            r3[r2] = r14;	 Catch:{ all -> 0x00cd }
            r15.<init>(r12, r4, r3, r10);	 Catch:{ all -> 0x00cd }
            r13.execute(r15);	 Catch:{ all -> 0x00cd }
            monitor-exit(r0);	 Catch:{ all -> 0x00cd }
            return;
        L_0x0085:
            monitor-exit(r0);	 Catch:{ all -> 0x00cd }
            r14 = com.sendbird.android.shadow.okhttp3.internal.http2.Http2Stream.f23504l;
            if (r14 != 0) goto L_0x0096;
        L_0x008a:
            r14 = java.lang.Thread.holdsLock(r4);
            if (r14 == 0) goto L_0x0096;
        L_0x0090:
            r13 = new java.lang.AssertionError;
            r13.<init>();
            throw r13;
        L_0x0096:
            monitor-enter(r4);
            r4.f23510f = r2;	 Catch:{ all -> 0x00ca }
            r14 = r4.f23509e;	 Catch:{ all -> 0x00ca }
            if (r14 != 0) goto L_0x00a7;
        L_0x009d:
            r4.f23509e = r15;	 Catch:{ all -> 0x00ca }
            r2 = r4.m25496a();	 Catch:{ all -> 0x00ca }
            r4.notifyAll();	 Catch:{ all -> 0x00ca }
            goto L_0x00ba;
        L_0x00a7:
            r14 = new java.util.ArrayList;	 Catch:{ all -> 0x00ca }
            r14.<init>();	 Catch:{ all -> 0x00ca }
            r0 = r4.f23509e;	 Catch:{ all -> 0x00ca }
            r14.addAll(r0);	 Catch:{ all -> 0x00ca }
            r0 = 0;
            r14.add(r0);	 Catch:{ all -> 0x00ca }
            r14.addAll(r15);	 Catch:{ all -> 0x00ca }
            r4.f23509e = r14;	 Catch:{ all -> 0x00ca }
        L_0x00ba:
            monitor-exit(r4);	 Catch:{ all -> 0x00ca }
            if (r2 != 0) goto L_0x00c4;
        L_0x00bd:
            r14 = r4.f23508d;
            r15 = r4.f23507c;
            r14.m25476b(r15);
        L_0x00c4:
            if (r13 == 0) goto L_0x00c9;
        L_0x00c6:
            r4.m25502e();
        L_0x00c9:
            return;
        L_0x00ca:
            r13 = move-exception;
            monitor-exit(r4);	 Catch:{ all -> 0x00ca }
            throw r13;
        L_0x00cd:
            r13 = move-exception;
            monitor-exit(r0);	 Catch:{ all -> 0x00cd }
            throw r13;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.okhttp3.internal.http2.Http2Connection.ReaderRunnable.a(boolean, int, java.util.List):void");
        }

        public final void mo5346a(int i, ErrorCode errorCode) {
            if (Http2Connection.m25468d(i)) {
                Http2Connection http2Connection = this.f30491c;
                http2Connection.f23486i.execute(new C24797(http2Connection, "OkHttp %s Push Reset[%s]", new Object[]{http2Connection.f23482e, Integer.valueOf(i)}, i, errorCode));
                return;
            }
            i = this.f30491c.m25476b(i);
            if (i != 0) {
                i.m25500c(errorCode);
            }
        }

        public final void mo5349a(final Settings settings) {
            long j;
            synchronized (this.f30491c) {
                int b = this.f30491c.f23491n.m25529b();
                Settings settings2 = this.f30491c.f23491n;
                int i = 0;
                for (int i2 = 0; i2 < 10; i2++) {
                    if (settings.m25528a(i2)) {
                        settings2.m25527a(i2, settings.f23536b[i2]);
                    }
                }
                Http2Connection.f23477a.execute(new NamedRunnable(this, "OkHttp %s ACK Settings", new Object[]{this.f30491c.f23482e}) {
                    final /* synthetic */ ReaderRunnable f30489c;

                    public final void mo5317b() {
                        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r2 = this;
                        r0 = r2.f30489c;	 Catch:{ IOException -> 0x000c }
                        r0 = r0.f30491c;	 Catch:{ IOException -> 0x000c }
                        r0 = r0.f23494q;	 Catch:{ IOException -> 0x000c }
                        r1 = r12;	 Catch:{ IOException -> 0x000c }
                        r0.m25512a(r1);	 Catch:{ IOException -> 0x000c }
                        return;
                    L_0x000c:
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.okhttp3.internal.http2.Http2Connection.ReaderRunnable.3.b():void");
                    }
                });
                settings = this.f30491c.f23491n.m25529b();
                Http2Stream[] http2StreamArr = null;
                if (settings == -1 || settings == b) {
                    j = 0;
                } else {
                    j = (long) (settings - b);
                    if (this.f30491c.f23492o == null) {
                        settings = this.f30491c;
                        settings.f23489l += j;
                        if (j > 0) {
                            settings.notifyAll();
                        }
                        this.f30491c.f23492o = true;
                    }
                    if (this.f30491c.f23481d.isEmpty() == null) {
                        http2StreamArr = (Http2Stream[]) this.f30491c.f23481d.values().toArray(new Http2Stream[this.f30491c.f23481d.size()]);
                    }
                }
                Http2Connection.f23477a.execute(new NamedRunnable(this, "OkHttp %s settings", this.f30491c.f23482e) {
                    final /* synthetic */ ReaderRunnable f30487a;

                    public final void mo5317b() {
                        this.f30487a.f30491c.f23480c.mo5327a(this.f30487a.f30491c);
                    }
                });
            }
            if (http2StreamArr != null && j != 0) {
                settings = http2StreamArr.length;
                while (i < settings) {
                    Http2Stream http2Stream = http2StreamArr[i];
                    synchronized (http2Stream) {
                        http2Stream.m25494a(j);
                    }
                    i++;
                }
            }
        }

        public final void mo5350a(boolean z, int i, int i2) {
            if (z) {
                z = this.f30491c.m25479c(i);
                if (z) {
                    if (z.f23533c == -1) {
                        if (z.f23532b != -1) {
                            z.f23533c = System.nanoTime();
                            z.f23531a.countDown();
                        }
                    }
                    throw new IllegalStateException();
                }
                return;
            }
            Http2Connection http2Connection = this.f30491c;
            Http2Connection.f23477a.execute(new C24753(http2Connection, "OkHttp %s ping %08x%08x", new Object[]{http2Connection.f23482e, Integer.valueOf(i), Integer.valueOf(i2)}, i, i2));
        }

        public final void mo5347a(int i, ByteString byteString) {
            byteString.mo5405h();
            synchronized (this.f30491c) {
                Http2Stream[] http2StreamArr = (Http2Stream[]) this.f30491c.f23481d.values().toArray(new Http2Stream[this.f30491c.f23481d.size()]);
                this.f30491c.f23485h = true;
            }
            for (Http2Stream http2Stream : http2StreamArr) {
                if (http2Stream.f23507c > i && http2Stream.m25498b()) {
                    http2Stream.m25500c(ErrorCode.REFUSED_STREAM);
                    this.f30491c.m25476b(http2Stream.f23507c);
                }
            }
        }

        public final void mo5345a(int i, long j) {
            if (i == 0) {
                synchronized (this.f30491c) {
                    i = this.f30491c;
                    i.f23489l += j;
                    this.f30491c.notifyAll();
                }
                return;
            }
            i = this.f30491c.m25470a(i);
            if (i != 0) {
                synchronized (i) {
                    i.m25494a(j);
                }
            }
        }

        public final void mo5348a(int i, List<Header> list) {
            Http2Connection http2Connection = this.f30491c;
            synchronized (http2Connection) {
                if (http2Connection.f23496s.contains(Integer.valueOf(i))) {
                    http2Connection.m25473a(i, ErrorCode.PROTOCOL_ERROR);
                    return;
                }
                http2Connection.f23496s.add(Integer.valueOf(i));
                http2Connection.f23486i.execute(new C24764(http2Connection, "OkHttp %s Push Request[%s]", new Object[]{http2Connection.f23482e, Integer.valueOf(i)}, i, list));
            }
        }
    }

    static boolean m25468d(int i) {
        return i != 0 && (i & 1) == 0;
    }

    public Http2Connection(Builder builder) {
        this.f23487j = builder.f23474f;
        this.f23479b = builder.f23475g;
        this.f23480c = builder.f23473e;
        int i = 2;
        this.f23484g = builder.f23475g ? 1 : 2;
        if (builder.f23475g) {
            this.f23484g += 2;
        }
        if (builder.f23475g) {
            i = 1;
        }
        this.f23498v = i;
        if (builder.f23475g) {
            this.f23490m.m25527a(7, 16777216);
        }
        this.f23482e = builder.f23470b;
        this.f23486i = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), Util.m25364a(Util.m25360a("OkHttp %s Push Observer", this.f23482e), true));
        this.f23491n.m25527a(7, 65535);
        this.f23491n.m25527a(5, 16384);
        this.f23489l = (long) this.f23491n.m25529b();
        this.f23493p = builder.f23469a;
        this.f23494q = new Http2Writer(builder.f23472d, this.f23479b);
        this.f23495r = new ReaderRunnable(this, new Http2Reader(builder.f23471c, this.f23479b));
    }

    final synchronized Http2Stream m25470a(int i) {
        return (Http2Stream) this.f23481d.get(Integer.valueOf(i));
    }

    final synchronized Http2Stream m25476b(int i) {
        Http2Stream http2Stream;
        http2Stream = (Http2Stream) this.f23481d.remove(Integer.valueOf(i));
        notifyAll();
        return http2Stream;
    }

    public final synchronized int m25469a() {
        Settings settings = this.f23491n;
        if ((16 & settings.f23535a) == 0) {
            return RedditJobManager.f10810d;
        }
        return settings.f23536b[4];
    }

    final Http2Stream m25471a(List<Header> list, boolean z) throws IOException {
        Http2Stream http2Stream;
        boolean z2 = z ^ 1;
        synchronized (this.f23494q) {
            int i;
            synchronized (this) {
                if (this.f23485h) {
                    throw new ConnectionShutdownException();
                }
                i = this.f23484g;
                this.f23484g += 2;
                http2Stream = new Http2Stream(i, this, z2, false, list);
                if (z && this.f23489l != 0) {
                    if (http2Stream.f23506b != 0) {
                        z = false;
                        if (http2Stream.m25496a()) {
                            this.f23481d.put(Integer.valueOf(i), http2Stream);
                        }
                    }
                }
                z = true;
                if (http2Stream.m25496a()) {
                    this.f23481d.put(Integer.valueOf(i), http2Stream);
                }
            }
            this.f23494q.m25515a(z2, i, (List) list);
        }
        if (z) {
            this.f23494q.m25516b();
        }
        return http2Stream;
    }

    public final void m25474a(int r9, boolean r10, com.sendbird.android.shadow.okio.Buffer r11, long r12) throws java.io.IOException {
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
        r8 = this;
        r0 = 0;
        r2 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1));
        r3 = 0;
        if (r2 != 0) goto L_0x000d;
    L_0x0007:
        r12 = r8.f23494q;
        r12.m25514a(r10, r9, r11, r3);
        return;
    L_0x000d:
        r2 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1));
        if (r2 <= 0) goto L_0x0060;
    L_0x0011:
        monitor-enter(r8);
    L_0x0012:
        r4 = r8.f23489l;	 Catch:{ InterruptedException -> 0x0058 }
        r2 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1));	 Catch:{ InterruptedException -> 0x0058 }
        if (r2 > 0) goto L_0x0030;	 Catch:{ InterruptedException -> 0x0058 }
    L_0x0018:
        r2 = r8.f23481d;	 Catch:{ InterruptedException -> 0x0058 }
        r4 = java.lang.Integer.valueOf(r9);	 Catch:{ InterruptedException -> 0x0058 }
        r2 = r2.containsKey(r4);	 Catch:{ InterruptedException -> 0x0058 }
        if (r2 != 0) goto L_0x002c;	 Catch:{ InterruptedException -> 0x0058 }
    L_0x0024:
        r9 = new java.io.IOException;	 Catch:{ InterruptedException -> 0x0058 }
        r10 = "stream closed";	 Catch:{ InterruptedException -> 0x0058 }
        r9.<init>(r10);	 Catch:{ InterruptedException -> 0x0058 }
        throw r9;	 Catch:{ InterruptedException -> 0x0058 }
    L_0x002c:
        r8.wait();	 Catch:{ InterruptedException -> 0x0058 }
        goto L_0x0012;
    L_0x0030:
        r4 = r8.f23489l;	 Catch:{ all -> 0x0056 }
        r4 = java.lang.Math.min(r12, r4);	 Catch:{ all -> 0x0056 }
        r2 = (int) r4;	 Catch:{ all -> 0x0056 }
        r4 = r8.f23494q;	 Catch:{ all -> 0x0056 }
        r4 = r4.f23518a;	 Catch:{ all -> 0x0056 }
        r2 = java.lang.Math.min(r2, r4);	 Catch:{ all -> 0x0056 }
        r4 = r8.f23489l;	 Catch:{ all -> 0x0056 }
        r6 = (long) r2;	 Catch:{ all -> 0x0056 }
        r4 = r4 - r6;	 Catch:{ all -> 0x0056 }
        r8.f23489l = r4;	 Catch:{ all -> 0x0056 }
        monitor-exit(r8);	 Catch:{ all -> 0x0056 }
        r12 = r12 - r6;
        r4 = r8.f23494q;
        if (r10 == 0) goto L_0x0051;
    L_0x004b:
        r5 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1));
        if (r5 != 0) goto L_0x0051;
    L_0x004f:
        r5 = 1;
        goto L_0x0052;
    L_0x0051:
        r5 = r3;
    L_0x0052:
        r4.m25514a(r5, r9, r11, r2);
        goto L_0x000d;
    L_0x0056:
        r9 = move-exception;
        goto L_0x005e;
    L_0x0058:
        r9 = new java.io.InterruptedIOException;	 Catch:{ all -> 0x0056 }
        r9.<init>();	 Catch:{ all -> 0x0056 }
        throw r9;	 Catch:{ all -> 0x0056 }
    L_0x005e:
        monitor-exit(r8);	 Catch:{ all -> 0x0056 }
        throw r9;
    L_0x0060:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.okhttp3.internal.http2.Http2Connection.a(int, boolean, com.sendbird.android.shadow.okio.Buffer, long):void");
    }

    final void m25473a(int i, ErrorCode errorCode) {
        final int i2 = i;
        final ErrorCode errorCode2 = errorCode;
        f23477a.execute(new NamedRunnable(this, "OkHttp %s stream %d", new Object[]{this.f23482e, Integer.valueOf(i)}) {
            final /* synthetic */ Http2Connection f30461d;

            public final void mo5317b() {
                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r3 = this;
                r0 = r3.f30461d;	 Catch:{ IOException -> 0x000a }
                r1 = r5;	 Catch:{ IOException -> 0x000a }
                r2 = r6;	 Catch:{ IOException -> 0x000a }
                r0.m25477b(r1, r2);	 Catch:{ IOException -> 0x000a }
                return;
            L_0x000a:
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.okhttp3.internal.http2.Http2Connection.1.b():void");
            }
        });
    }

    final void m25477b(int i, ErrorCode errorCode) throws IOException {
        this.f23494q.m25510a(i, errorCode);
    }

    final void m25472a(int i, long j) {
        final int i2 = i;
        final long j2 = j;
        f23477a.execute(new NamedRunnable(this, "OkHttp Window Update %s stream %d", new Object[]{this.f23482e, Integer.valueOf(i)}) {
            final /* synthetic */ Http2Connection f30464d;

            public final void mo5317b() {
                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r4 = this;
                r0 = r4.f30464d;	 Catch:{ IOException -> 0x000c }
                r0 = r0.f23494q;	 Catch:{ IOException -> 0x000c }
                r1 = r5;	 Catch:{ IOException -> 0x000c }
                r2 = r6;	 Catch:{ IOException -> 0x000c }
                r0.m25509a(r1, r2);	 Catch:{ IOException -> 0x000c }
                return;
            L_0x000c:
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.okhttp3.internal.http2.Http2Connection.2.b():void");
            }
        });
    }

    final synchronized Ping m25479c(int i) {
        if (this.f23497u == null) {
            return 0;
        }
        return (Ping) this.f23497u.remove(Integer.valueOf(i));
    }

    public final void close() throws IOException {
        m25475a(ErrorCode.NO_ERROR, ErrorCode.CANCEL);
    }

    final void m25475a(ErrorCode errorCode, ErrorCode errorCode2) throws IOException {
        if (f23478t || !Thread.holdsLock(this)) {
            int i;
            Http2Stream[] http2StreamArr;
            ErrorCode errorCode3;
            Ping ping;
            Map map = null;
            try {
                synchronized (this.f23494q) {
                    synchronized (this) {
                        if (this.f23485h) {
                        } else {
                            this.f23485h = true;
                            this.f23494q.m25511a(this.f23483f, errorCode, Util.f23334a);
                        }
                    }
                    i = 0;
                    if (http2StreamArr != null) {
                        errorCode3 = errorCode;
                        for (Http2Stream a : http2StreamArr) {
                            try {
                                a.m25495a(errorCode2);
                            } catch (IOException e) {
                                if (errorCode3 != null) {
                                    errorCode3 = e;
                                }
                            }
                        }
                        errorCode = errorCode3;
                    }
                    if (map != null) {
                        errorCode2 = map.length;
                        while (i < errorCode2) {
                            ping = map[i];
                            if (ping.f23533c != -1) {
                                if (ping.f23532b == -1) {
                                    ping.f23533c = ping.f23532b - 1;
                                    ping.f23531a.countDown();
                                    i++;
                                }
                            }
                            throw new IllegalStateException();
                        }
                    }
                    this.f23494q.close();
                    this.f23493p.close();
                    if (errorCode != null) {
                        throw errorCode;
                    }
                    return;
                }
                errorCode = null;
            } catch (IOException e2) {
                errorCode = e2;
            }
            synchronized (this) {
                if (this.f23481d.isEmpty()) {
                    http2StreamArr = null;
                } else {
                    http2StreamArr = (Http2Stream[]) this.f23481d.values().toArray(new Http2Stream[this.f23481d.size()]);
                    this.f23481d.clear();
                }
                if (this.f23497u != null) {
                    Ping[] pingArr = (Ping[]) this.f23497u.values().toArray(new Ping[this.f23497u.size()]);
                    this.f23497u = null;
                    map = pingArr;
                }
            }
            i = 0;
            if (http2StreamArr != null) {
                errorCode3 = errorCode;
                while (errorCode < r3) {
                    a.m25495a(errorCode2);
                }
                errorCode = errorCode3;
            }
            if (map != null) {
                errorCode2 = map.length;
                while (i < errorCode2) {
                    ping = map[i];
                    if (ping.f23533c != -1) {
                        if (ping.f23532b == -1) {
                            ping.f23533c = ping.f23532b - 1;
                            ping.f23531a.countDown();
                            i++;
                        }
                    }
                    throw new IllegalStateException();
                }
            }
            try {
                this.f23494q.close();
            } catch (ErrorCode errorCode22) {
                if (errorCode == null) {
                    errorCode = errorCode22;
                }
            }
            try {
                this.f23493p.close();
            } catch (IOException e3) {
                errorCode = e3;
            }
            if (errorCode != null) {
                throw errorCode;
            }
            return;
        }
        throw new AssertionError();
    }

    public final synchronized boolean m25478b() {
        return this.f23485h;
    }
}
