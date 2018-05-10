package com.sendbird.android.shadow.okhttp3;

import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import com.sendbird.android.shadow.okhttp3.internal.Util;
import com.sendbird.android.shadow.okio.Buffer;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.jcodec.containers.mps.MPSUtils;

public final class HttpUrl {
    private static final char[] f23213e = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    public final String f23214a;
    public final String f23215b;
    public final int f23216c;
    public final List<String> f23217d;
    private final String f23218f;
    private final String f23219g;
    private final List<String> f23220h;
    private final String f23221i;
    private final String f23222j;

    public static final class Builder {
        String f23205a;
        String f23206b = "";
        String f23207c = "";
        String f23208d;
        int f23209e = -1;
        final List<String> f23210f = new ArrayList();
        List<String> f23211g;
        String f23212h;

        enum ParseResult {
            SUCCESS,
            MISSING_SCHEME,
            UNSUPPORTED_SCHEME,
            INVALID_PORT,
            INVALID_HOST
        }

        public Builder() {
            this.f23210f.add("");
        }

        final int m25276a() {
            return this.f23209e != -1 ? this.f23209e : HttpUrl.m25280a(this.f23205a);
        }

        public final Builder m25278a(String str) {
            if (str != null) {
                str = HttpUrl.m25288b(HttpUrl.m25283a(str, " \"'<>#", true, false, true, true));
            } else {
                str = null;
            }
            this.f23211g = str;
            return this;
        }

        public final HttpUrl m25279b() {
            if (this.f23205a == null) {
                throw new IllegalStateException("scheme == null");
            } else if (this.f23208d != null) {
                return new HttpUrl(this);
            } else {
                throw new IllegalStateException("host == null");
            }
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.f23205a);
            stringBuilder.append("://");
            if (!(this.f23206b.isEmpty() && this.f23207c.isEmpty())) {
                stringBuilder.append(this.f23206b);
                if (!this.f23207c.isEmpty()) {
                    stringBuilder.append(':');
                    stringBuilder.append(this.f23207c);
                }
                stringBuilder.append('@');
            }
            if (this.f23208d.indexOf(58) != -1) {
                stringBuilder.append('[');
                stringBuilder.append(this.f23208d);
                stringBuilder.append(']');
            } else {
                stringBuilder.append(this.f23208d);
            }
            int a = m25276a();
            if (a != HttpUrl.m25280a(this.f23205a)) {
                stringBuilder.append(':');
                stringBuilder.append(a);
            }
            HttpUrl.m25286a(stringBuilder, this.f23210f);
            if (this.f23211g != null) {
                stringBuilder.append('?');
                HttpUrl.m25289b(stringBuilder, this.f23211g);
            }
            if (this.f23212h != null) {
                stringBuilder.append('#');
                stringBuilder.append(this.f23212h);
            }
            return stringBuilder.toString();
        }

