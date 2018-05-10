package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscribers.SinglePostCompleteSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;

public final class FlowableConcatWithSingle<T> extends AbstractFlowableWithUpstream<T, T> {
    final SingleSource<? extends T> f37682a;

    static final class ConcatWithSubscriber<T> extends SinglePostCompleteSubscriber<T, T> implements SingleObserver<T> {
        final AtomicReference<Disposable> f37680a = new AtomicReference();
        SingleSource<? extends T> f37681b;

        ConcatWithSubscriber(Subscriber<? super T> subscriber, SingleSource<? extends T> singleSource) {
            super(subscriber);
            this.f37681b = singleSource;
        }

        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.m32092b(this.f37680a, disposable);
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
            this.e = SubscriptionHelper.f32454a;
            SingleSource singleSource = this.f37681b;
            this.f37681b = null;
            singleSource.subscribe(this);
        }

        public final void cancel() {
            super.cancel();
            DisposableHelper.m32090a(this.f37680a);
        }
    }

    public FlowableConcatWithSingle(Flowable<T> flowable, SingleSource<? extends T> singleSource) {
        super(flowable);
        this.f37682a = singleSource;
    }

    protected final void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe(new ConcatWithSubscriber(subscriber, this.f37682a));
    }
}
