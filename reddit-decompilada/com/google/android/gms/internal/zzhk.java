package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.KeyguardManager;
import android.content.Context;
import android.graphics.Rect;
import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.gms.ads.internal.zzbs;
import com.google.android.gms.common.util.zzq;
import java.util.List;

@zzzv
@TargetApi(14)
public final class zzhk extends Thread {
    boolean f7670a = false;
    final Object f7671b;
    final zzhf f7672c;
    final zzzt f7673d;
    final int f7674e;
    final int f7675f;
    final int f7676g;
    final int f7677h;
    final int f7678i;
    final int f7679j;
    final int f7680k;
    final boolean f7681l;
    private boolean f7682m = false;
    private boolean f7683n = false;
    private final int f7684o;
    private final String f7685p;

    public zzhk(zzhf com_google_android_gms_internal_zzhf, zzzt com_google_android_gms_internal_zzzt) {
        this.f7672c = com_google_android_gms_internal_zzhf;
        this.f7673d = com_google_android_gms_internal_zzzt;
        this.f7671b = new Object();
        this.f7674e = ((Integer) zzkb.m6350f().m6488a(zznh.f7876L)).intValue();
        this.f7675f = ((Integer) zzkb.m6350f().m6488a(zznh.f7877M)).intValue();
        this.f7676g = ((Integer) zzkb.m6350f().m6488a(zznh.f7878N)).intValue();
        this.f7677h = ((Integer) zzkb.m6350f().m6488a(zznh.f7879O)).intValue();
        this.f7678i = ((Integer) zzkb.m6350f().m6488a(zznh.f7882R)).intValue();
        this.f7679j = ((Integer) zzkb.m6350f().m6488a(zznh.f7884T)).intValue();
        this.f7680k = ((Integer) zzkb.m6350f().m6488a(zznh.f7885U)).intValue();
        this.f7684o = ((Integer) zzkb.m6350f().m6488a(zznh.f7880P)).intValue();
        this.f7685p = (String) zzkb.m6350f().m6488a(zznh.f7887W);
        this.f7681l = ((Boolean) zzkb.m6350f().m6488a(zznh.f7889Y)).booleanValue();
        setName("ContentFetchTask");
    }

