package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString.ByteIterator;

class LiteralByteString extends ByteString {
    private int f32870a = 0;
    protected final byte[] f32871d;

    private class LiteralByteIterator implements ByteIterator {
        final /* synthetic */ LiteralByteString f32867a;
        private int f32868b;
        private final int f32869c;

        private LiteralByteIterator(LiteralByteString literalByteString) {
            this.f32867a = literalByteString;
            this.f32868b = 0;
            this.f32869c = literalByteString.mo5868a();
        }

        public boolean hasNext() {
            return this.f32868b < this.f32869c;
        }

        public final byte mo5863a() {
            try {
                byte[] bArr = this.f32867a.f32871d;
                int i = this.f32868b;
                this.f32868b = i + 1;
                return bArr[i];
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new NoSuchElementException(e.getMessage());
            }
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public /* synthetic */ Object next() {
            return Byte.valueOf(mo5863a());
        }
    }

    protected int mo6725b() {
        return 0;
    }

    protected final int mo5877i() {
        return 0;
    }

    protected final boolean mo5879j() {
        return true;
    }

    public /* synthetic */ Iterator iterator() {
        return mo5874c();
    }

    LiteralByteString(byte[] bArr) {
        this.f32871d = bArr;
    }

    public byte mo6724a(int i) {
        return this.f32871d[i];
    }

    public int mo5868a() {
        return this.f32871d.length;
    }

    protected void mo5872a(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.f32871d, i, bArr, i2, i3);
    }

    final void mo5871a(OutputStream outputStream, int i, int i2) throws IOException {
        outputStream.write(this.f32871d, mo6725b() + i, i2);
    }

    public final String mo5870a(String str) throws UnsupportedEncodingException {
        return new String(this.f32871d, mo6725b(), mo5868a(), str);
    }

    public final boolean mo5875f() {
        int b = mo6725b();
        return Utf8.m27575a(this.f32871d, b, mo5868a() + b);
    }

    protected final int mo5869a(int i, int i2, int i3) {
        int b = mo6725b() + i2;
        return Utf8.m27573a(i, this.f32871d, b, i3 + b);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ByteString) || mo5868a() != ((ByteString) obj).mo5868a()) {
            return false;
        }
        if (mo5868a() == 0) {
            return true;
        }
        if (obj instanceof LiteralByteString) {
            return m33302a((LiteralByteString) obj, 0, mo5868a());
        }
        if (obj instanceof RopeByteString) {
            return obj.equals(this);
        }
        obj = String.valueOf(String.valueOf(obj.getClass()));
        StringBuilder stringBuilder = new StringBuilder(49 + obj.length());
        stringBuilder.append("Has a new type of ByteString been created? Found ");
        stringBuilder.append(obj);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    final boolean m33302a(LiteralByteString literalByteString, int i, int i2) {
        if (i2 > literalByteString.mo5868a()) {
            i = mo5868a();
            StringBuilder stringBuilder = new StringBuilder(40);
            stringBuilder.append("Length too large: ");
            stringBuilder.append(i2);
            stringBuilder.append(i);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (i + i2 > literalByteString.mo5868a()) {
            literalByteString = literalByteString.mo5868a();
            StringBuilder stringBuilder2 = new StringBuilder(59);
            stringBuilder2.append("Ran off end of other: ");
            stringBuilder2.append(i);
            stringBuilder2.append(", ");
            stringBuilder2.append(i2);
            stringBuilder2.append(", ");
            stringBuilder2.append(literalByteString);
            throw new IllegalArgumentException(stringBuilder2.toString());
        } else {
            byte[] bArr = this.f32871d;
            byte[] bArr2 = literalByteString.f32871d;
            int b = mo6725b() + i2;
            i2 = mo6725b();
            literalByteString = literalByteString.mo6725b() + i;
            while (i2 < b) {
                if (bArr[i2] != bArr2[literalByteString]) {
                    return null;
                }
                i2++;
                literalByteString++;
            }
            return true;
        }
    }

    public int hashCode() {
        int i = this.f32870a;
        if (i == 0) {
            i = mo5868a();
            i = mo5873b(i, 0, i);
            if (i == 0) {
                i = 1;
            }
            this.f32870a = i;
        }
        return i;
    }

    protected final int mo5880k() {
        return this.f32870a;
    }

    protected final int mo5873b(int i, int i2, int i3) {
        return m33294a(i, this.f32871d, mo6725b() + i2, i3);
    }

    static int m33294a(int i, byte[] bArr, int i2, int i3) {
        int i4 = i;
        for (i = i2; i < i2 + i3; i++) {
            i4 = (i4 * 31) + bArr[i];
        }
        return i4;
    }

    static int m33295b(byte[] bArr) {
        bArr = m33294a(bArr.length, bArr, 0, bArr.length);
        return bArr == null ? 1 : bArr;
    }

    public final CodedInputStream mo5876g() {
        return CodedInputStream.m27475a(this);
    }

    public ByteIterator mo5874c() {
        return new LiteralByteIterator();
    }
}
