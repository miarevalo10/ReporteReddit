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
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableDebounceTimed<T> extends AbstractFlowableWithUpstream<T, T> {
    final long f37697a;
    final TimeUnit f37698b;
    final Scheduler f37699c;

    static final class DebounceEmitter<T> extends AtomicReference<Disposable> implements Disposable, Runnable {
        final T f31255a;
        final long f31256b;
        final DebounceTimedSubscriber<T> f31257c;
        final AtomicBoolean f31258d = new AtomicBoolean();

        DebounceEmitter(T t, long j, DebounceTimedSubscriber<T> debounceTimedSubscriber) {
            this.f31255a = t;
            this.f31256b = j;
            this.f31257c = debounceTimedSubscriber;
        }

        public final void run() {
            m32176c();
        }

        final void m32176c() {
            if (this.f31258d.compareAndSet(false, true)) {
                AtomicLong atomicLong = this.f31257c;
                long j = this.f31256b;
                Object obj = this.f31255a;
                if (j == atomicLong.f34958g) {
                    if (atomicLong.get() != 0) {
                        atomicLong.f34952a.onNext(obj);
                        BackpressureHelper.m26673c(atomicLong, 1);
                        DisposableHelper.m32090a((AtomicReference) this);
                        return;
                    }
                    atomicLong.cancel();
                    atomicLong.f34952a.onError(new MissingBackpressureException("Could not deliver value due to lack of requests"));
                }
            }
        }

        public final void mo5626a() {
            DisposableHelper.m32090a((AtomicReference) this);
        }

        public final boolean mo5627b() {
            return get() == DisposableHelper.f31095a;
        }
    }

    static final class DebounceTimedSubscriber<T> extends AtomicLong implements FlowableSubscriber<T>, Subscription {
        final Subscriber<? super T> f34952a;
        final long f34953b;
        final TimeUnit f34954c;
        final Worker f34955d;
        Subscription f34956e;
        final SequentialDisposable f34957f = new SequentialDisposable();
        volatile long f34958g;
        boolean f34959h;

        DebounceTimedSubscriber(Subscriber<? super T> subscriber, long j, TimeUnit timeUnit, Worker worker) {
            this.f34952a = subscriber;
            this.f34953b = j;
            this.f34954c = timeUnit;
            this.f34955d = worker;
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32781a(this.f34956e, subscription)) {
                this.f34956e = subscription;
                this.f34952a.mo5623a(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public final void onNext(T t) {
            if (!this.f34959h) {
                long j = this.f34958g + 1;
                this.f34958g = j;
                Disposable disposable = (Disposable) this.f34957f.get();
                if (disposable != null) {
                    disposable.mo5626a();
                }
                AtomicReference debounceEmitter = new DebounceEmitter(t, j, this);
                if (DisposableHelper.m32094c(this.f34957f, debounceEmitter) != null) {
                    DisposableHelper.m32094c(debounceEmitter, this.f34955d.mo6607a(debounceEmitter, this.f34953b, this.f34954c));
                }
            }
        }

        public final void onError(Throwable th) {
            if (this.f34959h) {
                RxJavaPlugins.m26757a(th);
                return;
            }
            this.f34959h = true;
            this.f34952a.onError(th);
            this.f34955d.mo5626a();
        }

        public final void onComplete() {
            if (!this.f34959h) {
                this.f34959h = true;
                Disposable disposable = (Disposable) this.f34957f.get();
                if (!DisposableHelper.m32088a(disposable)) {
                    DebounceEmitter debounceEmitter = (DebounceEmitter) disposable;
                    if (debounceEmitter != null) {
                        debounceEmitter.m32176c();
                    }
                    DisposableHelper.m32090a(this.f34957f);
                    this.f34952a.onComplete();
                    this.f34955d.mo5626a();
                }
            }
        }

        public final void request(long j) {
            if (SubscriptionHelper.m32776a(j)) {
                BackpressureHelper.m26670a((AtomicLong) this, j);
            }
        }

        public final void cancel() {
            this.f34956e.cancel();
            this.f34955d.mo5626a();
        }
    }

    public FlowableDebounceTimed(Flowable<T> flowable, long j, TimeUnit timeUnit, Scheduler scheduler) {
        super(flowable);
        this.f37697a = j;
        this.f37698b = timeUnit;
        this.f37699c = scheduler;
    }

    protected final void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe(new DebounceTimedSubscriber(new SerializedSubscriber(subscriber), this.f37697a, this.f37698b, this.f37699c.mo5629a()));
    }
}
