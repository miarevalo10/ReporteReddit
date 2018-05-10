package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzg;

public final class zzcku implements ServiceConnection, zzf, zzg {
    volatile boolean f14246a;
    volatile zzchl f14247b;
    final /* synthetic */ zzckg f14248c;

    protected zzcku(zzckg com_google_android_gms_internal_zzckg) {
        this.f14248c = com_google_android_gms_internal_zzckg;
    }

    public final void mo1620a() {
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
        r4 = this;
        r0 = "MeasurementServiceConnection.onConnected";
        com.google.android.gms.common.internal.zzbq.m4816b(r0);
        monitor-enter(r4);
        r0 = 0;
        r1 = r4.f14247b;	 Catch:{ DeadObjectException -> 0x0022, DeadObjectException -> 0x0022 }
        r1 = r1.m4863r();	 Catch:{ DeadObjectException -> 0x0022, DeadObjectException -> 0x0022 }
        r1 = (com.google.android.gms.internal.zzche) r1;	 Catch:{ DeadObjectException -> 0x0022, DeadObjectException -> 0x0022 }
        r4.f14247b = r0;	 Catch:{ DeadObjectException -> 0x0022, DeadObjectException -> 0x0022 }
        r2 = r4.f14248c;	 Catch:{ DeadObjectException -> 0x0022, DeadObjectException -> 0x0022 }
        r2 = r2.mo1827s();	 Catch:{ DeadObjectException -> 0x0022, DeadObjectException -> 0x0022 }
        r3 = new com.google.android.gms.internal.zzckx;	 Catch:{ DeadObjectException -> 0x0022, DeadObjectException -> 0x0022 }
        r3.<init>(r4, r1);	 Catch:{ DeadObjectException -> 0x0022, DeadObjectException -> 0x0022 }
        r2.m18271a(r3);	 Catch:{ DeadObjectException -> 0x0022, DeadObjectException -> 0x0022 }
        goto L_0x0027;
    L_0x0020:
        r0 = move-exception;
        goto L_0x0029;
    L_0x0022:
        r4.f14247b = r0;	 Catch:{ all -> 0x0020 }
        r0 = 0;	 Catch:{ all -> 0x0020 }
        r4.f14246a = r0;	 Catch:{ all -> 0x0020 }
    L_0x0027:
        monitor-exit(r4);	 Catch:{ all -> 0x0020 }
        return;	 Catch:{ all -> 0x0020 }
    L_0x0029:
        monitor-exit(r4);	 Catch:{ all -> 0x0020 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcku.a():void");
    }

    public final void onServiceConnected(android.content.ComponentName r4, android.os.IBinder r5) {
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
        r3 = this;
        r4 = "MeasurementServiceConnection.onServiceConnected";
        com.google.android.gms.common.internal.zzbq.m4816b(r4);
        monitor-enter(r3);
        r4 = 0;
        if (r5 != 0) goto L_0x001d;
    L_0x0009:
        r3.f14246a = r4;	 Catch:{ all -> 0x001a }
        r4 = r3.f14248c;	 Catch:{ all -> 0x001a }
        r4 = r4.mo1828t();	 Catch:{ all -> 0x001a }
        r4 = r4.f17816a;	 Catch:{ all -> 0x001a }
        r5 = "Service connected with null binder";	 Catch:{ all -> 0x001a }
        r4.m5693a(r5);	 Catch:{ all -> 0x001a }
        monitor-exit(r3);	 Catch:{ all -> 0x001a }
        return;
    L_0x001a:
        r4 = move-exception;
        goto L_0x0091;
    L_0x001d:
        r0 = 0;
        r1 = r5.getInterfaceDescriptor();	 Catch:{ RemoteException -> 0x005d }
        r2 = "com.google.android.gms.measurement.internal.IMeasurementService";	 Catch:{ RemoteException -> 0x005d }
        r2 = r2.equals(r1);	 Catch:{ RemoteException -> 0x005d }
        if (r2 == 0) goto L_0x004f;	 Catch:{ RemoteException -> 0x005d }
    L_0x002a:
        if (r5 != 0) goto L_0x002d;	 Catch:{ RemoteException -> 0x005d }
    L_0x002c:
        goto L_0x0041;	 Catch:{ RemoteException -> 0x005d }
    L_0x002d:
        r1 = "com.google.android.gms.measurement.internal.IMeasurementService";	 Catch:{ RemoteException -> 0x005d }
        r1 = r5.queryLocalInterface(r1);	 Catch:{ RemoteException -> 0x005d }
        r2 = r1 instanceof com.google.android.gms.internal.zzche;	 Catch:{ RemoteException -> 0x005d }
        if (r2 == 0) goto L_0x003b;	 Catch:{ RemoteException -> 0x005d }
    L_0x0037:
        r1 = (com.google.android.gms.internal.zzche) r1;	 Catch:{ RemoteException -> 0x005d }
    L_0x0039:
        r0 = r1;	 Catch:{ RemoteException -> 0x005d }
        goto L_0x0041;	 Catch:{ RemoteException -> 0x005d }
    L_0x003b:
        r1 = new com.google.android.gms.internal.zzchg;	 Catch:{ RemoteException -> 0x005d }
        r1.<init>(r5);	 Catch:{ RemoteException -> 0x005d }
        goto L_0x0039;	 Catch:{ RemoteException -> 0x005d }
    L_0x0041:
        r5 = r3.f14248c;	 Catch:{ RemoteException -> 0x005d }
        r5 = r5.mo1828t();	 Catch:{ RemoteException -> 0x005d }
        r5 = r5.f17822g;	 Catch:{ RemoteException -> 0x005d }
        r1 = "Bound to IMeasurementService interface";	 Catch:{ RemoteException -> 0x005d }
        r5.m5693a(r1);	 Catch:{ RemoteException -> 0x005d }
        goto L_0x006a;	 Catch:{ RemoteException -> 0x005d }
    L_0x004f:
        r5 = r3.f14248c;	 Catch:{ RemoteException -> 0x005d }
        r5 = r5.mo1828t();	 Catch:{ RemoteException -> 0x005d }
        r5 = r5.f17816a;	 Catch:{ RemoteException -> 0x005d }
        r2 = "Got binder with a wrong descriptor";	 Catch:{ RemoteException -> 0x005d }
        r5.m5694a(r2, r1);	 Catch:{ RemoteException -> 0x005d }
        goto L_0x006a;
    L_0x005d:
        r5 = r3.f14248c;	 Catch:{ all -> 0x001a }
        r5 = r5.mo1828t();	 Catch:{ all -> 0x001a }
        r5 = r5.f17816a;	 Catch:{ all -> 0x001a }
        r1 = "Service connect failed to get IMeasurementService";	 Catch:{ all -> 0x001a }
        r5.m5693a(r1);	 Catch:{ all -> 0x001a }
    L_0x006a:
        if (r0 != 0) goto L_0x0081;	 Catch:{ all -> 0x001a }
    L_0x006c:
        r3.f14246a = r4;	 Catch:{ all -> 0x001a }
        com.google.android.gms.common.stats.zza.m4889a();	 Catch:{ IllegalArgumentException -> 0x008f }
        r4 = r3.f14248c;	 Catch:{ IllegalArgumentException -> 0x008f }
        r4 = r4.mo1820l();	 Catch:{ IllegalArgumentException -> 0x008f }
        r5 = r3.f14248c;	 Catch:{ IllegalArgumentException -> 0x008f }
        r5 = r5.f17887b;	 Catch:{ IllegalArgumentException -> 0x008f }
        r4.unbindService(r5);	 Catch:{ IllegalArgumentException -> 0x008f }
        goto L_0x008f;
    L_0x0081:
        r4 = r3.f14248c;	 Catch:{ all -> 0x001a }
        r4 = r4.mo1827s();	 Catch:{ all -> 0x001a }
        r5 = new com.google.android.gms.internal.zzckv;	 Catch:{ all -> 0x001a }
        r5.<init>(r3, r0);	 Catch:{ all -> 0x001a }
        r4.m18271a(r5);	 Catch:{ all -> 0x001a }
    L_0x008f:
        monitor-exit(r3);	 Catch:{ all -> 0x001a }
        return;	 Catch:{ all -> 0x001a }
    L_0x0091:
        monitor-exit(r3);	 Catch:{ all -> 0x001a }
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcku.onServiceConnected(android.content.ComponentName, android.os.IBinder):void");
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        zzbq.m4816b("MeasurementServiceConnection.onServiceDisconnected");
        this.f14248c.mo1828t().f17821f.m5693a("Service disconnected");
        this.f14248c.mo1827s().m18271a(new zzckw(this, componentName));
    }

    public final void mo1621a(int i) {
        zzbq.m4816b("MeasurementServiceConnection.onConnectionSuspended");
        this.f14248c.mo1828t().f17821f.m5693a("Service connection suspended");
        this.f14248c.mo1827s().m18271a(new zzcky(this));
    }

    public final void mo1622a(ConnectionResult connectionResult) {
        zzbq.m4816b("MeasurementServiceConnection.onConnectionFailed");
        zzcim com_google_android_gms_internal_zzcim = this.f14248c.s;
        zzchm com_google_android_gms_internal_zzchm = (com_google_android_gms_internal_zzcim.f6976c == null || !com_google_android_gms_internal_zzcim.f6976c.m13544K()) ? null : com_google_android_gms_internal_zzcim.f6976c;
        if (com_google_android_gms_internal_zzchm != null) {
            com_google_android_gms_internal_zzchm.f17818c.m5694a("Service connection failed", connectionResult);
        }
        synchronized (this) {
            this.f14246a = null;
            this.f14247b = null;
        }
        this.f14248c.mo1827s().m18271a(new zzckz(this));
    }
}
