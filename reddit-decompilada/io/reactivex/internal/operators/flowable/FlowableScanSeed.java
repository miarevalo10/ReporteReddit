package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableScanSeed<T, R> extends AbstractFlowableWithUpstream<T, R> {
    final BiFunction<R, ? super T, R> f37813a;
    final Callable<R> f37814b;

    static final class ScanSeedSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        final Subscriber<? super R> f35300a;
        final BiFunction<R, ? super T, R> f35301b;
        final SimplePlainQueue<R> f35302c;
        final AtomicLong f35303d = new AtomicLong();
        final int f35304e;
        final int f35305f;
        volatile boolean f35306g;
        volatile boolean f35307h;
        Throwable f35308i;
        Subscription f35309j;
        R f35310k;
        int f35311l;

        ScanSeedSubscriber(Subscriber<? super R> subscriber, BiFunction<R, ? super T, R> biFunction, R r, int i) {
            this.f35300a = subscriber;
            this.f35301b = biFunction;
            this.f35310k = r;
            this.f35304e = i;
            this.f35305f = i - (i >> 2);
            this.f35302c = new SpscArrayQueue(i);
            this.f35302c.offer(r);
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32781a(this.f35309j, subscription)) {
                this.f35309j = subscription;
                this.f35300a.mo5623a(this);
                subscription.request((long) (this.f35304e - 1));
            }
        }

        public final void onNext(T t) {
            if (!this.f35307h) {
                try {
                    t = ObjectHelper.m26573a(this.f35301b.apply(this.f35310k, t), "The accumulator returned a null value");
                    this.f35310k = t;
                    this.f35302c.offer(t);
                    m35826a();
                } catch (T t2) {
                    Exceptions.m26521b(t2);
                    this.f35309j.cancel();
                    onError(t2);
                }
            }
        }

        public final void onError(Throwable th) {
            if (this.f35307h) {
                RxJavaPlugins.m26757a(th);
                return;
            }
            this.f35308i = th;
            this.f35307h = true;
            m35826a();
        }

        public final void onComplete() {
            if (!this.f35307h) {
                this.f35307h = true;
                m35826a();
            }
        }

        public final void cancel() {
            this.f35306g = true;
            this.f35309j.cancel();
            if (getAndIncrement() == 0) {
                this.f35302c.clear();
            }
        }

        public final void request(long j) {
            if (SubscriptionHelper.m32776a(j)) {
                BackpressureHelper.m26670a(this.f35303d, j);
                m35826a();
            }
        }

        private void m35826a() {
            ScanSeedSubscriber scanSeedSubscriber = this;
            if (getAndIncrement() == 0) {
                Subscriber subscriber = scanSeedSubscriber.f35300a;
                SimplePlainQueue simplePlainQueue = scanSeedSubscriber.f35302c;
                int i = scanSeedSubscriber.f35305f;
                int i2 = scanSeedSubscriber.f35311l;
                int i3 = 1;
                do {
                    int i4;
                    long j = scanSeedSubscriber.f35303d.get();
                    long j2 = 0;
                    while (true) {
                        i4 = (j2 > j ? 1 : (j2 == j ? 0 : -1));
                        if (i4 == 0) {
                            break;
                        } else if (scanSeedSubscriber.f35306g) {
                            simplePlainQueue.clear();
                            return;
                        } else {
                            boolean z = scanSeedSubscriber.f35307h;
                            if (z) {
                                Throwable th = scanSeedSubscriber.f35308i;
                                if (th != null) {
                                    simplePlainQueue.clear();
                                    subscriber.onError(th);
                                    return;
                                }
                            }
                            Object poll = simplePlainQueue.poll();
                            Object obj = poll == null ? 1 : null;
                            if (!z || obj == null) {
                                if (obj != null) {
                                    break;
                                }
                                subscriber.onNext(poll);
                                j2++;
                                i2++;
                                if (i2 == i) {
                                    scanSeedSubscriber.f35309j.request((long) i);
                                    i2 = 0;
                                }
                            } else {
                                subscriber.onComplete();
                                return;
                            }
                        }
                    }
                    if (i4 == 0 && scanSeedSubscriber.f35307h) {
                        Throwable th2 = scanSeedSubscriber.f35308i;
                        if (th2 != null) {
                            simplePlainQueue.clear();
                            subscriber.onError(th2);
                            return;
                        } else if (simplePlainQueue.isEmpty()) {
                            subscriber.onComplete();
                            return;
                        }
                    }
                    if (j2 != 0) {
                        BackpressureHelper.m26673c(scanSeedSubscriber.f35303d, j2);
                    }
                    scanSeedSubscriber.f35311l = i2;
                    i3 = addAndGet(-i3);
                } while (i3 != 0);
            }
        }
    }

    public FlowableScanSeed(Flowable<T> flowable, Callable<R> callable, BiFunction<R, ? super T, R> biFunction) {
        super(flowable);
        this.f37813a = biFunction;
        this.f37814b = callable;
    }

    protected final void subscribeActual(Subscriber<? super R> subscriber) {
        try {
            this.source.subscribe(new ScanSeedSubscriber(subscriber, this.f37813a, ObjectHelper.m26573a(this.f37814b.call(), "The seed supplied is null"), Flowable.bufferSize()));
        } catch (Throwable th) {
            Exceptions.m26521b(th);
            EmptySubscription.m38160a(th, subscriber);
        }
    }
}
