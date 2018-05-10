package com.google.android.gms.internal;

import java.io.IOException;

public final class zzclu extends zzfjm<zzclu> {
    public Integer f17927a;
    public Boolean f17928b;
    public String f17929c;
    public String f17930d;
    public String f17931e;

    public zzclu() {
        this.f17927a = null;
        this.f17928b = null;
        this.f17929c = null;
        this.f17930d = null;
        this.f17931e = null;
        this.X = null;
        this.Y = -1;
    }

    private final com.google.android.gms.internal.zzclu m18597b(com.google.android.gms.internal.zzfjj r7) throws java.io.IOException {
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
        if (r0 == 0) goto L_0x0074;
    L_0x0006:
        r1 = 8;
        if (r0 == r1) goto L_0x0041;
    L_0x000a:
        r1 = 16;
        if (r0 == r1) goto L_0x0036;
    L_0x000e:
        r1 = 26;
        if (r0 == r1) goto L_0x002f;
    L_0x0012:
        r1 = 34;
        if (r0 == r1) goto L_0x0028;
    L_0x0016:
        r1 = 42;
        if (r0 == r1) goto L_0x0021;
    L_0x001a:
        r0 = super.m13900a(r7, r0);
        if (r0 != 0) goto L_0x0000;
    L_0x0020:
        return r6;
    L_0x0021:
        r0 = r7.m6142d();
        r6.f17931e = r0;
        goto L_0x0000;
    L_0x0028:
        r0 = r7.m6142d();
        r6.f17930d = r0;
        goto L_0x0000;
    L_0x002f:
        r0 = r7.m6142d();
        r6.f17929c = r0;
        goto L_0x0000;
    L_0x0036:
        r0 = r7.m6141c();
        r0 = java.lang.Boolean.valueOf(r0);
        r6.f17928b = r0;
        goto L_0x0000;
    L_0x0041:
        r1 = r7.m6151k();
        r2 = r7.m6146f();	 Catch:{ IllegalArgumentException -> 0x006d }
        switch(r2) {
            case 0: goto L_0x004f;
            case 1: goto L_0x004f;
            case 2: goto L_0x004f;
            case 3: goto L_0x004f;
            case 4: goto L_0x004f;
            default: goto L_0x004c;
        };	 Catch:{ IllegalArgumentException -> 0x006d }
    L_0x004c:
        r3 = new java.lang.IllegalArgumentException;	 Catch:{ IllegalArgumentException -> 0x006d }
        goto L_0x0056;	 Catch:{ IllegalArgumentException -> 0x006d }
    L_0x004f:
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ IllegalArgumentException -> 0x006d }
        r6.f17927a = r2;	 Catch:{ IllegalArgumentException -> 0x006d }
        goto L_0x0000;	 Catch:{ IllegalArgumentException -> 0x006d }
    L_0x0056:
        r4 = 46;	 Catch:{ IllegalArgumentException -> 0x006d }
        r5 = new java.lang.StringBuilder;	 Catch:{ IllegalArgumentException -> 0x006d }
        r5.<init>(r4);	 Catch:{ IllegalArgumentException -> 0x006d }
        r5.append(r2);	 Catch:{ IllegalArgumentException -> 0x006d }
        r2 = " is not a valid enum ComparisonType";	 Catch:{ IllegalArgumentException -> 0x006d }
        r5.append(r2);	 Catch:{ IllegalArgumentException -> 0x006d }
        r2 = r5.toString();	 Catch:{ IllegalArgumentException -> 0x006d }
        r3.<init>(r2);	 Catch:{ IllegalArgumentException -> 0x006d }
        throw r3;	 Catch:{ IllegalArgumentException -> 0x006d }
    L_0x006d:
        r7.m6144e(r1);
        r6.m13900a(r7, r0);
        goto L_0x0000;
    L_0x0074:
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzclu.b(com.google.android.gms.internal.zzfjj):com.google.android.gms.internal.zzclu");
    }

    protected final int mo1927a() {
        int a = super.mo1927a();
        if (this.f17927a != null) {
            a += zzfjk.m6161b(1, this.f17927a.intValue());
        }
        if (this.f17928b != null) {
            this.f17928b.booleanValue();
            a += zzfjk.m6160b(2) + 1;
        }
        if (this.f17929c != null) {
            a += zzfjk.m6163b(3, this.f17929c);
        }
        if (this.f17930d != null) {
            a += zzfjk.m6163b(4, this.f17930d);
        }
        return this.f17931e != null ? a + zzfjk.m6163b(5, this.f17931e) : a;
    }

    public final /* synthetic */ zzfjs mo3478a(zzfjj com_google_android_gms_internal_zzfjj) throws IOException {
        return m18597b(com_google_android_gms_internal_zzfjj);
    }

    public final void mo1928a(zzfjk com_google_android_gms_internal_zzfjk) throws IOException {
        if (this.f17927a != null) {
            com_google_android_gms_internal_zzfjk.m6174a(1, this.f17927a.intValue());
        }
        if (this.f17928b != null) {
            com_google_android_gms_internal_zzfjk.m6178a(2, this.f17928b.booleanValue());
        }
        if (this.f17929c != null) {
            com_google_android_gms_internal_zzfjk.m6177a(3, this.f17929c);
        }
        if (this.f17930d != null) {
            com_google_android_gms_internal_zzfjk.m6177a(4, this.f17930d);
        }
        if (this.f17931e != null) {
            com_google_android_gms_internal_zzfjk.m6177a(5, this.f17931e);
        }
        super.mo1928a(com_google_android_gms_internal_zzfjk);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzclu)) {
            return false;
        }
        zzclu com_google_android_gms_internal_zzclu = (zzclu) obj;
        if (this.f17927a == null) {
            if (com_google_android_gms_internal_zzclu.f17927a != null) {
                return false;
            }
        } else if (!this.f17927a.equals(com_google_android_gms_internal_zzclu.f17927a)) {
            return false;
        }
        if (this.f17928b == null) {
            if (com_google_android_gms_internal_zzclu.f17928b != null) {
                return false;
            }
        } else if (!this.f17928b.equals(com_google_android_gms_internal_zzclu.f17928b)) {
            return false;
        }
        if (this.f17929c == null) {
            if (com_google_android_gms_internal_zzclu.f17929c != null) {
                return false;
            }
        } else if (!this.f17929c.equals(com_google_android_gms_internal_zzclu.f17929c)) {
            return false;
        }
        if (this.f17930d == null) {
            if (com_google_android_gms_internal_zzclu.f17930d != null) {
                return false;
            }
        } else if (!this.f17930d.equals(com_google_android_gms_internal_zzclu.f17930d)) {
            return false;
        }
        if (this.f17931e == null) {
            if (com_google_android_gms_internal_zzclu.f17931e != null) {
                return false;
            }
        } else if (!this.f17931e.equals(com_google_android_gms_internal_zzclu.f17931e)) {
            return false;
        }
        if (this.X != null) {
            if (!this.X.m6188a()) {
                return this.X.equals(com_google_android_gms_internal_zzclu.X);
            }
        }
        return com_google_android_gms_internal_zzclu.X == null || com_google_android_gms_internal_zzclu.X.m6188a();
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = (((((((((((527 + getClass().getName().hashCode()) * 31) + (this.f17927a == null ? 0 : this.f17927a.intValue())) * 31) + (this.f17928b == null ? 0 : this.f17928b.hashCode())) * 31) + (this.f17929c == null ? 0 : this.f17929c.hashCode())) * 31) + (this.f17930d == null ? 0 : this.f17930d.hashCode())) * 31) + (this.f17931e == null ? 0 : this.f17931e.hashCode())) * 31;
        if (this.X != null) {
            if (!this.X.m6188a()) {
                i = this.X.hashCode();
            }
        }
        return hashCode + i;
    }
}
