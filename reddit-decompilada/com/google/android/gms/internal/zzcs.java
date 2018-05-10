package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import java.util.LinkedList;

public abstract class zzcs implements zzcr {
    protected MotionEvent f14256a;
    protected LinkedList<MotionEvent> f14257b = new LinkedList();
    protected long f14258c = 0;
    protected long f14259d = 0;
    protected long f14260e = 0;
    protected long f14261f = 0;
    protected long f14262g = 0;
    protected long f14263h = 0;
    protected long f14264i = 0;
    protected double f14265j;
    protected float f14266k;
    protected float f14267l;
    protected float f14268m;
    protected float f14269n;
    protected boolean f14270o = false;
    protected DisplayMetrics f14271p;
    private double f14272q;
    private double f14273r;
    private boolean f14274s = false;

    protected zzcs(android.content.Context r3) {
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
        r2.<init>();
        r0 = new java.util.LinkedList;
        r0.<init>();
        r2.f14257b = r0;
        r0 = 0;
        r2.f14258c = r0;
        r2.f14259d = r0;
        r2.f14260e = r0;
        r2.f14261f = r0;
        r2.f14262g = r0;
        r2.f14263h = r0;
        r2.f14264i = r0;
        r0 = 0;
        r2.f14274s = r0;
        r2.f14270o = r0;
        r0 = com.google.android.gms.internal.zznh.by;	 Catch:{ Throwable -> 0x0042 }
        r1 = com.google.android.gms.internal.zzkb.m6350f();	 Catch:{ Throwable -> 0x0042 }
        r0 = r1.m6488a(r0);	 Catch:{ Throwable -> 0x0042 }
        r0 = (java.lang.Boolean) r0;	 Catch:{ Throwable -> 0x0042 }
        r0 = r0.booleanValue();	 Catch:{ Throwable -> 0x0042 }
        if (r0 == 0) goto L_0x0035;	 Catch:{ Throwable -> 0x0042 }
    L_0x0031:
        com.google.android.gms.internal.zzbw.m5583a();	 Catch:{ Throwable -> 0x0042 }
        goto L_0x0038;	 Catch:{ Throwable -> 0x0042 }
    L_0x0035:
        com.google.android.gms.internal.zzbz.m5590a();	 Catch:{ Throwable -> 0x0042 }
    L_0x0038:
        r3 = r3.getResources();	 Catch:{ Throwable -> 0x0042 }
        r3 = r3.getDisplayMetrics();	 Catch:{ Throwable -> 0x0042 }
        r2.f14271p = r3;	 Catch:{ Throwable -> 0x0042 }
    L_0x0042:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcs.<init>(android.content.Context):void");
    }

    private final java.lang.String m13563a(android.content.Context r1, java.lang.String r2, boolean r3, android.view.View r4, android.app.Activity r5) {
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
        r0 = this;
        if (r3 == 0) goto L_0x000a;
    L_0x0002:
        r1 = r0.mo3493a(r1, r4, r5);	 Catch:{ GeneralSecurityException -> 0x0021, GeneralSecurityException -> 0x0021, Throwable -> 0x001f }
        r3 = 1;	 Catch:{ GeneralSecurityException -> 0x0021, GeneralSecurityException -> 0x0021, Throwable -> 0x001f }
        r0.f14274s = r3;	 Catch:{ GeneralSecurityException -> 0x0021, GeneralSecurityException -> 0x0021, Throwable -> 0x001f }
        goto L_0x000e;	 Catch:{ GeneralSecurityException -> 0x0021, GeneralSecurityException -> 0x0021, Throwable -> 0x001f }
    L_0x000a:
        r1 = r0.mo3494b(r1);	 Catch:{ GeneralSecurityException -> 0x0021, GeneralSecurityException -> 0x0021, Throwable -> 0x001f }
    L_0x000e:
        r3 = r1.m6211e();	 Catch:{ GeneralSecurityException -> 0x0021, GeneralSecurityException -> 0x0021, Throwable -> 0x001f }
        if (r3 != 0) goto L_0x001a;	 Catch:{ GeneralSecurityException -> 0x0021, GeneralSecurityException -> 0x0021, Throwable -> 0x001f }
    L_0x0014:
        r1 = 5;	 Catch:{ GeneralSecurityException -> 0x0021, GeneralSecurityException -> 0x0021, Throwable -> 0x001f }
        r1 = java.lang.Integer.toString(r1);	 Catch:{ GeneralSecurityException -> 0x0021, GeneralSecurityException -> 0x0021, Throwable -> 0x001f }
        return r1;	 Catch:{ GeneralSecurityException -> 0x0021, GeneralSecurityException -> 0x0021, Throwable -> 0x001f }
    L_0x001a:
        r1 = com.google.android.gms.internal.zzbw.m5581a(r1, r2);	 Catch:{ GeneralSecurityException -> 0x0021, GeneralSecurityException -> 0x0021, Throwable -> 0x001f }
        return r1;
    L_0x001f:
        r1 = 3;
        goto L_0x0022;
    L_0x0021:
        r1 = 7;
    L_0x0022:
        r1 = java.lang.Integer.toString(r1);
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcs.a(android.content.Context, java.lang.String, boolean, android.view.View, android.app.Activity):java.lang.String");
    }

