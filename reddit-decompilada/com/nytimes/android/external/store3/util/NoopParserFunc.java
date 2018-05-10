package com.nytimes.android.external.store3.util;

import com.nytimes.android.external.store3.base.Parser;

public class NoopParserFunc<Raw, Parsed> implements Parser<Raw, Parsed> {
    public Parsed apply(Raw raw) throws ParserException {
        return raw;
    }
}
