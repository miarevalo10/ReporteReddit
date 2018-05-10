package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.Scheduler.Worker;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscribers.QueueDrainSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.processors.UnicastProcessor;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableWindowTimed<T> extends AbstractFlowableWithUpstream<T, Flowable<T>> {
    final long f37881a;
    final long f37882b;
    final TimeUnit f37883c;
    final Scheduler f37884d;
    final long f37885e;
    final int f37886f;
    final boolean f37887g;

    static final class WindowExactBoundedSubscriber<T> extends QueueDrainSubscriber<T, Object, Flowable<T>> implements Subscription {
        final long f40686a;
        final TimeUnit f40687b;
        final Scheduler f40688c;
        final int f40689d;
        final boolean f40690e;
        final long f40691f;
        final Worker f40692g;
        long f40693h;
        long f40694i;
        Subscription f40695j;
        UnicastProcessor<T> f40696k;
        volatile boolean f40697l;
        final SequentialDisposable f40698m = new SequentialDisposable();

        static final class ConsumerIndexHolder implements Runnable {
            final long f25085a;
            final WindowExactBoundedSubscriber<?> f25086b;

            ConsumerIndexHolder(long j, WindowExactBoundedSubscriber<?> windowExactBoundedSubscriber) {
                this.f25085a = j;
                this.f25086b = windowExactBoundedSubscriber;
            }

            public final void run() {
                WindowExactBoundedSubscriber windowExactBoundedSubscriber = this.f25086b;
                if (windowExactBoundedSubscriber.p) {
                    windowExactBoundedSubscriber.f40697l = true;
                    windowExactBoundedSubscriber.m42364a();
                } else {
                    windowExactBoundedSubscriber.o.offer(this);
                }
                if (windowExactBoundedSubscriber.m41404f()) {
                    windowExactBoundedSubscriber.m42366b();
                }
            }
        }

        WindowExactBoundedSubscriber(Subscriber<? super Flowable<T>> subscriber, long j, TimeUnit timeUnit, Scheduler scheduler, int i, long j2, boolean z) {
            super(subscriber, new MpscLinkedQueue());
            this.f40686a = j;
            this.f40687b = timeUnit;
            this.f40688c = scheduler;
            this.f40689d = i;
            this.f40691f = j2;
            this.f40690e = z;
            if (z) {
                this.f40692g = scheduler.mo5629a();
            } else {
                this.f40692g = null;
            }
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32781a(this.f40695j, subscription)) {
                this.f40695j = subscription;
                Subscriber subscriber = this.n;
                subscriber.mo5623a(this);
                if (!this.p) {
                    UnicastProcessor a = UnicastProcessor.m38166a(this.f40689d);
                    this.f40696k = a;
                    long j = this.s.get();
                    if (j != 0) {
                        Disposable a2;
                        subscriber.onNext(a);
                        if (j != Long.MAX_VALUE) {
                            mo7608j();
                        }
                        Runnable consumerIndexHolder = new ConsumerIndexHolder(this.f40694i, this);
                        if (this.f40690e) {
                            a2 = this.f40692g.mo6652a(consumerIndexHolder, this.f40686a, this.f40686a, this.f40687b);
                        } else {
                            a2 = this.f40688c.mo5675a(consumerIndexHolder, this.f40686a, this.f40686a, this.f40687b);
                        }
                        if (DisposableHelper.m32094c(this.f40698m, a2)) {
                            subscription.request(Long.MAX_VALUE);
                        }
                    } else {
                        this.p = true;
                        subscription.cancel();
                        subscriber.onError(new MissingBackpressureException("Could not deliver initial window due to lack of requests."));
                    }
                }
            }
        }

        public final void onNext(T t) {
            if (!this.f40697l) {
                if (m41405g()) {
                    UnicastProcessor unicastProcessor = this.f40696k;
                    unicastProcessor.onNext(t);
                    long j = this.f40693h + 1;
                    if (j >= this.f40691f) {
                        this.f40694i++;
                        this.f40693h = 0;
                        unicastProcessor.onComplete();
                        long j2 = this.s.get();
                        if (j2 != 0) {
                            t = UnicastProcessor.m38166a(this.f40689d);
                            this.f40696k = t;
                            this.n.onNext(t);
                            if (j2 != Long.MAX_VALUE) {
                                mo7608j();
                            }
                            if (this.f40690e != null) {
                                Disposable disposable = (Disposable) this.f40698m.get();
                                disposable.mo5626a();
                                Disposable a = this.f40692g.mo6652a(new ConsumerIndexHolder(this.f40694i, this), this.f40686a, this.f40686a, this.f40687b);
                                if (this.f40698m.compareAndSet(disposable, a) == null) {
                                    a.mo5626a();
                                }
                            }
                        } else {
                            this.f40696k = null;
                            this.f40695j.cancel();
                            this.n.onError(new MissingBackpressureException("Could not deliver window due to lack of requests"));
                            m42364a();
                            return;
                        }
                    }
                    this.f40693h = j;
                    if (mo7602a(-1) == null) {
                        return;
                    }
                }
                this.o.offer(NotificationLite.m26696a((Object) t));
                if (m41404f() == null) {
                    return;
                }
                m42366b();
            }
        }

        public final void onError(Throwable th) {
            this.r = th;
            this.q = true;
            if (m41404f()) {
                m42366b();
            }
            this.n.onError(th);
            m42364a();
        }

        public final void onComplete() {
            this.q = true;
            if (m41404f()) {
                m42366b();
            }
            this.n.onComplete();
            m42364a();
        }

        public final void request(long j) {
            m41398a(j);
        }

        public final void cancel() {
            this.p = true;
        }

        public final void m42364a() {
            DisposableHelper.m32090a(this.f40698m);
            Worker worker = this.f40692g;
            if (worker != null) {
                worker.mo5626a();
            }
        }

        final void m42366b() {
            SimplePlainQueue simplePlainQueue = this.o;
            Subscriber subscriber = this.n;
            UnicastProcessor unicastProcessor = this.f40696k;
            int i = 1;
            while (!r0.f40697l) {
                boolean z = r0.q;
                Object poll = simplePlainQueue.poll();
                Object obj = poll == null ? 1 : null;
                boolean z2 = poll instanceof ConsumerIndexHolder;
                if (z && (obj != null || z2)) {
                    r0.f40696k = null;
                    simplePlainQueue.clear();
                    Throwable th = r0.r;
                    if (th != null) {
                        unicastProcessor.onError(th);
                    } else {
                        unicastProcessor.onComplete();
                    }
                    m42364a();
                    return;
                } else if (obj != null) {
                    i = mo7602a(-i);
                    if (i == 0) {
                        return;
                    }
                } else if (z2) {
                    ConsumerIndexHolder consumerIndexHolder = (ConsumerIndexHolder) poll;
                    if (r0.f40690e || r0.f40694i == consumerIndexHolder.f25085a) {
                        unicastProcessor.onComplete();
                        r0.f40693h = 0;
                        unicastProcessor = UnicastProcessor.m38166a(r0.f40689d);
                        r0.f40696k = unicastProcessor;
                        r6 = r0.s.get();
                        if (r6 != 0) {
                            subscriber.onNext(unicastProcessor);
                            if (r6 != Long.MAX_VALUE) {
                                mo7608j();
                            }
                        } else {
                            r0.f40696k = null;
                            r0.o.clear();
                            r0.f40695j.cancel();
                            subscriber.onError(new MissingBackpressureException("Could not deliver first window due to lack of requests."));
                            m42364a();
                            return;
                        }
                    }
                } else {
                    unicastProcessor.onNext(NotificationLite.m26706e(poll));
                    r6 = r0.f40693h + 1;
                    if (r6 >= r0.f40691f) {
                        r0.f40694i++;
                        r0.f40693h = 0;
                        unicastProcessor.onComplete();
                        long j = r0.s.get();
                        if (j != 0) {
                            UnicastProcessor a = UnicastProcessor.m38166a(r0.f40689d);
                            r0.f40696k = a;
                            r0.n.onNext(a);
                            if (j != Long.MAX_VALUE) {
                                mo7608j();
                            }
                            if (r0.f40690e) {
                                Disposable disposable = (Disposable) r0.f40698m.get();
                                disposable.mo5626a();
                                Disposable a2 = r0.f40692g.mo6652a(new ConsumerIndexHolder(r0.f40694i, r0), r0.f40686a, r0.f40686a, r0.f40687b);
                                if (!r0.f40698m.compareAndSet(disposable, a2)) {
                                    a2.mo5626a();
                                }
                            }
                            unicastProcessor = a;
                        } else {
                            r0.f40696k = null;
                            r0.f40695j.cancel();
                            r0.n.onError(new MissingBackpressureException("Could not deliver window due to lack of requests"));
                            m42364a();
                            return;
                        }
                    }
                    r0.f40693h = r6;
                }
            }
            r0.f40695j.cancel();
            simplePlainQueue.clear();
            m42364a();
        }
    }

    static final class WindowExactUnboundedSubscriber<T> extends QueueDrainSubscriber<T, Object, Flowable<T>> implements FlowableSubscriber<T>, Runnable, Subscription {
        static final Object f40699h = new Object();
        final long f40700a;
        final TimeUnit f40701b;
        final Scheduler f40702c;
        final int f40703d;
        Subscription f40704e;
        UnicastProcessor<T> f40705f;
        final SequentialDisposable f40706g = new SequentialDisposable();
        volatile boolean f40707i;

        WindowExactUnboundedSubscriber(Subscriber<? super Flowable<T>> subscriber, long j, TimeUnit timeUnit, Scheduler scheduler, int i) {
            super(subscriber, new MpscLinkedQueue());
            this.f40700a = j;
            this.f40701b = timeUnit;
            this.f40702c = scheduler;
            this.f40703d = i;
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32781a(this.f40704e, subscription)) {
                this.f40704e = subscription;
                this.f40705f = UnicastProcessor.m38166a(this.f40703d);
                Subscriber subscriber = this.n;
                subscriber.mo5623a(this);
                long j = this.s.get();
                if (j != 0) {
                    subscriber.onNext(this.f40705f);
                    if (j != Long.MAX_VALUE) {
                        mo7608j();
                    }
                    if (!this.p && DisposableHelper.m32094c(this.f40706g, this.f40702c.mo5675a(this, this.f40700a, this.f40700a, this.f40701b))) {
                        subscription.request(Long.MAX_VALUE);
                    }
                } else {
                    this.p = true;
                    subscription.cancel();
                    subscriber.onError(new MissingBackpressureException("Could not deliver first window due to lack of requests."));
                }
            }
        }

        public final void onNext(T t) {
            if (!this.f40707i) {
                if (m41405g()) {
                    this.f40705f.onNext(t);
                    if (mo7602a(-1) == null) {
                        return;
                    }
                }
                this.o.offer(NotificationLite.m26696a((Object) t));
                if (m41404f() == null) {
                    return;
                }
                m42368b();
            }
        }

        public final void onError(Throwable th) {
            this.r = th;
            this.q = true;
            if (m41404f()) {
                m42368b();
            }
            this.n.onError(th);
            m42367a();
        }

        public final void onComplete() {
            this.q = true;
            if (m41404f()) {
                m42368b();
            }
            this.n.onComplete();
            m42367a();
        }

        public final void request(long j) {
            m41398a(j);
        }

        public final void cancel() {
            this.p = true;
        }

        private void m42367a() {
            DisposableHelper.m32090a(this.f40706g);
        }

        public final void run() {
            if (this.p) {
                this.f40707i = true;
                m42367a();
            }
            this.o.offer(f40699h);
            if (m41404f()) {
                m42368b();
            }
        }

        private void m42368b() {
            SimplePlainQueue simplePlainQueue = this.o;
            Subscriber subscriber = this.n;
            UnicastProcessor unicastProcessor = this.f40705f;
            int i = 1;
            while (true) {
                boolean z = this.f40707i;
                boolean z2 = this.q;
                Object poll = simplePlainQueue.poll();
                if (!(z2 && (poll == null || poll == f40699h))) {
                    if (poll == null) {
                        i = mo7602a(-i);
                        if (i == 0) {
                            return;
                        }
                    } else if (poll == f40699h) {
                        unicastProcessor.onComplete();
                        if (z) {
                            this.f40704e.cancel();
                        } else {
                            unicastProcessor = UnicastProcessor.m38166a(this.f40703d);
                            this.f40705f = unicastProcessor;
                            long j = this.s.get();
                            if (j != 0) {
                                subscriber.onNext(unicastProcessor);
                                if (j != Long.MAX_VALUE) {
                                    mo7608j();
                                }
                            } else {
                                this.f40705f = null;
                                this.o.clear();
                                this.f40704e.cancel();
                                m42367a();
                                subscriber.onError(new MissingBackpressureException("Could not deliver first window due to lack of requests."));
                                return;
                            }
                        }
                    } else {
                        unicastProcessor.onNext(NotificationLite.m26706e(poll));
                    }
                }
            }
            this.f40705f = null;
            simplePlainQueue.clear();
            m42367a();
            Throwable th = this.r;
            if (th != null) {
                unicastProcessor.onError(th);
            } else {
                unicastProcessor.onComplete();
            }
        }
    }

    static final class WindowSkipSubscriber<T> extends QueueDrainSubscriber<T, Object, Flowable<T>> implements Runnable, Subscription {
        final long f40708a;
        final long f40709b;
        final TimeUnit f40710c;
        final Worker f40711d;
        final int f40712e;
        final List<UnicastProcessor<T>> f40713f = new LinkedList();
        Subscription f40714g;
        volatile boolean f40715h;

        final class Completion implements Runnable {
            final /* synthetic */ WindowSkipSubscriber f25087a;
            private final UnicastProcessor<T> f25088b;

            Completion(WindowSkipSubscriber windowSkipSubscriber, UnicastProcessor<T> unicastProcessor) {
                this.f25087a = windowSkipSubscriber;
                this.f25088b = unicastProcessor;
            }

            public final void run() {
                this.f25087a.m42371a(this.f25088b);
            }
        }

        static final class SubjectWork<T> {
            final UnicastProcessor<T> f25089a;
            final boolean f25090b;

            SubjectWork(UnicastProcessor<T> unicastProcessor, boolean z) {
                this.f25089a = unicastProcessor;
                this.f25090b = z;
            }
        }

        WindowSkipSubscriber(Subscriber<? super Flowable<T>> subscriber, long j, long j2, TimeUnit timeUnit, Worker worker, int i) {
            super(subscriber, new MpscLinkedQueue());
            this.f40708a = j;
            this.f40709b = j2;
            this.f40710c = timeUnit;
            this.f40711d = worker;
            this.f40712e = i;
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32781a(this.f40714g, subscription)) {
                this.f40714g = subscription;
                this.n.mo5623a(this);
                if (!this.p) {
                    long j = this.s.get();
                    if (j != 0) {
                        UnicastProcessor a = UnicastProcessor.m38166a(this.f40712e);
                        this.f40713f.add(a);
                        this.n.onNext(a);
                        if (j != Long.MAX_VALUE) {
                            mo7608j();
                        }
                        this.f40711d.mo6607a(new Completion(this, a), this.f40708a, this.f40710c);
                        this.f40711d.mo6652a(this, this.f40709b, this.f40709b, this.f40710c);
                        subscription.request(Long.MAX_VALUE);
                        return;
                    }
                    subscription.cancel();
                    this.n.onError(new MissingBackpressureException("Could not emit the first window due to lack of requests"));
                }
            }
        }

        public final void onNext(T t) {
            if (m41405g()) {
                for (UnicastProcessor onNext : this.f40713f) {
                    onNext.onNext(t);
                }
                if (mo7602a(-1) == null) {
                    return;
                }
            }
            this.o.offer(t);
            if (m41404f() == null) {
                return;
            }
            m42370a();
        }

        public final void onError(Throwable th) {
            this.r = th;
            this.q = true;
            if (m41404f()) {
                m42370a();
            }
            this.n.onError(th);
            this.f40711d.mo5626a();
        }

        public final void onComplete() {
            this.q = true;
            if (m41404f()) {
                m42370a();
            }
            this.n.onComplete();
            this.f40711d.mo5626a();
        }

        public final void request(long j) {
            m41398a(j);
        }

        public final void cancel() {
            this.p = true;
        }

        final void m42371a(UnicastProcessor<T> unicastProcessor) {
            this.o.offer(new SubjectWork(unicastProcessor, false));
            if (m41404f() != null) {
                m42370a();
            }
        }

        private void m42370a() {
            SimplePlainQueue simplePlainQueue = this.o;
            Subscriber subscriber = this.n;
            List<UnicastProcessor> list = this.f40713f;
            int i = 1;
            while (!this.f40715h) {
                boolean z = this.q;
                Object poll = simplePlainQueue.poll();
                boolean z2 = poll == null;
                boolean z3 = poll instanceof SubjectWork;
                if (z && (z2 || z3)) {
                    simplePlainQueue.clear();
                    Throwable th = this.r;
                    if (th != null) {
                        for (UnicastProcessor onError : list) {
                            onError.onError(th);
                        }
                    } else {
                        for (UnicastProcessor onComplete : list) {
                            onComplete.onComplete();
                        }
                    }
                    list.clear();
                    this.f40711d.mo5626a();
                    return;
                } else if (z2) {
                    i = mo7602a(-i);
                    if (i == 0) {
                        return;
                    }
                } else if (z3) {
                    SubjectWork subjectWork = (SubjectWork) poll;
                    if (!subjectWork.f25090b) {
                        list.remove(subjectWork.f25089a);
                        subjectWork.f25089a.onComplete();
                        if (list.isEmpty() && this.p) {
                            this.f40715h = true;
                        }
                    } else if (!this.p) {
                        long j = this.s.get();
                        if (j != 0) {
                            r7 = UnicastProcessor.m38166a(this.f40712e);
                            list.add(r7);
                            subscriber.onNext(r7);
                            if (j != Long.MAX_VALUE) {
                                mo7608j();
                            }
                            this.f40711d.mo6607a(new Completion(this, r7), this.f40708a, this.f40710c);
                        } else {
                            subscriber.onError(new MissingBackpressureException("Can't emit window due to lack of requests"));
                        }
                    }
                } else {
                    for (UnicastProcessor onNext : list) {
                        onNext.onNext(poll);
                    }
                }
            }
            this.f40714g.cancel();
            this.f40711d.mo5626a();
            simplePlainQueue.clear();
            list.clear();
        }

        public final void run() {
            SubjectWork subjectWork = new SubjectWork(UnicastProcessor.m38166a(this.f40712e), true);
            if (!this.p) {
                this.o.offer(subjectWork);
            }
            if (m41404f()) {
                m42370a();
            }
        }
    }

    public FlowableWindowTimed(Flowable<T> flowable, long j, long j2, TimeUnit timeUnit, Scheduler scheduler, long j3, int i, boolean z) {
        super(flowable);
        this.f37881a = j;
        this.f37882b = j2;
        this.f37883c = timeUnit;
        this.f37884d = scheduler;
        this.f37885e = j3;
        this.f37886f = i;
        this.f37887g = z;
    }

    protected final void subscribeActual(Subscriber<? super Flowable<T>> subscriber) {
        Subscriber serializedSubscriber = new SerializedSubscriber(subscriber);
        if (this.f37881a != this.f37882b) {
            this.source.subscribe(new WindowSkipSubscriber(serializedSubscriber, this.f37881a, this.f37882b, this.f37883c, this.f37884d.mo5629a(), this.f37886f));
        } else if (this.f37885e == Long.MAX_VALUE) {
            this.source.subscribe(new WindowExactUnboundedSubscriber(serializedSubscriber, this.f37881a, this.f37883c, this.f37884d, this.f37886f));
        } else {
            this.source.subscribe(new WindowExactBoundedSubscriber(serializedSubscriber, this.f37881a, this.f37883c, this.f37884d, this.f37886f, this.f37885e, this.f37887g));
        }
    }
}
