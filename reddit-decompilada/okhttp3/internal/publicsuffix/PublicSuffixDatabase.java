package okhttp3.internal.publicsuffix;

import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.IDN;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.internal.Util;
import okio.GzipSource;
import okio.Okio;

public final class PublicSuffixDatabase {
    private static final String[] EMPTY_RULE = new String[0];
    private static final byte EXCEPTION_MARKER = (byte) 33;
    private static final String[] PREVAILING_RULE = new String[]{Operation.MULTIPLY};
    public static final String PUBLIC_SUFFIX_RESOURCE = "publicsuffixes.gz";
    private static final byte[] WILDCARD_LABEL = new byte[]{(byte) 42};
    private static final PublicSuffixDatabase instance = new PublicSuffixDatabase();
    private final AtomicBoolean listRead = new AtomicBoolean(false);
    private byte[] publicSuffixExceptionListBytes;
    private byte[] publicSuffixListBytes;
    private final CountDownLatch readCompleteLatch = new CountDownLatch(1);

    public static PublicSuffixDatabase get() {
        return instance;
    }

    public final String getEffectiveTldPlusOne(String str) {
        if (str == null) {
            throw new NullPointerException("domain == null");
        }
        String[] split = IDN.toUnicode(str).split("\\.");
        String[] findMatchingRule = findMatchingRule(split);
        if (split.length == findMatchingRule.length && findMatchingRule[0].charAt(0) != '!') {
            return null;
        }
        int length;
        if (findMatchingRule[0].charAt(0) == '!') {
            length = split.length - findMatchingRule.length;
        } else {
            length = split.length - (findMatchingRule.length + 1);
        }
        StringBuilder stringBuilder = new StringBuilder();
        str = str.split("\\.");
        for (length = 
/*
Method generation error in method: okhttp3.internal.publicsuffix.PublicSuffixDatabase.getEffectiveTldPlusOne(java.lang.String):java.lang.String
jadx.core.utils.exceptions.CodegenException: Error generate insn: PHI: (r0_7 'length' int) = (r0_4 'length' int), (r0_6 'length' int) binds: {(r0_4 'length' int)=B:11:0x0031, (r0_6 'length' int)=B:12:0x0035} in method: okhttp3.internal.publicsuffix.PublicSuffixDatabase.getEffectiveTldPlusOne(java.lang.String):java.lang.String
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

        private java.lang.String[] findMatchingRule(java.lang.String[] r8) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r7 = this;
            r0 = r7.listRead;
            r0 = r0.get();
            r1 = 0;
            r2 = 1;
            if (r0 != 0) goto L_0x0016;
        L_0x000a:
            r0 = r7.listRead;
            r0 = r0.compareAndSet(r1, r2);
            if (r0 == 0) goto L_0x0016;
        L_0x0012:
            r7.readTheListUninterruptibly();
            goto L_0x001b;
        L_0x0016:
            r0 = r7.readCompleteLatch;	 Catch:{ InterruptedException -> 0x001b }
            r0.await();	 Catch:{ InterruptedException -> 0x001b }
        L_0x001b:
            monitor-enter(r7);
            r0 = r7.publicSuffixListBytes;	 Catch:{ all -> 0x00bb }
            if (r0 != 0) goto L_0x0028;	 Catch:{ all -> 0x00bb }
        L_0x0020:
            r8 = new java.lang.IllegalStateException;	 Catch:{ all -> 0x00bb }
            r0 = "Unable to load publicsuffixes.gz resource from the classpath.";	 Catch:{ all -> 0x00bb }
            r8.<init>(r0);	 Catch:{ all -> 0x00bb }
            throw r8;	 Catch:{ all -> 0x00bb }
        L_0x0028:
            monitor-exit(r7);	 Catch:{ all -> 0x00bb }
            r0 = r8.length;
            r0 = new byte[r0][];
            r3 = r1;
        L_0x002d:
            r4 = r8.length;
            if (r3 >= r4) goto L_0x003d;
        L_0x0030:
            r4 = r8[r3];
            r5 = okhttp3.internal.Util.UTF_8;
            r4 = r4.getBytes(r5);
            r0[r3] = r4;
            r3 = r3 + 1;
            goto L_0x002d;
        L_0x003d:
            r8 = r1;
        L_0x003e:
            r3 = 0;
            r4 = r0.length;
            if (r8 >= r4) goto L_0x004e;
        L_0x0042:
            r4 = r7.publicSuffixListBytes;
            r4 = binarySearchBytes(r4, r0, r8);
            if (r4 == 0) goto L_0x004b;
        L_0x004a:
            goto L_0x004f;
        L_0x004b:
            r8 = r8 + 1;
            goto L_0x003e;
        L_0x004e:
            r4 = r3;
        L_0x004f:
            r8 = r0.length;
            if (r8 <= r2) goto L_0x006d;
        L_0x0052:
            r8 = r0.clone();
            r8 = (byte[][]) r8;
            r5 = r1;
        L_0x0059:
            r6 = r8.length;
            r6 = r6 - r2;
            if (r5 >= r6) goto L_0x006d;
        L_0x005d:
            r6 = WILDCARD_LABEL;
            r8[r5] = r6;
            r6 = r7.publicSuffixListBytes;
            r6 = binarySearchBytes(r6, r8, r5);
            if (r6 == 0) goto L_0x006a;
        L_0x0069:
            goto L_0x006e;
        L_0x006a:
            r5 = r5 + 1;
            goto L_0x0059;
        L_0x006d:
            r6 = r3;
        L_0x006e:
            if (r6 == 0) goto L_0x0080;
        L_0x0070:
            r8 = r0.length;
            r8 = r8 - r2;
            if (r1 >= r8) goto L_0x0080;
        L_0x0074:
            r8 = r7.publicSuffixExceptionListBytes;
            r8 = binarySearchBytes(r8, r0, r1);
            if (r8 == 0) goto L_0x007d;
        L_0x007c:
            goto L_0x0081;
        L_0x007d:
            r1 = r1 + 1;
            goto L_0x0070;
        L_0x0080:
            r8 = r3;
        L_0x0081:
            if (r8 == 0) goto L_0x0098;
        L_0x0083:
            r0 = new java.lang.StringBuilder;
            r1 = "!";
            r0.<init>(r1);
            r0.append(r8);
            r8 = r0.toString();
            r0 = "\\.";
            r8 = r8.split(r0);
            return r8;
        L_0x0098:
            if (r4 != 0) goto L_0x009f;
        L_0x009a:
            if (r6 != 0) goto L_0x009f;
        L_0x009c:
            r8 = PREVAILING_RULE;
            return r8;
        L_0x009f:
            if (r4 == 0) goto L_0x00a8;
        L_0x00a1:
            r8 = "\\.";
            r8 = r4.split(r8);
            goto L_0x00aa;
        L_0x00a8:
            r8 = EMPTY_RULE;
        L_0x00aa:
            if (r6 == 0) goto L_0x00b3;
        L_0x00ac:
            r0 = "\\.";
            r0 = r6.split(r0);
            goto L_0x00b5;
        L_0x00b3:
            r0 = EMPTY_RULE;
        L_0x00b5:
            r1 = r8.length;
            r2 = r0.length;
            if (r1 <= r2) goto L_0x00ba;
        L_0x00b9:
            return r8;
        L_0x00ba:
            return r0;
        L_0x00bb:
            r8 = move-exception;
            monitor-exit(r7);	 Catch:{ all -> 0x00bb }
            throw r8;
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.publicsuffix.PublicSuffixDatabase.findMatchingRule(java.lang.String[]):java.lang.String[]");
        }

        private static String binarySearchBytes(byte[] bArr, byte[][] bArr2, int i) {
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
                        return new String(bArr, i4, i6, Util.UTF_8);
                    } else {
                        i2 = i3 + 1;
                    }
                }
            }
            return null;
        }

        private void readTheListUninterruptibly() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r5 = this;
            r0 = 0;
        L_0x0001:
            r5.readTheList();	 Catch:{ InterruptedIOException -> 0x002f, IOException -> 0x0010 }
            if (r0 == 0) goto L_0x000d;
        L_0x0006:
            r0 = java.lang.Thread.currentThread();
            r0.interrupt();
        L_0x000d:
            return;
        L_0x000e:
            r1 = move-exception;
            goto L_0x0025;
        L_0x0010:
            r1 = move-exception;
            r2 = okhttp3.internal.platform.Platform.get();	 Catch:{ all -> 0x000e }
            r3 = 5;	 Catch:{ all -> 0x000e }
            r4 = "Failed to read public suffix list";	 Catch:{ all -> 0x000e }
            r2.log(r3, r4, r1);	 Catch:{ all -> 0x000e }
            if (r0 == 0) goto L_0x0024;
        L_0x001d:
            r0 = java.lang.Thread.currentThread();
            r0.interrupt();
        L_0x0024:
            return;
        L_0x0025:
            if (r0 == 0) goto L_0x002e;
        L_0x0027:
            r0 = java.lang.Thread.currentThread();
            r0.interrupt();
        L_0x002e:
            throw r1;
        L_0x002f:
            r0 = 1;
            goto L_0x0001;
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.publicsuffix.PublicSuffixDatabase.readTheListUninterruptibly():void");
        }

        private void readTheList() throws IOException {
            InputStream resourceAsStream = PublicSuffixDatabase.class.getResourceAsStream(PUBLIC_SUFFIX_RESOURCE);
            if (resourceAsStream != null) {
                Closeable a = Okio.m28289a(new GzipSource(Okio.m28295a(resourceAsStream)));
                try {
                    byte[] bArr = new byte[a.mo6778i()];
                    a.mo6757a(bArr);
                    byte[] bArr2 = new byte[a.mo6778i()];
                    a.mo6757a(bArr2);
                    synchronized (this) {
                        this.publicSuffixListBytes = bArr;
                        this.publicSuffixExceptionListBytes = bArr2;
                    }
                    this.readCompleteLatch.countDown();
                } finally {
                    Util.closeQuietly(a);
                }
            }
        }

        final void setListBytes(byte[] bArr, byte[] bArr2) {
            this.publicSuffixListBytes = bArr;
            this.publicSuffixExceptionListBytes = bArr2;
            this.listRead.set(1);
            this.readCompleteLatch.countDown();
        }
    }
