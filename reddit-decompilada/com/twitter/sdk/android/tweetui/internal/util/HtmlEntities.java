package com.twitter.sdk.android.tweetui.internal.util;

import com.crashlytics.android.beta.Beta;
import com.crashlytics.android.beta.BuildConfig;
import com.instabug.chat.model.Attachment;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HtmlEntities {
    public static final HtmlEntities f24283a;
    static final String[][] f24284b = new String[][]{new String[]{"nbsp", "160"}, new String[]{"iexcl", "161"}, new String[]{"cent", "162"}, new String[]{"pound", "163"}, new String[]{"curren", "164"}, new String[]{"yen", "165"}, new String[]{"brvbar", "166"}, new String[]{"sect", "167"}, new String[]{"uml", "168"}, new String[]{"copy", "169"}, new String[]{"ordf", "170"}, new String[]{"laquo", "171"}, new String[]{"not", "172"}, new String[]{"shy", "173"}, new String[]{"reg", "174"}, new String[]{"macr", "175"}, new String[]{"deg", "176"}, new String[]{"plusmn", "177"}, new String[]{"sup2", "178"}, new String[]{"sup3", "179"}, new String[]{"acute", "180"}, new String[]{"micro", "181"}, new String[]{"para", "182"}, new String[]{"middot", "183"}, new String[]{"cedil", "184"}, new String[]{"sup1", "185"}, new String[]{"ordm", "186"}, new String[]{"raquo", "187"}, new String[]{"frac14", "188"}, new String[]{"frac12", "189"}, new String[]{"frac34", "190"}, new String[]{"iquest", "191"}, new String[]{"Agrave", "192"}, new String[]{"Aacute", "193"}, new String[]{"Acirc", "194"}, new String[]{"Atilde", "195"}, new String[]{"Auml", "196"}, new String[]{"Aring", "197"}, new String[]{"AElig", "198"}, new String[]{"Ccedil", "199"}, new String[]{"Egrave", "200"}, new String[]{"Eacute", "201"}, new String[]{"Ecirc", "202"}, new String[]{"Euml", "203"}, new String[]{"Igrave", "204"}, new String[]{"Iacute", "205"}, new String[]{"Icirc", "206"}, new String[]{"Iuml", "207"}, new String[]{"ETH", "208"}, new String[]{"Ntilde", "209"}, new String[]{"Ograve", "210"}, new String[]{"Oacute", "211"}, new String[]{"Ocirc", "212"}, new String[]{"Otilde", "213"}, new String[]{"Ouml", "214"}, new String[]{"times", "215"}, new String[]{"Oslash", "216"}, new String[]{"Ugrave", "217"}, new String[]{"Uacute", "218"}, new String[]{"Ucirc", "219"}, new String[]{"Uuml", "220"}, new String[]{"Yacute", "221"}, new String[]{"THORN", "222"}, new String[]{"szlig", "223"}, new String[]{"agrave", "224"}, new String[]{"aacute", "225"}, new String[]{"acirc", "226"}, new String[]{"atilde", "227"}, new String[]{"auml", "228"}, new String[]{"aring", "229"}, new String[]{"aelig", "230"}, new String[]{"ccedil", "231"}, new String[]{"egrave", "232"}, new String[]{"eacute", "233"}, new String[]{"ecirc", "234"}, new String[]{"euml", "235"}, new String[]{"igrave", "236"}, new String[]{"iacute", "237"}, new String[]{"icirc", "238"}, new String[]{"iuml", "239"}, new String[]{"eth", "240"}, new String[]{"ntilde", "241"}, new String[]{"ograve", "242"}, new String[]{"oacute", "243"}, new String[]{"ocirc", "244"}, new String[]{"otilde", "245"}, new String[]{"ouml", "246"}, new String[]{"divide", "247"}, new String[]{"oslash", "248"}, new String[]{"ugrave", "249"}, new String[]{"uacute", "250"}, new String[]{"ucirc", "251"}, new String[]{"uuml", "252"}, new String[]{"yacute", "253"}, new String[]{"thorn", "254"}, new String[]{"yuml", "255"}};
    static final String[][] f24285c = new String[][]{new String[]{"fnof", "402"}, new String[]{"Alpha", "913"}, new String[]{Beta.TAG, "914"}, new String[]{"Gamma", "915"}, new String[]{"Delta", "916"}, new String[]{"Epsilon", "917"}, new String[]{"Zeta", "918"}, new String[]{"Eta", "919"}, new String[]{"Theta", "920"}, new String[]{"Iota", "921"}, new String[]{"Kappa", "922"}, new String[]{"Lambda", "923"}, new String[]{"Mu", "924"}, new String[]{"Nu", "925"}, new String[]{"Xi", "926"}, new String[]{"Omicron", "927"}, new String[]{"Pi", "928"}, new String[]{"Rho", "929"}, new String[]{"Sigma", "931"}, new String[]{"Tau", "932"}, new String[]{"Upsilon", "933"}, new String[]{"Phi", "934"}, new String[]{"Chi", "935"}, new String[]{"Psi", "936"}, new String[]{"Omega", "937"}, new String[]{"alpha", "945"}, new String[]{BuildConfig.ARTIFACT_ID, "946"}, new String[]{"gamma", "947"}, new String[]{"delta", "948"}, new String[]{"epsilon", "949"}, new String[]{"zeta", "950"}, new String[]{"eta", "951"}, new String[]{"theta", "952"}, new String[]{"iota", "953"}, new String[]{"kappa", "954"}, new String[]{"lambda", "955"}, new String[]{"mu", "956"}, new String[]{"nu", "957"}, new String[]{"xi", "958"}, new String[]{"omicron", "959"}, new String[]{"pi", "960"}, new String[]{"rho", "961"}, new String[]{"sigmaf", "962"}, new String[]{"sigma", "963"}, new String[]{"tau", "964"}, new String[]{"upsilon", "965"}, new String[]{"phi", "966"}, new String[]{"chi", "967"}, new String[]{"psi", "968"}, new String[]{"omega", "969"}, new String[]{"thetasym", "977"}, new String[]{"upsih", "978"}, new String[]{"piv", "982"}, new String[]{"bull", "8226"}, new String[]{"hellip", "8230"}, new String[]{"prime", "8242"}, new String[]{"Prime", "8243"}, new String[]{"oline", "8254"}, new String[]{"frasl", "8260"}, new String[]{"weierp", "8472"}, new String[]{Attachment.TYPE_IMAGE, "8465"}, new String[]{"real", "8476"}, new String[]{"trade", "8482"}, new String[]{"alefsym", "8501"}, new String[]{"larr", "8592"}, new String[]{"uarr", "8593"}, new String[]{"rarr", "8594"}, new String[]{"darr", "8595"}, new String[]{"harr", "8596"}, new String[]{"crarr", "8629"}, new String[]{"lArr", "8656"}, new String[]{"uArr", "8657"}, new String[]{"rArr", "8658"}, new String[]{"dArr", "8659"}, new String[]{"hArr", "8660"}, new String[]{"forall", "8704"}, new String[]{"part", "8706"}, new String[]{"exist", "8707"}, new String[]{"empty", "8709"}, new String[]{"nabla", "8711"}, new String[]{"isin", "8712"}, new String[]{"notin", "8713"}, new String[]{"ni", "8715"}, new String[]{"prod", "8719"}, new String[]{"sum", "8721"}, new String[]{"minus", "8722"}, new String[]{"lowast", "8727"}, new String[]{"radic", "8730"}, new String[]{"prop", "8733"}, new String[]{"infin", "8734"}, new String[]{"ang", "8736"}, new String[]{"and", "8743"}, new String[]{"or", "8744"}, new String[]{"cap", "8745"}, new String[]{"cup", "8746"}, new String[]{"int", "8747"}, new String[]{"there4", "8756"}, new String[]{"sim", "8764"}, new String[]{"cong", "8773"}, new String[]{"asymp", "8776"}, new String[]{"ne", "8800"}, new String[]{"equiv", "8801"}, new String[]{"le", "8804"}, new String[]{"ge", "8805"}, new String[]{"sub", "8834"}, new String[]{"sup", "8835"}, new String[]{"sube", "8838"}, new String[]{"supe", "8839"}, new String[]{"oplus", "8853"}, new String[]{"otimes", "8855"}, new String[]{"perp", "8869"}, new String[]{"sdot", "8901"}, new String[]{"lceil", "8968"}, new String[]{"rceil", "8969"}, new String[]{"lfloor", "8970"}, new String[]{"rfloor", "8971"}, new String[]{"lang", "9001"}, new String[]{"rang", "9002"}, new String[]{"loz", "9674"}, new String[]{"spades", "9824"}, new String[]{"clubs", "9827"}, new String[]{"hearts", "9829"}, new String[]{"diams", "9830"}, new String[]{"OElig", "338"}, new String[]{"oelig", "339"}, new String[]{"Scaron", "352"}, new String[]{"scaron", "353"}, new String[]{"Yuml", "376"}, new String[]{"circ", "710"}, new String[]{"tilde", "732"}, new String[]{"ensp", "8194"}, new String[]{"emsp", "8195"}, new String[]{"thinsp", "8201"}, new String[]{"zwnj", "8204"}, new String[]{"zwj", "8205"}, new String[]{"lrm", "8206"}, new String[]{"rlm", "8207"}, new String[]{"ndash", "8211"}, new String[]{"mdash", "8212"}, new String[]{"lsquo", "8216"}, new String[]{"rsquo", "8217"}, new String[]{"sbquo", "8218"}, new String[]{"ldquo", "8220"}, new String[]{"rdquo", "8221"}, new String[]{"bdquo", "8222"}, new String[]{"dagger", "8224"}, new String[]{"Dagger", "8225"}, new String[]{"permil", "8240"}, new String[]{"lsaquo", "8249"}, new String[]{"rsaquo", "8250"}, new String[]{"euro", "8364"}};
    private static final String[][] f24286e = new String[][]{new String[]{"quot", "34"}, new String[]{"amp", "38"}, new String[]{"lt", "60"}, new String[]{"gt", "62"}};
    final EntityMap f24287d = new LookupEntityMap();

    interface EntityMap {
        int mo5521a(String str);

        void mo5522a(String str, int i);
    }

    public static final class Unescaped {
        public final String f24281a;
        public final ArrayList<int[]> f24282b;

        public Unescaped(String str, ArrayList<int[]> arrayList) {
            this.f24281a = str;
            this.f24282b = arrayList;
        }
    }

    static class PrimitiveEntityMap implements EntityMap {
        private final Map f30830a = new HashMap();
        private final IntHashMap f30831b = new IntHashMap();

        PrimitiveEntityMap() {
        }

        public final void mo5522a(String str, int i) {
            this.f30830a.put(str, Integer.valueOf(i));
            this.f30831b.m25996a(i, str);
        }

        public final int mo5521a(String str) {
            str = this.f30830a.get(str);
            if (str == null) {
                return -1;
            }
            return ((Integer) str).intValue();
        }
    }

    static class LookupEntityMap extends PrimitiveEntityMap {
        LookupEntityMap() {
        }
    }

    static {
        HtmlEntities htmlEntities = new HtmlEntities();
        f24283a = htmlEntities;
        htmlEntities.m25994a(f24286e);
        htmlEntities.m25994a(f24284b);
        htmlEntities.m25994a(f24285c);
    }

    private void m25994a(String[][] strArr) {
        for (String[] strArr2 : strArr) {
            this.f24287d.mo5522a(strArr2[0], Integer.parseInt(strArr2[1]));
        }
    }

    public final com.twitter.sdk.android.tweetui.internal.util.HtmlEntities.Unescaped m25995a(java.lang.String r17) {
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
        r16 = this;
        r0 = r17;
        r1 = r17.length();
        r2 = new java.lang.StringBuilder;
        r2.<init>(r1);
        r3 = new java.util.ArrayList;
        r4 = 5;
        r3.<init>(r4);
        r4 = 0;
        r5 = r4;
    L_0x0013:
        if (r5 >= r1) goto L_0x00a6;
    L_0x0015:
        r6 = r0.charAt(r5);
        r7 = 38;
        r8 = 1;
        if (r6 != r7) goto L_0x009e;
    L_0x001e:
        r9 = r5 + 1;
        r10 = 59;
        r11 = r0.indexOf(r10, r9);
        r12 = -1;
        if (r11 != r12) goto L_0x0030;
    L_0x0029:
        r2.append(r6);
        r9 = r16;
        goto L_0x00a3;
    L_0x0030:
        r6 = r0.substring(r9, r11);
        r9 = r6.length();
        r13 = 2;
        if (r9 <= 0) goto L_0x007a;
    L_0x003b:
        r14 = r6.charAt(r4);
        r15 = 35;
        if (r14 != r15) goto L_0x0071;
    L_0x0043:
        if (r9 <= r8) goto L_0x0071;
    L_0x0045:
        r14 = r6.charAt(r8);
        r15 = 120; // 0x78 float:1.68E-43 double:5.93E-322;
        if (r14 == r15) goto L_0x005b;
    L_0x004d:
        r15 = 88;
        if (r14 != r15) goto L_0x0052;
    L_0x0051:
        goto L_0x005b;
    L_0x0052:
        r9 = r6.substring(r8);	 Catch:{ Exception -> 0x007a }
        r9 = java.lang.Integer.parseInt(r9);	 Catch:{ Exception -> 0x007a }
        goto L_0x006d;	 Catch:{ Exception -> 0x007a }
    L_0x005b:
        if (r9 <= r13) goto L_0x006c;	 Catch:{ Exception -> 0x007a }
    L_0x005d:
        r9 = r6.substring(r13);	 Catch:{ Exception -> 0x007a }
        r14 = 16;	 Catch:{ Exception -> 0x007a }
        r9 = java.lang.Integer.valueOf(r9, r14);	 Catch:{ Exception -> 0x007a }
        r9 = r9.intValue();	 Catch:{ Exception -> 0x007a }
        goto L_0x006d;
    L_0x006c:
        r9 = r12;
    L_0x006d:
        r14 = r9;
        r9 = r16;
        goto L_0x007d;
    L_0x0071:
        r9 = r16;
        r14 = r9.f24287d;
        r14 = r14.mo5521a(r6);
        goto L_0x007d;
    L_0x007a:
        r9 = r16;
        r14 = r12;
    L_0x007d:
        if (r14 != r12) goto L_0x008f;
    L_0x007f:
        r2.append(r7);
        r7 = r6.indexOf(r7);
        if (r7 != r12) goto L_0x00a3;
    L_0x0088:
        r2.append(r6);
        r2.append(r10);
        goto L_0x009c;
    L_0x008f:
        r6 = (char) r14;
        r2.append(r6);
        r6 = new int[r13];
        r6[r4] = r5;
        r6[r8] = r11;
        r3.add(r6);
    L_0x009c:
        r5 = r11;
        goto L_0x00a3;
    L_0x009e:
        r9 = r16;
        r2.append(r6);
    L_0x00a3:
        r5 = r5 + r8;
        goto L_0x0013;
    L_0x00a6:
        r9 = r16;
        r0 = new com.twitter.sdk.android.tweetui.internal.util.HtmlEntities$Unescaped;
        r1 = r2.toString();
        r0.<init>(r1, r3);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.twitter.sdk.android.tweetui.internal.util.HtmlEntities.a(java.lang.String):com.twitter.sdk.android.tweetui.internal.util.HtmlEntities$Unescaped");
    }
}
