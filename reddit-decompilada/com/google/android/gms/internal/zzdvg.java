package com.google.android.gms.internal;

import java.security.GeneralSecurityException;
import java.security.Key;
import javax.crypto.Mac;

public final class zzdvg implements zzdqa {
    private Mac f14396a;
    private final int f14397b;
    private final String f14398c;
    private final Key f14399d;

    public zzdvg(String str, Key key, int i) throws GeneralSecurityException {
        this.f14398c = str;
        this.f14397b = i;
        this.f14399d = key;
        this.f14396a = (Mac) zzduu.f7328b.m5911a(str);
        this.f14396a.init(key);
    }

    public final byte[] mo1868a(byte[] r4) throws java.security.GeneralSecurityException {
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
        r3 = this;
        r0 = r3.f14396a;	 Catch:{ CloneNotSupportedException -> 0x0009 }
        r0 = r0.clone();	 Catch:{ CloneNotSupportedException -> 0x0009 }
        r0 = (javax.crypto.Mac) r0;	 Catch:{ CloneNotSupportedException -> 0x0009 }
        goto L_0x0018;
    L_0x0009:
        r0 = com.google.android.gms.internal.zzduu.f7328b;
        r1 = r3.f14398c;
        r0 = r0.m5911a(r1);
        r0 = (javax.crypto.Mac) r0;
        r1 = r3.f14399d;
        r0.init(r1);
    L_0x0018:
        r0.update(r4);
        r4 = r3.f14397b;
        r4 = new byte[r4];
        r0 = r0.doFinal();
        r1 = r3.f14397b;
        r2 = 0;
        java.lang.System.arraycopy(r0, r2, r4, r2, r1);
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzdvg.a(byte[]):byte[]");
    }
}
