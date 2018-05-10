package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
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

public final class FlowableMergeWithMaybe<T> extends AbstractFlowableWithUpstream<T, T> {
    final MaybeSource<? extends T> f37762a;

    static final class MergeWithObserver<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        final Subscriber<? super T> f35122a;
        final AtomicReference<Subscription> f35123b = new AtomicReference();
        final OtherObserver<T> f35124c = new OtherObserver(this);
        final AtomicThrowable f35125d = new AtomicThrowable();
        final AtomicLong f35126e = new AtomicLong();
        final int f35127f = Flowable.bufferSize();
        final int f35128g = (this.f35127f - (this.f35127f >> 2));
        volatile SimplePlainQueue<T> f35129h;
        T f35130i;
        volatile boolean f35131j;
        volatile boolean f35132k;
        volatile int f35133l;
        long f35134m;
        int f35135n;

        static final class OtherObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T> {
            final MergeWithObserver<T> f31335a;

            OtherObserver(MergeWithObserver<T> mergeWithObserver) {
                this.f31335a = mergeWithObserver;
            }

            public final void onSubscribe(Disposable disposable) {
                DisposableHelper.m32092b(this, disposable);
            }

            public final void onSuccess(T t) {
                MergeWithObserver mergeWithObserver = this.f31335a;
                if (mergeWithObserver.compareAndSet(0, 1)) {
                    long j = mergeWithObserver.f35134m;
                    if (mergeWithObserver.f35126e.get() != j) {
                        mergeWithObserver.f35134m = j + 1;
                        mergeWithObserver.f35122a.onNext(t);
                        mergeWithObserver.f35133l = 2;
                    } else {
                        mergeWithObserver.f35130i = t;
                        mergeWithObserver.f35133l = 1;
                        if (mergeWithObserver.decrementAndGet() == null) {
                            return;
                        }
                    }
                } else {
                    mergeWithObserver.f35130i = t;
                    mergeWithObserver.f35133l = 1;
                    if (mergeWithObserver.getAndIncrement() != null) {
                        return;
                    }
                }
                mergeWithObserver.m35756b();
            }

            public final void onError(Throwable th) {
                MergeWithObserver mergeWithObserver = this.f31335a;
                if (ExceptionHelper.m26684a(mergeWithObserver.f35125d, th)) {
                    SubscriptionHelper.m32777a(mergeWithObserver.f35123b);
                    mergeWithObserver.m35754a();
                    return;
                }
                RxJavaPlugins.m26757a(th);
            }

            public final void onComplete() {
                MergeWithObserver mergeWithObserver = this.f31335a;
                mergeWithObserver.f35133l = 2;
                mergeWithObserver.m35754a();
            }
        }

