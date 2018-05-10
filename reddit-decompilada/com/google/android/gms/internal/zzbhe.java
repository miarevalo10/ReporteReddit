package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Binder;
import android.os.Process;
import com.google.android.gms.common.util.zzq;

public final class zzbhe {
    public Context f6711a;

    public zzbhe(Context context) {
        this.f6711a = context;
    }

    public final int m5568a(String str) {
        return this.f6711a.checkCallingOrSelfPermission(str);
    }

    public final ApplicationInfo m5569a(String str, int i) throws NameNotFoundException {
        return this.f6711a.getPackageManager().getApplicationInfo(str, i);
    }

    public final boolean m5570a() {
        if (Binder.getCallingUid() == Process.myUid()) {
            return zzbhd.m5567a(this.f6711a);
        }
        if (zzq.m4917i()) {
            String nameForUid = this.f6711a.getPackageManager().getNameForUid(Binder.getCallingUid());
            if (nameForUid != null) {
                return this.f6711a.getPackageManager().isInstantApp(nameForUid);
            }
        }
        return false;
    }

    @android.annotation.TargetApi(19)
    public final boolean m5571a(int r5, java.lang.String r6) {
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
        r4 = this;
        r0 = com.google.android.gms.common.util.zzq.m4913e();
        r1 = 0;
        r2 = 1;
        if (r0 == 0) goto L_0x0017;
    L_0x0008:
        r0 = r4.f6711a;	 Catch:{ SecurityException -> 0x0016 }
        r3 = "appops";	 Catch:{ SecurityException -> 0x0016 }
        r0 = r0.getSystemService(r3);	 Catch:{ SecurityException -> 0x0016 }
        r0 = (android.app.AppOpsManager) r0;	 Catch:{ SecurityException -> 0x0016 }
        r0.checkPackage(r5, r6);	 Catch:{ SecurityException -> 0x0016 }
        return r2;
    L_0x0016:
        return r1;
    L_0x0017:
        r0 = r4.f6711a;
        r0 = r0.getPackageManager();
        r5 = r0.getPackagesForUid(r5);
        if (r6 == 0) goto L_0x0035;
    L_0x0023:
        if (r5 == 0) goto L_0x0035;
    L_0x0025:
        r0 = r1;
    L_0x0026:
        r3 = r5.length;
        if (r0 >= r3) goto L_0x0035;
    L_0x0029:
        r3 = r5[r0];
        r3 = r6.equals(r3);
        if (r3 == 0) goto L_0x0032;
    L_0x0031:
        return r2;
    L_0x0032:
        r0 = r0 + 1;
        goto L_0x0026;
    L_0x0035:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzbhe.a(int, java.lang.String):boolean");
    }

    public final PackageInfo m5572b(String str, int i) throws NameNotFoundException {
        return this.f6711a.getPackageManager().getPackageInfo(str, i);
    }

    public final CharSequence m5573b(String str) throws NameNotFoundException {
        return this.f6711a.getPackageManager().getApplicationLabel(this.f6711a.getPackageManager().getApplicationInfo(str, 0));
    }
}
