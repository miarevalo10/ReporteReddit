package com.google.common.base;

import java.io.Serializable;

public abstract class Optional<T> implements Serializable {
    public abstract T mo2314a(T t);

    public abstract boolean mo2315b();

    public abstract T mo2316c();

    public abstract T mo2317d();

    public static <T> Optional<T> m6898e() {
        return Absent.m14535a();
    }

    public static <T> Optional<T> m6896b(T t) {
        return new Present(Preconditions.m6908a((Object) t));
    }

    Optional() {
    }

    public static <T> Optional<T> m6897c(T t) {
        if (t == null) {
            return Absent.m14535a();
        }
        return new Present(t);
    }
}
