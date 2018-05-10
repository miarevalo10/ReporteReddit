package org.jsoup.parser;

import java.util.Arrays;
import org.jsoup.helper.Validate;

final class Tokeniser {
    private static final char[] f27088o;
    final CharacterReader f27089a;
    TokeniserState f27090b = TokeniserState.f27133a;
    Token f27091c;
    boolean f27092d = false;
    String f27093e = null;
    StringBuilder f27094f = new StringBuilder(1024);
    StringBuilder f27095g = new StringBuilder(1024);
    Tag f27096h;
    StartTag f27097i = new StartTag();
    EndTag f27098j = new EndTag();
    Character f27099k = new Character();
    Doctype f27100l = new Doctype();
    Comment f27101m = new Comment();
    boolean f27102n = true;
    private final ParseErrorList f27103p;
    private String f27104q;
    private final int[] f27105r = new int[1];
    private final int[] f27106s = new int[2];

    static {
        char[] cArr = new char[]{'\t', '\n', '\r', '\f', ' ', '<', '&'};
        f27088o = cArr;
        Arrays.sort(cArr);
    }

    Tokeniser(CharacterReader characterReader, ParseErrorList parseErrorList) {
        this.f27089a = characterReader;
        this.f27103p = parseErrorList;
    }

    final void m28599a(Token token) {
        Validate.m28461b(this.f27092d, "There is an unread token pending!");
        this.f27091c = token;
        this.f27092d = true;
        if (token.f27085a == TokenType.StartTag) {
            StartTag startTag = (StartTag) token;
            this.f27104q = startTag.b;
            if (startTag.f != null) {
                this.f27102n = null;
            }
            return;
        }
        if (token.f27085a == TokenType.EndTag && ((EndTag) token).g != null) {
            m28603b("Attributes incorrectly present on end tag");
        }
    }

    final void m28598a(String str) {
        if (this.f27093e == null) {
            this.f27093e = str;
            return;
        }
        if (this.f27094f.length() == 0) {
            this.f27094f.append(this.f27093e);
        }
        this.f27094f.append(str);
    }

    final void m28597a(char c) {
        m28598a(String.valueOf(c));
    }

    final void m28600a(TokeniserState tokeniserState) {
        this.f27089a.m28533e();
        this.f27090b = tokeniserState;
    }

