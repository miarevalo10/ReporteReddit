package com.bumptech.glide.util;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class ContentLengthInputStream extends FilterInputStream {
    private final long f3663a;
    private int f3664b;

    public static InputStream m3209a(InputStream inputStream, long j) {
        return new ContentLengthInputStream(inputStream, j);
    }

    private ContentLengthInputStream(InputStream inputStream, long j) {
        super(inputStream);
        this.f3663a = j;
    }

    public final synchronized int available() throws IOException {
        return (int) Math.max(this.f3663a - ((long) this.f3664b), (long) this.in.available());
    }

    public final synchronized int read() throws IOException {
        int read;
        read = super.read();
        m3208a(read >= 0 ? 1 : -1);
        return read;
    }

    public final int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public final synchronized int read(byte[] bArr, int i, int i2) throws IOException {
        return m3208a(super.read(bArr, i, i2));
    }

    private int m3208a(int i) throws IOException {
        if (i >= 0) {
            this.f3664b += i;
        } else if (this.f3663a - ((long) this.f3664b) > 0) {
            StringBuilder stringBuilder = new StringBuilder("Failed to read all expected data, expected: ");
            stringBuilder.append(this.f3663a);
            stringBuilder.append(", but read: ");
            stringBuilder.append(this.f3664b);
            throw new IOException(stringBuilder.toString());
        }
        return i;
    }
}
