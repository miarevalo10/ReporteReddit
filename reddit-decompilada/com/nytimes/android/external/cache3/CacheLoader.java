package com.nytimes.android.external.cache3;

import java.util.Map;

public abstract class CacheLoader<K, V> {

    public static final class InvalidCacheLoadException extends RuntimeException {
        public InvalidCacheLoadException(String str) {
            super(str);
        }
    }

    public static final class UnsupportedLoadingOperationException extends UnsupportedOperationException {
        UnsupportedLoadingOperationException() {
        }
    }

    public abstract V mo2705a(K k) throws Exception;

    protected CacheLoader() {
    }

    public static Map<K, V> m8541a() throws Exception {
        throw new UnsupportedLoadingOperationException();
    }
}
