package kotlin.reflect.jvm.internal.impl.protobuf;

import com.reddit.datalibrary.frontpage.job.RedditJobManager;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import org.jcodec.containers.mkv.util.EbmlUtil;

public final class CodedInputStream {
    final byte[] f25893a;
    int f25894b;
    int f25895c;
    int f25896d;
    int f25897e;
    private final boolean f25898f;
    private int f25899g;
    private final InputStream f25900h;
    private int f25901i;
    private boolean f25902j;
    private int f25903k;
    private int f25904l;
    private int f25905m;
    private RefillCallback f25906n;

    private interface RefillCallback {
    }

    public static CodedInputStream m27474a(InputStream inputStream) {
        return new CodedInputStream(inputStream);
    }

    static CodedInputStream m27475a(LiteralByteString literalByteString) {
        CodedInputStream codedInputStream = new CodedInputStream(literalByteString);
        try {
            codedInputStream.m27487b(literalByteString.mo5868a());
            return codedInputStream;
        } catch (LiteralByteString literalByteString2) {
            throw new IllegalArgumentException(literalByteString2);
        }
    }

    public final void m27484a(int i) throws InvalidProtocolBufferException {
        if (this.f25901i != i) {
            throw InvalidProtocolBufferException.m27532e();
        }
    }

    public final boolean m27485a(int i, CodedOutputStream codedOutputStream) throws IOException {
        switch (WireFormat.m27579a(i)) {
            case 0:
                long g = m27494g();
                codedOutputStream.m27502b(i);
                while ((-128 & g) != 0) {
                    codedOutputStream.m27500a((((int) g) & 127) | 128);
                    g >>>= 7;
                }
                codedOutputStream.m27500a((int) g);
                return true;
            case 1:
                long i2 = m27496i();
                codedOutputStream.m27502b(i);
                codedOutputStream.m27500a(((int) i2) & 255);
                codedOutputStream.m27500a(((int) (i2 >> 8)) & 255);
                codedOutputStream.m27500a(((int) (i2 >> 16)) & 255);
                codedOutputStream.m27500a(((int) (i2 >> 24)) & 255);
                codedOutputStream.m27500a(((int) (i2 >> 32)) & 255);
                codedOutputStream.m27500a(((int) (i2 >> 40)) & 255);
                codedOutputStream.m27500a(((int) (i2 >> 48)) & 255);
                codedOutputStream.m27500a(((int) (i2 >> 56)) & 255);
                return true;
            case 2:
                ByteString d = m27490d();
                codedOutputStream.m27502b(i);
                codedOutputStream.m27502b(d.mo5868a());
                i = d.mo5868a();
                if (codedOutputStream.f25908b - codedOutputStream.f25909c >= i) {
                    d.m27464b(codedOutputStream.f25907a, 0, codedOutputStream.f25909c, i);
                    codedOutputStream.f25909c += i;
                } else {
                    int i3 = codedOutputStream.f25908b - codedOutputStream.f25909c;
                    d.m27464b(codedOutputStream.f25907a, 0, codedOutputStream.f25909c, i3);
                    int i4 = 0 + i3;
                    i -= i3;
                    codedOutputStream.f25909c = codedOutputStream.f25908b;
                    codedOutputStream.f25910d += i3;
                    codedOutputStream.m27499a();
                    if (i <= codedOutputStream.f25908b) {
                        d.m27464b(codedOutputStream.f25907a, i4, 0, i);
                        codedOutputStream.f25909c = i;
                    } else {
                        OutputStream outputStream = codedOutputStream.f25911e;
                        if (i4 < 0) {
                            codedOutputStream = new StringBuilder(30);
                            codedOutputStream.append("Source offset < 0: ");
                            codedOutputStream.append(i4);
                            throw new IndexOutOfBoundsException(codedOutputStream.toString());
                        } else if (i < 0) {
                            StringBuilder stringBuilder = new StringBuilder(23);
                            stringBuilder.append("Length < 0: ");
                            stringBuilder.append(i);
                            throw new IndexOutOfBoundsException(stringBuilder.toString());
                        } else {
                            int i5 = i4 + i;
                            if (i5 > d.mo5868a()) {
                                codedOutputStream = new StringBuilder(39);
                                codedOutputStream.append("Source end offset exceeded: ");
                                codedOutputStream.append(i5);
                                throw new IndexOutOfBoundsException(codedOutputStream.toString());
                            } else if (i > 0) {
                                d.mo5871a(outputStream, i4, i);
                            }
                        }
                    }
                }
                codedOutputStream.f25910d += i;
                return true;
            case 3:
                codedOutputStream.m27502b(i);
                m27476a(codedOutputStream);
                i = WireFormat.m27581c(WireFormat.m27580b(i));
                m27484a(i);
                codedOutputStream.m27502b(i);
                return true;
            case 4:
                return false;
            case 5:
                int h = m27495h();
                codedOutputStream.m27502b(i);
                codedOutputStream.m27500a(h & 255);
                codedOutputStream.m27500a((h >> 8) & 255);
                codedOutputStream.m27500a((h >> 16) & 255);
                codedOutputStream.m27500a((h >> 24) & 255);
                return true;
            default:
                throw InvalidProtocolBufferException.m27533f();
        }
    }

