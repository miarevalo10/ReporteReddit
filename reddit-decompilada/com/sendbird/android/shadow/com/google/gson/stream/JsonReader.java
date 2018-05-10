package com.sendbird.android.shadow.com.google.gson.stream;

import com.sendbird.android.shadow.com.google.gson.JsonPrimitive;
import com.sendbird.android.shadow.com.google.gson.internal.JsonReaderInternalAccess;
import com.sendbird.android.shadow.com.google.gson.internal.bind.JsonTreeReader;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.Map.Entry;

public class JsonReader implements Closeable {
    private static final char[] f22999c = ")]}'\n".toCharArray();
    public boolean f23000a = false;
    int f23001b = 0;
    private final Reader f23002d;
    private final char[] f23003e = new char[1024];
    private int f23004f = 0;
    private int f23005g = 0;
    private int f23006h = 0;
    private int f23007i = 0;
    private long f23008j;
    private int f23009k;
    private String f23010l;
    private int[] f23011m = new int[32];
    private int f23012n = 0;
    private String[] f23013o;
    private int[] f23014p;

    static class C24601 extends JsonReaderInternalAccess {
        C24601() {
        }

        public final void mo5286a(JsonReader jsonReader) throws IOException {
            if (jsonReader instanceof JsonTreeReader) {
                JsonTreeReader jsonTreeReader = (JsonTreeReader) jsonReader;
                jsonTreeReader.m31186a(JsonToken.NAME);
                Entry entry = (Entry) ((Iterator) jsonTreeReader.mo5259g()).next();
                jsonTreeReader.m31187a(entry.getValue());
                jsonTreeReader.m31187a(new JsonPrimitive((String) entry.getKey()));
                return;
            }
            int i = jsonReader.f23001b;
            if (i == 0) {
                i = jsonReader.m25171q();
            }
            if (i == 13) {
                jsonReader.f23001b = 9;
            } else if (i == 12) {
                jsonReader.f23001b = 8;
            } else if (i == 14) {
                jsonReader.f23001b = 10;
            } else {
                StringBuilder stringBuilder = new StringBuilder("Expected a name but was ");
                stringBuilder.append(jsonReader.mo5258f());
                stringBuilder.append(jsonReader.m25172r());
                throw new IllegalStateException(stringBuilder.toString());
            }
        }
    }

    static {
        JsonReaderInternalAccess.f22910a = new C24601();
    }

    public JsonReader(Reader reader) {
        int[] iArr = this.f23011m;
        int i = this.f23012n;
        this.f23012n = i + 1;
        iArr[i] = 6;
        this.f23013o = new String[32];
        this.f23014p = new int[32];
        if (reader == null) {
            throw new NullPointerException("in == null");
        }
        this.f23002d = reader;
    }

