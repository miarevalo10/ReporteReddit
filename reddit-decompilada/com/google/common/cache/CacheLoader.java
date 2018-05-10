package com.google.common.cache;

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

    public abstract V mo2376a(K k) throws Exception;

    protected CacheLoader() {
    }

    public static Map<K, V> m6955a() throws Exception {
        throw new UnsupportedLoadingOperationException();
    }
}
