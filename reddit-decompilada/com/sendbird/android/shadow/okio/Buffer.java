package com.sendbird.android.shadow.okio;

import com.facebook.stetho.dumpapp.Framer;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import org.jcodec.codecs.mjpeg.JpegConst;
import org.jcodec.codecs.mpeg12.MPEGConst;

public final class Buffer implements BufferedSink, BufferedSource, Cloneable {
    private static final byte[] f34623c = new byte[]{(byte) 48, Framer.STDOUT_FRAME_PREFIX, Framer.STDERR_FRAME_PREFIX, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 97, (byte) 98, (byte) 99, (byte) 100, (byte) 101, (byte) 102};
    Segment f34624a;
    public long f34625b;

    class C20452 extends InputStream {
        final /* synthetic */ Buffer f23600a;

        public void close() {
        }

        public C20452(Buffer buffer) {
            this.f23600a = buffer;
        }

        public int read() {
            return this.f23600a.f34625b > 0 ? this.f23600a.mo6563f() & 255 : -1;
        }

        public int read(byte[] bArr, int i, int i2) {
            return this.f23600a.mo6547a(bArr, i, i2);
        }

        public int available() {
            return (int) Math.min(this.f23600a.f34625b, 2147483647L);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.f23600a);
            stringBuilder.append(".inputStream()");
            return stringBuilder.toString();
        }
    }

    public final Buffer mo6552b() {
        return this;
    }

    public final BufferedSink mo6556c() {
        return this;
    }

    public final void close() {
    }

    public final void flush() {
    }

    public final /* bridge */ /* synthetic */ BufferedSink mo6581t() throws IOException {
        return this;
    }

    public final /* synthetic */ BufferedSink mo6553b(String str) throws IOException {
        return m35455a(str);
    }

    public final /* synthetic */ BufferedSink mo6557c(ByteString byteString) throws IOException {
        return m35454a(byteString);
    }

    public final /* synthetic */ BufferedSink mo6558c(byte[] bArr) throws IOException {
        return m35464b(bArr);
    }

    public final /* synthetic */ BufferedSink mo6559c(byte[] bArr, int i, int i2) throws IOException {
        return m35465b(bArr, i, i2);
    }

    public final /* synthetic */ BufferedSink mo6564f(int i) throws IOException {
        return m35475d(i);
    }

    public final /* synthetic */ BufferedSink mo6566g(int i) throws IOException {
        return m35469c(i);
    }

    public final /* synthetic */ BufferedSink mo6570h(int i) throws IOException {
        return m35463b(i);
    }

    public final /* synthetic */ BufferedSink mo6574k(long j) throws IOException {
        return m35492j(j);
    }

    public final /* synthetic */ BufferedSink mo6576l(long j) throws IOException {
        return m35491i(j);
    }

    public final /* synthetic */ BufferedSink mo6578m(long j) throws IOException {
        return m35488h(j);
    }

    public final boolean mo6562d() {
        return this.f34625b == 0;
    }

    public final void mo6550a(long j) throws EOFException {
        if (this.f34625b < j) {
            throw new EOFException();
        }
    }

    public final Buffer m35453a(Buffer buffer, long j, long j2) {
        if (buffer == null) {
            throw new IllegalArgumentException("out == null");
        }
        Util.m25643a(this.f34625b, j, j2);
        if (j2 == 0) {
            return this;
        }
        buffer.f34625b += j2;
        Segment segment = this.f34624a;
        while (j >= ((long) (segment.f23609c - segment.f23608b))) {
            j -= (long) (segment.f23609c - segment.f23608b);
            segment = segment.f23612f;
        }
        while (j2 > 0) {
            Segment segment2 = new Segment(segment);
            segment2.f23608b = (int) (((long) segment2.f23608b) + j);
            segment2.f23609c = Math.min(segment2.f23608b + ((int) j2), segment2.f23609c);
            if (buffer.f34624a == null) {
                segment2.f23613g = segment2;
                segment2.f23612f = segment2;
                buffer.f34624a = segment2;
            } else {
                buffer.f34624a.f23613g.m25629a(segment2);
            }
            j2 -= (long) (segment2.f23609c - segment2.f23608b);
            segment = segment.f23612f;
            j = 0;
        }
        return this;
    }

    public final long m35478e() {
        long j = this.f34625b;
        if (j == 0) {
            return 0;
        }
        Segment segment = this.f34624a.f23613g;
        if (segment.f23609c < 8192 && segment.f23611e) {
            j -= (long) (segment.f23609c - segment.f23608b);
        }
        return j;
    }

    public final byte mo6563f() {
        if (this.f34625b == 0) {
            throw new IllegalStateException("size == 0");
        }
        Segment segment = this.f34624a;
        int i = segment.f23608b;
        int i2 = segment.f23609c;
        int i3 = i + 1;
        byte b = segment.f23607a[i];
        this.f34625b--;
        if (i3 == i2) {
            this.f34624a = segment.m25628a();
            SegmentPool.m25632a(segment);
        } else {
            segment.f23608b = i3;
        }
        return b;
    }

    public final byte m35461b(long j) {
        Util.m25643a(this.f34625b, j, 1);
        Segment segment = this.f34624a;
        while (true) {
            long j2 = (long) (segment.f23609c - segment.f23608b);
            if (j < j2) {
                return segment.f23607a[segment.f23608b + ((int) j)];
            }
            j -= j2;
            segment = segment.f23612f;
        }
    }

    public final short mo6567g() {
        if (this.f34625b < 2) {
            StringBuilder stringBuilder = new StringBuilder("size < 2: ");
            stringBuilder.append(this.f34625b);
            throw new IllegalStateException(stringBuilder.toString());
        }
        Segment segment = this.f34624a;
        int i = segment.f23608b;
        int i2 = segment.f23609c;
        if (i2 - i < 2) {
            return (short) (((mo6563f() & 255) << 8) | (mo6563f() & 255));
        }
        byte[] bArr = segment.f23607a;
        int i3 = i + 1;
        int i4 = i3 + 1;
        i = ((bArr[i] & 255) << 8) | (bArr[i3] & 255);
        this.f34625b -= 2;
        if (i4 == i2) {
            this.f34624a = segment.m25628a();
            SegmentPool.m25632a(segment);
        } else {
            segment.f23608b = i4;
        }
        return (short) i;
    }

    public final int mo6569h() {
        if (this.f34625b < 4) {
            StringBuilder stringBuilder = new StringBuilder("size < 4: ");
            stringBuilder.append(this.f34625b);
            throw new IllegalStateException(stringBuilder.toString());
        }
        Segment segment = this.f34624a;
        int i = segment.f23608b;
        int i2 = segment.f23609c;
        if (i2 - i < 4) {
            return ((((mo6563f() & 255) << 24) | ((mo6563f() & 255) << 16)) | ((mo6563f() & 255) << 8)) | (mo6563f() & 255);
        }
        byte[] bArr = segment.f23607a;
        int i3 = i + 1;
        int i4 = i3 + 1;
        i = ((bArr[i] & 255) << 24) | ((bArr[i3] & 255) << 16);
        i3 = i4 + 1;
        i |= (bArr[i4] & 255) << 8;
        i4 = i3 + 1;
        i |= bArr[i3] & 255;
        this.f34625b -= 4;
        if (i4 == i2) {
            this.f34624a = segment.m25628a();
            SegmentPool.m25632a(segment);
        } else {
            segment.f23608b = i4;
        }
        return i;
    }

    public final long mo6571i() {
        if (this.f34625b < 8) {
            StringBuilder stringBuilder = new StringBuilder("size < 8: ");
            stringBuilder.append(this.f34625b);
            throw new IllegalStateException(stringBuilder.toString());
        }
        Segment segment = this.f34624a;
        int i = segment.f23608b;
        int i2 = segment.f23609c;
        if (i2 - i < 8) {
            return ((((long) mo6569h()) & 4294967295L) << 32) | (4294967295L & ((long) mo6569h()));
        }
        byte[] bArr = segment.f23607a;
        int i3 = i + 1;
        i = i3 + 1;
        int i4 = i + 1;
        i = i4 + 1;
        int i5 = i + 1;
        i = i5 + 1;
        i5 = i + 1;
        long j = (((((((((long) bArr[i]) & 255) << 56) | ((((long) bArr[i3]) & 255) << 48)) | ((((long) bArr[i]) & 255) << 40)) | ((((long) bArr[i4]) & 255) << 32)) | ((((long) bArr[i]) & 255) << 24)) | ((((long) bArr[i5]) & 255) << 16)) | ((((long) bArr[i]) & 255) << 8);
        i = i5 + 1;
        long j2 = (((long) bArr[i5]) & 255) | j;
        this.f34625b -= 8;
        if (i == i2) {
            this.f34624a = segment.m25628a();
            SegmentPool.m25632a(segment);
        } else {
            segment.f23608b = i;
        }
        return j2;
    }

    public final short mo6572j() {
        return Util.m25642a(mo6567g());
    }

    public final int mo6573k() {
        return Util.m25641a(mo6569h());
    }

    public final long mo6575l() {
        if (this.f34625b == 0) {
            throw new IllegalStateException("size == 0");
        }
        long j = -7;
        int i = 0;
        long j2 = 0;
        int i2 = 0;
        int i3 = i2;
        do {
            Segment segment;
            Segment segment2 = r0.f34624a;
            byte[] bArr = segment2.f23607a;
            int i4 = segment2.f23608b;
            int i5 = segment2.f23609c;
            while (i4 < i5) {
                byte[] bArr2;
                int i6 = bArr[i4];
                if (i6 < (byte) 48 || i6 > (byte) 57) {
                    segment = segment2;
                    bArr2 = bArr;
                    if (i6 != Framer.STDIN_FRAME_PREFIX || i != 0) {
                        if (i != 0) {
                            i3 = 1;
                            if (i4 != i5) {
                                segment2 = segment;
                                r0.f34624a = segment2.m25628a();
                                SegmentPool.m25632a(segment2);
                            } else {
                                segment.f23608b = i4;
                            }
                            if (i3 == 0) {
                                break;
                            }
                        } else {
                            StringBuilder stringBuilder = new StringBuilder("Expected leading [0-9] or '-' character but was 0x");
                            stringBuilder.append(Integer.toHexString(i6));
                            throw new NumberFormatException(stringBuilder.toString());
                        }
                    }
                    j--;
                    i2 = 1;
                } else {
                    int i7 = 48 - i6;
                    int i8 = (j2 > -922337203685477580L ? 1 : (j2 == -922337203685477580L ? 0 : -1));
                    if (i8 >= 0) {
                        if (i8 == 0) {
                            segment = segment2;
                            bArr2 = bArr;
                            if (((long) i7) < j) {
                            }
                        } else {
                            segment = segment2;
                            bArr2 = bArr;
                        }
                        j2 = (j2 * 10) + ((long) i7);
                    }
                    Buffer b = new Buffer().m35491i(j2).m35463b(i6);
                    if (i2 == 0) {
                        b.mo6563f();
                    }
                    StringBuilder stringBuilder2 = new StringBuilder("Number too large: ");
                    stringBuilder2.append(b.m35501o());
                    throw new NumberFormatException(stringBuilder2.toString());
                }
                i4++;
                i++;
                segment2 = segment;
                bArr = bArr2;
            }
            segment = segment2;
            if (i4 != i5) {
                segment.f23608b = i4;
            } else {
                segment2 = segment;
                r0.f34624a = segment2.m25628a();
                SegmentPool.m25632a(segment2);
            }
            if (i3 == 0) {
                break;
            }
        } while (r0.f34624a != null);
        r0.f34625b -= (long) i;
        return i2 != 0 ? j2 : -j2;
    }

    public final long mo6577m() {
        if (this.f34625b == 0) {
            throw new IllegalStateException("size == 0");
        }
        int i = 0;
        int i2 = 0;
        long j = 0;
        do {
            Segment segment = this.f34624a;
            byte[] bArr = segment.f23607a;
            int i3 = segment.f23608b;
            int i4 = segment.f23609c;
            while (i3 < i4) {
                int i5;
                int i6 = bArr[i3];
                if (i6 >= (byte) 48 && i6 <= (byte) 57) {
                    i5 = i6 - 48;
                } else if (i6 >= (byte) 97 && i6 <= (byte) 102) {
                    i5 = (i6 - 97) + 10;
                } else if (i6 < (byte) 65 || i6 > (byte) 70) {
                    if (i != 0) {
                        i2 = 1;
                        if (i3 != i4) {
                            this.f34624a = segment.m25628a();
                            SegmentPool.m25632a(segment);
                        } else {
                            segment.f23608b = i3;
                        }
                        if (i2 == 0) {
                            break;
                        }
                    } else {
                        StringBuilder stringBuilder = new StringBuilder("Expected leading [0-9a-fA-F] character but was 0x");
                        stringBuilder.append(Integer.toHexString(i6));
                        throw new NumberFormatException(stringBuilder.toString());
                    }
                } else {
                    i5 = (i6 - 65) + 10;
                }
                if ((-1152921504606846976L & j) != 0) {
                    Buffer b = new Buffer().m35492j(j).m35463b(i6);
                    StringBuilder stringBuilder2 = new StringBuilder("Number too large: ");
                    stringBuilder2.append(b.m35501o());
                    throw new NumberFormatException(stringBuilder2.toString());
                }
                j = (j << 4) | ((long) i5);
                i3++;
                i++;
            }
            if (i3 != i4) {
                segment.f23608b = i3;
            } else {
                this.f34624a = segment.m25628a();
                SegmentPool.m25632a(segment);
            }
            if (i2 == 0) {
                break;
            }
        } while (this.f34624a != null);
        this.f34625b -= (long) i;
        return j;
    }

    public final ByteString m35500n() {
        return new ByteString(m35503q());
    }

    public final ByteString mo6560c(long j) throws EOFException {
        return new ByteString(mo6565f(j));
    }

    public final void mo6554b(Buffer buffer, long j) throws EOFException {
        if (this.f34625b < j) {
            buffer.a_(this, this.f34625b);
            throw new EOFException();
        } else {
            buffer.a_(this, j);
        }
    }

    public final String m35501o() {
        try {
            return m35446a(this.f34625b, Util.f23620a);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    private String m35447n(long j) throws EOFException {
        return m35446a(j, Util.f23620a);
    }

    public final String mo6549a(Charset charset) {
        try {
            return m35446a(this.f34625b, charset);
        } catch (Charset charset2) {
            throw new AssertionError(charset2);
        }
    }

    private String m35446a(long j, Charset charset) throws EOFException {
        Util.m25643a(this.f34625b, 0, j);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        } else if (j > 2147483647L) {
            StringBuilder stringBuilder = new StringBuilder("byteCount > Integer.MAX_VALUE: ");
            stringBuilder.append(j);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (j == 0) {
            return "";
        } else {
            Segment segment = this.f34624a;
            if (((long) segment.f23608b) + j > ((long) segment.f23609c)) {
                return new String(mo6565f(j), charset);
            }
            String str = new String(segment.f23607a, segment.f23608b, (int) j, charset);
            segment.f23608b = (int) (((long) segment.f23608b) + j);
            this.f34625b -= j;
            if (segment.f23608b == segment.f23609c) {
                this.f34624a = segment.m25628a();
                SegmentPool.m25632a(segment);
            }
            return str;
        }
    }

    public final String mo6579p() throws EOFException {
        return mo6561d(Long.MAX_VALUE);
    }

    public final String mo6561d(long j) throws EOFException {
        if (j < 0) {
            StringBuilder stringBuilder = new StringBuilder("limit < 0: ");
            stringBuilder.append(j);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        long j2 = Long.MAX_VALUE;
        if (j != Long.MAX_VALUE) {
            j2 = j + 1;
        }
        long a = m35449a((byte) 10, 0, j2);
        if (a != -1) {
            return m35480e(a);
        }
        if (j2 < this.f34625b && m35461b(j2 - 1) == (byte) 13 && m35461b(j2) == (byte) 10) {
            return m35480e(j2);
        }
        Buffer buffer = new Buffer();
        m35453a(buffer, 0, Math.min(32, this.f34625b));
        stringBuilder = new StringBuilder("\\n not found: limit=");
        stringBuilder.append(Math.min(this.f34625b, j));
        stringBuilder.append(" content=");
        stringBuilder.append(buffer.m35500n().mo5403f());
        stringBuilder.append(8230);
        throw new EOFException(stringBuilder.toString());
    }

    final String m35480e(long j) throws EOFException {
        if (j > 0) {
            long j2 = j - 1;
            if (m35461b(j2) == (byte) 13) {
                j = m35447n(j2);
                mo6568g(2);
                return j;
            }
        }
        j = m35447n(j);
        mo6568g(1);
        return j;
    }

    public final byte[] m35503q() {
        try {
            return mo6565f(this.f34625b);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public final byte[] mo6565f(long j) throws EOFException {
        Util.m25643a(this.f34625b, 0, j);
        if (j > 2147483647L) {
            StringBuilder stringBuilder = new StringBuilder("byteCount > Integer.MAX_VALUE: ");
            stringBuilder.append(j);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        byte[] bArr = new byte[((int) j)];
        mo6551a(bArr);
        return bArr;
    }

    public final void mo6551a(byte[] bArr) throws EOFException {
        int i = 0;
        while (i < bArr.length) {
            int a = mo6547a(bArr, i, bArr.length - i);
            if (a == -1) {
                throw new EOFException();
            }
            i += a;
        }
    }

    public final int mo6547a(byte[] bArr, int i, int i2) {
        Util.m25643a((long) bArr.length, (long) i, (long) i2);
        Segment segment = this.f34624a;
        if (segment == null) {
            return -1;
        }
        i2 = Math.min(i2, segment.f23609c - segment.f23608b);
        System.arraycopy(segment.f23607a, segment.f23608b, bArr, i, i2);
        segment.f23608b += i2;
        this.f34625b -= (long) i2;
        if (segment.f23608b == segment.f23609c) {
            this.f34624a = segment.m25628a();
            SegmentPool.m25632a(segment);
        }
        return i2;
    }

    public final void m35504r() {
        try {
            mo6568g(this.f34625b);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public final void mo6568g(long j) throws EOFException {
        while (j > 0) {
            if (this.f34624a == null) {
                throw new EOFException();
            }
            int min = (int) Math.min(j, (long) (this.f34624a.f23609c - this.f34624a.f23608b));
            long j2 = (long) min;
            this.f34625b -= j2;
            j -= j2;
            Segment segment = this.f34624a;
            segment.f23608b += min;
            if (this.f34624a.f23608b == this.f34624a.f23609c) {
                Segment segment2 = this.f34624a;
                this.f34624a = segment2.m25628a();
                SegmentPool.m25632a(segment2);
            }
        }
    }

    public final Buffer m35454a(ByteString byteString) {
        if (byteString == null) {
            throw new IllegalArgumentException("byteString == null");
        }
        byteString.mo5395a(this);
        return this;
    }

    public final Buffer m35455a(String str) {
        return m35456a(str, 0, str.length());
    }

    public final Buffer m35456a(String str, int i, int i2) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        } else if (i < 0) {
            i2 = new StringBuilder("beginIndex < 0: ");
            i2.append(i);
            throw new IllegalArgumentException(i2.toString());
        } else if (i2 < i) {
            r0 = new StringBuilder("endIndex < beginIndex: ");
            r0.append(i2);
            r0.append(" < ");
            r0.append(i);
            throw new IllegalArgumentException(r0.toString());
        } else if (i2 > str.length()) {
            r0 = new StringBuilder("endIndex > string.length: ");
            r0.append(i2);
            r0.append(" > ");
            r0.append(str.length());
            throw new IllegalArgumentException(r0.toString());
        } else {
            while (i < i2) {
                char charAt = str.charAt(i);
                int i3;
                int min;
                if (charAt < '') {
                    Segment e = m35479e(1);
                    byte[] bArr = e.f23607a;
                    i3 = e.f23609c - i;
                    min = Math.min(i2, 8192 - i3);
                    int i4 = i + 1;
                    bArr[i + i3] = (byte) charAt;
                    while (true) {
                        i = i4;
                        if (i >= min) {
                            break;
                        }
                        charAt = str.charAt(i);
                        if (charAt >= '') {
                            break;
                        }
                        i4 = i + 1;
                        bArr[i + i3] = (byte) charAt;
                    }
                    i3 = (i3 + i) - e.f23609c;
                    e.f23609c += i3;
                    this.f34625b += (long) i3;
                } else if (charAt < 'ࠀ') {
                    m35463b((charAt >> 6) | JpegConst.SOF0);
                    m35463b((charAt & 63) | 128);
                    i++;
                } else {
                    if (charAt >= '?') {
                        if (charAt <= '?') {
                            i3 = i + 1;
                            if (i3 < i2) {
                                min = str.charAt(i3);
                            } else {
                                min = 0;
                            }
                            if (charAt <= '?' && min >= 56320) {
                                if (min <= 57343) {
                                    int i5 = 65536 + (((charAt & -55297) << 10) | (-56321 & min));
                                    m35463b((i5 >> 18) | 240);
                                    m35463b(((i5 >> 12) & 63) | 128);
                                    m35463b(((i5 >> 6) & 63) | 128);
                                    m35463b((i5 & 63) | 128);
                                    i += 2;
                                }
                            }
                            m35463b(63);
                            i = i3;
                        }
                    }
                    m35463b((charAt >> 12) | JpegConst.APP0);
                    m35463b(((charAt >> 6) & 63) | 128);
                    m35463b((charAt & 63) | 128);
                    i++;
                }
            }
            return this;
        }
    }

    public final Buffer m35452a(int i) {
        if (i < 128) {
            m35463b(i);
        } else if (i < MPEGConst.CODE_END) {
            m35463b((i >> 6) | JpegConst.SOF0);
            m35463b((i & 63) | 128);
        } else if (i < 65536) {
            if (i < 55296 || i > 57343) {
                m35463b((i >> 12) | JpegConst.APP0);
                m35463b(((i >> 6) & 63) | 128);
                m35463b((i & 63) | 128);
            } else {
                m35463b(63);
            }
        } else if (i <= 1114111) {
            m35463b((i >> 18) | 240);
            m35463b(((i >> 12) & 63) | 128);
            m35463b(((i >> 6) & 63) | 128);
            m35463b((i & 63) | 128);
        } else {
            StringBuilder stringBuilder = new StringBuilder("Unexpected code point: ");
            stringBuilder.append(Integer.toHexString(i));
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        return this;
    }

    public final Buffer m35464b(byte[] bArr) {
        if (bArr != null) {
            return m35465b(bArr, 0, bArr.length);
        }
        throw new IllegalArgumentException("source == null");
    }

    public final Buffer m35465b(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = (long) i2;
        Util.m25643a((long) bArr.length, (long) i, j);
        i2 += i;
        while (i < i2) {
            Segment e = m35479e(1);
            int min = Math.min(i2 - i, 8192 - e.f23609c);
            System.arraycopy(bArr, i, e.f23607a, e.f23609c, min);
            i += min;
            e.f23609c += min;
        }
        this.f34625b += j;
        return this;
    }

    public final long mo6548a(Source source) throws IOException {
        if (source == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long a = source.mo5322a(this, 8192);
            if (a == -1) {
                return j;
            }
            j += a;
        }
    }

    public final Buffer m35463b(int i) {
        Segment e = m35479e(1);
        byte[] bArr = e.f23607a;
        int i2 = e.f23609c;
        e.f23609c = i2 + 1;
        bArr[i2] = (byte) i;
        this.f34625b++;
        return this;
    }

    public final Buffer m35469c(int i) {
        Segment e = m35479e(2);
        byte[] bArr = e.f23607a;
        int i2 = e.f23609c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        i2 = i3 + 1;
        bArr[i3] = (byte) (i & 255);
        e.f23609c = i2;
        this.f34625b += 2;
        return this;
    }

    public final Buffer m35475d(int i) {
        Segment e = m35479e(4);
        byte[] bArr = e.f23607a;
        int i2 = e.f23609c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        i2 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 16) & 255);
        i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        i2 = i3 + 1;
        bArr[i3] = (byte) (i & 255);
        e.f23609c = i2;
        this.f34625b += 4;
        return this;
    }

    public final Buffer m35488h(long j) {
        Segment e = m35479e(8);
        byte[] bArr = e.f23607a;
        int i = e.f23609c;
        int i2 = i + 1;
        bArr[i] = (byte) ((int) ((j >>> 56) & 255));
        i = i2 + 1;
        bArr[i2] = (byte) ((int) ((j >>> 48) & 255));
        i2 = i + 1;
        bArr[i] = (byte) ((int) ((j >>> 40) & 255));
        i = i2 + 1;
        bArr[i2] = (byte) ((int) ((j >>> 32) & 255));
        i2 = i + 1;
        bArr[i] = (byte) ((int) ((j >>> 24) & 255));
        i = i2 + 1;
        bArr[i2] = (byte) ((int) ((j >>> 16) & 255));
        i2 = i + 1;
        bArr[i] = (byte) ((int) ((j >>> 8) & 255));
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((int) (j & 255));
        e.f23609c = i3;
        this.f34625b += 8;
        return this;
    }

    public final Buffer m35491i(long j) {
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i == 0) {
            return m35463b((int) 48);
        }
        int i2 = 0;
        int i3 = 1;
        if (i < 0) {
            j = -j;
            if (j < 0) {
                return m35455a("-9223372036854775808");
            }
            i2 = 1;
        }
        if (j >= 100000000) {
            i3 = j < 1000000000000L ? j < 10000000000L ? j < 1000000000 ? 9 : 10 : j < 100000000000L ? 11 : 12 : j < 1000000000000000L ? j < 10000000000000L ? 13 : j < 100000000000000L ? 14 : 15 : j < 100000000000000000L ? j < 10000000000000000L ? 16 : 17 : j < 1000000000000000000L ? 18 : 19;
        } else if (j >= 10000) {
            i3 = j < 1000000 ? j < 100000 ? 5 : 6 : j < 10000000 ? 7 : 8;
        } else if (j >= 100) {
            i3 = j < 1000 ? 3 : 4;
        } else if (j >= 10) {
            i3 = 2;
        }
        if (i2 != 0) {
            i3++;
        }
        Segment e = m35479e(i3);
        byte[] bArr = e.f23607a;
        int i4 = e.f23609c + i3;
        while (j != 0) {
            i4--;
            bArr[i4] = f34623c[(int) (j % 10)];
            j /= 10;
        }
        if (i2 != 0) {
            bArr[i4 - 1] = 45;
        }
        e.f23609c += i3;
        this.f34625b += (long) i3;
        return this;
    }

    public final Buffer m35492j(long j) {
        if (j == 0) {
            return m35463b((int) 48);
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        Segment e = m35479e(numberOfTrailingZeros);
        byte[] bArr = e.f23607a;
        int i = e.f23609c;
        for (int i2 = (e.f23609c + numberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = f34623c[(int) (15 & j)];
            j >>>= 4;
        }
        e.f23609c += numberOfTrailingZeros;
        this.f34625b += (long) numberOfTrailingZeros;
        return this;
    }

    final Segment m35479e(int i) {
        if (i > 0) {
            if (i <= 8192) {
                Segment segment;
                if (this.f34624a == null) {
                    this.f34624a = SegmentPool.m25631a();
                    i = this.f34624a;
                    Segment segment2 = this.f34624a;
                    segment = this.f34624a;
                    segment2.f23613g = segment;
                    i.f23612f = segment;
                    return segment;
                }
                segment = this.f34624a.f23613g;
                if (segment.f23609c + i > 8192 || segment.f23611e == 0) {
                    segment = segment.m25629a(SegmentPool.m25631a());
                }
                return segment;
            }
        }
        throw new IllegalArgumentException();
    }

    public final void a_(Buffer buffer, long j) {
        if (buffer == null) {
            throw new IllegalArgumentException("source == null");
        } else if (buffer == this) {
            throw new IllegalArgumentException("source == this");
        } else {
            Util.m25643a(buffer.f34625b, 0, j);
            while (j > 0) {
                Segment segment;
                long j2;
                int i;
                int i2 = 0;
                if (j < ((long) (buffer.f34624a.f23609c - buffer.f34624a.f23608b))) {
                    segment = this.f34624a != null ? this.f34624a.f23613g : null;
                    if (segment != null && segment.f23611e) {
                        j2 = ((long) segment.f23609c) + j;
                        if (segment.f23610d) {
                            i = 0;
                        } else {
                            i = segment.f23608b;
                        }
                        if (j2 - ((long) i) <= 8192) {
                            buffer.f34624a.m25630a(segment, (int) j);
                            buffer.f34625b -= j;
                            this.f34625b += j;
                            return;
                        }
                    }
                    segment = buffer.f34624a;
                    int i3 = (int) j;
                    if (i3 > 0) {
                        if (i3 <= segment.f23609c - segment.f23608b) {
                            Segment segment2;
                            if (i3 >= 1024) {
                                segment2 = new Segment(segment);
                            } else {
                                segment2 = SegmentPool.m25631a();
                                System.arraycopy(segment.f23607a, segment.f23608b, segment2.f23607a, 0, i3);
                            }
                            segment2.f23609c = segment2.f23608b + i3;
                            segment.f23608b += i3;
                            segment.f23613g.m25629a(segment2);
                            buffer.f34624a = segment2;
                        }
                    }
                    throw new IllegalArgumentException();
                }
                segment = buffer.f34624a;
                j2 = (long) (segment.f23609c - segment.f23608b);
                buffer.f34624a = segment.m25628a();
                if (this.f34624a == null) {
                    this.f34624a = segment;
                    segment = this.f34624a;
                    Segment segment3 = this.f34624a;
                    Segment segment4 = this.f34624a;
                    segment3.f23613g = segment4;
                    segment.f23612f = segment4;
                } else {
                    segment = this.f34624a.f23613g.m25629a(segment);
                    if (segment.f23613g == segment) {
                        throw new IllegalStateException();
                    } else if (segment.f23613g.f23611e) {
                        i = segment.f23609c - segment.f23608b;
                        int i4 = 8192 - segment.f23613g.f23609c;
                        if (!segment.f23613g.f23610d) {
                            i2 = segment.f23613g.f23608b;
                        }
                        if (i <= i4 + i2) {
                            segment.m25630a(segment.f23613g, i);
                            segment.m25628a();
                            SegmentPool.m25632a(segment);
                        }
                    }
                }
                buffer.f34625b -= j2;
                this.f34625b += j2;
                j -= j2;
            }
        }
    }

    public final long mo5322a(Buffer buffer, long j) {
        if (buffer == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j < 0) {
            StringBuilder stringBuilder = new StringBuilder("byteCount < 0: ");
            stringBuilder.append(j);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (this.f34625b == 0) {
            return -1;
        } else {
            if (j > this.f34625b) {
                j = this.f34625b;
            }
            buffer.a_(this, j);
            return j;
        }
    }

    public final long mo6580s() {
        return m35449a((byte) 0, 0, Long.MAX_VALUE);
    }

    public final long m35449a(byte b, long j, long j2) {
        long j3 = 0;
        if (j >= 0) {
            if (j2 >= j) {
                if (j2 > this.f34625b) {
                    j2 = this.f34625b;
                }
                if (j == j2) {
                    return -1;
                }
                Segment segment = this.f34624a;
                if (segment == null) {
                    return -1;
                }
                if (this.f34625b - j >= j) {
                    while (true) {
                        long j4 = ((long) (segment.f23609c - segment.f23608b)) + j3;
                        if (j4 >= j) {
                            break;
                        }
                        segment = segment.f23612f;
                        j3 = j4;
                    }
                } else {
                    j3 = this.f34625b;
                    while (j3 > j) {
                        segment = segment.f23613g;
                        j3 -= (long) (segment.f23609c - segment.f23608b);
                    }
                }
                while (j3 < j2) {
                    byte[] bArr = segment.f23607a;
                    int min = (int) Math.min((long) segment.f23609c, (((long) segment.f23608b) + j2) - j3);
                    for (j = (int) ((((long) segment.f23608b) + j) - j3); j < min; j++) {
                        if (bArr[j] == b) {
                            return ((long) (j - segment.f23608b)) + j3;
                        }
                    }
                    j = ((long) (segment.f23609c - segment.f23608b)) + j3;
                    segment = segment.f23612f;
                    j3 = j;
                }
                return -1;
            }
        }
        throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", new Object[]{Long.valueOf(this.f34625b), Long.valueOf(j), Long.valueOf(j2)}));
    }

    public final boolean mo6555b(ByteString byteString) {
        int h = byteString.mo5405h();
        if (h >= 0 && this.f34625b - 0 >= ((long) h)) {
            if (byteString.mo5405h() - 0 >= h) {
                for (int i = 0; i < h; i++) {
                    if (m35461b(((long) i) + 0) != byteString.mo5392a(0 + i)) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public final Timeout mo5323a() {
        return Timeout.f23616c;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Buffer)) {
            return false;
        }
        Buffer buffer = (Buffer) obj;
        if (this.f34625b != buffer.f34625b) {
            return false;
        }
        long j = 0;
        if (this.f34625b == 0) {
            return true;
        }
        Segment segment = this.f34624a;
        obj = buffer.f34624a;
        int i = segment.f23608b;
        int i2 = obj.f23608b;
        while (j < this.f34625b) {
            long min = (long) Math.min(segment.f23609c - i, obj.f23609c - i2);
            int i3 = i2;
            i2 = i;
            i = 0;
            while (((long) i) < min) {
                int i4 = i2 + 1;
                int i5 = i3 + 1;
                if (segment.f23607a[i2] != obj.f23607a[i3]) {
                    return false;
                }
                i++;
                i2 = i4;
                i3 = i5;
            }
            if (i2 == segment.f23609c) {
                segment = segment.f23612f;
                i = segment.f23608b;
            } else {
                i = i2;
            }
            if (i3 == obj.f23609c) {
                obj = obj.f23612f;
                i2 = obj.f23608b;
            } else {
                i2 = i3;
            }
            j += min;
        }
        return true;
    }

    public final int hashCode() {
        Segment segment = this.f34624a;
        if (segment == null) {
            return 0;
        }
        int i = 1;
        do {
            for (int i2 = segment.f23608b; i2 < segment.f23609c; i2++) {
                i = segment.f23607a[i2] + (31 * i);
            }
            segment = segment.f23612f;
        } while (segment != this.f34624a);
        return i;
    }

    public final String toString() {
        if (this.f34625b > 2147483647L) {
            StringBuilder stringBuilder = new StringBuilder("size > Integer.MAX_VALUE: ");
            stringBuilder.append(this.f34625b);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        ByteString byteString;
        int i = (int) this.f34625b;
        if (i == 0) {
            byteString = ByteString.f23602b;
        } else {
            byteString = new SegmentedByteString(this, i);
        }
        return byteString.toString();
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        Buffer buffer = new Buffer();
        if (this.f34625b == 0) {
            return buffer;
        }
        buffer.f34624a = new Segment(this.f34624a);
        Segment segment = buffer.f34624a;
        Segment segment2 = buffer.f34624a;
        Segment segment3 = buffer.f34624a;
        segment2.f23613g = segment3;
        segment.f23612f = segment3;
        segment = this.f34624a;
        while (true) {
            segment = segment.f23612f;
            if (segment != this.f34624a) {
                buffer.f34624a.f23613g.m25629a(new Segment(segment));
            } else {
                buffer.f34625b = this.f34625b;
                return buffer;
            }
        }
    }
}
