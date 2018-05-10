package com.sendbird.android.shadow.okhttp3.internal.publicsuffix;

import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import com.sendbird.android.shadow.okhttp3.internal.Util;
import java.net.IDN;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

public final class PublicSuffixDatabase {
    private static final byte[] f23550a = new byte[]{(byte) 42};
    private static final String[] f23551b = new String[0];
    private static final String[] f23552c = new String[]{Operation.MULTIPLY};
    private static final PublicSuffixDatabase f23553d = new PublicSuffixDatabase();
    private final AtomicBoolean f23554e = new AtomicBoolean(false);
    private final CountDownLatch f23555f = new CountDownLatch(1);
    private byte[] f23556g;
    private byte[] f23557h;

    public static PublicSuffixDatabase m25561a() {
        return f23553d;
    }

    public final String m25564a(String str) {
        if (str == null) {
            throw new NullPointerException("domain == null");
        }
        String[] split = IDN.toUnicode(str).split("\\.");
        String[] a = m25563a(split);
        if (split.length == a.length && a[0].charAt(0) != '!') {
            return null;
        }
        int length;
        if (a[0].charAt(0) == '!') {
            length = split.length - a.length;
        } else {
            length = split.length - (a.length + 1);
        }
        StringBuilder stringBuilder = new StringBuilder();
        str = str.split("\\.");
        for (length = 
/*
Method generation error in method: com.sendbird.android.shadow.okhttp3.internal.publicsuffix.PublicSuffixDatabase.a(java.lang.String):java.lang.String
jadx.core.utils.exceptions.CodegenException: Error generate insn: PHI: (r0_7 'length' int) = (r0_4 'length' int), (r0_6 'length' int) binds: {(r0_4 'length' int)=B:11:0x0031, (r0_6 'length' int)=B:12:0x0035} in method: com.sendbird.android.shadow.okhttp3.internal.publicsuffix.PublicSuffixDatabase.a(java.lang.String):java.lang.String
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:226)
	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:184)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:61)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:183)
	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:328)
	at jadx.core.codegen.ClassGen.addMethods(ClassGen.java:265)
	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:228)
	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:118)
	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:83)
	at jadx.core.codegen.CodeGen.visit(CodeGen.java:19)
	at jadx.core.ProcessClass.process(ProcessClass.java:43)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
Caused by: jadx.core.utils.exceptions.CodegenException: PHI can be used only in fallback mode
	at jadx.core.codegen.InsnGen.fallbackOnlyInsn(InsnGen.java:530)
	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:514)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
	... 23 more

*/

        private java.lang.String[] m25563a(java.lang.String[] r8) {
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
            r0 = r7.f23554e;
            r0 = r0.get();
            r1 = 0;
            r2 = 1;
            if (r0 != 0) goto L_0x0079;
        L_0x000a:
            r0 = r7.f23554e;
            r0 = r0.compareAndSet(r1, r2);
            if (r0 == 0) goto L_0x0079;
        L_0x0012:
            r0 = r1;
        L_0x0013:
            r3 = com.sendbird.android.shadow.okhttp3.internal.publicsuffix.PublicSuffixDatabase.class;	 Catch:{ InterruptedIOException -> 0x0077, IOException -> 0x005f }
            r4 = "publicsuffixes.gz";	 Catch:{ InterruptedIOException -> 0x0077, IOException -> 0x005f }
            r3 = r3.getResourceAsStream(r4);	 Catch:{ InterruptedIOException -> 0x0077, IOException -> 0x005f }
            if (r3 == 0) goto L_0x0053;	 Catch:{ InterruptedIOException -> 0x0077, IOException -> 0x005f }
        L_0x001d:
            r4 = new com.sendbird.android.shadow.okio.GzipSource;	 Catch:{ InterruptedIOException -> 0x0077, IOException -> 0x005f }
            r3 = com.sendbird.android.shadow.okio.Okio.m25621a(r3);	 Catch:{ InterruptedIOException -> 0x0077, IOException -> 0x005f }
            r4.<init>(r3);	 Catch:{ InterruptedIOException -> 0x0077, IOException -> 0x005f }
            r3 = com.sendbird.android.shadow.okio.Okio.m25615a(r4);	 Catch:{ InterruptedIOException -> 0x0077, IOException -> 0x005f }
            r4 = r3.mo6569h();	 Catch:{ all -> 0x004e }
            r4 = new byte[r4];	 Catch:{ all -> 0x004e }
            r3.mo6551a(r4);	 Catch:{ all -> 0x004e }
            r5 = r3.mo6569h();	 Catch:{ all -> 0x004e }
            r5 = new byte[r5];	 Catch:{ all -> 0x004e }
            r3.mo6551a(r5);	 Catch:{ all -> 0x004e }
            com.sendbird.android.shadow.okhttp3.internal.Util.m25366a(r3);	 Catch:{ InterruptedIOException -> 0x0077, IOException -> 0x005f }
            monitor-enter(r7);	 Catch:{ InterruptedIOException -> 0x0077, IOException -> 0x005f }
            r7.f23556g = r4;	 Catch:{ all -> 0x004b }
            r7.f23557h = r5;	 Catch:{ all -> 0x004b }
            monitor-exit(r7);	 Catch:{ all -> 0x004b }
            r3 = r7.f23555f;	 Catch:{ InterruptedIOException -> 0x0077, IOException -> 0x005f }
            r3.countDown();	 Catch:{ InterruptedIOException -> 0x0077, IOException -> 0x005f }
            goto L_0x0053;
        L_0x004b:
            r3 = move-exception;
            monitor-exit(r7);	 Catch:{ all -> 0x004b }
            throw r3;	 Catch:{ InterruptedIOException -> 0x0077, IOException -> 0x005f }
        L_0x004e:
            r4 = move-exception;	 Catch:{ InterruptedIOException -> 0x0077, IOException -> 0x005f }
            com.sendbird.android.shadow.okhttp3.internal.Util.m25366a(r3);	 Catch:{ InterruptedIOException -> 0x0077, IOException -> 0x005f }
            throw r4;	 Catch:{ InterruptedIOException -> 0x0077, IOException -> 0x005f }
        L_0x0053:
            if (r0 == 0) goto L_0x007e;
        L_0x0055:
            r0 = java.lang.Thread.currentThread();
            r0.interrupt();
            goto L_0x007e;
        L_0x005d:
            r8 = move-exception;
            goto L_0x006d;
        L_0x005f:
            r3 = move-exception;
            r4 = com.sendbird.android.shadow.okhttp3.internal.platform.Platform.m25549b();	 Catch:{ all -> 0x005d }
            r5 = 5;	 Catch:{ all -> 0x005d }
            r6 = "Failed to read public suffix list";	 Catch:{ all -> 0x005d }
            r4.mo5370a(r5, r6, r3);	 Catch:{ all -> 0x005d }
            if (r0 == 0) goto L_0x007e;
        L_0x006c:
            goto L_0x0055;
        L_0x006d:
            if (r0 == 0) goto L_0x0076;
        L_0x006f:
            r0 = java.lang.Thread.currentThread();
            r0.interrupt();
        L_0x0076:
            throw r8;
        L_0x0077:
            r0 = r2;
            goto L_0x0013;
        L_0x0079:
            r0 = r7.f23555f;	 Catch:{ InterruptedException -> 0x007e }
            r0.await();	 Catch:{ InterruptedException -> 0x007e }
        L_0x007e:
            monitor-enter(r7);
            r0 = r7.f23556g;	 Catch:{ all -> 0x011e }
            if (r0 != 0) goto L_0x008b;	 Catch:{ all -> 0x011e }
        L_0x0083:
            r8 = new java.lang.IllegalStateException;	 Catch:{ all -> 0x011e }
            r0 = "Unable to load publicsuffixes.gz resource from the classpath.";	 Catch:{ all -> 0x011e }
            r8.<init>(r0);	 Catch:{ all -> 0x011e }
            throw r8;	 Catch:{ all -> 0x011e }
        L_0x008b:
            monitor-exit(r7);	 Catch:{ all -> 0x011e }
            r0 = r8.length;
            r0 = new byte[r0][];
            r3 = r1;
        L_0x0090:
            r4 = r8.length;
            if (r3 >= r4) goto L_0x00a0;
        L_0x0093:
            r4 = r8[r3];
            r5 = com.sendbird.android.shadow.okhttp3.internal.Util.f23338e;
            r4 = r4.getBytes(r5);
            r0[r3] = r4;
            r3 = r3 + 1;
            goto L_0x0090;
        L_0x00a0:
            r8 = r1;
        L_0x00a1:
            r3 = 0;
            r4 = r0.length;
            if (r8 >= r4) goto L_0x00b1;
        L_0x00a5:
            r4 = r7.f23556g;
            r4 = m25562a(r4, r0, r8);
            if (r4 == 0) goto L_0x00ae;
        L_0x00ad:
            goto L_0x00b2;
        L_0x00ae:
            r8 = r8 + 1;
            goto L_0x00a1;
        L_0x00b1:
            r4 = r3;
        L_0x00b2:
            r8 = r0.length;
            if (r8 <= r2) goto L_0x00d0;
        L_0x00b5:
            r8 = r0.clone();
            r8 = (byte[][]) r8;
            r5 = r1;
        L_0x00bc:
            r6 = r8.length;
            r6 = r6 - r2;
            if (r5 >= r6) goto L_0x00d0;
        L_0x00c0:
            r6 = f23550a;
            r8[r5] = r6;
            r6 = r7.f23556g;
            r6 = m25562a(r6, r8, r5);
            if (r6 == 0) goto L_0x00cd;
        L_0x00cc:
            goto L_0x00d1;
        L_0x00cd:
            r5 = r5 + 1;
            goto L_0x00bc;
        L_0x00d0:
            r6 = r3;
        L_0x00d1:
            if (r6 == 0) goto L_0x00e3;
        L_0x00d3:
            r8 = r0.length;
            r8 = r8 - r2;
            if (r1 >= r8) goto L_0x00e3;
        L_0x00d7:
            r8 = r7.f23557h;
            r8 = m25562a(r8, r0, r1);
            if (r8 == 0) goto L_0x00e0;
        L_0x00df:
            goto L_0x00e4;
        L_0x00e0:
            r1 = r1 + 1;
            goto L_0x00d3;
        L_0x00e3:
            r8 = r3;
        L_0x00e4:
            if (r8 == 0) goto L_0x00fb;
        L_0x00e6:
            r0 = new java.lang.StringBuilder;
            r1 = "!";
            r0.<init>(r1);
            r0.append(r8);
            r8 = r0.toString();
            r0 = "\\.";
            r8 = r8.split(r0);
            return r8;
        L_0x00fb:
            if (r4 != 0) goto L_0x0102;
        L_0x00fd:
            if (r6 != 0) goto L_0x0102;
        L_0x00ff:
            r8 = f23552c;
            return r8;
        L_0x0102:
            if (r4 == 0) goto L_0x010b;
        L_0x0104:
            r8 = "\\.";
            r8 = r4.split(r8);
            goto L_0x010d;
        L_0x010b:
            r8 = f23551b;
        L_0x010d:
            if (r6 == 0) goto L_0x0116;
        L_0x010f:
            r0 = "\\.";
            r0 = r6.split(r0);
            goto L_0x0118;
        L_0x0116:
            r0 = f23551b;
        L_0x0118:
            r1 = r8.length;
            r2 = r0.length;
            if (r1 <= r2) goto L_0x011d;
        L_0x011c:
            return r8;
        L_0x011d:
            return r0;
        L_0x011e:
            r8 = move-exception;
            monitor-exit(r7);	 Catch:{ all -> 0x011e }
            throw r8;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.okhttp3.internal.publicsuffix.PublicSuffixDatabase.a(java.lang.String[]):java.lang.String[]");
        }

        private static String m25562a(byte[] bArr, byte[][] bArr2, int i) {
            int length = bArr.length;
            int i2 = 0;
            while (i2 < length) {
                int i3;
                int i4 = (i2 + length) / 2;
                while (i4 >= 0 && bArr[i4] != (byte) 10) {
                    i4--;
                }
                i4++;
                int i5 = 1;
                while (true) {
                    i3 = i4 + i5;
                    if (bArr[i3] == (byte) 10) {
                        break;
                    }
                    i5++;
                }
                int i6 = i3 - i4;
                int i7 = i;
                i5 = 0;
                int i8 = i5;
                int i9 = i8;
                while (true) {
                    int i10;
                    if (i5 != 0) {
                        i10 = 46;
                        i5 = 0;
                    } else {
                        i10 = bArr2[i7][i8] & 255;
                    }
                    i10 -= bArr[i4 + i9] & 255;
                    if (i10 != 0) {
                        break;
                    }
                    i9++;
                    i8++;
                    if (i9 != i6) {
                        if (bArr2[i7].length == i8) {
                            if (i7 == bArr2.length - 1) {
                                break;
                            }
                            i7++;
                            i8 = -1;
                            i5 = 1;
                        }
                    } else {
                        break;
                    }
                }
                if (i10 < 0) {
                    length = i4 - 1;
                } else if (i10 > 0) {
                    i2 = i3 + 1;
                } else {
                    int i11 = i6 - i9;
                    i5 = bArr2[i7].length - i8;
                    while (true) {
                        i7++;
                        if (i7 >= bArr2.length) {
                            break;
                        }
                        i5 += bArr2[i7].length;
                    }
                    if (i5 < i11) {
                        length = i4 - 1;
                    } else if (i5 <= i11) {
                        return new String(bArr, i4, i6, Util.f23338e);
                    } else {
                        i2 = i3 + 1;
                    }
                }
            }
            return null;
        }
    }
