package kotlin.reflect.jvm.internal.impl.protobuf;

import com.reddit.datalibrary.frontpage.job.RedditJobManager;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Stack;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString.ByteIterator;

class RopeByteString extends ByteString {
    private static final int[] f32876a;
    private final int f32877d;
    private final ByteString f32878e;
    private final ByteString f32879f;
    private final int f32880g;
    private final int f32881h;
    private int f32882i;

    private static class Balancer {
        private final Stack<ByteString> f25934a;

        private Balancer() {
            this.f25934a = new Stack();
        }

        private void m27546a(ByteString byteString) {
            while (!byteString.mo5879j()) {
                if (byteString instanceof RopeByteString) {
                    RopeByteString ropeByteString = (RopeByteString) byteString;
                    m27546a(ropeByteString.f32878e);
                    byteString = ropeByteString.f32879f;
                } else {
                    byteString = String.valueOf(String.valueOf(byteString.getClass()));
                    StringBuilder stringBuilder = new StringBuilder(49 + byteString.length());
                    stringBuilder.append("Has a new type of ByteString been created? Found ");
                    stringBuilder.append(byteString);
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
            }
            int a = m27544a(byteString.mo5868a());
            int i = RopeByteString.f32876a[a + 1];
            if (!this.f25934a.isEmpty()) {
                if (((ByteString) this.f25934a.peek()).mo5868a() < i) {
                    a = RopeByteString.f32876a[a];
                    ByteString byteString2 = (ByteString) this.f25934a.pop();
                    while (!this.f25934a.isEmpty() && ((ByteString) this.f25934a.peek()).mo5868a() < a) {
                        byteString2 = new RopeByteString((ByteString) this.f25934a.pop(), byteString2);
                    }
                    ByteString ropeByteString2 = new RopeByteString(byteString2, byteString);
                    while (this.f25934a.isEmpty() == null) {
                        if (((ByteString) this.f25934a.peek()).mo5868a() >= RopeByteString.f32876a[m27544a(ropeByteString2.mo5868a()) + 1]) {
                            break;
                        }
                        ropeByteString2 = new RopeByteString((ByteString) this.f25934a.pop(), ropeByteString2);
                    }
                    this.f25934a.push(ropeByteString2);
                    return;
                }
            }
            this.f25934a.push(byteString);
        }

        private static int m27544a(int i) {
            i = Arrays.binarySearch(RopeByteString.f32876a, i);
            return i < 0 ? (-(i + 1)) - 1 : i;
        }

        static /* synthetic */ ByteString m27545a(Balancer balancer, ByteString byteString, ByteString byteString2) {
            balancer.m27546a(byteString);
            balancer.m27546a(byteString2);
            byteString = (ByteString) balancer.f25934a.pop();
            while (balancer.f25934a.isEmpty() == null) {
                byteString = new RopeByteString((ByteString) balancer.f25934a.pop(), byteString);
            }
            return byteString;
        }
    }

    private static class PieceIterator implements Iterator<LiteralByteString> {
        private final Stack<RopeByteString> f25935a;
        private LiteralByteString f25936b;

        public /* synthetic */ Object next() {
            return m27549a();
        }

        private PieceIterator(ByteString byteString) {
            this.f25935a = new Stack();
            this.f25936b = m27547a(byteString);
        }

        private LiteralByteString m27547a(ByteString byteString) {
            while (byteString instanceof RopeByteString) {
                RopeByteString ropeByteString = (RopeByteString) byteString;
                this.f25935a.push(ropeByteString);
                byteString = ropeByteString.f32878e;
            }
            return (LiteralByteString) byteString;
        }

        private LiteralByteString m27548b() {
            while (!this.f25935a.isEmpty()) {
                Object obj;
                ByteString a = m27547a(((RopeByteString) this.f25935a.pop()).f32879f);
                if (a.mo5868a() == 0) {
                    obj = 1;
                    continue;
                } else {
                    obj = null;
                    continue;
                }
                if (obj == null) {
                    return a;
                }
            }
            return null;
        }

        public boolean hasNext() {
            return this.f25936b != null;
        }