    protected abstract long mo3492a(StackTraceElement[] stackTraceElementArr) throws zzdj;

    protected abstract zzaz mo3493a(Context context, View view, Activity activity);

    public final String mo1517a(Context context) {
        if (zzdr.m5892b()) {
            if (((Boolean) zzkb.m6350f().m6488a(zznh.bA)).booleanValue()) {
                throw new IllegalStateException("The caller must not be called from the UI thread.");
            }
        }
        return m13563a(context, null, false, null, null);
    }

    public final String mo1518a(Context context, String str, View view) {
        return mo1519a(context, str, view, null);
    }

    public final String mo1519a(Context context, String str, View view, Activity activity) {
        return m13563a(context, str, true, view, activity);
    }

    public final void mo1520a(int i, int i2, int i3) {
        MotionEvent obtain;
        if (this.f14256a != null) {
            r0.f14256a.recycle();
        }
        if (r0.f14271p != null) {
            obtain = MotionEvent.obtain(0, (long) i3, 1, r0.f14271p.density * ((float) i), r0.f14271p.density * ((float) i2), 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
        } else {
            obtain = null;
        }
        r0.f14256a = obtain;
        r0.f14270o = false;
    }

    public final void mo1521a(android.view.MotionEvent r13) {
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
        r12 = this;
        r0 = r12.f14274s;
        r1 = 0;
        if (r0 == 0) goto L_0x0035;
    L_0x0005:
        r2 = 0;
        r12.f14261f = r2;
        r12.f14260e = r2;
        r12.f14259d = r2;
        r12.f14258c = r2;
        r12.f14262g = r2;
        r12.f14264i = r2;
        r12.f14263h = r2;
        r0 = r12.f14257b;
        r0 = r0.iterator();
    L_0x001b:
        r2 = r0.hasNext();
        if (r2 == 0) goto L_0x002b;
    L_0x0021:
        r2 = r0.next();
        r2 = (android.view.MotionEvent) r2;
        r2.recycle();
        goto L_0x001b;
    L_0x002b:
        r0 = r12.f14257b;
        r0.clear();
        r0 = 0;
        r12.f14256a = r0;
        r12.f14274s = r1;
    L_0x0035:
        r0 = r13.getAction();
        switch(r0) {
            case 0: goto L_0x0060;
            case 1: goto L_0x003d;
            case 2: goto L_0x003d;
            default: goto L_0x003c;
        };
    L_0x003c:
        goto L_0x0072;
    L_0x003d:
        r0 = r13.getRawX();
        r2 = (double) r0;
        r0 = r13.getRawY();
        r4 = (double) r0;
        r6 = r12.f14272q;
        r6 = r2 - r6;
        r8 = r12.f14273r;
        r8 = r4 - r8;
        r10 = r12.f14265j;
        r6 = r6 * r6;
        r8 = r8 * r8;
        r6 = r6 + r8;
        r6 = java.lang.Math.sqrt(r6);
        r10 = r10 + r6;
        r12.f14265j = r10;
        r12.f14272q = r2;
        r12.f14273r = r4;
        goto L_0x0072;
    L_0x0060:
        r2 = 0;
        r12.f14265j = r2;
        r0 = r13.getRawX();
        r2 = (double) r0;
        r12.f14272q = r2;
        r0 = r13.getRawY();
        r2 = (double) r0;
        r12.f14273r = r2;
    L_0x0072:
        r0 = r13.getAction();
        r2 = 1;
        r4 = 1;
        switch(r0) {
            case 0: goto L_0x010b;
            case 1: goto L_0x00d5;
            case 2: goto L_0x0085;
            case 3: goto L_0x007e;
            default: goto L_0x007c;
        };
    L_0x007c:
        goto L_0x013a;
    L_0x007e:
        r0 = r12.f14261f;
        r0 = r0 + r2;
        r12.f14261f = r0;
        goto L_0x013a;
    L_0x0085:
        r2 = r12.f14259d;
        r0 = r13.getHistorySize();
        r0 = r0 + r4;
        r5 = (long) r0;
        r2 = r2 + r5;
        r12.f14259d = r2;
        r13 = r12.mo3495b(r13);	 Catch:{ zzdj -> 0x013a }
        r0 = r13.f14294d;	 Catch:{ zzdj -> 0x013a }
        if (r0 == 0) goto L_0x009e;	 Catch:{ zzdj -> 0x013a }
    L_0x0098:
        r0 = r13.f14297g;	 Catch:{ zzdj -> 0x013a }
        if (r0 == 0) goto L_0x009e;	 Catch:{ zzdj -> 0x013a }
    L_0x009c:
        r0 = r4;	 Catch:{ zzdj -> 0x013a }
        goto L_0x009f;	 Catch:{ zzdj -> 0x013a }
    L_0x009e:
        r0 = r1;	 Catch:{ zzdj -> 0x013a }
    L_0x009f:
        if (r0 == 0) goto L_0x00b3;	 Catch:{ zzdj -> 0x013a }
    L_0x00a1:
        r2 = r12.f14263h;	 Catch:{ zzdj -> 0x013a }
        r0 = r13.f14294d;	 Catch:{ zzdj -> 0x013a }
        r5 = r0.longValue();	 Catch:{ zzdj -> 0x013a }
        r0 = r13.f14297g;	 Catch:{ zzdj -> 0x013a }
        r7 = r0.longValue();	 Catch:{ zzdj -> 0x013a }
        r5 = r5 + r7;	 Catch:{ zzdj -> 0x013a }
        r2 = r2 + r5;	 Catch:{ zzdj -> 0x013a }
        r12.f14263h = r2;	 Catch:{ zzdj -> 0x013a }
    L_0x00b3:
        r0 = r12.f14271p;	 Catch:{ zzdj -> 0x013a }
        if (r0 == 0) goto L_0x00c0;	 Catch:{ zzdj -> 0x013a }
    L_0x00b7:
        r0 = r13.f14295e;	 Catch:{ zzdj -> 0x013a }
        if (r0 == 0) goto L_0x00c0;	 Catch:{ zzdj -> 0x013a }
    L_0x00bb:
        r0 = r13.f14298h;	 Catch:{ zzdj -> 0x013a }
        if (r0 == 0) goto L_0x00c0;	 Catch:{ zzdj -> 0x013a }
    L_0x00bf:
        r1 = r4;	 Catch:{ zzdj -> 0x013a }
    L_0x00c0:
        if (r1 == 0) goto L_0x013a;	 Catch:{ zzdj -> 0x013a }
    L_0x00c2:
        r0 = r12.f14264i;	 Catch:{ zzdj -> 0x013a }
        r2 = r13.f14295e;	 Catch:{ zzdj -> 0x013a }
        r2 = r2.longValue();	 Catch:{ zzdj -> 0x013a }
        r13 = r13.f14298h;	 Catch:{ zzdj -> 0x013a }
        r5 = r13.longValue();	 Catch:{ zzdj -> 0x013a }
        r2 = r2 + r5;	 Catch:{ zzdj -> 0x013a }
        r0 = r0 + r2;	 Catch:{ zzdj -> 0x013a }
        r12.f14264i = r0;	 Catch:{ zzdj -> 0x013a }
        goto L_0x013a;
    L_0x00d5:
        r13 = android.view.MotionEvent.obtain(r13);
        r12.f14256a = r13;
        r13 = r12.f14257b;
        r0 = r12.f14256a;
        r13.add(r0);
        r13 = r12.f14257b;
        r13 = r13.size();
        r0 = 6;
        if (r13 <= r0) goto L_0x00f6;
    L_0x00eb:
        r13 = r12.f14257b;
        r13 = r13.remove();
        r13 = (android.view.MotionEvent) r13;
        r13.recycle();
    L_0x00f6:
        r0 = r12.f14260e;
        r0 = r0 + r2;
        r12.f14260e = r0;
        r13 = new java.lang.Throwable;	 Catch:{ zzdj -> 0x013a }
        r13.<init>();	 Catch:{ zzdj -> 0x013a }
        r13 = r13.getStackTrace();	 Catch:{ zzdj -> 0x013a }
        r0 = r12.mo3492a(r13);	 Catch:{ zzdj -> 0x013a }
        r12.f14262g = r0;	 Catch:{ zzdj -> 0x013a }
        goto L_0x013a;
    L_0x010b:
        r0 = com.google.android.gms.internal.zznh.bv;
        r1 = com.google.android.gms.internal.zzkb.m6350f();
        r0 = r1.m6488a(r0);
        r0 = (java.lang.Boolean) r0;
        r0 = r0.booleanValue();
        if (r0 == 0) goto L_0x0135;
    L_0x011d:
        r0 = r13.getX();
        r12.f14266k = r0;
        r0 = r13.getY();
        r12.f14267l = r0;
        r0 = r13.getRawX();
        r12.f14268m = r0;
        r13 = r13.getRawY();
        r12.f14269n = r13;
    L_0x0135:
        r0 = r12.f14258c;
        r0 = r0 + r2;
        r12.f14258c = r0;
    L_0x013a:
        r12.f14270o = r4;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcs.a(android.view.MotionEvent):void");
    }

    public void mo1522a(View view) {
    }

    protected abstract zzaz mo3494b(Context context);

    protected abstract zzdq mo3495b(MotionEvent motionEvent) throws zzdj;
}
