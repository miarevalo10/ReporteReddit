package com.google.android.gms.internal;

import java.util.concurrent.Callable;

final class zzahj implements Callable<Void> {
    private /* synthetic */ Runnable f6372a;

    zzahj(Runnable runnable) {
        this.f6372a = runnable;
    }

    public final /* synthetic */ Object call() throws Exception {
        this.f6372a.run();
        return null;
    }
}
