package com.squareup.moshi;

import com.squareup.moshi.JsonReader.Options;
import com.squareup.moshi.JsonReader.Token;
import java.io.EOFException;
import java.io.IOException;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;

final class JsonUtf8Reader extends JsonReader {
    private static final ByteString f30632g = ByteString.m28267a("'\\");
    private static final ByteString f30633h = ByteString.m28267a("\"\\");
    private static final ByteString f30634i = ByteString.m28267a("{}[]:, \n\t\r\f/\\;#=");
    private static final ByteString f30635j = ByteString.m28267a("\n\r");
    private final BufferedSource f30636k;
    private final Buffer f30637l;
    private int f30638m = 0;
    private long f30639n;
    private int f30640o;
    private String f30641p;

    JsonUtf8Reader(BufferedSource bufferedSource) {
        if (bufferedSource == null) {
            throw new NullPointerException("source == null");
        }
        this.f30636k = bufferedSource;
        this.f30637l = bufferedSource.mo6754a();
        m25660a(6);
    }

    public final void mo5417a() throws IOException {
        int i = this.f30638m;
        if (i == 0) {
            i = m31599r();
        }
        if (i == 3) {
            m25660a(1);
            this.d[this.a - 1] = 0;
            this.f30638m = 0;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder("Expected BEGIN_ARRAY but was ");
        stringBuilder.append(mo5423f());
        stringBuilder.append(" at path ");
        stringBuilder.append(m25676p());
        throw new JsonDataException(stringBuilder.toString());
    }

    public final void mo5419b() throws IOException {
        int i = this.f30638m;
        if (i == 0) {
            i = m31599r();
        }
        if (i == 4) {
            this.a--;
            int[] iArr = this.d;
            int i2 = this.a - 1;
            iArr[i2] = iArr[i2] + 1;
            this.f30638m = 0;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder("Expected END_ARRAY but was ");
        stringBuilder.append(mo5423f());
        stringBuilder.append(" at path ");
        stringBuilder.append(m25676p());
        throw new JsonDataException(stringBuilder.toString());
    }

    public final void mo5420c() throws IOException {
        int i = this.f30638m;
        if (i == 0) {
            i = m31599r();
        }
        if (i == 1) {
            m25660a(3);
            this.f30638m = 0;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder("Expected BEGIN_OBJECT but was ");
        stringBuilder.append(mo5423f());
        stringBuilder.append(" at path ");
        stringBuilder.append(m25676p());
        throw new JsonDataException(stringBuilder.toString());
    }

    public final void mo5421d() throws IOException {
        int i = this.f30638m;
        if (i == 0) {
            i = m31599r();
        }
        if (i == 2) {
            this.a--;
            this.c[this.a] = null;
            int[] iArr = this.d;
            int i2 = this.a - 1;
            iArr[i2] = iArr[i2] + 1;
            this.f30638m = 0;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder("Expected END_OBJECT but was ");
        stringBuilder.append(mo5423f());
        stringBuilder.append(" at path ");
        stringBuilder.append(m25676p());
        throw new JsonDataException(stringBuilder.toString());
    }

    public final boolean mo5422e() throws IOException {
        int i = this.f30638m;
        if (i == 0) {
            i = m31599r();
        }
        return (i == 2 || i == 4) ? false : true;
    }

    public final Token mo5423f() throws IOException {
        int i = this.f30638m;
        if (i == 0) {
            i = m31599r();
        }
        switch (i) {
            case 1:
                return Token.BEGIN_OBJECT;
            case 2:
                return Token.END_OBJECT;
            case 3:
                return Token.BEGIN_ARRAY;
            case 4:
                return Token.END_ARRAY;
            case 5:
            case 6:
                return Token.BOOLEAN;
            case 7:
                return Token.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return Token.STRING;
            case 12:
            case 13:
            case 14:
            case 15:
                return Token.NAME;
            case 16:
            case 17:
                return Token.NUMBER;
            case 18:
                return Token.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    private int m31599r() throws IOException {
        int a;
        int i = this.b[this.a - 1];
        if (i == 1) {
            r0.b[r0.a - 1] = 2;
        } else if (i == 2) {
            a = m31594a(true);
            r0.f30637l.mo6773g();
            if (a != 44) {
                if (a == 59) {
                    m31604w();
                } else if (a != 93) {
                    throw m25658a("Unterminated array");
                } else {
                    r0.f30638m = 4;
                    return 4;
                }
            }
        } else {
            if (i != 3) {
                if (i != 5) {
                    if (i == 4) {
                        r0.b[r0.a - 1] = 5;
                        a = m31594a(true);
                        r0.f30637l.mo6773g();
                        if (a != 58) {
                            if (a != 61) {
                                throw m25658a("Expected ':'");
                            }
                            m31604w();
                            if (r0.f30636k.mo6762b(1) && r0.f30637l.m36499c(0) == (byte) 62) {
                                r0.f30637l.mo6773g();
                            }
                        }
                    } else if (i == 6) {
                        r0.b[r0.a - 1] = 7;
                    } else if (i == 7) {
                        if (m31594a(false) == -1) {
                            r0.f30638m = 18;
                            return 18;
                        }
                        m31604w();
                    } else if (i == 8) {
                        throw new IllegalStateException("JsonReader is closed");
                    }
                }
            }
            r0.b[r0.a - 1] = 4;
            if (i == 5) {
                int a2 = m31594a(true);
                r0.f30637l.mo6773g();
                if (a2 != 44) {
                    if (a2 == 59) {
                        m31604w();
                    } else if (a2 != 125) {
                        throw m25658a("Unterminated object");
                    } else {
                        r0.f30638m = 2;
                        return 2;
                    }
                }
            }
            int a3 = m31594a(true);
            if (a3 == 34) {
                r0.f30637l.mo6773g();
                r0.f30638m = 13;
                return 13;
            } else if (a3 == 39) {
                r0.f30637l.mo6773g();
                m31604w();
                r0.f30638m = 12;
                return 12;
            } else if (a3 != 125) {
                m31604w();
                if (m31598b((char) a3)) {
                    r0.f30638m = 14;
                    return 14;
                }
                throw m25658a("Expected name");
            } else if (i != 5) {
                r0.f30637l.mo6773g();
                r0.f30638m = 2;
                return 2;
            } else {
                throw m25658a("Expected name");
            }
        }
        a = m31594a(true);
        if (a == 34) {
            r0.f30637l.mo6773g();
            r0.f30638m = 9;
            return 9;
        } else if (a != 39) {
            if (!(a == 44 || a == 59)) {
                if (a == 91) {
                    r0.f30637l.mo6773g();
                    r0.f30638m = 3;
                    return 3;
                } else if (a != 93) {
                    if (a != 123) {
                        i = m31600s();
                        if (i != 0) {
                            return i;
                        }
                        i = m31601t();
                        if (i != 0) {
                            return i;
                        }
                        if (m31598b(r0.f30637l.m36499c(0))) {
                            m31604w();
                            r0.f30638m = 10;
                            return 10;
                        }
                        throw m25658a("Expected value");
                    }
                    r0.f30637l.mo6773g();
                    r0.f30638m = 1;
                    return 1;
                } else if (i == 1) {
                    r0.f30637l.mo6773g();
                    r0.f30638m = 4;
                    return 4;
                }
            }
            if (i != 1) {
                if (i != 2) {
                    throw m25658a("Unexpected value");
                }
            }
            m31604w();
            r0.f30638m = 7;
            return 7;
        } else {
            m31604w();
            r0.f30637l.mo6773g();
            r0.f30638m = 8;
            return 8;
        }
    }

    private int m31600s() throws IOException {
        String str;
        String str2;
        int i;
        int length;
        int i2;
        int i3;
        char c;
        byte c2 = this.f30637l.m36499c(0);
        if (c2 != (byte) 116) {
            if (c2 != (byte) 84) {
                if (c2 != (byte) 102) {
                    if (c2 != (byte) 70) {
                        if (c2 != (byte) 110) {
                            if (c2 != (byte) 78) {
                                return 0;
                            }
                        }
                        str = "null";
                        str2 = "NULL";
                        i = 7;
                        length = str.length();
                        i2 = 1;
                        while (i2 < length) {
                            i3 = i2 + 1;
                            if (this.f30636k.mo6762b((long) i3)) {
                                return 0;
                            }
                            c = this.f30637l.m36499c((long) i2);
                            if (c != str.charAt(i2) && c != r2.charAt(i2)) {
                                return 0;
                            }
                            i2 = i3;
                        }
                        if (!this.f30636k.mo6762b((long) (length + 1)) && m31598b(this.f30637l.m36499c((long) length))) {
                            return 0;
                        }
                        this.f30637l.mo6779i((long) length);
                        this.f30638m = i;
                        return i;
                    }
                }
                str = "false";
                str2 = "FALSE";
                i = 6;
                length = str.length();
                i2 = 1;
                while (i2 < length) {
                    i3 = i2 + 1;
                    if (this.f30636k.mo6762b((long) i3)) {
                        return 0;
                    }
                    c = this.f30637l.m36499c((long) i2);
                    if (c != str.charAt(i2)) {
                    }
                    i2 = i3;
                }
                if (!this.f30636k.mo6762b((long) (length + 1))) {
                }
                this.f30637l.mo6779i((long) length);
                this.f30638m = i;
                return i;
            }
        }
        str = "true";
        str2 = "TRUE";
        i = 5;
        length = str.length();
        i2 = 1;
        while (i2 < length) {
            i3 = i2 + 1;
            if (this.f30636k.mo6762b((long) i3)) {
                return 0;
            }
            c = this.f30637l.m36499c((long) i2);
            if (c != str.charAt(i2)) {
            }
            i2 = i3;
        }
        if (!this.f30636k.mo6762b((long) (length + 1))) {
        }
        this.f30637l.mo6779i((long) length);
        this.f30638m = i;
        return i;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int m31601t() throws java.io.IOException {
        /*
        r17 = this;
        r0 = r17;
        r1 = 0;
        r3 = 1;
        r4 = 0;
        r8 = r1;
        r7 = r3;
        r5 = r4;
        r6 = r5;
        r10 = r6;
    L_0x000b:
        r11 = r0.f30636k;
        r12 = r5 + 1;
        r13 = (long) r12;
        r11 = r11.mo6762b(r13);
        r15 = 2;
        if (r11 == 0) goto L_0x009d;
    L_0x0017:
        r11 = r0.f30637l;
        r13 = (long) r5;
        r11 = r11.m36499c(r13);
        r13 = 43;
        r14 = 5;
        if (r11 == r13) goto L_0x0093;
    L_0x0023:
        r13 = 69;
        if (r11 == r13) goto L_0x008a;
    L_0x0027:
        r13 = 101; // 0x65 float:1.42E-43 double:5.0E-322;
        if (r11 == r13) goto L_0x008a;
    L_0x002b:
        switch(r11) {
            case 45: goto L_0x0080;
            case 46: goto L_0x007b;
            default: goto L_0x002e;
        };
    L_0x002e:
        r13 = 48;
        if (r11 < r13) goto L_0x0074;
    L_0x0032:
        r13 = 57;
        if (r11 <= r13) goto L_0x0037;
    L_0x0036:
        goto L_0x0074;
    L_0x0037:
        if (r6 == r3) goto L_0x006d;
    L_0x0039:
        if (r6 != 0) goto L_0x003c;
    L_0x003b:
        goto L_0x006d;
    L_0x003c:
        if (r6 != r15) goto L_0x0061;
    L_0x003e:
        r5 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1));
        if (r5 != 0) goto L_0x0043;
    L_0x0042:
        return r4;
    L_0x0043:
        r13 = 10;
        r13 = r13 * r8;
        r11 = r11 + -48;
        r1 = (long) r11;
        r13 = r13 - r1;
        r1 = -922337203685477580; // 0xf333333333333334 float:4.1723254E-8 double:-8.390303882365713E246;
        r1 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1));
        if (r1 > 0) goto L_0x005c;
    L_0x0053:
        if (r1 != 0) goto L_0x005a;
    L_0x0055:
        r1 = (r13 > r8 ? 1 : (r13 == r8 ? 0 : -1));
        if (r1 >= 0) goto L_0x005a;
    L_0x0059:
        goto L_0x005c;
    L_0x005a:
        r1 = r4;
        goto L_0x005d;
    L_0x005c:
        r1 = r3;
    L_0x005d:
        r1 = r1 & r7;
        r7 = r1;
        r8 = r13;
        goto L_0x0097;
    L_0x0061:
        r1 = 3;
        if (r6 != r1) goto L_0x0066;
    L_0x0064:
        r6 = 4;
        goto L_0x0097;
    L_0x0066:
        if (r6 == r14) goto L_0x006b;
    L_0x0068:
        r1 = 6;
        if (r6 != r1) goto L_0x0097;
    L_0x006b:
        r6 = 7;
        goto L_0x0097;
    L_0x006d:
        r11 = r11 + -48;
        r1 = -r11;
        r1 = (long) r1;
        r8 = r1;
        r6 = r15;
        goto L_0x0097;
    L_0x0074:
        r1 = r0.m31598b(r11);
        if (r1 == 0) goto L_0x009d;
    L_0x007a:
        return r4;
    L_0x007b:
        r1 = 3;
        if (r6 != r15) goto L_0x007f;
    L_0x007e:
        goto L_0x0096;
    L_0x007f:
        return r4;
    L_0x0080:
        r1 = 6;
        if (r6 != 0) goto L_0x0086;
    L_0x0083:
        r6 = r3;
        r10 = r6;
        goto L_0x0097;
    L_0x0086:
        if (r6 != r14) goto L_0x0089;
    L_0x0088:
        goto L_0x0096;
    L_0x0089:
        return r4;
    L_0x008a:
        if (r6 == r15) goto L_0x0091;
    L_0x008c:
        r1 = 4;
        if (r6 != r1) goto L_0x0090;
    L_0x008f:
        goto L_0x0091;
    L_0x0090:
        return r4;
    L_0x0091:
        r6 = r14;
        goto L_0x0097;
    L_0x0093:
        r1 = 6;
        if (r6 != r14) goto L_0x009c;
    L_0x0096:
        r6 = r1;
    L_0x0097:
        r5 = r12;
        r1 = 0;
        goto L_0x000b;
    L_0x009c:
        return r4;
    L_0x009d:
        if (r6 != r15) goto L_0x00c2;
    L_0x009f:
        if (r7 == 0) goto L_0x00c2;
    L_0x00a1:
        r1 = -9223372036854775808;
        r1 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1));
        if (r1 != 0) goto L_0x00a9;
    L_0x00a7:
        if (r10 == 0) goto L_0x00c2;
    L_0x00a9:
        r1 = 0;
        r1 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1));
        if (r1 != 0) goto L_0x00b1;
    L_0x00af:
        if (r10 != 0) goto L_0x00c2;
    L_0x00b1:
        if (r10 == 0) goto L_0x00b4;
    L_0x00b3:
        goto L_0x00b5;
    L_0x00b4:
        r8 = -r8;
    L_0x00b5:
        r0.f30639n = r8;
        r1 = r0.f30637l;
        r2 = (long) r5;
        r1.mo6779i(r2);
        r1 = 16;
        r0.f30638m = r1;
        return r1;
    L_0x00c2:
        if (r6 == r15) goto L_0x00cc;
    L_0x00c4:
        r1 = 4;
        if (r6 == r1) goto L_0x00cc;
    L_0x00c7:
        r1 = 7;
        if (r6 != r1) goto L_0x00cb;
    L_0x00ca:
        goto L_0x00cc;
    L_0x00cb:
        return r4;
    L_0x00cc:
        r0.f30640o = r5;
        r1 = 17;
        r0.f30638m = r1;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.moshi.JsonUtf8Reader.t():int");
    }

    private boolean m31598b(int i) throws IOException {
        switch (i) {
            case 9:
            case 10:
            case 12:
            case 13:
            case 32:
            case 44:
            case 58:
            case 91:
            case 93:
            case 123:
            case 125:
                break;
            case 35:
            case 47:
            case 59:
            case 61:
            case 92:
                m31604w();
                break;
            default:
                return true;
        }
        return false;
    }

    public final String mo5424g() throws IOException {
        String u;
        int i = this.f30638m;
        if (i == 0) {
            i = m31599r();
        }
        if (i == 14) {
            u = m31602u();
        } else if (i == 13) {
            u = m31595a(f30633h);
        } else if (i == 12) {
            u = m31595a(f30632g);
        } else if (i == 15) {
            u = this.f30641p;
        } else {
            StringBuilder stringBuilder = new StringBuilder("Expected a name but was ");
            stringBuilder.append(mo5423f());
            stringBuilder.append(" at path ");
            stringBuilder.append(m25676p());
            throw new JsonDataException(stringBuilder.toString());
        }
        this.f30638m = 0;
        this.c[this.a - 1] = u;
        return u;
    }

    public final int mo5416a(Options options) throws IOException {
        int i = this.f30638m;
        if (i == 0) {
            i = m31599r();
        }
        if (i >= 12) {
            if (i <= 15) {
                if (i == 15) {
                    return m31593a(this.f30641p, options);
                }
                i = this.f30636k.mo6749a(options.f23633b);
                if (i != -1) {
                    this.f30638m = 0;
                    this.c[this.a - 1] = options.f23632a[i];
                    return i;
                }
                String str = this.c[this.a - 1];
                String g = mo5424g();
                options = m31593a(g, options);
                if (options == -1) {
                    this.f30638m = 15;
                    this.f30641p = g;
                    this.c[this.a - 1] = str;
                }
                return options;
            }
        }
        return -1;
    }

    private int m31593a(String str, Options options) {
        int length = options.f23632a.length;
        for (int i = 0; i < length; i++) {
            if (str.equals(options.f23632a[i])) {
                this.f30638m = 0;
                this.c[this.a - 1] = str;
                return i;
            }
        }
        return -1;
    }

    public final String mo5425h() throws IOException {
        String u;
        int i = this.f30638m;
        if (i == 0) {
            i = m31599r();
        }
        if (i == 10) {
            u = m31602u();
        } else if (i == 9) {
            u = m31595a(f30633h);
        } else if (i == 8) {
            u = m31595a(f30632g);
        } else if (i == 11) {
            u = this.f30641p;
            this.f30641p = null;
        } else if (i == 16) {
            u = Long.toString(this.f30639n);
        } else if (i == 17) {
            u = this.f30637l.m36510e((long) this.f30640o);
        } else {
            StringBuilder stringBuilder = new StringBuilder("Expected a string but was ");
            stringBuilder.append(mo5423f());
            stringBuilder.append(" at path ");
            stringBuilder.append(m25676p());
            throw new JsonDataException(stringBuilder.toString());
        }
        this.f30638m = 0;
        int[] iArr = this.d;
        int i2 = this.a - 1;
        iArr[i2] = iArr[i2] + 1;
        return u;
    }

    public final int mo5418b(Options options) throws IOException {
        int i = this.f30638m;
        if (i == 0) {
            i = m31599r();
        }
        if (i >= 8) {
            if (i <= 11) {
                if (i == 11) {
                    return m31596b(this.f30641p, options);
                }
                i = this.f30636k.mo6749a(options.f23633b);
                int i2;
                if (i != -1) {
                    this.f30638m = null;
                    options = this.d;
                    i2 = this.a - 1;
                    options[i2] = options[i2] + 1;
                    return i;
                }
                String h = mo5425h();
                options = m31596b(h, options);
                if (options == -1) {
                    this.f30638m = 11;
                    this.f30641p = h;
                    int[] iArr = this.d;
                    i2 = this.a - 1;
                    iArr[i2] = iArr[i2] - 1;
                }
                return options;
            }
        }
        return -1;
    }

    private int m31596b(String str, Options options) {
        int length = options.f23632a.length;
        for (int i = 0; i < length; i++) {
            if (str.equals(options.f23632a[i])) {
                this.f30638m = 0;
                str = this.d;
                options = this.a - 1;
                str[options] = str[options] + 1;
                return i;
            }
        }
        return -1;
    }

    public final boolean mo5426i() throws IOException {
        int i = this.f30638m;
        if (i == 0) {
            i = m31599r();
        }
        int[] iArr;
        int i2;
        if (i == 5) {
            this.f30638m = 0;
            iArr = this.d;
            i2 = this.a - 1;
            iArr[i2] = iArr[i2] + 1;
            return true;
        } else if (i == 6) {
            this.f30638m = 0;
            iArr = this.d;
            i2 = this.a - 1;
            iArr[i2] = iArr[i2] + 1;
            return false;
        } else {
            StringBuilder stringBuilder = new StringBuilder("Expected a boolean but was ");
            stringBuilder.append(mo5423f());
            stringBuilder.append(" at path ");
            stringBuilder.append(m25676p());
            throw new JsonDataException(stringBuilder.toString());
        }
    }

    public final <T> T mo5427j() throws IOException {
        int i = this.f30638m;
        if (i == 0) {
            i = m31599r();
        }
        if (i == 7) {
            this.f30638m = 0;
            int[] iArr = this.d;
            int i2 = this.a - 1;
            iArr[i2] = iArr[i2] + 1;
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder("Expected null but was ");
        stringBuilder.append(mo5423f());
        stringBuilder.append(" at path ");
        stringBuilder.append(m25676p());
        throw new JsonDataException(stringBuilder.toString());
    }

    public final double mo5428k() throws java.io.IOException {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r6 = this;
        r0 = r6.f30638m;
        if (r0 != 0) goto L_0x0008;
    L_0x0004:
        r0 = r6.m31599r();
    L_0x0008:
        r1 = 16;
        r2 = 0;
        if (r0 != r1) goto L_0x001f;
    L_0x000d:
        r6.f30638m = r2;
        r0 = r6.d;
        r1 = r6.a;
        r1 = r1 + -1;
        r2 = r0[r1];
        r2 = r2 + 1;
        r0[r1] = r2;
        r0 = r6.f30639n;
        r0 = (double) r0;
        return r0;
    L_0x001f:
        r1 = 17;
        r3 = 11;
        if (r0 != r1) goto L_0x0031;
    L_0x0025:
        r0 = r6.f30637l;
        r1 = r6.f30640o;
        r4 = (long) r1;
        r0 = r0.m36510e(r4);
        r6.f30641p = r0;
        goto L_0x007c;
    L_0x0031:
        r1 = 9;
        if (r0 != r1) goto L_0x003e;
    L_0x0035:
        r0 = f30633h;
        r0 = r6.m31595a(r0);
        r6.f30641p = r0;
        goto L_0x007c;
    L_0x003e:
        r1 = 8;
        if (r0 != r1) goto L_0x004b;
    L_0x0042:
        r0 = f30632g;
        r0 = r6.m31595a(r0);
        r6.f30641p = r0;
        goto L_0x007c;
    L_0x004b:
        r1 = 10;
        if (r0 != r1) goto L_0x0056;
    L_0x004f:
        r0 = r6.m31602u();
        r6.f30641p = r0;
        goto L_0x007c;
    L_0x0056:
        if (r0 == r3) goto L_0x007c;
    L_0x0058:
        r0 = new com.squareup.moshi.JsonDataException;
        r1 = new java.lang.StringBuilder;
        r2 = "Expected a double but was ";
        r1.<init>(r2);
        r2 = r6.mo5423f();
        r1.append(r2);
        r2 = " at path ";
        r1.append(r2);
        r2 = r6.m25676p();
        r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x007c:
        r6.f30638m = r3;
        r0 = r6.f30641p;	 Catch:{ NumberFormatException -> 0x00c6 }
        r0 = java.lang.Double.parseDouble(r0);	 Catch:{ NumberFormatException -> 0x00c6 }
        r3 = r6.e;
        if (r3 != 0) goto L_0x00b4;
    L_0x0088:
        r3 = java.lang.Double.isNaN(r0);
        if (r3 != 0) goto L_0x0094;
    L_0x008e:
        r3 = java.lang.Double.isInfinite(r0);
        if (r3 == 0) goto L_0x00b4;
    L_0x0094:
        r2 = new com.squareup.moshi.JsonEncodingException;
        r3 = new java.lang.StringBuilder;
        r4 = "JSON forbids NaN and infinities: ";
        r3.<init>(r4);
        r3.append(r0);
        r0 = " at path ";
        r3.append(r0);
        r0 = r6.m25676p();
        r3.append(r0);
        r0 = r3.toString();
        r2.<init>(r0);
        throw r2;
    L_0x00b4:
        r3 = 0;
        r6.f30641p = r3;
        r6.f30638m = r2;
        r2 = r6.d;
        r3 = r6.a;
        r3 = r3 + -1;
        r4 = r2[r3];
        r4 = r4 + 1;
        r2[r3] = r4;
        return r0;
    L_0x00c6:
        r0 = new com.squareup.moshi.JsonDataException;
        r1 = new java.lang.StringBuilder;
        r2 = "Expected a double but was ";
        r1.<init>(r2);
        r2 = r6.f30641p;
        r1.append(r2);
        r2 = " at path ";
        r1.append(r2);
        r2 = r6.m25676p();
        r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.moshi.JsonUtf8Reader.k():double");
    }

    public final long mo5429l() throws java.io.IOException {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r7 = this;
        r0 = r7.f30638m;
        if (r0 != 0) goto L_0x0008;
    L_0x0004:
        r0 = r7.m31599r();
    L_0x0008:
        r1 = 16;
        r2 = 0;
        if (r0 != r1) goto L_0x001e;
    L_0x000d:
        r7.f30638m = r2;
        r0 = r7.d;
        r1 = r7.a;
        r1 = r1 + -1;
        r2 = r0[r1];
        r2 = r2 + 1;
        r0[r1] = r2;
        r0 = r7.f30639n;
        return r0;
    L_0x001e:
        r1 = 17;
        r3 = 11;
        if (r0 != r1) goto L_0x0030;
    L_0x0024:
        r0 = r7.f30637l;
        r1 = r7.f30640o;
        r4 = (long) r1;
        r0 = r0.m36510e(r4);
        r7.f30641p = r0;
        goto L_0x0085;
    L_0x0030:
        r1 = 9;
        if (r0 == r1) goto L_0x005f;
    L_0x0034:
        r4 = 8;
        if (r0 != r4) goto L_0x0039;
    L_0x0038:
        goto L_0x005f;
    L_0x0039:
        if (r0 == r3) goto L_0x0085;
    L_0x003b:
        r0 = new com.squareup.moshi.JsonDataException;
        r1 = new java.lang.StringBuilder;
        r2 = "Expected a long but was ";
        r1.<init>(r2);
        r2 = r7.mo5423f();
        r1.append(r2);
        r2 = " at path ";
        r1.append(r2);
        r2 = r7.m25676p();
        r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x005f:
        if (r0 != r1) goto L_0x0068;
    L_0x0061:
        r0 = f30633h;
        r0 = r7.m31595a(r0);
        goto L_0x006e;
    L_0x0068:
        r0 = f30632g;
        r0 = r7.m31595a(r0);
    L_0x006e:
        r7.f30641p = r0;
        r0 = r7.f30641p;	 Catch:{ NumberFormatException -> 0x0085 }
        r0 = java.lang.Long.parseLong(r0);	 Catch:{ NumberFormatException -> 0x0085 }
        r7.f30638m = r2;	 Catch:{ NumberFormatException -> 0x0085 }
        r4 = r7.d;	 Catch:{ NumberFormatException -> 0x0085 }
        r5 = r7.a;	 Catch:{ NumberFormatException -> 0x0085 }
        r5 = r5 + -1;	 Catch:{ NumberFormatException -> 0x0085 }
        r6 = r4[r5];	 Catch:{ NumberFormatException -> 0x0085 }
        r6 = r6 + 1;	 Catch:{ NumberFormatException -> 0x0085 }
        r4[r5] = r6;	 Catch:{ NumberFormatException -> 0x0085 }
        return r0;
    L_0x0085:
        r7.f30638m = r3;
        r0 = new java.math.BigDecimal;	 Catch:{ NumberFormatException -> 0x00a4, NumberFormatException -> 0x00a4 }
        r1 = r7.f30641p;	 Catch:{ NumberFormatException -> 0x00a4, NumberFormatException -> 0x00a4 }
        r0.<init>(r1);	 Catch:{ NumberFormatException -> 0x00a4, NumberFormatException -> 0x00a4 }
        r0 = r0.longValueExact();	 Catch:{ NumberFormatException -> 0x00a4, NumberFormatException -> 0x00a4 }
        r3 = 0;
        r7.f30641p = r3;
        r7.f30638m = r2;
        r2 = r7.d;
        r3 = r7.a;
        r3 = r3 + -1;
        r4 = r2[r3];
        r4 = r4 + 1;
        r2[r3] = r4;
        return r0;
    L_0x00a4:
        r0 = new com.squareup.moshi.JsonDataException;
        r1 = new java.lang.StringBuilder;
        r2 = "Expected a long but was ";
        r1.<init>(r2);
        r2 = r7.f30641p;
        r1.append(r2);
        r2 = " at path ";
        r1.append(r2);
        r2 = r7.m25676p();
        r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.moshi.JsonUtf8Reader.l():long");
    }

    private String m31595a(ByteString byteString) throws IOException {
        StringBuilder stringBuilder = null;
        while (true) {
            long b = this.f30636k.mo6758b(byteString);
            if (b != -1) {
                if (this.f30637l.m36499c(b) != (byte) 92) {
                    break;
                }
                if (stringBuilder == null) {
                    stringBuilder = new StringBuilder();
                }
                stringBuilder.append(this.f30637l.m36510e(b));
                this.f30637l.mo6773g();
                stringBuilder.append(m31606y());
            } else {
                throw m25658a("Unterminated string");
            }
        }
        if (stringBuilder == null) {
            byteString = this.f30637l.m36510e(b);
            this.f30637l.mo6773g();
            return byteString;
        }
        stringBuilder.append(this.f30637l.m36510e(b));
        this.f30637l.mo6773g();
        return stringBuilder.toString();
    }

    private String m31602u() throws IOException {
        long b = this.f30636k.mo6758b(f30634i);
        return b != -1 ? this.f30637l.m36510e(b) : this.f30637l.m36535p();
    }

    private void m31597b(ByteString byteString) throws IOException {
        while (true) {
            long b = this.f30636k.mo6758b(byteString);
            if (b == -1) {
                throw m25658a("Unterminated string");
            } else if (this.f30637l.m36499c(b) == (byte) 92) {
                this.f30637l.mo6779i(b + 1);
                m31606y();
            } else {
                this.f30637l.mo6779i(b + 1);
                return;
            }
        }
    }

    private void m31603v() throws IOException {
        long b = this.f30636k.mo6758b(f30634i);
        Buffer buffer = this.f30637l;
        if (b == -1) {
            b = this.f30637l.f36201b;
        }
        buffer.mo6779i(b);
    }

    public final int mo5430m() throws java.io.IOException {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r7 = this;
        r0 = r7.f30638m;
        if (r0 != 0) goto L_0x0008;
    L_0x0004:
        r0 = r7.m31599r();
    L_0x0008:
        r1 = 16;
        r2 = 0;
        if (r0 != r1) goto L_0x0048;
    L_0x000d:
        r0 = r7.f30639n;
        r0 = (int) r0;
        r3 = r7.f30639n;
        r5 = (long) r0;
        r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1));
        if (r1 == 0) goto L_0x0039;
    L_0x0017:
        r0 = new com.squareup.moshi.JsonDataException;
        r1 = new java.lang.StringBuilder;
        r2 = "Expected an int but was ";
        r1.<init>(r2);
        r2 = r7.f30639n;
        r1.append(r2);
        r2 = " at path ";
        r1.append(r2);
        r2 = r7.m25676p();
        r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x0039:
        r7.f30638m = r2;
        r1 = r7.d;
        r2 = r7.a;
        r2 = r2 + -1;
        r3 = r1[r2];
        r3 = r3 + 1;
        r1[r2] = r3;
        return r0;
    L_0x0048:
        r1 = 17;
        r3 = 11;
        if (r0 != r1) goto L_0x005a;
    L_0x004e:
        r0 = r7.f30637l;
        r1 = r7.f30640o;
        r4 = (long) r1;
        r0 = r0.m36510e(r4);
        r7.f30641p = r0;
        goto L_0x00af;
    L_0x005a:
        r1 = 9;
        if (r0 == r1) goto L_0x0089;
    L_0x005e:
        r4 = 8;
        if (r0 != r4) goto L_0x0063;
    L_0x0062:
        goto L_0x0089;
    L_0x0063:
        if (r0 == r3) goto L_0x00af;
    L_0x0065:
        r0 = new com.squareup.moshi.JsonDataException;
        r1 = new java.lang.StringBuilder;
        r2 = "Expected an int but was ";
        r1.<init>(r2);
        r2 = r7.mo5423f();
        r1.append(r2);
        r2 = " at path ";
        r1.append(r2);
        r2 = r7.m25676p();
        r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x0089:
        if (r0 != r1) goto L_0x0092;
    L_0x008b:
        r0 = f30633h;
        r0 = r7.m31595a(r0);
        goto L_0x0098;
    L_0x0092:
        r0 = f30632g;
        r0 = r7.m31595a(r0);
    L_0x0098:
        r7.f30641p = r0;
        r0 = r7.f30641p;	 Catch:{ NumberFormatException -> 0x00af }
        r0 = java.lang.Integer.parseInt(r0);	 Catch:{ NumberFormatException -> 0x00af }
        r7.f30638m = r2;	 Catch:{ NumberFormatException -> 0x00af }
        r1 = r7.d;	 Catch:{ NumberFormatException -> 0x00af }
        r4 = r7.a;	 Catch:{ NumberFormatException -> 0x00af }
        r4 = r4 + -1;	 Catch:{ NumberFormatException -> 0x00af }
        r5 = r1[r4];	 Catch:{ NumberFormatException -> 0x00af }
        r5 = r5 + 1;	 Catch:{ NumberFormatException -> 0x00af }
        r1[r4] = r5;	 Catch:{ NumberFormatException -> 0x00af }
        return r0;
    L_0x00af:
        r7.f30638m = r3;
        r0 = r7.f30641p;	 Catch:{ NumberFormatException -> 0x00f1 }
        r0 = java.lang.Double.parseDouble(r0);	 Catch:{ NumberFormatException -> 0x00f1 }
        r3 = (int) r0;
        r4 = (double) r3;
        r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1));
        if (r0 == 0) goto L_0x00df;
    L_0x00bd:
        r0 = new com.squareup.moshi.JsonDataException;
        r1 = new java.lang.StringBuilder;
        r2 = "Expected an int but was ";
        r1.<init>(r2);
        r2 = r7.f30641p;
        r1.append(r2);
        r2 = " at path ";
        r1.append(r2);
        r2 = r7.m25676p();
        r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x00df:
        r0 = 0;
        r7.f30641p = r0;
        r7.f30638m = r2;
        r0 = r7.d;
        r1 = r7.a;
        r1 = r1 + -1;
        r2 = r0[r1];
        r2 = r2 + 1;
        r0[r1] = r2;
        return r3;
    L_0x00f1:
        r0 = new com.squareup.moshi.JsonDataException;
        r1 = new java.lang.StringBuilder;
        r2 = "Expected an int but was ";
        r1.<init>(r2);
        r2 = r7.f30641p;
        r1.append(r2);
        r2 = " at path ";
        r1.append(r2);
        r2 = r7.m25676p();
        r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.moshi.JsonUtf8Reader.m():int");
    }

    public final void close() throws IOException {
        this.f30638m = 0;
        this.b[0] = 8;
        this.a = 1;
        this.f30637l.m36539t();
        this.f30636k.close();
    }

    public final void mo5431n() throws IOException {
        if (this.f) {
            StringBuilder stringBuilder = new StringBuilder("Cannot skip unexpected ");
            stringBuilder.append(mo5423f());
            stringBuilder.append(" at ");
            stringBuilder.append(m25676p());
            throw new JsonDataException(stringBuilder.toString());
        }
        int i = 0;
        do {
            int i2 = this.f30638m;
            if (i2 == 0) {
                i2 = m31599r();
            }
            if (i2 == 3) {
                m25660a(1);
                i++;
            } else if (i2 == 1) {
                m25660a(3);
                i++;
            } else if (i2 == 4) {
                this.a--;
                i--;
            } else if (i2 == 2) {
                this.a--;
                i--;
            } else {
                if (i2 != 14) {
                    if (i2 != 10) {
                        if (i2 != 9) {
                            if (i2 != 13) {
                                if (i2 != 8) {
                                    if (i2 != 12) {
                                        if (i2 == 17) {
                                            this.f30637l.mo6779i((long) this.f30640o);
                                        }
                                    }
                                }
                                m31597b(f30632g);
                            }
                        }
                        m31597b(f30633h);
                    }
                }
                m31603v();
            }
            this.f30638m = 0;
        } while (i != 0);
        int[] iArr = this.d;
        i = this.a - 1;
        iArr[i] = iArr[i] + 1;
        this.c[this.a - 1] = "null";
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int m31594a(boolean r7) throws java.io.IOException {
        /*
        r6 = this;
        r0 = 0;
    L_0x0001:
        r1 = r0;
    L_0x0002:
        r2 = r6.f30636k;
        r3 = r1 + 1;
        r4 = (long) r3;
        r2 = r2.mo6762b(r4);
        if (r2 == 0) goto L_0x00b9;
    L_0x000d:
        r2 = r6.f30637l;
        r4 = (long) r1;
        r1 = r2.m36499c(r4);
        r2 = 10;
        if (r1 == r2) goto L_0x00b6;
    L_0x0018:
        r2 = 32;
        if (r1 == r2) goto L_0x00b6;
    L_0x001c:
        r2 = 13;
        if (r1 == r2) goto L_0x00b6;
    L_0x0020:
        r2 = 9;
        if (r1 == r2) goto L_0x00b6;
    L_0x0024:
        r2 = r6.f30637l;
        r3 = r3 + -1;
        r3 = (long) r3;
        r2.mo6779i(r3);
        r2 = 47;
        if (r1 != r2) goto L_0x00a9;
    L_0x0030:
        r3 = r6.f30636k;
        r4 = 2;
        r3 = r3.mo6762b(r4);
        if (r3 != 0) goto L_0x003b;
    L_0x003a:
        return r1;
    L_0x003b:
        r6.m31604w();
        r3 = r6.f30637l;
        r4 = 1;
        r3 = r3.m36499c(r4);
        r4 = 42;
        if (r3 == r4) goto L_0x005b;
    L_0x004a:
        if (r3 == r2) goto L_0x004d;
    L_0x004c:
        return r1;
    L_0x004d:
        r1 = r6.f30637l;
        r1.mo6773g();
        r1 = r6.f30637l;
        r1.mo6773g();
        r6.m31605x();
        goto L_0x0001;
    L_0x005b:
        r1 = r6.f30637l;
        r1.mo6773g();
        r1 = r6.f30637l;
        r1.mo6773g();
        r1 = "*/";
    L_0x0067:
        r2 = r6.f30636k;
        r3 = r1.length();
        r3 = (long) r3;
        r2 = r2.mo6762b(r3);
        if (r2 == 0) goto L_0x0093;
    L_0x0074:
        r2 = r0;
    L_0x0075:
        r3 = r1.length();
        if (r2 >= r3) goto L_0x0091;
    L_0x007b:
        r3 = r6.f30637l;
        r4 = (long) r2;
        r3 = r3.m36499c(r4);
        r4 = r1.charAt(r2);
        if (r3 == r4) goto L_0x008e;
    L_0x0088:
        r2 = r6.f30637l;
        r2.mo6773g();
        goto L_0x0067;
    L_0x008e:
        r2 = r2 + 1;
        goto L_0x0075;
    L_0x0091:
        r1 = 1;
        goto L_0x0094;
    L_0x0093:
        r1 = r0;
    L_0x0094:
        if (r1 != 0) goto L_0x009d;
    L_0x0096:
        r7 = "Unterminated comment";
        r7 = r6.m25658a(r7);
        throw r7;
    L_0x009d:
        r1 = r6.f30637l;
        r1.mo6773g();
        r1 = r6.f30637l;
        r1.mo6773g();
        goto L_0x0001;
    L_0x00a9:
        r2 = 35;
        if (r1 != r2) goto L_0x00b5;
    L_0x00ad:
        r6.m31604w();
        r6.m31605x();
        goto L_0x0001;
    L_0x00b5:
        return r1;
    L_0x00b6:
        r1 = r3;
        goto L_0x0002;
    L_0x00b9:
        if (r7 == 0) goto L_0x00c3;
    L_0x00bb:
        r7 = new java.io.EOFException;
        r0 = "End of input";
        r7.<init>(r0);
        throw r7;
    L_0x00c3:
        r7 = -1;
        return r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.moshi.JsonUtf8Reader.a(boolean):int");
    }

    private void m31604w() throws IOException {
        if (!this.e) {
            throw m25658a("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private void m31605x() throws IOException {
        long b = this.f30636k.mo6758b(f30635j);
        this.f30637l.mo6779i(b != -1 ? b + 1 : this.f30637l.f36201b);
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("JsonReader(");
        stringBuilder.append(this.f30636k);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    private char m31606y() throws IOException {
        if (this.f30636k.mo6762b(1)) {
            byte g = this.f30637l.mo6773g();
            if (g == (byte) 10 || g == (byte) 34 || g == (byte) 39 || g == (byte) 47 || g == (byte) 92) {
                return (char) g;
            }
            if (g == (byte) 98) {
                return '\b';
            }
            if (g == (byte) 102) {
                return '\f';
            }
            if (g == (byte) 110) {
                return '\n';
            }
            if (g == (byte) 114) {
                return '\r';
            }
            StringBuilder stringBuilder;
            switch (g) {
                case (byte) 116:
                    return '\t';
                case (byte) 117:
                    if (this.f30636k.mo6762b(4)) {
                        int i = 0;
                        char c = '\u0000';
                        while (i < 4) {
                            byte c2 = this.f30637l.m36499c((long) i);
                            c = (char) (c << 4);
                            if (c2 >= (byte) 48 && c2 <= (byte) 57) {
                                c = (char) (c + (c2 - 48));
                            } else if (c2 >= (byte) 97 && c2 <= (byte) 102) {
                                c = (char) (c + ((c2 - 97) + 10));
                            } else if (c2 < (byte) 65 || c2 > (byte) 70) {
                                StringBuilder stringBuilder2 = new StringBuilder("\\u");
                                stringBuilder2.append(this.f30637l.m36510e(4));
                                throw m25658a(stringBuilder2.toString());
                            } else {
                                c = (char) (c + ((c2 - 65) + 10));
                            }
                            i++;
                        }
                        this.f30637l.mo6779i(4);
                        return c;
                    }
                    stringBuilder = new StringBuilder("Unterminated escape sequence at path ");
                    stringBuilder.append(m25676p());
                    throw new EOFException(stringBuilder.toString());
                default:
                    if (this.e) {
                        return (char) g;
                    }
                    stringBuilder = new StringBuilder("Invalid escape sequence: \\");
                    stringBuilder.append((char) g);
                    throw m25658a(stringBuilder.toString());
            }
        }
        throw m25658a("Unterminated escape sequence");
    }

    final void mo5432q() throws IOException {
        if (mo5422e()) {
            this.f30641p = mo5424g();
            this.f30638m = 11;
        }
    }
}
