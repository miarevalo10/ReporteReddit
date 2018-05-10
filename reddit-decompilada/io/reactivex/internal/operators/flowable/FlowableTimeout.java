package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableTimeout<T, U, V> extends AbstractFlowableWithUpstream<T, T> {
    final Publisher<U> f37853a;
    final Function<? super T, ? extends Publisher<V>> f37854b;
    final Publisher<? extends T> f37855c;

    interface TimeoutSelectorSupport extends TimeoutSupport {
        void mo6632a(long j, Throwable th);
    }

    static final class TimeoutConsumer extends AtomicReference<Subscription> implements FlowableSubscriber<Object>, Disposable {
        final TimeoutSelectorSupport f35442a;
        final long f35443b;

        TimeoutConsumer(long j, TimeoutSelectorSupport timeoutSelectorSupport) {
            this.f35443b = j;
            this.f35442a = timeoutSelectorSupport;
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32779a((AtomicReference) this, subscription)) {
                subscription.request(Long.MAX_VALUE);
            }
        }

        public final void onNext(Object obj) {
            Subscription subscription = (Subscription) get();
            if (subscription != SubscriptionHelper.f32454a) {
                subscription.cancel();
                lazySet(SubscriptionHelper.f32454a);
                this.f35442a.mo6631a(this.f35443b);
            }
        }

        public final void onError(Throwable th) {
            if (get() != SubscriptionHelper.f32454a) {
                lazySet(SubscriptionHelper.f32454a);
                this.f35442a.mo6632a(this.f35443b, th);
                return;
            }
            RxJavaPlugins.m26757a(th);
        }

        public final void onComplete() {
            if (get() != SubscriptionHelper.f32454a) {
                lazySet(SubscriptionHelper.f32454a);
                this.f35442a.mo6631a(this.f35443b);
            }
        }

        public final void mo5626a() {
            SubscriptionHelper.m32777a((AtomicReference) this);
        }

        public final boolean mo5627b() {
            return SubscriptionHelper.m32780a((Subscription) get());
        }
    }

    static final class TimeoutFallbackSubscriber<T> extends SubscriptionArbiter implements FlowableSubscriber<T>, TimeoutSelectorSupport {
        final Subscriber<? super T> f35444a;
        final Function<? super T, ? extends Publisher<?>> f35445b;
        final SequentialDisposable f35446c = new SequentialDisposable();
        final AtomicReference<Subscription> f35447d = new AtomicReference();
        final AtomicLong f35448e;
        Publisher<? extends T> f35449f;
        long f35450g;

        TimeoutFallbackSubscriber(Subscriber<? super T> subscriber, Function<? super T, ? extends Publisher<?>> function, Publisher<? extends T> publisher) {
            this.f35444a = subscriber;
            this.f35445b = function;
            this.f35449f = publisher;
            this.f35448e = new AtomicLong();
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32779a(this.f35447d, subscription)) {
                m32772b(subscription);
            }
        }

        public final void onNext(T t) {
            long j = this.f35448e.get();
            if (j != Long.MAX_VALUE) {
                long j2 = j + 1;
                if (this.f35448e.compareAndSet(j, j2)) {
                    Disposable disposable = (Disposable) this.f35446c.get();
                    if (disposable != null) {
                        disposable.mo5626a();
                    }
                    this.f35450g++;
                    this.f35444a.onNext(t);
                    try {
                        Publisher publisher = (Publisher) ObjectHelper.m26573a(this.f35445b.apply(t), "The itemTimeoutIndicator returned a null Publisher.");
                        Object timeoutConsumer = new TimeoutConsumer(j2, this);
                        if (DisposableHelper.m32094c(this.f35446c, timeoutConsumer)) {
                            publisher.subscribe(timeoutConsumer);
                        }
                    } catch (T t2) {
                        Exceptions.m26521b(t2);
                        ((Subscription) this.f35447d.get()).cancel();
                        this.f35448e.getAndSet(Long.MAX_VALUE);
                        this.f35444a.onError(t2);
                    }
                }
            }
        }

        public final void onError(Throwable th) {
            if (this.f35448e.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.f35446c.mo5626a();
                this.f35444a.onError(th);
                this.f35446c.mo5626a();
                return;
            }
            RxJavaPlugins.m26757a(th);
        }

        public final void onComplete() {
            if (this.f35448e.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.f35446c.mo5626a();
                this.f35444a.onComplete();
                this.f35446c.mo5626a();
            }
        }

        public final void mo6631a(long j) {
            if (this.f35448e.compareAndSet(j, Long.MAX_VALUE) != null) {
                SubscriptionHelper.m32777a(this.f35447d);
                j = this.f35449f;
                this.f35449f = null;
                long j2 = this.f35450g;
                if (j2 != 0) {
                    m32773c(j2);
                }
                j.subscribe(new FallbackSubscriber(this.f35444a, this));
            }
        }

        public final void mo6632a(long j, Throwable th) {
            if (this.f35448e.compareAndSet(j, Long.MAX_VALUE) != null) {
                SubscriptionHelper.m32777a(this.f35447d);
                this.f35444a.onError(th);
                return;
            }
            RxJavaPlugins.m26757a(th);
        }

        public final void cancel() {
            super.cancel();
            this.f35446c.mo5626a();
        }
    }

    static final class TimeoutSubscriber<T> extends AtomicLong implements FlowableSubscriber<T>, TimeoutSelectorSupport, Subscription {
        final Subscriber<? super T> f35451a;
        final Function<? super T, ? extends Publisher<?>> f35452b;
        final SequentialDisposable f35453c = new SequentialDisposable();
        final AtomicReference<Subscription> f35454d = new AtomicReference();
        final AtomicLong f35455e = new AtomicLong();

        TimeoutSubscriber(Subscriber<? super T> subscriber, Function<? super T, ? extends Publisher<?>> function) {
            this.f35451a = subscriber;
            this.f35452b = function;
        }

        public final void mo5623a(Subscription subscription) {
            SubscriptionHelper.m32778a(this.f35454d, this.f35455e, subscription);
        }

        public final void onNext(T t) {
            long j = get();
            if (j != Long.MAX_VALUE) {
                long j2 = 1 + j;
                if (compareAndSet(j, j2)) {
                    Disposable disposable = (Disposable) this.f35453c.get();
                    if (disposable != null) {
                        disposable.mo5626a();
                    }
                    this.f35451a.onNext(t);
                    try {
                        Publisher publisher = (Publisher) ObjectHelper.m26573a(this.f35452b.apply(t), "The itemTimeoutIndicator returned a null Publisher.");
                        Object timeoutConsumer = new TimeoutConsumer(j2, this);
                        if (DisposableHelper.m32094c(this.f35453c, timeoutConsumer)) {
                            publisher.subscribe(timeoutConsumer);
                        }
                    } catch (T t2) {
                        Exceptions.m26521b(t2);
                        ((Subscription) this.f35454d.get()).cancel();
                        getAndSet(Long.MAX_VALUE);
                        this.f35451a.onError(t2);
                    }
                }
            }
        }

        public final void onError(Throwable th) {
            if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.f35453c.mo5626a();
                this.f35451a.onError(th);
                return;
            }
            RxJavaPlugins.m26757a(th);
        }

        public final void onComplete() {
            if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.f35453c.mo5626a();
                this.f35451a.onComplete();
            }
        }

        public final void mo6631a(long j) {
            if (compareAndSet(j, Long.MAX_VALUE) != null) {
                SubscriptionHelper.m32777a(this.f35454d);
                this.f35451a.onError(new TimeoutException());
            }
        }

        public final void mo6632a(long j, Throwable th) {
            if (compareAndSet(j, Long.MAX_VALUE) != null) {
                SubscriptionHelper.m32777a(this.f35454d);
                this.f35451a.onError(th);
                return;
            }
            RxJavaPlugins.m26757a(th);
        }

        public final void request(long j) {
            SubscriptionHelper.m32775a(this.f35454d, this.f35455e, j);
        }

        public final void cancel() {
            SubscriptionHelper.m32777a(this.f35454d);
            this.f35453c.mo5626a();
        }
    }

    public FlowableTimeout(Flowable<T> flowable, Publisher<U> publisher, Function<? super T, ? extends Publisher<V>> function, Publisher<? extends T> publisher2) {
        super(flowable);
        this.f37853a = publisher;
        this.f37854b = function;
        this.f37855c = publisher2;
    }

    protected final void subscribeActual(Subscriber<? super T> subscriber) {
        FlowableSubscriber timeoutSubscriber;
        Object timeoutConsumer;
        if (this.f37855c == null) {
            timeoutSubscriber = new TimeoutSubscriber(subscriber, this.f37854b);
            subscriber.mo5623a(timeoutSubscriber);
            subscriber = this.f37853a;
            if (subscriber != null) {
                timeoutConsumer = new TimeoutConsumer(0, timeoutSubscriber);
                if (DisposableHelper.m32094c(timeoutSubscriber.f35453c, timeoutConsumer)) {
                    subscriber.subscribe(timeoutConsumer);
                }
            }
            this.source.subscribe(timeoutSubscriber);
            return;
        }
        timeoutSubscriber = new TimeoutFallbackSubscriber(subscriber, this.f37854b, this.f37855c);
        subscriber.mo5623a(timeoutSubscriber);
        subscriber = this.f37853a;
        if (subscriber != null) {
            timeoutConsumer = new TimeoutConsumer(0, timeoutSubscriber);
            if (DisposableHelper.m32094c(timeoutSubscriber.f35446c, timeoutConsumer)) {
                subscriber.subscribe(timeoutConsumer);
            }
        }
        this.source.subscribe(timeoutSubscriber);
    }
}
