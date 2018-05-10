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
import io.reactivex.processors.UnicastProcessor;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableGroupJoin<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AbstractFlowableWithUpstream<TLeft, R> {
    final Publisher<? extends TRight> f37742a;
    final Function<? super TLeft, ? extends Publisher<TLeftEnd>> f37743b;
    final Function<? super TRight, ? extends Publisher<TRightEnd>> f37744c;
    final BiFunction<? super TLeft, ? super Flowable<TRight>, ? extends R> f37745d;

    interface JoinSupport {
        void mo5644a(LeftRightSubscriber leftRightSubscriber);

        void mo5645a(Throwable th);

        void mo5646a(boolean z, LeftRightEndSubscriber leftRightEndSubscriber);

        void mo5647a(boolean z, Object obj);

        void mo5648b(Throwable th);
    }

    static final class GroupJoinSubscription<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AtomicInteger implements JoinSupport, Subscription {
        static final Integer f31275o = Integer.valueOf(1);
        static final Integer f31276p = Integer.valueOf(2);
        static final Integer f31277q = Integer.valueOf(3);
        static final Integer f31278r = Integer.valueOf(4);
        final Subscriber<? super R> f31279a;
        final AtomicLong f31280b = new AtomicLong();
        final SpscLinkedArrayQueue<Object> f31281c = new SpscLinkedArrayQueue(Flowable.bufferSize());
        final CompositeDisposable f31282d = new CompositeDisposable();
        final Map<Integer, UnicastProcessor<TRight>> f31283e = new LinkedHashMap();
        final Map<Integer, TRight> f31284f = new LinkedHashMap();
        final AtomicReference<Throwable> f31285g = new AtomicReference();
        final Function<? super TLeft, ? extends Publisher<TLeftEnd>> f31286h;
        final Function<? super TRight, ? extends Publisher<TRightEnd>> f31287i;
        final BiFunction<? super TLeft, ? super Flowable<TRight>, ? extends R> f31288j;
        final AtomicInteger f31289k;
        int f31290l;
        int f31291m;
        volatile boolean f31292n;

        GroupJoinSubscription(Subscriber<? super R> subscriber, Function<? super TLeft, ? extends Publisher<TLeftEnd>> function, Function<? super TRight, ? extends Publisher<TRightEnd>> function2, BiFunction<? super TLeft, ? super Flowable<TRight>, ? extends R> biFunction) {
            this.f31279a = subscriber;
            this.f31286h = function;
            this.f31287i = function2;
            this.f31288j = biFunction;
            this.f31289k = new AtomicInteger(2);
        }

        public final void request(long j) {
            if (SubscriptionHelper.m32776a(j)) {
                BackpressureHelper.m26670a(this.f31280b, j);
            }
        }

        public final void cancel() {
            if (!this.f31292n) {
                this.f31292n = true;
                this.f31282d.mo5626a();
                if (getAndIncrement() == 0) {
                    this.f31281c.clear();
                }
            }
        }

        private void m32190a(Subscriber<?> subscriber) {
            Throwable a = ExceptionHelper.m26683a(this.f31285g);
            for (UnicastProcessor onError : this.f31283e.values()) {
                onError.onError(a);
            }
            this.f31283e.clear();
            this.f31284f.clear();
            subscriber.onError(a);
        }

        private void m32189a(Throwable th, Subscriber<?> subscriber, SimpleQueue<?> simpleQueue) {
            Exceptions.m26521b(th);
            ExceptionHelper.m26684a(this.f31285g, th);
            simpleQueue.clear();
            this.f31282d.mo5626a();
            m32190a((Subscriber) subscriber);
        }

        private void m32188a() {
            if (getAndIncrement() == 0) {
                SpscLinkedArrayQueue spscLinkedArrayQueue = this.f31281c;
                Subscriber subscriber = this.f31279a;
                int i = 1;
                while (!this.f31292n) {
                    if (((Throwable) this.f31285g.get()) != null) {
                        spscLinkedArrayQueue.clear();
                        this.f31282d.mo5626a();
                        m32190a(subscriber);
                        return;
                    }
                    boolean z = this.f31289k.get() == 0;
                    Integer num = (Integer) spscLinkedArrayQueue.poll();
                    boolean z2 = num == null;
                    if (z && z2) {
                        for (UnicastProcessor onComplete : this.f31283e.values()) {
                            onComplete.onComplete();
                        }
                        this.f31283e.clear();
                        this.f31284f.clear();
                        this.f31282d.mo5626a();
                        subscriber.onComplete();
                        return;
                    } else if (z2) {
                        i = addAndGet(-i);
                        if (i == 0) {
                            return;
                        }
                    } else {
                        Object poll = spscLinkedArrayQueue.poll();
                        UnicastProcessor b;
                        int i2;
                        Publisher publisher;
                        Disposable leftRightEndSubscriber;
                        if (num == f31275o) {
                            b = UnicastProcessor.m38169b();
                            i2 = this.f31290l;
                            this.f31290l = i2 + 1;
                            this.f31283e.put(Integer.valueOf(i2), b);
                            try {
                                publisher = (Publisher) ObjectHelper.m26573a(this.f31286h.apply(poll), "The leftEnd returned a null Publisher");
                                leftRightEndSubscriber = new LeftRightEndSubscriber(this, true, i2);
                                this.f31282d.mo5631a(leftRightEndSubscriber);
                                publisher.subscribe(leftRightEndSubscriber);
                                if (((Throwable) this.f31285g.get()) != null) {
                                    spscLinkedArrayQueue.clear();
                                    this.f31282d.mo5626a();
                                    m32190a(subscriber);
                                    return;
                                }
                                try {
                                    poll = ObjectHelper.m26573a(this.f31288j.apply(poll, b), "The resultSelector returned a null value");
                                    if (this.f31280b.get() != 0) {
                                        subscriber.onNext(poll);
                                        BackpressureHelper.m26673c(this.f31280b, 1);
                                        for (Object onNext : this.f31284f.values()) {
                                            b.onNext(onNext);
                                        }
                                    } else {
                                        m32189a(new MissingBackpressureException("Could not emit value due to lack of requests"), subscriber, spscLinkedArrayQueue);
                                        return;
                                    }
                                } catch (Throwable th) {
                                    m32189a(th, subscriber, spscLinkedArrayQueue);
                                    return;
                                }
                            } catch (Throwable th2) {
                                m32189a(th2, subscriber, spscLinkedArrayQueue);
                                return;
                            }
                        } else if (num == f31276p) {
                            i2 = this.f31291m;
                            this.f31291m = i2 + 1;
                            this.f31284f.put(Integer.valueOf(i2), poll);
                            try {
                                publisher = (Publisher) ObjectHelper.m26573a(this.f31287i.apply(poll), "The rightEnd returned a null Publisher");
                                leftRightEndSubscriber = new LeftRightEndSubscriber(this, false, i2);
                                this.f31282d.mo5631a(leftRightEndSubscriber);
                                publisher.subscribe(leftRightEndSubscriber);
                                if (((Throwable) this.f31285g.get()) != null) {
                                    spscLinkedArrayQueue.clear();
                                    this.f31282d.mo5626a();
                                    m32190a(subscriber);
                                    return;
                                }
                                for (UnicastProcessor onNext2 : this.f31283e.values()) {
                                    onNext2.onNext(poll);
                                }
                            } catch (Throwable th22) {
                                m32189a(th22, subscriber, spscLinkedArrayQueue);
                                return;
                            }
                        } else if (num == f31277q) {
                            r4 = (LeftRightEndSubscriber) poll;
                            b = (UnicastProcessor) this.f31283e.remove(Integer.valueOf(r4.f35081c));
                            this.f31282d.mo5632b(r4);
                            if (b != null) {
                                b.onComplete();
                            }
                        } else if (num == f31278r) {
                            r4 = (LeftRightEndSubscriber) poll;
                            this.f31284f.remove(Integer.valueOf(r4.f35081c));
                            this.f31282d.mo5632b(r4);
                        }
                    }
                }
                spscLinkedArrayQueue.clear();
            }
        }

        public final void mo5645a(Throwable th) {
            if (ExceptionHelper.m26684a(this.f31285g, th)) {
                this.f31289k.decrementAndGet();
                m32188a();
                return;
            }
            RxJavaPlugins.m26757a(th);
        }

        public final void mo5644a(LeftRightSubscriber leftRightSubscriber) {
            this.f31282d.mo5633c(leftRightSubscriber);
            this.f31289k.decrementAndGet();
            m32188a();
        }

        public final void mo5647a(boolean z, Object obj) {
            synchronized (this) {
                this.f31281c.m35964a(z ? f31275o : f31276p, obj);
            }
            m32188a();
        }

        public final void mo5646a(boolean z, LeftRightEndSubscriber leftRightEndSubscriber) {
            synchronized (this) {
                this.f31281c.m35964a(z ? f31277q : f31278r, (Object) leftRightEndSubscriber);
            }
            m32188a();
        }

        public final void mo5648b(Throwable th) {
            if (ExceptionHelper.m26684a(this.f31285g, th)) {
                m32188a();
            } else {
                RxJavaPlugins.m26757a(th);
            }
        }
    }

    static final class LeftRightEndSubscriber extends AtomicReference<Subscription> implements FlowableSubscriber<Object>, Disposable {
        final JoinSupport f35079a;
        final boolean f35080b;
        final int f35081c;

        LeftRightEndSubscriber(JoinSupport joinSupport, boolean z, int i) {
            this.f35079a = joinSupport;
            this.f35080b = z;
            this.f35081c = i;
        }

        public final void mo5626a() {
            SubscriptionHelper.m32777a((AtomicReference) this);
        }

        public final boolean mo5627b() {
            return SubscriptionHelper.m32780a((Subscription) get());
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32779a((AtomicReference) this, subscription)) {
                subscription.request(Long.MAX_VALUE);
            }
        }

        public final void onNext(Object obj) {
            if (SubscriptionHelper.m32777a((AtomicReference) this) != null) {
                this.f35079a.mo5646a(this.f35080b, this);
            }
        }

        public final void onError(Throwable th) {
            this.f35079a.mo5648b(th);
        }

        public final void onComplete() {
            this.f35079a.mo5646a(this.f35080b, this);
        }
    }

    static final class LeftRightSubscriber extends AtomicReference<Subscription> implements FlowableSubscriber<Object>, Disposable {
        final JoinSupport f35082a;
        final boolean f35083b;

        LeftRightSubscriber(JoinSupport joinSupport, boolean z) {
            this.f35082a = joinSupport;
            this.f35083b = z;
        }

        public final void mo5626a() {
            SubscriptionHelper.m32777a((AtomicReference) this);
        }

        public final boolean mo5627b() {
            return SubscriptionHelper.m32780a((Subscription) get());
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32779a((AtomicReference) this, subscription)) {
                subscription.request(Long.MAX_VALUE);
            }
        }

        public final void onNext(Object obj) {
            this.f35082a.mo5647a(this.f35083b, obj);
        }

        public final void onError(Throwable th) {
            this.f35082a.mo5645a(th);
        }

        public final void onComplete() {
            this.f35082a.mo5644a(this);
        }
    }

    public FlowableGroupJoin(Flowable<TLeft> flowable, Publisher<? extends TRight> publisher, Function<? super TLeft, ? extends Publisher<TLeftEnd>> function, Function<? super TRight, ? extends Publisher<TRightEnd>> function2, BiFunction<? super TLeft, ? super Flowable<TRight>, ? extends R> biFunction) {
        super(flowable);
        this.f37742a = publisher;
        this.f37743b = function;
        this.f37744c = function2;
        this.f37745d = biFunction;
    }

    protected final void subscribeActual(Subscriber<? super R> subscriber) {
        Object groupJoinSubscription = new GroupJoinSubscription(subscriber, this.f37743b, this.f37744c, this.f37745d);
        subscriber.mo5623a(groupJoinSubscription);
        FlowableSubscriber leftRightSubscriber = new LeftRightSubscriber(groupJoinSubscription, true);
        groupJoinSubscription.f31282d.mo5631a((Disposable) leftRightSubscriber);
        Disposable leftRightSubscriber2 = new LeftRightSubscriber(groupJoinSubscription, false);
        groupJoinSubscription.f31282d.mo5631a(leftRightSubscriber2);
        this.source.subscribe(leftRightSubscriber);
        this.f37742a.subscribe(leftRightSubscriber2);
    }
}
