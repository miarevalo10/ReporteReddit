package io.reactivex.internal.util;

import io.reactivex.CompletableObserver;
import io.reactivex.FlowableSubscriber;
import io.reactivex.MaybeObserver;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public enum EmptyComponent implements CompletableObserver, FlowableSubscriber<Object>, MaybeObserver<Object>, Observer<Object>, SingleObserver<Object>, Disposable, Subscription {
    ;

    public final void mo5626a() {
    }

    public final boolean mo5627b() {
        return true;
    }

    public final void cancel() {
    }

    public final void onComplete() {
    }

    public final void onNext(Object obj) {
    }

    public final void onSuccess(Object obj) {
    }

    public final void request(long j) {
    }

    private EmptyComponent(String str) {
    }

    public static <T> Subscriber<T> m36013c() {
        return f35937a;
    }

    public static <T> Observer<T> m36014d() {
        return f35937a;
    }

    public final void onSubscribe(Disposable disposable) {
        disposable.mo5626a();
    }

    public final void mo5623a(Subscription subscription) {
        subscription.cancel();
    }

    public final void onError(Throwable th) {
        RxJavaPlugins.m26757a(th);
    }
}
