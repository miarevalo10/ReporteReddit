package org.jsoup.parser;

import com.coremedia.iso.boxes.MetaBox;
import com.instabug.chat.model.Attachment;
import com.instabug.library.model.State;
import java.util.HashMap;
import java.util.Map;
import org.jsoup.helper.Validate;

public class Tag {
    private static final Map<String, Tag> f27060h = new HashMap();
    private static final String[] f27061l = new String[]{"html", "head", "body", "frameset", "script", "noscript", "style", MetaBox.TYPE, "link", "title", "frame", "noframes", "section", "nav", "aside", "hgroup", "header", "footer", "p", "h1", "h2", "h3", "h4", "h5", "h6", "ul", "ol", "pre", "div", "blockquote", "hr", "address", "figure", "figcaption", "form", "fieldset", "ins", "del", "s", "dl", "dt", "dd", "li", "table", "caption", "thead", "tfoot", "tbody", "colgroup", "col", "tr", "th", "td", Attachment.TYPE_VIDEO, Attachment.TYPE_AUDIO, "canvas", "details", "menu", "plaintext", "template", "article", "main", "svg", "math"};
    private static final String[] f27062m = new String[]{"object", "base", "font", "tt", "i", "b", "u", "big", "small", "em", "strong", "dfn", "code", "samp", "kbd", "var", "cite", "abbr", "time", "acronym", "mark", "ruby", "rt", "rp", "a", "img", "br", "wbr", "map", "q", "sub", "sup", "bdo", "iframe", "embed", "span", "input", "select", "textarea", "label", "button", "optgroup", "option", "legend", "datalist", "keygen", "output", "progress", "meter", "area", "param", "source", "track", "summary", "command", State.KEY_DEVICE, "area", "basefont", "bgsound", "menuitem", "param", "source", "track", "data", "bdi"};
    private static final String[] f27063n = new String[]{MetaBox.TYPE, "link", "base", "frame", "img", "br", "wbr", "embed", "hr", "input", "keygen", "col", "command", State.KEY_DEVICE, "area", "basefont", "bgsound", "menuitem", "param", "source", "track"};
    private static final String[] f27064o = new String[]{"title", "a", "p", "h1", "h2", "h3", "h4", "h5", "h6", "pre", "address", "li", "th", "td", "script", "style", "ins", "del", "s"};
    private static final String[] f27065p = new String[]{"pre", "plaintext", "title", "textarea"};
    private static final String[] f27066q = new String[]{"button", "fieldset", "input", "keygen", "object", "output", "select", "textarea"};
    private static final String[] f27067r = new String[]{"input", "keygen", "object", "select", "textarea"};
    public String f27068a;
    public boolean f27069b = true;
    public boolean f27070c = true;
    public boolean f27071d = false;
    boolean f27072e = false;
    public boolean f27073f = false;
    boolean f27074g = false;
    private boolean f27075i = true;
    private boolean f27076j = true;
    private boolean f27077k = false;

    static {
        int i = 0;
        for (String tag : f27061l) {
            m28568a(new Tag(tag));
        }
        for (String tag2 : f27062m) {
            Tag tag3 = new Tag(tag2);
            tag3.f27069b = false;
            tag3.f27075i = false;
            tag3.f27070c = false;
            m28568a(tag3);
        }
        for (Object obj : f27063n) {
            Object obj2 = (Tag) f27060h.get(obj2);
            Validate.m28452a(obj2);
            obj2.f27075i = false;
            obj2.f27076j = false;
            obj2.f27071d = true;
        }
        for (Object obj22 : f27064o) {
            obj22 = (Tag) f27060h.get(obj22);
            Validate.m28452a(obj22);
            obj22.f27070c = false;
        }
        for (Object obj222 : f27065p) {
            obj222 = (Tag) f27060h.get(obj222);
            Validate.m28452a(obj222);
            obj222.f27073f = true;
        }
        for (Object obj2222 : f27066q) {
            obj2222 = (Tag) f27060h.get(obj2222);
            Validate.m28452a(obj2222);
            obj2222.f27074g = true;
        }
        String[] strArr = f27067r;
        int length = strArr.length;
        while (i < length) {
            Object obj3 = (Tag) f27060h.get(strArr[i]);
            Validate.m28452a(obj3);
            obj3.f27077k = true;
            i++;
        }
    }

    private Tag(String str) {
        this.f27068a = str;
    }

    public static Tag m28567a(String str, ParseSettings parseSettings) {
        Validate.m28452a((Object) str);
        Tag tag = (Tag) f27060h.get(str);
        if (tag != null) {
            return tag;
        }
        str = parseSettings.m28562a(str);
        Validate.m28454a(str);
        tag = (Tag) f27060h.get(str);
        if (tag != null) {
            return tag;
        }
        tag = new Tag(str);
        tag.f27069b = null;
        tag.f27075i = true;
        return tag;
    }

    public final boolean m28569a() {
        if (!this.f27071d) {
            if (!this.f27072e) {
                return false;
            }
        }
        return true;
    }

    public final boolean m28570b() {
        return f27060h.containsKey(this.f27068a);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Tag)) {
            return false;
        }
        Tag tag = (Tag) obj;
        return this.f27068a.equals(tag.f27068a) && this.f27075i == tag.f27075i && this.f27076j == tag.f27076j && this.f27071d == tag.f27071d && this.f27070c == tag.f27070c && this.f27069b == tag.f27069b && this.f27073f == tag.f27073f && this.f27072e == tag.f27072e && this.f27074g == tag.f27074g && this.f27077k == tag.f27077k;
    }

    public int hashCode() {
        return (31 * ((((((((((((((((this.f27068a.hashCode() * 31) + this.f27069b) * 31) + this.f27070c) * 31) + this.f27075i) * 31) + this.f27076j) * 31) + this.f27071d) * 31) + this.f27072e) * 31) + this.f27073f) * 31) + this.f27074g)) + this.f27077k;
    }

    public String toString() {
        return this.f27068a;
    }

    private static void m28568a(Tag tag) {
        f27060h.put(tag.f27068a, tag);
    }
}
