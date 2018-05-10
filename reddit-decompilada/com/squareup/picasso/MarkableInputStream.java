package com.squareup.picasso;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

final class MarkableInputStream extends InputStream {
    private final InputStream f23782a;
    private long f23783b;
    private long f23784c;
    private long f23785d;
    private long f23786e;

    public MarkableInputStream(InputStream inputStream) {
        this(inputStream, (byte) 0);
    }

    private MarkableInputStream(InputStream inputStream, byte b) {
        this.f23786e = -1;
        if (inputStream.markSupported() == (byte) 0) {
            inputStream = new BufferedInputStream(inputStream, 4096);
        }
        this.f23782a = inputStream;
    }

    public final void mark(int i) {
        this.f23786e = m25766a(i);
    }

    public final long m25766a(int i) {
        long j = this.f23783b + ((long) i);
        if (this.f23785d < j) {
            try {
                if (this.f23784c >= this.f23783b || this.f23783b > this.f23785d) {
                    this.f23784c = this.f23783b;
                    this.f23782a.mark((int) (j - this.f23783b));
                } else {
                    this.f23782a.reset();
                    this.f23782a.mark((int) (j - this.f23784c));
                    m25765a(this.f23784c, this.f23783b);
                }
                this.f23785d = j;
            } catch (int i2) {
                StringBuilder stringBuilder = new StringBuilder("Unable to mark: ");
                stringBuilder.append(i2);
                throw new IllegalStateException(stringBuilder.toString());
            }
        }
        return this.f23783b;
    }

    public final void reset() throws IOException {
        m25767a(this.f23786e);
    }

    public final void m25767a(long j) throws IOException {
        if (this.f23783b <= this.f23785d) {
            if (j >= this.f23784c) {
                this.f23782a.reset();
                m25765a(this.f23784c, j);
                this.f23783b = j;
                return;
            }
        }
        throw new IOException("Cannot reset");
    }

    private void m25765a(long j, long j2) throws IOException {
        while (j < j2) {
            long skip = this.f23782a.skip(j2 - j);
            if (skip == 0) {
                if (read() != -1) {
                    skip = 1;
                } else {
                    return;
                }
            }
            j += skip;
        }
    }

    public final int read() throws IOException {
        int read = this.f23782a.read();
        if (read != -1) {
            this.f23783b++;
        }
        return read;
    }

    public final int read(byte[] bArr) throws IOException {
        bArr = this.f23782a.read(bArr);
        if (bArr != -1) {
            this.f23783b += (long) bArr;
        }
        return bArr;
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        bArr = this.f23782a.read(bArr, i, i2);
        if (bArr != -1) {
            this.f23783b += (long) bArr;
        }
        return bArr;
    }

    public final long skip(long j) throws IOException {
        j = this.f23782a.skip(j);
        this.f23783b += j;
        return j;
    }

    public final int available() throws IOException {
        return this.f23782a.available();
    }

    public final void close() throws IOException {
        this.f23782a.close();
    }

    public final boolean markSupported() {
        return this.f23782a.markSupported();
    }
}
