package com.google.android.gms.internal;

import java.security.MessageDigest;

@zzzv
public abstract class zzhq {
    private static MessageDigest f7701b;
    protected Object f7702a = new Object();

    protected final java.security.MessageDigest m6296a() {
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
        r3 = this;
        r0 = r3.f7702a;
        monitor-enter(r0);
        r1 = f7701b;	 Catch:{ all -> 0x001e }
        if (r1 == 0) goto L_0x000b;	 Catch:{ all -> 0x001e }
    L_0x0007:
        r1 = f7701b;	 Catch:{ all -> 0x001e }
        monitor-exit(r0);	 Catch:{ all -> 0x001e }
        return r1;
    L_0x000b:
        r1 = 0;
    L_0x000c:
        r2 = 2;
        if (r1 >= r2) goto L_0x001a;
    L_0x000f:
        r2 = "MD5";	 Catch:{ NoSuchAlgorithmException -> 0x0017 }
        r2 = java.security.MessageDigest.getInstance(r2);	 Catch:{ NoSuchAlgorithmException -> 0x0017 }
        f7701b = r2;	 Catch:{ NoSuchAlgorithmException -> 0x0017 }
    L_0x0017:
        r1 = r1 + 1;
        goto L_0x000c;
    L_0x001a:
        r1 = f7701b;	 Catch:{ all -> 0x001e }
        monitor-exit(r0);	 Catch:{ all -> 0x001e }
        return r1;	 Catch:{ all -> 0x001e }
    L_0x001e:
        r1 = move-exception;	 Catch:{ all -> 0x001e }
        monitor-exit(r0);	 Catch:{ all -> 0x001e }
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzhq.a():java.security.MessageDigest");
    }

    abstract byte[] mo1953a(String str);
}
