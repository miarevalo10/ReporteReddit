package io.reactivex.internal.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.QueueDrainHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public final class InnerQueuedSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T>, Subscription {
    final InnerQueuedSubscriberSupport<T> f35914a;
    final int f35915b;
    public final int f35916c;
    public volatile SimpleQueue<T> f35917d;
    public volatile boolean f35918e;
    public long f35919f;
    public int f35920g;

    public InnerQueuedSubscriber(InnerQueuedSubscriberSupport<T> innerQueuedSubscriberSupport, int i) {
        this.f35914a = innerQueuedSubscriberSupport;
        this.f35915b = i;
        this.f35916c = i - (i >> 2);
    }

    public final void mo5623a(Subscription subscription) {
        if (SubscriptionHelper.m32779a((AtomicReference) this, subscription)) {
            if (subscription instanceof QueueSubscription) {
                QueueSubscription queueSubscription = (QueueSubscription) subscription;
                int a = queueSubscription.mo7033a(3);
                if (a == 1) {
                    this.f35920g = a;
                    this.f35917d = queueSubscription;
                    this.f35918e = true;
                    this.f35914a.mo6620a(this);
                    return;
                } else if (a == 2) {
                    this.f35920g = a;
                    this.f35917d = queueSubscription;
                    QueueDrainHelper.m26729a(subscription, this.f35915b);
                    return;
                }
            }
            this.f35917d = QueueDrainHelper.m26725a(this.f35915b);
            QueueDrainHelper.m26729a(subscription, this.f35915b);
        }
    }

    public final void onNext(T t) {
        if (this.f35920g == 0) {
            this.f35914a.mo6621a(this, (Object) t);
        } else {
            this.f35914a.mo6619a();
        }
    }

    public final void onError(Throwable th) {
        this.f35914a.mo6622a(this, th);
    }

    public final void onComplete() {
        this.f35914a.mo6620a(this);
    }

    public final void request(long j) {
        if (this.f35920g != 1) {
            long j2 = this.f35919f + j;
            if (j2 >= ((long) this.f35916c)) {
                this.f35919f = 0;
                ((Subscription) get()).request(j2);
                return;
            }
            this.f35919f = j2;
        }
    }

    public final void cancel() {
        SubscriptionHelper.m32777a((AtomicReference) this);
    }
}
