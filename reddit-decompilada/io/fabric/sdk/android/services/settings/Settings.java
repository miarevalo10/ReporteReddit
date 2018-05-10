package io.fabric.sdk.android.services.settings;

import io.fabric.sdk.android.Fabric;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

public class Settings {
    private final AtomicReference<SettingsData> f24916a;
    private final CountDownLatch f24917b;
    private SettingsController f24918c;
    private boolean f24919d;

    static class LazyHolder {
        private static final Settings f24915a = new Settings();
    }

    public static Settings m26437a() {
        return LazyHolder.f24915a;
    }

    private Settings() {
        this.f24916a = new AtomicReference();
        this.f24917b = new CountDownLatch(1);
        this.f24919d = false;
    }

    public final synchronized io.fabric.sdk.android.services.settings.Settings m26439a(io.fabric.sdk.android.Kit r27, io.fabric.sdk.android.services.common.IdManager r28, io.fabric.sdk.android.services.network.HttpRequestFactory r29, java.lang.String r30, java.lang.String r31, java.lang.String r32) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r26 = this;
        r1 = r26;
        r3 = r27;
        monitor-enter(r26);
        r2 = r1.f24919d;	 Catch:{ all -> 0x00ac }
        if (r2 == 0) goto L_0x000b;
    L_0x0009:
        monitor-exit(r26);
        return r1;
    L_0x000b:
        r2 = r1.f24918c;	 Catch:{ all -> 0x00ac }
        r9 = 1;	 Catch:{ all -> 0x00ac }
        if (r2 != 0) goto L_0x00a8;	 Catch:{ all -> 0x00ac }
    L_0x0010:
        r2 = r27.getContext();	 Catch:{ all -> 0x00ac }
        r4 = r28;	 Catch:{ all -> 0x00ac }
        r5 = r4.f24759b;	 Catch:{ all -> 0x00ac }
        r6 = new io.fabric.sdk.android.services.common.ApiKey;	 Catch:{ all -> 0x00ac }
        r6.<init>();	 Catch:{ all -> 0x00ac }
        r11 = io.fabric.sdk.android.services.common.ApiKey.m26273a(r2);	 Catch:{ all -> 0x00ac }
        r6 = r28.m26334d();	 Catch:{ all -> 0x00ac }
        r7 = new io.fabric.sdk.android.services.common.SystemCurrentTimeProvider;	 Catch:{ all -> 0x00ac }
        r7.<init>();	 Catch:{ all -> 0x00ac }
        r8 = new io.fabric.sdk.android.services.settings.DefaultSettingsJsonTransform;	 Catch:{ all -> 0x00ac }
        r8.<init>();	 Catch:{ all -> 0x00ac }
        r15 = new io.fabric.sdk.android.services.settings.DefaultCachedSettingsIo;	 Catch:{ all -> 0x00ac }
        r15.<init>(r3);	 Catch:{ all -> 0x00ac }
        r22 = io.fabric.sdk.android.services.common.CommonUtils.m26313i(r2);	 Catch:{ all -> 0x00ac }
        r10 = java.util.Locale.US;	 Catch:{ all -> 0x00ac }
        r12 = "https://settings.crashlytics.com/spi/v2/platforms/android/apps/%s/settings";	 Catch:{ all -> 0x00ac }
        r13 = new java.lang.Object[r9];	 Catch:{ all -> 0x00ac }
        r14 = 0;	 Catch:{ all -> 0x00ac }
        r13[r14] = r5;	 Catch:{ all -> 0x00ac }
        r5 = java.lang.String.format(r10, r12, r13);	 Catch:{ all -> 0x00ac }
        r13 = new io.fabric.sdk.android.services.settings.DefaultSettingsSpiCall;	 Catch:{ all -> 0x00ac }
        r10 = r29;	 Catch:{ all -> 0x00ac }
        r12 = r32;	 Catch:{ all -> 0x00ac }
        r13.<init>(r3, r12, r5, r10);	 Catch:{ all -> 0x00ac }
        r12 = io.fabric.sdk.android.services.common.IdManager.m26329b();	 Catch:{ all -> 0x00ac }
        r5 = android.os.Build.VERSION.INCREMENTAL;	 Catch:{ all -> 0x00ac }
        r5 = io.fabric.sdk.android.services.common.IdManager.m26327a(r5);	 Catch:{ all -> 0x00ac }
        r10 = android.os.Build.VERSION.RELEASE;	 Catch:{ all -> 0x00ac }
        r16 = io.fabric.sdk.android.services.common.IdManager.m26327a(r10);	 Catch:{ all -> 0x00ac }
        r17 = r28.m26335e();	 Catch:{ all -> 0x00ac }
        r18 = r28.m26332a();	 Catch:{ all -> 0x00ac }
        r4 = r28.m26336f();	 Catch:{ all -> 0x00ac }
        r10 = new java.lang.String[r9];	 Catch:{ all -> 0x00ac }
        r2 = io.fabric.sdk.android.services.common.CommonUtils.m26315k(r2);	 Catch:{ all -> 0x00ac }
        r10[r14] = r2;	 Catch:{ all -> 0x00ac }
        r2 = io.fabric.sdk.android.services.common.CommonUtils.m26291a(r10);	 Catch:{ all -> 0x00ac }
        r6 = io.fabric.sdk.android.services.common.DeliveryMechanism.m26319a(r6);	 Catch:{ all -> 0x00ac }
        r6 = r6.f24744e;	 Catch:{ all -> 0x00ac }
        r23 = new io.fabric.sdk.android.services.settings.SettingsRequest;	 Catch:{ all -> 0x00ac }
        r10 = r23;	 Catch:{ all -> 0x00ac }
        r24 = r13;	 Catch:{ all -> 0x00ac }
        r13 = r5;	 Catch:{ all -> 0x00ac }
        r14 = r16;	 Catch:{ all -> 0x00ac }
        r25 = r15;	 Catch:{ all -> 0x00ac }
        r15 = r17;	 Catch:{ all -> 0x00ac }
        r16 = r18;	 Catch:{ all -> 0x00ac }
        r17 = r4;	 Catch:{ all -> 0x00ac }
        r18 = r2;	 Catch:{ all -> 0x00ac }
        r19 = r31;	 Catch:{ all -> 0x00ac }
        r20 = r30;	 Catch:{ all -> 0x00ac }
        r21 = r6;	 Catch:{ all -> 0x00ac }
        r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22);	 Catch:{ all -> 0x00ac }
        r10 = new io.fabric.sdk.android.services.settings.DefaultSettingsController;	 Catch:{ all -> 0x00ac }
        r2 = r10;	 Catch:{ all -> 0x00ac }
        r4 = r23;	 Catch:{ all -> 0x00ac }
        r5 = r7;	 Catch:{ all -> 0x00ac }
        r6 = r8;	 Catch:{ all -> 0x00ac }
        r7 = r25;	 Catch:{ all -> 0x00ac }
        r8 = r24;	 Catch:{ all -> 0x00ac }
        r2.<init>(r3, r4, r5, r6, r7, r8);	 Catch:{ all -> 0x00ac }
        r1.f24918c = r10;	 Catch:{ all -> 0x00ac }
    L_0x00a8:
        r1.f24919d = r9;	 Catch:{ all -> 0x00ac }
        monitor-exit(r26);
        return r1;
    L_0x00ac:
        r0 = move-exception;
        r2 = r0;
        monitor-exit(r26);
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.fabric.sdk.android.services.settings.Settings.a(io.fabric.sdk.android.Kit, io.fabric.sdk.android.services.common.IdManager, io.fabric.sdk.android.services.network.HttpRequestFactory, java.lang.String, java.lang.String, java.lang.String):io.fabric.sdk.android.services.settings.Settings");
    }

    public final io.fabric.sdk.android.services.settings.SettingsData m26440b() {
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
        r3 = this;
        r0 = r3.f24917b;	 Catch:{ InterruptedException -> 0x000e }
        r0.await();	 Catch:{ InterruptedException -> 0x000e }
        r0 = r3.f24916a;	 Catch:{ InterruptedException -> 0x000e }
        r0 = r0.get();	 Catch:{ InterruptedException -> 0x000e }
        r0 = (io.fabric.sdk.android.services.settings.SettingsData) r0;	 Catch:{ InterruptedException -> 0x000e }
        return r0;
    L_0x000e:
        r0 = io.fabric.sdk.android.Fabric.m26243b();
        r1 = "Fabric";
        r2 = "Interrupted while waiting for settings data.";
        r0.mo5570e(r1, r2);
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.fabric.sdk.android.services.settings.Settings.b():io.fabric.sdk.android.services.settings.SettingsData");
    }

    public final synchronized boolean m26441c() {
        boolean z;
        SettingsData a = this.f24918c.mo5611a();
        m26438a(a);
        if (a != null) {
            z = true;
        } else {
            z = false;
        }
        return z;
    }

    public final synchronized boolean m26442d() {
        boolean z;
        SettingsData a = this.f24918c.mo5612a(SettingsCacheBehavior.SKIP_CACHE_LOOKUP);
        m26438a(a);
        if (a == null) {
            Fabric.m26243b().mo5568c("Fabric", "Failed to force reload of settings from Crashlytics.", null);
        }
        if (a != null) {
            z = true;
        } else {
            z = false;
        }
        return z;
    }

    private void m26438a(SettingsData settingsData) {
        this.f24916a.set(settingsData);
        this.f24917b.countDown();
    }
}
