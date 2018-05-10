package com.google.common.collect;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import java.util.Iterator;

public abstract class FluentIterable<E> implements Iterable<E> {
    private final Optional<Iterable<E>> f8423a;

    protected FluentIterable() {
        this.f8423a = Optional.m6898e();
    }

    FluentIterable(Iterable<E> iterable) {
        Preconditions.m6908a((Object) iterable);
        if (this == iterable) {
            iterable = null;
        }
        this.f8423a = Optional.m6897c(iterable);
    }

    public final Iterable<E> m7111a() {
        return (Iterable) this.f8423a.mo2314a(this);
    }

    public static <E> FluentIterable<E> m7110a(final Iterable<E> iterable) {
        return iterable instanceof FluentIterable ? (FluentIterable) iterable : new FluentIterable<E>(iterable) {
            public final Iterator<E> iterator() {
                return iterable.iterator();
            }
        };
    }

    public String toString() {
        return Iterables.m7136a(m7111a());
    }
}