    private static boolean m6292b() {
        boolean z = false;
        try {
            Context b = zzbs.m4489h().m6284b();
            if (b == null) {
                return false;
            }
            ActivityManager activityManager = (ActivityManager) b.getSystemService("activity");
            KeyguardManager keyguardManager = (KeyguardManager) b.getSystemService("keyguard");
            if (activityManager != null) {
                if (keyguardManager == null) {
                    return false;
                }
                List<RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
                if (runningAppProcesses == null) {
                    return false;
                }
                for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (Process.myPid() == runningAppProcessInfo.pid) {
                        if (runningAppProcessInfo.importance == 100 && !keyguardManager.inKeyguardRestrictedInputMode()) {
                            PowerManager powerManager = (PowerManager) b.getSystemService("power");
                            if (powerManager == null ? false : powerManager.isScreenOn()) {
                                z = true;
                            }
                        }
                    }
                }
            }
            return z;
        } catch (Throwable th) {
            zzbs.m4490i().m13246a(th, "ContentFetchTask.isInForeground");
            return false;
        }
    }

    private final void m6293c() {
        synchronized (this.f7671b) {
            this.f7670a = true;
            boolean z = this.f7670a;
            StringBuilder stringBuilder = new StringBuilder(42);
            stringBuilder.append("ContentFetchThread: paused, mPause = ");
            stringBuilder.append(z);
            zzakb.m5366b(stringBuilder.toString());
        }
    }

    public final void m6295a() {
        synchronized (this.f7671b) {
            if (this.f7682m) {
                zzakb.m5366b("Content hash thread already started, quiting...");
                return;
            }
            this.f7682m = true;
            start();
        }
    }

    public final void run() {
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
    L_0x0000:
        r0 = m6292b();	 Catch:{ InterruptedException -> 0x0076, Exception -> 0x0068 }
        if (r0 == 0) goto L_0x0059;	 Catch:{ InterruptedException -> 0x0076, Exception -> 0x0068 }
    L_0x0006:
        r0 = com.google.android.gms.ads.internal.zzbs.m4489h();	 Catch:{ InterruptedException -> 0x0076, Exception -> 0x0068 }
        r0 = r0.m6282a();	 Catch:{ InterruptedException -> 0x0076, Exception -> 0x0068 }
        if (r0 != 0) goto L_0x0019;	 Catch:{ InterruptedException -> 0x0076, Exception -> 0x0068 }
    L_0x0010:
        r0 = "ContentFetchThread: no activity. Sleeping.";	 Catch:{ InterruptedException -> 0x0076, Exception -> 0x0068 }
        com.google.android.gms.internal.zzakb.m5366b(r0);	 Catch:{ InterruptedException -> 0x0076, Exception -> 0x0068 }
    L_0x0015:
        r4.m6293c();	 Catch:{ InterruptedException -> 0x0076, Exception -> 0x0068 }
        goto L_0x005f;
    L_0x0019:
        if (r0 == 0) goto L_0x005f;
    L_0x001b:
        r1 = 0;
        r2 = r0.getWindow();	 Catch:{ Exception -> 0x003d, InterruptedException -> 0x0076 }
        if (r2 == 0) goto L_0x004c;	 Catch:{ Exception -> 0x003d, InterruptedException -> 0x0076 }
    L_0x0022:
        r2 = r0.getWindow();	 Catch:{ Exception -> 0x003d, InterruptedException -> 0x0076 }
        r2 = r2.getDecorView();	 Catch:{ Exception -> 0x003d, InterruptedException -> 0x0076 }
        if (r2 == 0) goto L_0x004c;	 Catch:{ Exception -> 0x003d, InterruptedException -> 0x0076 }
    L_0x002c:
        r0 = r0.getWindow();	 Catch:{ Exception -> 0x003d, InterruptedException -> 0x0076 }
        r0 = r0.getDecorView();	 Catch:{ Exception -> 0x003d, InterruptedException -> 0x0076 }
        r2 = 16908290; // 0x1020002 float:2.3877235E-38 double:8.353805E-317;	 Catch:{ Exception -> 0x003d, InterruptedException -> 0x0076 }
        r0 = r0.findViewById(r2);	 Catch:{ Exception -> 0x003d, InterruptedException -> 0x0076 }
        r1 = r0;
        goto L_0x004c;
    L_0x003d:
        r0 = move-exception;
        r2 = com.google.android.gms.ads.internal.zzbs.m4490i();	 Catch:{ InterruptedException -> 0x0076, Exception -> 0x0068 }
        r3 = "ContentFetchTask.extractContent";	 Catch:{ InterruptedException -> 0x0076, Exception -> 0x0068 }
        r2.m13246a(r0, r3);	 Catch:{ InterruptedException -> 0x0076, Exception -> 0x0068 }
        r0 = "Failed getting root view of activity. Content not extracted.";	 Catch:{ InterruptedException -> 0x0076, Exception -> 0x0068 }
        com.google.android.gms.internal.zzakb.m5366b(r0);	 Catch:{ InterruptedException -> 0x0076, Exception -> 0x0068 }
    L_0x004c:
        if (r1 == 0) goto L_0x005f;	 Catch:{ InterruptedException -> 0x0076, Exception -> 0x0068 }
    L_0x004e:
        if (r1 == 0) goto L_0x005f;	 Catch:{ InterruptedException -> 0x0076, Exception -> 0x0068 }
    L_0x0050:
        r0 = new com.google.android.gms.internal.zzhl;	 Catch:{ InterruptedException -> 0x0076, Exception -> 0x0068 }
        r0.<init>(r4, r1);	 Catch:{ InterruptedException -> 0x0076, Exception -> 0x0068 }
        r1.post(r0);	 Catch:{ InterruptedException -> 0x0076, Exception -> 0x0068 }
        goto L_0x005f;	 Catch:{ InterruptedException -> 0x0076, Exception -> 0x0068 }
    L_0x0059:
        r0 = "ContentFetchTask: sleeping";	 Catch:{ InterruptedException -> 0x0076, Exception -> 0x0068 }
        com.google.android.gms.internal.zzakb.m5366b(r0);	 Catch:{ InterruptedException -> 0x0076, Exception -> 0x0068 }
        goto L_0x0015;	 Catch:{ InterruptedException -> 0x0076, Exception -> 0x0068 }
    L_0x005f:
        r0 = r4.f7684o;	 Catch:{ InterruptedException -> 0x0076, Exception -> 0x0068 }
        r0 = r0 * 1000;	 Catch:{ InterruptedException -> 0x0076, Exception -> 0x0068 }
        r0 = (long) r0;	 Catch:{ InterruptedException -> 0x0076, Exception -> 0x0068 }
        java.lang.Thread.sleep(r0);	 Catch:{ InterruptedException -> 0x0076, Exception -> 0x0068 }
        goto L_0x007c;
    L_0x0068:
        r0 = move-exception;
        r1 = "Error in ContentFetchTask";
        com.google.android.gms.internal.zzakb.m5367b(r1, r0);
        r1 = r4.f7673d;
        r2 = "ContentFetchTask.run";
        r1.mo2296a(r0, r2);
        goto L_0x007c;
    L_0x0076:
        r0 = move-exception;
        r1 = "Error in ContentFetchTask";
        com.google.android.gms.internal.zzakb.m5367b(r1, r0);
    L_0x007c:
        r0 = r4.f7671b;
        monitor-enter(r0);
    L_0x007f:
        r1 = r4.f7670a;	 Catch:{ all -> 0x0091 }
        if (r1 == 0) goto L_0x008e;
    L_0x0083:
        r1 = "ContentFetchTask: waiting";	 Catch:{ InterruptedException -> 0x007f }
        com.google.android.gms.internal.zzakb.m5366b(r1);	 Catch:{ InterruptedException -> 0x007f }
        r1 = r4.f7671b;	 Catch:{ InterruptedException -> 0x007f }
        r1.wait();	 Catch:{ InterruptedException -> 0x007f }
        goto L_0x007f;
    L_0x008e:
        monitor-exit(r0);	 Catch:{ all -> 0x0091 }
        goto L_0x0000;	 Catch:{ all -> 0x0091 }
    L_0x0091:
        r1 = move-exception;	 Catch:{ all -> 0x0091 }
        monitor-exit(r0);	 Catch:{ all -> 0x0091 }
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzhk.run():void");
    }

    final zzho m6294a(View view, zzhe com_google_android_gms_internal_zzhe) {
        int i = 0;
        if (view == null) {
            return new zzho(0, 0);
        }
        Context b = zzbs.m4489h().m6284b();
        if (b != null) {
            String str = (String) view.getTag(b.getResources().getIdentifier((String) zzkb.m6350f().m6488a(zznh.f7886V), "id", b.getPackageName()));
            if (!(TextUtils.isEmpty(this.f7685p) || str == null || !str.equals(this.f7685p))) {
                return new zzho(0, 0);
            }
        }
        boolean globalVisibleRect = view.getGlobalVisibleRect(new Rect());
        if ((view instanceof TextView) && !(view instanceof EditText)) {
            CharSequence text = ((TextView) view).getText();
            if (TextUtils.isEmpty(text)) {
                return new zzho(0, 0);
            }
            com_google_android_gms_internal_zzhe.m6277b(text.toString(), globalVisibleRect, view.getX(), view.getY(), (float) view.getWidth(), (float) view.getHeight());
            return new zzho(1, 0);
        } else if ((view instanceof WebView) && !(view instanceof zzanh)) {
            com_google_android_gms_internal_zzhe.m6276b();
            WebView webView = (WebView) view;
            if (zzq.m4913e()) {
                com_google_android_gms_internal_zzhe.m6276b();
                webView.post(new zzhm(this, com_google_android_gms_internal_zzhe, webView, globalVisibleRect));
                view = 1;
            } else {
                view = null;
            }
            return view != null ? new zzho(0, 1) : new zzho(0, 0);
        } else if (!(view instanceof ViewGroup)) {
            return new zzho(0, 0);
        } else {
            ViewGroup viewGroup = (ViewGroup) view;
            int i2 = 0;
            int i3 = i2;
            while (i < viewGroup.getChildCount()) {
                zzho a = m6294a(viewGroup.getChildAt(i), com_google_android_gms_internal_zzhe);
                i2 += a.f7694a;
                i3 += a.f7695b;
                i++;
            }
            return new zzho(i2, i3);
        }
    }
}
