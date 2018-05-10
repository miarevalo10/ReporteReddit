package io.reactivex.internal.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public final class LambdaSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T>, Disposable, Subscription {
    final Consumer<? super T> f35921a;
    final Consumer<? super Throwable> f35922b;
    final Action f35923c;
    final Consumer<? super Subscription> f35924d;

    public LambdaSubscriber(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action, Consumer<? super Subscription> consumer3) {
        this.f35921a = consumer;
        this.f35922b = consumer2;
        this.f35923c = action;
        this.f35924d = consumer3;
    }

    public final void mo5623a(Subscription subscription) {
        if (SubscriptionHelper.m32779a((AtomicReference) this, subscription)) {
            try {
                this.f35924d.accept(this);
            } catch (Throwable th) {
                Exceptions.m26521b(th);
                subscription.cancel();
                onError(th);
            }
        }
    }

    public final void onNext(T t) {
        if (!mo5627b()) {
            try {
                this.f35921a.accept(t);
            } catch (T t2) {
                Exceptions.m26521b(t2);
                ((Subscription) get()).cancel();
                onError(t2);
            }
        }
    }

    public final void onError(Throwable th) {
        if (get() != SubscriptionHelper.f32454a) {
            lazySet(SubscriptionHelper.f32454a);
            try {
                this.f35922b.accept(th);
                return;
            } catch (Throwable th2) {
                Exceptions.m26521b(th2);
                RxJavaPlugins.m26757a(new CompositeException(th, th2));
                return;
            }
        }
        RxJavaPlugins.m26757a(th);
    }

    public final void onComplete() {
        if (get() != SubscriptionHelper.f32454a) {
            lazySet(SubscriptionHelper.f32454a);
            try {
                this.f35923c.run();
            } catch (Throwable th) {
                Exceptions.m26521b(th);
                RxJavaPlugins.m26757a(th);
            }
        }
    }

    public final void mo5626a() {
        cancel();
    }

    public final boolean mo5627b() {
        return get() == SubscriptionHelper.f32454a;
    }

    public final void request(long j) {
        ((Subscription) get()).request(j);
    }

    public final void cancel() {
        SubscriptionHelper.m32777a((AtomicReference) this);
    }
}
