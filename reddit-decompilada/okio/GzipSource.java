package okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

public final class GzipSource implements Source {
    private int f33186a = 0;
    private final BufferedSource f33187b;
    private final Inflater f33188c;
    private final InflaterSource f33189d;
    private final CRC32 f33190e = new CRC32();

    public GzipSource(Source source) {
        if (source == null) {
            throw new IllegalArgumentException("source == null");
        }
        this.f33188c = new Inflater(true);
        this.f33187b = Okio.m28289a(source);
        this.f33189d = new InflaterSource(this.f33187b, this.f33188c);
    }

    public final long read(Buffer buffer, long j) throws IOException {
        GzipSource gzipSource = this;
        Buffer buffer2 = buffer;
        long j2 = j;
        int i = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
        if (i < 0) {
            StringBuilder stringBuilder = new StringBuilder("byteCount < 0: ");
            stringBuilder.append(j2);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (i == 0) {
            return 0;
        } else {
            if (gzipSource.f33186a == 0) {
                long u;
                gzipSource.f33187b.mo6755a(10);
                byte c = gzipSource.f33187b.mo6754a().m36499c(3);
                int i2 = ((c >> 1) & 1) == 1 ? 1 : 0;
                if (i2 != 0) {
                    m33794a(gzipSource.f33187b.mo6754a(), 0, 10);
                }
                m33793a("ID1ID2", 8075, gzipSource.f33187b.mo6776h());
                gzipSource.f33187b.mo6779i(8);
                if (((c >> 2) & 1) == 1) {
                    long j3;
                    gzipSource.f33187b.mo6755a(2);
                    if (i2 != 0) {
                        m33794a(gzipSource.f33187b.mo6754a(), 0, 2);
                    }
                    long k = (long) gzipSource.f33187b.mo6754a().mo6781k();
                    gzipSource.f33187b.mo6755a(k);
                    if (i2 != 0) {
                        j3 = k;
                        m33794a(gzipSource.f33187b.mo6754a(), 0, k);
                    } else {
                        j3 = k;
                    }
                    gzipSource.f33187b.mo6779i(j3);
                }
                if (((c >> 3) & 1) == 1) {
                    u = gzipSource.f33187b.mo6790u();
                    if (u == -1) {
                        throw new EOFException();
                    }
                    if (i2 != 0) {
                        m33794a(gzipSource.f33187b.mo6754a(), 0, u + 1);
                    }
                    gzipSource.f33187b.mo6779i(u + 1);
                }
                if (((c >> 4) & 1) == 1) {
                    u = gzipSource.f33187b.mo6790u();
                    if (u == -1) {
                        throw new EOFException();
                    }
                    if (i2 != 0) {
                        m33794a(gzipSource.f33187b.mo6754a(), 0, u + 1);
                    }
                    gzipSource.f33187b.mo6779i(u + 1);
                }
                if (i2 != 0) {
                    m33793a("FHCRC", gzipSource.f33187b.mo6781k(), (short) ((int) gzipSource.f33190e.getValue()));
                    gzipSource.f33190e.reset();
                }
                gzipSource.f33186a = 1;
            }
            if (gzipSource.f33186a == 1) {
                long j4 = buffer2.f36201b;
                j2 = gzipSource.f33189d.read(buffer2, j2);
                if (j2 != -1) {
                    m33794a(buffer2, j4, j2);
                    return j2;
                }
                gzipSource.f33186a = 2;
            }
            if (gzipSource.f33186a == 2) {
                m33793a("CRC", gzipSource.f33187b.mo6782l(), (int) gzipSource.f33190e.getValue());
                m33793a("ISIZE", gzipSource.f33187b.mo6782l(), (int) gzipSource.f33188c.getBytesWritten());
                gzipSource.f33186a = 3;
                if (!gzipSource.f33187b.mo6769d()) {
                    throw new IOException("gzip finished without exhausting source");
                }
            }
            return -1;
        }
    }

    public final Timeout timeout() {
        return this.f33187b.timeout();
    }

    public final void close() throws IOException {
        this.f33189d.close();
    }

    private void m33794a(Buffer buffer, long j, long j2) {
        buffer = buffer.f36200a;
        while (j >= ((long) (buffer.f26680c - buffer.f26679b))) {
            j -= (long) (buffer.f26680c - buffer.f26679b);
            buffer = buffer.f26683f;
        }
        while (j2 > 0) {
            j = (int) (((long) buffer.f26679b) + j);
            int min = (int) Math.min((long) (buffer.f26680c - j), j2);
            this.f33190e.update(buffer.f26678a, j, min);
            j2 -= (long) min;
            buffer = buffer.f26683f;
            j = 0;
        }
    }

    private static void m33793a(String str, int i, int i2) throws IOException {
        if (i2 != i) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i)}));
        }
    }
}
