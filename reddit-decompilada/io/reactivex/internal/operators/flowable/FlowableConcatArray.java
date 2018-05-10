package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableConcatArray<T> extends Flowable<T> {
    final Publisher<? extends T>[] f34897a;
    final boolean f34898b;

    static final class ConcatArraySubscriber<T> extends SubscriptionArbiter implements FlowableSubscriber<T> {
        final Subscriber<? super T> f34890a;
        final Publisher<? extends T>[] f34891b;
        final boolean f34892c;
        final AtomicInteger f34893d = new AtomicInteger();
        int f34894e;
        List<Throwable> f34895f;
        long f34896g;

        ConcatArraySubscriber(Publisher<? extends T>[] publisherArr, boolean z, Subscriber<? super T> subscriber) {
            this.f34890a = subscriber;
            this.f34891b = publisherArr;
            this.f34892c = z;
        }

        public final void mo5623a(Subscription subscription) {
            m32772b(subscription);
        }

        public final void onNext(T t) {
            this.f34896g++;
            this.f34890a.onNext(t);
        }

        public final void onError(Throwable th) {
            if (this.f34892c) {
                List list = this.f34895f;
                if (list == null) {
                    list = new ArrayList((this.f34891b.length - this.f34894e) + 1);
                    this.f34895f = list;
                }
                list.add(th);
                onComplete();
                return;
            }
            this.f34890a.onError(th);
        }

        public final void onComplete() {
            if (this.f34893d.getAndIncrement() == 0) {
                Publisher[] publisherArr = this.f34891b;
                int length = publisherArr.length;
                int i = this.f34894e;
                while (i != length) {
                    Publisher publisher = publisherArr[i];
                    if (publisher == null) {
                        Throwable nullPointerException = new NullPointerException("A Publisher entry is null");
                        if (this.f34892c) {
                            List list = this.f34895f;
                            if (list == null) {
                                list = new ArrayList((length - i) + 1);
                                this.f34895f = list;
                            }
                            list.add(nullPointerException);
                            i++;
                        } else {
                            this.f34890a.onError(nullPointerException);
                            return;
                        }
                    }
                    long j = this.f34896g;
                    if (j != 0) {
                        this.f34896g = 0;
                        m32773c(j);
                    }
                    publisher.subscribe(this);
                    i++;
                    this.f34894e = i;
                    if (this.f34893d.decrementAndGet() == 0) {
                    }
                }
                Iterable iterable = this.f34895f;
                if (iterable == null) {
                    this.f34890a.onComplete();
                } else if (iterable.size() == 1) {
                    this.f34890a.onError((Throwable) iterable.get(0));
                } else {
                    this.f34890a.onError(new CompositeException(iterable));
                }
            }
        }
    }

    public FlowableConcatArray(Publisher<? extends T>[] publisherArr, boolean z) {
        this.f34897a = publisherArr;
        this.f34898b = z;
    }

    protected final void subscribeActual(Subscriber<? super T> subscriber) {
        Object concatArraySubscriber = new ConcatArraySubscriber(this.f34897a, this.f34898b, subscriber);
        subscriber.mo5623a(concatArraySubscriber);
        concatArraySubscriber.onComplete();
    }
}
