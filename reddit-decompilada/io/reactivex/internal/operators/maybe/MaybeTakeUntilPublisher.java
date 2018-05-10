package io.reactivex.internal.operators.maybe;

import io.reactivex.FlowableSubscriber;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

public final class MaybeTakeUntilPublisher<T, U> extends AbstractMaybeWithUpstream<T, T> {
    final Publisher<U> f37939b;

    static final class TakeUntilMainMaybeObserver<T, U> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable {
        final MaybeObserver<? super T> f31523a;
        final TakeUntilOtherMaybeObserver<U> f31524b = new TakeUntilOtherMaybeObserver(this);

        static final class TakeUntilOtherMaybeObserver<U> extends AtomicReference<Subscription> implements FlowableSubscriber<U> {
            final TakeUntilMainMaybeObserver<?, U> f35604a;

            TakeUntilOtherMaybeObserver(TakeUntilMainMaybeObserver<?, U> takeUntilMainMaybeObserver) {
                this.f35604a = takeUntilMainMaybeObserver;
            }

            public final void mo5623a(Subscription subscription) {
                if (SubscriptionHelper.m32779a((AtomicReference) this, subscription)) {
                    subscription.request(Long.MAX_VALUE);
                }
            }

            public final void onNext(Object obj) {
                this.f35604a.m32326c();
            }

            public final void onError(Throwable th) {
                AtomicReference atomicReference = this.f35604a;
                if (DisposableHelper.m32090a(atomicReference)) {
                    atomicReference.f31523a.onError(th);
                } else {
                    RxJavaPlugins.m26757a(th);
                }
            }

            public final void onComplete() {
                this.f35604a.m32326c();
            }
        }

        TakeUntilMainMaybeObserver(MaybeObserver<? super T> maybeObserver) {
            this.f31523a = maybeObserver;
        }

        public final void mo5626a() {
            DisposableHelper.m32090a((AtomicReference) this);
            SubscriptionHelper.m32777a(this.f31524b);
        }

        public final boolean mo5627b() {
            return DisposableHelper.m32088a((Disposable) get());
        }

        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.m32092b(this, disposable);
        }

        public final void onSuccess(T t) {
            SubscriptionHelper.m32777a(this.f31524b);
            if (getAndSet(DisposableHelper.f31095a) != DisposableHelper.f31095a) {
                this.f31523a.onSuccess(t);
            }
        }

        public final void onError(Throwable th) {
            SubscriptionHelper.m32777a(this.f31524b);
            if (getAndSet(DisposableHelper.f31095a) != DisposableHelper.f31095a) {
                this.f31523a.onError(th);
            } else {
                RxJavaPlugins.m26757a(th);
            }
        }

        public final void onComplete() {
            SubscriptionHelper.m32777a(this.f31524b);
            if (getAndSet(DisposableHelper.f31095a) != DisposableHelper.f31095a) {
                this.f31523a.onComplete();
            }
        }

        final void m32326c() {
            if (DisposableHelper.m32090a((AtomicReference) this)) {
                this.f31523a.onComplete();
            }
        }
    }

    public MaybeTakeUntilPublisher(MaybeSource<T> maybeSource, Publisher<U> publisher) {
        super(maybeSource);
        this.f37939b = publisher;
    }

    protected final void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        MaybeObserver takeUntilMainMaybeObserver = new TakeUntilMainMaybeObserver(maybeObserver);
        maybeObserver.onSubscribe(takeUntilMainMaybeObserver);
        this.f37939b.subscribe(takeUntilMainMaybeObserver.f31524b);
        this.a.subscribe(takeUntilMainMaybeObserver);
    }
}
