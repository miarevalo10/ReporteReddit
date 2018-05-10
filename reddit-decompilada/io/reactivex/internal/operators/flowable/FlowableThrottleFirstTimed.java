package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.Scheduler.Worker;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableThrottleFirstTimed<T> extends AbstractFlowableWithUpstream<T, T> {
    final long f37848a;
    final TimeUnit f37849b;
    final Scheduler f37850c;

    static final class DebounceTimedSubscriber<T> extends AtomicLong implements FlowableSubscriber<T>, Runnable, Subscription {
        final Subscriber<? super T> f35429a;
        final long f35430b;
        final TimeUnit f35431c;
        final Worker f35432d;
        Subscription f35433e;
        final SequentialDisposable f35434f = new SequentialDisposable();
        volatile boolean f35435g;
        boolean f35436h;

        DebounceTimedSubscriber(Subscriber<? super T> subscriber, long j, TimeUnit timeUnit, Worker worker) {
            this.f35429a = subscriber;
            this.f35430b = j;
            this.f35431c = timeUnit;
            this.f35432d = worker;
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32781a(this.f35433e, subscription)) {
                this.f35433e = subscription;
                this.f35429a.mo5623a(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public final void onNext(T t) {
            if (!(this.f35436h || this.f35435g)) {
                this.f35435g = true;
                if (get() != 0) {
                    this.f35429a.onNext(t);
                    BackpressureHelper.m26673c(this, 1);
                    Disposable disposable = (Disposable) this.f35434f.get();
                    if (disposable != null) {
                        disposable.mo5626a();
                    }
                    DisposableHelper.m32094c(this.f35434f, this.f35432d.mo6607a(this, this.f35430b, this.f35431c));
                } else {
                    this.f35436h = true;
                    cancel();
                    this.f35429a.onError(new MissingBackpressureException("Could not deliver value due to lack of requests"));
                }
            }
        }

        public final void run() {
            this.f35435g = false;
        }

        public final void onError(Throwable th) {
            if (this.f35436h) {
                RxJavaPlugins.m26757a(th);
                return;
            }
            this.f35436h = true;
            this.f35429a.onError(th);
            this.f35432d.mo5626a();
        }

        public final void onComplete() {
            if (!this.f35436h) {
                this.f35436h = true;
                this.f35429a.onComplete();
                this.f35432d.mo5626a();
            }
        }

        public final void request(long j) {
            if (SubscriptionHelper.m32776a(j)) {
                BackpressureHelper.m26670a((AtomicLong) this, j);
            }
        }

        public final void cancel() {
            this.f35433e.cancel();
            this.f35432d.mo5626a();
        }
    }

    public FlowableThrottleFirstTimed(Flowable<T> flowable, long j, TimeUnit timeUnit, Scheduler scheduler) {
        super(flowable);
        this.f37848a = j;
        this.f37849b = timeUnit;
        this.f37850c = scheduler;
    }

    protected final void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe(new DebounceTimedSubscriber(new SerializedSubscriber(subscriber), this.f37848a, this.f37849b, this.f37850c.mo5629a()));
    }
}
