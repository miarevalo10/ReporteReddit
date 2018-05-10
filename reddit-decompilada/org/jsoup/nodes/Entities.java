package org.jsoup.nodes;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import org.jsoup.helper.StringUtil;
import org.jsoup.nodes.Document.OutputSettings;

public class Entities {
    private static final HashMap<String, String> f26993a = new HashMap();
    private static final char[] f26994b = new char[]{',', ';'};

    private enum CoreCharset {
        ascii,
        utf,
        fallback
    }

    public enum EscapeMode {
        xhtml("entities-xhtml.properties", 4),
        base("entities-base.properties", 106),
        extended("entities-full.properties", 2125);
        
        int[] f26989d;
        String[] f26990e;
        private String[] f26991f;
        private int[] f26992g;

        private EscapeMode(String str, int i) {
            Entities.m28492a(this, str, i);
        }

        final int m28488a(String str) {
            str = Arrays.binarySearch(this.f26991f, str);
            return str >= null ? this.f26992g[str] : -1;
        }
    }

    private Entities() {
    }

    public static boolean m28493a(String str) {
        return EscapeMode.extended.m28488a(str) != -1 ? true : null;
    }

    public static boolean m28494b(String str) {
        return EscapeMode.base.m28488a(str) != -1 ? true : null;
    }

    public static int m28489a(String str, int[] iArr) {
        String str2 = (String) f26993a.get(str);
        if (str2 != null) {
            iArr[0] = str2.codePointAt(0);
            iArr[1] = str2.codePointAt(1);
            return 2;
        }
        str = EscapeMode.extended.m28488a(str);
        if (str == -1) {
            return 0;
        }
        iArr[0] = str;
        return 1;
    }

    static void m28490a(Appendable appendable, String str, OutputSettings outputSettings, boolean z, boolean z2) throws IOException {
        EscapeMode escapeMode = outputSettings.f26970a;
        outputSettings = outputSettings.f26971b.newEncoder();
        CoreCharset a = CoreCharset.m28479a(outputSettings.charset().name());
        int length = str.length();
        int i = 0;
        int i2 = i;
        while (i < length) {
            int codePointAt = str.codePointAt(i);
            boolean z3 = true;
            if (z2) {
                if (StringUtil.m28449b(codePointAt)) {
                    if (i2 == 0) {
                        appendable.append(' ');
                        i2 = true;
                    }
                    i += Character.charCount(codePointAt);
                } else {
                    i2 = 0;
                }
            }
            if (codePointAt < 65536) {
                char c = (char) codePointAt;
                if (c != '\"') {
                    if (c == '&') {
                        appendable.append("&amp;");
                    } else if (c == '<') {
                        if (z) {
                            if (escapeMode != EscapeMode.xhtml) {
                                appendable.append(c);
                            }
                        }
                        appendable.append("&lt;");
                    } else if (c != '>') {
                        if (c != ' ') {
                            switch (a) {
                                case ascii:
                                    if (c >= '') {
                                        z3 = false;
                                        break;
                                    }
                                    break;
                                case utf:
                                    break;
                                default:
                                    z3 = outputSettings.canEncode(c);
                                    break;
                            }
                            if (z3) {
                                appendable.append(c);
                            } else {
                                m28491a(appendable, escapeMode, codePointAt);
                            }
                        } else if (escapeMode != EscapeMode.xhtml) {
                            appendable.append("&nbsp;");
                        } else {
                            appendable.append("&#xa0;");
                        }
                    } else if (z) {
                        appendable.append(c);
                    } else {
                        appendable.append("&gt;");
                    }
                } else if (z) {
                    appendable.append("&quot;");
                } else {
                    appendable.append(c);
                }
            } else {
                CharSequence str2 = new String(Character.toChars(codePointAt));
                if (outputSettings.canEncode(str2)) {
                    appendable.append(str2);
                } else {
                    m28491a(appendable, escapeMode, codePointAt);
                }
            }
            i += Character.charCount(codePointAt);
        }
    }

