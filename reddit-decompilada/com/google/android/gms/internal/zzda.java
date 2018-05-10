package com.google.android.gms.internal;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import java.lang.ref.WeakReference;

final class zzda implements ActivityLifecycleCallbacks {
    private final Application f7211a;
    private final WeakReference<ActivityLifecycleCallbacks> f7212b;
    private boolean f7213c = false;

    public zzda(Application application, ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.f7212b = new WeakReference(activityLifecycleCallbacks);
        this.f7211a = application;
    }

    private final void m5833a(com.google.android.gms.internal.zzdi r2) {
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
        r1 = this;
        r0 = r1.f7212b;	 Catch:{ Exception -> 0x001a }
        r0 = r0.get();	 Catch:{ Exception -> 0x001a }
        r0 = (android.app.Application.ActivityLifecycleCallbacks) r0;	 Catch:{ Exception -> 0x001a }
        if (r0 == 0) goto L_0x000e;	 Catch:{ Exception -> 0x001a }
    L_0x000a:
        r2.mo1854a(r0);	 Catch:{ Exception -> 0x001a }
        return;	 Catch:{ Exception -> 0x001a }
    L_0x000e:
        r2 = r1.f7213c;	 Catch:{ Exception -> 0x001a }
        if (r2 != 0) goto L_0x001a;	 Catch:{ Exception -> 0x001a }
    L_0x0012:
        r2 = r1.f7211a;	 Catch:{ Exception -> 0x001a }
        r2.unregisterActivityLifecycleCallbacks(r1);	 Catch:{ Exception -> 0x001a }
        r2 = 1;	 Catch:{ Exception -> 0x001a }
        r1.f7213c = r2;	 Catch:{ Exception -> 0x001a }
    L_0x001a:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzda.a(com.google.android.gms.internal.zzdi):void");
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        m5833a(new zzdb(activity, bundle));
    }

    public final void onActivityDestroyed(Activity activity) {
        m5833a(new zzdh(activity));
    }

    public final void onActivityPaused(Activity activity) {
        m5833a(new zzde(activity));
    }

    public final void onActivityResumed(Activity activity) {
        m5833a(new zzdd(activity));
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        m5833a(new zzdg(activity, bundle));
    }

    public final void onActivityStarted(Activity activity) {
        m5833a(new zzdc(activity));
    }

    public final void onActivityStopped(Activity activity) {
        m5833a(new zzdf(activity));
    }
}
