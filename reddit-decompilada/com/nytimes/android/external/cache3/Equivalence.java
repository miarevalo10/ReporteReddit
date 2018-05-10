package com.nytimes.android.external.cache3;

import java.io.Serializable;

public abstract class Equivalence<T> {

    static final class Equals extends Equivalence<Object> implements Serializable {
        static final Equals f15645a = new Equals();

        Equals() {
        }

        protected final boolean mo2664b(Object obj, Object obj2) {
            return obj.equals(obj2);
        }

        protected final int mo2663b(Object obj) {
            return obj.hashCode();
        }
    }

    static final class Identity extends Equivalence<Object> implements Serializable {
        static final Identity f15646a = new Identity();

        protected final boolean mo2664b(Object obj, Object obj2) {
            return false;
        }

        Identity() {
        }

        protected final int mo2663b(Object obj) {
            return System.identityHashCode(obj);
        }
    }

    protected abstract int mo2663b(T t);

    protected abstract boolean mo2664b(T t, T t2);

    protected Equivalence() {
    }

    public final boolean m8546a(T t, T t2) {
        if (t == t2) {
            return true;
        }
        if (t != null) {
            if (t2 != null) {
                return mo2664b(t, t2);
            }
        }
        return null;
    }

    public final int m8545a(T t) {
        return t == null ? null : mo2663b(t);
    }

    public static Equivalence<Object> m8543a() {
        return Equals.f15645a;
    }

    public static Equivalence<Object> m8544b() {
        return Identity.f15646a;
    }
}
