package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.util.Util;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;

public final class DefaultExtractorInput implements ExtractorInput {
    private static final byte[] f12826a = new byte[4096];
    private final DataSource f12827b;
    private final long f12828c;
    private long f12829d;
    private byte[] f12830e = new byte[65536];
    private int f12831f;
    private int f12832g;

    public DefaultExtractorInput(DataSource dataSource, long j, long j2) {
        this.f12827b = dataSource;
        this.f12829d = j;
        this.f12828c = j2;
    }

    public final int mo1331a(byte[] bArr, int i, int i2) throws IOException, InterruptedException {
        int d = m12000d(bArr, i, i2);
        if (d == 0) {
            d = m11997a(bArr, i, i2, 0, true);
        }
        m12002f(d);
        return d;
    }

    public final boolean mo1333a(byte[] bArr, int i, int i2, boolean z) throws IOException, InterruptedException {
        int d = m12000d(bArr, i, i2);
        while (d < i2 && d != -1) {
            d = m11997a(bArr, i, i2, d, z);
        }
        m12002f(d);
        return d != -1 ? 1 : null;
    }

    public final void mo1336b(byte[] bArr, int i, int i2) throws IOException, InterruptedException {
        mo1333a(bArr, i, i2, false);
    }

    public final int mo1330a(int i) throws IOException, InterruptedException {
        int d = m11999d(i);
        if (d == 0) {
            d = m11997a(f12826a, 0, Math.min(i, f12826a.length), 0, true);
        }
        m12002f(d);
        return d;
    }

    public final boolean mo1337b(byte[] bArr, int i, int i2, boolean z) throws IOException, InterruptedException {
        if (!m11998a(i2, z)) {
            return null;
        }
        System.arraycopy(this.f12830e, this.f12831f - i2, bArr, i, i2);
        return 1;
    }

    public final void mo1340c(byte[] bArr, int i, int i2) throws IOException, InterruptedException {
        mo1337b(bArr, i, i2, false);
    }

    public final void mo1339c(int i) throws IOException, InterruptedException {
        m11998a(i, false);
    }

    public final void mo1332a() {
        this.f12831f = 0;
    }

    public final long mo1334b() {
        return this.f12829d + ((long) this.f12831f);
    }

    public final long mo1338c() {
        return this.f12829d;
    }

    public final long mo1341d() {
        return this.f12828c;
    }

    private int m11999d(int i) {
        i = Math.min(this.f12832g, i);
        m12001e(i);
        return i;
    }

    private int m12000d(byte[] bArr, int i, int i2) {
        if (this.f12832g == 0) {
            return 0;
        }
        i2 = Math.min(this.f12832g, i2);
        System.arraycopy(this.f12830e, 0, bArr, i, i2);
        m12001e(i2);
        return i2;
    }

    private void m12001e(int i) {
        this.f12832g -= i;
        this.f12831f = 0;
        Object obj = this.f12830e;
        if (this.f12832g < this.f12830e.length - 524288) {
            obj = new byte[(this.f12832g + 65536)];
        }
        System.arraycopy(this.f12830e, i, obj, 0, this.f12832g);
        this.f12830e = obj;
    }

    private int m11997a(byte[] bArr, int i, int i2, int i3, boolean z) throws InterruptedException, IOException {
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        bArr = this.f12827b.mo1434a(bArr, i + i3, i2 - i3);
        if (bArr != -1) {
            return i3 + bArr;
        }
        if (i3 == 0 && z) {
            return -1;
        }
        throw new EOFException();
    }

    private void m12002f(int i) {
        if (i != -1) {
            this.f12829d += (long) i;
        }
    }

    public final void mo1335b(int i) throws IOException, InterruptedException {
        int d = m11999d(i);
        while (d < i && d != -1) {
            d = m11997a(f12826a, -d, Math.min(i, f12826a.length + d), d, false);
        }
        m12002f(d);
    }

    private boolean m11998a(int i, boolean z) throws IOException, InterruptedException {
        int i2 = this.f12831f + i;
        if (i2 > this.f12830e.length) {
            this.f12830e = Arrays.copyOf(this.f12830e, Util.m4297a(this.f12830e.length * 2, 65536 + i2, i2 + 524288));
        }
        int min = Math.min(this.f12832g - this.f12831f, i);
        while (min < i) {
            min = m11997a(this.f12830e, this.f12831f, i, min, z);
            if (min == -1) {
                return false;
            }
        }
        this.f12831f += i;
        this.f12832g = Math.max(this.f12832g, this.f12831f);
        return true;
    }
}
