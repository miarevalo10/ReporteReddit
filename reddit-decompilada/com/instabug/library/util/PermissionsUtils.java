package com.instabug.library.util;

import android.app.Activity;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;

public class PermissionsUtils {
    public static boolean isPermissionGranted(android.content.Context r4, java.lang.String r5) {
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
        r0 = 1;
        r1 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Exception -> 0x0066, Exception -> 0x0066 }
        r2 = 23;	 Catch:{ Exception -> 0x0066, Exception -> 0x0066 }
        r3 = 0;	 Catch:{ Exception -> 0x0066, Exception -> 0x0066 }
        if (r1 < r2) goto L_0x0037;	 Catch:{ Exception -> 0x0066, Exception -> 0x0066 }
    L_0x0008:
        r4 = android.support.v4.content.ContextCompat.m713a(r4, r5);	 Catch:{ Exception -> 0x0066, Exception -> 0x0066 }
        if (r4 != 0) goto L_0x000f;	 Catch:{ Exception -> 0x0066, Exception -> 0x0066 }
    L_0x000e:
        r3 = r0;	 Catch:{ Exception -> 0x0066, Exception -> 0x0066 }
    L_0x000f:
        r4 = com.instabug.library.util.PermissionsUtils.class;	 Catch:{ Exception -> 0x0066, Exception -> 0x0066 }
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0066, Exception -> 0x0066 }
        r2 = "Permission ";	 Catch:{ Exception -> 0x0066, Exception -> 0x0066 }
        r1.<init>(r2);	 Catch:{ Exception -> 0x0066, Exception -> 0x0066 }
        r1.append(r5);	 Catch:{ Exception -> 0x0066, Exception -> 0x0066 }
        r5 = " state is ";	 Catch:{ Exception -> 0x0066, Exception -> 0x0066 }
        r1.append(r5);	 Catch:{ Exception -> 0x0066, Exception -> 0x0066 }
        if (r3 == 0) goto L_0x0025;	 Catch:{ Exception -> 0x0066, Exception -> 0x0066 }
    L_0x0022:
        r5 = "";	 Catch:{ Exception -> 0x0066, Exception -> 0x0066 }
        goto L_0x0027;	 Catch:{ Exception -> 0x0066, Exception -> 0x0066 }
    L_0x0025:
        r5 = "NOT ";	 Catch:{ Exception -> 0x0066, Exception -> 0x0066 }
    L_0x0027:
        r1.append(r5);	 Catch:{ Exception -> 0x0066, Exception -> 0x0066 }
        r5 = "granted";	 Catch:{ Exception -> 0x0066, Exception -> 0x0066 }
        r1.append(r5);	 Catch:{ Exception -> 0x0066, Exception -> 0x0066 }
        r5 = r1.toString();	 Catch:{ Exception -> 0x0066, Exception -> 0x0066 }
        com.instabug.library.util.InstabugSDKLogger.m8356d(r4, r5);	 Catch:{ Exception -> 0x0066, Exception -> 0x0066 }
        return r3;	 Catch:{ Exception -> 0x0066, Exception -> 0x0066 }
    L_0x0037:
        r4 = r4.checkCallingOrSelfPermission(r5);	 Catch:{ Exception -> 0x0066, Exception -> 0x0066 }
        if (r4 != 0) goto L_0x003e;	 Catch:{ Exception -> 0x0066, Exception -> 0x0066 }
    L_0x003d:
        r3 = r0;	 Catch:{ Exception -> 0x0066, Exception -> 0x0066 }
    L_0x003e:
        r4 = com.instabug.library.util.PermissionsUtils.class;	 Catch:{ Exception -> 0x0066, Exception -> 0x0066 }
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0066, Exception -> 0x0066 }
        r2 = "Permission ";	 Catch:{ Exception -> 0x0066, Exception -> 0x0066 }
        r1.<init>(r2);	 Catch:{ Exception -> 0x0066, Exception -> 0x0066 }
        r1.append(r5);	 Catch:{ Exception -> 0x0066, Exception -> 0x0066 }
        r5 = " state is ";	 Catch:{ Exception -> 0x0066, Exception -> 0x0066 }
        r1.append(r5);	 Catch:{ Exception -> 0x0066, Exception -> 0x0066 }
        if (r3 == 0) goto L_0x0054;	 Catch:{ Exception -> 0x0066, Exception -> 0x0066 }
    L_0x0051:
        r5 = "";	 Catch:{ Exception -> 0x0066, Exception -> 0x0066 }
        goto L_0x0056;	 Catch:{ Exception -> 0x0066, Exception -> 0x0066 }
    L_0x0054:
        r5 = "NOT ";	 Catch:{ Exception -> 0x0066, Exception -> 0x0066 }
    L_0x0056:
        r1.append(r5);	 Catch:{ Exception -> 0x0066, Exception -> 0x0066 }
        r5 = "granted";	 Catch:{ Exception -> 0x0066, Exception -> 0x0066 }
        r1.append(r5);	 Catch:{ Exception -> 0x0066, Exception -> 0x0066 }
        r5 = r1.toString();	 Catch:{ Exception -> 0x0066, Exception -> 0x0066 }
        com.instabug.library.util.InstabugSDKLogger.m8356d(r4, r5);	 Catch:{ Exception -> 0x0066, Exception -> 0x0066 }
        return r3;
    L_0x0066:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.util.PermissionsUtils.isPermissionGranted(android.content.Context, java.lang.String):boolean");
    }

    public static void requestPermission(Activity activity, String str, int i, Runnable runnable, Runnable runnable2) {
        if (isPermissionGranted(activity, str)) {
            i = new StringBuilder("Permission ");
            i.append(str);
            i.append(" already granted, running after permission granted runnable");
            InstabugSDKLogger.m8356d(PermissionsUtils.class, i.toString());
            runIfValid(runnable2);
            return;
        }
        if (ActivityCompat.m9757a(activity, str) == null) {
            runIfValid(runnable);
        }
        runnable2 = new StringBuilder("Permission ");
        runnable2.append(str);
        runnable2.append(" not granted, requesting it");
        InstabugSDKLogger.m8356d(PermissionsUtils.class, runnable2.toString());
        ActivityCompat.m9756a(activity, new String[]{str}, i);
    }

    public static void requestPermission(Fragment fragment, String str, int i, Runnable runnable, Runnable runnable2) {
        if (isPermissionGranted(fragment.getContext(), str)) {
            i = new StringBuilder("Permission ");
            i.append(str);
            i.append(" already granted, running after permission granted runnable");
            InstabugSDKLogger.m8356d(PermissionsUtils.class, i.toString());
            runIfValid(runnable2);
            return;
        }
        if (fragment.shouldShowRequestPermissionRationale(str) == null) {
            runIfValid(runnable);
        }
        runnable2 = new StringBuilder("Permission ");
        runnable2.append(str);
        runnable2.append(" not granted, requesting it");
        InstabugSDKLogger.m8356d(PermissionsUtils.class, runnable2.toString());
        fragment.requestPermissions(new String[]{str}, i);
    }

    private static void runIfValid(Runnable runnable) {
        if (runnable != null) {
            runnable.run();
        }
    }
}
