package io.gsonfire.util;

import java.util.Iterator;

public final class SimpleIterable<T> implements Iterable<T> {
    private final Iterable<T> f24974a;

    private SimpleIterable(Iterable<T> iterable) {
        this.f24974a = iterable;
    }

    public final Iterator<T> iterator() {
        return this.f24974a.iterator();
    }

    public static <T> SimpleIterable<T> m26462a(Iterable<T> iterable) {
        return new SimpleIterable(iterable);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                SimpleIterable simpleIterable = (SimpleIterable) obj;
                if (this.f24974a == null) {
                    return simpleIterable.f24974a == null;
                } else {
                    if (this.f24974a.equals(simpleIterable.f24974a) == null) {
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f24974a != null ? this.f24974a.hashCode() : 0;
    }

    public final String toString() {
        return this.f24974a.toString();
    }
}
