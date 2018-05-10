package io.reactivex.internal.operators.flowable;

import com.reddit.datalibrary.frontpage.job.RedditJobManager;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
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

public final class FlowableFlatMap<T, U> extends AbstractFlowableWithUpstream<T, U> {
    final Function<? super T, ? extends Publisher<? extends U>> f37721a;
    final boolean f37722b;
    final int f37723c;
    final int f37724d;

    static final class InnerSubscriber<T, U> extends AtomicReference<Subscription> implements FlowableSubscriber<U>, Disposable {
        final long f35002a;
        final MergeSubscriber<T, U> f35003b;
        final int f35004c = (this.f35005d >> 2);
        final int f35005d;
        volatile boolean f35006e;
        volatile SimpleQueue<U> f35007f;
        long f35008g;
        int f35009h;

        InnerSubscriber(MergeSubscriber<T, U> mergeSubscriber, long j) {
            this.f35002a = j;
            this.f35003b = mergeSubscriber;
            this.f35005d = mergeSubscriber.f35016e;
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32779a((AtomicReference) this, subscription)) {
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int a = queueSubscription.mo7033a(7);
                    if (a == 1) {
                        this.f35009h = a;
                        this.f35007f = queueSubscription;
                        this.f35006e = true;
                        this.f35003b.m35716a();
                        return;
                    } else if (a == 2) {
                        this.f35009h = a;
                        this.f35007f = queueSubscription;
                    }
                }
                subscription.request((long) this.f35005d);
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onNext(U r7) {
            /*
            r6 = this;
            r0 = r6.f35009h;
            r1 = 2;
            if (r0 == r1) goto L_0x0094;
        L_0x0005:
            r0 = r6.f35003b;
            r1 = r0.get();
            if (r1 != 0) goto L_0x006c;
        L_0x000d:
            r1 = 0;
            r2 = 1;
            r1 = r0.compareAndSet(r1, r2);
            if (r1 == 0) goto L_0x006c;
        L_0x0015:
            r1 = r0.f35022m;
            r1 = r1.get();
            r3 = r6.f35007f;
            r4 = 0;
            r4 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1));
            if (r4 == 0) goto L_0x0044;
        L_0x0023:
            if (r3 == 0) goto L_0x002b;
        L_0x0025:
            r4 = r3.isEmpty();
            if (r4 == 0) goto L_0x0044;
        L_0x002b:
            r3 = r0.f35012a;
            r3.onNext(r7);
            r3 = 9223372036854775807; // 0x7fffffffffffffff float:NaN double:NaN;
            r7 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));
            if (r7 == 0) goto L_0x003e;
        L_0x0039:
            r7 = r0.f35022m;
            r7.decrementAndGet();
        L_0x003e:
            r1 = 1;
            r6.m35708a(r1);
            goto L_0x0065;
        L_0x0044:
            if (r3 != 0) goto L_0x0054;
        L_0x0046:
            r1 = r6.f35007f;
            if (r1 != 0) goto L_0x0053;
        L_0x004a:
            r1 = new io.reactivex.internal.queue.SpscArrayQueue;
            r2 = r0.f35016e;
            r1.<init>(r2);
            r6.f35007f = r1;
        L_0x0053:
            r3 = r1;
        L_0x0054:
            r7 = r3.offer(r7);
            if (r7 != 0) goto L_0x0065;
        L_0x005a:
            r7 = new io.reactivex.exceptions.MissingBackpressureException;
            r1 = "Inner queue full?!";
            r7.<init>(r1);
            r0.onError(r7);
            return;
        L_0x0065:
            r7 = r0.decrementAndGet();
            if (r7 == 0) goto L_0x0093;
        L_0x006b:
            goto L_0x0090;
        L_0x006c:
            r1 = r6.f35007f;
            if (r1 != 0) goto L_0x0079;
        L_0x0070:
            r1 = new io.reactivex.internal.queue.SpscArrayQueue;
            r2 = r0.f35016e;
            r1.<init>(r2);
            r6.f35007f = r1;
        L_0x0079:
            r7 = r1.offer(r7);
            if (r7 != 0) goto L_0x008a;
        L_0x007f:
            r7 = new io.reactivex.exceptions.MissingBackpressureException;
            r1 = "Inner queue full?!";
            r7.<init>(r1);
            r0.onError(r7);
            return;
        L_0x008a:
            r7 = r0.getAndIncrement();
            if (r7 != 0) goto L_0x0093;
        L_0x0090:
            r0.m35718b();
        L_0x0093:
            return;
        L_0x0094:
            r7 = r6.f35003b;
            r7.m35716a();
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableFlatMap.InnerSubscriber.onNext(java.lang.Object):void");
        }

        public final void onError(Throwable th) {
            lazySet(SubscriptionHelper.f32454a);
            MergeSubscriber mergeSubscriber = this.f35003b;
            if (ExceptionHelper.m26684a(mergeSubscriber.f35019h, th)) {
                this.f35006e = true;
                if (mergeSubscriber.f35014c == null) {
                    mergeSubscriber.f35023n.cancel();
                    for (AtomicReference a : (InnerSubscriber[]) mergeSubscriber.f35021j.getAndSet(MergeSubscriber.f35011l)) {
                        SubscriptionHelper.m32777a(a);
                    }
                }
                mergeSubscriber.m35716a();
                return;
            }
            RxJavaPlugins.m26757a(th);
        }

        public final void onComplete() {
            this.f35006e = true;
            this.f35003b.m35716a();
        }

        final void m35708a(long j) {
            if (this.f35009h != 1) {
                long j2 = this.f35008g + j;
                if (j2 >= ((long) this.f35004c)) {
                    this.f35008g = 0;
                    ((Subscription) get()).request(j2);
                    return;
                }
                this.f35008g = j2;
            }
        }

        public final void mo5626a() {
            SubscriptionHelper.m32777a((AtomicReference) this);
        }

        public final boolean mo5627b() {
            return get() == SubscriptionHelper.f32454a;
        }
    }

    static final class MergeSubscriber<T, U> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        static final InnerSubscriber<?, ?>[] f35010k = new InnerSubscriber[0];
        static final InnerSubscriber<?, ?>[] f35011l = new InnerSubscriber[0];
        final Subscriber<? super U> f35012a;
        final Function<? super T, ? extends Publisher<? extends U>> f35013b;
        final boolean f35014c;
        final int f35015d;
        final int f35016e;
        volatile SimplePlainQueue<U> f35017f;
        volatile boolean f35018g;
        final AtomicThrowable f35019h = new AtomicThrowable();
        volatile boolean f35020i;
        final AtomicReference<InnerSubscriber<?, ?>[]> f35021j = new AtomicReference();
        final AtomicLong f35022m = new AtomicLong();
        Subscription f35023n;
        long f35024o;
        long f35025p;
        int f35026q;
        int f35027r;
        final int f35028s;

        MergeSubscriber(Subscriber<? super U> subscriber, Function<? super T, ? extends Publisher<? extends U>> function, boolean z, int i, int i2) {
            this.f35012a = subscriber;
            this.f35013b = function;
            this.f35014c = z;
            this.f35015d = i;
            this.f35016e = i2;
            this.f35028s = Math.max(1, i >> 1);
            this.f35021j.lazySet(f35010k);
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32781a(this.f35023n, subscription)) {
                this.f35023n = subscription;
                this.f35012a.mo5623a(this);
                if (!this.f35020i) {
                    if (this.f35015d == RedditJobManager.f10810d) {
                        subscription.request(Long.MAX_VALUE);
                        return;
                    }
                    subscription.request((long) this.f35015d);
                }
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onNext(T r9) {
            /*
            r8 = this;
            r0 = r8.f35018g;
            if (r0 == 0) goto L_0x0005;
        L_0x0004:
            return;
        L_0x0005:
            r0 = r8.f35013b;	 Catch:{ Throwable -> 0x00f1 }
            r9 = r0.apply(r9);	 Catch:{ Throwable -> 0x00f1 }
            r0 = "The mapper returned a null Publisher";
            r9 = io.reactivex.internal.functions.ObjectHelper.m26573a(r9, r0);	 Catch:{ Throwable -> 0x00f1 }
            r9 = (org.reactivestreams.Publisher) r9;	 Catch:{ Throwable -> 0x00f1 }
            r0 = r9 instanceof java.util.concurrent.Callable;
            if (r0 == 0) goto L_0x00db;
        L_0x0017:
            r9 = (java.util.concurrent.Callable) r9;	 Catch:{ Throwable -> 0x00ce }
            r9 = r9.call();	 Catch:{ Throwable -> 0x00ce }
            r0 = 2147483647; // 0x7fffffff float:NaN double:1.060997895E-314;
            r1 = 1;
            r2 = 0;
            if (r9 == 0) goto L_0x00b2;
        L_0x0024:
            r3 = r8.get();
            if (r3 != 0) goto L_0x0093;
        L_0x002a:
            r3 = r8.compareAndSet(r2, r1);
            if (r3 == 0) goto L_0x0093;
        L_0x0030:
            r3 = r8.f35022m;
            r3 = r3.get();
            r5 = r8.f35017f;
            r6 = 0;
            r6 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1));
            if (r6 == 0) goto L_0x0075;
        L_0x003e:
            if (r5 == 0) goto L_0x0046;
        L_0x0040:
            r6 = r5.isEmpty();
            if (r6 == 0) goto L_0x0075;
        L_0x0046:
            r5 = r8.f35012a;
            r5.onNext(r9);
            r5 = 9223372036854775807; // 0x7fffffffffffffff float:NaN double:NaN;
            r9 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1));
            if (r9 == 0) goto L_0x0059;
        L_0x0054:
            r9 = r8.f35022m;
            r9.decrementAndGet();
        L_0x0059:
            r9 = r8.f35015d;
            if (r9 == r0) goto L_0x008c;
        L_0x005d:
            r9 = r8.f35020i;
            if (r9 != 0) goto L_0x008c;
        L_0x0061:
            r9 = r8.f35027r;
            r9 = r9 + r1;
            r8.f35027r = r9;
            r0 = r8.f35028s;
            if (r9 != r0) goto L_0x008c;
        L_0x006a:
            r8.f35027r = r2;
            r9 = r8.f35023n;
            r0 = r8.f35028s;
            r0 = (long) r0;
            r9.request(r0);
            goto L_0x008c;
        L_0x0075:
            if (r5 != 0) goto L_0x007b;
        L_0x0077:
            r5 = r8.m35713c();
        L_0x007b:
            r9 = r5.offer(r9);
            if (r9 != 0) goto L_0x008c;
        L_0x0081:
            r9 = new java.lang.IllegalStateException;
            r0 = "Scalar queue full?!";
            r9.<init>(r0);
            r8.onError(r9);
            return;
        L_0x008c:
            r9 = r8.decrementAndGet();
            if (r9 == 0) goto L_0x00b1;
        L_0x0092:
            goto L_0x00ae;
        L_0x0093:
            r0 = r8.m35713c();
            r9 = r0.offer(r9);
            if (r9 != 0) goto L_0x00a8;
        L_0x009d:
            r9 = new java.lang.IllegalStateException;
            r0 = "Scalar queue full?!";
            r9.<init>(r0);
            r8.onError(r9);
            return;
        L_0x00a8:
            r9 = r8.getAndIncrement();
            if (r9 != 0) goto L_0x00b1;
        L_0x00ae:
            r8.m35718b();
        L_0x00b1:
            return;
        L_0x00b2:
            r9 = r8.f35015d;
            if (r9 == r0) goto L_0x00cd;
        L_0x00b6:
            r9 = r8.f35020i;
            if (r9 != 0) goto L_0x00cd;
        L_0x00ba:
            r9 = r8.f35027r;
            r9 = r9 + r1;
            r8.f35027r = r9;
            r0 = r8.f35028s;
            if (r9 != r0) goto L_0x00cd;
        L_0x00c3:
            r8.f35027r = r2;
            r9 = r8.f35023n;
            r0 = r8.f35028s;
            r0 = (long) r0;
            r9.request(r0);
        L_0x00cd:
            return;
        L_0x00ce:
            r9 = move-exception;
            io.reactivex.exceptions.Exceptions.m26521b(r9);
            r0 = r8.f35019h;
            io.reactivex.internal.util.ExceptionHelper.m26684a(r0, r9);
            r8.m35716a();
            return;
        L_0x00db:
            r0 = new io.reactivex.internal.operators.flowable.FlowableFlatMap$InnerSubscriber;
            r1 = r8.f35024o;
            r3 = 1;
            r3 = r3 + r1;
            r8.f35024o = r3;
            r0.<init>(r8, r1);
            r1 = r8.m35711a(r0);
            if (r1 == 0) goto L_0x00f0;
        L_0x00ed:
            r9.subscribe(r0);
        L_0x00f0:
            return;
        L_0x00f1:
            r9 = move-exception;
            io.reactivex.exceptions.Exceptions.m26521b(r9);
            r0 = r8.f35023n;
            r0.cancel();
            r8.onError(r9);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableFlatMap.MergeSubscriber.onNext(java.lang.Object):void");
        }

        private boolean m35711a(InnerSubscriber<T, U> innerSubscriber) {
            InnerSubscriber[] innerSubscriberArr;
            Object obj;
            do {
                innerSubscriberArr = (InnerSubscriber[]) this.f35021j.get();
                if (innerSubscriberArr == f35011l) {
                    innerSubscriber.mo5626a();
                    return false;
                }
                int length = innerSubscriberArr.length;
                obj = new InnerSubscriber[(length + 1)];
                System.arraycopy(innerSubscriberArr, 0, obj, 0, length);
                obj[length] = innerSubscriber;
            } while (!this.f35021j.compareAndSet(innerSubscriberArr, obj));
            return true;
        }

        private void m35712b(InnerSubscriber<T, U> innerSubscriber) {
            InnerSubscriber[] innerSubscriberArr;
            Object obj;
            do {
                innerSubscriberArr = (InnerSubscriber[]) this.f35021j.get();
                if (innerSubscriberArr != f35011l) {
                    if (innerSubscriberArr != f35010k) {
                        int length = innerSubscriberArr.length;
                        int i = -1;
                        for (int i2 = 0; i2 < length; i2++) {
                            if (innerSubscriberArr[i2] == innerSubscriber) {
                                i = i2;
                                break;
                            }
                        }
                        if (i >= 0) {
                            if (length == 1) {
                                obj = f35010k;
                            } else {
                                Object obj2 = new InnerSubscriber[(length - 1)];
                                System.arraycopy(innerSubscriberArr, 0, obj2, 0, i);
                                System.arraycopy(innerSubscriberArr, i + 1, obj2, i, (length - i) - 1);
                                obj = obj2;
                            }
                        } else {
                            return;
                        }
                    }
                }
                return;
            } while (!this.f35021j.compareAndSet(innerSubscriberArr, obj));
        }

        private SimpleQueue<U> m35713c() {
            SimpleQueue<U> simpleQueue = this.f35017f;
            if (simpleQueue == null) {
                if (this.f35015d == RedditJobManager.f10810d) {
                    simpleQueue = new SpscLinkedArrayQueue(this.f35016e);
                } else {
                    simpleQueue = new SpscArrayQueue(this.f35015d);
                }
                this.f35017f = simpleQueue;
            }
            return simpleQueue;
        }

        public final void onError(Throwable th) {
            if (this.f35018g) {
                RxJavaPlugins.m26757a(th);
            } else if (ExceptionHelper.m26684a(this.f35019h, th)) {
                this.f35018g = true;
                m35716a();
            } else {
                RxJavaPlugins.m26757a(th);
            }
        }

        public final void onComplete() {
            if (!this.f35018g) {
                this.f35018g = true;
                m35716a();
            }
        }

        public final void request(long j) {
            if (SubscriptionHelper.m32776a(j)) {
                BackpressureHelper.m26670a(this.f35022m, j);
                m35716a();
            }
        }

        public final void cancel() {
            if (!this.f35020i) {
                this.f35020i = true;
                this.f35023n.cancel();
                if (((InnerSubscriber[]) this.f35021j.get()) != f35011l) {
                    InnerSubscriber[] innerSubscriberArr = (InnerSubscriber[]) this.f35021j.getAndSet(f35011l);
                    if (innerSubscriberArr != f35011l) {
                        for (InnerSubscriber a : innerSubscriberArr) {
                            a.mo5626a();
                        }
                        Throwable a2 = ExceptionHelper.m26683a(this.f35019h);
                        if (!(a2 == null || a2 == ExceptionHelper.f25187a)) {
                            RxJavaPlugins.m26757a(a2);
                        }
                    }
                }
                if (getAndIncrement() == 0) {
                    SimpleQueue simpleQueue = this.f35017f;
                    if (simpleQueue != null) {
                        simpleQueue.clear();
                    }
                }
            }
        }

        final void m35716a() {
            if (getAndIncrement() == 0) {
                m35718b();
            }
        }

        final void m35718b() {
            Subscriber subscriber = this.f35012a;
            int i = 1;
            while (!m35714d()) {
                long j;
                SimplePlainQueue simplePlainQueue = r1.f35017f;
                long j2 = r1.f35022m.get();
                Object obj = j2 == Long.MAX_VALUE ? 1 : null;
                if (simplePlainQueue != null) {
                    j = 0;
                    while (true) {
                        long j3 = 0;
                        Object obj2 = null;
                        while (j2 != 0) {
                            Object poll = simplePlainQueue.poll();
                            if (!m35714d()) {
                                if (poll == null) {
                                    obj2 = poll;
                                    break;
                                }
                                subscriber.onNext(poll);
                                j++;
                                j3++;
                                j2--;
                                obj2 = poll;
                            } else {
                                return;
                            }
                        }
                        if (j3 != 0) {
                            if (obj != null) {
                                j2 = Long.MAX_VALUE;
                            } else {
                                j2 = r1.f35022m.addAndGet(-j3);
                            }
                        }
                        if (j2 == 0) {
                            break;
                        } else if (obj2 == null) {
                            break;
                        }
                    }
                } else {
                    j = 0;
                }
                boolean z = r1.f35018g;
                SimplePlainQueue simplePlainQueue2 = r1.f35017f;
                InnerSubscriber[] innerSubscriberArr = (InnerSubscriber[]) r1.f35021j.get();
                int length = innerSubscriberArr.length;
                if (z && ((simplePlainQueue2 == null || simplePlainQueue2.isEmpty()) && length == 0)) {
                    Throwable a = ExceptionHelper.m26683a(r1.f35019h);
                    if (a != ExceptionHelper.f25187a) {
                        if (a == null) {
                            subscriber.onComplete();
                            return;
                        }
                        subscriber.onError(a);
                    }
                    return;
                }
                int i2;
                Object obj3;
                Subscriber subscriber2;
                long addAndGet;
                if (length != 0) {
                    int i3;
                    i2 = i;
                    long j4 = r1.f35025p;
                    int i4 = r1.f35026q;
                    if (length <= i4 || innerSubscriberArr[i4].f35002a != j4) {
                        if (length <= i4) {
                            i4 = 0;
                        }
                        i3 = i4;
                        for (i4 = 0; i4 < length && innerSubscriberArr[i3].f35002a != j4; i4++) {
                            i3++;
                            if (i3 == length) {
                                i3 = 0;
                            }
                        }
                        r1.f35026q = i3;
                        r1.f35025p = innerSubscriberArr[i3].f35002a;
                        i4 = i3;
                    }
                    int i5 = 0;
                    obj3 = null;
                    while (i5 < length) {
                        if (!m35714d()) {
                            InnerSubscriber innerSubscriber = innerSubscriberArr[i4];
                            Object obj4 = null;
                            while (!m35714d()) {
                                int i6;
                                int i7;
                                SimpleQueue simpleQueue = innerSubscriber.f35007f;
                                if (simpleQueue != null) {
                                    i6 = length;
                                    Object obj5 = obj4;
                                    long j5 = 0;
                                    while (j2 != 0) {
                                        try {
                                            obj5 = simpleQueue.poll();
                                            if (obj5 == null) {
                                                break;
                                            }
                                            subscriber.onNext(obj5);
                                            if (!m35714d()) {
                                                j2--;
                                                j5++;
                                            } else {
                                                return;
                                            }
                                        } catch (Throwable th) {
                                            Exceptions.m26521b(th);
                                            innerSubscriber.mo5626a();
                                            ExceptionHelper.m26684a(r1.f35019h, th);
                                            if (!r1.f35014c) {
                                                r1.f35023n.cancel();
                                            }
                                            if (!m35714d()) {
                                                m35712b(innerSubscriber);
                                                subscriber2 = subscriber;
                                                i7 = i5 + 1;
                                                i3 = i6;
                                                obj3 = 1;
                                            } else {
                                                return;
                                            }
                                        }
                                    }
                                    if (j5 != 0) {
                                        if (obj == null) {
                                            subscriber2 = subscriber;
                                            i7 = i5;
                                            addAndGet = r1.f35022m.addAndGet(-j5);
                                        } else {
                                            subscriber2 = subscriber;
                                            i7 = i5;
                                            addAndGet = Long.MAX_VALUE;
                                        }
                                        innerSubscriber.m35708a(j5);
                                        j2 = addAndGet;
                                    } else {
                                        subscriber2 = subscriber;
                                        i7 = i5;
                                    }
                                    if (j2 != 0) {
                                        if (obj5 != null) {
                                            obj4 = obj5;
                                            length = i6;
                                            subscriber = subscriber2;
                                            i5 = i7;
                                        }
                                    }
                                } else {
                                    subscriber2 = subscriber;
                                    i7 = i5;
                                    i6 = length;
                                }
                                boolean z2 = innerSubscriber.f35006e;
                                SimpleQueue simpleQueue2 = innerSubscriber.f35007f;
                                if (z2 && (simpleQueue2 == null || simpleQueue2.isEmpty())) {
                                    m35712b(innerSubscriber);
                                    if (!m35714d()) {
                                        j++;
                                        obj3 = 1;
                                    } else {
                                        return;
                                    }
                                }
                                if (j2 == 0) {
                                    break;
                                }
                                length = i4 + 1;
                                i3 = i6;
                                i4 = length == i3 ? 0 : length;
                                length = i3;
                                i5 = i7 + 1;
                                subscriber = subscriber2;
                            }
                            return;
                        }
                        return;
                    }
                    subscriber2 = subscriber;
                    r1.f35026q = i4;
                    r1.f35025p = innerSubscriberArr[i4].f35002a;
                    addAndGet = j;
                } else {
                    subscriber2 = subscriber;
                    i2 = i;
                    addAndGet = j;
                    obj3 = null;
                }
                if (!(addAndGet == 0 || r1.f35020i)) {
                    r1.f35023n.request(addAndGet);
                }
                if (obj3 == null) {
                    i = addAndGet(-i2);
                    if (i == 0) {
                        return;
                    }
                } else {
                    i = i2;
                }
                subscriber = subscriber2;
            }
        }

        private boolean m35714d() {
            if (this.f35020i) {
                m35715e();
                return true;
            } else if (this.f35014c || this.f35019h.get() == null) {
                return false;
            } else {
                m35715e();
                Throwable a = ExceptionHelper.m26683a(this.f35019h);
                if (a != ExceptionHelper.f25187a) {
                    this.f35012a.onError(a);
                }
                return true;
            }
        }

        private void m35715e() {
            SimpleQueue simpleQueue = this.f35017f;
            if (simpleQueue != null) {
                simpleQueue.clear();
            }
        }
    }

    public FlowableFlatMap(Flowable<T> flowable, Function<? super T, ? extends Publisher<? extends U>> function, boolean z, int i, int i2) {
        super(flowable);
        this.f37721a = function;
        this.f37722b = z;
        this.f37723c = i;
        this.f37724d = i2;
    }

    protected final void subscribeActual(Subscriber<? super U> subscriber) {
        if (!FlowableScalarXMap.m26613a(this.source, subscriber, this.f37721a)) {
            this.source.subscribe(m38101a(subscriber, this.f37721a, this.f37722b, this.f37723c, this.f37724d));
        }
    }

    public static <T, U> FlowableSubscriber<T> m38101a(Subscriber<? super U> subscriber, Function<? super T, ? extends Publisher<? extends U>> function, boolean z, int i, int i2) {
        return new MergeSubscriber(subscriber, function, z, i, i2);
    }
}
