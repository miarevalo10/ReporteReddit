package com.bumptech.glide.load.engine.cache;

import android.support.v4.util.Pools.Pool;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.LruCache;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import com.bumptech.glide.util.pool.FactoryPools;
import com.bumptech.glide.util.pool.FactoryPools.Factory;
import com.bumptech.glide.util.pool.FactoryPools.Poolable;
import com.bumptech.glide.util.pool.StateVerifier;
import java.security.MessageDigest;

public class SafeKeyGenerator {
    private final LruCache<Key, String> f3468a = new LruCache(1000);
    private final Pool<PoolableDigestContainer> f3469b = FactoryPools.m3243a(10, new C10671(this));

    class C10671 implements Factory<PoolableDigestContainer> {
        final /* synthetic */ SafeKeyGenerator f12511a;

        C10671(SafeKeyGenerator safeKeyGenerator) {
            this.f12511a = safeKeyGenerator;
        }

        public final /* synthetic */ Object mo916a() {
            return C10671.m11429b();
        }

        private static PoolableDigestContainer m11429b() {
            try {
                return new PoolableDigestContainer(MessageDigest.getInstance("SHA-256"));
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static final class PoolableDigestContainer implements Poolable {
        final MessageDigest f12512a;
        private final StateVerifier f12513b = StateVerifier.m3247a();

        PoolableDigestContainer(MessageDigest messageDigest) {
            this.f12512a = messageDigest;
        }

        public final StateVerifier getVerifier() {
            return this.f12513b;
        }
    }

    public final String m2977a(Key key) {
        String str;
        synchronized (this.f3468a) {
            str = (String) this.f3468a.get(key);
        }
        if (str == null) {
            str = m2976b(key);
        }
        synchronized (this.f3468a) {
            this.f3468a.put(key, str);
        }
        return str;
    }

    private String m2976b(Key key) {
        PoolableDigestContainer poolableDigestContainer = (PoolableDigestContainer) Preconditions.m3217a(this.f3469b.mo362a());
        try {
            key.mo893a(poolableDigestContainer.f12512a);
            key = Util.m3227a(poolableDigestContainer.f12512a.digest());
            return key;
        } finally {
            this.f3469b.mo363a(poolableDigestContainer);
        }
    }
}
