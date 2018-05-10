package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.flowables.ConnectableFlowable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowablePublish<T> extends ConnectableFlowable<T> {
    final Flowable<T> f37779a;
    final AtomicReference<PublishSubscriber<T>> f37780b;
    final int f37781c;
    final Publisher<T> f37782d;

    static final class FlowablePublisher<T> implements Publisher<T> {
        private final AtomicReference<PublishSubscriber<T>> f31337a;
        private final int f31338b;

        FlowablePublisher(AtomicReference<PublishSubscriber<T>> atomicReference, int i) {
            this.f31337a = atomicReference;
            this.f31338b = i;
        }

        public final void subscribe(Subscriber<? super T> subscriber) {
            InnerSubscriber innerSubscriber = new InnerSubscriber(subscriber);
            subscriber.mo5623a(innerSubscriber);
            while (true) {
                int i;
                subscriber = (PublishSubscriber) this.f31337a.get();
                if (subscriber == null || subscriber.mo5627b()) {
                    PublishSubscriber publishSubscriber = new PublishSubscriber(this.f31337a, this.f31338b);
                    if (this.f31337a.compareAndSet(subscriber, publishSubscriber) != null) {
                        subscriber = publishSubscriber;
                    } else {
                        continue;
                    }
                }
                InnerSubscriber[] innerSubscriberArr;
                Object obj;
                do {
                    innerSubscriberArr = (InnerSubscriber[]) subscriber.f35185e.get();
                    i = 0;
                    if (innerSubscriberArr == PublishSubscriber.f35182b) {
                        break;
                    }
                    int length = innerSubscriberArr.length;
                    obj = new InnerSubscriber[(length + 1)];
                    System.arraycopy(innerSubscriberArr, 0, obj, 0, length);
                    obj[length] = innerSubscriber;
                } while (!subscriber.f35185e.compareAndSet(innerSubscriberArr, obj));
                i = 1;
                if (i != 0) {
                    break;
                }
            }
            if (innerSubscriber.get() == Long.MIN_VALUE) {
                subscriber.m35772a(innerSubscriber);
            } else {
                innerSubscriber.f31340b = subscriber;
            }
            subscriber.m35775c();
        }
    }

    static final class InnerSubscriber<T> extends AtomicLong implements Subscription {
        final Subscriber<? super T> f31339a;
        volatile PublishSubscriber<T> f31340b;

        InnerSubscriber(Subscriber<? super T> subscriber) {
            this.f31339a = subscriber;
        }

        public final void request(long j) {
            if (SubscriptionHelper.m32776a(j)) {
                BackpressureHelper.m26672b((AtomicLong) this, j);
                j = this.f31340b;
                if (j != null) {
                    j.m35775c();
                }
            }
        }

        public final void cancel() {
            if (get() != Long.MIN_VALUE && getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                PublishSubscriber publishSubscriber = this.f31340b;
                if (publishSubscriber != null) {
                    publishSubscriber.m35772a(this);
                    publishSubscriber.m35775c();
                }
            }
        }
    }

    static final class PublishSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Disposable {
        static final InnerSubscriber[] f35181a = new InnerSubscriber[0];
        static final InnerSubscriber[] f35182b = new InnerSubscriber[0];
        final AtomicReference<PublishSubscriber<T>> f35183c;
        final int f35184d;
        final AtomicReference<InnerSubscriber[]> f35185e = new AtomicReference(f35181a);
        final AtomicBoolean f35186f;
        final AtomicReference<Subscription> f35187g = new AtomicReference();
        volatile Object f35188h;
        int f35189i;
        volatile SimpleQueue<T> f35190j;

        PublishSubscriber(AtomicReference<PublishSubscriber<T>> atomicReference, int i) {
            this.f35183c = atomicReference;
            this.f35186f = new AtomicBoolean();
            this.f35184d = i;
        }

        public final void mo5626a() {
            if (this.f35185e.get() != f35182b && ((InnerSubscriber[]) this.f35185e.getAndSet(f35182b)) != f35182b) {
                this.f35183c.compareAndSet(this, null);
                SubscriptionHelper.m32777a(this.f35187g);
            }
        }

        public final boolean mo5627b() {
            return this.f35185e.get() == f35182b;
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32779a(this.f35187g, subscription)) {
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int a = queueSubscription.mo7033a(3);
                    if (a == 1) {
                        this.f35189i = a;
                        this.f35190j = queueSubscription;
                        this.f35188h = NotificationLite.m26694a();
                        m35775c();
                        return;
                    } else if (a == 2) {
                        this.f35189i = a;
                        this.f35190j = queueSubscription;
                        subscription.request((long) this.f35184d);
                        return;
                    }
                }
                this.f35190j = new SpscArrayQueue(this.f35184d);
                subscription.request((long) this.f35184d);
            }
        }

        public final void onNext(T t) {
            if (this.f35189i == 0 && this.f35190j.offer(t) == null) {
                onError(new MissingBackpressureException("Prefetch queue is full?!"));
            } else {
                m35775c();
            }
        }

        public final void onError(Throwable th) {
            if (this.f35188h == null) {
                this.f35188h = NotificationLite.m26697a(th);
                m35775c();
                return;
            }
            RxJavaPlugins.m26757a(th);
        }

        public final void onComplete() {
            if (this.f35188h == null) {
                this.f35188h = NotificationLite.m26694a();
                m35775c();
            }
        }

        final void m35772a(InnerSubscriber<T> innerSubscriber) {
            InnerSubscriber[] innerSubscriberArr;
            Object obj;
            do {
                innerSubscriberArr = (InnerSubscriber[]) this.f35185e.get();
                int length = innerSubscriberArr.length;
                if (length == 0) {
                    break;
                }
                int i = -1;
                for (int i2 = 0; i2 < length; i2++) {
                    if (innerSubscriberArr[i2].equals(innerSubscriber)) {
                        i = i2;
                        break;
                    }
                }
                if (i >= 0) {
                    if (length == 1) {
                        obj = f35181a;
                    } else {
                        Object obj2 = new InnerSubscriber[(length - 1)];
                        System.arraycopy(innerSubscriberArr, 0, obj2, 0, i);
                        System.arraycopy(innerSubscriberArr, i + 1, obj2, i, (length - i) - 1);
                        obj = obj2;
                    }
                } else {
                    return;
                }
            } while (!this.f35185e.compareAndSet(innerSubscriberArr, obj));
        }

        private boolean m35770a(Object obj, boolean z) {
            int i = 0;
            if (obj != null) {
                if (!NotificationLite.m26701b(obj)) {
                    Throwable f = NotificationLite.m26707f(obj);
                    this.f35183c.compareAndSet(this, null);
                    InnerSubscriber[] innerSubscriberArr = (InnerSubscriber[]) this.f35185e.getAndSet(f35182b);
                    if (innerSubscriberArr.length != 0) {
                        int length = innerSubscriberArr.length;
                        while (i < length) {
                            innerSubscriberArr[i].f31339a.onError(f);
                            i++;
                        }
                    } else {
                        RxJavaPlugins.m26757a(f);
                    }
                    return true;
                } else if (z) {
                    this.f35183c.compareAndSet(this, null);
                    InnerSubscriber[] innerSubscriberArr2 = (InnerSubscriber[]) this.f35185e.getAndSet(f35182b);
                    z = innerSubscriberArr2.length;
                    boolean z2;
                    while (z2 < z) {
                        innerSubscriberArr2[z2].f31339a.onComplete();
                        z2++;
                    }
                    return true;
                }
            }
            return false;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        final void m35775c() {
            /*
            r20 = this;
            r1 = r20;
            r2 = r20.getAndIncrement();
            if (r2 == 0) goto L_0x0009;
        L_0x0008:
            return;
        L_0x0009:
            r3 = 1;
        L_0x000a:
            r4 = r1.f35188h;
            r5 = r1.f35190j;
            if (r5 == 0) goto L_0x0019;
        L_0x0010:
            r7 = r5.isEmpty();
            if (r7 == 0) goto L_0x0017;
        L_0x0016:
            goto L_0x0019;
        L_0x0017:
            r7 = 0;
            goto L_0x001a;
        L_0x0019:
            r7 = 1;
        L_0x001a:
            r4 = r1.m35770a(r4, r7);
            if (r4 == 0) goto L_0x0021;
        L_0x0020:
            return;
        L_0x0021:
            if (r7 != 0) goto L_0x0116;
        L_0x0023:
            r4 = r1.f35185e;
            r4 = r4.get();
            r4 = (io.reactivex.internal.operators.flowable.FlowablePublish.InnerSubscriber[]) r4;
            r8 = r4.length;
            r9 = 9223372036854775807; // 0x7fffffffffffffff float:NaN double:NaN;
            r11 = r4.length;
            r12 = r9;
            r9 = 0;
            r10 = 0;
        L_0x0035:
            r14 = 0;
            if (r9 >= r11) goto L_0x0058;
        L_0x0039:
            r6 = r4[r9];
            r16 = r3;
            r2 = r6.get();
            r6 = (r2 > r14 ? 1 : (r2 == r14 ? 0 : -1));
            if (r6 < 0) goto L_0x004b;
        L_0x0045:
            r2 = java.lang.Math.min(r12, r2);
            r12 = r2;
            goto L_0x0053;
        L_0x004b:
            r14 = -9223372036854775808;
            r2 = (r2 > r14 ? 1 : (r2 == r14 ? 0 : -1));
            if (r2 != 0) goto L_0x0053;
        L_0x0051:
            r10 = r10 + 1;
        L_0x0053:
            r9 = r9 + 1;
            r3 = r16;
            goto L_0x0035;
        L_0x0058:
            r16 = r3;
            r2 = 1;
            if (r8 != r10) goto L_0x009d;
        L_0x005e:
            r4 = r1.f35188h;
            r5 = r5.poll();	 Catch:{ Throwable -> 0x0065 }
            goto L_0x007b;
        L_0x0065:
            r0 = move-exception;
            io.reactivex.exceptions.Exceptions.m26521b(r0);
            r4 = r1.f35187g;
            r4 = r4.get();
            r4 = (org.reactivestreams.Subscription) r4;
            r4.cancel();
            r4 = io.reactivex.internal.util.NotificationLite.m26697a(r0);
            r1.f35188h = r4;
            r5 = 0;
        L_0x007b:
            if (r5 != 0) goto L_0x007f;
        L_0x007d:
            r5 = 1;
            goto L_0x0080;
        L_0x007f:
            r5 = 0;
        L_0x0080:
            r4 = r1.m35770a(r4, r5);
            if (r4 == 0) goto L_0x0087;
        L_0x0086:
            return;
        L_0x0087:
            r4 = r1.f35189i;
            r5 = 1;
            if (r4 == r5) goto L_0x009a;
        L_0x008c:
            r4 = r1.f35187g;
            r4 = r4.get();
            r4 = (org.reactivestreams.Subscription) r4;
            r4.request(r2);
            r3 = 1;
            goto L_0x0112;
        L_0x009a:
            r3 = r5;
            goto L_0x0112;
        L_0x009d:
            r8 = r7;
            r7 = 0;
        L_0x009f:
            r9 = (long) r7;
            r11 = (r9 > r12 ? 1 : (r9 == r12 ? 0 : -1));
            if (r11 >= 0) goto L_0x00f4;
        L_0x00a4:
            r8 = r1.f35188h;
            r11 = r5.poll();	 Catch:{ Throwable -> 0x00ab }
            goto L_0x00c1;
        L_0x00ab:
            r0 = move-exception;
            io.reactivex.exceptions.Exceptions.m26521b(r0);
            r8 = r1.f35187g;
            r8 = r8.get();
            r8 = (org.reactivestreams.Subscription) r8;
            r8.cancel();
            r8 = io.reactivex.internal.util.NotificationLite.m26697a(r0);
            r1.f35188h = r8;
            r11 = 0;
        L_0x00c1:
            if (r11 != 0) goto L_0x00c5;
        L_0x00c3:
            r6 = 1;
            goto L_0x00c6;
        L_0x00c5:
            r6 = 0;
        L_0x00c6:
            r8 = r1.m35770a(r8, r6);
            if (r8 == 0) goto L_0x00cd;
        L_0x00cc:
            return;
        L_0x00cd:
            if (r6 != 0) goto L_0x00f5;
        L_0x00cf:
            r8 = io.reactivex.internal.util.NotificationLite.m26706e(r11);
            r9 = r4.length;
            r10 = 0;
        L_0x00d5:
            if (r10 >= r9) goto L_0x00ee;
        L_0x00d7:
            r11 = r4[r10];
            r17 = r11.get();
            r17 = (r17 > r14 ? 1 : (r17 == r14 ? 0 : -1));
            if (r17 <= 0) goto L_0x00e9;
        L_0x00e1:
            r14 = r11.f31339a;
            r14.onNext(r8);
            io.reactivex.internal.util.BackpressureHelper.m26674d(r11, r2);
        L_0x00e9:
            r10 = r10 + 1;
            r14 = 0;
            goto L_0x00d5;
        L_0x00ee:
            r7 = r7 + 1;
            r8 = r6;
            r14 = 0;
            goto L_0x009f;
        L_0x00f4:
            r6 = r8;
        L_0x00f5:
            if (r7 <= 0) goto L_0x0108;
        L_0x00f7:
            r2 = r1.f35189i;
            r3 = 1;
            if (r2 == r3) goto L_0x0109;
        L_0x00fc:
            r2 = r1.f35187g;
            r2 = r2.get();
            r2 = (org.reactivestreams.Subscription) r2;
            r2.request(r9);
            goto L_0x0109;
        L_0x0108:
            r3 = 1;
        L_0x0109:
            r4 = 0;
            r2 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1));
            if (r2 == 0) goto L_0x0119;
        L_0x010f:
            if (r6 == 0) goto L_0x0112;
        L_0x0111:
            goto L_0x0119;
        L_0x0112:
            r3 = r16;
            goto L_0x000a;
        L_0x0116:
            r16 = r3;
            r3 = 1;
        L_0x0119:
            r2 = r16;
            r2 = -r2;
            r2 = r1.addAndGet(r2);
            if (r2 != 0) goto L_0x0123;
        L_0x0122:
            return;
        L_0x0123:
            r3 = r2;
            goto L_0x000a;
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowablePublish.PublishSubscriber.c():void");
        }
    }

    public static <T> ConnectableFlowable<T> m38107a(Flowable<T> flowable, int i) {
        AtomicReference atomicReference = new AtomicReference();
        return RxJavaPlugins.m26749a(new FlowablePublish(new FlowablePublisher(atomicReference, i), flowable, atomicReference, i));
    }

    private FlowablePublish(Publisher<T> publisher, Flowable<T> flowable, AtomicReference<PublishSubscriber<T>> atomicReference, int i) {
        this.f37782d = publisher;
        this.f37779a = flowable;
        this.f37780b = atomicReference;
        this.f37781c = i;
    }

    protected final void subscribeActual(Subscriber<? super T> subscriber) {
        this.f37782d.subscribe(subscriber);
    }

    public final void mo7047a(Consumer<? super Disposable> consumer) {
        FlowableSubscriber flowableSubscriber;
        PublishSubscriber publishSubscriber;
        do {
            flowableSubscriber = (PublishSubscriber) this.f37780b.get();
            if (flowableSubscriber != null && !flowableSubscriber.mo5627b()) {
                break;
            }
            publishSubscriber = new PublishSubscriber(this.f37780b, this.f37781c);
        } while (!this.f37780b.compareAndSet(flowableSubscriber, publishSubscriber));
        flowableSubscriber = publishSubscriber;
        boolean z = true;
        if (flowableSubscriber.f35186f.get() || !flowableSubscriber.f35186f.compareAndSet(false, true)) {
            z = false;
        }
        try {
            consumer.accept(flowableSubscriber);
            if (z) {
                this.f37779a.subscribe(flowableSubscriber);
            }
        } catch (Throwable th) {
            Exceptions.m26521b(th);
            consumer = ExceptionHelper.m26682a(th);
        }
    }
}
