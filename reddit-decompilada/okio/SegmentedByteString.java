package okio;

final class SegmentedByteString extends ByteString {
    final transient byte[][] f33203f;
    final transient int[] f33204g;

    private int m33796b(int r1) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: okio.SegmentedByteString.b(int):int
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
        throw new UnsupportedOperationException("Method not decompiled: okio.SegmentedByteString.b(int):int");
    }

    SegmentedByteString(Buffer buffer, int i) {
        super(null);
        Util.m28310a(buffer.f36201b, 0, (long) i);
        int i2 = 0;
        Segment segment = buffer.f36200a;
        int i3 = 0;
        int i4 = i3;
        while (i3 < i) {
            if (segment.f26680c == segment.f26679b) {
                throw new AssertionError("s.limit == s.pos");
            }
            i3 += segment.f26680c - segment.f26679b;
            i4++;
            segment = segment.f26683f;
        }
        this.f33203f = new byte[i4][];
        this.f33204g = new int[(i4 * 2)];
        Segment segment2 = buffer.f36200a;
        buffer = null;
        while (i2 < i) {
            this.f33203f[buffer] = segment2.f26678a;
            i2 += segment2.f26680c - segment2.f26679b;
            if (i2 > i) {
                i2 = i;
            }
            this.f33204g[buffer] = i2;
            this.f33204g[this.f33203f.length + buffer] = segment2.f26679b;
            segment2.f26681d = true;
            buffer++;
            segment2 = segment2.f26683f;
        }
    }

    public final String mo6154a() {
        return m33797k().mo6154a();
    }

    public final String mo6159b() {
        return m33797k().mo6159b();
    }

    public final String mo6164f() {
        return m33797k().mo6164f();
    }

    public final ByteString mo6165g() {
        return m33797k().mo6165g();
    }

    public final ByteString mo6160c() {
        return m33797k().mo6160c();
    }

    public final ByteString mo6161d() {
        return m33797k().mo6161d();
    }

    public final ByteString mo6162e() {
        return m33797k().mo6162e();
    }

    public final ByteString mo6155a(int i, int i2) {
        return m33797k().mo6155a(i, i2);
    }

    public final byte mo6153a(int i) {
        int i2;
        Util.m28310a((long) this.f33204g[this.f33203f.length - 1], (long) i, 1);
        int b = m33796b(i);
        if (b == 0) {
            i2 = 0;
        } else {
            i2 = this.f33204g[b - 1];
        }
        return this.f33203f[b][(i - i2) + this.f33204g[this.f33203f.length + b]];
    }

    public final int mo6166h() {
        return this.f33204g[this.f33203f.length - 1];
    }

    public final byte[] mo6168i() {
        int i = 0;
        Object obj = new byte[this.f33204g[this.f33203f.length - 1]];
        int length = this.f33203f.length;
        int i2 = 0;
        while (i < length) {
            int i3 = this.f33204g[length + i];
            int i4 = this.f33204g[i];
            System.arraycopy(this.f33203f[i], i3, obj, i2, i4 - i2);
            i++;
            i2 = i4;
        }
        return obj;
    }

    final void mo6156a(Buffer buffer) {
        int i = 0;
        int length = this.f33203f.length;
        int i2 = 0;
        while (i < length) {
            int i3 = this.f33204g[length + i];
            int i4 = this.f33204g[i];
            Segment segment = new Segment(this.f33203f[i], i3, (i3 + i4) - i2);
            if (buffer.f36200a == null) {
                segment.f26684g = segment;
                segment.f26683f = segment;
                buffer.f36200a = segment;
            } else {
                buffer.f36200a.f26684g.m28304a(segment);
            }
            i++;
            i2 = i4;
        }
        buffer.f36201b += (long) i2;
    }

    public final boolean mo6157a(int i, ByteString byteString, int i2, int i3) {
        if (mo6166h() - i3 < 0) {
            return false;
        }
        int b = m33796b(0);
        while (i3 > 0) {
            int i4;
            if (b == 0) {
                i4 = 0;
            } else {
                i4 = this.f33204g[b - 1];
            }
            int min = Math.min(i3, ((this.f33204g[b] - i4) + i4) - i);
            if (!byteString.mo6158a(i2, this.f33203f[b], (i - i4) + this.f33204g[this.f33203f.length + b], min)) {
                return false;
            }
            i += min;
            i2 += min;
            i3 -= min;
            b++;
        }
        return true;
    }

    public final boolean mo6158a(int i, byte[] bArr, int i2, int i3) {
        if (i >= 0 && i <= mo6166h() - i3 && i2 >= 0) {
            if (i2 <= bArr.length - i3) {
                int b = m33796b(i);
                while (i3 > 0) {
                    int i4;
                    if (b == 0) {
                        i4 = 0;
                    } else {
                        i4 = this.f33204g[b - 1];
                    }
                    int min = Math.min(i3, ((this.f33204g[b] - i4) + i4) - i);
                    if (!Util.m28312a(this.f33203f[b], (i - i4) + this.f33204g[this.f33203f.length + b], bArr, i2, min)) {
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

    private ByteString m33797k() {
        return new ByteString(mo6168i());
    }

    final byte[] mo6169j() {
        return mo6168i();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            return byteString.mo6166h() == mo6166h() && mo6157a(0, byteString, 0, mo6166h()) != null;
        }
    }

    public final int hashCode() {
        int i = this.d;
        if (i != 0) {
            return i;
        }
        int i2 = 0;
        i = this.f33203f.length;
        int i3 = 1;
        int i4 = 0;
        while (i2 < i) {
            byte[] bArr = this.f33203f[i2];
            int i5 = this.f33204g[i + i2];
            int i6 = this.f33204g[i2];
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
        return m33797k().toString();
    }
}
