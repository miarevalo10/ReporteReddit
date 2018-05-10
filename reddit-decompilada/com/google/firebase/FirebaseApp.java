package com.google.firebase;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.util.ArrayMap;
import android.util.Log;
import com.google.android.gms.common.api.internal.zzk;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.util.zzs;
import com.google.firebase.internal.zza;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class FirebaseApp {
    static final Map<String, FirebaseApp> f8587a = new ArrayMap();
    private static final List<String> f8588b = Arrays.asList(new String[]{"com.google.firebase.auth.FirebaseAuth", "com.google.firebase.iid.FirebaseInstanceId"});
    private static final List<String> f8589c = Collections.singletonList("com.google.firebase.crash.FirebaseCrash");
    private static final List<String> f8590d = Arrays.asList(new String[]{"com.google.android.gms.measurement.AppMeasurement"});
    private static final List<String> f8591e = Arrays.asList(new String[0]);
    private static final Set<String> f8592f = Collections.emptySet();
    private static final Object f8593g = new Object();
    private final Context f8594h;
    private final String f8595i;
    private final FirebaseOptions f8596j;
    private final AtomicBoolean f8597k = new AtomicBoolean(false);
    private final AtomicBoolean f8598l = new AtomicBoolean();
    private final List<Object> f8599m = new CopyOnWriteArrayList();
    private final List<Object> f8600n = new CopyOnWriteArrayList();
    private final List<Object> f8601o = new CopyOnWriteArrayList();
    private zzb f8602p;

    public interface zzb {
    }

    @TargetApi(24)
    static class zzc extends BroadcastReceiver {
        private static AtomicReference<zzc> f8585a = new AtomicReference();
        private final Context f8586b;

        private zzc(Context context) {
            this.f8586b = context;
        }

        public final void onReceive(Context context, Intent intent) {
            synchronized (FirebaseApp.f8593g) {
                for (FirebaseApp a : FirebaseApp.f8587a.values()) {
                    FirebaseApp.m7344a(a);
                }
            }
            this.f8586b.unregisterReceiver(this);
        }

        static /* synthetic */ void m7341a(Context context) {
            if (f8585a.get() == null) {
                BroadcastReceiver com_google_firebase_FirebaseApp_zzc = new zzc(context);
                if (f8585a.compareAndSet(null, com_google_firebase_FirebaseApp_zzc)) {
                    context.registerReceiver(com_google_firebase_FirebaseApp_zzc, new IntentFilter("android.intent.action.USER_UNLOCKED"));
                }
            }
        }
    }

    private FirebaseApp(Context context, String str, FirebaseOptions firebaseOptions) {
        this.f8594h = (Context) zzbq.m4808a((Object) context);
        this.f8595i = zzbq.m4810a(str);
        this.f8596j = (FirebaseOptions) zzbq.m4808a((Object) firebaseOptions);
        this.f8602p = new zza();
    }

    private static FirebaseApp m7343a(Context context, FirebaseOptions firebaseOptions, String str) {
        Object firebaseApp;
        com.google.firebase.internal.zzb.m7434a();
        if (context.getApplicationContext() instanceof Application) {
            zzk.m4770a((Application) context.getApplicationContext());
            zzk.m4769a().m4772a(new zza());
        }
        str = str.trim();
        if (context.getApplicationContext() != null) {
            Object applicationContext = context.getApplicationContext();
        }
        synchronized (f8593g) {
            boolean containsKey = f8587a.containsKey(str) ^ 1;
            StringBuilder stringBuilder = new StringBuilder(33 + String.valueOf(str).length());
            stringBuilder.append("FirebaseApp name ");
            stringBuilder.append(str);
            stringBuilder.append(" already exists!");
            zzbq.m4814a(containsKey, stringBuilder.toString());
            zzbq.m4809a(applicationContext, (Object) "Application context cannot be null.");
            firebaseApp = new FirebaseApp(applicationContext, str, firebaseOptions);
            f8587a.put(str, firebaseApp);
        }
        com.google.firebase.internal.zzb.m7435b();
        firebaseApp.m7345a(FirebaseApp.class, firebaseApp, f8588b);
        if (firebaseApp.m7351h()) {
            firebaseApp.m7345a(FirebaseApp.class, firebaseApp, f8589c);
            firebaseApp.m7345a(Context.class, firebaseApp.m7353a(), f8590d);
        }
        return firebaseApp;
    }

    private final <T> void m7345a(java.lang.Class<T> r8, T r9, java.lang.Iterable<java.lang.String> r10) {
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
        r7 = this;
        r0 = r7.f8594h;
        r0 = android.support.v4.content.ContextCompat.m721d(r0);
        if (r0 == 0) goto L_0x000d;
    L_0x0008:
        r1 = r7.f8594h;
        com.google.firebase.FirebaseApp.zzc.m7341a(r1);
    L_0x000d:
        r10 = r10.iterator();
    L_0x0011:
        r1 = r10.hasNext();
        if (r1 == 0) goto L_0x00b2;
    L_0x0017:
        r1 = r10.next();
        r1 = (java.lang.String) r1;
        if (r0 == 0) goto L_0x002c;
    L_0x001f:
        r2 = f8591e;	 Catch:{ ClassNotFoundException -> 0x0089, NoSuchMethodException -> 0x0079, InvocationTargetException -> 0x002a, IllegalAccessException -> 0x0028 }
        r2 = r2.contains(r1);	 Catch:{ ClassNotFoundException -> 0x0089, NoSuchMethodException -> 0x0079, InvocationTargetException -> 0x002a, IllegalAccessException -> 0x0028 }
        if (r2 == 0) goto L_0x0011;	 Catch:{ ClassNotFoundException -> 0x0089, NoSuchMethodException -> 0x0079, InvocationTargetException -> 0x002a, IllegalAccessException -> 0x0028 }
    L_0x0027:
        goto L_0x002c;	 Catch:{ ClassNotFoundException -> 0x0089, NoSuchMethodException -> 0x0079, InvocationTargetException -> 0x002a, IllegalAccessException -> 0x0028 }
    L_0x0028:
        r2 = move-exception;	 Catch:{ ClassNotFoundException -> 0x0089, NoSuchMethodException -> 0x0079, InvocationTargetException -> 0x002a, IllegalAccessException -> 0x0028 }
        goto L_0x0055;	 Catch:{ ClassNotFoundException -> 0x0089, NoSuchMethodException -> 0x0079, InvocationTargetException -> 0x002a, IllegalAccessException -> 0x0028 }
    L_0x002a:
        r1 = move-exception;	 Catch:{ ClassNotFoundException -> 0x0089, NoSuchMethodException -> 0x0079, InvocationTargetException -> 0x002a, IllegalAccessException -> 0x0028 }
        goto L_0x0071;	 Catch:{ ClassNotFoundException -> 0x0089, NoSuchMethodException -> 0x0079, InvocationTargetException -> 0x002a, IllegalAccessException -> 0x0028 }
    L_0x002c:
        r2 = java.lang.Class.forName(r1);	 Catch:{ ClassNotFoundException -> 0x0089, NoSuchMethodException -> 0x0079, InvocationTargetException -> 0x002a, IllegalAccessException -> 0x0028 }
        r3 = "getInstance";	 Catch:{ ClassNotFoundException -> 0x0089, NoSuchMethodException -> 0x0079, InvocationTargetException -> 0x002a, IllegalAccessException -> 0x0028 }
        r4 = 1;	 Catch:{ ClassNotFoundException -> 0x0089, NoSuchMethodException -> 0x0079, InvocationTargetException -> 0x002a, IllegalAccessException -> 0x0028 }
        r5 = new java.lang.Class[r4];	 Catch:{ ClassNotFoundException -> 0x0089, NoSuchMethodException -> 0x0079, InvocationTargetException -> 0x002a, IllegalAccessException -> 0x0028 }
        r6 = 0;	 Catch:{ ClassNotFoundException -> 0x0089, NoSuchMethodException -> 0x0079, InvocationTargetException -> 0x002a, IllegalAccessException -> 0x0028 }
        r5[r6] = r8;	 Catch:{ ClassNotFoundException -> 0x0089, NoSuchMethodException -> 0x0079, InvocationTargetException -> 0x002a, IllegalAccessException -> 0x0028 }
        r2 = r2.getMethod(r3, r5);	 Catch:{ ClassNotFoundException -> 0x0089, NoSuchMethodException -> 0x0079, InvocationTargetException -> 0x002a, IllegalAccessException -> 0x0028 }
        r3 = r2.getModifiers();	 Catch:{ ClassNotFoundException -> 0x0089, NoSuchMethodException -> 0x0079, InvocationTargetException -> 0x002a, IllegalAccessException -> 0x0028 }
        r5 = java.lang.reflect.Modifier.isPublic(r3);	 Catch:{ ClassNotFoundException -> 0x0089, NoSuchMethodException -> 0x0079, InvocationTargetException -> 0x002a, IllegalAccessException -> 0x0028 }
        if (r5 == 0) goto L_0x0011;	 Catch:{ ClassNotFoundException -> 0x0089, NoSuchMethodException -> 0x0079, InvocationTargetException -> 0x002a, IllegalAccessException -> 0x0028 }
    L_0x0046:
        r3 = java.lang.reflect.Modifier.isStatic(r3);	 Catch:{ ClassNotFoundException -> 0x0089, NoSuchMethodException -> 0x0079, InvocationTargetException -> 0x002a, IllegalAccessException -> 0x0028 }
        if (r3 == 0) goto L_0x0011;	 Catch:{ ClassNotFoundException -> 0x0089, NoSuchMethodException -> 0x0079, InvocationTargetException -> 0x002a, IllegalAccessException -> 0x0028 }
    L_0x004c:
        r3 = 0;	 Catch:{ ClassNotFoundException -> 0x0089, NoSuchMethodException -> 0x0079, InvocationTargetException -> 0x002a, IllegalAccessException -> 0x0028 }
        r4 = new java.lang.Object[r4];	 Catch:{ ClassNotFoundException -> 0x0089, NoSuchMethodException -> 0x0079, InvocationTargetException -> 0x002a, IllegalAccessException -> 0x0028 }
        r4[r6] = r9;	 Catch:{ ClassNotFoundException -> 0x0089, NoSuchMethodException -> 0x0079, InvocationTargetException -> 0x002a, IllegalAccessException -> 0x0028 }
        r2.invoke(r3, r4);	 Catch:{ ClassNotFoundException -> 0x0089, NoSuchMethodException -> 0x0079, InvocationTargetException -> 0x002a, IllegalAccessException -> 0x0028 }
        goto L_0x0011;
    L_0x0055:
        r3 = "FirebaseApp";
        r4 = "Failed to initialize ";
        r1 = java.lang.String.valueOf(r1);
        r5 = r1.length();
        if (r5 == 0) goto L_0x0068;
    L_0x0063:
        r1 = r4.concat(r1);
        goto L_0x006d;
    L_0x0068:
        r1 = new java.lang.String;
        r1.<init>(r4);
    L_0x006d:
        android.util.Log.wtf(r3, r1, r2);
        goto L_0x0011;
    L_0x0071:
        r2 = "FirebaseApp";
        r3 = "Firebase API initialization failure.";
        android.util.Log.wtf(r2, r3, r1);
        goto L_0x0011;
    L_0x0079:
        r8 = new java.lang.IllegalStateException;
        r9 = java.lang.String.valueOf(r1);
        r10 = "#getInstance has been removed by Proguard. Add keep rule to prevent it.";
        r9 = r9.concat(r10);
        r8.<init>(r9);
        throw r8;
    L_0x0089:
        r2 = f8592f;
        r2 = r2.contains(r1);
        if (r2 == 0) goto L_0x00a1;
    L_0x0091:
        r8 = new java.lang.IllegalStateException;
        r9 = java.lang.String.valueOf(r1);
        r10 = " is missing, but is required. Check if it has been removed by Proguard.";
        r9 = r9.concat(r10);
        r8.<init>(r9);
        throw r8;
    L_0x00a1:
        r2 = "FirebaseApp";
        r1 = java.lang.String.valueOf(r1);
        r3 = " is not linked. Skipping initialization.";
        r1 = r1.concat(r3);
        android.util.Log.d(r2, r1);
        goto L_0x0011;
    L_0x00b2:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.FirebaseApp.a(java.lang.Class, java.lang.Object, java.lang.Iterable):void");
    }

    public static FirebaseApp m7346c() {
        FirebaseApp firebaseApp;
        synchronized (f8593g) {
            firebaseApp = (FirebaseApp) f8587a.get("[DEFAULT]");
            if (firebaseApp == null) {
                String a = zzs.m4919a();
                StringBuilder stringBuilder = new StringBuilder(116 + String.valueOf(a).length());
                stringBuilder.append("Default FirebaseApp is not initialized in this process ");
                stringBuilder.append(a);
                stringBuilder.append(". Make sure to call FirebaseApp.initializeApp(Context) first.");
                throw new IllegalStateException(stringBuilder.toString());
            }
        }
        return firebaseApp;
    }

    public static void m7347d() {
        synchronized (f8593g) {
            ArrayList arrayList = new ArrayList(f8587a.values());
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                FirebaseApp firebaseApp = (FirebaseApp) obj;
                if (firebaseApp.f8597k.get()) {
                    firebaseApp.m7352i();
                }
            }
        }
    }

    private String m7349f() {
        m7350g();
        return this.f8595i;
    }

    private final void m7350g() {
        zzbq.m4814a(this.f8598l.get() ^ 1, (Object) "FirebaseApp was deleted");
    }

    private boolean m7351h() {
        return "[DEFAULT]".equals(m7349f());
    }

    private final void m7352i() {
        Log.d("FirebaseApp", "Notifying background state change listeners.");
        Iterator it = this.f8600n.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    public final Context m7353a() {
        m7350g();
        return this.f8594h;
    }

    public final FirebaseOptions m7354b() {
        m7350g();
        return this.f8596j;
    }

    public boolean equals(Object obj) {
        return !(obj instanceof FirebaseApp) ? false : this.f8595i.equals(((FirebaseApp) obj).m7349f());
    }

    public int hashCode() {
        return this.f8595i.hashCode();
    }

    public String toString() {
        return zzbg.m4805a(this).m4807a("name", this.f8595i).m4807a("options", this.f8596j).toString();
    }

    public static FirebaseApp m7342a(Context context) {
        synchronized (f8593g) {
            if (f8587a.containsKey("[DEFAULT]")) {
                context = m7346c();
                return context;
            }
            FirebaseOptions a = FirebaseOptions.m7355a(context);
            if (a == null) {
                return null;
            }
            context = m7343a(context, a, "[DEFAULT]");
            return context;
        }
    }

    static /* synthetic */ void m7344a(FirebaseApp firebaseApp) {
        firebaseApp.m7345a(FirebaseApp.class, (Object) firebaseApp, f8588b);
        if (firebaseApp.m7351h()) {
            firebaseApp.m7345a(FirebaseApp.class, (Object) firebaseApp, f8589c);
            firebaseApp.m7345a(Context.class, firebaseApp.f8594h, f8590d);
        }
    }
}
