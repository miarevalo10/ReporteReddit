package com.google.android.gms.internal;

import java.lang.reflect.InvocationTargetException;

public final class zzed extends zzet {
    public zzed(zzdm com_google_android_gms_internal_zzdm, String str, String str2, zzaz com_google_android_gms_internal_zzaz, int i) {
        super(com_google_android_gms_internal_zzdm, str, str2, com_google_android_gms_internal_zzaz, i, 24);
    }

    private final void m13720c() {
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
        r4 = this;
        r0 = r4.a;
        r0 = r0.m5849b();
        if (r0 != 0) goto L_0x0009;
    L_0x0008:
        return;
    L_0x0009:
        r0 = r0.getInfo();	 Catch:{ IOException -> 0x0038 }
        r1 = r0.getId();	 Catch:{ IOException -> 0x0038 }
        r1 = com.google.android.gms.internal.zzdr.m5889a(r1);	 Catch:{ IOException -> 0x0038 }
        if (r1 == 0) goto L_0x0038;	 Catch:{ IOException -> 0x0038 }
    L_0x0017:
        r2 = r4.b;	 Catch:{ IOException -> 0x0038 }
        monitor-enter(r2);	 Catch:{ IOException -> 0x0038 }
        r3 = r4.b;	 Catch:{ all -> 0x0035 }
        r3.f17635S = r1;	 Catch:{ all -> 0x0035 }
        r1 = r4.b;	 Catch:{ all -> 0x0035 }
        r0 = r0.isLimitAdTrackingEnabled();	 Catch:{ all -> 0x0035 }
        r0 = java.lang.Boolean.valueOf(r0);	 Catch:{ all -> 0x0035 }
        r1.f17637U = r0;	 Catch:{ all -> 0x0035 }
        r0 = r4.b;	 Catch:{ all -> 0x0035 }
        r1 = 5;	 Catch:{ all -> 0x0035 }
        r1 = java.lang.Integer.valueOf(r1);	 Catch:{ all -> 0x0035 }
        r0.f17636T = r1;	 Catch:{ all -> 0x0035 }
        monitor-exit(r2);	 Catch:{ all -> 0x0035 }
        return;	 Catch:{ all -> 0x0035 }
    L_0x0035:
        r0 = move-exception;	 Catch:{ all -> 0x0035 }
        monitor-exit(r2);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ IOException -> 0x0038 }
    L_0x0038:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzed.c():void");
    }

    public final /* synthetic */ Object call() throws Exception {
        return mo1871b();
    }

    public final Void mo1871b() throws Exception {
        if (this.a.f7226k) {
            return super.mo1871b();
        }
        if (this.a.f7224i) {
            m13720c();
        }
        return null;
    }

    protected final void mo1870a() throws IllegalAccessException, InvocationTargetException {
        if (this.a.f7224i) {
            m13720c();
            return;
        }
        synchronized (this.b) {
            this.b.f17635S = (String) this.c.invoke(null, new Object[]{this.a.m5845a()});
        }
    }
}