        final ParseResult m25277a(HttpUrl httpUrl, String str) {
            int i;
            char charAt;
            int i2;
            char c;
            char charAt2;
            char c2;
            int i3;
            int a;
            int i4;
            int a2;
            char charAt3;
            int i5;
            char c3;
            String a3;
            Builder builder = this;
            HttpUrl httpUrl2 = httpUrl;
            String str2 = str;
            int a4 = Util.m25352a(str2, 0, str.length());
            int b = Util.m25375b(str2, a4, str.length());
            char c4 = ':';
            if (b - a4 >= 2) {
                char charAt4 = str2.charAt(a4);
                if (charAt4 < 'a' || charAt4 > 'z') {
                    if (charAt4 >= 'A') {
                        if (charAt4 > 'Z') {
                        }
                    }
                }
                i = a4 + 1;
                while (i < b) {
                    charAt = str2.charAt(i);
                    if ((charAt >= 'a' && charAt <= 'z') || ((charAt >= 'A' && charAt <= 'Z') || ((charAt >= '0' && charAt <= '9') || charAt == '+' || charAt == '-' || charAt == '.'))) {
                        i++;
                    } else if (charAt == ':') {
                        if (i != -1) {
                            if (str2.regionMatches(true, a4, "https:", 0, 6)) {
                                if (str2.regionMatches(true, a4, "http:", 0, 5)) {
                                    return ParseResult.UNSUPPORTED_SCHEME;
                                }
                                builder.f23205a = "http";
                                a4 += 5;
                            } else {
                                builder.f23205a = "https";
                                a4 += 6;
                            }
                        } else if (httpUrl2 != null) {
                            return ParseResult.MISSING_SCHEME;
                        } else {
                            builder.f23205a = httpUrl2.f23214a;
                        }
                        i2 = 0;
                        i = a4;
                        while (true) {
                            c = '/';
                            charAt = '\\';
                            if (i < b) {
                                break;
                            }
                            charAt2 = str2.charAt(i);
                            if (charAt2 == '\\' && charAt2 != '/') {
                                break;
                            }
                            i2++;
                            i++;
                        }
                        c2 = '#';
                        if (i2 < 2 && httpUrl2 != null) {
                            if (!httpUrl2.f23214a.equals(builder.f23205a)) {
                                builder.f23206b = httpUrl.m25295c();
                                builder.f23207c = httpUrl.m25296d();
                                builder.f23208d = httpUrl2.f23215b;
                                builder.f23209e = httpUrl2.f23216c;
                                builder.f23210f.clear();
                                builder.f23210f.addAll(httpUrl.m25298f());
                                if (a4 == b || str2.charAt(a4) == '#') {
                                    m25278a(httpUrl.m25299g());
                                }
                                i3 = a4;
                                a = Util.m25354a(str2, i3, b, "?#");
                                m25273b(str2, i3, a);
                                if (a < b && str2.charAt(a) == '?') {
                                    a4 = Util.m25353a(str2, a, b, '#');
                                    builder.f23211g = HttpUrl.m25288b(HttpUrl.m25281a(str2, a + 1, a4, " \"'<>#", true, false, true, true));
                                    a = a4;
                                }
                                if (a < b && str2.charAt(a) == '#') {
                                    builder.f23212h = HttpUrl.m25281a(str2, a + 1, b, "", true, false, false, false);
                                }
                                return ParseResult.SUCCESS;
                            }
                        }
                        i4 = 0;
                        i = a4 + i2;
                        a4 = i4;
                        while (true) {
                            a2 = Util.m25354a(str2, i, b, "@/\\?#");
                            charAt3 = a2 == b ? str2.charAt(a2) : '￿';
                            if (!(charAt3 == '￿' || charAt3 == c2 || charAt3 == r15 || charAt3 == charAt)) {
                                switch (charAt3) {
                                    case '?':
                                        break;
                                    case '@':
                                        if (a4 != 0) {
                                            int a5 = Util.m25353a(str2, i, a2, c4);
                                            i5 = a5;
                                            c = c2;
                                            c3 = charAt;
                                            i3 = a2;
                                            a3 = HttpUrl.m25281a(str2, i, a5, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                                            if (i4 != 0) {
                                                StringBuilder stringBuilder = new StringBuilder();
                                                stringBuilder.append(builder.f23206b);
                                                stringBuilder.append("%40");
                                                stringBuilder.append(a3);
                                                a3 = stringBuilder.toString();
                                            }
                                            builder.f23206b = a3;
                                            if (i5 != i3) {
                                                builder.f23207c = HttpUrl.m25281a(str2, i5 + 1, i3, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                                                a4 = 1;
                                            }
                                            i4 = 1;
                                        } else {
                                            c3 = charAt;
                                            i3 = a2;
                                            StringBuilder stringBuilder2 = new StringBuilder();
                                            stringBuilder2.append(builder.f23207c);
                                            stringBuilder2.append("%40");
                                            stringBuilder2.append(HttpUrl.m25281a(str2, i, i3, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true));
                                            builder.f23207c = stringBuilder2.toString();
                                        }
                                        i = i3 + 1;
                                        charAt = c3;
                                        c2 = '#';
                                        c4 = ':';
                                        c = '/';
                                        continue;
                                        continue;
                                    default:
                                        continue;
                                        continue;
                                }
                            }
                            i3 = a2;
                            a = m25274c(str2, i, i3);
                            i2 = a + 1;
                            if (i2 >= i3) {
                                builder.f23208d = m25272a(str2, i, a);
                                builder.f23209e = m25275d(str2, i2, i3);
                                if (builder.f23209e == -1) {
                                    return ParseResult.INVALID_PORT;
                                }
                            }
                            builder.f23208d = m25272a(str2, i, a);
                            builder.f23209e = HttpUrl.m25280a(builder.f23205a);
                            if (builder.f23208d == null) {
                                return ParseResult.INVALID_HOST;
                            }
                            a = Util.m25354a(str2, i3, b, "?#");
                            m25273b(str2, i3, a);
                            a4 = Util.m25353a(str2, a, b, '#');
                            builder.f23211g = HttpUrl.m25288b(HttpUrl.m25281a(str2, a + 1, a4, " \"'<>#", true, false, true, true));
                            a = a4;
                            builder.f23212h = HttpUrl.m25281a(str2, a + 1, b, "", true, false, false, false);
                            return ParseResult.SUCCESS;
                        }
                    }
                }
            }
            i = -1;
            if (i != -1) {
                if (str2.regionMatches(true, a4, "https:", 0, 6)) {
                    if (str2.regionMatches(true, a4, "http:", 0, 5)) {
                        return ParseResult.UNSUPPORTED_SCHEME;
                    }
                    builder.f23205a = "http";
                    a4 += 5;
                } else {
                    builder.f23205a = "https";
                    a4 += 6;
                }
            } else if (httpUrl2 != null) {
                return ParseResult.MISSING_SCHEME;
            } else {
                builder.f23205a = httpUrl2.f23214a;
            }
            i2 = 0;
            i = a4;
            while (true) {
                c = '/';
                charAt = '\\';
                if (i < b) {
                    break;
                }
                charAt2 = str2.charAt(i);
                if (charAt2 == '\\') {
                }
                i2++;
                i++;
            }
            c2 = '#';
            if (!httpUrl2.f23214a.equals(builder.f23205a)) {
                builder.f23206b = httpUrl.m25295c();
                builder.f23207c = httpUrl.m25296d();
                builder.f23208d = httpUrl2.f23215b;
                builder.f23209e = httpUrl2.f23216c;
                builder.f23210f.clear();
                builder.f23210f.addAll(httpUrl.m25298f());
                m25278a(httpUrl.m25299g());
                i3 = a4;
                a = Util.m25354a(str2, i3, b, "?#");
                m25273b(str2, i3, a);
                a4 = Util.m25353a(str2, a, b, '#');
                builder.f23211g = HttpUrl.m25288b(HttpUrl.m25281a(str2, a + 1, a4, " \"'<>#", true, false, true, true));
                a = a4;
                builder.f23212h = HttpUrl.m25281a(str2, a + 1, b, "", true, false, false, false);
                return ParseResult.SUCCESS;
            }
            i4 = 0;
            i = a4 + i2;
            a4 = i4;
            while (true) {
                a2 = Util.m25354a(str2, i, b, "@/\\?#");
                if (a2 == b) {
                }
                switch (charAt3) {
                    case '?':
                        break;
                    case '@':
                        if (a4 != 0) {
                            c3 = charAt;
                            i3 = a2;
                            StringBuilder stringBuilder22 = new StringBuilder();
                            stringBuilder22.append(builder.f23207c);
                            stringBuilder22.append("%40");
                            stringBuilder22.append(HttpUrl.m25281a(str2, i, i3, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true));
                            builder.f23207c = stringBuilder22.toString();
                        } else {
                            int a52 = Util.m25353a(str2, i, a2, c4);
                            i5 = a52;
                            c = c2;
                            c3 = charAt;
                            i3 = a2;
                            a3 = HttpUrl.m25281a(str2, i, a52, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                            if (i4 != 0) {
                                StringBuilder stringBuilder3 = new StringBuilder();
                                stringBuilder3.append(builder.f23206b);
                                stringBuilder3.append("%40");
                                stringBuilder3.append(a3);
                                a3 = stringBuilder3.toString();
                            }
                            builder.f23206b = a3;
                            if (i5 != i3) {
                                builder.f23207c = HttpUrl.m25281a(str2, i5 + 1, i3, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                                a4 = 1;
                            }
                            i4 = 1;
                        }
                        i = i3 + 1;
                        charAt = c3;
                        c2 = '#';
                        c4 = ':';
                        c = '/';
                        continue;
                        continue;
                    default:
                        continue;
                        continue;
                }
                i3 = a2;
                a = m25274c(str2, i, i3);
                i2 = a + 1;
                if (i2 >= i3) {
                    builder.f23208d = m25272a(str2, i, a);
                    builder.f23209e = HttpUrl.m25280a(builder.f23205a);
                } else {
                    builder.f23208d = m25272a(str2, i, a);
                    builder.f23209e = m25275d(str2, i2, i3);
                    if (builder.f23209e == -1) {
                        return ParseResult.INVALID_PORT;
                    }
                }
                if (builder.f23208d == null) {
                    return ParseResult.INVALID_HOST;
                }
                a = Util.m25354a(str2, i3, b, "?#");
                m25273b(str2, i3, a);
                a4 = Util.m25353a(str2, a, b, '#');
                builder.f23211g = HttpUrl.m25288b(HttpUrl.m25281a(str2, a + 1, a4, " \"'<>#", true, false, true, true));
                a = a4;
                builder.f23212h = HttpUrl.m25281a(str2, a + 1, b, "", true, false, false, false);
                return ParseResult.SUCCESS;
            }
        }

        private void m25273b(String str, int i, int i2) {
            if (i != i2) {
                int i3;
                int i4;
                int i5;
                String a;
                char charAt = str.charAt(i);
                if (charAt != '/') {
                    if (charAt != '\\') {
                        this.f23210f.set(this.f23210f.size() - 1, "");
                        while (true) {
                            i3 = i;
                            if (i3 < i2) {
                                i = Util.m25354a(str, i3, i2, "/\\");
                                i4 = 0;
                                i5 = i >= i2 ? 1 : 0;
                                a = HttpUrl.m25281a(str, i3, i, " \"<>^`{}|/\\?#", true, false, false, true);
                                if (!a.equals(".")) {
                                    if (a.equalsIgnoreCase("%2e")) {
                                        i3 = 0;
                                        if (i3 == 0) {
                                            if (a.equals("..") || a.equalsIgnoreCase("%2e.") || a.equalsIgnoreCase(".%2e") || a.equalsIgnoreCase("%2e%2e")) {
                                                i4 = 1;
                                            }
                                            if (i4 != 0) {
                                                if (((String) this.f23210f.get(this.f23210f.size() - 1)).isEmpty()) {
                                                    this.f23210f.add(a);
                                                } else {
                                                    this.f23210f.set(this.f23210f.size() - 1, a);
                                                }
                                                if (i5 != 0) {
                                                    this.f23210f.add("");
                                                }
                                            } else if (((String) this.f23210f.remove(this.f23210f.size() - 1)).isEmpty() || this.f23210f.isEmpty()) {
                                                this.f23210f.add("");
                                            } else {
                                                this.f23210f.set(this.f23210f.size() - 1, "");
                                            }
                                        }
                                        if (i5 == 0) {
                                            i++;
                                        }
                                    }
                                }
                                i3 = 1;
                                if (i3 == 0) {
                                    i4 = 1;
                                    if (i4 != 0) {
                                        if (((String) this.f23210f.get(this.f23210f.size() - 1)).isEmpty()) {
                                            this.f23210f.add(a);
                                        } else {
                                            this.f23210f.set(this.f23210f.size() - 1, a);
                                        }
                                        if (i5 != 0) {
                                            this.f23210f.add("");
                                        }
                                    } else {
                                        if (((String) this.f23210f.remove(this.f23210f.size() - 1)).isEmpty()) {
                                        }
                                        this.f23210f.add("");
                                    }
                                }
                                if (i5 == 0) {
                                    i++;
                                }
                            } else {
                                return;
                            }
                        }
                    }
                }
                this.f23210f.clear();
                this.f23210f.add("");
                i++;
                while (true) {
                    i3 = i;
                    if (i3 < i2) {
                        i = Util.m25354a(str, i3, i2, "/\\");
                        i4 = 0;
                        if (i >= i2) {
                        }
                        a = HttpUrl.m25281a(str, i3, i, " \"<>^`{}|/\\?#", true, false, false, true);
                        if (a.equals(".")) {
                            if (a.equalsIgnoreCase("%2e")) {
                                i3 = 0;
                                if (i3 == 0) {
                                    i4 = 1;
                                    if (i4 != 0) {
                                        if (((String) this.f23210f.remove(this.f23210f.size() - 1)).isEmpty()) {
                                        }
                                        this.f23210f.add("");
                                    } else {
                                        if (((String) this.f23210f.get(this.f23210f.size() - 1)).isEmpty()) {
                                            this.f23210f.set(this.f23210f.size() - 1, a);
                                        } else {
                                            this.f23210f.add(a);
                                        }
                                        if (i5 != 0) {
                                            this.f23210f.add("");
                                        }
                                    }
                                }
                                if (i5 == 0) {
                                    i++;
                                }
                            }
                        }
                        i3 = 1;
                        if (i3 == 0) {
                            i4 = 1;
                            if (i4 != 0) {
                                if (((String) this.f23210f.get(this.f23210f.size() - 1)).isEmpty()) {
                                    this.f23210f.add(a);
                                } else {
                                    this.f23210f.set(this.f23210f.size() - 1, a);
                                }
                                if (i5 != 0) {
                                    this.f23210f.add("");
                                }
                            } else {
                                if (((String) this.f23210f.remove(this.f23210f.size() - 1)).isEmpty()) {
                                }
                                this.f23210f.add("");
                            }
                        }
                        if (i5 == 0) {
                            i++;
                        }
                    } else {
                        return;
                    }
                }
            }
        }

        private static int m25274c(String str, int i, int i2) {
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt == ':') {
                    return i;
                }
                if (charAt == '[') {
                    do {
                        i++;
                        if (i >= i2) {
                            break;
                        }
                    } while (str.charAt(i) != ']');
                }
                i++;
            }
            return i2;
        }

        static String m25272a(String str, int i, int i2) {
            return Util.m25359a(HttpUrl.m25282a(str, i, i2, false));
        }

        private static int m25275d(java.lang.String r9, int r10, int r11) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r0 = -1;
            r4 = "";	 Catch:{ NumberFormatException -> 0x001b }
            r5 = 0;	 Catch:{ NumberFormatException -> 0x001b }
            r6 = 0;	 Catch:{ NumberFormatException -> 0x001b }
            r7 = 0;	 Catch:{ NumberFormatException -> 0x001b }
            r8 = 1;	 Catch:{ NumberFormatException -> 0x001b }
            r1 = r9;	 Catch:{ NumberFormatException -> 0x001b }
            r2 = r10;	 Catch:{ NumberFormatException -> 0x001b }
            r3 = r11;	 Catch:{ NumberFormatException -> 0x001b }
            r9 = com.sendbird.android.shadow.okhttp3.HttpUrl.m25281a(r1, r2, r3, r4, r5, r6, r7, r8);	 Catch:{ NumberFormatException -> 0x001b }
            r9 = java.lang.Integer.parseInt(r9);	 Catch:{ NumberFormatException -> 0x001b }
            if (r9 <= 0) goto L_0x001a;
        L_0x0014:
            r10 = 65535; // 0xffff float:9.1834E-41 double:3.23786E-319;
            if (r9 > r10) goto L_0x001a;
        L_0x0019:
            return r9;
        L_0x001a:
            return r0;
        L_0x001b:
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.okhttp3.HttpUrl.Builder.d(java.lang.String, int, int):int");
        }
    }

