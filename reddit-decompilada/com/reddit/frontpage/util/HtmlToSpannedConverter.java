package com.reddit.frontpage.util;

import android.content.Context;
import android.content.res.Resources;
import android.text.Editable;
import android.text.Layout.Alignment;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.AlignmentSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.LeadingMarginSpan.Standard;
import android.text.style.ParagraphStyle;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.TextAppearanceSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.presentation.common.ResourcesUtil;
import com.reddit.frontpage.util.html.BlockquoteSpan;
import com.reddit.frontpage.util.html.NestableBulletSpan;
import com.reddit.frontpage.widgets.span.SpoilerSpan;
import com.reddit.frontpage.widgets.span.UrlToNativeWebViewSpan;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Locale;
import java.util.Stack;
import org.ccil.cowan.tagsoup.Parser;
import org.sufficientlysecure.htmltextview.ClickableTableSpan;
import org.sufficientlysecure.htmltextview.DrawTableLinkSpan;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

/* compiled from: RedditHtml */
class HtmlToSpannedConverter implements ContentHandler {
    private static final int f21724e = Util.m24004c((int) C1761R.dimen.html_blockquote_padding);
    private static final int f21725f = Util.m24012d((int) C1761R.dimen.html_blockquote_line_width);
    private static final int f21726g = Util.m24012d((int) C1761R.dimen.html_bullet_radius);
    private static final int f21727h = Util.m24004c((int) C1761R.dimen.html_bullet_gap_width);
    private static final int f21728i = Util.m24004c((int) C1761R.dimen.html_list_indent);
    private static final NestableBulletSpan f21729j = new NestableBulletSpan(f21728i, f21726g, f21727h);
    private static final float[] f21730k = new float[]{1.5f, 1.4f, 1.3f, 1.2f, 1.1f, 1.0f};
    private static final HashMap<String, Integer> f21731r;
    private final Stack<String> f21732a = new Stack();
    private final Stack<Integer> f21733b = new Stack();
    private StringBuilder f21734c = new StringBuilder();
    private int f21735d = 0;
    private final String f21736l;
    private final XMLReader f21737m;
    private final SpannableStringBuilder f21738n;
    private final ClickableTableSpan f21739o;
    private final DrawTableLinkSpan f21740p;
    private final int f21741q;

    /* compiled from: RedditHtml */
    private static class Big {
        private Big() {
        }
    }

    /* compiled from: RedditHtml */
    private static class Blockquote {
        private Blockquote() {
        }
    }

    /* compiled from: RedditHtml */
    private static class Bold {
        private Bold() {
        }
    }

    /* compiled from: RedditHtml */
    private static class Center {
        private Center() {
        }
    }

    /* compiled from: RedditHtml */
    private static class Code {
        private Code() {
        }
    }

    /* compiled from: RedditHtml */
    private static class Font {
        public final String f21719a;
        public final String f21720b;

        Font(String str, String str2) {
            this.f21719a = str;
            this.f21720b = str2;
        }
    }

    /* compiled from: RedditHtml */
    private static class Header {
        private final int f21721a;

        Header(int i) {
            this.f21721a = i;
        }
    }

    /* compiled from: RedditHtml */
    private static class Href {
        public final String f21722a;
        public final String f21723b;

        Href(String str, String str2) {
            this.f21722a = str;
            this.f21723b = str2;
        }
    }

    /* compiled from: RedditHtml */
    private static class Italic {
        private Italic() {
        }
    }

    /* compiled from: RedditHtml */
    private static class Monospace {
        private Monospace() {
        }
    }

    /* compiled from: RedditHtml */
    private static class Ol {
        private Ol() {
        }
    }

    /* compiled from: RedditHtml */
    private static class Small {
        private Small() {
        }
    }

    /* compiled from: RedditHtml */
    private static class Strike {
        private Strike() {
        }
    }

    /* compiled from: RedditHtml */
    private static class Strikethrough {
        private Strikethrough() {
        }
    }

    /* compiled from: RedditHtml */
    private static class Sub {
        private Sub() {
        }
    }

    /* compiled from: RedditHtml */
    private static class Super {
        private Super() {
        }
    }

