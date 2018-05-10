package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;

public final class FlowableFromArray<T> extends Flowable<T> {
    final T[] f35068a;

    static abstract class BaseArraySubscription<T> extends BasicQueueSubscription<T> {
        final T[] f39449b;
        int f39450c;
        volatile boolean f39451d;

        public final int mo7033a(int i) {
            return i & 1;
        }

        abstract void mo7591a();

        abstract void mo7592a(long j);

        BaseArraySubscription(T[] tArr) {
            this.f39449b = tArr;
        }

        public final T poll() {
            int i = this.f39450c;
            Object[] objArr = this.f39449b;
            if (i == objArr.length) {
                return null;
            }
            this.f39450c = i + 1;
            return ObjectHelper.m26573a(objArr[i], "array element is null");
        }

        public final boolean isEmpty() {
            return this.f39450c == this.f39449b.length;
        }

        public final void clear() {
            this.f39450c = this.f39449b.length;
        }

        public final void request(long j) {
            if (SubscriptionHelper.m32776a(j) && BackpressureHelper.m26670a((AtomicLong) this, j) == 0) {
                if (j == Long.MAX_VALUE) {
                    mo7591a();
                    return;
                }
                mo7592a(j);
            }
        }

        public final void cancel() {
            this.f39451d = true;
        }
    }

    static final class ArrayConditionalSubscription<T> extends BaseArraySubscription<T> {
        final ConditionalSubscriber<? super T> f40244a;

        ArrayConditionalSubscription(ConditionalSubscriber<? super T> conditionalSubscriber, T[] tArr) {
            super(tArr);
            this.f40244a = conditionalSubscriber;
        }

        final void mo7591a() {
            Object[] objArr = this.b;
            int length = objArr.length;
            ConditionalSubscriber conditionalSubscriber = this.f40244a;
            int i = this.c;
            while (i != length) {
                if (!this.d) {
                    Object obj = objArr[i];
                    if (obj == null) {
                        conditionalSubscriber.onError(new NullPointerException("array element is null"));
                        return;
                    } else {
                        conditionalSubscriber.mo7052a(obj);
                        i++;
                    }
                } else {
                    return;
                }
            }
            if (!this.d) {
                conditionalSubscriber.onComplete();
            }
        }

        final void mo7592a(long j) {
            Object[] objArr = this.b;
            int length = objArr.length;
            int i = this.c;
            ConditionalSubscriber conditionalSubscriber = this.f40244a;
            long j2 = j;
            loop0:
            do {
                j = 0;
                while (true) {
                    if (j == j2 || i == length) {
                        if (i == length) {
                            break loop0;
                        }
                        j2 = get();
                        if (j == j2) {
                            this.c = i;
                            j2 = addAndGet(-j);
                        }
                    } else if (!this.d) {
                        Object obj = objArr[i];
                        if (obj == null) {
                            conditionalSubscriber.onError(new NullPointerException("array element is null"));
                            return;
                        }
                        if (conditionalSubscriber.mo7052a(obj)) {
                            j++;
                        }
                        i++;
                    } else {
                        return;
                    }
                }
                if (this.d == null) {
                    conditionalSubscriber.onComplete();
                }
                return;
            } while (j2 != 0);
        }
    }

    static final class ArraySubscription<T> extends BaseArraySubscription<T> {
        final Subscriber<? super T> f40245a;

        ArraySubscription(Subscriber<? super T> subscriber, T[] tArr) {
            super(tArr);
            this.f40245a = subscriber;
        }

        final void mo7591a() {
            Object[] objArr = this.b;
            int length = objArr.length;
            Subscriber subscriber = this.f40245a;
            int i = this.c;
            while (i != length) {
                if (!this.d) {
                    Object obj = objArr[i];
                    if (obj == null) {
                        subscriber.onError(new NullPointerException("array element is null"));
                        return;
                    } else {
                        subscriber.onNext(obj);
                        i++;
                    }
                } else {
                    return;
                }
            }
            if (!this.d) {
                subscriber.onComplete();
            }
        }

        final void mo7592a(long j) {
            Object[] objArr = this.b;
            int length = objArr.length;
            int i = this.c;
            Subscriber subscriber = this.f40245a;
            long j2 = j;
            loop0:
            do {
                j = 0;
                while (true) {
                    if (j == j2 || i == length) {
                        if (i == length) {
                            break loop0;
                        }
                        j2 = get();
                        if (j == j2) {
                            this.c = i;
                            j2 = addAndGet(-j);
                        }
                    } else if (!this.d) {
                        Object obj = objArr[i];
                        if (obj == null) {
                            subscriber.onError(new NullPointerException("array element is null"));
                            return;
                        }
                        subscriber.onNext(obj);
                        j++;
                        i++;
                    } else {
                        return;
                    }
                }
                if (this.d == null) {
                    subscriber.onComplete();
                }
                return;
            } while (j2 != 0);
        }
    }

    public FlowableFromArray(T[] tArr) {
        this.f35068a = tArr;
    }

    public final void subscribeActual(Subscriber<? super T> subscriber) {
        if (subscriber instanceof ConditionalSubscriber) {
            subscriber.mo5623a(new ArrayConditionalSubscription((ConditionalSubscriber) subscriber, this.f35068a));
        } else {
            subscriber.mo5623a(new ArraySubscription(subscriber, this.f35068a));
        }
    }
}
