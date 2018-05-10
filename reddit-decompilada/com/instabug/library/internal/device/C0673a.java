package com.instabug.library.internal.device;

import android.os.Build;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

@SuppressFBWarnings({"DMI_HARDCODED_ABSOLUTE_FILENAME"})
/* compiled from: InstabugRootChecker */
public class C0673a {
    private static boolean m8185b() {
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
        r0 = new java.io.File;	 Catch:{ Exception -> 0x000c }
        r1 = "/system/app/Superuser.apk";	 Catch:{ Exception -> 0x000c }
        r0.<init>(r1);	 Catch:{ Exception -> 0x000c }
        r0 = r0.exists();	 Catch:{ Exception -> 0x000c }
        return r0;
    L_0x000c:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.internal.device.a.b():boolean");
    }

    private static boolean m8186c() {
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
        r0 = new java.util.ArrayList;
        r0.<init>();
        r1 = 0;
        r2 = java.lang.Runtime.getRuntime();	 Catch:{ Exception -> 0x007e }
        r3 = "/system/xbin/which";	 Catch:{ Exception -> 0x007e }
        r4 = "su";	 Catch:{ Exception -> 0x007e }
        r3 = new java.lang.String[]{r3, r4};	 Catch:{ Exception -> 0x007e }
        r2 = r2.exec(r3);	 Catch:{ Exception -> 0x007e }
        r3 = new java.io.BufferedReader;
        r4 = new java.io.InputStreamReader;
        r2 = r2.getInputStream();
        r5 = "UTF-8";
        r5 = java.nio.charset.Charset.forName(r5);
        r4.<init>(r2, r5);
        r3.<init>(r4);
    L_0x002a:
        r2 = r3.readLine();	 Catch:{ Exception -> 0x0052 }
        if (r2 == 0) goto L_0x0047;	 Catch:{ Exception -> 0x0052 }
    L_0x0030:
        r4 = com.instabug.library.internal.device.C0673a.class;	 Catch:{ Exception -> 0x0052 }
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0052 }
        r6 = "SHELL --> Line received: ";	 Catch:{ Exception -> 0x0052 }
        r5.<init>(r6);	 Catch:{ Exception -> 0x0052 }
        r5.append(r2);	 Catch:{ Exception -> 0x0052 }
        r5 = r5.toString();	 Catch:{ Exception -> 0x0052 }
        com.instabug.library.util.InstabugSDKLogger.m8356d(r4, r5);	 Catch:{ Exception -> 0x0052 }
        r0.add(r2);	 Catch:{ Exception -> 0x0052 }
        goto L_0x002a;
    L_0x0047:
        r3.close();	 Catch:{ IOException -> 0x004b }
        goto L_0x0059;
    L_0x004b:
        r2 = move-exception;
        r2.printStackTrace();
        goto L_0x0059;
    L_0x0050:
        r0 = move-exception;
        goto L_0x0075;
    L_0x0052:
        r2 = move-exception;
        r2.printStackTrace();	 Catch:{ all -> 0x0050 }
        r3.close();	 Catch:{ IOException -> 0x004b }
    L_0x0059:
        r2 = com.instabug.library.internal.device.C0673a.class;
        r3 = new java.lang.StringBuilder;
        r4 = "SHELL --> Full response was: ";
        r3.<init>(r4);
        r3.append(r0);
        r3 = r3.toString();
        com.instabug.library.util.InstabugSDKLogger.m8356d(r2, r3);
        r0 = r0.size();
        if (r0 == 0) goto L_0x0074;
    L_0x0072:
        r0 = 1;
        return r0;
    L_0x0074:
        return r1;
    L_0x0075:
        r3.close();	 Catch:{ IOException -> 0x0079 }
        goto L_0x007d;
    L_0x0079:
        r1 = move-exception;
        r1.printStackTrace();
    L_0x007d:
        throw r0;
    L_0x007e:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.internal.device.a.c():boolean");
    }

    public static boolean m8184a() {
        String str = Build.TAGS;
        boolean z = str != null && str.contains("test-keys");
        if (!(z || C0673a.m8185b())) {
            if (!C0673a.m8186c()) {
                return false;
            }
        }
        return true;
    }
}
