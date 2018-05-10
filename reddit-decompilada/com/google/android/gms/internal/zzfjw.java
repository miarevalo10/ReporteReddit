package com.google.android.gms.internal;

import java.io.IOException;

public final class zzfjw extends zzfjm<zzfjw> {
    public Integer f18045a;
    public String f18046b;
    public String f18047c;
    public zzfjx f18048d;
    public zzfke[] f18049e;
    public String f18050f;
    public zzfkd f18051g;
    public zzfkf f18052h;
    private Integer f18053i;
    private String f18054j;
    private Boolean f18055k;
    private String[] f18056l;
    private String f18057m;
    private Boolean f18058n;
    private Boolean f18059o;
    private byte[] f18060p;

    public zzfjw() {
        this.f18045a = null;
        this.f18053i = null;
        this.f18046b = null;
        this.f18047c = null;
        this.f18054j = null;
        this.f18048d = null;
        this.f18049e = zzfke.m18733b();
        this.f18050f = null;
        this.f18051g = null;
        this.f18055k = null;
        this.f18056l = zzfjv.f7564f;
        this.f18057m = null;
        this.f18058n = null;
        this.f18059o = null;
        this.f18060p = null;
        this.f18052h = null;
        this.X = null;
        this.Y = -1;
    }

    protected final int mo1927a() {
        int i;
        int a = super.mo1927a();
        if (this.f18046b != null) {
            a += zzfjk.m6163b(1, this.f18046b);
        }
        if (this.f18047c != null) {
            a += zzfjk.m6163b(2, this.f18047c);
        }
        if (this.f18054j != null) {
            a += zzfjk.m6163b(3, this.f18054j);
        }
        int i2 = 0;
        if (this.f18049e != null && this.f18049e.length > 0) {
            i = a;
            for (zzfjs com_google_android_gms_internal_zzfjs : this.f18049e) {
                if (com_google_android_gms_internal_zzfjs != null) {
                    i += zzfjk.m6162b(4, com_google_android_gms_internal_zzfjs);
                }
            }
            a = i;
        }
        if (this.f18055k != null) {
            this.f18055k.booleanValue();
            a += zzfjk.m6160b(5) + 1;
        }
        if (this.f18056l != null && this.f18056l.length > 0) {
            i = 0;
            int i3 = i;
            while (i2 < this.f18056l.length) {
                String str = this.f18056l[i2];
                if (str != null) {
                    i3++;
                    i += zzfjk.m6156a(str);
                }
                i2++;
            }
            a = (a + i) + (i3 * 1);
        }
        if (this.f18057m != null) {
            a += zzfjk.m6163b(7, this.f18057m);
        }
        if (this.f18058n != null) {
            this.f18058n.booleanValue();
            a += zzfjk.m6160b(8) + 1;
        }
        if (this.f18059o != null) {
            this.f18059o.booleanValue();
            a += zzfjk.m6160b(9) + 1;
        }
        if (this.f18045a != null) {
            a += zzfjk.m6161b(10, this.f18045a.intValue());
        }
        if (this.f18053i != null) {
            a += zzfjk.m6161b(11, this.f18053i.intValue());
        }
        if (this.f18048d != null) {
            a += zzfjk.m6162b(12, this.f18048d);
        }
        if (this.f18050f != null) {
            a += zzfjk.m6163b(13, this.f18050f);
        }
        if (this.f18051g != null) {
            a += zzfjk.m6162b(14, this.f18051g);
        }
        if (this.f18060p != null) {
            a += zzfjk.m6164b(15, this.f18060p);
        }
        return this.f18052h != null ? a + zzfjk.m6162b(17, this.f18052h) : a;
    }

    public final /* synthetic */ zzfjs mo3478a(zzfjj com_google_android_gms_internal_zzfjj) throws IOException {
        return m18705b(com_google_android_gms_internal_zzfjj);
    }

