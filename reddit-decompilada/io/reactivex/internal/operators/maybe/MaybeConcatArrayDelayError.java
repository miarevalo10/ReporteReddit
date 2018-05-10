package io.reactivex.internal.operators.maybe;

import io.reactivex.Flowable;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class MaybeConcatArrayDelayError<T> extends Flowable<T> {
    final MaybeSource<? extends T>[] f35552a;

    static final class ConcatMaybeObserver<T> extends AtomicInteger implements MaybeObserver<T>, Subscription {
        final Subscriber<? super T> f31393a;
        final AtomicLong f31394b = new AtomicLong();
        final AtomicReference<Object> f31395c = new AtomicReference(NotificationLite.f25198a);
        final SequentialDisposable f31396d = new SequentialDisposable();
        final MaybeSource<? extends T>[] f31397e;
        final AtomicThrowable f31398f = new AtomicThrowable();
        int f31399g;
        long f31400h;

        ConcatMaybeObserver(Subscriber<? super T> subscriber, MaybeSource<? extends T>[] maybeSourceArr) {
            this.f31393a = subscriber;
            this.f31397e = maybeSourceArr;
        }

        public final void request(long j) {
            if (SubscriptionHelper.m32776a(j)) {
                BackpressureHelper.m26670a(this.f31394b, j);
                m32237a();
            }
        }

        public final void cancel() {
            this.f31396d.mo5626a();
        }

        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.m32094c(this.f31396d, disposable);
        }

        public final void onSuccess(T t) {
            this.f31395c.lazySet(t);
            m32237a();
        }

        public final void onError(Throwable th) {
            this.f31395c.lazySet(NotificationLite.f25198a);
            if (ExceptionHelper.m26684a(this.f31398f, th)) {
                m32237a();
            } else {
                RxJavaPlugins.m26757a(th);
            }
        }

        public final void onComplete() {
            this.f31395c.lazySet(NotificationLite.f25198a);
            m32237a();
        }

        final void m32237a() {
            if (getAndIncrement() == 0) {
                AtomicReference atomicReference = this.f31395c;
                Subscriber subscriber = this.f31393a;
                Disposable disposable = this.f31396d;
                while (!disposable.mo5627b()) {
                    NotificationLite notificationLite = atomicReference.get();
                    if (notificationLite != null) {
                        Object obj = 1;
                        if (notificationLite != NotificationLite.f25198a) {
                            long j = this.f31400h;
                            if (j != this.f31394b.get()) {
                                this.f31400h = j + 1;
                                atomicReference.lazySet(null);
                                subscriber.onNext(notificationLite);
                            } else {
                                obj = null;
                            }
                        } else {
                            atomicReference.lazySet(null);
                        }
                        if (!(obj == null || disposable.mo5627b())) {
                            int i = this.f31399g;
                            if (i != this.f31397e.length) {
                                this.f31399g = i + 1;
                                this.f31397e[i].subscribe(this);
                            } else if (((Throwable) this.f31398f.get()) != null) {
                                subscriber.onError(ExceptionHelper.m26683a(this.f31398f));
                                return;
                            } else {
                                subscriber.onComplete();
                                return;
                            }
                        }
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
                atomicReference.lazySet(null);
            }
        }
    }

    public MaybeConcatArrayDelayError(MaybeSource<? extends T>[] maybeSourceArr) {
        this.f35552a = maybeSourceArr;
    }

    protected final void subscribeActual(Subscriber<? super T> subscriber) {
        Object concatMaybeObserver = new ConcatMaybeObserver(subscriber, this.f35552a);
        subscriber.mo5623a(concatMaybeObserver);
        concatMaybeObserver.m32237a();
    }
}