    private void m27476a(CodedOutputStream codedOutputStream) throws IOException {
        int a;
        do {
            a = m27482a();
            if (a == 0) {
                return;
            }
        } while (m27485a(a, codedOutputStream));
    }

    public final int m27486b() throws IOException {
        return m27493f();
    }

    public final boolean m27489c() throws IOException {
        return m27494g() != 0;
    }

    public final <T extends MessageLite> T m27483a(Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        int f = m27493f();
        if (this.f25896d >= this.f25897e) {
            throw InvalidProtocolBufferException.m27534g();
        }
        f = m27487b(f);
        this.f25896d++;
        MessageLite messageLite = (MessageLite) parser.mo6731a(this, extensionRegistryLite);
        m27484a((int) null);
        this.f25896d--;
        m27488c(f);
        return messageLite;
    }

    public final ByteString m27490d() throws IOException {
        int f = m27493f();
        if (f <= this.f25894b - this.f25895c && f > 0) {
            ByteString boundedByteString = (this.f25898f && this.f25902j) ? new BoundedByteString(this.f25893a, this.f25895c, f) : ByteString.m27455a(this.f25893a, this.f25895c, f);
            this.f25895c += f;
            return boundedByteString;
        } else if (f == 0) {
            return ByteString.f25891b;
        } else {
            return new LiteralByteString(m27491d(f));
        }
    }

