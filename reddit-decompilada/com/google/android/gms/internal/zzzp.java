package com.google.android.gms.internal;

import android.content.Context;
import android.os.Looper;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@zzzv
public final class zzzp implements zzzt {
    private static final Object f14794a = new Object();
    private static zzzt f14795b;
    private final Object f14796c = new Object();
    private final Context f14797d;
    private final WeakHashMap<Thread, Boolean> f14798e = new WeakHashMap();
    private final ExecutorService f14799f = Executors.newCachedThreadPool();
    private final zzakd f14800g;

    private zzzp(Context context) {
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        this.f14797d = context;
        this.f14800g = zzakd.m17801a();
        Thread thread = Looper.getMainLooper().getThread();
        if (thread != null) {
            synchronized (this.f14796c) {
                this.f14798e.put(thread, Boolean.valueOf(true));
            }
            thread.setUncaughtExceptionHandler(new zzzr(this, thread.getUncaughtExceptionHandler()));
        }
        Thread.setDefaultUncaughtExceptionHandler(new zzzq(this, Thread.getDefaultUncaughtExceptionHandler()));
    }

    private final android.net.Uri.Builder m14484a(java.lang.String r9, java.lang.String r10, java.lang.String r11) {
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
        r8 = this;
        r0 = r8.f14797d;	 Catch:{ Throwable -> 0x000b }
        r0 = com.google.android.gms.internal.zzbhf.m5574a(r0);	 Catch:{ Throwable -> 0x000b }
        r0 = r0.m5570a();	 Catch:{ Throwable -> 0x000b }
        goto L_0x0012;
    L_0x000b:
        r0 = move-exception;
        r1 = "Error fetching instant app info";
        com.google.android.gms.internal.zzakb.m5367b(r1, r0);
        r0 = 0;
    L_0x0012:
        r1 = "unknown";
        r2 = r8.f14797d;	 Catch:{ Throwable -> 0x001c }
        r2 = r2.getPackageName();	 Catch:{ Throwable -> 0x001c }
        r1 = r2;
        goto L_0x0021;
    L_0x001c:
        r2 = "Cannot obtain package name, proceeding.";
        com.google.android.gms.internal.zzakb.m5371e(r2);
    L_0x0021:
        r2 = new android.net.Uri$Builder;
        r2.<init>();
        r3 = "https";
        r2 = r2.scheme(r3);
        r3 = "//pagead2.googlesyndication.com/pagead/gen_204";
        r2 = r2.path(r3);
        r3 = "is_aia";
        r0 = java.lang.Boolean.toString(r0);
        r0 = r2.appendQueryParameter(r3, r0);
        r2 = "id";
        r3 = "gmob-apps-report-exception";
        r0 = r0.appendQueryParameter(r2, r3);
        r2 = "os";
        r3 = android.os.Build.VERSION.RELEASE;
        r0 = r0.appendQueryParameter(r2, r3);
        r2 = "api";
        r3 = android.os.Build.VERSION.SDK_INT;
        r3 = java.lang.String.valueOf(r3);
        r0 = r0.appendQueryParameter(r2, r3);
        r2 = "device";
        r3 = android.os.Build.MANUFACTURER;
        r4 = android.os.Build.MODEL;
        r5 = r4.startsWith(r3);
        r6 = 1;
        if (r5 == 0) goto L_0x0066;
    L_0x0065:
        goto L_0x008c;
    L_0x0066:
        r5 = java.lang.String.valueOf(r3);
        r5 = r5.length();
        r5 = r5 + r6;
        r7 = java.lang.String.valueOf(r4);
        r7 = r7.length();
        r5 = r5 + r7;
        r7 = new java.lang.StringBuilder;
        r7.<init>(r5);
        r7.append(r3);
        r3 = " ";
        r7.append(r3);
        r7.append(r4);
        r4 = r7.toString();
    L_0x008c:
        r0 = r0.appendQueryParameter(r2, r4);
        r2 = "js";
        r3 = r8.f14800g;
        r3 = r3.f17551a;
        r0 = r0.appendQueryParameter(r2, r3);
        r2 = "appid";
        r0 = r0.appendQueryParameter(r2, r1);
        r1 = "exceptiontype";
        r9 = r0.appendQueryParameter(r1, r9);
        r0 = "stacktrace";
        r9 = r9.appendQueryParameter(r0, r10);
        r10 = "eids";
        r0 = ",";
        r1 = com.google.android.gms.internal.zznh.m6489a();
        r0 = android.text.TextUtils.join(r0, r1);
        r9 = r9.appendQueryParameter(r10, r0);
        r10 = "exceptionkey";
        r9 = r9.appendQueryParameter(r10, r11);
        r10 = "cl";
        r11 = "179146524";
        r9 = r9.appendQueryParameter(r10, r11);
        r10 = "rc";
        r11 = "dev";
        r9 = r9.appendQueryParameter(r10, r11);
        r10 = "session_id";
        r11 = com.google.android.gms.internal.zzkb.m6347c();
        r9 = r9.appendQueryParameter(r10, r11);
        r10 = "sampling_rate";
        r11 = java.lang.Integer.toString(r6);
        r9 = r9.appendQueryParameter(r10, r11);
        r10 = "pb_tm";
        r11 = com.google.android.gms.internal.zznh.cN;
        r0 = com.google.android.gms.internal.zzkb.m6350f();
        r11 = r0.m6488a(r11);
        r11 = java.lang.String.valueOf(r11);
        r9 = r9.appendQueryParameter(r10, r11);
        return r9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzzp.a(java.lang.String, java.lang.String, java.lang.String):android.net.Uri$Builder");
    }

