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

public final class FlowableTakeLastTimed<T> extends AbstractFlowableWithUpstream<T, T> {
    final long f37839a;
    final long f37840b;
    final TimeUnit f37841c;
    final Scheduler f37842d;
    final int f37843e;
    final boolean f37844f;

    static final class TakeLastTimedSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        final Subscriber<? super T> f35401a;
        final long f35402b;
        final long f35403c;
        final TimeUnit f35404d;
        final Scheduler f35405e;
        final SpscLinkedArrayQueue<Object> f35406f;
        final boolean f35407g;
        Subscription f35408h;
        final AtomicLong f35409i = new AtomicLong();
        volatile boolean f35410j;
        volatile boolean f35411k;
        Throwable f35412l;

        TakeLastTimedSubscriber(Subscriber<? super T> subscriber, long j, long j2, TimeUnit timeUnit, Scheduler scheduler, int i, boolean z) {
            this.f35401a = subscriber;
            this.f35402b = j;
            this.f35403c = j2;
            this.f35404d = timeUnit;
            this.f35405e = scheduler;
            this.f35406f = new SpscLinkedArrayQueue(i);
            this.f35407g = z;
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32781a(this.f35408h, subscription)) {
                this.f35408h = subscription;
                this.f35401a.mo5623a(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public final void onNext(T t) {
            SpscLinkedArrayQueue spscLinkedArrayQueue = this.f35406f;
            long a = Scheduler.m26494a(this.f35404d);
            spscLinkedArrayQueue.m35964a(Long.valueOf(a), (Object) t);
            m35857a(a, spscLinkedArrayQueue);
        }

        public final void onError(Throwable th) {
            if (this.f35407g) {
                m35857a(Scheduler.m26494a(this.f35404d), this.f35406f);
            }
            this.f35412l = th;
            this.f35411k = true;
            m35856a();
        }

        public final void onComplete() {
            m35857a(Scheduler.m26494a(this.f35404d), this.f35406f);
            this.f35411k = true;
            m35856a();
        }

        private void m35857a(long j, SpscLinkedArrayQueue<Object> spscLinkedArrayQueue) {
            long j2 = this.f35403c;
            long j3 = this.f35402b;
            int i = j3 == Long.MAX_VALUE ? 1 : 0;
            while (!spscLinkedArrayQueue.isEmpty()) {
                if (((Long) spscLinkedArrayQueue.m35963a()).longValue() < j - j2 || (r4 == 0 && ((long) (spscLinkedArrayQueue.m35965b() >> 1)) > j3)) {
                    spscLinkedArrayQueue.poll();
                    spscLinkedArrayQueue.poll();
                } else {
                    return;
                }
            }
        }

        public final void request(long j) {
            if (SubscriptionHelper.m32776a(j)) {
                BackpressureHelper.m26670a(this.f35409i, j);
                m35856a();
            }
        }

        public final void cancel() {
            if (!this.f35410j) {
                this.f35410j = true;
                this.f35408h.cancel();
                if (getAndIncrement() == 0) {
                    this.f35406f.clear();
                }
            }
        }

        private void m35856a() {
            if (getAndIncrement() == 0) {
                Subscriber subscriber = this.f35401a;
                SpscLinkedArrayQueue spscLinkedArrayQueue = this.f35406f;
                boolean z = this.f35407g;
                int i = 1;
                do {
                    if (this.f35411k) {
                        if (!m35858a(spscLinkedArrayQueue.isEmpty(), subscriber, z)) {
                            long j = this.f35409i.get();
                            long j2 = 0;
                            while (true) {
                                if (!m35858a(spscLinkedArrayQueue.m35963a() == null, subscriber, z)) {
                                    if (j == j2) {
                                        break;
                                    }
                                    spscLinkedArrayQueue.poll();
                                    subscriber.onNext(spscLinkedArrayQueue.poll());
                                    j2++;
                                } else {
                                    return;
                                }
                            }
                            if (j2 != 0) {
                                BackpressureHelper.m26673c(this.f35409i, j2);
                            }
                        } else {
                            return;
                        }
                    }
                    i = addAndGet(-i);
                } while (i != 0);
            }
        }

        private boolean m35858a(boolean z, Subscriber<? super T> subscriber, boolean z2) {
            if (this.f35410j) {
                this.f35406f.clear();
                return true;
            }
            if (!z2) {
                z2 = this.f35412l;
                if (z2) {
                    this.f35406f.clear();
                    subscriber.onError(z2);
                    return true;
                } else if (z) {
                    subscriber.onComplete();
                    return true;
                }
            } else if (z) {
                z = this.f35412l;
                if (z) {
                    subscriber.onError(z);
                } else {
                    subscriber.onComplete();
                }
                return true;
            }
            return false;
        }
    }

    public FlowableTakeLastTimed(Flowable<T> flowable, long j, long j2, TimeUnit timeUnit, Scheduler scheduler, int i, boolean z) {
        super(flowable);
        this.f37839a = j;
        this.f37840b = j2;
        this.f37841c = timeUnit;
        this.f37842d = scheduler;
        this.f37843e = i;
        this.f37844f = z;
    }

    protected final void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe(new TakeLastTimedSubscriber(subscriber, this.f37839a, this.f37840b, this.f37841c, this.f37842d, this.f37843e, this.f37844f));
    }
}
