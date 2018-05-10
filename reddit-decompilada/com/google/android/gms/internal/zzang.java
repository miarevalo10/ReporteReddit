package com.google.android.gms.internal;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@zzzv
public final class zzang extends zzana {
    private static final Set<String> f17576b = Collections.synchronizedSet(new HashSet());
    private static final DecimalFormat f17577c = new DecimalFormat("#,###");
    private File f17578d;
    private boolean f17579e;

    public zzang(zzamp com_google_android_gms_internal_zzamp) {
        super(com_google_android_gms_internal_zzamp);
        File cacheDir = this.a.getCacheDir();
        if (cacheDir == null) {
            zzakb.m5371e("Context.getCacheDir() returned null");
            return;
        }
        this.f17578d = new File(cacheDir, "admobVideoStreams");
        if (this.f17578d.isDirectory() || this.f17578d.mkdirs()) {
            if (this.f17578d.setReadable(true, false)) {
                if (this.f17578d.setExecutable(true, false)) {
                    return;
                }
            }
            String str = "Could not set cache file permissions at ";
            String valueOf = String.valueOf(this.f17578d.getAbsolutePath());
            zzakb.m5371e(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            this.f17578d = null;
            return;
        }
        str = "Could not create preload cache directory at ";
        valueOf = String.valueOf(this.f17578d.getAbsolutePath());
        zzakb.m5371e(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        this.f17578d = null;
    }

    private final File m17820a(File file) {
        return new File(this.f17578d, String.valueOf(file.getName()).concat(".done"));
    }

    public final void mo3459a() {
        this.f17579e = true;
    }

    public final boolean mo3460a(java.lang.String r30) {
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
        r29 = this;
        r7 = r29;
        r8 = r30;
        r1 = r7.f17578d;
        r9 = 0;
        r10 = 0;
        if (r1 != 0) goto L_0x0010;
    L_0x000a:
        r1 = "noCacheDir";
    L_0x000c:
        r7.m13403a(r8, r9, r1, r9);
        return r10;
    L_0x0010:
        r1 = r7.f17578d;
        if (r1 != 0) goto L_0x0016;
    L_0x0014:
        r4 = r10;
        goto L_0x0034;
    L_0x0016:
        r1 = r7.f17578d;
        r1 = r1.listFiles();
        r2 = r1.length;
        r3 = r10;
        r4 = r3;
    L_0x001f:
        if (r3 >= r2) goto L_0x0034;
    L_0x0021:
        r5 = r1[r3];
        r5 = r5.getName();
        r6 = ".done";
        r5 = r5.endsWith(r6);
        if (r5 != 0) goto L_0x0031;
    L_0x002f:
        r4 = r4 + 1;
    L_0x0031:
        r3 = r3 + 1;
        goto L_0x001f;
    L_0x0034:
        r1 = com.google.android.gms.internal.zznh.f7901j;
        r2 = com.google.android.gms.internal.zzkb.m6350f();
        r1 = r2.m6488a(r1);
        r1 = (java.lang.Integer) r1;
        r1 = r1.intValue();
        if (r4 <= r1) goto L_0x0098;
    L_0x0046:
        r1 = r7.f17578d;
        if (r1 != 0) goto L_0x004c;
    L_0x004a:
        r1 = r10;
        goto L_0x008d;
    L_0x004c:
        r1 = 9223372036854775807; // 0x7fffffffffffffff float:NaN double:NaN;
        r3 = r7.f17578d;
        r3 = r3.listFiles();
        r4 = r3.length;
        r5 = r1;
        r2 = r9;
        r1 = r10;
    L_0x005b:
        if (r1 >= r4) goto L_0x0078;
    L_0x005d:
        r11 = r3[r1];
        r12 = r11.getName();
        r13 = ".done";
        r12 = r12.endsWith(r13);
        if (r12 != 0) goto L_0x0075;
    L_0x006b:
        r12 = r11.lastModified();
        r14 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1));
        if (r14 >= 0) goto L_0x0075;
    L_0x0073:
        r2 = r11;
        r5 = r12;
    L_0x0075:
        r1 = r1 + 1;
        goto L_0x005b;
    L_0x0078:
        if (r2 == 0) goto L_0x004a;
    L_0x007a:
        r1 = r2.delete();
        r2 = r7.m17820a(r2);
        r3 = r2.isFile();
        if (r3 == 0) goto L_0x008d;
    L_0x0088:
        r2 = r2.delete();
        r1 = r1 & r2;
    L_0x008d:
        if (r1 != 0) goto L_0x0010;
    L_0x008f:
        r1 = "Unable to expire stream cache";
        com.google.android.gms.internal.zzakb.m5371e(r1);
        r1 = "expireFailed";
        goto L_0x000c;
    L_0x0098:
        com.google.android.gms.internal.zzkb.m6345a();
        r1 = com.google.android.gms.internal.zzajr.m5321a(r30);
        r11 = new java.io.File;
        r2 = r7.f17578d;
        r11.<init>(r2, r1);
        r12 = r7.m17820a(r11);
        r1 = r11.isFile();
        r13 = 1;
        if (r1 == 0) goto L_0x00de;
    L_0x00b1:
        r1 = r12.isFile();
        if (r1 == 0) goto L_0x00de;
    L_0x00b7:
        r1 = r11.length();
        r1 = (int) r1;
        r2 = "Stream cache hit at ";
        r3 = java.lang.String.valueOf(r30);
        r4 = r3.length();
        if (r4 == 0) goto L_0x00cd;
    L_0x00c8:
        r2 = r2.concat(r3);
        goto L_0x00d3;
    L_0x00cd:
        r3 = new java.lang.String;
        r3.<init>(r2);
        r2 = r3;
    L_0x00d3:
        com.google.android.gms.internal.zzakb.m5366b(r2);
        r2 = r11.getAbsolutePath();
        r7.m13402a(r8, r2, r1);
        return r13;
    L_0x00de:
        r1 = r7.f17578d;
        r1 = r1.getAbsolutePath();
        r1 = java.lang.String.valueOf(r1);
        r2 = java.lang.String.valueOf(r30);
        r3 = r2.length();
        if (r3 == 0) goto L_0x00f8;
    L_0x00f2:
        r1 = r1.concat(r2);
        r14 = r1;
        goto L_0x00fe;
    L_0x00f8:
        r2 = new java.lang.String;
        r2.<init>(r1);
        r14 = r2;
    L_0x00fe:
        r1 = f17576b;
        monitor-enter(r1);
        r2 = f17576b;	 Catch:{ all -> 0x04ed }
        r2 = r2.contains(r14);	 Catch:{ all -> 0x04ed }
        if (r2 == 0) goto L_0x012e;	 Catch:{ all -> 0x04ed }
    L_0x0109:
        r2 = "Stream cache already in progress at ";	 Catch:{ all -> 0x04ed }
        r3 = java.lang.String.valueOf(r30);	 Catch:{ all -> 0x04ed }
        r4 = r3.length();	 Catch:{ all -> 0x04ed }
        if (r4 == 0) goto L_0x011a;	 Catch:{ all -> 0x04ed }
    L_0x0115:
        r2 = r2.concat(r3);	 Catch:{ all -> 0x04ed }
        goto L_0x0120;	 Catch:{ all -> 0x04ed }
    L_0x011a:
        r3 = new java.lang.String;	 Catch:{ all -> 0x04ed }
        r3.<init>(r2);	 Catch:{ all -> 0x04ed }
        r2 = r3;	 Catch:{ all -> 0x04ed }
    L_0x0120:
        com.google.android.gms.internal.zzakb.m5371e(r2);	 Catch:{ all -> 0x04ed }
        r2 = r11.getAbsolutePath();	 Catch:{ all -> 0x04ed }
        r3 = "inProgress";	 Catch:{ all -> 0x04ed }
        r7.m13403a(r8, r2, r3, r9);	 Catch:{ all -> 0x04ed }
        monitor-exit(r1);	 Catch:{ all -> 0x04ed }
        return r10;	 Catch:{ all -> 0x04ed }
    L_0x012e:
        r2 = f17576b;	 Catch:{ all -> 0x04ed }
        r2.add(r14);	 Catch:{ all -> 0x04ed }
        monitor-exit(r1);	 Catch:{ all -> 0x04ed }
        r15 = "error";
        com.google.android.gms.ads.internal.zzbs.m4497p();	 Catch:{ IOException -> 0x0453, IOException -> 0x0453 }
        r1 = com.google.android.gms.internal.zznh.f7906o;	 Catch:{ IOException -> 0x0453, IOException -> 0x0453 }
        r2 = com.google.android.gms.internal.zzkb.m6350f();	 Catch:{ IOException -> 0x0453, IOException -> 0x0453 }
        r1 = r2.m6488a(r1);	 Catch:{ IOException -> 0x0453, IOException -> 0x0453 }
        r1 = (java.lang.Integer) r1;	 Catch:{ IOException -> 0x0453, IOException -> 0x0453 }
        r1 = r1.intValue();	 Catch:{ IOException -> 0x0453, IOException -> 0x0453 }
        r1 = com.google.android.gms.internal.zzalg.m5393a(r8, r1);	 Catch:{ IOException -> 0x0453, IOException -> 0x0453 }
        r2 = r1 instanceof java.net.HttpURLConnection;	 Catch:{ IOException -> 0x0453, IOException -> 0x0453 }
        if (r2 == 0) goto L_0x01b3;
    L_0x0151:
        r2 = r1;	 Catch:{ IOException -> 0x01ad, IOException -> 0x01ad }
        r2 = (java.net.HttpURLConnection) r2;	 Catch:{ IOException -> 0x01ad, IOException -> 0x01ad }
        r2 = r2.getResponseCode();	 Catch:{ IOException -> 0x01ad, IOException -> 0x01ad }
        r3 = 400; // 0x190 float:5.6E-43 double:1.976E-321;	 Catch:{ IOException -> 0x01ad, IOException -> 0x01ad }
        if (r2 < r3) goto L_0x01b3;	 Catch:{ IOException -> 0x01ad, IOException -> 0x01ad }
    L_0x015c:
        r1 = "badUrl";	 Catch:{ IOException -> 0x01ad, IOException -> 0x01ad }
        r3 = "HTTP request failed. Code: ";	 Catch:{ IOException -> 0x01a6, IOException -> 0x01a6 }
        r4 = java.lang.Integer.toString(r2);	 Catch:{ IOException -> 0x01a6, IOException -> 0x01a6 }
        r4 = java.lang.String.valueOf(r4);	 Catch:{ IOException -> 0x01a6, IOException -> 0x01a6 }
        r5 = r4.length();	 Catch:{ IOException -> 0x01a6, IOException -> 0x01a6 }
        if (r5 == 0) goto L_0x0173;	 Catch:{ IOException -> 0x01a6, IOException -> 0x01a6 }
    L_0x016e:
        r3 = r3.concat(r4);	 Catch:{ IOException -> 0x01a6, IOException -> 0x01a6 }
        goto L_0x0179;	 Catch:{ IOException -> 0x01a6, IOException -> 0x01a6 }
    L_0x0173:
        r4 = new java.lang.String;	 Catch:{ IOException -> 0x01a6, IOException -> 0x01a6 }
        r4.<init>(r3);	 Catch:{ IOException -> 0x01a6, IOException -> 0x01a6 }
        r3 = r4;
    L_0x0179:
        r4 = new java.io.IOException;	 Catch:{ IOException -> 0x01a3, IOException -> 0x01a3 }
        r5 = 32;	 Catch:{ IOException -> 0x01a3, IOException -> 0x01a3 }
        r6 = java.lang.String.valueOf(r30);	 Catch:{ IOException -> 0x01a3, IOException -> 0x01a3 }
        r6 = r6.length();	 Catch:{ IOException -> 0x01a3, IOException -> 0x01a3 }
        r5 = r5 + r6;	 Catch:{ IOException -> 0x01a3, IOException -> 0x01a3 }
        r6 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x01a3, IOException -> 0x01a3 }
        r6.<init>(r5);	 Catch:{ IOException -> 0x01a3, IOException -> 0x01a3 }
        r5 = "HTTP status code ";	 Catch:{ IOException -> 0x01a3, IOException -> 0x01a3 }
        r6.append(r5);	 Catch:{ IOException -> 0x01a3, IOException -> 0x01a3 }
        r6.append(r2);	 Catch:{ IOException -> 0x01a3, IOException -> 0x01a3 }
        r2 = " at ";	 Catch:{ IOException -> 0x01a3, IOException -> 0x01a3 }
        r6.append(r2);	 Catch:{ IOException -> 0x01a3, IOException -> 0x01a3 }
        r6.append(r8);	 Catch:{ IOException -> 0x01a3, IOException -> 0x01a3 }
        r2 = r6.toString();	 Catch:{ IOException -> 0x01a3, IOException -> 0x01a3 }
        r4.<init>(r2);	 Catch:{ IOException -> 0x01a3, IOException -> 0x01a3 }
        throw r4;	 Catch:{ IOException -> 0x01a3, IOException -> 0x01a3 }
    L_0x01a3:
        r0 = move-exception;
        r15 = r1;
        goto L_0x01a9;
    L_0x01a6:
        r0 = move-exception;
        r15 = r1;
        r3 = r9;
    L_0x01a9:
        r2 = r14;
    L_0x01aa:
        r1 = r0;
        goto L_0x0458;
    L_0x01ad:
        r0 = move-exception;
        r1 = r0;
        r3 = r9;
        r2 = r14;
        goto L_0x0458;
    L_0x01b3:
        r6 = r1.getContentLength();	 Catch:{ IOException -> 0x0453, IOException -> 0x0453 }
        if (r6 >= 0) goto L_0x01e2;
    L_0x01b9:
        r1 = "Stream cache aborted, missing content-length header at ";	 Catch:{ IOException -> 0x01ad, IOException -> 0x01ad }
        r2 = java.lang.String.valueOf(r30);	 Catch:{ IOException -> 0x01ad, IOException -> 0x01ad }
        r3 = r2.length();	 Catch:{ IOException -> 0x01ad, IOException -> 0x01ad }
        if (r3 == 0) goto L_0x01ca;	 Catch:{ IOException -> 0x01ad, IOException -> 0x01ad }
    L_0x01c5:
        r1 = r1.concat(r2);	 Catch:{ IOException -> 0x01ad, IOException -> 0x01ad }
        goto L_0x01d0;	 Catch:{ IOException -> 0x01ad, IOException -> 0x01ad }
    L_0x01ca:
        r2 = new java.lang.String;	 Catch:{ IOException -> 0x01ad, IOException -> 0x01ad }
        r2.<init>(r1);	 Catch:{ IOException -> 0x01ad, IOException -> 0x01ad }
        r1 = r2;	 Catch:{ IOException -> 0x01ad, IOException -> 0x01ad }
    L_0x01d0:
        com.google.android.gms.internal.zzakb.m5371e(r1);	 Catch:{ IOException -> 0x01ad, IOException -> 0x01ad }
        r1 = r11.getAbsolutePath();	 Catch:{ IOException -> 0x01ad, IOException -> 0x01ad }
        r2 = "contentLengthMissing";	 Catch:{ IOException -> 0x01ad, IOException -> 0x01ad }
        r7.m13403a(r8, r1, r2, r9);	 Catch:{ IOException -> 0x01ad, IOException -> 0x01ad }
        r1 = f17576b;	 Catch:{ IOException -> 0x01ad, IOException -> 0x01ad }
        r1.remove(r14);	 Catch:{ IOException -> 0x01ad, IOException -> 0x01ad }
        return r10;
    L_0x01e2:
        r2 = f17577c;	 Catch:{ IOException -> 0x0453, IOException -> 0x0453 }
        r3 = (long) r6;	 Catch:{ IOException -> 0x0453, IOException -> 0x0453 }
        r2 = r2.format(r3);	 Catch:{ IOException -> 0x0453, IOException -> 0x0453 }
        r3 = com.google.android.gms.internal.zznh.f7902k;	 Catch:{ IOException -> 0x0453, IOException -> 0x0453 }
        r4 = com.google.android.gms.internal.zzkb.m6350f();	 Catch:{ IOException -> 0x0453, IOException -> 0x0453 }
        r3 = r4.m6488a(r3);	 Catch:{ IOException -> 0x0453, IOException -> 0x0453 }
        r3 = (java.lang.Integer) r3;	 Catch:{ IOException -> 0x0453, IOException -> 0x0453 }
        r5 = r3.intValue();	 Catch:{ IOException -> 0x0453, IOException -> 0x0453 }
        if (r6 <= r5) goto L_0x0251;
    L_0x01fb:
        r1 = 33;
        r3 = java.lang.String.valueOf(r2);	 Catch:{ IOException -> 0x01ad, IOException -> 0x01ad }
        r3 = r3.length();	 Catch:{ IOException -> 0x01ad, IOException -> 0x01ad }
        r1 = r1 + r3;	 Catch:{ IOException -> 0x01ad, IOException -> 0x01ad }
        r3 = java.lang.String.valueOf(r30);	 Catch:{ IOException -> 0x01ad, IOException -> 0x01ad }
        r3 = r3.length();	 Catch:{ IOException -> 0x01ad, IOException -> 0x01ad }
        r1 = r1 + r3;	 Catch:{ IOException -> 0x01ad, IOException -> 0x01ad }
        r3 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x01ad, IOException -> 0x01ad }
        r3.<init>(r1);	 Catch:{ IOException -> 0x01ad, IOException -> 0x01ad }
        r1 = "Content length ";	 Catch:{ IOException -> 0x01ad, IOException -> 0x01ad }
        r3.append(r1);	 Catch:{ IOException -> 0x01ad, IOException -> 0x01ad }
        r3.append(r2);	 Catch:{ IOException -> 0x01ad, IOException -> 0x01ad }
        r1 = " exceeds limit at ";	 Catch:{ IOException -> 0x01ad, IOException -> 0x01ad }
        r3.append(r1);	 Catch:{ IOException -> 0x01ad, IOException -> 0x01ad }
        r3.append(r8);	 Catch:{ IOException -> 0x01ad, IOException -> 0x01ad }
        r1 = r3.toString();	 Catch:{ IOException -> 0x01ad, IOException -> 0x01ad }
        com.google.android.gms.internal.zzakb.m5371e(r1);	 Catch:{ IOException -> 0x01ad, IOException -> 0x01ad }
        r1 = "File too big for full file cache. Size: ";	 Catch:{ IOException -> 0x01ad, IOException -> 0x01ad }
        r2 = java.lang.String.valueOf(r2);	 Catch:{ IOException -> 0x01ad, IOException -> 0x01ad }
        r3 = r2.length();	 Catch:{ IOException -> 0x01ad, IOException -> 0x01ad }
        if (r3 == 0) goto L_0x023c;	 Catch:{ IOException -> 0x01ad, IOException -> 0x01ad }
    L_0x0237:
        r1 = r1.concat(r2);	 Catch:{ IOException -> 0x01ad, IOException -> 0x01ad }
        goto L_0x0242;	 Catch:{ IOException -> 0x01ad, IOException -> 0x01ad }
    L_0x023c:
        r2 = new java.lang.String;	 Catch:{ IOException -> 0x01ad, IOException -> 0x01ad }
        r2.<init>(r1);	 Catch:{ IOException -> 0x01ad, IOException -> 0x01ad }
        r1 = r2;	 Catch:{ IOException -> 0x01ad, IOException -> 0x01ad }
    L_0x0242:
        r2 = r11.getAbsolutePath();	 Catch:{ IOException -> 0x01ad, IOException -> 0x01ad }
        r3 = "sizeExceeded";	 Catch:{ IOException -> 0x01ad, IOException -> 0x01ad }
        r7.m13403a(r8, r2, r3, r1);	 Catch:{ IOException -> 0x01ad, IOException -> 0x01ad }
        r1 = f17576b;	 Catch:{ IOException -> 0x01ad, IOException -> 0x01ad }
        r1.remove(r14);	 Catch:{ IOException -> 0x01ad, IOException -> 0x01ad }
        return r10;
    L_0x0251:
        r3 = 20;
        r4 = java.lang.String.valueOf(r2);	 Catch:{ IOException -> 0x0453, IOException -> 0x0453 }
        r4 = r4.length();	 Catch:{ IOException -> 0x0453, IOException -> 0x0453 }
        r3 = r3 + r4;	 Catch:{ IOException -> 0x0453, IOException -> 0x0453 }
        r4 = java.lang.String.valueOf(r30);	 Catch:{ IOException -> 0x0453, IOException -> 0x0453 }
        r4 = r4.length();	 Catch:{ IOException -> 0x0453, IOException -> 0x0453 }
        r3 = r3 + r4;	 Catch:{ IOException -> 0x0453, IOException -> 0x0453 }
        r4 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0453, IOException -> 0x0453 }
        r4.<init>(r3);	 Catch:{ IOException -> 0x0453, IOException -> 0x0453 }
        r3 = "Caching ";	 Catch:{ IOException -> 0x0453, IOException -> 0x0453 }
        r4.append(r3);	 Catch:{ IOException -> 0x0453, IOException -> 0x0453 }
        r4.append(r2);	 Catch:{ IOException -> 0x0453, IOException -> 0x0453 }
        r2 = " bytes from ";	 Catch:{ IOException -> 0x0453, IOException -> 0x0453 }
        r4.append(r2);	 Catch:{ IOException -> 0x0453, IOException -> 0x0453 }
        r4.append(r8);	 Catch:{ IOException -> 0x0453, IOException -> 0x0453 }
        r2 = r4.toString();	 Catch:{ IOException -> 0x0453, IOException -> 0x0453 }
        com.google.android.gms.internal.zzakb.m5366b(r2);	 Catch:{ IOException -> 0x0453, IOException -> 0x0453 }
        r1 = r1.getInputStream();	 Catch:{ IOException -> 0x0453, IOException -> 0x0453 }
        r4 = java.nio.channels.Channels.newChannel(r1);	 Catch:{ IOException -> 0x0453, IOException -> 0x0453 }
        r3 = new java.io.FileOutputStream;	 Catch:{ IOException -> 0x0453, IOException -> 0x0453 }
        r3.<init>(r11);	 Catch:{ IOException -> 0x0453, IOException -> 0x0453 }
        r2 = r3.getChannel();	 Catch:{ IOException -> 0x044c, IOException -> 0x044c }
        r1 = 1048576; // 0x100000 float:1.469368E-39 double:5.180654E-318;	 Catch:{ IOException -> 0x044c, IOException -> 0x044c }
        r1 = java.nio.ByteBuffer.allocate(r1);	 Catch:{ IOException -> 0x044c, IOException -> 0x044c }
        r9 = com.google.android.gms.ads.internal.zzbs.m4492k();	 Catch:{ IOException -> 0x044c, IOException -> 0x044c }
        r16 = r9.mo1632a();	 Catch:{ IOException -> 0x044c, IOException -> 0x044c }
        r10 = com.google.android.gms.internal.zznh.f7905n;	 Catch:{ IOException -> 0x044c, IOException -> 0x044c }
        r13 = com.google.android.gms.internal.zzkb.m6350f();	 Catch:{ IOException -> 0x044c, IOException -> 0x044c }
        r10 = r13.m6488a(r10);	 Catch:{ IOException -> 0x044c, IOException -> 0x044c }
        r10 = (java.lang.Long) r10;	 Catch:{ IOException -> 0x044c, IOException -> 0x044c }
        r18 = r14;
        r13 = r10.longValue();	 Catch:{ IOException -> 0x0447, IOException -> 0x0447 }
        r10 = new com.google.android.gms.internal.zzaji;	 Catch:{ IOException -> 0x0447, IOException -> 0x0447 }
        r10.<init>(r13);	 Catch:{ IOException -> 0x0447, IOException -> 0x0447 }
        r13 = com.google.android.gms.internal.zznh.f7904m;	 Catch:{ IOException -> 0x0447, IOException -> 0x0447 }
        r14 = com.google.android.gms.internal.zzkb.m6350f();	 Catch:{ IOException -> 0x0447, IOException -> 0x0447 }
        r13 = r14.m6488a(r13);	 Catch:{ IOException -> 0x0447, IOException -> 0x0447 }
        r13 = (java.lang.Long) r13;	 Catch:{ IOException -> 0x0447, IOException -> 0x0447 }
        r13 = r13.longValue();	 Catch:{ IOException -> 0x0447, IOException -> 0x0447 }
        r19 = r3;
        r3 = 0;
    L_0x02ca:
        r20 = r4.read(r1);	 Catch:{ IOException -> 0x0441, IOException -> 0x0441 }
        if (r20 < 0) goto L_0x03d1;
    L_0x02d0:
        r3 = r3 + r20;
        if (r3 <= r5) goto L_0x0314;
    L_0x02d4:
        r1 = "sizeExceeded";	 Catch:{ IOException -> 0x030c, IOException -> 0x030c }
        r2 = "File too big for full file cache. Size: ";	 Catch:{ IOException -> 0x0303, IOException -> 0x0303 }
        r3 = java.lang.Integer.toString(r3);	 Catch:{ IOException -> 0x0303, IOException -> 0x0303 }
        r3 = java.lang.String.valueOf(r3);	 Catch:{ IOException -> 0x0303, IOException -> 0x0303 }
        r4 = r3.length();	 Catch:{ IOException -> 0x0303, IOException -> 0x0303 }
        if (r4 == 0) goto L_0x02ec;	 Catch:{ IOException -> 0x0303, IOException -> 0x0303 }
    L_0x02e6:
        r2 = r2.concat(r3);	 Catch:{ IOException -> 0x0303, IOException -> 0x0303 }
        r9 = r2;	 Catch:{ IOException -> 0x0303, IOException -> 0x0303 }
        goto L_0x02f2;	 Catch:{ IOException -> 0x0303, IOException -> 0x0303 }
    L_0x02ec:
        r3 = new java.lang.String;	 Catch:{ IOException -> 0x0303, IOException -> 0x0303 }
        r3.<init>(r2);	 Catch:{ IOException -> 0x0303, IOException -> 0x0303 }
        r9 = r3;
    L_0x02f2:
        r2 = new java.io.IOException;	 Catch:{ IOException -> 0x02fa, IOException -> 0x02fa }
        r3 = "stream cache file size limit exceeded";	 Catch:{ IOException -> 0x02fa, IOException -> 0x02fa }
        r2.<init>(r3);	 Catch:{ IOException -> 0x02fa, IOException -> 0x02fa }
        throw r2;	 Catch:{ IOException -> 0x02fa, IOException -> 0x02fa }
    L_0x02fa:
        r0 = move-exception;
        r15 = r1;
        r3 = r9;
        r2 = r18;
        r9 = r19;
        goto L_0x01aa;
    L_0x0303:
        r0 = move-exception;
        r15 = r1;
        r2 = r18;
        r9 = r19;
        r3 = 0;
        goto L_0x01aa;
    L_0x030c:
        r0 = move-exception;
        r1 = r0;
        r2 = r18;
        r9 = r19;
        goto L_0x0451;
    L_0x0314:
        r1.flip();	 Catch:{ IOException -> 0x03c8, IOException -> 0x03c8 }
    L_0x0317:
        r20 = r2.write(r1);	 Catch:{ IOException -> 0x03c8, IOException -> 0x03c8 }
        if (r20 > 0) goto L_0x03c4;	 Catch:{ IOException -> 0x03c8, IOException -> 0x03c8 }
    L_0x031d:
        r1.clear();	 Catch:{ IOException -> 0x03c8, IOException -> 0x03c8 }
        r20 = r9.mo1632a();	 Catch:{ IOException -> 0x03c8, IOException -> 0x03c8 }
        r20 = r20 - r16;
        r22 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r22 = r22 * r13;
        r20 = (r20 > r22 ? 1 : (r20 == r22 ? 0 : -1));
        if (r20 <= 0) goto L_0x035d;
    L_0x032e:
        r1 = "downloadTimeout";	 Catch:{ IOException -> 0x030c, IOException -> 0x030c }
        r2 = java.lang.Long.toString(r13);	 Catch:{ IOException -> 0x0303, IOException -> 0x0303 }
        r3 = 29;	 Catch:{ IOException -> 0x0303, IOException -> 0x0303 }
        r4 = java.lang.String.valueOf(r2);	 Catch:{ IOException -> 0x0303, IOException -> 0x0303 }
        r4 = r4.length();	 Catch:{ IOException -> 0x0303, IOException -> 0x0303 }
        r3 = r3 + r4;	 Catch:{ IOException -> 0x0303, IOException -> 0x0303 }
        r4 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0303, IOException -> 0x0303 }
        r4.<init>(r3);	 Catch:{ IOException -> 0x0303, IOException -> 0x0303 }
        r3 = "Timeout exceeded. Limit: ";	 Catch:{ IOException -> 0x0303, IOException -> 0x0303 }
        r4.append(r3);	 Catch:{ IOException -> 0x0303, IOException -> 0x0303 }
        r4.append(r2);	 Catch:{ IOException -> 0x0303, IOException -> 0x0303 }
        r2 = " sec";	 Catch:{ IOException -> 0x0303, IOException -> 0x0303 }
        r4.append(r2);	 Catch:{ IOException -> 0x0303, IOException -> 0x0303 }
        r9 = r4.toString();	 Catch:{ IOException -> 0x0303, IOException -> 0x0303 }
        r2 = new java.io.IOException;	 Catch:{ IOException -> 0x02fa, IOException -> 0x02fa }
        r3 = "stream cache time limit exceeded";	 Catch:{ IOException -> 0x02fa, IOException -> 0x02fa }
        r2.<init>(r3);	 Catch:{ IOException -> 0x02fa, IOException -> 0x02fa }
        throw r2;	 Catch:{ IOException -> 0x02fa, IOException -> 0x02fa }
    L_0x035d:
        r24 = r1;
        r1 = r7.f17579e;	 Catch:{ IOException -> 0x03c8, IOException -> 0x03c8 }
        if (r1 == 0) goto L_0x036d;
    L_0x0363:
        r1 = "externalAbort";	 Catch:{ IOException -> 0x030c, IOException -> 0x030c }
        r2 = new java.io.IOException;	 Catch:{ IOException -> 0x0303, IOException -> 0x0303 }
        r3 = "abort requested";	 Catch:{ IOException -> 0x0303, IOException -> 0x0303 }
        r2.<init>(r3);	 Catch:{ IOException -> 0x0303, IOException -> 0x0303 }
        throw r2;	 Catch:{ IOException -> 0x0303, IOException -> 0x0303 }
    L_0x036d:
        r1 = r10.m5301a();	 Catch:{ IOException -> 0x03c8, IOException -> 0x03c8 }
        if (r1 == 0) goto L_0x039c;	 Catch:{ IOException -> 0x03c8, IOException -> 0x03c8 }
    L_0x0373:
        r20 = r11.getAbsolutePath();	 Catch:{ IOException -> 0x03c8, IOException -> 0x03c8 }
        r1 = com.google.android.gms.internal.zzajr.f6473a;	 Catch:{ IOException -> 0x03c8, IOException -> 0x03c8 }
        r25 = r9;	 Catch:{ IOException -> 0x03c8, IOException -> 0x03c8 }
        r9 = new com.google.android.gms.internal.zzanb;	 Catch:{ IOException -> 0x03c8, IOException -> 0x03c8 }
        r26 = r10;
        r21 = r24;
        r10 = r1;
        r1 = r9;
        r22 = r2;
        r2 = r7;
        r27 = r13;
        r13 = r19;
        r14 = r3;
        r3 = r8;
        r19 = r4;
        r4 = r20;
        r20 = r5;
        r5 = r14;
        r23 = r6;
        r1.<init>(r2, r3, r4, r5, r6);	 Catch:{ IOException -> 0x0415, IOException -> 0x0415 }
        r10.post(r9);	 Catch:{ IOException -> 0x0415, IOException -> 0x0415 }
        goto L_0x03af;
    L_0x039c:
        r22 = r2;
        r20 = r5;
        r23 = r6;
        r25 = r9;
        r26 = r10;
        r27 = r13;
        r13 = r19;
        r21 = r24;
        r14 = r3;
        r19 = r4;
    L_0x03af:
        r3 = r14;
        r4 = r19;
        r5 = r20;
        r1 = r21;
        r2 = r22;
        r6 = r23;
        r9 = r25;
        r10 = r26;
        r19 = r13;
        r13 = r27;
        goto L_0x02ca;
    L_0x03c4:
        r27 = r13;
        goto L_0x0317;
    L_0x03c8:
        r0 = move-exception;
        r13 = r19;
    L_0x03cb:
        r1 = r0;
        r9 = r13;
        r2 = r18;
        goto L_0x0451;
    L_0x03d1:
        r13 = r19;
        r13.close();	 Catch:{ IOException -> 0x043f, IOException -> 0x043f }
        r1 = 3;	 Catch:{ IOException -> 0x043f, IOException -> 0x043f }
        r1 = com.google.android.gms.internal.zzakb.m5365a(r1);	 Catch:{ IOException -> 0x043f, IOException -> 0x043f }
        if (r1 == 0) goto L_0x0417;
    L_0x03dd:
        r1 = f17577c;	 Catch:{ IOException -> 0x0415, IOException -> 0x0415 }
        r4 = (long) r3;	 Catch:{ IOException -> 0x0415, IOException -> 0x0415 }
        r1 = r1.format(r4);	 Catch:{ IOException -> 0x0415, IOException -> 0x0415 }
        r2 = 22;	 Catch:{ IOException -> 0x0415, IOException -> 0x0415 }
        r4 = java.lang.String.valueOf(r1);	 Catch:{ IOException -> 0x0415, IOException -> 0x0415 }
        r4 = r4.length();	 Catch:{ IOException -> 0x0415, IOException -> 0x0415 }
        r2 = r2 + r4;	 Catch:{ IOException -> 0x0415, IOException -> 0x0415 }
        r4 = java.lang.String.valueOf(r30);	 Catch:{ IOException -> 0x0415, IOException -> 0x0415 }
        r4 = r4.length();	 Catch:{ IOException -> 0x0415, IOException -> 0x0415 }
        r2 = r2 + r4;	 Catch:{ IOException -> 0x0415, IOException -> 0x0415 }
        r4 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0415, IOException -> 0x0415 }
        r4.<init>(r2);	 Catch:{ IOException -> 0x0415, IOException -> 0x0415 }
        r2 = "Preloaded ";	 Catch:{ IOException -> 0x0415, IOException -> 0x0415 }
        r4.append(r2);	 Catch:{ IOException -> 0x0415, IOException -> 0x0415 }
        r4.append(r1);	 Catch:{ IOException -> 0x0415, IOException -> 0x0415 }
        r1 = " bytes from ";	 Catch:{ IOException -> 0x0415, IOException -> 0x0415 }
        r4.append(r1);	 Catch:{ IOException -> 0x0415, IOException -> 0x0415 }
        r4.append(r8);	 Catch:{ IOException -> 0x0415, IOException -> 0x0415 }
        r1 = r4.toString();	 Catch:{ IOException -> 0x0415, IOException -> 0x0415 }
        com.google.android.gms.internal.zzakb.m5366b(r1);	 Catch:{ IOException -> 0x0415, IOException -> 0x0415 }
        goto L_0x0417;
    L_0x0415:
        r0 = move-exception;
        goto L_0x03cb;
    L_0x0417:
        r1 = 0;
        r2 = 1;
        r11.setReadable(r2, r1);	 Catch:{ IOException -> 0x043f, IOException -> 0x043f }
        r1 = r12.isFile();	 Catch:{ IOException -> 0x043f, IOException -> 0x043f }
        if (r1 == 0) goto L_0x042a;
    L_0x0422:
        r1 = java.lang.System.currentTimeMillis();	 Catch:{ IOException -> 0x0415, IOException -> 0x0415 }
        r12.setLastModified(r1);	 Catch:{ IOException -> 0x0415, IOException -> 0x0415 }
        goto L_0x042d;
    L_0x042a:
        r12.createNewFile();	 Catch:{ IOException -> 0x042d }
    L_0x042d:
        r1 = r11.getAbsolutePath();	 Catch:{ IOException -> 0x043f, IOException -> 0x043f }
        r7.m13402a(r8, r1, r3);	 Catch:{ IOException -> 0x043f, IOException -> 0x043f }
        r1 = f17576b;	 Catch:{ IOException -> 0x043f, IOException -> 0x043f }
        r2 = r18;
        r1.remove(r2);	 Catch:{ IOException -> 0x043d, IOException -> 0x043d }
        r1 = 1;
        return r1;
    L_0x043d:
        r0 = move-exception;
        goto L_0x044f;
    L_0x043f:
        r0 = move-exception;
        goto L_0x0449;
    L_0x0441:
        r0 = move-exception;
        r2 = r18;
        r13 = r19;
        goto L_0x044f;
    L_0x0447:
        r0 = move-exception;
        r13 = r3;
    L_0x0449:
        r2 = r18;
        goto L_0x044f;
    L_0x044c:
        r0 = move-exception;
        r13 = r3;
        r2 = r14;
    L_0x044f:
        r1 = r0;
        r9 = r13;
    L_0x0451:
        r3 = 0;
        goto L_0x0458;
    L_0x0453:
        r0 = move-exception;
        r2 = r14;
        r1 = r0;
        r3 = 0;
        r9 = 0;
    L_0x0458:
        r4 = r1 instanceof java.lang.RuntimeException;
        if (r4 == 0) goto L_0x0465;
    L_0x045c:
        r4 = com.google.android.gms.ads.internal.zzbs.m4490i();
        r5 = "VideoStreamFullFileCache.preload";
        r4.m13246a(r1, r5);
    L_0x0465:
        r9.close();	 Catch:{ IOException -> 0x0468, IOException -> 0x0468 }
    L_0x0468:
        r4 = r7.f17579e;
        if (r4 == 0) goto L_0x0491;
    L_0x046c:
        r1 = 26;
        r4 = java.lang.String.valueOf(r30);
        r4 = r4.length();
        r1 = r1 + r4;
        r4 = new java.lang.StringBuilder;
        r4.<init>(r1);
        r1 = "Preload aborted for URL \"";
        r4.append(r1);
        r4.append(r8);
        r1 = "\"";
        r4.append(r1);
        r1 = r4.toString();
        com.google.android.gms.internal.zzakb.m5370d(r1);
        goto L_0x04b5;
    L_0x0491:
        r4 = 25;
        r5 = java.lang.String.valueOf(r30);
        r5 = r5.length();
        r4 = r4 + r5;
        r5 = new java.lang.StringBuilder;
        r5.<init>(r4);
        r4 = "Preload failed for URL \"";
        r5.append(r4);
        r5.append(r8);
        r4 = "\"";
        r5.append(r4);
        r4 = r5.toString();
        com.google.android.gms.internal.zzakb.m5369c(r4, r1);
    L_0x04b5:
        r1 = r11.exists();
        if (r1 == 0) goto L_0x04df;
    L_0x04bb:
        r1 = r11.delete();
        if (r1 != 0) goto L_0x04df;
    L_0x04c1:
        r1 = "Could not delete partial cache file at ";
        r4 = r11.getAbsolutePath();
        r4 = java.lang.String.valueOf(r4);
        r5 = r4.length();
        if (r5 == 0) goto L_0x04d6;
    L_0x04d1:
        r1 = r1.concat(r4);
        goto L_0x04dc;
    L_0x04d6:
        r4 = new java.lang.String;
        r4.<init>(r1);
        r1 = r4;
    L_0x04dc:
        com.google.android.gms.internal.zzakb.m5371e(r1);
    L_0x04df:
        r1 = r11.getAbsolutePath();
        r7.m13403a(r8, r1, r15, r3);
        r1 = f17576b;
        r1.remove(r2);
        r1 = 0;
        return r1;
    L_0x04ed:
        r0 = move-exception;
        r2 = r0;
        monitor-exit(r1);	 Catch:{ all -> 0x04ed }
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzang.a(java.lang.String):boolean");
    }
}
