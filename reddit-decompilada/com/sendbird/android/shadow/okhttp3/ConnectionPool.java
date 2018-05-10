package com.sendbird.android.shadow.okhttp3;

import com.reddit.datalibrary.frontpage.job.RedditJobManager;
import com.sendbird.android.shadow.okhttp3.internal.Util;
import com.sendbird.android.shadow.okhttp3.internal.connection.RealConnection;
import com.sendbird.android.shadow.okhttp3.internal.connection.RouteDatabase;
import com.sendbird.android.shadow.okhttp3.internal.connection.StreamAllocation.StreamAllocationReference;
import com.sendbird.android.shadow.okhttp3.internal.platform.Platform;
import java.lang.ref.Reference;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class ConnectionPool {
    static final Executor f23149a = new ThreadPoolExecutor(0, RedditJobManager.f10810d, 60, TimeUnit.SECONDS, new SynchronousQueue(), Util.m25364a("OkHttp ConnectionPool", true));
    static final /* synthetic */ boolean f23150g = true;
    final int f23151b;
    final Runnable f23152c;
    final Deque<RealConnection> f23153d;
    final RouteDatabase f23154e;
    boolean f23155f;
    private final long f23156h;

    class C20371 implements Runnable {
        final /* synthetic */ ConnectionPool f23148a;

        C20371(ConnectionPool connectionPool) {
            this.f23148a = connectionPool;
        }

        public void run() {
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
            r6 = this;
        L_0x0000:
            r0 = r6.f23148a;
            r1 = java.lang.System.nanoTime();
            r0 = r0.m25213a(r1);
            r2 = -1;
            r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
            if (r2 != 0) goto L_0x0011;
        L_0x0010:
            return;
        L_0x0011:
            r2 = 0;
            r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
            if (r2 <= 0) goto L_0x0000;
        L_0x0017:
            r2 = 1000000; // 0xf4240 float:1.401298E-39 double:4.940656E-318;
            r4 = r0 / r2;
            r2 = r2 * r4;
            r0 = r0 - r2;
            r2 = r6.f23148a;
            monitor-enter(r2);
            r3 = r6.f23148a;	 Catch:{ InterruptedException -> 0x002a }
            r0 = (int) r0;	 Catch:{ InterruptedException -> 0x002a }
            r3.wait(r4, r0);	 Catch:{ InterruptedException -> 0x002a }
            goto L_0x002a;
        L_0x0028:
            r0 = move-exception;
            goto L_0x002c;
        L_0x002a:
            monitor-exit(r2);	 Catch:{ all -> 0x0028 }
            goto L_0x0000;	 Catch:{ all -> 0x0028 }
        L_0x002c:
            monitor-exit(r2);	 Catch:{ all -> 0x0028 }
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.okhttp3.ConnectionPool.1.run():void");
        }
    }

    public ConnectionPool() {
        this(TimeUnit.MINUTES);
    }

    private ConnectionPool(TimeUnit timeUnit) {
        this.f23152c = new C20371(this);
        this.f23153d = new ArrayDeque();
        this.f23154e = new RouteDatabase();
        this.f23151b = 5;
        this.f23156h = timeUnit.toNanos(5);
    }

    public final void m25214a() {
        List<RealConnection> arrayList = new ArrayList();
        synchronized (this) {
            Iterator it = this.f23153d.iterator();
            while (it.hasNext()) {
                RealConnection realConnection = (RealConnection) it.next();
                if (realConnection.f30401k.isEmpty()) {
                    realConnection.f30398h = true;
                    arrayList.add(realConnection);
                    it.remove();
                }
            }
        }
        for (RealConnection realConnection2 : arrayList) {
            Util.m25367a(realConnection2.f30393c);
        }
    }

    final long m25213a(long j) {
        synchronized (this) {
            long j2 = Long.MIN_VALUE;
            int i = 0;
            RealConnection realConnection = null;
            int i2 = i;
            for (RealConnection realConnection2 : this.f23153d) {
                int i3;
                List list = realConnection2.f30401k;
                int i4 = 0;
                while (i4 < list.size()) {
                    Reference reference = (Reference) list.get(i4);
                    if (reference.get() != null) {
                        i4++;
                    } else {
                        StreamAllocationReference streamAllocationReference = (StreamAllocationReference) reference;
                        StringBuilder stringBuilder = new StringBuilder("A connection to ");
                        stringBuilder.append(realConnection2.f30391a.f23321a.f23037a);
                        stringBuilder.append(" was leaked. Did you forget to close a response body?");
                        Platform.m25549b().mo5371a(stringBuilder.toString(), streamAllocationReference.f23405a);
                        list.remove(i4);
                        realConnection2.f30398h = true;
                        if (list.isEmpty()) {
                            realConnection2.f30402l = j - this.f23156h;
                            i3 = 0;
                            break;
                        }
                    }
                }
                i3 = list.size();
                if (i3 > 0) {
                    i++;
                } else {
                    i2++;
                    long j3 = j - realConnection2.f30402l;
                    if (j3 > j2) {
                        realConnection = realConnection2;
                        j2 = j3;
                    }
                }
            }
            if (j2 < this.f23156h) {
                if (i2 <= this.f23151b) {
                    if (i2 > 0) {
                        j = this.f23156h - j2;
                        return j;
                    } else if (i > 0) {
                        j = this.f23156h;
                        return j;
                    } else {
                        this.f23155f = false;
                        return -1;
                    }
                }
            }
            this.f23153d.remove(realConnection);
            Util.m25367a(realConnection.f30393c);
            return 0;
        }
    }
}
