package io.reactivex.internal.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public abstract class SinglePostCompleteSubscriber<T, R> extends AtomicLong implements FlowableSubscriber<T>, Subscription {
    protected final Subscriber<? super R> f35925d;
    protected Subscription f35926e;
    protected R f35927f;
    protected long f35928g;

    public void mo7046a(R r) {
    }

    public SinglePostCompleteSubscriber(Subscriber<? super R> subscriber) {
        this.f35925d = subscriber;
    }

    public final void mo5623a(Subscription subscription) {
        if (SubscriptionHelper.m32781a(this.f35926e, subscription)) {
            this.f35926e = subscription;
            this.f35925d.mo5623a(this);
        }
    }

    protected final void m36008b(R r) {
        long j = this.f35928g;
        if (j != 0) {
            BackpressureHelper.m26673c(this, j);
        }
        while (true) {
            j = get();
            if ((j & Long.MIN_VALUE) != 0) {
                mo7046a((Object) r);
                return;
            } else if ((j & Long.MAX_VALUE) != 0) {
                lazySet(-9223372036854775807L);
                this.f35925d.onNext(r);
                this.f35925d.onComplete();
                return;
            } else {
                this.f35927f = r;
                if (!compareAndSet(0, Long.MIN_VALUE)) {
                    this.f35927f = null;
                } else {
                    return;
                }
            }
        }
    }

    public final void request(long j) {
        if (SubscriptionHelper.m32776a(j)) {
            long j2;
            do {
                j2 = get();
                if ((j2 & Long.MIN_VALUE) != 0) {
                    if (compareAndSet(Long.MIN_VALUE, -9223372036854775807L) != null) {
                        this.f35925d.onNext(this.f35927f);
                        this.f35925d.onComplete();
                        return;
                    }
                }
            } while (!compareAndSet(j2, BackpressureHelper.m26669a(j2, j)));
            this.f35926e.request(j);
        }
    }

    public void cancel() {
        this.f35926e.cancel();
    }
}
