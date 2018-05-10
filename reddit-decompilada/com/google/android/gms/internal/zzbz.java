package com.google.android.gms.internal;

final class zzbz {
    static zzdpv f6720a;

    static boolean m5590a() {
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
        r0 = f6720a;
        r1 = 1;
        if (r0 == 0) goto L_0x0006;
    L_0x0005:
        return r1;
    L_0x0006:
        r0 = com.google.android.gms.internal.zznh.bx;
        r2 = com.google.android.gms.internal.zzkb.m6350f();
        r0 = r2.m6488a(r0);
        r0 = (java.lang.String) r0;
        r2 = r0.length();
        r3 = 0;
        if (r2 != 0) goto L_0x001a;
    L_0x0019:
        return r3;
    L_0x001a:
        r0 = com.google.android.gms.internal.zzbu.m5580a(r0, r1);	 Catch:{ IllegalArgumentException -> 0x008a }
        r0 = com.google.android.gms.internal.zzdqb.m5866a(r0);	 Catch:{ GeneralSecurityException -> 0x0089 }
        r2 = com.google.android.gms.internal.zzdqs.f7255a;	 Catch:{ GeneralSecurityException -> 0x0089 }
        r2 = r2.f19715a;	 Catch:{ GeneralSecurityException -> 0x0089 }
        r2 = r2.iterator();	 Catch:{ GeneralSecurityException -> 0x0089 }
    L_0x002a:
        r4 = r2.hasNext();	 Catch:{ GeneralSecurityException -> 0x0089 }
        if (r4 == 0) goto L_0x007e;	 Catch:{ GeneralSecurityException -> 0x0089 }
    L_0x0030:
        r4 = r2.next();	 Catch:{ GeneralSecurityException -> 0x0089 }
        r4 = (com.google.android.gms.internal.zzdtf) r4;	 Catch:{ GeneralSecurityException -> 0x0089 }
        r5 = r4.f19672b;	 Catch:{ GeneralSecurityException -> 0x0089 }
        r5 = r5.isEmpty();	 Catch:{ GeneralSecurityException -> 0x0089 }
        if (r5 == 0) goto L_0x0046;	 Catch:{ GeneralSecurityException -> 0x0089 }
    L_0x003e:
        r0 = new java.security.GeneralSecurityException;	 Catch:{ GeneralSecurityException -> 0x0089 }
        r1 = "Missing type_url.";	 Catch:{ GeneralSecurityException -> 0x0089 }
        r0.<init>(r1);	 Catch:{ GeneralSecurityException -> 0x0089 }
        throw r0;	 Catch:{ GeneralSecurityException -> 0x0089 }
    L_0x0046:
        r5 = r4.f19671a;	 Catch:{ GeneralSecurityException -> 0x0089 }
        r5 = r5.isEmpty();	 Catch:{ GeneralSecurityException -> 0x0089 }
        if (r5 == 0) goto L_0x0056;	 Catch:{ GeneralSecurityException -> 0x0089 }
    L_0x004e:
        r0 = new java.security.GeneralSecurityException;	 Catch:{ GeneralSecurityException -> 0x0089 }
        r1 = "Missing primitive_name.";	 Catch:{ GeneralSecurityException -> 0x0089 }
        r0.<init>(r1);	 Catch:{ GeneralSecurityException -> 0x0089 }
        throw r0;	 Catch:{ GeneralSecurityException -> 0x0089 }
    L_0x0056:
        r5 = r4.f19675e;	 Catch:{ GeneralSecurityException -> 0x0089 }
        r5 = r5.isEmpty();	 Catch:{ GeneralSecurityException -> 0x0089 }
        if (r5 == 0) goto L_0x0066;	 Catch:{ GeneralSecurityException -> 0x0089 }
    L_0x005e:
        r0 = new java.security.GeneralSecurityException;	 Catch:{ GeneralSecurityException -> 0x0089 }
        r1 = "Missing catalogue_name.";	 Catch:{ GeneralSecurityException -> 0x0089 }
        r0.<init>(r1);	 Catch:{ GeneralSecurityException -> 0x0089 }
        throw r0;	 Catch:{ GeneralSecurityException -> 0x0089 }
    L_0x0066:
        r5 = r4.f19675e;	 Catch:{ GeneralSecurityException -> 0x0089 }
        r5 = com.google.android.gms.internal.zzdqe.m5868a(r5);	 Catch:{ GeneralSecurityException -> 0x0089 }
        r6 = r4.f19672b;	 Catch:{ GeneralSecurityException -> 0x0089 }
        r7 = r4.f19671a;	 Catch:{ GeneralSecurityException -> 0x0089 }
        r8 = r4.f19673c;	 Catch:{ GeneralSecurityException -> 0x0089 }
        r5 = r5.mo1855a(r6, r7, r8);	 Catch:{ GeneralSecurityException -> 0x0089 }
        r6 = r4.f19672b;	 Catch:{ GeneralSecurityException -> 0x0089 }
        r4 = r4.f19674d;	 Catch:{ GeneralSecurityException -> 0x0089 }
        com.google.android.gms.internal.zzdqe.m5876a(r6, r5, r4);	 Catch:{ GeneralSecurityException -> 0x0089 }
        goto L_0x002a;	 Catch:{ GeneralSecurityException -> 0x0089 }
    L_0x007e:
        r0 = com.google.android.gms.internal.zzdqt.m5881a(r0);	 Catch:{ GeneralSecurityException -> 0x0089 }
        f6720a = r0;	 Catch:{ GeneralSecurityException -> 0x0089 }
        r0 = f6720a;
        if (r0 == 0) goto L_0x0089;
    L_0x0088:
        return r1;
    L_0x0089:
        return r3;
    L_0x008a:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzbz.a():boolean");
    }
}
