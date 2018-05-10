package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.LinkedArrayList;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableCache<T> extends AbstractFlowableWithUpstream<T, T> {
    final AtomicBoolean once = new AtomicBoolean();
    final CacheState<T> state;

    static final class ReplaySubscription<T> extends AtomicInteger implements Subscription {
        final Subscriber<? super T> f31245a;
        final CacheState<T> f31246b;
        final AtomicLong f31247c = new AtomicLong();
        Object[] f31248d;
        int f31249e;
        int f31250f;

        ReplaySubscription(Subscriber<? super T> subscriber, CacheState<T> cacheState) {
            this.f31245a = subscriber;
            this.f31246b = cacheState;
        }

        public final void request(long j) {
            if (SubscriptionHelper.m32776a(j)) {
                long j2;
                do {
                    j2 = this.f31247c.get();
                    if (j2 != -1) {
                    } else {
                        return;
                    }
                } while (!this.f31247c.compareAndSet(j2, BackpressureHelper.m26669a(j2, j)));
                m32173a();
            }
        }

        public final void cancel() {
            if (this.f31247c.getAndSet(-1) != -1) {
                CacheState cacheState = this.f31246b;
                ReplaySubscription[] replaySubscriptionArr;
                Object obj;
                do {
                    replaySubscriptionArr = (ReplaySubscription[]) cacheState.f34869c.get();
                    int length = replaySubscriptionArr.length;
                    if (length != 0) {
                        int i = -1;
                        for (int i2 = 0; i2 < length; i2++) {
                            if (replaySubscriptionArr[i2].equals(this)) {
                                i = i2;
                                break;
                            }
                        }
                        if (i < 0) {
                            return;
                        }
                        if (length == 1) {
                            obj = CacheState.f34865d;
                        } else {
                            Object obj2 = new ReplaySubscription[(length - 1)];
                            System.arraycopy(replaySubscriptionArr, 0, obj2, 0, i);
                            System.arraycopy(replaySubscriptionArr, i + 1, obj2, i, (length - i) - 1);
                            obj = obj2;
                        }
                    } else {
                        return;
                    }
                } while (!cacheState.f34869c.compareAndSet(replaySubscriptionArr, obj));
            }
        }

        public final void m32173a() {
            ReplaySubscription replaySubscription = this;
            if (getAndIncrement() == 0) {
                Subscriber subscriber = replaySubscription.f31245a;
                AtomicLong atomicLong = replaySubscription.f31247c;
                int i = 1;
                int i2 = 1;
                while (true) {
                    long j = atomicLong.get();
                    if (j >= 0) {
                        int i3 = replaySubscription.f31246b.f25193k;
                        if (i3 != 0) {
                            Object[] objArr = replaySubscription.f31248d;
                            if (objArr == null) {
                                objArr = replaySubscription.f31246b.f25191i;
                                replaySubscription.f31248d = objArr;
                            }
                            int length = objArr.length - i;
                            int i4 = replaySubscription.f31250f;
                            int i5 = replaySubscription.f31249e;
                            int i6 = 0;
                            while (i4 < i3 && j > 0) {
                                if (atomicLong.get() != -1) {
                                    if (i5 == length) {
                                        objArr = (Object[]) objArr[length];
                                        i5 = 0;
                                    }
                                    if (!NotificationLite.m26700a(objArr[i5], subscriber)) {
                                        i5++;
                                        i4++;
                                        j--;
                                        i6++;
                                    } else {
                                        return;
                                    }
                                }
                                return;
                            }
                            if (atomicLong.get() != -1) {
                                if (j == 0) {
                                    Object obj = objArr[i5];
                                    if (NotificationLite.m26701b(obj)) {
                                        subscriber.onComplete();
                                        return;
                                    } else if (NotificationLite.m26704c(obj)) {
                                        subscriber.onError(NotificationLite.m26707f(obj));
                                        return;
                                    }
                                }
                                if (i6 != 0) {
                                    BackpressureHelper.m26674d(atomicLong, (long) i6);
                                }
                                replaySubscription.f31250f = i4;
                                replaySubscription.f31249e = i5;
                                replaySubscription.f31248d = objArr;
                            } else {
                                return;
                            }
                        }
                        i2 = addAndGet(-i2);
                        if (i2 != 0) {
                            i = 1;
                        } else {
                            return;
                        }
                    }
                    return;
                }
            }
        }
    }

    static final class CacheState<T> extends LinkedArrayList implements FlowableSubscriber<T> {
        static final ReplaySubscription[] f34865d = new ReplaySubscription[0];
        static final ReplaySubscription[] f34866e = new ReplaySubscription[0];
        final Flowable<T> f34867a;
        final AtomicReference<Subscription> f34868b = new AtomicReference();
        final AtomicReference<ReplaySubscription<T>[]> f34869c;
        volatile boolean f34870f;
        boolean f34871g;

        CacheState(Flowable<T> flowable, int i) {
            super(i);
            this.f34867a = flowable;
            this.f34869c = new AtomicReference(f34865d);
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32779a(this.f34868b, subscription)) {
                subscription.request(Long.MAX_VALUE);
            }
        }

        public final void onNext(T t) {
            if (!this.f34871g) {
                m26693a(NotificationLite.m26696a((Object) t));
                for (ReplaySubscription a : (ReplaySubscription[]) this.f34869c.get()) {
                    a.m32173a();
                }
            }
        }

        public final void onError(Throwable th) {
            if (this.f34871g) {
                RxJavaPlugins.m26757a(th);
                return;
            }
            this.f34871g = true;
            m26693a(NotificationLite.m26697a(th));
            SubscriptionHelper.m32777a(this.f34868b);
            for (ReplaySubscription a : (ReplaySubscription[]) this.f34869c.getAndSet(f34866e)) {
                a.m32173a();
            }
        }

        public final void onComplete() {
            if (!this.f34871g) {
                this.f34871g = true;
                m26693a(NotificationLite.m26694a());
                SubscriptionHelper.m32777a(this.f34868b);
                for (ReplaySubscription a : (ReplaySubscription[]) this.f34869c.getAndSet(f34866e)) {
                    a.m32173a();
                }
            }
        }
    }

    public FlowableCache(Flowable<T> flowable, int i) {
        super(flowable);
        this.state = new CacheState(flowable, i);
    }

    protected final void subscribeActual(Subscriber<? super T> subscriber) {
        Subscription replaySubscription = new ReplaySubscription(subscriber, this.state);
        CacheState cacheState = this.state;
        ReplaySubscription[] replaySubscriptionArr;
        Object obj;
        do {
            replaySubscriptionArr = (ReplaySubscription[]) cacheState.f34869c.get();
            if (replaySubscriptionArr == CacheState.f34866e) {
                break;
            }
            int length = replaySubscriptionArr.length;
            obj = new ReplaySubscription[(length + 1)];
            System.arraycopy(replaySubscriptionArr, 0, obj, 0, length);
            obj[length] = replaySubscription;
        } while (!cacheState.f34869c.compareAndSet(replaySubscriptionArr, obj));
        subscriber.mo5623a(replaySubscription);
        if (this.once.get() == null && this.once.compareAndSet(false, true) != null) {
            FlowableSubscriber flowableSubscriber = this.state;
            flowableSubscriber.f34867a.subscribe(flowableSubscriber);
            flowableSubscriber.f34870f = true;
        }
    }

    final boolean isConnected() {
        return this.state.f34870f;
    }

    final boolean hasSubscribers() {
        return ((ReplaySubscription[]) this.state.f34869c.get()).length != 0;
    }

    final int cachedEventCount() {
        return this.state.f25193k;
    }
}
