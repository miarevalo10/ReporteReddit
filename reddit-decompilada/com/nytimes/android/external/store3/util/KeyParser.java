package com.nytimes.android.external.store3.util;

import io.reactivex.functions.BiFunction;

public interface KeyParser<Key, Raw, Parsed> extends BiFunction<Key, Raw, Parsed> {
    Parsed apply(Key key, Raw raw) throws ParserException;
}
