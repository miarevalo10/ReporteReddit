package io.reactivex.internal.operators.flowable;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableCreate<T> extends Flowable<T> {
    final FlowableOnSubscribe<T> f34944a;
    final BackpressureStrategy f34945b;

    static abstract class BaseEmitter<T> extends AtomicLong implements FlowableEmitter<T>, Subscription {
        final Subscriber<? super T> f34942a;
        final SequentialDisposable f34943b = new SequentialDisposable();

        void mo7044c() {
        }

        void mo7045d() {
        }

        BaseEmitter(Subscriber<? super T> subscriber) {
            this.f34942a = subscriber;
        }

        public void aA_() {
            m35686b();
        }

        public final void mo5642a(Throwable th) {
            if (!mo7043b(th)) {
                RxJavaPlugins.m26757a(th);
            }
        }

        public boolean mo7043b(Throwable th) {
            return m35689c(th);
        }

        protected final boolean m35689c(Throwable th) {
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            if (this.f34943b.mo5627b()) {
                return null;
            }
            try {
                this.f34942a.onError(th);
                return true;
            } finally {
                this.f34943b.mo5626a();
            }
        }

        public final void cancel() {
            this.f34943b.mo5626a();
            mo7044c();
        }

        public final void request(long j) {
            if (SubscriptionHelper.m32776a(j)) {
                BackpressureHelper.m26670a((AtomicLong) this, j);
                mo7045d();
            }
        }

        public final void mo6623a(Disposable disposable) {
            DisposableHelper.m32091a(this.f34943b, disposable);
        }

        protected final void m35686b() {
            if (!this.f34943b.mo5627b()) {
                try {
                    this.f34942a.onComplete();
                } finally {
                    this.f34943b.mo5626a();
                }
            }
        }
    }

    static final class BufferAsyncEmitter<T> extends BaseEmitter<T> {
        final SpscLinkedArrayQueue<T> f37683c;
        Throwable f37684d;
        volatile boolean f37685e;
        final AtomicInteger f37686f = new AtomicInteger();

        BufferAsyncEmitter(Subscriber<? super T> subscriber, int i) {
            super(subscriber);
            this.f37683c = new SpscLinkedArrayQueue(i);
        }

        public final void mo5641a(T t) {
            if (!this.f37685e) {
                if (!this.f34943b.mo5627b()) {
                    if (t == null) {
                        mo5642a((Throwable) new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                        return;
                    }
                    this.f37683c.offer(t);
                    m38087e();
                }
            }
        }

        public final boolean mo7043b(Throwable th) {
            if (!this.f37685e) {
                if (!this.f34943b.mo5627b()) {
                    if (th == null) {
                        th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
                    }
                    this.f37684d = th;
                    this.f37685e = true;
                    m38087e();
                    return true;
                }
            }
            return null;
        }

        public final void aA_() {
            this.f37685e = true;
            m38087e();
        }

        final void mo7045d() {
            m38087e();
        }

        final void mo7044c() {
            if (this.f37686f.getAndIncrement() == 0) {
                this.f37683c.clear();
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void m38087e() {
            /*
            r14 = this;
            r0 = r14.f37686f;
            r0 = r0.getAndIncrement();
            if (r0 == 0) goto L_0x0009;
        L_0x0008:
            return;
        L_0x0009:
            r0 = r14.a;
            r1 = r14.f37683c;
            r2 = 1;
            r3 = r2;
        L_0x000f:
            r4 = r14.get();
            r6 = 0;
            r8 = r6;
        L_0x0016:
            r10 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1));
            if (r10 == 0) goto L_0x004a;
        L_0x001a:
            r11 = r14.f34943b;
            r11 = r11.mo5627b();
            if (r11 == 0) goto L_0x0026;
        L_0x0022:
            r1.clear();
            return;
        L_0x0026:
            r11 = r14.f37685e;
            r12 = r1.poll();
            if (r12 != 0) goto L_0x0030;
        L_0x002e:
            r13 = r2;
            goto L_0x0031;
        L_0x0030:
            r13 = 0;
        L_0x0031:
            if (r11 == 0) goto L_0x0041;
        L_0x0033:
            if (r13 == 0) goto L_0x0041;
        L_0x0035:
            r0 = r14.f37684d;
            if (r0 == 0) goto L_0x003d;
        L_0x0039:
            r14.m35689c(r0);
            return;
        L_0x003d:
            r14.m35686b();
            return;
        L_0x0041:
            if (r13 != 0) goto L_0x004a;
        L_0x0043:
            r0.onNext(r12);
            r10 = 1;
            r8 = r8 + r10;
            goto L_0x0016;
        L_0x004a:
            if (r10 != 0) goto L_0x006e;
        L_0x004c:
            r4 = r14.f34943b;
            r4 = r4.mo5627b();
            if (r4 == 0) goto L_0x0058;
        L_0x0054:
            r1.clear();
            return;
        L_0x0058:
            r4 = r14.f37685e;
            r5 = r1.isEmpty();
            if (r4 == 0) goto L_0x006e;
        L_0x0060:
            if (r5 == 0) goto L_0x006e;
        L_0x0062:
            r0 = r14.f37684d;
            if (r0 == 0) goto L_0x006a;
        L_0x0066:
            r14.m35689c(r0);
            return;
        L_0x006a:
            r14.m35686b();
            return;
        L_0x006e:
            r4 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1));
            if (r4 == 0) goto L_0x0075;
        L_0x0072:
            io.reactivex.internal.util.BackpressureHelper.m26673c(r14, r8);
        L_0x0075:
            r4 = r14.f37686f;
            r3 = -r3;
            r3 = r4.addAndGet(r3);
            if (r3 != 0) goto L_0x000f;
        L_0x007e:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableCreate.BufferAsyncEmitter.e():void");
        }
    }

    static final class LatestAsyncEmitter<T> extends BaseEmitter<T> {
        final AtomicReference<T> f37687c = new AtomicReference();
        Throwable f37688d;
        volatile boolean f37689e;
        final AtomicInteger f37690f = new AtomicInteger();

        LatestAsyncEmitter(Subscriber<? super T> subscriber) {
            super(subscriber);
        }

        public final void mo5641a(T t) {
            if (!this.f37689e) {
                if (!this.f34943b.mo5627b()) {
                    if (t == null) {
                        mo5642a((Throwable) new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                        return;
                    }
                    this.f37687c.set(t);
                    m38092e();
                }
            }
        }

        public final boolean mo7043b(Throwable th) {
            if (!this.f37689e) {
                if (!this.f34943b.mo5627b()) {
                    if (th == null) {
                        mo5642a(new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources."));
                    }
                    this.f37688d = th;
                    this.f37689e = true;
                    m38092e();
                    return true;
                }
            }
            return null;
        }

        public final void aA_() {
            this.f37689e = true;
            m38092e();
        }

        final void mo7045d() {
            m38092e();
        }

        final void mo7044c() {
            if (this.f37690f.getAndIncrement() == 0) {
                this.f37687c.lazySet(null);
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void m38092e() {
            /*
            r17 = this;
            r0 = r17;
            r1 = r0.f37690f;
            r1 = r1.getAndIncrement();
            if (r1 == 0) goto L_0x000b;
        L_0x000a:
            return;
        L_0x000b:
            r1 = r0.a;
            r2 = r0.f37687c;
            r3 = 1;
            r4 = r3;
        L_0x0011:
            r5 = r17.get();
            r7 = 0;
            r9 = r7;
        L_0x0018:
            r11 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1));
            r12 = 0;
            r13 = 0;
            if (r11 == 0) goto L_0x0050;
        L_0x001e:
            r14 = r0.f34943b;
            r14 = r14.mo5627b();
            if (r14 == 0) goto L_0x002a;
        L_0x0026:
            r2.lazySet(r13);
            return;
        L_0x002a:
            r14 = r0.f37689e;
            r15 = r2.getAndSet(r13);
            if (r15 != 0) goto L_0x0035;
        L_0x0032:
            r16 = r3;
            goto L_0x0037;
        L_0x0035:
            r16 = r12;
        L_0x0037:
            if (r14 == 0) goto L_0x0047;
        L_0x0039:
            if (r16 == 0) goto L_0x0047;
        L_0x003b:
            r1 = r0.f37688d;
            if (r1 == 0) goto L_0x0043;
        L_0x003f:
            r0.m35689c(r1);
            return;
        L_0x0043:
            r17.m35686b();
            return;
        L_0x0047:
            if (r16 != 0) goto L_0x0050;
        L_0x0049:
            r1.onNext(r15);
            r11 = 1;
            r9 = r9 + r11;
            goto L_0x0018;
        L_0x0050:
            if (r11 != 0) goto L_0x0077;
        L_0x0052:
            r5 = r0.f34943b;
            r5 = r5.mo5627b();
            if (r5 == 0) goto L_0x005e;
        L_0x005a:
            r2.lazySet(r13);
            return;
        L_0x005e:
            r5 = r0.f37689e;
            r6 = r2.get();
            if (r6 != 0) goto L_0x0067;
        L_0x0066:
            r12 = r3;
        L_0x0067:
            if (r5 == 0) goto L_0x0077;
        L_0x0069:
            if (r12 == 0) goto L_0x0077;
        L_0x006b:
            r1 = r0.f37688d;
            if (r1 == 0) goto L_0x0073;
        L_0x006f:
            r0.m35689c(r1);
            return;
        L_0x0073:
            r17.m35686b();
            return;
        L_0x0077:
            r5 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1));
            if (r5 == 0) goto L_0x007e;
        L_0x007b:
            io.reactivex.internal.util.BackpressureHelper.m26673c(r0, r9);
        L_0x007e:
            r5 = r0.f37690f;
            r4 = -r4;
            r4 = r5.addAndGet(r4);
            if (r4 != 0) goto L_0x0011;
        L_0x0087:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableCreate.LatestAsyncEmitter.e():void");
        }
    }

    static final class MissingEmitter<T> extends BaseEmitter<T> {
        MissingEmitter(Subscriber<? super T> subscriber) {
            super(subscriber);
        }

        public final void mo5641a(T t) {
            if (!this.f34943b.mo5627b()) {
                if (t != null) {
                    this.a.onNext(t);
                    long j;
                    do {
                        j = get();
                        if (j == 0) {
                            break;
                        }
                    } while (compareAndSet(j, j - 1) == null);
                    return;
                }
                mo5642a((Throwable) new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            }
        }
    }

    static abstract class NoOverflowBaseAsyncEmitter<T> extends BaseEmitter<T> {
        abstract void mo7252e();

        NoOverflowBaseAsyncEmitter(Subscriber<? super T> subscriber) {
            super(subscriber);
        }

        public final void mo5641a(T t) {
            if (!this.f34943b.mo5627b()) {
                if (t == null) {
                    mo5642a((Throwable) new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                } else if (get() != 0) {
                    this.a.onNext(t);
                    BackpressureHelper.m26673c(this, 1);
                } else {
                    mo7252e();
                }
            }
        }
    }

    static final class DropAsyncEmitter<T> extends NoOverflowBaseAsyncEmitter<T> {
        final void mo7252e() {
        }

        DropAsyncEmitter(Subscriber<? super T> subscriber) {
            super(subscriber);
        }
    }

    static final class ErrorAsyncEmitter<T> extends NoOverflowBaseAsyncEmitter<T> {
        ErrorAsyncEmitter(Subscriber<? super T> subscriber) {
            super(subscriber);
        }

        final void mo7252e() {
            mo5642a(new MissingBackpressureException("create: could not emit value due to lack of requests"));
        }
    }

    public FlowableCreate(FlowableOnSubscribe<T> flowableOnSubscribe, BackpressureStrategy backpressureStrategy) {
        this.f34944a = flowableOnSubscribe;
        this.f34945b = backpressureStrategy;
    }

    public final void subscribeActual(Subscriber<? super T> subscriber) {
        BaseEmitter missingEmitter;
        switch (this.f34945b) {
            case MISSING:
                missingEmitter = new MissingEmitter(subscriber);
                break;
            case ERROR:
                missingEmitter = new ErrorAsyncEmitter(subscriber);
                break;
            case DROP:
                missingEmitter = new DropAsyncEmitter(subscriber);
                break;
            case LATEST:
                missingEmitter = new LatestAsyncEmitter(subscriber);
                break;
            default:
                missingEmitter = new BufferAsyncEmitter(subscriber, Flowable.bufferSize());
                break;
        }
        subscriber.mo5623a(missingEmitter);
        try {
            this.f34944a.subscribe(missingEmitter);
        } catch (Throwable th) {
            Exceptions.m26521b(th);
            missingEmitter.mo5642a(th);
        }
    }
}
