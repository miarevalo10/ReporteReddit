package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.functions.Function;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableZip<T, R> extends Flowable<R> {
    final Publisher<? extends T>[] f35538a;
    final Iterable<? extends Publisher<? extends T>> f35539b;
    final Function<? super Object[], ? extends R> f35540c;
    final int f35541d;
    final boolean f35542e;

    static final class ZipCoordinator<T, R> extends AtomicInteger implements Subscription {
        final Subscriber<? super R> f31372a;
        final ZipSubscriber<T, R>[] f31373b;
        final Function<? super Object[], ? extends R> f31374c;
        final AtomicLong f31375d;
        final AtomicThrowable f31376e;
        final boolean f31377f;
        volatile boolean f31378g;
        final Object[] f31379h;

        ZipCoordinator(Subscriber<? super R> subscriber, Function<? super Object[], ? extends R> function, int i, int i2, boolean z) {
            this.f31372a = subscriber;
            this.f31374c = function;
            this.f31377f = z;
            subscriber = new ZipSubscriber[i];
            for (function = null; function < i; function++) {
                subscriber[function] = new ZipSubscriber(this, i2);
            }
            this.f31379h = new Object[i];
            this.f31373b = subscriber;
            this.f31375d = new AtomicLong();
            this.f31376e = new AtomicThrowable();
        }

        public final void request(long j) {
            if (SubscriptionHelper.m32776a(j)) {
                BackpressureHelper.m26670a(this.f31375d, j);
                m32228a();
            }
        }

        public final void cancel() {
            if (!this.f31378g) {
                this.f31378g = true;
                m32227b();
            }
        }

        final void m32229a(ZipSubscriber<T, R> zipSubscriber, Throwable th) {
            if (ExceptionHelper.m26684a(this.f31376e, th)) {
                zipSubscriber.f35536f = true;
                m32228a();
                return;
            }
            RxJavaPlugins.m26757a(th);
        }

        private void m32227b() {
            for (ZipSubscriber cancel : this.f31373b) {
                cancel.cancel();
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        final void m32228a() {
            /*
            r19 = this;
            r1 = r19;
            r2 = r19.getAndIncrement();
            if (r2 == 0) goto L_0x0009;
        L_0x0008:
            return;
        L_0x0009:
            r2 = r1.f31372a;
            r3 = r1.f31373b;
            r5 = r3.length;
            r6 = r1.f31379h;
            r7 = 1;
        L_0x0011:
            r8 = r1.f31375d;
            r8 = r8.get();
            r12 = 0;
        L_0x0019:
            r14 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1));
            r15 = 0;
            r16 = 0;
            if (r14 == 0) goto L_0x00d5;
        L_0x0020:
            r4 = r1.f31378g;
            if (r4 == 0) goto L_0x0025;
        L_0x0024:
            return;
        L_0x0025:
            r4 = r1.f31377f;
            if (r4 != 0) goto L_0x003e;
        L_0x0029:
            r4 = r1.f31376e;
            r4 = r4.get();
            if (r4 == 0) goto L_0x003e;
        L_0x0031:
            r19.m32227b();
            r3 = r1.f31376e;
            r3 = io.reactivex.internal.util.ExceptionHelper.m26683a(r3);
            r2.onError(r3);
            return;
        L_0x003e:
            r4 = r16;
            r17 = r4;
        L_0x0042:
            if (r4 >= r5) goto L_0x00a1;
        L_0x0044:
            r10 = r3[r4];
            r11 = r6[r4];
            if (r11 != 0) goto L_0x009e;
        L_0x004a:
            r11 = r10.f35536f;	 Catch:{ Throwable -> 0x0081 }
            r10 = r10.f35534d;	 Catch:{ Throwable -> 0x0081 }
            if (r10 == 0) goto L_0x0055;
        L_0x0050:
            r10 = r10.poll();	 Catch:{ Throwable -> 0x0081 }
            goto L_0x0056;
        L_0x0055:
            r10 = r15;
        L_0x0056:
            if (r10 != 0) goto L_0x005b;
        L_0x0058:
            r18 = 1;
            goto L_0x005d;
        L_0x005b:
            r18 = r16;
        L_0x005d:
            if (r11 == 0) goto L_0x007c;
        L_0x005f:
            if (r18 == 0) goto L_0x007c;
        L_0x0061:
            r19.m32227b();	 Catch:{ Throwable -> 0x0081 }
            r10 = r1.f31376e;	 Catch:{ Throwable -> 0x0081 }
            r10 = r10.get();	 Catch:{ Throwable -> 0x0081 }
            r10 = (java.lang.Throwable) r10;	 Catch:{ Throwable -> 0x0081 }
            if (r10 == 0) goto L_0x0078;
        L_0x006e:
            r10 = r1.f31376e;	 Catch:{ Throwable -> 0x0081 }
            r10 = io.reactivex.internal.util.ExceptionHelper.m26683a(r10);	 Catch:{ Throwable -> 0x0081 }
            r2.onError(r10);	 Catch:{ Throwable -> 0x0081 }
            return;
        L_0x0078:
            r2.onComplete();	 Catch:{ Throwable -> 0x0081 }
            return;
        L_0x007c:
            if (r18 != 0) goto L_0x009c;
        L_0x007e:
            r6[r4] = r10;	 Catch:{ Throwable -> 0x0081 }
            goto L_0x009e;
        L_0x0081:
            r0 = move-exception;
            r10 = r0;
            io.reactivex.exceptions.Exceptions.m26521b(r10);
            r11 = r1.f31376e;
            io.reactivex.internal.util.ExceptionHelper.m26684a(r11, r10);
            r10 = r1.f31377f;
            if (r10 != 0) goto L_0x009c;
        L_0x008f:
            r19.m32227b();
            r3 = r1.f31376e;
            r3 = io.reactivex.internal.util.ExceptionHelper.m26683a(r3);
            r2.onError(r3);
            return;
        L_0x009c:
            r17 = 1;
        L_0x009e:
            r4 = r4 + 1;
            goto L_0x0042;
        L_0x00a1:
            if (r17 != 0) goto L_0x00d5;
        L_0x00a3:
            r4 = r1.f31374c;	 Catch:{ Throwable -> 0x00be }
            r10 = r6.clone();	 Catch:{ Throwable -> 0x00be }
            r4 = r4.apply(r10);	 Catch:{ Throwable -> 0x00be }
            r10 = "The zipper returned a null value";
            r4 = io.reactivex.internal.functions.ObjectHelper.m26573a(r4, r10);	 Catch:{ Throwable -> 0x00be }
            r2.onNext(r4);
            r10 = 1;
            r12 = r12 + r10;
            java.util.Arrays.fill(r6, r15);
            goto L_0x0019;
        L_0x00be:
            r0 = move-exception;
            r3 = r0;
            io.reactivex.exceptions.Exceptions.m26521b(r3);
            r19.m32227b();
            r4 = r1.f31376e;
            io.reactivex.internal.util.ExceptionHelper.m26684a(r4, r3);
            r3 = r1.f31376e;
            r3 = io.reactivex.internal.util.ExceptionHelper.m26683a(r3);
            r2.onError(r3);
            return;
        L_0x00d5:
            if (r14 != 0) goto L_0x0153;
        L_0x00d7:
            r4 = r1.f31378g;
            if (r4 == 0) goto L_0x00dc;
        L_0x00db:
            return;
        L_0x00dc:
            r4 = r1.f31377f;
            if (r4 != 0) goto L_0x00f5;
        L_0x00e0:
            r4 = r1.f31376e;
            r4 = r4.get();
            if (r4 == 0) goto L_0x00f5;
        L_0x00e8:
            r19.m32227b();
            r3 = r1.f31376e;
            r3 = io.reactivex.internal.util.ExceptionHelper.m26683a(r3);
            r2.onError(r3);
            return;
        L_0x00f5:
            r4 = r16;
        L_0x00f7:
            if (r4 >= r5) goto L_0x0153;
        L_0x00f9:
            r10 = r3[r4];
            r11 = r6[r4];
            if (r11 != 0) goto L_0x0150;
        L_0x00ff:
            r11 = r10.f35536f;	 Catch:{ Throwable -> 0x0135 }
            r10 = r10.f35534d;	 Catch:{ Throwable -> 0x0135 }
            if (r10 == 0) goto L_0x010a;
        L_0x0105:
            r10 = r10.poll();	 Catch:{ Throwable -> 0x0135 }
            goto L_0x010b;
        L_0x010a:
            r10 = r15;
        L_0x010b:
            if (r10 != 0) goto L_0x010f;
        L_0x010d:
            r14 = 1;
            goto L_0x0111;
        L_0x010f:
            r14 = r16;
        L_0x0111:
            if (r11 == 0) goto L_0x0130;
        L_0x0113:
            if (r14 == 0) goto L_0x0130;
        L_0x0115:
            r19.m32227b();	 Catch:{ Throwable -> 0x0135 }
            r10 = r1.f31376e;	 Catch:{ Throwable -> 0x0135 }
            r10 = r10.get();	 Catch:{ Throwable -> 0x0135 }
            r10 = (java.lang.Throwable) r10;	 Catch:{ Throwable -> 0x0135 }
            if (r10 == 0) goto L_0x012c;
        L_0x0122:
            r10 = r1.f31376e;	 Catch:{ Throwable -> 0x0135 }
            r10 = io.reactivex.internal.util.ExceptionHelper.m26683a(r10);	 Catch:{ Throwable -> 0x0135 }
            r2.onError(r10);	 Catch:{ Throwable -> 0x0135 }
            return;
        L_0x012c:
            r2.onComplete();	 Catch:{ Throwable -> 0x0135 }
            return;
        L_0x0130:
            if (r14 != 0) goto L_0x0150;
        L_0x0132:
            r6[r4] = r10;	 Catch:{ Throwable -> 0x0135 }
            goto L_0x0150;
        L_0x0135:
            r0 = move-exception;
            r10 = r0;
            io.reactivex.exceptions.Exceptions.m26521b(r10);
            r11 = r1.f31376e;
            io.reactivex.internal.util.ExceptionHelper.m26684a(r11, r10);
            r10 = r1.f31377f;
            if (r10 != 0) goto L_0x0150;
        L_0x0143:
            r19.m32227b();
            r3 = r1.f31376e;
            r3 = io.reactivex.internal.util.ExceptionHelper.m26683a(r3);
            r2.onError(r3);
            return;
        L_0x0150:
            r4 = r4 + 1;
            goto L_0x00f7;
        L_0x0153:
            r10 = 0;
            r4 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1));
            if (r4 == 0) goto L_0x0175;
        L_0x0159:
            r4 = r3.length;
            r10 = r16;
        L_0x015c:
            if (r10 >= r4) goto L_0x0166;
        L_0x015e:
            r11 = r3[r10];
            r11.request(r12);
            r10 = r10 + 1;
            goto L_0x015c;
        L_0x0166:
            r10 = 9223372036854775807; // 0x7fffffffffffffff float:NaN double:NaN;
            r4 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1));
            if (r4 == 0) goto L_0x0175;
        L_0x016f:
            r4 = r1.f31375d;
            r8 = -r12;
            r4.addAndGet(r8);
        L_0x0175:
            r4 = -r7;
            r7 = r1.addAndGet(r4);
            if (r7 != 0) goto L_0x0011;
        L_0x017c:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableZip.ZipCoordinator.a():void");
        }
    }

    static final class ZipSubscriber<T, R> extends AtomicReference<Subscription> implements FlowableSubscriber<T>, Subscription {
        final ZipCoordinator<T, R> f35531a;
        final int f35532b;
        final int f35533c;
        SimpleQueue<T> f35534d;
        long f35535e;
        volatile boolean f35536f;
        int f35537g;

        ZipSubscriber(ZipCoordinator<T, R> zipCoordinator, int i) {
            this.f35531a = zipCoordinator;
            this.f35532b = i;
            this.f35533c = i - (i >> 2);
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32779a((AtomicReference) this, subscription)) {
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int a = queueSubscription.mo7033a(7);
                    if (a == 1) {
                        this.f35537g = a;
                        this.f35534d = queueSubscription;
                        this.f35536f = true;
                        this.f35531a.m32228a();
                        return;
                    } else if (a == 2) {
                        this.f35537g = a;
                        this.f35534d = queueSubscription;
                        subscription.request((long) this.f35532b);
                        return;
                    }
                }
                this.f35534d = new SpscArrayQueue(this.f35532b);
                subscription.request((long) this.f35532b);
            }
        }

        public final void onNext(T t) {
            if (this.f35537g != 2) {
                this.f35534d.offer(t);
            }
            this.f35531a.m32228a();
        }

        public final void onError(Throwable th) {
            this.f35531a.m32229a(this, th);
        }

        public final void onComplete() {
            this.f35536f = true;
            this.f35531a.m32228a();
        }

        public final void cancel() {
            SubscriptionHelper.m32777a((AtomicReference) this);
        }

        public final void request(long j) {
            if (this.f35537g != 1) {
                long j2 = this.f35535e + j;
                if (j2 >= ((long) this.f35533c)) {
                    this.f35535e = 0;
                    ((Subscription) get()).request(j2);
                    return;
                }
                this.f35535e = j2;
            }
        }
    }

    public FlowableZip(Publisher<? extends T>[] publisherArr, Iterable<? extends Publisher<? extends T>> iterable, Function<? super Object[], ? extends R> function, int i, boolean z) {
        this.f35538a = publisherArr;
        this.f35539b = iterable;
        this.f35540c = function;
        this.f35541d = i;
        this.f35542e = z;
    }

    public final void subscribeActual(Subscriber<? super R> subscriber) {
        int i;
        Publisher[] publisherArr;
        Publisher[] publisherArr2 = this.f35538a;
        int i2 = 0;
        if (publisherArr2 == null) {
            Object obj = new Publisher[8];
            Object obj2 = obj;
            i = 0;
            for (Publisher publisher : this.f35539b) {
                if (i == obj2.length) {
                    Object obj3 = new Publisher[((i >> 2) + i)];
                    System.arraycopy(obj2, 0, obj3, 0, i);
                    obj2 = obj3;
                }
                int i3 = i + 1;
                obj2[i] = publisher;
                i = i3;
            }
            publisherArr = obj2;
        } else {
            publisherArr = publisherArr2;
            i = publisherArr2.length;
        }
        if (i == 0) {
            EmptySubscription.m38161a((Subscriber) subscriber);
            return;
        }
        ZipCoordinator zipCoordinator = new ZipCoordinator(subscriber, this.f35540c, i, this.f35541d, this.f35542e);
        subscriber.mo5623a(zipCoordinator);
        subscriber = zipCoordinator.f31373b;
        while (i2 < i && !zipCoordinator.f31378g) {
            if (!zipCoordinator.f31377f && zipCoordinator.f31376e.get() != null) {
                break;
            }
            publisherArr[i2].subscribe(subscriber[i2]);
            i2++;
        }
    }
}
