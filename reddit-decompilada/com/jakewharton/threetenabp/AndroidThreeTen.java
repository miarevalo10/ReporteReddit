package com.jakewharton.threetenabp;

import android.app.Application;
import android.content.Context;
import java.util.concurrent.atomic.AtomicBoolean;

public final class AndroidThreeTen {
    private static final AtomicBoolean f10023a = new AtomicBoolean();

    public static void m8477a(Application application) {
        m8478a((Context) application);
    }

    public static void m8478a(android.content.Context r4) {
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
        r0 = f10023a;
        r1 = 1;
        r0 = r0.getAndSet(r1);
        if (r0 == 0) goto L_0x000a;
    L_0x0009:
        return;
    L_0x000a:
        r0 = 0;
        r4 = r4.getAssets();	 Catch:{ IOException -> 0x002f }
        r1 = "org/threeten/bp/TZDB.dat";	 Catch:{ IOException -> 0x002f }
        r4 = r4.open(r1);	 Catch:{ IOException -> 0x002f }
        r0 = new org.threeten.bp.zone.TzdbZoneRulesProvider;	 Catch:{ IOException -> 0x0028, all -> 0x0023 }
        r0.<init>(r4);	 Catch:{ IOException -> 0x0028, all -> 0x0023 }
        if (r4 == 0) goto L_0x001f;
    L_0x001c:
        r4.close();	 Catch:{ IOException -> 0x001f }
    L_0x001f:
        org.threeten.bp.zone.ZoneRulesProvider.a(r0);
        return;
    L_0x0023:
        r0 = move-exception;
        r3 = r0;
        r0 = r4;
        r4 = r3;
        goto L_0x0038;
    L_0x0028:
        r0 = move-exception;
        r3 = r0;
        r0 = r4;
        r4 = r3;
        goto L_0x0030;
    L_0x002d:
        r4 = move-exception;
        goto L_0x0038;
    L_0x002f:
        r4 = move-exception;
    L_0x0030:
        r1 = new java.lang.IllegalStateException;	 Catch:{ all -> 0x002d }
        r2 = "TZDB.dat missing from assets.";	 Catch:{ all -> 0x002d }
        r1.<init>(r2, r4);	 Catch:{ all -> 0x002d }
        throw r1;	 Catch:{ all -> 0x002d }
    L_0x0038:
        if (r0 == 0) goto L_0x003d;
    L_0x003a:
        r0.close();	 Catch:{ IOException -> 0x003d }
    L_0x003d:
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jakewharton.threetenabp.AndroidThreeTen.a(android.content.Context):void");
    }
}
