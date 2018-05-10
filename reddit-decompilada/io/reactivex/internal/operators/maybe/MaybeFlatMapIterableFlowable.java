package io.reactivex.internal.operators.maybe;

import io.reactivex.Flowable;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
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

public final class MaybeFlatMapIterableFlowable<T, R> extends Flowable<R> {
    final MaybeSource<T> f35577a;
    final Function<? super T, ? extends Iterable<? extends R>> f35578b;

    static final class FlatMapIterableObserver<T, R> extends BasicIntQueueSubscription<R> implements MaybeObserver<T> {
        final Subscriber<? super R> f39514a;
        final Function<? super T, ? extends Iterable<? extends R>> f39515b;
        final AtomicLong f39516c = new AtomicLong();
        Disposable f39517d;
        volatile Iterator<? extends R> f39518e;
        volatile boolean f39519f;
        boolean f39520g;

        FlatMapIterableObserver(Subscriber<? super R> subscriber, Function<? super T, ? extends Iterable<? extends R>> function) {
            this.f39514a = subscriber;
            this.f39515b = function;
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f39517d, disposable)) {
                this.f39517d = disposable;
                this.f39514a.mo5623a(this);
            }
        }

        public final void onSuccess(T t) {
            try {
                t = ((Iterable) this.f39515b.apply(t)).iterator();
                if (t.hasNext()) {
                    this.f39518e = t;
                    m39697a();
                    return;
                }
                this.f39514a.onComplete();
            } catch (T t2) {
                Exceptions.m26521b(t2);
                this.f39514a.onError(t2);
            }
        }

        public final void onError(Throwable th) {
            this.f39517d = DisposableHelper.f31095a;
            this.f39514a.onError(th);
        }

        public final void onComplete() {
            this.f39514a.onComplete();
        }

        public final void request(long j) {
            if (SubscriptionHelper.m32776a(j)) {
                BackpressureHelper.m26670a(this.f39516c, j);
                m39697a();
            }
        }

        public final void cancel() {
            this.f39519f = true;
            this.f39517d.mo5626a();
            this.f39517d = DisposableHelper.f31095a;
        }

        private void m39697a() {
            if (getAndIncrement() == 0) {
                Subscriber subscriber = this.f39514a;
                Iterator it = this.f39518e;
                if (!this.f39520g || it == null) {
                    int i = 1;
                    while (true) {
                        if (it != null) {
                            long j = this.f39516c.get();
                            if (j == Long.MAX_VALUE) {
                                break;
                            }
                            long j2 = 0;
                            while (j2 != j) {
                                if (!this.f39519f) {
                                    try {
                                        subscriber.onNext(ObjectHelper.m26573a(it.next(), "The iterator returned a null value"));
                                        if (!this.f39519f) {
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
                                BackpressureHelper.m26673c(this.f39516c, j2);
                            }
                        }
                        i = addAndGet(-i);
                        if (i == 0) {
                            return;
                        }
                        if (it == null) {
                            it = this.f39518e;
                        }
                    }
                    while (!this.f39519f) {
                        try {
                            subscriber.onNext(it.next());
                            if (this.f39519f) {
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
            this.f39520g = true;
            return 2;
        }

        public final void clear() {
            this.f39518e = null;
        }

        public final boolean isEmpty() {
            return this.f39518e == null;
        }

        public final R poll() throws Exception {
            Iterator it = this.f39518e;
            if (it == null) {
                return null;
            }
            R a = ObjectHelper.m26573a(it.next(), "The iterator returned a null value");
            if (!it.hasNext()) {
                this.f39518e = null;
            }
            return a;
        }
    }

    public MaybeFlatMapIterableFlowable(MaybeSource<T> maybeSource, Function<? super T, ? extends Iterable<? extends R>> function) {
        this.f35577a = maybeSource;
        this.f35578b = function;
    }

    protected final void subscribeActual(Subscriber<? super R> subscriber) {
        this.f35577a.subscribe(new FlatMapIterableObserver(subscriber, this.f35578b));
    }
}
