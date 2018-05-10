package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscribers.SinglePostCompleteSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;

public final class FlowableConcatWithMaybe<T> extends AbstractFlowableWithUpstream<T, T> {
    final MaybeSource<? extends T> f37679a;

    static final class ConcatWithSubscriber<T> extends SinglePostCompleteSubscriber<T, T> implements MaybeObserver<T> {
        final AtomicReference<Disposable> f37676a = new AtomicReference();
        MaybeSource<? extends T> f37677b;
        boolean f37678c;

        ConcatWithSubscriber(Subscriber<? super T> subscriber, MaybeSource<? extends T> maybeSource) {
            super(subscriber);
            this.f37677b = maybeSource;
        }

        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.m32092b(this.f37676a, disposable);
        }

        public final void onNext(T t) {
            this.g++;
            this.d.onNext(t);
        }

        public final void onError(Throwable th) {
            this.d.onError(th);
        }

        public final void onSuccess(T t) {
            m36008b(t);
        }

        public final void onComplete() {
            if (this.f37678c) {
                this.d.onComplete();
                return;
            }
            this.f37678c = true;
            this.e = SubscriptionHelper.f32454a;
            MaybeSource maybeSource = this.f37677b;
            this.f37677b = null;
            maybeSource.subscribe(this);
        }

        public final void cancel() {
            super.cancel();
            DisposableHelper.m32090a(this.f37676a);
        }
    }

    public FlowableConcatWithMaybe(Flowable<T> flowable, MaybeSource<? extends T> maybeSource) {
        super(flowable);
        this.f37679a = maybeSource;
    }

    protected final void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe(new ConcatWithSubscriber(subscriber, this.f37679a));
    }
}
