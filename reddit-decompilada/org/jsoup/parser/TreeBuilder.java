package org.jsoup.parser;

import java.util.ArrayList;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

abstract class TreeBuilder {
    private StartTag f27159a = new StartTag();
    private EndTag f27160b = new EndTag();
    CharacterReader f27161l;
    Tokeniser f27162m;
    protected Document f27163n;
    protected ArrayList<Element> f27164o;
    protected String f27165p;
    protected Token f27166q;
    protected ParseErrorList f27167r;
    protected ParseSettings f27168s;

    abstract ParseSettings mo6346a();

    protected abstract boolean mo6348a(Token token);

    TreeBuilder() {
    }

    protected void mo6352b(String str, String str2, ParseErrorList parseErrorList, ParseSettings parseSettings) {
        Validate.m28453a((Object) str, "String input must not be null");
        Validate.m28453a((Object) str2, "BaseURI must not be null");
        this.f27163n = new Document(str2);
        this.f27168s = parseSettings;
        this.f27161l = new CharacterReader(str);
        this.f27167r = parseErrorList;
        this.f27162m = new Tokeniser(this.f27161l, parseErrorList);
        this.f27164o = new ArrayList(32);
        this.f27165p = str2;
    }

    Document mo6345a(String str, String str2, ParseErrorList parseErrorList, ParseSettings parseSettings) {
        mo6352b(str, str2, parseErrorList, parseSettings);
        do {
            Tokeniser tokeniser = this.f27162m;
            if (tokeniser.f27102n == null) {
                tokeniser.m28603b("Self closing flag not acknowledged");
                tokeniser.f27102n = true;
            }
            while (tokeniser.f27092d == null) {
                tokeniser.f27090b.mo6351a(tokeniser, tokeniser.f27089a);
            }
            if (tokeniser.f27094f.length() > null) {
                str2 = tokeniser.f27094f.toString();
                tokeniser.f27094f.delete(0, tokeniser.f27094f.length());
                tokeniser.f27093e = null;
                str = tokeniser.f27099k;
                str.f33363b = str2;
            } else if (tokeniser.f27093e != null) {
                str2 = tokeniser.f27099k;
                str2.f33363b = tokeniser.f27093e;
                tokeniser.f27093e = null;
                str = str2;
            } else {
                tokeniser.f27092d = false;
                str = tokeniser.f27091c;
            }
            mo6348a(str);
            str.mo6350a();
        } while (str.f27085a != TokenType.EOF);
        return this.f27163n;
    }

    protected final boolean m28621l(String str) {
        if (this.f27166q == this.f27159a) {
            return mo6348a(new StartTag().m34058a(str));
        }
        return mo6348a(this.f27159a.mo6857h().m34058a(str));
    }

    public boolean mo6347a(String str, Attributes attributes) {
        if (this.f27166q == this.f27159a) {
            return mo6348a(new StartTag().m36605a(str, attributes));
        }
        this.f27159a.mo6857h();
        this.f27159a.m36605a(str, attributes);
        return mo6348a(this.f27159a);
    }

    protected final boolean m28622m(String str) {
        if (this.f27166q == this.f27160b) {
            return mo6348a(new EndTag().m34058a(str));
        }
        return mo6348a(this.f27160b.mo6857h().m34058a(str));
    }

    protected final Element m28623p() {
        int size = this.f27164o.size();
        return size > 0 ? (Element) this.f27164o.get(size - 1) : null;
    }
}
