package io.reactivex.internal.operators.single;

import io.reactivex.Flowable;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;

public final class SingleFlatMapIterableFlowable<T, R> extends Flowable<R> {
    final SingleSource<T> f35812a;
    final Function<? super T, ? extends Iterable<? extends R>> f35813b;

    static final class FlatMapIterableObserver<T, R> extends BasicIntQueueSubscription<R> implements SingleObserver<T> {
        final Subscriber<? super R> f39674a;
        final Function<? super T, ? extends Iterable<? extends R>> f39675b;
        final AtomicLong f39676c = new AtomicLong();
        Disposable f39677d;
        volatile Iterator<? extends R> f39678e;
        volatile boolean f39679f;
        boolean f39680g;

        FlatMapIterableObserver(Subscriber<? super R> subscriber, Function<? super T, ? extends Iterable<? extends R>> function) {
            this.f39674a = subscriber;
            this.f39675b = function;
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f39677d, disposable)) {
                this.f39677d = disposable;
                this.f39674a.mo5623a(this);
            }
        }

        public final void onSuccess(T t) {
            try {
                t = ((Iterable) this.f39675b.apply(t)).iterator();
                if (t.hasNext()) {
                    this.f39678e = t;
                    m39783a();
                    return;
                }
                this.f39674a.onComplete();
            } catch (T t2) {
                Exceptions.m26521b(t2);
                this.f39674a.onError(t2);
            }
        }

        public final void onError(Throwable th) {
            this.f39677d = DisposableHelper.f31095a;
            this.f39674a.onError(th);
        }

        public final void request(long j) {
            if (SubscriptionHelper.m32776a(j)) {
                BackpressureHelper.m26670a(this.f39676c, j);
                m39783a();
            }
        }

        public final void cancel() {
            this.f39679f = true;
            this.f39677d.mo5626a();
            this.f39677d = DisposableHelper.f31095a;
        }

        private void m39783a() {
            if (getAndIncrement() == 0) {
                Subscriber subscriber = this.f39674a;
                Iterator it = this.f39678e;
                if (!this.f39680g || it == null) {
                    int i = 1;
                    while (true) {
                        if (it != null) {
                            long j = this.f39676c.get();
                            if (j == Long.MAX_VALUE) {
                                break;
                            }
                            long j2 = 0;
                            while (j2 != j) {
                                if (!this.f39679f) {
                                    try {
                                        subscriber.onNext(ObjectHelper.m26573a(it.next(), "The iterator returned a null value"));
                                        if (!this.f39679f) {
                                            j2++;
                                            try {
                                                if (!it.hasNext()) {
                                                    subscriber.onComplete();
                                                    return;
                                                }
                                            } catch (Throwable th) {
                                                Exceptions.m26521b(th);
                                                subscriber.onError(th);
                                                return;
                                            }
                                        }
                                        return;
                                    } catch (Throwable th2) {
                                        Exceptions.m26521b(th2);
                                        subscriber.onError(th2);
                                        return;
                                    }
                                }
                                return;
                            }
                            if (j2 != 0) {
                                BackpressureHelper.m26673c(this.f39676c, j2);
                            }
                        }
                        i = addAndGet(-i);
                        if (i == 0) {
                            return;
                        }
                        if (it == null) {
                            it = this.f39678e;
                        }
                    }
                    while (!this.f39679f) {
                        try {
                            subscriber.onNext(it.next());
                            if (this.f39679f) {
                                break;
                            }
                            try {
                                if (!it.hasNext()) {
                                    subscriber.onComplete();
                                    return;
                                }
                            } catch (Throwable th22) {
                                Exceptions.m26521b(th22);
                                subscriber.onError(th22);
                                return;
                            }
                        } catch (Throwable th222) {
                            Exceptions.m26521b(th222);
                            subscriber.onError(th222);
                            return;
                        }
                    }
                    return;
                }
                subscriber.onNext(null);
                subscriber.onComplete();
            }
        }

        public final int mo7033a(int i) {
            if ((i & 2) == 0) {
                return 0;
            }
            this.f39680g = true;
            return 2;
        }

        public final void clear() {
            this.f39678e = null;
        }

        public final boolean isEmpty() {
            return this.f39678e == null;
        }

        public final R poll() throws Exception {
            Iterator it = this.f39678e;
            if (it == null) {
                return null;
            }
            R a = ObjectHelper.m26573a(it.next(), "The iterator returned a null value");
            if (!it.hasNext()) {
                this.f39678e = null;
            }
            return a;
        }
    }

    public SingleFlatMapIterableFlowable(SingleSource<T> singleSource, Function<? super T, ? extends Iterable<? extends R>> function) {
        this.f35812a = singleSource;
        this.f35813b = function;
    }

    protected final void subscribeActual(Subscriber<? super R> subscriber) {
        this.f35812a.subscribe(new FlatMapIterableObserver(subscriber, this.f35813b));
    }
}
