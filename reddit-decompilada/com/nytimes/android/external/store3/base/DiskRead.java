package com.nytimes.android.external.store3.base;

import io.reactivex.Maybe;

public interface DiskRead<Raw, Key> {
    Maybe<Raw> mo2708a(Key key);
}
