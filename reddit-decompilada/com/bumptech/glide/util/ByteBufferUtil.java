package com.bumptech.glide.util;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicReference;

public final class ByteBufferUtil {
    private static final AtomicReference<byte[]> f3662a = new AtomicReference();

    private static class ByteBufferStream extends InputStream {
        private final ByteBuffer f3657a;
        private int f3658b = -1;

        public boolean markSupported() {
            return true;
        }

        ByteBufferStream(ByteBuffer byteBuffer) {
            this.f3657a = byteBuffer;
        }

        public int available() {
            return this.f3657a.remaining();
        }

        public int read() {
            if (this.f3657a.hasRemaining()) {
                return this.f3657a.get();
            }
            return -1;
        }

        public synchronized void mark(int i) {
            this.f3658b = this.f3657a.position();
        }

        public int read(byte[] bArr, int i, int i2) throws IOException {
            if (!this.f3657a.hasRemaining()) {
                return -1;
            }
            i2 = Math.min(i2, available());
            this.f3657a.get(bArr, i, i2);
            return i2;
        }

        public synchronized void reset() throws IOException {
            if (this.f3658b == -1) {
                throw new IOException("Cannot reset to unset mark position");
            }
            this.f3657a.position(this.f3658b);
        }

        public long skip(long j) throws IOException {
            if (!this.f3657a.hasRemaining()) {
                return -1;
            }
            j = Math.min(j, (long) available());
            this.f3657a.position((int) (((long) this.f3657a.position()) + j));
            return j;
        }
    }

    static final class SafeArray {
        final int f3659a;
        final int f3660b;
        final byte[] f3661c;

        SafeArray(byte[] bArr, int i, int i2) {
            this.f3661c = bArr;
            this.f3659a = i;
            this.f3660b = i2;
        }
    }

    public static java.nio.ByteBuffer m3204a(java.io.File r9) throws java.io.IOException {
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
        r0 = 0;
        r5 = r9.length();	 Catch:{ all -> 0x004a }
        r1 = 2147483647; // 0x7fffffff float:NaN double:1.060997895E-314;	 Catch:{ all -> 0x004a }
        r1 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1));	 Catch:{ all -> 0x004a }
        if (r1 <= 0) goto L_0x0014;	 Catch:{ all -> 0x004a }
    L_0x000c:
        r9 = new java.io.IOException;	 Catch:{ all -> 0x004a }
        r1 = "File too large to map into memory";	 Catch:{ all -> 0x004a }
        r9.<init>(r1);	 Catch:{ all -> 0x004a }
        throw r9;	 Catch:{ all -> 0x004a }
    L_0x0014:
        r1 = 0;	 Catch:{ all -> 0x004a }
        r1 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1));	 Catch:{ all -> 0x004a }
        if (r1 != 0) goto L_0x0022;	 Catch:{ all -> 0x004a }
    L_0x001a:
        r9 = new java.io.IOException;	 Catch:{ all -> 0x004a }
        r1 = "File unsuitable for memory mapping";	 Catch:{ all -> 0x004a }
        r9.<init>(r1);	 Catch:{ all -> 0x004a }
        throw r9;	 Catch:{ all -> 0x004a }
    L_0x0022:
        r7 = new java.io.RandomAccessFile;	 Catch:{ all -> 0x004a }
        r1 = "r";	 Catch:{ all -> 0x004a }
        r7.<init>(r9, r1);	 Catch:{ all -> 0x004a }
        r9 = r7.getChannel();	 Catch:{ all -> 0x0048 }
        r2 = java.nio.channels.FileChannel.MapMode.READ_ONLY;	 Catch:{ all -> 0x0043 }
        r3 = 0;	 Catch:{ all -> 0x0043 }
        r1 = r9;	 Catch:{ all -> 0x0043 }
        r0 = r1.map(r2, r3, r5);	 Catch:{ all -> 0x0043 }
        r0 = r0.load();	 Catch:{ all -> 0x0043 }
        if (r9 == 0) goto L_0x003f;
    L_0x003c:
        r9.close();	 Catch:{ IOException -> 0x003f }
    L_0x003f:
        r7.close();	 Catch:{ IOException -> 0x0042 }
    L_0x0042:
        return r0;
    L_0x0043:
        r0 = move-exception;
        r8 = r0;
        r0 = r9;
        r9 = r8;
        goto L_0x004c;
    L_0x0048:
        r9 = move-exception;
        goto L_0x004c;
    L_0x004a:
        r9 = move-exception;
        r7 = r0;
    L_0x004c:
        if (r0 == 0) goto L_0x0051;
    L_0x004e:
        r0.close();	 Catch:{ IOException -> 0x0051 }
    L_0x0051:
        if (r7 == 0) goto L_0x0056;
    L_0x0053:
        r7.close();	 Catch:{ IOException -> 0x0056 }
    L_0x0056:
        throw r9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.util.ByteBufferUtil.a(java.io.File):java.nio.ByteBuffer");
    }

    public static void m3205a(java.nio.ByteBuffer r4, java.io.File r5) throws java.io.IOException {
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
        r0 = 0;
        r4.position(r0);
        r1 = 0;
        r2 = new java.io.RandomAccessFile;	 Catch:{ all -> 0x002a }
        r3 = "rw";	 Catch:{ all -> 0x002a }
        r2.<init>(r5, r3);	 Catch:{ all -> 0x002a }
        r5 = r2.getChannel();	 Catch:{ all -> 0x0027 }
        r5.write(r4);	 Catch:{ all -> 0x0025 }
        r5.force(r0);	 Catch:{ all -> 0x0025 }
        r5.close();	 Catch:{ all -> 0x0025 }
        r2.close();	 Catch:{ all -> 0x0025 }
        if (r5 == 0) goto L_0x0021;
    L_0x001e:
        r5.close();	 Catch:{ IOException -> 0x0021 }
    L_0x0021:
        r2.close();	 Catch:{ IOException -> 0x0024 }
    L_0x0024:
        return;
    L_0x0025:
        r4 = move-exception;
        goto L_0x002d;
    L_0x0027:
        r4 = move-exception;
        r5 = r1;
        goto L_0x002d;
    L_0x002a:
        r4 = move-exception;
        r5 = r1;
        r2 = r5;
    L_0x002d:
        if (r5 == 0) goto L_0x0032;
    L_0x002f:
        r5.close();	 Catch:{ IOException -> 0x0032 }
    L_0x0032:
        if (r2 == 0) goto L_0x0037;
    L_0x0034:
        r2.close();	 Catch:{ IOException -> 0x0037 }
    L_0x0037:
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.util.ByteBufferUtil.a(java.nio.ByteBuffer, java.io.File):void");
    }

    public static InputStream m3207b(ByteBuffer byteBuffer) {
        return new ByteBufferStream(byteBuffer);
    }

    public static byte[] m3206a(ByteBuffer byteBuffer) {
        SafeArray safeArray = (byteBuffer.isReadOnly() || !byteBuffer.hasArray()) ? null : new SafeArray(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.limit());
        if (safeArray != null && safeArray.f3659a == 0 && safeArray.f3660b == safeArray.f3661c.length) {
            return byteBuffer.array();
        }
        byteBuffer = byteBuffer.asReadOnlyBuffer();
        byte[] bArr = new byte[byteBuffer.limit()];
        byteBuffer.position(0);
        byteBuffer.get(bArr);
        return bArr;
    }
}
