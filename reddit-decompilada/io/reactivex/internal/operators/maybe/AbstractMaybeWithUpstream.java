package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeSource;

abstract class AbstractMaybeWithUpstream<T, R> extends Maybe<R> {
    protected final MaybeSource<T> f35548a;

    AbstractMaybeWithUpstream(MaybeSource<T> maybeSource) {
        this.f35548a = maybeSource;
    }
}
