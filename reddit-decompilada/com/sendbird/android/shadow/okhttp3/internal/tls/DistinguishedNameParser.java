package com.sendbird.android.shadow.okhttp3.internal.tls;

import javax.security.auth.x500.X500Principal;
import org.jcodec.codecs.mjpeg.JpegConst;

final class DistinguishedNameParser {
    final String f23558a;
    final int f23559b = this.f23558a.length();
    int f23560c;
    int f23561d;
    int f23562e;
    int f23563f;
    char[] f23564g;

    DistinguishedNameParser(X500Principal x500Principal) {
        this.f23558a = x500Principal.getName("RFC2253");
    }

    final String m25569a() {
        while (this.f23560c < this.f23559b && this.f23564g[this.f23560c] == ' ') {
            this.f23560c++;
        }
        if (this.f23560c == this.f23559b) {
            return null;
        }
        this.f23561d = this.f23560c;
        this.f23560c++;
        while (this.f23560c < this.f23559b && this.f23564g[this.f23560c] != '=' && this.f23564g[this.f23560c] != ' ') {
            this.f23560c++;
        }
        if (this.f23560c >= this.f23559b) {
            StringBuilder stringBuilder = new StringBuilder("Unexpected end of DN: ");
            stringBuilder.append(this.f23558a);
            throw new IllegalStateException(stringBuilder.toString());
        }
        this.f23562e = this.f23560c;
        if (this.f23564g[this.f23560c] == ' ') {
            while (this.f23560c < this.f23559b && this.f23564g[this.f23560c] != '=' && this.f23564g[this.f23560c] == ' ') {
                this.f23560c++;
            }
            if (this.f23564g[this.f23560c] != '=' || this.f23560c == this.f23559b) {
                stringBuilder = new StringBuilder("Unexpected end of DN: ");
                stringBuilder.append(this.f23558a);
                throw new IllegalStateException(stringBuilder.toString());
            }
        }
        do {
            this.f23560c++;
            if (this.f23560c >= this.f23559b) {
                break;
            }
        } while (this.f23564g[this.f23560c] == ' ');
        if (this.f23562e - this.f23561d > 4 && this.f23564g[this.f23561d + 3] == '.' && ((this.f23564g[this.f23561d] == 'O' || this.f23564g[this.f23561d] == 'o') && ((this.f23564g[this.f23561d + 1] == 'I' || this.f23564g[this.f23561d + 1] == 'i') && (this.f23564g[this.f23561d + 2] == 'D' || this.f23564g[this.f23561d + 2] == 'd')))) {
            this.f23561d += 4;
        }
        return new String(this.f23564g, this.f23561d, this.f23562e - this.f23561d);
    }

    final String m25570b() {
        if (this.f23560c + 4 >= this.f23559b) {
            StringBuilder stringBuilder = new StringBuilder("Unexpected end of DN: ");
            stringBuilder.append(this.f23558a);
            throw new IllegalStateException(stringBuilder.toString());
        }
        int i;
        this.f23561d = this.f23560c;
        this.f23560c++;
        while (this.f23560c != this.f23559b && this.f23564g[this.f23560c] != '+' && this.f23564g[this.f23560c] != ',') {
            byte[] bArr;
            int i2;
            int i3;
            if (this.f23564g[this.f23560c] == ';') {
                break;
            } else if (this.f23564g[this.f23560c] == ' ') {
                this.f23562e = this.f23560c;
                this.f23560c++;
                while (this.f23560c < this.f23559b && this.f23564g[this.f23560c] == ' ') {
                    this.f23560c++;
                }
                i = this.f23562e - this.f23561d;
                if (i >= 5) {
                    if ((i & 1) == 0) {
                        bArr = new byte[(i / 2)];
                        i2 = this.f23561d + 1;
                        for (i3 = 0; i3 < bArr.length; i3++) {
                            bArr[i3] = (byte) m25567a(i2);
                            i2 += 2;
                        }
                        return new String(this.f23564g, this.f23561d, i);
                    }
                }
                stringBuilder = new StringBuilder("Unexpected end of DN: ");
                stringBuilder.append(this.f23558a);
                throw new IllegalStateException(stringBuilder.toString());
            } else {
                if (this.f23564g[this.f23560c] >= 'A' && this.f23564g[this.f23560c] <= 'F') {
                    char[] cArr = this.f23564g;
                    i3 = this.f23560c;
                    cArr[i3] = (char) (cArr[i3] + 32);
                }
                this.f23560c++;
            }
        }
        this.f23562e = this.f23560c;
        i = this.f23562e - this.f23561d;
        if (i >= 5) {
            if ((i & 1) == 0) {
                bArr = new byte[(i / 2)];
                i2 = this.f23561d + 1;
                for (i3 = 0; i3 < bArr.length; i3++) {
                    bArr[i3] = (byte) m25567a(i2);
                    i2 += 2;
                }
                return new String(this.f23564g, this.f23561d, i);
            }
        }
        stringBuilder = new StringBuilder("Unexpected end of DN: ");
        stringBuilder.append(this.f23558a);
        throw new IllegalStateException(stringBuilder.toString());
    }

