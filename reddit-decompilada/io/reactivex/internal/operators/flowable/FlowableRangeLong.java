package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;

public final class FlowableRangeLong extends Flowable<Long> {
    final long f35209a;
    final long f35210b;

    static abstract class BaseRangeSubscription extends BasicQueueSubscription<Long> {
        final long f39511a;
        long f39512b;
        volatile boolean f39513c;

        public final int mo7033a(int i) {
            return i & 1;
        }

        abstract void mo7600a();

        abstract void mo7601a(long j);

        BaseRangeSubscription(long j, long j2) {
            this.f39512b = j;
            this.f39511a = j2;
        }

        public final boolean isEmpty() {
            return this.f39512b == this.f39511a;
        }

        public final void clear() {
            this.f39512b = this.f39511a;
        }

        public final void request(long j) {
            if (SubscriptionHelper.m32776a(j) && BackpressureHelper.m26670a((AtomicLong) this, j) == 0) {
                if (j == Long.MAX_VALUE) {
                    mo7600a();
                    return;
                }
                mo7601a(j);
            }
        }

        public final void cancel() {
            this.f39513c = true;
        }

        public /* synthetic */ Object poll() throws Exception {
            long j = this.f39512b;
            if (j == this.f39511a) {
                return null;
            }
            this.f39512b = 1 + j;
            return Long.valueOf(j);
        }
    }

    static final class RangeConditionalSubscription extends BaseRangeSubscription {
        final ConditionalSubscriber<? super Long> f40253d;

        RangeConditionalSubscription(ConditionalSubscriber<? super Long> conditionalSubscriber, long j, long j2) {
            super(j, j2);
            this.f40253d = conditionalSubscriber;
        }

        final void mo7600a() {
            long j = this.a;
            ConditionalSubscriber conditionalSubscriber = this.f40253d;
            long j2 = this.b;
            while (j2 != j) {
                if (!this.c) {
                    conditionalSubscriber.mo7052a(Long.valueOf(j2));
                    j2++;
                } else {
                    return;
                }
            }
            if (!this.c) {
                conditionalSubscriber.onComplete();
            }
        }

        final void mo7601a(long j) {
            long j2 = this.a;
            long j3 = this.b;
            ConditionalSubscriber conditionalSubscriber = this.f40253d;
            long j4 = j3;
            j3 = j;
            loop0:
            do {
                j = 0;
                while (true) {
                    if (j == j3 || j4 == j2) {
                        if (j4 == j2) {
                            break loop0;
                        }
                        j3 = get();
                        if (j == j3) {
                            this.b = j4;
                            j3 = addAndGet(-j);
                        }
                    } else if (!this.c) {
                        if (conditionalSubscriber.mo7052a(Long.valueOf(j4))) {
                            j++;
                        }
                        j4++;
                    } else {
                        return;
                    }
                }
                if (this.c == null) {
                    conditionalSubscriber.onComplete();
                }
                return;
            } while (j3 != 0);
        }
    }

    static final class RangeSubscription extends BaseRangeSubscription {
        final Subscriber<? super Long> f40254d;

        RangeSubscription(Subscriber<? super Long> subscriber, long j, long j2) {
            super(j, j2);
            this.f40254d = subscriber;
        }

        final void mo7600a() {
            long j = this.a;
            Subscriber subscriber = this.f40254d;
            long j2 = this.b;
            while (j2 != j) {
                if (!this.c) {
                    subscriber.onNext(Long.valueOf(j2));
                    j2++;
                } else {
                    return;
                }
            }
            if (!this.c) {
                subscriber.onComplete();
            }
        }

        final void mo7601a(long j) {
            long j2 = this.a;
            long j3 = this.b;
            Subscriber subscriber = this.f40254d;
            long j4 = j3;
            j3 = j;
            loop0:
            do {
                j = 0;
                while (true) {
                    if (j == j3 || j4 == j2) {
                        if (j4 == j2) {
                            break loop0;
                        }
                        j3 = get();
                        if (j == j3) {
                            this.b = j4;
                            j3 = addAndGet(-j);
                        }
                    } else if (!this.c) {
                        subscriber.onNext(Long.valueOf(j4));
                        j++;
                        j4++;
                    } else {
                        return;
                    }
                }
                if (this.c == null) {
                    subscriber.onComplete();
                }
                return;
            } while (j3 != 0);
        }
    }

    public FlowableRangeLong(long j, long j2) {
        this.f35209a = j;
        this.f35210b = j + j2;
    }

    public final void subscribeActual(Subscriber<? super Long> subscriber) {
        if (subscriber instanceof ConditionalSubscriber) {
            subscriber.mo5623a(new RangeConditionalSubscription((ConditionalSubscriber) subscriber, this.f35209a, this.f35210b));
            return;
        }
        subscriber.mo5623a(new RangeSubscription(subscriber, this.f35209a, this.f35210b));
    }
}
