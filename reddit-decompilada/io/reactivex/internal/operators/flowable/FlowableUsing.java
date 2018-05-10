package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableUsing<T, D> extends Flowable<T> {
    final Callable<? extends D> f35490a;
    final Function<? super D, ? extends Publisher<? extends T>> f35491b;
    final Consumer<? super D> f35492c;
    final boolean f35493d;

    static final class UsingSubscriber<T, D> extends AtomicBoolean implements FlowableSubscriber<T>, Subscription {
        final Subscriber<? super T> f35485a;
        final D f35486b;
        final Consumer<? super D> f35487c;
        final boolean f35488d;
        Subscription f35489e;

        UsingSubscriber(Subscriber<? super T> subscriber, D d, Consumer<? super D> consumer, boolean z) {
            this.f35485a = subscriber;
            this.f35486b = d;
            this.f35487c = consumer;
            this.f35488d = z;
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32781a(this.f35489e, subscription)) {
                this.f35489e = subscription;
                this.f35485a.mo5623a(this);
            }
        }

        public final void onNext(T t) {
            this.f35485a.onNext(t);
        }

        public final void onError(Throwable th) {
            if (this.f35488d) {
                Throwable th2 = null;
                if (compareAndSet(false, true)) {
                    try {
                        this.f35487c.accept(this.f35486b);
                    } catch (Throwable th3) {
                        th2 = th3;
                        Exceptions.m26521b(th2);
                    }
                }
                this.f35489e.cancel();
                if (th2 != null) {
                    this.f35485a.onError(new CompositeException(th, th2));
                    return;
                }
                this.f35485a.onError(th);
                return;
            }
            this.f35485a.onError(th);
            this.f35489e.cancel();
            m35887a();
        }

        public final void onComplete() {
            if (this.f35488d) {
                if (compareAndSet(false, true)) {
                    try {
                        this.f35487c.accept(this.f35486b);
                    } catch (Throwable th) {
                        Exceptions.m26521b(th);
                        this.f35485a.onError(th);
                        return;
                    }
                }
                this.f35489e.cancel();
                this.f35485a.onComplete();
                return;
            }
            this.f35485a.onComplete();
            this.f35489e.cancel();
            m35887a();
        }

        public final void request(long j) {
            this.f35489e.request(j);
        }

        public final void cancel() {
            m35887a();
            this.f35489e.cancel();
        }

        private void m35887a() {
            if (compareAndSet(false, true)) {
                try {
                    this.f35487c.accept(this.f35486b);
                } catch (Throwable th) {
                    Exceptions.m26521b(th);
                    RxJavaPlugins.m26757a(th);
                }
            }
        }
    }

    public FlowableUsing(Callable<? extends D> callable, Function<? super D, ? extends Publisher<? extends T>> function, Consumer<? super D> consumer, boolean z) {
        this.f35490a = callable;
        this.f35491b = function;
        this.f35492c = consumer;
        this.f35493d = z;
    }

    public final void subscribeActual(Subscriber<? super T> subscriber) {
        try {
            Object call = this.f35490a.call();
            try {
                ((Publisher) ObjectHelper.m26573a(this.f35491b.apply(call), "The sourceSupplier returned a null Publisher")).subscribe(new UsingSubscriber(subscriber, call, this.f35492c, this.f35493d));
            } catch (Throwable th) {
                Exceptions.m26521b(th);
                EmptySubscription.m38160a(new CompositeException(th, th), subscriber);
            }
        } catch (Throwable th2) {
            Exceptions.m26521b(th2);
            EmptySubscription.m38160a(th2, subscriber);
        }
    }
}
