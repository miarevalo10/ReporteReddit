package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeSource;
import io.reactivex.functions.Function;
import org.reactivestreams.Publisher;

public enum MaybeToPublisher implements Function<MaybeSource<Object>, Publisher<Object>> {
    ;

    private MaybeToPublisher(String str) {
    }

    public static <T> Function<MaybeSource<T>, Publisher<T>> m32335a() {
        return f31537a;
    }
}
