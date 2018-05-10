package com.google.android.gms.internal;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

final class zzfhn {
    private static final zzfhn f7441a = new zzfhn();
    private final zzfhw f7442b;
    private final ConcurrentMap<Class<?>, zzfhv<?>> f7443c = new ConcurrentHashMap();

    private zzfhn() {
        String[] strArr = new String[]{"com.google.protobuf.AndroidProto3SchemaFactory"};
        zzfhw com_google_android_gms_internal_zzfhw = null;
        for (int i = 0; i <= 0; i++) {
            com_google_android_gms_internal_zzfhw = m6048a(strArr[0]);
            if (com_google_android_gms_internal_zzfhw != null) {
                break;
            }
        }
        if (com_google_android_gms_internal_zzfhw == null) {
            com_google_android_gms_internal_zzfhw = new zzfgq();
        }
        this.f7442b = com_google_android_gms_internal_zzfhw;
    }

    public static zzfhn m6047a() {
        return f7441a;
    }

    private static com.google.android.gms.internal.zzfhw m6048a(java.lang.String r2) {
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
        r2 = java.lang.Class.forName(r2);	 Catch:{ Throwable -> 0x0014 }
        r0 = 0;	 Catch:{ Throwable -> 0x0014 }
        r1 = new java.lang.Class[r0];	 Catch:{ Throwable -> 0x0014 }
        r2 = r2.getConstructor(r1);	 Catch:{ Throwable -> 0x0014 }
        r0 = new java.lang.Object[r0];	 Catch:{ Throwable -> 0x0014 }
        r2 = r2.newInstance(r0);	 Catch:{ Throwable -> 0x0014 }
        r2 = (com.google.android.gms.internal.zzfhw) r2;	 Catch:{ Throwable -> 0x0014 }
        return r2;
    L_0x0014:
        r2 = 0;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzfhn.a(java.lang.String):com.google.android.gms.internal.zzfhw");
    }

    public final <T> zzfhv<T> m6049a(Class<T> cls) {
        zzffz.m6014a(cls, "messageType");
        zzfhv<T> com_google_android_gms_internal_zzfhv_T = (zzfhv) this.f7443c.get(cls);
        if (com_google_android_gms_internal_zzfhv_T != null) {
            return com_google_android_gms_internal_zzfhv_T;
        }
        com_google_android_gms_internal_zzfhv_T = this.f7442b.mo1910a(cls);
        zzffz.m6014a(cls, "messageType");
        zzffz.m6014a(com_google_android_gms_internal_zzfhv_T, "schema");
        zzfhv<T> com_google_android_gms_internal_zzfhv_T2 = (zzfhv) this.f7443c.putIfAbsent(cls, com_google_android_gms_internal_zzfhv_T);
        return com_google_android_gms_internal_zzfhv_T2 != null ? com_google_android_gms_internal_zzfhv_T2 : com_google_android_gms_internal_zzfhv_T;
    }
}
