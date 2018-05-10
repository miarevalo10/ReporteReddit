package io.reactivex.internal.operators.flowable;

import io.reactivex.BackpressureOverflowStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Action;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableOnBackpressureBufferStrategy<T> extends AbstractFlowableWithUpstream<T, T> {
    final long f37771a;
    final Action f37772b;
    final BackpressureOverflowStrategy f37773c;

    static final class OnBackpressureBufferStrategySubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        final Subscriber<? super T> f35151a;
        final Action f35152b;
        final BackpressureOverflowStrategy f35153c;
        final long f35154d;
        final AtomicLong f35155e = new AtomicLong();
        final Deque<T> f35156f = new ArrayDeque();
        Subscription f35157g;
        volatile boolean f35158h;
        volatile boolean f35159i;
        Throwable f35160j;

        OnBackpressureBufferStrategySubscriber(Subscriber<? super T> subscriber, Action action, BackpressureOverflowStrategy backpressureOverflowStrategy, long j) {
            this.f35151a = subscriber;
            this.f35152b = action;
            this.f35153c = backpressureOverflowStrategy;
            this.f35154d = j;
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32781a(this.f35157g, subscription)) {
                this.f35157g = subscription;
                this.f35151a.mo5623a(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public final void onNext(T t) {
            if (!this.f35159i) {
                Object obj;
                Object obj2;
                Deque deque = this.f35156f;
                synchronized (deque) {
                    obj = null;
                    obj2 = 1;
                    if (((long) deque.size()) == this.f35154d) {
                        switch (this.f35153c) {
                            case DROP_LATEST:
                                deque.pollLast();
                                deque.offer(t);
                                break;
                            case DROP_OLDEST:
                                deque.poll();
                                deque.offer(t);
                                break;
                            default:
                                break;
                        }
                        obj2 = null;
                        obj = 1;
                    } else {
                        deque.offer(t);
                        obj2 = null;
                    }
                }
                if (obj != null) {
                    if (this.f35152b != null) {
                        try {
                            this.f35152b.run();
                        } catch (T t2) {
                            Exceptions.m26521b(t2);
                            this.f35157g.cancel();
                            onError(t2);
                        }
                    }
                } else if (obj2 != null) {
                    this.f35157g.cancel();
                    onError(new MissingBackpressureException());
                } else {
                    m35761a();
                }
            }
        }

        public final void onError(Throwable th) {
            if (this.f35159i) {
                RxJavaPlugins.m26757a(th);
                return;
            }
            this.f35160j = th;
            this.f35159i = true;
            m35761a();
        }

        public final void onComplete() {
            this.f35159i = true;
            m35761a();
        }

        public final void request(long j) {
            if (SubscriptionHelper.m32776a(j)) {
                BackpressureHelper.m26670a(this.f35155e, j);
                m35761a();
            }
        }

        public final void cancel() {
            this.f35158h = true;
            this.f35157g.cancel();
            if (getAndIncrement() == 0) {
                m35762a(this.f35156f);
            }
        }

        private static void m35762a(Deque<T> deque) {
            synchronized (deque) {
                deque.clear();
            }
        }

        private void m35761a() {
            if (getAndIncrement() == 0) {
                Deque deque = this.f35156f;
                Subscriber subscriber = this.f35151a;
                int i = 1;
                do {
                    int i2;
                    long j = this.f35155e.get();
                    long j2 = 0;
                    while (true) {
                        i2 = (j2 > j ? 1 : (j2 == j ? 0 : -1));
                        if (i2 != 0) {
                            if (!this.f35158h) {
                                Object poll;
                                boolean z = this.f35159i;
                                synchronized (deque) {
                                    poll = deque.poll();
                                }
                                Object obj = poll == null ? 1 : null;
                                if (z) {
                                    Throwable th = this.f35160j;
                                    if (th != null) {
                                        m35762a(deque);
                                        subscriber.onError(th);
                                        return;
                                    } else if (obj != null) {
                                        subscriber.onComplete();
                                        return;
                                    }
                                }
                                if (obj != null) {
                                    break;
                                }
                                subscriber.onNext(poll);
                                j2++;
                            } else {
                                m35762a(deque);
                                return;
                            }
                        }
                        break;
                    }
                    if (i2 == 0) {
                        if (this.f35158h) {
                            m35762a(deque);
                            return;
                        }
                        boolean isEmpty;
                        boolean z2 = this.f35159i;
                        synchronized (deque) {
                            isEmpty = deque.isEmpty();
                        }
                        if (z2) {
                            Throwable th2 = this.f35160j;
                            if (th2 != null) {
                                m35762a(deque);
                                subscriber.onError(th2);
                                return;
                            } else if (isEmpty) {
                                subscriber.onComplete();
                                return;
                            }
                        }
                    }
                    if (j2 != 0) {
                        BackpressureHelper.m26673c(this.f35155e, j2);
                    }
                    i = addAndGet(-i);
                } while (i != 0);
            }
        }
    }

    public FlowableOnBackpressureBufferStrategy(Flowable<T> flowable, long j, Action action, BackpressureOverflowStrategy backpressureOverflowStrategy) {
        super(flowable);
        this.f37771a = j;
        this.f37772b = action;
        this.f37773c = backpressureOverflowStrategy;
    }

    protected final void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe(new OnBackpressureBufferStrategySubscriber(subscriber, this.f37772b, this.f37773c, this.f37771a));
    }
}
