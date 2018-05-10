package org.ccil.cowan.tagsoup;

import com.facebook.stetho.server.http.HttpStatus;
import java.io.IOException;
import java.io.PushbackReader;
import java.lang.reflect.Array;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

public class HTMLScanner implements Scanner, Locator {
    static short[][] f33213f;
    static int f33214g;
    private static int[] f33215h = new int[]{1, 47, 5, 22, 1, 61, 4, 3, 1, 62, 6, 28, 1, 0, 27, 1, 1, -1, 6, 21, 1, 32, 4, 24, 1, 10, 4, 24, 1, 9, 4, 24, 2, 39, 7, 34, 2, 0, 27, 2, 2, -1, 8, 21, 2, 32, 29, 2, 2, 10, 29, 2, 2, 9, 29, 2, 3, 34, 28, 31, 3, 39, 28, 2, 3, 62, 8, 28, 3, 0, 27, 32, 3, -1, 8, 21, 3, 32, 28, 3, 3, 10, 28, 3, 3, 9, 28, 3, 4, 67, 28, 5, 4, 0, 28, 19, 4, -1, 28, 21, 5, 68, 28, 6, 5, 0, 28, 19, 5, -1, 28, 21, 6, 65, 28, 7, 6, 0, 28, 19, 6, -1, 28, 21, 7, 84, 28, 8, 7, 0, 28, 19, 7, -1, 28, 21, 8, 65, 28, 9, 8, 0, 28, 19, 8, -1, 28, 21, 9, 91, 28, 12, 9, 0, 28, 19, 9, -1, 28, 21, 10, 60, 27, 11, 10, 0, 27, 10, 10, -1, 23, 21, 11, 47, 32, 25, 11, 0, 27, 10, 11, -1, 32, 21, 12, 93, 27, 13, 12, 0, 27, 12, 12, -1, 28, 21, 13, 93, 27, 14, 13, 0, 27, 12, 13, -1, 28, 21, 14, 62, 9, 28, 14, 93, 27, 14, 14, 0, 27, 12, 14, -1, 28, 21, 15, 45, 28, 16, 15, 0, 27, 16, 15, -1, 10, 21, 16, 45, 28, 17, 16, 0, 27, 16, 16, -1, 10, 21, 17, 45, 28, 18, 17, 0, 20, 16, 17, -1, 10, 21, 18, 45, 22, 18, 18, 62, 10, 28, 18, 0, 21, 16, 18, -1, 10, 21, 19, 45, 28, 15, 19, 62, 28, 28, 19, 91, 28, 4, 19, 0, 27, 20, 19, -1, 28, 21, 20, 62, 11, 28, 20, 0, 27, 20, 20, -1, 28, 21, 22, 62, 12, 28, 22, 0, 27, 1, 22, 32, 28, 34, 22, 10, 28, 34, 22, 9, 28, 34, 23, 0, 13, 23, 23, -1, 13, 21, 24, 61, 28, 3, 24, 62, 3, 28, 24, 0, 2, 1, 24, -1, 3, 21, 24, 32, 28, 24, 24, 10, 28, 24, 24, 9, 28, 24, 25, 62, 15, 28, 25, 0, 27, 25, 25, -1, 15, 21, 25, 32, 28, 25, 25, 10, 28, 25, 25, 9, 28, 25, 26, 47, 28, 22, 26, 62, 17, 28, 26, 0, 27, 26, 26, -1, 28, 21, 26, 32, 16, 34, 26, 10, 16, 34, 26, 9, 16, 34, 27, 0, 13, 27, 27, -1, 13, 21, 28, 38, 14, 23, 28, 60, 23, 33, 28, 0, 27, 28, 28, -1, 23, 21, 29, 62, 24, 28, 29, 0, 27, 29, 29, -1, 24, 21, 30, 62, 26, 28, 30, 0, 27, 30, 30, -1, 26, 21, 30, 32, 25, 29, 30, 10, 25, 29, 30, 9, 25, 29, 31, 34, 7, 34, 31, 0, 27, 31, 31, -1, 8, 21, 31, 32, 29, 31, 31, 10, 29, 31, 31, 9, 29, 31, 32, 62, 8, 28, 32, 0, 27, 32, 32, -1, 8, 21, 32, 32, 7, 34, 32, 10, 7, 34, 32, 9, 7, 34, 33, 33, 28, 19, 33, 47, 28, 25, 33, 60, 27, 33, 33, 63, 28, 30, 33, 0, 27, 26, 33, -1, 19, 21, 33, 32, 18, 28, 33, 10, 18, 28, 33, 9, 18, 28, 34, 47, 28, 22, 34, 62, 30, 28, 34, 0, 27, 1, 34, -1, 30, 21, 34, 32, 28, 34, 34, 10, 28, 34, 34, 9, 28, 34, 35, 0, 13, 35, 35, -1, 13, 21};
    private static final String[] f33216i = new String[]{"", "A_ADUP", "A_ADUP_SAVE", "A_ADUP_STAGC", "A_ANAME", "A_ANAME_ADUP", "A_ANAME_ADUP_STAGC", "A_AVAL", "A_AVAL_STAGC", "A_CDATA", "A_CMNT", "A_DECL", "A_EMPTYTAG", "A_ENTITY", "A_ENTITY_START", "A_ETAG", "A_GI", "A_GI_STAGC", "A_LT", "A_LT_PCDATA", "A_MINUS", "A_MINUS2", "A_MINUS3", "A_PCDATA", "A_PI", "A_PITARGET", "A_PITARGET_PI", "A_SAVE", "A_SKIP", "A_SP", "A_STAGC", "A_UNGET", "A_UNSAVE_PCDATA"};
    private static final String[] f33217j = new String[]{"", "S_ANAME", "S_APOS", "S_AVAL", "S_BB", "S_BBC", "S_BBCD", "S_BBCDA", "S_BBCDAT", "S_BBCDATA", "S_CDATA", "S_CDATA2", "S_CDSECT", "S_CDSECT1", "S_CDSECT2", "S_COM", "S_COM2", "S_COM3", "S_COM4", "S_DECL", "S_DECL2", "S_DONE", "S_EMPTYTAG", "S_ENT", "S_EQ", "S_ETAG", "S_GI", "S_NCR", "S_PCDATA", "S_PI", "S_PITARGET", "S_QUOT", "S_STAGC", "S_TAG", "S_TAGWS", "S_XNCR"};
    int f33218a;
    int f33219b;
    char[] f33220c = new char[HttpStatus.HTTP_OK];
    int f33221d;
    int[] f33222e = new int[]{8364, 65533, 8218, 402, 8222, 8230, 8224, 8225, 710, 8240, 352, 8249, 338, 65533, 381, 65533, 65533, 8216, 8217, 8220, 8221, 8226, 8211, 8212, 732, 8482, 353, 8250, 339, 65533, 382, 376};
    private String f33223k;
    private String f33224l;
    private int f33225m;
    private int f33226n;
    private int f33227o;
    private int f33228p;

