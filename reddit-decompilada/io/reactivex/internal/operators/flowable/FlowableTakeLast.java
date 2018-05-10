package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableTakeLast<T> extends AbstractFlowableWithUpstream<T, T> {
    final int f37838a;

    static final class TakeLastSubscriber<T> extends ArrayDeque<T> implements FlowableSubscriber<T>, Subscription {
        final Subscriber<? super T> f35394a;
        final int f35395b;
        Subscription f35396c;
        volatile boolean f35397d;
        volatile boolean f35398e;
        final AtomicLong f35399f = new AtomicLong();
        final AtomicInteger f35400g = new AtomicInteger();

        TakeLastSubscriber(Subscriber<? super T> subscriber, int i) {
            this.f35394a = subscriber;
            this.f35395b = i;
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32781a(this.f35396c, subscription)) {
                this.f35396c = subscription;
                this.f35394a.mo5623a(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public final void onNext(T t) {
            if (this.f35395b == size()) {
                poll();
            }
            offer(t);
        }

        public final void onError(Throwable th) {
            this.f35394a.onError(th);
        }

        public final void onComplete() {
            this.f35397d = true;
            m35854a();
        }

        public final void request(long j) {
            if (SubscriptionHelper.m32776a(j)) {
                BackpressureHelper.m26670a(this.f35399f, j);
                m35854a();
            }
        }

        public final void cancel() {
            this.f35398e = true;
            this.f35396c.cancel();
        }

        private void m35854a() {
            if (this.f35400g.getAndIncrement() == 0) {
                Subscriber subscriber = this.f35394a;
                long j = this.f35399f.get();
                while (!this.f35398e) {
                    if (this.f35397d) {
                        long j2 = 0;
                        while (j2 != j) {
                            if (!this.f35398e) {
                                Object poll = poll();
                                if (poll == null) {
                                    subscriber.onComplete();
                                    return;
                                } else {
                                    subscriber.onNext(poll);
                                    j2++;
                                }
                            } else {
                                return;
                            }
                        }
                        if (!(j2 == 0 || j == Long.MAX_VALUE)) {
                            j = this.f35399f.addAndGet(-j2);
                        }
                    }
                    if (this.f35400g.decrementAndGet() == 0) {
                    }
                }
            }
        }
    }

    public FlowableTakeLast(Flowable<T> flowable, int i) {
        super(flowable);
        this.f37838a = i;
    }

    protected final void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe(new TakeLastSubscriber(subscriber, this.f37838a));
    }
}
