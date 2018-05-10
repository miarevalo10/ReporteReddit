package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeZipArray<T, R> extends Maybe<R> {
    final MaybeSource<? extends T>[] f35617a;
    final Function<? super Object[], ? extends R> f35618b;

    final class SingletonArrayFunc implements Function<T, R> {
        final /* synthetic */ MaybeZipArray f31549a;

        SingletonArrayFunc(MaybeZipArray maybeZipArray) {
            this.f31549a = maybeZipArray;
        }

        public final R apply(T t) throws Exception {
            return ObjectHelper.m26573a(this.f31549a.f35618b.apply(new Object[]{t}), "The zipper returned a null value");
        }
    }

    static final class ZipCoordinator<T, R> extends AtomicInteger implements Disposable {
        final MaybeObserver<? super R> f31550a;
        final Function<? super Object[], ? extends R> f31551b;
        final ZipMaybeObserver<T>[] f31552c;
        final Object[] f31553d;

        ZipCoordinator(MaybeObserver<? super R> maybeObserver, int i, Function<? super Object[], ? extends R> function) {
            super(i);
            this.f31550a = maybeObserver;
            this.f31551b = function;
            maybeObserver = new ZipMaybeObserver[i];
            for (function = null; function < i; function++) {
                maybeObserver[function] = new ZipMaybeObserver(this, function);
            }
            this.f31552c = maybeObserver;
            this.f31553d = new Object[i];
        }

        public final boolean mo5627b() {
            return get() <= 0;
        }

        public final void mo5626a() {
            int i = 0;
            if (getAndSet(0) > 0) {
                ZipMaybeObserver[] zipMaybeObserverArr = this.f31552c;
                int length = zipMaybeObserverArr.length;
                while (i < length) {
                    DisposableHelper.m32090a(zipMaybeObserverArr[i]);
                    i++;
                }
            }
        }

        final void m32344a(int i) {
            ZipMaybeObserver[] zipMaybeObserverArr = this.f31552c;
            int length = zipMaybeObserverArr.length;
            for (int i2 = 0; i2 < i; i2++) {
                DisposableHelper.m32090a(zipMaybeObserverArr[i2]);
            }
            while (true) {
                i++;
                if (i < length) {
                    DisposableHelper.m32090a(zipMaybeObserverArr[i]);
                } else {
                    return;
                }
            }
        }

        final void m32345a(Throwable th, int i) {
            if (getAndSet(0) > 0) {
                m32344a(i);
                this.f31550a.onError(th);
                return;
            }
            RxJavaPlugins.m26757a(th);
        }
    }

    static final class ZipMaybeObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T> {
        final ZipCoordinator<T, ?> f31554a;
        final int f31555b;

        ZipMaybeObserver(ZipCoordinator<T, ?> zipCoordinator, int i) {
            this.f31554a = zipCoordinator;
            this.f31555b = i;
        }

        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.m32092b(this, disposable);
        }

        public final void onSuccess(T t) {
            ZipCoordinator zipCoordinator = this.f31554a;
            zipCoordinator.f31553d[this.f31555b] = t;
            if (zipCoordinator.decrementAndGet() == null) {
                try {
                    zipCoordinator.f31550a.onSuccess(ObjectHelper.m26573a(zipCoordinator.f31551b.apply(zipCoordinator.f31553d), "The zipper returned a null value"));
                } catch (T t2) {
                    Exceptions.m26521b(t2);
                    zipCoordinator.f31550a.onError(t2);
                }
            }
        }

        public final void onError(Throwable th) {
            this.f31554a.m32345a(th, this.f31555b);
        }

        public final void onComplete() {
            ZipCoordinator zipCoordinator = this.f31554a;
            int i = this.f31555b;
            if (zipCoordinator.getAndSet(0) > 0) {
                zipCoordinator.m32344a(i);
                zipCoordinator.f31550a.onComplete();
            }
        }
    }

    public MaybeZipArray(MaybeSource<? extends T>[] maybeSourceArr, Function<? super Object[], ? extends R> function) {
        this.f35617a = maybeSourceArr;
        this.f35618b = function;
    }

    protected final void subscribeActual(MaybeObserver<? super R> maybeObserver) {
        MaybeSource[] maybeSourceArr = this.f35617a;
        int i = 0;
        int length = maybeSourceArr.length;
        if (length == 1) {
            maybeSourceArr[0].subscribe(new MapMaybeObserver(maybeObserver, new SingletonArrayFunc(this)));
            return;
        }
        ZipCoordinator zipCoordinator = new ZipCoordinator(maybeObserver, length, this.f35618b);
        maybeObserver.onSubscribe(zipCoordinator);
        while (i < length && zipCoordinator.mo5627b() == null) {
            maybeObserver = maybeSourceArr[i];
            if (maybeObserver == null) {
                zipCoordinator.m32345a(new NullPointerException("One of the sources is null"), i);
                return;
            } else {
                maybeObserver.subscribe(zipCoordinator.f31552c[i]);
                i++;
            }
        }
    }
}
