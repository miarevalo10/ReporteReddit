package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Result;

public final class zzal implements zzbh {
    final zzbi f13855a;
    boolean f13856b = false;

    public zzal(zzbi com_google_android_gms_common_api_internal_zzbi) {
        this.f13855a = com_google_android_gms_common_api_internal_zzbi;
    }

    public final <A extends zzb, R extends Result, T extends zzm<R, A>> T mo1570a(T t) {
        return mo1575b(t);
    }

    public final void mo1571a() {
    }

    public final void mo1572a(int i) {
        this.f13855a.m17602a(null);
        this.f13855a.f17289n.mo1590a(i, this.f13856b);
    }

    public final void mo1573a(Bundle bundle) {
    }

    public final void mo1574a(ConnectionResult connectionResult, Api<?> api, boolean z) {
    }

    public final void mo1577c() {
        if (this.f13856b) {
            this.f13856b = false;
            this.f13855a.m17604a(new zzan(this, this));
        }
    }

    public final <A extends com.google.android.gms.common.api.Api.zzb, T extends com.google.android.gms.common.api.internal.zzm<? extends com.google.android.gms.common.api.Result, A>> T mo1575b(T r4) {
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
        r3 = this;
        r0 = r3.f13855a;	 Catch:{ DeadObjectException -> 0x0045 }
        r0 = r0.f17288m;	 Catch:{ DeadObjectException -> 0x0045 }
        r0 = r0.f13899e;	 Catch:{ DeadObjectException -> 0x0045 }
        r0.m4764a(r4);	 Catch:{ DeadObjectException -> 0x0045 }
        r0 = r3.f13855a;	 Catch:{ DeadObjectException -> 0x0045 }
        r0 = r0.f17288m;	 Catch:{ DeadObjectException -> 0x0045 }
        r1 = r4.f17313d;	 Catch:{ DeadObjectException -> 0x0045 }
        r0 = r0.f13896b;	 Catch:{ DeadObjectException -> 0x0045 }
        r0 = r0.get(r1);	 Catch:{ DeadObjectException -> 0x0045 }
        r0 = (com.google.android.gms.common.api.Api.zze) r0;	 Catch:{ DeadObjectException -> 0x0045 }
        r1 = "Appropriate Api was not requested.";	 Catch:{ DeadObjectException -> 0x0045 }
        com.google.android.gms.common.internal.zzbq.m4809a(r0, r1);	 Catch:{ DeadObjectException -> 0x0045 }
        r1 = r0.m12812f();	 Catch:{ DeadObjectException -> 0x0045 }
        if (r1 != 0) goto L_0x0039;	 Catch:{ DeadObjectException -> 0x0045 }
    L_0x0022:
        r1 = r3.f13855a;	 Catch:{ DeadObjectException -> 0x0045 }
        r1 = r1.f17282g;	 Catch:{ DeadObjectException -> 0x0045 }
        r2 = r4.f17313d;	 Catch:{ DeadObjectException -> 0x0045 }
        r1 = r1.containsKey(r2);	 Catch:{ DeadObjectException -> 0x0045 }
        if (r1 == 0) goto L_0x0039;	 Catch:{ DeadObjectException -> 0x0045 }
    L_0x002e:
        r0 = new com.google.android.gms.common.api.Status;	 Catch:{ DeadObjectException -> 0x0045 }
        r1 = 17;	 Catch:{ DeadObjectException -> 0x0045 }
        r0.<init>(r1);	 Catch:{ DeadObjectException -> 0x0045 }
        r4.m17674c(r0);	 Catch:{ DeadObjectException -> 0x0045 }
        goto L_0x004f;	 Catch:{ DeadObjectException -> 0x0045 }
    L_0x0039:
        r1 = r0 instanceof com.google.android.gms.common.internal.zzbz;	 Catch:{ DeadObjectException -> 0x0045 }
        if (r1 == 0) goto L_0x0041;	 Catch:{ DeadObjectException -> 0x0045 }
    L_0x003d:
        r0 = com.google.android.gms.common.internal.zzbz.m20203n();	 Catch:{ DeadObjectException -> 0x0045 }
    L_0x0041:
        r4.m17673b(r0);	 Catch:{ DeadObjectException -> 0x0045 }
        goto L_0x004f;
    L_0x0045:
        r0 = r3.f13855a;
        r1 = new com.google.android.gms.common.api.internal.zzam;
        r1.<init>(r3, r3);
        r0.m17604a(r1);
    L_0x004f:
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.zzal.b(com.google.android.gms.common.api.internal.zzm):T");
    }

    public final boolean mo1576b() {
        if (this.f13856b) {
            return false;
        }
        if (this.f13855a.f17288m.m12985n()) {
            this.f13856b = true;
            for (zzdg com_google_android_gms_common_api_internal_zzdg : this.f13855a.f17288m.f13898d) {
                com_google_android_gms_common_api_internal_zzdg.f13945b = null;
            }
            return false;
        }
        this.f13855a.m17602a(null);
        return true;
    }
}
