package com.nytimes.android.external.store3.base;

import io.reactivex.Single;

public interface Fetcher<Raw, Key> {
    Single<Raw> mo2915a(Key key);
}
