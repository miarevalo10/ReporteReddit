package okio;

import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import java.io.EOFException;
import java.io.IOException;
import java.util.zip.Inflater;

public final class InflaterSource implements Source {
    private final BufferedSource f33191a;
    private final Inflater f33192b;
    private int f33193c;
    private boolean f33194d;

    InflaterSource(BufferedSource bufferedSource, Inflater inflater) {
        if (bufferedSource == null) {
            throw new IllegalArgumentException("source == null");
        } else if (inflater == null) {
            throw new IllegalArgumentException("inflater == null");
        } else {
            this.f33191a = bufferedSource;
            this.f33192b = inflater;
        }
    }

    public final long read(Buffer buffer, long j) throws IOException {
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i < 0) {
            StringBuilder stringBuilder = new StringBuilder("byteCount < 0: ");
            stringBuilder.append(j);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (this.f33194d != null) {
            throw new IllegalStateException("closed");
        } else if (i == 0) {
            return 0;
        } else {
            int i2;
            do {
                i2 = 0;
                if (this.f33192b.needsInput() != null) {
                    m33795a();
                    if (this.f33192b.getRemaining() != null) {
                        throw new IllegalStateException(Operation.EMPTY_PARAM);
                    } else if (this.f33191a.mo6769d() != null) {
                        i2 = 1;
                    } else {
                        j = this.f33191a.mo6754a().f36200a;
                        this.f33193c = j.f26680c - j.f26679b;
                        this.f33192b.setInput(j.f26678a, j.f26679b, this.f33193c);
                    }
                }
                try {
                    j = buffer.m36511e(1);
                    int inflate = this.f33192b.inflate(j.f26678a, j.f26680c, 8192 - j.f26680c);
                    if (inflate > 0) {
                        j.f26680c += inflate;
                        j = (long) inflate;
                        buffer.f36201b += j;
                        return j;
                    }
                    if (!this.f33192b.finished()) {
                        if (this.f33192b.needsDictionary()) {
                        }
                    }
                    m33795a();
                    if (j.f26679b == j.f26680c) {
                        buffer.f36200a = j.m28303a();
                        SegmentPool.m28307a(j);
                    }
                    return -1;
                } catch (Buffer buffer2) {
                    throw new IOException(buffer2);
                }
            } while (i2 == 0);
            throw new EOFException("source exhausted prematurely");
        }
    }

    private void m33795a() throws IOException {
        if (this.f33193c != 0) {
            int remaining = this.f33193c - this.f33192b.getRemaining();
            this.f33193c -= remaining;
            this.f33191a.mo6779i((long) remaining);
        }
    }

    public final Timeout timeout() {
        return this.f33191a.timeout();
    }

    public final void close() throws IOException {
        if (!this.f33194d) {
            this.f33192b.end();
            this.f33194d = true;
            this.f33191a.close();
        }
    }
}
