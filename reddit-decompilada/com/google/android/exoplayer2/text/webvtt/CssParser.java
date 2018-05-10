package com.google.android.exoplayer2.text.webvtt;

import android.text.TextUtils;
import com.google.android.exoplayer2.util.ColorParser;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class CssParser {
    private static final Pattern f5081a = Pattern.compile("\\[voice=\"([^\"]*)\"\\]");
    private final ParsableByteArray f5082b = new ParsableByteArray();
    private final StringBuilder f5083c = new StringBuilder();

    public final WebvttCssStyle m4100a(ParsableByteArray parsableByteArray) {
        int i;
        int i2;
        String trim;
        WebvttCssStyle webvttCssStyle;
        Matcher matcher;
        Object obj;
        StringBuilder stringBuilder;
        String b;
        StringBuilder stringBuilder2;
        int i3;
        int i4;
        String a;
        String str;
        String a2;
        this.f5083c.setLength(0);
        int i5 = parsableByteArray.f5257b;
        do {
        } while (!TextUtils.isEmpty(parsableByteArray.m4267r()));
        this.f5082b.m4244a(parsableByteArray.f5256a, parsableByteArray.f5257b);
        this.f5082b.m4249c(i5);
        parsableByteArray = this.f5082b;
        StringBuilder stringBuilder3 = this.f5083c;
        m4099b(parsableByteArray);
        if (parsableByteArray.m4246b() >= 5) {
            if ("::cue".equals(parsableByteArray.m4253e(5))) {
                i = parsableByteArray.f5257b;
                String a3 = m4097a(parsableByteArray, stringBuilder3);
                if (a3 != null) {
                    if ("{".equals(a3)) {
                        parsableByteArray.m4249c(i);
                        parsableByteArray = "";
                    } else {
                        if ("(".equals(a3)) {
                            i = parsableByteArray.f5257b;
                            i2 = parsableByteArray.f5258c;
                            int i6 = 0;
                            while (i < i2 && r7 == 0) {
                                int i7 = i + 1;
                                i6 = ((char) parsableByteArray.f5256a[i]) == ')' ? true : 0;
                                i = i7;
                            }
                            trim = parsableByteArray.m4253e((i - 1) - parsableByteArray.f5257b).trim();
                        } else {
                            trim = null;
                        }
                        parsableByteArray = m4097a(parsableByteArray, stringBuilder3);
                        if (")".equals(parsableByteArray)) {
                            if (parsableByteArray != null) {
                                parsableByteArray = trim;
                            }
                        }
                    }
                    if (parsableByteArray != null) {
                        if (!"{".equals(m4097a(this.f5082b, this.f5083c))) {
                            webvttCssStyle = new WebvttCssStyle();
                            if (!"".equals(parsableByteArray)) {
                                i = parsableByteArray.indexOf(91);
                                if (i != -1) {
                                    matcher = f5081a.matcher(parsableByteArray.substring(i));
                                    if (matcher.matches()) {
                                        webvttCssStyle.f5087d = matcher.group(1);
                                    }
                                    parsableByteArray = parsableByteArray.substring(0, i);
                                }
                                parsableByteArray = parsableByteArray.split("\\.");
                                trim = parsableByteArray[0];
                                i2 = trim.indexOf(35);
                                if (i2 == -1) {
                                    webvttCssStyle.f5085b = trim.substring(0, i2);
                                    webvttCssStyle.f5084a = trim.substring(i2 + 1);
                                } else {
                                    webvttCssStyle.f5085b = trim;
                                }
                                if (parsableByteArray.length > 1) {
                                    webvttCssStyle.f5086c = Arrays.asList((String[]) Arrays.copyOfRange(parsableByteArray, 1, parsableByteArray.length));
                                }
                            }
                            parsableByteArray = null;
                            obj = null;
                            while (parsableByteArray == null) {
                                parsableByteArray = this.f5082b.f5257b;
                                obj = m4097a(this.f5082b, this.f5083c);
                                if (obj != null) {
                                    if ("}".equals(obj)) {
                                        i2 = 0;
                                        if (i2 != 0) {
                                            this.f5082b.m4249c(parsableByteArray);
                                            parsableByteArray = this.f5082b;
                                            stringBuilder = this.f5083c;
                                            m4099b(parsableByteArray);
                                            b = m4098b(parsableByteArray, stringBuilder);
                                            if (!"".equals(b) && ":".equals(m4097a(parsableByteArray, stringBuilder))) {
                                                m4099b(parsableByteArray);
                                                stringBuilder2 = new StringBuilder();
                                                i3 = 0;
                                                while (i3 == 0) {
                                                    i4 = parsableByteArray.f5257b;
                                                    a = m4097a(parsableByteArray, stringBuilder);
                                                    if (a != null) {
                                                        str = null;
                                                        break;
                                                    }
                                                    if (!"}".equals(a)) {
                                                        if (!";".equals(a)) {
                                                            stringBuilder2.append(a);
                                                        }
                                                    }
                                                    parsableByteArray.m4249c(i4);
                                                    i3 = true;
                                                }
                                                str = stringBuilder2.toString();
                                                if (str == null) {
                                                    if (!"".equals(str)) {
                                                        i3 = parsableByteArray.f5257b;
                                                        a2 = m4097a(parsableByteArray, stringBuilder);
                                                        if (!";".equals(a2)) {
                                                            if (!"}".equals(a2)) {
                                                                parsableByteArray.m4249c(i3);
                                                            }
                                                        }
                                                        if ("color".equals(b) == null) {
                                                            webvttCssStyle.f5089f = ColorParser.m4202b(str);
                                                            webvttCssStyle.f5090g = true;
                                                        } else if ("background-color".equals(b) == null) {
                                                            webvttCssStyle.f5091h = ColorParser.m4202b(str);
                                                            webvttCssStyle.f5092i = true;
                                                        } else if ("text-decoration".equals(b) == null) {
                                                            if ("underline".equals(str) == null) {
                                                                webvttCssStyle.f5094k = 1;
                                                            }
                                                        } else if ("font-family".equals(b) == null) {
                                                            webvttCssStyle.f5088e = Util.m4323d(str);
                                                        } else if ("font-weight".equals(b) != null) {
                                                            if ("bold".equals(str) == null) {
                                                                webvttCssStyle.f5095l = 1;
                                                            }
                                                        } else if (!("font-style".equals(b) == null || "italic".equals(str) == null)) {
                                                            webvttCssStyle.f5096m = 1;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        parsableByteArray = i2;
                                    }
                                }
                                i2 = true;
                                if (i2 != 0) {
                                    this.f5082b.m4249c(parsableByteArray);
                                    parsableByteArray = this.f5082b;
                                    stringBuilder = this.f5083c;
                                    m4099b(parsableByteArray);
                                    b = m4098b(parsableByteArray, stringBuilder);
                                    m4099b(parsableByteArray);
                                    stringBuilder2 = new StringBuilder();
                                    i3 = 0;
                                    while (i3 == 0) {
                                        i4 = parsableByteArray.f5257b;
                                        a = m4097a(parsableByteArray, stringBuilder);
                                        if (a != null) {
                                            str = null;
                                            break;
                                        }
                                        if ("}".equals(a)) {
                                            if (!";".equals(a)) {
                                                stringBuilder2.append(a);
                                            }
                                        }
                                        parsableByteArray.m4249c(i4);
                                        i3 = true;
                                    }
                                    str = stringBuilder2.toString();
                                    if (str == null) {
                                        if (!"".equals(str)) {
                                            i3 = parsableByteArray.f5257b;
                                            a2 = m4097a(parsableByteArray, stringBuilder);
                                            if (";".equals(a2)) {
                                                if (!"}".equals(a2)) {
                                                    parsableByteArray.m4249c(i3);
                                                }
                                            }
                                            if ("color".equals(b) == null) {
                                                webvttCssStyle.f5089f = ColorParser.m4202b(str);
                                                webvttCssStyle.f5090g = true;
                                            } else if ("background-color".equals(b) == null) {
                                                webvttCssStyle.f5091h = ColorParser.m4202b(str);
                                                webvttCssStyle.f5092i = true;
                                            } else if ("text-decoration".equals(b) == null) {
                                                if ("font-family".equals(b) == null) {
                                                    webvttCssStyle.f5088e = Util.m4323d(str);
                                                } else if ("font-weight".equals(b) != null) {
                                                    webvttCssStyle.f5096m = 1;
                                                } else if ("bold".equals(str) == null) {
                                                    webvttCssStyle.f5095l = 1;
                                                }
                                            } else if ("underline".equals(str) == null) {
                                                webvttCssStyle.f5094k = 1;
                                            }
                                        }
                                    }
                                }
                                parsableByteArray = i2;
                            }
                            if ("}".equals(obj) == null) {
                                return webvttCssStyle;
                            }
                            return null;
                        }
                    }
                    return null;
                }
            }
        }
        parsableByteArray = null;
        if (parsableByteArray != null) {
            if (!"{".equals(m4097a(this.f5082b, this.f5083c))) {
                webvttCssStyle = new WebvttCssStyle();
                if ("".equals(parsableByteArray)) {
                    i = parsableByteArray.indexOf(91);
                    if (i != -1) {
                        matcher = f5081a.matcher(parsableByteArray.substring(i));
                        if (matcher.matches()) {
                            webvttCssStyle.f5087d = matcher.group(1);
                        }
                        parsableByteArray = parsableByteArray.substring(0, i);
                    }
                    parsableByteArray = parsableByteArray.split("\\.");
                    trim = parsableByteArray[0];
                    i2 = trim.indexOf(35);
                    if (i2 == -1) {
                        webvttCssStyle.f5085b = trim;
                    } else {
                        webvttCssStyle.f5085b = trim.substring(0, i2);
                        webvttCssStyle.f5084a = trim.substring(i2 + 1);
                    }
                    if (parsableByteArray.length > 1) {
                        webvttCssStyle.f5086c = Arrays.asList((String[]) Arrays.copyOfRange(parsableByteArray, 1, parsableByteArray.length));
                    }
                }
                parsableByteArray = null;
                obj = null;
                while (parsableByteArray == null) {
                    parsableByteArray = this.f5082b.f5257b;
                    obj = m4097a(this.f5082b, this.f5083c);
                    if (obj != null) {
                        if ("}".equals(obj)) {
                            i2 = 0;
                            if (i2 != 0) {
                                this.f5082b.m4249c(parsableByteArray);
                                parsableByteArray = this.f5082b;
                                stringBuilder = this.f5083c;
                                m4099b(parsableByteArray);
                                b = m4098b(parsableByteArray, stringBuilder);
                                m4099b(parsableByteArray);
                                stringBuilder2 = new StringBuilder();
                                i3 = 0;
                                while (i3 == 0) {
                                    i4 = parsableByteArray.f5257b;
                                    a = m4097a(parsableByteArray, stringBuilder);
                                    if (a != null) {
                                        str = null;
                                        break;
                                    }
                                    if ("}".equals(a)) {
                                        if (!";".equals(a)) {
                                            stringBuilder2.append(a);
                                        }
                                    }
                                    parsableByteArray.m4249c(i4);
                                    i3 = true;
                                }
                                str = stringBuilder2.toString();
                                if (str == null) {
                                    if (!"".equals(str)) {
                                        i3 = parsableByteArray.f5257b;
                                        a2 = m4097a(parsableByteArray, stringBuilder);
                                        if (";".equals(a2)) {
                                            if (!"}".equals(a2)) {
                                                parsableByteArray.m4249c(i3);
                                            }
                                        }
                                        if ("color".equals(b) == null) {
                                            webvttCssStyle.f5089f = ColorParser.m4202b(str);
                                            webvttCssStyle.f5090g = true;
                                        } else if ("background-color".equals(b) == null) {
                                            webvttCssStyle.f5091h = ColorParser.m4202b(str);
                                            webvttCssStyle.f5092i = true;
                                        } else if ("text-decoration".equals(b) == null) {
                                            if ("underline".equals(str) == null) {
                                                webvttCssStyle.f5094k = 1;
                                            }
                                        } else if ("font-family".equals(b) == null) {
                                            webvttCssStyle.f5088e = Util.m4323d(str);
                                        } else if ("font-weight".equals(b) != null) {
                                            webvttCssStyle.f5096m = 1;
                                        } else if ("bold".equals(str) == null) {
                                            webvttCssStyle.f5095l = 1;
                                        }
                                    }
                                }
                            }
                            parsableByteArray = i2;
                        }
                    }
                    i2 = true;
                    if (i2 != 0) {
                        this.f5082b.m4249c(parsableByteArray);
                        parsableByteArray = this.f5082b;
                        stringBuilder = this.f5083c;
                        m4099b(parsableByteArray);
                        b = m4098b(parsableByteArray, stringBuilder);
                        m4099b(parsableByteArray);
                        stringBuilder2 = new StringBuilder();
                        i3 = 0;
                        while (i3 == 0) {
                            i4 = parsableByteArray.f5257b;
                            a = m4097a(parsableByteArray, stringBuilder);
                            if (a != null) {
                                str = null;
                                break;
                            }
                            if ("}".equals(a)) {
                                if (!";".equals(a)) {
                                    stringBuilder2.append(a);
                                }
                            }
                            parsableByteArray.m4249c(i4);
                            i3 = true;
                        }
                        str = stringBuilder2.toString();
                        if (str == null) {
                            if (!"".equals(str)) {
                                i3 = parsableByteArray.f5257b;
                                a2 = m4097a(parsableByteArray, stringBuilder);
                                if (";".equals(a2)) {
                                    if (!"}".equals(a2)) {
                                        parsableByteArray.m4249c(i3);
                                    }
                                }
                                if ("color".equals(b) == null) {
                                    webvttCssStyle.f5089f = ColorParser.m4202b(str);
                                    webvttCssStyle.f5090g = true;
                                } else if ("background-color".equals(b) == null) {
                                    webvttCssStyle.f5091h = ColorParser.m4202b(str);
                                    webvttCssStyle.f5092i = true;
                                } else if ("text-decoration".equals(b) == null) {
                                    if ("font-family".equals(b) == null) {
                                        webvttCssStyle.f5088e = Util.m4323d(str);
                                    } else if ("font-weight".equals(b) != null) {
                                        webvttCssStyle.f5096m = 1;
                                    } else if ("bold".equals(str) == null) {
                                        webvttCssStyle.f5095l = 1;
                                    }
                                } else if ("underline".equals(str) == null) {
                                    webvttCssStyle.f5094k = 1;
                                }
                            }
                        }
                    }
                    parsableByteArray = i2;
                }
                if ("}".equals(obj) == null) {
                    return null;
                }
                return webvttCssStyle;
            }
        }
        return null;
    }

    private static void m4099b(ParsableByteArray parsableByteArray) {
        while (true) {
            int i = 1;
            while (parsableByteArray.m4246b() > 0 && r1 != 0) {
                switch ((char) parsableByteArray.f5256a[parsableByteArray.f5257b]) {
                    case '\t':
                    case '\n':
                    case '\f':
                    case '\r':
                    case ' ':
                        parsableByteArray.m4251d(1);
                        i = 1;
                        break;
                    default:
                        i = 0;
                        break;
                }
                if (i == 0) {
                    i = parsableByteArray.f5257b;
                    int i2 = parsableByteArray.f5258c;
                    byte[] bArr = parsableByteArray.f5256a;
                    if (i + 2 <= i2) {
                        int i3 = i + 1;
                        if (bArr[i] == (byte) 47) {
                            i = i3 + 1;
                            if (bArr[i3] == (byte) 42) {
                                while (true) {
                                    i3 = i + 1;
                                    if (i3 >= i2) {
                                        parsableByteArray.m4251d(i2 - parsableByteArray.f5257b);
                                        i = 1;
                                        if (i != 0) {
                                            i = 0;
                                        }
                                    } else if (((char) bArr[i]) == '*' && ((char) bArr[i3]) == '/') {
                                        i = i3 + 1;
                                        i2 = i;
                                    } else {
                                        i = i3;
                                    }
                                }
                            }
                        }
                    }
                    i = 0;
                    if (i != 0) {
                        i = 0;
                    }
                }
            }
            return;
        }
    }

    private static String m4097a(ParsableByteArray parsableByteArray, StringBuilder stringBuilder) {
        m4099b(parsableByteArray);
        if (parsableByteArray.m4246b() == 0) {
            return null;
        }
        stringBuilder = m4098b(parsableByteArray, stringBuilder);
        if (!"".equals(stringBuilder)) {
            return stringBuilder;
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append((char) parsableByteArray.m4250d());
        return stringBuilder.toString();
    }

    private static String m4098b(ParsableByteArray parsableByteArray, StringBuilder stringBuilder) {
        int i = 0;
        stringBuilder.setLength(0);
        int i2 = parsableByteArray.f5257b;
        int i3 = parsableByteArray.f5258c;
        while (i2 < i3 && r0 == 0) {
            char c = (char) parsableByteArray.f5256a[i2];
            if ((c < 'A' || c > 'Z') && ((c < 'a' || c > 'z') && !((c >= '0' && c <= '9') || c == '#' || c == '-' || c == '.'))) {
                if (c != '_') {
                    i = 1;
                }
            }
            i2++;
            stringBuilder.append(c);
        }
        parsableByteArray.m4251d(i2 - parsableByteArray.f5257b);
        return stringBuilder.toString();
    }
}
