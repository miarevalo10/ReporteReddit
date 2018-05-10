package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import com.google.android.gms.common.ConnectionResult;

public final class zzn extends zze {
    private IBinder f17340a;
    private /* synthetic */ zzd f17341b;

    public zzn(zzd com_google_android_gms_common_internal_zzd, int i, IBinder iBinder, Bundle bundle) {
        this.f17341b = com_google_android_gms_common_internal_zzd;
        super(com_google_android_gms_common_internal_zzd, i, bundle);
        this.f17340a = iBinder;
    }

    protected final void mo3427a(ConnectionResult connectionResult) {
        if (this.f17341b.f5930v != null) {
            this.f17341b.f5930v.mo1622a(connectionResult);
        }
        this.f17341b.m4844a(connectionResult);
    }

    protected final boolean mo3428a() {
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
        r6 = this;
        r0 = 0;
        r1 = r6.f17340a;	 Catch:{ RemoteException -> 0x0082 }
        r1 = r1.getInterfaceDescriptor();	 Catch:{ RemoteException -> 0x0082 }
        r2 = r6.f17341b;
        r2 = r2.mo1648b();
        r2 = r2.equals(r1);
        if (r2 != 0) goto L_0x004c;
    L_0x0013:
        r2 = "GmsClient";
        r3 = r6.f17341b;
        r3 = r3.mo1648b();
        r4 = 34;
        r5 = java.lang.String.valueOf(r3);
        r5 = r5.length();
        r4 = r4 + r5;
        r5 = java.lang.String.valueOf(r1);
        r5 = r5.length();
        r4 = r4 + r5;
        r5 = new java.lang.StringBuilder;
        r5.<init>(r4);
        r4 = "service descriptor mismatch: ";
        r5.append(r4);
        r5.append(r3);
        r3 = " vs. ";
        r5.append(r3);
        r5.append(r1);
        r1 = r5.toString();
        android.util.Log.e(r2, r1);
        return r0;
    L_0x004c:
        r1 = r6.f17341b;
        r2 = r6.f17340a;
        r1 = r1.mo1646a(r2);
        if (r1 == 0) goto L_0x0081;
    L_0x0056:
        r2 = r6.f17341b;
        r3 = 2;
        r4 = 4;
        r2 = r2.m4828a(r3, r4, r1);
        if (r2 != 0) goto L_0x0069;
    L_0x0060:
        r2 = r6.f17341b;
        r3 = 3;
        r1 = r2.m4828a(r3, r4, r1);
        if (r1 == 0) goto L_0x0081;
    L_0x0069:
        r0 = r6.f17341b;
        r1 = 0;
        r0.f5933y = r1;
        r0 = r6.f17341b;
        r0 = r0.f5929u;
        if (r0 == 0) goto L_0x0080;
    L_0x0077:
        r0 = r6.f17341b;
        r0 = r0.f5929u;
        r0.mo1620a();
    L_0x0080:
        r0 = 1;
    L_0x0081:
        return r0;
    L_0x0082:
        r1 = "GmsClient";
        r2 = "service probably died";
        android.util.Log.w(r1, r2);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.zzn.a():boolean");
    }
}
