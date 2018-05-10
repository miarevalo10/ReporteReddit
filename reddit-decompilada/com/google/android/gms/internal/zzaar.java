package com.google.android.gms.internal;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import com.google.android.gms.ads.internal.zzbs;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzg;

@zzzv
public final class zzaar extends zzaan implements zzf, zzg {
    private Context f17362a;
    private zzakd f17363b;
    private zzalh<zzaat> f17364c;
    private final zzaal f17365d;
    private final Object f17366e = new Object();
    private zzaas f17367f;

    public zzaar(Context context, zzakd com_google_android_gms_internal_zzakd, zzalh<zzaat> com_google_android_gms_internal_zzalh_com_google_android_gms_internal_zzaat, zzaal com_google_android_gms_internal_zzaal) {
        super(com_google_android_gms_internal_zzalh_com_google_android_gms_internal_zzaat, com_google_android_gms_internal_zzaal);
        this.f17362a = context;
        this.f17363b = com_google_android_gms_internal_zzakd;
        this.f17364c = com_google_android_gms_internal_zzalh_com_google_android_gms_internal_zzaat;
        this.f17365d = com_google_android_gms_internal_zzaal;
        this.f17367f = new zzaas(context, ((Boolean) zzkb.m6350f().m6488a(zznh.f7867C)).booleanValue() ? zzbs.m4500s().m5300a() : context.getMainLooper(), this, this, this.f17363b.f17553c);
        this.f17367f.m4860o();
    }

    public final void mo1620a() {
        mo1645e();
    }

    public final void mo1621a(int i) {
        zzakb.m5366b("Disconnected from remote ad request service.");
    }

    public final void mo1622a(ConnectionResult connectionResult) {
        zzakb.m5366b("Cannot connect to remote service, fallback to local instance.");
        new zzaaq(this.f17362a, this.f17364c, this.f17365d).mo1645e();
        Bundle bundle = new Bundle();
        bundle.putString("action", "gms_connection_failed_fallback_to_local");
        zzbs.m4486e();
        zzahn.m5193b(this.f17362a, this.f17363b.f17551a, "gmob-apps", bundle, true);
    }

    public final void mo3429b() {
        synchronized (this.f17366e) {
            if (this.f17367f.m4853f() || this.f17367f.m4854g()) {
                this.f17367f.mo4292e();
            }
            Binder.flushPendingCommands();
        }
    }

    public final com.google.android.gms.internal.zzabb mo3430c() {
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
        r0 = r2.f17366e;
        monitor-enter(r0);
        r1 = r2.f17367f;	 Catch:{ IllegalStateException -> 0x000d, IllegalStateException -> 0x000d }
        r1 = r1.mo1649n();	 Catch:{ IllegalStateException -> 0x000d, IllegalStateException -> 0x000d }
        monitor-exit(r0);	 Catch:{ all -> 0x000b }
        return r1;	 Catch:{ all -> 0x000b }
    L_0x000b:
        r1 = move-exception;	 Catch:{ all -> 0x000b }
        goto L_0x0010;	 Catch:{ all -> 0x000b }
    L_0x000d:
        r1 = 0;	 Catch:{ all -> 0x000b }
        monitor-exit(r0);	 Catch:{ all -> 0x000b }
        return r1;	 Catch:{ all -> 0x000b }
    L_0x0010:
        monitor-exit(r0);	 Catch:{ all -> 0x000b }
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzaar.c():com.google.android.gms.internal.zzabb");
    }
}
