package com.google.android.gms.internal;

import java.io.IOException;

public final class zzfke extends zzfjm<zzfke> {
    private static volatile zzfke[] f18085f;
    public Integer f18086a;
    public String f18087b;
    public zzfjz f18088c;
    public Integer f18089d;
    public String[] f18090e;
    private zzfkb f18091g;
    private Integer f18092h;
    private int[] f18093i;
    private String f18094j;

    public zzfke() {
        this.f18086a = null;
        this.f18087b = null;
        this.f18088c = null;
        this.f18091g = null;
        this.f18092h = null;
        this.f18093i = zzfjv.f7559a;
        this.f18094j = null;
        this.f18089d = null;
        this.f18090e = zzfjv.f7564f;
        this.X = null;
        this.Y = -1;
    }

    public static zzfke[] m18733b() {
        if (f18085f == null) {
            synchronized (zzfjq.f7554b) {
                if (f18085f == null) {
                    f18085f = new zzfke[0];
                }
            }
        }
        return f18085f;
    }

    protected final int mo1927a() {
        int i;
        int i2;
        int a = super.mo1927a() + zzfjk.m6161b(1, this.f18086a.intValue());
        if (this.f18087b != null) {
            a += zzfjk.m6163b(2, this.f18087b);
        }
        if (this.f18088c != null) {
            a += zzfjk.m6162b(3, this.f18088c);
        }
        if (this.f18091g != null) {
            a += zzfjk.m6162b(4, this.f18091g);
        }
        if (this.f18092h != null) {
            a += zzfjk.m6161b(5, this.f18092h.intValue());
        }
        int i3 = 0;
        if (this.f18093i != null && this.f18093i.length > 0) {
            i = 0;
            i2 = i;
            while (i < this.f18093i.length) {
                i2 += zzfjk.m6152a(this.f18093i[i]);
                i++;
            }
            a = (a + i2) + (this.f18093i.length * 1);
        }
        if (this.f18094j != null) {
            a += zzfjk.m6163b(7, this.f18094j);
        }
        if (this.f18089d != null) {
            a += zzfjk.m6161b(8, this.f18089d.intValue());
        }
        if (this.f18090e == null || this.f18090e.length <= 0) {
            return a;
        }
        i = 0;
        i2 = i;
        while (i3 < this.f18090e.length) {
            String str = this.f18090e[i3];
            if (str != null) {
                i2++;
                i += zzfjk.m6156a(str);
            }
            i3++;
        }
        return (a + i) + (1 * i2);
    }

    public final /* synthetic */ zzfjs mo3478a(zzfjj com_google_android_gms_internal_zzfjj) throws IOException {
        return m18732b(com_google_android_gms_internal_zzfjj);
    }

    public final void mo1928a(zzfjk com_google_android_gms_internal_zzfjk) throws IOException {
        com_google_android_gms_internal_zzfjk.m6174a(1, this.f18086a.intValue());
        if (this.f18087b != null) {
            com_google_android_gms_internal_zzfjk.m6177a(2, this.f18087b);
        }
        if (this.f18088c != null) {
            com_google_android_gms_internal_zzfjk.m6176a(3, this.f18088c);
        }
        if (this.f18091g != null) {
            com_google_android_gms_internal_zzfjk.m6176a(4, this.f18091g);
        }
        if (this.f18092h != null) {
            com_google_android_gms_internal_zzfjk.m6174a(5, this.f18092h.intValue());
        }
        int i = 0;
        if (this.f18093i != null && this.f18093i.length > 0) {
            for (int a : this.f18093i) {
                com_google_android_gms_internal_zzfjk.m6174a(6, a);
            }
        }
        if (this.f18094j != null) {
            com_google_android_gms_internal_zzfjk.m6177a(7, this.f18094j);
        }
        if (this.f18089d != null) {
            com_google_android_gms_internal_zzfjk.m6174a(8, this.f18089d.intValue());
        }
        if (this.f18090e != null && this.f18090e.length > 0) {
            while (i < this.f18090e.length) {
                String str = this.f18090e[i];
                if (str != null) {
                    com_google_android_gms_internal_zzfjk.m6177a(9, str);
                }
                i++;
            }
        }
        super.mo1928a(com_google_android_gms_internal_zzfjk);
    }