    HttpUrl(Builder builder) {
        this.f23214a = builder.f23205a;
        this.f23218f = m25284a(builder.f23206b, false);
        this.f23219g = m25284a(builder.f23207c, false);
        this.f23215b = builder.f23208d;
        this.f23216c = builder.m25276a();
        this.f23220h = m25285a(builder.f23210f, false);
        String str = null;
        this.f23217d = builder.f23211g != null ? m25285a(builder.f23211g, true) : null;
        if (builder.f23212h != null) {
            str = m25284a(builder.f23212h, false);
        }
        this.f23221i = str;
        this.f23222j = builder.toString();
    }

    public final boolean m25293b() {
        return this.f23214a.equals("https");
    }

    public final String m25295c() {
        if (this.f23218f.isEmpty()) {
            return "";
        }
        int length = this.f23214a.length() + 3;
        return this.f23222j.substring(length, Util.m25354a(this.f23222j, length, this.f23222j.length(), ":@"));
    }

    public final String m25296d() {
        if (this.f23219g.isEmpty()) {
            return "";
        }
        return this.f23222j.substring(this.f23222j.indexOf(58, this.f23214a.length() + 3) + 1, this.f23222j.indexOf(64));
    }

    public static int m25280a(String str) {
        if (str.equals("http")) {
            return 80;
        }
        return str.equals("https") != null ? MPSUtils.SYSTEM : -1;
    }

