package com.google.firebase.internal;

import java.util.concurrent.atomic.AtomicReference;

public final class zzb {
    private static final AtomicReference<zzb> f8695a = new AtomicReference();

    private zzb() {
    }

    public static zzb m7434a() {
        f8695a.compareAndSet(null, new zzb());
        return (zzb) f8695a.get();
    }

    public static void m7435b() {
    }
}
