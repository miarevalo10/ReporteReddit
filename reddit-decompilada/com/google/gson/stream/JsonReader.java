package com.google.gson.stream;

import com.google.gson.JsonPrimitive;
import com.google.gson.internal.JsonReaderInternalAccess;
import com.google.gson.internal.bind.JsonTreeReader;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.Map.Entry;

public class JsonReader implements Closeable {
    private static final char[] f8837c = ")]}'\n".toCharArray();
    public boolean f8838a = false;
    int f8839b = 0;
    private final Reader f8840d;
    private final char[] f8841e = new char[1024];
    private int f8842f = 0;
    private int f8843g = 0;
    private int f8844h = 0;
    private int f8845i = 0;
    private long f8846j;
    private int f8847k;
    private String f8848l;
    private int[] f8849m = new int[32];
    private int f8850n = 0;
    private String[] f8851o;
    private int[] f8852p;

    static class C12521 extends JsonReaderInternalAccess {
        C12521() {
        }

        public final void mo2505a(JsonReader jsonReader) throws IOException {
            if (jsonReader instanceof JsonTreeReader) {
                JsonTreeReader jsonTreeReader = (JsonTreeReader) jsonReader;
                jsonTreeReader.m14989a(JsonToken.NAME);
                Entry entry = (Entry) ((Iterator) jsonTreeReader.mo2476g()).next();
                jsonTreeReader.m14990a(entry.getValue());
                jsonTreeReader.m14990a(new JsonPrimitive((String) entry.getKey()));
                return;
            }
            int i = jsonReader.f8839b;
            if (i == 0) {
                i = jsonReader.m7602q();
            }
            if (i == 13) {
                jsonReader.f8839b = 9;
            } else if (i == 12) {
                jsonReader.f8839b = 8;
            } else if (i == 14) {
                jsonReader.f8839b = 10;
            } else {
                StringBuilder stringBuilder = new StringBuilder("Expected a name but was ");
                stringBuilder.append(jsonReader.mo2475f());
                stringBuilder.append(jsonReader.m7585v());
                throw new IllegalStateException(stringBuilder.toString());
            }
        }
    }

    static {
        JsonReaderInternalAccess.f8749a = new C12521();
    }

    public JsonReader(Reader reader) {
        int[] iArr = this.f8849m;
        int i = this.f8850n;
        this.f8850n = i + 1;
        iArr[i] = 6;
        this.f8851o = new String[32];
        this.f8852p = new int[32];
        if (reader == null) {
            throw new NullPointerException("in == null");
        }
        this.f8840d = reader;
    }

