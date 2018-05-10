package io.reactivex.internal.subscribers;

import io.reactivex.plugins.RxJavaPlugins;

public final class BlockingFirstSubscriber<T> extends BlockingBaseSubscriber<T> {
    public final void onNext(T t) {
        if (this.a == null) {
            this.a = t;
            this.c.cancel();
            countDown();
        }
    }

    public final void onError(Throwable th) {
        if (this.a == null) {
            this.b = th;
        } else {
            RxJavaPlugins.m26757a(th);
        }
        countDown();
    }
}
