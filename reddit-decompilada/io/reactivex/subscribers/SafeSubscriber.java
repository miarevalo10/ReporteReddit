package io.reactivex.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class SafeSubscriber<T> implements FlowableSubscriber<T>, Subscription {
    final Subscriber<? super T> f35959a;
    Subscription f35960b;
    boolean f35961c;

    public SafeSubscriber(Subscriber<? super T> subscriber) {
        this.f35959a = subscriber;
    }

    public final void mo5623a(Subscription subscription) {
        if (SubscriptionHelper.m32781a(this.f35960b, subscription)) {
            this.f35960b = subscription;
            try {
                this.f35959a.mo5623a(this);
            } catch (Subscription subscription2) {
                Exceptions.m26521b(subscription2);
                RxJavaPlugins.m26757a(new CompositeException(th, subscription2));
            }
        }
    }

    public final void onNext(T t) {
        if (!this.f35961c) {
            if (this.f35960b == null) {
                this.f35961c = true;
                t = new NullPointerException("Subscription not set!");
                try {
                    this.f35959a.mo5623a(EmptySubscription.f38145a);
                    try {
                        this.f35959a.onError(t);
                    } catch (Throwable th) {
                        Exceptions.m26521b(th);
                        RxJavaPlugins.m26757a(new CompositeException(t, th));
                    }
                } catch (Throwable th2) {
                    Exceptions.m26521b(th2);
                    RxJavaPlugins.m26757a(new CompositeException(t, th2));
                }
            } else if (t == null) {
                t = new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
                try {
                    this.f35960b.cancel();
                    onError(t);
                } catch (Throwable th22) {
                    Exceptions.m26521b(th22);
                    onError(new CompositeException(t, th22));
                }
            } else {
                try {
                    this.f35959a.onNext(t);
                } catch (Throwable th222) {
                    Exceptions.m26521b(th222);
                    onError(new CompositeException(t, th222));
                }
            }
        }
    }

    public final void onError(Throwable th) {
        if (this.f35961c) {
            RxJavaPlugins.m26757a(th);
            return;
        }
        this.f35961c = true;
        if (this.f35960b == null) {
            NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
            try {
                this.f35959a.mo5623a(EmptySubscription.f38145a);
                try {
                    this.f35959a.onError(new CompositeException(th, nullPointerException));
                    return;
                } catch (Throwable th2) {
                    Exceptions.m26521b(th2);
                    RxJavaPlugins.m26757a(new CompositeException(th, nullPointerException, th2));
                    return;
                }
            } catch (Throwable th22) {
                Exceptions.m26521b(th22);
                RxJavaPlugins.m26757a(new CompositeException(th, nullPointerException, th22));
                return;
            }
        }
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        }
        try {
            this.f35959a.onError(th);
        } catch (Throwable th3) {
            Exceptions.m26521b(th3);
            RxJavaPlugins.m26757a(new CompositeException(th, th3));
        }
    }

    public final void onComplete() {
        if (!this.f35961c) {
            this.f35961c = true;
            if (this.f35960b == null) {
                Throwable nullPointerException = new NullPointerException("Subscription not set!");
                try {
                    this.f35959a.mo5623a(EmptySubscription.f38145a);
                    try {
                        this.f35959a.onError(nullPointerException);
                        return;
                    } catch (Throwable th) {
                        Exceptions.m26521b(th);
                        RxJavaPlugins.m26757a(new CompositeException(nullPointerException, th));
                        return;
                    }
                } catch (Throwable th2) {
                    Exceptions.m26521b(th2);
                    RxJavaPlugins.m26757a(new CompositeException(nullPointerException, th2));
                    return;
                }
            }
            try {
                this.f35959a.onComplete();
            } catch (Throwable th3) {
                Exceptions.m26521b(th3);
                RxJavaPlugins.m26757a(th3);
            }
        }
    }

    public final void request(long j) {
        try {
            this.f35960b.request(j);
        } catch (Throwable th) {
            Exceptions.m26521b(th);
            RxJavaPlugins.m26757a(new CompositeException(th, th));
        }
    }

    public final void cancel() {
        try {
            this.f35960b.cancel();
        } catch (Throwable th) {
            Exceptions.m26521b(th);
            RxJavaPlugins.m26757a(th);
        }
    }
}
