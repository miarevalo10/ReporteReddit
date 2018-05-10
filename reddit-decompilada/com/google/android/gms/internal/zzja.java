package com.google.android.gms.internal;

import java.io.IOException;

public final class zzja extends zzfjm<zzja> {
    public Integer f18122a;

    public zzja() {
        this.f18122a = null;
        this.X = null;
        this.Y = -1;
    }

    private final com.google.android.gms.internal.zzja m18753b(com.google.android.gms.internal.zzfjj r7) throws java.io.IOException {
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
    L_0x0000:
        r0 = r7.m6134a();
        if (r0 == 0) goto L_0x0044;
    L_0x0006:
        r1 = 56;
        if (r0 == r1) goto L_0x0011;
    L_0x000a:
        r0 = super.m13900a(r7, r0);
        if (r0 != 0) goto L_0x0000;
    L_0x0010:
        return r6;
    L_0x0011:
        r1 = r7.m6151k();
        r2 = r7.m6146f();	 Catch:{ IllegalArgumentException -> 0x003d }
        switch(r2) {
            case 0: goto L_0x001f;
            case 1: goto L_0x001f;
            case 2: goto L_0x001f;
            case 3: goto L_0x001f;
            case 4: goto L_0x001f;
            case 5: goto L_0x001f;
            case 6: goto L_0x001f;
            case 7: goto L_0x001f;
            case 8: goto L_0x001f;
            case 9: goto L_0x001f;
            default: goto L_0x001c;
        };	 Catch:{ IllegalArgumentException -> 0x003d }
    L_0x001c:
        r3 = new java.lang.IllegalArgumentException;	 Catch:{ IllegalArgumentException -> 0x003d }
        goto L_0x0026;	 Catch:{ IllegalArgumentException -> 0x003d }
    L_0x001f:
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ IllegalArgumentException -> 0x003d }
        r6.f18122a = r2;	 Catch:{ IllegalArgumentException -> 0x003d }
        goto L_0x0000;	 Catch:{ IllegalArgumentException -> 0x003d }
    L_0x0026:
        r4 = 43;	 Catch:{ IllegalArgumentException -> 0x003d }
        r5 = new java.lang.StringBuilder;	 Catch:{ IllegalArgumentException -> 0x003d }
        r5.<init>(r4);	 Catch:{ IllegalArgumentException -> 0x003d }
        r5.append(r2);	 Catch:{ IllegalArgumentException -> 0x003d }
        r2 = " is not a valid enum AdInitiater";	 Catch:{ IllegalArgumentException -> 0x003d }
        r5.append(r2);	 Catch:{ IllegalArgumentException -> 0x003d }
        r2 = r5.toString();	 Catch:{ IllegalArgumentException -> 0x003d }
        r3.<init>(r2);	 Catch:{ IllegalArgumentException -> 0x003d }
        throw r3;	 Catch:{ IllegalArgumentException -> 0x003d }
    L_0x003d:
        r7.m6144e(r1);
        r6.m13900a(r7, r0);
        goto L_0x0000;
    L_0x0044:
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzja.b(com.google.android.gms.internal.zzfjj):com.google.android.gms.internal.zzja");
    }

    protected final int mo1927a() {
        int a = super.mo1927a();
        return this.f18122a != null ? a + zzfjk.m6161b(7, this.f18122a.intValue()) : a;
    }

    public final /* synthetic */ zzfjs mo3478a(zzfjj com_google_android_gms_internal_zzfjj) throws IOException {
        return m18753b(com_google_android_gms_internal_zzfjj);
    }

    public final void mo1928a(zzfjk com_google_android_gms_internal_zzfjk) throws IOException {
        if (this.f18122a != null) {
            com_google_android_gms_internal_zzfjk.m6174a(7, this.f18122a.intValue());
        }
        super.mo1928a(com_google_android_gms_internal_zzfjk);
    }
}
