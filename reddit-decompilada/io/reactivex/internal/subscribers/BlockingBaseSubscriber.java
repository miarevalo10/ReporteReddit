package io.reactivex.internal.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.CountDownLatch;
import org.reactivestreams.Subscription;

public abstract class BlockingBaseSubscriber<T> extends CountDownLatch implements FlowableSubscriber<T> {
    T f35901a;
    Throwable f35902b;
    Subscription f35903c;
    volatile boolean f35904d;

    public BlockingBaseSubscriber() {
        super(1);
    }

    public final void mo5623a(Subscription subscription) {
        if (SubscriptionHelper.m32781a(this.f35903c, subscription)) {
            this.f35903c = subscription;
            if (!this.f35904d) {
                subscription.request(Long.MAX_VALUE);
                if (this.f35904d) {
                    this.f35903c = SubscriptionHelper.f32454a;
                    subscription.cancel();
                }
            }
        }
    }

    public final void onComplete() {
        countDown();
    }

    public final T m35994a() {
        if (getCount() != 0) {
            try {
                BlockingHelper.m26675a();
                await();
            } catch (Throwable e) {
                Subscription subscription = this.f35903c;
                this.f35903c = SubscriptionHelper.f32454a;
                if (subscription != null) {
                    subscription.cancel();
                }
                throw ExceptionHelper.m26682a(e);
            }
        }
        Throwable e2 = this.f35902b;
        if (e2 == null) {
            return this.f35901a;
        }
        throw ExceptionHelper.m26682a(e2);
    }
}
