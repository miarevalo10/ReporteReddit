package io.reactivex.internal.operators.maybe;

import io.reactivex.Flowable;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class MaybeConcatArray<T> extends Flowable<T> {
    final MaybeSource<? extends T>[] f35551a;

    static final class ConcatMaybeObserver<T> extends AtomicInteger implements MaybeObserver<T>, Subscription {
        final Subscriber<? super T> f31386a;
        final AtomicLong f31387b = new AtomicLong();
        final AtomicReference<Object> f31388c = new AtomicReference(NotificationLite.f25198a);
        final SequentialDisposable f31389d = new SequentialDisposable();
        final MaybeSource<? extends T>[] f31390e;
        int f31391f;
        long f31392g;

        ConcatMaybeObserver(Subscriber<? super T> subscriber, MaybeSource<? extends T>[] maybeSourceArr) {
            this.f31386a = subscriber;
            this.f31390e = maybeSourceArr;
        }

        public final void request(long j) {
            if (SubscriptionHelper.m32776a(j)) {
                BackpressureHelper.m26670a(this.f31387b, j);
                m32236a();
            }
        }

        public final void cancel() {
            this.f31389d.mo5626a();
        }

        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.m32094c(this.f31389d, disposable);
        }

        public final void onSuccess(T t) {
            this.f31388c.lazySet(t);
            m32236a();
        }

        public final void onError(Throwable th) {
            this.f31386a.onError(th);
        }

        public final void onComplete() {
            this.f31388c.lazySet(NotificationLite.f25198a);
            m32236a();
        }

        final void m32236a() {
            if (getAndIncrement() == 0) {
                AtomicReference atomicReference = this.f31388c;
                Subscriber subscriber = this.f31386a;
                Disposable disposable = this.f31389d;
                while (!disposable.mo5627b()) {
                    NotificationLite notificationLite = atomicReference.get();
                    if (notificationLite != null) {
                        Object obj = 1;
                        if (notificationLite != NotificationLite.f25198a) {
                            long j = this.f31392g;
                            if (j != this.f31387b.get()) {
                                this.f31392g = j + 1;
                                atomicReference.lazySet(null);
                                subscriber.onNext(notificationLite);
                            } else {
                                obj = null;
                            }
                        } else {
                            atomicReference.lazySet(null);
                        }
                        if (!(obj == null || disposable.mo5627b())) {
                            int i = this.f31391f;
                            if (i == this.f31390e.length) {
                                subscriber.onComplete();
                                return;
                            } else {
                                this.f31391f = i + 1;
                                this.f31390e[i].subscribe(this);
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

    public MaybeConcatArray(MaybeSource<? extends T>[] maybeSourceArr) {
        this.f35551a = maybeSourceArr;
    }

    protected final void subscribeActual(Subscriber<? super T> subscriber) {
        Object concatMaybeObserver = new ConcatMaybeObserver(subscriber, this.f35551a);
        subscriber.mo5623a(concatMaybeObserver);
        concatMaybeObserver.m32236a();
    }
}
