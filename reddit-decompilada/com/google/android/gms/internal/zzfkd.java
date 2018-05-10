package com.google.android.gms.internal;

import java.io.IOException;

public final class zzfkd extends zzfjm<zzfkd> {
    public Integer f18082a;
    public String f18083b;
    public byte[] f18084c;

    public zzfkd() {
        this.f18082a = null;
        this.f18083b = null;
        this.f18084c = null;
        this.X = null;
        this.Y = -1;
    }

    protected final int mo1927a() {
        int a = super.mo1927a();
        if (this.f18082a != null) {
            a += zzfjk.m6161b(1, this.f18082a.intValue());
        }
        if (this.f18083b != null) {
            a += zzfjk.m6163b(2, this.f18083b);
        }
        return this.f18084c != null ? a + zzfjk.m6164b(3, this.f18084c) : a;
    }

    public final /* synthetic */ zzfjs mo3478a(zzfjj com_google_android_gms_internal_zzfjj) throws IOException {
        return m18728b(com_google_android_gms_internal_zzfjj);
    }

    public final void mo1928a(zzfjk com_google_android_gms_internal_zzfjk) throws IOException {
        if (this.f18082a != null) {
            com_google_android_gms_internal_zzfjk.m6174a(1, this.f18082a.intValue());
        }
        if (this.f18083b != null) {
            com_google_android_gms_internal_zzfjk.m6177a(2, this.f18083b);
        }
        if (this.f18084c != null) {
            com_google_android_gms_internal_zzfjk.m6179a(3, this.f18084c);
        }
        super.mo1928a(com_google_android_gms_internal_zzfjk);
    }

    private final com.google.android.gms.internal.zzfkd m18728b(com.google.android.gms.internal.zzfjj r7) throws java.io.IOException {
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
        if (r0 == 0) goto L_0x005a;
    L_0x0006:
        r1 = 8;
        if (r0 == r1) goto L_0x0027;
    L_0x000a:
        r1 = 18;
        if (r0 == r1) goto L_0x0020;
    L_0x000e:
        r1 = 26;
        if (r0 == r1) goto L_0x0019;
    L_0x0012:
        r0 = super.m13900a(r7, r0);
        if (r0 != 0) goto L_0x0000;
    L_0x0018:
        return r6;
    L_0x0019:
        r0 = r7.m6145e();
        r6.f18084c = r0;
        goto L_0x0000;
    L_0x0020:
        r0 = r7.m6142d();
        r6.f18083b = r0;
        goto L_0x0000;
    L_0x0027:
        r1 = r7.m6151k();
        r2 = r7.m6146f();	 Catch:{ IllegalArgumentException -> 0x0053 }
        switch(r2) {
            case 0: goto L_0x0035;
            case 1: goto L_0x0035;
            default: goto L_0x0032;
        };	 Catch:{ IllegalArgumentException -> 0x0053 }
    L_0x0032:
        r3 = new java.lang.IllegalArgumentException;	 Catch:{ IllegalArgumentException -> 0x0053 }
        goto L_0x003c;	 Catch:{ IllegalArgumentException -> 0x0053 }
    L_0x0035:
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ IllegalArgumentException -> 0x0053 }
        r6.f18082a = r2;	 Catch:{ IllegalArgumentException -> 0x0053 }
        goto L_0x0000;	 Catch:{ IllegalArgumentException -> 0x0053 }
    L_0x003c:
        r4 = 36;	 Catch:{ IllegalArgumentException -> 0x0053 }
        r5 = new java.lang.StringBuilder;	 Catch:{ IllegalArgumentException -> 0x0053 }
        r5.<init>(r4);	 Catch:{ IllegalArgumentException -> 0x0053 }
        r5.append(r2);	 Catch:{ IllegalArgumentException -> 0x0053 }
        r2 = " is not a valid enum Type";	 Catch:{ IllegalArgumentException -> 0x0053 }
        r5.append(r2);	 Catch:{ IllegalArgumentException -> 0x0053 }
        r2 = r5.toString();	 Catch:{ IllegalArgumentException -> 0x0053 }
        r3.<init>(r2);	 Catch:{ IllegalArgumentException -> 0x0053 }
        throw r3;	 Catch:{ IllegalArgumentException -> 0x0053 }
    L_0x0053:
        r7.m6144e(r1);
        r6.m13900a(r7, r0);
        goto L_0x0000;
    L_0x005a:
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzfkd.b(com.google.android.gms.internal.zzfjj):com.google.android.gms.internal.zzfkd");
    }
}
