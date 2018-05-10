package com.google.android.gms.internal;

import java.util.concurrent.Callable;

final class zzahi implements Callable<Void> {
    private /* synthetic */ Runnable f6371a;

    zzahi(Runnable runnable) {
        this.f6371a = runnable;
    }

    public final /* synthetic */ Object call() throws Exception {
        this.f6371a.run();
        return null;
    }
}
