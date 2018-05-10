package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Iterator;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableZipIterable<T, U, V> extends AbstractFlowableWithUpstream<T, V> {
    final Iterable<U> f37906a;
    final BiFunction<? super T, ? super U, ? extends V> f37907b;

    static final class ZipIterableSubscriber<T, U, V> implements FlowableSubscriber<T>, Subscription {
        final Subscriber<? super V> f35543a;
        final Iterator<U> f35544b;
        final BiFunction<? super T, ? super U, ? extends V> f35545c;
        Subscription f35546d;
        boolean f35547e;

        ZipIterableSubscriber(Subscriber<? super V> subscriber, Iterator<U> it, BiFunction<? super T, ? super U, ? extends V> biFunction) {
            this.f35543a = subscriber;
            this.f35544b = it;
            this.f35545c = biFunction;
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32781a(this.f35546d, subscription)) {
                this.f35546d = subscription;
                this.f35543a.mo5623a(this);
            }
        }

        public final void onNext(T t) {
            if (!this.f35547e) {
                try {
                    try {
                        this.f35543a.onNext(ObjectHelper.m26573a(this.f35545c.apply(t, ObjectHelper.m26573a(this.f35544b.next(), "The iterator returned a null value")), "The zipper function returned a null value"));
                        try {
                            if (this.f35544b.hasNext() == null) {
                                this.f35547e = true;
                                this.f35546d.cancel();
                                this.f35543a.onComplete();
                            }
                        } catch (Throwable th) {
                            m35897a(th);
                        }
                    } catch (Throwable th2) {
                        m35897a(th2);
                    }
                } catch (Throwable th22) {
                    m35897a(th22);
                }
            }
        }

        private void m35897a(Throwable th) {
            Exceptions.m26521b(th);
            this.f35547e = true;
            this.f35546d.cancel();
            this.f35543a.onError(th);
        }

        public final void onError(Throwable th) {
            if (this.f35547e) {
                RxJavaPlugins.m26757a(th);
                return;
            }
            this.f35547e = true;
            this.f35543a.onError(th);
        }

        public final void onComplete() {
            if (!this.f35547e) {
                this.f35547e = true;
                this.f35543a.onComplete();
            }
        }

        public final void request(long j) {
            this.f35546d.request(j);
        }

        public final void cancel() {
            this.f35546d.cancel();
        }
    }

    public FlowableZipIterable(Flowable<T> flowable, Iterable<U> iterable, BiFunction<? super T, ? super U, ? extends V> biFunction) {
        super(flowable);
        this.f37906a = iterable;
        this.f37907b = biFunction;
    }

    public final void subscribeActual(Subscriber<? super V> subscriber) {
        try {
            Iterator it = (Iterator) ObjectHelper.m26573a(this.f37906a.iterator(), "The iterator returned by other is null");
            try {
                if (it.hasNext()) {
                    this.source.subscribe(new ZipIterableSubscriber(subscriber, it, this.f37907b));
                } else {
                    EmptySubscription.m38161a((Subscriber) subscriber);
                }
            } catch (Throwable th) {
                Exceptions.m26521b(th);
                EmptySubscription.m38160a(th, subscriber);
            }
        } catch (Throwable th2) {
            Exceptions.m26521b(th2);
            EmptySubscription.m38160a(th2, subscriber);
        }
    }
}
