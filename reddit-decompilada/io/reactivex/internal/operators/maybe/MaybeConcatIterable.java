package io.reactivex.internal.operators.maybe;

import io.reactivex.Flowable;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class MaybeConcatIterable<T> extends Flowable<T> {
    final Iterable<? extends MaybeSource<? extends T>> f35553a;

    static final class ConcatMaybeObserver<T> extends AtomicInteger implements MaybeObserver<T>, Subscription {
        final Subscriber<? super T> f31401a;
        final AtomicLong f31402b = new AtomicLong();
        final AtomicReference<Object> f31403c = new AtomicReference(NotificationLite.f25198a);
        final SequentialDisposable f31404d = new SequentialDisposable();
        final Iterator<? extends MaybeSource<? extends T>> f31405e;
        long f31406f;

        ConcatMaybeObserver(Subscriber<? super T> subscriber, Iterator<? extends MaybeSource<? extends T>> it) {
            this.f31401a = subscriber;
            this.f31405e = it;
        }

        public final void request(long j) {
            if (SubscriptionHelper.m32776a(j)) {
                BackpressureHelper.m26670a(this.f31402b, j);
                m32238a();
            }
        }

        public final void cancel() {
            this.f31404d.mo5626a();
        }

        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.m32094c(this.f31404d, disposable);
        }

        public final void onSuccess(T t) {
            this.f31403c.lazySet(t);
            m32238a();
        }

        public final void onError(Throwable th) {
            this.f31401a.onError(th);
        }

        public final void onComplete() {
            this.f31403c.lazySet(NotificationLite.f25198a);
            m32238a();
        }

        final void m32238a() {
            if (getAndIncrement() == 0) {
                AtomicReference atomicReference = this.f31403c;
                Subscriber subscriber = this.f31401a;
                Disposable disposable = this.f31404d;
                while (!disposable.mo5627b()) {
                    NotificationLite notificationLite = atomicReference.get();
                    if (notificationLite != null) {
                        Object obj = 1;
                        if (notificationLite != NotificationLite.f25198a) {
                            long j = this.f31406f;
                            if (j != this.f31402b.get()) {
                                this.f31406f = j + 1;
                                atomicReference.lazySet(null);
                                subscriber.onNext(notificationLite);
                            } else {
                                obj = null;
                            }
                        } else {
                            atomicReference.lazySet(null);
                        }
                        if (!(obj == null || disposable.mo5627b())) {
                            try {
                                if (this.f31405e.hasNext()) {
                                    try {
                                        ((MaybeSource) ObjectHelper.m26573a(this.f31405e.next(), "The source Iterator returned a null MaybeSource")).subscribe(this);
                                    } catch (Throwable th) {
                                        Exceptions.m26521b(th);
                                        subscriber.onError(th);
                                        return;
                                    }
                                }
                                subscriber.onComplete();
                            } catch (Throwable th2) {
                                Exceptions.m26521b(th2);
                                subscriber.onError(th2);
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

    public MaybeConcatIterable(Iterable<? extends MaybeSource<? extends T>> iterable) {
        this.f35553a = iterable;
    }

    protected final void subscribeActual(Subscriber<? super T> subscriber) {
        try {
            Object concatMaybeObserver = new ConcatMaybeObserver(subscriber, (Iterator) ObjectHelper.m26573a(this.f35553a.iterator(), "The sources Iterable returned a null Iterator"));
            subscriber.mo5623a(concatMaybeObserver);
            concatMaybeObserver.m32238a();
        } catch (Throwable th) {
            Exceptions.m26521b(th);
            EmptySubscription.m38160a(th, subscriber);
        }
    }
}
