package org.jsoup.nodes;

import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import org.jsoup.helper.StringUtil;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document.OutputSettings;
import org.jsoup.nodes.Document.OutputSettings.Syntax;
import org.jsoup.parser.Tag;
import org.jsoup.select.Collector;
import org.jsoup.select.Elements;
import org.jsoup.select.Evaluator;
import org.jsoup.select.NodeTraversor;
import org.jsoup.select.NodeVisitor;

public class Element extends Node {
    private static final Pattern f33333a = Pattern.compile("\\s+");
    public Tag f33334c;

    public final /* synthetic */ Node mo6336b(String str, String str2) {
        return m33923a(str, str2);
    }

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return mo6856c();
    }

    public /* synthetic */ Node mo6338d() {
        return mo6856c();
    }

    public final /* synthetic */ Node mo6339d(Node node) {
        return mo6335b(node);
    }

    public Element(Tag tag, String str, Attributes attributes) {
        super(str, attributes);
        Validate.m28452a((Object) tag);
        this.f33334c = tag;
    }

    public Element(Tag tag, String str) {
        this(tag, str, new Attributes());
    }

    public String mo6328a() {
        return this.f33334c.f27068a;
    }

    public final Element m33923a(String str, String str2) {
        super.mo6336b(str, str2);
        return this;
    }

    public final Element m33934e() {
        return (Element) m33935f().get(0);
    }

    public final Elements m33935f() {
        List arrayList = new ArrayList(this.e.size());
        for (Node node : this.e) {
            if (node instanceof Element) {
                arrayList.add((Element) node);
            }
        }
        return new Elements(arrayList);
    }

    public final Element mo6334a(Node node) {
        Validate.m28452a((Object) node);
        m28509e(node);
        m28515q();
        this.e.add(node);
        node.f27000h = this.e.size() - 1;
        return this;
    }

    public final Element mo6335b(Node node) {
        return (Element) super.mo6339d(node);
    }

    public final Element m33936g() {
        if (this.d == null) {
            return null;
        }
        List f = ((Element) this.d).m33935f();
        Object a = m33916a(this, f);
        Validate.m28452a(a);
        if (a.intValue() > 0) {
            return (Element) f.get(a.intValue() - 1);
        }
        return null;
    }

    private static <E extends Element> Integer m33916a(Element element, List<E> list) {
        Validate.m28452a((Object) element);
        Validate.m28452a((Object) list);
        for (int i = 0; i < list.size(); i++) {
            if (((Element) list.get(i)) == element) {
                return Integer.valueOf(i);
            }
        }
        return null;
    }

    public final Elements m33925a(String str) {
        Validate.m28454a(str);
        return Collector.m28624a(new Evaluator.Tag(str.toLowerCase().trim()), this);
    }

    public final String m33938i() {
        final StringBuilder stringBuilder = new StringBuilder();
        new NodeTraversor(new NodeVisitor(this) {
            final /* synthetic */ Element f33332b;

            public final void mo6333b(Node node, int i) {
            }

            public final void mo6332a(Node node, int i) {
                if ((node instanceof TextNode) != 0) {
                    Element.m33920b(stringBuilder, (TextNode) node);
                    return;
                }
                if ((node instanceof Element) != 0) {
                    Element element = (Element) node;
                    if (stringBuilder.length() > 0 && (!(element.f33334c.f27069b == 0 && element.f33334c.f27068a.equals("br") == null) && TextNode.m33946a(stringBuilder) == null)) {
                        stringBuilder.append(" ");
                    }
                }
            }
        }).m28627a(this);
        return stringBuilder.toString().trim();
    }

    public final String m33939j() {
        StringBuilder stringBuilder = new StringBuilder();
        m33919b(stringBuilder);
        return stringBuilder.toString().trim();
    }

    private void m33919b(StringBuilder stringBuilder) {
        for (Node node : this.e) {
            if (node instanceof TextNode) {
                m33920b(stringBuilder, (TextNode) node);
            } else if ((node instanceof Element) && ((Element) node).f33334c.f27068a.equals("br") && !TextNode.m33946a(stringBuilder)) {
                stringBuilder.append(" ");
            }
        }
    }

    private static void m33920b(StringBuilder stringBuilder, TextNode textNode) {
        String c = textNode.m33953c();
        if (m33921c(textNode.d) != null) {
            stringBuilder.append(c);
        } else {
            StringUtil.m28446a(stringBuilder, c, TextNode.m33946a(stringBuilder));
        }
    }

    static boolean m33921c(Node node) {
        if (node == null || !(node instanceof Element)) {
            return false;
        }
        Element element = (Element) node;
        if (!element.f33334c.f27073f) {
            if (((Element) element.d) == null || ((Element) element.d).f33334c.f27073f == null) {
                return false;
            }
        }
        return true;
    }

    public final String m33940k() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Node node : this.e) {
            if (node instanceof DataNode) {
                stringBuilder.append(((DataNode) node).m33908b());
            } else if (node instanceof Comment) {
                stringBuilder.append(((Comment) node).m33904b());
            } else if (node instanceof Element) {
                stringBuilder.append(((Element) node).m33940k());
            }
        }
        return stringBuilder.toString();
    }

    final void mo6330b(Appendable appendable, int i, OutputSettings outputSettings) throws IOException {
        if (!this.e.isEmpty() || !this.f33334c.m28569a()) {
            if (outputSettings.f26972c && !this.e.isEmpty() && (this.f33334c.f27070c || (outputSettings.f26973d && (this.e.size() > 1 || (this.e.size() == 1 && !(this.e.get(0) instanceof TextNode)))))) {
                Node.m28498c(appendable, i, outputSettings);
            }
            appendable.append("</").append(this.f33334c.f27068a).append(Operation.GREATER_THAN);
        }
    }

    final void m33927a(StringBuilder stringBuilder) {
        for (Node a : this.e) {
            a.m28500a((Appendable) stringBuilder);
        }
    }

    public String toString() {
        return aU_();
    }

    public Element mo6856c() {
        return (Element) super.mo6338d();
    }

    public final Integer m33937h() {
        if (((Element) this.d) == null) {
            return Integer.valueOf(0);
        }
        return m33916a(this, ((Element) this.d).m33935f());
    }

    final void mo6329a(Appendable appendable, int i, OutputSettings outputSettings) throws IOException {
        if (outputSettings.f26972c && ((this.f33334c.f27070c || ((((Element) this.d) != null && ((Element) this.d).f33334c.f27070c) || outputSettings.f26973d)) && (!(appendable instanceof StringBuilder) || ((StringBuilder) appendable).length() > 0))) {
            Node.m28498c(appendable, i, outputSettings);
        }
        appendable.append(Operation.LESS_THAN).append(this.f33334c.f27068a);
        this.f.m28469a(appendable, outputSettings);
        if (this.e.isEmpty() == 0 || this.f33334c.m28569a() == 0) {
            appendable.append(Operation.GREATER_THAN);
        } else if (outputSettings.f26975f != Syntax.html || this.f33334c.f27071d == 0) {
            appendable.append(" />");
        } else {
            appendable.append(62);
        }
    }

    public final /* bridge */ /* synthetic */ Node mo6340l() {
        return (Element) this.d;
    }
}
