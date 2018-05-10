package com.sendbird.android.shadow.okio;

final class SegmentedByteString extends ByteString {
    final transient byte[][] f30585f;
    final transient int[] f30586g;

    private int m31554b(int r1) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.sendbird.android.shadow.okio.SegmentedByteString.b(int):int
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:116)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:249)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
Caused by: jadx.core.utils.exceptions.DecodeException: Unknown instruction: not-int
	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:568)
	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:56)
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:102)
	... 5 more
*/
        /*
        // Can't load method instructions.
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.okio.SegmentedByteString.b(int):int");
    }

    SegmentedByteString(Buffer buffer, int i) {
        super(null);
        Util.m25643a(buffer.f34625b, 0, (long) i);
        int i2 = 0;
        Segment segment = buffer.f34624a;
        int i3 = 0;
        int i4 = i3;
        while (i3 < i) {
            if (segment.f23609c == segment.f23608b) {
                throw new AssertionError("s.limit == s.pos");
            }
            i3 += segment.f23609c - segment.f23608b;
            i4++;
            segment = segment.f23612f;
        }
        this.f30585f = new byte[i4][];
        this.f30586g = new int[(i4 * 2)];
        Segment segment2 = buffer.f34624a;
        buffer = null;
        while (i2 < i) {
            this.f30585f[buffer] = segment2.f23607a;
            i2 += segment2.f23609c - segment2.f23608b;
            if (i2 > i) {
                i2 = i;
            }
            this.f30586g[buffer] = i2;
            this.f30586g[this.f30585f.length + buffer] = segment2.f23608b;
            segment2.f23610d = true;
            buffer++;
            segment2 = segment2.f23612f;
        }
    }

    public final String mo5394a() {
        return m31555j().mo5394a();
    }

    public final String mo5398b() {
        return m31555j().mo5398b();
    }

    public final String mo5403f() {
        return m31555j().mo5403f();
    }

    public final ByteString mo5404g() {
        return m31555j().mo5404g();
    }

    public final ByteString mo5399c() {
        return m31555j().mo5399c();
    }

    public final ByteString mo5400d() {
        return m31555j().mo5400d();
    }

    public final ByteString mo5401e() {
        return m31555j().mo5401e();
    }

    public final ByteString mo5393a(int i, int i2) {
        return m31555j().mo5393a(i, i2);
    }

    public final byte mo5392a(int i) {
        int i2;
        Util.m25643a((long) this.f30586g[this.f30585f.length - 1], (long) i, 1);
        int b = m31554b(i);
        if (b == 0) {
            i2 = 0;
        } else {
            i2 = this.f30586g[b - 1];
        }
        return this.f30585f[b][(i - i2) + this.f30586g[this.f30585f.length + b]];
    }

    public final int mo5405h() {
        return this.f30586g[this.f30585f.length - 1];
    }

    public final byte[] mo5407i() {
        int i = 0;
        Object obj = new byte[this.f30586g[this.f30585f.length - 1]];
        int length = this.f30585f.length;
        int i2 = 0;
        while (i < length) {
            int i3 = this.f30586g[length + i];
            int i4 = this.f30586g[i];
            System.arraycopy(this.f30585f[i], i3, obj, i2, i4 - i2);
            i++;
            i2 = i4;
        }
        return obj;
    }

    final void mo5395a(Buffer buffer) {
        int i = 0;
        int length = this.f30585f.length;
        int i2 = 0;
        while (i < length) {
            int i3 = this.f30586g[length + i];
            int i4 = this.f30586g[i];
            Segment segment = new Segment(this.f30585f[i], i3, (i3 + i4) - i2);
            if (buffer.f34624a == null) {
                segment.f23613g = segment;
                segment.f23612f = segment;
                buffer.f34624a = segment;
            } else {
                buffer.f34624a.f23613g.m25629a(segment);
            }
            i++;
            i2 = i4;
        }
        buffer.f34625b += (long) i2;
    }

    public final boolean mo5396a(int i, ByteString byteString, int i2, int i3) {
        if (mo5405h() - i3 < 0) {
            return false;
        }
        int b = m31554b(0);
        while (i3 > 0) {
            int i4;
            if (b == 0) {
                i4 = 0;
            } else {
                i4 = this.f30586g[b - 1];
            }
            int min = Math.min(i3, ((this.f30586g[b] - i4) + i4) - i);
            if (!byteString.mo5397a(i2, this.f30585f[b], (i - i4) + this.f30586g[this.f30585f.length + b], min)) {
                return false;
            }
            i += min;
            i2 += min;
            i3 -= min;
            b++;
        }
        return true;
    }

    public final boolean mo5397a(int i, byte[] bArr, int i2, int i3) {
        if (i >= 0 && i <= mo5405h() - i3 && i2 >= 0) {
            if (i2 <= bArr.length - i3) {
                int b = m31554b(i);
                while (i3 > 0) {
                    int i4;
                    if (b == 0) {
                        i4 = 0;
                    } else {
                        i4 = this.f30586g[b - 1];
                    }
                    int min = Math.min(i3, ((this.f30586g[b] - i4) + i4) - i);
                    if (!Util.m25645a(this.f30585f[b], (i - i4) + this.f30586g[this.f30585f.length + b], bArr, i2, min)) {
                        return false;
                    }
                    i += min;
                    i2 += min;
                    i3 -= min;
                    b++;
                }
                return true;
            }
        }
        return false;
    }

    private ByteString m31555j() {
        return new ByteString(mo5407i());
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            return byteString.mo5405h() == mo5405h() && mo5396a(0, byteString, 0, mo5405h()) != null;
        }
    }

    public final int hashCode() {
        int i = this.d;
        if (i != 0) {
            return i;
        }
        int i2 = 0;
        i = this.f30585f.length;
        int i3 = 1;
        int i4 = 0;
        while (i2 < i) {
            byte[] bArr = this.f30585f[i2];
            int i5 = this.f30586g[i + i2];
            int i6 = this.f30586g[i2];
            i4 = (i6 - i4) + i5;
            while (i5 < i4) {
                i3 = bArr[i5] + (31 * i3);
                i5++;
            }
            i2++;
            i4 = i6;
        }
        this.d = i3;
        return i3;
    }

    public final String toString() {
        return m31555j().toString();
    }
}