    public void mo5252a() throws IOException {
        int i = this.f23001b;
        if (i == 0) {
            i = m25171q();
        }
        if (i == 3) {
            m25145a(1);
            this.f23014p[this.f23012n - 1] = 0;
            this.f23001b = 0;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder("Expected BEGIN_ARRAY but was ");
        stringBuilder.append(mo5258f());
        stringBuilder.append(m25172r());
        throw new IllegalStateException(stringBuilder.toString());
    }

    public void mo5253b() throws IOException {
        int i = this.f23001b;
        if (i == 0) {
            i = m25171q();
        }
        if (i == 4) {
            this.f23012n--;
            int[] iArr = this.f23014p;
            int i2 = this.f23012n - 1;
            iArr[i2] = iArr[i2] + 1;
            this.f23001b = 0;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder("Expected END_ARRAY but was ");
        stringBuilder.append(mo5258f());
        stringBuilder.append(m25172r());
        throw new IllegalStateException(stringBuilder.toString());
    }

    public void mo5254c() throws IOException {
        int i = this.f23001b;
        if (i == 0) {
            i = m25171q();
        }
        if (i == 1) {
            m25145a(3);
            this.f23001b = 0;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder("Expected BEGIN_OBJECT but was ");
        stringBuilder.append(mo5258f());
        stringBuilder.append(m25172r());
        throw new IllegalStateException(stringBuilder.toString());
    }

    public void mo5256d() throws IOException {
        int i = this.f23001b;
        if (i == 0) {
            i = m25171q();
        }
        if (i == 2) {
            this.f23012n--;
            this.f23013o[this.f23012n] = null;
            int[] iArr = this.f23014p;
            int i2 = this.f23012n - 1;
            iArr[i2] = iArr[i2] + 1;
            this.f23001b = 0;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder("Expected END_OBJECT but was ");
        stringBuilder.append(mo5258f());
        stringBuilder.append(m25172r());
        throw new IllegalStateException(stringBuilder.toString());
    }

    public boolean mo5257e() throws IOException {
        int i = this.f23001b;
        if (i == 0) {
            i = m25171q();
        }
        return (i == 2 || i == 4) ? false : true;
    }

    public JsonToken mo5258f() throws IOException {
        int i = this.f23001b;
        if (i == 0) {
            i = m25171q();
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

    final int m25171q() throws IOException {
        int a;
        int i = this.f23011m[this.f23012n - 1];
        if (i == 1) {
            this.f23011m[this.f23012n - 1] = 2;
        } else if (i == 2) {
            a = m25143a(true);
            if (a != 44) {
                if (a == 59) {
                    m25153u();
                } else if (a != 93) {
                    throw m25144a("Unterminated array");
                } else {
                    this.f23001b = 4;
                    return 4;
                }
            }
        } else {
            int a2;
            if (i != 3) {
                if (i != 5) {
                    if (i == 4) {
                        this.f23011m[this.f23012n - 1] = 5;
                        a = m25143a(true);
                        if (a != 58) {
                            if (a != 61) {
                                throw m25144a("Expected ':'");
                            }
                            m25153u();
                            if ((this.f23004f < this.f23005g || m25148b(1)) && this.f23003e[this.f23004f] == '>') {
                                this.f23004f++;
                            }
                        }
                    } else {
                        int i2 = 0;
                        if (i == 6) {
                            if (this.f23000a) {
                                m25143a(true);
                                this.f23004f--;
                                if (this.f23004f + f22999c.length <= this.f23005g || m25148b(f22999c.length)) {
                                    while (i2 < f22999c.length) {
                                        if (this.f23003e[this.f23004f + i2] != f22999c[i2]) {
                                            break;
                                        }
                                        i2++;
                                    }
                                    this.f23004f += f22999c.length;
                                }
                            }
                            this.f23011m[this.f23012n - 1] = 7;
                        } else if (i == 7) {
                            if (m25143a(false) == -1) {
                                this.f23001b = 17;
                                return 17;
                            }
                            m25153u();
                            this.f23004f--;
                        } else if (i == 8) {
                            throw new IllegalStateException("JsonReader is closed");
                        }
                    }
                }
            }
            this.f23011m[this.f23012n - 1] = 4;
            if (i == 5) {
                a2 = m25143a(true);
                if (a2 != 44) {
                    if (a2 == 59) {
                        m25153u();
                    } else if (a2 != 125) {
                        throw m25144a("Unterminated object");
                    } else {
                        this.f23001b = 2;
                        return 2;
                    }
                }
            }
            a2 = m25143a(true);
            if (a2 == 34) {
                this.f23001b = 13;
                return 13;
            } else if (a2 == 39) {
                m25153u();
                this.f23001b = 12;
                return 12;
            } else if (a2 != 125) {
                m25153u();
                this.f23004f--;
                if (m25146a((char) a2)) {
                    this.f23001b = 14;
                    return 14;
                }
                throw m25144a("Expected name");
            } else if (i != 5) {
                this.f23001b = 2;
                return 2;
            } else {
                throw m25144a("Expected name");
            }
        }
        a = m25143a(true);
        if (a == 34) {
            this.f23001b = 9;
            return 9;
        } else if (a != 39) {
            if (!(a == 44 || a == 59)) {
                if (a == 91) {
                    this.f23001b = 3;
                    return 3;
                } else if (a != 93) {
                    if (a != 123) {
                        this.f23004f--;
                        i = mo5259g();
                        if (i != 0) {
                            return i;
                        }
                        i = m25151s();
                        if (i != 0) {
                            return i;
                        }
                        if (m25146a(this.f23003e[this.f23004f])) {
                            m25153u();
                            this.f23001b = 10;
                            return 10;
                        }
                        throw m25144a("Expected value");
                    }
                    this.f23001b = 1;
                    return 1;
                } else if (i == 1) {
                    this.f23001b = 4;
                    return 4;
                }
            }
            if (i != 1) {
                if (i != 2) {
                    throw m25144a("Unexpected value");
                }
            }
            m25153u();
            this.f23004f--;
            this.f23001b = 7;
            return 7;
        } else {
            m25153u();
            this.f23001b = 8;
            return 8;
        }
    }

    private int mo5259g() throws IOException {
        String str;
        String str2;
        int i;
        int length;
        int i2;
        char c;
        char c2 = this.f23003e[this.f23004f];
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
                            if (this.f23004f + i2 < this.f23005g && !m25148b(i2 + 1)) {
                                return 0;
                            }
                            c = this.f23003e[this.f23004f + i2];
                            if (c != str.charAt(i2) && c != r2.charAt(i2)) {
                                return 0;
                            }
                            i2++;
                        }
                        if ((this.f23004f + length >= this.f23005g || m25148b(length + 1)) && m25146a(this.f23003e[this.f23004f + length])) {
                            return 0;
                        }
                        this.f23004f += length;
                        this.f23001b = i;
                        return i;
                    }
                }
                str = "false";
                str2 = "FALSE";
                i = 6;
                length = str.length();
                i2 = 1;
                while (i2 < length) {
                    if (this.f23004f + i2 < this.f23005g) {
                    }
                    c = this.f23003e[this.f23004f + i2];
                    if (c != str.charAt(i2)) {
                    }
                    i2++;
                }
                if (this.f23004f + length >= this.f23005g) {
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
            if (this.f23004f + i2 < this.f23005g) {
            }
            c = this.f23003e[this.f23004f + i2];
            if (c != str.charAt(i2)) {
            }
            i2++;
        }
        if (this.f23004f + length >= this.f23005g) {
        }
        return 0;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int m25151s() throws java.io.IOException {
        /*
        r19 = this;
        r0 = r19;
        r1 = r0.f23003e;
        r2 = r0.f23004f;
        r3 = r0.f23005g;
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
        r2 = r0.m25148b(r2);
        if (r2 == 0) goto L_0x0091;
    L_0x0022:
        r2 = r0.f23004f;
        r8 = r0.f23005g;
    L_0x0026:
        r14 = r2 + r3;
        r14 = r1[r14];
        r7 = 43;
        r4 = 3;
        r5 = 5;
        if (r14 == r7) goto L_0x00e7;
    L_0x0030:
        r7 = 69;
        if (r14 == r7) goto L_0x00db;
    L_0x0034:
        r7 = 101; // 0x65 float:1.42E-43 double:5.0E-322;
        if (r14 == r7) goto L_0x00db;
    L_0x0038:
        switch(r14) {
            case 45: goto L_0x00ce;
            case 46: goto L_0x00c7;
            default: goto L_0x003b;
        };
    L_0x003b:
        r7 = 48;
        if (r14 < r7) goto L_0x0089;
    L_0x003f:
        r7 = 57;
        if (r14 <= r7) goto L_0x0044;
    L_0x0043:
        goto L_0x0089;
    L_0x0044:
        if (r9 == r6) goto L_0x007e;
    L_0x0046:
        if (r9 != 0) goto L_0x0049;
    L_0x0048:
        goto L_0x007e;
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
        goto L_0x0084;
    L_0x0071:
        if (r9 != r4) goto L_0x0076;
    L_0x0073:
        r7 = 0;
        r9 = 4;
        goto L_0x0085;
    L_0x0076:
        if (r9 == r5) goto L_0x007b;
    L_0x0078:
        r4 = 6;
        if (r9 != r4) goto L_0x0084;
    L_0x007b:
        r7 = 0;
        r9 = 7;
        goto L_0x0085;
    L_0x007e:
        r14 = r14 + -48;
        r4 = -r14;
        r4 = (long) r4;
        r11 = r4;
        r9 = r15;
    L_0x0084:
        r7 = 0;
    L_0x0085:
        r16 = 0;
        goto L_0x00ee;
    L_0x0089:
        r1 = r0.m25146a(r14);
        if (r1 == 0) goto L_0x0091;
    L_0x008f:
        r1 = 0;
        return r1;
    L_0x0091:
        if (r9 != r15) goto L_0x00b5;
    L_0x0093:
        if (r10 == 0) goto L_0x00b5;
    L_0x0095:
        r1 = -9223372036854775808;
        r1 = (r11 > r1 ? 1 : (r11 == r1 ? 0 : -1));
        if (r1 != 0) goto L_0x009d;
    L_0x009b:
        if (r13 == 0) goto L_0x00b5;
    L_0x009d:
        r16 = 0;
        r1 = (r11 > r16 ? 1 : (r11 == r16 ? 0 : -1));
        if (r1 != 0) goto L_0x00a5;
    L_0x00a3:
        if (r13 != 0) goto L_0x00b5;
    L_0x00a5:
        if (r13 == 0) goto L_0x00a8;
    L_0x00a7:
        goto L_0x00a9;
    L_0x00a8:
        r11 = -r11;
    L_0x00a9:
        r0.f23008j = r11;
        r1 = r0.f23004f;
        r1 = r1 + r3;
        r0.f23004f = r1;
        r1 = 15;
        r0.f23001b = r1;
        return r1;
    L_0x00b5:
        if (r9 == r15) goto L_0x00c0;
    L_0x00b7:
        r1 = 4;
        if (r9 == r1) goto L_0x00c0;
    L_0x00ba:
        r1 = 7;
        if (r9 != r1) goto L_0x00be;
    L_0x00bd:
        goto L_0x00c0;
    L_0x00be:
        r7 = 0;
        return r7;
    L_0x00c0:
        r0.f23009k = r3;
        r1 = 16;
        r0.f23001b = r1;
        return r1;
    L_0x00c7:
        r7 = 0;
        r16 = 0;
        if (r9 != r15) goto L_0x00cd;
    L_0x00cc:
        goto L_0x00ed;
    L_0x00cd:
        return r7;
    L_0x00ce:
        r4 = 6;
        r7 = 0;
        r16 = 0;
        if (r9 != 0) goto L_0x00d7;
    L_0x00d4:
        r9 = r6;
        r13 = r9;
        goto L_0x00ee;
    L_0x00d7:
        if (r9 != r5) goto L_0x00da;
    L_0x00d9:
        goto L_0x00ed;
    L_0x00da:
        return r7;
    L_0x00db:
        r7 = 0;
        r16 = 0;
        if (r9 == r15) goto L_0x00e5;
    L_0x00e0:
        r4 = 4;
        if (r9 != r4) goto L_0x00e4;
    L_0x00e3:
        goto L_0x00e5;
    L_0x00e4:
        return r7;
    L_0x00e5:
        r9 = r5;
        goto L_0x00ee;
    L_0x00e7:
        r4 = 6;
        r7 = 0;
        r16 = 0;
        if (r9 != r5) goto L_0x00f2;
    L_0x00ed:
        r9 = r4;
    L_0x00ee:
        r3 = r3 + 1;
        goto L_0x0011;
    L_0x00f2:
        return r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.com.google.gson.stream.JsonReader.s():int");
    }

    private boolean m25146a(char c) throws IOException {
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
                m25153u();
                break;
            default:
                return true;
        }
        return false;
    }

    public String mo5260h() throws IOException {
        String t;
        int i = this.f23001b;
        if (i == 0) {
            i = m25171q();
        }
        if (i == 14) {
            t = m25152t();
        } else if (i == 12) {
            t = m25147b('\'');
        } else if (i == 13) {
            t = m25147b('\"');
        } else {
            StringBuilder stringBuilder = new StringBuilder("Expected a name but was ");
            stringBuilder.append(mo5258f());
            stringBuilder.append(m25172r());
            throw new IllegalStateException(stringBuilder.toString());
        }
        this.f23001b = 0;
        this.f23013o[this.f23012n - 1] = t;
        return t;
    }

    public String mo5261i() throws IOException {
        String t;
        int i = this.f23001b;
        if (i == 0) {
            i = m25171q();
        }
        if (i == 10) {
            t = m25152t();
        } else if (i == 8) {
            t = m25147b('\'');
        } else if (i == 9) {
            t = m25147b('\"');
        } else if (i == 11) {
            t = this.f23010l;
            this.f23010l = null;
        } else if (i == 15) {
            t = Long.toString(this.f23008j);
        } else if (i == 16) {
            t = new String(this.f23003e, this.f23004f, this.f23009k);
            this.f23004f += this.f23009k;
        } else {
            StringBuilder stringBuilder = new StringBuilder("Expected a string but was ");
            stringBuilder.append(mo5258f());
            stringBuilder.append(m25172r());
            throw new IllegalStateException(stringBuilder.toString());
        }
        this.f23001b = 0;
        int[] iArr = this.f23014p;
        int i2 = this.f23012n - 1;
        iArr[i2] = iArr[i2] + 1;
        return t;
    }

    public boolean mo5262j() throws IOException {
        int i = this.f23001b;
        if (i == 0) {
            i = m25171q();
        }
        int[] iArr;
        int i2;
        if (i == 5) {
            this.f23001b = 0;
            iArr = this.f23014p;
            i2 = this.f23012n - 1;
            iArr[i2] = iArr[i2] + 1;
            return true;
        } else if (i == 6) {
            this.f23001b = 0;
            iArr = this.f23014p;
            i2 = this.f23012n - 1;
            iArr[i2] = iArr[i2] + 1;
            return false;
        } else {
            StringBuilder stringBuilder = new StringBuilder("Expected a boolean but was ");
            stringBuilder.append(mo5258f());
            stringBuilder.append(m25172r());
            throw new IllegalStateException(stringBuilder.toString());
        }
    }

    public void mo5263k() throws IOException {
        int i = this.f23001b;
        if (i == 0) {
            i = m25171q();
        }
        if (i == 7) {
            this.f23001b = 0;
            int[] iArr = this.f23014p;
            int i2 = this.f23012n - 1;
            iArr[i2] = iArr[i2] + 1;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder("Expected null but was ");
        stringBuilder.append(mo5258f());
        stringBuilder.append(m25172r());
        throw new IllegalStateException(stringBuilder.toString());
    }

    public double mo5264l() throws IOException {
        int i = this.f23001b;
        if (i == 0) {
            i = m25171q();
        }
        if (i == 15) {
            this.f23001b = 0;
            int[] iArr = this.f23014p;
            int i2 = this.f23012n - 1;
            iArr[i2] = iArr[i2] + 1;
            return (double) this.f23008j;
        }
        if (i == 16) {
            this.f23010l = new String(this.f23003e, this.f23004f, this.f23009k);
            this.f23004f += this.f23009k;
        } else {
            if (i != 8) {
                if (i != 9) {
                    if (i == 10) {
                        this.f23010l = m25152t();
                    } else if (i != 11) {
                        StringBuilder stringBuilder = new StringBuilder("Expected a double but was ");
                        stringBuilder.append(mo5258f());
                        stringBuilder.append(m25172r());
                        throw new IllegalStateException(stringBuilder.toString());
                    }
                }
            }
            this.f23010l = m25147b(i == 8 ? '\'' : '\"');
        }
        this.f23001b = 11;
        double parseDouble = Double.parseDouble(this.f23010l);
        if (this.f23000a || !(Double.isNaN(parseDouble) || Double.isInfinite(parseDouble))) {
            this.f23010l = null;
            this.f23001b = 0;
            int[] iArr2 = this.f23014p;
            int i3 = this.f23012n - 1;
            iArr2[i3] = iArr2[i3] + 1;
            return parseDouble;
        }
        StringBuilder stringBuilder2 = new StringBuilder("JSON forbids NaN and infinities: ");
        stringBuilder2.append(parseDouble);
        stringBuilder2.append(m25172r());
        throw new MalformedJsonException(stringBuilder2.toString());
    }

    public long mo5265m() throws java.io.IOException {
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
        r0 = r7.f23001b;
        if (r0 != 0) goto L_0x0008;
    L_0x0004:
        r0 = r7.m25171q();
    L_0x0008:
        r1 = 15;
        r2 = 0;
        if (r0 != r1) goto L_0x001e;
    L_0x000d:
        r7.f23001b = r2;
        r0 = r7.f23014p;
        r1 = r7.f23012n;
        r1 = r1 + -1;
        r2 = r0[r1];
        r2 = r2 + 1;
        r0[r1] = r2;
        r0 = r7.f23008j;
        return r0;
    L_0x001e:
        r1 = 16;
        if (r0 != r1) goto L_0x0037;
    L_0x0022:
        r0 = new java.lang.String;
        r1 = r7.f23003e;
        r3 = r7.f23004f;
        r4 = r7.f23009k;
        r0.<init>(r1, r3, r4);
        r7.f23010l = r0;
        r0 = r7.f23004f;
        r1 = r7.f23009k;
        r0 = r0 + r1;
        r7.f23004f = r0;
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
        r2 = r7.mo5258f();
        r1.append(r2);
        r2 = r7.m25172r();
        r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x0063:
        if (r0 != r1) goto L_0x006c;
    L_0x0065:
        r0 = r7.m25152t();
        r7.f23010l = r0;
        goto L_0x0079;
    L_0x006c:
        if (r0 != r3) goto L_0x0071;
    L_0x006e:
        r0 = 39;
        goto L_0x0073;
    L_0x0071:
        r0 = 34;
    L_0x0073:
        r0 = r7.m25147b(r0);
        r7.f23010l = r0;
    L_0x0079:
        r0 = r7.f23010l;	 Catch:{ NumberFormatException -> 0x008e }
        r0 = java.lang.Long.parseLong(r0);	 Catch:{ NumberFormatException -> 0x008e }
        r7.f23001b = r2;	 Catch:{ NumberFormatException -> 0x008e }
        r3 = r7.f23014p;	 Catch:{ NumberFormatException -> 0x008e }
        r4 = r7.f23012n;	 Catch:{ NumberFormatException -> 0x008e }
        r4 = r4 + -1;	 Catch:{ NumberFormatException -> 0x008e }
        r5 = r3[r4];	 Catch:{ NumberFormatException -> 0x008e }
        r5 = r5 + 1;	 Catch:{ NumberFormatException -> 0x008e }
        r3[r4] = r5;	 Catch:{ NumberFormatException -> 0x008e }
        return r0;
    L_0x008e:
        r0 = 11;
        r7.f23001b = r0;
        r0 = r7.f23010l;
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
        r2 = r7.f23010l;
        r1.append(r2);
        r2 = r7.m25172r();
        r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x00bb:
        r0 = 0;
        r7.f23010l = r0;
        r7.f23001b = r2;
        r0 = r7.f23014p;
        r1 = r7.f23012n;
        r1 = r1 + -1;
        r2 = r0[r1];
        r2 = r2 + 1;
        r0[r1] = r2;
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.com.google.gson.stream.JsonReader.m():long");
    }

    private String m25147b(char c) throws IOException {
        int i;
        int i2;
        char[] cArr = this.f23003e;
        StringBuilder stringBuilder = null;
        loop0:
        while (true) {
            i = this.f23004f;
            int i3 = this.f23005g;
            int i4 = i;
            while (i4 < i3) {
                i2 = i4 + 1;
                char c2 = cArr[i4];
                if (c2 == c) {
                    break loop0;
                } else if (c2 == '\\') {
                    this.f23004f = i2;
                    i2 = (i2 - i) - 1;
                    if (stringBuilder == null) {
                        stringBuilder = new StringBuilder(Math.max((i2 + 1) * 2, 16));
                    }
                    stringBuilder.append(cArr, i, i2);
                    stringBuilder.append(m25155w());
                } else {
                    if (c2 == '\n') {
                        this.f23006h++;
                        this.f23007i = i2;
                    }
                    i4 = i2;
                }
            }
            if (stringBuilder == null) {
                stringBuilder = new StringBuilder(Math.max((i4 - i) * 2, 16));
            }
            stringBuilder.append(cArr, i, i4 - i);
            this.f23004f = i4;
            if (!m25148b(1)) {
                throw m25144a("Unterminated string");
            }
        }
        this.f23004f = i2;
        i2 = (i2 - i) - 1;
        if (stringBuilder == null) {
            return new String(cArr, i, i2);
        }
        stringBuilder.append(cArr, i, i2);
        return stringBuilder.toString();
    }

    private String m25152t() throws IOException {
        String str;
        int i = 0;
        StringBuilder stringBuilder = null;
        do {
            int i2 = 0;
            while (true) {
                if (this.f23004f + i2 < this.f23005g) {
                    switch (this.f23003e[this.f23004f + i2]) {
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
                            m25153u();
                            break;
                        default:
                            i2++;
                            break;
                    }
                } else if (i2 >= this.f23003e.length) {
                    if (stringBuilder == null) {
                        stringBuilder = new StringBuilder(Math.max(i2, 16));
                    }
                    stringBuilder.append(this.f23003e, this.f23004f, i2);
                    this.f23004f += i2;
                } else if (m25148b(i2 + 1)) {
                }
                i = i2;
                if (stringBuilder != null) {
                    str = new String(this.f23003e, this.f23004f, i);
                } else {
                    stringBuilder.append(this.f23003e, this.f23004f, i);
                    str = stringBuilder.toString();
                }
                this.f23004f += i;
                return str;
            }
        } while (m25148b(1));
        if (stringBuilder != null) {
            stringBuilder.append(this.f23003e, this.f23004f, i);
            str = stringBuilder.toString();
        } else {
            str = new String(this.f23003e, this.f23004f, i);
        }
        this.f23004f += i;
        return str;
    }

    private void m25149c(char c) throws IOException {
        char[] cArr = this.f23003e;
        while (true) {
            int i = this.f23004f;
            int i2 = this.f23005g;
            while (i < i2) {
                int i3 = i + 1;
                char c2 = cArr[i];
                if (c2 == c) {
                    this.f23004f = i3;
                    return;
                } else if (c2 == '\\') {
                    this.f23004f = i3;
                    m25155w();
                    break;
                } else {
                    if (c2 == '\n') {
                        this.f23006h++;
                        this.f23007i = i3;
                    }
                    i = i3;
                }
            }
            this.f23004f = i;
            if (!m25148b(1)) {
                throw m25144a("Unterminated string");
            }
        }
    }

    public int mo5266n() throws java.io.IOException {
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
        r0 = r7.f23001b;
        if (r0 != 0) goto L_0x0008;
    L_0x0004:
        r0 = r7.m25171q();
    L_0x0008:
        r1 = 15;
        r2 = 0;
        if (r0 != r1) goto L_0x0043;
    L_0x000d:
        r0 = r7.f23008j;
        r0 = (int) r0;
        r3 = r7.f23008j;
        r5 = (long) r0;
        r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1));
        if (r1 == 0) goto L_0x0034;
    L_0x0017:
        r0 = new java.lang.NumberFormatException;
        r1 = new java.lang.StringBuilder;
        r2 = "Expected an int but was ";
        r1.<init>(r2);
        r2 = r7.f23008j;
        r1.append(r2);
        r2 = r7.m25172r();
        r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x0034:
        r7.f23001b = r2;
        r1 = r7.f23014p;
        r2 = r7.f23012n;
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
        r1 = r7.f23003e;
        r3 = r7.f23004f;
        r4 = r7.f23009k;
        r0.<init>(r1, r3, r4);
        r7.f23010l = r0;
        r0 = r7.f23004f;
        r1 = r7.f23009k;
        r0 = r0 + r1;
        r7.f23004f = r0;
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
        r2 = r7.mo5258f();
        r1.append(r2);
        r2 = r7.m25172r();
        r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x0088:
        if (r0 != r1) goto L_0x0091;
    L_0x008a:
        r0 = r7.m25152t();
        r7.f23010l = r0;
        goto L_0x009e;
    L_0x0091:
        if (r0 != r3) goto L_0x0096;
    L_0x0093:
        r0 = 39;
        goto L_0x0098;
    L_0x0096:
        r0 = 34;
    L_0x0098:
        r0 = r7.m25147b(r0);
        r7.f23010l = r0;
    L_0x009e:
        r0 = r7.f23010l;	 Catch:{ NumberFormatException -> 0x00b3 }
        r0 = java.lang.Integer.parseInt(r0);	 Catch:{ NumberFormatException -> 0x00b3 }
        r7.f23001b = r2;	 Catch:{ NumberFormatException -> 0x00b3 }
        r1 = r7.f23014p;	 Catch:{ NumberFormatException -> 0x00b3 }
        r3 = r7.f23012n;	 Catch:{ NumberFormatException -> 0x00b3 }
        r3 = r3 + -1;	 Catch:{ NumberFormatException -> 0x00b3 }
        r4 = r1[r3];	 Catch:{ NumberFormatException -> 0x00b3 }
        r4 = r4 + 1;	 Catch:{ NumberFormatException -> 0x00b3 }
        r1[r3] = r4;	 Catch:{ NumberFormatException -> 0x00b3 }
        return r0;
    L_0x00b3:
        r0 = 11;
        r7.f23001b = r0;
        r0 = r7.f23010l;
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
        r2 = r7.f23010l;
        r1.append(r2);
        r2 = r7.m25172r();
        r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x00e0:
        r0 = 0;
        r7.f23010l = r0;
        r7.f23001b = r2;
        r0 = r7.f23014p;
        r1 = r7.f23012n;
        r1 = r1 + -1;
        r2 = r0[r1];
        r2 = r2 + 1;
        r0[r1] = r2;
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.com.google.gson.stream.JsonReader.n():int");
    }

    public void close() throws IOException {
        this.f23001b = 0;
        this.f23011m[0] = 8;
        this.f23012n = 1;
        this.f23002d.close();
    }

    public void mo5267o() throws IOException {
        int i = 0;
        do {
            int i2 = this.f23001b;
            if (i2 == 0) {
                i2 = m25171q();
            }
            if (i2 == 3) {
                m25145a(1);
                i++;
            } else if (i2 == 1) {
                m25145a(3);
                i++;
            } else if (i2 == 4) {
                this.f23012n--;
                i--;
            } else if (i2 == 2) {
                this.f23012n--;
                i--;
            } else {
                if (i2 != 14) {
                    if (i2 != 10) {
                        if (i2 != 8) {
                            if (i2 != 12) {
                                if (i2 != 9) {
                                    if (i2 != 13) {
                                        if (i2 == 16) {
                                            this.f23004f += this.f23009k;
                                        }
                                    }
                                }
                                m25149c('\"');
                            }
                        }
                        m25149c('\'');
                    }
                }
                do {
                    i2 = 0;
                    while (this.f23004f + i2 < this.f23005g) {
                        switch (this.f23003e[this.f23004f + i2]) {
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
                                m25153u();
                                break;
                            default:
                                i2++;
                        }
                        this.f23004f += i2;
                    }
                    this.f23004f += i2;
                } while (m25148b(1));
            }
            this.f23001b = 0;
        } while (i != 0);
        int[] iArr = this.f23014p;
        i = this.f23012n - 1;
        iArr[i] = iArr[i] + 1;
        this.f23013o[this.f23012n - 1] = "null";
    }

    private void m25145a(int i) {
        if (this.f23012n == this.f23011m.length) {
            Object obj = new int[(this.f23012n * 2)];
            Object obj2 = new int[(this.f23012n * 2)];
            Object obj3 = new String[(this.f23012n * 2)];
            System.arraycopy(this.f23011m, 0, obj, 0, this.f23012n);
            System.arraycopy(this.f23014p, 0, obj2, 0, this.f23012n);
            System.arraycopy(this.f23013o, 0, obj3, 0, this.f23012n);
            this.f23011m = obj;
            this.f23014p = obj2;
            this.f23013o = obj3;
        }
        int[] iArr = this.f23011m;
        int i2 = this.f23012n;
        this.f23012n = i2 + 1;
        iArr[i2] = i;
    }

    private boolean m25148b(int i) throws IOException {
        Object obj = this.f23003e;
        this.f23007i -= this.f23004f;
        if (this.f23005g != this.f23004f) {
            this.f23005g -= this.f23004f;
            System.arraycopy(obj, this.f23004f, obj, 0, this.f23005g);
        } else {
            this.f23005g = 0;
        }
        this.f23004f = 0;
        do {
            int read = this.f23002d.read(obj, this.f23005g, obj.length - this.f23005g);
            if (read == -1) {
                return false;
            }
            this.f23005g += read;
            if (this.f23006h == 0 && this.f23007i == 0 && this.f23005g > 0 && obj[0] == '﻿') {
                this.f23004f++;
                this.f23007i++;
                i++;
            }
        } while (this.f23005g < i);
        return true;
    }

    private int m25143a(boolean z) throws IOException {
        char[] cArr = this.f23003e;
        int i = this.f23004f;
        int i2 = this.f23005g;
        while (true) {
            int i3 = 1;
            if (i == i2) {
                this.f23004f = i;
                if (!m25148b(1)) {
                    break;
                }
                i = this.f23004f;
                i2 = this.f23005g;
            }
            int i4 = i + 1;
            char c = cArr[i];
            if (c == '\n') {
                this.f23006h++;
                this.f23007i = i4;
            } else if (!(c == ' ' || c == '\r' || c == '\t')) {
                if (c == '/') {
                    this.f23004f = i4;
                    if (i4 == i2) {
                        this.f23004f--;
                        boolean b = m25148b(2);
                        this.f23004f++;
                        if (!b) {
                            return c;
                        }
                    }
                    m25153u();
                    char c2 = cArr[this.f23004f];
                    if (c2 == '*') {
                        this.f23004f++;
                        String str = "*/";
                        i2 = str.length();
                        while (true) {
                            int i5 = 0;
                            if (this.f23004f + i2 > this.f23005g) {
                                if (!m25148b(i2)) {
                                    break;
                                }
                            }
                            if (this.f23003e[this.f23004f] != '\n') {
                                while (i5 < i2) {
                                    if (this.f23003e[this.f23004f + i5] == str.charAt(i5)) {
                                        i5++;
                                    }
                                }
                                break;
                            }
                            this.f23006h++;
                            this.f23007i = this.f23004f + 1;
                            this.f23004f++;
                        }
                        i3 = 0;
                        if (i3 == 0) {
                            throw m25144a("Unterminated comment");
                        }
                        i = this.f23004f + 2;
                        i2 = this.f23005g;
                    } else if (c2 != '/') {
                        return c;
                    } else {
                        this.f23004f++;
                        m25154v();
                        i = this.f23004f;
                        i2 = this.f23005g;
                    }
                } else if (c == '#') {
                    this.f23004f = i4;
                    m25153u();
                    m25154v();
                    i = this.f23004f;
                    i2 = this.f23005g;
                } else {
                    this.f23004f = i4;
                    return c;
                }
            }
            i = i4;
        }
        if (!z) {
            return true;
        }
        StringBuilder stringBuilder = new StringBuilder("End of input");
        stringBuilder.append(m25172r());
        throw new EOFException(stringBuilder.toString());
    }

