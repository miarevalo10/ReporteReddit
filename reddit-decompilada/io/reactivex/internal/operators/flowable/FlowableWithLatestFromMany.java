package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.HalfSerializer;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableWithLatestFromMany<T, R> extends AbstractFlowableWithUpstream<T, R> {
    final Publisher<?>[] f37903a;
    final Iterable<? extends Publisher<?>> f37904b;
    final Function<? super Object[], R> f37905c;

    final class SingletonArrayFunc implements Function<T, R> {
        final /* synthetic */ FlowableWithLatestFromMany f31371a;

        SingletonArrayFunc(FlowableWithLatestFromMany flowableWithLatestFromMany) {
            this.f31371a = flowableWithLatestFromMany;
        }

        public final R apply(T t) throws Exception {
            return ObjectHelper.m26573a(this.f31371a.f37905c.apply(new Object[]{t}), "The combiner returned a null value");
        }
    }

    static final class WithLatestInnerSubscriber extends AtomicReference<Subscription> implements FlowableSubscriber<Object> {
        final WithLatestFromSubscriber<?, ?> f35528a;
        final int f35529b;
        boolean f35530c;

        WithLatestInnerSubscriber(WithLatestFromSubscriber<?, ?> withLatestFromSubscriber, int i) {
            this.f35528a = withLatestFromSubscriber;
            this.f35529b = i;
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32779a((AtomicReference) this, subscription)) {
                subscription.request(Long.MAX_VALUE);
            }
        }

        public final void onNext(Object obj) {
            if (!this.f35530c) {
                this.f35530c = true;
            }
            WithLatestFromSubscriber withLatestFromSubscriber = this.f35528a;
            withLatestFromSubscriber.f37898d.set(this.f35529b, obj);
        }

        public final void onError(Throwable th) {
            AtomicInteger atomicInteger = this.f35528a;
            int i = this.f35529b;
            atomicInteger.f37902h = true;
            SubscriptionHelper.m32777a(atomicInteger.f37899e);
            atomicInteger.m38133a(i);
            HalfSerializer.m26690a(atomicInteger.f37895a, th, atomicInteger, atomicInteger.f37901g);
        }

        public final void onComplete() {
            AtomicInteger atomicInteger = this.f35528a;
            int i = this.f35529b;
            if (!this.f35530c) {
                atomicInteger.f37902h = true;
                SubscriptionHelper.m32777a(atomicInteger.f37899e);
                atomicInteger.m38133a(i);
                HalfSerializer.m26691a(atomicInteger.f37895a, atomicInteger, atomicInteger.f37901g);
            }
        }
    }

    static final class WithLatestFromSubscriber<T, R> extends AtomicInteger implements ConditionalSubscriber<T>, Subscription {
        final Subscriber<? super R> f37895a;
        final Function<? super Object[], R> f37896b;
        final WithLatestInnerSubscriber[] f37897c;
        final AtomicReferenceArray<Object> f37898d;
        final AtomicReference<Subscription> f37899e;
        final AtomicLong f37900f;
        final AtomicThrowable f37901g;
        volatile boolean f37902h;

        WithLatestFromSubscriber(Subscriber<? super R> subscriber, Function<? super Object[], R> function, int i) {
            this.f37895a = subscriber;
            this.f37896b = function;
            subscriber = new WithLatestInnerSubscriber[i];
            for (function = null; function < i; function++) {
                subscriber[function] = new WithLatestInnerSubscriber(this, function);
            }
            this.f37897c = subscriber;
            this.f37898d = new AtomicReferenceArray(i);
            this.f37899e = new AtomicReference();
            this.f37900f = new AtomicLong();
            this.f37901g = new AtomicThrowable();
        }

        public final void mo5623a(Subscription subscription) {
            SubscriptionHelper.m32778a(this.f37899e, this.f37900f, subscription);
        }

        public final void onNext(T t) {
            if (mo7052a((Object) t) == null && this.f37902h == null) {
                ((Subscription) this.f37899e.get()).request(1);
            }
        }

        public final boolean mo7052a(T t) {
            if (this.f37902h) {
                return false;
            }
            AtomicReferenceArray atomicReferenceArray = this.f37898d;
            T length = atomicReferenceArray.length();
            Object obj = new Object[(length + 1)];
            obj[0] = t;
            t = null;
            while (t < length) {
                Object obj2 = atomicReferenceArray.get(t);
                if (obj2 == null) {
                    return false;
                }
                t++;
                obj[t] = obj2;
            }
            try {
                HalfSerializer.m26689a(this.f37895a, ObjectHelper.m26573a(this.f37896b.apply(obj), "The combiner returned a null value"), (AtomicInteger) this, this.f37901g);
                return true;
            } catch (T t2) {
                Exceptions.m26521b(t2);
                cancel();
                onError(t2);
                return false;
            }
        }

        public final void onError(Throwable th) {
            if (this.f37902h) {
                RxJavaPlugins.m26757a(th);
                return;
            }
            this.f37902h = true;
            m38133a(-1);
            HalfSerializer.m26690a(this.f37895a, th, (AtomicInteger) this, this.f37901g);
        }

        public final void onComplete() {
            if (!this.f37902h) {
                this.f37902h = true;
                m38133a(-1);
                HalfSerializer.m26691a(this.f37895a, (AtomicInteger) this, this.f37901g);
            }
        }

        public final void request(long j) {
            SubscriptionHelper.m32775a(this.f37899e, this.f37900f, j);
        }

        public final void cancel() {
            SubscriptionHelper.m32777a(this.f37899e);
            for (AtomicReference a : this.f37897c) {
                SubscriptionHelper.m32777a(a);
            }
        }

        final void m38133a(int i) {
            WithLatestInnerSubscriber[] withLatestInnerSubscriberArr = this.f37897c;
            for (int i2 = 0; i2 < withLatestInnerSubscriberArr.length; i2++) {
                if (i2 != i) {
                    SubscriptionHelper.m32777a(withLatestInnerSubscriberArr[i2]);
                }
            }
        }
    }

    public FlowableWithLatestFromMany(Flowable<T> flowable, Publisher<?>[] publisherArr, Function<? super Object[], R> function) {
        super(flowable);
        this.f37903a = publisherArr;
        this.f37904b = null;
        this.f37905c = function;
    }

    public FlowableWithLatestFromMany(Flowable<T> flowable, Iterable<? extends Publisher<?>> iterable, Function<? super Object[], R> function) {
        super(flowable);
        this.f37903a = null;
        this.f37904b = iterable;
        this.f37905c = function;
    }

    protected final void subscribeActual(Subscriber<? super R> subscriber) {
        int i;
        Object[] objArr = this.f37903a;
        int i2 = 0;
        if (objArr == null) {
            objArr = new Publisher[8];
            try {
                i = 0;
                for (Publisher publisher : this.f37904b) {
                    if (i == objArr.length) {
                        objArr = (Publisher[]) Arrays.copyOf(objArr, (i >> 1) + i);
                    }
                    int i3 = i + 1;
                    objArr[i] = publisher;
                    i = i3;
                }
            } catch (Throwable th) {
                Exceptions.m26521b(th);
                EmptySubscription.m38160a(th, subscriber);
                return;
            }
        }
        i = objArr.length;
        if (i == 0) {
            new FlowableMap(this.source, new SingletonArrayFunc(this)).subscribeActual(subscriber);
            return;
        }
        FlowableSubscriber withLatestFromSubscriber = new WithLatestFromSubscriber(subscriber, this.f37905c, i);
        subscriber.mo5623a(withLatestFromSubscriber);
        subscriber = withLatestFromSubscriber.f37897c;
        AtomicReference atomicReference = withLatestFromSubscriber.f37899e;
        while (i2 < i && !SubscriptionHelper.m32780a((Subscription) atomicReference.get())) {
            objArr[i2].subscribe(subscriber[i2]);
            i2++;
        }
        this.source.subscribe(withLatestFromSubscriber);
    }
}
