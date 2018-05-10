package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscribers.QueueDrainSubscriber;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subscribers.DisposableSubscriber;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableBufferBoundarySupplier<T, U extends Collection<? super T>, B> extends AbstractFlowableWithUpstream<T, U> {
    final Callable<? extends Publisher<B>> f37650a;
    final Callable<U> f37651b;

    static final class BufferBoundarySubscriber<T, U extends Collection<? super T>, B> extends DisposableSubscriber<B> {
        final BufferBoundarySupplierSubscriber<T, U, B> f37648a;
        boolean f37649b;

        BufferBoundarySubscriber(BufferBoundarySupplierSubscriber<T, U, B> bufferBoundarySupplierSubscriber) {
            this.f37648a = bufferBoundarySupplierSubscriber;
        }

        public final void onNext(B b) {
            if (this.f37649b == null) {
                this.f37649b = true;
                m36032d();
                this.f37648a.m42330c();
            }
        }

        public final void onError(Throwable th) {
            if (this.f37649b) {
                RxJavaPlugins.m26757a(th);
                return;
            }
            this.f37649b = true;
            this.f37648a.onError(th);
        }

        public final void onComplete() {
            if (!this.f37649b) {
                this.f37649b = true;
                this.f37648a.m42330c();
            }
        }
    }

    static final class BufferBoundarySupplierSubscriber<T, U extends Collection<? super T>, B> extends QueueDrainSubscriber<T, U, U> implements FlowableSubscriber<T>, Disposable, Subscription {
        final Callable<U> f40629a;
        final Callable<? extends Publisher<B>> f40630b;
        Subscription f40631c;
        final AtomicReference<Disposable> f40632d = new AtomicReference();
        U f40633e;

        public final /* synthetic */ boolean mo7603a(Subscriber subscriber, Object obj) {
            this.n.onNext((Collection) obj);
            return true;
        }

        BufferBoundarySupplierSubscriber(Subscriber<? super U> subscriber, Callable<U> callable, Callable<? extends Publisher<B>> callable2) {
            super(subscriber, new MpscLinkedQueue());
            this.f40629a = callable;
            this.f40630b = callable2;
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32781a(this.f40631c, subscription)) {
                this.f40631c = subscription;
                Subscriber subscriber = this.n;
                try {
                    this.f40633e = (Collection) ObjectHelper.m26573a(this.f40629a.call(), "The buffer supplied is null");
                    try {
                        Publisher publisher = (Publisher) ObjectHelper.m26573a(this.f40630b.call(), "The boundary publisher supplied is null");
                        Subscriber bufferBoundarySubscriber = new BufferBoundarySubscriber(this);
                        this.f40632d.set(bufferBoundarySubscriber);
                        subscriber.mo5623a(this);
                        if (!this.p) {
                            subscription.request(Long.MAX_VALUE);
                            publisher.subscribe(bufferBoundarySubscriber);
                        }
                    } catch (Throwable th) {
                        Exceptions.m26521b(th);
                        this.p = true;
                        subscription.cancel();
                        EmptySubscription.m38160a(th, subscriber);
                    }
                } catch (Throwable th2) {
                    Exceptions.m26521b(th2);
                    this.p = true;
                    subscription.cancel();
                    EmptySubscription.m38160a(th2, subscriber);
                }
            }
        }

        public final void onNext(T t) {
            synchronized (this) {
                Collection collection = this.f40633e;
                if (collection == null) {
                    return;
                }
                collection.add(t);
            }
        }

        public final void onError(Throwable th) {
            cancel();
            this.n.onError(th);
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onComplete() {
            /*
            r2 = this;
            monitor-enter(r2);
            r0 = r2.f40633e;	 Catch:{ all -> 0x0021 }
            if (r0 != 0) goto L_0x0007;
        L_0x0005:
            monitor-exit(r2);	 Catch:{ all -> 0x0021 }
            return;
        L_0x0007:
            r1 = 0;
            r2.f40633e = r1;	 Catch:{ all -> 0x0021 }
            monitor-exit(r2);	 Catch:{ all -> 0x0021 }
            r1 = r2.o;
            r1.offer(r0);
            r0 = 1;
            r2.q = r0;
            r0 = r2.m41404f();
            if (r0 == 0) goto L_0x0020;
        L_0x0019:
            r0 = r2.o;
            r1 = r2.n;
            io.reactivex.internal.util.QueueDrainHelper.m26727a(r0, r1, r2, r2);
        L_0x0020:
            return;
        L_0x0021:
            r0 = move-exception;
            monitor-exit(r2);	 Catch:{ all -> 0x0021 }
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableBufferBoundarySupplier.BufferBoundarySupplierSubscriber.onComplete():void");
        }

        public final void request(long j) {
            m41398a(j);
        }

        public final void cancel() {
            if (!this.p) {
                this.p = true;
                this.f40631c.cancel();
                m42325k();
                if (m41404f()) {
                    this.o.clear();
                }
            }
        }

        private void m42325k() {
            DisposableHelper.m32090a(this.f40632d);
        }

        final void m42330c() {
            try {
                Collection collection = (Collection) ObjectHelper.m26573a(this.f40629a.call(), "The buffer supplied is null");
                try {
                    Publisher publisher = (Publisher) ObjectHelper.m26573a(this.f40630b.call(), "The boundary publisher supplied is null");
                    Subscriber bufferBoundarySubscriber = new BufferBoundarySubscriber(this);
                    if (this.f40632d.compareAndSet((Disposable) this.f40632d.get(), bufferBoundarySubscriber)) {
                        synchronized (this) {
                            Collection collection2 = this.f40633e;
                            if (collection2 == null) {
                                return;
                            }
                            this.f40633e = collection;
                            publisher.subscribe(bufferBoundarySubscriber);
                            m41399a((Object) collection2, (Disposable) this);
                        }
                    }
                } catch (Throwable th) {
                    Exceptions.m26521b(th);
                    this.p = true;
                    this.f40631c.cancel();
                    this.n.onError(th);
                }
            } catch (Throwable th2) {
                Exceptions.m26521b(th2);
                cancel();
                this.n.onError(th2);
            }
        }

        public final void mo5626a() {
            this.f40631c.cancel();
            m42325k();
        }

        public final boolean mo5627b() {
            return this.f40632d.get() == DisposableHelper.f31095a;
        }
    }

    public FlowableBufferBoundarySupplier(Flowable<T> flowable, Callable<? extends Publisher<B>> callable, Callable<U> callable2) {
        super(flowable);
        this.f37650a = callable;
        this.f37651b = callable2;
    }

    protected final void subscribeActual(Subscriber<? super U> subscriber) {
        this.source.subscribe(new BufferBoundarySupplierSubscriber(new SerializedSubscriber(subscriber), this.f37651b, this.f37650a));
    }
}
