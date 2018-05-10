package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.flowables.ConnectableFlowable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableRefCount<T> extends AbstractFlowableWithUpstream<T, T> {
    final ConnectableFlowable<T> f37787a;
    volatile CompositeDisposable f37788b = new CompositeDisposable();
    final AtomicInteger f37789c = new AtomicInteger();
    final ReentrantLock f37790d = new ReentrantLock();

    final class DisposeTask implements Runnable {
        final /* synthetic */ FlowableRefCount f25069a;
        private final CompositeDisposable f25070b;

        DisposeTask(FlowableRefCount flowableRefCount, CompositeDisposable compositeDisposable) {
            this.f25069a = flowableRefCount;
            this.f25070b = compositeDisposable;
        }

        public final void run() {
            this.f25069a.f37790d.lock();
            try {
                if (this.f25069a.f37788b == this.f25070b && this.f25069a.f37789c.decrementAndGet() == 0) {
                    if (this.f25069a.f37787a instanceof Disposable) {
                        ((Disposable) this.f25069a.f37787a).mo5626a();
                    }
                    this.f25069a.f37788b.mo5626a();
                    this.f25069a.f37788b = new CompositeDisposable();
                }
                this.f25069a.f37790d.unlock();
            } catch (Throwable th) {
                this.f25069a.f37790d.unlock();
            }
        }
    }

    final class DisposeConsumer implements Consumer<Disposable> {
        final /* synthetic */ FlowableRefCount f31343a;
        private final Subscriber<? super T> f31344b;
        private final AtomicBoolean f31345c;

        public final /* synthetic */ void accept(Object obj) throws Exception {
            try {
                this.f31343a.f37788b.mo5631a((Disposable) obj);
                this.f31343a.m38109a(this.f31344b, this.f31343a.f37788b);
            } finally {
                this.f31343a.f37790d.unlock();
                this.f31345c.set(false);
            }
        }

        DisposeConsumer(FlowableRefCount flowableRefCount, Subscriber<? super T> subscriber, AtomicBoolean atomicBoolean) {
            this.f31343a = flowableRefCount;
            this.f31344b = subscriber;
            this.f31345c = atomicBoolean;
        }
    }

    final class ConnectionSubscriber extends AtomicReference<Subscription> implements FlowableSubscriber<T>, Subscription {
        final Subscriber<? super T> f35228a;
        final CompositeDisposable f35229b;
        final Disposable f35230c;
        final AtomicLong f35231d = new AtomicLong();
        final /* synthetic */ FlowableRefCount f35232e;

        ConnectionSubscriber(FlowableRefCount flowableRefCount, Subscriber<? super T> subscriber, CompositeDisposable compositeDisposable, Disposable disposable) {
            this.f35232e = flowableRefCount;
            this.f35228a = subscriber;
            this.f35229b = compositeDisposable;
            this.f35230c = disposable;
        }

        public final void mo5623a(Subscription subscription) {
            SubscriptionHelper.m32778a((AtomicReference) this, this.f35231d, subscription);
        }

        public final void onError(Throwable th) {
            m35791a();
            this.f35228a.onError(th);
        }

        public final void onNext(T t) {
            this.f35228a.onNext(t);
        }

        public final void onComplete() {
            m35791a();
            this.f35228a.onComplete();
        }

        public final void request(long j) {
            SubscriptionHelper.m32775a((AtomicReference) this, this.f35231d, j);
        }

        public final void cancel() {
            SubscriptionHelper.m32777a((AtomicReference) this);
            this.f35230c.mo5626a();
        }

        private void m35791a() {
            this.f35232e.f37790d.lock();
            try {
                if (this.f35232e.f37788b == this.f35229b) {
                    if (this.f35232e.f37787a instanceof Disposable) {
                        ((Disposable) this.f35232e.f37787a).mo5626a();
                    }
                    this.f35232e.f37788b.mo5626a();
                    this.f35232e.f37788b = new CompositeDisposable();
                    this.f35232e.f37789c.set(0);
                }
                this.f35232e.f37790d.unlock();
            } catch (Throwable th) {
                this.f35232e.f37790d.unlock();
            }
        }
    }

    public final void subscribeActual(org.reactivestreams.Subscriber<? super T> r4) {
        /* JADX: method processing error */
/*
Error: java.util.NoSuchElementException
	at java.util.HashMap$HashIterator.nextNode(HashMap.java:1431)
	at java.util.HashMap$KeyIterator.next(HashMap.java:1453)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.applyRemove(BlockFinallyExtract.java:535)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.extractFinally(BlockFinallyExtract.java:175)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.processExceptionHandler(BlockFinallyExtract.java:79)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:51)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r3 = this;
        r0 = r3.f37790d;
        r0.lock();
        r0 = r3.f37789c;
        r0 = r0.incrementAndGet();
        r1 = 1;
        if (r0 != r1) goto L_0x0037;
    L_0x000e:
        r0 = new java.util.concurrent.atomic.AtomicBoolean;
        r0.<init>(r1);
        r1 = r3.f37787a;	 Catch:{ all -> 0x002a }
        r2 = new io.reactivex.internal.operators.flowable.FlowableRefCount$DisposeConsumer;	 Catch:{ all -> 0x002a }
        r2.<init>(r3, r4, r0);	 Catch:{ all -> 0x002a }
        r1.mo7047a(r2);	 Catch:{ all -> 0x002a }
        r4 = r0.get();
        if (r4 == 0) goto L_0x0029;
    L_0x0023:
        r4 = r3.f37790d;
        r4.unlock();
        return;
    L_0x0029:
        return;
    L_0x002a:
        r4 = move-exception;
        r0 = r0.get();
        if (r0 == 0) goto L_0x0036;
    L_0x0031:
        r0 = r3.f37790d;
        r0.unlock();
    L_0x0036:
        throw r4;
    L_0x0037:
        r0 = r3.f37788b;	 Catch:{ all -> 0x0042 }
        r3.m38109a(r4, r0);	 Catch:{ all -> 0x0042 }
        r4 = r3.f37790d;
        r4.unlock();
        return;
    L_0x0042:
        r4 = move-exception;
        r0 = r3.f37790d;
        r0.unlock();
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableRefCount.subscribeActual(org.reactivestreams.Subscriber):void");
    }

    public FlowableRefCount(ConnectableFlowable<T> connectableFlowable) {
        super(connectableFlowable);
        this.f37787a = connectableFlowable;
    }

    final void m38109a(Subscriber<? super T> subscriber, CompositeDisposable compositeDisposable) {
        Object connectionSubscriber = new ConnectionSubscriber(this, subscriber, compositeDisposable, Disposables.m26513a(new DisposeTask(this, compositeDisposable)));
        subscriber.mo5623a(connectionSubscriber);
        this.f37787a.subscribe((FlowableSubscriber) connectionSubscriber);
    }
}
