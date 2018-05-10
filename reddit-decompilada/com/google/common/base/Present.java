package com.google.common.base;

final class Present<T> extends Optional<T> {
    private final T f14836a;

    public final boolean mo2315b() {
        return true;
    }

    Present(T t) {
        this.f14836a = t;
    }

    public final T mo2316c() {
        return this.f14836a;
    }

    public final T mo2314a(T t) {
        Preconditions.m6909a((Object) t, (Object) "use Optional.orNull() instead of Optional.or(null)");
        return this.f14836a;
    }

    public final T mo2317d() {
        return this.f14836a;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Present)) {
            return null;
        }
        return this.f14836a.equals(((Present) obj).f14836a);
    }

    public final int hashCode() {
        return 1502476572 + this.f14836a.hashCode();
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("Optional.of(");
        stringBuilder.append(this.f14836a);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
