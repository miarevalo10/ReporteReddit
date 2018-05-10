package io.reactivex.internal.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public final class ForEachWhileSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T>, Disposable {
    final Predicate<? super T> f35907a;
    final Consumer<? super Throwable> f35908b;
    final Action f35909c;
    boolean f35910d;

    public ForEachWhileSubscriber(Predicate<? super T> predicate, Consumer<? super Throwable> consumer, Action action) {
        this.f35907a = predicate;
        this.f35908b = consumer;
        this.f35909c = action;
    }

    public final void mo5623a(Subscription subscription) {
        if (SubscriptionHelper.m32779a((AtomicReference) this, subscription)) {
            subscription.request(Long.MAX_VALUE);
        }
    }

    public final void onNext(T t) {
        if (!this.f35910d) {
            try {
                if (this.f35907a.test(t) == null) {
                    SubscriptionHelper.m32777a((AtomicReference) this);
                    onComplete();
                }
            } catch (T t2) {
                Exceptions.m26521b(t2);
                SubscriptionHelper.m32777a((AtomicReference) this);
                onError(t2);
            }
        }
    }

    public final void onError(Throwable th) {
        if (this.f35910d) {
            RxJavaPlugins.m26757a(th);
            return;
        }
        this.f35910d = true;
        try {
            this.f35908b.accept(th);
        } catch (Throwable th2) {
            Exceptions.m26521b(th2);
            RxJavaPlugins.m26757a(new CompositeException(th, th2));
        }
    }

    public final void onComplete() {
        if (!this.f35910d) {
            this.f35910d = true;
            try {
                this.f35909c.run();
            } catch (Throwable th) {
                Exceptions.m26521b(th);
                RxJavaPlugins.m26757a(th);
            }
        }
    }

    public final void mo5626a() {
        SubscriptionHelper.m32777a((AtomicReference) this);
    }

    public final boolean mo5627b() {
        return SubscriptionHelper.m32780a((Subscription) get());
    }
}
