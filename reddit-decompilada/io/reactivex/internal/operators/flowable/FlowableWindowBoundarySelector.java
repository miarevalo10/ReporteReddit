package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscribers.QueueDrainSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.processors.UnicastProcessor;
import io.reactivex.subscribers.DisposableSubscriber;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableWindowBoundarySelector<T, B, V> extends AbstractFlowableWithUpstream<T, Flowable<T>> {
    final Publisher<B> f37874a;
    final Function<? super B, ? extends Publisher<V>> f37875b;
    final int f37876c;

    static final class WindowOperation<T, B> {
        final UnicastProcessor<T> f25083a;
        final B f25084b;

        WindowOperation(UnicastProcessor<T> unicastProcessor, B b) {
            this.f25083a = unicastProcessor;
            this.f25084b = b;
        }
    }

    static final class OperatorWindowBoundaryCloseSubscriber<T, V> extends DisposableSubscriber<V> {
        final WindowBoundaryMainSubscriber<T, ?, V> f37869a;
        final UnicastProcessor<T> f37870b;
        boolean f37871c;

        OperatorWindowBoundaryCloseSubscriber(WindowBoundaryMainSubscriber<T, ?, V> windowBoundaryMainSubscriber, UnicastProcessor<T> unicastProcessor) {
            this.f37869a = windowBoundaryMainSubscriber;
            this.f37870b = unicastProcessor;
        }

        public final void onNext(V v) {
            if (this.f37871c == null) {
                this.f37871c = true;
                m36032d();
                this.f37869a.m42354a(this);
            }
        }

        public final void onError(Throwable th) {
            if (this.f37871c) {
                RxJavaPlugins.m26757a(th);
                return;
            }
            this.f37871c = true;
            this.f37869a.m42356a(th);
        }

        public final void onComplete() {
            if (!this.f37871c) {
                this.f37871c = true;
                this.f37869a.m42354a(this);
            }
        }
    }

    static final class OperatorWindowBoundaryOpenSubscriber<T, B> extends DisposableSubscriber<B> {
        final WindowBoundaryMainSubscriber<T, B, ?> f37872a;
        boolean f37873b;

        OperatorWindowBoundaryOpenSubscriber(WindowBoundaryMainSubscriber<T, B, ?> windowBoundaryMainSubscriber) {
            this.f37872a = windowBoundaryMainSubscriber;
        }

        public final void onNext(B b) {
            if (!this.f37873b) {
                this.f37872a.m42355a((Object) b);
            }
        }

        public final void onError(Throwable th) {
            if (this.f37873b) {
                RxJavaPlugins.m26757a(th);
                return;
            }
            this.f37873b = true;
            this.f37872a.m42356a(th);
        }

        public final void onComplete() {
            if (!this.f37873b) {
                this.f37873b = true;
                this.f37872a.onComplete();
            }
        }
    }

    static final class WindowBoundaryMainSubscriber<T, B, V> extends QueueDrainSubscriber<T, Object, Flowable<T>> implements Subscription {
        final Publisher<B> f40671a;
        final Function<? super B, ? extends Publisher<V>> f40672b;
        final int f40673c;
        final CompositeDisposable f40674d;
        Subscription f40675e;
        final AtomicReference<Disposable> f40676f = new AtomicReference();
        final List<UnicastProcessor<T>> f40677g;
        final AtomicLong f40678h = new AtomicLong();

        public final boolean mo7603a(Subscriber<? super Flowable<T>> subscriber, Object obj) {
            return false;
        }

        WindowBoundaryMainSubscriber(Subscriber<? super Flowable<T>> subscriber, Publisher<B> publisher, Function<? super B, ? extends Publisher<V>> function, int i) {
            super(subscriber, new MpscLinkedQueue());
            this.f40671a = publisher;
            this.f40672b = function;
            this.f40673c = i;
            this.f40674d = new CompositeDisposable();
            this.f40677g = new ArrayList();
            this.f40678h.lazySet(1);
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32781a(this.f40675e, subscription)) {
                this.f40675e = subscription;
                this.n.mo5623a(this);
                if (!this.p) {
                    Subscriber operatorWindowBoundaryOpenSubscriber = new OperatorWindowBoundaryOpenSubscriber(this);
                    if (this.f40676f.compareAndSet(null, operatorWindowBoundaryOpenSubscriber)) {
                        this.f40678h.getAndIncrement();
                        subscription.request(Long.MAX_VALUE);
                        this.f40671a.subscribe(operatorWindowBoundaryOpenSubscriber);
                    }
                }
            }
        }

        public final void onNext(T t) {
            if (!this.q) {
                if (m41405g()) {
                    for (UnicastProcessor onNext : this.f40677g) {
                        onNext.onNext(t);
                    }
                    if (mo7602a(-1) == null) {
                        return;
                    }
                }
                this.o.offer(NotificationLite.m26696a((Object) t));
                if (m41404f() == null) {
                    return;
                }
                m42353b();
            }
        }

        public final void onError(Throwable th) {
            if (this.q) {
                RxJavaPlugins.m26757a(th);
                return;
            }
            this.r = th;
            this.q = true;
            if (m41404f()) {
                m42353b();
            }
            if (this.f40678h.decrementAndGet() == 0) {
                this.f40674d.mo5626a();
            }
            this.n.onError(th);
        }

        public final void onComplete() {
            if (!this.q) {
                this.q = true;
                if (m41404f()) {
                    m42353b();
                }
                if (this.f40678h.decrementAndGet() == 0) {
                    this.f40674d.mo5626a();
                }
                this.n.onComplete();
            }
        }

        final void m42356a(Throwable th) {
            this.f40675e.cancel();
            this.f40674d.mo5626a();
            DisposableHelper.m32090a(this.f40676f);
            this.n.onError(th);
        }

        public final void request(long j) {
            m41398a(j);
        }

        public final void cancel() {
            this.p = true;
        }

        private void m42352a() {
            this.f40674d.mo5626a();
            DisposableHelper.m32090a(this.f40676f);
        }

        private void m42353b() {
            SimplePlainQueue simplePlainQueue = this.o;
            Subscriber subscriber = this.n;
            List<UnicastProcessor> list = this.f40677g;
            int i = 1;
            while (true) {
                boolean z = this.q;
                Object poll = simplePlainQueue.poll();
                boolean z2 = poll == null;
                if (z && z2) {
                    break;
                } else if (z2) {
                    i = mo7602a(-i);
                    if (i == 0) {
                        return;
                    }
                } else if (poll instanceof WindowOperation) {
                    WindowOperation windowOperation = (WindowOperation) poll;
                    if (windowOperation.f25083a != null) {
                        if (list.remove(windowOperation.f25083a)) {
                            windowOperation.f25083a.onComplete();
                            if (this.f40678h.decrementAndGet() == 0) {
                                m42352a();
                                return;
                            }
                        } else {
                            continue;
                        }
                    } else if (!this.p) {
                        UnicastProcessor a = UnicastProcessor.m38166a(this.f40673c);
                        long j = this.s.get();
                        if (j != 0) {
                            list.add(a);
                            subscriber.onNext(a);
                            if (j != Long.MAX_VALUE) {
                                mo7608j();
                            }
                            try {
                                Publisher publisher = (Publisher) ObjectHelper.m26573a(this.f40672b.apply(windowOperation.f25084b), "The publisher supplied is null");
                                Disposable operatorWindowBoundaryCloseSubscriber = new OperatorWindowBoundaryCloseSubscriber(this, a);
                                if (this.f40674d.mo5631a(operatorWindowBoundaryCloseSubscriber)) {
                                    this.f40678h.getAndIncrement();
                                    publisher.subscribe(operatorWindowBoundaryCloseSubscriber);
                                }
                            } catch (Throwable th) {
                                this.p = true;
                                subscriber.onError(th);
                            }
                        } else {
                            this.p = true;
                            subscriber.onError(new MissingBackpressureException("Could not deliver new window due to lack of requests"));
                        }
                    }
                } else {
                    for (UnicastProcessor onNext : list) {
                        onNext.onNext(NotificationLite.m26706e(poll));
                    }
                }
            }
            m42352a();
            Throwable th2 = this.r;
            if (th2 != null) {
                for (UnicastProcessor onError : list) {
                    onError.onError(th2);
                }
            } else {
                for (UnicastProcessor onComplete : list) {
                    onComplete.onComplete();
                }
            }
            list.clear();
        }

        final void m42355a(B b) {
            this.o.offer(new WindowOperation(null, b));
            if (m41404f() != null) {
                m42353b();
            }
        }

        final void m42354a(OperatorWindowBoundaryCloseSubscriber<T, V> operatorWindowBoundaryCloseSubscriber) {
            this.f40674d.mo5633c(operatorWindowBoundaryCloseSubscriber);
            this.o.offer(new WindowOperation(operatorWindowBoundaryCloseSubscriber.f37870b, null));
            if (m41404f() != null) {
                m42353b();
            }
        }
    }

    public FlowableWindowBoundarySelector(Flowable<T> flowable, Publisher<B> publisher, Function<? super B, ? extends Publisher<V>> function, int i) {
        super(flowable);
        this.f37874a = publisher;
        this.f37875b = function;
        this.f37876c = i;
    }

    protected final void subscribeActual(Subscriber<? super Flowable<T>> subscriber) {
        this.source.subscribe(new WindowBoundaryMainSubscriber(new SerializedSubscriber(subscriber), this.f37874a, this.f37875b, this.f37876c));
    }
}
