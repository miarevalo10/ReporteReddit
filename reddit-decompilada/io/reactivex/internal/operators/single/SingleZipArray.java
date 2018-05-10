package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleZipArray<T, R> extends Single<R> {
    final SingleSource<? extends T>[] f35861a;
    final Function<? super Object[], ? extends R> f35862b;

    final class SingletonArrayFunc implements Function<T, R> {
        final /* synthetic */ SingleZipArray f32400a;

        SingletonArrayFunc(SingleZipArray singleZipArray) {
            this.f32400a = singleZipArray;
        }

        public final R apply(T t) throws Exception {
            return ObjectHelper.m26573a(this.f32400a.f35862b.apply(new Object[]{t}), "The zipper returned a null value");
        }
    }

    static final class ZipCoordinator<T, R> extends AtomicInteger implements Disposable {
        final SingleObserver<? super R> f32401a;
        final Function<? super Object[], ? extends R> f32402b;
        final ZipSingleObserver<T>[] f32403c;
        final Object[] f32404d;

        ZipCoordinator(SingleObserver<? super R> singleObserver, int i, Function<? super Object[], ? extends R> function) {
            super(i);
            this.f32401a = singleObserver;
            this.f32402b = function;
            singleObserver = new ZipSingleObserver[i];
            for (function = null; function < i; function++) {
                singleObserver[function] = new ZipSingleObserver(this, function);
            }
            this.f32403c = singleObserver;
            this.f32404d = new Object[i];
        }

        public final boolean mo5627b() {
            return get() <= 0;
        }

        public final void mo5626a() {
            int i = 0;
            if (getAndSet(0) > 0) {
                ZipSingleObserver[] zipSingleObserverArr = this.f32403c;
                int length = zipSingleObserverArr.length;
                while (i < length) {
                    DisposableHelper.m32090a(zipSingleObserverArr[i]);
                    i++;
                }
            }
        }

        final void m32738a(Throwable th, int i) {
            int i2 = 0;
            if (getAndSet(0) > 0) {
                ZipSingleObserver[] zipSingleObserverArr = this.f32403c;
                int length = zipSingleObserverArr.length;
                while (i2 < i) {
                    DisposableHelper.m32090a(zipSingleObserverArr[i2]);
                    i2++;
                }
                while (true) {
                    i++;
                    if (i < length) {
                        DisposableHelper.m32090a(zipSingleObserverArr[i]);
                    } else {
                        this.f32401a.onError(th);
                        return;
                    }
                }
            }
            RxJavaPlugins.m26757a(th);
        }
    }

    static final class ZipSingleObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T> {
        final ZipCoordinator<T, ?> f32405a;
        final int f32406b;

        ZipSingleObserver(ZipCoordinator<T, ?> zipCoordinator, int i) {
            this.f32405a = zipCoordinator;
            this.f32406b = i;
        }

        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.m32092b(this, disposable);
        }

        public final void onSuccess(T t) {
            ZipCoordinator zipCoordinator = this.f32405a;
            zipCoordinator.f32404d[this.f32406b] = t;
            if (zipCoordinator.decrementAndGet() == null) {
                try {
                    zipCoordinator.f32401a.onSuccess(ObjectHelper.m26573a(zipCoordinator.f32402b.apply(zipCoordinator.f32404d), "The zipper returned a null value"));
                } catch (T t2) {
                    Exceptions.m26521b(t2);
                    zipCoordinator.f32401a.onError(t2);
                }
            }
        }

        public final void onError(Throwable th) {
            this.f32405a.m32738a(th, this.f32406b);
        }
    }

    public SingleZipArray(SingleSource<? extends T>[] singleSourceArr, Function<? super Object[], ? extends R> function) {
        this.f35861a = singleSourceArr;
        this.f35862b = function;
    }

    protected final void subscribeActual(SingleObserver<? super R> singleObserver) {
        SingleSource[] singleSourceArr = this.f35861a;
        int i = 0;
        int length = singleSourceArr.length;
        if (length == 1) {
            singleSourceArr[0].subscribe(new MapSingleObserver(singleObserver, new SingletonArrayFunc(this)));
            return;
        }
        ZipCoordinator zipCoordinator = new ZipCoordinator(singleObserver, length, this.f35862b);
        singleObserver.onSubscribe(zipCoordinator);
        while (i < length && zipCoordinator.mo5627b() == null) {
            singleObserver = singleSourceArr[i];
            if (singleObserver == null) {
                zipCoordinator.m32738a(new NullPointerException("One of the sources is null"), i);
                return;
            } else {
                singleObserver.subscribe(zipCoordinator.f32403c[i]);
                i++;
            }
        }
    }
}
