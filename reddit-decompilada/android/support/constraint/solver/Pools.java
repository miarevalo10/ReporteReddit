package android.support.constraint.solver;

final class Pools {

    interface Pool<T> {
        T mo11a();

        void mo12a(T[] tArr, int i);

        boolean mo13a(T t);
    }

    static class SimplePool<T> implements Pool<T> {
        private final Object[] f10993a = new Object[256];
        private int f10994b;

        SimplePool() {
        }

        public final T mo11a() {
            if (this.f10994b <= 0) {
                return null;
            }
            int i = this.f10994b - 1;
            T t = this.f10993a[i];
            this.f10993a[i] = null;
            this.f10994b--;
            return t;
        }

        public final boolean mo13a(T t) {
            if (this.f10994b >= this.f10993a.length) {
                return null;
            }
            this.f10993a[this.f10994b] = t;
            this.f10994b += 1;
            return true;
        }

        public final void mo12a(T[] tArr, int i) {
            if (i > tArr.length) {
                i = tArr.length;
            }
            for (int i2 = 0; i2 < i; i2++) {
                T t = tArr[i2];
                if (this.f10994b < this.f10993a.length) {
                    this.f10993a[this.f10994b] = t;
                    this.f10994b++;
                }
            }
        }
    }
}
