package com.google.android.gms.internal;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class zzdz extends zzet {
    private static volatile zzbv f14405d;
    private static final Object f14406e = new Object();
    private zzaw f14407f = null;

    public zzdz(zzdm com_google_android_gms_internal_zzdm, String str, String str2, zzaz com_google_android_gms_internal_zzaz, int i, zzaw com_google_android_gms_internal_zzaw) {
        super(com_google_android_gms_internal_zzdm, str, str2, com_google_android_gms_internal_zzaz, i, 27);
        this.f14407f = com_google_android_gms_internal_zzaw;
    }

    protected final void mo1870a() throws IllegalAccessException, InvocationTargetException {
        boolean z;
        int i;
        String c;
        boolean z2 = false;
        if (!(f14405d == null || zzdr.m5893b(f14405d.f14209a) || f14405d.f14209a.equals("E"))) {
            if (!f14405d.f14209a.equals("0000000000000000000000000000000000000000000000000000000000000000")) {
                z = false;
                if (z) {
                    synchronized (f14406e) {
                        zzbv com_google_android_gms_internal_zzbv;
                        if (zzdr.m5893b(null)) {
                            i = 4;
                        } else {
                            zzdr.m5893b(null);
                            if (Boolean.valueOf(false).booleanValue()) {
                                if (this.a.f7225j) {
                                    if (((Boolean) zzkb.m6350f().m6488a(zznh.bB)).booleanValue()) {
                                        if (((Boolean) zzkb.m6350f().m6488a(zznh.bC)).booleanValue()) {
                                            i = 1;
                                            if (i != 0) {
                                                i = 3;
                                            }
                                        }
                                    }
                                }
                                i = false;
                                if (i != 0) {
                                    i = 3;
                                }
                            }
                            i = 2;
                        }
                        Method method = this.c;
                        Object[] objArr = new Object[2];
                        objArr[0] = this.a.m5845a();
                        if (i == 2) {
                            z2 = true;
                        }
                        objArr[1] = Boolean.valueOf(z2);
                        com_google_android_gms_internal_zzbv = new zzbv((String) method.invoke(null, objArr));
                        f14405d = com_google_android_gms_internal_zzbv;
                        if (zzdr.m5893b(com_google_android_gms_internal_zzbv.f14209a) || f14405d.f14209a.equals("E")) {
                            switch (i) {
                                case 3:
                                    c = m13715c();
                                    if (!zzdr.m5893b(c)) {
                                        f14405d.f14209a = c;
                                        break;
                                    }
                                    break;
                                case 4:
                                    f14405d.f14209a = null.f17610a;
                                    break;
                                default:
                                    break;
                            }
                        }
                    }
                }
                synchronized (this.b) {
                    if (f14405d != null) {
                        this.b.f17654n = f14405d.f14209a;
                        this.b.f17660t = Long.valueOf(f14405d.f14210b);
                        this.b.f17659s = f14405d.f14211c;
                        this.b.f17619C = f14405d.f14212d;
                        this.b.f17620D = f14405d.f14213e;
                    }
                }
            }
        }
        z = true;
        if (z) {
            synchronized (f14406e) {
                if (zzdr.m5893b(null)) {
                    zzdr.m5893b(null);
                    if (Boolean.valueOf(false).booleanValue()) {
                        if (this.a.f7225j) {
                            if (((Boolean) zzkb.m6350f().m6488a(zznh.bB)).booleanValue()) {
                                if (((Boolean) zzkb.m6350f().m6488a(zznh.bC)).booleanValue()) {
                                    i = 1;
                                    if (i != 0) {
                                        i = 3;
                                    }
                                }
                            }
                        }
                        i = false;
                        if (i != 0) {
                            i = 3;
                        }
                    }
                    i = 2;
                } else {
                    i = 4;
                }
                Method method2 = this.c;
                Object[] objArr2 = new Object[2];
                objArr2[0] = this.a.m5845a();
                if (i == 2) {
                    z2 = true;
                }
                objArr2[1] = Boolean.valueOf(z2);
                com_google_android_gms_internal_zzbv = new zzbv((String) method2.invoke(null, objArr2));
                f14405d = com_google_android_gms_internal_zzbv;
                switch (i) {
                    case 3:
                        c = m13715c();
                        if (zzdr.m5893b(c)) {
                            f14405d.f14209a = c;
                            break;
                        }
                        break;
                    case 4:
                        f14405d.f14209a = null.f17610a;
                        break;
                    default:
                        break;
                }
            }
        }
        synchronized (this.b) {
            if (f14405d != null) {
                this.b.f17654n = f14405d.f14209a;
                this.b.f17660t = Long.valueOf(f14405d.f14210b);
                this.b.f17659s = f14405d.f14211c;
                this.b.f17619C = f14405d.f14212d;
                this.b.f17620D = f14405d.f14213e;
            }
        }
    }

    private final java.lang.String m13715c() {
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
        r2 = this;
        r0 = r2.a;	 Catch:{ InterruptedException -> 0x001a, InterruptedException -> 0x001a }
        r0 = r0.f7222g;	 Catch:{ InterruptedException -> 0x001a, InterruptedException -> 0x001a }
        if (r0 == 0) goto L_0x000d;	 Catch:{ InterruptedException -> 0x001a, InterruptedException -> 0x001a }
    L_0x0006:
        r0 = r2.a;	 Catch:{ InterruptedException -> 0x001a, InterruptedException -> 0x001a }
        r0 = r0.f7222g;	 Catch:{ InterruptedException -> 0x001a, InterruptedException -> 0x001a }
        r0.get();	 Catch:{ InterruptedException -> 0x001a, InterruptedException -> 0x001a }
    L_0x000d:
        r0 = r2.a;	 Catch:{ InterruptedException -> 0x001a, InterruptedException -> 0x001a }
        r0 = r0.f7221f;	 Catch:{ InterruptedException -> 0x001a, InterruptedException -> 0x001a }
        if (r0 == 0) goto L_0x001a;	 Catch:{ InterruptedException -> 0x001a, InterruptedException -> 0x001a }
    L_0x0013:
        r1 = r0.f17654n;	 Catch:{ InterruptedException -> 0x001a, InterruptedException -> 0x001a }
        if (r1 == 0) goto L_0x001a;	 Catch:{ InterruptedException -> 0x001a, InterruptedException -> 0x001a }
    L_0x0017:
        r0 = r0.f17654n;	 Catch:{ InterruptedException -> 0x001a, InterruptedException -> 0x001a }
        return r0;
    L_0x001a:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzdz.c():java.lang.String");
    }
}
