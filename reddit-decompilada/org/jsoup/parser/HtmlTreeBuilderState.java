package org.jsoup.parser;

import com.coremedia.iso.boxes.MetaBox;
import org.jsoup.helper.StringUtil;

enum HtmlTreeBuilderState {
    ;
    
    static String f27047x = "\u0000";

    private static final class Constants {
        private static final String[] f27007a = null;
        private static final String[] f27008b = null;
        private static final String[] f27009c = null;
        private static final String[] f27010d = null;
        private static final String[] f27011e = null;
        private static final String[] f27012f = null;
        private static final String[] f27013g = null;
        private static final String[] f27014h = null;
        private static final String[] f27015i = null;
        private static final String[] f27016j = null;
        private static final String[] f27017k = null;
        private static final String[] f27018l = null;
        private static final String[] f27019m = null;
        private static final String[] f27020n = null;
        private static final String[] f27021o = null;
        private static final String[] f27022p = null;
        private static final String[] f27023q = null;

        static {
            f27007a = new String[]{"base", "basefont", "bgsound", "command", "link", MetaBox.TYPE, "noframes", "script", "style", "title"};
            f27008b = new String[]{"address", "article", "aside", "blockquote", "center", "details", "dir", "div", "dl", "fieldset", "figcaption", "figure", "footer", "header", "hgroup", "menu", "nav", "ol", "p", "section", "summary", "ul"};
            f27009c = new String[]{"h1", "h2", "h3", "h4", "h5", "h6"};
            f27010d = new String[]{"pre", "listing"};
            f27011e = new String[]{"address", "div", "p"};
            f27012f = new String[]{"dd", "dt"};
            f27013g = new String[]{"b", "big", "code", "em", "font", "i", "s", "small", "strike", "strong", "tt", "u"};
            f27014h = new String[]{"applet", "marquee", "object"};
            f27015i = new String[]{"area", "br", "embed", "img", "keygen", "wbr"};
            f27016j = new String[]{"param", "source", "track"};
            f27017k = new String[]{"name", "action", "prompt"};
            f27018l = new String[]{"optgroup", "option"};
            f27019m = new String[]{"rp", "rt"};
            f27020n = new String[]{"caption", "col", "colgroup", "frame", "head", "tbody", "td", "tfoot", "th", "thead", "tr"};
            f27021o = new String[]{"address", "article", "aside", "blockquote", "button", "center", "details", "dir", "div", "dl", "fieldset", "figcaption", "figure", "footer", "header", "hgroup", "listing", "menu", "nav", "ol", "pre", "section", "summary", "ul"};
            f27022p = new String[]{"a", "b", "big", "code", "em", "font", "i", "nobr", "s", "small", "strike", "strong", "tt", "u"};
            f27023q = new String[]{"table", "tbody", "tfoot", "thead", "tr"};
        }
    }

    abstract boolean mo6349a(Token token, HtmlTreeBuilder htmlTreeBuilder);

    static boolean m28556a(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!StringUtil.m28449b(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