    final int[] m28601a(java.lang.Character r12, boolean r13) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r11 = this;
        r0 = r11.f27089a;
        r0 = r0.m28523a();
        r1 = 0;
        if (r0 == 0) goto L_0x000a;
    L_0x0009:
        return r1;
    L_0x000a:
        if (r12 == 0) goto L_0x0019;
    L_0x000c:
        r12 = r12.charValue();
        r0 = r11.f27089a;
        r0 = r0.m28525b();
        if (r12 != r0) goto L_0x0019;
    L_0x0018:
        return r1;
    L_0x0019:
        r12 = r11.f27089a;
        r0 = f27088o;
        r2 = r12.m28523a();
        r3 = 0;
        r4 = 1;
        if (r2 != 0) goto L_0x0033;
    L_0x0025:
        r2 = r12.f27001a;
        r12 = r12.f27003c;
        r12 = r2[r12];
        r12 = java.util.Arrays.binarySearch(r0, r12);
        if (r12 < 0) goto L_0x0033;
    L_0x0031:
        r12 = r4;
        goto L_0x0034;
    L_0x0033:
        r12 = r3;
    L_0x0034:
        if (r12 == 0) goto L_0x0037;
    L_0x0036:
        return r1;
    L_0x0037:
        r12 = r11.f27105r;
        r0 = r11.f27089a;
        r2 = r0.f27003c;
        r0.f27004d = r2;
        r0 = r11.f27089a;
        r2 = "#";
        r0 = r0.m28524a(r2);
        r2 = 97;
        r5 = 65;
        r6 = 57;
        r7 = 48;
        if (r0 == 0) goto L_0x00fc;
    L_0x0051:
        r13 = r11.f27089a;
        r0 = "X";
        r13 = r13.m28528b(r0);
        if (r13 == 0) goto L_0x0089;
    L_0x005b:
        r0 = r11.f27089a;
        r8 = r0.f27003c;
    L_0x005f:
        r9 = r0.f27003c;
        r10 = r0.f27002b;
        if (r9 >= r10) goto L_0x0081;
    L_0x0065:
        r9 = r0.f27001a;
        r10 = r0.f27003c;
        r9 = r9[r10];
        if (r9 < r7) goto L_0x006f;
    L_0x006d:
        if (r9 <= r6) goto L_0x007b;
    L_0x006f:
        if (r9 < r5) goto L_0x0075;
    L_0x0071:
        r10 = 70;
        if (r9 <= r10) goto L_0x007b;
    L_0x0075:
        if (r9 < r2) goto L_0x0081;
    L_0x0077:
        r10 = 102; // 0x66 float:1.43E-43 double:5.04E-322;
        if (r9 > r10) goto L_0x0081;
    L_0x007b:
        r9 = r0.f27003c;
        r9 = r9 + r4;
        r0.f27003c = r9;
        goto L_0x005f;
    L_0x0081:
        r2 = r0.f27003c;
        r2 = r2 - r8;
        r0 = r0.m28521a(r8, r2);
        goto L_0x00aa;
    L_0x0089:
        r0 = r11.f27089a;
        r2 = r0.f27003c;
    L_0x008d:
        r5 = r0.f27003c;
        r8 = r0.f27002b;
        if (r5 >= r8) goto L_0x00a3;
    L_0x0093:
        r5 = r0.f27001a;
        r8 = r0.f27003c;
        r5 = r5[r8];
        if (r5 < r7) goto L_0x00a3;
    L_0x009b:
        if (r5 > r6) goto L_0x00a3;
    L_0x009d:
        r5 = r0.f27003c;
        r5 = r5 + r4;
        r0.f27003c = r5;
        goto L_0x008d;
    L_0x00a3:
        r4 = r0.f27003c;
        r4 = r4 - r2;
        r0 = r0.m28521a(r2, r4);
    L_0x00aa:
        r2 = r0.length();
        if (r2 != 0) goto L_0x00bb;
    L_0x00b0:
        r12 = "numeric reference with no numerals";
        r11.m28594c(r12);
        r12 = r11.f27089a;
        r12.m28534f();
        return r1;
    L_0x00bb:
        r1 = r11.f27089a;
        r2 = ";";
        r1 = r1.m28524a(r2);
        if (r1 != 0) goto L_0x00ca;
    L_0x00c5:
        r1 = "missing semicolon";
        r11.m28594c(r1);
    L_0x00ca:
        if (r13 == 0) goto L_0x00cf;
    L_0x00cc:
        r13 = 16;
        goto L_0x00d1;
    L_0x00cf:
        r13 = 10;
    L_0x00d1:
        r1 = -1;
        r13 = java.lang.Integer.valueOf(r0, r13);	 Catch:{ NumberFormatException -> 0x00db }
        r13 = r13.intValue();	 Catch:{ NumberFormatException -> 0x00db }
        goto L_0x00dc;
    L_0x00db:
        r13 = r1;
    L_0x00dc:
        if (r13 == r1) goto L_0x00f1;
    L_0x00de:
        r0 = 55296; // 0xd800 float:7.7486E-41 double:2.732E-319;
        if (r13 < r0) goto L_0x00e8;
    L_0x00e3:
        r0 = 57343; // 0xdfff float:8.0355E-41 double:2.8331E-319;
        if (r13 <= r0) goto L_0x00f1;
    L_0x00e8:
        r0 = 1114111; // 0x10ffff float:1.561202E-39 double:5.50444E-318;
        if (r13 <= r0) goto L_0x00ee;
    L_0x00ed:
        goto L_0x00f1;
    L_0x00ee:
        r12[r3] = r13;
        return r12;
    L_0x00f1:
        r13 = "character outside of valid range";
        r11.m28594c(r13);
        r13 = 65533; // 0xfffd float:9.1831E-41 double:3.23776E-319;
        r12[r3] = r13;
        return r12;
    L_0x00fc:
        r0 = r11.f27089a;
        r8 = r0.f27003c;
    L_0x0100:
        r9 = r0.f27003c;
        r10 = r0.f27002b;
        if (r9 >= r10) goto L_0x0124;
    L_0x0106:
        r9 = r0.f27001a;
        r10 = r0.f27003c;
        r9 = r9[r10];
        if (r9 < r5) goto L_0x0112;
    L_0x010e:
        r10 = 90;
        if (r9 <= r10) goto L_0x011e;
    L_0x0112:
        if (r9 < r2) goto L_0x0118;
    L_0x0114:
        r10 = 122; // 0x7a float:1.71E-43 double:6.03E-322;
        if (r9 <= r10) goto L_0x011e;
    L_0x0118:
        r9 = java.lang.Character.isLetter(r9);
        if (r9 == 0) goto L_0x0124;
    L_0x011e:
        r9 = r0.f27003c;
        r9 = r9 + r4;
        r0.f27003c = r9;
        goto L_0x0100;
    L_0x0124:
        r2 = r0.m28523a();
        if (r2 != 0) goto L_0x013a;
    L_0x012a:
        r2 = r0.f27001a;
        r5 = r0.f27003c;
        r2 = r2[r5];
        if (r2 < r7) goto L_0x013a;
    L_0x0132:
        if (r2 > r6) goto L_0x013a;
    L_0x0134:
        r2 = r0.f27003c;
        r2 = r2 + r4;
        r0.f27003c = r2;
        goto L_0x0124;
    L_0x013a:
        r2 = r0.f27003c;
        r2 = r2 - r8;
        r0 = r0.m28521a(r8, r2);
        r2 = r11.f27089a;
        r5 = 59;
        r2 = r2.m28527b(r5);
        r5 = org.jsoup.nodes.Entities.m28494b(r0);
        if (r5 != 0) goto L_0x015a;
    L_0x014f:
        r5 = org.jsoup.nodes.Entities.m28493a(r0);
        if (r5 == 0) goto L_0x0158;
    L_0x0155:
        if (r2 == 0) goto L_0x0158;
    L_0x0157:
        goto L_0x015a;
    L_0x0158:
        r5 = r3;
        goto L_0x015b;
    L_0x015a:
        r5 = r4;
    L_0x015b:
        if (r5 != 0) goto L_0x0172;
    L_0x015d:
        r12 = r11.f27089a;
        r12.m28534f();
        if (r2 == 0) goto L_0x0171;
    L_0x0164:
        r12 = "invalid named referenece '%s'";
        r13 = new java.lang.Object[r4];
        r13[r3] = r0;
        r12 = java.lang.String.format(r12, r13);
        r11.m28594c(r12);
    L_0x0171:
        return r1;
    L_0x0172:
        if (r13 == 0) goto L_0x01a7;
    L_0x0174:
        r13 = r11.f27089a;
        r13 = r13.m28537i();
        if (r13 != 0) goto L_0x01a1;
    L_0x017c:
        r13 = r11.f27089a;
        r2 = r13.m28523a();
        if (r2 != 0) goto L_0x0190;
    L_0x0184:
        r2 = r13.f27001a;
        r13 = r13.f27003c;
        r13 = r2[r13];
        if (r13 < r7) goto L_0x0190;
    L_0x018c:
        if (r13 > r6) goto L_0x0190;
    L_0x018e:
        r13 = r4;
        goto L_0x0191;
    L_0x0190:
        r13 = r3;
    L_0x0191:
        if (r13 != 0) goto L_0x01a1;
    L_0x0193:
        r13 = r11.f27089a;
        r2 = 3;
        r2 = new char[r2];
        r2 = {61, 45, 95};
        r13 = r13.m28531c(r2);
        if (r13 == 0) goto L_0x01a7;
    L_0x01a1:
        r12 = r11.f27089a;
        r12.m28534f();
        return r1;
    L_0x01a7:
        r13 = r11.f27089a;
        r1 = ";";
        r13 = r13.m28524a(r1);
        if (r13 != 0) goto L_0x01b6;
    L_0x01b1:
        r13 = "missing semicolon";
        r11.m28594c(r13);
    L_0x01b6:
        r13 = r11.f27106s;
        r13 = org.jsoup.nodes.Entities.m28489a(r0, r13);
        if (r13 != r4) goto L_0x01c5;
    L_0x01be:
        r13 = r11.f27106s;
        r13 = r13[r3];
        r12[r3] = r13;
        return r12;
    L_0x01c5:
        r12 = 2;
        if (r13 != r12) goto L_0x01cb;
    L_0x01c8:
        r12 = r11.f27106s;
        return r12;
    L_0x01cb:
        r12 = new java.lang.StringBuilder;
        r13 = "Unexpected characters returned for ";
        r12.<init>(r13);
        r12.append(r0);
        r12 = r12.toString();
        org.jsoup.helper.Validate.m28459b(r12);
        r12 = r11.f27106s;
        return r12;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jsoup.parser.Tokeniser.a(java.lang.Character, boolean):int[]");
    }

    final Tag m28595a(boolean z) {
        this.f27096h = z ? this.f27097i.mo6857h() : this.f27098j.mo6857h();
        return this.f27096h;
    }

    final void m28596a() {
        Tag tag = this.f27096h;
        if (tag.f33373d != null) {
            tag.m34068i();
        }
        m28599a(this.f27096h);
    }

    final void m28602b() {
        m28599a(this.f27101m);
    }

    final void m28605c() {
        this.f27100l.mo6350a();
    }

    final void m28607d() {
        m28599a(this.f27100l);
    }

    final boolean m28608e() {
        return this.f27104q != null && this.f27096h.m34069j().equalsIgnoreCase(this.f27104q);
    }

    final String m28609f() {
        if (this.f27104q == null) {
            return null;
        }
        return this.f27104q;
    }

    final void m28604b(TokeniserState tokeniserState) {
        if (this.f27103p.m28561a()) {
            this.f27103p.add(new ParseError(this.f27089a.f27003c, "Unexpected character '%s' in input state [%s]", Character.valueOf(this.f27089a.m28525b()), tokeniserState));
        }
    }

    final void m28606c(TokeniserState tokeniserState) {
        if (this.f27103p.m28561a()) {
            this.f27103p.add(new ParseError(this.f27089a.f27003c, "Unexpectedly reached end of file (EOF) in input state [%s]", tokeniserState));
        }
    }

    private void m28594c(String str) {
        if (this.f27103p.m28561a()) {
            this.f27103p.add(new ParseError(this.f27089a.f27003c, "Invalid character reference: %s", str));
        }
    }

    final void m28603b(String str) {
        if (this.f27103p.m28561a()) {
            this.f27103p.add(new ParseError(this.f27089a.f27003c, str));
        }
    }
}
