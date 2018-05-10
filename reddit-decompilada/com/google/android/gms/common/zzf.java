package com.google.android.gms.common;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.internal.zzak;
import com.google.android.gms.common.util.zzi;

public class zzf {
    private static final zzf f5974a = new zzf();
    public static final int f5975b = zzp.GOOGLE_PLAY_SERVICES_VERSION_CODE;

    zzf() {
    }

    public static PendingIntent m4927a(Context context, int i, int i2, String str) {
        Intent a = m4928a(context, i, str);
        return a == null ? null : PendingIntent.getActivity(context, i2, a, 268435456);
    }

    public static Intent m4928a(Context context, int i, String str) {
        switch (i) {
            case 1:
            case 2:
                return (context == null || !zzi.m4902a(context)) ? zzak.m4793a("com.google.android.gms", m4929a(context, str)) : zzak.m4791a();
            case 3:
                return zzak.m4792a("com.google.android.gms");
            default:
                return null;
        }
    }

    private static java.lang.String m4929a(android.content.Context r2, java.lang.String r3) {
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
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = "gcore_";
        r0.append(r1);
        r1 = f5975b;
        r0.append(r1);
        r1 = "-";
        r0.append(r1);
        r1 = android.text.TextUtils.isEmpty(r3);
        if (r1 != 0) goto L_0x001d;
    L_0x001a:
        r0.append(r3);
    L_0x001d:
        r3 = "-";
        r0.append(r3);
        if (r2 == 0) goto L_0x002b;
    L_0x0024:
        r3 = r2.getPackageName();
        r0.append(r3);
    L_0x002b:
        r3 = "-";
        r0.append(r3);
        if (r2 == 0) goto L_0x0044;
    L_0x0032:
        r3 = com.google.android.gms.internal.zzbhf.m5574a(r2);	 Catch:{ NameNotFoundException -> 0x0044 }
        r2 = r2.getPackageName();	 Catch:{ NameNotFoundException -> 0x0044 }
        r1 = 0;	 Catch:{ NameNotFoundException -> 0x0044 }
        r2 = r3.m5572b(r2, r1);	 Catch:{ NameNotFoundException -> 0x0044 }
        r2 = r2.versionCode;	 Catch:{ NameNotFoundException -> 0x0044 }
        r0.append(r2);	 Catch:{ NameNotFoundException -> 0x0044 }
    L_0x0044:
        r2 = r0.toString();
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.zzf.a(android.content.Context, java.lang.String):java.lang.String");
    }

    public static zzf m4930b() {
        return f5974a;
    }

    public static boolean m4931b(Context context, int i) {
        return zzp.zze(context, i);
    }

    @Deprecated
    public static Intent m4932c(int i) {
        return m4928a(null, i, null);
    }

    public static void m4933c(Context context) {
        zzp.zzce(context);
    }

    public static int m4934d(Context context) {
        return zzp.zzcf(context);
    }

    public int mo1537a(Context context) {
        int isGooglePlayServicesAvailable = zzp.isGooglePlayServicesAvailable(context);
        return zzp.zze(context, isGooglePlayServicesAvailable) ? 18 : isGooglePlayServicesAvailable;
    }

    public PendingIntent mo1538a(Context context, int i, int i2) {
        return m4927a(context, i, i2, null);
    }

    public boolean mo1539a(int i) {
        return zzp.isUserRecoverableError(i);
    }

    public String mo1540b(int i) {
        return zzp.getErrorString(i);
    }
}
