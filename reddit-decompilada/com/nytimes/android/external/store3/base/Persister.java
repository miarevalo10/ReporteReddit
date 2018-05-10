package com.nytimes.android.external.store3.base;

import io.reactivex.Maybe;
import io.reactivex.Single;

public interface Persister<Raw, Key> extends DiskRead<Raw, Key>, DiskWrite<Raw, Key> {
    Maybe<Raw> mo2708a(Key key);

    Single<Boolean> mo2709a(Key key, Raw raw);
}
