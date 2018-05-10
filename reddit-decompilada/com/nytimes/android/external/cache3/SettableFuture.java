package com.nytimes.android.external.cache3;

import com.nytimes.android.external.cache3.AbstractFuture.TrustedFuture;

public final class SettableFuture<V> extends TrustedFuture<V> {
    public static <V> SettableFuture<V> m20596c() {
        return new SettableFuture();
    }

    private SettableFuture() {
    }

    public final boolean mo4089a(V v) {
        return super.mo4089a((Object) v);
    }

    public final boolean mo4090a(Throwable th) {
        return super.mo4090a(th);
    }
}
