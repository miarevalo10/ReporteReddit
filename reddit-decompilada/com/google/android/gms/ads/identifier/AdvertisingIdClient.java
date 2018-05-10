package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzfo;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

public class AdvertisingIdClient {
    private final Context mContext;
    private com.google.android.gms.common.zza zzamu;
    private zzfo zzamv;
    private boolean zzamw;
    private Object zzamx;
    private zza zzamy;
    private boolean zzamz;
    private long zzana;

    public static final class Info {
        private final String zzang;
        private final boolean zzanh;

        public Info(String str, boolean z) {
            this.zzang = str;
            this.zzanh = z;
        }

        public final String getId() {
            return this.zzang;
        }

        public final boolean isLimitAdTrackingEnabled() {
            return this.zzanh;
        }

        public final String toString() {
            String str = this.zzang;
            boolean z = this.zzanh;
            StringBuilder stringBuilder = new StringBuilder(7 + String.valueOf(str).length());
            stringBuilder.append("{");
            stringBuilder.append(str);
            stringBuilder.append("}");
            stringBuilder.append(z);
            return stringBuilder.toString();
        }
    }

    static class zza extends Thread {
        private WeakReference<AdvertisingIdClient> zzanc;
        private long zzand;
        CountDownLatch zzane = new CountDownLatch(1);
        boolean zzanf = false;

        public zza(AdvertisingIdClient advertisingIdClient, long j) {
            this.zzanc = new WeakReference(advertisingIdClient);
            this.zzand = j;
            start();
        }

        private final void disconnect() {
            AdvertisingIdClient advertisingIdClient = (AdvertisingIdClient) this.zzanc.get();
            if (advertisingIdClient != null) {
                advertisingIdClient.finish();
                this.zzanf = true;
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
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r4 = this;
            r0 = r4.zzane;	 Catch:{ InterruptedException -> 0x0010 }
            r1 = r4.zzand;	 Catch:{ InterruptedException -> 0x0010 }
            r3 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ InterruptedException -> 0x0010 }
            r0 = r0.await(r1, r3);	 Catch:{ InterruptedException -> 0x0010 }
            if (r0 != 0) goto L_0x000f;	 Catch:{ InterruptedException -> 0x0010 }
        L_0x000c:
            r4.disconnect();	 Catch:{ InterruptedException -> 0x0010 }
        L_0x000f:
            return;
        L_0x0010:
            r4.disconnect();
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.identifier.AdvertisingIdClient.zza.run():void");
        }
    }

    public AdvertisingIdClient(Context context) {
        this(context, 30000, false, false);
    }