    public final long m27492e() throws IOException {
        long g = m27494g();
        return (-(g & 1)) ^ (g >>> 1);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int m27493f() throws java.io.IOException {
        /*
        r8 = this;
        r0 = r8.f25895c;
        r1 = r8.f25894b;
        if (r1 == r0) goto L_0x007f;
    L_0x0006:
        r1 = r8.f25893a;
        r2 = r0 + 1;
        r0 = r1[r0];
        if (r0 < 0) goto L_0x0011;
    L_0x000e:
        r8.f25895c = r2;
        return r0;
    L_0x0011:
        r3 = r8.f25894b;
        r3 = r3 - r2;
        r4 = 9;
        if (r3 < r4) goto L_0x007f;
    L_0x0018:
        r3 = r2 + 1;
        r2 = r1[r2];
        r2 = r2 << 7;
        r0 = r0 ^ r2;
        r4 = (long) r0;
        r6 = 0;
        r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r2 >= 0) goto L_0x002b;
    L_0x0026:
        r0 = -128; // 0xffffffffffffff80 float:NaN double:NaN;
        r0 = r0 ^ r4;
        r0 = (int) r0;
        goto L_0x007c;
    L_0x002b:
        r2 = r3 + 1;
        r3 = r1[r3];
        r3 = r3 << 14;
        r0 = r0 ^ r3;
        r3 = (long) r0;
        r5 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1));
        if (r5 < 0) goto L_0x003d;
    L_0x0037:
        r0 = 16256; // 0x3f80 float:2.278E-41 double:8.0315E-320;
        r0 = r0 ^ r3;
        r0 = (int) r0;
    L_0x003b:
        r3 = r2;
        goto L_0x007c;
    L_0x003d:
        r3 = r2 + 1;
        r2 = r1[r2];
        r2 = r2 << 21;
        r0 = r0 ^ r2;
        r4 = (long) r0;
        r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r2 >= 0) goto L_0x004f;
    L_0x0049:
        r0 = -2080896; // 0xffffffffffe03f80 float:NaN double:NaN;
        r0 = r0 ^ r4;
        r0 = (int) r0;
        goto L_0x007c;
    L_0x004f:
        r2 = r3 + 1;
        r3 = r1[r3];
        r4 = r3 << 28;
        r0 = r0 ^ r4;
        r4 = (long) r0;
        r6 = 266354560; // 0xfe03f80 float:2.2112565E-29 double:1.315966377E-315;
        r4 = r4 ^ r6;
        r0 = (int) r4;
        if (r3 >= 0) goto L_0x003b;
    L_0x005e:
        r3 = r2 + 1;
        r2 = r1[r2];
        if (r2 >= 0) goto L_0x007c;
    L_0x0064:
        r2 = r3 + 1;
        r3 = r1[r3];
        if (r3 >= 0) goto L_0x003b;
    L_0x006a:
        r3 = r2 + 1;
        r2 = r1[r2];
        if (r2 >= 0) goto L_0x007c;
    L_0x0070:
        r2 = r3 + 1;
        r3 = r1[r3];
        if (r3 >= 0) goto L_0x003b;
    L_0x0076:
        r3 = r2 + 1;
        r1 = r1[r2];
        if (r1 < 0) goto L_0x007f;
    L_0x007c:
        r8.f25895c = r3;
        return r0;
    L_0x007f:
        r0 = r8.m27480k();
        r0 = (int) r0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.f():int");
    }

    public static int m27473a(int i, InputStream inputStream) throws IOException {
        if ((i & 128) == 0) {
            return i;
        }
        i &= 127;
        int i2 = 7;
        while (i2 < 32) {
            int read = inputStream.read();
            if (read == -1) {
                throw InvalidProtocolBufferException.m27528a();
            }
            i |= (read & 127) << i2;
            if ((read & 128) == 0) {
                return i;
            }
            i2 += 7;
        }
        while (i2 < 64) {
            read = inputStream.read();
            if (read == -1) {
                throw InvalidProtocolBufferException.m27528a();
            } else if ((read & 128) == 0) {
                return i;
            } else {
                i2 += 7;
            }
        }
        throw InvalidProtocolBufferException.m27530c();
    }

    public final long m27494g() throws IOException {
        int i = this.f25895c;
        if (this.f25894b != i) {
            byte[] bArr = this.f25893a;
            int i2 = i + 1;
            byte b = bArr[i];
            if (b >= (byte) 0) {
                this.f25895c = i2;
                return (long) b;
            } else if (this.f25894b - i2 >= 9) {
                long j;
                int i3 = i2 + 1;
                long j2 = (long) (b ^ (bArr[i2] << 7));
                if (j2 < 0) {
                    j = -128 ^ j2;
                    i = i3;
                } else {
                    i = i3 + 1;
                    long j3 = ((long) (bArr[i3] << 14)) ^ j2;
                    if (j3 >= 0) {
                        j = j3 ^ EbmlUtil.two;
                    } else {
                        long j4;
                        int i4 = i + 1;
                        j3 ^= (long) (bArr[i] << 21);
                        if (j3 < 0) {
                            j4 = -2080896 ^ j3;
                        } else {
                            i = i4 + 1;
                            j3 ^= ((long) bArr[i4]) << 28;
                            if (j3 >= 0) {
                                j = j3 ^ 266354560;
                            } else {
                                i4 = i + 1;
                                j3 ^= ((long) bArr[i]) << 35;
                                if (j3 < 0) {
                                    j4 = -34093383808L ^ j3;
                                } else {
                                    i = i4 + 1;
                                    j3 ^= ((long) bArr[i4]) << 42;
                                    if (j3 >= 0) {
                                        j = j3 ^ 4363953127296L;
                                    } else {
                                        i4 = i + 1;
                                        j3 ^= ((long) bArr[i]) << 49;
                                        if (j3 < 0) {
                                            j4 = -558586000294016L ^ j3;
                                        } else {
                                            i = i4 + 1;
                                            j3 = (j3 ^ (((long) bArr[i4]) << 56)) ^ 71499008037633920L;
                                            if (j3 < 0) {
                                                i4 = i + 1;
                                                if (((long) bArr[i]) >= 0) {
                                                    j = j3;
                                                    i = i4;
                                                }
                                            } else {
                                                j = j3;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        j = j4;
                        i = i4;
                    }
                }
                this.f25895c = i;
                return j;
            }
        }
        return m27480k();
    }

    public final int m27495h() throws IOException {
        int i = this.f25895c;
        if (this.f25894b - i < 4) {
            m27477e(4);
            i = this.f25895c;
        }
        byte[] bArr = this.f25893a;
        this.f25895c = i + 4;
        return ((bArr[i + 3] & 255) << 24) | (((bArr[i] & 255) | ((bArr[i + 1] & 255) << 8)) | ((bArr[i + 2] & 255) << 16));
    }

    public final long m27496i() throws IOException {
        int i = this.f25895c;
        if (this.f25894b - i < 8) {
            m27477e(8);
            i = this.f25895c;
        }
        byte[] bArr = this.f25893a;
        this.f25895c = i + 8;
        return ((((long) bArr[i + 7]) & 255) << 56) | (((((((((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8)) | ((((long) bArr[i + 2]) & 255) << 16)) | ((((long) bArr[i + 3]) & 255) << 24)) | ((((long) bArr[i + 4]) & 255) << 32)) | ((((long) bArr[i + 5]) & 255) << 40)) | ((((long) bArr[i + 6]) & 255) << 48));
    }

    private CodedInputStream(InputStream inputStream) {
        this.f25902j = false;
        this.f25904l = RedditJobManager.f10810d;
        this.f25897e = 64;
        this.f25905m = 67108864;
        this.f25906n = null;
        this.f25893a = new byte[4096];
        this.f25894b = 0;
        this.f25895c = 0;
        this.f25903k = 0;
        this.f25900h = inputStream;
        this.f25898f = false;
    }

    private CodedInputStream(LiteralByteString literalByteString) {
        this.f25902j = false;
        this.f25904l = RedditJobManager.f10810d;
        this.f25897e = 64;
        this.f25905m = 67108864;
        this.f25906n = null;
        this.f25893a = literalByteString.f32871d;
        this.f25895c = literalByteString.mo6725b();
        this.f25894b = this.f25895c + literalByteString.mo5868a();
        this.f25903k = -this.f25895c;
        this.f25900h = null;
        this.f25898f = true;
    }

    public final int m27487b(int i) throws InvalidProtocolBufferException {
        if (i < 0) {
            throw InvalidProtocolBufferException.m27529b();
        }
        i += this.f25903k + this.f25895c;
        int i2 = this.f25904l;
        if (i > i2) {
            throw InvalidProtocolBufferException.m27528a();
        }
        this.f25904l = i;
        m27481l();
        return i2;
    }

    private void m27481l() {
        this.f25894b += this.f25899g;
        int i = this.f25903k + this.f25894b;
        if (i > this.f25904l) {
            this.f25899g = i - this.f25904l;
            this.f25894b -= this.f25899g;
            return;
        }
        this.f25899g = 0;
    }

    public final void m27488c(int i) {
        this.f25904l = i;
        m27481l();
    }

    public final int m27497j() {
        if (this.f25904l == RedditJobManager.f10810d) {
            return -1;
        }
        return this.f25904l - (this.f25903k + this.f25895c);
    }

    private void m27477e(int i) throws IOException {
        if (m27478f(i) == 0) {
            throw InvalidProtocolBufferException.m27528a();
        }
    }

    private boolean m27478f(int i) throws IOException {
        StringBuilder stringBuilder;
        while (this.f25895c + i > this.f25894b) {
            if ((this.f25903k + this.f25895c) + i <= this.f25904l && this.f25900h != null) {
                int i2 = this.f25895c;
                if (i2 > 0) {
                    if (this.f25894b > i2) {
                        System.arraycopy(this.f25893a, i2, this.f25893a, 0, this.f25894b - i2);
                    }
                    this.f25903k += i2;
                    this.f25894b -= i2;
                    this.f25895c = 0;
                }
                i2 = this.f25900h.read(this.f25893a, this.f25894b, this.f25893a.length - this.f25894b);
                if (i2 != 0 && i2 >= -1) {
                    if (i2 <= this.f25893a.length) {
                        if (i2 > 0) {
                            this.f25894b += i2;
                            if ((this.f25903k + i) - this.f25905m > 0) {
                                throw InvalidProtocolBufferException.m27535h();
                            }
                            m27481l();
                            if (this.f25894b >= i) {
                                return true;
                            }
                        }
                    }
                }
                stringBuilder = new StringBuilder(102);
                stringBuilder.append("InputStream#read(byte[]) returned invalid result: ");
                stringBuilder.append(i2);
                stringBuilder.append("\nThe InputStream implementation is buggy.");
                throw new IllegalStateException(stringBuilder.toString());
            }
            return false;
        }
        stringBuilder = new StringBuilder(77);
        stringBuilder.append("refillBuffer() called when ");
        stringBuilder.append(i);
        stringBuilder.append(" bytes were already available in buffer");
        throw new IllegalStateException(stringBuilder.toString());
    }

    final byte[] m27491d(int i) throws IOException {
        if (i <= 0) {
            if (i == 0) {
                return Internal.EMPTY_BYTE_ARRAY;
            }
            throw InvalidProtocolBufferException.m27529b();
        } else if ((this.f25903k + this.f25895c) + i > this.f25904l) {
            m27479g((this.f25904l - this.f25903k) - this.f25895c);
            throw InvalidProtocolBufferException.m27528a();
        } else if (i < 4096) {
            Object obj = new byte[i];
            r2 = this.f25894b - this.f25895c;
            System.arraycopy(this.f25893a, this.f25895c, obj, 0, r2);
            this.f25895c = this.f25894b;
            i -= r2;
            if (this.f25894b - this.f25895c < i) {
                m27477e(i);
            }
            System.arraycopy(this.f25893a, 0, obj, r2, i);
            this.f25895c = i;
            return obj;
        } else {
            r2 = this.f25895c;
            int i2 = this.f25894b;
            this.f25903k += this.f25894b;
            this.f25895c = 0;
            this.f25894b = 0;
            i2 -= r2;
            int i3 = i - i2;
            List<byte[]> arrayList = new ArrayList();
            while (i3 > 0) {
                Object obj2 = new byte[Math.min(i3, 4096)];
                int i4 = 0;
                while (i4 < obj2.length) {
                    int read = this.f25900h == null ? -1 : this.f25900h.read(obj2, i4, obj2.length - i4);
                    if (read == -1) {
                        throw InvalidProtocolBufferException.m27528a();
                    }
                    this.f25903k += read;
                    i4 += read;
                }
                i3 -= obj2.length;
                arrayList.add(obj2);
            }
            i = new byte[i];
            System.arraycopy(this.f25893a, r2, i, 0, i2);
            for (byte[] bArr : arrayList) {
                System.arraycopy(bArr, 0, i, i2, bArr.length);
                i2 += bArr.length;
            }
            return i;
        }
    }

    private void m27479g(int i) throws IOException {
        if (i <= this.f25894b - this.f25895c && i >= 0) {
            this.f25895c += i;
        } else if (i < 0) {
            throw InvalidProtocolBufferException.m27529b();
        } else if ((this.f25903k + this.f25895c) + i > this.f25904l) {
            m27479g((this.f25904l - this.f25903k) - this.f25895c);
            throw InvalidProtocolBufferException.m27528a();
        } else {
            int i2 = this.f25894b - this.f25895c;
            this.f25895c = this.f25894b;
            m27477e(1);
            while (true) {
                int i3 = i - i2;
                if (i3 > this.f25894b) {
                    i2 += this.f25894b;
                    this.f25895c = this.f25894b;
                    m27477e(1);
                } else {
                    this.f25895c = i3;
                    return;
                }
            }
        }
    }

    public final int m27482a() throws IOException {
        int i = 1;
        if (this.f25895c != this.f25894b || m27478f(1)) {
            i = 0;
        }
        if (i != 0) {
            this.f25901i = 0;
            return 0;
        }
        this.f25901i = m27493f();
        if (WireFormat.m27580b(this.f25901i) != 0) {
            return this.f25901i;
        }
        throw InvalidProtocolBufferException.m27531d();
    }

    private long m27480k() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            if (this.f25895c == this.f25894b) {
                m27477e(1);
            }
            byte[] bArr = this.f25893a;
            int i2 = this.f25895c;
            this.f25895c = i2 + 1;
            byte b = bArr[i2];
            j |= ((long) (b & 127)) << i;
            if ((b & 128) == 0) {
                return j;
            }
        }
        throw InvalidProtocolBufferException.m27530c();
    }
}
