package io.reactivex.internal.operators.flowable;

import com.reddit.datalibrary.frontpage.job.RedditJobManager;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.flowables.ConnectableFlowable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscribers.SubscriberResourceWrapper;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Timed;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableReplay<T> extends ConnectableFlowable<T> implements Disposable {
    static final Callable f37796e = new DefaultUnboundedFactory();
    final Flowable<T> f37797a;
    final AtomicReference<ReplaySubscriber<T>> f37798b;
    final Callable<? extends ReplayBuffer<T>> f37799c;
    final Publisher<T> f37800d;

    static final class DefaultUnboundedFactory implements Callable<Object> {
        DefaultUnboundedFactory() {
        }

        public final Object call() {
            return new UnboundedReplayBuffer();
        }
    }

    static final class Node extends AtomicReference<Node> {
        final Object f25071a;
        final long f25072b;

        Node(Object obj, long j) {
            this.f25071a = obj;
            this.f25072b = j;
        }
    }

    interface ReplayBuffer<T> {
        void mo5649a();

        void mo5650a(InnerSubscription<T> innerSubscription);

        void mo5651a(T t);

        void mo5652a(Throwable th);
    }

    static final class ReplayBufferTask<T> implements Callable<ReplayBuffer<T>> {
        private final int f25073a;

        ReplayBufferTask(int i) {
            this.f25073a = i;
        }

        public final /* synthetic */ Object call() throws Exception {
            return new SizeBoundReplayBuffer(this.f25073a);
        }
    }

    static final class ScheduledReplayBufferTask<T> implements Callable<ReplayBuffer<T>> {
        private final int f25074a;
        private final long f25075b;
        private final TimeUnit f25076c;
        private final Scheduler f25077d;

        ScheduledReplayBufferTask(int i, long j, TimeUnit timeUnit, Scheduler scheduler) {
            this.f25074a = i;
            this.f25075b = j;
            this.f25076c = timeUnit;
            this.f25077d = scheduler;
        }

        public final /* synthetic */ Object call() throws Exception {
            return new SizeAndTimeBoundReplayBuffer(this.f25074a, this.f25075b, this.f25076c, this.f25077d);
        }
    }

    static class BoundedReplayBuffer<T> extends AtomicReference<Node> implements ReplayBuffer<T> {
        Node f31346a;
        int f31347b;
        long f31348c;

        Object mo6626b(Object obj) {
            return obj;
        }

        void mo6627b() {
        }

        Object mo6628c(Object obj) {
            return obj;
        }

        void mo6629c() {
        }

        BoundedReplayBuffer() {
            Node node = new Node(null, 0);
            this.f31346a = node;
            set(node);
        }

        private void m32206a(Node node) {
            this.f31346a.set(node);
            this.f31346a = node;
            this.f31347b++;
        }

        public final void mo5651a(T t) {
            t = mo6626b(NotificationLite.m26696a((Object) t));
            long j = this.f31348c + 1;
            this.f31348c = j;
            m32206a(new Node(t, j));
            mo6627b();
        }

        public final void mo5652a(Throwable th) {
            th = mo6626b(NotificationLite.m26697a(th));
            long j = this.f31348c + 1;
            this.f31348c = j;
            m32206a(new Node(th, j));
            mo6629c();
        }

        public final void mo5649a() {
            Object b = mo6626b(NotificationLite.m26694a());
            long j = this.f31348c + 1;
            this.f31348c = j;
            m32206a(new Node(b, j));
            mo6629c();
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void mo5650a(io.reactivex.internal.operators.flowable.FlowableReplay.InnerSubscription<T> r14) {
            /*
            r13 = this;
            monitor-enter(r14);
            r0 = r14.f31353e;	 Catch:{ all -> 0x009d }
            r1 = 1;
            if (r0 == 0) goto L_0x000a;
        L_0x0006:
            r14.f31354f = r1;	 Catch:{ all -> 0x009d }
            monitor-exit(r14);	 Catch:{ all -> 0x009d }
            return;
        L_0x000a:
            r14.f31353e = r1;	 Catch:{ all -> 0x009d }
            monitor-exit(r14);	 Catch:{ all -> 0x009d }
        L_0x000d:
            r0 = r14.mo5627b();
            if (r0 == 0) goto L_0x0014;
        L_0x0013:
            return;
        L_0x0014:
            r2 = r14.get();
            r4 = 9223372036854775807; // 0x7fffffffffffffff float:NaN double:NaN;
            r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
            r4 = 0;
            if (r0 != 0) goto L_0x0024;
        L_0x0022:
            r0 = r1;
            goto L_0x0025;
        L_0x0024:
            r0 = r4;
        L_0x0025:
            r5 = r14.f31351c;
            r5 = (io.reactivex.internal.operators.flowable.FlowableReplay.Node) r5;
            r6 = 0;
            if (r5 != 0) goto L_0x003a;
        L_0x002d:
            r5 = r13.mo6630d();
            r14.f31351c = r5;
            r8 = r14.f31352d;
            r9 = r5.f25072b;
            io.reactivex.internal.util.BackpressureHelper.m26670a(r8, r9);
        L_0x003a:
            r8 = r6;
        L_0x003b:
            r10 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1));
            if (r10 == 0) goto L_0x0081;
        L_0x003f:
            r10 = r5.get();
            r10 = (io.reactivex.internal.operators.flowable.FlowableReplay.Node) r10;
            if (r10 == 0) goto L_0x0081;
        L_0x0047:
            r5 = r10.f25071a;
            r5 = r13.mo6628c(r5);
            r11 = 0;
            r12 = r14.f31350b;	 Catch:{ Throwable -> 0x0066 }
            r12 = io.reactivex.internal.util.NotificationLite.m26700a(r5, r12);	 Catch:{ Throwable -> 0x0066 }
            if (r12 == 0) goto L_0x0059;
        L_0x0056:
            r14.f31351c = r11;	 Catch:{ Throwable -> 0x0066 }
            return;
        L_0x0059:
            r11 = 1;
            r8 = r8 + r11;
            r2 = r2 - r11;
            r5 = r14.mo5627b();
            if (r5 == 0) goto L_0x0064;
        L_0x0063:
            return;
        L_0x0064:
            r5 = r10;
            goto L_0x003b;
        L_0x0066:
            r0 = move-exception;
            io.reactivex.exceptions.Exceptions.m26521b(r0);
            r14.f31351c = r11;
            r14.mo5626a();
            r1 = io.reactivex.internal.util.NotificationLite.m26704c(r5);
            if (r1 != 0) goto L_0x0080;
        L_0x0075:
            r1 = io.reactivex.internal.util.NotificationLite.m26701b(r5);
            if (r1 != 0) goto L_0x0080;
        L_0x007b:
            r14 = r14.f31350b;
            r14.onError(r0);
        L_0x0080:
            return;
        L_0x0081:
            r2 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1));
            if (r2 == 0) goto L_0x008c;
        L_0x0085:
            r14.f31351c = r5;
            if (r0 != 0) goto L_0x008c;
        L_0x0089:
            io.reactivex.internal.util.BackpressureHelper.m26674d(r14, r8);
        L_0x008c:
            monitor-enter(r14);
            r0 = r14.f31354f;	 Catch:{ all -> 0x009a }
            if (r0 != 0) goto L_0x0095;
        L_0x0091:
            r14.f31353e = r4;	 Catch:{ all -> 0x009a }
            monitor-exit(r14);	 Catch:{ all -> 0x009a }
            return;
        L_0x0095:
            r14.f31354f = r4;	 Catch:{ all -> 0x009a }
            monitor-exit(r14);	 Catch:{ all -> 0x009a }
            goto L_0x000d;
        L_0x009a:
            r0 = move-exception;
            monitor-exit(r14);	 Catch:{ all -> 0x009a }
            throw r0;
        L_0x009d:
            r0 = move-exception;
            monitor-exit(r14);	 Catch:{ all -> 0x009d }
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableReplay.BoundedReplayBuffer.a(io.reactivex.internal.operators.flowable.FlowableReplay$InnerSubscription):void");
        }

        Node mo6630d() {
            return (Node) get();
        }
    }

    static final class InnerSubscription<T> extends AtomicLong implements Disposable, Subscription {
        final ReplaySubscriber<T> f31349a;
        final Subscriber<? super T> f31350b;
        Object f31351c;
        final AtomicLong f31352d = new AtomicLong();
        boolean f31353e;
        boolean f31354f;

        InnerSubscription(ReplaySubscriber<T> replaySubscriber, Subscriber<? super T> subscriber) {
            this.f31349a = replaySubscriber;
            this.f31350b = subscriber;
        }

        public final void request(long j) {
            if (SubscriptionHelper.m32776a(j)) {
                long j2;
                do {
                    j2 = get();
                    if (j2 != Long.MIN_VALUE) {
                        if (j2 >= 0 && j == 0) {
                            return;
                        }
                    } else {
                        return;
                    }
                } while (!compareAndSet(j2, BackpressureHelper.m26669a(j2, j)));
                BackpressureHelper.m26670a(this.f31352d, j);
                this.f31349a.m35804c();
                this.f31349a.f35253a.mo5650a(this);
            }
        }

        public final boolean mo5627b() {
            return get() == Long.MIN_VALUE;
        }

        public final void cancel() {
            mo5626a();
        }

        public final void mo5626a() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.f31349a.m35801a(this);
                this.f31349a.m35804c();
            }
        }
    }

    static final class MultiCastPublisher<R, U> implements Publisher<R> {
        private final Callable<? extends ConnectableFlowable<U>> f31357a;
        private final Function<? super Flowable<U>, ? extends Publisher<R>> f31358b;

        final class DisposableConsumer implements Consumer<Disposable> {
            final /* synthetic */ MultiCastPublisher f31355a;
            private final SubscriberResourceWrapper<R> f31356b;

            public final /* synthetic */ void accept(Object obj) throws Exception {
                DisposableHelper.m32091a(this.f31356b, (Disposable) obj);
            }

            DisposableConsumer(MultiCastPublisher multiCastPublisher, SubscriberResourceWrapper<R> subscriberResourceWrapper) {
                this.f31355a = multiCastPublisher;
                this.f31356b = subscriberResourceWrapper;
            }
        }

        MultiCastPublisher(Callable<? extends ConnectableFlowable<U>> callable, Function<? super Flowable<U>, ? extends Publisher<R>> function) {
            this.f31357a = callable;
            this.f31358b = function;
        }

        public final void subscribe(Subscriber<? super R> subscriber) {
            try {
                ConnectableFlowable connectableFlowable = (ConnectableFlowable) ObjectHelper.m26573a(this.f31357a.call(), "The connectableFactory returned null");
                try {
                    Publisher publisher = (Publisher) ObjectHelper.m26573a(this.f31358b.apply(connectableFlowable), "The selector returned a null Publisher");
                    Object subscriberResourceWrapper = new SubscriberResourceWrapper(subscriber);
                    publisher.subscribe(subscriberResourceWrapper);
                    connectableFlowable.mo7047a(new DisposableConsumer(this, subscriberResourceWrapper));
                } catch (Throwable th) {
                    Exceptions.m26521b(th);
                    EmptySubscription.m38160a(th, subscriber);
                }
            } catch (Throwable th2) {
                Exceptions.m26521b(th2);
                EmptySubscription.m38160a(th2, subscriber);
            }
        }
    }

    static final class ReplayPublisher<T> implements Publisher<T> {
        private final AtomicReference<ReplaySubscriber<T>> f31359a;
        private final Callable<? extends ReplayBuffer<T>> f31360b;

        ReplayPublisher(AtomicReference<ReplaySubscriber<T>> atomicReference, Callable<? extends ReplayBuffer<T>> callable) {
            this.f31359a = atomicReference;
            this.f31360b = callable;
        }

        public final void subscribe(Subscriber<? super T> subscriber) {
            ReplaySubscriber replaySubscriber;
            ReplaySubscriber replaySubscriber2;
            do {
                replaySubscriber2 = (ReplaySubscriber) this.f31359a.get();
                if (replaySubscriber2 != null) {
                    break;
                }
                try {
                    replaySubscriber = new ReplaySubscriber((ReplayBuffer) this.f31360b.call());
                } catch (Throwable th) {
                    Exceptions.m26521b(th);
                    subscriber = ExceptionHelper.m26682a(th);
                }
            } while (!this.f31359a.compareAndSet(null, replaySubscriber));
            replaySubscriber2 = replaySubscriber;
            InnerSubscription innerSubscription = new InnerSubscription(replaySubscriber2, subscriber);
            subscriber.mo5623a(innerSubscription);
            InnerSubscription[] innerSubscriptionArr;
            Object obj;
            do {
                innerSubscriptionArr = (InnerSubscription[]) replaySubscriber2.f35255e.get();
                if (innerSubscriptionArr == ReplaySubscriber.f35252d) {
                    break;
                }
                int length = innerSubscriptionArr.length;
                obj = new InnerSubscription[(length + 1)];
                System.arraycopy(innerSubscriptionArr, 0, obj, 0, length);
                obj[length] = innerSubscription;
            } while (replaySubscriber2.f35255e.compareAndSet(innerSubscriptionArr, obj) == null);
            if (innerSubscription.mo5627b() != null) {
                replaySubscriber2.m35801a(innerSubscription);
                return;
            }
            replaySubscriber2.m35804c();
            replaySubscriber2.f35253a.mo5650a(innerSubscription);
        }
    }

    static final class UnboundedReplayBuffer<T> extends ArrayList<Object> implements ReplayBuffer<T> {
        volatile int f31361a;

        UnboundedReplayBuffer() {
            super(16);
        }

        public final void mo5651a(T t) {
            add(NotificationLite.m26696a((Object) t));
            this.f31361a++;
        }

        public final void mo5652a(Throwable th) {
            add(NotificationLite.m26697a(th));
            this.f31361a++;
        }

        public final void mo5649a() {
            add(NotificationLite.m26694a());
            this.f31361a++;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void mo5650a(io.reactivex.internal.operators.flowable.FlowableReplay.InnerSubscription<T> r15) {
            /*
            r14 = this;
            monitor-enter(r15);
            r0 = r15.f31353e;	 Catch:{ all -> 0x0089 }
            r1 = 1;
            if (r0 == 0) goto L_0x000a;
        L_0x0006:
            r15.f31354f = r1;	 Catch:{ all -> 0x0089 }
            monitor-exit(r15);	 Catch:{ all -> 0x0089 }
            return;
        L_0x000a:
            r15.f31353e = r1;	 Catch:{ all -> 0x0089 }
            monitor-exit(r15);	 Catch:{ all -> 0x0089 }
            r0 = r15.f31350b;
        L_0x000f:
            r1 = r15.mo5627b();
            if (r1 == 0) goto L_0x0016;
        L_0x0015:
            return;
        L_0x0016:
            r1 = r14.f31361a;
            r2 = r15.f31351c;
            r2 = (java.lang.Integer) r2;
            r3 = 0;
            if (r2 == 0) goto L_0x0024;
        L_0x001f:
            r2 = r2.intValue();
            goto L_0x0025;
        L_0x0024:
            r2 = r3;
        L_0x0025:
            r4 = r15.get();
            r6 = 0;
            r8 = r4;
            r10 = r6;
        L_0x002d:
            r12 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1));
            if (r12 == 0) goto L_0x0063;
        L_0x0031:
            if (r2 >= r1) goto L_0x0063;
        L_0x0033:
            r12 = r14.get(r2);
            r13 = io.reactivex.internal.util.NotificationLite.m26700a(r12, r0);	 Catch:{ Throwable -> 0x004c }
            if (r13 == 0) goto L_0x003e;
        L_0x003d:
            return;
        L_0x003e:
            r12 = r15.mo5627b();
            if (r12 == 0) goto L_0x0045;
        L_0x0044:
            return;
        L_0x0045:
            r2 = r2 + 1;
            r12 = 1;
            r8 = r8 - r12;
            r10 = r10 + r12;
            goto L_0x002d;
        L_0x004c:
            r1 = move-exception;
            io.reactivex.exceptions.Exceptions.m26521b(r1);
            r15.mo5626a();
            r15 = io.reactivex.internal.util.NotificationLite.m26704c(r12);
            if (r15 != 0) goto L_0x0062;
        L_0x0059:
            r15 = io.reactivex.internal.util.NotificationLite.m26701b(r12);
            if (r15 != 0) goto L_0x0062;
        L_0x005f:
            r0.onError(r1);
        L_0x0062:
            return;
        L_0x0063:
            r1 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1));
            if (r1 == 0) goto L_0x0079;
        L_0x0067:
            r1 = java.lang.Integer.valueOf(r2);
            r15.f31351c = r1;
            r1 = 9223372036854775807; // 0x7fffffffffffffff float:NaN double:NaN;
            r1 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1));
            if (r1 == 0) goto L_0x0079;
        L_0x0076:
            io.reactivex.internal.util.BackpressureHelper.m26674d(r15, r10);
        L_0x0079:
            monitor-enter(r15);
            r1 = r15.f31354f;	 Catch:{ all -> 0x0086 }
            if (r1 != 0) goto L_0x0082;
        L_0x007e:
            r15.f31353e = r3;	 Catch:{ all -> 0x0086 }
            monitor-exit(r15);	 Catch:{ all -> 0x0086 }
            return;
        L_0x0082:
            r15.f31354f = r3;	 Catch:{ all -> 0x0086 }
            monitor-exit(r15);	 Catch:{ all -> 0x0086 }
            goto L_0x000f;
        L_0x0086:
            r0 = move-exception;
            monitor-exit(r15);	 Catch:{ all -> 0x0086 }
            throw r0;
        L_0x0089:
            r0 = move-exception;
            monitor-exit(r15);	 Catch:{ all -> 0x0089 }
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableReplay.UnboundedReplayBuffer.a(io.reactivex.internal.operators.flowable.FlowableReplay$InnerSubscription):void");
        }
    }

    static final class ReplaySubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T>, Disposable {
        static final InnerSubscription[] f35251c = new InnerSubscription[0];
        static final InnerSubscription[] f35252d = new InnerSubscription[0];
        final ReplayBuffer<T> f35253a;
        boolean f35254b;
        final AtomicReference<InnerSubscription<T>[]> f35255e = new AtomicReference(f35251c);
        final AtomicBoolean f35256f = new AtomicBoolean();
        final AtomicInteger f35257g = new AtomicInteger();
        long f35258h;
        long f35259i;

        ReplaySubscriber(ReplayBuffer<T> replayBuffer) {
            this.f35253a = replayBuffer;
        }

        public final boolean mo5627b() {
            return this.f35255e.get() == f35252d;
        }

        public final void mo5626a() {
            this.f35255e.set(f35252d);
            SubscriptionHelper.m32777a((AtomicReference) this);
        }

        final void m35801a(InnerSubscription<T> innerSubscription) {
            InnerSubscription[] innerSubscriptionArr;
            Object obj;
            do {
                innerSubscriptionArr = (InnerSubscription[]) this.f35255e.get();
                int length = innerSubscriptionArr.length;
                if (length != 0) {
                    int i = -1;
                    for (int i2 = 0; i2 < length; i2++) {
                        if (innerSubscriptionArr[i2].equals(innerSubscription)) {
                            i = i2;
                            break;
                        }
                    }
                    if (i >= 0) {
                        if (length == 1) {
                            obj = f35251c;
                        } else {
                            Object obj2 = new InnerSubscription[(length - 1)];
                            System.arraycopy(innerSubscriptionArr, 0, obj2, 0, i);
                            System.arraycopy(innerSubscriptionArr, i + 1, obj2, i, (length - i) - 1);
                            obj = obj2;
                        }
                    } else {
                        return;
                    }
                }
                return;
            } while (!this.f35255e.compareAndSet(innerSubscriptionArr, obj));
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32779a((AtomicReference) this, subscription) != null) {
                m35804c();
                for (InnerSubscription a : (InnerSubscription[]) this.f35255e.get()) {
                    this.f35253a.mo5650a(a);
                }
            }
        }

        public final void onNext(T t) {
            if (!this.f35254b) {
                this.f35253a.mo5651a((Object) t);
                for (InnerSubscription a : (InnerSubscription[]) this.f35255e.get()) {
                    this.f35253a.mo5650a(a);
                }
            }
        }

        public final void onError(Throwable th) {
            if (this.f35254b) {
                RxJavaPlugins.m26757a(th);
                return;
            }
            this.f35254b = true;
            this.f35253a.mo5652a(th);
            for (InnerSubscription a : (InnerSubscription[]) this.f35255e.getAndSet(f35252d)) {
                this.f35253a.mo5650a(a);
            }
        }

        public final void onComplete() {
            if (!this.f35254b) {
                this.f35254b = true;
                this.f35253a.mo5649a();
                for (InnerSubscription a : (InnerSubscription[]) this.f35255e.getAndSet(f35252d)) {
                    this.f35253a.mo5650a(a);
                }
            }
        }

        final void m35804c() {
            if (this.f35257g.getAndIncrement() == 0) {
                int i = 1;
                while (!mo5627b()) {
                    InnerSubscription[] innerSubscriptionArr = (InnerSubscription[]) this.f35255e.get();
                    long j = this.f35258h;
                    long j2 = j;
                    for (InnerSubscription innerSubscription : innerSubscriptionArr) {
                        j2 = Math.max(j2, innerSubscription.f31352d.get());
                    }
                    long j3 = this.f35259i;
                    Subscription subscription = (Subscription) get();
                    j = j2 - j;
                    if (j != 0) {
                        this.f35258h = j2;
                        if (subscription == null) {
                            j3 += j;
                            if (j3 < 0) {
                                j3 = Long.MAX_VALUE;
                            }
                            this.f35259i = j3;
                        } else if (j3 != 0) {
                            this.f35259i = 0;
                            subscription.request(j3 + j);
                        } else {
                            subscription.request(j);
                        }
                    } else if (!(j3 == 0 || subscription == null)) {
                        this.f35259i = 0;
                        subscription.request(j3);
                    }
                    i = this.f35257g.addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                }
            }
        }
    }

    static final class SizeAndTimeBoundReplayBuffer<T> extends BoundedReplayBuffer<T> {
        final Scheduler f35260d;
        final long f35261e;
        final TimeUnit f35262f;
        final int f35263g;

        SizeAndTimeBoundReplayBuffer(int i, long j, TimeUnit timeUnit, Scheduler scheduler) {
            this.f35260d = scheduler;
            this.f35263g = i;
            this.f35261e = j;
            this.f35262f = timeUnit;
        }

        final Object mo6626b(Object obj) {
            return new Timed(obj, Scheduler.m26494a(this.f35262f), this.f35262f);
        }

        final Object mo6628c(Object obj) {
            return ((Timed) obj).f25242a;
        }

        final void mo6627b() {
            long a = Scheduler.m26494a(this.f35262f) - this.f35261e;
            Node node = (Node) get();
            Node node2 = (Node) node.get();
            int i = 0;
            while (true) {
                Node node3 = node2;
                node2 = node;
                node = node3;
                if (node != null) {
                    if (this.b <= this.f35263g) {
                        if (((Timed) node.f25071a).f25243b > a) {
                            break;
                        }
                        i++;
                        this.b--;
                        node2 = (Node) node.get();
                    } else {
                        i++;
                        this.b--;
                        node2 = (Node) node.get();
                    }
                } else {
                    break;
                }
            }
            if (i != 0) {
                set(node2);
            }
        }

        final void mo6629c() {
            long a = Scheduler.m26494a(this.f35262f) - this.f35261e;
            Node node = (Node) get();
            Node node2 = (Node) node.get();
            int i = 0;
            while (true) {
                Node node3 = node2;
                node2 = node;
                node = node3;
                if (node != null && this.b > 1 && ((Timed) node.f25071a).f25243b <= a) {
                    i++;
                    this.b--;
                    node2 = (Node) node.get();
                } else if (i != 0) {
                    set(node2);
                }
            }
            if (i != 0) {
                set(node2);
            }
        }

        final Node mo6630d() {
            long a = Scheduler.m26494a(this.f35262f) - this.f35261e;
            Node node = (Node) get();
            Node node2 = (Node) node.get();
            while (true) {
                Node node3 = node2;
                node2 = node;
                node = node3;
                if (node == null) {
                    break;
                }
                Timed timed = (Timed) node.f25071a;
                if (NotificationLite.m26701b(timed.f25242a) || NotificationLite.m26704c(timed.f25242a) || timed.f25243b > a) {
                    break;
                }
                node2 = (Node) node.get();
            }
            return node2;
        }
    }

    static final class SizeBoundReplayBuffer<T> extends BoundedReplayBuffer<T> {
        final int f35264d;

        SizeBoundReplayBuffer(int i) {
            this.f35264d = i;
        }

        final void mo6627b() {
            if (this.b > this.f35264d) {
                Node node = (Node) ((Node) get()).get();
                if (node == null) {
                    throw new IllegalStateException("Empty list!");
                }
                this.f31347b--;
                set(node);
            }
        }
    }

    static final class ConnectableFlowableReplay<T> extends ConnectableFlowable<T> {
        private final ConnectableFlowable<T> f37794a;
        private final Flowable<T> f37795b;

        ConnectableFlowableReplay(ConnectableFlowable<T> connectableFlowable, Flowable<T> flowable) {
            this.f37794a = connectableFlowable;
            this.f37795b = flowable;
        }

        public final void mo7047a(Consumer<? super Disposable> consumer) {
            this.f37794a.mo7047a(consumer);
        }

        protected final void subscribeActual(Subscriber<? super T> subscriber) {
            this.f37795b.subscribe((Subscriber) subscriber);
        }
    }

    public static <U, R> Flowable<R> m38111a(Callable<? extends ConnectableFlowable<U>> callable, Function<? super Flowable<U>, ? extends Publisher<R>> function) {
        return Flowable.unsafeCreate(new MultiCastPublisher(callable, function));
    }

    public static <T> ConnectableFlowable<T> m38117a(ConnectableFlowable<T> connectableFlowable, Scheduler scheduler) {
        return RxJavaPlugins.m26749a(new ConnectableFlowableReplay(connectableFlowable, connectableFlowable.observeOn(scheduler)));
    }

    public static <T> ConnectableFlowable<T> m38112a(Flowable<? extends T> flowable) {
        return m38116a((Flowable) flowable, f37796e);
    }

    public static <T> ConnectableFlowable<T> m38114a(Flowable<T> flowable, long j, TimeUnit timeUnit, Scheduler scheduler) {
        return m38115a(flowable, j, timeUnit, scheduler, RedditJobManager.f10810d);
    }

    public static <T> ConnectableFlowable<T> m38115a(Flowable<T> flowable, long j, TimeUnit timeUnit, Scheduler scheduler, int i) {
        return m38116a((Flowable) flowable, new ScheduledReplayBufferTask(i, j, timeUnit, scheduler));
    }

    private static <T> ConnectableFlowable<T> m38116a(Flowable<T> flowable, Callable<? extends ReplayBuffer<T>> callable) {
        AtomicReference atomicReference = new AtomicReference();
        return RxJavaPlugins.m26749a(new FlowableReplay(new ReplayPublisher(atomicReference, callable), flowable, atomicReference, callable));
    }

    private FlowableReplay(Publisher<T> publisher, Flowable<T> flowable, AtomicReference<ReplaySubscriber<T>> atomicReference, Callable<? extends ReplayBuffer<T>> callable) {
        this.f37800d = publisher;
        this.f37797a = flowable;
        this.f37798b = atomicReference;
        this.f37799c = callable;
    }

    protected final void subscribeActual(Subscriber<? super T> subscriber) {
        this.f37800d.subscribe(subscriber);
    }

    public final void mo5626a() {
        this.f37798b.lazySet(null);
    }

    public final boolean mo5627b() {
        Disposable disposable = (Disposable) this.f37798b.get();
        if (disposable != null) {
            if (!disposable.mo5627b()) {
                return false;
            }
        }
        return true;
    }

    public final void mo7047a(Consumer<? super Disposable> consumer) {
        FlowableSubscriber flowableSubscriber;
        ReplaySubscriber replaySubscriber;
        do {
            flowableSubscriber = (ReplaySubscriber) this.f37798b.get();
            if (flowableSubscriber != null && !flowableSubscriber.mo5627b()) {
                break;
            }
            try {
                replaySubscriber = new ReplaySubscriber((ReplayBuffer) this.f37799c.call());
            } catch (Throwable th) {
                Exceptions.m26521b(th);
                consumer = ExceptionHelper.m26682a(th);
            }
        } while (!this.f37798b.compareAndSet(flowableSubscriber, replaySubscriber));
        flowableSubscriber = replaySubscriber;
        boolean z = !flowableSubscriber.f35256f.get() && flowableSubscriber.f35256f.compareAndSet(false, true);
        try {
            consumer.accept(flowableSubscriber);
            if (z) {
                this.f37797a.subscribe(flowableSubscriber);
            }
        } catch (Throwable th2) {
            if (z) {
                flowableSubscriber.f35256f.compareAndSet(true, false);
            }
            Exceptions.m26521b(th2);
            consumer = ExceptionHelper.m26682a(th2);
        }
    }

    public static <T> ConnectableFlowable<T> m38113a(Flowable<T> flowable, int i) {
        return i == RedditJobManager.f10810d ? m38116a((Flowable) flowable, f37796e) : m38116a((Flowable) flowable, new ReplayBufferTask(i));
    }
}
