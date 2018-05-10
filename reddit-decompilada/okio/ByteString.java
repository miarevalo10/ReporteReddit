package okio;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.Arrays;

public class ByteString implements Serializable, Comparable<ByteString> {
    static final char[] f26663a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static final ByteString f26664b = m28269a(new byte[0]);
    final byte[] f26665c;
    transient int f26666d;
    transient String f26667e;

    public /* synthetic */ int compareTo(Object obj) {
        ByteString byteString = (ByteString) obj;
        int h = mo6166h();
        int h2 = byteString.mo6166h();
        int min = Math.min(h, h2);
        int i = 0;
        while (i < min) {
            int a = mo6153a(i) & 255;
            int a2 = byteString.mo6153a(i) & 255;
            if (a != a2) {
                return a < a2 ? -1 : 1;
            } else {
                i++;
            }
        }
        if (h == h2) {
            return 0;
        }
        return h < h2 ? -1 : 1;
    }

    ByteString(byte[] bArr) {
        this.f26665c = bArr;
    }

    public static ByteString m28269a(byte... bArr) {
        if (bArr != null) {
            return new ByteString((byte[]) bArr.clone());
        }
        throw new IllegalArgumentException("data == null");
    }

    public static ByteString m28267a(String str) {
        if (str == null) {
            throw new IllegalArgumentException("s == null");
        }
        ByteString byteString = new ByteString(str.getBytes(Util.f26687a));
        byteString.f26667e = str;
        return byteString;
    }

    public static ByteString m28268a(String str, Charset charset) {
        if (str == null) {
            throw new IllegalArgumentException("s == null");
        } else if (charset != null) {
            return new ByteString(str.getBytes(charset));
        } else {
            throw new IllegalArgumentException("charset == null");
        }
    }

    public String mo6154a() {
        String str = this.f26667e;
        if (str != null) {
            return str;
        }
        str = new String(this.f26665c, Util.f26687a);
        this.f26667e = str;
        return str;
    }

    public String mo6159b() {
        return Base64.m28263a(this.f26665c);
    }

    public ByteString mo6160c() {
        return m28272d("MD5");
    }

    public ByteString mo6161d() {
        return m28272d("SHA-1");
    }

    public ByteString mo6162e() {
        return m28272d("SHA-256");
    }

    private ByteString m28272d(String str) {
        try {
            return m28269a(MessageDigest.getInstance(str).digest(this.f26665c));
        } catch (String str2) {
            throw new AssertionError(str2);
        }
    }

    public static ByteString m28270b(String str) {
        if (str == null) {
            throw new IllegalArgumentException("base64 == null");
        }
        str = Base64.m28265a(str);
        return str != null ? new ByteString(str) : null;
    }

    public String mo6164f() {
        int i = 0;
        char[] cArr = new char[(this.f26665c.length * 2)];
        byte[] bArr = this.f26665c;
        int length = bArr.length;
        int i2 = 0;
        while (i < length) {
            byte b = bArr[i];
            int i3 = i2 + 1;
            cArr[i2] = f26663a[(b >> 4) & 15];
            i2 = i3 + 1;
            cArr[i3] = f26663a[b & 15];
            i++;
        }
        return new String(cArr);
    }

