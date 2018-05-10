package com.bumptech.glide.load.data;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class ExifOrientationStream extends FilterInputStream {
    private static final byte[] f3343a = new byte[]{(byte) -1, (byte) -31, (byte) 0, (byte) 28, (byte) 69, Framer.EXIT_FRAME_PREFIX, (byte) 105, (byte) 102, (byte) 0, (byte) 0, (byte) 77, (byte) 77, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 8, (byte) 0, (byte) 1, (byte) 1, (byte) 18, (byte) 0, (byte) 2, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0};
    private static final int f3344b = 29;
    private static final int f3345c = 31;
    private final byte f3346d;
    private int f3347e;

    public final boolean markSupported() {
        return false;
    }

    public ExifOrientationStream(InputStream inputStream, int i) {
        super(inputStream);
        if (i >= -1) {
            if (i <= 8) {
                this.f3346d = (byte) i;
                return;
            }
        }
        StringBuilder stringBuilder = new StringBuilder("Cannot add invalid orientation: ");
        stringBuilder.append(i);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public final void mark(int i) {
        throw new UnsupportedOperationException();
    }

    public final int read() throws IOException {
        int i;
        if (this.f3347e >= 2) {
            if (this.f3347e <= f3345c) {
                if (this.f3347e == f3345c) {
                    i = this.f3346d;
                } else {
                    i = f3343a[this.f3347e - 2] & 255;
                }
                if (i != -1) {
                    this.f3347e++;
                }
                return i;
            }
        }
        i = super.read();
        if (i != -1) {
            this.f3347e++;
        }
        return i;
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.f3347e > f3345c) {
            bArr = super.read(bArr, i, i2);
        } else if (this.f3347e == f3345c) {
            bArr[i] = this.f3346d;
            bArr = 1;
        } else if (this.f3347e < 2) {
            bArr = super.read(bArr, i, 2 - this.f3347e);
        } else {
            i2 = Math.min(f3345c - this.f3347e, i2);
            System.arraycopy(f3343a, this.f3347e - 2, bArr, i, i2);
            bArr = i2;
        }
        if (bArr > null) {
            this.f3347e += bArr;
        }
        return bArr;
    }

    public final long skip(long j) throws IOException {
        j = super.skip(j);
        if (j > 0) {
            this.f3347e = (int) (((long) this.f3347e) + j);
        }
        return j;
    }

    public final void reset() throws IOException {
        throw new UnsupportedOperationException();
    }
}
