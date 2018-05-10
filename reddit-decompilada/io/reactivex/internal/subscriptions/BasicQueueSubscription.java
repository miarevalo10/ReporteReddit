package io.reactivex.internal.subscriptions;

import io.reactivex.internal.fuseable.QueueSubscription;
import java.util.concurrent.atomic.AtomicLong;

public abstract class BasicQueueSubscription<T> extends AtomicLong implements QueueSubscription<T> {
    public final boolean offer(T t) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
