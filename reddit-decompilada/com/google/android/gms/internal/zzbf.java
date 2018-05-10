package com.google.android.gms.internal;

import java.io.IOException;

public final class zzbf extends zzfjm<zzbf> {
    public byte[][] f17706a;
    public byte[] f17707b;
    public Integer f17708c;
    private Integer f17709d;

    public zzbf() {
        this.f17706a = zzfjv.f7565g;
        this.f17707b = null;
        this.Y = -1;
    }

    private final com.google.android.gms.internal.zzbf m17934b(com.google.android.gms.internal.zzfjj r7) throws java.io.IOException {
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
        if (r0 == 0) goto L_0x00b7;
    L_0x0006:
        r1 = 10;
        if (r0 == r1) goto L_0x0084;
    L_0x000a:
        r1 = 18;
        if (r0 == r1) goto L_0x007c;
    L_0x000e:
        r1 = 24;
        if (r0 == r1) goto L_0x0049;
    L_0x0012:
        r1 = 32;
        if (r0 == r1) goto L_0x001d;
    L_0x0016:
        r0 = super.m13900a(r7, r0);
        if (r0 != 0) goto L_0x0000;
    L_0x001c:
        return r6;
    L_0x001d:
        r1 = r7.m6151k();
        r2 = r7.m6146f();	 Catch:{ IllegalArgumentException -> 0x0075 }
        switch(r2) {
            case 0: goto L_0x002b;
            case 1: goto L_0x002b;
            case 2: goto L_0x002b;
            default: goto L_0x0028;
        };	 Catch:{ IllegalArgumentException -> 0x0075 }
    L_0x0028:
        r3 = new java.lang.IllegalArgumentException;	 Catch:{ IllegalArgumentException -> 0x0075 }
        goto L_0x0032;	 Catch:{ IllegalArgumentException -> 0x0075 }
    L_0x002b:
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ IllegalArgumentException -> 0x0075 }
        r6.f17708c = r2;	 Catch:{ IllegalArgumentException -> 0x0075 }
        goto L_0x0000;	 Catch:{ IllegalArgumentException -> 0x0075 }
    L_0x0032:
        r4 = 48;	 Catch:{ IllegalArgumentException -> 0x0075 }
        r5 = new java.lang.StringBuilder;	 Catch:{ IllegalArgumentException -> 0x0075 }
        r5.<init>(r4);	 Catch:{ IllegalArgumentException -> 0x0075 }
        r5.append(r2);	 Catch:{ IllegalArgumentException -> 0x0075 }
        r2 = " is not a valid enum EncryptionMethod";	 Catch:{ IllegalArgumentException -> 0x0075 }
        r5.append(r2);	 Catch:{ IllegalArgumentException -> 0x0075 }
        r2 = r5.toString();	 Catch:{ IllegalArgumentException -> 0x0075 }
        r3.<init>(r2);	 Catch:{ IllegalArgumentException -> 0x0075 }
        throw r3;	 Catch:{ IllegalArgumentException -> 0x0075 }
    L_0x0049:
        r1 = r7.m6151k();
        r2 = r7.m6146f();	 Catch:{ IllegalArgumentException -> 0x0075 }
        switch(r2) {
            case 0: goto L_0x0057;
            case 1: goto L_0x0057;
            default: goto L_0x0054;
        };	 Catch:{ IllegalArgumentException -> 0x0075 }
    L_0x0054:
        r3 = new java.lang.IllegalArgumentException;	 Catch:{ IllegalArgumentException -> 0x0075 }
        goto L_0x005e;	 Catch:{ IllegalArgumentException -> 0x0075 }
    L_0x0057:
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ IllegalArgumentException -> 0x0075 }
        r6.f17709d = r2;	 Catch:{ IllegalArgumentException -> 0x0075 }
        goto L_0x0000;	 Catch:{ IllegalArgumentException -> 0x0075 }
    L_0x005e:
        r4 = 41;	 Catch:{ IllegalArgumentException -> 0x0075 }
        r5 = new java.lang.StringBuilder;	 Catch:{ IllegalArgumentException -> 0x0075 }
        r5.<init>(r4);	 Catch:{ IllegalArgumentException -> 0x0075 }
        r5.append(r2);	 Catch:{ IllegalArgumentException -> 0x0075 }
        r2 = " is not a valid enum ProtoName";	 Catch:{ IllegalArgumentException -> 0x0075 }
        r5.append(r2);	 Catch:{ IllegalArgumentException -> 0x0075 }
        r2 = r5.toString();	 Catch:{ IllegalArgumentException -> 0x0075 }
        r3.<init>(r2);	 Catch:{ IllegalArgumentException -> 0x0075 }
        throw r3;	 Catch:{ IllegalArgumentException -> 0x0075 }
    L_0x0075:
        r7.m6144e(r1);
        r6.m13900a(r7, r0);
        goto L_0x0000;
    L_0x007c:
        r0 = r7.m6145e();
        r6.f17707b = r0;
        goto L_0x0000;
    L_0x0084:
        r0 = com.google.android.gms.internal.zzfjv.m6217a(r7, r1);
        r1 = r6.f17706a;
        r2 = 0;
        if (r1 != 0) goto L_0x008f;
    L_0x008d:
        r1 = r2;
        goto L_0x0092;
    L_0x008f:
        r1 = r6.f17706a;
        r1 = r1.length;
    L_0x0092:
        r0 = r0 + r1;
        r0 = new byte[r0][];
        if (r1 == 0) goto L_0x009c;
    L_0x0097:
        r3 = r6.f17706a;
        java.lang.System.arraycopy(r3, r2, r0, r2, r1);
    L_0x009c:
        r2 = r0.length;
        r2 = r2 + -1;
        if (r1 >= r2) goto L_0x00ad;
    L_0x00a1:
        r2 = r7.m6145e();
        r0[r1] = r2;
        r7.m6134a();
        r1 = r1 + 1;
        goto L_0x009c;
    L_0x00ad:
        r2 = r7.m6145e();
        r0[r1] = r2;
        r6.f17706a = r0;
        goto L_0x0000;
    L_0x00b7:
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzbf.b(com.google.android.gms.internal.zzfjj):com.google.android.gms.internal.zzbf");
    }

    protected final int mo1927a() {
        int a = super.mo1927a();
        if (this.f17706a != null && this.f17706a.length > 0) {
            int i = 0;
            int i2 = 0;
            int i3 = i2;
            while (i < this.f17706a.length) {
                byte[] bArr = this.f17706a[i];
                if (bArr != null) {
                    i3++;
                    i2 += zzfjk.m6165b(bArr);
                }
                i++;
            }
            a = (a + i2) + (1 * i3);
        }
        if (this.f17707b != null) {
            a += zzfjk.m6164b(2, this.f17707b);
        }
        if (this.f17709d != null) {
            a += zzfjk.m6161b(3, this.f17709d.intValue());
        }
        return this.f17708c != null ? a + zzfjk.m6161b(4, this.f17708c.intValue()) : a;
    }

    public final /* synthetic */ zzfjs mo3478a(zzfjj com_google_android_gms_internal_zzfjj) throws IOException {
        return m17934b(com_google_android_gms_internal_zzfjj);
    }

    public final void mo1928a(zzfjk com_google_android_gms_internal_zzfjk) throws IOException {
        if (this.f17706a != null && this.f17706a.length > 0) {
            for (byte[] bArr : this.f17706a) {
                if (bArr != null) {
                    com_google_android_gms_internal_zzfjk.m6179a(1, bArr);
                }
            }
        }
        if (this.f17707b != null) {
            com_google_android_gms_internal_zzfjk.m6179a(2, this.f17707b);
        }
        if (this.f17709d != null) {
            com_google_android_gms_internal_zzfjk.m6174a(3, this.f17709d.intValue());
        }
        if (this.f17708c != null) {
            com_google_android_gms_internal_zzfjk.m6174a(4, this.f17708c.intValue());
        }
        super.mo1928a(com_google_android_gms_internal_zzfjk);
    }
}
