package okio;

import com.facebook.stetho.dumpapp.Framer;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import org.jcodec.codecs.mjpeg.JpegConst;
import org.jcodec.codecs.mpeg12.MPEGConst;

public final class Buffer implements Cloneable, BufferedSink, BufferedSource {
    private static final byte[] f36199c = new byte[]{(byte) 48, Framer.STDOUT_FRAME_PREFIX, Framer.STDERR_FRAME_PREFIX, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 97, (byte) 98, (byte) 99, (byte) 100, (byte) 101, (byte) 102};
    Segment f36200a;
    public long f36201b;

    class C21851 extends OutputStream {
        final /* synthetic */ Buffer f26661a;

        public void close() {
        }

        public void flush() {
        }

        C21851(Buffer buffer) {
            this.f26661a = buffer;
        }

        public void write(int i) {
            this.f26661a.m36493b((byte) i);
        }

        public void write(byte[] bArr, int i, int i2) {
            this.f26661a.m36495b(bArr, i, i2);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.f26661a);
            stringBuilder.append(".outputStream()");
            return stringBuilder.toString();
        }
    }

    class C21862 extends InputStream {
        final /* synthetic */ Buffer f26662a;

        public void close() {
        }

        C21862(Buffer buffer) {
            this.f26662a = buffer;
        }

        public int read() {
            return this.f26662a.f36201b > 0 ? this.f26662a.mo6773g() & 255 : -1;
        }

        public int read(byte[] bArr, int i, int i2) {
            return this.f26662a.mo6750a(bArr, i, i2);
        }

        public int available() {
            return (int) Math.min(this.f26662a.f36201b, 2147483647L);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.f26662a);
            stringBuilder.append(".inputStream()");
            return stringBuilder.toString();
        }
    }

    public final Buffer mo6754a() {
        return this;
    }

    public final BufferedSink mo6763c() {
        return this;
    }

    public final void close() {
    }

    public final void flush() {
    }

    public final /* bridge */ /* synthetic */ BufferedSink mo6791w() throws IOException {
        return this;
    }

    public final /* synthetic */ BufferedSink mo6760b(String str) throws IOException {
        return m36482a(str);
    }

    public final /* synthetic */ BufferedSink mo6761b(String str, int i, int i2) throws IOException {
        return m36483a(str, i, i2);
    }

    public final /* synthetic */ BufferedSink mo6764c(byte[] bArr) throws IOException {
        return m36494b(bArr);
    }

    public final /* synthetic */ BufferedSink mo6765c(byte[] bArr, int i, int i2) throws IOException {
        return m36495b(bArr, i, i2);
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        return m36541v();
    }

    public final /* synthetic */ BufferedSink mo6767d(ByteString byteString) throws IOException {
        return m36486a(byteString);
    }

    public final /* synthetic */ BufferedSink mo6772f(int i) throws IOException {
        return m36505d(i);
    }

    public final /* synthetic */ BufferedSink mo6774g(int i) throws IOException {
        return m36500c(i);
    }

    public final /* synthetic */ BufferedSink mo6775h(int i) throws IOException {
        return m36493b(i);
    }

    public final /* synthetic */ BufferedSink mo6784m(long j) throws IOException {
        return m36528l(j);
    }

    public final /* synthetic */ BufferedSink mo6786n(long j) throws IOException {
        return m36525k(j);
    }

    public final /* synthetic */ BufferedSink mo6787o(long j) throws IOException {
        return m36524j(j);
    }

    public final OutputStream mo6759b() {
        return new C21851(this);
    }

    public final boolean mo6769d() {
        return this.f36201b == 0;
    }

    public final void mo6755a(long j) throws EOFException {
        if (this.f36201b < j) {
            throw new EOFException();
        }
    }

    public final boolean mo6762b(long j) {
        return this.f36201b >= j ? 1 : 0;
    }

    public final InputStream mo6770e() {
        return new C21862(this);
    }

    public final Buffer m36485a(Buffer buffer, long j, long j2) {
        if (buffer == null) {
            throw new IllegalArgumentException("out == null");
        }
        Util.m28310a(this.f36201b, j, j2);
        if (j2 == 0) {
            return this;
        }
        buffer.f36201b += j2;
        Segment segment = this.f36200a;
        while (j >= ((long) (segment.f26680c - segment.f26679b))) {
            j -= (long) (segment.f26680c - segment.f26679b);
            segment = segment.f26683f;
        }
        while (j2 > 0) {
            Segment segment2 = new Segment(segment);
            segment2.f26679b = (int) (((long) segment2.f26679b) + j);
            segment2.f26680c = Math.min(segment2.f26679b + ((int) j2), segment2.f26680c);
            if (buffer.f36200a == null) {
                segment2.f26684g = segment2;
                segment2.f26683f = segment2;
                buffer.f36200a = segment2;
            } else {
                buffer.f36200a.f26684g.m28304a(segment2);
            }
            j2 -= (long) (segment2.f26680c - segment2.f26679b);
            segment = segment.f26683f;
            j = 0;
        }
        return this;
    }

    public final long m36512f() {
        long j = this.f36201b;
        if (j == 0) {
            return 0;
        }
        Segment segment = this.f36200a.f26684g;
        if (segment.f26680c < 8192 && segment.f26682e) {
            j -= (long) (segment.f26680c - segment.f26679b);
        }
        return j;
    }

    public final byte mo6773g() {
        if (this.f36201b == 0) {
            throw new IllegalStateException("size == 0");
        }
        Segment segment = this.f36200a;
        int i = segment.f26679b;
        int i2 = segment.f26680c;
        int i3 = i + 1;
        byte b = segment.f26678a[i];
        this.f36201b--;
        if (i3 == i2) {
            this.f36200a = segment.m28303a();
            SegmentPool.m28307a(segment);
        } else {
            segment.f26679b = i3;
        }
        return b;
    }

    public final byte m36499c(long j) {
        Util.m28310a(this.f36201b, j, 1);
        Segment segment = this.f36200a;
        while (true) {
            long j2 = (long) (segment.f26680c - segment.f26679b);
            if (j < j2) {
                return segment.f26678a[segment.f26679b + ((int) j)];
            }
            j -= j2;
            segment = segment.f26683f;
        }
    }

    public final short mo6776h() {
        if (this.f36201b < 2) {
            StringBuilder stringBuilder = new StringBuilder("size < 2: ");
            stringBuilder.append(this.f36201b);
            throw new IllegalStateException(stringBuilder.toString());
        }
        Segment segment = this.f36200a;
        int i = segment.f26679b;
        int i2 = segment.f26680c;
        if (i2 - i < 2) {
            return (short) (((mo6773g() & 255) << 8) | (mo6773g() & 255));
        }
        byte[] bArr = segment.f26678a;
        int i3 = i + 1;
        int i4 = i3 + 1;
        i = ((bArr[i] & 255) << 8) | (bArr[i3] & 255);
        this.f36201b -= 2;
        if (i4 == i2) {
            this.f36200a = segment.m28303a();
            SegmentPool.m28307a(segment);
        } else {
            segment.f26679b = i4;
        }
        return (short) i;
    }

    public final int mo6778i() {
        if (this.f36201b < 4) {
            StringBuilder stringBuilder = new StringBuilder("size < 4: ");
            stringBuilder.append(this.f36201b);
            throw new IllegalStateException(stringBuilder.toString());
        }
        Segment segment = this.f36200a;
        int i = segment.f26679b;
        int i2 = segment.f26680c;
        if (i2 - i < 4) {
            return ((((mo6773g() & 255) << 24) | ((mo6773g() & 255) << 16)) | ((mo6773g() & 255) << 8)) | (mo6773g() & 255);
        }
        byte[] bArr = segment.f26678a;
        int i3 = i + 1;
        int i4 = i3 + 1;
        i = ((bArr[i] & 255) << 24) | ((bArr[i3] & 255) << 16);
        i3 = i4 + 1;
        i |= (bArr[i4] & 255) << 8;
        i4 = i3 + 1;
        i |= bArr[i3] & 255;
        this.f36201b -= 4;
        if (i4 == i2) {
            this.f36200a = segment.m28303a();
            SegmentPool.m28307a(segment);
        } else {
            segment.f26679b = i4;
        }
        return i;
    }

    public final long mo6780j() {
        if (this.f36201b < 8) {
            StringBuilder stringBuilder = new StringBuilder("size < 8: ");
            stringBuilder.append(this.f36201b);
            throw new IllegalStateException(stringBuilder.toString());
        }
        Segment segment = this.f36200a;
        int i = segment.f26679b;
        int i2 = segment.f26680c;
        if (i2 - i < 8) {
            return ((((long) mo6778i()) & 4294967295L) << 32) | (4294967295L & ((long) mo6778i()));
        }
        byte[] bArr = segment.f26678a;
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
        this.f36201b -= 8;
        if (i == i2) {
            this.f36200a = segment.m28303a();
            SegmentPool.m28307a(segment);
        } else {
            segment.f26679b = i;
        }
        return j2;
    }

    public final short mo6781k() {
        return Util.m28309a(mo6776h());
    }

    public final int mo6782l() {
        return Util.m28308a(mo6778i());
    }

    public final long mo6783m() {
        if (this.f36201b == 0) {
            throw new IllegalStateException("size == 0");
        }
        long j = -7;
        int i = 0;
        long j2 = 0;
        int i2 = 0;
        int i3 = i2;
        do {
            Segment segment;
            Segment segment2 = r0.f36200a;
            byte[] bArr = segment2.f26678a;
            int i4 = segment2.f26679b;
            int i5 = segment2.f26680c;
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
                                r0.f36200a = segment2.m28303a();
                                SegmentPool.m28307a(segment2);
                            } else {
                                segment.f26679b = i4;
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
                    Buffer b = new Buffer().m36525k(j2).m36493b(i6);
                    if (i2 == 0) {
                        b.mo6773g();
                    }
                    StringBuilder stringBuilder2 = new StringBuilder("Number too large: ");
                    stringBuilder2.append(b.m36535p());
                    throw new NumberFormatException(stringBuilder2.toString());
                }
                i4++;
                i++;
                segment2 = segment;
                bArr = bArr2;
            }
            segment = segment2;
            if (i4 != i5) {
                segment.f26679b = i4;
            } else {
                segment2 = segment;
                r0.f36200a = segment2.m28303a();
                SegmentPool.m28307a(segment2);
            }
            if (i3 == 0) {
                break;
            }
        } while (r0.f36200a != null);
        r0.f36201b -= (long) i;
        return i2 != 0 ? j2 : -j2;
    }

    public final long mo6785n() {
        if (this.f36201b == 0) {
            throw new IllegalStateException("size == 0");
        }
        int i = 0;
        int i2 = 0;
        long j = 0;
        do {
            Segment segment = this.f36200a;
            byte[] bArr = segment.f26678a;
            int i3 = segment.f26679b;
            int i4 = segment.f26680c;
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
                            this.f36200a = segment.m28303a();
                            SegmentPool.m28307a(segment);
                        } else {
                            segment.f26679b = i3;
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
                    Buffer b = new Buffer().m36528l(j).m36493b(i6);
                    StringBuilder stringBuilder2 = new StringBuilder("Number too large: ");
                    stringBuilder2.append(b.m36535p());
                    throw new NumberFormatException(stringBuilder2.toString());
                }
                j = (j << 4) | ((long) i5);
                i3++;
                i++;
            }
            if (i3 != i4) {
                segment.f26679b = i3;
            } else {
                this.f36200a = segment.m28303a();
                SegmentPool.m28307a(segment);
            }
            if (i2 == 0) {
                break;
            }
        } while (this.f36200a != null);
        this.f36201b -= (long) i;
        return j;
    }

    public final ByteString m36534o() {
        return new ByteString(mo6789s());
    }

    public final ByteString mo6768d(long j) throws EOFException {
        return new ByteString(mo6777h(j));
    }

    public final int mo6749a(Options options) {
        Segment segment = this.f36200a;
        if (segment == null) {
            return options.indexOf(ByteString.f26664b);
        }
        options = options.f26669a;
        int i = 0;
        int length = options.length;
        while (i < length) {
            ByteString byteString = options[i];
            if (this.f36201b < ((long) byteString.mo6166h()) || !m36472a(segment, segment.f26679b, byteString, byteString.mo6166h())) {
                i++;
            } else {
                try {
                    mo6779i((long) byteString.mo6166h());
                    return i;
                } catch (Options options2) {
                    throw new AssertionError(options2);
                }
            }
        }
        return -1;
    }

    final int m36490b(Options options) {
        Segment segment = this.f36200a;
        options = options.f26669a;
        int i = 0;
        int length = options.length;
        while (i < length) {
            ByteString byteString = options[i];
            int min = (int) Math.min(this.f36201b, (long) byteString.mo6166h());
            if (min != 0) {
                if (!m36472a(segment, segment.f26679b, byteString, min)) {
                    i++;
                }
            }
            return i;
        }
        return -1;
    }

    public final void mo6756a(Buffer buffer, long j) throws EOFException {
        if (this.f36201b < j) {
            buffer.write(this, this.f36201b);
            throw new EOFException();
        } else {
            buffer.write(this, j);
        }
    }

    public final long mo6751a(Sink sink) throws IOException {
        long j = this.f36201b;
        if (j > 0) {
            sink.write(this, j);
        }
        return j;
    }

    public final String m36535p() {
        try {
            return m36471a(this.f36201b, Util.f26687a);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public final String m36510e(long j) throws EOFException {
        return m36471a(j, Util.f26687a);
    }

    public final String mo6753a(Charset charset) {
        try {
            return m36471a(this.f36201b, charset);
        } catch (Charset charset2) {
            throw new AssertionError(charset2);
        }
    }

    private String m36471a(long j, Charset charset) throws EOFException {
        Util.m28310a(this.f36201b, 0, j);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        } else if (j > 2147483647L) {
            StringBuilder stringBuilder = new StringBuilder("byteCount > Integer.MAX_VALUE: ");
            stringBuilder.append(j);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (j == 0) {
            return "";
        } else {
            Segment segment = this.f36200a;
            if (((long) segment.f26679b) + j > ((long) segment.f26680c)) {
                return new String(mo6777h(j), charset);
            }
            String str = new String(segment.f26678a, segment.f26679b, (int) j, charset);
            segment.f26679b = (int) (((long) segment.f26679b) + j);
            this.f36201b -= j;
            if (segment.f26679b == segment.f26680c) {
                this.f36200a = segment.m28303a();
                SegmentPool.m28307a(segment);
            }
            return str;
        }
    }

    public final String mo6788q() throws EOFException {
        return mo6771f(Long.MAX_VALUE);
    }

    public final String mo6771f(long j) throws EOFException {
        if (j < 0) {
            StringBuilder stringBuilder = new StringBuilder("limit < 0: ");
            stringBuilder.append(j);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        long j2 = Long.MAX_VALUE;
        if (j != Long.MAX_VALUE) {
            j2 = j + 1;
        }
        long a = m36475a((byte) 10, 0, j2);
        if (a != -1) {
            return m36516g(a);
        }
        if (j2 < this.f36201b && m36499c(j2 - 1) == (byte) 13 && m36499c(j2) == (byte) 10) {
            return m36516g(j2);
        }
        Buffer buffer = new Buffer();
        m36485a(buffer, 0, Math.min(32, this.f36201b));
        stringBuilder = new StringBuilder("\\n not found: limit=");
        stringBuilder.append(Math.min(this.f36201b, j));
        stringBuilder.append(" content=");
        stringBuilder.append(buffer.m36534o().mo6164f());
        stringBuilder.append(8230);
        throw new EOFException(stringBuilder.toString());
    }

    final String m36516g(long j) throws EOFException {
        if (j > 0) {
            long j2 = j - 1;
            if (m36499c(j2) == (byte) 13) {
                j = m36510e(j2);
                mo6779i(2);
                return j;
            }
        }
        j = m36510e(j);
        mo6779i(1);
        return j;
    }

    public final int m36537r() throws EOFException {
        if (this.f36201b == 0) {
            throw new EOFException();
        }
        int i;
        int i2;
        byte c = m36499c(0);
        int i3 = 1;
        int i4;
        if ((c & 128) == 0) {
            i = c & 127;
            i4 = 0;
            i2 = 1;
        } else if ((c & JpegConst.APP0) == JpegConst.SOF0) {
            i = c & 31;
            i2 = 2;
            i4 = 128;
        } else if ((c & 240) == JpegConst.APP0) {
            i = c & 15;
            i2 = 3;
            i4 = MPEGConst.CODE_END;
        } else if ((c & 248) == 240) {
            i = c & 7;
            i2 = 4;
            i4 = 65536;
        } else {
            mo6779i(1);
            return 65533;
        }
        long j = (long) i2;
        if (this.f36201b < j) {
            StringBuilder stringBuilder = new StringBuilder("size < ");
            stringBuilder.append(i2);
            stringBuilder.append(": ");
            stringBuilder.append(this.f36201b);
            stringBuilder.append(" (to read code point prefixed 0x");
            stringBuilder.append(Integer.toHexString(c));
            stringBuilder.append(")");
            throw new EOFException(stringBuilder.toString());
        }
        while (i3 < i2) {
            long j2 = (long) i3;
            c = m36499c(j2);
            if ((c & JpegConst.SOF0) == 128) {
                i = (i << 6) | (c & 63);
                i3++;
            } else {
                mo6779i(j2);
                return 65533;
            }
        }
        mo6779i(j);
        if (i > 1114111) {
            return 65533;
        }
        if ((i < 55296 || i > 57343) && i >= r6) {
            return i;
        }
        return 65533;
    }

    public final byte[] mo6789s() {
        try {
            return mo6777h(this.f36201b);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public final byte[] mo6777h(long j) throws EOFException {
        Util.m28310a(this.f36201b, 0, j);
        if (j > 2147483647L) {
            StringBuilder stringBuilder = new StringBuilder("byteCount > Integer.MAX_VALUE: ");
            stringBuilder.append(j);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        byte[] bArr = new byte[((int) j)];
        mo6757a(bArr);
        return bArr;
    }

    public final void mo6757a(byte[] bArr) throws EOFException {
        int i = 0;
        while (i < bArr.length) {
            int a = mo6750a(bArr, i, bArr.length - i);
            if (a == -1) {
                throw new EOFException();
            }
            i += a;
        }
    }

    public final int mo6750a(byte[] bArr, int i, int i2) {
        Util.m28310a((long) bArr.length, (long) i, (long) i2);
        Segment segment = this.f36200a;
        if (segment == null) {
            return -1;
        }
        i2 = Math.min(i2, segment.f26680c - segment.f26679b);
        System.arraycopy(segment.f26678a, segment.f26679b, bArr, i, i2);
        segment.f26679b += i2;
        this.f36201b -= (long) i2;
        if (segment.f26679b == segment.f26680c) {
            this.f36200a = segment.m28303a();
            SegmentPool.m28307a(segment);
        }
        return i2;
    }

    public final void m36539t() {
        try {
            mo6779i(this.f36201b);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public final void mo6779i(long j) throws EOFException {
        while (j > 0) {
            if (this.f36200a == null) {
                throw new EOFException();
            }
            int min = (int) Math.min(j, (long) (this.f36200a.f26680c - this.f36200a.f26679b));
            long j2 = (long) min;
            this.f36201b -= j2;
            j -= j2;
            Segment segment = this.f36200a;
            segment.f26679b += min;
            if (this.f36200a.f26679b == this.f36200a.f26680c) {
                Segment segment2 = this.f36200a;
                this.f36200a = segment2.m28303a();
                SegmentPool.m28307a(segment2);
            }
        }
    }

    public final Buffer m36486a(ByteString byteString) {
        if (byteString == null) {
            throw new IllegalArgumentException("byteString == null");
        }
        byteString.mo6156a(this);
        return this;
    }

    public final Buffer m36482a(String str) {
        return m36483a(str, 0, str.length());
    }

    public final Buffer m36483a(String str, int i, int i2) {
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
                    Segment e = m36511e(1);
                    byte[] bArr = e.f26678a;
                    i3 = e.f26680c - i;
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
                    i3 = (i3 + i) - e.f26680c;
                    e.f26680c += i3;
                    this.f36201b += (long) i3;
                } else if (charAt < 'ࠀ') {
                    m36493b((charAt >> 6) | JpegConst.SOF0);
                    m36493b((charAt & 63) | 128);
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
                                    m36493b((i5 >> 18) | 240);
                                    m36493b(((i5 >> 12) & 63) | 128);
                                    m36493b(((i5 >> 6) & 63) | 128);
                                    m36493b((i5 & 63) | 128);
                                    i += 2;
                                }
                            }
                            m36493b(63);
                            i = i3;
                        }
                    }
                    m36493b((charAt >> 12) | JpegConst.APP0);
                    m36493b(((charAt >> 6) & 63) | 128);
                    m36493b((charAt & 63) | 128);
                    i++;
                }
            }
            return this;
        }
    }

    public final Buffer m36481a(int i) {
        if (i < 128) {
            m36493b(i);
        } else if (i < MPEGConst.CODE_END) {
            m36493b((i >> 6) | JpegConst.SOF0);
            m36493b((i & 63) | 128);
        } else if (i < 65536) {
            if (i < 55296 || i > 57343) {
                m36493b((i >> 12) | JpegConst.APP0);
                m36493b(((i >> 6) & 63) | 128);
                m36493b((i & 63) | 128);
            } else {
                m36493b(63);
            }
        } else if (i <= 1114111) {
            m36493b((i >> 18) | 240);
            m36493b(((i >> 12) & 63) | 128);
            m36493b(((i >> 6) & 63) | 128);
            m36493b((i & 63) | 128);
        } else {
            StringBuilder stringBuilder = new StringBuilder("Unexpected code point: ");
            stringBuilder.append(Integer.toHexString(i));
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        return this;
    }

    public final Buffer m36484a(String str, int i, int i2, Charset charset) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        } else if (i < 0) {
            i2 = new StringBuilder("beginIndex < 0: ");
            i2.append(i);
            throw new IllegalAccessError(i2.toString());
        } else if (i2 < i) {
            charset = new StringBuilder("endIndex < beginIndex: ");
            charset.append(i2);
            charset.append(" < ");
            charset.append(i);
            throw new IllegalArgumentException(charset.toString());
        } else if (i2 > str.length()) {
            charset = new StringBuilder("endIndex > string.length: ");
            charset.append(i2);
            charset.append(" > ");
            charset.append(str.length());
            throw new IllegalArgumentException(charset.toString());
        } else if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        } else if (charset.equals(Util.f26687a)) {
            return m36483a(str, i, i2);
        } else {
            byte[] bytes = str.substring(i, i2).getBytes(charset);
            return m36495b(bytes, 0, bytes.length);
        }
    }

    public final Buffer m36494b(byte[] bArr) {
        if (bArr != null) {
            return m36495b(bArr, 0, bArr.length);
        }
        throw new IllegalArgumentException("source == null");
    }

    public final Buffer m36495b(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = (long) i2;
        Util.m28310a((long) bArr.length, (long) i, j);
        i2 += i;
        while (i < i2) {
            Segment e = m36511e(1);
            int min = Math.min(i2 - i, 8192 - e.f26680c);
            System.arraycopy(bArr, i, e.f26678a, e.f26680c, min);
            i += min;
            e.f26680c += min;
        }
        this.f36201b += j;
        return this;
    }

    public final long mo6752a(Source source) throws IOException {
        if (source == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long read = source.read(this, 8192);
            if (read == -1) {
                return j;
            }
            j += read;
        }
    }

    public final Buffer m36493b(int i) {
        Segment e = m36511e(1);
        byte[] bArr = e.f26678a;
        int i2 = e.f26680c;
        e.f26680c = i2 + 1;
        bArr[i2] = (byte) i;
        this.f36201b++;
        return this;
    }

    public final Buffer m36500c(int i) {
        Segment e = m36511e(2);
        byte[] bArr = e.f26678a;
        int i2 = e.f26680c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        i2 = i3 + 1;
        bArr[i3] = (byte) (i & 255);
        e.f26680c = i2;
        this.f36201b += 2;
        return this;
    }

    public final Buffer m36505d(int i) {
        Segment e = m36511e(4);
        byte[] bArr = e.f26678a;
        int i2 = e.f26680c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        i2 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 16) & 255);
        i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        i2 = i3 + 1;
        bArr[i3] = (byte) (i & 255);
        e.f26680c = i2;
        this.f36201b += 4;
        return this;
    }

    public final Buffer m36524j(long j) {
        Segment e = m36511e(8);
        byte[] bArr = e.f26678a;
        int i = e.f26680c;
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
        e.f26680c = i3;
        this.f36201b += 8;
        return this;
    }

    public final Buffer m36525k(long j) {
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i == 0) {
            return m36493b((int) 48);
        }
        int i2 = 0;
        int i3 = 1;
        if (i < 0) {
            j = -j;
            if (j < 0) {
                return m36482a("-9223372036854775808");
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
        Segment e = m36511e(i3);
        byte[] bArr = e.f26678a;
        int i4 = e.f26680c + i3;
        while (j != 0) {
            i4--;
            bArr[i4] = f36199c[(int) (j % 10)];
            j /= 10;
        }
        if (i2 != 0) {
            bArr[i4 - 1] = 45;
        }
        e.f26680c += i3;
        this.f36201b += (long) i3;
        return this;
    }

    public final Buffer m36528l(long j) {
        if (j == 0) {
            return m36493b((int) 48);
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        Segment e = m36511e(numberOfTrailingZeros);
        byte[] bArr = e.f26678a;
        int i = e.f26680c;
        for (int i2 = (e.f26680c + numberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = f36199c[(int) (15 & j)];
            j >>>= 4;
        }
        e.f26680c += numberOfTrailingZeros;
        this.f36201b += (long) numberOfTrailingZeros;
        return this;
    }

    final Segment m36511e(int i) {
        if (i > 0) {
            if (i <= 8192) {
                Segment segment;
                if (this.f36200a == null) {
                    this.f36200a = SegmentPool.m28306a();
                    i = this.f36200a;
                    Segment segment2 = this.f36200a;
                    segment = this.f36200a;
                    segment2.f26684g = segment;
                    i.f26683f = segment;
                    return segment;
                }
                segment = this.f36200a.f26684g;
                if (segment.f26680c + i > 8192 || segment.f26682e == 0) {
                    segment = segment.m28304a(SegmentPool.m28306a());
                }
                return segment;
            }
        }
        throw new IllegalArgumentException();
    }

    public final void write(Buffer buffer, long j) {
        if (buffer == null) {
            throw new IllegalArgumentException("source == null");
        } else if (buffer == this) {
            throw new IllegalArgumentException("source == this");
        } else {
            Util.m28310a(buffer.f36201b, 0, j);
            while (j > 0) {
                Segment segment;
                long j2;
                int i;
                int i2 = 0;
                if (j < ((long) (buffer.f36200a.f26680c - buffer.f36200a.f26679b))) {
                    segment = this.f36200a != null ? this.f36200a.f26684g : null;
                    if (segment != null && segment.f26682e) {
                        j2 = ((long) segment.f26680c) + j;
                        if (segment.f26681d) {
                            i = 0;
                        } else {
                            i = segment.f26679b;
                        }
                        if (j2 - ((long) i) <= 8192) {
                            buffer.f36200a.m28305a(segment, (int) j);
                            buffer.f36201b -= j;
                            this.f36201b += j;
                            return;
                        }
                    }
                    segment = buffer.f36200a;
                    int i3 = (int) j;
                    if (i3 > 0) {
                        if (i3 <= segment.f26680c - segment.f26679b) {
                            Segment segment2;
                            if (i3 >= 1024) {
                                segment2 = new Segment(segment);
                            } else {
                                segment2 = SegmentPool.m28306a();
                                System.arraycopy(segment.f26678a, segment.f26679b, segment2.f26678a, 0, i3);
                            }
                            segment2.f26680c = segment2.f26679b + i3;
                            segment.f26679b += i3;
                            segment.f26684g.m28304a(segment2);
                            buffer.f36200a = segment2;
                        }
                    }
                    throw new IllegalArgumentException();
                }
                segment = buffer.f36200a;
                j2 = (long) (segment.f26680c - segment.f26679b);
                buffer.f36200a = segment.m28303a();
                if (this.f36200a == null) {
                    this.f36200a = segment;
                    segment = this.f36200a;
                    Segment segment3 = this.f36200a;
                    Segment segment4 = this.f36200a;
                    segment3.f26684g = segment4;
                    segment.f26683f = segment4;
                } else {
                    segment = this.f36200a.f26684g.m28304a(segment);
                    if (segment.f26684g == segment) {
                        throw new IllegalStateException();
                    } else if (segment.f26684g.f26682e) {
                        i = segment.f26680c - segment.f26679b;
                        int i4 = 8192 - segment.f26684g.f26680c;
                        if (!segment.f26684g.f26681d) {
                            i2 = segment.f26684g.f26679b;
                        }
                        if (i <= i4 + i2) {
                            segment.m28305a(segment.f26684g, i);
                            segment.m28303a();
                            SegmentPool.m28307a(segment);
                        }
                    }
                }
                buffer.f36201b -= j2;
                this.f36201b += j2;
                j -= j2;
            }
        }
    }

    public final long read(Buffer buffer, long j) {
        if (buffer == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j < 0) {
            StringBuilder stringBuilder = new StringBuilder("byteCount < 0: ");
            stringBuilder.append(j);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (this.f36201b == 0) {
            return -1;
        } else {
            if (j > this.f36201b) {
                j = this.f36201b;
            }
            buffer.write(this, j);
            return j;
        }
    }

    public final long mo6790u() {
        return m36475a((byte) 0, 0, Long.MAX_VALUE);
    }

    public final long m36475a(byte b, long j, long j2) {
        long j3 = 0;
        if (j >= 0) {
            if (j2 >= j) {
                if (j2 > this.f36201b) {
                    j2 = this.f36201b;
                }
                if (j == j2) {
                    return -1;
                }
                Segment segment = this.f36200a;
                if (segment == null) {
                    return -1;
                }
                if (this.f36201b - j >= j) {
                    while (true) {
                        long j4 = ((long) (segment.f26680c - segment.f26679b)) + j3;
                        if (j4 >= j) {
                            break;
                        }
                        segment = segment.f26683f;
                        j3 = j4;
                    }
                } else {
                    j3 = this.f36201b;
                    while (j3 > j) {
                        segment = segment.f26684g;
                        j3 -= (long) (segment.f26680c - segment.f26679b);
                    }
                }
                while (j3 < j2) {
                    byte[] bArr = segment.f26678a;
                    int min = (int) Math.min((long) segment.f26680c, (((long) segment.f26679b) + j2) - j3);
                    for (j = (int) ((((long) segment.f26679b) + j) - j3); j < min; j++) {
                        if (bArr[j] == b) {
                            return ((long) (j - segment.f26679b)) + j3;
                        }
                    }
                    j = ((long) (segment.f26680c - segment.f26679b)) + j3;
                    segment = segment.f26683f;
                    j3 = j;
                }
                return -1;
            }
        }
        throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", new Object[]{Long.valueOf(this.f36201b), Long.valueOf(j), Long.valueOf(j2)}));
    }

    public final long mo6758b(ByteString byteString) {
        return m36476a(byteString, 0);
    }

    public final long m36476a(ByteString byteString, long j) {
        long j2 = 0;
        if (j < 0) {
            throw new IllegalArgumentException("fromIndex < 0");
        }
        Segment segment = this.f36200a;
        if (segment == null) {
            return -1;
        }
        if (this.f36201b - j >= j) {
            while (true) {
                long j3 = ((long) (segment.f26680c - segment.f26679b)) + j2;
                if (j3 >= j) {
                    break;
                }
                segment = segment.f26683f;
                j2 = j3;
            }
        } else {
            j2 = this.f36201b;
            while (j2 > j) {
                segment = segment.f26684g;
                j2 -= (long) (segment.f26680c - segment.f26679b);
            }
        }
        int i;
        if (byteString.mo6166h() == 2) {
            byte a = byteString.mo6153a(0);
            byteString = byteString.mo6153a(1);
            while (j2 < this.f36201b) {
                byte[] bArr = segment.f26678a;
                j = (int) ((((long) segment.f26679b) + j) - j2);
                i = segment.f26680c;
                while (j < i) {
                    byte b = bArr[j];
                    if (b != a) {
                        if (b != byteString) {
                            j++;
                        }
                    }
                    return ((long) (j - segment.f26679b)) + j2;
                }
                j = ((long) (segment.f26680c - segment.f26679b)) + j2;
                segment = segment.f26683f;
                j2 = j;
            }
        } else {
            byteString = byteString.mo6169j();
            while (j2 < this.f36201b) {
                byte[] bArr2 = segment.f26678a;
                i = segment.f26680c;
                for (j = (int) ((((long) segment.f26679b) + j) - j2); j < i; j++) {
                    byte b2 = bArr2[j];
                    for (byte b3 : byteString) {
                        if (b2 == b3) {
                            return ((long) (j - segment.f26679b)) + j2;
                        }
                    }
                }
                j = ((long) (segment.f26680c - segment.f26679b)) + j2;
                segment = segment.f26683f;
                j2 = j;
            }
        }
        return -1;
    }

    public final boolean mo6766c(ByteString byteString) {
        int h = byteString.mo6166h();
        if (h >= 0 && this.f36201b - 0 >= ((long) h)) {
            if (byteString.mo6166h() - 0 >= h) {
                for (int i = 0; i < h; i++) {
                    if (m36499c(((long) i) + 0) != byteString.mo6153a(0 + i)) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    private static boolean m36472a(Segment segment, int i, ByteString byteString, int i2) {
        int i3 = segment.f26680c;
        byte[] bArr = segment.f26678a;
        Segment segment2 = segment;
        for (int i4 = null; i4 < i2; i4++) {
            if (i == i3) {
                i = segment2.f26683f;
                byte[] bArr2 = i.f26678a;
                int i5 = i.f26679b;
                int i6 = i.f26680c;
                int i7 = i5;
                segment2 = i;
                i = i7;
                int i8 = i6;
                bArr = bArr2;
                i3 = i8;
            }
            if (bArr[i] != byteString.mo6153a(i4)) {
                return false;
            }
            i++;
        }
        return true;
    }

    public final Timeout timeout() {
        return Timeout.NONE;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Buffer)) {
            return false;
        }
        Buffer buffer = (Buffer) obj;
        if (this.f36201b != buffer.f36201b) {
            return false;
        }
        long j = 0;
        if (this.f36201b == 0) {
            return true;
        }
        Segment segment = this.f36200a;
        obj = buffer.f36200a;
        int i = segment.f26679b;
        int i2 = obj.f26679b;
        while (j < this.f36201b) {
            long min = (long) Math.min(segment.f26680c - i, obj.f26680c - i2);
            int i3 = i2;
            i2 = i;
            i = 0;
            while (((long) i) < min) {
                int i4 = i2 + 1;
                int i5 = i3 + 1;
                if (segment.f26678a[i2] != obj.f26678a[i3]) {
                    return false;
                }
                i++;
                i2 = i4;
                i3 = i5;
            }
            if (i2 == segment.f26680c) {
                segment = segment.f26683f;
                i = segment.f26679b;
            } else {
                i = i2;
            }
            if (i3 == obj.f26680c) {
                obj = obj.f26683f;
                i2 = obj.f26679b;
            } else {
                i2 = i3;
            }
            j += min;
        }
        return true;
    }

    public final int hashCode() {
        Segment segment = this.f36200a;
        if (segment == null) {
            return 0;
        }
        int i = 1;
        do {
            for (int i2 = segment.f26679b; i2 < segment.f26680c; i2++) {
                i = segment.f26678a[i2] + (31 * i);
            }
            segment = segment.f26683f;
        } while (segment != this.f36200a);
        return i;
    }

    public final Buffer m36541v() {
        Buffer buffer = new Buffer();
        if (this.f36201b == 0) {
            return buffer;
        }
        buffer.f36200a = new Segment(this.f36200a);
        Segment segment = buffer.f36200a;
        Segment segment2 = buffer.f36200a;
        Segment segment3 = buffer.f36200a;
        segment2.f26684g = segment3;
        segment.f26683f = segment3;
        segment = this.f36200a;
        while (true) {
            segment = segment.f26683f;
            if (segment != this.f36200a) {
                buffer.f36200a.f26684g.m28304a(new Segment(segment));
            } else {
                buffer.f36201b = this.f36201b;
                return buffer;
            }
        }
    }

    public final String toString() {
        if (this.f36201b > 2147483647L) {
            StringBuilder stringBuilder = new StringBuilder("size > Integer.MAX_VALUE: ");
            stringBuilder.append(this.f36201b);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        ByteString byteString;
        int i = (int) this.f36201b;
        if (i == 0) {
            byteString = ByteString.f26664b;
        } else {
            byteString = new SegmentedByteString(this, i);
        }
        return byteString.toString();
    }
}