    static {
        int i;
        int i2 = -1;
        int i3 = i2;
        for (i = 0; i < f33215h.length; i += 4) {
            if (f33215h[i] > i2) {
                i2 = f33215h[i];
            }
            int i4 = i + 1;
            if (f33215h[i4] > i3) {
                i3 = f33215h[i4];
            }
        }
        f33214g = i3 + 1;
        f33213f = (short[][]) Array.newInstance(short.class, new int[]{i2 + 1, i3 + 3});
        for (i = 0; i <= i2; i++) {
            for (int i5 = -2; i5 <= i3; i5++) {
                int i6 = -1;
                i4 = 0;
                int i7 = i4;
                while (i4 < f33215h.length) {
                    if (i == f33215h[i4]) {
                        int i8 = i4 + 1;
                        if (f33215h[i8] == 0) {
                            i7 = f33215h[i4 + 2];
                            i6 = i4;
                        } else if (f33215h[i8] == i5) {
                            break;
                        }
                    } else if (i7 != 0) {
                        break;
                    }
                    i4 += 4;
                }
                i4 = i6;
                f33213f[i][i5 + 2] = (short) i4;
            }
        }
    }

    private static void m33818a(PushbackReader pushbackReader, int i) throws IOException {
        if (i != -1) {
            pushbackReader.unread(i);
        }
    }

    public int getLineNumber() {
        return this.f33225m;
    }

    public int getColumnNumber() {
        return this.f33226n;
    }

    public String getPublicId() {
        return this.f33223k;
    }

    public String getSystemId() {
        return this.f33224l;
    }

