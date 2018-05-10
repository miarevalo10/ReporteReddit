package com.nytimes.android.external.cache3;

import java.util.concurrent.Executor;
import java.util.concurrent.Future;

public interface ListenableFuture<V> extends Future<V> {
    void mo2661a(Runnable runnable, Executor executor);
}
