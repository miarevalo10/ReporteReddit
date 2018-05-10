package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableConcatMap<T, R> extends AbstractFlowableWithUpstream<T, R> {
    final Function<? super T, ? extends Publisher<? extends R>> f37668a;
    final int f37669b;
    final ErrorMode f37670c;

    interface ConcatMapSupport<T> {
        void mo7040a(T t);

        void mo7041a(Throwable th);

        void mo6618c();
    }

    static final class WeakScalarSubscription<T> implements Subscription {
        final Subscriber<? super T> f31252a;
        final T f31253b;
        boolean f31254c;

        public final void cancel() {
        }

        WeakScalarSubscription(T t, Subscriber<? super T> subscriber) {
            this.f31253b = t;
            this.f31252a = subscriber;
        }

        public final void request(long j) {
            if (j > 0 && this.f31254c == null) {
                this.f31254c = 1;
                j = this.f31252a;
                j.onNext(this.f31253b);
                j.onComplete();
            }
        }
    }

    static abstract class BaseConcatMapSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, ConcatMapSupport<R>, Subscription {
        final ConcatMapInner<R> f34899a = new ConcatMapInner(this);
        final Function<? super T, ? extends Publisher<? extends R>> f34900b;
        final int f34901c;
        final int f34902d;
        Subscription f34903e;
        int f34904f;
        SimpleQueue<T> f34905g;
        volatile boolean f34906h;
        volatile boolean f34907i;
        final AtomicThrowable f34908j = new AtomicThrowable();
        volatile boolean f34909k;
        int f34910l;

        abstract void mo7039a();

        abstract void mo7042b();

        BaseConcatMapSubscriber(Function<? super T, ? extends Publisher<? extends R>> function, int i) {
            this.f34900b = function;
            this.f34901c = i;
            this.f34902d = i - (i >> 2);
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32781a(this.f34903e, subscription)) {
                this.f34903e = subscription;
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int a = queueSubscription.mo7033a(3);
                    if (a == 1) {
                        this.f34910l = a;
                        this.f34905g = queueSubscription;
                        this.f34906h = true;
                        mo7042b();
                        mo7039a();
                        return;
                    } else if (a == 2) {
                        this.f34910l = a;
                        this.f34905g = queueSubscription;
                        mo7042b();
                        subscription.request((long) this.f34901c);
                        return;
                    }
                }
                this.f34905g = new SpscArrayQueue(this.f34901c);
                mo7042b();
                subscription.request((long) this.f34901c);
            }
        }

        public final void onNext(T t) {
            if (this.f34910l == 2 || this.f34905g.offer(t) != null) {
                mo7039a();
                return;
            }
            this.f34903e.cancel();
            onError(new IllegalStateException("Queue full?!"));
        }

        public final void onComplete() {
            this.f34906h = true;
            mo7039a();
        }

        public final void mo6618c() {
            this.f34909k = false;
            mo7039a();
        }
    }

    static final class ConcatMapInner<R> extends SubscriptionArbiter implements FlowableSubscriber<R> {
        final ConcatMapSupport<R> f34911a;
        long f34912b;

        ConcatMapInner(ConcatMapSupport<R> concatMapSupport) {
            this.f34911a = concatMapSupport;
        }

        public final void mo5623a(Subscription subscription) {
            m32772b(subscription);
        }

        public final void onNext(R r) {
            this.f34912b++;
            this.f34911a.mo7040a((Object) r);
        }

        public final void onError(Throwable th) {
            long j = this.f34912b;
            if (j != 0) {
                this.f34912b = 0;
                m32773c(j);
            }
            this.f34911a.mo7041a(th);
        }

        public final void onComplete() {
            long j = this.f34912b;
            if (j != 0) {
                this.f34912b = 0;
                m32773c(j);
            }
            this.f34911a.mo6618c();
        }
    }

    static final class ConcatMapDelayed<T, R> extends BaseConcatMapSubscriber<T, R> {
        final Subscriber<? super R> f37664m;
        final boolean f37665n;

        ConcatMapDelayed(Subscriber<? super R> subscriber, Function<? super T, ? extends Publisher<? extends R>> function, int i, boolean z) {
            super(function, i);
            this.f37664m = subscriber;
            this.f37665n = z;
        }

        final void mo7042b() {
            this.f37664m.mo5623a(this);
        }

        public final void onError(Throwable th) {
            if (ExceptionHelper.m26684a(this.j, th)) {
                this.h = true;
                mo7039a();
                return;
            }
            RxJavaPlugins.m26757a(th);
        }

        public final void mo7040a(R r) {
            this.f37664m.onNext(r);
        }

        public final void mo7041a(Throwable th) {
            if (ExceptionHelper.m26684a(this.j, th)) {
                if (this.f37665n == null) {
                    this.e.cancel();
                    this.h = true;
                }
                this.k = null;
                mo7039a();
                return;
            }
            RxJavaPlugins.m26757a(th);
        }

        public final void request(long j) {
            this.a.request(j);
        }

        public final void cancel() {
            if (!this.i) {
                this.i = true;
                this.a.cancel();
                this.e.cancel();
            }
        }

        final void mo7039a() {
            if (getAndIncrement() == 0) {
                while (!this.i) {
                    if (!this.k) {
                        boolean z = this.h;
                        if (!z || this.f37665n || ((Throwable) this.j.get()) == null) {
                            Throwable a;
                            try {
                                Object poll = this.g.poll();
                                boolean z2 = poll == null;
                                if (z && z2) {
                                    a = ExceptionHelper.m26683a(this.j);
                                    if (a != null) {
                                        this.f37664m.onError(a);
                                        return;
                                    } else {
                                        this.f37664m.onComplete();
                                        return;
                                    }
                                } else if (!z2) {
                                    try {
                                        Publisher publisher = (Publisher) ObjectHelper.m26573a(this.b.apply(poll), "The mapper returned a null Publisher");
                                        if (this.l != 1) {
                                            int i = this.f + 1;
                                            if (i == this.d) {
                                                this.f = 0;
                                                this.e.request((long) i);
                                            } else {
                                                this.f = i;
                                            }
                                        }
                                        if (publisher instanceof Callable) {
                                            try {
                                                Object call = ((Callable) publisher).call();
                                                if (call == null) {
                                                    continue;
                                                } else if (this.a.m32771a()) {
                                                    this.f37664m.onNext(call);
                                                } else {
                                                    this.k = true;
                                                    this.a.m32772b(new WeakScalarSubscription(call, this.a));
                                                }
                                            } catch (Throwable a2) {
                                                Exceptions.m26521b(a2);
                                                this.e.cancel();
                                                ExceptionHelper.m26684a(this.j, a2);
                                                this.f37664m.onError(ExceptionHelper.m26683a(this.j));
                                                return;
                                            }
                                        }
                                        this.k = true;
                                        publisher.subscribe(this.a);
                                    } catch (Throwable a22) {
                                        Exceptions.m26521b(a22);
                                        this.e.cancel();
                                        ExceptionHelper.m26684a(this.j, a22);
                                        this.f37664m.onError(ExceptionHelper.m26683a(this.j));
                                        return;
                                    }
                                }
                            } catch (Throwable a222) {
                                Exceptions.m26521b(a222);
                                this.e.cancel();
                                ExceptionHelper.m26684a(this.j, a222);
                                this.f37664m.onError(ExceptionHelper.m26683a(this.j));
                                return;
                            }
                        }
                        this.f37664m.onError(ExceptionHelper.m26683a(this.j));
                        return;
                    }
                    if (decrementAndGet() == 0) {
                    }
                }
            }
        }
    }

    static final class ConcatMapImmediate<T, R> extends BaseConcatMapSubscriber<T, R> {
        final Subscriber<? super R> f37666m;
        final AtomicInteger f37667n = new AtomicInteger();

        ConcatMapImmediate(Subscriber<? super R> subscriber, Function<? super T, ? extends Publisher<? extends R>> function, int i) {
            super(function, i);
            this.f37666m = subscriber;
        }

        final void mo7042b() {
            this.f37666m.mo5623a(this);
        }

        public final void onError(Throwable th) {
            if (ExceptionHelper.m26684a(this.j, th)) {
                this.a.cancel();
                if (getAndIncrement() == null) {
                    this.f37666m.onError(ExceptionHelper.m26683a(this.j));
                    return;
                }
            }
            RxJavaPlugins.m26757a(th);
        }

        public final void mo7040a(R r) {
            if (get() == 0 && compareAndSet(0, 1)) {
                this.f37666m.onNext(r);
                if (compareAndSet(1, 0) == null) {
                    this.f37666m.onError(ExceptionHelper.m26683a(this.j));
                }
            }
        }

        public final void mo7041a(Throwable th) {
            if (ExceptionHelper.m26684a(this.j, th)) {
                this.e.cancel();
                if (getAndIncrement() == null) {
                    this.f37666m.onError(ExceptionHelper.m26683a(this.j));
                    return;
                }
            }
            RxJavaPlugins.m26757a(th);
        }

        public final void request(long j) {
            this.a.request(j);
        }

        public final void cancel() {
            if (!this.i) {
                this.i = true;
                this.a.cancel();
                this.e.cancel();
            }
        }

        final void mo7039a() {
            if (this.f37667n.getAndIncrement() == 0) {
                while (!this.i) {
                    if (!this.k) {
                        boolean z = this.h;
                        try {
                            Object poll = this.g.poll();
                            boolean z2 = poll == null;
                            if (z && z2) {
                                this.f37666m.onComplete();
                                return;
                            } else if (!z2) {
                                try {
                                    Publisher publisher = (Publisher) ObjectHelper.m26573a(this.b.apply(poll), "The mapper returned a null Publisher");
                                    if (this.l != 1) {
                                        int i = this.f + 1;
                                        if (i == this.d) {
                                            this.f = 0;
                                            this.e.request((long) i);
                                        } else {
                                            this.f = i;
                                        }
                                    }
                                    if (publisher instanceof Callable) {
                                        try {
                                            Object call = ((Callable) publisher).call();
                                            if (call == null) {
                                                continue;
                                            } else if (!this.a.m32771a()) {
                                                this.k = true;
                                                this.a.m32772b(new WeakScalarSubscription(call, this.a));
                                            } else if (get() == 0 && compareAndSet(0, 1)) {
                                                this.f37666m.onNext(call);
                                                if (!compareAndSet(1, 0)) {
                                                    this.f37666m.onError(ExceptionHelper.m26683a(this.j));
                                                    return;
                                                }
                                            }
                                        } catch (Throwable th) {
                                            Exceptions.m26521b(th);
                                            this.e.cancel();
                                            ExceptionHelper.m26684a(this.j, th);
                                            this.f37666m.onError(ExceptionHelper.m26683a(this.j));
                                            return;
                                        }
                                    }
                                    this.k = true;
                                    publisher.subscribe(this.a);
                                } catch (Throwable th2) {
                                    Exceptions.m26521b(th2);
                                    this.e.cancel();
                                    ExceptionHelper.m26684a(this.j, th2);
                                    this.f37666m.onError(ExceptionHelper.m26683a(this.j));
                                    return;
                                }
                            }
                        } catch (Throwable th22) {
                            Exceptions.m26521b(th22);
                            this.e.cancel();
                            ExceptionHelper.m26684a(this.j, th22);
                            this.f37666m.onError(ExceptionHelper.m26683a(this.j));
                            return;
                        }
                    }
                    if (this.f37667n.decrementAndGet() == 0) {
                    }
                }
            }
        }
    }

    public FlowableConcatMap(Flowable<T> flowable, Function<? super T, ? extends Publisher<? extends R>> function, int i, ErrorMode errorMode) {
        super(flowable);
        this.f37668a = function;
        this.f37669b = i;
        this.f37670c = errorMode;
    }

    public static <T, R> Subscriber<T> m38086a(Subscriber<? super R> subscriber, Function<? super T, ? extends Publisher<? extends R>> function, int i, ErrorMode errorMode) {
        switch (errorMode) {
            case BOUNDARY:
                return new ConcatMapDelayed(subscriber, function, i, false);
            case END:
                return new ConcatMapDelayed(subscriber, function, i, true);
            default:
                return new ConcatMapImmediate(subscriber, function, i);
        }
    }

    protected final void subscribeActual(Subscriber<? super R> subscriber) {
        if (!FlowableScalarXMap.m26613a(this.source, subscriber, this.f37668a)) {
            this.source.subscribe(m38086a(subscriber, this.f37668a, this.f37669b, this.f37670c));
        }
    }
}
