package com.google.android.gms.internal;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

final class zzan extends FilterInputStream {
    private final long f6591a;
    private long f6592b;

    zzan(InputStream inputStream, long j) {
        super(inputStream);
        this.f6591a = j;
    }

    final long m5431a() {
        return this.f6591a - this.f6592b;
    }

    public final int read() throws IOException {
        int read = super.read();
        if (read != -1) {
            this.f6592b++;
        }
        return read;
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        int read = super.read(bArr, i, i2);
        if (read != -1) {
            this.f6592b += (long) read;
        }
        return read;
    }
}
