package com.bumptech.glide.load.resource.bitmap;

import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class RecyclableBufferedInputStream extends FilterInputStream {
    private volatile byte[] f3543a;
    private int f3544b;
    private int f3545c;
    private int f3546d;
    private int f3547e;
    private final ArrayPool f3548f;

    static class InvalidMarkException extends IOException {
        InvalidMarkException(String str) {
            super(str);
        }
    }

    public boolean markSupported() {
        return true;
    }

    public RecyclableBufferedInputStream(InputStream inputStream, ArrayPool arrayPool) {
        this(inputStream, arrayPool, (byte) 0);
    }

    private RecyclableBufferedInputStream(InputStream inputStream, ArrayPool arrayPool, byte b) {
        super(inputStream);
        this.f3546d = -1;
        this.f3548f = arrayPool;
        this.f3543a = (byte[]) arrayPool.mo946a((byte) 0, byte[].class);
    }

    public synchronized int available() throws IOException {
        InputStream inputStream;
        inputStream = this.in;
        if (this.f3543a != null) {
            if (inputStream != null) {
            }
        }
        throw m3047c();
        return (this.f3544b - this.f3547e) + inputStream.available();
    }

    private static IOException m3047c() throws IOException {
        throw new IOException("BufferedInputStream is closed");
    }

    public final synchronized void m3048a() {
        this.f3545c = this.f3543a.length;
    }

    public final synchronized void m3049b() {
        if (this.f3543a != null) {
            this.f3548f.mo950a(this.f3543a);
            this.f3543a = null;
        }
    }

    public void close() throws IOException {
        if (this.f3543a != null) {
            this.f3548f.mo950a(this.f3543a);
            this.f3543a = null;
        }
        InputStream inputStream = this.in;
        this.in = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    private int m3046a(InputStream inputStream, byte[] bArr) throws IOException {
        if (this.f3546d != -1) {
            if (this.f3547e - this.f3546d < this.f3545c) {
                if (this.f3546d == 0 && this.f3545c > bArr.length && this.f3544b == bArr.length) {
                    int length = bArr.length * 2;
                    if (length > this.f3545c) {
                        length = this.f3545c;
                    }
                    byte[] bArr2 = (byte[]) this.f3548f.mo946a(length, byte[].class);
                    System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                    this.f3543a = bArr2;
                    this.f3548f.mo950a((Object) bArr);
                    bArr = bArr2;
                } else if (this.f3546d > 0) {
                    System.arraycopy(bArr, this.f3546d, bArr, 0, bArr.length - this.f3546d);
                }
                this.f3547e -= this.f3546d;
                this.f3546d = 0;
                this.f3544b = 0;
                inputStream = inputStream.read(bArr, this.f3547e, bArr.length - this.f3547e);
                if (inputStream <= null) {
                    bArr = this.f3547e;
                } else {
                    bArr = this.f3547e + inputStream;
                }
                this.f3544b = bArr;
                return inputStream;
            }
        }
        inputStream = inputStream.read(bArr);
        if (inputStream > null) {
            this.f3546d = -1;
            this.f3547e = 0;
            this.f3544b = inputStream;
        }
        return inputStream;
    }

    public synchronized void mark(int i) {
        this.f3545c = Math.max(this.f3545c, i);
        this.f3546d = this.f3547e;
    }

    public synchronized int read() throws IOException {
        byte[] bArr = this.f3543a;
        InputStream inputStream = this.in;
        if (bArr != null) {
            if (inputStream != null) {
                if (this.f3547e >= this.f3544b && m3046a(inputStream, bArr) == -1) {
                    return -1;
                }
                if (bArr != this.f3543a) {
                    bArr = this.f3543a;
                    if (bArr == null) {
                        throw m3047c();
                    }
                }
                if (this.f3544b - this.f3547e <= 0) {
                    return -1;
                }
                int i = this.f3547e;
                this.f3547e = i + 1;
                return bArr[i] & 255;
            }
        }
        throw m3047c();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized int read(byte[] r6, int r7, int r8) throws java.io.IOException {
        /*
        r5 = this;
        monitor-enter(r5);
        r0 = r5.f3543a;	 Catch:{ all -> 0x009d }
        if (r0 != 0) goto L_0x000a;
    L_0x0005:
        r6 = m3047c();	 Catch:{ all -> 0x009d }
        throw r6;	 Catch:{ all -> 0x009d }
    L_0x000a:
        if (r8 != 0) goto L_0x000f;
    L_0x000c:
        r6 = 0;
        monitor-exit(r5);
        return r6;
    L_0x000f:
        r1 = r5.in;	 Catch:{ all -> 0x009d }
        if (r1 != 0) goto L_0x0018;
    L_0x0013:
        r6 = m3047c();	 Catch:{ all -> 0x009d }
        throw r6;	 Catch:{ all -> 0x009d }
    L_0x0018:
        r2 = r5.f3547e;	 Catch:{ all -> 0x009d }
        r3 = r5.f3544b;	 Catch:{ all -> 0x009d }
        if (r2 >= r3) goto L_0x0045;
    L_0x001e:
        r2 = r5.f3544b;	 Catch:{ all -> 0x009d }
        r3 = r5.f3547e;	 Catch:{ all -> 0x009d }
        r2 = r2 - r3;
        if (r2 < r8) goto L_0x0027;
    L_0x0025:
        r2 = r8;
        goto L_0x002c;
    L_0x0027:
        r2 = r5.f3544b;	 Catch:{ all -> 0x009d }
        r3 = r5.f3547e;	 Catch:{ all -> 0x009d }
        r2 = r2 - r3;
    L_0x002c:
        r3 = r5.f3547e;	 Catch:{ all -> 0x009d }
        java.lang.System.arraycopy(r0, r3, r6, r7, r2);	 Catch:{ all -> 0x009d }
        r3 = r5.f3547e;	 Catch:{ all -> 0x009d }
        r3 = r3 + r2;
        r5.f3547e = r3;	 Catch:{ all -> 0x009d }
        if (r2 == r8) goto L_0x0043;
    L_0x0038:
        r3 = r1.available();	 Catch:{ all -> 0x009d }
        if (r3 != 0) goto L_0x003f;
    L_0x003e:
        goto L_0x0043;
    L_0x003f:
        r7 = r7 + r2;
        r2 = r8 - r2;
        goto L_0x0046;
    L_0x0043:
        monitor-exit(r5);
        return r2;
    L_0x0045:
        r2 = r8;
    L_0x0046:
        r3 = r5.f3546d;	 Catch:{ all -> 0x009d }
        r4 = -1;
        if (r3 != r4) goto L_0x005b;
    L_0x004b:
        r3 = r0.length;	 Catch:{ all -> 0x009d }
        if (r2 < r3) goto L_0x005b;
    L_0x004e:
        r3 = r1.read(r6, r7, r2);	 Catch:{ all -> 0x009d }
        if (r3 != r4) goto L_0x008d;
    L_0x0054:
        if (r2 != r8) goto L_0x0058;
    L_0x0056:
        monitor-exit(r5);
        return r4;
    L_0x0058:
        r8 = r8 - r2;
        monitor-exit(r5);
        return r8;
    L_0x005b:
        r3 = r5.m3046a(r1, r0);	 Catch:{ all -> 0x009d }
        if (r3 != r4) goto L_0x0068;
    L_0x0061:
        if (r2 != r8) goto L_0x0065;
    L_0x0063:
        monitor-exit(r5);
        return r4;
    L_0x0065:
        r8 = r8 - r2;
        monitor-exit(r5);
        return r8;
    L_0x0068:
        r3 = r5.f3543a;	 Catch:{ all -> 0x009d }
        if (r0 == r3) goto L_0x0075;
    L_0x006c:
        r0 = r5.f3543a;	 Catch:{ all -> 0x009d }
        if (r0 != 0) goto L_0x0075;
    L_0x0070:
        r6 = m3047c();	 Catch:{ all -> 0x009d }
        throw r6;	 Catch:{ all -> 0x009d }
    L_0x0075:
        r3 = r5.f3544b;	 Catch:{ all -> 0x009d }
        r4 = r5.f3547e;	 Catch:{ all -> 0x009d }
        r3 = r3 - r4;
        if (r3 < r2) goto L_0x007e;
    L_0x007c:
        r3 = r2;
        goto L_0x0083;
    L_0x007e:
        r3 = r5.f3544b;	 Catch:{ all -> 0x009d }
        r4 = r5.f3547e;	 Catch:{ all -> 0x009d }
        r3 = r3 - r4;
    L_0x0083:
        r4 = r5.f3547e;	 Catch:{ all -> 0x009d }
        java.lang.System.arraycopy(r0, r4, r6, r7, r3);	 Catch:{ all -> 0x009d }
        r4 = r5.f3547e;	 Catch:{ all -> 0x009d }
        r4 = r4 + r3;
        r5.f3547e = r4;	 Catch:{ all -> 0x009d }
    L_0x008d:
        r2 = r2 - r3;
        if (r2 != 0) goto L_0x0092;
    L_0x0090:
        monitor-exit(r5);
        return r8;
    L_0x0092:
        r4 = r1.available();	 Catch:{ all -> 0x009d }
        if (r4 != 0) goto L_0x009b;
    L_0x0098:
        r8 = r8 - r2;
        monitor-exit(r5);
        return r8;
    L_0x009b:
        r7 = r7 + r3;
        goto L_0x0046;
    L_0x009d:
        r6 = move-exception;
        monitor-exit(r5);
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream.read(byte[], int, int):int");
    }

    public synchronized void reset() throws IOException {
        if (this.f3543a == null) {
            throw new IOException("Stream is closed");
        } else if (-1 == this.f3546d) {
            StringBuilder stringBuilder = new StringBuilder("Mark has been invalidated, pos: ");
            stringBuilder.append(this.f3547e);
            stringBuilder.append(" markLimit: ");
            stringBuilder.append(this.f3545c);
            throw new InvalidMarkException(stringBuilder.toString());
        } else {
            this.f3547e = this.f3546d;
        }
    }

    public synchronized long skip(long j) throws IOException {
        if (j < 1) {
            return 0;
        }
        byte[] bArr = this.f3543a;
        if (bArr == null) {
            throw m3047c();
        }
        InputStream inputStream = this.in;
        if (inputStream == null) {
            throw m3047c();
        } else if (((long) (this.f3544b - this.f3547e)) >= j) {
            this.f3547e = (int) (((long) this.f3547e) + j);
            return j;
        } else {
            long j2 = ((long) this.f3544b) - ((long) this.f3547e);
            this.f3547e = this.f3544b;
            if (this.f3546d == -1 || j > ((long) this.f3545c)) {
                return j2 + inputStream.skip(j - j2);
            } else if (m3046a(inputStream, bArr) == -1) {
                return j2;
            } else {
                if (((long) (this.f3544b - this.f3547e)) >= j - j2) {
                    this.f3547e = (int) ((((long) this.f3547e) + j) - j2);
                    return j;
                }
                j2 = (j2 + ((long) this.f3544b)) - ((long) this.f3547e);
                this.f3547e = this.f3544b;
                return j2;
            }
        }
    }
}
