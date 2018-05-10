package io.reactivex.internal.subscribers;

public final class BlockingLastSubscriber<T> extends BlockingBaseSubscriber<T> {
    public final void onNext(T t) {
        this.a = t;
    }

    public final void onError(Throwable th) {
        this.a = null;
        this.b = th;
        countDown();
    }
}
