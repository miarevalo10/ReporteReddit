package com.reddit.datalibrary.frontpage.redditauth.redditclient;

import android.text.TextUtils;
import com.android.volley.RetryPolicy;
import com.reddit.datalibrary.frontpage.redditauth.account.Session;
import com.reddit.datalibrary.frontpage.redditauth.account.Session.SessionId;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CountDownLatch;

public class SessionRetryPolicy implements RetryPolicy {
    private static final ConcurrentMap<SessionId, CountDownLatch> f16314d = new ConcurrentHashMap();
    private final int f16315a;
    private final int f16316b;
    private int f16317c;
    private final Session f16318e;
    private String f16319f;

    public SessionRetryPolicy(Session session) {
        this(session, (byte) 0);
    }

    private SessionRetryPolicy(Session session, byte b) {
        this.f16317c = (byte) 0;
        this.f16318e = session;
        this.f16319f = session.f16289b;
        this.f16316b = 7500;
        this.f16315a = 1;
    }

    public final int mo771a() {
        return this.f16316b;
    }

    public final int mo773b() {
        return this.f16317c;
    }

    private boolean m16370c() {
        return (this.f16318e.m16313d() || TextUtils.equals(this.f16319f, this.f16318e.f16289b)) ? false : true;
    }

    public final void mo772a(com.android.volley.VolleyError r9) throws com.android.volley.VolleyError {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r8 = this;
        r0 = r8.f16317c;
        r1 = r8.f16315a;
        r2 = 0;
        r3 = 1;
        if (r0 > r1) goto L_0x000a;
    L_0x0008:
        r0 = r3;
        goto L_0x000b;
    L_0x000a:
        r0 = r2;
    L_0x000b:
        if (r0 != 0) goto L_0x000e;
    L_0x000d:
        throw r9;
    L_0x000e:
        r0 = r8.f16317c;
        r0 = r0 + r3;
        r8.f16317c = r0;
        r0 = r9.f2805a;
        if (r0 == 0) goto L_0x00b3;
    L_0x0017:
        r0 = r0.f2777a;
        r1 = 401; // 0x191 float:5.62E-43 double:1.98E-321;
        if (r0 != r1) goto L_0x00b3;
    L_0x001d:
        r0 = f16314d;
        r1 = r8.f16318e;
        r1 = r1.f16288a;
        r0 = r0.get(r1);
        r0 = (java.util.concurrent.CountDownLatch) r0;
        if (r0 == 0) goto L_0x003d;
    L_0x002b:
        r0.await();	 Catch:{ InterruptedException -> 0x003c }
        r0 = r8.m16370c();
        if (r0 == 0) goto L_0x003b;
    L_0x0034:
        r9 = r8.f16318e;
        r9 = r9.f16289b;
        r8.f16319f = r9;
        return;
    L_0x003b:
        throw r9;
    L_0x003c:
        throw r9;
    L_0x003d:
        r0 = r8.f16318e;
        r0 = r0.f16288a;
        monitor-enter(r0);
        r1 = r8.m16370c();	 Catch:{ all -> 0x00b0 }
        if (r1 == 0) goto L_0x0050;	 Catch:{ all -> 0x00b0 }
    L_0x0048:
        r9 = r8.f16318e;	 Catch:{ all -> 0x00b0 }
        r9 = r9.f16289b;	 Catch:{ all -> 0x00b0 }
        r8.f16319f = r9;	 Catch:{ all -> 0x00b0 }
        monitor-exit(r0);	 Catch:{ all -> 0x00b0 }
        return;	 Catch:{ all -> 0x00b0 }
    L_0x0050:
        r1 = new java.util.concurrent.CountDownLatch;	 Catch:{ all -> 0x00b0 }
        r1.<init>(r3);	 Catch:{ all -> 0x00b0 }
        r4 = f16314d;	 Catch:{ all -> 0x00b0 }
        r5 = r8.f16318e;	 Catch:{ all -> 0x00b0 }
        r5 = r5.f16288a;	 Catch:{ all -> 0x00b0 }
        r4.put(r5, r1);	 Catch:{ all -> 0x00b0 }
        r4 = "getting token in retry %s / %s";	 Catch:{ TokenRotationError -> 0x009a }
        r5 = 2;	 Catch:{ TokenRotationError -> 0x009a }
        r6 = new java.lang.Object[r5];	 Catch:{ TokenRotationError -> 0x009a }
        r7 = r8.f16319f;	 Catch:{ TokenRotationError -> 0x009a }
        r6[r2] = r7;	 Catch:{ TokenRotationError -> 0x009a }
        r7 = r8.f16318e;	 Catch:{ TokenRotationError -> 0x009a }
        r7 = r7.f16289b;	 Catch:{ TokenRotationError -> 0x009a }
        r6[r3] = r7;	 Catch:{ TokenRotationError -> 0x009a }
        timber.log.Timber.b(r4, r6);	 Catch:{ TokenRotationError -> 0x009a }
        r4 = com.reddit.datalibrary.frontpage.redditauth.account.SessionManager.m9191b();	 Catch:{ TokenRotationError -> 0x009a }
        r6 = r8.f16318e;	 Catch:{ TokenRotationError -> 0x009a }
        r4.m9204c(r6);	 Catch:{ TokenRotationError -> 0x009a }
        r4 = "done getting token, old token was %s new token is %s";	 Catch:{ TokenRotationError -> 0x009a }
        r5 = new java.lang.Object[r5];	 Catch:{ TokenRotationError -> 0x009a }
        r6 = r8.f16319f;	 Catch:{ TokenRotationError -> 0x009a }
        r5[r2] = r6;	 Catch:{ TokenRotationError -> 0x009a }
        r6 = r8.f16318e;	 Catch:{ TokenRotationError -> 0x009a }
        r6 = r6.f16289b;	 Catch:{ TokenRotationError -> 0x009a }
        r5[r3] = r6;	 Catch:{ TokenRotationError -> 0x009a }
        timber.log.Timber.b(r4, r5);	 Catch:{ TokenRotationError -> 0x009a }
        r1.countDown();	 Catch:{ all -> 0x00b0 }
        r9 = f16314d;	 Catch:{ all -> 0x00b0 }
        r2 = r8.f16318e;	 Catch:{ all -> 0x00b0 }
        r2 = r2.f16288a;	 Catch:{ all -> 0x00b0 }
        r9.remove(r2, r1);	 Catch:{ all -> 0x00b0 }
        monitor-exit(r0);	 Catch:{ all -> 0x00b0 }
        return;
    L_0x0098:
        r9 = move-exception;
        goto L_0x00a3;
    L_0x009a:
        r3 = move-exception;
        r4 = "Failed to retrieve a new token";	 Catch:{ all -> 0x0098 }
        r2 = new java.lang.Object[r2];	 Catch:{ all -> 0x0098 }
        timber.log.Timber.c(r3, r4, r2);	 Catch:{ all -> 0x0098 }
        throw r9;	 Catch:{ all -> 0x0098 }
    L_0x00a3:
        r1.countDown();	 Catch:{ all -> 0x00b0 }
        r2 = f16314d;	 Catch:{ all -> 0x00b0 }
        r3 = r8.f16318e;	 Catch:{ all -> 0x00b0 }
        r3 = r3.f16288a;	 Catch:{ all -> 0x00b0 }
        r2.remove(r3, r1);	 Catch:{ all -> 0x00b0 }
        throw r9;	 Catch:{ all -> 0x00b0 }
    L_0x00b0:
        r9 = move-exception;	 Catch:{ all -> 0x00b0 }
        monitor-exit(r0);	 Catch:{ all -> 0x00b0 }
        throw r9;
    L_0x00b3:
        throw r9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reddit.datalibrary.frontpage.redditauth.redditclient.SessionRetryPolicy.a(com.android.volley.VolleyError):void");
    }
}
