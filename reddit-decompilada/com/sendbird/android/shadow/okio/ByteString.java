package com.sendbird.android.shadow.okio;

import java.io.Serializable;
import java.security.MessageDigest;
import java.util.Arrays;

public class ByteString implements Serializable, Comparable<ByteString> {
    static final char[] f23601a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static final ByteString f23602b = m25596a(new byte[0]);
    final byte[] f23603c;
    transient int f23604d;
    transient String f23605e;

    public /* synthetic */ int compareTo(Object obj) {
        ByteString byteString = (ByteString) obj;
        int h = mo5405h();
        int h2 = byteString.mo5405h();
        int min = Math.min(h, h2);
        int i = 0;
        while (i < min) {
            int a = mo5392a(i) & 255;
            int a2 = byteString.mo5392a(i) & 255;
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
        this.f23603c = bArr;
    }

    public static ByteString m25596a(byte... bArr) {
        if (bArr != null) {
            return new ByteString((byte[]) bArr.clone());
        }
        throw new IllegalArgumentException("data == null");
    }

    public static ByteString m25595a(String str) {
        if (str == null) {
            throw new IllegalArgumentException("s == null");
        }
        ByteString byteString = new ByteString(str.getBytes(Util.f23620a));
        byteString.f23605e = str;
        return byteString;
    }

    public String mo5394a() {
        String str = this.f23605e;
        if (str != null) {
            return str;
        }
        str = new String(this.f23603c, Util.f23620a);
        this.f23605e = str;
        return str;
    }

    public String mo5398b() {
        return Base64.m25591a(this.f23603c);
    }

    public ByteString mo5399c() {
        return m25599d("MD5");
    }

    public ByteString mo5400d() {
        return m25599d("SHA-1");
    }

    public ByteString mo5401e() {
        return m25599d("SHA-256");
    }

    private ByteString m25599d(String str) {
        try {
            return m25596a(MessageDigest.getInstance(str).digest(this.f23603c));
        } catch (String str2) {
            throw new AssertionError(str2);
        }
    }

    public static ByteString m25597b(String str) {
        if (str == null) {
            throw new IllegalArgumentException("base64 == null");
        }
        str = Base64.m25593a(str);
        return str != null ? new ByteString(str) : null;
    }

    public String mo5403f() {
        int i = 0;
        char[] cArr = new char[(this.f23603c.length * 2)];
        byte[] bArr = this.f23603c;
        int length = bArr.length;
        int i2 = 0;
        while (i < length) {
            byte b = bArr[i];
            int i3 = i2 + 1;
            cArr[i2] = f23601a[(b >> 4) & 15];
            i2 = i3 + 1;
            cArr[i3] = f23601a[b & 15];
            i++;
        }
        return new String(cArr);
    }

    public static ByteString m25598c(String str) {
        if (str.length() % 2 != 0) {
            StringBuilder stringBuilder = new StringBuilder("Unexpected hex string: ");
            stringBuilder.append(str);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        byte[] bArr = new byte[(str.length() / 2)];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) ((m25594a(str.charAt(i2)) << 4) + m25594a(str.charAt(i2 + 1)));
        }
        return m25596a(bArr);
    }

    private static int m25594a(char c) {
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

    public ByteString mo5404g() {
        int i = 0;
        while (i < this.f23603c.length) {
            byte b = this.f23603c[i];
            if (b < (byte) 65 || b > (byte) 90) {
                i++;
            } else {
                byte[] bArr = (byte[]) this.f23603c.clone();
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

    public ByteString mo5393a(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("beginIndex < 0");
        } else if (i2 > this.f23603c.length) {
            i2 = new StringBuilder("endIndex > length(");
            i2.append(this.f23603c.length);
            i2.append(")");
            throw new IllegalArgumentException(i2.toString());
        } else {
            int i3 = i2 - i;
            if (i3 < 0) {
                throw new IllegalArgumentException("endIndex < beginIndex");
            } else if (i == 0 && i2 == this.f23603c.length) {
                return this;
            } else {
                i2 = new byte[i3];
                System.arraycopy(this.f23603c, i, i2, 0, i3);
                return new ByteString(i2);
            }
        }
    }

    public byte mo5392a(int i) {
        return this.f23603c[i];
    }

    public int mo5405h() {
        return this.f23603c.length;
    }

    public byte[] mo5407i() {
        return (byte[]) this.f23603c.clone();
    }

    void mo5395a(Buffer buffer) {
        buffer.m35465b(this.f23603c, 0, this.f23603c.length);
    }

    public boolean mo5396a(int i, ByteString byteString, int i2, int i3) {
        return byteString.mo5397a(0, this.f23603c, 0, i3);
    }

    public boolean mo5397a(int i, byte[] bArr, int i2, int i3) {
        return i >= 0 && i <= this.f23603c.length - i3 && i2 >= 0 && i2 <= bArr.length - i3 && Util.m25645a(this.f23603c, i, bArr, i2, i3) != 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            return byteString.mo5405h() == this.f23603c.length && byteString.mo5397a(0, this.f23603c, 0, this.f23603c.length) != null;
        }
    }

    public int hashCode() {
        int i = this.f23604d;
        if (i != 0) {
            return i;
        }
        i = Arrays.hashCode(this.f23603c);
        this.f23604d = i;
        return i;
    }

    public String toString() {
        if (this.f23603c.length == 0) {
            return "[size=0]";
        }
        String a = mo5394a();
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
                stringBuilder.append(this.f23603c.length);
                stringBuilder.append(" text=");
                stringBuilder.append(replace);
                stringBuilder.append("…]");
                return stringBuilder.toString();
            }
            stringBuilder = new StringBuilder("[text=");
            stringBuilder.append(replace);
            stringBuilder.append("]");
            return stringBuilder.toString();
        } else if (this.f23603c.length <= 64) {
            stringBuilder = new StringBuilder("[hex=");
            stringBuilder.append(mo5403f());
            stringBuilder.append("]");
            return stringBuilder.toString();
        } else {
            stringBuilder = new StringBuilder("[size=");
            stringBuilder.append(this.f23603c.length);
            stringBuilder.append(" hex=");
            stringBuilder.append(mo5393a(0, 64).mo5403f());
            stringBuilder.append("…]");
            return stringBuilder.toString();
        }
    }
}