    public void mo2469a() throws IOException {
        int i = this.f8839b;
        if (i == 0) {
            i = m7602q();
        }
        if (i == 3) {
            m7575a(1);
            this.f8852p[this.f8850n - 1] = 0;
            this.f8839b = 0;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder("Expected BEGIN_ARRAY but was ");
        stringBuilder.append(mo2475f());
        stringBuilder.append(m7585v());
        throw new IllegalStateException(stringBuilder.toString());
    }

    public void mo2470b() throws IOException {
        int i = this.f8839b;
        if (i == 0) {
            i = m7602q();
        }
        if (i == 4) {
            this.f8850n--;
            int[] iArr = this.f8852p;
            int i2 = this.f8850n - 1;
            iArr[i2] = iArr[i2] + 1;
            this.f8839b = 0;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder("Expected END_ARRAY but was ");
        stringBuilder.append(mo2475f());
        stringBuilder.append(m7585v());
        throw new IllegalStateException(stringBuilder.toString());
    }

    public void mo2471c() throws IOException {
        int i = this.f8839b;
        if (i == 0) {
            i = m7602q();
        }
        if (i == 1) {
            m7575a(3);
            this.f8839b = 0;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder("Expected BEGIN_OBJECT but was ");
        stringBuilder.append(mo2475f());
        stringBuilder.append(m7585v());
        throw new IllegalStateException(stringBuilder.toString());
    }

    public void mo2473d() throws IOException {
        int i = this.f8839b;
        if (i == 0) {
            i = m7602q();
        }
        if (i == 2) {
            this.f8850n--;
            this.f8851o[this.f8850n] = null;
            int[] iArr = this.f8852p;
            int i2 = this.f8850n - 1;
            iArr[i2] = iArr[i2] + 1;
            this.f8839b = 0;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder("Expected END_OBJECT but was ");
        stringBuilder.append(mo2475f());
        stringBuilder.append(m7585v());
        throw new IllegalStateException(stringBuilder.toString());
    }

    public boolean mo2474e() throws IOException {
        int i = this.f8839b;
        if (i == 0) {
            i = m7602q();
        }
        return (i == 2 || i == 4) ? false : true;
    }

    public JsonToken mo2475f() throws IOException {
        int i = this.f8839b;
        if (i == 0) {
            i = m7602q();
        }
        switch (i) {
            case 1:
                return JsonToken.BEGIN_OBJECT;
            case 2:
                return JsonToken.END_OBJECT;
            case 3:
                return JsonToken.BEGIN_ARRAY;
            case 4:
                return JsonToken.END_ARRAY;
            case 5:
            case 6:
                return JsonToken.BOOLEAN;
            case 7:
                return JsonToken.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return JsonToken.STRING;
            case 12:
            case 13:
            case 14:
                return JsonToken.NAME;
            case 15:
            case 16:
                return JsonToken.NUMBER;
            case 17:
                return JsonToken.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    final int m7602q() throws IOException {
        int a;
        int i = this.f8849m[this.f8850n - 1];
        if (i == 1) {
            this.f8849m[this.f8850n - 1] = 2;
        } else if (i == 2) {
            a = m7572a(true);
            if (a != 44) {
                if (a == 59) {
                    m7583t();
                } else if (a != 93) {
                    throw m7573a("Unterminated array");
                } else {
                    this.f8839b = 4;
                    return 4;
                }
            }
        } else {
            int a2;
            if (i != 3) {
                if (i != 5) {
                    if (i == 4) {
                        this.f8849m[this.f8850n - 1] = 5;
                        a = m7572a(true);
                        if (a != 58) {
                            if (a != 61) {
                                throw m7573a("Expected ':'");
                            }
                            m7583t();
                            if ((this.f8842f < this.f8843g || m7578b(1)) && this.f8841e[this.f8842f] == '>') {
                                this.f8842f++;
                            }
                        }
                    } else {
                        int i2 = 0;
                        if (i == 6) {
                            if (this.f8838a) {
                                m7572a(true);
                                this.f8842f--;
                                if (this.f8842f + f8837c.length <= this.f8843g || m7578b(f8837c.length)) {
                                    while (i2 < f8837c.length) {
                                        if (this.f8841e[this.f8842f + i2] != f8837c[i2]) {
                                            break;
                                        }
                                        i2++;
                                    }
                                    this.f8842f += f8837c.length;
                                }
                            }
                            this.f8849m[this.f8850n - 1] = 7;
                        } else if (i == 7) {
                            if (m7572a(false) == -1) {
                                this.f8839b = 17;
                                return 17;
                            }
                            m7583t();
                            this.f8842f--;
                        } else if (i == 8) {
                            throw new IllegalStateException("JsonReader is closed");
                        }
                    }
                }
            }
            this.f8849m[this.f8850n - 1] = 4;
            if (i == 5) {
                a2 = m7572a(true);
                if (a2 != 44) {
                    if (a2 == 59) {
                        m7583t();
                    } else if (a2 != 125) {
                        throw m7573a("Unterminated object");
                    } else {
                        this.f8839b = 2;
                        return 2;
                    }
                }
            }
            a2 = m7572a(true);
            if (a2 == 34) {
                this.f8839b = 13;
                return 13;
            } else if (a2 == 39) {
                m7583t();
                this.f8839b = 12;
                return 12;
            } else if (a2 != 125) {
                m7583t();
                this.f8842f--;
                if (m7576a((char) a2)) {
                    this.f8839b = 14;
                    return 14;
                }
                throw m7573a("Expected name");
            } else if (i != 5) {
                this.f8839b = 2;
                return 2;
            } else {
                throw m7573a("Expected name");
            }
        }
        a = m7572a(true);
        if (a == 34) {
            this.f8839b = 9;
            return 9;
        } else if (a != 39) {
            if (!(a == 44 || a == 59)) {
                if (a == 91) {
                    this.f8839b = 3;
                    return 3;
                } else if (a != 93) {
                    if (a != 123) {
                        this.f8842f--;
                        i = mo2476g();
                        if (i != 0) {
                            return i;
                        }
                        i = m7581r();
                        if (i != 0) {
                            return i;
                        }
                        if (m7576a(this.f8841e[this.f8842f])) {
                            m7583t();
                            this.f8839b = 10;
                            return 10;
                        }
                        throw m7573a("Expected value");
                    }
                    this.f8839b = 1;
                    return 1;
                } else if (i == 1) {
                    this.f8839b = 4;
                    return 4;
                }
            }
            if (i != 1) {
                if (i != 2) {
                    throw m7573a("Unexpected value");
                }
            }
            m7583t();
            this.f8842f--;
            this.f8839b = 7;
            return 7;
        } else {
            m7583t();
            this.f8839b = 8;
            return 8;
        }
    }

    private int mo2476g() throws IOException {
        String str;
        String str2;
        int i;
        int length;
        int i2;
        char c;
        char c2 = this.f8841e[this.f8842f];
        if (c2 != 't') {
            if (c2 != 'T') {
                if (c2 != 'f') {
                    if (c2 != 'F') {
                        if (c2 != 'n') {
                            if (c2 != 'N') {
                                return 0;
                            }
                        }
                        str = "null";
                        str2 = "NULL";
                        i = 7;
                        length = str.length();
                        i2 = 1;
                        while (i2 < length) {
                            if (this.f8842f + i2 < this.f8843g && !m7578b(i2 + 1)) {
                                return 0;
                            }
                            c = this.f8841e[this.f8842f + i2];
                            if (c != str.charAt(i2) && c != r2.charAt(i2)) {
                                return 0;
                            }
                            i2++;
                        }
                        if ((this.f8842f + length >= this.f8843g || m7578b(length + 1)) && m7576a(this.f8841e[this.f8842f + length])) {
                            return 0;
                        }
                        this.f8842f += length;
                        this.f8839b = i;
                        return i;
                    }
                }
                str = "false";
                str2 = "FALSE";
                i = 6;
                length = str.length();
                i2 = 1;
                while (i2 < length) {
                    if (this.f8842f + i2 < this.f8843g) {
                    }
                    c = this.f8841e[this.f8842f + i2];
                    if (c != str.charAt(i2)) {
                    }
                    i2++;
                }
                if (this.f8842f + length >= this.f8843g) {
                }
                return 0;
            }
        }
        str = "true";
        str2 = "TRUE";
        i = 5;
        length = str.length();
        i2 = 1;
        while (i2 < length) {
            if (this.f8842f + i2 < this.f8843g) {
            }
            c = this.f8841e[this.f8842f + i2];
            if (c != str.charAt(i2)) {
            }
            i2++;
        }
        if (this.f8842f + length >= this.f8843g) {
        }
        return 0;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int m7581r() throws java.io.IOException {
        /*
        r19 = this;
        r0 = r19;
        r1 = r0.f8841e;
        r2 = r0.f8842f;
        r3 = r0.f8843g;
        r6 = 1;
        r7 = 0;
        r8 = r3;
        r10 = r6;
        r3 = r7;
        r9 = r3;
        r13 = r9;
        r11 = 0;
    L_0x0011:
        r14 = r2 + r3;
        r15 = 2;
        if (r14 != r8) goto L_0x0026;
    L_0x0016:
        r2 = r1.length;
        if (r3 != r2) goto L_0x001a;
    L_0x0019:
        return r7;
    L_0x001a:
        r2 = r3 + 1;
        r2 = r0.m7578b(r2);
        if (r2 == 0) goto L_0x0095;
    L_0x0022:
        r2 = r0.f8842f;
        r8 = r0.f8843g;
    L_0x0026:
        r14 = r2 + r3;
        r14 = r1[r14];
        r7 = 43;
        r4 = 3;
        r5 = 5;
        if (r14 == r7) goto L_0x00e3;
    L_0x0030:
        r7 = 69;
        if (r14 == r7) goto L_0x00d7;
    L_0x0034:
        r7 = 101; // 0x65 float:1.42E-43 double:5.0E-322;
        if (r14 == r7) goto L_0x00d7;
    L_0x0038:
        switch(r14) {
            case 45: goto L_0x00ca;
            case 46: goto L_0x00c3;
            default: goto L_0x003b;
        };
    L_0x003b:
        r7 = 48;
        if (r14 < r7) goto L_0x008d;
    L_0x003f:
        r7 = 57;
        if (r14 <= r7) goto L_0x0044;
    L_0x0043:
        goto L_0x008d;
    L_0x0044:
        if (r9 == r6) goto L_0x0082;
    L_0x0046:
        if (r9 != 0) goto L_0x0049;
    L_0x0048:
        goto L_0x0082;
    L_0x0049:
        if (r9 != r15) goto L_0x0071;
    L_0x004b:
        r16 = 0;
        r4 = (r11 > r16 ? 1 : (r11 == r16 ? 0 : -1));
        if (r4 != 0) goto L_0x0053;
    L_0x0051:
        r4 = 0;
        return r4;
    L_0x0053:
        r4 = 10;
        r4 = r4 * r11;
        r14 = r14 + -48;
        r14 = (long) r14;
        r4 = r4 - r14;
        r14 = -922337203685477580; // 0xf333333333333334 float:4.1723254E-8 double:-8.390303882365713E246;
        r7 = (r11 > r14 ? 1 : (r11 == r14 ? 0 : -1));
        if (r7 > 0) goto L_0x006c;
    L_0x0063:
        if (r7 != 0) goto L_0x006a;
    L_0x0065:
        r7 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1));
        if (r7 >= 0) goto L_0x006a;
    L_0x0069:
        goto L_0x006c;
    L_0x006a:
        r7 = 0;
        goto L_0x006d;
    L_0x006c:
        r7 = r6;
    L_0x006d:
        r7 = r7 & r10;
        r11 = r4;
        r10 = r7;
        goto L_0x008a;
    L_0x0071:
        r16 = 0;
        if (r9 != r4) goto L_0x0079;
    L_0x0075:
        r7 = 0;
        r9 = 4;
        goto L_0x00ea;
    L_0x0079:
        if (r9 == r5) goto L_0x007e;
    L_0x007b:
        r4 = 6;
        if (r9 != r4) goto L_0x008a;
    L_0x007e:
        r7 = 0;
        r9 = 7;
        goto L_0x00ea;
    L_0x0082:
        r16 = 0;
        r14 = r14 + -48;
        r4 = -r14;
        r4 = (long) r4;
        r11 = r4;
        r9 = r15;
    L_0x008a:
        r7 = 0;
        goto L_0x00ea;
    L_0x008d:
        r1 = r0.m7576a(r14);
        if (r1 == 0) goto L_0x0095;
    L_0x0093:
        r1 = 0;
        return r1;
    L_0x0095:
        if (r9 != r15) goto L_0x00b1;
    L_0x0097:
        if (r10 == 0) goto L_0x00b1;
    L_0x0099:
        r1 = -9223372036854775808;
        r1 = (r11 > r1 ? 1 : (r11 == r1 ? 0 : -1));
        if (r1 != 0) goto L_0x00a1;
    L_0x009f:
        if (r13 == 0) goto L_0x00b1;
    L_0x00a1:
        if (r13 == 0) goto L_0x00a4;
    L_0x00a3:
        goto L_0x00a5;
    L_0x00a4:
        r11 = -r11;
    L_0x00a5:
        r0.f8846j = r11;
        r1 = r0.f8842f;
        r1 = r1 + r3;
        r0.f8842f = r1;
        r1 = 15;
        r0.f8839b = r1;
        return r1;
    L_0x00b1:
        if (r9 == r15) goto L_0x00bc;
    L_0x00b3:
        r1 = 4;
        if (r9 == r1) goto L_0x00bc;
    L_0x00b6:
        r1 = 7;
        if (r9 != r1) goto L_0x00ba;
    L_0x00b9:
        goto L_0x00bc;
    L_0x00ba:
        r7 = 0;
        return r7;
    L_0x00bc:
        r0.f8847k = r3;
        r1 = 16;
        r0.f8839b = r1;
        return r1;
    L_0x00c3:
        r7 = 0;
        r16 = 0;
        if (r9 != r15) goto L_0x00c9;
    L_0x00c8:
        goto L_0x00e9;
    L_0x00c9:
        return r7;
    L_0x00ca:
        r4 = 6;
        r7 = 0;
        r16 = 0;
        if (r9 != 0) goto L_0x00d3;
    L_0x00d0:
        r9 = r6;
        r13 = r9;
        goto L_0x00ea;
    L_0x00d3:
        if (r9 != r5) goto L_0x00d6;
    L_0x00d5:
        goto L_0x00e9;
    L_0x00d6:
        return r7;
    L_0x00d7:
        r7 = 0;
        r16 = 0;
        if (r9 == r15) goto L_0x00e1;
    L_0x00dc:
        r4 = 4;
        if (r9 != r4) goto L_0x00e0;
    L_0x00df:
        goto L_0x00e1;
    L_0x00e0:
        return r7;
    L_0x00e1:
        r9 = r5;
        goto L_0x00ea;
    L_0x00e3:
        r4 = 6;
        r7 = 0;
        r16 = 0;
        if (r9 != r5) goto L_0x00ee;
    L_0x00e9:
        r9 = r4;
    L_0x00ea:
        r3 = r3 + 1;
        goto L_0x0011;
    L_0x00ee:
        return r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.stream.JsonReader.r():int");
    }

    private boolean m7576a(char c) throws IOException {
        switch (c) {
            case '\t':
            case '\n':
            case '\f':
            case '\r':
            case ' ':
            case ',':
            case ':':
            case '[':
            case ']':
            case '{':
            case '}':
                break;
            case '#':
            case '/':
            case ';':
            case '=':
            case '\\':
                m7583t();
                break;
            default:
                return true;
        }
        return false;
    }

    public String mo2477h() throws IOException {
        String s;
        int i = this.f8839b;
        if (i == 0) {
            i = m7602q();
        }
        if (i == 14) {
            s = m7582s();
        } else if (i == 12) {
            s = m7577b('\'');
        } else if (i == 13) {
            s = m7577b('\"');
        } else {
            StringBuilder stringBuilder = new StringBuilder("Expected a name but was ");
            stringBuilder.append(mo2475f());
            stringBuilder.append(m7585v());
            throw new IllegalStateException(stringBuilder.toString());
        }
        this.f8839b = 0;
        this.f8851o[this.f8850n - 1] = s;
        return s;
    }

    public String mo2478i() throws IOException {
        String s;
        int i = this.f8839b;
        if (i == 0) {
            i = m7602q();
        }
        if (i == 10) {
            s = m7582s();
        } else if (i == 8) {
            s = m7577b('\'');
        } else if (i == 9) {
            s = m7577b('\"');
        } else if (i == 11) {
            s = this.f8848l;
            this.f8848l = null;
        } else if (i == 15) {
            s = Long.toString(this.f8846j);
        } else if (i == 16) {
            s = new String(this.f8841e, this.f8842f, this.f8847k);
            this.f8842f += this.f8847k;
        } else {
            StringBuilder stringBuilder = new StringBuilder("Expected a string but was ");
            stringBuilder.append(mo2475f());
            stringBuilder.append(m7585v());
            throw new IllegalStateException(stringBuilder.toString());
        }
        this.f8839b = 0;
        int[] iArr = this.f8852p;
        int i2 = this.f8850n - 1;
        iArr[i2] = iArr[i2] + 1;
        return s;
    }

    public boolean mo2479j() throws IOException {
        int i = this.f8839b;
        if (i == 0) {
            i = m7602q();
        }
        int[] iArr;
        int i2;
        if (i == 5) {
            this.f8839b = 0;
            iArr = this.f8852p;
            i2 = this.f8850n - 1;
            iArr[i2] = iArr[i2] + 1;
            return true;
        } else if (i == 6) {
            this.f8839b = 0;
            iArr = this.f8852p;
            i2 = this.f8850n - 1;
            iArr[i2] = iArr[i2] + 1;
            return false;
        } else {
            StringBuilder stringBuilder = new StringBuilder("Expected a boolean but was ");
            stringBuilder.append(mo2475f());
            stringBuilder.append(m7585v());
            throw new IllegalStateException(stringBuilder.toString());
        }
    }

    public void mo2480k() throws IOException {
        int i = this.f8839b;
        if (i == 0) {
            i = m7602q();
        }
        if (i == 7) {
            this.f8839b = 0;
            int[] iArr = this.f8852p;
            int i2 = this.f8850n - 1;
            iArr[i2] = iArr[i2] + 1;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder("Expected null but was ");
        stringBuilder.append(mo2475f());
        stringBuilder.append(m7585v());
        throw new IllegalStateException(stringBuilder.toString());
    }

    public double mo2481l() throws IOException {
        int i = this.f8839b;
        if (i == 0) {
            i = m7602q();
        }
        if (i == 15) {
            this.f8839b = 0;
            int[] iArr = this.f8852p;
            int i2 = this.f8850n - 1;
            iArr[i2] = iArr[i2] + 1;
            return (double) this.f8846j;
        }
        if (i == 16) {
            this.f8848l = new String(this.f8841e, this.f8842f, this.f8847k);
            this.f8842f += this.f8847k;
        } else {
            if (i != 8) {
                if (i != 9) {
                    if (i == 10) {
                        this.f8848l = m7582s();
                    } else if (i != 11) {
                        StringBuilder stringBuilder = new StringBuilder("Expected a double but was ");
                        stringBuilder.append(mo2475f());
                        stringBuilder.append(m7585v());
                        throw new IllegalStateException(stringBuilder.toString());
                    }
                }
            }
            this.f8848l = m7577b(i == 8 ? '\'' : '\"');
        }
        this.f8839b = 11;
        double parseDouble = Double.parseDouble(this.f8848l);
        if (this.f8838a || !(Double.isNaN(parseDouble) || Double.isInfinite(parseDouble))) {
            this.f8848l = null;
            this.f8839b = 0;
            int[] iArr2 = this.f8852p;
            int i3 = this.f8850n - 1;
            iArr2[i3] = iArr2[i3] + 1;
            return parseDouble;
        }
        StringBuilder stringBuilder2 = new StringBuilder("JSON forbids NaN and infinities: ");
        stringBuilder2.append(parseDouble);
        stringBuilder2.append(m7585v());
        throw new MalformedJsonException(stringBuilder2.toString());
    }

    public long mo2482m() throws java.io.IOException {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r7 = this;
        r0 = r7.f8839b;
        if (r0 != 0) goto L_0x0008;
    L_0x0004:
        r0 = r7.m7602q();
    L_0x0008:
        r1 = 15;
        r2 = 0;
        if (r0 != r1) goto L_0x001e;
    L_0x000d:
        r7.f8839b = r2;
        r0 = r7.f8852p;
        r1 = r7.f8850n;
        r1 = r1 + -1;
        r2 = r0[r1];
        r2 = r2 + 1;
        r0[r1] = r2;
        r0 = r7.f8846j;
        return r0;
    L_0x001e:
        r1 = 16;
        if (r0 != r1) goto L_0x0037;
    L_0x0022:
        r0 = new java.lang.String;
        r1 = r7.f8841e;
        r3 = r7.f8842f;
        r4 = r7.f8847k;
        r0.<init>(r1, r3, r4);
        r7.f8848l = r0;
        r0 = r7.f8842f;
        r1 = r7.f8847k;
        r0 = r0 + r1;
        r7.f8842f = r0;
        goto L_0x008e;
    L_0x0037:
        r1 = 10;
        r3 = 8;
        if (r0 == r3) goto L_0x0063;
    L_0x003d:
        r4 = 9;
        if (r0 == r4) goto L_0x0063;
    L_0x0041:
        if (r0 != r1) goto L_0x0044;
    L_0x0043:
        goto L_0x0063;
    L_0x0044:
        r0 = new java.lang.IllegalStateException;
        r1 = new java.lang.StringBuilder;
        r2 = "Expected a long but was ";
        r1.<init>(r2);
        r2 = r7.mo2475f();
        r1.append(r2);
        r2 = r7.m7585v();
        r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x0063:
        if (r0 != r1) goto L_0x006c;
    L_0x0065:
        r0 = r7.m7582s();
        r7.f8848l = r0;
        goto L_0x0079;
    L_0x006c:
        if (r0 != r3) goto L_0x0071;
    L_0x006e:
        r0 = 39;
        goto L_0x0073;
    L_0x0071:
        r0 = 34;
    L_0x0073:
        r0 = r7.m7577b(r0);
        r7.f8848l = r0;
    L_0x0079:
        r0 = r7.f8848l;	 Catch:{ NumberFormatException -> 0x008e }
        r0 = java.lang.Long.parseLong(r0);	 Catch:{ NumberFormatException -> 0x008e }
        r7.f8839b = r2;	 Catch:{ NumberFormatException -> 0x008e }
        r3 = r7.f8852p;	 Catch:{ NumberFormatException -> 0x008e }
        r4 = r7.f8850n;	 Catch:{ NumberFormatException -> 0x008e }
        r4 = r4 + -1;	 Catch:{ NumberFormatException -> 0x008e }
        r5 = r3[r4];	 Catch:{ NumberFormatException -> 0x008e }
        r5 = r5 + 1;	 Catch:{ NumberFormatException -> 0x008e }
        r3[r4] = r5;	 Catch:{ NumberFormatException -> 0x008e }
        return r0;
    L_0x008e:
        r0 = 11;
        r7.f8839b = r0;
        r0 = r7.f8848l;
        r0 = java.lang.Double.parseDouble(r0);
        r3 = (long) r0;
        r5 = (double) r3;
        r0 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1));
        if (r0 == 0) goto L_0x00bb;
    L_0x009e:
        r0 = new java.lang.NumberFormatException;
        r1 = new java.lang.StringBuilder;
        r2 = "Expected a long but was ";
        r1.<init>(r2);
        r2 = r7.f8848l;
        r1.append(r2);
        r2 = r7.m7585v();
        r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x00bb:
        r0 = 0;
        r7.f8848l = r0;
        r7.f8839b = r2;
        r0 = r7.f8852p;
        r1 = r7.f8850n;
        r1 = r1 + -1;
        r2 = r0[r1];
        r2 = r2 + 1;
        r0[r1] = r2;
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.stream.JsonReader.m():long");
    }

    private String m7577b(char c) throws IOException {
        char[] cArr = this.f8841e;
        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            int i = this.f8842f;
            int i2 = this.f8843g;
            int i3 = i;
            while (i3 < i2) {
                int i4 = i3 + 1;
                char c2 = cArr[i3];
                if (c2 == c) {
                    this.f8842f = i4;
                    stringBuilder.append(cArr, i, (i4 - i) - 1);
                    return stringBuilder.toString();
                } else if (c2 == '\\') {
                    this.f8842f = i4;
                    stringBuilder.append(cArr, i, (i4 - i) - 1);
                    stringBuilder.append(m7586w());
                    break;
                } else {
                    if (c2 == '\n') {
                        this.f8844h++;
                        this.f8845i = i4;
                    }
                    i3 = i4;
                }
            }
            stringBuilder.append(cArr, i, i3 - i);
            this.f8842f = i3;
            if (!m7578b(1)) {
                throw m7573a("Unterminated string");
            }
        }
    }

    private String m7582s() throws IOException {
        String str;
        int i = 0;
        StringBuilder stringBuilder = null;
        do {
            int i2 = 0;
            while (true) {
                if (this.f8842f + i2 < this.f8843g) {
                    switch (this.f8841e[this.f8842f + i2]) {
                        case '\t':
                        case '\n':
                        case '\f':
                        case '\r':
                        case ' ':
                        case ',':
                        case ':':
                        case '[':
                        case ']':
                        case '{':
                        case '}':
                            break;
                        case '#':
                        case '/':
                        case ';':
                        case '=':
                        case '\\':
                            m7583t();
                            break;
                        default:
                            i2++;
                            break;
                    }
                } else if (i2 >= this.f8841e.length) {
                    if (stringBuilder == null) {
                        stringBuilder = new StringBuilder();
                    }
                    stringBuilder.append(this.f8841e, this.f8842f, i2);
                    this.f8842f += i2;
                } else if (m7578b(i2 + 1)) {
                }
                i = i2;
                if (stringBuilder != null) {
                    str = new String(this.f8841e, this.f8842f, i);
                } else {
                    stringBuilder.append(this.f8841e, this.f8842f, i);
                    str = stringBuilder.toString();
                }
                this.f8842f += i;
                return str;
            }
        } while (m7578b(1));
        if (stringBuilder != null) {
            stringBuilder.append(this.f8841e, this.f8842f, i);
            str = stringBuilder.toString();
        } else {
            str = new String(this.f8841e, this.f8842f, i);
        }
        this.f8842f += i;
        return str;
    }

    private void m7579c(char c) throws IOException {
        char[] cArr = this.f8841e;
        while (true) {
            int i = this.f8842f;
            int i2 = this.f8843g;
            while (i < i2) {
                int i3 = i + 1;
                char c2 = cArr[i];
                if (c2 == c) {
                    this.f8842f = i3;
                    return;
                } else if (c2 == '\\') {
                    this.f8842f = i3;
                    m7586w();
                    break;
                } else {
                    if (c2 == '\n') {
                        this.f8844h++;
                        this.f8845i = i3;
                    }
                    i = i3;
                }
            }
            this.f8842f = i;
            if (!m7578b(1)) {
                throw m7573a("Unterminated string");
            }
        }
    }

    public int mo2483n() throws java.io.IOException {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r7 = this;
        r0 = r7.f8839b;
        if (r0 != 0) goto L_0x0008;
    L_0x0004:
        r0 = r7.m7602q();
    L_0x0008:
        r1 = 15;
        r2 = 0;
        if (r0 != r1) goto L_0x0043;
    L_0x000d:
        r0 = r7.f8846j;
        r0 = (int) r0;
        r3 = r7.f8846j;
        r5 = (long) r0;
        r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1));
        if (r1 == 0) goto L_0x0034;
    L_0x0017:
        r0 = new java.lang.NumberFormatException;
        r1 = new java.lang.StringBuilder;
        r2 = "Expected an int but was ";
        r1.<init>(r2);
        r2 = r7.f8846j;
        r1.append(r2);
        r2 = r7.m7585v();
        r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x0034:
        r7.f8839b = r2;
        r1 = r7.f8852p;
        r2 = r7.f8850n;
        r2 = r2 + -1;
        r3 = r1[r2];
        r3 = r3 + 1;
        r1[r2] = r3;
        return r0;
    L_0x0043:
        r1 = 16;
        if (r0 != r1) goto L_0x005c;
    L_0x0047:
        r0 = new java.lang.String;
        r1 = r7.f8841e;
        r3 = r7.f8842f;
        r4 = r7.f8847k;
        r0.<init>(r1, r3, r4);
        r7.f8848l = r0;
        r0 = r7.f8842f;
        r1 = r7.f8847k;
        r0 = r0 + r1;
        r7.f8842f = r0;
        goto L_0x00b3;
    L_0x005c:
        r1 = 10;
        r3 = 8;
        if (r0 == r3) goto L_0x0088;
    L_0x0062:
        r4 = 9;
        if (r0 == r4) goto L_0x0088;
    L_0x0066:
        if (r0 != r1) goto L_0x0069;
    L_0x0068:
        goto L_0x0088;
    L_0x0069:
        r0 = new java.lang.IllegalStateException;
        r1 = new java.lang.StringBuilder;
        r2 = "Expected an int but was ";
        r1.<init>(r2);
        r2 = r7.mo2475f();
        r1.append(r2);
        r2 = r7.m7585v();
        r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x0088:
        if (r0 != r1) goto L_0x0091;
    L_0x008a:
        r0 = r7.m7582s();
        r7.f8848l = r0;
        goto L_0x009e;
    L_0x0091:
        if (r0 != r3) goto L_0x0096;
    L_0x0093:
        r0 = 39;
        goto L_0x0098;
    L_0x0096:
        r0 = 34;
    L_0x0098:
        r0 = r7.m7577b(r0);
        r7.f8848l = r0;
    L_0x009e:
        r0 = r7.f8848l;	 Catch:{ NumberFormatException -> 0x00b3 }
        r0 = java.lang.Integer.parseInt(r0);	 Catch:{ NumberFormatException -> 0x00b3 }
        r7.f8839b = r2;	 Catch:{ NumberFormatException -> 0x00b3 }
        r1 = r7.f8852p;	 Catch:{ NumberFormatException -> 0x00b3 }
        r3 = r7.f8850n;	 Catch:{ NumberFormatException -> 0x00b3 }
        r3 = r3 + -1;	 Catch:{ NumberFormatException -> 0x00b3 }
        r4 = r1[r3];	 Catch:{ NumberFormatException -> 0x00b3 }
        r4 = r4 + 1;	 Catch:{ NumberFormatException -> 0x00b3 }
        r1[r3] = r4;	 Catch:{ NumberFormatException -> 0x00b3 }
        return r0;
    L_0x00b3:
        r0 = 11;
        r7.f8839b = r0;
        r0 = r7.f8848l;
        r0 = java.lang.Double.parseDouble(r0);
        r3 = (int) r0;
        r4 = (double) r3;
        r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1));
        if (r0 == 0) goto L_0x00e0;
    L_0x00c3:
        r0 = new java.lang.NumberFormatException;
        r1 = new java.lang.StringBuilder;
        r2 = "Expected an int but was ";
        r1.<init>(r2);
        r2 = r7.f8848l;
        r1.append(r2);
        r2 = r7.m7585v();
        r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x00e0:
        r0 = 0;
        r7.f8848l = r0;
        r7.f8839b = r2;
        r0 = r7.f8852p;
        r1 = r7.f8850n;
        r1 = r1 + -1;
        r2 = r0[r1];
        r2 = r2 + 1;
        r0[r1] = r2;
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.stream.JsonReader.n():int");
    }

    public void close() throws IOException {
        this.f8839b = 0;
        this.f8849m[0] = 8;
        this.f8850n = 1;
        this.f8840d.close();
    }

    public void mo2484o() throws IOException {
        int i = 0;
        do {
            int i2 = this.f8839b;
            if (i2 == 0) {
                i2 = m7602q();
            }
            if (i2 == 3) {
                m7575a(1);
                i++;
            } else if (i2 == 1) {
                m7575a(3);
                i++;
            } else if (i2 == 4) {
                this.f8850n--;
                i--;
            } else if (i2 == 2) {
                this.f8850n--;
                i--;
            } else {
                if (i2 != 14) {
                    if (i2 != 10) {
                        if (i2 != 8) {
                            if (i2 != 12) {
                                if (i2 != 9) {
                                    if (i2 != 13) {
                                        if (i2 == 16) {
                                            this.f8842f += this.f8847k;
                                        }
                                    }
                                }
                                m7579c('\"');
                            }
                        }
                        m7579c('\'');
                    }
                }
                do {
                    i2 = 0;
                    while (this.f8842f + i2 < this.f8843g) {
                        switch (this.f8841e[this.f8842f + i2]) {
                            case '\t':
                            case '\n':
                            case '\f':
                            case '\r':
                            case ' ':
                            case ',':
                            case ':':
                            case '[':
                            case ']':
                            case '{':
                            case '}':
                                break;
                            case '#':
                            case '/':
                            case ';':
                            case '=':
                            case '\\':
                                m7583t();
                                break;
                            default:
                                i2++;
                        }
                        this.f8842f += i2;
                    }
                    this.f8842f += i2;
                } while (m7578b(1));
            }
            this.f8839b = 0;
        } while (i != 0);
        int[] iArr = this.f8852p;
        i = this.f8850n - 1;
        iArr[i] = iArr[i] + 1;
        this.f8851o[this.f8850n - 1] = "null";
    }

    private void m7575a(int i) {
        if (this.f8850n == this.f8849m.length) {
            Object obj = new int[(this.f8850n * 2)];
            Object obj2 = new int[(this.f8850n * 2)];
            Object obj3 = new String[(this.f8850n * 2)];
            System.arraycopy(this.f8849m, 0, obj, 0, this.f8850n);
            System.arraycopy(this.f8852p, 0, obj2, 0, this.f8850n);
            System.arraycopy(this.f8851o, 0, obj3, 0, this.f8850n);
            this.f8849m = obj;
            this.f8852p = obj2;
            this.f8851o = obj3;
        }
        int[] iArr = this.f8849m;
        int i2 = this.f8850n;
        this.f8850n = i2 + 1;
        iArr[i2] = i;
    }

    private boolean m7578b(int i) throws IOException {
        Object obj = this.f8841e;
        this.f8845i -= this.f8842f;
        if (this.f8843g != this.f8842f) {
            this.f8843g -= this.f8842f;
            System.arraycopy(obj, this.f8842f, obj, 0, this.f8843g);
        } else {
            this.f8843g = 0;
        }
        this.f8842f = 0;
        do {
            int read = this.f8840d.read(obj, this.f8843g, obj.length - this.f8843g);
            if (read == -1) {
                return false;
            }
            this.f8843g += read;
            if (this.f8844h == 0 && this.f8845i == 0 && this.f8843g > 0 && obj[0] == '﻿') {
                this.f8842f++;
                this.f8845i++;
                i++;
            }
        } while (this.f8843g < i);
        return true;
    }

    private int m7572a(boolean z) throws IOException {
        char[] cArr = this.f8841e;
        int i = this.f8842f;
        int i2 = this.f8843g;
        while (true) {
            int i3 = 1;
            if (i == i2) {
                this.f8842f = i;
                if (!m7578b(1)) {
                    break;
                }
                i = this.f8842f;
                i2 = this.f8843g;
            }
            int i4 = i + 1;
            char c = cArr[i];
            if (c == '\n') {
                this.f8844h++;
                this.f8845i = i4;
            } else if (!(c == ' ' || c == '\r' || c == '\t')) {
                if (c == '/') {
                    this.f8842f = i4;
                    if (i4 == i2) {
                        this.f8842f--;
                        boolean b = m7578b(2);
                        this.f8842f++;
                        if (!b) {
                            return c;
                        }
                    }
                    m7583t();
                    char c2 = cArr[this.f8842f];
                    if (c2 == '*') {
                        this.f8842f++;
                        String str = "*/";
                        while (true) {
                            int i5 = 0;
                            if (this.f8842f + str.length() > this.f8843g) {
                                if (!m7578b(str.length())) {
                                    break;
                                }
                            }
                            if (this.f8841e[this.f8842f] != '\n') {
                                while (i5 < str.length()) {
                                    if (this.f8841e[this.f8842f + i5] == str.charAt(i5)) {
                                        i5++;
                                    }
                                }
                                break;
                            }
                            this.f8844h++;
                            this.f8845i = this.f8842f + 1;
                            this.f8842f++;
                        }
                        i3 = 0;
                        if (i3 == 0) {
                            throw m7573a("Unterminated comment");
                        }
                        i = this.f8842f + 2;
                        i2 = this.f8843g;
                    } else if (c2 != '/') {
                        return c;
                    } else {
                        this.f8842f++;
                        m7584u();
                        i = this.f8842f;
                        i2 = this.f8843g;
                    }
                } else if (c == '#') {
                    this.f8842f = i4;
                    m7583t();
                    m7584u();
                    i = this.f8842f;
                    i2 = this.f8843g;
                } else {
                    this.f8842f = i4;
                    return c;
                }
            }
            i = i4;
        }
        if (!z) {
            return true;
        }
        StringBuilder stringBuilder = new StringBuilder("End of input");
        stringBuilder.append(m7585v());
        throw new EOFException(stringBuilder.toString());
    }

    private void m7583t() throws IOException {
        if (!this.f8838a) {
            throw m7573a("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private void m7584u() throws IOException {
        char c;
        do {
            if (this.f8842f >= this.f8843g && !m7578b(1)) {
                break;
            }
            char[] cArr = this.f8841e;
            int i = this.f8842f;
            this.f8842f = i + 1;
            c = cArr[i];
            if (c == '\n') {
                this.f8844h++;
                this.f8845i = this.f8842f;
                return;
            }
        } while (c != '\r');
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getClass().getSimpleName());
        stringBuilder.append(m7585v());
        return stringBuilder.toString();
    }

    private String m7585v() {
        int i = this.f8844h + 1;
        int i2 = (this.f8842f - this.f8845i) + 1;
        StringBuilder stringBuilder = new StringBuilder(" at line ");
        stringBuilder.append(i);
        stringBuilder.append(" column ");
        stringBuilder.append(i2);
        stringBuilder.append(" path ");
        stringBuilder.append(mo2485p());
        return stringBuilder.toString();
    }

    public String mo2485p() {
        StringBuilder stringBuilder = new StringBuilder("$");
        int i = this.f8850n;
        for (int i2 = 0; i2 < i; i2++) {
            switch (this.f8849m[i2]) {
                case 1:
                case 2:
                    stringBuilder.append('[');
                    stringBuilder.append(this.f8852p[i2]);
                    stringBuilder.append(']');
                    break;
                case 3:
                case 4:
                case 5:
                    stringBuilder.append('.');
                    if (this.f8851o[i2] == null) {
                        break;
                    }
                    stringBuilder.append(this.f8851o[i2]);
                    break;
                default:
                    break;
            }
        }
        return stringBuilder.toString();
    }

    private char m7586w() throws IOException {
        if (this.f8842f != this.f8843g || m7578b(1)) {
            char[] cArr = this.f8841e;
            int i = this.f8842f;
            this.f8842f = i + 1;
            char c = cArr[i];
            if (c == '\n') {
                this.f8844h++;
                this.f8845i = this.f8842f;
            } else if (!(c == '\"' || c == '\'' || c == '/' || c == '\\')) {
                if (c == 'b') {
                    return '\b';
                }
                if (c == 'f') {
                    return '\f';
                }
                if (c == 'n') {
                    return '\n';
                }
                if (c == 'r') {
                    return '\r';
                }
                switch (c) {
                    case 't':
                        return '\t';
                    case 'u':
                        if (this.f8842f + 4 <= this.f8843g || m7578b(4)) {
                            c = '\u0000';
                            int i2 = this.f8842f;
                            int i3 = i2 + 4;
                            while (i2 < i3) {
                                char c2 = this.f8841e[i2];
                                c = (char) (c << 4);
                                if (c2 >= '0' && c2 <= '9') {
                                    c = (char) (c + (c2 - 48));
                                } else if (c2 >= 'a' && c2 <= 'f') {
                                    c = (char) (c + ((c2 - 97) + 10));
                                } else if (c2 < 'A' || c2 > 'F') {
                                    StringBuilder stringBuilder = new StringBuilder("\\u");
                                    stringBuilder.append(new String(this.f8841e, this.f8842f, 4));
                                    throw new NumberFormatException(stringBuilder.toString());
                                } else {
                                    c = (char) (c + ((c2 - 65) + 10));
                                }
                                i2++;
                            }
                            this.f8842f += 4;
                            return c;
                        }
                        throw m7573a("Unterminated escape sequence");
                    default:
                        throw m7573a("Invalid escape sequence");
                }
            }
            return c;
        }
        throw m7573a("Unterminated escape sequence");
    }

    private IOException m7573a(String str) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(m7585v());
        throw new MalformedJsonException(stringBuilder.toString());
    }
}
