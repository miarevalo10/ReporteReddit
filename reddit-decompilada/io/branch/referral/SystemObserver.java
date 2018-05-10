package io.branch.referral;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Process;
import android.provider.Settings.Secure;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

class SystemObserver {
    String f24671a = null;
    int f24672b = 0;
    Context f24673c;
    boolean f24674d;

    interface GAdsParamsFetchEvents {
        void mo5543c();
    }

    private class GAdsPrefetchTask extends BranchAsyncTask<Void, Void, Void> {
        final /* synthetic */ SystemObserver f30971a;
        private final GAdsParamsFetchEvents f30972b;

        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return m31930a();
        }

        protected /* synthetic */ void onPostExecute(Object obj) {
            super.onPostExecute((Void) obj);
            if (this.f30972b != null) {
                this.f30972b.mo5543c();
            }
        }

        public GAdsPrefetchTask(SystemObserver systemObserver, GAdsParamsFetchEvents gAdsParamsFetchEvents) {
            this.f30971a = systemObserver;
            this.f30972b = gAdsParamsFetchEvents;
        }

        private Void m31930a() {
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            new Thread(new Runnable(this) {
                final /* synthetic */ GAdsPrefetchTask f24670b;

                public void run() {
                    Process.setThreadPriority(-19);
                    Object a = this.f24670b.f30971a.m26213k();
                    this.f24670b.f30971a.m26203a(a);
                    this.f24670b.f30971a.m26205b(a);
                    countDownLatch.countDown();
                }
            }).start();
            try {
                countDownLatch.await(1500, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    static String m26210g() {
        return "Android";
    }

    SystemObserver(Context context) {
        this.f24673c = context;
        this.f24674d = true;
    }

    final String m26216a(boolean z) {
        if (this.f24673c == null) {
            return "bnc_no_value";
        }
        String str = null;
        if (!z) {
            str = Secure.getString(this.f24673c.getContentResolver(), "android_id");
        }
        if (str == null) {
            str = UUID.randomUUID().toString();
            this.f24674d = false;
        }
        return str;
    }

    final String m26214a() {
        String str = "";
        try {
            return this.f24673c.getPackageManager().getPackageInfo(this.f24673c.getPackageName(), 0).packageName;
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            return str;
        }
    }

    final java.lang.String m26217b() {
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
        r0 = r3.f24673c;	 Catch:{ NameNotFoundException -> 0x001b }
        r0 = r0.getPackageManager();	 Catch:{ NameNotFoundException -> 0x001b }
        r1 = r3.f24673c;	 Catch:{ NameNotFoundException -> 0x001b }
        r1 = r1.getPackageName();	 Catch:{ NameNotFoundException -> 0x001b }
        r2 = 0;	 Catch:{ NameNotFoundException -> 0x001b }
        r0 = r0.getPackageInfo(r1, r2);	 Catch:{ NameNotFoundException -> 0x001b }
        r1 = r0.versionName;	 Catch:{ NameNotFoundException -> 0x001b }
        if (r1 == 0) goto L_0x0018;	 Catch:{ NameNotFoundException -> 0x001b }
    L_0x0015:
        r0 = r0.versionName;	 Catch:{ NameNotFoundException -> 0x001b }
        return r0;
    L_0x0018:
        r0 = "bnc_no_value";
        return r0;
    L_0x001b:
        r0 = "bnc_no_value";
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.SystemObserver.b():java.lang.String");
    }

    static String m26206c() {
        return Build.MANUFACTURER;
    }

    static String m26207d() {
        return Build.MODEL;
    }

    static String m26208e() {
        return Locale.getDefault() != null ? Locale.getDefault().getCountry() : "";
    }

    static String m26209f() {
        return Locale.getDefault() != null ? Locale.getDefault().getLanguage() : "";
    }

    static int m26211h() {
        return VERSION.SDK_INT;
    }

    @android.annotation.SuppressLint({"NewApi"})
    final int m26218i() {
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
        r6 = this;
        r0 = r6.f24673c;
        io.branch.referral.PrefHelper.m26151a(r0);
        r0 = r6.m26217b();
        r1 = "bnc_no_value";
        r2 = "bnc_app_version";
        r2 = io.branch.referral.PrefHelper.m26170d(r2);
        r1 = r1.equals(r2);
        r2 = 2;
        if (r1 == 0) goto L_0x003a;
    L_0x0018:
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 9;
        r3 = 0;
        if (r0 < r1) goto L_0x0039;
    L_0x001f:
        r0 = r6.f24673c;	 Catch:{ NameNotFoundException -> 0x0039 }
        r0 = r0.getPackageManager();	 Catch:{ NameNotFoundException -> 0x0039 }
        r1 = r6.f24673c;	 Catch:{ NameNotFoundException -> 0x0039 }
        r1 = r1.getPackageName();	 Catch:{ NameNotFoundException -> 0x0039 }
        r0 = r0.getPackageInfo(r1, r3);	 Catch:{ NameNotFoundException -> 0x0039 }
        r4 = r0.lastUpdateTime;	 Catch:{ NameNotFoundException -> 0x0039 }
        r0 = r0.firstInstallTime;	 Catch:{ NameNotFoundException -> 0x0039 }
        r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1));
        if (r0 == 0) goto L_0x0038;
    L_0x0037:
        return r2;
    L_0x0038:
        return r3;
    L_0x0039:
        return r3;
    L_0x003a:
        r1 = "bnc_app_version";
        r1 = io.branch.referral.PrefHelper.m26170d(r1);
        r0 = r1.equals(r0);
        if (r0 != 0) goto L_0x0047;
    L_0x0046:
        return r2;
    L_0x0047:
        r0 = 1;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.SystemObserver.i():int");
    }

    private java.lang.Object m26213k() {
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
        r7 = this;
        r0 = 0;
        r1 = "com.google.android.gms.ads.identifier.AdvertisingIdClient";	 Catch:{ Throwable -> 0x0020 }
        r1 = java.lang.Class.forName(r1);	 Catch:{ Throwable -> 0x0020 }
        r2 = "getAdvertisingIdInfo";	 Catch:{ Throwable -> 0x0020 }
        r3 = 1;	 Catch:{ Throwable -> 0x0020 }
        r4 = new java.lang.Class[r3];	 Catch:{ Throwable -> 0x0020 }
        r5 = android.content.Context.class;	 Catch:{ Throwable -> 0x0020 }
        r6 = 0;	 Catch:{ Throwable -> 0x0020 }
        r4[r6] = r5;	 Catch:{ Throwable -> 0x0020 }
        r1 = r1.getMethod(r2, r4);	 Catch:{ Throwable -> 0x0020 }
        r2 = new java.lang.Object[r3];	 Catch:{ Throwable -> 0x0020 }
        r3 = r7.f24673c;	 Catch:{ Throwable -> 0x0020 }
        r2[r6] = r3;	 Catch:{ Throwable -> 0x0020 }
        r1 = r1.invoke(r0, r2);	 Catch:{ Throwable -> 0x0020 }
        r0 = r1;
    L_0x0020:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.SystemObserver.k():java.lang.Object");
    }

    private java.lang.String m26203a(java.lang.Object r5) {
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
        r0 = r5.getClass();	 Catch:{ Exception -> 0x0017 }
        r1 = "getId";	 Catch:{ Exception -> 0x0017 }
        r2 = 0;	 Catch:{ Exception -> 0x0017 }
        r3 = new java.lang.Class[r2];	 Catch:{ Exception -> 0x0017 }
        r0 = r0.getMethod(r1, r3);	 Catch:{ Exception -> 0x0017 }
        r1 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x0017 }
        r5 = r0.invoke(r5, r1);	 Catch:{ Exception -> 0x0017 }
        r5 = (java.lang.String) r5;	 Catch:{ Exception -> 0x0017 }
        r4.f24671a = r5;	 Catch:{ Exception -> 0x0017 }
    L_0x0017:
        r5 = r4.f24671a;
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.SystemObserver.a(java.lang.Object):java.lang.String");
    }

