package com.nytimes.android.external.store3.base.impl;

import com.nytimes.android.external.store3.base.InternalStore;
import io.reactivex.Single;

public class RealStore<Parsed, Key> implements Store<Parsed, Key> {
    private final InternalStore<Parsed, Key> f15693a;

    public RealStore(InternalStore<Parsed, Key> internalStore) {
        this.f15693a = internalStore;
    }

    public final Single<Parsed> mo2713a(Key key) {
        return this.f15693a.mo2713a(key);
    }

    public final Single<Parsed> mo2714b(Key key) {
        return this.f15693a.mo2714b(key);
    }
}
