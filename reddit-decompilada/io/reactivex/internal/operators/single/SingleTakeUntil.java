package io.reactivex.internal.operators.single;

import io.reactivex.FlowableSubscriber;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

public final class SingleTakeUntil<T, U> extends Single<T> {
    final SingleSource<T> f35843a;
    final Publisher<U> f35844b;

    static final class TakeUntilMainObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T>, Disposable {
        final SingleObserver<? super T> f32383a;
        final TakeUntilOtherSubscriber f32384b = new TakeUntilOtherSubscriber(this);

        TakeUntilMainObserver(SingleObserver<? super T> singleObserver) {
            this.f32383a = singleObserver;
        }

        public final void mo5626a() {
            DisposableHelper.m32090a((AtomicReference) this);
        }

        public final boolean mo5627b() {
            return DisposableHelper.m32088a((Disposable) get());
        }

        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.m32092b(this, disposable);
        }

        public final void onSuccess(T t) {
            SubscriptionHelper.m32777a(this.f32384b);
            if (((Disposable) get()) != DisposableHelper.f31095a && ((Disposable) getAndSet(DisposableHelper.f31095a)) != DisposableHelper.f31095a) {
                this.f32383a.onSuccess(t);
            }
        }

        public final void onError(Throwable th) {
            SubscriptionHelper.m32777a(this.f32384b);
            if (((Disposable) get()) == DisposableHelper.f31095a || ((Disposable) getAndSet(DisposableHelper.f31095a)) == DisposableHelper.f31095a) {
                RxJavaPlugins.m26757a(th);
            } else {
                this.f32383a.onError(th);
            }
        }

        final void m32724a(Throwable th) {
            if (((Disposable) get()) != DisposableHelper.f31095a) {
                Disposable disposable = (Disposable) getAndSet(DisposableHelper.f31095a);
                if (disposable != DisposableHelper.f31095a) {
                    if (disposable != null) {
                        disposable.mo5626a();
                    }
                    this.f32383a.onError(th);
                    return;
                }
            }
            RxJavaPlugins.m26757a(th);
        }
    }

    static final class TakeUntilOtherSubscriber extends AtomicReference<Subscription> implements FlowableSubscriber<Object> {
        final TakeUntilMainObserver<?> f35842a;

        TakeUntilOtherSubscriber(TakeUntilMainObserver<?> takeUntilMainObserver) {
            this.f35842a = takeUntilMainObserver;
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32779a((AtomicReference) this, subscription)) {
                subscription.request(Long.MAX_VALUE);
            }
        }

        public final void onNext(Object obj) {
            if (SubscriptionHelper.m32777a((AtomicReference) this) != null) {
                this.f35842a.m32724a(new CancellationException());
            }
        }

        public final void onError(Throwable th) {
            this.f35842a.m32724a(th);
        }

        public final void onComplete() {
            if (get() != SubscriptionHelper.f32454a) {
                lazySet(SubscriptionHelper.f32454a);
                this.f35842a.m32724a(new CancellationException());
            }
        }
    }

    public SingleTakeUntil(SingleSource<T> singleSource, Publisher<U> publisher) {
        this.f35843a = singleSource;
        this.f35844b = publisher;
    }

    protected final void subscribeActual(SingleObserver<? super T> singleObserver) {
        SingleObserver takeUntilMainObserver = new TakeUntilMainObserver(singleObserver);
        singleObserver.onSubscribe(takeUntilMainObserver);
        this.f35844b.subscribe(takeUntilMainObserver.f32384b);
        this.f35843a.subscribe(takeUntilMainObserver);
    }
}
