package io.fabric.sdk.android;

import android.os.SystemClock;
import android.text.TextUtils;
import io.fabric.sdk.android.services.common.CommonUtils;
import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Callable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

class FabricKitsFinder implements Callable<Map<String, KitInfo>> {
    final String f24709a;

    FabricKitsFinder(String str) {
        this.f24709a = str;
    }

    private static java.util.Map<java.lang.String, io.fabric.sdk.android.KitInfo> m26249a() {
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
        r0 = new java.util.HashMap;
        r0.<init>();
        r1 = "com.google.android.gms.ads.AdView";	 Catch:{ Exception -> 0x0025 }
        java.lang.Class.forName(r1);	 Catch:{ Exception -> 0x0025 }
        r1 = new io.fabric.sdk.android.KitInfo;	 Catch:{ Exception -> 0x0025 }
        r2 = "com.google.firebase.firebase-ads";	 Catch:{ Exception -> 0x0025 }
        r3 = "0.0.0";	 Catch:{ Exception -> 0x0025 }
        r4 = "binary";	 Catch:{ Exception -> 0x0025 }
        r1.<init>(r2, r3, r4);	 Catch:{ Exception -> 0x0025 }
        r2 = r1.f24711a;	 Catch:{ Exception -> 0x0025 }
        r0.put(r2, r1);	 Catch:{ Exception -> 0x0025 }
        r1 = io.fabric.sdk.android.Fabric.m26243b();	 Catch:{ Exception -> 0x0025 }
        r2 = "Fabric";	 Catch:{ Exception -> 0x0025 }
        r3 = "Found kit: com.google.firebase.firebase-ads";	 Catch:{ Exception -> 0x0025 }
        r1.mo5565b(r2, r3);	 Catch:{ Exception -> 0x0025 }
    L_0x0025:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.fabric.sdk.android.FabricKitsFinder.a():java.util.Map<java.lang.String, io.fabric.sdk.android.KitInfo>");
    }

    private java.util.Map<java.lang.String, io.fabric.sdk.android.KitInfo> m26250b() throws java.lang.Exception {
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
        r10 = this;
        r0 = new java.util.HashMap;
        r0.<init>();
        r1 = new java.util.zip.ZipFile;
        r2 = r10.f24709a;
        r1.<init>(r2);
        r2 = r1.entries();
    L_0x0010:
        r3 = r2.hasMoreElements();
        if (r3 == 0) goto L_0x005b;
    L_0x0016:
        r3 = r2.nextElement();
        r3 = (java.util.zip.ZipEntry) r3;
        r4 = r3.getName();
        r5 = "fabric/";
        r4 = r4.startsWith(r5);
        if (r4 == 0) goto L_0x0010;
    L_0x0028:
        r4 = r3.getName();
        r4 = r4.length();
        r5 = 7;
        if (r4 <= r5) goto L_0x0010;
    L_0x0033:
        r3 = m26248a(r3, r1);
        if (r3 == 0) goto L_0x0010;
    L_0x0039:
        r4 = r3.f24711a;
        r0.put(r4, r3);
        r4 = io.fabric.sdk.android.Fabric.m26243b();
        r5 = "Fabric";
        r6 = "Found kit:[%s] version:[%s]";
        r7 = 2;
        r7 = new java.lang.Object[r7];
        r8 = 0;
        r9 = r3.f24711a;
        r7[r8] = r9;
        r8 = 1;
        r3 = r3.f24712b;
        r7[r8] = r3;
        r3 = java.lang.String.format(r6, r7);
        r4.mo5565b(r5, r3);
        goto L_0x0010;
    L_0x005b:
        r1.close();	 Catch:{ IOException -> 0x005e }
    L_0x005e:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.fabric.sdk.android.FabricKitsFinder.b():java.util.Map<java.lang.String, io.fabric.sdk.android.KitInfo>");
    }

    private static KitInfo m26248a(ZipEntry zipEntry, ZipFile zipFile) {
        Throwable e;
        StringBuilder stringBuilder;
        Closeable inputStream;
        try {
            inputStream = zipFile.getInputStream(zipEntry);
            try {
                Properties properties = new Properties();
                properties.load(inputStream);
                Object property = properties.getProperty("fabric-identifier");
                Object property2 = properties.getProperty("fabric-version");
                String property3 = properties.getProperty("fabric-build-type");
                if (!TextUtils.isEmpty(property)) {
                    if (!TextUtils.isEmpty(property2)) {
                        KitInfo kitInfo = new KitInfo(property, property2, property3);
                        CommonUtils.m26293a(inputStream);
                        return kitInfo;
                    }
                }
                StringBuilder stringBuilder2 = new StringBuilder("Invalid format of fabric file,");
                stringBuilder2.append(zipEntry.getName());
                throw new IllegalStateException(stringBuilder2.toString());
            } catch (IOException e2) {
                e = e2;
                try {
                    stringBuilder = new StringBuilder("Error when parsing fabric properties ");
                    stringBuilder.append(zipEntry.getName());
                    Fabric.m26243b().mo5568c("Fabric", stringBuilder.toString(), e);
                    CommonUtils.m26293a(inputStream);
                    return null;
                } catch (Throwable th) {
                    zipEntry = th;
                    CommonUtils.m26293a(inputStream);
                    throw zipEntry;
                }
            }
        } catch (IOException e3) {
            e = e3;
            inputStream = null;
            stringBuilder = new StringBuilder("Error when parsing fabric properties ");
            stringBuilder.append(zipEntry.getName());
            Fabric.m26243b().mo5568c("Fabric", stringBuilder.toString(), e);
            CommonUtils.m26293a(inputStream);
            return null;
        } catch (Throwable th2) {
            zipEntry = th2;
            inputStream = null;
            CommonUtils.m26293a(inputStream);
            throw zipEntry;
        }
    }

    public /* synthetic */ Object call() throws Exception {
        Map hashMap = new HashMap();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        hashMap.putAll(m26249a());
        hashMap.putAll(m26250b());
        StringBuilder stringBuilder = new StringBuilder("finish scanning in ");
        stringBuilder.append(SystemClock.elapsedRealtime() - elapsedRealtime);
        Fabric.m26243b().mo5565b("Fabric", stringBuilder.toString());
        return hashMap;
    }
}
