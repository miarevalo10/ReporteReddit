package com.google.android.gms.common.api.internal;

import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import com.google.android.gms.common.api.zze;
import java.lang.ref.WeakReference;

final class zzdl implements DeathRecipient, zzdm {
    private final WeakReference<BasePendingResult<?>> f13954a;
    private final WeakReference<zze> f13955b;
    private final WeakReference<IBinder> f13956c;

    private zzdl(BasePendingResult<?> basePendingResult, IBinder iBinder) {
        this.f13955b = new WeakReference(null);
        this.f13954a = new WeakReference(basePendingResult);
        this.f13956c = new WeakReference(iBinder);
    }

    private final void m13029a() {
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
        r0 = r2.f13954a;
        r0 = r0.get();
        r0 = (com.google.android.gms.common.api.internal.BasePendingResult) r0;
        r1 = r2.f13955b;
        r1 = r1.get();
        r1 = (com.google.android.gms.common.api.zze) r1;
        if (r1 == 0) goto L_0x001e;
    L_0x0012:
        if (r0 == 0) goto L_0x001e;
    L_0x0014:
        r0 = r0.mo1546e();
        r0.intValue();
        r1.m4778a();
    L_0x001e:
        r0 = r2.f13956c;
        r0 = r0.get();
        r0 = (android.os.IBinder) r0;
        if (r0 == 0) goto L_0x002c;
    L_0x0028:
        r1 = 0;
        r0.unlinkToDeath(r2, r1);	 Catch:{ NoSuchElementException -> 0x002c }
    L_0x002c:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.zzdl.a():void");
    }

    public final void mo1611a(BasePendingResult<?> basePendingResult) {
        m13029a();
    }

    public final void binderDied() {
        m13029a();
    }
}