    /* compiled from: RedditHtml */
    private static class Table {
        private Table() {
        }
    }

    /* compiled from: RedditHtml */
    private static class Td {
        private Td() {
        }
    }

    /* compiled from: RedditHtml */
    private static class Th {
        private Th() {
        }
    }

    /* compiled from: RedditHtml */
    private static class Ul {
        private Ul() {
        }
    }

    /* compiled from: RedditHtml */
    private static class Underline {
        private Underline() {
        }
    }

    public void endDocument() throws SAXException {
    }

    public void endPrefixMapping(String str) throws SAXException {
    }

    public void ignorableWhitespace(char[] cArr, int i, int i2) throws SAXException {
    }

    public void processingInstruction(String str, String str2) throws SAXException {
    }

    public void setDocumentLocator(Locator locator) {
    }

    public void skippedEntity(String str) throws SAXException {
    }

    public void startDocument() throws SAXException {
    }

    public void startPrefixMapping(String str, String str2) throws SAXException {
    }

    static {
        HashMap hashMap = new HashMap();
        f21731r = hashMap;
        hashMap.put("black", Integer.valueOf(-16777216));
        f21731r.put("darkgray", Integer.valueOf(-12303292));
        f21731r.put("gray", Integer.valueOf(-7829368));
        f21731r.put("lightgray", Integer.valueOf(-3355444));
        f21731r.put("lightgrey", Integer.valueOf(-3355444));
        f21731r.put("white", Integer.valueOf(-1));
        f21731r.put("red", Integer.valueOf(-65536));
        f21731r.put("green", Integer.valueOf(-16711936));
        f21731r.put("blue", Integer.valueOf(-16776961));
        f21731r.put("yellow", Integer.valueOf(-256));
        f21731r.put("cyan", Integer.valueOf(-16711681));
        f21731r.put("magenta", Integer.valueOf(-65281));
        f21731r.put("aqua", Integer.valueOf(-16711681));
        f21731r.put("fuchsia", Integer.valueOf(-65281));
        f21731r.put("darkgrey", Integer.valueOf(-12303292));
        f21731r.put("grey", Integer.valueOf(-7829368));
        f21731r.put("lime", Integer.valueOf(-16711936));
        f21731r.put("maroon", Integer.valueOf(-8388608));
        f21731r.put("navy", Integer.valueOf(-16777088));
        f21731r.put("olive", Integer.valueOf(-8355840));
        f21731r.put("purple", Integer.valueOf(-8388480));
        f21731r.put("silver", Integer.valueOf(-4144960));
        f21731r.put("teal", Integer.valueOf(-16744320));
    }

    HtmlToSpannedConverter(Context context, String str, Parser parser, ClickableTableSpan clickableTableSpan, DrawTableLinkSpan drawTableLinkSpan) {
        this.f21736l = str;
        this.f21738n = new SpannableStringBuilder();
        this.f21737m = parser;
        this.f21739o = clickableTableSpan;
        this.f21740p = drawTableLinkSpan;
        this.f21741q = ResourcesUtil.m22740i(context, C1761R.attr.rdt_active_color);
    }

