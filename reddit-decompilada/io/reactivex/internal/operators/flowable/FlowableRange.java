package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;

public final class FlowableRange extends Flowable<Integer> {
    final int f35207a;
    final int f35208b;

    static abstract class BaseRangeSubscription extends BasicQueueSubscription<Integer> {
        final int f39508a;
        int f39509b;
        volatile boolean f39510c;

        public final int mo7033a(int i) {
            return i & 1;
        }

        abstract void mo7598a();

        abstract void mo7599a(long j);

        BaseRangeSubscription(int i, int i2) {
            this.f39509b = i;
            this.f39508a = i2;
        }

        public final boolean isEmpty() {
            return this.f39509b == this.f39508a;
        }

        public final void clear() {
            this.f39509b = this.f39508a;
        }

        public final void request(long j) {
            if (SubscriptionHelper.m32776a(j) && BackpressureHelper.m26670a((AtomicLong) this, j) == 0) {
                if (j == Long.MAX_VALUE) {
                    mo7598a();
                    return;
                }
                mo7599a(j);
            }
        }

        public final void cancel() {
            this.f39510c = true;
        }

        public /* synthetic */ Object poll() throws Exception {
            int i = this.f39509b;
            if (i == this.f39508a) {
                return null;
            }
            this.f39509b = i + 1;
            return Integer.valueOf(i);
        }
    }

    static final class RangeConditionalSubscription extends BaseRangeSubscription {
        final ConditionalSubscriber<? super Integer> f40251d;

        RangeConditionalSubscription(ConditionalSubscriber<? super Integer> conditionalSubscriber, int i, int i2) {
            super(i, i2);
            this.f40251d = conditionalSubscriber;
        }

        final void mo7598a() {
            int i = this.a;
            ConditionalSubscriber conditionalSubscriber = this.f40251d;
            int i2 = this.b;
            while (i2 != i) {
                if (!this.c) {
                    conditionalSubscriber.mo7052a(Integer.valueOf(i2));
                    i2++;
                } else {
                    return;
                }
            }
            if (!this.c) {
                conditionalSubscriber.onComplete();
            }
        }

        final void mo7599a(long j) {
            int i = this.a;
            int i2 = this.b;
            ConditionalSubscriber conditionalSubscriber = this.f40251d;
            long j2 = j;
            loop0:
            do {
                j = 0;
                while (true) {
                    if (j == j2 || i2 == i) {
                        if (i2 == i) {
                            break loop0;
                        }
                        j2 = get();
                        if (j == j2) {
                            this.b = i2;
                            j2 = addAndGet(-j);
                        }
                    } else if (!this.c) {
                        if (conditionalSubscriber.mo7052a(Integer.valueOf(i2))) {
                            j++;
                        }
                        i2++;
                    } else {
                        return;
                    }
                }
                if (this.c == null) {
                    conditionalSubscriber.onComplete();
                }
                return;
            } while (j2 != 0);
        }
    }

    static final class RangeSubscription extends BaseRangeSubscription {
        final Subscriber<? super Integer> f40252d;

        RangeSubscription(Subscriber<? super Integer> subscriber, int i, int i2) {
            super(i, i2);
            this.f40252d = subscriber;
        }

        final void mo7598a() {
            int i = this.a;
            Subscriber subscriber = this.f40252d;
            int i2 = this.b;
            while (i2 != i) {
                if (!this.c) {
                    subscriber.onNext(Integer.valueOf(i2));
                    i2++;
                } else {
                    return;
                }
            }
            if (!this.c) {
                subscriber.onComplete();
            }
        }

        final void mo7599a(long j) {
            int i = this.a;
            int i2 = this.b;
            Subscriber subscriber = this.f40252d;
            long j2 = j;
            loop0:
            do {
                j = 0;
                while (true) {
                    if (j == j2 || i2 == i) {
                        if (i2 == i) {
                            break loop0;
                        }
                        j2 = get();
                        if (j == j2) {
                            this.b = i2;
                            j2 = addAndGet(-j);
                        }
                    } else if (!this.c) {
                        subscriber.onNext(Integer.valueOf(i2));
                        j++;
                        i2++;
                    } else {
                        return;
                    }
                }
                if (this.c == null) {
                    subscriber.onComplete();
                }
                return;
            } while (j2 != 0);
        }
    }

    public FlowableRange(int i, int i2) {
        this.f35207a = i;
        this.f35208b = i + i2;
    }

    public final void subscribeActual(Subscriber<? super Integer> subscriber) {
        if (subscriber instanceof ConditionalSubscriber) {
            subscriber.mo5623a(new RangeConditionalSubscription((ConditionalSubscriber) subscriber, this.f35207a, this.f35208b));
        } else {
            subscriber.mo5623a(new RangeSubscription(subscriber, this.f35207a, this.f35208b));
        }
    }
}
