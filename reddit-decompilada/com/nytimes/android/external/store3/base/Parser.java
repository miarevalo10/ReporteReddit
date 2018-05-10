package com.nytimes.android.external.store3.base;

import com.nytimes.android.external.store3.util.ParserException;
import io.reactivex.functions.Function;

public interface Parser<Raw, Parsed> extends Function<Raw, Parsed> {
    Parsed apply(Raw raw) throws ParserException;
}
