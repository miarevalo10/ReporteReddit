package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subscribers.DisposableSubscriber;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableDebounce<T, U> extends AbstractFlowableWithUpstream<T, T> {
    final Function<? super T, ? extends Publisher<U>> f37696a;

    static final class DebounceSubscriber<T, U> extends AtomicLong implements FlowableSubscriber<T>, Subscription {
        final Subscriber<? super T> f34946a;
        final Function<? super T, ? extends Publisher<U>> f34947b;
        Subscription f34948c;
        final AtomicReference<Disposable> f34949d = new AtomicReference();
        volatile long f34950e;
        boolean f34951f;

        static final class DebounceInnerSubscriber<T, U> extends DisposableSubscriber<U> {
            final DebounceSubscriber<T, U> f37691a;
            final long f37692b;
            final T f37693c;
            boolean f37694d;
            final AtomicBoolean f37695e = new AtomicBoolean();

            DebounceInnerSubscriber(DebounceSubscriber<T, U> debounceSubscriber, long j, T t) {
                this.f37691a = debounceSubscriber;
                this.f37692b = j;
                this.f37693c = t;
            }

            public final void onNext(U u) {
                if (this.f37694d == null) {
                    this.f37694d = true;
                    m36032d();
                    m38100c();
                }
            }

            final void m38100c() {
                if (this.f37695e.compareAndSet(false, true)) {
                    AtomicLong atomicLong = this.f37691a;
                    long j = this.f37692b;
                    Object obj = this.f37693c;
                    if (j == atomicLong.f34950e) {
                        if (atomicLong.get() != 0) {
                            atomicLong.f34946a.onNext(obj);
                            BackpressureHelper.m26673c(atomicLong, 1);
                            return;
                        }
                        atomicLong.cancel();
                        atomicLong.f34946a.onError(new MissingBackpressureException("Could not deliver value due to lack of requests"));
                    }
                }
            }

            public final void onError(Throwable th) {
                if (this.f37694d) {
                    RxJavaPlugins.m26757a(th);
                    return;
                }
                this.f37694d = true;
                this.f37691a.onError(th);
            }

            public final void onComplete() {
                if (!this.f37694d) {
                    this.f37694d = true;
                    m38100c();
                }
            }
        }

        DebounceSubscriber(Subscriber<? super T> subscriber, Function<? super T, ? extends Publisher<U>> function) {
            this.f34946a = subscriber;
            this.f34947b = function;
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32781a(this.f34948c, subscription)) {
                this.f34948c = subscription;
                this.f34946a.mo5623a(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public final void onNext(T t) {
            if (!this.f34951f) {
                long j = this.f34950e + 1;
                this.f34950e = j;
                Disposable disposable = (Disposable) this.f34949d.get();
                if (disposable != null) {
                    disposable.mo5626a();
                }
                try {
                    Publisher publisher = (Publisher) ObjectHelper.m26573a(this.f34947b.apply(t), "The publisher supplied is null");
                    Subscriber debounceInnerSubscriber = new DebounceInnerSubscriber(this, j, t);
                    if (this.f34949d.compareAndSet(disposable, debounceInnerSubscriber) != null) {
                        publisher.subscribe(debounceInnerSubscriber);
                    }
                } catch (T t2) {
                    Exceptions.m26521b(t2);
                    cancel();
                    this.f34946a.onError(t2);
                }
            }
        }

        public final void onError(Throwable th) {
            DisposableHelper.m32090a(this.f34949d);
            this.f34946a.onError(th);
        }

        public final void onComplete() {
            if (!this.f34951f) {
                this.f34951f = true;
                Disposable disposable = (Disposable) this.f34949d.get();
                if (!DisposableHelper.m32088a(disposable)) {
                    ((DebounceInnerSubscriber) disposable).m38100c();
                    DisposableHelper.m32090a(this.f34949d);
                    this.f34946a.onComplete();
                }
            }
        }

        public final void request(long j) {
            if (SubscriptionHelper.m32776a(j)) {
                BackpressureHelper.m26670a((AtomicLong) this, j);
            }
        }

        public final void cancel() {
            this.f34948c.cancel();
            DisposableHelper.m32090a(this.f34949d);
        }
    }

    public FlowableDebounce(Flowable<T> flowable, Function<? super T, ? extends Publisher<U>> function) {
        super(flowable);
        this.f37696a = function;
    }

    protected final void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe(new DebounceSubscriber(new SerializedSubscriber(subscriber), this.f37696a));
    }
}
