package com.bumptech.glide.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

public class ExceptionCatchingInputStream extends InputStream {
    private static final Queue<ExceptionCatchingInputStream> f3665b = Util.m3229a(0);
    public IOException f3666a;
    private InputStream f3667c;

    public static ExceptionCatchingInputStream m3210a(InputStream inputStream) {
        ExceptionCatchingInputStream exceptionCatchingInputStream;
        synchronized (f3665b) {
            exceptionCatchingInputStream = (ExceptionCatchingInputStream) f3665b.poll();
        }
        if (exceptionCatchingInputStream == null) {
            exceptionCatchingInputStream = new ExceptionCatchingInputStream();
        }
        exceptionCatchingInputStream.f3667c = inputStream;
        return exceptionCatchingInputStream;
    }

    ExceptionCatchingInputStream() {
    }

    public int available() throws IOException {
        return this.f3667c.available();
    }

    public void close() throws IOException {
        this.f3667c.close();
    }

    public void mark(int i) {
        this.f3667c.mark(i);
    }

    public boolean markSupported() {
        return this.f3667c.markSupported();
    }

    public int read(byte[] bArr) {
        try {
            return this.f3667c.read(bArr);
        } catch (byte[] bArr2) {
            this.f3666a = bArr2;
            return -1;
        }
    }

    public int read(byte[] bArr, int i, int i2) {
        try {
            return this.f3667c.read(bArr, i, i2);
        } catch (byte[] bArr2) {
            this.f3666a = bArr2;
            return -1;
        }
    }

    public synchronized void reset() throws IOException {
        this.f3667c.reset();
    }

    public long skip(long j) {
        try {
            return this.f3667c.skip(j);
        } catch (long j2) {
            this.f3666a = j2;
            return 0;
        }
    }

    public int read() {
        try {
            return this.f3667c.read();
        } catch (IOException e) {
            this.f3666a = e;
            return -1;
        }
    }

    public final void m3211a() {
        this.f3666a = null;
        this.f3667c = null;
        synchronized (f3665b) {
            f3665b.offer(this);
        }
    }
}
