package kotlin.reflect.jvm.internal.impl.protobuf;

import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString.ByteIterator;

class BoundedByteString extends LiteralByteString {
    final int f36130a;
    private final int f36131e;

    private class BoundedByteIterator implements ByteIterator {
        final /* synthetic */ BoundedByteString f32858a;
        private int f32859b;
        private final int f32860c;

        private BoundedByteIterator(BoundedByteString boundedByteString) {
            this.f32858a = boundedByteString;
            this.f32859b = boundedByteString.f36130a;
            this.f32860c = this.f32859b + boundedByteString.mo5868a();
        }

        public boolean hasNext() {
            return this.f32859b < this.f32860c;
        }

        public final byte mo5863a() {
            if (this.f32859b >= this.f32860c) {
                throw new NoSuchElementException();
            }
            byte[] bArr = this.f32858a.d;
            int i = this.f32859b;
            this.f32859b = i + 1;
            return bArr[i];
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public /* synthetic */ Object next() {
            return Byte.valueOf(mo5863a());
        }
    }

    public /* synthetic */ Iterator iterator() {
        return mo5874c();
    }

    BoundedByteString(byte[] bArr, int i, int i2) {
        super(bArr);
        if (i < 0) {
            i2 = new StringBuilder(29);
            i2.append("Offset too small: ");
            i2.append(i);
            throw new IllegalArgumentException(i2.toString());
        } else if (i2 < 0) {
            i2 = new StringBuilder(29);
            i2.append("Length too small: ");
            i2.append(i);
            throw new IllegalArgumentException(i2.toString());
        } else if (((long) i) + ((long) i2) > ((long) bArr.length)) {
            StringBuilder stringBuilder = new StringBuilder(48);
            stringBuilder.append("Offset+Length too large: ");
            stringBuilder.append(i);
            stringBuilder.append(Operation.PLUS);
            stringBuilder.append(i2);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else {
            this.f36130a = i;
            this.f36131e = i2;
        }
    }

    public final byte mo6724a(int i) {
        if (i < 0) {
            StringBuilder stringBuilder = new StringBuilder(28);
            stringBuilder.append("Index too small: ");
            stringBuilder.append(i);
            throw new ArrayIndexOutOfBoundsException(stringBuilder.toString());
        } else if (i < this.f36131e) {
            return this.d[this.f36130a + i];
        } else {
            int i2 = this.f36131e;
            StringBuilder stringBuilder2 = new StringBuilder(41);
            stringBuilder2.append("Index too large: ");
            stringBuilder2.append(i);
            stringBuilder2.append(", ");
            stringBuilder2.append(i2);
            throw new ArrayIndexOutOfBoundsException(stringBuilder2.toString());
        }
    }

    public final int mo5868a() {
        return this.f36131e;
    }

    protected final int mo6725b() {
        return this.f36130a;
    }

    protected final void mo5872a(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.d, this.f36130a + i, bArr, i2, i3);
    }

    public final ByteIterator mo5874c() {
        return new BoundedByteIterator();
    }
}
