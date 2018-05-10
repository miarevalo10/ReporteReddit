package com.android.volley.toolbox;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class PoolingByteArrayOutputStream extends ByteArrayOutputStream {
    private final ByteArrayPool f2829a;

    public PoolingByteArrayOutputStream(ByteArrayPool byteArrayPool, int i) {
        this.f2829a = byteArrayPool;
        this.buf = this.f2829a.m2462a(Math.max(i, 256));
    }

    public void close() throws IOException {
        this.f2829a.m2461a(this.buf);
        this.buf = null;
        super.close();
    }

    public void finalize() {
        this.f2829a.m2461a(this.buf);
    }

    private void m2471a(int i) {
        if (this.count + i > this.buf.length) {
            i = this.f2829a.m2462a((this.count + i) * 2);
            System.arraycopy(this.buf, 0, i, 0, this.count);
            this.f2829a.m2461a(this.buf);
            this.buf = i;
        }
    }

    public synchronized void write(byte[] bArr, int i, int i2) {
        m2471a(i2);
        super.write(bArr, i, i2);
    }

    public synchronized void write(int i) {
        m2471a(1);
        super.write(i);
    }
}
