package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
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

public final class FlowableSwitchMap<T, R> extends AbstractFlowableWithUpstream<T, R> {
    final Function<? super T, ? extends Publisher<? extends R>> f37834a;
    final int f37835b;
    final boolean f37836c;

    static final class SwitchMapInnerSubscriber<T, R> extends AtomicReference<Subscription> implements FlowableSubscriber<R> {
        final SwitchMapSubscriber<T, R> f35371a;
        final long f35372b;
        final int f35373c;
        volatile SimpleQueue<R> f35374d;
        volatile boolean f35375e;
        int f35376f;

        SwitchMapInnerSubscriber(SwitchMapSubscriber<T, R> switchMapSubscriber, long j, int i) {
            this.f35371a = switchMapSubscriber;
            this.f35372b = j;
            this.f35373c = i;
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32779a((AtomicReference) this, subscription)) {
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int a = queueSubscription.mo7033a(3);
                    if (a == 1) {
                        this.f35376f = a;
                        this.f35374d = queueSubscription;
                        this.f35375e = true;
                        this.f35371a.m35851a();
                        return;
                    } else if (a == 2) {
                        this.f35376f = a;
                        this.f35374d = queueSubscription;
                        subscription.request((long) this.f35373c);
                        return;
                    }
                }
                this.f35374d = new SpscArrayQueue(this.f35373c);
                subscription.request((long) this.f35373c);
            }
        }

        public final void onNext(R r) {
            SwitchMapSubscriber switchMapSubscriber = this.f35371a;
            if (this.f35372b == switchMapSubscriber.f35388l) {
                if (this.f35376f == 0 && this.f35374d.offer(r) == null) {
                    onError(new MissingBackpressureException("Queue full?!"));
                    return;
                }
                switchMapSubscriber.m35851a();
            }
        }

        public final void onError(Throwable th) {
            SwitchMapSubscriber switchMapSubscriber = this.f35371a;
            if (this.f35372b == switchMapSubscriber.f35388l && ExceptionHelper.m26684a(switchMapSubscriber.f35383f, th)) {
                if (switchMapSubscriber.f35381d == null) {
                    switchMapSubscriber.f35385h.cancel();
                }
                this.f35375e = true;
                switchMapSubscriber.m35851a();
                return;
            }
            RxJavaPlugins.m26757a(th);
        }

        public final void onComplete() {
            SwitchMapSubscriber switchMapSubscriber = this.f35371a;
            if (this.f35372b == switchMapSubscriber.f35388l) {
                this.f35375e = true;
                switchMapSubscriber.m35851a();
            }
        }
    }

    static final class SwitchMapSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        static final SwitchMapInnerSubscriber<Object, Object> f35377k;
        final Subscriber<? super R> f35378a;
        final Function<? super T, ? extends Publisher<? extends R>> f35379b;
        final int f35380c;
        final boolean f35381d;
        volatile boolean f35382e;
        final AtomicThrowable f35383f;
        volatile boolean f35384g;
        Subscription f35385h;
        final AtomicReference<SwitchMapInnerSubscriber<T, R>> f35386i = new AtomicReference();
        final AtomicLong f35387j = new AtomicLong();
        volatile long f35388l;

        static {
            AtomicReference switchMapInnerSubscriber = new SwitchMapInnerSubscriber(null, -1, 1);
            f35377k = switchMapInnerSubscriber;
            SubscriptionHelper.m32777a(switchMapInnerSubscriber);
        }

        SwitchMapSubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends Publisher<? extends R>> function, int i, boolean z) {
            this.f35378a = subscriber;
            this.f35379b = function;
            this.f35380c = i;
            this.f35381d = z;
            this.f35383f = new AtomicThrowable();
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32781a(this.f35385h, subscription)) {
                this.f35385h = subscription;
                this.f35378a.mo5623a(this);
            }
        }

        public final void onNext(T t) {
            if (!this.f35382e) {
                long j = this.f35388l + 1;
                this.f35388l = j;
                AtomicReference atomicReference = (SwitchMapInnerSubscriber) this.f35386i.get();
                if (atomicReference != null) {
                    SubscriptionHelper.m32777a(atomicReference);
                }
                try {
                    Publisher publisher = (Publisher) ObjectHelper.m26573a(this.f35379b.apply(t), "The publisher returned is null");
                    Subscriber switchMapInnerSubscriber = new SwitchMapInnerSubscriber(this, j, this.f35380c);
                    SwitchMapInnerSubscriber switchMapInnerSubscriber2;
                    do {
                        switchMapInnerSubscriber2 = (SwitchMapInnerSubscriber) this.f35386i.get();
                        if (switchMapInnerSubscriber2 == f35377k) {
                            break;
                        }
                    } while (!this.f35386i.compareAndSet(switchMapInnerSubscriber2, switchMapInnerSubscriber));
                    publisher.subscribe(switchMapInnerSubscriber);
                } catch (T t2) {
                    Exceptions.m26521b(t2);
                    this.f35385h.cancel();
                    onError(t2);
                }
            }
        }

        public final void onError(Throwable th) {
            if (this.f35382e || !ExceptionHelper.m26684a(this.f35383f, th)) {
                RxJavaPlugins.m26757a(th);
                return;
            }
            if (this.f35381d == null) {
                m35850b();
            }
            this.f35382e = true;
            m35851a();
        }

        public final void onComplete() {
            if (!this.f35382e) {
                this.f35382e = true;
                m35851a();
            }
        }

        public final void request(long j) {
            if (SubscriptionHelper.m32776a(j)) {
                BackpressureHelper.m26670a(this.f35387j, j);
                if (this.f35388l == 0) {
                    this.f35385h.request(Long.MAX_VALUE);
                    return;
                }
                m35851a();
            }
        }

        public final void cancel() {
            if (!this.f35384g) {
                this.f35384g = true;
                this.f35385h.cancel();
                m35850b();
            }
        }

        private void m35850b() {
            if (((SwitchMapInnerSubscriber) this.f35386i.get()) != f35377k) {
                AtomicReference atomicReference = (SwitchMapInnerSubscriber) this.f35386i.getAndSet(f35377k);
                if (atomicReference != f35377k && atomicReference != null) {
                    SubscriptionHelper.m32777a(atomicReference);
                }
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        final void m35851a() {
            /*
            r19 = this;
            r1 = r19;
            r2 = r19.getAndIncrement();
            if (r2 == 0) goto L_0x0009;
        L_0x0008:
            return;
        L_0x0009:
            r2 = r1.f35378a;
            r4 = 1;
        L_0x000c:
            r5 = r1.f35384g;
            r6 = 0;
            if (r5 == 0) goto L_0x0017;
        L_0x0011:
            r2 = r1.f35386i;
            r2.lazySet(r6);
            return;
        L_0x0017:
            r5 = r1.f35382e;
            if (r5 == 0) goto L_0x0062;
        L_0x001b:
            r5 = r1.f35381d;
            if (r5 == 0) goto L_0x003f;
        L_0x001f:
            r5 = r1.f35386i;
            r5 = r5.get();
            if (r5 != 0) goto L_0x0062;
        L_0x0027:
            r3 = r1.f35383f;
            r3 = r3.get();
            r3 = (java.lang.Throwable) r3;
            if (r3 == 0) goto L_0x003b;
        L_0x0031:
            r3 = r1.f35383f;
            r3 = io.reactivex.internal.util.ExceptionHelper.m26683a(r3);
            r2.onError(r3);
            return;
        L_0x003b:
            r2.onComplete();
            return;
        L_0x003f:
            r5 = r1.f35383f;
            r5 = r5.get();
            r5 = (java.lang.Throwable) r5;
            if (r5 == 0) goto L_0x0056;
        L_0x0049:
            r19.m35850b();
            r3 = r1.f35383f;
            r3 = io.reactivex.internal.util.ExceptionHelper.m26683a(r3);
            r2.onError(r3);
            return;
        L_0x0056:
            r5 = r1.f35386i;
            r5 = r5.get();
            if (r5 != 0) goto L_0x0062;
        L_0x005e:
            r2.onComplete();
            return;
        L_0x0062:
            r5 = r1.f35386i;
            r5 = r5.get();
            r5 = (io.reactivex.internal.operators.flowable.FlowableSwitchMap.SwitchMapInnerSubscriber) r5;
            if (r5 == 0) goto L_0x006f;
        L_0x006c:
            r7 = r5.f35374d;
            goto L_0x0070;
        L_0x006f:
            r7 = r6;
        L_0x0070:
            if (r7 == 0) goto L_0x0140;
        L_0x0072:
            r8 = r5.f35375e;
            if (r8 == 0) goto L_0x00ab;
        L_0x0076:
            r8 = r1.f35381d;
            if (r8 != 0) goto L_0x009e;
        L_0x007a:
            r8 = r1.f35383f;
            r8 = r8.get();
            r8 = (java.lang.Throwable) r8;
            if (r8 == 0) goto L_0x0091;
        L_0x0084:
            r19.m35850b();
            r3 = r1.f35383f;
            r3 = io.reactivex.internal.util.ExceptionHelper.m26683a(r3);
            r2.onError(r3);
            return;
        L_0x0091:
            r8 = r7.isEmpty();
            if (r8 == 0) goto L_0x00ab;
        L_0x0097:
            r7 = r1.f35386i;
            r7.compareAndSet(r5, r6);
            goto L_0x000c;
        L_0x009e:
            r8 = r7.isEmpty();
            if (r8 == 0) goto L_0x00ab;
        L_0x00a4:
            r7 = r1.f35386i;
            r7.compareAndSet(r5, r6);
            goto L_0x000c;
        L_0x00ab:
            r8 = r1.f35387j;
            r8 = r8.get();
            r10 = 0;
            r12 = r10;
        L_0x00b4:
            r14 = (r12 > r8 ? 1 : (r12 == r8 ? 0 : -1));
            r15 = 0;
            if (r14 == 0) goto L_0x011e;
        L_0x00b9:
            r14 = r1.f35384g;
            if (r14 == 0) goto L_0x00be;
        L_0x00bd:
            return;
        L_0x00be:
            r14 = r5.f35375e;
            r16 = r7.poll();	 Catch:{ Throwable -> 0x00cb }
            r18 = r16;
            r16 = r14;
            r14 = r18;
            goto L_0x00da;
        L_0x00cb:
            r0 = move-exception;
            io.reactivex.exceptions.Exceptions.m26521b(r0);
            io.reactivex.internal.subscriptions.SubscriptionHelper.m32777a(r5);
            r14 = r1.f35383f;
            io.reactivex.internal.util.ExceptionHelper.m26684a(r14, r0);
            r14 = r6;
            r16 = 1;
        L_0x00da:
            if (r14 != 0) goto L_0x00df;
        L_0x00dc:
            r17 = 1;
            goto L_0x00e1;
        L_0x00df:
            r17 = r15;
        L_0x00e1:
            r3 = r1.f35386i;
            r3 = r3.get();
            if (r5 == r3) goto L_0x00eb;
        L_0x00e9:
            r15 = 1;
            goto L_0x011e;
        L_0x00eb:
            if (r16 == 0) goto L_0x0115;
        L_0x00ed:
            r3 = r1.f35381d;
            if (r3 != 0) goto L_0x010d;
        L_0x00f1:
            r3 = r1.f35383f;
            r3 = r3.get();
            r3 = (java.lang.Throwable) r3;
            if (r3 == 0) goto L_0x0105;
        L_0x00fb:
            r3 = r1.f35383f;
            r3 = io.reactivex.internal.util.ExceptionHelper.m26683a(r3);
            r2.onError(r3);
            return;
        L_0x0105:
            if (r17 == 0) goto L_0x0115;
        L_0x0107:
            r3 = r1.f35386i;
            r3.compareAndSet(r5, r6);
            goto L_0x00e9;
        L_0x010d:
            if (r17 == 0) goto L_0x0115;
        L_0x010f:
            r3 = r1.f35386i;
            r3.compareAndSet(r5, r6);
            goto L_0x00e9;
        L_0x0115:
            if (r17 != 0) goto L_0x011e;
        L_0x0117:
            r2.onNext(r14);
            r14 = 1;
            r12 = r12 + r14;
            goto L_0x00b4;
        L_0x011e:
            r3 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1));
            if (r3 == 0) goto L_0x013e;
        L_0x0122:
            r3 = r1.f35384g;
            if (r3 != 0) goto L_0x013e;
        L_0x0126:
            r6 = 9223372036854775807; // 0x7fffffffffffffff float:NaN double:NaN;
            r3 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1));
            if (r3 == 0) goto L_0x0135;
        L_0x012f:
            r3 = r1.f35387j;
            r6 = -r12;
            r3.addAndGet(r6);
        L_0x0135:
            r3 = r5.get();
            r3 = (org.reactivestreams.Subscription) r3;
            r3.request(r12);
        L_0x013e:
            if (r15 != 0) goto L_0x000c;
        L_0x0140:
            r3 = -r4;
            r4 = r1.addAndGet(r3);
            if (r4 != 0) goto L_0x000c;
        L_0x0147:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableSwitchMap.SwitchMapSubscriber.a():void");
        }
    }

    public FlowableSwitchMap(Flowable<T> flowable, Function<? super T, ? extends Publisher<? extends R>> function, int i, boolean z) {
        super(flowable);
        this.f37834a = function;
        this.f37835b = i;
        this.f37836c = z;
    }

    protected final void subscribeActual(Subscriber<? super R> subscriber) {
        if (!FlowableScalarXMap.m26613a(this.source, subscriber, this.f37834a)) {
            this.source.subscribe(new SwitchMapSubscriber(subscriber, this.f37834a, this.f37835b, this.f37836c));
        }
    }
}
