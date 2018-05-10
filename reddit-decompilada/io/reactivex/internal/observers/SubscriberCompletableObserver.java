package io.reactivex.internal.observers;

import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class SubscriberCompletableObserver<T> implements CompletableObserver, Subscription {
    final Subscriber<? super T> f31170a;
    Disposable f31171b;

    public final void request(long j) {
    }

    public SubscriberCompletableObserver(Subscriber<? super T> subscriber) {
        this.f31170a = subscriber;
    }

    public final void onComplete() {
        this.f31170a.onComplete();
    }

    public final void onError(Throwable th) {
        this.f31170a.onError(th);
    }

    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.m32089a(this.f31171b, disposable)) {
            this.f31171b = disposable;
            this.f31170a.mo5623a(this);
        }
    }

    public final void cancel() {
        this.f31171b.mo5626a();
    }
}
