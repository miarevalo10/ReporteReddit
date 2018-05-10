package com.google.android.gms.internal;

import android.content.Context;

public final class zzbhd {
    private static Context f6709a;
    private static Boolean f6710b;

    public static synchronized boolean m5567a(android.content.Context r3) {
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
        r0 = com.google.android.gms.internal.zzbhd.class;
        monitor-enter(r0);
        r1 = r3.getApplicationContext();	 Catch:{ all -> 0x0054 }
        r2 = f6709a;	 Catch:{ all -> 0x0054 }
        if (r2 == 0) goto L_0x001b;	 Catch:{ all -> 0x0054 }
    L_0x000b:
        r2 = f6710b;	 Catch:{ all -> 0x0054 }
        if (r2 == 0) goto L_0x001b;	 Catch:{ all -> 0x0054 }
    L_0x000f:
        r2 = f6709a;	 Catch:{ all -> 0x0054 }
        if (r2 != r1) goto L_0x001b;	 Catch:{ all -> 0x0054 }
    L_0x0013:
        r3 = f6710b;	 Catch:{ all -> 0x0054 }
        r3 = r3.booleanValue();	 Catch:{ all -> 0x0054 }
        monitor-exit(r0);
        return r3;
    L_0x001b:
        r2 = 0;
        f6710b = r2;	 Catch:{ all -> 0x0054 }
        r2 = com.google.android.gms.common.util.zzq.m4917i();	 Catch:{ all -> 0x0054 }
        if (r2 == 0) goto L_0x0033;	 Catch:{ all -> 0x0054 }
    L_0x0024:
        r3 = r1.getPackageManager();	 Catch:{ all -> 0x0054 }
        r3 = r3.isInstantApp();	 Catch:{ all -> 0x0054 }
        r3 = java.lang.Boolean.valueOf(r3);	 Catch:{ all -> 0x0054 }
    L_0x0030:
        f6710b = r3;	 Catch:{ all -> 0x0054 }
        goto L_0x004a;
    L_0x0033:
        r3 = r3.getClassLoader();	 Catch:{ ClassNotFoundException -> 0x0044 }
        r2 = "com.google.android.instantapps.supervisor.InstantAppsRuntime";	 Catch:{ ClassNotFoundException -> 0x0044 }
        r3.loadClass(r2);	 Catch:{ ClassNotFoundException -> 0x0044 }
        r3 = 1;	 Catch:{ ClassNotFoundException -> 0x0044 }
        r3 = java.lang.Boolean.valueOf(r3);	 Catch:{ ClassNotFoundException -> 0x0044 }
        f6710b = r3;	 Catch:{ ClassNotFoundException -> 0x0044 }
        goto L_0x004a;
    L_0x0044:
        r3 = 0;
        r3 = java.lang.Boolean.valueOf(r3);	 Catch:{ all -> 0x0054 }
        goto L_0x0030;	 Catch:{ all -> 0x0054 }
    L_0x004a:
        f6709a = r1;	 Catch:{ all -> 0x0054 }
        r3 = f6710b;	 Catch:{ all -> 0x0054 }
        r3 = r3.booleanValue();	 Catch:{ all -> 0x0054 }
        monitor-exit(r0);
        return r3;
    L_0x0054:
        r3 = move-exception;
        monitor-exit(r0);
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzbhd.a(android.content.Context):boolean");
    }
}
