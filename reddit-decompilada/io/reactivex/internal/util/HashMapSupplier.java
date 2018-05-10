package io.reactivex.internal.util;

import java.util.Map;
import java.util.concurrent.Callable;

public enum HashMapSupplier implements Callable<Map<Object, Object>> {
    ;

    private HashMapSupplier(String str) {
    }

    public static <K, V> Callable<Map<K, V>> m26692a() {
        return f25188a;
    }
}
