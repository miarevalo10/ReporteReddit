package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableSkipLastTimed<T> extends AbstractFlowableWithUpstream<T, T> {
    final long f37818a;
    final TimeUnit f37819b;
    final Scheduler f37820c;
    final int f37821d;
    final boolean f37822e;

    static final class SkipLastTimedSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        final Subscriber<? super T> f35345a;
        final long f35346b;
        final TimeUnit f35347c;
        final Scheduler f35348d;
        final SpscLinkedArrayQueue<Object> f35349e;
        final boolean f35350f;
        Subscription f35351g;
        final AtomicLong f35352h = new AtomicLong();
        volatile boolean f35353i;
        volatile boolean f35354j;
        Throwable f35355k;

        SkipLastTimedSubscriber(Subscriber<? super T> subscriber, long j, TimeUnit timeUnit, Scheduler scheduler, int i, boolean z) {
            this.f35345a = subscriber;
            this.f35346b = j;
            this.f35347c = timeUnit;
            this.f35348d = scheduler;
            this.f35349e = new SpscLinkedArrayQueue(i);
            this.f35350f = z;
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32781a(this.f35351g, subscription)) {
                this.f35351g = subscription;
                this.f35345a.mo5623a(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public final void onNext(T t) {
            this.f35349e.m35964a(Long.valueOf(Scheduler.m26494a(this.f35347c)), (Object) t);
            m35842a();
        }

        public final void onError(Throwable th) {
            this.f35355k = th;
            this.f35354j = true;
            m35842a();
        }

        public final void onComplete() {
            this.f35354j = true;
            m35842a();
        }

        public final void request(long j) {
            if (SubscriptionHelper.m32776a(j)) {
                BackpressureHelper.m26670a(this.f35352h, j);
                m35842a();
            }
        }

        public final void cancel() {
            if (!this.f35353i) {
                this.f35353i = true;
                this.f35351g.cancel();
                if (getAndIncrement() == 0) {
                    this.f35349e.clear();
                }
            }
        }

        private void m35842a() {
            SkipLastTimedSubscriber skipLastTimedSubscriber = this;
            if (getAndIncrement() == 0) {
                Subscriber subscriber = skipLastTimedSubscriber.f35345a;
                SpscLinkedArrayQueue spscLinkedArrayQueue = skipLastTimedSubscriber.f35349e;
                boolean z = skipLastTimedSubscriber.f35350f;
                TimeUnit timeUnit = skipLastTimedSubscriber.f35347c;
                long j = skipLastTimedSubscriber.f35346b;
                int i = 1;
                do {
                    long j2 = skipLastTimedSubscriber.f35352h.get();
                    long j3 = 0;
                    while (j3 != j2) {
                        boolean z2 = skipLastTimedSubscriber.f35354j;
                        Long l = (Long) spscLinkedArrayQueue.m35963a();
                        Object obj = null;
                        Object obj2 = l == null ? 1 : null;
                        long a = Scheduler.m26494a(timeUnit);
                        if (obj2 == null && l.longValue() > a - j) {
                            obj2 = 1;
                        }
                        if (!skipLastTimedSubscriber.f35353i) {
                            if (z2) {
                                Throwable th;
                                if (!z) {
                                    th = skipLastTimedSubscriber.f35355k;
                                    if (th != null) {
                                        skipLastTimedSubscriber.f35349e.clear();
                                        subscriber.onError(th);
                                    } else if (obj2 != null) {
                                        subscriber.onComplete();
                                    }
                                } else if (obj2 != null) {
                                    th = skipLastTimedSubscriber.f35355k;
                                    if (th != null) {
                                        subscriber.onError(th);
                                    } else {
                                        subscriber.onComplete();
                                    }
                                }
                            }
                            if (obj == null) {
                                if (obj2 == null) {
                                    break;
                                }
                                spscLinkedArrayQueue.poll();
                                subscriber.onNext(spscLinkedArrayQueue.poll());
                                j3++;
                            } else {
                                return;
                            }
                        }
                        skipLastTimedSubscriber.f35349e.clear();
                        obj = 1;
                        if (obj == null) {
                            return;
                        }
                        if (obj2 == null) {
                            break;
                        }
                        spscLinkedArrayQueue.poll();
                        subscriber.onNext(spscLinkedArrayQueue.poll());
                        j3++;
                    }
                    if (j3 != 0) {
                        BackpressureHelper.m26673c(skipLastTimedSubscriber.f35352h, j3);
                    }
                    i = addAndGet(-i);
                } while (i != 0);
            }
        }
    }

    public FlowableSkipLastTimed(Flowable<T> flowable, long j, TimeUnit timeUnit, Scheduler scheduler, int i, boolean z) {
        super(flowable);
        this.f37818a = j;
        this.f37819b = timeUnit;
        this.f37820c = scheduler;
        this.f37821d = i;
        this.f37822e = z;
    }

    protected final void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe(new SkipLastTimedSubscriber(subscriber, this.f37818a, this.f37819b, this.f37820c, this.f37821d, this.f37822e));
    }
}
