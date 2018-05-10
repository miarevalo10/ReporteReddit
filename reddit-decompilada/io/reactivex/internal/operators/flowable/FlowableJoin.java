package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableJoin<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AbstractFlowableWithUpstream<TLeft, R> {
    final Publisher<? extends TRight> f37748a;
    final Function<? super TLeft, ? extends Publisher<TLeftEnd>> f37749b;
    final Function<? super TRight, ? extends Publisher<TRightEnd>> f37750c;
    final BiFunction<? super TLeft, ? super TRight, ? extends R> f37751d;

    static final class JoinSubscription<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AtomicInteger implements JoinSupport, Subscription {
        static final Integer f31316o = Integer.valueOf(1);
        static final Integer f31317p = Integer.valueOf(2);
        static final Integer f31318q = Integer.valueOf(3);
        static final Integer f31319r = Integer.valueOf(4);
        final Subscriber<? super R> f31320a;
        final AtomicLong f31321b = new AtomicLong();
        final SpscLinkedArrayQueue<Object> f31322c = new SpscLinkedArrayQueue(Flowable.bufferSize());
        final CompositeDisposable f31323d = new CompositeDisposable();
        final Map<Integer, TLeft> f31324e = new LinkedHashMap();
        final Map<Integer, TRight> f31325f = new LinkedHashMap();
        final AtomicReference<Throwable> f31326g = new AtomicReference();
        final Function<? super TLeft, ? extends Publisher<TLeftEnd>> f31327h;
        final Function<? super TRight, ? extends Publisher<TRightEnd>> f31328i;
        final BiFunction<? super TLeft, ? super TRight, ? extends R> f31329j;
        final AtomicInteger f31330k;
        int f31331l;
        int f31332m;
        volatile boolean f31333n;

        JoinSubscription(Subscriber<? super R> subscriber, Function<? super TLeft, ? extends Publisher<TLeftEnd>> function, Function<? super TRight, ? extends Publisher<TRightEnd>> function2, BiFunction<? super TLeft, ? super TRight, ? extends R> biFunction) {
            this.f31320a = subscriber;
            this.f31327h = function;
            this.f31328i = function2;
            this.f31329j = biFunction;
            this.f31330k = new AtomicInteger(2);
        }

        public final void request(long j) {
            if (SubscriptionHelper.m32776a(j)) {
                BackpressureHelper.m26670a(this.f31321b, j);
            }
        }

        public final void cancel() {
            if (!this.f31333n) {
                this.f31333n = true;
                this.f31323d.mo5626a();
                if (getAndIncrement() == 0) {
                    this.f31322c.clear();
                }
            }
        }

        private void m32200a(Subscriber<?> subscriber) {
            Throwable a = ExceptionHelper.m26683a(this.f31326g);
            this.f31324e.clear();
            this.f31325f.clear();
            subscriber.onError(a);
        }

        private void m32199a(Throwable th, Subscriber<?> subscriber, SimpleQueue<?> simpleQueue) {
            Exceptions.m26521b(th);
            ExceptionHelper.m26684a(this.f31326g, th);
            simpleQueue.clear();
            this.f31323d.mo5626a();
            m32200a((Subscriber) subscriber);
        }

        private void m32198a() {
            JoinSubscription joinSubscription = this;
            if (getAndIncrement() == 0) {
                SpscLinkedArrayQueue spscLinkedArrayQueue = joinSubscription.f31322c;
                Subscriber subscriber = joinSubscription.f31320a;
                boolean z = true;
                int i = 1;
                while (!joinSubscription.f31333n) {
                    if (((Throwable) joinSubscription.f31326g.get()) != null) {
                        spscLinkedArrayQueue.clear();
                        joinSubscription.f31323d.mo5626a();
                        m32200a(subscriber);
                        return;
                    }
                    boolean z2 = joinSubscription.f31330k.get() == 0 ? z : false;
                    Integer num = (Integer) spscLinkedArrayQueue.poll();
                    boolean z3 = num == null ? z : false;
                    if (z2 && z3) {
                        joinSubscription.f31324e.clear();
                        joinSubscription.f31325f.clear();
                        joinSubscription.f31323d.mo5626a();
                        subscriber.onComplete();
                        return;
                    }
                    if (z3) {
                        i = addAndGet(-i);
                        if (i == 0) {
                            return;
                        }
                    } else {
                        Object poll = spscLinkedArrayQueue.poll();
                        Publisher publisher;
                        Disposable leftRightEndSubscriber;
                        long j;
                        if (num == f31316o) {
                            int i2 = joinSubscription.f31331l;
                            joinSubscription.f31331l = i2 + 1;
                            joinSubscription.f31324e.put(Integer.valueOf(i2), poll);
                            try {
                                publisher = (Publisher) ObjectHelper.m26573a(joinSubscription.f31327h.apply(poll), "The leftEnd returned a null Publisher");
                                leftRightEndSubscriber = new LeftRightEndSubscriber(joinSubscription, z, i2);
                                joinSubscription.f31323d.mo5631a(leftRightEndSubscriber);
                                publisher.subscribe(leftRightEndSubscriber);
                                if (((Throwable) joinSubscription.f31326g.get()) != null) {
                                    spscLinkedArrayQueue.clear();
                                    joinSubscription.f31323d.mo5626a();
                                    m32200a(subscriber);
                                    return;
                                }
                                j = joinSubscription.f31321b.get();
                                long j2 = 0;
                                for (Object apply : joinSubscription.f31325f.values()) {
                                    try {
                                        Object apply2 = ObjectHelper.m26573a(joinSubscription.f31329j.apply(poll, apply2), "The resultSelector returned a null value");
                                        if (j2 != j) {
                                            subscriber.onNext(apply2);
                                            j2++;
                                        } else {
                                            ExceptionHelper.m26684a(joinSubscription.f31326g, new MissingBackpressureException("Could not emit value due to lack of requests"));
                                            spscLinkedArrayQueue.clear();
                                            joinSubscription.f31323d.mo5626a();
                                            m32200a(subscriber);
                                            return;
                                        }
                                    } catch (Throwable th) {
                                        m32199a(th, subscriber, spscLinkedArrayQueue);
                                        return;
                                    }
                                }
                                if (j2 != 0) {
                                    BackpressureHelper.m26673c(joinSubscription.f31321b, j2);
                                }
                            } catch (Throwable th2) {
                                m32199a(th2, subscriber, spscLinkedArrayQueue);
                                return;
                            }
                        } else if (num == f31317p) {
                            int i3 = joinSubscription.f31332m;
                            joinSubscription.f31332m = i3 + 1;
                            joinSubscription.f31325f.put(Integer.valueOf(i3), poll);
                            try {
                                publisher = (Publisher) ObjectHelper.m26573a(joinSubscription.f31328i.apply(poll), "The rightEnd returned a null Publisher");
                                leftRightEndSubscriber = new LeftRightEndSubscriber(joinSubscription, false, i3);
                                joinSubscription.f31323d.mo5631a(leftRightEndSubscriber);
                                publisher.subscribe(leftRightEndSubscriber);
                                if (((Throwable) joinSubscription.f31326g.get()) != null) {
                                    spscLinkedArrayQueue.clear();
                                    joinSubscription.f31323d.mo5626a();
                                    m32200a(subscriber);
                                    return;
                                }
                                j = joinSubscription.f31321b.get();
                                long j3 = 0;
                                for (Object apply3 : joinSubscription.f31324e.values()) {
                                    try {
                                        Object apply32 = ObjectHelper.m26573a(joinSubscription.f31329j.apply(apply32, poll), "The resultSelector returned a null value");
                                        if (j3 != j) {
                                            subscriber.onNext(apply32);
                                            j3++;
                                        } else {
                                            ExceptionHelper.m26684a(joinSubscription.f31326g, new MissingBackpressureException("Could not emit value due to lack of requests"));
                                            spscLinkedArrayQueue.clear();
                                            joinSubscription.f31323d.mo5626a();
                                            m32200a(subscriber);
                                            return;
                                        }
                                    } catch (Throwable th22) {
                                        m32199a(th22, subscriber, spscLinkedArrayQueue);
                                        return;
                                    }
                                }
                                if (j3 != 0) {
                                    BackpressureHelper.m26673c(joinSubscription.f31321b, j3);
                                }
                            } catch (Throwable th222) {
                                m32199a(th222, subscriber, spscLinkedArrayQueue);
                                return;
                            }
                        } else if (num == f31318q) {
                            r6 = (LeftRightEndSubscriber) poll;
                            joinSubscription.f31324e.remove(Integer.valueOf(r6.f35081c));
                            joinSubscription.f31323d.mo5632b(r6);
                        } else if (num == f31319r) {
                            r6 = (LeftRightEndSubscriber) poll;
                            joinSubscription.f31325f.remove(Integer.valueOf(r6.f35081c));
                            joinSubscription.f31323d.mo5632b(r6);
                        }
                    }
                    z = true;
                }
                spscLinkedArrayQueue.clear();
            }
        }

        public final void mo5645a(Throwable th) {
            if (ExceptionHelper.m26684a(this.f31326g, th)) {
                this.f31330k.decrementAndGet();
                m32198a();
                return;
            }
            RxJavaPlugins.m26757a(th);
        }

        public final void mo5644a(LeftRightSubscriber leftRightSubscriber) {
            this.f31323d.mo5633c(leftRightSubscriber);
            this.f31330k.decrementAndGet();
            m32198a();
        }

        public final void mo5647a(boolean z, Object obj) {
            synchronized (this) {
                this.f31322c.m35964a(z ? f31316o : f31317p, obj);
            }
            m32198a();
        }

        public final void mo5646a(boolean z, LeftRightEndSubscriber leftRightEndSubscriber) {
            synchronized (this) {
                this.f31322c.m35964a(z ? f31318q : f31319r, (Object) leftRightEndSubscriber);
            }
            m32198a();
        }

        public final void mo5648b(Throwable th) {
            if (ExceptionHelper.m26684a(this.f31326g, th)) {
                m32198a();
            } else {
                RxJavaPlugins.m26757a(th);
            }
        }
    }

    public FlowableJoin(Flowable<TLeft> flowable, Publisher<? extends TRight> publisher, Function<? super TLeft, ? extends Publisher<TLeftEnd>> function, Function<? super TRight, ? extends Publisher<TRightEnd>> function2, BiFunction<? super TLeft, ? super TRight, ? extends R> biFunction) {
        super(flowable);
        this.f37748a = publisher;
        this.f37749b = function;
        this.f37750c = function2;
        this.f37751d = biFunction;
    }

    protected final void subscribeActual(Subscriber<? super R> subscriber) {
        Object joinSubscription = new JoinSubscription(subscriber, this.f37749b, this.f37750c, this.f37751d);
        subscriber.mo5623a(joinSubscription);
        FlowableSubscriber leftRightSubscriber = new LeftRightSubscriber(joinSubscription, true);
        joinSubscription.f31323d.mo5631a((Disposable) leftRightSubscriber);
        Disposable leftRightSubscriber2 = new LeftRightSubscriber(joinSubscription, false);
        joinSubscription.f31323d.mo5631a(leftRightSubscriber2);
        this.source.subscribe(leftRightSubscriber);
        this.f37748a.subscribe(leftRightSubscriber2);
    }
}
