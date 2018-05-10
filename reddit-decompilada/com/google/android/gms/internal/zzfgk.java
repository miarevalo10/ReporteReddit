package com.google.android.gms.internal;

public class zzfgk {
    private static final zzffm f7425d = zzffm.m5984a();
    zzfes f7426a;
    volatile zzfhe f7427b;
    volatile zzfes f7428c;

    private com.google.android.gms.internal.zzfhe m6028a(com.google.android.gms.internal.zzfhe r2) {
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
        r1 = this;
        r0 = r1.f7427b;
        if (r0 != 0) goto L_0x001c;
    L_0x0004:
        monitor-enter(r1);
        r0 = r1.f7427b;	 Catch:{ all -> 0x0019 }
        if (r0 == 0) goto L_0x000b;	 Catch:{ all -> 0x0019 }
    L_0x0009:
        monitor-exit(r1);	 Catch:{ all -> 0x0019 }
        goto L_0x001c;
    L_0x000b:
        r1.f7427b = r2;	 Catch:{ zzfge -> 0x0012 }
        r0 = com.google.android.gms.internal.zzfes.f7377a;	 Catch:{ zzfge -> 0x0012 }
        r1.f7428c = r0;	 Catch:{ zzfge -> 0x0012 }
        goto L_0x0009;
    L_0x0012:
        r1.f7427b = r2;	 Catch:{ all -> 0x0019 }
        r2 = com.google.android.gms.internal.zzfes.f7377a;	 Catch:{ all -> 0x0019 }
        r1.f7428c = r2;	 Catch:{ all -> 0x0019 }
        goto L_0x0009;	 Catch:{ all -> 0x0019 }
    L_0x0019:
        r2 = move-exception;	 Catch:{ all -> 0x0019 }
        monitor-exit(r1);	 Catch:{ all -> 0x0019 }
        throw r2;
    L_0x001c:
        r2 = r1.f7427b;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzfgk.a(com.google.android.gms.internal.zzfhe):com.google.android.gms.internal.zzfhe");
    }

    public final int m6029b() {
        return this.f7428c != null ? this.f7428c.mo3503a() : this.f7427b != null ? this.f7427b.mo4040c() : 0;
    }

    public final zzfes m6030c() {
        if (this.f7428c != null) {
            return this.f7428c;
        }
        synchronized (this) {
            if (this.f7428c != null) {
                zzfes com_google_android_gms_internal_zzfes = this.f7428c;
                return com_google_android_gms_internal_zzfes;
            }
            this.f7428c = this.f7427b == null ? zzfes.f7377a : this.f7427b.mo3499g();
            com_google_android_gms_internal_zzfes = this.f7428c;
            return com_google_android_gms_internal_zzfes;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzfgk)) {
            return false;
        }
        zzfgk com_google_android_gms_internal_zzfgk = (zzfgk) obj;
        zzfhe com_google_android_gms_internal_zzfhe = this.f7427b;
        zzfhe com_google_android_gms_internal_zzfhe2 = com_google_android_gms_internal_zzfgk.f7427b;
        return (com_google_android_gms_internal_zzfhe == null && com_google_android_gms_internal_zzfhe2 == null) ? m6030c().equals(com_google_android_gms_internal_zzfgk.m6030c()) : (com_google_android_gms_internal_zzfhe == null || com_google_android_gms_internal_zzfhe2 == null) ? com_google_android_gms_internal_zzfhe != null ? com_google_android_gms_internal_zzfhe.equals(com_google_android_gms_internal_zzfgk.m6028a(com_google_android_gms_internal_zzfhe.mo4038j())) : m6028a(com_google_android_gms_internal_zzfhe2.mo4038j()).equals(com_google_android_gms_internal_zzfhe2) : com_google_android_gms_internal_zzfhe.equals(com_google_android_gms_internal_zzfhe2);
    }

    public int hashCode() {
        return 1;
    }
}
