package kotlin.reflect.jvm.internal.impl.protobuf;

import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public abstract class ByteString implements Iterable<Byte> {
    public static final ByteString f25891b = new LiteralByteString(new byte[0]);
    static final /* synthetic */ boolean f25892c = true;

    public interface ByteIterator extends Iterator<Byte> {
        byte mo5863a();
    }

    public static final class Output extends OutputStream {
        private static final byte[] f25885a = new byte[0];
        private final int f25886b = 128;
        private final ArrayList<ByteString> f25887c = new ArrayList();
        private int f25888d;
        private byte[] f25889e = new byte[128];
        private int f25890f;

        Output() {
        }

        public final synchronized void write(int i) {
            if (this.f25890f == this.f25889e.length) {
                m27449a(1);
            }
            byte[] bArr = this.f25889e;
            int i2 = this.f25890f;
            this.f25890f = i2 + 1;
            bArr[i2] = (byte) i;
        }

        public final synchronized void write(byte[] bArr, int i, int i2) {
            if (i2 <= this.f25889e.length - this.f25890f) {
                System.arraycopy(bArr, i, this.f25889e, this.f25890f, i2);
                this.f25890f += i2;
                return;
            }
            int length = this.f25889e.length - this.f25890f;
            System.arraycopy(bArr, i, this.f25889e, this.f25890f, length);
            i += length;
            i2 -= length;
            m27449a(i2);
            System.arraycopy(bArr, i, this.f25889e, 0, i2);
            this.f25890f = i2;
        }

        private synchronized int m27450b() {
            return this.f25888d + this.f25890f;
        }

        public final String toString() {
            return String.format("<ByteString.Output@%s size=%d>", new Object[]{Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(m27450b())});
        }

        private void m27449a(int i) {
            this.f25887c.add(new LiteralByteString(this.f25889e));
            this.f25888d += this.f25889e.length;
            this.f25889e = new byte[Math.max(this.f25886b, Math.max(i, this.f25888d >>> 1))];
            this.f25890f = 0;
        }

        public final synchronized ByteString m27451a() {
            if (this.f25890f >= this.f25889e.length) {
                this.f25887c.add(new LiteralByteString(this.f25889e));
                this.f25889e = f25885a;
            } else if (this.f25890f > 0) {
                Object obj = this.f25889e;
                int i = this.f25890f;
                Object obj2 = new byte[i];
                System.arraycopy(obj, 0, obj2, 0, Math.min(obj.length, i));
                this.f25887c.add(new LiteralByteString(obj2));
            }
            this.f25888d += this.f25890f;
            this.f25890f = 0;
            return ByteString.m27452a(this.f25887c);
        }
    }

    public abstract int mo5868a();

    protected abstract int mo5869a(int i, int i2, int i3);

    public abstract String mo5870a(String str) throws UnsupportedEncodingException;

    abstract void mo5871a(OutputStream outputStream, int i, int i2) throws IOException;

    protected abstract void mo5872a(byte[] bArr, int i, int i2, int i3);

    protected abstract int mo5873b(int i, int i2, int i3);

    public abstract ByteIterator mo5874c();

    public abstract boolean mo5875f();

    public abstract CodedInputStream mo5876g();

    protected abstract int mo5877i();

    protected abstract boolean mo5879j();

    protected abstract int mo5880k();

    public /* synthetic */ Iterator iterator() {
        return mo5874c();
    }

    ByteString() {
    }

    public static ByteString m27455a(byte[] bArr, int i, int i2) {
        Object obj = new byte[i2];
        System.arraycopy(bArr, i, obj, 0, i2);
        return new LiteralByteString(obj);
    }

    public static ByteString m27454a(byte[] bArr) {
        return m27455a(bArr, 0, bArr.length);
    }

    public final ByteString m27460a(ByteString byteString) {
        int a = mo5868a();
        int a2 = byteString.mo5868a();
        if (((long) a) + ((long) a2) < 2147483647L) {
            return RopeByteString.m33317a(this, byteString);
        }
        StringBuilder stringBuilder = new StringBuilder(53);
        stringBuilder.append("ByteString would be too long: ");
        stringBuilder.append(a);
        stringBuilder.append(Operation.PLUS);
        stringBuilder.append(a2);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public static ByteString m27452a(Iterable<ByteString> iterable) {
        Collection collection;
        if (iterable instanceof Collection) {
            collection = (Collection) iterable;
        } else {
            collection = new ArrayList();
            for (ByteString add : iterable) {
                collection.add(add);
            }
        }
        if (collection.isEmpty() != null) {
            return f25891b;
        }
        return m27453a(collection.iterator(), collection.size());
    }

    private static ByteString m27453a(Iterator<ByteString> it, int i) {
        if (!f25892c && i <= 0) {
            throw new AssertionError();
        } else if (i == 1) {
            return (ByteString) it.next();
        } else {
            int i2 = i >>> 1;
            return m27453a(it, i2).m27460a(m27453a(it, i - i2));
        }
    }

    public final void m27464b(byte[] bArr, int i, int i2, int i3) {
        if (i < 0) {
            i2 = new StringBuilder(30);
            i2.append("Source offset < 0: ");
            i2.append(i);
            throw new IndexOutOfBoundsException(i2.toString());
        } else if (i2 < 0) {
            i = new StringBuilder(30);
            i.append("Target offset < 0: ");
            i.append(i2);
            throw new IndexOutOfBoundsException(i.toString());
        } else if (i3 < 0) {
            i = new StringBuilder(23);
            i.append("Length < 0: ");
            i.append(i3);
            throw new IndexOutOfBoundsException(i.toString());
        } else {
            int i4 = i + i3;
            if (i4 > mo5868a()) {
                i = new StringBuilder(34);
                i.append("Source end offset < 0: ");
                i.append(i4);
                throw new IndexOutOfBoundsException(i.toString());
            }
            i4 = i2 + i3;
            if (i4 > bArr.length) {
                i = new StringBuilder(34);
                i.append("Target end offset < 0: ");
                i.append(i4);
                throw new IndexOutOfBoundsException(i.toString());
            } else if (i3 > 0) {
                mo5872a(bArr, i, i2, i3);
            }
        }
    }

    public final byte[] m27466d() {
        int a = mo5868a();
        if (a == 0) {
            return Internal.EMPTY_BYTE_ARRAY;
        }
        byte[] bArr = new byte[a];
        mo5872a(bArr, 0, 0, a);
        return bArr;
    }

    public final String m27467e() {
        try {
            return mo5870a("UTF-8");
        } catch (Throwable e) {
            throw new RuntimeException("UTF-8 not supported?", e);
        }
    }

    public static Output m27456h() {
        return new Output();
    }

    public String toString() {
        return String.format("<ByteString@%s size=%d>", new Object[]{Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(mo5868a())});
    }
}
