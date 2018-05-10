package org.jsoup.parser;

import com.coremedia.iso.boxes.MetaBox;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.helper.StringUtil;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Comment;
import org.jsoup.nodes.DataNode;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.FormElement;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.Node.C26601;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.NodeTraversor;

public class HtmlTreeBuilder extends TreeBuilder {
    public static final String[] f33342a = new String[]{"applet", "caption", "html", "table", "td", "th", "marquee", "object"};
    static final /* synthetic */ boolean f33343k = true;
    private static final String[] f33344t = new String[]{"ol", "ul"};
    private static final String[] f33345u = new String[]{"button"};
    private static final String[] f33346v = new String[]{"html", "table"};
    private static final String[] f33347w = new String[]{"optgroup", "option"};
    private static final String[] f33348x = new String[]{"dd", "dt", "li", "option", "optgroup", "p", "rp", "rt"};
    private static final String[] f33349y = new String[]{"address", "applet", "area", "article", "aside", "base", "basefont", "bgsound", "blockquote", "body", "br", "button", "caption", "center", "col", "colgroup", "command", "dd", "details", "dir", "div", "dl", "dt", "embed", "fieldset", "figcaption", "figure", "footer", "form", "frame", "frameset", "h1", "h2", "h3", "h4", "h5", "h6", "head", "header", "hgroup", "hr", "html", "iframe", "img", "input", "isindex", "li", "link", "listing", "marquee", "menu", MetaBox.TYPE, "nav", "noembed", "noframes", "noscript", "object", "ol", "p", "param", "plaintext", "pre", "script", "section", "select", "style", "summary", "table", "tbody", "td", "textarea", "tfoot", "th", "thead", "title", "tr", "ul", "wbr", "xmp"};
    private Element f33350A;
    private EndTag f33351B = new EndTag();
    private String[] f33352C = new String[]{null};
    HtmlTreeBuilderState f33353b;
    HtmlTreeBuilderState f33354c;
    Element f33355d;
    FormElement f33356e;
    ArrayList<Element> f33357f = new ArrayList();
    List<String> f33358g = new ArrayList();
    boolean f33359h = true;
    boolean f33360i = false;
    boolean f33361j = false;
    private boolean f33362z = false;

    HtmlTreeBuilder() {
    }

    final ParseSettings mo6346a() {
        return ParseSettings.f27052a;
    }

    final Document mo6345a(String str, String str2, ParseErrorList parseErrorList, ParseSettings parseSettings) {
        this.f33353b = HtmlTreeBuilderState.f27024a;
        this.f33362z = false;
        return super.mo6345a(str, str2, parseErrorList, parseSettings);
    }

    protected final boolean mo6348a(Token token) {
        this.q = token;
        return this.f33353b.mo6349a(token, this);
    }

    final boolean m33983a(Token token, HtmlTreeBuilderState htmlTreeBuilderState) {
        this.q = token;
        return htmlTreeBuilderState.mo6349a(token, this);
    }

    final void m33986b() {
        this.f33354c = this.f33353b;
    }

    final Document m33990c() {
        return this.n;
    }

    final String m33993d() {
        return this.p;
    }

    final void m33974a(Element element) {
        if (!this.f33362z) {
            Object d = element.mo6343d("href");
            if (d.length() != 0) {
                this.p = d;
                this.f33362z = true;
                Node node = this.n;
                Validate.m28452a(d);
                Object c26601 = new C26601(node, d);
                Validate.m28452a(c26601);
                new NodeTraversor(c26601).m28627a(node);
            }
        }
    }

    final void m33977a(HtmlTreeBuilderState htmlTreeBuilderState) {
        if (this.r.m28561a()) {
            this.r.add(new ParseError(this.l.f27003c, "Unexpected token [%s] when in state [%s]", this.q.getClass().getSimpleName(), htmlTreeBuilderState));
        }
    }

    final Element m33970a(String str) {
        Element element = new Element(Tag.m28567a(str, this.s), this.p);
        m33968i(element);
        return element;
    }

    private void m33968i(Element element) {
        m33965b((Node) element);
        this.o.add(element);
    }

    final Element m33985b(StartTag startTag) {
        Tag a = Tag.m28567a(startTag.m34069j(), this.s);
        Node element = new Element(a, this.p, startTag.g);
        m33965b(element);
        if (startTag.f33375f != null) {
            if (a.m28570b() == null) {
                a.f27072e = true;
                this.m.f27102n = true;
            } else if (a.m28569a() != null) {
                this.m.f27102n = true;
            }
        }
        return element;
    }

