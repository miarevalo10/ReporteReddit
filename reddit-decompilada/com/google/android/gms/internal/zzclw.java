package com.google.android.gms.internal;

import java.io.IOException;

public final class zzclw extends zzfjm<zzclw> {
    public Integer f17936a;
    public String f17937b;
    public Boolean f17938c;
    public String[] f17939d;

    public zzclw() {
        this.f17936a = null;
        this.f17937b = null;
        this.f17938c = null;
        this.f17939d = zzfjv.f7564f;
        this.X = null;
        this.Y = -1;
    }

    private final com.google.android.gms.internal.zzclw m18605b(com.google.android.gms.internal.zzfjj r7) throws java.io.IOException {
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
        if (r0 == 0) goto L_0x0095;
    L_0x0006:
        r1 = 8;
        if (r0 == r1) goto L_0x0061;
    L_0x000a:
        r1 = 18;
        if (r0 == r1) goto L_0x005a;
    L_0x000e:
        r1 = 24;
        if (r0 == r1) goto L_0x004f;
    L_0x0012:
        r1 = 34;
        if (r0 == r1) goto L_0x001d;
    L_0x0016:
        r0 = super.m13900a(r7, r0);
        if (r0 != 0) goto L_0x0000;
    L_0x001c:
        return r6;
    L_0x001d:
        r0 = com.google.android.gms.internal.zzfjv.m6217a(r7, r1);
        r1 = r6.f17939d;
        r2 = 0;
        if (r1 != 0) goto L_0x0028;
    L_0x0026:
        r1 = r2;
        goto L_0x002b;
    L_0x0028:
        r1 = r6.f17939d;
        r1 = r1.length;
    L_0x002b:
        r0 = r0 + r1;
        r0 = new java.lang.String[r0];
        if (r1 == 0) goto L_0x0035;
    L_0x0030:
        r3 = r6.f17939d;
        java.lang.System.arraycopy(r3, r2, r0, r2, r1);
    L_0x0035:
        r2 = r0.length;
        r2 = r2 + -1;
        if (r1 >= r2) goto L_0x0046;
    L_0x003a:
        r2 = r7.m6142d();
        r0[r1] = r2;
        r7.m6134a();
        r1 = r1 + 1;
        goto L_0x0035;
    L_0x0046:
        r2 = r7.m6142d();
        r0[r1] = r2;
        r6.f17939d = r0;
        goto L_0x0000;
    L_0x004f:
        r0 = r7.m6141c();
        r0 = java.lang.Boolean.valueOf(r0);
        r6.f17938c = r0;
        goto L_0x0000;
    L_0x005a:
        r0 = r7.m6142d();
        r6.f17937b = r0;
        goto L_0x0000;
    L_0x0061:
        r1 = r7.m6151k();
        r2 = r7.m6146f();	 Catch:{ IllegalArgumentException -> 0x008d }
        switch(r2) {
            case 0: goto L_0x006f;
            case 1: goto L_0x006f;
            case 2: goto L_0x006f;
            case 3: goto L_0x006f;
            case 4: goto L_0x006f;
            case 5: goto L_0x006f;
            case 6: goto L_0x006f;
            default: goto L_0x006c;
        };	 Catch:{ IllegalArgumentException -> 0x008d }
    L_0x006c:
        r3 = new java.lang.IllegalArgumentException;	 Catch:{ IllegalArgumentException -> 0x008d }
        goto L_0x0076;	 Catch:{ IllegalArgumentException -> 0x008d }
    L_0x006f:
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ IllegalArgumentException -> 0x008d }
        r6.f17936a = r2;	 Catch:{ IllegalArgumentException -> 0x008d }
        goto L_0x0000;	 Catch:{ IllegalArgumentException -> 0x008d }
    L_0x0076:
        r4 = 41;	 Catch:{ IllegalArgumentException -> 0x008d }
        r5 = new java.lang.StringBuilder;	 Catch:{ IllegalArgumentException -> 0x008d }
        r5.<init>(r4);	 Catch:{ IllegalArgumentException -> 0x008d }
        r5.append(r2);	 Catch:{ IllegalArgumentException -> 0x008d }
        r2 = " is not a valid enum MatchType";	 Catch:{ IllegalArgumentException -> 0x008d }
        r5.append(r2);	 Catch:{ IllegalArgumentException -> 0x008d }
        r2 = r5.toString();	 Catch:{ IllegalArgumentException -> 0x008d }
        r3.<init>(r2);	 Catch:{ IllegalArgumentException -> 0x008d }
        throw r3;	 Catch:{ IllegalArgumentException -> 0x008d }
    L_0x008d:
        r7.m6144e(r1);
        r6.m13900a(r7, r0);
        goto L_0x0000;
    L_0x0095:
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzclw.b(com.google.android.gms.internal.zzfjj):com.google.android.gms.internal.zzclw");
    }

    protected final int mo1927a() {
        int a = super.mo1927a();
        if (this.f17936a != null) {
            a += zzfjk.m6161b(1, this.f17936a.intValue());
        }
        if (this.f17937b != null) {
            a += zzfjk.m6163b(2, this.f17937b);
        }
        if (this.f17938c != null) {
            this.f17938c.booleanValue();
            a += zzfjk.m6160b(3) + 1;
        }
        if (this.f17939d == null || this.f17939d.length <= 0) {
            return a;
        }
        int i = 0;
        int i2 = 0;
        int i3 = i2;
        while (i < this.f17939d.length) {
            String str = this.f17939d[i];
            if (str != null) {
                i3++;
                i2 += zzfjk.m6156a(str);
            }
            i++;
        }
        return (a + i2) + (1 * i3);
    }

    public final /* synthetic */ zzfjs mo3478a(zzfjj com_google_android_gms_internal_zzfjj) throws IOException {
        return m18605b(com_google_android_gms_internal_zzfjj);
    }

    public final void mo1928a(zzfjk com_google_android_gms_internal_zzfjk) throws IOException {
        if (this.f17936a != null) {
            com_google_android_gms_internal_zzfjk.m6174a(1, this.f17936a.intValue());
        }
        if (this.f17937b != null) {
            com_google_android_gms_internal_zzfjk.m6177a(2, this.f17937b);
        }
        if (this.f17938c != null) {
            com_google_android_gms_internal_zzfjk.m6178a(3, this.f17938c.booleanValue());
        }
        if (this.f17939d != null && this.f17939d.length > 0) {
            for (String str : this.f17939d) {
                if (str != null) {
                    com_google_android_gms_internal_zzfjk.m6177a(4, str);
                }
            }
        }
        super.mo1928a(com_google_android_gms_internal_zzfjk);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzclw)) {
            return false;
        }
        zzclw com_google_android_gms_internal_zzclw = (zzclw) obj;
        if (this.f17936a == null) {
            if (com_google_android_gms_internal_zzclw.f17936a != null) {
                return false;
            }
        } else if (!this.f17936a.equals(com_google_android_gms_internal_zzclw.f17936a)) {
            return false;
        }
        if (this.f17937b == null) {
            if (com_google_android_gms_internal_zzclw.f17937b != null) {
                return false;
            }
        } else if (!this.f17937b.equals(com_google_android_gms_internal_zzclw.f17937b)) {
            return false;
        }
        if (this.f17938c == null) {
            if (com_google_android_gms_internal_zzclw.f17938c != null) {
                return false;
            }
        } else if (!this.f17938c.equals(com_google_android_gms_internal_zzclw.f17938c)) {
            return false;
        }
        if (!zzfjq.m6198a(this.f17939d, com_google_android_gms_internal_zzclw.f17939d)) {
            return false;
        }
        if (this.X != null) {
            if (!this.X.m6188a()) {
                return this.X.equals(com_google_android_gms_internal_zzclw.X);
            }
        }
        return com_google_android_gms_internal_zzclw.X == null || com_google_android_gms_internal_zzclw.X.m6188a();
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = (((((((((527 + getClass().getName().hashCode()) * 31) + (this.f17936a == null ? 0 : this.f17936a.intValue())) * 31) + (this.f17937b == null ? 0 : this.f17937b.hashCode())) * 31) + (this.f17938c == null ? 0 : this.f17938c.hashCode())) * 31) + zzfjq.m6195a(this.f17939d)) * 31;
        if (this.X != null) {
            if (!this.X.m6188a()) {
                i = this.X.hashCode();
            }
        }
        return hashCode + i;
    }
}
