package io.reactivex.internal.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public final class BlockingSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T>, Subscription {
    public static final Object f35905a = new Object();
    final Queue<Object> f35906b;

    public BlockingSubscriber(Queue<Object> queue) {
        this.f35906b = queue;
    }

    public final void mo5623a(Subscription subscription) {
        if (SubscriptionHelper.m32779a((AtomicReference) this, subscription) != null) {
            this.f35906b.offer(NotificationLite.m26698a((Subscription) this));
        }
    }

    public final void onNext(T t) {
        this.f35906b.offer(NotificationLite.m26696a((Object) t));
    }

    public final void onError(Throwable th) {
        this.f35906b.offer(NotificationLite.m26697a(th));
    }

    public final void onComplete() {
        this.f35906b.offer(NotificationLite.m26694a());
    }

    public final void request(long j) {
        ((Subscription) get()).request(j);
    }

    public final void cancel() {
        if (SubscriptionHelper.m32777a((AtomicReference) this)) {
            this.f35906b.offer(f35905a);
        }
    }

    public final boolean m35997a() {
        return get() == SubscriptionHelper.f32454a;
    }
}