    private void m25153u() throws IOException {
        if (!this.f23000a) {
            throw m25144a("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private void m25154v() throws IOException {
        char c;
        do {
            if (this.f23004f >= this.f23005g && !m25148b(1)) {
                break;
            }
            char[] cArr = this.f23003e;
            int i = this.f23004f;
            this.f23004f = i + 1;
            c = cArr[i];
            if (c == '\n') {
                this.f23006h++;
                this.f23007i = this.f23004f;
                return;
            }
        } while (c != '\r');
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getClass().getSimpleName());
        stringBuilder.append(m25172r());
        return stringBuilder.toString();
    }

    final String m25172r() {
        int i = this.f23006h + 1;
        int i2 = (this.f23004f - this.f23007i) + 1;
        StringBuilder stringBuilder = new StringBuilder(" at line ");
        stringBuilder.append(i);
        stringBuilder.append(" column ");
        stringBuilder.append(i2);
        stringBuilder.append(" path ");
        stringBuilder.append(mo5268p());
        return stringBuilder.toString();
    }

    public String mo5268p() {
        StringBuilder stringBuilder = new StringBuilder("$");
        int i = this.f23012n;
        for (int i2 = 0; i2 < i; i2++) {
            switch (this.f23011m[i2]) {
                case 1:
                case 2:
                    stringBuilder.append('[');
                    stringBuilder.append(this.f23014p[i2]);
                    stringBuilder.append(']');
                    break;
                case 3:
                case 4:
                case 5:
                    stringBuilder.append('.');
                    if (this.f23013o[i2] == null) {
                        break;
                    }
                    stringBuilder.append(this.f23013o[i2]);
                    break;
                default:
                    break;
            }
        }
        return stringBuilder.toString();
    }

    private char m25155w() throws IOException {
        if (this.f23004f != this.f23005g || m25148b(1)) {
            char[] cArr = this.f23003e;
            int i = this.f23004f;
            this.f23004f = i + 1;
            char c = cArr[i];
            if (c == '\n') {
                this.f23006h++;
                this.f23007i = this.f23004f;
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
                        if (this.f23004f + 4 <= this.f23005g || m25148b(4)) {
                            c = '\u0000';
                            int i2 = this.f23004f;
                            int i3 = i2 + 4;
                            while (i2 < i3) {
                                char c2 = this.f23003e[i2];
                                c = (char) (c << 4);
                                if (c2 >= '0' && c2 <= '9') {
                                    c = (char) (c + (c2 - 48));
                                } else if (c2 >= 'a' && c2 <= 'f') {
                                    c = (char) (c + ((c2 - 97) + 10));
                                } else if (c2 < 'A' || c2 > 'F') {
                                    StringBuilder stringBuilder = new StringBuilder("\\u");
                                    stringBuilder.append(new String(this.f23003e, this.f23004f, 4));
                                    throw new NumberFormatException(stringBuilder.toString());
                                } else {
                                    c = (char) (c + ((c2 - 65) + 10));
                                }
                                i2++;
                            }
                            this.f23004f += 4;
                            return c;
                        }
                        throw m25144a("Unterminated escape sequence");
                    default:
                        throw m25144a("Invalid escape sequence");
                }
            }
            return c;
        }
        throw m25144a("Unterminated escape sequence");
    }

    private IOException m25144a(String str) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(m25172r());
        throw new MalformedJsonException(stringBuilder.toString());
    }
}
