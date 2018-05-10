package com.sendbird.android.shadow.okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

public final class GzipSource implements Source {
    private int f30572a = 0;
    private final BufferedSource f30573b;
    private final Inflater f30574c;
    private final InflaterSource f30575d;
    private final CRC32 f30576e = new CRC32();

    public GzipSource(Source source) {
        if (source == null) {
            throw new IllegalArgumentException("source == null");
        }
        this.f30574c = new Inflater(true);
        this.f30573b = Okio.m25615a(source);
        this.f30575d = new InflaterSource(this.f30573b, this.f30574c);
    }

    public final long mo5322a(Buffer buffer, long j) throws IOException {
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
            if (gzipSource.f30572a == 0) {
                long s;
                gzipSource.f30573b.mo6550a(10);
                byte b = gzipSource.f30573b.mo6552b().m35461b(3);
                int i2 = ((b >> 1) & 1) == 1 ? 1 : 0;
                if (i2 != 0) {
                    m31543a(gzipSource.f30573b.mo6552b(), 0, 10);
                }
                m31544a("ID1ID2", 8075, gzipSource.f30573b.mo6567g());
                gzipSource.f30573b.mo6568g(8);
                if (((b >> 2) & 1) == 1) {
                    long j3;
                    gzipSource.f30573b.mo6550a(2);
                    if (i2 != 0) {
                        m31543a(gzipSource.f30573b.mo6552b(), 0, 2);
                    }
                    long j4 = (long) gzipSource.f30573b.mo6552b().mo6572j();
                    gzipSource.f30573b.mo6550a(j4);
                    if (i2 != 0) {
                        j3 = j4;
                        m31543a(gzipSource.f30573b.mo6552b(), 0, j4);
                    } else {
                        j3 = j4;
                    }
                    gzipSource.f30573b.mo6568g(j3);
                }
                if (((b >> 3) & 1) == 1) {
                    s = gzipSource.f30573b.mo6580s();
                    if (s == -1) {
                        throw new EOFException();
                    }
                    if (i2 != 0) {
                        m31543a(gzipSource.f30573b.mo6552b(), 0, s + 1);
                    }
                    gzipSource.f30573b.mo6568g(s + 1);
                }
                if (((b >> 4) & 1) == 1) {
                    s = gzipSource.f30573b.mo6580s();
                    if (s == -1) {
                        throw new EOFException();
                    }
                    if (i2 != 0) {
                        m31543a(gzipSource.f30573b.mo6552b(), 0, s + 1);
                    }
                    gzipSource.f30573b.mo6568g(s + 1);
                }
                if (i2 != 0) {
                    m31544a("FHCRC", gzipSource.f30573b.mo6572j(), (short) ((int) gzipSource.f30576e.getValue()));
                    gzipSource.f30576e.reset();
                }
                gzipSource.f30572a = 1;
            }
            if (gzipSource.f30572a == 1) {
                long j5 = buffer2.f34625b;
                j2 = gzipSource.f30575d.mo5322a(buffer2, j2);
                if (j2 != -1) {
                    m31543a(buffer2, j5, j2);
                    return j2;
                }
                gzipSource.f30572a = 2;
            }
            if (gzipSource.f30572a == 2) {
                m31544a("CRC", gzipSource.f30573b.mo6573k(), (int) gzipSource.f30576e.getValue());
                m31544a("ISIZE", gzipSource.f30573b.mo6573k(), (int) gzipSource.f30574c.getBytesWritten());
                gzipSource.f30572a = 3;
                if (!gzipSource.f30573b.mo6562d()) {
                    throw new IOException("gzip finished without exhausting source");
                }
            }
            return -1;
        }
    }

    public final Timeout mo5323a() {
        return this.f30573b.mo5323a();
    }

    public final void close() throws IOException {
        this.f30575d.close();
    }

    private void m31543a(Buffer buffer, long j, long j2) {
        buffer = buffer.f34624a;
        while (j >= ((long) (buffer.f23609c - buffer.f23608b))) {
            j -= (long) (buffer.f23609c - buffer.f23608b);
            buffer = buffer.f23612f;
        }
        while (j2 > 0) {
            j = (int) (((long) buffer.f23608b) + j);
            int min = (int) Math.min((long) (buffer.f23609c - j), j2);
            this.f30576e.update(buffer.f23607a, j, min);
            j2 -= (long) min;
            buffer = buffer.f23612f;
            j = 0;
        }
    }

    private static void m31544a(String str, int i, int i2) throws IOException {
        if (i2 != i) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i)}));
        }
    }
}
