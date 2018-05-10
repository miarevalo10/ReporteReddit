package com.nytimes.android.external.store3.base.impl;

import com.nytimes.android.external.cache3.Cache;
import com.nytimes.android.external.cache3.CacheBuilder;
import com.nytimes.android.external.cache3.Preconditions;
import io.reactivex.Maybe;
import io.reactivex.Single;
import java.util.concurrent.TimeUnit;

final class CacheFactory {
    private CacheFactory() {
    }

    static <Key, Parsed> Cache<Key, Maybe<Parsed>> m8696a(MemoryPolicy memoryPolicy) {
        if (memoryPolicy == null) {
            return CacheBuilder.m8534a().m8535a(100).m8536a(StoreDefaults.m8710a(), StoreDefaults.m8711b()).m8539d();
        }
        if (memoryPolicy.f10237b == -1) {
            return CacheBuilder.m8534a().m8535a(memoryPolicy.f10239d).m8536a(memoryPolicy.f10236a, memoryPolicy.f10238c).m8539d();
        }
        CacheBuilder a = CacheBuilder.m8534a().m8535a(memoryPolicy.f10239d);
        long j = memoryPolicy.f10237b;
        memoryPolicy = memoryPolicy.f10238c;
        Preconditions.m8676b(a.f10121k == -1, "expireAfterAccess was already set to %s ns", Long.valueOf(a.f10121k));
        Preconditions.m8674a(j >= 0, "duration cannot be negative: %s %s", Long.valueOf(j), memoryPolicy);
        a.f10121k = memoryPolicy.toNanos(j);
        return a.m8539d();
    }

    static <Key, Parsed> Cache<Key, Single<Parsed>> m8697b(MemoryPolicy memoryPolicy) {
        long toSeconds;
        if (memoryPolicy == null) {
            toSeconds = StoreDefaults.m8711b().toSeconds(StoreDefaults.m8710a());
        } else {
            toSeconds = memoryPolicy.f10238c.toSeconds(memoryPolicy.f10236a);
        }
        long toSeconds2 = TimeUnit.MINUTES.toSeconds(1);
        if (toSeconds > toSeconds2) {
            return CacheBuilder.m8534a().m8536a(toSeconds2, TimeUnit.SECONDS).m8539d();
        }
        if (memoryPolicy == null) {
            toSeconds = StoreDefaults.m8710a();
        } else {
            toSeconds = memoryPolicy.f10236a;
        }
        if (memoryPolicy == null) {
            memoryPolicy = StoreDefaults.m8711b();
        } else {
            memoryPolicy = memoryPolicy.f10238c;
        }
        return CacheBuilder.m8534a().m8536a(toSeconds, memoryPolicy).m8539d();
    }
}
