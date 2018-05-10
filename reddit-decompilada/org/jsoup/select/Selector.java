package org.jsoup.select;

import org.jsoup.helper.Validate;
import org.jsoup.nodes.Element;

public class Selector {
    private final Evaluator f27178a;
    private final Element f27179b;

    public static class SelectorParseException extends IllegalStateException {
        public SelectorParseException(String str, Object... objArr) {
            super(String.format(str, objArr));
        }
    }

    private Selector(String str, Element element) {
        Validate.m28452a((Object) str);
        str = str.trim();
        Validate.m28454a(str);
        Validate.m28452a((Object) element);
        this.f27178a = QueryParser.m28630a(str);
        this.f27179b = element;
    }

    public static Elements m28637a(String str, Element element) {
        Selector selector = new Selector(str, element);
        return Collector.m28624a(selector.f27178a, selector.f27179b);
    }
}
