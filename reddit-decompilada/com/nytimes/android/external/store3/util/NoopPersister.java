package com.nytimes.android.external.store3.util;

import com.nytimes.android.external.cache3.Cache;
import com.nytimes.android.external.cache3.CacheBuilder;
import com.nytimes.android.external.store3.base.Persister;
import com.nytimes.android.external.store3.base.impl.MemoryPolicy;
import io.reactivex.Maybe;
import io.reactivex.Single;
import java.util.concurrent.TimeUnit;

public class NoopPersister<Raw, Key> implements Persister<Raw, Key> {
    protected final Cache<Key, Maybe<Raw>> f18675a;

    private NoopPersister(MemoryPolicy memoryPolicy) {
        this.f18675a = CacheBuilder.m8534a().m8536a(memoryPolicy.f10236a, memoryPolicy.f10238c).m8539d();
    }

    public static <Raw, Key> NoopPersister<Raw, Key> m19634a(MemoryPolicy memoryPolicy) {
        if (memoryPolicy == null) {
            memoryPolicy = MemoryPolicy.m8700a().m8698a(TimeUnit.HOURS.toSeconds(24));
            memoryPolicy.f10232a = TimeUnit.SECONDS;
            memoryPolicy = memoryPolicy.m8699a();
        }
        return new NoopPersister(memoryPolicy);
    }

    public final Maybe<Raw> mo2708a(Key key) {
        Maybe maybe = (Maybe) this.f18675a.getIfPresent(key);
        return maybe == null ? Maybe.empty() : maybe;
    }

    public final Single<Boolean> mo2709a(Key key, Raw raw) {
        this.f18675a.put(key, Maybe.just(raw));
        return Single.just(Boolean.valueOf(true));
    }
}
