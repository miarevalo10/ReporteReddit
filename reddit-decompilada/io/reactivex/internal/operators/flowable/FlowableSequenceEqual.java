package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.BiPredicate;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableSequenceEqual<T> extends Flowable<Boolean> {
    final Publisher<? extends T> f35319a;
    final Publisher<? extends T> f35320b;
    final BiPredicate<? super T, ? super T> f35321c;
    final int f35322d;

    interface EqualCoordinatorHelper {
        void mo5653a(Throwable th);

        void ay_();
    }

    static final class EqualSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T> {
        final EqualCoordinatorHelper f35312a;
        final int f35313b;
        final int f35314c;
        long f35315d;
        volatile SimpleQueue<T> f35316e;
        volatile boolean f35317f;
        int f35318g;

        EqualSubscriber(EqualCoordinatorHelper equalCoordinatorHelper, int i) {
            this.f35312a = equalCoordinatorHelper;
            this.f35314c = i - (i >> 2);
            this.f35313b = i;
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32779a((AtomicReference) this, subscription)) {
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int a = queueSubscription.mo7033a(3);
                    if (a == 1) {
                        this.f35318g = a;
                        this.f35316e = queueSubscription;
                        this.f35317f = true;
                        this.f35312a.ay_();
                        return;
                    } else if (a == 2) {
                        this.f35318g = a;
                        this.f35316e = queueSubscription;
                        subscription.request((long) this.f35313b);
                        return;
                    }
                }
                this.f35316e = new SpscArrayQueue(this.f35313b);
                subscription.request((long) this.f35313b);
            }
        }

        public final void onNext(T t) {
            if (this.f35318g == 0 && this.f35316e.offer(t) == null) {
                onError(new MissingBackpressureException());
            } else {
                this.f35312a.ay_();
            }
        }

        public final void onError(Throwable th) {
            this.f35312a.mo5653a(th);
        }

        public final void onComplete() {
            this.f35317f = true;
            this.f35312a.ay_();
        }

        public final void m35828a() {
            if (this.f35318g != 1) {
                long j = this.f35315d + 1;
                if (j >= ((long) this.f35314c)) {
                    this.f35315d = 0;
                    ((Subscription) get()).request(j);
                    return;
                }
                this.f35315d = j;
            }
        }

        final void m35830b() {
            SimpleQueue simpleQueue = this.f35316e;
            if (simpleQueue != null) {
                simpleQueue.clear();
            }
        }
    }

    static final class EqualCoordinator<T> extends DeferredScalarSubscription<Boolean> implements EqualCoordinatorHelper {
        final BiPredicate<? super T, ? super T> f40257a;
        final EqualSubscriber<T> f40258b;
        final EqualSubscriber<T> f40259c;
        final AtomicThrowable f40260d;
        final AtomicInteger f40261e = new AtomicInteger();
        T f40262f;
        T f40263g;

        EqualCoordinator(Subscriber<? super Boolean> subscriber, int i, BiPredicate<? super T, ? super T> biPredicate) {
            super(subscriber);
            this.f40257a = biPredicate;
            this.f40258b = new EqualSubscriber(this, i);
            this.f40259c = new EqualSubscriber(this, i);
            this.f40260d = new AtomicThrowable();
        }

        public final void cancel() {
            super.cancel();
            SubscriptionHelper.m32777a(this.f40258b);
            SubscriptionHelper.m32777a(this.f40259c);
            if (this.f40261e.getAndIncrement() == 0) {
                this.f40258b.m35830b();
                this.f40259c.m35830b();
            }
        }

        private void m41391c() {
            SubscriptionHelper.m32777a(this.f40258b);
            this.f40258b.m35830b();
            SubscriptionHelper.m32777a(this.f40259c);
            this.f40259c.m35830b();
        }

        public final void ay_() {
            if (this.f40261e.getAndIncrement() == 0) {
                int i = 1;
                do {
                    SimpleQueue simpleQueue = this.f40258b.f35316e;
                    SimpleQueue simpleQueue2 = this.f40259c.f35316e;
                    if (simpleQueue != null && simpleQueue2 != null) {
                        while (!m39790b()) {
                            if (((Throwable) this.f40260d.get()) != null) {
                                m41391c();
                                this.h.onError(ExceptionHelper.m26683a(this.f40260d));
                                return;
                            }
                            boolean z = this.f40258b.f35317f;
                            Object obj = this.f40262f;
                            if (obj == null) {
                                try {
                                    obj = simpleQueue.poll();
                                    this.f40262f = obj;
                                } catch (Throwable th) {
                                    Exceptions.m26521b(th);
                                    m41391c();
                                    ExceptionHelper.m26684a(this.f40260d, th);
                                    this.h.onError(ExceptionHelper.m26683a(this.f40260d));
                                    return;
                                }
                            }
                            boolean z2 = obj == null;
                            boolean z3 = this.f40259c.f35317f;
                            Object obj2 = this.f40263g;
                            if (obj2 == null) {
                                try {
                                    obj2 = simpleQueue2.poll();
                                    this.f40263g = obj2;
                                } catch (Throwable th2) {
                                    Exceptions.m26521b(th2);
                                    m41391c();
                                    ExceptionHelper.m26684a(this.f40260d, th2);
                                    this.h.onError(ExceptionHelper.m26683a(this.f40260d));
                                    return;
                                }
                            }
                            boolean z4 = obj2 == null;
                            if (z && z3 && z2 && z4) {
                                m39789a((Object) Boolean.valueOf(true));
                                return;
                            } else if (z && z3 && z2 != z4) {
                                m41391c();
                                m39789a((Object) Boolean.valueOf(false));
                                return;
                            } else if (!(z2 || z4)) {
                                try {
                                    if (this.f40257a.mo4928a(obj, obj2)) {
                                        this.f40262f = null;
                                        this.f40263g = null;
                                        this.f40258b.m35828a();
                                        this.f40259c.m35828a();
                                    } else {
                                        m41391c();
                                        m39789a((Object) Boolean.valueOf(false));
                                        return;
                                    }
                                } catch (Throwable th22) {
                                    Exceptions.m26521b(th22);
                                    m41391c();
                                    ExceptionHelper.m26684a(this.f40260d, th22);
                                    this.h.onError(ExceptionHelper.m26683a(this.f40260d));
                                    return;
                                }
                            }
                        }
                        this.f40258b.m35830b();
                        this.f40259c.m35830b();
                        return;
                    } else if (m39790b()) {
                        this.f40258b.m35830b();
                        this.f40259c.m35830b();
                        return;
                    } else if (((Throwable) this.f40260d.get()) != null) {
                        m41391c();
                        this.h.onError(ExceptionHelper.m26683a(this.f40260d));
                        return;
                    }
                    i = this.f40261e.addAndGet(-i);
                } while (i != 0);
            }
        }

        public final void mo5653a(Throwable th) {
            if (ExceptionHelper.m26684a(this.f40260d, th)) {
                ay_();
            } else {
                RxJavaPlugins.m26757a(th);
            }
        }
    }

    public FlowableSequenceEqual(Publisher<? extends T> publisher, Publisher<? extends T> publisher2, BiPredicate<? super T, ? super T> biPredicate, int i) {
        this.f35319a = publisher;
        this.f35320b = publisher2;
        this.f35321c = biPredicate;
        this.f35322d = i;
    }

    public final void subscribeActual(Subscriber<? super Boolean> subscriber) {
        EqualCoordinator equalCoordinator = new EqualCoordinator(subscriber, this.f35322d, this.f35321c);
        subscriber.mo5623a(equalCoordinator);
        subscriber = this.f35319a;
        Publisher publisher = this.f35320b;
        subscriber.subscribe(equalCoordinator.f40258b);
        publisher.subscribe(equalCoordinator.f40259c);
    }
}