    final String m25571c() {
        this.f23561d = this.f23560c;
        this.f23562e = this.f23560c;
        while (this.f23560c < this.f23559b) {
            char c = this.f23564g[this.f23560c];
            char[] cArr;
            if (c != ' ') {
                if (c != ';') {
                    int i;
                    if (c != '\\') {
                        switch (c) {
                            case '+':
                            case ',':
                                break;
                            default:
                                cArr = this.f23564g;
                                i = this.f23562e;
                                this.f23562e = i + 1;
                                cArr[i] = this.f23564g[this.f23560c];
                                this.f23560c++;
                                continue;
                        }
                    } else {
                        cArr = this.f23564g;
                        i = this.f23562e;
                        this.f23562e = i + 1;
                        cArr[i] = m25572d();
                        this.f23560c++;
                    }
                }
                return new String(this.f23564g, this.f23561d, this.f23562e - this.f23561d);
            }
            this.f23563f = this.f23562e;
            this.f23560c++;
            cArr = this.f23564g;
            int i2 = this.f23562e;
            this.f23562e = i2 + 1;
            cArr[i2] = ' ';
            while (this.f23560c < this.f23559b && this.f23564g[this.f23560c] == ' ') {
                cArr = this.f23564g;
                i2 = this.f23562e;
                this.f23562e = i2 + 1;
                cArr[i2] = ' ';
                this.f23560c++;
            }
            if (this.f23560c == this.f23559b || this.f23564g[this.f23560c] == ',' || this.f23564g[this.f23560c] == '+' || this.f23564g[this.f23560c] == ';') {
                return new String(this.f23564g, this.f23561d, this.f23563f - this.f23561d);
            }
        }
        return new String(this.f23564g, this.f23561d, this.f23562e - this.f23561d);
    }

    final char m25572d() {
        this.f23560c++;
        if (this.f23560c == this.f23559b) {
            StringBuilder stringBuilder = new StringBuilder("Unexpected end of DN: ");
            stringBuilder.append(this.f23558a);
            throw new IllegalStateException(stringBuilder.toString());
        }
        char c = this.f23564g[this.f23560c];
        if (!(c == ' ' || c == '%' || c == '\\' || c == '_')) {
            switch (c) {
                case '\"':
                case '#':
                    break;
                default:
                    switch (c) {
                        case '*':
                        case '+':
                        case ',':
                            break;
                        default:
                            switch (c) {
                                case ';':
                                case '<':
                                case '=':
                                case '>':
                                    break;
                                default:
                                    return m25568e();
                            }
                    }
            }
        }
        return this.f23564g[this.f23560c];
    }

    private char m25568e() {
        int a = m25567a(this.f23560c);
        this.f23560c++;
        if (a < 128) {
            return (char) a;
        }
        if (a < JpegConst.SOF0 || a > 247) {
            return '?';
        }
        int i;
        if (a <= 223) {
            a &= 31;
            i = 1;
        } else if (a <= JpegConst.APPF) {
            i = 2;
            a &= 15;
        } else {
            i = 3;
            a &= 7;
        }
        int i2 = 0;
        while (i2 < i) {
            this.f23560c++;
            if (this.f23560c != this.f23559b) {
                if (this.f23564g[this.f23560c] == '\\') {
                    this.f23560c++;
                    int a2 = m25567a(this.f23560c);
                    this.f23560c++;
                    if ((a2 & JpegConst.SOF0) != 128) {
                        return '?';
                    }
                    a = (a << 6) + (a2 & 63);
                    i2++;
                }
            }
            return '?';
        }
        return (char) a;
    }

    private int m25567a(int i) {
        int i2 = i + 1;
        if (i2 >= this.f23559b) {
            StringBuilder stringBuilder = new StringBuilder("Malformed DN: ");
            stringBuilder.append(this.f23558a);
            throw new IllegalStateException(stringBuilder.toString());
        }
        i = this.f23564g[i];
        if (i >= 48 && i <= 57) {
            i -= 48;
        } else if (i >= 97 && i <= 102) {
            i -= 87;
        } else if (i < 65 || i > 70) {
            stringBuilder = new StringBuilder("Malformed DN: ");
            stringBuilder.append(this.f23558a);
            throw new IllegalStateException(stringBuilder.toString());
        } else {
            i -= 55;
        }
        char c = this.f23564g[i2];
        if (c >= '0' && c <= '9') {
            i2 = c - 48;
        } else if (c >= 'a' && c <= 'f') {
            i2 = c - 87;
        } else if (c < 'A' || c > 'F') {
            stringBuilder = new StringBuilder("Malformed DN: ");
            stringBuilder.append(this.f23558a);
            throw new IllegalStateException(stringBuilder.toString());
        } else {
            i2 = c - 55;
        }
        return (i << 4) + i2;
    }
}