    public static zzzt m14485a(Context context) {
        synchronized (f14794a) {
            if (f14795b == null) {
                if (((Boolean) zzkb.m6350f().m6488a(zznh.f7892b)).booleanValue()) {
                    f14795b = new zzzp(context);
                } else {
                    f14795b = new zzzu();
                }
            }
        }
        return f14795b;
    }

    private final void m14486a(List<String> list) {
        for (String str : list) {
            this.f14799f.submit(new zzzs(new zzakc(), str));
        }
    }

    protected final void m14487a(Throwable th) {
        Object obj;
        String str;
        String name;
        String stringWriter;
        Object obj2 = 1;
        if (th != null) {
            Throwable th2 = th;
            Object obj3 = null;
            Object obj4 = obj3;
            while (th2 != null) {
                Object obj5 = obj4;
                obj4 = obj3;
                for (StackTraceElement stackTraceElement : th2.getStackTrace()) {
                    if (zzajr.m5333b(stackTraceElement.getClassName())) {
                        obj4 = 1;
                    }
                    if (getClass().getName().equals(stackTraceElement.getClassName())) {
                        obj5 = 1;
                    }
                }
                th2 = th2.getCause();
                obj3 = obj4;
                obj4 = obj5;
            }
            if (obj3 != null && obj4 == null) {
                obj = 1;
                if (obj != null) {
                    str = "";
                    if (zzajr.m5323a(th) != null) {
                        name = th.getClass().getName();
                        Writer stringWriter2 = new StringWriter();
                        zzdvl.m5926a(th, new PrintWriter(stringWriter2));
                        stringWriter = stringWriter2.toString();
                        if (Math.random() < 1.0d) {
                            obj2 = null;
                        }
                        if (obj2 != null) {
                            List arrayList = new ArrayList();
                            arrayList.add(m14484a(name, stringWriter, str).toString());
                            m14486a(arrayList);
                        }
                    }
                }
            }
        }
        obj = null;
        if (obj != null) {
            str = "";
            if (zzajr.m5323a(th) != null) {
                name = th.getClass().getName();
                Writer stringWriter22 = new StringWriter();
                zzdvl.m5926a(th, new PrintWriter(stringWriter22));
                stringWriter = stringWriter22.toString();
                if (Math.random() < 1.0d) {
                    obj2 = null;
                }
                if (obj2 != null) {
                    List arrayList2 = new ArrayList();
                    arrayList2.add(m14484a(name, stringWriter, str).toString());
                    m14486a(arrayList2);
                }
            }
        }
    }

    public final void mo2296a(Throwable th, String str) {
        if (zzajr.m5323a(th) != null) {
            String name = th.getClass().getName();
            Writer stringWriter = new StringWriter();
            zzdvl.m5926a(th, new PrintWriter(stringWriter));
            String stringWriter2 = stringWriter.toString();
            if ((Math.random() < 1.0d ? 1 : null) != null) {
                List arrayList = new ArrayList();
                arrayList.add(m14484a(name, stringWriter2, str).toString());
                m14486a(arrayList);
            }
        }
    }
}
