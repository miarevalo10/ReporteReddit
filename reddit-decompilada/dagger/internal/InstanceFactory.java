package dagger.internal;

import dagger.Lazy;

public final class InstanceFactory<T> implements Lazy<T>, Factory<T> {
    private static final InstanceFactory<Object> f34669a = new InstanceFactory(null);
    private final T f34670b;

    public static <T> Factory<T> m35583a(T t) {
        return new InstanceFactory(Preconditions.m26013a(t, "instance cannot be null"));
    }

    private InstanceFactory(T t) {
        this.f34670b = t;
    }

    public final T get() {
        return this.f34670b;
    }
}
