package com.danikula.videocache;

import android.content.Context;
import java.io.File;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

final class StorageUtils {
    private static final Logger f3774a = LoggerFactory.a("StorageUtils");

    public static File m3353a(Context context) {
        return new File(m3354b(context), "video-cache");
    }

    private static java.io.File m3354b(android.content.Context r5) {
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
        r0 = android.os.Environment.getExternalStorageState();	 Catch:{ NullPointerException -> 0x0005 }
        goto L_0x0007;
    L_0x0005:
        r0 = "";
    L_0x0007:
        r1 = "mounted";
        r0 = r1.equals(r0);
        r1 = 0;
        if (r0 == 0) goto L_0x0047;
    L_0x0010:
        r0 = new java.io.File;
        r2 = new java.io.File;
        r3 = android.os.Environment.getExternalStorageDirectory();
        r4 = "Android";
        r2.<init>(r3, r4);
        r3 = "data";
        r0.<init>(r2, r3);
        r2 = new java.io.File;
        r3 = new java.io.File;
        r4 = r5.getPackageName();
        r3.<init>(r0, r4);
        r0 = "cache";
        r2.<init>(r3, r0);
        r0 = r2.exists();
        if (r0 != 0) goto L_0x0046;
    L_0x0038:
        r0 = r2.mkdirs();
        if (r0 != 0) goto L_0x0046;
    L_0x003e:
        r0 = f3774a;
        r2 = "Unable to create external cache directory";
        r0.c(r2);
        goto L_0x0047;
    L_0x0046:
        r1 = r2;
    L_0x0047:
        if (r1 != 0) goto L_0x004d;
    L_0x0049:
        r1 = r5.getCacheDir();
    L_0x004d:
        if (r1 != 0) goto L_0x0083;
    L_0x004f:
        r0 = new java.lang.StringBuilder;
        r1 = "/data/data/";
        r0.<init>(r1);
        r5 = r5.getPackageName();
        r0.append(r5);
        r5 = "/cache/";
        r0.append(r5);
        r5 = r0.toString();
        r0 = f3774a;
        r1 = new java.lang.StringBuilder;
        r2 = "Can't define system cache directory! '";
        r1.<init>(r2);
        r1.append(r5);
        r2 = "%s' will be used.";
        r1.append(r2);
        r1 = r1.toString();
        r0.c(r1);
        r1 = new java.io.File;
        r1.<init>(r5);
    L_0x0083:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.danikula.videocache.StorageUtils.b(android.content.Context):java.io.File");
    }
}
