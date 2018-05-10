package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.HashSet;
import java.util.Set;

final class zzaj implements ServiceConnection {
    final Set<ServiceConnection> f5883a = new HashSet();
    int f5884b = 2;
    boolean f5885c;
    IBinder f5886d;
    final zzah f5887e;
    ComponentName f5888f;
    /* synthetic */ zzai f5889g;

    public zzaj(zzai com_google_android_gms_common_internal_zzai, zzah com_google_android_gms_common_internal_zzah) {
        this.f5889g = com_google_android_gms_common_internal_zzai;
        this.f5887e = com_google_android_gms_common_internal_zzah;
    }

    public final void m4788a(ServiceConnection serviceConnection) {
        this.f5889g.f13998d;
        this.f5889g.f13996b;
        this.f5887e.m4786a();
        this.f5883a.add(serviceConnection);
    }

    public final boolean m4789b() {
        return this.f5883a.isEmpty();
    }

    public final boolean m4790b(ServiceConnection serviceConnection) {
        return this.f5883a.contains(serviceConnection);
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.f5889g.f13995a) {
            this.f5889g.f13997c.removeMessages(1, this.f5887e);
            this.f5886d = iBinder;
            this.f5888f = componentName;
            for (ServiceConnection onServiceConnected : this.f5883a) {
                onServiceConnected.onServiceConnected(componentName, iBinder);
            }
            this.f5884b = 1;
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.f5889g.f13995a) {
            this.f5889g.f13997c.removeMessages(1, this.f5887e);
            this.f5886d = null;
            this.f5888f = componentName;
            for (ServiceConnection onServiceDisconnected : this.f5883a) {
                onServiceDisconnected.onServiceDisconnected(componentName);
            }
            this.f5884b = 2;
        }
    }

    public final void m4787a() {
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
        r0 = 3;
        r4.f5884b = r0;
        r0 = r4.f5889g;
        r0.f13998d;
        r0 = r4.f5889g;
        r0 = r0.f13996b;
        r1 = r4.f5887e;
        r1 = r1.m4786a();
        r2 = r4.f5887e;
        r2 = r2.f5881c;
        r0 = com.google.android.gms.common.stats.zza.m4890a(r0, r1, r4, r2);
        r4.f5885c = r0;
        r0 = r4.f5885c;
        if (r0 == 0) goto L_0x003f;
    L_0x0022:
        r0 = r4.f5889g;
        r0 = r0.f13997c;
        r1 = 1;
        r2 = r4.f5887e;
        r0 = r0.obtainMessage(r1, r2);
        r1 = r4.f5889g;
        r1 = r1.f13997c;
        r2 = r4.f5889g;
        r2 = r2.f14000f;
        r1.sendMessageDelayed(r0, r2);
        return;
    L_0x003f:
        r0 = 2;
        r4.f5884b = r0;
        r0 = r4.f5889g;	 Catch:{ IllegalArgumentException -> 0x0050 }
        r0.f13998d;	 Catch:{ IllegalArgumentException -> 0x0050 }
        r0 = r4.f5889g;	 Catch:{ IllegalArgumentException -> 0x0050 }
        r0 = r0.f13996b;	 Catch:{ IllegalArgumentException -> 0x0050 }
        r0.unbindService(r4);	 Catch:{ IllegalArgumentException -> 0x0050 }
    L_0x0050:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.zzaj.a():void");
    }
}
