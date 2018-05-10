package io.reactivex.internal.operators.flowable;

import com.reddit.datalibrary.frontpage.job.RedditJobManager;
import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.Scheduler.Worker;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscribers.QueueDrainSubscriber;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.QueueDrain;
import io.reactivex.internal.util.QueueDrainHelper;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableBufferTimed<T, U extends Collection<? super T>> extends AbstractFlowableWithUpstream<T, U> {
    final long f37655a;
    final long f37656b;
    final TimeUnit f37657c;
    final Scheduler f37658d;
    final Callable<U> f37659e;
    final int f37660f;
    final boolean f37661g;

    static final class BufferExactBoundedSubscriber<T, U extends Collection<? super T>> extends QueueDrainSubscriber<T, U, U> implements Disposable, Runnable, Subscription {
        final Callable<U> f40639a;
        final long f40640b;
        final TimeUnit f40641c;
        final int f40642d;
        final boolean f40643e;
        final Worker f40644f;
        U f40645g;
        Disposable f40646h;
        Subscription f40647i;
        long f40648j;
        long f40649k;

        public final /* synthetic */ boolean mo7603a(Subscriber subscriber, Object obj) {
            subscriber.onNext((Collection) obj);
            return true;
        }

        BufferExactBoundedSubscriber(Subscriber<? super U> subscriber, Callable<U> callable, long j, TimeUnit timeUnit, int i, boolean z, Worker worker) {
            super(subscriber, new MpscLinkedQueue());
            this.f40639a = callable;
            this.f40640b = j;
            this.f40641c = timeUnit;
            this.f40642d = i;
            this.f40643e = z;
            this.f40644f = worker;
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32781a(this.f40647i, subscription)) {
                this.f40647i = subscription;
                try {
                    this.f40645g = (Collection) ObjectHelper.m26573a(this.f40639a.call(), "The supplied buffer is null");
                    this.n.mo5623a(this);
                    this.f40646h = this.f40644f.mo6652a(this, this.f40640b, this.f40640b, this.f40641c);
                    subscription.request(Long.MAX_VALUE);
                } catch (Throwable th) {
                    Exceptions.m26521b(th);
                    this.f40644f.mo5626a();
                    subscription.cancel();
                    EmptySubscription.m38160a(th, this.n);
                }
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onNext(T r8) {
            /*
            r7 = this;
            monitor-enter(r7);
            r0 = r7.f40645g;	 Catch:{ all -> 0x0066 }
            if (r0 != 0) goto L_0x0007;
        L_0x0005:
            monitor-exit(r7);	 Catch:{ all -> 0x0066 }
            return;
        L_0x0007:
            r0.add(r8);	 Catch:{ all -> 0x0066 }
            r8 = r0.size();	 Catch:{ all -> 0x0066 }
            r1 = r7.f40642d;	 Catch:{ all -> 0x0066 }
            if (r8 >= r1) goto L_0x0014;
        L_0x0012:
            monitor-exit(r7);	 Catch:{ all -> 0x0066 }
            return;
        L_0x0014:
            r8 = 0;
            r7.f40645g = r8;	 Catch:{ all -> 0x0066 }
            r1 = r7.f40648j;	 Catch:{ all -> 0x0066 }
            r3 = 1;
            r1 = r1 + r3;
            r7.f40648j = r1;	 Catch:{ all -> 0x0066 }
            monitor-exit(r7);	 Catch:{ all -> 0x0066 }
            r8 = r7.f40643e;
            if (r8 == 0) goto L_0x0028;
        L_0x0023:
            r8 = r7.f40646h;
            r8.mo5626a();
        L_0x0028:
            r7.m41401b(r0, r7);
            r8 = r7.f40639a;	 Catch:{ Throwable -> 0x0059 }
            r8 = r8.call();	 Catch:{ Throwable -> 0x0059 }
            r0 = "The supplied buffer is null";
            r8 = io.reactivex.internal.functions.ObjectHelper.m26573a(r8, r0);	 Catch:{ Throwable -> 0x0059 }
            r8 = (java.util.Collection) r8;	 Catch:{ Throwable -> 0x0059 }
            monitor-enter(r7);
            r7.f40645g = r8;	 Catch:{ all -> 0x0056 }
            r0 = r7.f40649k;	 Catch:{ all -> 0x0056 }
            r0 = r0 + r3;
            r7.f40649k = r0;	 Catch:{ all -> 0x0056 }
            monitor-exit(r7);	 Catch:{ all -> 0x0056 }
            r8 = r7.f40643e;
            if (r8 == 0) goto L_0x0055;
        L_0x0046:
            r0 = r7.f40644f;
            r2 = r7.f40640b;
            r4 = r7.f40640b;
            r6 = r7.f40641c;
            r1 = r7;
            r8 = r0.mo6652a(r1, r2, r4, r6);
            r7.f40646h = r8;
        L_0x0055:
            return;
        L_0x0056:
            r8 = move-exception;
            monitor-exit(r7);	 Catch:{ all -> 0x0056 }
            throw r8;
        L_0x0059:
            r8 = move-exception;
            io.reactivex.exceptions.Exceptions.m26521b(r8);
            r7.cancel();
            r0 = r7.n;
            r0.onError(r8);
            return;
        L_0x0066:
            r8 = move-exception;
            monitor-exit(r7);	 Catch:{ all -> 0x0066 }
            throw r8;
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableBufferTimed.BufferExactBoundedSubscriber.onNext(java.lang.Object):void");
        }

        public final void onError(Throwable th) {
            synchronized (this) {
                this.f40645g = null;
            }
            this.n.onError(th);
            this.f40644f.mo5626a();
        }

        public final void onComplete() {
            Collection collection;
            synchronized (this) {
                collection = this.f40645g;
                this.f40645g = null;
            }
            this.o.offer(collection);
            this.q = true;
            if (m41404f()) {
                QueueDrainHelper.m26727a(this.o, this.n, (Disposable) this, (QueueDrain) this);
            }
            this.f40644f.mo5626a();
        }

        public final void request(long j) {
            m41398a(j);
        }

        public final void cancel() {
            if (!this.p) {
                this.p = true;
                mo5626a();
            }
        }

        public final void mo5626a() {
            synchronized (this) {
                this.f40645g = null;
            }
            this.f40647i.cancel();
            this.f40644f.mo5626a();
        }

        public final boolean mo5627b() {
            return this.f40644f.mo5627b();
        }

        public final void run() {
            try {
                Collection collection = (Collection) ObjectHelper.m26573a(this.f40639a.call(), "The supplied buffer is null");
                synchronized (this) {
                    Collection collection2 = this.f40645g;
                    if (collection2 != null) {
                        if (this.f40648j == this.f40649k) {
                            this.f40645g = collection;
                            m41401b(collection2, this);
                            return;
                        }
                    }
                }
            } catch (Throwable th) {
                Exceptions.m26521b(th);
                cancel();
                this.n.onError(th);
            }
        }
    }

    static final class BufferExactUnboundedSubscriber<T, U extends Collection<? super T>> extends QueueDrainSubscriber<T, U, U> implements Disposable, Runnable, Subscription {
        final Callable<U> f40650a;
        final long f40651b;
        final TimeUnit f40652c;
        final Scheduler f40653d;
        Subscription f40654e;
        U f40655f;
        final AtomicReference<Disposable> f40656g = new AtomicReference();

        public final /* synthetic */ boolean mo7603a(Subscriber subscriber, Object obj) {
            this.n.onNext((Collection) obj);
            return true;
        }

        BufferExactUnboundedSubscriber(Subscriber<? super U> subscriber, Callable<U> callable, long j, TimeUnit timeUnit, Scheduler scheduler) {
            super(subscriber, new MpscLinkedQueue());
            this.f40650a = callable;
            this.f40651b = j;
            this.f40652c = timeUnit;
            this.f40653d = scheduler;
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32781a(this.f40654e, subscription)) {
                this.f40654e = subscription;
                try {
                    this.f40655f = (Collection) ObjectHelper.m26573a(this.f40650a.call(), "The supplied buffer is null");
                    this.n.mo5623a(this);
                    if (!this.p) {
                        subscription.request(Long.MAX_VALUE);
                        subscription = this.f40653d.mo5675a(this, this.f40651b, this.f40651b, this.f40652c);
                        if (!this.f40656g.compareAndSet(null, subscription)) {
                            subscription.mo5626a();
                        }
                    }
                } catch (Subscription subscription2) {
                    Exceptions.m26521b(subscription2);
                    cancel();
                    EmptySubscription.m38160a(subscription2, this.n);
                }
            }
        }

        public final void onNext(T t) {
            synchronized (this) {
                Collection collection = this.f40655f;
                if (collection != null) {
                    collection.add(t);
                }
            }
        }

        public final void onError(Throwable th) {
            DisposableHelper.m32090a(this.f40656g);
            synchronized (this) {
                this.f40655f = null;
            }
            this.n.onError(th);
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onComplete() {
            /*
            r3 = this;
            r0 = r3.f40656g;
            io.reactivex.internal.disposables.DisposableHelper.m32090a(r0);
            monitor-enter(r3);
            r0 = r3.f40655f;	 Catch:{ all -> 0x0026 }
            if (r0 != 0) goto L_0x000c;
        L_0x000a:
            monitor-exit(r3);	 Catch:{ all -> 0x0026 }
            return;
        L_0x000c:
            r1 = 0;
            r3.f40655f = r1;	 Catch:{ all -> 0x0026 }
            monitor-exit(r3);	 Catch:{ all -> 0x0026 }
            r2 = r3.o;
            r2.offer(r0);
            r0 = 1;
            r3.q = r0;
            r0 = r3.m41404f();
            if (r0 == 0) goto L_0x0025;
        L_0x001e:
            r0 = r3.o;
            r2 = r3.n;
            io.reactivex.internal.util.QueueDrainHelper.m26727a(r0, r2, r1, r3);
        L_0x0025:
            return;
        L_0x0026:
            r0 = move-exception;
            monitor-exit(r3);	 Catch:{ all -> 0x0026 }
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableBufferTimed.BufferExactUnboundedSubscriber.onComplete():void");
        }

        public final void request(long j) {
            m41398a(j);
        }

        public final void cancel() {
            this.f40654e.cancel();
            DisposableHelper.m32090a(this.f40656g);
        }

        public final void run() {
            try {
                Collection collection;
                Collection collection2 = (Collection) ObjectHelper.m26573a(this.f40650a.call(), "The supplied buffer is null");
                synchronized (this) {
                    collection = this.f40655f;
                    if (collection != null) {
                        this.f40655f = collection2;
                    }
                }
                if (collection == null) {
                    DisposableHelper.m32090a(this.f40656g);
                } else {
                    m41399a((Object) collection, (Disposable) this);
                }
            } catch (Throwable th) {
                Exceptions.m26521b(th);
                cancel();
                this.n.onError(th);
            }
        }

        public final void mo5626a() {
            cancel();
        }

        public final boolean mo5627b() {
            return this.f40656g.get() == DisposableHelper.f31095a;
        }
    }

    static final class BufferSkipBoundedSubscriber<T, U extends Collection<? super T>> extends QueueDrainSubscriber<T, U, U> implements Runnable, Subscription {
        final Callable<U> f40657a;
        final long f40658b;
        final long f40659c;
        final TimeUnit f40660d;
        final Worker f40661e;
        final List<U> f40662f = new LinkedList();
        Subscription f40663g;

        final class RemoveFromBuffer implements Runnable {
            final /* synthetic */ BufferSkipBoundedSubscriber f25047a;
            private final U f25048b;

            RemoveFromBuffer(BufferSkipBoundedSubscriber bufferSkipBoundedSubscriber, U u) {
                this.f25047a = bufferSkipBoundedSubscriber;
                this.f25048b = u;
            }

            public final void run() {
                synchronized (this.f25047a) {
                    this.f25047a.f40662f.remove(this.f25048b);
                }
                this.f25047a.m41401b(this.f25048b, this.f25047a.f40661e);
            }
        }

        public final /* synthetic */ boolean mo7603a(Subscriber subscriber, Object obj) {
            subscriber.onNext((Collection) obj);
            return true;
        }

        BufferSkipBoundedSubscriber(Subscriber<? super U> subscriber, Callable<U> callable, long j, long j2, TimeUnit timeUnit, Worker worker) {
            super(subscriber, new MpscLinkedQueue());
            this.f40657a = callable;
            this.f40658b = j;
            this.f40659c = j2;
            this.f40660d = timeUnit;
            this.f40661e = worker;
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32781a(this.f40663g, subscription)) {
                this.f40663g = subscription;
                try {
                    Collection collection = (Collection) ObjectHelper.m26573a(this.f40657a.call(), "The supplied buffer is null");
                    this.f40662f.add(collection);
                    this.n.mo5623a(this);
                    subscription.request(Long.MAX_VALUE);
                    this.f40661e.mo6652a(this, this.f40659c, this.f40659c, this.f40660d);
                    this.f40661e.mo6607a(new RemoveFromBuffer(this, collection), this.f40658b, this.f40660d);
                } catch (Throwable th) {
                    Exceptions.m26521b(th);
                    this.f40661e.mo5626a();
                    subscription.cancel();
                    EmptySubscription.m38160a(th, this.n);
                }
            }
        }

        public final void onNext(T t) {
            synchronized (this) {
                for (Collection add : this.f40662f) {
                    add.add(t);
                }
            }
        }

        public final void onError(Throwable th) {
            this.q = true;
            this.f40661e.mo5626a();
            m42344a();
            this.n.onError(th);
        }

        public final void onComplete() {
            synchronized (this) {
                List<Collection> arrayList = new ArrayList(this.f40662f);
                this.f40662f.clear();
            }
            for (Collection offer : arrayList) {
                this.o.offer(offer);
            }
            this.q = true;
            if (m41404f()) {
                QueueDrainHelper.m26727a(this.o, this.n, this.f40661e, (QueueDrain) this);
            }
        }

        public final void request(long j) {
            m41398a(j);
        }

        public final void cancel() {
            m42344a();
            this.f40663g.cancel();
            this.f40661e.mo5626a();
        }

        private void m42344a() {
            synchronized (this) {
                this.f40662f.clear();
            }
        }

        public final void run() {
            if (!this.p) {
                try {
                    Collection collection = (Collection) ObjectHelper.m26573a(this.f40657a.call(), "The supplied buffer is null");
                    synchronized (this) {
                        if (this.p) {
                            return;
                        }
                        this.f40662f.add(collection);
                        this.f40661e.mo6607a(new RemoveFromBuffer(this, collection), this.f40658b, this.f40660d);
                    }
                } catch (Throwable th) {
                    Exceptions.m26521b(th);
                    cancel();
                    this.n.onError(th);
                }
            }
        }
    }

    public FlowableBufferTimed(Flowable<T> flowable, long j, long j2, TimeUnit timeUnit, Scheduler scheduler, Callable<U> callable, int i, boolean z) {
        super(flowable);
        this.f37655a = j;
        this.f37656b = j2;
        this.f37657c = timeUnit;
        this.f37658d = scheduler;
        this.f37659e = callable;
        this.f37660f = i;
        this.f37661g = z;
    }

    protected final void subscribeActual(Subscriber<? super U> subscriber) {
        if (this.f37655a == this.f37656b && this.f37660f == RedditJobManager.f10810d) {
            this.source.subscribe(new BufferExactUnboundedSubscriber(new SerializedSubscriber(subscriber), this.f37659e, this.f37655a, this.f37657c, this.f37658d));
            return;
        }
        Worker a = this.f37658d.mo5629a();
        if (this.f37655a == this.f37656b) {
            this.source.subscribe(new BufferExactBoundedSubscriber(new SerializedSubscriber(subscriber), this.f37659e, this.f37655a, this.f37657c, this.f37660f, this.f37661g, a));
        } else {
            this.source.subscribe(new BufferSkipBoundedSubscriber(new SerializedSubscriber(subscriber), this.f37659e, this.f37655a, this.f37656b, this.f37657c, a));
        }
    }
}
