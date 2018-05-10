package android.support.v4.util;

public final class Pools {

    public interface Pool<T> {
        T mo362a();

        boolean mo363a(T t);
    }

    public static class SimplePool<T> implements Pool<T> {
        private final Object[] f11446a;
        private int f11447b;

        public SimplePool(int i) {
            if (i <= 0) {
                throw new IllegalArgumentException("The max pool size must be > 0");
            }
            this.f11446a = new Object[i];
        }

        public T mo362a() {
            if (this.f11447b <= 0) {
                return null;
            }
            int i = this.f11447b - 1;
            T t = this.f11446a[i];
            this.f11446a[i] = null;
            this.f11447b--;
            return t;
        }

        public boolean mo363a(T t) {
            boolean z;
            for (int i = 0; i < this.f11447b; i++) {
                if (this.f11446a[i] == t) {
                    z = true;
                    break;
                }
            }
            z = false;
            if (z) {
                throw new IllegalStateException("Already in the pool!");
            } else if (this.f11447b >= this.f11446a.length) {
                return false;
            } else {
                this.f11446a[this.f11447b] = t;
                this.f11447b += 1;
                return true;
            }
        }
    }

    public static class SynchronizedPool<T> extends SimplePool<T> {
        private final Object f16505a = new Object();

        public SynchronizedPool(int i) {
            super(i);
        }

        public final T mo362a() {
            T a;
            synchronized (this.f16505a) {
                a = super.mo362a();
            }
            return a;
        }

        public final boolean mo363a(T t) {
            synchronized (this.f16505a) {
                t = super.mo363a(t);
            }
            return t;
        }
    }
}
