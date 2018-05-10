package org.jsoup.nodes;

import java.nio.charset.Charset;
import org.jsoup.nodes.Entities.EscapeMode;
import org.jsoup.parser.ParseSettings;
import org.jsoup.parser.Tag;

public class Document extends Element {
    public OutputSettings f36228a = new OutputSettings();
    public QuirksMode f36229b = QuirksMode.noQuirks;
    private String f36230i;
    private boolean f36231j = false;

    public static class OutputSettings implements Cloneable {
        EscapeMode f26970a = EscapeMode.base;
        public Charset f26971b = Charset.forName("UTF-8");
        boolean f26972c = true;
        boolean f26973d = false;
        int f26974e = 1;
        public Syntax f26975f = Syntax.html;

        public enum Syntax {
            html,
            xml
        }

        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            return m28477a();
        }

        public final OutputSettings m28478a(String str) {
            this.f26971b = Charset.forName(str);
            return this;
        }

        public final OutputSettings m28477a() {
            try {
                OutputSettings outputSettings = (OutputSettings) super.clone();
                outputSettings.m28478a(this.f26971b.name());
                outputSettings.f26970a = EscapeMode.valueOf(this.f26970a.name());
                return outputSettings;
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }
    }

    public enum QuirksMode {
        noQuirks,
        quirks,
        limitedQuirks
    }

    public final String mo6328a() {
        return "#document";
    }

    public final /* synthetic */ Element mo6856c() {
        return m36600t();
    }

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return m36600t();
    }

    public final /* synthetic */ Node mo6338d() {
        return m36600t();
    }

    public Document(String str) {
        super(Tag.m28567a("#root", ParseSettings.f27052a), str);
        this.f36230i = str;
    }

    public final Element m36602a(String str, Node node) {
        if (node.mo6328a().equals(str)) {
            return (Element) node;
        }
        for (Node a : node.f26997e) {
            Element a2 = m36602a(str, a);
            if (a2 != null) {
                return a2;
            }
        }
        return null;
    }

    private Document m36600t() {
        Document document = (Document) super.mo6856c();
        document.f36228a = this.f36228a.m28477a();
        return document;
    }

    public final String aU_() {
        StringBuilder stringBuilder = new StringBuilder();
        super.m33927a(stringBuilder);
        return m28517s().f26972c ? stringBuilder.toString().trim() : stringBuilder.toString();
    }
}
