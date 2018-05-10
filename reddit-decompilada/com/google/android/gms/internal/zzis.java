package com.google.android.gms.internal;

import com.google.android.gms.internal.zziu.zza.zzb;

@zzzv
public final class zzis {
    private final zzix f7727a;
    private final zzjc f7728b;
    private final boolean f7729c;

    private zzis() {
        this.f7729c = false;
        this.f7727a = new zzix();
        this.f7728b = new zzjc();
        m6323b();
    }

    public zzis(zzix com_google_android_gms_internal_zzix, boolean z) {
        this.f7727a = com_google_android_gms_internal_zzix;
        this.f7729c = z;
        this.f7728b = new zzjc();
        m6323b();
    }

    public static zzis m6322a() {
        return new zzis();
    }

    private final synchronized void m6323b() {
        this.f7728b.f18128d = new zzja();
        this.f7728b.f18127c = new zzjb();
    }

    private static long[] m6324c() {
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
        r0 = com.google.android.gms.internal.zznh.m6492b();
        r1 = new java.util.ArrayList;
        r1.<init>();
        r0 = r0.iterator();
    L_0x000d:
        r2 = r0.hasNext();
        r3 = 0;
        if (r2 == 0) goto L_0x0035;
    L_0x0014:
        r2 = r0.next();
        r2 = (java.lang.String) r2;
        r4 = ",";
        r2 = r2.split(r4);
        r4 = r2.length;
    L_0x0021:
        if (r3 >= r4) goto L_0x000d;
    L_0x0023:
        r5 = r2[r3];
        r5 = java.lang.Long.valueOf(r5);	 Catch:{ NumberFormatException -> 0x002d }
        r1.add(r5);	 Catch:{ NumberFormatException -> 0x002d }
        goto L_0x0032;
    L_0x002d:
        r5 = "Experiment ID is not a number";
        com.google.android.gms.internal.zzagf.m13278a(r5);
    L_0x0032:
        r3 = r3 + 1;
        goto L_0x0021;
    L_0x0035:
        r0 = r1.size();
        r0 = new long[r0];
        r1 = (java.util.ArrayList) r1;
        r2 = r1.size();
        r4 = r3;
    L_0x0042:
        if (r3 >= r2) goto L_0x0055;
    L_0x0044:
        r5 = r1.get(r3);
        r3 = r3 + 1;
        r5 = (java.lang.Long) r5;
        r5 = r5.longValue();
        r0[r4] = r5;
        r4 = r4 + 1;
        goto L_0x0042;
    L_0x0055:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzis.c():long[]");
    }

    public final synchronized void m6325a(zzit com_google_android_gms_internal_zzit) {
        if (this.f7729c) {
            com_google_android_gms_internal_zzit.mo1523a(this.f7728b);
        }
    }

    public final synchronized void m6326a(zzb com_google_android_gms_internal_zziu_zza_zzb) {
        if (this.f7729c) {
            this.f7728b.f18126b = m6324c();
            zziz a = this.f7727a.m6328a(zzfjs.m6205a(this.f7728b));
            a.f7734b = com_google_android_gms_internal_zziu_zza_zzb.f14542f;
            a.m6329a();
            String str = "Logging Event with event code : ";
            com_google_android_gms_internal_zziu_zza_zzb = String.valueOf(Integer.toString(com_google_android_gms_internal_zziu_zza_zzb.f14542f, 10));
            zzagf.m13278a(com_google_android_gms_internal_zziu_zza_zzb.length() != 0 ? str.concat(com_google_android_gms_internal_zziu_zza_zzb) : new String(str));
        }
    }
}
