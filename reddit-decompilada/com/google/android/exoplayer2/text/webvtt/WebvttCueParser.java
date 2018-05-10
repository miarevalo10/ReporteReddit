package com.google.android.exoplayer2.text.webvtt;

import android.util.Log;
import com.google.android.exoplayer2.text.webvtt.WebvttCue.Builder;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class WebvttCueParser {
    public static final Pattern f5118a = Pattern.compile("^(\\S+)\\s+-->\\s+(\\S+)(.*)?$");
    private static final Pattern f5119b = Pattern.compile("(\\S+?):(\\S+)");
    private final StringBuilder f5120c = new StringBuilder();

    private static final class StartTag {
        private static final String[] f5111e = new String[0];
        public final String f5112a;
        public final int f5113b;
        public final String f5114c;
        public final String[] f5115d;

        private StartTag(String str, int i, String str2, String[] strArr) {
            this.f5113b = i;
            this.f5112a = str;
            this.f5114c = str2;
            this.f5115d = strArr;
        }

        public static StartTag m4106a(String str, int i) {
            str = str.trim();
            if (str.isEmpty()) {
                return null;
            }
            String str2;
            String trim;
            int indexOf = str.indexOf(" ");
            if (indexOf == -1) {
                str2 = "";
            } else {
                trim = str.substring(indexOf).trim();
                str = str.substring(0, indexOf);
                str2 = trim;
            }
            str = str.split("\\.");
            trim = str[0];
            if (str.length > 1) {
                str = (String[]) Arrays.copyOfRange(str, 1, str.length);
            } else {
                str = f5111e;
            }
            return new StartTag(trim, i, str2, str);
        }

        public static StartTag m4105a() {
            return new StartTag("", 0, "", new String[0]);
        }
    }

    private static final class StyleMatch implements Comparable<StyleMatch> {
        public final int f5116a;
        public final WebvttCssStyle f5117b;

        public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return this.f5116a - ((StyleMatch) obj).f5116a;
        }

        public StyleMatch(int i, WebvttCssStyle webvttCssStyle) {
            this.f5116a = i;
            this.f5117b = webvttCssStyle;
        }
    }

    final boolean m4113a(ParsableByteArray parsableByteArray, Builder builder, List<WebvttCssStyle> list) {
        Object r = parsableByteArray.m4267r();
        if (r == null) {
            return false;
        }
        Matcher matcher = f5118a.matcher(r);
        if (matcher.matches()) {
            return m4112a(null, matcher, parsableByteArray, builder, this.f5120c, list);
        }
        CharSequence r2 = parsableByteArray.m4267r();
        if (r2 == null) {
            return false;
        }
        Matcher matcher2 = f5118a.matcher(r2);
        if (!matcher2.matches()) {
            return false;
        }
        return m4112a(r.trim(), matcher2, parsableByteArray, builder, this.f5120c, list);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void m4108a(java.lang.String r9, com.google.android.exoplayer2.text.webvtt.WebvttCue.Builder r10) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f5119b;
        r9 = r0.matcher(r9);
    L_0x0006:
        r0 = r9.find();
        if (r0 == 0) goto L_0x013c;
    L_0x000c:
        r0 = 1;
        r1 = r9.group(r0);
        r2 = 2;
        r3 = r9.group(r2);
        r4 = "line";	 Catch:{ NumberFormatException -> 0x0123 }
        r4 = r4.equals(r1);	 Catch:{ NumberFormatException -> 0x0123 }
        r5 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;	 Catch:{ NumberFormatException -> 0x0123 }
        r6 = 44;	 Catch:{ NumberFormatException -> 0x0123 }
        r7 = 0;	 Catch:{ NumberFormatException -> 0x0123 }
        r8 = -1;	 Catch:{ NumberFormatException -> 0x0123 }
        if (r4 == 0) goto L_0x005c;	 Catch:{ NumberFormatException -> 0x0123 }
    L_0x0024:
        r1 = r3.indexOf(r6);	 Catch:{ NumberFormatException -> 0x0123 }
        if (r1 == r8) goto L_0x003b;	 Catch:{ NumberFormatException -> 0x0123 }
    L_0x002a:
        r2 = r1 + 1;	 Catch:{ NumberFormatException -> 0x0123 }
        r2 = r3.substring(r2);	 Catch:{ NumberFormatException -> 0x0123 }
        r2 = m4107a(r2);	 Catch:{ NumberFormatException -> 0x0123 }
        r10.f5107g = r2;	 Catch:{ NumberFormatException -> 0x0123 }
        r3 = r3.substring(r7, r1);	 Catch:{ NumberFormatException -> 0x0123 }
        goto L_0x003d;	 Catch:{ NumberFormatException -> 0x0123 }
    L_0x003b:
        r10.f5107g = r5;	 Catch:{ NumberFormatException -> 0x0123 }
    L_0x003d:
        r1 = "%";	 Catch:{ NumberFormatException -> 0x0123 }
        r1 = r3.endsWith(r1);	 Catch:{ NumberFormatException -> 0x0123 }
        if (r1 == 0) goto L_0x004e;	 Catch:{ NumberFormatException -> 0x0123 }
    L_0x0045:
        r0 = com.google.android.exoplayer2.text.webvtt.WebvttParserUtil.m4116b(r3);	 Catch:{ NumberFormatException -> 0x0123 }
        r10.f5105e = r0;	 Catch:{ NumberFormatException -> 0x0123 }
        r10.f5106f = r7;	 Catch:{ NumberFormatException -> 0x0123 }
        goto L_0x0006;	 Catch:{ NumberFormatException -> 0x0123 }
    L_0x004e:
        r1 = java.lang.Integer.parseInt(r3);	 Catch:{ NumberFormatException -> 0x0123 }
        if (r1 >= 0) goto L_0x0056;	 Catch:{ NumberFormatException -> 0x0123 }
    L_0x0054:
        r1 = r1 + -1;	 Catch:{ NumberFormatException -> 0x0123 }
    L_0x0056:
        r1 = (float) r1;	 Catch:{ NumberFormatException -> 0x0123 }
        r10.f5105e = r1;	 Catch:{ NumberFormatException -> 0x0123 }
        r10.f5106f = r0;	 Catch:{ NumberFormatException -> 0x0123 }
        goto L_0x0006;	 Catch:{ NumberFormatException -> 0x0123 }
    L_0x005c:
        r4 = "align";	 Catch:{ NumberFormatException -> 0x0123 }
        r4 = r4.equals(r1);	 Catch:{ NumberFormatException -> 0x0123 }
        if (r4 == 0) goto L_0x00cd;	 Catch:{ NumberFormatException -> 0x0123 }
    L_0x0064:
        r1 = r3.hashCode();	 Catch:{ NumberFormatException -> 0x0123 }
        switch(r1) {
            case -1364013995: goto L_0x009d;
            case -1074341483: goto L_0x0093;
            case 100571: goto L_0x0089;
            case 3317767: goto L_0x0080;
            case 108511772: goto L_0x0076;
            case 109757538: goto L_0x006c;
            default: goto L_0x006b;
        };	 Catch:{ NumberFormatException -> 0x0123 }
    L_0x006b:
        goto L_0x00a7;	 Catch:{ NumberFormatException -> 0x0123 }
    L_0x006c:
        r0 = "start";	 Catch:{ NumberFormatException -> 0x0123 }
        r0 = r3.equals(r0);	 Catch:{ NumberFormatException -> 0x0123 }
        if (r0 == 0) goto L_0x00a7;	 Catch:{ NumberFormatException -> 0x0123 }
    L_0x0074:
        r0 = r7;	 Catch:{ NumberFormatException -> 0x0123 }
        goto L_0x00a8;	 Catch:{ NumberFormatException -> 0x0123 }
    L_0x0076:
        r0 = "right";	 Catch:{ NumberFormatException -> 0x0123 }
        r0 = r3.equals(r0);	 Catch:{ NumberFormatException -> 0x0123 }
        if (r0 == 0) goto L_0x00a7;	 Catch:{ NumberFormatException -> 0x0123 }
    L_0x007e:
        r0 = 5;	 Catch:{ NumberFormatException -> 0x0123 }
        goto L_0x00a8;	 Catch:{ NumberFormatException -> 0x0123 }
    L_0x0080:
        r1 = "left";	 Catch:{ NumberFormatException -> 0x0123 }
        r1 = r3.equals(r1);	 Catch:{ NumberFormatException -> 0x0123 }
        if (r1 == 0) goto L_0x00a7;	 Catch:{ NumberFormatException -> 0x0123 }
    L_0x0088:
        goto L_0x00a8;	 Catch:{ NumberFormatException -> 0x0123 }
    L_0x0089:
        r0 = "end";	 Catch:{ NumberFormatException -> 0x0123 }
        r0 = r3.equals(r0);	 Catch:{ NumberFormatException -> 0x0123 }
        if (r0 == 0) goto L_0x00a7;	 Catch:{ NumberFormatException -> 0x0123 }
    L_0x0091:
        r0 = 4;	 Catch:{ NumberFormatException -> 0x0123 }
        goto L_0x00a8;	 Catch:{ NumberFormatException -> 0x0123 }
    L_0x0093:
        r0 = "middle";	 Catch:{ NumberFormatException -> 0x0123 }
        r0 = r3.equals(r0);	 Catch:{ NumberFormatException -> 0x0123 }
        if (r0 == 0) goto L_0x00a7;	 Catch:{ NumberFormatException -> 0x0123 }
    L_0x009b:
        r0 = 3;	 Catch:{ NumberFormatException -> 0x0123 }
        goto L_0x00a8;	 Catch:{ NumberFormatException -> 0x0123 }
    L_0x009d:
        r0 = "center";	 Catch:{ NumberFormatException -> 0x0123 }
        r0 = r3.equals(r0);	 Catch:{ NumberFormatException -> 0x0123 }
        if (r0 == 0) goto L_0x00a7;	 Catch:{ NumberFormatException -> 0x0123 }
    L_0x00a5:
        r0 = r2;	 Catch:{ NumberFormatException -> 0x0123 }
        goto L_0x00a8;	 Catch:{ NumberFormatException -> 0x0123 }
    L_0x00a7:
        r0 = r8;	 Catch:{ NumberFormatException -> 0x0123 }
    L_0x00a8:
        switch(r0) {
            case 0: goto L_0x00b4;
            case 1: goto L_0x00b4;
            case 2: goto L_0x00b1;
            case 3: goto L_0x00b1;
            case 4: goto L_0x00ae;
            case 5: goto L_0x00ae;
            default: goto L_0x00ab;
        };	 Catch:{ NumberFormatException -> 0x0123 }
    L_0x00ab:
        r0 = "WebvttCueParser";	 Catch:{ NumberFormatException -> 0x0123 }
        goto L_0x00b7;	 Catch:{ NumberFormatException -> 0x0123 }
    L_0x00ae:
        r0 = android.text.Layout.Alignment.ALIGN_OPPOSITE;	 Catch:{ NumberFormatException -> 0x0123 }
        goto L_0x00c9;	 Catch:{ NumberFormatException -> 0x0123 }
    L_0x00b1:
        r0 = android.text.Layout.Alignment.ALIGN_CENTER;	 Catch:{ NumberFormatException -> 0x0123 }
        goto L_0x00c9;	 Catch:{ NumberFormatException -> 0x0123 }
    L_0x00b4:
        r0 = android.text.Layout.Alignment.ALIGN_NORMAL;	 Catch:{ NumberFormatException -> 0x0123 }
        goto L_0x00c9;	 Catch:{ NumberFormatException -> 0x0123 }
    L_0x00b7:
        r1 = new java.lang.StringBuilder;	 Catch:{ NumberFormatException -> 0x0123 }
        r2 = "Invalid alignment value: ";	 Catch:{ NumberFormatException -> 0x0123 }
        r1.<init>(r2);	 Catch:{ NumberFormatException -> 0x0123 }
        r1.append(r3);	 Catch:{ NumberFormatException -> 0x0123 }
        r1 = r1.toString();	 Catch:{ NumberFormatException -> 0x0123 }
        android.util.Log.w(r0, r1);	 Catch:{ NumberFormatException -> 0x0123 }
        r0 = 0;	 Catch:{ NumberFormatException -> 0x0123 }
    L_0x00c9:
        r10.f5104d = r0;	 Catch:{ NumberFormatException -> 0x0123 }
        goto L_0x0006;	 Catch:{ NumberFormatException -> 0x0123 }
    L_0x00cd:
        r0 = "position";	 Catch:{ NumberFormatException -> 0x0123 }
        r0 = r0.equals(r1);	 Catch:{ NumberFormatException -> 0x0123 }
        if (r0 == 0) goto L_0x00f6;	 Catch:{ NumberFormatException -> 0x0123 }
    L_0x00d5:
        r0 = r3.indexOf(r6);	 Catch:{ NumberFormatException -> 0x0123 }
        if (r0 == r8) goto L_0x00ec;	 Catch:{ NumberFormatException -> 0x0123 }
    L_0x00db:
        r1 = r0 + 1;	 Catch:{ NumberFormatException -> 0x0123 }
        r1 = r3.substring(r1);	 Catch:{ NumberFormatException -> 0x0123 }
        r1 = m4107a(r1);	 Catch:{ NumberFormatException -> 0x0123 }
        r10.f5109i = r1;	 Catch:{ NumberFormatException -> 0x0123 }
        r3 = r3.substring(r7, r0);	 Catch:{ NumberFormatException -> 0x0123 }
        goto L_0x00ee;	 Catch:{ NumberFormatException -> 0x0123 }
    L_0x00ec:
        r10.f5109i = r5;	 Catch:{ NumberFormatException -> 0x0123 }
    L_0x00ee:
        r0 = com.google.android.exoplayer2.text.webvtt.WebvttParserUtil.m4116b(r3);	 Catch:{ NumberFormatException -> 0x0123 }
        r10.f5108h = r0;	 Catch:{ NumberFormatException -> 0x0123 }
        goto L_0x0006;	 Catch:{ NumberFormatException -> 0x0123 }
    L_0x00f6:
        r0 = "size";	 Catch:{ NumberFormatException -> 0x0123 }
        r0 = r0.equals(r1);	 Catch:{ NumberFormatException -> 0x0123 }
        if (r0 == 0) goto L_0x0106;	 Catch:{ NumberFormatException -> 0x0123 }
    L_0x00fe:
        r0 = com.google.android.exoplayer2.text.webvtt.WebvttParserUtil.m4116b(r3);	 Catch:{ NumberFormatException -> 0x0123 }
        r10.f5110j = r0;	 Catch:{ NumberFormatException -> 0x0123 }
        goto L_0x0006;	 Catch:{ NumberFormatException -> 0x0123 }
    L_0x0106:
        r0 = "WebvttCueParser";	 Catch:{ NumberFormatException -> 0x0123 }
        r2 = new java.lang.StringBuilder;	 Catch:{ NumberFormatException -> 0x0123 }
        r4 = "Unknown cue setting ";	 Catch:{ NumberFormatException -> 0x0123 }
        r2.<init>(r4);	 Catch:{ NumberFormatException -> 0x0123 }
        r2.append(r1);	 Catch:{ NumberFormatException -> 0x0123 }
        r1 = ":";	 Catch:{ NumberFormatException -> 0x0123 }
        r2.append(r1);	 Catch:{ NumberFormatException -> 0x0123 }
        r2.append(r3);	 Catch:{ NumberFormatException -> 0x0123 }
        r1 = r2.toString();	 Catch:{ NumberFormatException -> 0x0123 }
        android.util.Log.w(r0, r1);	 Catch:{ NumberFormatException -> 0x0123 }
        goto L_0x0006;
    L_0x0123:
        r0 = "WebvttCueParser";
        r1 = new java.lang.StringBuilder;
        r2 = "Skipping bad cue setting: ";
        r1.<init>(r2);
        r2 = r9.group();
        r1.append(r2);
        r1 = r1.toString();
        android.util.Log.w(r0, r1);
        goto L_0x0006;
    L_0x013c:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.text.webvtt.WebvttCueParser.a(java.lang.String, com.google.android.exoplayer2.text.webvtt.WebvttCue$Builder):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void m4110a(java.lang.String r17, java.lang.String r18, com.google.android.exoplayer2.text.webvtt.WebvttCue.Builder r19, java.util.List<com.google.android.exoplayer2.text.webvtt.WebvttCssStyle> r20) {
        /*
        r0 = r17;
        r1 = r18;
        r2 = r20;
        r3 = new android.text.SpannableStringBuilder;
        r3.<init>();
        r4 = new java.util.Stack;
        r4.<init>();
        r5 = new java.util.ArrayList;
        r5.<init>();
        r6 = 0;
        r7 = r6;
    L_0x0017:
        r8 = r18.length();
        if (r7 >= r8) goto L_0x0193;
    L_0x001d:
        r8 = r1.charAt(r7);
        r10 = 62;
        r11 = 60;
        r12 = 38;
        r14 = -1;
        r15 = 1;
        if (r8 == r12) goto L_0x00fa;
    L_0x002b:
        if (r8 == r11) goto L_0x0033;
    L_0x002d:
        r3.append(r8);
        r7 = r7 + 1;
        goto L_0x0017;
    L_0x0033:
        r8 = r7 + 1;
        r11 = r18.length();
        if (r8 < r11) goto L_0x003d;
    L_0x003b:
        r7 = r8;
        goto L_0x0017;
    L_0x003d:
        r11 = r1.charAt(r8);
        r12 = 47;
        if (r11 != r12) goto L_0x0047;
    L_0x0045:
        r11 = r15;
        goto L_0x0048;
    L_0x0047:
        r11 = r6;
    L_0x0048:
        r8 = r1.indexOf(r10, r8);
        if (r8 != r14) goto L_0x0053;
    L_0x004e:
        r8 = r18.length();
        goto L_0x0055;
    L_0x0053:
        r8 = r8 + 1;
    L_0x0055:
        r10 = r8 + -2;
        r9 = r1.charAt(r10);
        if (r9 != r12) goto L_0x005f;
    L_0x005d:
        r9 = r15;
        goto L_0x0060;
    L_0x005f:
        r9 = r6;
    L_0x0060:
        if (r11 == 0) goto L_0x0064;
    L_0x0062:
        r12 = 2;
        goto L_0x0065;
    L_0x0064:
        r12 = r15;
    L_0x0065:
        r7 = r7 + r12;
        if (r9 == 0) goto L_0x0069;
    L_0x0068:
        goto L_0x006b;
    L_0x0069:
        r10 = r8 + -1;
    L_0x006b:
        r7 = r1.substring(r7, r10);
        r10 = r7.trim();
        r12 = r10.isEmpty();
        if (r12 == 0) goto L_0x007b;
    L_0x0079:
        r10 = 0;
        goto L_0x0083;
    L_0x007b:
        r12 = "[ \\.]";
        r10 = r10.split(r12);
        r10 = r10[r6];
    L_0x0083:
        if (r10 == 0) goto L_0x003b;
    L_0x0085:
        r12 = r10.hashCode();
        switch(r12) {
            case 98: goto L_0x00bf;
            case 99: goto L_0x00b5;
            case 105: goto L_0x00ab;
            case 117: goto L_0x00a1;
            case 118: goto L_0x0097;
            case 3314158: goto L_0x008d;
            default: goto L_0x008c;
        };
    L_0x008c:
        goto L_0x00c9;
    L_0x008d:
        r12 = "lang";
        r12 = r10.equals(r12);
        if (r12 == 0) goto L_0x00c9;
    L_0x0095:
        r12 = 3;
        goto L_0x00ca;
    L_0x0097:
        r12 = "v";
        r12 = r10.equals(r12);
        if (r12 == 0) goto L_0x00c9;
    L_0x009f:
        r12 = 5;
        goto L_0x00ca;
    L_0x00a1:
        r12 = "u";
        r12 = r10.equals(r12);
        if (r12 == 0) goto L_0x00c9;
    L_0x00a9:
        r12 = 4;
        goto L_0x00ca;
    L_0x00ab:
        r12 = "i";
        r12 = r10.equals(r12);
        if (r12 == 0) goto L_0x00c9;
    L_0x00b3:
        r12 = 2;
        goto L_0x00ca;
    L_0x00b5:
        r12 = "c";
        r12 = r10.equals(r12);
        if (r12 == 0) goto L_0x00c9;
    L_0x00bd:
        r12 = r15;
        goto L_0x00ca;
    L_0x00bf:
        r12 = "b";
        r12 = r10.equals(r12);
        if (r12 == 0) goto L_0x00c9;
    L_0x00c7:
        r12 = r6;
        goto L_0x00ca;
    L_0x00c9:
        r12 = r14;
    L_0x00ca:
        switch(r12) {
            case 0: goto L_0x00ce;
            case 1: goto L_0x00ce;
            case 2: goto L_0x00ce;
            case 3: goto L_0x00ce;
            case 4: goto L_0x00ce;
            case 5: goto L_0x00ce;
            default: goto L_0x00cd;
        };
    L_0x00cd:
        r15 = r6;
    L_0x00ce:
        if (r15 == 0) goto L_0x003b;
    L_0x00d0:
        if (r11 == 0) goto L_0x00eb;
    L_0x00d2:
        r7 = r4.isEmpty();
        if (r7 != 0) goto L_0x003b;
    L_0x00d8:
        r7 = r4.pop();
        r7 = (com.google.android.exoplayer2.text.webvtt.WebvttCueParser.StartTag) r7;
        m4109a(r0, r7, r3, r2, r5);
        r7 = r7.f5112a;
        r7 = r7.equals(r10);
        if (r7 == 0) goto L_0x00d2;
    L_0x00e9:
        goto L_0x003b;
    L_0x00eb:
        if (r9 != 0) goto L_0x003b;
    L_0x00ed:
        r9 = r3.length();
        r7 = com.google.android.exoplayer2.text.webvtt.WebvttCueParser.StartTag.m4106a(r7, r9);
        r4.push(r7);
        goto L_0x003b;
    L_0x00fa:
        r9 = 59;
        r7 = r7 + 1;
        r9 = r1.indexOf(r9, r7);
        r6 = 32;
        r13 = r1.indexOf(r6, r7);
        if (r9 != r14) goto L_0x010c;
    L_0x010a:
        r9 = r13;
        goto L_0x0113;
    L_0x010c:
        if (r13 != r14) goto L_0x010f;
    L_0x010e:
        goto L_0x0113;
    L_0x010f:
        r9 = java.lang.Math.min(r9, r13);
    L_0x0113:
        if (r9 == r14) goto L_0x018d;
    L_0x0115:
        r7 = r1.substring(r7, r9);
        r8 = r7.hashCode();
        r14 = 3309; // 0xced float:4.637E-42 double:1.635E-320;
        if (r8 == r14) goto L_0x014e;
    L_0x0121:
        r14 = 3464; // 0xd88 float:4.854E-42 double:1.7114E-320;
        if (r8 == r14) goto L_0x0144;
    L_0x0125:
        r14 = 96708; // 0x179c4 float:1.35517E-40 double:4.778E-319;
        if (r8 == r14) goto L_0x013a;
    L_0x012a:
        r14 = 3374865; // 0x337f11 float:4.729193E-39 double:1.667405E-317;
        if (r8 == r14) goto L_0x0130;
    L_0x012f:
        goto L_0x0157;
    L_0x0130:
        r8 = "nbsp";
        r8 = r7.equals(r8);
        if (r8 == 0) goto L_0x0157;
    L_0x0138:
        r15 = 2;
        goto L_0x0158;
    L_0x013a:
        r8 = "amp";
        r8 = r7.equals(r8);
        if (r8 == 0) goto L_0x0157;
    L_0x0142:
        r15 = 3;
        goto L_0x0158;
    L_0x0144:
        r8 = "lt";
        r8 = r7.equals(r8);
        if (r8 == 0) goto L_0x0157;
    L_0x014c:
        r15 = 0;
        goto L_0x0158;
    L_0x014e:
        r8 = "gt";
        r8 = r7.equals(r8);
        if (r8 == 0) goto L_0x0157;
    L_0x0156:
        goto L_0x0158;
    L_0x0157:
        r15 = -1;
    L_0x0158:
        switch(r15) {
            case 0: goto L_0x0180;
            case 1: goto L_0x017c;
            case 2: goto L_0x0178;
            case 3: goto L_0x0174;
            default: goto L_0x015b;
        };
    L_0x015b:
        r6 = "WebvttCueParser";
        r8 = new java.lang.StringBuilder;
        r10 = "ignoring unsupported entity: '&";
        r8.<init>(r10);
        r8.append(r7);
        r7 = ";'";
        r8.append(r7);
        r7 = r8.toString();
        android.util.Log.w(r6, r7);
        goto L_0x0183;
    L_0x0174:
        r3.append(r12);
        goto L_0x0183;
    L_0x0178:
        r3.append(r6);
        goto L_0x0183;
    L_0x017c:
        r3.append(r10);
        goto L_0x0183;
    L_0x0180:
        r3.append(r11);
    L_0x0183:
        if (r9 != r13) goto L_0x018a;
    L_0x0185:
        r6 = " ";
        r3.append(r6);
    L_0x018a:
        r7 = r9 + 1;
        goto L_0x0190;
    L_0x018d:
        r3.append(r8);
    L_0x0190:
        r6 = 0;
        goto L_0x0017;
    L_0x0193:
        r1 = r4.isEmpty();
        if (r1 != 0) goto L_0x01a3;
    L_0x0199:
        r1 = r4.pop();
        r1 = (com.google.android.exoplayer2.text.webvtt.WebvttCueParser.StartTag) r1;
        m4109a(r0, r1, r3, r2, r5);
        goto L_0x0193;
    L_0x01a3:
        r1 = com.google.android.exoplayer2.text.webvtt.WebvttCueParser.StartTag.m4105a();
        m4109a(r0, r1, r3, r2, r5);
        r0 = r19;
        r0.f5103c = r3;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.text.webvtt.WebvttCueParser.a(java.lang.String, java.lang.String, com.google.android.exoplayer2.text.webvtt.WebvttCue$Builder, java.util.List):void");
    }

    private static boolean m4112a(java.lang.String r4, java.util.regex.Matcher r5, com.google.android.exoplayer2.util.ParsableByteArray r6, com.google.android.exoplayer2.text.webvtt.WebvttCue.Builder r7, java.lang.StringBuilder r8, java.util.List<com.google.android.exoplayer2.text.webvtt.WebvttCssStyle> r9) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = 0;
        r1 = 1;
        r2 = r5.group(r1);	 Catch:{ NumberFormatException -> 0x0047 }
        r2 = com.google.android.exoplayer2.text.webvtt.WebvttParserUtil.m4114a(r2);	 Catch:{ NumberFormatException -> 0x0047 }
        r7.f5101a = r2;	 Catch:{ NumberFormatException -> 0x0047 }
        r2 = 2;	 Catch:{ NumberFormatException -> 0x0047 }
        r2 = r5.group(r2);	 Catch:{ NumberFormatException -> 0x0047 }
        r2 = com.google.android.exoplayer2.text.webvtt.WebvttParserUtil.m4114a(r2);	 Catch:{ NumberFormatException -> 0x0047 }
        r7.f5102b = r2;	 Catch:{ NumberFormatException -> 0x0047 }
        r2 = 3;
        r5 = r5.group(r2);
        m4108a(r5, r7);
        r8.setLength(r0);
    L_0x0022:
        r5 = r6.m4267r();
        r0 = android.text.TextUtils.isEmpty(r5);
        if (r0 != 0) goto L_0x003f;
    L_0x002c:
        r0 = r8.length();
        if (r0 <= 0) goto L_0x0037;
    L_0x0032:
        r0 = "\n";
        r8.append(r0);
    L_0x0037:
        r5 = r5.trim();
        r8.append(r5);
        goto L_0x0022;
    L_0x003f:
        r5 = r8.toString();
        m4110a(r4, r5, r7, r9);
        return r1;
    L_0x0047:
        r4 = "WebvttCueParser";
        r6 = new java.lang.StringBuilder;
        r7 = "Skipping cue with bad header: ";
        r6.<init>(r7);
        r5 = r5.group();
        r6.append(r5);
        r5 = r6.toString();
        android.util.Log.w(r4, r5);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.text.webvtt.WebvttCueParser.a(java.lang.String, java.util.regex.Matcher, com.google.android.exoplayer2.util.ParsableByteArray, com.google.android.exoplayer2.text.webvtt.WebvttCue$Builder, java.lang.StringBuilder, java.util.List):boolean");
    }

    private static int m4107a(String str) {
        StringBuilder stringBuilder;
        int hashCode = str.hashCode();
        if (hashCode != -1364013995) {
            if (hashCode != -1074341483) {
                if (hashCode != 100571) {
                    if (hashCode == 109757538) {
                        if (str.equals("start")) {
                            hashCode = 0;
                            switch (hashCode) {
                                case 0:
                                    return 0;
                                case 1:
                                case 2:
                                    return 1;
                                case 3:
                                    return 2;
                                default:
                                    stringBuilder = new StringBuilder("Invalid anchor value: ");
                                    stringBuilder.append(str);
                                    Log.w("WebvttCueParser", stringBuilder.toString());
                                    return Integer.MIN_VALUE;
                            }
                        }
                    }
                } else if (str.equals("end")) {
                    hashCode = 3;
                    switch (hashCode) {
                        case 0:
                            return 0;
                        case 1:
                        case 2:
                            return 1;
                        case 3:
                            return 2;
                        default:
                            stringBuilder = new StringBuilder("Invalid anchor value: ");
                            stringBuilder.append(str);
                            Log.w("WebvttCueParser", stringBuilder.toString());
                            return Integer.MIN_VALUE;
                    }
                }
            } else if (str.equals("middle")) {
                hashCode = 2;
                switch (hashCode) {
                    case 0:
                        return 0;
                    case 1:
                    case 2:
                        return 1;
                    case 3:
                        return 2;
                    default:
                        stringBuilder = new StringBuilder("Invalid anchor value: ");
                        stringBuilder.append(str);
                        Log.w("WebvttCueParser", stringBuilder.toString());
                        return Integer.MIN_VALUE;
                }
            }
        } else if (str.equals("center")) {
            hashCode = 1;
            switch (hashCode) {
                case 0:
                    return 0;
                case 1:
                case 2:
                    return 1;
                case 3:
                    return 2;
                default:
                    stringBuilder = new StringBuilder("Invalid anchor value: ");
                    stringBuilder.append(str);
                    Log.w("WebvttCueParser", stringBuilder.toString());
                    return Integer.MIN_VALUE;
            }
        }
        hashCode = -1;
        switch (hashCode) {
            case 0:
                return 0;
            case 1:
            case 2:
                return 1;
            case 3:
                return 2;
            default:
                stringBuilder = new StringBuilder("Invalid anchor value: ");
                stringBuilder.append(str);
                Log.w("WebvttCueParser", stringBuilder.toString());
                return Integer.MIN_VALUE;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void m4109a(java.lang.String r8, com.google.android.exoplayer2.text.webvtt.WebvttCueParser.StartTag r9, android.text.SpannableStringBuilder r10, java.util.List<com.google.android.exoplayer2.text.webvtt.WebvttCssStyle> r11, java.util.List<com.google.android.exoplayer2.text.webvtt.WebvttCueParser.StyleMatch> r12) {
        /*
        r0 = r9.f5113b;
        r1 = r10.length();
        r2 = r9.f5112a;
        r3 = r2.hashCode();
        r4 = 2;
        r5 = -1;
        r6 = 0;
        r7 = 1;
        switch(r3) {
            case 0: goto L_0x0050;
            case 98: goto L_0x0046;
            case 99: goto L_0x003c;
            case 105: goto L_0x0032;
            case 117: goto L_0x0028;
            case 118: goto L_0x001e;
            case 3314158: goto L_0x0014;
            default: goto L_0x0013;
        };
    L_0x0013:
        goto L_0x005a;
    L_0x0014:
        r3 = "lang";
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x005a;
    L_0x001c:
        r2 = 4;
        goto L_0x005b;
    L_0x001e:
        r3 = "v";
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x005a;
    L_0x0026:
        r2 = 5;
        goto L_0x005b;
    L_0x0028:
        r3 = "u";
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x005a;
    L_0x0030:
        r2 = r4;
        goto L_0x005b;
    L_0x0032:
        r3 = "i";
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x005a;
    L_0x003a:
        r2 = r7;
        goto L_0x005b;
    L_0x003c:
        r3 = "c";
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x005a;
    L_0x0044:
        r2 = 3;
        goto L_0x005b;
    L_0x0046:
        r3 = "b";
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x005a;
    L_0x004e:
        r2 = r6;
        goto L_0x005b;
    L_0x0050:
        r3 = "";
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x005a;
    L_0x0058:
        r2 = 6;
        goto L_0x005b;
    L_0x005a:
        r2 = r5;
    L_0x005b:
        r3 = 33;
        switch(r2) {
            case 0: goto L_0x0073;
            case 1: goto L_0x006a;
            case 2: goto L_0x0061;
            case 3: goto L_0x007b;
            case 4: goto L_0x007b;
            case 5: goto L_0x007b;
            case 6: goto L_0x007b;
            default: goto L_0x0060;
        };
    L_0x0060:
        return;
    L_0x0061:
        r2 = new android.text.style.UnderlineSpan;
        r2.<init>();
        r10.setSpan(r2, r0, r1, r3);
        goto L_0x007b;
    L_0x006a:
        r2 = new android.text.style.StyleSpan;
        r2.<init>(r4);
        r10.setSpan(r2, r0, r1, r3);
        goto L_0x007b;
    L_0x0073:
        r2 = new android.text.style.StyleSpan;
        r2.<init>(r7);
        r10.setSpan(r2, r0, r1, r3);
    L_0x007b:
        r12.clear();
        m4111a(r11, r8, r9, r12);
        r8 = r12.size();
        r9 = r6;
    L_0x0086:
        if (r9 >= r8) goto L_0x0144;
    L_0x0088:
        r11 = r12.get(r9);
        r11 = (com.google.android.exoplayer2.text.webvtt.WebvttCueParser.StyleMatch) r11;
        r11 = r11.f5117b;
        if (r11 == 0) goto L_0x0140;
    L_0x0092:
        r2 = r11.m4102a();
        if (r2 == r5) goto L_0x00a4;
    L_0x0098:
        r2 = new android.text.style.StyleSpan;
        r4 = r11.m4102a();
        r2.<init>(r4);
        r10.setSpan(r2, r0, r1, r3);
    L_0x00a4:
        r2 = r11.f5093j;
        if (r2 != r7) goto L_0x00aa;
    L_0x00a8:
        r2 = r7;
        goto L_0x00ab;
    L_0x00aa:
        r2 = r6;
    L_0x00ab:
        if (r2 == 0) goto L_0x00b5;
    L_0x00ad:
        r2 = new android.text.style.StrikethroughSpan;
        r2.<init>();
        r10.setSpan(r2, r0, r1, r3);
    L_0x00b5:
        r2 = r11.f5094k;
        if (r2 != r7) goto L_0x00bb;
    L_0x00b9:
        r2 = r7;
        goto L_0x00bc;
    L_0x00bb:
        r2 = r6;
    L_0x00bc:
        if (r2 == 0) goto L_0x00c6;
    L_0x00be:
        r2 = new android.text.style.UnderlineSpan;
        r2.<init>();
        r10.setSpan(r2, r0, r1, r3);
    L_0x00c6:
        r2 = r11.f5090g;
        if (r2 == 0) goto L_0x00e0;
    L_0x00ca:
        r2 = new android.text.style.ForegroundColorSpan;
        r4 = r11.f5090g;
        if (r4 != 0) goto L_0x00d8;
    L_0x00d0:
        r8 = new java.lang.IllegalStateException;
        r9 = "Font color not defined";
        r8.<init>(r9);
        throw r8;
    L_0x00d8:
        r4 = r11.f5089f;
        r2.<init>(r4);
        r10.setSpan(r2, r0, r1, r3);
    L_0x00e0:
        r2 = r11.f5092i;
        if (r2 == 0) goto L_0x00fa;
    L_0x00e4:
        r2 = new android.text.style.BackgroundColorSpan;
        r4 = r11.f5092i;
        if (r4 != 0) goto L_0x00f2;
    L_0x00ea:
        r8 = new java.lang.IllegalStateException;
        r9 = "Background color not defined.";
        r8.<init>(r9);
        throw r8;
    L_0x00f2:
        r4 = r11.f5091h;
        r2.<init>(r4);
        r10.setSpan(r2, r0, r1, r3);
    L_0x00fa:
        r2 = r11.f5088e;
        if (r2 == 0) goto L_0x0108;
    L_0x00fe:
        r2 = new android.text.style.TypefaceSpan;
        r4 = r11.f5088e;
        r2.<init>(r4);
        r10.setSpan(r2, r0, r1, r3);
    L_0x0108:
        r2 = r11.f5099p;
        if (r2 == 0) goto L_0x0116;
    L_0x010c:
        r2 = new android.text.style.AlignmentSpan$Standard;
        r4 = r11.f5099p;
        r2.<init>(r4);
        r10.setSpan(r2, r0, r1, r3);
    L_0x0116:
        r2 = r11.f5097n;
        switch(r2) {
            case 1: goto L_0x0135;
            case 2: goto L_0x012a;
            case 3: goto L_0x011c;
            default: goto L_0x011b;
        };
    L_0x011b:
        goto L_0x0140;
    L_0x011c:
        r2 = new android.text.style.RelativeSizeSpan;
        r11 = r11.f5098o;
        r4 = 1120403456; // 0x42c80000 float:100.0 double:5.53552857E-315;
        r11 = r11 / r4;
        r2.<init>(r11);
        r10.setSpan(r2, r0, r1, r3);
        goto L_0x0140;
    L_0x012a:
        r2 = new android.text.style.RelativeSizeSpan;
        r11 = r11.f5098o;
        r2.<init>(r11);
        r10.setSpan(r2, r0, r1, r3);
        goto L_0x0140;
    L_0x0135:
        r2 = new android.text.style.AbsoluteSizeSpan;
        r11 = r11.f5098o;
        r11 = (int) r11;
        r2.<init>(r11, r7);
        r10.setSpan(r2, r0, r1, r3);
    L_0x0140:
        r9 = r9 + 1;
        goto L_0x0086;
    L_0x0144:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.text.webvtt.WebvttCueParser.a(java.lang.String, com.google.android.exoplayer2.text.webvtt.WebvttCueParser$StartTag, android.text.SpannableStringBuilder, java.util.List, java.util.List):void");
    }

    private static void m4111a(List<WebvttCssStyle> list, String str, StartTag startTag, List<StyleMatch> list2) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            int a;
            WebvttCssStyle webvttCssStyle = (WebvttCssStyle) list.get(i);
            String str2 = startTag.f5112a;
            String[] strArr = startTag.f5115d;
            String str3 = startTag.f5114c;
            if (!webvttCssStyle.f5084a.isEmpty() || !webvttCssStyle.f5085b.isEmpty() || !webvttCssStyle.f5086c.isEmpty() || !webvttCssStyle.f5087d.isEmpty()) {
                a = WebvttCssStyle.m4101a(WebvttCssStyle.m4101a(WebvttCssStyle.m4101a(0, webvttCssStyle.f5084a, str, 1073741824), webvttCssStyle.f5085b, str2, 2), webvttCssStyle.f5087d, str3, 4);
                if (a != -1) {
                    if (Arrays.asList(strArr).containsAll(webvttCssStyle.f5086c)) {
                        a += webvttCssStyle.f5086c.size() * 4;
                        if (a <= 0) {
                            list2.add(new StyleMatch(a, webvttCssStyle));
                        }
                    }
                }
            } else if (str2.isEmpty()) {
                a = 1;
                if (a <= 0) {
                    list2.add(new StyleMatch(a, webvttCssStyle));
                }
            }
            a = 0;
            if (a <= 0) {
                list2.add(new StyleMatch(a, webvttCssStyle));
            }
        }
        Collections.sort(list2);
    }
}