    public final Spanned m23718a() {
        this.f21737m.setContentHandler(this);
        try {
            this.f21737m.parse(new InputSource(new StringReader(this.f21736l)));
            int i = 0;
            Object[] spans = this.f21738n.getSpans(0, this.f21738n.length(), ParagraphStyle.class);
            int length = spans.length;
            while (i < length) {
                Object obj = spans[i];
                int spanStart = this.f21738n.getSpanStart(obj);
                int spanEnd = this.f21738n.getSpanEnd(obj);
                int i2 = spanEnd - 2;
                if (i2 >= 0 && this.f21738n.charAt(spanEnd - 1) == '\n' && this.f21738n.charAt(i2) == '\n') {
                    spanEnd--;
                }
                if (spanEnd == spanStart) {
                    this.f21738n.removeSpan(obj);
                } else {
                    this.f21738n.setSpan(obj, spanStart, spanEnd, 51);
                }
                i++;
            }
            return this.f21738n;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    private void m23717a(boolean z, String str, Attributes attributes) {
        if (this.f21735d > 0 || str.equalsIgnoreCase("table")) {
            if (!z && (str.equalsIgnoreCase("th") || str.equalsIgnoreCase("td") || str.equalsIgnoreCase("a"))) {
                this.f21734c.append("</font>");
            }
            this.f21734c.append('<');
            if (!z) {
                this.f21734c.append('/');
            }
            this.f21734c.append(str.toLowerCase());
            if (z) {
                if (attributes != null) {
                    for (int i = 0; i < attributes.getLength(); i++) {
                        String qName = attributes.getQName(i);
                        String value = attributes.getValue(qName);
                        StringBuilder stringBuilder = this.f21734c;
                        stringBuilder.append(' ');
                        stringBuilder.append(qName);
                        stringBuilder.append("=\"");
                        stringBuilder.append(value);
                        stringBuilder.append('\"');
                    }
                }
                if (str.equalsIgnoreCase("table") != null) {
                    this.f21734c.append(" frame=\"border\" bordercolor=\"#efefed\" width=\"100%\" rules=\"all\" cellpadding=\"3\"");
                } else if (str.equalsIgnoreCase("th") != null) {
                    this.f21734c.append(" style=\"text-decoration: none; color: #222222; font-weight:normal\"");
                } else if (str.equalsIgnoreCase("td") != null) {
                    this.f21734c.append(" valign=\"top\" style=\"color: #A5A4A4;\"");
                } else if (str.equalsIgnoreCase("a") != null) {
                    this.f21734c.append(" style=\"text-decoration: none; color: #0079d3;\"");
                }
            }
            this.f21734c.append('>');
            if (z) {
                this.f21734c.append("<font size=2>");
            }
        }
    }

    private static void m23716a(SpannableStringBuilder spannableStringBuilder, boolean z) {
        int length = spannableStringBuilder.length();
        if (length <= 0 || spannableStringBuilder.charAt(length - 1) != '\n') {
            if (length != 0) {
                if (z) {
                    spannableStringBuilder.append("\n\n");
                }
                spannableStringBuilder.setSpan(new RelativeSizeSpan(0.5f), length, spannableStringBuilder.length(), 17);
            }
        } else if (length < 2 || !spannableStringBuilder.charAt(length - 2)) {
            spannableStringBuilder.append('\n');
        }
    }

    private static Object m23710a(Spanned spanned, Class cls) {
        spanned = spanned.getSpans(0, spanned.length(), cls);
        if (spanned.length == null) {
            return null;
        }
        return spanned[spanned.length - 1];
    }

    private static void m23715a(SpannableStringBuilder spannableStringBuilder, Object obj) {
        int length = spannableStringBuilder.length();
        spannableStringBuilder.setSpan(obj, length, length, 17);
    }

    private static void m23714a(SpannableStringBuilder spannableStringBuilder, Class cls, Object obj) {
        int length = spannableStringBuilder.length();
        cls = m23710a((Spanned) spannableStringBuilder, cls);
        int spanStart = spannableStringBuilder.getSpanStart(cls);
        spannableStringBuilder.removeSpan(cls);
        if (spanStart != length) {
            spannableStringBuilder.setSpan(obj, spanStart, length, 33);
        }
    }

    private void m23711a(Editable editable, Class cls) {
        if (this.f21735d > 0) {
            cls = editable.getSpanStart(m23710a((Spanned) editable, cls));
            int length = editable.length();
            CharSequence subSequence = editable.subSequence(cls, length);
            editable.delete(cls, length);
            this.f21734c.append(subSequence);
        }
    }

    private static void m23713a(SpannableStringBuilder spannableStringBuilder) {
        int length = spannableStringBuilder.length();
        Object a = m23710a((Spanned) spannableStringBuilder, Header.class);
        int spanStart = spannableStringBuilder.getSpanStart(a);
        spannableStringBuilder.removeSpan(a);
        while (length > spanStart && spannableStringBuilder.charAt(length - 1) == '\n') {
            length--;
        }
        if (spanStart != length && a != null) {
            spannableStringBuilder.setSpan(new RelativeSizeSpan(f21730k[((Header) a).f21721a]), spanStart, length, 33);
            spannableStringBuilder.setSpan(new StyleSpan(1), spanStart, length, 33);
        }
    }

    public void characters(char[] cArr, int i, int i2) throws SAXException {
        CharSequence stringBuilder = new StringBuilder();
        for (int i3 = 0; i3 < i2; i3++) {
            char c = cArr[i3 + i];
            if (c != ' ') {
                if (c != '\n') {
                    stringBuilder.append(c);
                }
            }
            int length = stringBuilder.length();
            if (length == 0) {
                length = this.f21738n.length();
                if (length == 0) {
                    c = '\n';
                } else {
                    c = this.f21738n.charAt(length - 1);
                }
            } else {
                c = stringBuilder.charAt(length - 1);
            }
            if (!(c == ' ' || c == '\n')) {
                stringBuilder.append(' ');
            }
        }
        this.f21738n.append(stringBuilder);
    }

    private static int m23709a(java.lang.String r2) {
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
        r0 = f21731r;
        r1 = java.util.Locale.ROOT;
        r1 = r2.toLowerCase(r1);
        r0 = r0.get(r1);
        r0 = (java.lang.Integer) r0;
        if (r0 == 0) goto L_0x0015;
    L_0x0010:
        r2 = r0.intValue();
        return r2;
    L_0x0015:
        r2 = com.reddit.frontpage.util.XmlUtils.m24068a(r2);	 Catch:{ NumberFormatException -> 0x001a }
        return r2;
    L_0x001a:
        r2 = -1;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reddit.frontpage.util.HtmlToSpannedConverter.a(java.lang.String):int");
    }

    private static void m23712a(Editable editable, Class cls, boolean z, Object... objArr) {
        int length;
        int i;
        int i2 = 0;
        cls = editable.getSpans(0, editable.length(), cls);
        if (cls.length != 0) {
            for (length = cls.length; length > 0; length--) {
                i = length - 1;
                if (editable.getSpanFlags(cls[i]) == 17) {
                    cls = cls[i];
                    break;
                }
            }
        }
        cls = null;
        length = editable.getSpanStart(cls);
        i = editable.length();
        editable.removeSpan(cls);
        if (length != i) {
            if (z) {
                editable.append('\n');
                i++;
            }
            cls = objArr.length;
            while (i2 < cls) {
                editable.setSpan(objArr[i2], length, i, 33);
                i2++;
            }
        }
    }

    public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
        if (str2.equalsIgnoreCase("br") == null) {
            boolean z = false;
            if (str2.equalsIgnoreCase("p") != null) {
                if (this.f21732a.isEmpty() != null || "ol".equals(this.f21732a.peek()) == null) {
                    z = true;
                }
                m23716a(this.f21738n, z);
            } else if (str2.equalsIgnoreCase("div") != null) {
                m23716a(this.f21738n, true);
            } else if (str2.equalsIgnoreCase("strong") != null) {
                m23715a(this.f21738n, new Bold());
            } else if (str2.equalsIgnoreCase("b") != null) {
                m23715a(this.f21738n, new Bold());
            } else if (str2.equalsIgnoreCase("em") != null) {
                m23715a(this.f21738n, new Italic());
            } else if (str2.equalsIgnoreCase("cite") != null) {
                m23715a(this.f21738n, new Italic());
            } else if (str2.equalsIgnoreCase("dfn") != null) {
                m23715a(this.f21738n, new Italic());
            } else if (str2.equalsIgnoreCase("i") != null) {
                m23715a(this.f21738n, new Italic());
            } else if (str2.equalsIgnoreCase("big") != null) {
                m23715a(this.f21738n, new Big());
            } else if (str2.equalsIgnoreCase("small") != null) {
                m23715a(this.f21738n, new Small());
            } else if (str2.equalsIgnoreCase("font") != null) {
                str = this.f21738n;
                r0 = attributes.getValue("", "color");
                r2 = attributes.getValue("", "face");
                r3 = str.length();
                str.setSpan(new Font(r0, r2), r3, r3, 17);
            } else if (str2.equalsIgnoreCase("blockquote") != null) {
                m23716a(this.f21738n, true);
                m23715a(this.f21738n, new Blockquote());
            } else if (str2.equalsIgnoreCase("tt") != null) {
                m23715a(this.f21738n, new Monospace());
            } else if (str2.equalsIgnoreCase("a") != null) {
                str = this.f21738n;
                r0 = attributes.getValue("", "href");
                r2 = attributes.getValue("", "title");
                r3 = str.length();
                str.setSpan(new Href(r0, r2), r3, r3, 17);
            } else if (str2.equalsIgnoreCase("u") != null) {
                m23715a(this.f21738n, new Underline());
            } else if (str2.equalsIgnoreCase("sup") != null) {
                m23715a(this.f21738n, new Super());
            } else if (str2.equalsIgnoreCase("sub") != null) {
                m23715a(this.f21738n, new Sub());
            } else if (str2.equalsIgnoreCase("del") != null) {
                m23715a(this.f21738n, new Strikethrough());
            } else if (str2.length() == 2 && str2.substring(0, 1).equals("h") != null && str2.charAt(1) >= 49 && str2.charAt(1) <= 54) {
                m23716a(this.f21738n, true);
                m23715a(this.f21738n, new Header(str2.charAt(1) - 49));
            } else if (str2.equalsIgnoreCase("ul") != null) {
                this.f21732a.push(str2);
            } else if (str2.equalsIgnoreCase("ol") != null) {
                this.f21732a.push(str2);
                this.f21733b.push(Integer.valueOf(1));
            } else if (str2.equalsIgnoreCase("li") != null) {
                if (this.f21738n.length() > null && this.f21738n.charAt(this.f21738n.length() - 1) != 10) {
                    this.f21738n.append('\n');
                }
                str = (String) this.f21732a.peek();
                if (str.equalsIgnoreCase("ol")) {
                    m23715a(this.f21738n, new Ol());
                    this.f21738n.append(((Integer) this.f21733b.peek()).toString()).append(". ");
                    this.f21733b.push(Integer.valueOf(((Integer) this.f21733b.pop()).intValue() + 1));
                } else if (str.equalsIgnoreCase("ul") != null) {
                    m23715a(this.f21738n, new Ul());
                }
            } else if (str2.equalsIgnoreCase("code") != null) {
                m23715a(this.f21738n, new Code());
            } else if (str2.equalsIgnoreCase("center") != null) {
                m23715a(this.f21738n, new Center());
            } else {
                if (str2.equalsIgnoreCase("s") == null) {
                    if (str2.equalsIgnoreCase("strike") == null) {
                        if (str2.equalsIgnoreCase("table") != null) {
                            m23715a(this.f21738n, new Table());
                            if (this.f21735d == null) {
                                this.f21734c = new StringBuilder();
                                this.f21738n.append("table placeholder");
                            }
                            this.f21735d += 1;
                        } else if (str2.equalsIgnoreCase("th") != null) {
                            m23715a(this.f21738n, new Th());
                        } else if (str2.equalsIgnoreCase("td") != null) {
                            m23715a(this.f21738n, new Td());
                        }
                    }
                }
                m23715a(this.f21738n, new Strike());
            }
        }
        m23717a(true, str2, attributes);
    }

    public void endElement(String str, String str2, String str3) throws SAXException {
        HtmlToSpannedConverter htmlToSpannedConverter = this;
        String str4 = str2;
        if (str4.equalsIgnoreCase("br")) {
            htmlToSpannedConverter.f21738n.append('\n');
        } else if (str4.equalsIgnoreCase("p")) {
            m23716a(htmlToSpannedConverter.f21738n, true);
        } else if (str4.equalsIgnoreCase("div")) {
            m23716a(htmlToSpannedConverter.f21738n, true);
        } else if (str4.equalsIgnoreCase("strong")) {
            m23714a(htmlToSpannedConverter.f21738n, Bold.class, new StyleSpan(1));
        } else if (str4.equalsIgnoreCase("b")) {
            m23714a(htmlToSpannedConverter.f21738n, Bold.class, new StyleSpan(1));
        } else if (str4.equalsIgnoreCase("em")) {
            m23714a(htmlToSpannedConverter.f21738n, Italic.class, new StyleSpan(2));
        } else if (str4.equalsIgnoreCase("cite")) {
            m23714a(htmlToSpannedConverter.f21738n, Italic.class, new StyleSpan(2));
        } else if (str4.equalsIgnoreCase("dfn")) {
            m23714a(htmlToSpannedConverter.f21738n, Italic.class, new StyleSpan(2));
        } else if (str4.equalsIgnoreCase("i")) {
            m23714a(htmlToSpannedConverter.f21738n, Italic.class, new StyleSpan(2));
        } else if (str4.equalsIgnoreCase("big")) {
            m23714a(htmlToSpannedConverter.f21738n, Big.class, new RelativeSizeSpan(1.25f));
        } else if (str4.equalsIgnoreCase("small")) {
            m23714a(htmlToSpannedConverter.f21738n, Small.class, new RelativeSizeSpan(0.8f));
        } else if (str4.equalsIgnoreCase("font")) {
            r2 = htmlToSpannedConverter.f21738n;
            r3 = r2.length();
            r7 = m23710a(r2, Font.class);
            r9 = r2.getSpanStart(r7);
            r2.removeSpan(r7);
            if (r9 != r3) {
                Font font = (Font) r7;
                if (!(font == null || TextUtils.isEmpty(font.f21719a))) {
                    if (font.f21719a.startsWith("@")) {
                        Resources system = Resources.getSystem();
                        int identifier = system.getIdentifier(font.f21719a.substring(1), "color", "android");
                        if (identifier != 0) {
                            r2.setSpan(new TextAppearanceSpan(null, 0, 0, system.getColorStateList(identifier), null), r9, r3, 33);
                        }
                    } else {
                        int a = m23709a(font.f21719a);
                        if (a != -1) {
                            r2.setSpan(new ForegroundColorSpan(a | -16777216), r9, r3, 33);
                        }
                    }
                }
                if (!(font == null || font.f21720b == null)) {
                    r2.setSpan(new TypefaceSpan(font.f21720b), r9, r3, 33);
                }
            }
        } else if (str4.equalsIgnoreCase("blockquote")) {
            m23716a(htmlToSpannedConverter.f21738n, true);
            m23714a(htmlToSpannedConverter.f21738n, Blockquote.class, new BlockquoteSpan(htmlToSpannedConverter.f21741q, f21724e, f21725f));
        } else if (str4.equalsIgnoreCase("tt")) {
            m23714a(htmlToSpannedConverter.f21738n, Monospace.class, new TypefaceSpan("monospace"));
        } else if (str4.equalsIgnoreCase("a")) {
            m23711a(htmlToSpannedConverter.f21738n, Href.class);
            r2 = htmlToSpannedConverter.f21738n;
            r3 = r2.length();
            r7 = m23710a(r2, Href.class);
            r9 = r2.getSpanStart(r7);
            r2.removeSpan(r7);
            if (r9 != r3) {
                Href href = (Href) r7;
                if (!(href == null || href.f21722a == null)) {
                    if (!href.f21722a.toLowerCase(Locale.US).startsWith("/s") || href.f21723b == null) {
                        r2.setSpan(new UrlToNativeWebViewSpan(href.f21722a), r9, r3, 33);
                    } else {
                        r2.setSpan(new SpoilerSpan(href.f21723b), r9, r3, 33);
                    }
                }
            }
        } else if (str4.equalsIgnoreCase("u")) {
            m23714a(htmlToSpannedConverter.f21738n, Underline.class, new UnderlineSpan());
        } else if (str4.equalsIgnoreCase("sup")) {
            m23712a(htmlToSpannedConverter.f21738n, Super.class, false, new SuperscriptSpan(), new RelativeSizeSpan(0.8f));
        } else if (str4.equalsIgnoreCase("sub")) {
            m23712a(htmlToSpannedConverter.f21738n, Sub.class, false, new SubscriptSpan(), new RelativeSizeSpan(0.8f));
        } else if (str4.equalsIgnoreCase("del")) {
            m23714a(htmlToSpannedConverter.f21738n, Strikethrough.class, new StrikethroughSpan());
        } else if (str2.length() == 2 && str4.substring(0, 1).equals("h") && str4.charAt(1) >= '1' && str4.charAt(1) <= '6') {
            m23716a(htmlToSpannedConverter.f21738n, true);
            m23713a(htmlToSpannedConverter.f21738n);
        } else if (str4.equalsIgnoreCase("ul")) {
            htmlToSpannedConverter.f21732a.pop();
        } else if (str4.equalsIgnoreCase("ol")) {
            htmlToSpannedConverter.f21732a.pop();
            htmlToSpannedConverter.f21733b.pop();
        } else if (str4.equalsIgnoreCase("li")) {
            int i;
            if (((String) htmlToSpannedConverter.f21732a.peek()).equalsIgnoreCase("ul")) {
                if (htmlToSpannedConverter.f21738n.length() > 0 && htmlToSpannedConverter.f21738n.charAt(htmlToSpannedConverter.f21738n.length() - 1) != '\n') {
                    htmlToSpannedConverter.f21738n.append('\n');
                }
                i = f21727h;
                if (htmlToSpannedConverter.f21732a.size() > 1) {
                    i -= f21729j.getLeadingMargin(true);
                    if (htmlToSpannedConverter.f21732a.size() > 2) {
                        i -= (htmlToSpannedConverter.f21732a.size() - 2) * f21728i;
                    }
                }
                NestableBulletSpan nestableBulletSpan = new NestableBulletSpan(f21728i * htmlToSpannedConverter.f21732a.size(), f21726g, i);
                m23712a(htmlToSpannedConverter.f21738n, Ul.class, false, nestableBulletSpan);
            } else if (((String) htmlToSpannedConverter.f21732a.peek()).equalsIgnoreCase("ol")) {
                if (htmlToSpannedConverter.f21738n.length() > 0 && htmlToSpannedConverter.f21738n.charAt(htmlToSpannedConverter.f21738n.length() - 1) != '\n') {
                    htmlToSpannedConverter.f21738n.append('\n');
                }
                i = f21728i * (htmlToSpannedConverter.f21732a.size() - 1);
                if (htmlToSpannedConverter.f21732a.size() > 2) {
                    i -= (htmlToSpannedConverter.f21732a.size() - 2) * f21728i;
                }
                m23712a(htmlToSpannedConverter.f21738n, Ol.class, false, new Standard(i));
            }
        } else if (str4.equalsIgnoreCase("code")) {
            m23712a(htmlToSpannedConverter.f21738n, Code.class, false, new TypefaceSpan("monospace"));
        } else if (str4.equalsIgnoreCase("center")) {
            m23712a(htmlToSpannedConverter.f21738n, Center.class, true, new AlignmentSpan.Standard(Alignment.ALIGN_CENTER));
        } else {
            if (!str4.equalsIgnoreCase("s")) {
                if (!str4.equalsIgnoreCase("strike")) {
                    if (str4.equalsIgnoreCase("table")) {
                        htmlToSpannedConverter.f21735d--;
                        if (htmlToSpannedConverter.f21735d != 0) {
                            m23714a(htmlToSpannedConverter.f21738n, Table.class, Boolean.valueOf(false));
                        }
                    } else if (str4.equalsIgnoreCase("th")) {
                        m23711a(htmlToSpannedConverter.f21738n, Th.class);
                        m23714a(htmlToSpannedConverter.f21738n, Th.class, Boolean.valueOf(false));
                    } else if (str4.equalsIgnoreCase("td")) {
                        m23711a(htmlToSpannedConverter.f21738n, Td.class);
                        m23714a(htmlToSpannedConverter.f21738n, Td.class, Boolean.valueOf(false));
                    }
                }
            }
            m23712a(htmlToSpannedConverter.f21738n, Strike.class, false, new StrikethroughSpan());
        }
        Attributes attributes = null;
        m23717a(false, str4, null);
        if (str4.equalsIgnoreCase("table") && htmlToSpannedConverter.f21735d == 0) {
            str4 = htmlToSpannedConverter.f21734c.toString();
            DrawTableLinkSpan a2 = htmlToSpannedConverter.f21740p != null ? htmlToSpannedConverter.f21740p.m28720a() : null;
            if (htmlToSpannedConverter.f21739o != null) {
                attributes = htmlToSpannedConverter.f21739o.mo5069a();
                attributes.m28718a(str4);
            }
            m23712a(htmlToSpannedConverter.f21738n, Table.class, false, a2, attributes);
        }
    }
}
