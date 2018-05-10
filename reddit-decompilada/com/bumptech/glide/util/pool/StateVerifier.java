package com.bumptech.glide.util.pool;

public abstract class StateVerifier {

    private static class DefaultStateVerifier extends StateVerifier {
        private volatile boolean f12674a;

        DefaultStateVerifier() {
            super();
        }

        public final void mo1031b() {
            if (this.f12674a) {
                throw new IllegalStateException("Already released");
            }
        }

        public final void mo1030a(boolean z) {
            this.f12674a = z;
        }
    }

    abstract void mo1030a(boolean z);

    public abstract void mo1031b();

    public static StateVerifier m3247a() {
        return new DefaultStateVerifier();
    }

    private StateVerifier() {
    }
}
