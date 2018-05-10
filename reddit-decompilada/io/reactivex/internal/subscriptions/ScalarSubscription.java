package io.reactivex.internal.subscriptions;

import io.reactivex.internal.fuseable.QueueSubscription;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Subscriber;

public final class ScalarSubscription<T> extends AtomicInteger implements QueueSubscription<T> {
    final T f38147a;
    final Subscriber<? super T> f38148b;

    public final int mo7033a(int i) {
        return i & 1;
    }

    public ScalarSubscription(Subscriber<? super T> subscriber, T t) {
        this.f38148b = subscriber;
        this.f38147a = t;
    }

    public final void request(long j) {
        if (!(SubscriptionHelper.m32776a(j) == null || compareAndSet(0, 1) == null)) {
            j = this.f38148b;
            j.onNext(this.f38147a);
            if (get() != 2) {
                j.onComplete();
            }
        }
    }

    public final void cancel() {
        lazySet(2);
    }

    public final boolean offer(T t) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public final T poll() {
        if (get() != 0) {
            return null;
        }
        lazySet(1);
        return this.f38147a;
    }

    public final boolean isEmpty() {
        return get() != 0;
    }

    public final void clear() {
        lazySet(1);
    }
}
