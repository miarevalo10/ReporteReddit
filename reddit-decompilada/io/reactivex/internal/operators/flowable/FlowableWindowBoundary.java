package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscribers.QueueDrainSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.processors.UnicastProcessor;
import io.reactivex.subscribers.DisposableSubscriber;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableWindowBoundary<T, B> extends AbstractFlowableWithUpstream<T, Flowable<T>> {
    final Publisher<B> f37867a;
    final int f37868b;

    static final class WindowBoundaryInnerSubscriber<T, B> extends DisposableSubscriber<B> {
        final WindowBoundaryMainSubscriber<T, B> f37865a;
        boolean f37866b;

        WindowBoundaryInnerSubscriber(WindowBoundaryMainSubscriber<T, B> windowBoundaryMainSubscriber) {
            this.f37865a = windowBoundaryMainSubscriber;
        }

        public final void onNext(B b) {
            if (this.f37866b == null) {
                this.f37865a.m42349a();
            }
        }

        public final void onError(Throwable th) {
            if (this.f37866b) {
                RxJavaPlugins.m26757a(th);
                return;
            }
            this.f37866b = true;
            this.f37865a.onError(th);
        }

        public final void onComplete() {
            if (!this.f37866b) {
                this.f37866b = true;
                this.f37865a.onComplete();
            }
        }
    }

    static final class WindowBoundaryMainSubscriber<T, B> extends QueueDrainSubscriber<T, Object, Flowable<T>> implements Subscription {
        static final Object f40664f = new Object();
        final Publisher<B> f40665a;
        final int f40666b;
        Subscription f40667c;
        final AtomicReference<Disposable> f40668d = new AtomicReference();
        UnicastProcessor<T> f40669e;
        final AtomicLong f40670g = new AtomicLong();

        public final boolean mo7603a(Subscriber<? super Flowable<T>> subscriber, Object obj) {
            return false;
        }

        WindowBoundaryMainSubscriber(Subscriber<? super Flowable<T>> subscriber, Publisher<B> publisher, int i) {
            super(subscriber, new MpscLinkedQueue());
            this.f40665a = publisher;
            this.f40666b = i;
            this.f40670g.lazySet(1);
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32781a(this.f40667c, subscription)) {
                this.f40667c = subscription;
                Subscriber subscriber = this.n;
                subscriber.mo5623a(this);
                if (!this.p) {
                    UnicastProcessor a = UnicastProcessor.m38166a(this.f40666b);
                    long j = this.s.get();
                    if (j != 0) {
                        subscriber.onNext(a);
                        if (j != Long.MAX_VALUE) {
                            mo7608j();
                        }
                        this.f40669e = a;
                        subscriber = new WindowBoundaryInnerSubscriber(this);
                        if (this.f40668d.compareAndSet(null, subscriber)) {
                            this.f40670g.getAndIncrement();
                            subscription.request(Long.MAX_VALUE);
                            this.f40665a.subscribe(subscriber);
                        }
                    } else {
                        subscriber.onError(new MissingBackpressureException("Could not deliver first window due to lack of requests"));
                    }
                }
            }
        }

        public final void onNext(T t) {
            if (m41405g()) {
                this.f40669e.onNext(t);
                if (mo7602a(-1) == null) {
                    return;
                }
            }
            this.o.offer(NotificationLite.m26696a((Object) t));
            if (m41404f() == null) {
                return;
            }
            m42348b();
        }

        public final void onError(Throwable th) {
            if (this.q) {
                RxJavaPlugins.m26757a(th);
                return;
            }
            this.r = th;
            this.q = true;
            if (m41404f()) {
                m42348b();
            }
            if (this.f40670g.decrementAndGet() == 0) {
                DisposableHelper.m32090a(this.f40668d);
            }
            this.n.onError(th);
        }

        public final void onComplete() {
            if (!this.q) {
                this.q = true;
                if (m41404f()) {
                    m42348b();
                }
                if (this.f40670g.decrementAndGet() == 0) {
                    DisposableHelper.m32090a(this.f40668d);
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

        private void m42348b() {
            SimplePlainQueue simplePlainQueue = this.o;
            Subscriber subscriber = this.n;
            UnicastProcessor unicastProcessor = this.f40669e;
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
                } else if (poll == f40664f) {
                    unicastProcessor.onComplete();
                    if (this.f40670g.decrementAndGet() == 0) {
                        DisposableHelper.m32090a(this.f40668d);
                        return;
                    } else if (!this.p) {
                        unicastProcessor = UnicastProcessor.m38166a(this.f40666b);
                        long j = this.s.get();
                        if (j != 0) {
                            this.f40670g.getAndIncrement();
                            subscriber.onNext(unicastProcessor);
                            if (j != Long.MAX_VALUE) {
                                mo7608j();
                            }
                            this.f40669e = unicastProcessor;
                        } else {
                            this.p = true;
                            subscriber.onError(new MissingBackpressureException("Could not deliver new window due to lack of requests"));
                        }
                    }
                } else {
                    unicastProcessor.onNext(NotificationLite.m26706e(poll));
                }
            }
            DisposableHelper.m32090a(this.f40668d);
            Throwable th = this.r;
            if (th != null) {
                unicastProcessor.onError(th);
            } else {
                unicastProcessor.onComplete();
            }
        }

        final void m42349a() {
            this.o.offer(f40664f);
            if (m41404f()) {
                m42348b();
            }
        }
    }

    public FlowableWindowBoundary(Flowable<T> flowable, Publisher<B> publisher, int i) {
        super(flowable);
        this.f37867a = publisher;
        this.f37868b = i;
    }

    protected final void subscribeActual(Subscriber<? super Flowable<T>> subscriber) {
        this.source.subscribe(new WindowBoundaryMainSubscriber(new SerializedSubscriber(subscriber), this.f37867a, this.f37868b));
    }
}
