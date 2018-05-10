package com.google.common.util.concurrent;

public final class SettableFuture<V> extends TrustedFuture<V> {
    public static <V> SettableFuture<V> m21569e() {
        return new SettableFuture();
    }

    public final boolean mo4399a(V v) {
        return super.mo4399a((Object) v);
    }

    public final boolean mo4400a(Throwable th) {
        return super.mo4400a(th);
    }

    private SettableFuture() {
    }
}
