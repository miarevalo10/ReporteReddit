package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableBufferBoundary<T, U extends Collection<? super T>, Open, Close> extends AbstractFlowableWithUpstream<T, U> {
    final Callable<U> f37645a;
    final Publisher<? extends Open> f37646b;
    final Function<? super Open, ? extends Publisher<? extends Close>> f37647c;

    static final class BufferBoundarySubscriber<T, C extends Collection<? super T>, Open, Close> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        final Subscriber<? super C> f34849a;
        final Callable<C> f34850b;
        final Publisher<? extends Open> f34851c;
        final Function<? super Open, ? extends Publisher<? extends Close>> f34852d;
        final CompositeDisposable f34853e = new CompositeDisposable();
        final AtomicLong f34854f = new AtomicLong();
        final AtomicReference<Subscription> f34855g = new AtomicReference();
        final AtomicThrowable f34856h = new AtomicThrowable();
        volatile boolean f34857i;
        final SpscLinkedArrayQueue<C> f34858j = new SpscLinkedArrayQueue(Flowable.bufferSize());
        volatile boolean f34859k;
        long f34860l;
        Map<Long, C> f34861m = new LinkedHashMap();
        long f34862n;

        static final class BufferOpenSubscriber<Open> extends AtomicReference<Subscription> implements FlowableSubscriber<Open>, Disposable {
            final BufferBoundarySubscriber<?, ?, Open, ?> f34848a;

            BufferOpenSubscriber(BufferBoundarySubscriber<?, ?, Open, ?> bufferBoundarySubscriber) {
                this.f34848a = bufferBoundarySubscriber;
            }

            public final void mo5623a(Subscription subscription) {
                if (SubscriptionHelper.m32779a((AtomicReference) this, subscription)) {
                    subscription.request(Long.MAX_VALUE);
                }
            }

            public final void onNext(Open open) {
                BufferBoundarySubscriber bufferBoundarySubscriber = this.f34848a;
                try {
                    Collection collection = (Collection) ObjectHelper.m26573a(bufferBoundarySubscriber.f34850b.call(), "The bufferSupplier returned a null Collection");
                    Publisher publisher = (Publisher) ObjectHelper.m26573a(bufferBoundarySubscriber.f34852d.apply(open), "The bufferClose returned a null Publisher");
                    long j = bufferBoundarySubscriber.f34860l;
                    bufferBoundarySubscriber.f34860l = 1 + j;
                    synchronized (bufferBoundarySubscriber) {
                        Map map = bufferBoundarySubscriber.f34861m;
                        if (map == null) {
                            return;
                        }
                        map.put(Long.valueOf(j), collection);
                        Disposable bufferCloseSubscriber = new BufferCloseSubscriber(bufferBoundarySubscriber, j);
                        bufferBoundarySubscriber.f34853e.mo5631a(bufferCloseSubscriber);
                        publisher.subscribe(bufferCloseSubscriber);
                    }
                } catch (Open open2) {
                    Exceptions.m26521b(open2);
                    SubscriptionHelper.m32777a(bufferBoundarySubscriber.f34855g);
                    bufferBoundarySubscriber.onError(open2);
                }
            }

            public final void onError(Throwable th) {
                lazySet(SubscriptionHelper.f32454a);
                this.f34848a.m35653a((Disposable) this, th);
            }

            public final void onComplete() {
                lazySet(SubscriptionHelper.f32454a);
                BufferBoundarySubscriber bufferBoundarySubscriber = this.f34848a;
                bufferBoundarySubscriber.f34853e.mo5633c(this);
                if (bufferBoundarySubscriber.f34853e.m32079d() == 0) {
                    SubscriptionHelper.m32777a(bufferBoundarySubscriber.f34855g);
                    bufferBoundarySubscriber.f34857i = true;
                    bufferBoundarySubscriber.m35652a();
                }
            }

            public final void mo5626a() {
                SubscriptionHelper.m32777a((AtomicReference) this);
            }

            public final boolean mo5627b() {
                return get() == SubscriptionHelper.f32454a;
            }
        }

        BufferBoundarySubscriber(Subscriber<? super C> subscriber, Publisher<? extends Open> publisher, Function<? super Open, ? extends Publisher<? extends Close>> function, Callable<C> callable) {
            this.f34849a = subscriber;
            this.f34850b = callable;
            this.f34851c = publisher;
            this.f34852d = function;
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32779a(this.f34855g, subscription)) {
                Disposable bufferOpenSubscriber = new BufferOpenSubscriber(this);
                this.f34853e.mo5631a(bufferOpenSubscriber);
                this.f34851c.subscribe(bufferOpenSubscriber);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public final void onNext(T t) {
            synchronized (this) {
                Map map = this.f34861m;
                if (map == null) {
                    return;
                }
                for (Collection add : map.values()) {
                    add.add(t);
                }
            }
        }

        public final void onError(Throwable th) {
            if (ExceptionHelper.m26684a(this.f34856h, th)) {
                this.f34853e.mo5626a();
                synchronized (this) {
                    this.f34861m = null;
                }
                this.f34857i = true;
                m35652a();
                return;
            }
            RxJavaPlugins.m26757a(th);
        }

        public final void onComplete() {
            this.f34853e.mo5626a();
            synchronized (this) {
                Map map = this.f34861m;
                if (map == null) {
                    return;
                }
                for (Collection offer : map.values()) {
                    this.f34858j.offer(offer);
                }
                this.f34861m = null;
                this.f34857i = true;
                m35652a();
            }
        }

        public final void request(long j) {
            BackpressureHelper.m26670a(this.f34854f, j);
            m35652a();
        }

        public final void cancel() {
            if (SubscriptionHelper.m32777a(this.f34855g)) {
                this.f34859k = true;
                this.f34853e.mo5626a();
                synchronized (this) {
                    this.f34861m = null;
                }
                if (getAndIncrement() != 0) {
                    this.f34858j.clear();
                }
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        final void m35654a(io.reactivex.internal.operators.flowable.FlowableBufferBoundary.BufferCloseSubscriber<T, C> r4, long r5) {
            /*
            r3 = this;
            r0 = r3.f34853e;
            r0.mo5633c(r4);
            r4 = r3.f34853e;
            r4 = r4.m32079d();
            r0 = 1;
            if (r4 != 0) goto L_0x0015;
        L_0x000e:
            r4 = r3.f34855g;
            io.reactivex.internal.subscriptions.SubscriptionHelper.m32777a(r4);
            r4 = r0;
            goto L_0x0016;
        L_0x0015:
            r4 = 0;
        L_0x0016:
            monitor-enter(r3);
            r1 = r3.f34861m;	 Catch:{ all -> 0x0035 }
            if (r1 != 0) goto L_0x001d;
        L_0x001b:
            monitor-exit(r3);	 Catch:{ all -> 0x0035 }
            return;
        L_0x001d:
            r1 = r3.f34858j;	 Catch:{ all -> 0x0035 }
            r2 = r3.f34861m;	 Catch:{ all -> 0x0035 }
            r5 = java.lang.Long.valueOf(r5);	 Catch:{ all -> 0x0035 }
            r5 = r2.remove(r5);	 Catch:{ all -> 0x0035 }
            r1.offer(r5);	 Catch:{ all -> 0x0035 }
            monitor-exit(r3);	 Catch:{ all -> 0x0035 }
            if (r4 == 0) goto L_0x0031;
        L_0x002f:
            r3.f34857i = r0;
        L_0x0031:
            r3.m35652a();
            return;
        L_0x0035:
            r4 = move-exception;
            monitor-exit(r3);	 Catch:{ all -> 0x0035 }
            throw r4;
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableBufferBoundary.BufferBoundarySubscriber.a(io.reactivex.internal.operators.flowable.FlowableBufferBoundary$BufferCloseSubscriber, long):void");
        }

        final void m35653a(Disposable disposable, Throwable th) {
            SubscriptionHelper.m32777a(this.f34855g);
            this.f34853e.mo5633c(disposable);
            onError(th);
        }

        final void m35652a() {
            if (getAndIncrement() == 0) {
                long j = this.f34862n;
                Subscriber subscriber = this.f34849a;
                SpscLinkedArrayQueue spscLinkedArrayQueue = this.f34858j;
                int i = 1;
                do {
                    int i2;
                    long j2 = this.f34854f.get();
                    while (true) {
                        i2 = (j > j2 ? 1 : (j == j2 ? 0 : -1));
                        if (i2 == 0) {
                            break;
                        } else if (this.f34859k) {
                            spscLinkedArrayQueue.clear();
                            return;
                        } else {
                            boolean z = this.f34857i;
                            if (!z || this.f34856h.get() == null) {
                                Collection collection = (Collection) spscLinkedArrayQueue.poll();
                                Object obj = collection == null ? 1 : null;
                                if (!z || obj == null) {
                                    if (obj != null) {
                                        break;
                                    }
                                    subscriber.onNext(collection);
                                    j++;
                                } else {
                                    subscriber.onComplete();
                                    return;
                                }
                            }
                            spscLinkedArrayQueue.clear();
                            subscriber.onError(ExceptionHelper.m26683a(this.f34856h));
                            return;
                        }
                    }
                    if (i2 == 0) {
                        if (this.f34859k) {
                            spscLinkedArrayQueue.clear();
                            return;
                        } else if (this.f34857i) {
                            if (this.f34856h.get() != null) {
                                spscLinkedArrayQueue.clear();
                                subscriber.onError(ExceptionHelper.m26683a(this.f34856h));
                                return;
                            } else if (spscLinkedArrayQueue.isEmpty()) {
                                subscriber.onComplete();
                                return;
                            }
                        }
                    }
                    this.f34862n = j;
                    i = addAndGet(-i);
                } while (i != 0);
            }
        }
    }

    static final class BufferCloseSubscriber<T, C extends Collection<? super T>> extends AtomicReference<Subscription> implements FlowableSubscriber<Object>, Disposable {
        final BufferBoundarySubscriber<T, C, ?, ?> f34863a;
        final long f34864b;

        BufferCloseSubscriber(BufferBoundarySubscriber<T, C, ?, ?> bufferBoundarySubscriber, long j) {
            this.f34863a = bufferBoundarySubscriber;
            this.f34864b = j;
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32779a((AtomicReference) this, subscription)) {
                subscription.request(Long.MAX_VALUE);
            }
        }

        public final void onNext(Object obj) {
            Subscription subscription = (Subscription) get();
            if (subscription != SubscriptionHelper.f32454a) {
                lazySet(SubscriptionHelper.f32454a);
                subscription.cancel();
                this.f34863a.m35654a(this, this.f34864b);
            }
        }

        public final void onError(Throwable th) {
            if (get() != SubscriptionHelper.f32454a) {
                lazySet(SubscriptionHelper.f32454a);
                this.f34863a.m35653a((Disposable) this, th);
                return;
            }
            RxJavaPlugins.m26757a(th);
        }

        public final void onComplete() {
            if (get() != SubscriptionHelper.f32454a) {
                lazySet(SubscriptionHelper.f32454a);
                this.f34863a.m35654a(this, this.f34864b);
            }
        }

        public final void mo5626a() {
            SubscriptionHelper.m32777a((AtomicReference) this);
        }

        public final boolean mo5627b() {
            return get() == SubscriptionHelper.f32454a;
        }
    }

    public FlowableBufferBoundary(Flowable<T> flowable, Publisher<? extends Open> publisher, Function<? super Open, ? extends Publisher<? extends Close>> function, Callable<U> callable) {
        super(flowable);
        this.f37646b = publisher;
        this.f37647c = function;
        this.f37645a = callable;
    }

    protected final void subscribeActual(Subscriber<? super U> subscriber) {
        FlowableSubscriber bufferBoundarySubscriber = new BufferBoundarySubscriber(subscriber, this.f37646b, this.f37647c, this.f37645a);
        subscriber.mo5623a(bufferBoundarySubscriber);
        this.source.subscribe(bufferBoundarySubscriber);
    }
}