    public final void mo6174a(String str, String str2) {
        this.f33223k = str;
        this.f33224l = str2;
        this.f33228p = 0;
        this.f33227o = 0;
        this.f33226n = 0;
        this.f33225m = 0;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo6173a(java.io.Reader r14, org.ccil.cowan.tagsoup.ScanHandler r15) throws java.io.IOException, org.xml.sax.SAXException {
        /*
        r13 = this;
        r0 = 28;
        r13.f33218a = r0;
        r1 = r14 instanceof java.io.BufferedReader;
        r2 = 5;
        if (r1 == 0) goto L_0x000f;
    L_0x0009:
        r1 = new java.io.PushbackReader;
        r1.<init>(r14, r2);
        goto L_0x0019;
    L_0x000f:
        r1 = new java.io.PushbackReader;
        r3 = new java.io.BufferedReader;
        r3.<init>(r14);
        r1.<init>(r3, r2);
    L_0x0019:
        r14 = r1.read();
        r2 = 65279; // 0xfeff float:9.1475E-41 double:3.2252E-319;
        if (r14 == r2) goto L_0x0025;
    L_0x0022:
        m33818a(r1, r14);
    L_0x0025:
        r14 = r13.f33218a;
        r2 = 21;
        if (r14 == r2) goto L_0x0308;
    L_0x002b:
        r14 = r1.read();
        r2 = 159; // 0x9f float:2.23E-43 double:7.86E-322;
        r3 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
        if (r14 < r3) goto L_0x003d;
    L_0x0035:
        if (r14 > r2) goto L_0x003d;
    L_0x0037:
        r4 = r13.f33222e;
        r14 = r14 + -128;
        r14 = r4[r14];
    L_0x003d:
        r4 = 13;
        r5 = 10;
        if (r14 != r4) goto L_0x004d;
    L_0x0043:
        r14 = r1.read();
        if (r14 == r5) goto L_0x004d;
    L_0x0049:
        m33818a(r1, r14);
        r14 = r5;
    L_0x004d:
        r4 = 1;
        r6 = 0;
        if (r14 != r5) goto L_0x0059;
    L_0x0051:
        r7 = r13.f33227o;
        r7 = r7 + r4;
        r13.f33227o = r7;
        r13.f33228p = r6;
        goto L_0x005e;
    L_0x0059:
        r7 = r13.f33228p;
        r7 = r7 + r4;
        r13.f33228p = r7;
    L_0x005e:
        r7 = -1;
        r8 = 32;
        if (r14 >= r8) goto L_0x006b;
    L_0x0063:
        if (r14 == r5) goto L_0x006b;
    L_0x0065:
        r5 = 9;
        if (r14 == r5) goto L_0x006b;
    L_0x0069:
        if (r14 != r7) goto L_0x0025;
    L_0x006b:
        if (r14 < r7) goto L_0x0073;
    L_0x006d:
        r5 = f33214g;
        if (r14 >= r5) goto L_0x0073;
    L_0x0071:
        r5 = r14;
        goto L_0x0074;
    L_0x0073:
        r5 = -2;
    L_0x0074:
        r9 = f33213f;
        r10 = r13.f33218a;
        r9 = r9[r10];
        r5 = r5 + 2;
        r5 = r9[r5];
        if (r5 == r7) goto L_0x008f;
    L_0x0080:
        r9 = f33215h;
        r10 = r5 + 2;
        r9 = r9[r10];
        r10 = f33215h;
        r5 = r5 + 3;
        r5 = r10[r5];
        r13.f33219b = r5;
        goto L_0x0090;
    L_0x008f:
        r9 = r6;
    L_0x0090:
        r5 = 60;
        r10 = 45;
        switch(r9) {
            case 0: goto L_0x02e2;
            case 1: goto L_0x02d7;
            case 2: goto L_0x02ce;
            case 3: goto L_0x02c1;
            case 4: goto L_0x02b7;
            case 5: goto L_0x02aa;
            case 6: goto L_0x0296;
            case 7: goto L_0x028c;
            case 8: goto L_0x027b;
            case 9: goto L_0x0264;
            case 10: goto L_0x0256;
            case 11: goto L_0x024b;
            case 12: goto L_0x0232;
            case 13: goto L_0x017f;
            case 14: goto L_0x0171;
            case 15: goto L_0x0166;
            case 16: goto L_0x015b;
            case 17: goto L_0x0149;
            case 18: goto L_0x013e;
            case 19: goto L_0x012d;
            case 20: goto L_0x0125;
            case 21: goto L_0x011f;
            case 22: goto L_0x0117;
            case 23: goto L_0x0109;
            case 24: goto L_0x00fb;
            case 25: goto L_0x00f0;
            case 26: goto L_0x00de;
            case 27: goto L_0x00d9;
            case 28: goto L_0x02dc;
            case 29: goto L_0x00d4;
            case 30: goto L_0x00c9;
            case 31: goto L_0x00bf;
            case 32: goto L_0x00ab;
            default: goto L_0x0097;
        };
    L_0x0097:
        r14 = new java.lang.Error;
        r15 = new java.lang.StringBuffer;
        r0 = "Can't process state ";
        r15.<init>(r0);
        r15.append(r9);
        r15 = r15.toString();
        r14.<init>(r15);
        throw r14;
    L_0x00ab:
        r14 = r13.f33221d;
        if (r14 <= 0) goto L_0x00b4;
    L_0x00af:
        r14 = r13.f33221d;
        r14 = r14 - r4;
        r13.f33221d = r14;
    L_0x00b4:
        r14 = r13.f33220c;
        r2 = r13.f33221d;
        r15.mo6185g(r14, r2);
        r13.f33221d = r6;
        goto L_0x02dc;
    L_0x00bf:
        m33818a(r1, r14);
        r14 = r13.f33228p;
        r14 = r14 - r4;
        r13.f33228p = r14;
        goto L_0x02dc;
    L_0x00c9:
        r14 = r13.f33220c;
        r2 = r13.f33221d;
        r15.mo6188j(r14, r2);
        r13.f33221d = r6;
        goto L_0x02dc;
    L_0x00d4:
        r13.m33817a(r8, r15);
        goto L_0x02dc;
    L_0x00d9:
        r13.m33817a(r14, r15);
        goto L_0x02dc;
    L_0x00de:
        r14 = r13.f33220c;
        r2 = r13.f33221d;
        r15.mo6186h(r14, r2);
        r13.f33221d = r6;
        r14 = r13.f33220c;
        r2 = r13.f33221d;
        r15.mo6187i(r14, r2);
        goto L_0x02dc;
    L_0x00f0:
        r14 = r13.f33220c;
        r2 = r13.f33221d;
        r15.mo6186h(r14, r2);
        r13.f33221d = r6;
        goto L_0x02dc;
    L_0x00fb:
        r13.m33819b();
        r14 = r13.f33220c;
        r2 = r13.f33221d;
        r15.mo6187i(r14, r2);
        r13.f33221d = r6;
        goto L_0x02dc;
    L_0x0109:
        r13.m33819b();
        r14 = r13.f33220c;
        r2 = r13.f33221d;
        r15.mo6185g(r14, r2);
        r13.f33221d = r6;
        goto L_0x02dc;
    L_0x0117:
        r13.m33817a(r10, r15);
        r13.m33817a(r8, r15);
        goto L_0x02dc;
    L_0x011f:
        r13.m33817a(r10, r15);
        r13.m33817a(r8, r15);
    L_0x0125:
        r13.m33817a(r10, r15);
        r13.m33817a(r14, r15);
        goto L_0x02dc;
    L_0x012d:
        r13.m33819b();
        r13.m33817a(r5, r15);
        r14 = r13.f33220c;
        r2 = r13.f33221d;
        r15.mo6185g(r14, r2);
        r13.f33221d = r6;
        goto L_0x02dc;
    L_0x013e:
        r13.m33819b();
        r13.m33817a(r5, r15);
        r13.m33817a(r14, r15);
        goto L_0x02dc;
    L_0x0149:
        r14 = r13.f33220c;
        r2 = r13.f33221d;
        r15.mo6184f(r14, r2);
        r13.f33221d = r6;
        r14 = r13.f33220c;
        r2 = r13.f33221d;
        r15.mo6188j(r14, r2);
        goto L_0x02dc;
    L_0x015b:
        r14 = r13.f33220c;
        r2 = r13.f33221d;
        r15.mo6184f(r14, r2);
        r13.f33221d = r6;
        goto L_0x02dc;
    L_0x0166:
        r14 = r13.f33220c;
        r2 = r13.f33221d;
        r15.mo6182d(r14, r2);
        r13.f33221d = r6;
        goto L_0x02dc;
    L_0x0171:
        r2 = r13.f33220c;
        r3 = r13.f33221d;
        r15.mo6185g(r2, r3);
        r13.f33221d = r6;
        r13.m33817a(r14, r15);
        goto L_0x02dc;
    L_0x017f:
        r13.m33819b();
        r5 = (char) r14;
        r9 = r13.f33218a;
        r10 = 23;
        r11 = 27;
        r12 = 35;
        if (r9 != r10) goto L_0x0196;
    L_0x018d:
        if (r5 != r12) goto L_0x0196;
    L_0x018f:
        r13.f33219b = r11;
        r13.m33817a(r14, r15);
        goto L_0x02dc;
    L_0x0196:
        r9 = r13.f33218a;
        if (r9 != r11) goto L_0x01a9;
    L_0x019a:
        r9 = 120; // 0x78 float:1.68E-43 double:5.93E-322;
        if (r5 == r9) goto L_0x01a2;
    L_0x019e:
        r9 = 88;
        if (r5 != r9) goto L_0x01a9;
    L_0x01a2:
        r13.f33219b = r12;
        r13.m33817a(r14, r15);
        goto L_0x02dc;
    L_0x01a9:
        r9 = r13.f33218a;
        if (r9 != r10) goto L_0x01b8;
    L_0x01ad:
        r9 = java.lang.Character.isLetterOrDigit(r5);
        if (r9 == 0) goto L_0x01b8;
    L_0x01b3:
        r13.m33817a(r14, r15);
        goto L_0x02dc;
    L_0x01b8:
        r9 = r13.f33218a;
        if (r9 != r11) goto L_0x01c7;
    L_0x01bc:
        r9 = java.lang.Character.isDigit(r5);
        if (r9 == 0) goto L_0x01c7;
    L_0x01c2:
        r13.m33817a(r14, r15);
        goto L_0x02dc;
    L_0x01c7:
        r9 = r13.f33218a;
        if (r9 != r12) goto L_0x01de;
    L_0x01cb:
        r9 = java.lang.Character.isDigit(r5);
        if (r9 != 0) goto L_0x01d9;
    L_0x01d1:
        r9 = "abcdefABCDEF";
        r5 = r9.indexOf(r5);
        if (r5 == r7) goto L_0x01de;
    L_0x01d9:
        r13.m33817a(r14, r15);
        goto L_0x02dc;
    L_0x01de:
        r5 = r13.f33220c;
        r7 = r13.f33221d;
        r7 = r7 - r4;
        r15.mo6181c(r5, r7);
        r5 = r15.mo6180c();
        if (r5 == 0) goto L_0x0226;
    L_0x01ec:
        r13.f33221d = r6;
        if (r5 < r3) goto L_0x01f8;
    L_0x01f0:
        if (r5 > r2) goto L_0x01f8;
    L_0x01f2:
        r2 = r13.f33222e;
        r5 = r5 + -128;
        r5 = r2[r5];
    L_0x01f8:
        if (r5 < r8) goto L_0x0222;
    L_0x01fa:
        r2 = 55296; // 0xd800 float:7.7486E-41 double:2.732E-319;
        if (r5 < r2) goto L_0x0204;
    L_0x01ff:
        r2 = 57343; // 0xdfff float:8.0355E-41 double:2.8331E-319;
        if (r5 <= r2) goto L_0x0222;
    L_0x0204:
        r2 = 65535; // 0xffff float:9.1834E-41 double:3.23786E-319;
        if (r5 > r2) goto L_0x020d;
    L_0x0209:
        r13.m33817a(r5, r15);
        goto L_0x0222;
    L_0x020d:
        r2 = 65536; // 0x10000 float:9.18355E-41 double:3.2379E-319;
        r5 = r5 - r2;
        r2 = r5 >> 10;
        r3 = 55296; // 0xd800 float:7.7486E-41 double:2.732E-319;
        r2 = r2 + r3;
        r13.m33817a(r2, r15);
        r2 = r5 & 1023;
        r3 = 56320; // 0xdc00 float:7.8921E-41 double:2.7826E-319;
        r2 = r2 + r3;
        r13.m33817a(r2, r15);
    L_0x0222:
        r2 = 59;
        if (r14 == r2) goto L_0x022e;
    L_0x0226:
        m33818a(r1, r14);
        r14 = r13.f33228p;
        r14 = r14 - r4;
        r13.f33228p = r14;
    L_0x022e:
        r13.f33219b = r0;
        goto L_0x02dc;
    L_0x0232:
        r13.m33819b();
        r14 = r13.f33221d;
        if (r14 <= 0) goto L_0x0240;
    L_0x0239:
        r14 = r13.f33220c;
        r2 = r13.f33221d;
        r15.mo6184f(r14, r2);
    L_0x0240:
        r13.f33221d = r6;
        r14 = r13.f33220c;
        r2 = r13.f33221d;
        r15.mo6189k(r14, r2);
        goto L_0x02dc;
    L_0x024b:
        r14 = r13.f33220c;
        r2 = r13.f33221d;
        r15.mo6183e(r14, r2);
        r13.f33221d = r6;
        goto L_0x02dc;
    L_0x0256:
        r13.m33819b();
        r14 = r13.f33220c;
        r2 = r13.f33221d;
        r15.mo6190l(r14, r2);
        r13.f33221d = r6;
        goto L_0x02dc;
    L_0x0264:
        r13.m33819b();
        r14 = r13.f33221d;
        if (r14 <= r4) goto L_0x0271;
    L_0x026b:
        r14 = r13.f33221d;
        r14 = r14 + -2;
        r13.f33221d = r14;
    L_0x0271:
        r14 = r13.f33220c;
        r2 = r13.f33221d;
        r15.mo6185g(r14, r2);
        r13.f33221d = r6;
        goto L_0x02dc;
    L_0x027b:
        r14 = r13.f33220c;
        r2 = r13.f33221d;
        r15.mo6179b(r14, r2);
        r13.f33221d = r6;
        r14 = r13.f33220c;
        r2 = r13.f33221d;
        r15.mo6188j(r14, r2);
        goto L_0x02dc;
    L_0x028c:
        r14 = r13.f33220c;
        r2 = r13.f33221d;
        r15.mo6179b(r14, r2);
        r13.f33221d = r6;
        goto L_0x02dc;
    L_0x0296:
        r14 = r13.f33220c;
        r2 = r13.f33221d;
        r15.mo6177a(r14, r2);
        r13.f33221d = r6;
        r15.mo6176a();
        r14 = r13.f33220c;
        r2 = r13.f33221d;
        r15.mo6188j(r14, r2);
        goto L_0x02dc;
    L_0x02aa:
        r14 = r13.f33220c;
        r2 = r13.f33221d;
        r15.mo6177a(r14, r2);
        r13.f33221d = r6;
        r15.mo6176a();
        goto L_0x02dc;
    L_0x02b7:
        r14 = r13.f33220c;
        r2 = r13.f33221d;
        r15.mo6177a(r14, r2);
        r13.f33221d = r6;
        goto L_0x02dc;
    L_0x02c1:
        r15.mo6176a();
        r13.f33221d = r6;
        r14 = r13.f33220c;
        r2 = r13.f33221d;
        r15.mo6188j(r14, r2);
        goto L_0x02dc;
    L_0x02ce:
        r15.mo6176a();
        r13.f33221d = r6;
        r13.m33817a(r14, r15);
        goto L_0x02dc;
    L_0x02d7:
        r15.mo6176a();
        r13.f33221d = r6;
    L_0x02dc:
        r14 = r13.f33219b;
        r13.f33218a = r14;
        goto L_0x0025;
    L_0x02e2:
        r15 = new java.lang.Error;
        r0 = new java.lang.StringBuffer;
        r1 = "HTMLScanner can't cope with ";
        r0.<init>(r1);
        r14 = java.lang.Integer.toString(r14);
        r0.append(r14);
        r14 = " in state ";
        r0.append(r14);
        r14 = r13.f33218a;
        r14 = java.lang.Integer.toString(r14);
        r0.append(r14);
        r14 = r0.toString();
        r15.<init>(r14);
        throw r15;
    L_0x0308:
        r15.mo6178b();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.ccil.cowan.tagsoup.HTMLScanner.a(java.io.Reader, org.ccil.cowan.tagsoup.ScanHandler):void");
    }

    private void m33819b() {
        this.f33226n = this.f33228p;
        this.f33225m = this.f33227o;
    }

    public final void mo6172a() {
        this.f33219b = 10;
    }

    private void m33817a(int i, ScanHandler scanHandler) throws IOException, SAXException {
        if (this.f33221d >= this.f33220c.length - 20) {
            if (this.f33218a != 28) {
                if (this.f33218a != 10) {
                    scanHandler = new char[(this.f33220c.length * 2)];
                    System.arraycopy(this.f33220c, 0, scanHandler, 0, this.f33221d + 1);
                    this.f33220c = scanHandler;
                }
            }
            scanHandler.mo6185g(this.f33220c, this.f33221d);
            this.f33221d = 0;
        }
        scanHandler = this.f33220c;
        int i2 = this.f33221d;
        this.f33221d = i2 + 1;
        scanHandler[i2] = (char) i;
    }
}
