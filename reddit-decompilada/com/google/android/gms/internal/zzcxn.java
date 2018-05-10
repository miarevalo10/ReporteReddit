package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzm;
import com.google.android.gms.common.internal.zzr;

public final class zzcxn extends zzab<zzcxl> implements zzcxd {
    private final boolean f19225a;
    private final zzr f19226i;
    private final Bundle f19227j;
    private Integer f19228k;

    protected final /* synthetic */ IInterface mo1646a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
        return queryLocalInterface instanceof zzcxl ? (zzcxl) queryLocalInterface : new zzcxm(iBinder);
    }

    protected final String mo1647a() {
        return "com.google.android.gms.signin.service.START";
    }

    public final void mo4025a(com.google.android.gms.common.internal.zzan r3, boolean r4) {
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
        r2 = this;
        r0 = r2.m4863r();	 Catch:{ RemoteException -> 0x0010 }
        r0 = (com.google.android.gms.internal.zzcxl) r0;	 Catch:{ RemoteException -> 0x0010 }
        r1 = r2.f19228k;	 Catch:{ RemoteException -> 0x0010 }
        r1 = r1.intValue();	 Catch:{ RemoteException -> 0x0010 }
        r0.mo1852a(r3, r1, r4);	 Catch:{ RemoteException -> 0x0010 }
        return;
    L_0x0010:
        r3 = "SignInClientImpl";
        r4 = "Remote service probably died when saveDefaultAccount is called";
        android.util.Log.w(r3, r4);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcxn.a(com.google.android.gms.common.internal.zzan, boolean):void");
    }

    protected final String mo1648b() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    public final boolean mo4023h() {
        return this.f19225a;
    }

    public final void mo4027l() {
        m4846a(new zzm(this));
    }

    public final void m_() {
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
        r2 = this;
        r0 = r2.m4863r();	 Catch:{ RemoteException -> 0x0010 }
        r0 = (com.google.android.gms.internal.zzcxl) r0;	 Catch:{ RemoteException -> 0x0010 }
        r1 = r2.f19228k;	 Catch:{ RemoteException -> 0x0010 }
        r1 = r1.intValue();	 Catch:{ RemoteException -> 0x0010 }
        r0.mo1851a(r1);	 Catch:{ RemoteException -> 0x0010 }
        return;
    L_0x0010:
        r0 = "SignInClientImpl";
        r1 = "Remote service probably died when clearAccountFromSessionStore is called";
        android.util.Log.w(r0, r1);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcxn.m_():void");
    }

    private zzcxn(Context context, Looper looper, zzr com_google_android_gms_common_internal_zzr, Bundle bundle, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 44, com_google_android_gms_common_internal_zzr, connectionCallbacks, onConnectionFailedListener);
        this.f19225a = true;
        this.f19226i = com_google_android_gms_common_internal_zzr;
        this.f19227j = bundle;
        this.f19228k = com_google_android_gms_common_internal_zzr.f5948h;
    }

    public zzcxn(Context context, Looper looper, zzr com_google_android_gms_common_internal_zzr, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        zzcxe com_google_android_gms_internal_zzcxe = com_google_android_gms_common_internal_zzr.f5947g;
        Integer num = com_google_android_gms_common_internal_zzr.f5948h;
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", com_google_android_gms_common_internal_zzr.f5941a);
        if (num != null) {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", num.intValue());
        }
        if (com_google_android_gms_internal_zzcxe != null) {
            bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", com_google_android_gms_internal_zzcxe.f19217b);
            bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", com_google_android_gms_internal_zzcxe.f19218c);
            bundle.putString("com.google.android.gms.signin.internal.serverClientId", com_google_android_gms_internal_zzcxe.f19219d);
            bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
            bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", com_google_android_gms_internal_zzcxe.f19220e);
            bundle.putString("com.google.android.gms.signin.internal.hostedDomain", com_google_android_gms_internal_zzcxe.f19221f);
            bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", com_google_android_gms_internal_zzcxe.f19222g);
            if (com_google_android_gms_internal_zzcxe.f19223h != null) {
                bundle.putLong("com.google.android.gms.signin.internal.authApiSignInModuleVersion", com_google_android_gms_internal_zzcxe.f19223h.longValue());
            }
            if (com_google_android_gms_internal_zzcxe.f19224i != null) {
                bundle.putLong("com.google.android.gms.signin.internal.realClientLibraryVersion", com_google_android_gms_internal_zzcxe.f19224i.longValue());
            }
        }
        this(context, looper, com_google_android_gms_common_internal_zzr, bundle, connectionCallbacks, onConnectionFailedListener);
    }

    public final void mo4026a(com.google.android.gms.internal.zzcxj r5) {
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
        r0 = "Expecting a valid ISignInCallbacks";
        com.google.android.gms.common.internal.zzbq.m4809a(r5, r0);
        r0 = r4.f19226i;	 Catch:{ RemoteException -> 0x0046 }
        r1 = r0.f5941a;	 Catch:{ RemoteException -> 0x0046 }
        if (r1 == 0) goto L_0x000e;	 Catch:{ RemoteException -> 0x0046 }
    L_0x000b:
        r0 = r0.f5941a;	 Catch:{ RemoteException -> 0x0046 }
        goto L_0x0017;	 Catch:{ RemoteException -> 0x0046 }
    L_0x000e:
        r0 = new android.accounts.Account;	 Catch:{ RemoteException -> 0x0046 }
        r1 = "<<default account>>";	 Catch:{ RemoteException -> 0x0046 }
        r2 = "com.google";	 Catch:{ RemoteException -> 0x0046 }
        r0.<init>(r1, r2);	 Catch:{ RemoteException -> 0x0046 }
    L_0x0017:
        r1 = 0;	 Catch:{ RemoteException -> 0x0046 }
        r2 = "<<default account>>";	 Catch:{ RemoteException -> 0x0046 }
        r3 = r0.name;	 Catch:{ RemoteException -> 0x0046 }
        r2 = r2.equals(r3);	 Catch:{ RemoteException -> 0x0046 }
        if (r2 == 0) goto L_0x002c;	 Catch:{ RemoteException -> 0x0046 }
    L_0x0022:
        r1 = r4.f5913e;	 Catch:{ RemoteException -> 0x0046 }
        r1 = com.google.android.gms.auth.api.signin.internal.zzz.m4620a(r1);	 Catch:{ RemoteException -> 0x0046 }
        r1 = r1.m4624a();	 Catch:{ RemoteException -> 0x0046 }
    L_0x002c:
        r2 = new com.google.android.gms.common.internal.zzbr;	 Catch:{ RemoteException -> 0x0046 }
        r3 = r4.f19228k;	 Catch:{ RemoteException -> 0x0046 }
        r3 = r3.intValue();	 Catch:{ RemoteException -> 0x0046 }
        r2.<init>(r0, r3, r1);	 Catch:{ RemoteException -> 0x0046 }
        r0 = r4.m4863r();	 Catch:{ RemoteException -> 0x0046 }
        r0 = (com.google.android.gms.internal.zzcxl) r0;	 Catch:{ RemoteException -> 0x0046 }
        r1 = new com.google.android.gms.internal.zzcxo;	 Catch:{ RemoteException -> 0x0046 }
        r1.<init>(r2);	 Catch:{ RemoteException -> 0x0046 }
        r0.mo1853a(r1, r5);	 Catch:{ RemoteException -> 0x0046 }
        return;
    L_0x0046:
        r0 = move-exception;
        r1 = "SignInClientImpl";
        r2 = "Remote service probably died when signIn is called";
        android.util.Log.w(r1, r2);
        r1 = new com.google.android.gms.internal.zzcxq;	 Catch:{ RemoteException -> 0x0057 }
        r1.<init>();	 Catch:{ RemoteException -> 0x0057 }
        r5.mo3496a(r1);	 Catch:{ RemoteException -> 0x0057 }
        return;
    L_0x0057:
        r5 = "SignInClientImpl";
        r1 = "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.";
        android.util.Log.wtf(r5, r1, r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcxn.a(com.google.android.gms.internal.zzcxj):void");
    }

    protected final Bundle mo4022p() {
        if (!this.f5913e.getPackageName().equals(this.f19226i.f5945e)) {
            this.f19227j.putString("com.google.android.gms.signin.internal.realClientPackageName", this.f19226i.f5945e);
        }
        return this.f19227j;
    }
}
