package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public final class zzdj {
    public static final Status f5833a = new Status(8, "The connection to Google Play services was lost");
    static final BasePendingResult<?>[] f5834b = new BasePendingResult[0];
    final Set<BasePendingResult<?>> f5835c = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));
    private final zzdm f5836d = new zzdk(this);
    private final Map<zzc<?>, zze> f5837e;

    public zzdj(Map<zzc<?>, zze> map) {
        this.f5837e = map;
    }

    final void m4764a(BasePendingResult<? extends Result> basePendingResult) {
        this.f5835c.add(basePendingResult);
        basePendingResult.m12828a(this.f5836d);
    }

    public final void m4763a() {
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
        r8 = this;
        r0 = r8.f5835c;
        r1 = f5834b;
        r0 = r0.toArray(r1);
        r0 = (com.google.android.gms.common.api.internal.BasePendingResult[]) r0;
        r1 = 0;
        r2 = r0.length;
        r3 = r1;
    L_0x000d:
        if (r3 >= r2) goto L_0x0076;
    L_0x000f:
        r4 = r0[r3];
        r5 = 0;
        r4.m12828a(r5);
        r6 = r4.mo1546e();
        if (r6 != 0) goto L_0x0027;
    L_0x001b:
        r5 = r4.m12831b();
        if (r5 == 0) goto L_0x0073;
    L_0x0021:
        r5 = r8.f5835c;
        r5.remove(r4);
        goto L_0x0073;
    L_0x0027:
        r4.mo1543a(r5);
        r6 = r8.f5837e;
        r7 = r4;
        r7 = (com.google.android.gms.common.api.internal.zzm) r7;
        r7 = r7.f17313d;
        r6 = r6.get(r7);
        r6 = (com.google.android.gms.common.api.Api.zze) r6;
        r6 = r6.m12815i();
        r7 = r4.m12829a();
        if (r7 == 0) goto L_0x004a;
    L_0x0041:
        r5 = new com.google.android.gms.common.api.internal.zzdl;
        r5.<init>(r4, r6, r1);
        r4.m12828a(r5);
        goto L_0x006e;
    L_0x004a:
        if (r6 == 0) goto L_0x005e;
    L_0x004c:
        r7 = r6.isBinderAlive();
        if (r7 == 0) goto L_0x005e;
    L_0x0052:
        r7 = new com.google.android.gms.common.api.internal.zzdl;
        r7.<init>(r4, r6, r1);
        r4.m12828a(r7);
        r6.linkToDeath(r7, r1);	 Catch:{ RemoteException -> 0x0061 }
        goto L_0x006e;
    L_0x005e:
        r4.m12828a(r5);
    L_0x0061:
        r4.mo1544c();
        r6 = r4.mo1546e();
        r6.intValue();
        r5.m4778a();
    L_0x006e:
        r5 = r8.f5835c;
        r5.remove(r4);
    L_0x0073:
        r3 = r3 + 1;
        goto L_0x000d;
    L_0x0076:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.zzdj.a():void");
    }
}
