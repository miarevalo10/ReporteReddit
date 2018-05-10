package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;

public final class SignInConfiguration extends zzbfm implements ReflectedParcelable {
    public static final Creator<SignInConfiguration> CREATOR = new zzx();
    GoogleSignInOptions f17248a;
    private final String f17249b;

    public SignInConfiguration(String str, GoogleSignInOptions googleSignInOptions) {
        this.f17249b = zzbq.m4810a(str);
        this.f17248a = googleSignInOptions;
    }

    public final boolean equals(java.lang.Object r4) {
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
        r3 = this;
        r0 = 0;
        if (r4 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r4 = (com.google.android.gms.auth.api.signin.internal.SignInConfiguration) r4;	 Catch:{ ClassCastException -> 0x0025 }
        r1 = r3.f17249b;	 Catch:{ ClassCastException -> 0x0025 }
        r2 = r4.f17249b;	 Catch:{ ClassCastException -> 0x0025 }
        r1 = r1.equals(r2);	 Catch:{ ClassCastException -> 0x0025 }
        if (r1 == 0) goto L_0x0025;	 Catch:{ ClassCastException -> 0x0025 }
    L_0x0010:
        r1 = r3.f17248a;	 Catch:{ ClassCastException -> 0x0025 }
        if (r1 != 0) goto L_0x0019;	 Catch:{ ClassCastException -> 0x0025 }
    L_0x0014:
        r4 = r4.f17248a;	 Catch:{ ClassCastException -> 0x0025 }
        if (r4 != 0) goto L_0x0025;	 Catch:{ ClassCastException -> 0x0025 }
    L_0x0018:
        goto L_0x0023;	 Catch:{ ClassCastException -> 0x0025 }
    L_0x0019:
        r1 = r3.f17248a;	 Catch:{ ClassCastException -> 0x0025 }
        r4 = r4.f17248a;	 Catch:{ ClassCastException -> 0x0025 }
        r4 = r1.equals(r4);	 Catch:{ ClassCastException -> 0x0025 }
        if (r4 == 0) goto L_0x0025;
    L_0x0023:
        r4 = 1;
        return r4;
    L_0x0025:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.api.signin.internal.SignInConfiguration.equals(java.lang.Object):boolean");
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = zzbfp.m5536a(parcel);
        zzbfp.m5545a(parcel, 2, this.f17249b);
        zzbfp.m5544a(parcel, 5, this.f17248a, i);
        zzbfp.m5537a(parcel, a);
    }

    public final int hashCode() {
        return new zzp().m4610a(this.f17249b).m4610a(this.f17248a).f5722a;
    }
}
