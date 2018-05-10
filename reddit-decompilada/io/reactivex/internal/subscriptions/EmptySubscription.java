package io.reactivex.internal.subscriptions;

import io.reactivex.internal.fuseable.QueueSubscription;
import org.reactivestreams.Subscriber;

public enum EmptySubscription implements QueueSubscription<Object> {
    ;

    public final int mo7033a(int i) {
        return i & 2;
    }

    public final void cancel() {
    }

    public final void clear() {
    }

    public final boolean isEmpty() {
        return true;
    }

    public final Object poll() {
        return null;
    }

    public final String toString() {
        return "EmptySubscription";
    }

    private EmptySubscription(String str) {
    }

    public final void request(long j) {
        SubscriptionHelper.m32776a(j);
    }

    public static void m38160a(Throwable th, Subscriber<?> subscriber) {
        subscriber.mo5623a(f38145a);
        subscriber.onError(th);
    }

    public static void m38161a(Subscriber<?> subscriber) {
        subscriber.mo5623a(f38145a);
        subscriber.onComplete();
    }

    public final boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
