package org.jsoup.parser;

import java.util.ArrayList;

public class ParseErrorList extends ArrayList<ParseError> {
    private final int f27051a;

    private ParseErrorList(int i, int i2) {
        super(i);
        this.f27051a = i2;
    }

    final boolean m28561a() {
        return size() < this.f27051a;
    }

    public static ParseErrorList m28560b() {
        return new ParseErrorList(0, 0);
    }

    public static ParseErrorList m28559a(int i) {
        return new ParseErrorList(16, i);
    }
}