    public static ByteString m28271c(String str) {
        if (str.length() % 2 != 0) {
            StringBuilder stringBuilder = new StringBuilder("Unexpected hex string: ");
            stringBuilder.append(str);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        byte[] bArr = new byte[(str.length() / 2)];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) ((m28266a(str.charAt(i2)) << 4) + m28266a(str.charAt(i2 + 1)));
        }
        return m28269a(bArr);
    }

    private static int m28266a(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        if (c >= 'a' && c <= 'f') {
            return (c - 'a') + 10;
        }
        if (c >= 'A' && c <= 'F') {
            return (c - 'A') + 10;
        }
        StringBuilder stringBuilder = new StringBuilder("Unexpected hex digit: ");
        stringBuilder.append(c);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public ByteString mo6165g() {
        int i = 0;
        while (i < this.f26665c.length) {
            byte b = this.f26665c[i];
            if (b < (byte) 65 || b > (byte) 90) {
                i++;
            } else {
                byte[] bArr = (byte[]) this.f26665c.clone();
                bArr[i] = (byte) (b + 32);
                for (int i2 = i + 1; i2 < bArr.length; i2++) {
                    byte b2 = bArr[i2];
                    if (b2 >= (byte) 65 && b2 <= (byte) 90) {
                        bArr[i2] = (byte) (b2 + 32);
                    }
                }
                return new ByteString(bArr);
            }
        }
        return this;
    }

    public ByteString mo6155a(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("beginIndex < 0");
        } else if (i2 > this.f26665c.length) {
            i2 = new StringBuilder("endIndex > length(");
            i2.append(this.f26665c.length);
            i2.append(")");
            throw new IllegalArgumentException(i2.toString());
        } else {
            int i3 = i2 - i;
            if (i3 < 0) {
                throw new IllegalArgumentException("endIndex < beginIndex");
            } else if (i == 0 && i2 == this.f26665c.length) {
                return this;
            } else {
                i2 = new byte[i3];
                System.arraycopy(this.f26665c, i, i2, 0, i3);
                return new ByteString(i2);
            }
        }
    }

    public byte mo6153a(int i) {
        return this.f26665c[i];
    }

    public int mo6166h() {
        return this.f26665c.length;
    }

    public byte[] mo6168i() {
        return (byte[]) this.f26665c.clone();
    }

    byte[] mo6169j() {
        return this.f26665c;
    }

    void mo6156a(Buffer buffer) {
        buffer.m36495b(this.f26665c, 0, this.f26665c.length);
    }

    public boolean mo6157a(int i, ByteString byteString, int i2, int i3) {
        return byteString.mo6158a(0, this.f26665c, 0, i3);
    }

    public boolean mo6158a(int i, byte[] bArr, int i2, int i3) {
        return i >= 0 && i <= this.f26665c.length - i3 && i2 >= 0 && i2 <= bArr.length - i3 && Util.m28312a(this.f26665c, i, bArr, i2, i3) != 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            return byteString.mo6166h() == this.f26665c.length && byteString.mo6158a(0, this.f26665c, 0, this.f26665c.length) != null;
        }
    }

    public int hashCode() {
        int i = this.f26666d;
        if (i != 0) {
            return i;
        }
        i = Arrays.hashCode(this.f26665c);
        this.f26666d = i;
        return i;
    }

    public String toString() {
        if (this.f26665c.length == 0) {
            return "[size=0]";
        }
        String a = mo6154a();
        int length = a.length();
        int i = 0;
        int i2 = i;
        while (i < length) {
            if (i2 != 64) {
                int codePointAt = a.codePointAt(i);
                if ((Character.isISOControl(codePointAt) && codePointAt != 10 && codePointAt != 13) || codePointAt == 65533) {
                    i = -1;
                    break;
                }
                i2++;
                i += Character.charCount(codePointAt);
            } else {
                break;
            }
        }
        i = a.length();
        StringBuilder stringBuilder;
        if (i != -1) {
            String replace = a.substring(0, i).replace("\\", "\\\\").replace("\n", "\\n").replace("\r", "\\r");
            if (i < a.length()) {
                stringBuilder = new StringBuilder("[size=");
                stringBuilder.append(this.f26665c.length);
                stringBuilder.append(" text=");
                stringBuilder.append(replace);
                stringBuilder.append("…]");
                return stringBuilder.toString();
            }
            stringBuilder = new StringBuilder("[text=");
            stringBuilder.append(replace);
            stringBuilder.append("]");
            return stringBuilder.toString();
        } else if (this.f26665c.length <= 64) {
            stringBuilder = new StringBuilder("[hex=");
            stringBuilder.append(mo6164f());
            stringBuilder.append("]");
            return stringBuilder.toString();
        } else {
            stringBuilder = new StringBuilder("[size=");
            stringBuilder.append(this.f26665c.length);
            stringBuilder.append(" hex=");
            stringBuilder.append(mo6155a(0, 64).mo6164f());
            stringBuilder.append("…]");
            return stringBuilder.toString();
        }
    }
}
