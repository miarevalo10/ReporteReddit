package com.bumptech.glide.util;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MarkEnforcingInputStream extends FilterInputStream {
    private int f3669a = Integer.MIN_VALUE;

    public MarkEnforcingInputStream(InputStream inputStream) {
        super(inputStream);
    }

    public synchronized void mark(int i) {
        super.mark(i);
        this.f3669a = i;
    }

    public int read() throws IOException {
        if (m3214a(1) == -1) {
            return -1;
        }
        int read = super.read();
        m3215b(1);
        return read;
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        i2 = (int) m3214a((long) i2);
        if (i2 == -1) {
            return -1;
        }
        bArr = super.read(bArr, i, i2);
        m3215b((long) bArr);
        return bArr;
    }

    public synchronized void reset() throws IOException {
        super.reset();
        this.f3669a = Integer.MIN_VALUE;
    }

    public long skip(long j) throws IOException {
        j = m3214a(j);
        if (j == -1) {
            return 0;
        }
        j = super.skip(j);
        m3215b(j);
        return j;
    }

    public int available() throws IOException {
        if (this.f3669a == Integer.MIN_VALUE) {
            return super.available();
        }
        return Math.min(this.f3669a, super.available());
    }

    private long m3214a(long j) {
        if (this.f3669a == 0) {
            return -1;
        }
        return (this.f3669a == Integer.MIN_VALUE || j <= ((long) this.f3669a)) ? j : (long) this.f3669a;
    }

    private void m3215b(long j) {
        if (this.f3669a != Integer.MIN_VALUE && j != -1) {
            this.f3669a = (int) (((long) this.f3669a) - j);
        }
    }
}