    final FormElement m33972a(StartTag startTag, boolean z) {
        Node formElement = new FormElement(Tag.m28567a(startTag.m34069j(), this.s), this.p, startTag.g);
        this.f33356e = formElement;
        m33965b(formElement);
        if (z) {
            this.o.add(formElement);
        }
        return formElement;
    }

    final void m33979a(Comment comment) {
        m33965b(new Comment(comment.f33364b.toString(), this.p));
    }

    final void m33978a(Character character) {
        Node textNode;
        String str = m28623p().f33334c.f27068a;
        if (!str.equals("script")) {
            if (!str.equals("style")) {
                textNode = new TextNode(character.f33363b, this.p);
                m28623p().mo6334a(textNode);
            }
        }
        textNode = new DataNode(character.f33363b, this.p);
        m28623p().mo6334a(textNode);
    }

    private void m33965b(Node node) {
        if (this.o.size() == 0) {
            this.n.mo6334a(node);
        } else if (this.f33360i) {
            m33976a(node);
        } else {
            m28623p().mo6334a(node);
        }
        if (node instanceof Element) {
            Element element = (Element) node;
            if (element.f33334c.f27074g && this.f33356e != null) {
                this.f33356e.f36232a.add(element);
            }
        }
    }

    final Element m33996e() {
        return (Element) this.o.remove(this.o.size() - 1);
    }

    final void m33987b(Element element) {
        this.o.add(element);
    }

    final ArrayList<Element> m33999f() {
        return this.o;
    }

    final boolean m33992c(Element element) {
        return m33963a(this.o, element);
    }

