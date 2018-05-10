package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;
import java.io.InputStream;

public final class DataSourceInputStream extends InputStream {
    long f5161a;
    private final DataSource f5162b;
    private final DataSpec f5163c;
    private final byte[] f5164d;
    private boolean f5165e = false;
    private boolean f5166f = false;

    public DataSourceInputStream(DataSource dataSource, DataSpec dataSpec) {
        this.f5162b = dataSource;
        this.f5163c = dataSpec;
        this.f5164d = new byte[1];
    }

    public final int read() throws IOException {
        if (read(this.f5164d) == -1) {
            return -1;
        }
        return this.f5164d[0] & 255;
    }

    public final int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        Assertions.m4186b(this.f5166f ^ 1);
        m4148a();
        bArr = this.f5162b.mo1434a(bArr, i, i2);
        if (bArr == -1) {
            return -1;
        }
        this.f5161a += (long) bArr;
        return bArr;
    }

    public final void close() throws IOException {
        if (!this.f5166f) {
            this.f5162b.mo1436a();
            this.f5166f = true;
        }
    }

    final void m4148a() throws IOException {
        if (!this.f5165e) {
            this.f5162b.mo1435a(this.f5163c);
            this.f5165e = true;
        }
    }
}
