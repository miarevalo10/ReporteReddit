package com.google.android.gms.internal;

import java.util.concurrent.Executor;

final class zzalc implements Executor {
    zzalc() {
    }

    public final void execute(Runnable runnable) {
        runnable.run();
    }
}
