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
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableFlattenIterable<T, R> extends AbstractFlowableWithUpstream<T, R> {
    final Function<? super T, ? extends Iterable<? extends R>> f37734a;
    final int f37735b;

    static final class FlattenIterableSubscriber<T, R> extends BasicIntQueueSubscription<R> implements FlowableSubscriber<T> {
        final Subscriber<? super R> f39436a;
        final Function<? super T, ? extends Iterable<? extends R>> f39437b;
        final int f39438c;
        final int f39439d;
        final AtomicLong f39440e = new AtomicLong();
        Subscription f39441f;
        SimpleQueue<T> f39442g;
        volatile boolean f39443h;
        volatile boolean f39444i;
        final AtomicReference<Throwable> f39445j = new AtomicReference();
        Iterator<? extends R> f39446k;
        int f39447l;
        int f39448m;

        FlattenIterableSubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends Iterable<? extends R>> function, int i) {
            this.f39436a = subscriber;
            this.f39437b = function;
            this.f39438c = i;
            this.f39439d = i - (i >> 2);
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32781a(this.f39441f, subscription)) {
                this.f39441f = subscription;
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int a = queueSubscription.mo7033a(3);
                    if (a == 1) {
                        this.f39448m = a;
                        this.f39442g = queueSubscription;
                        this.f39443h = true;
                        this.f39436a.mo5623a(this);
                        return;
                    } else if (a == 2) {
                        this.f39448m = a;
                        this.f39442g = queueSubscription;
                        this.f39436a.mo5623a(this);
                        subscription.request((long) this.f39438c);
                        return;
                    }
                }
                this.f39442g = new SpscArrayQueue(this.f39438c);
                this.f39436a.mo5623a(this);
                subscription.request((long) this.f39438c);
            }
        }

        public final void onNext(T t) {
            if (!this.f39443h) {
                if (this.f39448m == 0 && this.f39442g.offer(t) == null) {
                    onError(new MissingBackpressureException("Queue is full?!"));
                } else {
                    m39660a();
                }
            }
        }

        public final void onError(Throwable th) {
            if (this.f39443h || !ExceptionHelper.m26684a(this.f39445j, th)) {
                RxJavaPlugins.m26757a(th);
                return;
            }
            this.f39443h = true;
            m39660a();
        }

        public final void onComplete() {
            if (!this.f39443h) {
                this.f39443h = true;
                m39660a();
            }
        }

        public final void request(long j) {
            if (SubscriptionHelper.m32776a(j)) {
                BackpressureHelper.m26670a(this.f39440e, j);
                m39660a();
            }
        }

        public final void cancel() {
            if (!this.f39444i) {
                this.f39444i = true;
                this.f39441f.cancel();
                if (getAndIncrement() == 0) {
                    this.f39442g.clear();
                }
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void m39660a() {
            /*
            r18 = this;
            r1 = r18;
            r2 = r18.getAndIncrement();
            if (r2 == 0) goto L_0x0009;
        L_0x0008:
            return;
        L_0x0009:
            r2 = r1.f39436a;
            r3 = r1.f39442g;
            r4 = r1.f39448m;
            r5 = 0;
            r6 = 1;
            if (r4 == r6) goto L_0x0015;
        L_0x0013:
            r4 = r6;
            goto L_0x0016;
        L_0x0015:
            r4 = r5;
        L_0x0016:
            r7 = r1.f39446k;
            r8 = 0;
            r9 = r6;
        L_0x001a:
            if (r7 != 0) goto L_0x0080;
        L_0x001c:
            r10 = r1.f39443h;
            r11 = r3.poll();	 Catch:{ Throwable -> 0x0063 }
            if (r11 != 0) goto L_0x0026;
        L_0x0024:
            r12 = r6;
            goto L_0x0027;
        L_0x0026:
            r12 = r5;
        L_0x0027:
            r10 = r1.m39662a(r10, r12, r2, r3);
            if (r10 == 0) goto L_0x002e;
        L_0x002d:
            return;
        L_0x002e:
            if (r11 == 0) goto L_0x0080;
        L_0x0030:
            r7 = r1.f39437b;	 Catch:{ Throwable -> 0x004a }
            r7 = r7.apply(r11);	 Catch:{ Throwable -> 0x004a }
            r7 = (java.lang.Iterable) r7;	 Catch:{ Throwable -> 0x004a }
            r7 = r7.iterator();	 Catch:{ Throwable -> 0x004a }
            r10 = r7.hasNext();	 Catch:{ Throwable -> 0x004a }
            if (r10 != 0) goto L_0x0047;
        L_0x0042:
            r1.m39661a(r4);
            r7 = r8;
            goto L_0x001a;
        L_0x0047:
            r1.f39446k = r7;
            goto L_0x0080;
        L_0x004a:
            r0 = move-exception;
            r3 = r0;
            io.reactivex.exceptions.Exceptions.m26521b(r3);
            r4 = r1.f39441f;
            r4.cancel();
            r4 = r1.f39445j;
            io.reactivex.internal.util.ExceptionHelper.m26684a(r4, r3);
            r3 = r1.f39445j;
            r3 = io.reactivex.internal.util.ExceptionHelper.m26683a(r3);
            r2.onError(r3);
            return;
        L_0x0063:
            r0 = move-exception;
            io.reactivex.exceptions.Exceptions.m26521b(r0);
            r4 = r1.f39441f;
            r4.cancel();
            r4 = r1.f39445j;
            io.reactivex.internal.util.ExceptionHelper.m26684a(r4, r0);
            r4 = r1.f39445j;
            r4 = io.reactivex.internal.util.ExceptionHelper.m26683a(r4);
            r1.f39446k = r8;
            r3.clear();
            r2.onError(r4);
            return;
        L_0x0080:
            if (r7 == 0) goto L_0x0123;
        L_0x0082:
            r10 = r1.f39440e;
            r10 = r10.get();
            r14 = 0;
        L_0x008a:
            r16 = (r14 > r10 ? 1 : (r14 == r10 ? 0 : -1));
            if (r16 == 0) goto L_0x00f4;
        L_0x008e:
            r6 = r1.f39443h;
            r6 = r1.m39662a(r6, r5, r2, r3);
            if (r6 == 0) goto L_0x0097;
        L_0x0096:
            return;
        L_0x0097:
            r6 = r7.next();	 Catch:{ Throwable -> 0x00d9 }
            r12 = "The iterator returned a null value";
            r6 = io.reactivex.internal.functions.ObjectHelper.m26573a(r6, r12);	 Catch:{ Throwable -> 0x00d9 }
            r2.onNext(r6);
            r6 = r1.f39443h;
            r6 = r1.m39662a(r6, r5, r2, r3);
            if (r6 == 0) goto L_0x00ad;
        L_0x00ac:
            return;
        L_0x00ad:
            r12 = 1;
            r14 = r14 + r12;
            r6 = r7.hasNext();	 Catch:{ Throwable -> 0x00bf }
            if (r6 != 0) goto L_0x00bd;
        L_0x00b6:
            r1.m39661a(r4);
            r1.f39446k = r8;
            r7 = r8;
            goto L_0x00f4;
        L_0x00bd:
            r6 = 1;
            goto L_0x008a;
        L_0x00bf:
            r0 = move-exception;
            io.reactivex.exceptions.Exceptions.m26521b(r0);
            r1.f39446k = r8;
            r3 = r1.f39441f;
            r3.cancel();
            r3 = r1.f39445j;
            io.reactivex.internal.util.ExceptionHelper.m26684a(r3, r0);
            r3 = r1.f39445j;
            r3 = io.reactivex.internal.util.ExceptionHelper.m26683a(r3);
            r2.onError(r3);
            return;
        L_0x00d9:
            r0 = move-exception;
            r3 = r0;
            io.reactivex.exceptions.Exceptions.m26521b(r3);
            r1.f39446k = r8;
            r4 = r1.f39441f;
            r4.cancel();
            r4 = r1.f39445j;
            io.reactivex.internal.util.ExceptionHelper.m26684a(r4, r3);
            r3 = r1.f39445j;
            r3 = io.reactivex.internal.util.ExceptionHelper.m26683a(r3);
            r2.onError(r3);
            return;
        L_0x00f4:
            r6 = (r14 > r10 ? 1 : (r14 == r10 ? 0 : -1));
            if (r6 != 0) goto L_0x010c;
        L_0x00f8:
            r6 = r1.f39443h;
            r12 = r3.isEmpty();
            if (r12 == 0) goto L_0x0104;
        L_0x0100:
            if (r7 != 0) goto L_0x0104;
        L_0x0102:
            r12 = 1;
            goto L_0x0105;
        L_0x0104:
            r12 = r5;
        L_0x0105:
            r6 = r1.m39662a(r6, r12, r2, r3);
            if (r6 == 0) goto L_0x010c;
        L_0x010b:
            return;
        L_0x010c:
            r12 = 0;
            r6 = (r14 > r12 ? 1 : (r14 == r12 ? 0 : -1));
            if (r6 == 0) goto L_0x0121;
        L_0x0112:
            r12 = 9223372036854775807; // 0x7fffffffffffffff float:NaN double:NaN;
            r6 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1));
            if (r6 == 0) goto L_0x0121;
        L_0x011b:
            r6 = r1.f39440e;
            r10 = -r14;
            r6.addAndGet(r10);
        L_0x0121:
            if (r7 == 0) goto L_0x012b;
        L_0x0123:
            r6 = -r9;
            r9 = r1.addAndGet(r6);
            if (r9 != 0) goto L_0x012b;
        L_0x012a:
            return;
        L_0x012b:
            r6 = 1;
            goto L_0x001a;
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableFlattenIterable.FlattenIterableSubscriber.a():void");
        }

        private void m39661a(boolean z) {
            if (z) {
                z = this.f39447l + 1;
                if (z == this.f39439d) {
                    this.f39447l = 0;
                    this.f39441f.request((long) z);
                    return;
                }
                this.f39447l = z;
            }
        }

        private boolean m39662a(boolean z, boolean z2, Subscriber<?> subscriber, SimpleQueue<?> simpleQueue) {
            if (this.f39444i) {
                this.f39446k = null;
                simpleQueue.clear();
                return true;
            }
            if (z) {
                if (((Throwable) this.f39445j.get()) != null) {
                    z = ExceptionHelper.m26683a(this.f39445j);
                    this.f39446k = null;
                    simpleQueue.clear();
                    subscriber.onError(z);
                    return true;
                } else if (z2) {
                    subscriber.onComplete();
                    return true;
                }
            }
            return false;
        }

        public final void clear() {
            this.f39446k = null;
            this.f39442g.clear();
        }

        public final boolean isEmpty() {
            Iterator it = this.f39446k;
            if (it == null) {
                return this.f39442g.isEmpty();
            }
            return !it.hasNext();
        }

        public final R poll() throws Exception {
            Iterator it = this.f39446k;
            while (it == null) {
                Object poll = this.f39442g.poll();
                if (poll != null) {
                    it = ((Iterable) this.f39437b.apply(poll)).iterator();
                    if (it.hasNext()) {
                        this.f39446k = it;
                        break;
                    }
                    it = null;
                } else {
                    return null;
                }
            }
            R a = ObjectHelper.m26573a(it.next(), "The iterator returned a null value");
            if (!it.hasNext()) {
                this.f39446k = null;
            }
            return a;
        }

        public final int mo7033a(int i) {
            return ((i & 1) == 0 || this.f39448m != 1) ? 0 : 1;
        }
    }

    public FlowableFlattenIterable(Flowable<T> flowable, Function<? super T, ? extends Iterable<? extends R>> function, int i) {
        super(flowable);
        this.f37734a = function;
        this.f37735b = i;
    }

    public final void subscribeActual(Subscriber<? super R> subscriber) {
        if (this.source instanceof Callable) {
            try {
                Object call = ((Callable) this.source).call();
                if (call == null) {
                    EmptySubscription.m38161a((Subscriber) subscriber);
                    return;
                }
                try {
                    FlowableFromIterable.m35733a(subscriber, ((Iterable) this.f37734a.apply(call)).iterator());
                    return;
                } catch (Throwable th) {
                    Exceptions.m26521b(th);
                    EmptySubscription.m38160a(th, subscriber);
                    return;
                }
            } catch (Throwable th2) {
                Exceptions.m26521b(th2);
                EmptySubscription.m38160a(th2, subscriber);
                return;
            }
        }
        this.source.subscribe(new FlattenIterableSubscriber(subscriber, this.f37734a, this.f37735b));
    }
}