    public final String m25297e() {
        int indexOf = this.f23222j.indexOf(47, this.f23214a.length() + 3);
        return this.f23222j.substring(indexOf, Util.m25354a(this.f23222j, indexOf, this.f23222j.length(), "?#"));
    }

    static void m25286a(StringBuilder stringBuilder, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            stringBuilder.append('/');
            stringBuilder.append((String) list.get(i));
        }
    }

    public final List<String> m25298f() {
        int indexOf = this.f23222j.indexOf(47, this.f23214a.length() + 3);
        int a = Util.m25354a(this.f23222j, indexOf, this.f23222j.length(), "?#");
        List<String> arrayList = new ArrayList();
        while (indexOf < a) {
            indexOf++;
            int a2 = Util.m25353a(this.f23222j, indexOf, a, '/');
            arrayList.add(this.f23222j.substring(indexOf, a2));
            indexOf = a2;
        }
        return arrayList;
    }

    public final String m25299g() {
        if (this.f23217d == null) {
            return null;
        }
        int indexOf = this.f23222j.indexOf(63) + 1;
        return this.f23222j.substring(indexOf, Util.m25353a(this.f23222j, indexOf, this.f23222j.length(), '#'));
    }

    public static void m25289b(StringBuilder stringBuilder, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            String str = (String) list.get(i);
            String str2 = (String) list.get(i + 1);
            if (i > 0) {
                stringBuilder.append('&');
            }
            stringBuilder.append(str);
            if (str2 != null) {
                stringBuilder.append('=');
                stringBuilder.append(str2);
            }
        }
    }

    static List<String> m25288b(String str) {
        List<String> arrayList = new ArrayList();
        int i = 0;
        while (i <= str.length()) {
            int indexOf = str.indexOf(38, i);
            if (indexOf == -1) {
                indexOf = str.length();
            }
            int indexOf2 = str.indexOf(61, i);
            if (indexOf2 != -1) {
                if (indexOf2 <= indexOf) {
                    arrayList.add(str.substring(i, indexOf2));
                    arrayList.add(str.substring(indexOf2 + 1, indexOf));
                    i = indexOf + 1;
                }
            }
            arrayList.add(str.substring(i, indexOf));
            arrayList.add(null);
            i = indexOf + 1;
        }
        return arrayList;
    }

    public final String m25300h() {
        Builder c = m25294c("/...");
        c.f23206b = m25283a("", " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
        c.f23207c = m25283a("", " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
        return c.m25279b().toString();
    }

    public final Builder m25294c(String str) {
        Builder builder = new Builder();
        return builder.m25277a(this, str) == ParseResult.SUCCESS ? builder : null;
    }

    public static HttpUrl m25290d(String str) {
        Builder builder = new Builder();
        if (builder.m25277a(null, str) == ParseResult.SUCCESS) {
            return builder.m25279b();
        }
        return null;
    }

    static HttpUrl m25291e(String str) throws MalformedURLException, UnknownHostException {
        Builder builder = new Builder();
        ParseResult a = builder.m25277a(null, str);
        switch (a) {
            case SUCCESS:
                return builder.m25279b();
            case INVALID_HOST:
                StringBuilder stringBuilder = new StringBuilder("Invalid host: ");
                stringBuilder.append(str);
                throw new UnknownHostException(stringBuilder.toString());
            default:
                StringBuilder stringBuilder2 = new StringBuilder("Invalid URL: ");
                stringBuilder2.append(a);
                stringBuilder2.append(" for ");
                stringBuilder2.append(str);
                throw new MalformedURLException(stringBuilder2.toString());
        }
    }

    public final boolean equals(Object obj) {
        return (!(obj instanceof HttpUrl) || ((HttpUrl) obj).f23222j.equals(this.f23222j) == null) ? null : true;
    }

    public final int hashCode() {
        return this.f23222j.hashCode();
    }

    public final String toString() {
        return this.f23222j;
    }

    private static String m25284a(String str, boolean z) {
        return m25282a(str, 0, str.length(), z);
    }

    private static List<String> m25285a(List<String> list, boolean z) {
        int size = list.size();
        List arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            String str = (String) list.get(i);
            arrayList.add(str != null ? m25284a(str, z) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    static String m25282a(String str, int i, int i2, boolean z) {
        int i3 = i;
        while (i3 < i2) {
            char charAt = str.charAt(i3);
            if (charAt != '%') {
                if (charAt != '+' || !z) {
                    i3++;
                }
            }
            Buffer buffer = new Buffer();
            buffer.m35456a(str, i, i3);
            while (i3 < i2) {
                i = str.codePointAt(i3);
                if (i == 37) {
                    int i4 = i3 + 2;
                    if (i4 < i2) {
                        int a = Util.m25351a(str.charAt(i3 + 1));
                        int a2 = Util.m25351a(str.charAt(i4));
                        if (!(a == -1 || a2 == -1)) {
                            buffer.m35463b((a << 4) + a2);
                            i3 = i4;
                            i3 += Character.charCount(i);
                        }
                        buffer.m35452a(i);
                        i3 += Character.charCount(i);
                    }
                }
                if (i == 43 && z) {
                    buffer.m35463b(32);
                    i3 += Character.charCount(i);
                }
                buffer.m35452a(i);
                i3 += Character.charCount(i);
            }
            return buffer.m35501o();
        }
        return str.substring(i, i2);
    }

    private static boolean m25287a(String str, int i, int i2) {
        int i3 = i + 2;
        if (i3 >= i2 || str.charAt(i) != 37 || Util.m25351a(str.charAt(i + 1)) == -1 || Util.m25351a(str.charAt(i3)) == -1) {
            return null;
        }
        return true;
    }

    static String m25281a(String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        String str3 = str;
        int i3 = i2;
        String str4 = str2;
        int i4 = i;
        while (i4 < i3) {
            int codePointAt = str3.codePointAt(i4);
            int i5 = 43;
            if (codePointAt >= 32 && codePointAt != 127 && ((codePointAt < 128 || !z4) && str4.indexOf(codePointAt) == -1 && (codePointAt != 37 || (z && (!z2 || m25287a(str3, i4, i3)))))) {
                if (codePointAt != 43 || !z3) {
                    i4 += Character.charCount(codePointAt);
                }
            }
            Buffer buffer = new Buffer();
            buffer.m35456a(str3, i, i4);
            Buffer buffer2 = null;
            while (i4 < i3) {
                int codePointAt2 = str3.codePointAt(i4);
                if (z) {
                    if (!(codePointAt2 == 9 || codePointAt2 == 10 || codePointAt2 == 12 || codePointAt2 == 13)) {
                    }
                    i4 += Character.charCount(codePointAt2);
                    i5 = 43;
                }
                if (codePointAt2 == i5 && z3) {
                    buffer.m35455a(z ? Operation.PLUS : "%2B");
                    i4 += Character.charCount(codePointAt2);
                    i5 = 43;
                } else {
                    if (codePointAt2 >= 32 && codePointAt2 != 127 && (codePointAt2 < 128 || !z4)) {
                        if (str4.indexOf(codePointAt2) == -1) {
                            if (codePointAt2 == 37) {
                                if (z) {
                                    if (z2 && !m25287a(str3, i4, i3)) {
                                    }
                                }
                            }
                            buffer.m35452a(codePointAt2);
                            i4 += Character.charCount(codePointAt2);
                            i5 = 43;
                        }
                    }
                    if (buffer2 == null) {
                        buffer2 = new Buffer();
                    }
                    buffer2.m35452a(codePointAt2);
                    while (!buffer2.mo6562d()) {
                        int f = buffer2.mo6563f() & 255;
                        buffer.m35463b(37);
                        buffer.m35463b(f23213e[(f >> 4) & 15]);
                        buffer.m35463b(f23213e[f & 15]);
                    }
                    i4 += Character.charCount(codePointAt2);
                    i5 = 43;
                }
            }
            return buffer.m35501o();
        }
        int i6 = i;
        return str.substring(i, i2);
    }

    static String m25283a(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        return m25281a(str, 0, str.length(), str2, z, z2, z3, z4);
    }

    public final java.net.URI m25292a() {
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
        r11 = this;
        r0 = new com.sendbird.android.shadow.okhttp3.HttpUrl$Builder;
        r0.<init>();
        r1 = r11.f23214a;
        r0.f23205a = r1;
        r1 = r11.m25295c();
        r0.f23206b = r1;
        r1 = r11.m25296d();
        r0.f23207c = r1;
        r1 = r11.f23215b;
        r0.f23208d = r1;
        r1 = r11.f23216c;
        r2 = r11.f23214a;
        r2 = m25280a(r2);
        if (r1 == r2) goto L_0x0026;
    L_0x0023:
        r1 = r11.f23216c;
        goto L_0x0027;
    L_0x0026:
        r1 = -1;
    L_0x0027:
        r0.f23209e = r1;
        r1 = r0.f23210f;
        r1.clear();
        r1 = r0.f23210f;
        r2 = r11.m25298f();
        r1.addAll(r2);
        r1 = r11.m25299g();
        r0.m25278a(r1);
        r1 = r11.f23221i;
        if (r1 != 0) goto L_0x0044;
    L_0x0042:
        r1 = 0;
        goto L_0x0054;
    L_0x0044:
        r1 = r11.f23222j;
        r2 = 35;
        r1 = r1.indexOf(r2);
        r1 = r1 + 1;
        r2 = r11.f23222j;
        r1 = r2.substring(r1);
    L_0x0054:
        r0.f23212h = r1;
        r1 = r0.f23210f;
        r1 = r1.size();
        r2 = 0;
        r3 = r2;
    L_0x005e:
        if (r3 >= r1) goto L_0x007b;
    L_0x0060:
        r4 = r0.f23210f;
        r4 = r4.get(r3);
        r5 = r4;
        r5 = (java.lang.String) r5;
        r4 = r0.f23210f;
        r6 = "[]";
        r7 = 1;
        r8 = 1;
        r9 = 0;
        r10 = 1;
        r5 = m25283a(r5, r6, r7, r8, r9, r10);
        r4.set(r3, r5);
        r3 = r3 + 1;
        goto L_0x005e;
    L_0x007b:
        r1 = r0.f23211g;
        if (r1 == 0) goto L_0x00a4;
    L_0x007f:
        r1 = r0.f23211g;
        r1 = r1.size();
    L_0x0085:
        if (r2 >= r1) goto L_0x00a4;
    L_0x0087:
        r3 = r0.f23211g;
        r3 = r3.get(r2);
        r4 = r3;
        r4 = (java.lang.String) r4;
        if (r4 == 0) goto L_0x00a1;
    L_0x0092:
        r3 = r0.f23211g;
        r5 = "\\^`{|}";
        r6 = 1;
        r7 = 1;
        r8 = 1;
        r9 = 1;
        r4 = m25283a(r4, r5, r6, r7, r8, r9);
        r3.set(r2, r4);
    L_0x00a1:
        r2 = r2 + 1;
        goto L_0x0085;
    L_0x00a4:
        r1 = r0.f23212h;
        if (r1 == 0) goto L_0x00b6;
    L_0x00a8:
        r2 = r0.f23212h;
        r3 = " \"#<>\\^`{|}";
        r4 = 1;
        r5 = 1;
        r6 = 0;
        r7 = 0;
        r1 = m25283a(r2, r3, r4, r5, r6, r7);
        r0.f23212h = r1;
    L_0x00b6:
        r0 = r0.toString();
        r1 = new java.net.URI;	 Catch:{ URISyntaxException -> 0x00c0 }
        r1.<init>(r0);	 Catch:{ URISyntaxException -> 0x00c0 }
        return r1;
    L_0x00c0:
        r1 = move-exception;
        r2 = "[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]";	 Catch:{ Exception -> 0x00ce }
        r3 = "";	 Catch:{ Exception -> 0x00ce }
        r0 = r0.replaceAll(r2, r3);	 Catch:{ Exception -> 0x00ce }
        r0 = java.net.URI.create(r0);	 Catch:{ Exception -> 0x00ce }
        return r0;
    L_0x00ce:
        r0 = new java.lang.RuntimeException;
        r0.<init>(r1);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.okhttp3.HttpUrl.a():java.net.URI");
    }
}
