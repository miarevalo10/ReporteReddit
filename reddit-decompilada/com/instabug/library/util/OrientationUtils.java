package com.instabug.library.util;

import android.app.Activity;
import android.view.WindowManager;
import com.instabug.library.Instabug;
import com.instabug.library.settings.SettingsManager;

public class OrientationUtils {
    public static int getOrientation(int i) {
        switch (i) {
            case -1:
                return -1;
            case 0:
                return 0;
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
            case 5:
                return 5;
            case 6:
                return 6;
            case 8:
                return 8;
            case 9:
                return 9;
            case 10:
                return 10;
            case 11:
                return 11;
            case 12:
                return 12;
            case 13:
                return 13;
            case 14:
                return 14;
            default:
                return -1;
        }
    }

    private OrientationUtils() {
    }

    public static void unlockOrientation(android.app.Activity r4) {
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
        if (r4 == 0) goto L_0x003f;
    L_0x0002:
        r0 = com.instabug.library.util.OrientationUtils.class;
        r1 = new java.lang.StringBuilder;
        r2 = "Unlocking orientation for activity ";
        r1.<init>(r2);
        r2 = r4.toString();
        r1.append(r2);
        r1 = r1.toString();
        com.instabug.library.util.InstabugSDKLogger.m8356d(r0, r1);
        r0 = new android.content.ComponentName;
        r1 = r4.getClass();
        r0.<init>(r4, r1);
        r1 = r4.getPackageManager();
        r2 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
        r3 = -1;
        r0 = r1.getActivityInfo(r0, r2);	 Catch:{ NameNotFoundException -> 0x0037, Exception -> 0x0033 }
        r0 = r0.screenOrientation;	 Catch:{ NameNotFoundException -> 0x0037, Exception -> 0x0033 }
        r4.setRequestedOrientation(r0);	 Catch:{ NameNotFoundException -> 0x0037, Exception -> 0x0033 }
        return;
    L_0x0033:
        r4.setRequestedOrientation(r3);
        goto L_0x003f;
    L_0x0037:
        r0 = move-exception;
        r0.printStackTrace();
        r4.setRequestedOrientation(r3);
        return;
    L_0x003f:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.util.OrientationUtils.unlockOrientation(android.app.Activity):void");
    }

    public static void lockScreenOrientation(Activity activity) {
        StringBuilder stringBuilder = new StringBuilder("Locking orientation for activity ");
        stringBuilder.append(activity.toString());
        InstabugSDKLogger.m8356d(OrientationUtils.class, stringBuilder.toString());
        int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
        switch (activity.getResources().getConfiguration().orientation) {
            case 1:
                if (rotation != 1) {
                    if (rotation != 2) {
                        activity.setRequestedOrientation(1);
                        return;
                    }
                }
                activity.setRequestedOrientation(9);
                return;
            case 2:
                if (rotation != 0) {
                    if (rotation != 1) {
                        activity.setRequestedOrientation(8);
                        break;
                    }
                }
                activity.setRequestedOrientation(0);
                return;
            default:
                break;
        }
    }

    public static void handelOrientation(Activity activity) {
        if (SettingsManager.getInstance().getRequestedOrientation() == -2) {
            lockScreenOrientation(activity);
        } else {
            activity.setRequestedOrientation(Instabug.getRequestedOrientation());
        }
    }

    public static boolean isInLandscape(Activity activity) {
        if (activity == null) {
            return false;
        }
        switch (((WindowManager) activity.getSystemService("window")).getDefaultDisplay().getOrientation()) {
            case null:
                return false;
            case 1:
                return true;
            case 2:
                return false;
            default:
                return true;
        }
    }
}
