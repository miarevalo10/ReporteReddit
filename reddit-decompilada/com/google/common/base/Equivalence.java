package com.google.common.base;

import java.io.Serializable;

public abstract class Equivalence<T> {

    static final class Equals extends Equivalence<Object> implements Serializable {
        static final Equals f14829a = new Equals();

        Equals() {
        }

        protected final boolean mo2321b(Object obj, Object obj2) {
            return obj.equals(obj2);
        }

        protected final int mo2320b(Object obj) {
            return obj.hashCode();
        }
    }

    static final class Identity extends Equivalence<Object> implements Serializable {
        static final Identity f14830a = new Identity();

        protected final boolean mo2321b(Object obj, Object obj2) {
            return false;
        }

        Identity() {
        }

        protected final int mo2320b(Object obj) {
            return System.identityHashCode(obj);
        }
    }

    protected abstract int mo2320b(T t);

    protected abstract boolean mo2321b(T t, T t2);

    protected Equivalence() {
    }

    public final boolean m6878a(T t, T t2) {
        if (t == t2) {
            return true;
        }
        if (t != null) {
            if (t2 != null) {
                return mo2321b(t, t2);
            }
        }
        return null;
    }

    public final int m6877a(T t) {
        return t == null ? null : mo2320b(t);
    }

    public static Equivalence<Object> m6875a() {
        return Equals.f14829a;
    }

    public static Equivalence<Object> m6876b() {
        return Identity.f14830a;
    }
}
