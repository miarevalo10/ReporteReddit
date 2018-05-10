package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscribers.QueueDrainSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.processors.UnicastProcessor;
import io.reactivex.subscribers.DisposableSubscriber;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableWindowBoundarySupplier<T, B> extends AbstractFlowableWithUpstream<T, Flowable<T>> {
    final Callable<? extends Publisher<B>> f37879a;
    final int f37880b;

    static final class WindowBoundaryInnerSubscriber<T, B> extends DisposableSubscriber<B> {
        final WindowBoundaryMainSubscriber<T, B> f37877a;
        boolean f37878b;

        WindowBoundaryInnerSubscriber(WindowBoundaryMainSubscriber<T, B> windowBoundaryMainSubscriber) {
            this.f37877a = windowBoundaryMainSubscriber;
        }

        public final void onNext(B b) {
            if (this.f37878b == null) {
                this.f37878b = true;
                m36032d();
                this.f37877a.m42360a();
            }
        }

        public final void onError(Throwable th) {
            if (this.f37878b) {
                RxJavaPlugins.m26757a(th);
                return;
            }
            this.f37878b = true;
            this.f37877a.onError(th);
        }

        public final void onComplete() {
            if (!this.f37878b) {
                this.f37878b = true;
                this.f37877a.onComplete();
            }
        }
    }

    static final class WindowBoundaryMainSubscriber<T, B> extends QueueDrainSubscriber<T, Object, Flowable<T>> implements Subscription {
        static final Object f40679f = new Object();
        final Callable<? extends Publisher<B>> f40680a;
        final int f40681b;
        Subscription f40682c;
        final AtomicReference<Disposable> f40683d = new AtomicReference();
        UnicastProcessor<T> f40684e;
        final AtomicLong f40685g = new AtomicLong();

        WindowBoundaryMainSubscriber(Subscriber<? super Flowable<T>> subscriber, Callable<? extends Publisher<B>> callable, int i) {
            super(subscriber, new MpscLinkedQueue());
            this.f40680a = callable;
            this.f40681b = i;
            this.f40685g.lazySet(1);
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32781a(this.f40682c, subscription)) {
                this.f40682c = subscription;
                Subscriber subscriber = this.n;
                subscriber.mo5623a(this);
                if (!this.p) {
                    try {
                        Publisher publisher = (Publisher) ObjectHelper.m26573a(this.f40680a.call(), "The first window publisher supplied is null");
                        UnicastProcessor a = UnicastProcessor.m38166a(this.f40681b);
                        long j = this.s.get();
                        if (j != 0) {
                            subscriber.onNext(a);
                            if (j != Long.MAX_VALUE) {
                                mo7608j();
                            }
                            this.f40684e = a;
                            subscriber = new WindowBoundaryInnerSubscriber(this);
                            if (this.f40683d.compareAndSet(null, subscriber)) {
                                this.f40685g.getAndIncrement();
                                subscription.request(Long.MAX_VALUE);
                                publisher.subscribe(subscriber);
                            }
                        } else {
                            subscription.cancel();
                            subscriber.onError(new MissingBackpressureException("Could not deliver first window due to lack of requests"));
                        }
                    } catch (Throwable th) {
                        Exceptions.m26521b(th);
                        subscription.cancel();
                        subscriber.onError(th);
                    }
                }
            }
        }

        public final void onNext(T t) {
            if (!this.q) {
                if (m41405g()) {
                    this.f40684e.onNext(t);
                    if (mo7602a(-1) == null) {
                        return;
                    }
                }
                this.o.offer(NotificationLite.m26696a((Object) t));
                if (m41404f() == null) {
                    return;
                }
                m42359b();
            }
        }

        public final void onError(Throwable th) {
            if (this.q) {
                RxJavaPlugins.m26757a(th);
                return;
            }
            this.r = th;
            this.q = true;
            if (m41404f()) {
                m42359b();
            }
            if (this.f40685g.decrementAndGet() == 0) {
                DisposableHelper.m32090a(this.f40683d);
            }
            this.n.onError(th);
        }

        public final void onComplete() {
            if (!this.q) {
                this.q = true;
                if (m41404f()) {
                    m42359b();
                }
                if (this.f40685g.decrementAndGet() == 0) {
                    DisposableHelper.m32090a(this.f40683d);
                }
                this.n.onComplete();
            }
        }

        public final void request(long j) {
            m41398a(j);
        }

        public final void cancel() {
            this.p = true;
        }

        private void m42359b() {
            SimplePlainQueue simplePlainQueue = this.o;
            Subscriber subscriber = this.n;
            UnicastProcessor unicastProcessor = this.f40684e;
            int i = 1;
            while (true) {
                boolean z = this.q;
                Object poll = simplePlainQueue.poll();
                boolean z2 = poll == null;
                if (z && z2) {
                    break;
                } else if (z2) {
                    i = mo7602a(-i);
                    if (i == 0) {
                        return;
                    }
                } else if (poll == f40679f) {
                    unicastProcessor.onComplete();
                    if (this.f40685g.decrementAndGet() == 0) {
                        DisposableHelper.m32090a(this.f40683d);
                        return;
                    } else if (this.p) {
                        continue;
                    } else {
                        try {
                            Publisher publisher = (Publisher) ObjectHelper.m26573a(this.f40680a.call(), "The publisher supplied is null");
                            UnicastProcessor a = UnicastProcessor.m38166a(this.f40681b);
                            long j = this.s.get();
                            if (j != 0) {
                                this.f40685g.getAndIncrement();
                                subscriber.onNext(a);
                                if (j != Long.MAX_VALUE) {
                                    mo7608j();
                                }
                                this.f40684e = a;
                                Subscriber windowBoundaryInnerSubscriber = new WindowBoundaryInnerSubscriber(this);
                                if (this.f40683d.compareAndSet(this.f40683d.get(), windowBoundaryInnerSubscriber)) {
                                    publisher.subscribe(windowBoundaryInnerSubscriber);
                                }
                            } else {
                                this.p = true;
                                subscriber.onError(new MissingBackpressureException("Could not deliver new window due to lack of requests"));
                            }
                            unicastProcessor = a;
                        } catch (Throwable th) {
                            Exceptions.m26521b(th);
                            DisposableHelper.m32090a(this.f40683d);
                            subscriber.onError(th);
                            return;
                        }
                    }
                } else {
                    unicastProcessor.onNext(NotificationLite.m26706e(poll));
                }
            }
            DisposableHelper.m32090a(this.f40683d);
            Throwable th2 = this.r;
            if (th2 != null) {
                unicastProcessor.onError(th2);
            } else {
                unicastProcessor.onComplete();
            }
        }

        final void m42360a() {
            this.o.offer(f40679f);
            if (m41404f()) {
                m42359b();
            }
        }
    }

    public FlowableWindowBoundarySupplier(Flowable<T> flowable, Callable<? extends Publisher<B>> callable, int i) {
        super(flowable);
        this.f37879a = callable;
        this.f37880b = i;
    }

    protected final void subscribeActual(Subscriber<? super Flowable<T>> subscriber) {
        this.source.subscribe(new WindowBoundaryMainSubscriber(new SerializedSubscriber(subscriber), this.f37879a, this.f37880b));
    }
}