        MergeWithObserver(Subscriber<? super T> subscriber) {
            this.f35122a = subscriber;
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32779a(this.f35123b, subscription)) {
                subscription.request((long) this.f35127f);
            }
        }

        public final void onNext(T t) {
            if (compareAndSet(0, 1)) {
                long j = this.f35134m;
                if (this.f35126e.get() != j) {
                    SimplePlainQueue simplePlainQueue = this.f35129h;
                    if (simplePlainQueue != null) {
                        if (!simplePlainQueue.isEmpty()) {
                            simplePlainQueue.offer(t);
                        }
                    }
                    this.f35134m = j + 1;
                    this.f35122a.onNext(t);
                    t = this.f35135n + 1;
                    if (t == this.f35128g) {
                        this.f35135n = 0;
                        ((Subscription) this.f35123b.get()).request((long) t);
                    } else {
                        this.f35135n = t;
                    }
                } else {
                    m35753c().offer(t);
                }
                if (decrementAndGet() == null) {
                    return;
                }
            }
            m35753c().offer(t);
            if (getAndIncrement() != null) {
                return;
            }
            m35756b();
        }

        public final void onError(Throwable th) {
            if (ExceptionHelper.m26684a(this.f35125d, th)) {
                SubscriptionHelper.m32777a(this.f35123b);
                m35754a();
                return;
            }
            RxJavaPlugins.m26757a(th);
        }

        public final void onComplete() {
            this.f35132k = true;
            m35754a();
        }

        public final void request(long j) {
            BackpressureHelper.m26670a(this.f35126e, j);
            m35754a();
        }

        public final void cancel() {
            this.f35131j = true;
            SubscriptionHelper.m32777a(this.f35123b);
            DisposableHelper.m32090a(this.f35124c);
            if (getAndIncrement() == 0) {
                this.f35129h = null;
                this.f35130i = null;
            }
        }

        private SimplePlainQueue<T> m35753c() {
            SimplePlainQueue<T> simplePlainQueue = this.f35129h;
            if (simplePlainQueue != null) {
                return simplePlainQueue;
            }
            simplePlainQueue = new SpscArrayQueue(Flowable.bufferSize());
            this.f35129h = simplePlainQueue;
            return simplePlainQueue;
        }

        final void m35754a() {
            if (getAndIncrement() == 0) {
                m35756b();
            }
        }

        final void m35756b() {
            Subscriber subscriber = this.f35122a;
            long j = this.f35134m;
            int i = this.f35135n;
            int i2 = this.f35128g;
            int i3 = 1;
            int i4 = 1;
            while (true) {
                boolean z;
                long j2 = r0.f35126e.get();
                while (true) {
                    int i5 = (j > j2 ? 1 : (j == j2 ? 0 : -1));
                    if (i5 == 0) {
                        break;
                    } else if (r0.f35131j) {
                        r0.f35130i = null;
                        r0.f35129h = null;
                        return;
                    } else if (r0.f35125d.get() != null) {
                        r0.f35130i = null;
                        r0.f35129h = null;
                        subscriber.onError(ExceptionHelper.m26683a(r0.f35125d));
                        return;
                    } else {
                        int i6 = r0.f35133l;
                        if (i6 == i3) {
                            Object obj = r0.f35130i;
                            r0.f35130i = null;
                            r0.f35133l = 2;
                            subscriber.onNext(obj);
                            j++;
                        } else {
                            z = r0.f35132k;
                            SimplePlainQueue simplePlainQueue = r0.f35129h;
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
                                    ((Subscription) r0.f35123b.get()).request((long) i2);
                                    i = 0;
                                }
                                i3 = 1;
                            } else {
                                r0.f35129h = null;
                                subscriber.onComplete();
                                return;
                            }
                        }
                    }
                }
                if (i5 == 0) {
                    if (r0.f35131j) {
                        r0.f35130i = null;
                        r0.f35129h = null;
                        return;
                    } else if (r0.f35125d.get() != null) {
                        r0.f35130i = null;
                        r0.f35129h = null;
                        subscriber.onError(ExceptionHelper.m26683a(r0.f35125d));
                        return;
                    } else {
                        Object obj3;
                        z = r0.f35132k;
                        SimplePlainQueue simplePlainQueue2 = r0.f35129h;
                        if (simplePlainQueue2 != null) {
                            if (!simplePlainQueue2.isEmpty()) {
                                obj3 = null;
                                if (z && r17 != null && r0.f35133l == 2) {
                                    r0.f35129h = null;
                                    subscriber.onComplete();
                                    return;
                                }
                            }
                        }
                        obj3 = 1;
                        r0.f35129h = null;
                        subscriber.onComplete();
                        return;
                    }
                }
                r0.f35134m = j;
                r0.f35135n = i;
                i4 = addAndGet(-i4);
                if (i4 != 0) {
                    i3 = 1;
                } else {
                    return;
                }
            }
        }
    }

    public FlowableMergeWithMaybe(Flowable<T> flowable, MaybeSource<? extends T> maybeSource) {
        super(flowable);
        this.f37762a = maybeSource;
    }

    protected final void subscribeActual(Subscriber<? super T> subscriber) {
        FlowableSubscriber mergeWithObserver = new MergeWithObserver(subscriber);
        subscriber.mo5623a(mergeWithObserver);
        this.source.subscribe(mergeWithObserver);
        this.f37762a.subscribe(mergeWithObserver.f35124c);
    }
}