    private final com.google.android.gms.internal.zzfke m18732b(com.google.android.gms.internal.zzfjj r7) throws java.io.IOException {
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
        r1 = 0;
        switch(r0) {
            case 0: goto L_0x0132;
            case 8: goto L_0x0126;
            case 18: goto L_0x011e;
            case 26: goto L_0x010c;
            case 34: goto L_0x00fe;
            case 40: goto L_0x00f2;
            case 48: goto L_0x00be;
            case 50: goto L_0x007c;
            case 58: goto L_0x0075;
            case 64: goto L_0x0042;
            case 74: goto L_0x000f;
            default: goto L_0x0008;
        };
    L_0x0008:
        r0 = super.m13900a(r7, r0);
        if (r0 != 0) goto L_0x0000;
    L_0x000e:
        return r6;
    L_0x000f:
        r0 = 74;
        r0 = com.google.android.gms.internal.zzfjv.m6217a(r7, r0);
        r2 = r6.f18090e;
        if (r2 != 0) goto L_0x001b;
    L_0x0019:
        r2 = r1;
        goto L_0x001e;
    L_0x001b:
        r2 = r6.f18090e;
        r2 = r2.length;
    L_0x001e:
        r0 = r0 + r2;
        r0 = new java.lang.String[r0];
        if (r2 == 0) goto L_0x0028;
    L_0x0023:
        r3 = r6.f18090e;
        java.lang.System.arraycopy(r3, r1, r0, r1, r2);
    L_0x0028:
        r1 = r0.length;
        r1 = r1 + -1;
        if (r2 >= r1) goto L_0x0039;
    L_0x002d:
        r1 = r7.m6142d();
        r0[r2] = r1;
        r7.m6134a();
        r2 = r2 + 1;
        goto L_0x0028;
    L_0x0039:
        r1 = r7.m6142d();
        r0[r2] = r1;
        r6.f18090e = r0;
        goto L_0x0000;
    L_0x0042:
        r1 = r7.m6151k();
        r2 = r7.m6146f();	 Catch:{ IllegalArgumentException -> 0x006e }
        switch(r2) {
            case 0: goto L_0x0050;
            case 1: goto L_0x0050;
            case 2: goto L_0x0050;
            case 3: goto L_0x0050;
            default: goto L_0x004d;
        };	 Catch:{ IllegalArgumentException -> 0x006e }
    L_0x004d:
        r3 = new java.lang.IllegalArgumentException;	 Catch:{ IllegalArgumentException -> 0x006e }
        goto L_0x0057;	 Catch:{ IllegalArgumentException -> 0x006e }
    L_0x0050:
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ IllegalArgumentException -> 0x006e }
        r6.f18089d = r2;	 Catch:{ IllegalArgumentException -> 0x006e }
        goto L_0x0000;	 Catch:{ IllegalArgumentException -> 0x006e }
    L_0x0057:
        r4 = 46;	 Catch:{ IllegalArgumentException -> 0x006e }
        r5 = new java.lang.StringBuilder;	 Catch:{ IllegalArgumentException -> 0x006e }
        r5.<init>(r4);	 Catch:{ IllegalArgumentException -> 0x006e }
        r5.append(r2);	 Catch:{ IllegalArgumentException -> 0x006e }
        r2 = " is not a valid enum AdResourceType";	 Catch:{ IllegalArgumentException -> 0x006e }
        r5.append(r2);	 Catch:{ IllegalArgumentException -> 0x006e }
        r2 = r5.toString();	 Catch:{ IllegalArgumentException -> 0x006e }
        r3.<init>(r2);	 Catch:{ IllegalArgumentException -> 0x006e }
        throw r3;	 Catch:{ IllegalArgumentException -> 0x006e }
    L_0x006e:
        r7.m6144e(r1);
        r6.m13900a(r7, r0);
        goto L_0x0000;
    L_0x0075:
        r0 = r7.m6142d();
        r6.f18094j = r0;
        goto L_0x0000;
    L_0x007c:
        r0 = r7.m6146f();
        r0 = r7.m6140c(r0);
        r2 = r7.m6151k();
        r3 = r1;
    L_0x0089:
        r4 = r7.m6150j();
        if (r4 <= 0) goto L_0x0095;
    L_0x008f:
        r7.m6146f();
        r3 = r3 + 1;
        goto L_0x0089;
    L_0x0095:
        r7.m6144e(r2);
        r2 = r6.f18093i;
        if (r2 != 0) goto L_0x009e;
    L_0x009c:
        r2 = r1;
        goto L_0x00a1;
    L_0x009e:
        r2 = r6.f18093i;
        r2 = r2.length;
    L_0x00a1:
        r3 = r3 + r2;
        r3 = new int[r3];
        if (r2 == 0) goto L_0x00ab;
    L_0x00a6:
        r4 = r6.f18093i;
        java.lang.System.arraycopy(r4, r1, r3, r1, r2);
    L_0x00ab:
        r1 = r3.length;
        if (r2 >= r1) goto L_0x00b7;
    L_0x00ae:
        r1 = r7.m6146f();
        r3[r2] = r1;
        r2 = r2 + 1;
        goto L_0x00ab;
    L_0x00b7:
        r6.f18093i = r3;
        r7.m6143d(r0);
        goto L_0x0000;
    L_0x00be:
        r0 = 48;
        r0 = com.google.android.gms.internal.zzfjv.m6217a(r7, r0);
        r2 = r6.f18093i;
        if (r2 != 0) goto L_0x00ca;
    L_0x00c8:
        r2 = r1;
        goto L_0x00cd;
    L_0x00ca:
        r2 = r6.f18093i;
        r2 = r2.length;
    L_0x00cd:
        r0 = r0 + r2;
        r0 = new int[r0];
        if (r2 == 0) goto L_0x00d7;
    L_0x00d2:
        r3 = r6.f18093i;
        java.lang.System.arraycopy(r3, r1, r0, r1, r2);
    L_0x00d7:
        r1 = r0.length;
        r1 = r1 + -1;
        if (r2 >= r1) goto L_0x00e8;
    L_0x00dc:
        r1 = r7.m6146f();
        r0[r2] = r1;
        r7.m6134a();
        r2 = r2 + 1;
        goto L_0x00d7;
    L_0x00e8:
        r1 = r7.m6146f();
        r0[r2] = r1;
        r6.f18093i = r0;
        goto L_0x0000;
    L_0x00f2:
        r0 = r7.m6146f();
        r0 = java.lang.Integer.valueOf(r0);
        r6.f18092h = r0;
        goto L_0x0000;
    L_0x00fe:
        r0 = r6.f18091g;
        if (r0 != 0) goto L_0x0109;
    L_0x0102:
        r0 = new com.google.android.gms.internal.zzfkb;
        r0.<init>();
        r6.f18091g = r0;
    L_0x0109:
        r0 = r6.f18091g;
        goto L_0x0119;
    L_0x010c:
        r0 = r6.f18088c;
        if (r0 != 0) goto L_0x0117;
    L_0x0110:
        r0 = new com.google.android.gms.internal.zzfjz;
        r0.<init>();
        r6.f18088c = r0;
    L_0x0117:
        r0 = r6.f18088c;
    L_0x0119:
        r7.m6137a(r0);
        goto L_0x0000;
    L_0x011e:
        r0 = r7.m6142d();
        r6.f18087b = r0;
        goto L_0x0000;
    L_0x0126:
        r0 = r7.m6146f();
        r0 = java.lang.Integer.valueOf(r0);
        r6.f18086a = r0;
        goto L_0x0000;
    L_0x0132:
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzfke.b(com.google.android.gms.internal.zzfjj):com.google.android.gms.internal.zzfke");
    }
}
