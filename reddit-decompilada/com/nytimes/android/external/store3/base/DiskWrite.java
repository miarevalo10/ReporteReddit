package com.nytimes.android.external.store3.base;

import io.reactivex.Single;

public interface DiskWrite<Raw, Key> {
    Single<Boolean> mo2709a(Key key, Raw raw);
}
