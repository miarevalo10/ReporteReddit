package io.reactivex.internal.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class SubscriberResourceWrapper<T> extends AtomicReference<Disposable> implements FlowableSubscriber<T>, Disposable, Subscription {
    final Subscriber<? super T> f35935a;
    final AtomicReference<Subscription> f35936b = new AtomicReference();

    public SubscriberResourceWrapper(Subscriber<? super T> subscriber) {
        this.f35935a = subscriber;
    }

    public final void mo5623a(Subscription subscription) {
        if (SubscriptionHelper.m32779a(this.f35936b, subscription) != null) {
            this.f35935a.mo5623a(this);
        }
    }

    public final void onNext(T t) {
        this.f35935a.onNext(t);
    }

    public final void onError(Throwable th) {
        DisposableHelper.m32090a((AtomicReference) this);
        this.f35935a.onError(th);
    }

    public final void onComplete() {
        DisposableHelper.m32090a((AtomicReference) this);
        this.f35935a.onComplete();
    }

    public final void request(long j) {
        if (SubscriptionHelper.m32776a(j)) {
            ((Subscription) this.f35936b.get()).request(j);
        }
    }

    public final void mo5626a() {
        SubscriptionHelper.m32777a(this.f35936b);
        DisposableHelper.m32090a((AtomicReference) this);
    }

    public final boolean mo5627b() {
        return this.f35936b.get() == SubscriptionHelper.f32454a;
    }

    public final void cancel() {
        mo5626a();
    }
}
