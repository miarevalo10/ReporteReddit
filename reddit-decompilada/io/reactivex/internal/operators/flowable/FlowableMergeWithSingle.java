package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableMergeWithSingle<T> extends AbstractFlowableWithUpstream<T, T> {
    final SingleSource<? extends T> f37763a;

    static final class MergeWithObserver<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        final Subscriber<? super T> f35136a;
        final AtomicReference<Subscription> f35137b = new AtomicReference();
        final OtherObserver<T> f35138c = new OtherObserver(this);
        final AtomicThrowable f35139d = new AtomicThrowable();
        final AtomicLong f35140e = new AtomicLong();
        final int f35141f = Flowable.bufferSize();
        final int f35142g = (this.f35141f - (this.f35141f >> 2));
        volatile SimplePlainQueue<T> f35143h;
        T f35144i;
        volatile boolean f35145j;
        volatile boolean f35146k;
        volatile int f35147l;
        long f35148m;
        int f35149n;

        static final class OtherObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T> {
            final MergeWithObserver<T> f31336a;

            OtherObserver(MergeWithObserver<T> mergeWithObserver) {
                this.f31336a = mergeWithObserver;
            }

            public final void onSubscribe(Disposable disposable) {
                DisposableHelper.m32092b(this, disposable);
            }

            public final void onSuccess(T t) {
                MergeWithObserver mergeWithObserver = this.f31336a;
                if (mergeWithObserver.compareAndSet(0, 1)) {
                    long j = mergeWithObserver.f35148m;
                    if (mergeWithObserver.f35140e.get() != j) {
                        mergeWithObserver.f35148m = j + 1;
                        mergeWithObserver.f35136a.onNext(t);
                        mergeWithObserver.f35147l = 2;
                    } else {
                        mergeWithObserver.f35144i = t;
                        mergeWithObserver.f35147l = 1;
                        if (mergeWithObserver.decrementAndGet() == null) {
                            return;
                        }
                    }
                } else {
                    mergeWithObserver.f35144i = t;
                    mergeWithObserver.f35147l = 1;
                    if (mergeWithObserver.getAndIncrement() != null) {
                        return;
                    }
                }
                mergeWithObserver.m35760b();
            }

            public final void onError(Throwable th) {
                MergeWithObserver mergeWithObserver = this.f31336a;
                if (ExceptionHelper.m26684a(mergeWithObserver.f35139d, th)) {
                    SubscriptionHelper.m32777a(mergeWithObserver.f35137b);
                    mergeWithObserver.m35758a();
                    return;
                }
                RxJavaPlugins.m26757a(th);
            }
        }

        MergeWithObserver(Subscriber<? super T> subscriber) {
            this.f35136a = subscriber;
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32779a(this.f35137b, subscription)) {
                subscription.request((long) this.f35141f);
            }
        }

        public final void onNext(T t) {
            if (compareAndSet(0, 1)) {
                long j = this.f35148m;
                if (this.f35140e.get() != j) {
                    SimplePlainQueue simplePlainQueue = this.f35143h;
                    if (simplePlainQueue != null) {
                        if (!simplePlainQueue.isEmpty()) {
                            simplePlainQueue.offer(t);
                        }
                    }
                    this.f35148m = j + 1;
                    this.f35136a.onNext(t);
                    t = this.f35149n + 1;
                    if (t == this.f35142g) {
                        this.f35149n = 0;
                        ((Subscription) this.f35137b.get()).request((long) t);
                    } else {
                        this.f35149n = t;
                    }
                } else {
                    m35757c().offer(t);
                }
                if (decrementAndGet() == null) {
                    return;
                }
            }
            m35757c().offer(t);
            if (getAndIncrement() != null) {
                return;
            }
            m35760b();
        }

        public final void onError(Throwable th) {
            if (ExceptionHelper.m26684a(this.f35139d, th)) {
                SubscriptionHelper.m32777a(this.f35137b);
                m35758a();
                return;
            }
            RxJavaPlugins.m26757a(th);
        }

        public final void onComplete() {
            this.f35146k = true;
            m35758a();
        }

        public final void request(long j) {
            BackpressureHelper.m26670a(this.f35140e, j);
            m35758a();
        }

        public final void cancel() {
            this.f35145j = true;
            SubscriptionHelper.m32777a(this.f35137b);
            DisposableHelper.m32090a(this.f35138c);
            if (getAndIncrement() == 0) {
                this.f35143h = null;
                this.f35144i = null;
            }
        }

        private SimplePlainQueue<T> m35757c() {
            SimplePlainQueue<T> simplePlainQueue = this.f35143h;
            if (simplePlainQueue != null) {
                return simplePlainQueue;
            }
            simplePlainQueue = new SpscArrayQueue(Flowable.bufferSize());
            this.f35143h = simplePlainQueue;
            return simplePlainQueue;
        }

        final void m35758a() {
            if (getAndIncrement() == 0) {
                m35760b();
            }
        }

        final void m35760b() {
            Subscriber subscriber = this.f35136a;
            long j = this.f35148m;
            int i = this.f35149n;
            int i2 = this.f35142g;
            int i3 = 1;
            int i4 = 1;
            while (true) {
                long j2 = r0.f35140e.get();
                while (true) {
                    boolean z;
                    int i5 = (j > j2 ? 1 : (j == j2 ? 0 : -1));
                    if (i5 == 0) {
                        break;
                    } else if (r0.f35145j) {
                        r0.f35144i = null;
                        r0.f35143h = null;
                        return;
                    } else if (r0.f35139d.get() != null) {
                        r0.f35144i = null;
                        r0.f35143h = null;
                        subscriber.onError(ExceptionHelper.m26683a(r0.f35139d));
                        return;
                    } else {
                        int i6 = r0.f35147l;
                        if (i6 == i3) {
                            Object obj = r0.f35144i;
                            r0.f35144i = null;
                            r0.f35147l = 2;
                            subscriber.onNext(obj);
                            j++;
                        } else {
                            z = r0.f35146k;
                            SimplePlainQueue simplePlainQueue = r0.f35143h;
                            Object poll = simplePlainQueue != null ? simplePlainQueue.poll() : null;
                            Object obj2 = poll == null ? 1 : null;
                            if (!z || obj2 == null || i6 != 2) {
                                if (obj2 != null) {
                                    break;
                                }
                                subscriber.onNext(poll);
                                j++;
                                i++;
                                if (i == i2) {
                                    ((Subscription) r0.f35137b.get()).request((long) i2);
                                    i = 0;
                                }
                                i3 = 1;
                            } else {
                                r0.f35143h = null;
                                subscriber.onComplete();
                                return;
                            }
                        }
                    }
                }
                if (i5 == 0) {
                    if (r0.f35145j) {
                        r0.f35144i = null;
                        r0.f35143h = null;
                        return;
                    } else if (r0.f35139d.get() != null) {
                        r0.f35144i = null;
                        r0.f35143h = null;
                        subscriber.onError(ExceptionHelper.m26683a(r0.f35139d));
                        return;
                    } else {
                        Object obj3;
                        z = r0.f35146k;
                        SimplePlainQueue simplePlainQueue2 = r0.f35143h;
                        if (simplePlainQueue2 != null) {
                            if (!simplePlainQueue2.isEmpty()) {
                                obj3 = null;
                                if (z && r17 != null && r0.f35147l == 2) {
                                    r0.f35143h = null;
                                    subscriber.onComplete();
                                    return;
                                }
                            }
                        }
                        obj3 = 1;
                        r0.f35143h = null;
                        subscriber.onComplete();
                        return;
                    }
                }
                r0.f35148m = j;
                r0.f35149n = i;
                i4 = addAndGet(-i4);
                if (i4 != 0) {
                    i3 = 1;
                } else {
                    return;
                }
            }
        }
    }

    public FlowableMergeWithSingle(Flowable<T> flowable, SingleSource<? extends T> singleSource) {
        super(flowable);
        this.f37763a = singleSource;
    }

    protected final void subscribeActual(Subscriber<? super T> subscriber) {
        FlowableSubscriber mergeWithObserver = new MergeWithObserver(subscriber);
        subscriber.mo5623a(mergeWithObserver);
        this.source.subscribe(mergeWithObserver);
        this.f37763a.subscribe(mergeWithObserver.f35138c);
    }
}
