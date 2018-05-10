package com.google.common.base;

final class Absent<T> extends Optional<T> {
    static final Absent<Object> f14826a = new Absent();

    public final boolean mo2315b() {
        return false;
    }

    public final T mo2317d() {
        return null;
    }

    public final boolean equals(Object obj) {
        return obj == this;
    }

    public final int hashCode() {
        return 2040732332;
    }

    public final String toString() {
        return "Optional.absent()";
    }

    static <T> Optional<T> m14535a() {
        return f14826a;
    }

    private Absent() {
    }

    public final T mo2316c() {
        throw new IllegalStateException("Optional.get() cannot be called on an absent value");
    }

    public final T mo2314a(T t) {
        return Preconditions.m6909a((Object) t, (Object) "use Optional.orNull() instead of Optional.or(null)");
    }
}
