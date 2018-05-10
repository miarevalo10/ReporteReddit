package com.nytimes.android.external.store3.util;

import com.nytimes.android.external.store3.base.Parser;

public class NoKeyParser<Key, Raw, Parsed> implements KeyParser<Key, Raw, Parsed> {
    private final Parser<Raw, Parsed> f18674a;

    public NoKeyParser(Parser<Raw, Parsed> parser) {
        this.f18674a = parser;
    }

    public Parsed apply(Key key, Raw raw) throws ParserException {
        return this.f18674a.apply(raw);
    }
}
