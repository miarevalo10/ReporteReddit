package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscribers.QueueDrainSubscriber;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.subscribers.DisposableSubscriber;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.Collection;
import java.util.concurrent.Callable;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableBufferExactBoundary<T, U extends Collection<? super T>, B> extends AbstractFlowableWithUpstream<T, U> {
    final Publisher<B> f37653a;
    final Callable<U> f37654b;

    static final class BufferBoundarySubscriber<T, U extends Collection<? super T>, B> extends DisposableSubscriber<B> {
        final BufferExactBoundarySubscriber<T, U, B> f37652a;

        BufferBoundarySubscriber(BufferExactBoundarySubscriber<T, U, B> bufferExactBoundarySubscriber) {
            this.f37652a = bufferExactBoundarySubscriber;
        }

        public final void onNext(B b) {
            this.f37652a.m42335c();
        }

        public final void onError(Throwable th) {
            this.f37652a.onError(th);
        }

        public final void onComplete() {
            this.f37652a.onComplete();
        }
    }

    static final class BufferExactBoundarySubscriber<T, U extends Collection<? super T>, B> extends QueueDrainSubscriber<T, U, U> implements FlowableSubscriber<T>, Disposable, Subscription {
        final Callable<U> f40634a;
        final Publisher<B> f40635b;
        Subscription f40636c;
        Disposable f40637d;
        U f40638e;

        public final /* synthetic */ boolean mo7603a(Subscriber subscriber, Object obj) {
            this.n.onNext((Collection) obj);
            return true;
        }

        BufferExactBoundarySubscriber(Subscriber<? super U> subscriber, Callable<U> callable, Publisher<B> publisher) {
            super(subscriber, new MpscLinkedQueue());
            this.f40634a = callable;
            this.f40635b = publisher;
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32781a(this.f40636c, subscription)) {
                this.f40636c = subscription;
                try {
                    this.f40638e = (Collection) ObjectHelper.m26573a(this.f40634a.call(), "The buffer supplied is null");
                    Object bufferBoundarySubscriber = new BufferBoundarySubscriber(this);
                    this.f40637d = bufferBoundarySubscriber;
                    this.n.mo5623a(this);
                    if (!this.p) {
                        subscription.request(Long.MAX_VALUE);
                        this.f40635b.subscribe(bufferBoundarySubscriber);
                    }
                } catch (Throwable th) {
                    Exceptions.m26521b(th);
                    this.p = true;
                    subscription.cancel();
                    EmptySubscription.m38160a(th, this.n);
                }
            }
        }

        public final void onNext(T t) {
            synchronized (this) {
                Collection collection = this.f40638e;
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
            r0 = r2.f40638e;	 Catch:{ all -> 0x0021 }
            if (r0 != 0) goto L_0x0007;
        L_0x0005:
            monitor-exit(r2);	 Catch:{ all -> 0x0021 }
            return;
        L_0x0007:
            r1 = 0;
            r2.f40638e = r1;	 Catch:{ all -> 0x0021 }
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
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableBufferExactBoundary.BufferExactBoundarySubscriber.onComplete():void");
        }

        public final void request(long j) {
            m41398a(j);
        }

        public final void cancel() {
            if (!this.p) {
                this.p = true;
                this.f40637d.mo5626a();
                this.f40636c.cancel();
                if (m41404f()) {
                    this.o.clear();
                }
            }
        }

        final void m42335c() {
            try {
                Collection collection = (Collection) ObjectHelper.m26573a(this.f40634a.call(), "The buffer supplied is null");
                synchronized (this) {
                    Collection collection2 = this.f40638e;
                    if (collection2 == null) {
                        return;
                    }
                    this.f40638e = collection;
                    m41399a((Object) collection2, (Disposable) this);
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
            return this.p;
        }
    }

    public FlowableBufferExactBoundary(Flowable<T> flowable, Publisher<B> publisher, Callable<U> callable) {
        super(flowable);
        this.f37653a = publisher;
        this.f37654b = callable;
    }

    protected final void subscribeActual(Subscriber<? super U> subscriber) {
        this.source.subscribe(new BufferExactBoundarySubscriber(new SerializedSubscriber(subscriber), this.f37654b, this.f37653a));
    }
}