    public final void mo1928a(zzfjk com_google_android_gms_internal_zzfjk) throws IOException {
        if (this.f18046b != null) {
            com_google_android_gms_internal_zzfjk.m6177a(1, this.f18046b);
        }
        if (this.f18047c != null) {
            com_google_android_gms_internal_zzfjk.m6177a(2, this.f18047c);
        }
        if (this.f18054j != null) {
            com_google_android_gms_internal_zzfjk.m6177a(3, this.f18054j);
        }
        int i = 0;
        if (this.f18049e != null && this.f18049e.length > 0) {
            for (zzfjs com_google_android_gms_internal_zzfjs : this.f18049e) {
                if (com_google_android_gms_internal_zzfjs != null) {
                    com_google_android_gms_internal_zzfjk.m6176a(4, com_google_android_gms_internal_zzfjs);
                }
            }
        }
        if (this.f18055k != null) {
            com_google_android_gms_internal_zzfjk.m6178a(5, this.f18055k.booleanValue());
        }
        if (this.f18056l != null && this.f18056l.length > 0) {
            while (i < this.f18056l.length) {
                String str = this.f18056l[i];
                if (str != null) {
                    com_google_android_gms_internal_zzfjk.m6177a(6, str);
                }
                i++;
            }
        }
        if (this.f18057m != null) {
            com_google_android_gms_internal_zzfjk.m6177a(7, this.f18057m);
        }
        if (this.f18058n != null) {
            com_google_android_gms_internal_zzfjk.m6178a(8, this.f18058n.booleanValue());
        }
        if (this.f18059o != null) {
            com_google_android_gms_internal_zzfjk.m6178a(9, this.f18059o.booleanValue());
        }
        if (this.f18045a != null) {
            com_google_android_gms_internal_zzfjk.m6174a(10, this.f18045a.intValue());
        }
        if (this.f18053i != null) {
            com_google_android_gms_internal_zzfjk.m6174a(11, this.f18053i.intValue());
        }
        if (this.f18048d != null) {
            com_google_android_gms_internal_zzfjk.m6176a(12, this.f18048d);
        }
        if (this.f18050f != null) {
            com_google_android_gms_internal_zzfjk.m6177a(13, this.f18050f);
        }
        if (this.f18051g != null) {
            com_google_android_gms_internal_zzfjk.m6176a(14, this.f18051g);
        }
        if (this.f18060p != null) {
            com_google_android_gms_internal_zzfjk.m6179a(15, this.f18060p);
        }
        if (this.f18052h != null) {
            com_google_android_gms_internal_zzfjk.m6176a(17, this.f18052h);
        }
        super.mo1928a(com_google_android_gms_internal_zzfjk);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.android.gms.internal.zzfjw m18705b(com.google.android.gms.internal.zzfjj r7) throws java.io.IOException {
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
            case 0: goto L_0x0163;
            case 10: goto L_0x015b;
            case 18: goto L_0x0153;
            case 26: goto L_0x014b;
            case 34: goto L_0x010b;
            case 40: goto L_0x00ff;
            case 50: goto L_0x00cb;
            case 58: goto L_0x00c3;
            case 64: goto L_0x00b7;
            case 72: goto L_0x00ab;
            case 80: goto L_0x0076;
            case 88: goto L_0x004a;
            case 98: goto L_0x0039;
            case 106: goto L_0x0032;
            case 114: goto L_0x0024;
            case 122: goto L_0x001d;
            case 138: goto L_0x000f;
            default: goto L_0x0008;
        };
    L_0x0008:
        r0 = super.m13900a(r7, r0);
        if (r0 != 0) goto L_0x0000;
    L_0x000e:
        return r6;
    L_0x000f:
        r0 = r6.f18052h;
        if (r0 != 0) goto L_0x001a;
    L_0x0013:
        r0 = new com.google.android.gms.internal.zzfkf;
        r0.<init>();
        r6.f18052h = r0;
    L_0x001a:
        r0 = r6.f18052h;
        goto L_0x0046;
    L_0x001d:
        r0 = r7.m6145e();
        r6.f18060p = r0;
        goto L_0x0000;
    L_0x0024:
        r0 = r6.f18051g;
        if (r0 != 0) goto L_0x002f;
    L_0x0028:
        r0 = new com.google.android.gms.internal.zzfkd;
        r0.<init>();
        r6.f18051g = r0;
    L_0x002f:
        r0 = r6.f18051g;
        goto L_0x0046;
    L_0x0032:
        r0 = r7.m6142d();
        r6.f18050f = r0;
        goto L_0x0000;
    L_0x0039:
        r0 = r6.f18048d;
        if (r0 != 0) goto L_0x0044;
    L_0x003d:
        r0 = new com.google.android.gms.internal.zzfjx;
        r0.<init>();
        r6.f18048d = r0;
    L_0x0044:
        r0 = r6.f18048d;
    L_0x0046:
        r7.m6137a(r0);
        goto L_0x0000;
    L_0x004a:
        r1 = r7.m6151k();
        r2 = r7.m6138b();	 Catch:{ IllegalArgumentException -> 0x00a3 }
        switch(r2) {
            case 0: goto L_0x0058;
            case 1: goto L_0x0058;
            case 2: goto L_0x0058;
            case 3: goto L_0x0058;
            case 4: goto L_0x0058;
            default: goto L_0x0055;
        };	 Catch:{ IllegalArgumentException -> 0x00a3 }
    L_0x0055:
        r3 = new java.lang.IllegalArgumentException;	 Catch:{ IllegalArgumentException -> 0x00a3 }
        goto L_0x005f;	 Catch:{ IllegalArgumentException -> 0x00a3 }
    L_0x0058:
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ IllegalArgumentException -> 0x00a3 }
        r6.f18053i = r2;	 Catch:{ IllegalArgumentException -> 0x00a3 }
        goto L_0x0000;	 Catch:{ IllegalArgumentException -> 0x00a3 }
    L_0x005f:
        r4 = 39;	 Catch:{ IllegalArgumentException -> 0x00a3 }
        r5 = new java.lang.StringBuilder;	 Catch:{ IllegalArgumentException -> 0x00a3 }
        r5.<init>(r4);	 Catch:{ IllegalArgumentException -> 0x00a3 }
        r5.append(r2);	 Catch:{ IllegalArgumentException -> 0x00a3 }
        r2 = " is not a valid enum Verdict";	 Catch:{ IllegalArgumentException -> 0x00a3 }
        r5.append(r2);	 Catch:{ IllegalArgumentException -> 0x00a3 }
        r2 = r5.toString();	 Catch:{ IllegalArgumentException -> 0x00a3 }
        r3.<init>(r2);	 Catch:{ IllegalArgumentException -> 0x00a3 }
        throw r3;	 Catch:{ IllegalArgumentException -> 0x00a3 }
    L_0x0076:
        r1 = r7.m6151k();
        r2 = r7.m6146f();	 Catch:{ IllegalArgumentException -> 0x00a3 }
        switch(r2) {
            case 0: goto L_0x0084;
            case 1: goto L_0x0084;
            case 2: goto L_0x0084;
            case 3: goto L_0x0084;
            case 4: goto L_0x0084;
            case 5: goto L_0x0084;
            case 6: goto L_0x0084;
            case 7: goto L_0x0084;
            case 8: goto L_0x0084;
            case 9: goto L_0x0084;
            default: goto L_0x0081;
        };	 Catch:{ IllegalArgumentException -> 0x00a3 }
    L_0x0081:
        r3 = new java.lang.IllegalArgumentException;	 Catch:{ IllegalArgumentException -> 0x00a3 }
        goto L_0x008c;	 Catch:{ IllegalArgumentException -> 0x00a3 }
    L_0x0084:
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ IllegalArgumentException -> 0x00a3 }
        r6.f18045a = r2;	 Catch:{ IllegalArgumentException -> 0x00a3 }
        goto L_0x0000;	 Catch:{ IllegalArgumentException -> 0x00a3 }
    L_0x008c:
        r4 = 42;	 Catch:{ IllegalArgumentException -> 0x00a3 }
        r5 = new java.lang.StringBuilder;	 Catch:{ IllegalArgumentException -> 0x00a3 }
        r5.<init>(r4);	 Catch:{ IllegalArgumentException -> 0x00a3 }
        r5.append(r2);	 Catch:{ IllegalArgumentException -> 0x00a3 }
        r2 = " is not a valid enum ReportType";	 Catch:{ IllegalArgumentException -> 0x00a3 }
        r5.append(r2);	 Catch:{ IllegalArgumentException -> 0x00a3 }
        r2 = r5.toString();	 Catch:{ IllegalArgumentException -> 0x00a3 }
        r3.<init>(r2);	 Catch:{ IllegalArgumentException -> 0x00a3 }
        throw r3;	 Catch:{ IllegalArgumentException -> 0x00a3 }
    L_0x00a3:
        r7.m6144e(r1);
        r6.m13900a(r7, r0);
        goto L_0x0000;
    L_0x00ab:
        r0 = r7.m6141c();
        r0 = java.lang.Boolean.valueOf(r0);
        r6.f18059o = r0;
        goto L_0x0000;
    L_0x00b7:
        r0 = r7.m6141c();
        r0 = java.lang.Boolean.valueOf(r0);
        r6.f18058n = r0;
        goto L_0x0000;
    L_0x00c3:
        r0 = r7.m6142d();
        r6.f18057m = r0;
        goto L_0x0000;
    L_0x00cb:
        r0 = 50;
        r0 = com.google.android.gms.internal.zzfjv.m6217a(r7, r0);
        r2 = r6.f18056l;
        if (r2 != 0) goto L_0x00d7;
    L_0x00d5:
        r2 = r1;
        goto L_0x00da;
    L_0x00d7:
        r2 = r6.f18056l;
        r2 = r2.length;
    L_0x00da:
        r0 = r0 + r2;
        r0 = new java.lang.String[r0];
        if (r2 == 0) goto L_0x00e4;
    L_0x00df:
        r3 = r6.f18056l;
        java.lang.System.arraycopy(r3, r1, r0, r1, r2);
    L_0x00e4:
        r1 = r0.length;
        r1 = r1 + -1;
        if (r2 >= r1) goto L_0x00f5;
    L_0x00e9:
        r1 = r7.m6142d();
        r0[r2] = r1;
        r7.m6134a();
        r2 = r2 + 1;
        goto L_0x00e4;
    L_0x00f5:
        r1 = r7.m6142d();
        r0[r2] = r1;
        r6.f18056l = r0;
        goto L_0x0000;
    L_0x00ff:
        r0 = r7.m6141c();
        r0 = java.lang.Boolean.valueOf(r0);
        r6.f18055k = r0;
        goto L_0x0000;
    L_0x010b:
        r0 = 34;
        r0 = com.google.android.gms.internal.zzfjv.m6217a(r7, r0);
        r2 = r6.f18049e;
        if (r2 != 0) goto L_0x0117;
    L_0x0115:
        r2 = r1;
        goto L_0x011a;
    L_0x0117:
        r2 = r6.f18049e;
        r2 = r2.length;
    L_0x011a:
        r0 = r0 + r2;
        r0 = new com.google.android.gms.internal.zzfke[r0];
        if (r2 == 0) goto L_0x0124;
    L_0x011f:
        r3 = r6.f18049e;
        java.lang.System.arraycopy(r3, r1, r0, r1, r2);
    L_0x0124:
        r1 = r0.length;
        r1 = r1 + -1;
        if (r2 >= r1) goto L_0x013b;
    L_0x0129:
        r1 = new com.google.android.gms.internal.zzfke;
        r1.<init>();
        r0[r2] = r1;
        r1 = r0[r2];
        r7.m6137a(r1);
        r7.m6134a();
        r2 = r2 + 1;
        goto L_0x0124;
    L_0x013b:
        r1 = new com.google.android.gms.internal.zzfke;
        r1.<init>();
        r0[r2] = r1;
        r1 = r0[r2];
        r7.m6137a(r1);
        r6.f18049e = r0;
        goto L_0x0000;
    L_0x014b:
        r0 = r7.m6142d();
        r6.f18054j = r0;
        goto L_0x0000;
    L_0x0153:
        r0 = r7.m6142d();
        r6.f18047c = r0;
        goto L_0x0000;
    L_0x015b:
        r0 = r7.m6142d();
        r6.f18046b = r0;
        goto L_0x0000;
    L_0x0163:
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzfjw.b(com.google.android.gms.internal.zzfjj):com.google.android.gms.internal.zzfjw");
    }
}
