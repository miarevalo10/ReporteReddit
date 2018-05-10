package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableAmb<T> extends Flowable<T> {
    final Publisher<? extends T>[] f34814a;
    final Iterable<? extends Publisher<? extends T>> f34815b;

    static final class AmbCoordinator<T> implements Subscription {
        final Subscriber<? super T> f31242a;
        final AmbInnerSubscriber<T>[] f31243b;
        final AtomicInteger f31244c = new AtomicInteger();

        AmbCoordinator(Subscriber<? super T> subscriber, int i) {
            this.f31242a = subscriber;
            this.f31243b = new AmbInnerSubscriber[i];
        }

        public final void m32171a(Publisher<? extends T>[] publisherArr) {
            AmbInnerSubscriber[] ambInnerSubscriberArr = this.f31243b;
            int i = 0;
            int length = ambInnerSubscriberArr.length;
            int i2 = 0;
            while (i2 < length) {
                int i3 = i2 + 1;
                ambInnerSubscriberArr[i2] = new AmbInnerSubscriber(this, i3, this.f31242a);
                i2 = i3;
            }
            this.f31244c.lazySet(0);
            this.f31242a.mo5623a(this);
            while (i < length && this.f31244c.get() == 0) {
                publisherArr[i].subscribe(ambInnerSubscriberArr[i]);
                i++;
            }
        }

        public final void request(long j) {
            if (SubscriptionHelper.m32776a(j)) {
                int i = this.f31244c.get();
                if (i > 0) {
                    this.f31243b[i - 1].request(j);
                } else if (i == 0) {
                    for (AmbInnerSubscriber request : this.f31243b) {
                        request.request(j);
                    }
                }
            }
        }

        public final boolean m32172a(int i) {
            int i2 = 0;
            if (this.f31244c.get() != 0 || !this.f31244c.compareAndSet(0, i)) {
                return false;
            }
            AmbInnerSubscriber[] ambInnerSubscriberArr = this.f31243b;
            int length = ambInnerSubscriberArr.length;
            while (i2 < length) {
                int i3 = i2 + 1;
                if (i3 != i) {
                    ambInnerSubscriberArr[i2].cancel();
                }
                i2 = i3;
            }
            return true;
        }

        public final void cancel() {
            if (this.f31244c.get() != -1) {
                this.f31244c.lazySet(-1);
                for (AmbInnerSubscriber cancel : this.f31243b) {
                    cancel.cancel();
                }
            }
        }
    }

    static final class AmbInnerSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T>, Subscription {
        final AmbCoordinator<T> f34809a;
        final int f34810b;
        final Subscriber<? super T> f34811c;
        boolean f34812d;
        final AtomicLong f34813e = new AtomicLong();

        AmbInnerSubscriber(AmbCoordinator<T> ambCoordinator, int i, Subscriber<? super T> subscriber) {
            this.f34809a = ambCoordinator;
            this.f34810b = i;
            this.f34811c = subscriber;
        }

        public final void mo5623a(Subscription subscription) {
            SubscriptionHelper.m32778a((AtomicReference) this, this.f34813e, subscription);
        }

        public final void request(long j) {
            SubscriptionHelper.m32775a((AtomicReference) this, this.f34813e, j);
        }

        public final void onNext(T t) {
            if (this.f34812d) {
                this.f34811c.onNext(t);
            } else if (this.f34809a.m32172a(this.f34810b)) {
                this.f34812d = true;
                this.f34811c.onNext(t);
            } else {
                ((Subscription) get()).cancel();
            }
        }

        public final void onError(Throwable th) {
            if (this.f34812d) {
                this.f34811c.onError(th);
            } else if (this.f34809a.m32172a(this.f34810b)) {
                this.f34812d = true;
                this.f34811c.onError(th);
            } else {
                ((Subscription) get()).cancel();
                RxJavaPlugins.m26757a(th);
            }
        }

        public final void onComplete() {
            if (this.f34812d) {
                this.f34811c.onComplete();
            } else if (this.f34809a.m32172a(this.f34810b)) {
                this.f34812d = true;
                this.f34811c.onComplete();
            } else {
                ((Subscription) get()).cancel();
            }
        }

        public final void cancel() {
            SubscriptionHelper.m32777a((AtomicReference) this);
        }
    }

    public FlowableAmb(Publisher<? extends T>[] publisherArr, Iterable<? extends Publisher<? extends T>> iterable) {
        this.f34814a = publisherArr;
        this.f34815b = iterable;
    }

    public final void subscribeActual(Subscriber<? super T> subscriber) {
        int i;
        Publisher[] publisherArr = this.f34814a;
        if (publisherArr == null) {
            publisherArr = new Publisher[8];
            try {
                i = 0;
                for (Publisher publisher : this.f34815b) {
                    if (publisher == null) {
                        EmptySubscription.m38160a(new NullPointerException("One of the sources is null"), subscriber);
                        return;
                    }
                    if (i == publisherArr.length) {
                        Object obj = new Publisher[((i >> 2) + i)];
                        System.arraycopy(publisherArr, 0, obj, 0, i);
                        publisherArr = obj;
                    }
                    int i2 = i + 1;
                    publisherArr[i] = publisher;
                    i = i2;
                }
            } catch (Throwable th) {
                Exceptions.m26521b(th);
                EmptySubscription.m38160a(th, subscriber);
                return;
            }
        }
        i = publisherArr.length;
        if (i == 0) {
            EmptySubscription.m38161a((Subscriber) subscriber);
        } else if (i == 1) {
            publisherArr[0].subscribe(subscriber);
        } else {
            new AmbCoordinator(subscriber, i).m32171a(publisherArr);
        }
    }
}
