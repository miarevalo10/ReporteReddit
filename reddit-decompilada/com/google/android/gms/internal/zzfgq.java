package com.google.android.gms.internal;

final class zzfgq implements zzfhw {
    private static final zzfhd f14445c = new zzfgr();
    private final zzfhd f14446a;
    private final zzfgu f14447b;

    public zzfgq() {
        this(zzfgu.DYNAMIC);
    }

    private zzfgq(zzfgu com_google_android_gms_internal_zzfgu) {
        this(new zzfgt(zzfft.m13828a(), m13853a()), com_google_android_gms_internal_zzfgu);
    }

    private zzfgq(zzfhd com_google_android_gms_internal_zzfhd, zzfgu com_google_android_gms_internal_zzfgu) {
        this.f14446a = (zzfhd) zzffz.m6014a(com_google_android_gms_internal_zzfhd, "messageInfoFactory");
        this.f14447b = (zzfgu) zzffz.m6014a(com_google_android_gms_internal_zzfgu, "mode");
    }

    private static com.google.android.gms.internal.zzfhd m13853a() {
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
        r0 = "com.google.protobuf.DescriptorMessageInfoFactory";	 Catch:{ Exception -> 0x0019 }
        r0 = java.lang.Class.forName(r0);	 Catch:{ Exception -> 0x0019 }
        r1 = "getInstance";	 Catch:{ Exception -> 0x0019 }
        r2 = 0;	 Catch:{ Exception -> 0x0019 }
        r3 = new java.lang.Class[r2];	 Catch:{ Exception -> 0x0019 }
        r0 = r0.getDeclaredMethod(r1, r3);	 Catch:{ Exception -> 0x0019 }
        r1 = 0;	 Catch:{ Exception -> 0x0019 }
        r2 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x0019 }
        r0 = r0.invoke(r1, r2);	 Catch:{ Exception -> 0x0019 }
        r0 = (com.google.android.gms.internal.zzfhd) r0;	 Catch:{ Exception -> 0x0019 }
        return r0;
    L_0x0019:
        r0 = f14445c;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzfgq.a():com.google.android.gms.internal.zzfhd");
    }

    private static <T> zzfhv<T> m13854a(Class<T> cls, zzfhc com_google_android_gms_internal_zzfhc) {
        if (zzffu.class.isAssignableFrom(cls)) {
            if (m13855a(com_google_android_gms_internal_zzfhc)) {
                zzfgm.m6032b();
                zzfhx.m6057c();
                zzffp.m5988a();
            } else {
                zzfgm.m6032b();
                zzfhx.m6057c();
            }
            zzfhb.m6034b();
        } else {
            if (m13855a(com_google_android_gms_internal_zzfhc)) {
                zzfgm.m6031a();
                zzfhx.m6053a();
                zzffp.m5989b();
            } else {
                zzfgm.m6031a();
                zzfhx.m6056b();
            }
            zzfhb.m6033a();
        }
        return zzfhi.m13869a(com_google_android_gms_internal_zzfhc);
    }

    private static boolean m13855a(zzfhc com_google_android_gms_internal_zzfhc) {
        return com_google_android_gms_internal_zzfhc.mo1913a() == zzfhm.f7438a;
    }

    private static <T> zzfhv<T> m13856b(Class<T> cls, zzfhc com_google_android_gms_internal_zzfhc) {
        if (zzffu.class.isAssignableFrom(cls)) {
            if (m13855a(com_google_android_gms_internal_zzfhc)) {
                zzfgm.m6032b();
                zzfhx.m6057c();
                zzffp.m5988a();
            } else {
                zzfgm.m6032b();
                zzfhx.m6057c();
            }
            zzfhb.m6034b();
        } else {
            if (m13855a(com_google_android_gms_internal_zzfhc)) {
                zzfgm.m6031a();
                zzfhx.m6053a();
                zzffp.m5989b();
            } else {
                zzfgm.m6031a();
                zzfhx.m6056b();
            }
            zzfhb.m6033a();
        }
        return zzfhi.m13870b(com_google_android_gms_internal_zzfhc);
    }

    public final <T> zzfhv<T> mo1910a(Class<T> cls) {
        zzfhx.m6055a((Class) cls);
        zzfhc b = this.f14446a.mo1900b(cls);
        if (b.mo1914b()) {
            zzfin c;
            zzffn a;
            if (zzffu.class.isAssignableFrom(cls)) {
                c = zzfhx.m6057c();
                a = zzffp.m5988a();
            } else {
                c = zzfhx.m6053a();
                a = zzffp.m5989b();
            }
            return zzfhj.m13873a(cls, c, a, b.mo1915c());
        }
        switch (zzfgs.f7431a[this.f14447b.ordinal()]) {
            case 1:
                return m13854a(cls, b);
            case 2:
                return m13856b(cls, b);
            default:
                return b.mo1916d() ? m13854a(cls, b) : m13856b(cls, b);
        }
    }
}