    static boolean m33963a(ArrayList<Element> arrayList, Element element) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (((Element) arrayList.get(size)) == element) {
                return true;
            }
        }
        return null;
    }

    final Element m33984b(String str) {
        for (int size = this.o.size() - 1; size >= 0; size--) {
            Element element = (Element) this.o.get(size);
            if (element.mo6328a().equals(str)) {
                return element;
            }
        }
        return null;
    }

    final boolean m33995d(Element element) {
        for (int size = this.o.size() - 1; size >= 0; size--) {
            if (((Element) this.o.get(size)) == element) {
                this.o.remove(size);
                return true;
            }
        }
        return null;
    }

    final void m33991c(String str) {
        int size = this.o.size() - 1;
        while (size >= 0) {
            Element element = (Element) this.o.get(size);
            this.o.remove(size);
            if (!element.mo6328a().equals(str)) {
                size--;
            } else {
                return;
            }
        }
    }

    final void m33980a(String... strArr) {
        int size = this.o.size() - 1;
        while (size >= 0) {
            Element element = (Element) this.o.get(size);
            this.o.remove(size);
            if (!StringUtil.m28448a(element.mo6328a(), strArr)) {
                size--;
            } else {
                return;
            }
        }
    }

    final void m33994d(String str) {
        int size = this.o.size() - 1;
        while (size >= 0 && !((Element) this.o.get(size)).mo6328a().equals(str)) {
            this.o.remove(size);
            size--;
        }
    }

    final void m34001g() {
        m33966c("table");
    }

    final void m34004h() {
        m33966c("tbody", "tfoot", "thead");
    }

    final void m34007i() {
        m33966c("tr");
    }

    private void m33966c(String... strArr) {
        int size = this.o.size() - 1;
        while (size >= 0) {
            Element element = (Element) this.o.get(size);
            if (!StringUtil.m28448a(element.mo6328a(), strArr) && !element.mo6328a().equals("html")) {
                this.o.remove(size);
                size--;
            } else {
                return;
            }
        }
    }

    final Element m33997e(Element element) {
        if (f33343k || m33992c(element)) {
            for (int size = this.o.size() - 1; size >= 0; size--) {
                if (((Element) this.o.get(size)) == element) {
                    return (Element) this.o.get(size - 1);
                }
            }
            return null;
        }
        throw new AssertionError();
    }

    final void m33975a(Element element, Element element2) {
        element = this.o.lastIndexOf(element);
        Validate.m28456a(element != -1);
        this.o.add(element + 1, element2);
    }

    final void m33988b(Element element, Element element2) {
        m33960a(this.o, element, element2);
    }

    static void m33960a(ArrayList<Element> arrayList, Element element, Element element2) {
        element = arrayList.lastIndexOf(element);
        Validate.m28456a(element != -1);
        arrayList.set(element, element2);
    }

    final void m34009j() {
        int size = this.o.size() - 1;
        int i = 0;
        while (size >= 0) {
            Element element = (Element) this.o.get(size);
            if (size == 0) {
                element = this.f33350A;
                i = 1;
            }
            String a = element.mo6328a();
            if ("select".equals(a)) {
                this.f33353b = HtmlTreeBuilderState.f27039p;
                return;
            }
            if (!"td".equals(a)) {
                if (!"th".equals(a) || i != 0) {
                    if ("tr".equals(a)) {
                        this.f33353b = HtmlTreeBuilderState.f27037n;
                        return;
                    }
                    if (!("tbody".equals(a) || "thead".equals(a))) {
                        if (!"tfoot".equals(a)) {
                            if ("caption".equals(a)) {
                                this.f33353b = HtmlTreeBuilderState.f27034k;
                                return;
                            } else if ("colgroup".equals(a)) {
                                this.f33353b = HtmlTreeBuilderState.f27035l;
                                return;
                            } else if ("table".equals(a)) {
                                this.f33353b = HtmlTreeBuilderState.f27032i;
                                return;
                            } else if ("head".equals(a)) {
                                this.f33353b = HtmlTreeBuilderState.f27030g;
                                return;
                            } else if ("body".equals(a)) {
                                this.f33353b = HtmlTreeBuilderState.f27030g;
                                return;
                            } else if ("frameset".equals(a)) {
                                this.f33353b = HtmlTreeBuilderState.f27042s;
                                return;
                            } else if ("html".equals(a)) {
                                this.f33353b = HtmlTreeBuilderState.f27026c;
                                return;
                            } else if (i != 0) {
                                this.f33353b = HtmlTreeBuilderState.f27030g;
                                return;
                            } else {
                                size--;
                            }
                        }
                    }
                    this.f33353b = HtmlTreeBuilderState.f27036m;
                    return;
                }
            }
            this.f33353b = HtmlTreeBuilderState.f27038o;
            return;
        }
    }

    private boolean m33962a(String str, String[] strArr, String[] strArr2) {
        this.f33352C[0] = str;
        return m33964a(this.f33352C, strArr, strArr2);
    }

    private boolean m33964a(String[] strArr, String[] strArr2, String[] strArr3) {
        for (int size = this.o.size() - 1; size >= 0; size--) {
            String a = ((Element) this.o.get(size)).mo6328a();
            if (StringUtil.m28448a(a, strArr)) {
                return true;
            }
            if (StringUtil.m28448a(a, strArr2)) {
                return false;
            }
            if (strArr3 != null && StringUtil.m28448a(a, strArr3)) {
                return false;
            }
        }
        Validate.m28459b("Should not be reachable");
        return false;
    }

    final boolean m33989b(String[] strArr) {
        return m33964a(strArr, f33342a, null);
    }

    final boolean m33998e(String str) {
        return m33961a(str, null);
    }

    private boolean m33961a(String str, String[] strArr) {
        return m33962a(str, f33342a, strArr);
    }

    final boolean m34000f(String str) {
        return m33961a(str, f33344t);
    }

    final boolean m34003g(String str) {
        return m33961a(str, f33345u);
    }

    final boolean m34006h(String str) {
        return m33962a(str, f33346v, null);
    }

    final boolean m34008i(String str) {
        for (int size = this.o.size() - 1; size >= 0; size--) {
            String a = ((Element) this.o.get(size)).mo6328a();
            if (a.equals(str)) {
                return true;
            }
            if (!StringUtil.m28448a(a, f33347w)) {
                return false;
            }
        }
        Validate.m28459b("Should not be reachable");
        return false;
    }

    final void m34012k() {
        this.f33358g = new ArrayList();
    }

    final void m34010j(String str) {
        while (str != null && !m28623p().mo6328a().equals(str) && StringUtil.m28448a(m28623p().mo6328a(), f33348x)) {
            m33996e();
        }
    }

    final void m34013l() {
        m34010j(null);
    }

    static boolean m33967f(Element element) {
        return StringUtil.m28448a(element.mo6328a(), f33349y);
    }

    final void m34002g(Element element) {
        int i = 0;
        for (int size = this.f33357f.size() - 1; size >= 0; size--) {
            Element element2 = (Element) this.f33357f.get(size);
            if (element2 == null) {
                break;
            }
            int i2 = (element.mo6328a().equals(element2.mo6328a()) && element.mo6344m().equals(element2.mo6344m())) ? 1 : 0;
            if (i2 != 0) {
                i++;
            }
            if (i == 3) {
                this.f33357f.remove(size);
                break;
            }
        }
        this.f33357f.add(element);
    }

    final void m34015n() {
        while (!this.f33357f.isEmpty()) {
            Element element;
            int size = this.f33357f.size();
            if (size > 0) {
                element = (Element) this.f33357f.remove(size - 1);
                continue;
            } else {
                element = null;
                continue;
            }
            if (element == null) {
                return;
            }
        }
    }

    final void m34005h(Element element) {
        for (int size = this.f33357f.size() - 1; size >= 0; size--) {
            if (((Element) this.f33357f.get(size)) == element) {
                this.f33357f.remove(size);
                return;
            }
        }
    }

    final Element m34011k(String str) {
        int size = this.f33357f.size() - 1;
        while (size >= 0) {
            Element element = (Element) this.f33357f.get(size);
            if (element == null) {
                break;
            } else if (element.mo6328a().equals(str)) {
                return element;
            } else {
                size--;
            }
        }
        return null;
    }

    final void m34016o() {
        this.f33357f.add(null);
    }

    final void m33976a(Node node) {
        Element element;
        Object b = m33984b("table");
        int i = 0;
        if (b == null) {
            element = (Element) this.o.get(0);
        } else if (((Element) b.d) != null) {
            Node node2 = b.d;
            element = null;
            i = 1;
        } else {
            element = m33997e((Element) b);
        }
        if (i != 0) {
            Validate.m28452a(b);
            b.mo6335b(node);
            return;
        }
        element.mo6334a(node);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("TreeBuilder{currentToken=");
        stringBuilder.append(this.q);
        stringBuilder.append(", state=");
        stringBuilder.append(this.f33353b);
        stringBuilder.append(", currentElement=");
        stringBuilder.append(m28623p());
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    final Element m33971a(StartTag startTag) {
        if (startTag.f33375f) {
            startTag = m33985b(startTag);
            this.o.add(startTag);
            this.m.f27090b = TokeniserState.f27133a;
            this.m.m28599a(this.f33351B.mo6857h().m34058a(startTag.f33334c.f27068a));
            return startTag;
        }
        Element element = new Element(Tag.m28567a(startTag.m34069j(), this.s), this.p, this.s.m28563a(startTag.g));
        m33968i(element);
        return element;
    }

    final void m34014m() {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:37)
	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:61)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:33)
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
        r0 = r7.f33357f;
        r0 = r0.size();
        r1 = 1;
        if (r0 <= 0) goto L_0x0019;
    L_0x0009:
        r0 = r7.f33357f;
        r2 = r7.f33357f;
        r2 = r2.size();
        r2 = r2 - r1;
        r0 = r0.get(r2);
        r0 = (org.jsoup.nodes.Element) r0;
        goto L_0x001a;
    L_0x0019:
        r0 = 0;
    L_0x001a:
        if (r0 == 0) goto L_0x006e;
    L_0x001c:
        r2 = r7.m33992c(r0);
        if (r2 == 0) goto L_0x0023;
    L_0x0022:
        goto L_0x006e;
    L_0x0023:
        r2 = r7.f33357f;
        r2 = r2.size();
        r2 = r2 - r1;
        r3 = r0;
        r0 = r2;
    L_0x002c:
        r4 = 0;
        if (r0 != 0) goto L_0x0030;
    L_0x002f:
        goto L_0x0043;
    L_0x0030:
        r3 = r7.f33357f;
        r0 = r0 + -1;
        r3 = r3.get(r0);
        r3 = (org.jsoup.nodes.Element) r3;
        if (r3 == 0) goto L_0x0042;
    L_0x003c:
        r5 = r7.m33992c(r3);
        if (r5 == 0) goto L_0x002c;
    L_0x0042:
        r1 = r4;
    L_0x0043:
        if (r1 != 0) goto L_0x0050;
    L_0x0045:
        r1 = r7.f33357f;
        r0 = r0 + 1;
        r1 = r1.get(r0);
        r1 = (org.jsoup.nodes.Element) r1;
        r3 = r1;
    L_0x0050:
        org.jsoup.helper.Validate.m28452a(r3);
        r1 = r3.mo6328a();
        r1 = r7.m33970a(r1);
        r5 = r1.mo6344m();
        r6 = r3.mo6344m();
        r5.m28472a(r6);
        r5 = r7.f33357f;
        r5.set(r0, r1);
        if (r0 != r2) goto L_0x0042;
    L_0x006d:
        return;
    L_0x006e:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jsoup.parser.HtmlTreeBuilder.m():void");
    }
}
