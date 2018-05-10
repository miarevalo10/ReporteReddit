package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Action;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableOnBackpressureBuffer<T> extends AbstractFlowableWithUpstream<T, T> {
    final int f37767a;
    final boolean f37768b;
    final boolean f37769c;
    final Action f37770d;

    static final class BackpressureBufferSubscriber<T> extends BasicIntQueueSubscription<T> implements FlowableSubscriber<T> {
        final Subscriber<? super T> f39498a;
        final SimplePlainQueue<T> f39499b;
        final boolean f39500c;
        final Action f39501d;
        Subscription f39502e;
        volatile boolean f39503f;
        volatile boolean f39504g;
        Throwable f39505h;
        final AtomicLong f39506i = new AtomicLong();
        boolean f39507j;

        BackpressureBufferSubscriber(Subscriber<? super T> subscriber, int i, boolean z, boolean z2, Action action) {
            this.f39498a = subscriber;
            this.f39501d = action;
            this.f39500c = z2;
            if (z) {
                subscriber = new SpscLinkedArrayQueue(i);
            } else {
                subscriber = new SpscArrayQueue(i);
            }
            this.f39499b = subscriber;
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32781a(this.f39502e, subscription)) {
                this.f39502e = subscription;
                this.f39498a.mo5623a(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public final void onNext(T t) {
            if (this.f39499b.offer(t) == null) {
                this.f39502e.cancel();
                t = new MissingBackpressureException("Buffer is full");
                try {
                    this.f39501d.run();
                } catch (Throwable th) {
                    Exceptions.m26521b(th);
                    t.initCause(th);
                }
                onError(t);
            } else if (this.f39507j != null) {
                this.f39498a.onNext(null);
            } else {
                m39687a();
            }
        }

        public final void onError(Throwable th) {
            this.f39505h = th;
            this.f39504g = true;
            if (this.f39507j) {
                this.f39498a.onError(th);
            } else {
                m39687a();
            }
        }

        public final void onComplete() {
            this.f39504g = true;
            if (this.f39507j) {
                this.f39498a.onComplete();
            } else {
                m39687a();
            }
        }

        public final void request(long j) {
            if (!this.f39507j && SubscriptionHelper.m32776a(j)) {
                BackpressureHelper.m26670a(this.f39506i, j);
                m39687a();
            }
        }

        public final void cancel() {
            if (!this.f39503f) {
                this.f39503f = true;
                this.f39502e.cancel();
                if (getAndIncrement() == 0) {
                    this.f39499b.clear();
                }
            }
        }

        private void m39687a() {
            if (getAndIncrement() == 0) {
                SimplePlainQueue simplePlainQueue = this.f39499b;
                Subscriber subscriber = this.f39498a;
                int i = 1;
                while (!m39688a(this.f39504g, simplePlainQueue.isEmpty(), subscriber)) {
                    int i2;
                    long j = this.f39506i.get();
                    long j2 = 0;
                    while (true) {
                        i2 = (j2 > j ? 1 : (j2 == j ? 0 : -1));
                        if (i2 == 0) {
                            break;
                        }
                        boolean z = this.f39504g;
                        Object poll = simplePlainQueue.poll();
                        boolean z2 = poll == null;
                        if (!m39688a(z, z2, subscriber)) {
                            if (z2) {
                                break;
                            }
                            subscriber.onNext(poll);
                            j2++;
                        } else {
                            return;
                        }
                    }
                    if (i2 != 0 || !m39688a(this.f39504g, simplePlainQueue.isEmpty(), subscriber)) {
                        if (!(j2 == 0 || j == Long.MAX_VALUE)) {
                            this.f39506i.addAndGet(-j2);
                        }
                        i = addAndGet(-i);
                        if (i == 0) {
                        }
                    } else {
                        return;
                    }
                }
            }
        }

        private boolean m39688a(boolean z, boolean z2, Subscriber<? super T> subscriber) {
            if (this.f39503f) {
                this.f39499b.clear();
                return true;
            }
            if (z) {
                if (!this.f39500c) {
                    z = this.f39505h;
                    if (z) {
                        this.f39499b.clear();
                        subscriber.onError(z);
                        return true;
                    } else if (z2) {
                        subscriber.onComplete();
                        return true;
                    }
                } else if (z2) {
                    z = this.f39505h;
                    if (z) {
                        subscriber.onError(z);
                    } else {
                        subscriber.onComplete();
                    }
                    return true;
                }
            }
            return false;
        }

        public final int mo7033a(int i) {
            if ((i & 2) == 0) {
                return 0;
            }
            this.f39507j = true;
            return 2;
        }

        public final T poll() throws Exception {
            return this.f39499b.poll();
        }

        public final void clear() {
            this.f39499b.clear();
        }

        public final boolean isEmpty() {
            return this.f39499b.isEmpty();
        }
    }

    public FlowableOnBackpressureBuffer(Flowable<T> flowable, int i, boolean z, boolean z2, Action action) {
        super(flowable);
        this.f37767a = i;
        this.f37768b = z;
        this.f37769c = z2;
        this.f37770d = action;
    }

    protected final void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe(new BackpressureBufferSubscriber(subscriber, this.f37767a, this.f37768b, this.f37769c, this.f37770d));
    }
}
