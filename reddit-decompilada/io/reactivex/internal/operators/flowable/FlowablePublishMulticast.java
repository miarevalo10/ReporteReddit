package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.QueueDrainHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowablePublishMulticast<T, R> extends AbstractFlowableWithUpstream<T, R> {
    final Function<? super Flowable<T>, ? extends Publisher<? extends R>> f37783a;
    final int f37784b;
    final boolean f37785c = null;

    static final class MulticastSubscription<T> extends AtomicLong implements Subscription {
        final Subscriber<? super T> f31341a;
        final MulticastProcessor<T> f31342b;

        MulticastSubscription(Subscriber<? super T> subscriber, MulticastProcessor<T> multicastProcessor) {
            this.f31341a = subscriber;
            this.f31342b = multicastProcessor;
        }

        public final void request(long j) {
            if (SubscriptionHelper.m32776a(j)) {
                BackpressureHelper.m26672b((AtomicLong) this, j);
                this.f31342b.m35782c();
            }
        }

        public final void cancel() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.f31342b.m35779a(this);
                this.f31342b.m35782c();
            }
        }
    }

    static final class MulticastProcessor<T> extends Flowable<T> implements FlowableSubscriber<T>, Disposable {
        static final MulticastSubscription[] f35191a = new MulticastSubscription[0];
        static final MulticastSubscription[] f35192b = new MulticastSubscription[0];
        final AtomicInteger f35193c = new AtomicInteger();
        final AtomicReference<MulticastSubscription<T>[]> f35194d = new AtomicReference(f35191a);
        final int f35195e;
        final int f35196f;
        final boolean f35197g;
        final AtomicReference<Subscription> f35198h = new AtomicReference();
        volatile SimpleQueue<T> f35199i;
        int f35200j;
        volatile boolean f35201k;
        Throwable f35202l;
        int f35203m;

        MulticastProcessor(int i, boolean z) {
            this.f35195e = i;
            this.f35196f = i - (i >> 2);
            this.f35197g = z;
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32779a(this.f35198h, subscription)) {
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int a = queueSubscription.mo7033a(3);
                    if (a == 1) {
                        this.f35200j = a;
                        this.f35199i = queueSubscription;
                        this.f35201k = true;
                        m35782c();
                        return;
                    } else if (a == 2) {
                        this.f35200j = a;
                        this.f35199i = queueSubscription;
                        QueueDrainHelper.m26729a(subscription, this.f35195e);
                        return;
                    }
                }
                this.f35199i = QueueDrainHelper.m26725a(this.f35195e);
                QueueDrainHelper.m26729a(subscription, this.f35195e);
            }
        }

        public final void mo5626a() {
            SubscriptionHelper.m32777a(this.f35198h);
            if (this.f35193c.getAndIncrement() == 0) {
                SimpleQueue simpleQueue = this.f35199i;
                if (simpleQueue != null) {
                    simpleQueue.clear();
                }
            }
        }

        public final boolean mo5627b() {
            return SubscriptionHelper.m32780a((Subscription) this.f35198h.get());
        }

        public final void onNext(T t) {
            if (!this.f35201k) {
                if (this.f35200j == 0 && this.f35199i.offer(t) == null) {
                    ((Subscription) this.f35198h.get()).cancel();
                    onError(new MissingBackpressureException());
                    return;
                }
                m35782c();
            }
        }

        public final void onError(Throwable th) {
            if (this.f35201k) {
                RxJavaPlugins.m26757a(th);
                return;
            }
            this.f35202l = th;
            this.f35201k = true;
            m35782c();
        }

        public final void onComplete() {
            if (!this.f35201k) {
                this.f35201k = true;
                m35782c();
            }
        }

        final void m35779a(MulticastSubscription<T> multicastSubscription) {
            MulticastSubscription[] multicastSubscriptionArr;
            Object obj;
            do {
                multicastSubscriptionArr = (MulticastSubscription[]) this.f35194d.get();
                if (multicastSubscriptionArr != f35192b) {
                    if (multicastSubscriptionArr != f35191a) {
                        int length = multicastSubscriptionArr.length;
                        int i = -1;
                        for (int i2 = 0; i2 < length; i2++) {
                            if (multicastSubscriptionArr[i2] == multicastSubscription) {
                                i = i2;
                                break;
                            }
                        }
                        if (i >= 0) {
                            if (length == 1) {
                                obj = f35191a;
                            } else {
                                Object obj2 = new MulticastSubscription[(length - 1)];
                                System.arraycopy(multicastSubscriptionArr, 0, obj2, 0, i);
                                System.arraycopy(multicastSubscriptionArr, i + 1, obj2, i, (length - i) - 1);
                                obj = obj2;
                            }
                        } else {
                            return;
                        }
                    }
                }
                return;
            } while (!this.f35194d.compareAndSet(multicastSubscriptionArr, obj));
        }

        protected final void subscribeActual(Subscriber<? super T> subscriber) {
            int i;
            MulticastSubscription multicastSubscription = new MulticastSubscription(subscriber, this);
            subscriber.mo5623a(multicastSubscription);
            MulticastSubscription[] multicastSubscriptionArr;
            Object obj;
            do {
                multicastSubscriptionArr = (MulticastSubscription[]) this.f35194d.get();
                int i2 = 1;
                if (multicastSubscriptionArr == f35192b) {
                    i = 0;
                    break;
                }
                int length = multicastSubscriptionArr.length;
                obj = new MulticastSubscription[(length + 1)];
                System.arraycopy(multicastSubscriptionArr, 0, obj, 0, length);
                obj[length] = multicastSubscription;
            } while (!this.f35194d.compareAndSet(multicastSubscriptionArr, obj));
            i = 1;
            if (i != 0) {
                if (multicastSubscription.get() != Long.MIN_VALUE) {
                    i2 = 0;
                }
                if (i2 != 0) {
                    m35779a(multicastSubscription);
                    return;
                } else {
                    m35782c();
                    return;
                }
            }
            Throwable th = this.f35202l;
            if (th != null) {
                subscriber.onError(th);
            } else {
                subscriber.onComplete();
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        final void m35782c() {
            /*
            r20 = this;
            r1 = r20;
            r2 = r1.f35193c;
            r2 = r2.getAndIncrement();
            if (r2 == 0) goto L_0x000b;
        L_0x000a:
            return;
        L_0x000b:
            r2 = r1.f35199i;
            r3 = r1.f35203m;
            r4 = r1.f35196f;
            r5 = r1.f35200j;
            r7 = 1;
            if (r5 == r7) goto L_0x0018;
        L_0x0016:
            r5 = r7;
            goto L_0x0019;
        L_0x0018:
            r5 = 0;
        L_0x0019:
            r8 = r3;
            r3 = r7;
        L_0x001b:
            r9 = r1.f35194d;
            r9 = r9.get();
            r9 = (io.reactivex.internal.operators.flowable.FlowablePublishMulticast.MulticastSubscription[]) r9;
            r10 = r9.length;
            if (r2 == 0) goto L_0x0101;
        L_0x0026:
            if (r10 == 0) goto L_0x0101;
        L_0x0028:
            r10 = 9223372036854775807; // 0x7fffffffffffffff float:NaN double:NaN;
            r12 = r9.length;
            r13 = r10;
            r10 = 0;
        L_0x0030:
            r15 = -9223372036854775808;
            if (r10 >= r12) goto L_0x0047;
        L_0x0034:
            r11 = r9[r10];
            r17 = r11.get();
            r11 = (r17 > r15 ? 1 : (r17 == r15 ? 0 : -1));
            if (r11 == 0) goto L_0x0044;
        L_0x003e:
            r11 = (r13 > r17 ? 1 : (r13 == r17 ? 0 : -1));
            if (r11 <= 0) goto L_0x0044;
        L_0x0042:
            r13 = r17;
        L_0x0044:
            r10 = r10 + 1;
            goto L_0x0030;
        L_0x0047:
            r10 = 0;
        L_0x0049:
            r12 = (r10 > r13 ? 1 : (r10 == r13 ? 0 : -1));
            if (r12 == 0) goto L_0x00c5;
        L_0x004d:
            r17 = r20.mo5627b();
            if (r17 == 0) goto L_0x0057;
        L_0x0053:
            r2.clear();
            return;
        L_0x0057:
            r6 = r1.f35201k;
            if (r6 == 0) goto L_0x0067;
        L_0x005b:
            r7 = r1.f35197g;
            if (r7 != 0) goto L_0x0067;
        L_0x005f:
            r7 = r1.f35202l;
            if (r7 == 0) goto L_0x0067;
        L_0x0063:
            r1.m35776a(r7);
            return;
        L_0x0067:
            r7 = r2.poll();	 Catch:{ Throwable -> 0x00b8 }
            if (r7 != 0) goto L_0x0070;
        L_0x006d:
            r17 = 1;
            goto L_0x0072;
        L_0x0070:
            r17 = 0;
        L_0x0072:
            if (r6 == 0) goto L_0x0082;
        L_0x0074:
            if (r17 == 0) goto L_0x0082;
        L_0x0076:
            r2 = r1.f35202l;
            if (r2 == 0) goto L_0x007e;
        L_0x007a:
            r1.m35776a(r2);
            return;
        L_0x007e:
            r20.m35777d();
            return;
        L_0x0082:
            if (r17 != 0) goto L_0x00c5;
        L_0x0084:
            r6 = r9.length;
            r12 = 0;
        L_0x0086:
            if (r12 >= r6) goto L_0x009e;
        L_0x0088:
            r19 = r6;
            r6 = r9[r12];
            r17 = r6.get();
            r17 = (r17 > r15 ? 1 : (r17 == r15 ? 0 : -1));
            if (r17 == 0) goto L_0x0099;
        L_0x0094:
            r6 = r6.f31341a;
            r6.onNext(r7);
        L_0x0099:
            r12 = r12 + 1;
            r6 = r19;
            goto L_0x0086;
        L_0x009e:
            r6 = 1;
            r10 = r10 + r6;
            if (r5 == 0) goto L_0x00b6;
        L_0x00a3:
            r6 = r8 + 1;
            if (r6 != r4) goto L_0x00b5;
        L_0x00a7:
            r6 = r1.f35198h;
            r6 = r6.get();
            r6 = (org.reactivestreams.Subscription) r6;
            r7 = (long) r4;
            r6.request(r7);
            r8 = 0;
            goto L_0x00b6;
        L_0x00b5:
            r8 = r6;
        L_0x00b6:
            r7 = 1;
            goto L_0x0049;
        L_0x00b8:
            r0 = move-exception;
            io.reactivex.exceptions.Exceptions.m26521b(r0);
            r2 = r1.f35198h;
            io.reactivex.internal.subscriptions.SubscriptionHelper.m32777a(r2);
            r1.m35776a(r0);
            return;
        L_0x00c5:
            if (r12 != 0) goto L_0x00f5;
        L_0x00c7:
            r6 = r20.mo5627b();
            if (r6 == 0) goto L_0x00d1;
        L_0x00cd:
            r2.clear();
            return;
        L_0x00d1:
            r6 = r1.f35201k;
            if (r6 == 0) goto L_0x00e1;
        L_0x00d5:
            r7 = r1.f35197g;
            if (r7 != 0) goto L_0x00e1;
        L_0x00d9:
            r7 = r1.f35202l;
            if (r7 == 0) goto L_0x00e1;
        L_0x00dd:
            r1.m35776a(r7);
            return;
        L_0x00e1:
            if (r6 == 0) goto L_0x00f5;
        L_0x00e3:
            r6 = r2.isEmpty();
            if (r6 == 0) goto L_0x00f5;
        L_0x00e9:
            r2 = r1.f35202l;
            if (r2 == 0) goto L_0x00f1;
        L_0x00ed:
            r1.m35776a(r2);
            return;
        L_0x00f1:
            r20.m35777d();
            return;
        L_0x00f5:
            r6 = r9.length;
            r7 = 0;
        L_0x00f7:
            if (r7 >= r6) goto L_0x0101;
        L_0x00f9:
            r12 = r9[r7];
            io.reactivex.internal.util.BackpressureHelper.m26673c(r12, r10);
            r7 = r7 + 1;
            goto L_0x00f7;
        L_0x0101:
            r1.f35203m = r8;
            r6 = r1.f35193c;
            r3 = -r3;
            r3 = r6.addAndGet(r3);
            if (r3 == 0) goto L_0x0113;
        L_0x010c:
            if (r2 != 0) goto L_0x0110;
        L_0x010e:
            r2 = r1.f35199i;
        L_0x0110:
            r7 = 1;
            goto L_0x001b;
        L_0x0113:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowablePublishMulticast.MulticastProcessor.c():void");
        }

        private void m35776a(Throwable th) {
            for (MulticastSubscription multicastSubscription : (MulticastSubscription[]) this.f35194d.getAndSet(f35192b)) {
                if (multicastSubscription.get() != Long.MIN_VALUE) {
                    multicastSubscription.f31341a.onError(th);
                }
            }
        }

        private void m35777d() {
            for (MulticastSubscription multicastSubscription : (MulticastSubscription[]) this.f35194d.getAndSet(f35192b)) {
                if (multicastSubscription.get() != Long.MIN_VALUE) {
                    multicastSubscription.f31341a.onComplete();
                }
            }
        }
    }

    static final class OutputCanceller<R> implements FlowableSubscriber<R>, Subscription {
        final Subscriber<? super R> f35204a;
        final MulticastProcessor<?> f35205b;
        Subscription f35206c;

        OutputCanceller(Subscriber<? super R> subscriber, MulticastProcessor<?> multicastProcessor) {
            this.f35204a = subscriber;
            this.f35205b = multicastProcessor;
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32781a(this.f35206c, subscription)) {
                this.f35206c = subscription;
                this.f35204a.mo5623a(this);
            }
        }

        public final void onNext(R r) {
            this.f35204a.onNext(r);
        }

        public final void onError(Throwable th) {
            this.f35204a.onError(th);
            this.f35205b.mo5626a();
        }

        public final void onComplete() {
            this.f35204a.onComplete();
            this.f35205b.mo5626a();
        }

        public final void request(long j) {
            this.f35206c.request(j);
        }

        public final void cancel() {
            this.f35206c.cancel();
            this.f35205b.mo5626a();
        }
    }

    public FlowablePublishMulticast(Flowable<T> flowable, Function<? super Flowable<T>, ? extends Publisher<? extends R>> function, int i) {
        super(flowable);
        this.f37783a = function;
        this.f37784b = i;
    }

    protected final void subscribeActual(Subscriber<? super R> subscriber) {
        FlowableSubscriber multicastProcessor = new MulticastProcessor(this.f37784b, this.f37785c);
        try {
            ((Publisher) ObjectHelper.m26573a(this.f37783a.apply(multicastProcessor), "selector returned a null Publisher")).subscribe(new OutputCanceller(subscriber, multicastProcessor));
            this.source.subscribe(multicastProcessor);
        } catch (Throwable th) {
            Exceptions.m26521b(th);
            EmptySubscription.m38160a(th, subscriber);
        }
    }
}
