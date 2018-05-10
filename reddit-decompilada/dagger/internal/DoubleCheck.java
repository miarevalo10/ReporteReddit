package dagger.internal;

import dagger.Lazy;
import javax.inject.Provider;

public final class DoubleCheck<T> implements Lazy<T>, Provider<T> {
    static final /* synthetic */ boolean f30832a = true;
    private static final Object f30833b = new Object();
    private volatile Provider<T> f30834c;
    private volatile Object f30835d = f30833b;

    private DoubleCheck(Provider<T> provider) {
        if (f30832a || provider != null) {
            this.f30834c = provider;
            return;
        }
        throw new AssertionError();
    }

    public final T get() {
        T t = this.f30835d;
        if (t == f30833b) {
            synchronized (this) {
                t = this.f30835d;
                if (t == f30833b) {
                    t = this.f30834c.get();
                    T t2 = this.f30835d;
                    if (t2 == f30833b || t2 == t) {
                        this.f30835d = t;
                        this.f30834c = null;
                    } else {
                        StringBuilder stringBuilder = new StringBuilder("Scoped provider was invoked recursively returning different results: ");
                        stringBuilder.append(t2);
                        stringBuilder.append(" & ");
                        stringBuilder.append(t);
                        stringBuilder.append(". This is likely due to a circular dependency.");
                        throw new IllegalStateException(stringBuilder.toString());
                    }
                }
            }
        }
        return t;
    }

    public static <P extends Provider<T>, T> Provider<T> m31842a(P p) {
        Preconditions.m26012a(p);
        if (p instanceof DoubleCheck) {
            return p;
        }
        return new DoubleCheck(p);
    }

    public static <P extends Provider<T>, T> Lazy<T> m31843b(P p) {
        if (p instanceof Lazy) {
            return (Lazy) p;
        }
        return new DoubleCheck((Provider) Preconditions.m26012a(p));
    }
}
