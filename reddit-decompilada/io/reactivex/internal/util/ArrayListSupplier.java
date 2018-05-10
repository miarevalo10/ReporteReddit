package io.reactivex.internal.util;

import io.reactivex.functions.Function;
import java.util.List;
import java.util.concurrent.Callable;

public enum ArrayListSupplier implements Function<Object, List<Object>>, Callable<List<Object>> {
    ;

    private ArrayListSupplier(String str) {
    }

    public static <T> Callable<List<T>> m32783a() {
        return f32456a;
    }

    public static <T, O> Function<O, List<T>> m32784b() {
        return f32456a;
    }
}
