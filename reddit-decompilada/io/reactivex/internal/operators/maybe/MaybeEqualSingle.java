package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiPredicate;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeEqualSingle<T> extends Single<Boolean> {
    final MaybeSource<? extends T> f35568a;
    final MaybeSource<? extends T> f35569b;
    final BiPredicate<? super T, ? super T> f35570c;

    static final class EqualCoordinator<T> extends AtomicInteger implements Disposable {
        final SingleObserver<? super Boolean> f31438a;
        final EqualObserver<T> f31439b = new EqualObserver(this);
        final EqualObserver<T> f31440c = new EqualObserver(this);
        final BiPredicate<? super T, ? super T> f31441d;

        EqualCoordinator(SingleObserver<? super Boolean> singleObserver, BiPredicate<? super T, ? super T> biPredicate) {
            super(2);
            this.f31438a = singleObserver;
            this.f31441d = biPredicate;
        }

        public final void mo5626a() {
            DisposableHelper.m32090a(this.f31439b);
            DisposableHelper.m32090a(this.f31440c);
        }

        public final boolean mo5627b() {
            return DisposableHelper.m32088a((Disposable) this.f31439b.get());
        }

        final void m32267c() {
            if (decrementAndGet() == 0) {
                SingleObserver singleObserver;
                boolean z;
                Object obj = this.f31439b.f31443b;
                Object obj2 = this.f31440c.f31443b;
                if (obj == null || obj2 == null) {
                    singleObserver = this.f31438a;
                    z = obj == null && obj2 == null;
                } else {
                    try {
                        z = this.f31441d.mo4928a(obj, obj2);
                        singleObserver = this.f31438a;
                    } catch (Throwable th) {
                        Exceptions.m26521b(th);
                        this.f31438a.onError(th);
                        return;
                    }
                }
                singleObserver.onSuccess(Boolean.valueOf(z));
            }
        }
    }

    static final class EqualObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T> {
        final EqualCoordinator<T> f31442a;
        Object f31443b;

        EqualObserver(EqualCoordinator<T> equalCoordinator) {
            this.f31442a = equalCoordinator;
        }

        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.m32092b(this, disposable);
        }

        public final void onSuccess(T t) {
            this.f31443b = t;
            this.f31442a.m32267c();
        }

        public final void onError(Throwable th) {
            EqualCoordinator equalCoordinator = this.f31442a;
            if (equalCoordinator.getAndSet(0) > 0) {
                if (this == equalCoordinator.f31439b) {
                    DisposableHelper.m32090a(equalCoordinator.f31440c);
                } else {
                    DisposableHelper.m32090a(equalCoordinator.f31439b);
                }
                equalCoordinator.f31438a.onError(th);
                return;
            }
            RxJavaPlugins.m26757a(th);
        }

        public final void onComplete() {
            this.f31442a.m32267c();
        }
    }

    public MaybeEqualSingle(MaybeSource<? extends T> maybeSource, MaybeSource<? extends T> maybeSource2, BiPredicate<? super T, ? super T> biPredicate) {
        this.f35568a = maybeSource;
        this.f35569b = maybeSource2;
        this.f35570c = biPredicate;
    }

    protected final void subscribeActual(SingleObserver<? super Boolean> singleObserver) {
        EqualCoordinator equalCoordinator = new EqualCoordinator(singleObserver, this.f35570c);
        singleObserver.onSubscribe(equalCoordinator);
        singleObserver = this.f35568a;
        MaybeSource maybeSource = this.f35569b;
        singleObserver.subscribe(equalCoordinator.f31439b);
        maybeSource.subscribe(equalCoordinator.f31440c);
    }
}
