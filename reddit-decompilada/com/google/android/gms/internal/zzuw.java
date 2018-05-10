package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.ads.mediation.AdUrlAdapter;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEventAdapter;
import com.google.android.gms.ads.mediation.customevent.CustomEventExtras;
import java.util.Map;

@zzzv
public final class zzuw extends zzuy {
    public Map<Class<? extends NetworkExtras>, NetworkExtras> f18313a;

    private final <NETWORK_EXTRAS extends com.google.ads.mediation.NetworkExtras, SERVER_PARAMETERS extends com.google.ads.mediation.MediationServerParameters> com.google.android.gms.internal.zzva m19051c(java.lang.String r4) throws android.os.RemoteException {
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
        r0 = 0;
        r1 = com.google.android.gms.internal.zzuw.class;	 Catch:{ Throwable -> 0x0069 }
        r1 = r1.getClassLoader();	 Catch:{ Throwable -> 0x0069 }
        r0 = java.lang.Class.forName(r4, r0, r1);	 Catch:{ Throwable -> 0x0069 }
        r1 = com.google.ads.mediation.MediationAdapter.class;	 Catch:{ Throwable -> 0x0069 }
        r1 = r1.isAssignableFrom(r0);	 Catch:{ Throwable -> 0x0069 }
        if (r1 == 0) goto L_0x002b;	 Catch:{ Throwable -> 0x0069 }
    L_0x0013:
        r0 = r0.newInstance();	 Catch:{ Throwable -> 0x0069 }
        r0 = (com.google.ads.mediation.MediationAdapter) r0;	 Catch:{ Throwable -> 0x0069 }
        r1 = r3.f18313a;	 Catch:{ Throwable -> 0x0069 }
        r2 = r0.getAdditionalParametersType();	 Catch:{ Throwable -> 0x0069 }
        r1 = r1.get(r2);	 Catch:{ Throwable -> 0x0069 }
        r1 = (com.google.ads.mediation.NetworkExtras) r1;	 Catch:{ Throwable -> 0x0069 }
        r2 = new com.google.android.gms.internal.zzvw;	 Catch:{ Throwable -> 0x0069 }
        r2.<init>(r0, r1);	 Catch:{ Throwable -> 0x0069 }
        return r2;	 Catch:{ Throwable -> 0x0069 }
    L_0x002b:
        r1 = com.google.android.gms.ads.mediation.MediationAdapter.class;	 Catch:{ Throwable -> 0x0069 }
        r1 = r1.isAssignableFrom(r0);	 Catch:{ Throwable -> 0x0069 }
        if (r1 == 0) goto L_0x003f;	 Catch:{ Throwable -> 0x0069 }
    L_0x0033:
        r0 = r0.newInstance();	 Catch:{ Throwable -> 0x0069 }
        r0 = (com.google.android.gms.ads.mediation.MediationAdapter) r0;	 Catch:{ Throwable -> 0x0069 }
        r1 = new com.google.android.gms.internal.zzvr;	 Catch:{ Throwable -> 0x0069 }
        r1.<init>(r0);	 Catch:{ Throwable -> 0x0069 }
        return r1;	 Catch:{ Throwable -> 0x0069 }
    L_0x003f:
        r0 = 64;	 Catch:{ Throwable -> 0x0069 }
        r1 = java.lang.String.valueOf(r4);	 Catch:{ Throwable -> 0x0069 }
        r1 = r1.length();	 Catch:{ Throwable -> 0x0069 }
        r0 = r0 + r1;	 Catch:{ Throwable -> 0x0069 }
        r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0069 }
        r1.<init>(r0);	 Catch:{ Throwable -> 0x0069 }
        r0 = "Could not instantiate mediation adapter: ";	 Catch:{ Throwable -> 0x0069 }
        r1.append(r0);	 Catch:{ Throwable -> 0x0069 }
        r1.append(r4);	 Catch:{ Throwable -> 0x0069 }
        r0 = " (not a valid adapter).";	 Catch:{ Throwable -> 0x0069 }
        r1.append(r0);	 Catch:{ Throwable -> 0x0069 }
        r0 = r1.toString();	 Catch:{ Throwable -> 0x0069 }
        com.google.android.gms.internal.zzakb.m5371e(r0);	 Catch:{ Throwable -> 0x0069 }
        r0 = new android.os.RemoteException;	 Catch:{ Throwable -> 0x0069 }
        r0.<init>();	 Catch:{ Throwable -> 0x0069 }
        throw r0;	 Catch:{ Throwable -> 0x0069 }
    L_0x0069:
        r4 = r3.m19052d(r4);
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzuw.c(java.lang.String):com.google.android.gms.internal.zzva");
    }

    private final zzva m19052d(String str) throws RemoteException {
        try {
            zzakb.m5366b("Reflection failed, retrying using direct instantiation");
            if ("com.google.ads.mediation.admob.AdMobAdapter".equals(str)) {
                return new zzvr(new AdMobAdapter());
            }
            if ("com.google.ads.mediation.AdUrlAdapter".equals(str)) {
                return new zzvr(new AdUrlAdapter());
            }
            if ("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter".equals(str)) {
                return new zzvr(new CustomEventAdapter());
            }
            if ("com.google.ads.mediation.customevent.CustomEventAdapter".equals(str)) {
                MediationAdapter customEventAdapter = new com.google.ads.mediation.customevent.CustomEventAdapter();
                return new zzvw(customEventAdapter, (CustomEventExtras) this.f18313a.get(customEventAdapter.getAdditionalParametersType()));
            }
            throw new RemoteException();
        } catch (Throwable th) {
            StringBuilder stringBuilder = new StringBuilder(43 + String.valueOf(str).length());
            stringBuilder.append("Could not instantiate mediation adapter: ");
            stringBuilder.append(str);
            stringBuilder.append(". ");
            zzakb.m5369c(stringBuilder.toString(), th);
        }
    }

    public final zzva mo2168a(String str) throws RemoteException {
        return m19051c(str);
    }

    public final boolean mo2169b(java.lang.String r4) throws android.os.RemoteException {
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
        r0 = 0;
        r1 = com.google.android.gms.internal.zzuw.class;	 Catch:{ Throwable -> 0x0012 }
        r1 = r1.getClassLoader();	 Catch:{ Throwable -> 0x0012 }
        r1 = java.lang.Class.forName(r4, r0, r1);	 Catch:{ Throwable -> 0x0012 }
        r2 = com.google.android.gms.ads.mediation.customevent.CustomEvent.class;	 Catch:{ Throwable -> 0x0012 }
        r1 = r2.isAssignableFrom(r1);	 Catch:{ Throwable -> 0x0012 }
        return r1;
    L_0x0012:
        r1 = 80;
        r2 = java.lang.String.valueOf(r4);
        r2 = r2.length();
        r1 = r1 + r2;
        r2 = new java.lang.StringBuilder;
        r2.<init>(r1);
        r1 = "Could not load custom event implementation class: ";
        r2.append(r1);
        r2.append(r4);
        r4 = ", assuming old implementation.";
        r2.append(r4);
        r4 = r2.toString();
        com.google.android.gms.internal.zzakb.m5371e(r4);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzuw.b(java.lang.String):boolean");
    }
}
