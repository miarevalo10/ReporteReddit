package com.google.android.gms.internal;

import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class zzal implements zzb {
    private final Map<String, zzam> f14131a;
    private long f14132b;
    private final File f14133c;
    private final int f14134d;

    private zzal(File file) {
        this.f14131a = new LinkedHashMap(16, 0.75f, true);
        this.f14132b = 0;
        this.f14133c = file;
        this.f14134d = 5242880;
    }

    public zzal(File file, byte b) {
        this(file);
    }

    static int m13309a(InputStream inputStream) throws IOException {
        return (m13320c(inputStream) << 24) | (((m13320c(inputStream) | 0) | (m13320c(inputStream) << 8)) | (m13320c(inputStream) << 16));
    }

    private static InputStream m13310a(File file) throws FileNotFoundException {
        return new FileInputStream(file);
    }

    static String m13311a(zzan com_google_android_gms_internal_zzan) throws IOException {
        return new String(m13316a(com_google_android_gms_internal_zzan, m13317b((InputStream) com_google_android_gms_internal_zzan)), "UTF-8");
    }

    static void m13312a(OutputStream outputStream, int i) throws IOException {
        outputStream.write(i & 255);
        outputStream.write((i >> 8) & 255);
        outputStream.write((i >> 16) & 255);
        outputStream.write(i >>> 24);
    }

    static void m13313a(OutputStream outputStream, long j) throws IOException {
        outputStream.write((byte) ((int) j));
        outputStream.write((byte) ((int) (j >>> 8)));
        outputStream.write((byte) ((int) (j >>> 16)));
        outputStream.write((byte) ((int) (j >>> 24)));
        outputStream.write((byte) ((int) (j >>> 32)));
        outputStream.write((byte) ((int) (j >>> 40)));
        outputStream.write((byte) ((int) (j >>> 48)));
        outputStream.write((byte) ((int) (j >>> 56)));
    }

    static void m13314a(OutputStream outputStream, String str) throws IOException {
        byte[] bytes = str.getBytes("UTF-8");
        m13313a(outputStream, (long) bytes.length);
        outputStream.write(bytes, 0, bytes.length);
    }

    private final void m13315a(String str, zzam com_google_android_gms_internal_zzam) {
        if (this.f14131a.containsKey(str)) {
            this.f14132b += com_google_android_gms_internal_zzam.f6531a - ((zzam) this.f14131a.get(str)).f6531a;
        } else {
            this.f14132b += com_google_android_gms_internal_zzam.f6531a;
        }
        this.f14131a.put(str, com_google_android_gms_internal_zzam);
    }

    private static byte[] m13316a(zzan com_google_android_gms_internal_zzan, long j) throws IOException {
        long a = com_google_android_gms_internal_zzan.m5431a();
        if (j >= 0 && j <= a) {
            int i = (int) j;
            if (((long) i) == j) {
                byte[] bArr = new byte[i];
                new DataInputStream(com_google_android_gms_internal_zzan).readFully(bArr);
                return bArr;
            }
        }
        StringBuilder stringBuilder = new StringBuilder(73);
        stringBuilder.append("streamToBytes length=");
        stringBuilder.append(j);
        stringBuilder.append(", maxLength=");
        stringBuilder.append(a);
        throw new IOException(stringBuilder.toString());
    }

    static long m13317b(InputStream inputStream) throws IOException {
        return ((((((((((long) m13320c(inputStream)) & 255) | 0) | ((((long) m13320c(inputStream)) & 255) << 8)) | ((((long) m13320c(inputStream)) & 255) << 16)) | ((((long) m13320c(inputStream)) & 255) << 24)) | ((((long) m13320c(inputStream)) & 255) << 32)) | ((((long) m13320c(inputStream)) & 255) << 40)) | ((((long) m13320c(inputStream)) & 255) << 48)) | ((255 & ((long) m13320c(inputStream))) << 56);
    }

    static List<zzl> m13318b(zzan com_google_android_gms_internal_zzan) throws IOException {
        int a = m13309a((InputStream) com_google_android_gms_internal_zzan);
        List<zzl> emptyList = a == 0 ? Collections.emptyList() : new ArrayList(a);
        for (int i = 0; i < a; i++) {
            emptyList.add(new zzl(m13311a(com_google_android_gms_internal_zzan).intern(), m13311a(com_google_android_gms_internal_zzan).intern()));
        }
        return emptyList;
    }

    private final synchronized void m13319b(String str) {
        boolean delete = m13322d(str).delete();
        m13323e(str);
        if (!delete) {
            zzae.m5043b("Could not delete cache entry for key=%s, filename=%s", str, m13321c(str));
        }
    }

    private static int m13320c(InputStream inputStream) throws IOException {
        int read = inputStream.read();
        if (read != -1) {
            return read;
        }
        throw new EOFException();
    }

    private static String m13321c(String str) {
        int length = str.length() / 2;
        String valueOf = String.valueOf(String.valueOf(str.substring(0, length).hashCode()));
        str = String.valueOf(String.valueOf(str.substring(length).hashCode()));
        return str.length() != 0 ? valueOf.concat(str) : new String(valueOf);
    }

    private final File m13322d(String str) {
        return new File(this.f14133c, m13321c(str));
    }

    private final void m13323e(String str) {
        zzam com_google_android_gms_internal_zzam = (zzam) this.f14131a.remove(str);
        if (com_google_android_gms_internal_zzam != null) {
            this.f14132b -= com_google_android_gms_internal_zzam.f6531a;
        }
    }

    public final synchronized zzc mo1733a(String str) {
        zzam com_google_android_gms_internal_zzam = (zzam) this.f14131a.get(str);
        if (com_google_android_gms_internal_zzam == null) {
            return null;
        }
        File d = m13322d(str);
        zzan com_google_android_gms_internal_zzan;
        try {
            com_google_android_gms_internal_zzan = new zzan(new BufferedInputStream(m13310a(d)), d.length());
            if (TextUtils.equals(str, zzam.m5405a(com_google_android_gms_internal_zzan).f6532b)) {
                byte[] a = m13316a(com_google_android_gms_internal_zzan, com_google_android_gms_internal_zzan.m5431a());
                zzc com_google_android_gms_internal_zzc = new zzc();
                com_google_android_gms_internal_zzc.f6721a = a;
                com_google_android_gms_internal_zzc.f6722b = com_google_android_gms_internal_zzam.f6533c;
                com_google_android_gms_internal_zzc.f6723c = com_google_android_gms_internal_zzam.f6534d;
                com_google_android_gms_internal_zzc.f6724d = com_google_android_gms_internal_zzam.f6535e;
                com_google_android_gms_internal_zzc.f6725e = com_google_android_gms_internal_zzam.f6536f;
                com_google_android_gms_internal_zzc.f6726f = com_google_android_gms_internal_zzam.f6537g;
                com_google_android_gms_internal_zzc.f6727g = zzao.m5470a(com_google_android_gms_internal_zzam.f6538h);
                com_google_android_gms_internal_zzc.f6728h = Collections.unmodifiableList(com_google_android_gms_internal_zzam.f6538h);
                com_google_android_gms_internal_zzan.close();
                return com_google_android_gms_internal_zzc;
            }
            zzae.m5043b("%s: key=%s, found=%s", d.getAbsolutePath(), str, zzam.m5405a(com_google_android_gms_internal_zzan).f6532b);
            m13323e(str);
            com_google_android_gms_internal_zzan.close();
            return null;
        } catch (IOException e) {
            zzae.m5043b("%s: %s", d.getAbsolutePath(), e.toString());
            m13319b(str);
            return null;
        } catch (Throwable th) {
            com_google_android_gms_internal_zzan.close();
        }
    }

    public final synchronized void mo1734a() {
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
        r9 = this;
        monitor-enter(r9);
        r0 = r9.f14133c;	 Catch:{ all -> 0x0061 }
        r0 = r0.exists();	 Catch:{ all -> 0x0061 }
        r1 = 0;	 Catch:{ all -> 0x0061 }
        if (r0 != 0) goto L_0x0024;	 Catch:{ all -> 0x0061 }
    L_0x000a:
        r0 = r9.f14133c;	 Catch:{ all -> 0x0061 }
        r0 = r0.mkdirs();	 Catch:{ all -> 0x0061 }
        if (r0 != 0) goto L_0x0022;	 Catch:{ all -> 0x0061 }
    L_0x0012:
        r0 = "Unable to create cache dir %s";	 Catch:{ all -> 0x0061 }
        r2 = 1;	 Catch:{ all -> 0x0061 }
        r2 = new java.lang.Object[r2];	 Catch:{ all -> 0x0061 }
        r3 = r9.f14133c;	 Catch:{ all -> 0x0061 }
        r3 = r3.getAbsolutePath();	 Catch:{ all -> 0x0061 }
        r2[r1] = r3;	 Catch:{ all -> 0x0061 }
        com.google.android.gms.internal.zzae.m5044c(r0, r2);	 Catch:{ all -> 0x0061 }
    L_0x0022:
        monitor-exit(r9);
        return;
    L_0x0024:
        r0 = r9.f14133c;	 Catch:{ all -> 0x0061 }
        r0 = r0.listFiles();	 Catch:{ all -> 0x0061 }
        if (r0 != 0) goto L_0x002e;
    L_0x002c:
        monitor-exit(r9);
        return;
    L_0x002e:
        r2 = r0.length;	 Catch:{ all -> 0x0061 }
    L_0x002f:
        if (r1 >= r2) goto L_0x005f;	 Catch:{ all -> 0x0061 }
    L_0x0031:
        r3 = r0[r1];	 Catch:{ all -> 0x0061 }
        r4 = r3.length();	 Catch:{ IOException -> 0x0059 }
        r6 = new com.google.android.gms.internal.zzan;	 Catch:{ IOException -> 0x0059 }
        r7 = new java.io.BufferedInputStream;	 Catch:{ IOException -> 0x0059 }
        r8 = m13310a(r3);	 Catch:{ IOException -> 0x0059 }
        r7.<init>(r8);	 Catch:{ IOException -> 0x0059 }
        r6.<init>(r7, r4);	 Catch:{ IOException -> 0x0059 }
        r7 = com.google.android.gms.internal.zzam.m5405a(r6);	 Catch:{ all -> 0x0054 }
        r7.f6531a = r4;	 Catch:{ all -> 0x0054 }
        r4 = r7.f6532b;	 Catch:{ all -> 0x0054 }
        r9.m13315a(r4, r7);	 Catch:{ all -> 0x0054 }
        r6.close();	 Catch:{ IOException -> 0x0059 }
        goto L_0x005c;	 Catch:{ IOException -> 0x0059 }
    L_0x0054:
        r4 = move-exception;	 Catch:{ IOException -> 0x0059 }
        r6.close();	 Catch:{ IOException -> 0x0059 }
        throw r4;	 Catch:{ IOException -> 0x0059 }
    L_0x0059:
        r3.delete();	 Catch:{ all -> 0x0061 }
    L_0x005c:
        r1 = r1 + 1;
        goto L_0x002f;
    L_0x005f:
        monitor-exit(r9);
        return;
    L_0x0061:
        r0 = move-exception;
        monitor-exit(r9);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzal.a():void");
    }

    public final synchronized void mo1735a(java.lang.String r20, com.google.android.gms.internal.zzc r21) {
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
        r19 = this;
        r1 = r19;
        r2 = r20;
        r3 = r21;
        monitor-enter(r19);
        r4 = r3.f6721a;	 Catch:{ all -> 0x0111 }
        r4 = r4.length;	 Catch:{ all -> 0x0111 }
        r5 = r1.f14132b;	 Catch:{ all -> 0x0111 }
        r7 = (long) r4;	 Catch:{ all -> 0x0111 }
        r5 = r5 + r7;	 Catch:{ all -> 0x0111 }
        r4 = r1.f14134d;	 Catch:{ all -> 0x0111 }
        r9 = (long) r4;	 Catch:{ all -> 0x0111 }
        r4 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1));	 Catch:{ all -> 0x0111 }
        r6 = 0;	 Catch:{ all -> 0x0111 }
        if (r4 < 0) goto L_0x00ba;	 Catch:{ all -> 0x0111 }
    L_0x0016:
        r4 = com.google.android.gms.internal.zzae.f6235a;	 Catch:{ all -> 0x0111 }
        if (r4 == 0) goto L_0x0021;	 Catch:{ all -> 0x0111 }
    L_0x001a:
        r4 = "Pruning old cache entries.";	 Catch:{ all -> 0x0111 }
        r9 = new java.lang.Object[r6];	 Catch:{ all -> 0x0111 }
        com.google.android.gms.internal.zzae.m5041a(r4, r9);	 Catch:{ all -> 0x0111 }
    L_0x0021:
        r9 = r1.f14132b;	 Catch:{ all -> 0x0111 }
        r11 = android.os.SystemClock.elapsedRealtime();	 Catch:{ all -> 0x0111 }
        r4 = r1.f14131a;	 Catch:{ all -> 0x0111 }
        r4 = r4.entrySet();	 Catch:{ all -> 0x0111 }
        r4 = r4.iterator();	 Catch:{ all -> 0x0111 }
        r13 = r6;	 Catch:{ all -> 0x0111 }
    L_0x0032:
        r14 = r4.hasNext();	 Catch:{ all -> 0x0111 }
        r15 = 2;	 Catch:{ all -> 0x0111 }
        if (r14 == 0) goto L_0x0090;	 Catch:{ all -> 0x0111 }
    L_0x0039:
        r14 = r4.next();	 Catch:{ all -> 0x0111 }
        r14 = (java.util.Map.Entry) r14;	 Catch:{ all -> 0x0111 }
        r14 = r14.getValue();	 Catch:{ all -> 0x0111 }
        r14 = (com.google.android.gms.internal.zzam) r14;	 Catch:{ all -> 0x0111 }
        r5 = r14.f6532b;	 Catch:{ all -> 0x0111 }
        r5 = r1.m13322d(r5);	 Catch:{ all -> 0x0111 }
        r5 = r5.delete();	 Catch:{ all -> 0x0111 }
        if (r5 == 0) goto L_0x005b;	 Catch:{ all -> 0x0111 }
    L_0x0051:
        r16 = r7;	 Catch:{ all -> 0x0111 }
        r6 = r1.f14132b;	 Catch:{ all -> 0x0111 }
        r2 = r14.f6531a;	 Catch:{ all -> 0x0111 }
        r6 = r6 - r2;	 Catch:{ all -> 0x0111 }
        r1.f14132b = r6;	 Catch:{ all -> 0x0111 }
        goto L_0x0072;	 Catch:{ all -> 0x0111 }
    L_0x005b:
        r16 = r7;	 Catch:{ all -> 0x0111 }
        r2 = "Could not delete cache entry for key=%s, filename=%s";	 Catch:{ all -> 0x0111 }
        r3 = new java.lang.Object[r15];	 Catch:{ all -> 0x0111 }
        r5 = r14.f6532b;	 Catch:{ all -> 0x0111 }
        r6 = 0;	 Catch:{ all -> 0x0111 }
        r3[r6] = r5;	 Catch:{ all -> 0x0111 }
        r5 = r14.f6532b;	 Catch:{ all -> 0x0111 }
        r5 = m13321c(r5);	 Catch:{ all -> 0x0111 }
        r6 = 1;	 Catch:{ all -> 0x0111 }
        r3[r6] = r5;	 Catch:{ all -> 0x0111 }
        com.google.android.gms.internal.zzae.m5043b(r2, r3);	 Catch:{ all -> 0x0111 }
    L_0x0072:
        r4.remove();	 Catch:{ all -> 0x0111 }
        r13 = r13 + 1;	 Catch:{ all -> 0x0111 }
        r2 = r1.f14132b;	 Catch:{ all -> 0x0111 }
        r2 = r2 + r16;	 Catch:{ all -> 0x0111 }
        r2 = (float) r2;	 Catch:{ all -> 0x0111 }
        r3 = r1.f14134d;	 Catch:{ all -> 0x0111 }
        r3 = (float) r3;	 Catch:{ all -> 0x0111 }
        r5 = 1063675494; // 0x3f666666 float:0.9 double:5.2552552E-315;	 Catch:{ all -> 0x0111 }
        r3 = r3 * r5;	 Catch:{ all -> 0x0111 }
        r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1));	 Catch:{ all -> 0x0111 }
        if (r2 >= 0) goto L_0x0088;	 Catch:{ all -> 0x0111 }
    L_0x0087:
        goto L_0x0090;	 Catch:{ all -> 0x0111 }
    L_0x0088:
        r7 = r16;	 Catch:{ all -> 0x0111 }
        r2 = r20;	 Catch:{ all -> 0x0111 }
        r3 = r21;	 Catch:{ all -> 0x0111 }
        r6 = 0;	 Catch:{ all -> 0x0111 }
        goto L_0x0032;	 Catch:{ all -> 0x0111 }
    L_0x0090:
        r2 = com.google.android.gms.internal.zzae.f6235a;	 Catch:{ all -> 0x0111 }
        if (r2 == 0) goto L_0x00b8;	 Catch:{ all -> 0x0111 }
    L_0x0094:
        r2 = "pruned %d files, %d bytes, %d ms";	 Catch:{ all -> 0x0111 }
        r3 = 3;	 Catch:{ all -> 0x0111 }
        r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x0111 }
        r4 = java.lang.Integer.valueOf(r13);	 Catch:{ all -> 0x0111 }
        r5 = 0;	 Catch:{ all -> 0x0111 }
        r3[r5] = r4;	 Catch:{ all -> 0x0111 }
        r4 = r1.f14132b;	 Catch:{ all -> 0x0111 }
        r4 = r4 - r9;	 Catch:{ all -> 0x0111 }
        r4 = java.lang.Long.valueOf(r4);	 Catch:{ all -> 0x0111 }
        r5 = 1;	 Catch:{ all -> 0x0111 }
        r3[r5] = r4;	 Catch:{ all -> 0x0111 }
        r4 = android.os.SystemClock.elapsedRealtime();	 Catch:{ all -> 0x0111 }
        r4 = r4 - r11;	 Catch:{ all -> 0x0111 }
        r4 = java.lang.Long.valueOf(r4);	 Catch:{ all -> 0x0111 }
        r3[r15] = r4;	 Catch:{ all -> 0x0111 }
        com.google.android.gms.internal.zzae.m5041a(r2, r3);	 Catch:{ all -> 0x0111 }
    L_0x00b8:
        r2 = r20;	 Catch:{ all -> 0x0111 }
    L_0x00ba:
        r3 = r19.m13322d(r20);	 Catch:{ all -> 0x0111 }
        r4 = new java.io.BufferedOutputStream;	 Catch:{ IOException -> 0x00fa }
        r5 = new java.io.FileOutputStream;	 Catch:{ IOException -> 0x00fa }
        r5.<init>(r3);	 Catch:{ IOException -> 0x00fa }
        r4.<init>(r5);	 Catch:{ IOException -> 0x00fa }
        r5 = new com.google.android.gms.internal.zzam;	 Catch:{ IOException -> 0x00fa }
        r6 = r21;	 Catch:{ IOException -> 0x00fa }
        r5.<init>(r2, r6);	 Catch:{ IOException -> 0x00fa }
        r7 = r5.m5406a(r4);	 Catch:{ IOException -> 0x00fa }
        if (r7 != 0) goto L_0x00ed;	 Catch:{ IOException -> 0x00fa }
    L_0x00d5:
        r4.close();	 Catch:{ IOException -> 0x00fa }
        r2 = "Failed to write header for %s";	 Catch:{ IOException -> 0x00fa }
        r4 = 1;	 Catch:{ IOException -> 0x00fa }
        r5 = new java.lang.Object[r4];	 Catch:{ IOException -> 0x00fa }
        r4 = r3.getAbsolutePath();	 Catch:{ IOException -> 0x00fa }
        r6 = 0;	 Catch:{ IOException -> 0x00fa }
        r5[r6] = r4;	 Catch:{ IOException -> 0x00fa }
        com.google.android.gms.internal.zzae.m5043b(r2, r5);	 Catch:{ IOException -> 0x00fa }
        r2 = new java.io.IOException;	 Catch:{ IOException -> 0x00fa }
        r2.<init>();	 Catch:{ IOException -> 0x00fa }
        throw r2;	 Catch:{ IOException -> 0x00fa }
    L_0x00ed:
        r6 = r6.f6721a;	 Catch:{ IOException -> 0x00fa }
        r4.write(r6);	 Catch:{ IOException -> 0x00fa }
        r4.close();	 Catch:{ IOException -> 0x00fa }
        r1.m13315a(r2, r5);	 Catch:{ IOException -> 0x00fa }
        monitor-exit(r19);
        return;
    L_0x00fa:
        r2 = r3.delete();	 Catch:{ all -> 0x0111 }
        if (r2 != 0) goto L_0x010f;	 Catch:{ all -> 0x0111 }
    L_0x0100:
        r2 = "Could not clean up file %s";	 Catch:{ all -> 0x0111 }
        r4 = 1;	 Catch:{ all -> 0x0111 }
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x0111 }
        r3 = r3.getAbsolutePath();	 Catch:{ all -> 0x0111 }
        r5 = 0;	 Catch:{ all -> 0x0111 }
        r4[r5] = r3;	 Catch:{ all -> 0x0111 }
        com.google.android.gms.internal.zzae.m5043b(r2, r4);	 Catch:{ all -> 0x0111 }
    L_0x010f:
        monitor-exit(r19);
        return;
    L_0x0111:
        r0 = move-exception;
        r2 = r0;
        monitor-exit(r19);
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzal.a(java.lang.String, com.google.android.gms.internal.zzc):void");
    }
}
