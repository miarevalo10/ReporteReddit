package io.reactivex.internal.operators.flowable;

import com.reddit.datalibrary.frontpage.job.RedditJobManager;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscribers.InnerQueuedSubscriber;
import io.reactivex.internal.subscribers.InnerQueuedSubscriberSupport;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableConcatMapEager<T, R> extends AbstractFlowableWithUpstream<T, R> {
    final Function<? super T, ? extends Publisher<? extends R>> f37671a;
    final int f37672b;
    final int f37673c;
    final ErrorMode f37674d;

    static final class ConcatMapEagerDelayErrorSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, InnerQueuedSubscriberSupport<R>, Subscription {
        final Subscriber<? super R> f34913a;
        final Function<? super T, ? extends Publisher<? extends R>> f34914b;
        final int f34915c;
        final int f34916d;
        final ErrorMode f34917e;
        final AtomicThrowable f34918f = new AtomicThrowable();
        final AtomicLong f34919g = new AtomicLong();
        final SpscLinkedArrayQueue<InnerQueuedSubscriber<R>> f34920h;
        Subscription f34921i;
        volatile boolean f34922j;
        volatile boolean f34923k;
        volatile InnerQueuedSubscriber<R> f34924l;

        ConcatMapEagerDelayErrorSubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends Publisher<? extends R>> function, int i, int i2, ErrorMode errorMode) {
            this.f34913a = subscriber;
            this.f34914b = function;
            this.f34915c = i;
            this.f34916d = i2;
            this.f34917e = errorMode;
            this.f34920h = new SpscLinkedArrayQueue(Math.min(i2, i));
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32781a(this.f34921i, subscription)) {
                this.f34921i = subscription;
                this.f34913a.mo5623a(this);
                subscription.request(this.f34915c == RedditJobManager.f10810d ? Long.MAX_VALUE : (long) this.f34915c);
            }
        }

        public final void onNext(T t) {
            try {
                Publisher publisher = (Publisher) ObjectHelper.m26573a(this.f34914b.apply(t), "The mapper returned a null Publisher");
                Object innerQueuedSubscriber = new InnerQueuedSubscriber(this, this.f34916d);
                if (!this.f34922j) {
                    this.f34920h.offer(innerQueuedSubscriber);
                    if (!this.f34922j) {
                        publisher.subscribe(innerQueuedSubscriber);
                        if (this.f34922j != null) {
                            innerQueuedSubscriber.cancel();
                            m35672b();
                        }
                    }
                }
            } catch (T t2) {
                Exceptions.m26521b(t2);
                this.f34921i.cancel();
                onError(t2);
            }
        }

        public final void onError(Throwable th) {
            if (ExceptionHelper.m26684a(this.f34918f, th)) {
                this.f34923k = true;
                mo6619a();
                return;
            }
            RxJavaPlugins.m26757a(th);
        }

        public final void onComplete() {
            this.f34923k = true;
            mo6619a();
        }

        public final void cancel() {
            if (!this.f34922j) {
                this.f34922j = true;
                this.f34921i.cancel();
                m35672b();
            }
        }

        private void m35672b() {
            if (getAndIncrement() == 0) {
                do {
                    m35673c();
                } while (decrementAndGet() != 0);
            }
        }

        private void m35673c() {
            while (true) {
                InnerQueuedSubscriber innerQueuedSubscriber = (InnerQueuedSubscriber) this.f34920h.poll();
                if (innerQueuedSubscriber != null) {
                    innerQueuedSubscriber.cancel();
                } else {
                    return;
                }
            }
        }

        public final void request(long j) {
            if (SubscriptionHelper.m32776a(j)) {
                BackpressureHelper.m26670a(this.f34919g, j);
                mo6619a();
            }
        }

        public final void mo6622a(InnerQueuedSubscriber<R> innerQueuedSubscriber, Throwable th) {
            if (ExceptionHelper.m26684a(this.f34918f, th)) {
                innerQueuedSubscriber.f35918e = true;
                if (this.f34917e != ErrorMode.END) {
                    this.f34921i.cancel();
                }
                mo6619a();
                return;
            }
            RxJavaPlugins.m26757a(th);
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void mo6619a() {
            /*
            r20 = this;
            r1 = r20;
            r2 = r20.getAndIncrement();
            if (r2 == 0) goto L_0x0009;
        L_0x0008:
            return;
        L_0x0009:
            r2 = r1.f34924l;
            r3 = r1.f34913a;
            r4 = r1.f34917e;
            r6 = 1;
        L_0x0010:
            r7 = r1.f34919g;
            r7 = r7.get();
            if (r2 != 0) goto L_0x0056;
        L_0x0018:
            r2 = io.reactivex.internal.util.ErrorMode.END;
            if (r4 == r2) goto L_0x0033;
        L_0x001c:
            r2 = r1.f34918f;
            r2 = r2.get();
            r2 = (java.lang.Throwable) r2;
            if (r2 == 0) goto L_0x0033;
        L_0x0026:
            r20.m35673c();
            r2 = r1.f34918f;
            r2 = io.reactivex.internal.util.ExceptionHelper.m26683a(r2);
            r3.onError(r2);
            return;
        L_0x0033:
            r2 = r1.f34923k;
            r9 = r1.f34920h;
            r9 = r9.poll();
            r9 = (io.reactivex.internal.subscribers.InnerQueuedSubscriber) r9;
            if (r2 == 0) goto L_0x0051;
        L_0x003f:
            if (r9 != 0) goto L_0x0051;
        L_0x0041:
            r2 = r1.f34918f;
            r2 = io.reactivex.internal.util.ExceptionHelper.m26683a(r2);
            if (r2 == 0) goto L_0x004d;
        L_0x0049:
            r3.onError(r2);
            return;
        L_0x004d:
            r3.onComplete();
            return;
        L_0x0051:
            if (r9 == 0) goto L_0x0055;
        L_0x0053:
            r1.f34924l = r9;
        L_0x0055:
            r2 = r9;
        L_0x0056:
            r12 = 0;
            if (r2 == 0) goto L_0x0129;
        L_0x0059:
            r13 = r2.f35917d;
            if (r13 == 0) goto L_0x0129;
        L_0x005d:
            r14 = 0;
        L_0x005f:
            r16 = (r14 > r7 ? 1 : (r14 == r7 ? 0 : -1));
            r9 = 1;
            if (r16 == 0) goto L_0x00e0;
        L_0x0065:
            r11 = r1.f34922j;
            if (r11 == 0) goto L_0x006d;
        L_0x0069:
            r20.m35673c();
            return;
        L_0x006d:
            r11 = io.reactivex.internal.util.ErrorMode.IMMEDIATE;
            if (r4 != r11) goto L_0x008d;
        L_0x0071:
            r11 = r1.f34918f;
            r11 = r11.get();
            r11 = (java.lang.Throwable) r11;
            if (r11 == 0) goto L_0x008d;
        L_0x007b:
            r1.f34924l = r12;
            r2.cancel();
            r20.m35673c();
            r2 = r1.f34918f;
            r2 = io.reactivex.internal.util.ExceptionHelper.m26683a(r2);
            r3.onError(r2);
            return;
        L_0x008d:
            r11 = r2.f35918e;
            r5 = r13.poll();	 Catch:{ Throwable -> 0x00cf }
            if (r5 != 0) goto L_0x0098;
        L_0x0095:
            r18 = 1;
            goto L_0x009a;
        L_0x0098:
            r18 = 0;
        L_0x009a:
            if (r11 == 0) goto L_0x00a8;
        L_0x009c:
            if (r18 == 0) goto L_0x00a8;
        L_0x009e:
            r1.f34924l = r12;
            r2 = r1.f34921i;
            r2.request(r9);
            r2 = r12;
            r5 = 1;
            goto L_0x00e1;
        L_0x00a8:
            if (r18 != 0) goto L_0x00e0;
        L_0x00aa:
            r3.onNext(r5);
            r14 = r14 + r9;
            r5 = r2.f35920g;
            r11 = 1;
            if (r5 == r11) goto L_0x00cd;
        L_0x00b3:
            r11 = r2.f35919f;
            r11 = r11 + r9;
            r5 = r2.f35916c;
            r9 = (long) r5;
            r5 = (r11 > r9 ? 1 : (r11 == r9 ? 0 : -1));
            if (r5 != 0) goto L_0x00cb;
        L_0x00bd:
            r9 = 0;
            r2.f35919f = r9;
            r5 = r2.get();
            r5 = (org.reactivestreams.Subscription) r5;
            r5.request(r11);
            goto L_0x00cd;
        L_0x00cb:
            r2.f35919f = r11;
        L_0x00cd:
            r12 = 0;
            goto L_0x005f;
        L_0x00cf:
            r0 = move-exception;
            io.reactivex.exceptions.Exceptions.m26521b(r0);
            r4 = 0;
            r1.f34924l = r4;
            r2.cancel();
            r20.m35673c();
            r3.onError(r0);
            return;
        L_0x00e0:
            r5 = 0;
        L_0x00e1:
            if (r16 != 0) goto L_0x0124;
        L_0x00e3:
            r11 = r1.f34922j;
            if (r11 == 0) goto L_0x00eb;
        L_0x00e7:
            r20.m35673c();
            return;
        L_0x00eb:
            r11 = io.reactivex.internal.util.ErrorMode.IMMEDIATE;
            if (r4 != r11) goto L_0x010c;
        L_0x00ef:
            r11 = r1.f34918f;
            r11 = r11.get();
            r11 = (java.lang.Throwable) r11;
            if (r11 == 0) goto L_0x010c;
        L_0x00f9:
            r11 = 0;
            r1.f34924l = r11;
            r2.cancel();
            r20.m35673c();
            r2 = r1.f34918f;
            r2 = io.reactivex.internal.util.ExceptionHelper.m26683a(r2);
            r3.onError(r2);
            return;
        L_0x010c:
            r11 = r2.f35918e;
            r12 = r13.isEmpty();
            if (r11 == 0) goto L_0x0124;
        L_0x0114:
            if (r12 == 0) goto L_0x0124;
        L_0x0116:
            r11 = 0;
            r1.f34924l = r11;
            r2 = r1.f34921i;
            r2.request(r9);
            r2 = r11;
            r9 = 0;
            r17 = 1;
            goto L_0x012f;
        L_0x0124:
            r17 = r5;
            r9 = 0;
            goto L_0x012f;
        L_0x0129:
            r9 = 0;
            r14 = 0;
            r17 = 0;
        L_0x012f:
            r5 = (r14 > r9 ? 1 : (r14 == r9 ? 0 : -1));
            if (r5 == 0) goto L_0x0142;
        L_0x0133:
            r9 = 9223372036854775807; // 0x7fffffffffffffff float:NaN double:NaN;
            r5 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1));
            if (r5 == 0) goto L_0x0142;
        L_0x013c:
            r5 = r1.f34919g;
            r7 = -r14;
            r5.addAndGet(r7);
        L_0x0142:
            if (r17 != 0) goto L_0x0010;
        L_0x0144:
            r5 = -r6;
            r6 = r1.addAndGet(r5);
            if (r6 != 0) goto L_0x0010;
        L_0x014b:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableConcatMapEager.ConcatMapEagerDelayErrorSubscriber.a():void");
        }

        public final void mo6621a(InnerQueuedSubscriber<R> innerQueuedSubscriber, R r) {
            if (innerQueuedSubscriber.f35917d.offer(r) != null) {
                mo6619a();
                return;
            }
            innerQueuedSubscriber.cancel();
            mo6622a((InnerQueuedSubscriber) innerQueuedSubscriber, new MissingBackpressureException());
        }

        public final void mo6620a(InnerQueuedSubscriber<R> innerQueuedSubscriber) {
            innerQueuedSubscriber.f35918e = true;
            mo6619a();
        }
    }

    public FlowableConcatMapEager(Flowable<T> flowable, Function<? super T, ? extends Publisher<? extends R>> function, int i, int i2, ErrorMode errorMode) {
        super(flowable);
        this.f37671a = function;
        this.f37672b = i;
        this.f37673c = i2;
        this.f37674d = errorMode;
    }

    protected final void subscribeActual(Subscriber<? super R> subscriber) {
        this.source.subscribe(new ConcatMapEagerDelayErrorSubscriber(subscriber, this.f37671a, this.f37672b, this.f37673c, this.f37674d));
    }
}