        public final LiteralByteString m27549a() {
            if (this.f25936b == null) {
                throw new NoSuchElementException();
            }
            LiteralByteString literalByteString = this.f25936b;
            this.f25936b = m27548b();
            return literalByteString;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private class RopeInputStream extends InputStream {
        final /* synthetic */ RopeByteString f25937a;
        private PieceIterator f25938b;
        private LiteralByteString f25939c;
        private int f25940d;
        private int f25941e;
        private int f25942f;
        private int f25943g;

        public boolean markSupported() {
            return true;
        }

        public RopeInputStream(RopeByteString ropeByteString) {
            this.f25937a = ropeByteString;
            m27551a();
        }

        public int read(byte[] bArr, int i, int i2) {
            if (bArr == null) {
                throw new NullPointerException();
            }
            if (i >= 0 && i2 >= 0) {
                if (i2 <= bArr.length - i) {
                    return m27550a(bArr, i, i2);
                }
            }
            throw new IndexOutOfBoundsException();
        }

        public long skip(long j) {
            if (j < 0) {
                throw new IndexOutOfBoundsException();
            }
            if (j > 2147483647L) {
                j = 2147483647L;
            }
            return (long) m27550a(null, 0, (int) j);
        }

        private int m27550a(byte[] bArr, int i, int i2) {
            int i3 = i;
            i = i2;
            while (i > 0) {
                m27552b();
                if (this.f25939c == null) {
                    if (i == i2) {
                        return -1;
                    }
                    return i2 - i;
                }
                int min = Math.min(this.f25940d - this.f25941e, i);
                if (bArr != null) {
                    this.f25939c.m27464b(bArr, this.f25941e, i3, min);
                    i3 += min;
                }
                this.f25941e += min;
                i -= min;
            }
            return i2 - i;
        }

        public int read() throws IOException {
            m27552b();
            if (this.f25939c == null) {
                return -1;
            }
            LiteralByteString literalByteString = this.f25939c;
            int i = this.f25941e;
            this.f25941e = i + 1;
            return literalByteString.mo6724a(i) & 255;
        }

        public int available() throws IOException {
            return this.f25937a.mo5868a() - (this.f25942f + this.f25941e);
        }

        public void mark(int i) {
            this.f25943g = this.f25942f + this.f25941e;
        }

        public synchronized void reset() {
            m27551a();
            m27550a(null, 0, this.f25943g);
        }

        private void m27551a() {
            this.f25938b = new PieceIterator(this.f25937a);
            this.f25939c = this.f25938b.m27549a();
            this.f25940d = this.f25939c.mo5868a();
            this.f25941e = 0;
            this.f25942f = 0;
        }

        private void m27552b() {
            if (this.f25939c != null && this.f25941e == this.f25940d) {
                this.f25942f += this.f25940d;
                this.f25941e = 0;
                if (this.f25938b.hasNext()) {
                    this.f25939c = this.f25938b.m27549a();
                    this.f25940d = this.f25939c.mo5868a();
                    return;
                }
                this.f25939c = null;
                this.f25940d = 0;
            }
        }
    }

    private class RopeByteIterator implements ByteIterator {
        int f32872a;
        final /* synthetic */ RopeByteString f32873b;
        private final PieceIterator f32874c;
        private ByteIterator f32875d;

        private RopeByteIterator(RopeByteString ropeByteString) {
            this.f32873b = ropeByteString;
            this.f32874c = new PieceIterator(ropeByteString);
            this.f32875d = this.f32874c.m27549a().mo5874c();
            this.f32872a = ropeByteString.mo5868a();
        }

        public boolean hasNext() {
            return this.f32872a > 0;
        }

        public final byte mo5863a() {
            if (!this.f32875d.hasNext()) {
                this.f32875d = this.f32874c.m27549a().mo5874c();
            }
            this.f32872a--;
            return this.f32875d.mo5863a();
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

    static {
        List arrayList = new ArrayList();
        int i = 1;
        int i2 = 1;
        while (i > 0) {
            arrayList.add(Integer.valueOf(i));
            int i3 = i2 + i;
            i2 = i;
            i = i3;
        }
        arrayList.add(Integer.valueOf(RedditJobManager.f10810d));
        f32876a = new int[arrayList.size()];
        for (i = 0; i < f32876a.length; i++) {
            f32876a[i] = ((Integer) arrayList.get(i)).intValue();
        }
    }

    private RopeByteString(ByteString byteString, ByteString byteString2) {
        this.f32882i = 0;
        this.f32878e = byteString;
        this.f32879f = byteString2;
        this.f32880g = byteString.mo5868a();
        this.f32877d = this.f32880g + byteString2.mo5868a();
        this.f32881h = Math.max(byteString.mo5877i(), byteString2.mo5877i()) + 1;
    }

    static ByteString m33317a(ByteString byteString, ByteString byteString2) {
        RopeByteString ropeByteString = byteString instanceof RopeByteString ? (RopeByteString) byteString : null;
        if (byteString2.mo5868a() == 0) {
            return byteString;
        }
        if (byteString.mo5868a() != 0) {
            int a = byteString.mo5868a() + byteString2.mo5868a();
            if (a < 128) {
                return m33320b(byteString, byteString2);
            }
            if (ropeByteString != null && ropeByteString.f32879f.mo5868a() + byteString2.mo5868a() < 128) {
                byteString2 = new RopeByteString(ropeByteString.f32878e, m33320b(ropeByteString.f32879f, byteString2));
            } else if (ropeByteString == null || ropeByteString.f32878e.mo5877i() <= ropeByteString.f32879f.mo5877i() || ropeByteString.f32881h <= byteString2.mo5877i()) {
                if (a >= f32876a[Math.max(byteString.mo5877i(), byteString2.mo5877i()) + 1]) {
                    return new RopeByteString(byteString, byteString2);
                }
                return Balancer.m27545a(new Balancer(), byteString, byteString2);
            } else {
                byteString2 = new RopeByteString(ropeByteString.f32878e, new RopeByteString(ropeByteString.f32879f, byteString2));
            }
        }
        return byteString2;
    }

    private static LiteralByteString m33320b(ByteString byteString, ByteString byteString2) {
        int a = byteString.mo5868a();
        int a2 = byteString2.mo5868a();
        byte[] bArr = new byte[(a + a2)];
        byteString.m27464b(bArr, 0, 0, a);
        byteString2.m27464b(bArr, 0, a, a2);
        return new LiteralByteString(bArr);
    }

    public final int mo5868a() {
        return this.f32877d;
    }

    protected final int mo5877i() {
        return this.f32881h;
    }

    protected final boolean mo5879j() {
        return this.f32877d >= f32876a[this.f32881h];
    }

    protected final void mo5872a(byte[] bArr, int i, int i2, int i3) {
        if (i + i3 <= this.f32880g) {
            this.f32878e.mo5872a(bArr, i, i2, i3);
        } else if (i >= this.f32880g) {
            this.f32879f.mo5872a(bArr, i - this.f32880g, i2, i3);
        } else {
            int i4 = this.f32880g - i;
            this.f32878e.mo5872a(bArr, i, i2, i4);
            this.f32879f.mo5872a(bArr, 0, i2 + i4, i3 - i4);
        }
    }

    final void mo5871a(OutputStream outputStream, int i, int i2) throws IOException {
        if (i + i2 <= this.f32880g) {
            this.f32878e.mo5871a(outputStream, i, i2);
        } else if (i >= this.f32880g) {
            this.f32879f.mo5871a(outputStream, i - this.f32880g, i2);
        } else {
            int i3 = this.f32880g - i;
            this.f32878e.mo5871a(outputStream, i, i3);
            this.f32879f.mo5871a(outputStream, 0, i2 - i3);
        }
    }

    public final String mo5870a(String str) throws UnsupportedEncodingException {
        return new String(m27466d(), str);
    }

    public final boolean mo5875f() {
        if (this.f32879f.mo5869a(this.f32878e.mo5869a(0, 0, this.f32880g), 0, this.f32879f.mo5868a()) == 0) {
            return true;
        }
        return false;
    }

    protected final int mo5869a(int i, int i2, int i3) {
        if (i2 + i3 <= this.f32880g) {
            return this.f32878e.mo5869a(i, i2, i3);
        }
        if (i2 >= this.f32880g) {
            return this.f32879f.mo5869a(i, i2 - this.f32880g, i3);
        }
        int i4 = this.f32880g - i2;
        return this.f32879f.mo5869a(this.f32878e.mo5869a(i, i2, i4), 0, i3 - i4);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ByteString)) {
            return false;
        }
        ByteString byteString = (ByteString) obj;
        if (this.f32877d != byteString.mo5868a()) {
            return false;
        }
        if (this.f32877d == 0) {
            return true;
        }
        if (this.f32882i != 0) {
            int k = byteString.mo5880k();
            if (!(k == 0 || this.f32882i == k)) {
                return false;
            }
        }
        Iterator pieceIterator = new PieceIterator(this);
        LiteralByteString literalByteString = (LiteralByteString) pieceIterator.next();
        Iterator pieceIterator2 = new PieceIterator(byteString);
        LiteralByteString literalByteString2 = (LiteralByteString) pieceIterator2.next();
        int i = null;
        int i2 = i;
        int i3 = i2;
        while (true) {
            int a = literalByteString.mo5868a() - i;
            int a2 = literalByteString2.mo5868a() - i2;
            int min = Math.min(a, a2);
            if (!(i == null ? literalByteString.m33302a(literalByteString2, i2, min) : literalByteString2.m33302a(literalByteString, i, min))) {
                return false;
            }
            i3 += min;
            if (i3 >= this.f32877d) {
                break;
            }
            if (min == a) {
                literalByteString = (LiteralByteString) pieceIterator.next();
                i = null;
            } else {
                i += min;
            }
            if (min == a2) {
                literalByteString2 = (LiteralByteString) pieceIterator2.next();
                i2 = 0;
            } else {
                i2 += min;
            }
        }
        if (i3 == this.f32877d) {
            return true;
        }
        throw new IllegalStateException();
    }

    public int hashCode() {
        int i = this.f32882i;
        if (i == 0) {
            i = mo5873b(this.f32877d, 0, this.f32877d);
            if (i == 0) {
                i = 1;
            }
            this.f32882i = i;
        }
        return i;
    }

    protected final int mo5880k() {
        return this.f32882i;
    }

    protected final int mo5873b(int i, int i2, int i3) {
        if (i2 + i3 <= this.f32880g) {
            return this.f32878e.mo5873b(i, i2, i3);
        }
        if (i2 >= this.f32880g) {
            return this.f32879f.mo5873b(i, i2 - this.f32880g, i3);
        }
        int i4 = this.f32880g - i2;
        return this.f32879f.mo5873b(this.f32878e.mo5873b(i, i2, i4), 0, i3 - i4);
    }

    public final CodedInputStream mo5876g() {
        return CodedInputStream.m27474a(new RopeInputStream(this));
    }

    public final ByteIterator mo5874c() {
        return new RopeByteIterator();
    }
}