    public AdvertisingIdClient(Context context, long j, boolean z, boolean z2) {
        this.zzamx = new Object();
        zzbq.m4808a((Object) context);
        if (z) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                context = applicationContext;
            }
        }
        this.mContext = context;
        this.zzamw = false;
        this.zzana = j;
        this.zzamz = z2;
    }

    public static Info getAdvertisingIdInfo(Context context) throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        zzb com_google_android_gms_ads_identifier_zzb = new zzb(context);
        boolean z = com_google_android_gms_ads_identifier_zzb.getBoolean("gads:ad_id_app_context:enabled", false);
        float f = com_google_android_gms_ads_identifier_zzb.getFloat("gads:ad_id_app_context:ping_ratio", 0.0f);
        String string = com_google_android_gms_ads_identifier_zzb.getString("gads:ad_id_use_shared_preference:experiment_id", "");
        AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(context, -1, z, com_google_android_gms_ads_identifier_zzb.getBoolean("gads:ad_id_use_persistent_service:enabled", false));
        try {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            advertisingIdClient.start(false);
            Info info = advertisingIdClient.getInfo();
            advertisingIdClient.zza(info, z, f, SystemClock.elapsedRealtime() - elapsedRealtime, string, null);
            advertisingIdClient.finish();
            return info;
        } catch (Throwable th) {
            advertisingIdClient.finish();
        }
    }

    public static boolean getIsAdIdFakeForDebugLogging(Context context) throws IOException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        zzb com_google_android_gms_ads_identifier_zzb = new zzb(context);
        AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(context, -1, com_google_android_gms_ads_identifier_zzb.getBoolean("gads:ad_id_app_context:enabled", false), com_google_android_gms_ads_identifier_zzb.getBoolean("com.google.android.gms.ads.identifier.service.PERSISTENT_START", false));
        try {
            advertisingIdClient.start(false);
            boolean isAdIdFakeForDebugLogging = advertisingIdClient.getIsAdIdFakeForDebugLogging();
            return isAdIdFakeForDebugLogging;
        } finally {
            advertisingIdClient.finish();
        }
    }

    public static void setShouldSkipGmsCoreVersionCheck(boolean z) {
    }

    private final void start(boolean z) throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        zzbq.m4820c("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (this.zzamw) {
                finish();
            }
            this.zzamu = zzc(this.mContext, this.zzamz);
            this.zzamv = zza(this.mContext, this.zzamu);
            this.zzamw = true;
            if (z) {
                zzbo();
            }
        }
    }

    private final boolean zza(Info info, boolean z, float f, long j, String str, Throwable th) {
        if (Math.random() > ((double) f)) {
            return false;
        }
        Map hashMap = new HashMap();
        hashMap.put("app_context", z ? "1" : "0");
        if (info != null) {
            hashMap.put("limit_ad_tracking", info.isLimitAdTrackingEnabled() ? "1" : "0");
        }
        if (!(info == null || info.getId() == null)) {
            hashMap.put("ad_id_size", Integer.toString(info.getId().length()));
        }
        if (th != null) {
            hashMap.put("error", th.getClass().getName());
        }
        if (!(str == null || str.isEmpty())) {
            hashMap.put("experiment_id", str);
        }
        hashMap.put("tag", "AdvertisingIdClient");
        hashMap.put("time_spent", Long.toString(j));
        new zza(this, hashMap).start();
        return true;
    }

    private final void zzbo() {
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
        r5 = this;
        r0 = r5.zzamx;
        monitor-enter(r0);
        r1 = r5.zzamy;	 Catch:{ all -> 0x0026 }
        if (r1 == 0) goto L_0x0013;	 Catch:{ all -> 0x0026 }
    L_0x0007:
        r1 = r5.zzamy;	 Catch:{ all -> 0x0026 }
        r1 = r1.zzane;	 Catch:{ all -> 0x0026 }
        r1.countDown();	 Catch:{ all -> 0x0026 }
        r1 = r5.zzamy;	 Catch:{ InterruptedException -> 0x0013 }
        r1.join();	 Catch:{ InterruptedException -> 0x0013 }
    L_0x0013:
        r1 = r5.zzana;	 Catch:{ all -> 0x0026 }
        r3 = 0;	 Catch:{ all -> 0x0026 }
        r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));	 Catch:{ all -> 0x0026 }
        if (r1 <= 0) goto L_0x0024;	 Catch:{ all -> 0x0026 }
    L_0x001b:
        r1 = new com.google.android.gms.ads.identifier.AdvertisingIdClient$zza;	 Catch:{ all -> 0x0026 }
        r2 = r5.zzana;	 Catch:{ all -> 0x0026 }
        r1.<init>(r5, r2);	 Catch:{ all -> 0x0026 }
        r5.zzamy = r1;	 Catch:{ all -> 0x0026 }
    L_0x0024:
        monitor-exit(r0);	 Catch:{ all -> 0x0026 }
        return;	 Catch:{ all -> 0x0026 }
    L_0x0026:
        r1 = move-exception;	 Catch:{ all -> 0x0026 }
        monitor-exit(r0);	 Catch:{ all -> 0x0026 }
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.identifier.AdvertisingIdClient.zzbo():void");
    }

    private static com.google.android.gms.common.zza zzc(android.content.Context r3, boolean r4) throws java.io.IOException, com.google.android.gms.common.GooglePlayServicesNotAvailableException, com.google.android.gms.common.GooglePlayServicesRepairableException {
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
        r0 = r3.getPackageManager();	 Catch:{ NameNotFoundException -> 0x004f }
        r1 = "com.android.vending";	 Catch:{ NameNotFoundException -> 0x004f }
        r2 = 0;	 Catch:{ NameNotFoundException -> 0x004f }
        r0.getPackageInfo(r1, r2);	 Catch:{ NameNotFoundException -> 0x004f }
        r0 = com.google.android.gms.common.zzf.m4930b();
        r0 = r0.mo1537a(r3);
        if (r0 == 0) goto L_0x001f;
    L_0x0014:
        r1 = 2;
        if (r0 == r1) goto L_0x001f;
    L_0x0017:
        r3 = new java.io.IOException;
        r4 = "Google Play services not available";
        r3.<init>(r4);
        throw r3;
    L_0x001f:
        if (r4 == 0) goto L_0x0024;
    L_0x0021:
        r4 = "com.google.android.gms.ads.identifier.service.PERSISTENT_START";
        goto L_0x0026;
    L_0x0024:
        r4 = "com.google.android.gms.ads.identifier.service.START";
    L_0x0026:
        r0 = new com.google.android.gms.common.zza;
        r0.<init>();
        r1 = new android.content.Intent;
        r1.<init>(r4);
        r4 = "com.google.android.gms";
        r1.setPackage(r4);
        com.google.android.gms.common.stats.zza.m4889a();	 Catch:{ Throwable -> 0x0048 }
        r4 = 1;	 Catch:{ Throwable -> 0x0048 }
        r3 = com.google.android.gms.common.stats.zza.m4891b(r3, r1, r0, r4);	 Catch:{ Throwable -> 0x0048 }
        if (r3 == 0) goto L_0x0040;
    L_0x003f:
        return r0;
    L_0x0040:
        r3 = new java.io.IOException;
        r4 = "Connection failure";
        r3.<init>(r4);
        throw r3;
    L_0x0048:
        r3 = move-exception;
        r4 = new java.io.IOException;
        r4.<init>(r3);
        throw r4;
    L_0x004f:
        r3 = new com.google.android.gms.common.GooglePlayServicesNotAvailableException;
        r4 = 9;
        r3.<init>(r4);
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.identifier.AdvertisingIdClient.zzc(android.content.Context, boolean):com.google.android.gms.common.zza");
    }

    protected void finalize() throws Throwable {
        finish();
        super.finalize();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void finish() {
        /*
        r3 = this;
        r0 = "Calling this from your main thread can lead to deadlock";
        com.google.android.gms.common.internal.zzbq.m4820c(r0);
        monitor-enter(r3);
        r0 = r3.mContext;	 Catch:{ all -> 0x0032 }
        if (r0 == 0) goto L_0x0030;
    L_0x000a:
        r0 = r3.zzamu;	 Catch:{ all -> 0x0032 }
        if (r0 != 0) goto L_0x000f;
    L_0x000e:
        goto L_0x0030;
    L_0x000f:
        r0 = r3.zzamw;	 Catch:{ Throwable -> 0x001e }
        if (r0 == 0) goto L_0x0026;
    L_0x0013:
        com.google.android.gms.common.stats.zza.m4889a();	 Catch:{ Throwable -> 0x001e }
        r0 = r3.mContext;	 Catch:{ Throwable -> 0x001e }
        r1 = r3.zzamu;	 Catch:{ Throwable -> 0x001e }
        r0.unbindService(r1);	 Catch:{ Throwable -> 0x001e }
        goto L_0x0026;
    L_0x001e:
        r0 = move-exception;
        r1 = "AdvertisingIdClient";
        r2 = "AdvertisingIdClient unbindService failed.";
        android.util.Log.i(r1, r2, r0);	 Catch:{ all -> 0x0032 }
    L_0x0026:
        r0 = 0;
        r3.zzamw = r0;	 Catch:{ all -> 0x0032 }
        r0 = 0;
        r3.zzamv = r0;	 Catch:{ all -> 0x0032 }
        r3.zzamu = r0;	 Catch:{ all -> 0x0032 }
        monitor-exit(r3);	 Catch:{ all -> 0x0032 }
        return;
    L_0x0030:
        monitor-exit(r3);	 Catch:{ all -> 0x0032 }
        return;
    L_0x0032:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0032 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.identifier.AdvertisingIdClient.finish():void");
    }

    public Info getInfo() throws IOException {
        Info info;
        zzbq.m4820c("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (!this.zzamw) {
                synchronized (this.zzamx) {
                    if (this.zzamy != null) {
                        if (this.zzamy.zzanf) {
                        }
                    }
                    throw new IOException("AdvertisingIdClient is not connected.");
                }
                try {
                    start(false);
                    if (!this.zzamw) {
                        throw new IOException("AdvertisingIdClient cannot reconnect.");
                    }
                } catch (Throwable e) {
                    Log.i("AdvertisingIdClient", "GMS remote exception ", e);
                    throw new IOException("Remote exception");
                } catch (Throwable e2) {
                    throw new IOException("AdvertisingIdClient cannot reconnect.", e2);
                }
            }
            zzbq.m4808a(this.zzamu);
            zzbq.m4808a(this.zzamv);
            info = new Info(this.zzamv.mo1938a(), this.zzamv.mo1939b());
        }
        zzbo();
        return info;
    }

    public boolean getIsAdIdFakeForDebugLogging() throws IOException {
        boolean c;
        zzbq.m4820c("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (!this.zzamw) {
                synchronized (this.zzamx) {
                    if (this.zzamy != null) {
                        if (this.zzamy.zzanf) {
                        }
                    }
                    throw new IOException("AdvertisingIdClient is not connected.");
                }
                try {
                    start(false);
                    if (!this.zzamw) {
                        throw new IOException("AdvertisingIdClient cannot reconnect.");
                    }
                } catch (Throwable e) {
                    Log.i("AdvertisingIdClient", "GMS remote exception ", e);
                    throw new IOException("Remote exception");
                } catch (Throwable e2) {
                    throw new IOException("AdvertisingIdClient cannot reconnect.", e2);
                }
            }
            zzbq.m4808a(this.zzamu);
            zzbq.m4808a(this.zzamv);
            c = this.zzamv.mo1940c();
        }
        zzbo();
        return c;
    }

    public void start() throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        start(true);
    }

    private static com.google.android.gms.internal.zzfo zza(android.content.Context r2, com.google.android.gms.common.zza r3) throws java.io.IOException {
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
        r2 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ InterruptedException -> 0x0036, Throwable -> 0x002f }
        r0 = "BlockingServiceConnection.getServiceWithTimeout() called on main thread";	 Catch:{ InterruptedException -> 0x0036, Throwable -> 0x002f }
        com.google.android.gms.common.internal.zzbq.m4820c(r0);	 Catch:{ InterruptedException -> 0x0036, Throwable -> 0x002f }
        r0 = r3.f5972a;	 Catch:{ InterruptedException -> 0x0036, Throwable -> 0x002f }
        if (r0 == 0) goto L_0x0013;	 Catch:{ InterruptedException -> 0x0036, Throwable -> 0x002f }
    L_0x000b:
        r2 = new java.lang.IllegalStateException;	 Catch:{ InterruptedException -> 0x0036, Throwable -> 0x002f }
        r3 = "Cannot call get on this connection more than once";	 Catch:{ InterruptedException -> 0x0036, Throwable -> 0x002f }
        r2.<init>(r3);	 Catch:{ InterruptedException -> 0x0036, Throwable -> 0x002f }
        throw r2;	 Catch:{ InterruptedException -> 0x0036, Throwable -> 0x002f }
    L_0x0013:
        r0 = 1;	 Catch:{ InterruptedException -> 0x0036, Throwable -> 0x002f }
        r3.f5972a = r0;	 Catch:{ InterruptedException -> 0x0036, Throwable -> 0x002f }
        r3 = r3.f5973b;	 Catch:{ InterruptedException -> 0x0036, Throwable -> 0x002f }
        r0 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;	 Catch:{ InterruptedException -> 0x0036, Throwable -> 0x002f }
        r2 = r3.poll(r0, r2);	 Catch:{ InterruptedException -> 0x0036, Throwable -> 0x002f }
        r2 = (android.os.IBinder) r2;	 Catch:{ InterruptedException -> 0x0036, Throwable -> 0x002f }
        if (r2 != 0) goto L_0x002a;	 Catch:{ InterruptedException -> 0x0036, Throwable -> 0x002f }
    L_0x0022:
        r2 = new java.util.concurrent.TimeoutException;	 Catch:{ InterruptedException -> 0x0036, Throwable -> 0x002f }
        r3 = "Timed out waiting for the service connection";	 Catch:{ InterruptedException -> 0x0036, Throwable -> 0x002f }
        r2.<init>(r3);	 Catch:{ InterruptedException -> 0x0036, Throwable -> 0x002f }
        throw r2;	 Catch:{ InterruptedException -> 0x0036, Throwable -> 0x002f }
    L_0x002a:
        r2 = com.google.android.gms.internal.zzfp.m13910a(r2);	 Catch:{ InterruptedException -> 0x0036, Throwable -> 0x002f }
        return r2;
    L_0x002f:
        r2 = move-exception;
        r3 = new java.io.IOException;
        r3.<init>(r2);
        throw r3;
    L_0x0036:
        r2 = new java.io.IOException;
        r3 = "Interrupted exception";
        r2.<init>(r3);
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.identifier.AdvertisingIdClient.zza(android.content.Context, com.google.android.gms.common.zza):com.google.android.gms.internal.zzfo");
    }
}