    private static void m28491a(Appendable appendable, EscapeMode escapeMode, int i) throws IOException {
        int binarySearch = Arrays.binarySearch(escapeMode.f26989d, i);
        if (binarySearch >= 0) {
            if (binarySearch < escapeMode.f26990e.length - 1) {
                int i2 = binarySearch + 1;
                if (escapeMode.f26989d[i2] == i) {
                    escapeMode = escapeMode.f26990e[i2];
                }
            }
            escapeMode = escapeMode.f26990e[binarySearch];
        } else {
            escapeMode = "";
        }
        if (escapeMode != "") {
            appendable.append(38).append(escapeMode).append(';');
        } else {
            appendable.append("&#x").append(Integer.toHexString(i)).append(';');
        }
    }

    static /* synthetic */ void m28492a(org.jsoup.nodes.Entities.EscapeMode r11, java.lang.String r12, int r13) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = new java.lang.String[r13];
        r11.f26991f = r0;
        r0 = new int[r13];
        r11.f26992g = r0;
        r0 = new int[r13];
        r11.f26989d = r0;
        r13 = new java.lang.String[r13];
        r11.f26990e = r13;
        r13 = org.jsoup.nodes.Entities.class;
        r13 = r13.getResourceAsStream(r12);
        if (r13 != 0) goto L_0x003e;
    L_0x001c:
        r11 = new java.lang.IllegalStateException;
        r13 = new java.lang.StringBuilder;
        r0 = "Could not read resource ";
        r13.<init>(r0);
        r13.append(r12);
        r12 = ". Make sure you copy resources for ";
        r13.append(r12);
        r12 = org.jsoup.nodes.Entities.class;
        r12 = r12.getCanonicalName();
        r13.append(r12);
        r12 = r13.toString();
        r11.<init>(r12);
        throw r11;
    L_0x003e:
        r0 = 0;
        r13 = org.jsoup.helper.DataUtil.m28437a(r13, r0);	 Catch:{ IOException -> 0x00e1 }
        r1 = "ascii";	 Catch:{ IOException -> 0x00e1 }
        r1 = java.nio.charset.Charset.forName(r1);	 Catch:{ IOException -> 0x00e1 }
        r13 = r1.decode(r13);	 Catch:{ IOException -> 0x00e1 }
        r13 = r13.toString();	 Catch:{ IOException -> 0x00e1 }
        r1 = new org.jsoup.parser.CharacterReader;	 Catch:{ IOException -> 0x00e1 }
        r1.<init>(r13);	 Catch:{ IOException -> 0x00e1 }
        r13 = r0;	 Catch:{ IOException -> 0x00e1 }
    L_0x0057:
        r2 = r1.m28523a();	 Catch:{ IOException -> 0x00e1 }
        if (r2 != 0) goto L_0x00e0;	 Catch:{ IOException -> 0x00e1 }
    L_0x005d:
        r2 = 61;	 Catch:{ IOException -> 0x00e1 }
        r2 = r1.m28520a(r2);	 Catch:{ IOException -> 0x00e1 }
        r1.m28533e();	 Catch:{ IOException -> 0x00e1 }
        r3 = f26994b;	 Catch:{ IOException -> 0x00e1 }
        r3 = r1.m28522a(r3);	 Catch:{ IOException -> 0x00e1 }
        r4 = 36;	 Catch:{ IOException -> 0x00e1 }
        r3 = java.lang.Integer.parseInt(r3, r4);	 Catch:{ IOException -> 0x00e1 }
        r5 = r1.m28525b();	 Catch:{ IOException -> 0x00e1 }
        r1.m28533e();	 Catch:{ IOException -> 0x00e1 }
        r6 = 44;	 Catch:{ IOException -> 0x00e1 }
        r7 = -1;	 Catch:{ IOException -> 0x00e1 }
        if (r5 != r6) goto L_0x008c;	 Catch:{ IOException -> 0x00e1 }
    L_0x007e:
        r5 = 59;	 Catch:{ IOException -> 0x00e1 }
        r5 = r1.m28520a(r5);	 Catch:{ IOException -> 0x00e1 }
        r5 = java.lang.Integer.parseInt(r5, r4);	 Catch:{ IOException -> 0x00e1 }
        r1.m28533e();	 Catch:{ IOException -> 0x00e1 }
        goto L_0x008d;	 Catch:{ IOException -> 0x00e1 }
    L_0x008c:
        r5 = r7;	 Catch:{ IOException -> 0x00e1 }
    L_0x008d:
        r6 = 10;	 Catch:{ IOException -> 0x00e1 }
        r6 = r1.m28520a(r6);	 Catch:{ IOException -> 0x00e1 }
        r8 = r6.length();	 Catch:{ IOException -> 0x00e1 }
        r9 = 1;	 Catch:{ IOException -> 0x00e1 }
        r8 = r8 - r9;	 Catch:{ IOException -> 0x00e1 }
        r8 = r6.charAt(r8);	 Catch:{ IOException -> 0x00e1 }
        r10 = 13;	 Catch:{ IOException -> 0x00e1 }
        if (r8 != r10) goto L_0x00aa;	 Catch:{ IOException -> 0x00e1 }
    L_0x00a1:
        r8 = r6.length();	 Catch:{ IOException -> 0x00e1 }
        r8 = r8 - r9;	 Catch:{ IOException -> 0x00e1 }
        r6 = r6.substring(r0, r8);	 Catch:{ IOException -> 0x00e1 }
    L_0x00aa:
        r4 = java.lang.Integer.parseInt(r6, r4);	 Catch:{ IOException -> 0x00e1 }
        r1.m28533e();	 Catch:{ IOException -> 0x00e1 }
        r6 = r11.f26991f;	 Catch:{ IOException -> 0x00e1 }
        r6[r13] = r2;	 Catch:{ IOException -> 0x00e1 }
        r6 = r11.f26992g;	 Catch:{ IOException -> 0x00e1 }
        r6[r13] = r3;	 Catch:{ IOException -> 0x00e1 }
        r6 = r11.f26989d;	 Catch:{ IOException -> 0x00e1 }
        r6[r4] = r3;	 Catch:{ IOException -> 0x00e1 }
        r6 = r11.f26990e;	 Catch:{ IOException -> 0x00e1 }
        r6[r4] = r2;	 Catch:{ IOException -> 0x00e1 }
        if (r5 == r7) goto L_0x00dc;	 Catch:{ IOException -> 0x00e1 }
    L_0x00cb:
        r4 = f26993a;	 Catch:{ IOException -> 0x00e1 }
        r6 = new java.lang.String;	 Catch:{ IOException -> 0x00e1 }
        r7 = 2;	 Catch:{ IOException -> 0x00e1 }
        r8 = new int[r7];	 Catch:{ IOException -> 0x00e1 }
        r8[r0] = r3;	 Catch:{ IOException -> 0x00e1 }
        r8[r9] = r5;	 Catch:{ IOException -> 0x00e1 }
        r6.<init>(r8, r0, r7);	 Catch:{ IOException -> 0x00e1 }
        r4.put(r2, r6);	 Catch:{ IOException -> 0x00e1 }
    L_0x00dc:
        r13 = r13 + 1;
        goto L_0x0057;
    L_0x00e0:
        return;
    L_0x00e1:
        r11 = new java.lang.IllegalStateException;
        r13 = new java.lang.StringBuilder;
        r0 = "Error reading resource ";
        r13.<init>(r0);
        r13.append(r12);
        r12 = r13.toString();
        r11.<init>(r12);
        throw r11;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jsoup.nodes.Entities.a(org.jsoup.nodes.Entities$EscapeMode, java.lang.String, int):void");
    }
}