    private int m26205b(java.lang.Object r5) {
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
        r0 = r5.getClass();	 Catch:{ Exception -> 0x001b }
        r1 = "isLimitAdTrackingEnabled";	 Catch:{ Exception -> 0x001b }
        r2 = 0;	 Catch:{ Exception -> 0x001b }
        r3 = new java.lang.Class[r2];	 Catch:{ Exception -> 0x001b }
        r0 = r0.getMethod(r1, r3);	 Catch:{ Exception -> 0x001b }
        r1 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x001b }
        r5 = r0.invoke(r5, r1);	 Catch:{ Exception -> 0x001b }
        r5 = (java.lang.Boolean) r5;	 Catch:{ Exception -> 0x001b }
        r5 = r5.booleanValue();	 Catch:{ Exception -> 0x001b }
        r4.f24672b = r5;	 Catch:{ Exception -> 0x001b }
    L_0x001b:
        r5 = r4.f24672b;
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.SystemObserver.b(java.lang.Object):int");
    }

    static java.lang.String m26212j() {
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
        r0 = "";
        r1 = java.net.NetworkInterface.getNetworkInterfaces();	 Catch:{ Throwable -> 0x004b }
        r1 = java.util.Collections.list(r1);	 Catch:{ Throwable -> 0x004b }
        r1 = r1.iterator();	 Catch:{ Throwable -> 0x004b }
    L_0x000e:
        r2 = r1.hasNext();	 Catch:{ Throwable -> 0x004b }
        if (r2 == 0) goto L_0x004b;	 Catch:{ Throwable -> 0x004b }
    L_0x0014:
        r2 = r1.next();	 Catch:{ Throwable -> 0x004b }
        r2 = (java.net.NetworkInterface) r2;	 Catch:{ Throwable -> 0x004b }
        r2 = r2.getInetAddresses();	 Catch:{ Throwable -> 0x004b }
        r2 = java.util.Collections.list(r2);	 Catch:{ Throwable -> 0x004b }
        r2 = r2.iterator();	 Catch:{ Throwable -> 0x004b }
    L_0x0026:
        r3 = r2.hasNext();	 Catch:{ Throwable -> 0x004b }
        if (r3 == 0) goto L_0x000e;	 Catch:{ Throwable -> 0x004b }
    L_0x002c:
        r3 = r2.next();	 Catch:{ Throwable -> 0x004b }
        r3 = (java.net.InetAddress) r3;	 Catch:{ Throwable -> 0x004b }
        r4 = r3.isLoopbackAddress();	 Catch:{ Throwable -> 0x004b }
        if (r4 != 0) goto L_0x0026;	 Catch:{ Throwable -> 0x004b }
    L_0x0038:
        r3 = r3.getHostAddress();	 Catch:{ Throwable -> 0x004b }
        r4 = 58;	 Catch:{ Throwable -> 0x004b }
        r4 = r3.indexOf(r4);	 Catch:{ Throwable -> 0x004b }
        if (r4 >= 0) goto L_0x0046;
    L_0x0044:
        r4 = 1;
        goto L_0x0047;
    L_0x0046:
        r4 = 0;
    L_0x0047:
        if (r4 == 0) goto L_0x0026;
    L_0x0049:
        r0 = r3;
        goto L_0x000e;
    L_0x004b:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.SystemObserver.j():java.lang.String");
    }

    final java.lang.String m26215a(java.lang.String r6) {
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
        r5 = this;
        r0 = "bnc_no_value";
        r1 = r5.f24673c;
        r2 = "activity";
        r1 = r1.getSystemService(r2);
        r1 = (android.app.ActivityManager) r1;
        r2 = new android.app.ActivityManager$MemoryInfo;
        r2.<init>();
        r1.getMemoryInfo(r2);
        r1 = r2.lowMemory;
        if (r1 != 0) goto L_0x0074;
    L_0x0018:
        r1 = r5.f24673c;
        r1 = r1.getPackageManager();
        r2 = 0;
        r6 = r1.getApplicationInfo(r6, r2);	 Catch:{  }
        r6 = r6.publicSourceDir;	 Catch:{  }
        r1 = 0;
        r2 = new java.util.jar.JarFile;	 Catch:{ Exception -> 0x0069, all -> 0x005a }
        r2.<init>(r6);	 Catch:{ Exception -> 0x0069, all -> 0x005a }
        r6 = "AndroidManifest.xml";	 Catch:{ Exception -> 0x006a, all -> 0x0055 }
        r6 = r2.getEntry(r6);	 Catch:{ Exception -> 0x006a, all -> 0x0055 }
        r6 = r2.getInputStream(r6);	 Catch:{ Exception -> 0x006a, all -> 0x0055 }
        r1 = r6.available();	 Catch:{ Exception -> 0x0053, all -> 0x0051 }
        r1 = new byte[r1];	 Catch:{ Exception -> 0x0053, all -> 0x0051 }
        r6.read(r1);	 Catch:{ Exception -> 0x0053, all -> 0x0051 }
        r3 = new io.branch.referral.ApkParser;	 Catch:{ Exception -> 0x0053, all -> 0x0051 }
        r3.<init>();	 Catch:{ Exception -> 0x0053, all -> 0x0051 }
        r1 = io.branch.referral.ApkParser.m26093a(r1);	 Catch:{ Exception -> 0x0053, all -> 0x0051 }
        if (r6 == 0) goto L_0x004c;
    L_0x0049:
        r6.close();	 Catch:{ IOException -> 0x004f, IOException -> 0x004f }
    L_0x004c:
        r2.close();	 Catch:{ IOException -> 0x004f, IOException -> 0x004f }
    L_0x004f:
        r0 = r1;
        goto L_0x0074;
    L_0x0051:
        r1 = move-exception;
        goto L_0x005e;
    L_0x0053:
        r1 = r6;
        goto L_0x006a;
    L_0x0055:
        r6 = move-exception;
        r4 = r1;
        r1 = r6;
        r6 = r4;
        goto L_0x005e;
    L_0x005a:
        r6 = move-exception;
        r2 = r1;
        r1 = r6;
        r6 = r2;
    L_0x005e:
        if (r6 == 0) goto L_0x0063;
    L_0x0060:
        r6.close();	 Catch:{ IOException -> 0x0068 }
    L_0x0063:
        if (r2 == 0) goto L_0x0068;	 Catch:{ IOException -> 0x0068 }
    L_0x0065:
        r2.close();	 Catch:{ IOException -> 0x0068 }
    L_0x0068:
        throw r1;	 Catch:{  }
    L_0x0069:
        r2 = r1;
    L_0x006a:
        if (r1 == 0) goto L_0x006f;
    L_0x006c:
        r1.close();	 Catch:{ NameNotFoundException -> 0x0074 }
    L_0x006f:
        if (r2 == 0) goto L_0x0074;	 Catch:{ NameNotFoundException -> 0x0074 }
    L_0x0071:
        r2.close();	 Catch:{ NameNotFoundException -> 0x0074 }
    L_0x0074:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.SystemObserver.a(java.lang.String):java.lang.String");
    }
}
