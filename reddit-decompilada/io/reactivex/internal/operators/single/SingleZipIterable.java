package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.Arrays;
import java.util.NoSuchElementException;

public final class SingleZipIterable<T, R> extends Single<R> {
    final Iterable<? extends SingleSource<? extends T>> f35863a;
    final Function<? super Object[], ? extends R> f35864b;

    final class SingletonArrayFunc implements Function<T, R> {
        final /* synthetic */ SingleZipIterable f32407a;

        SingletonArrayFunc(SingleZipIterable singleZipIterable) {
            this.f32407a = singleZipIterable;
        }

        public final R apply(T t) throws Exception {
            return ObjectHelper.m26573a(this.f32407a.f35864b.apply(new Object[]{t}), "The zipper returned a null value");
        }
    }

    public SingleZipIterable(Iterable<? extends SingleSource<? extends T>> iterable, Function<? super Object[], ? extends R> function) {
        this.f35863a = iterable;
        this.f35864b = function;
    }

    protected final void subscribeActual(SingleObserver<? super R> singleObserver) {
        SingleSource[] singleSourceArr = new SingleSource[8];
        try {
            int i = 0;
            Object[] objArr = singleSourceArr;
            int i2 = 0;
            for (SingleSource singleSource : this.f35863a) {
                if (singleSource == null) {
                    EmptyDisposable.m38052a(new NullPointerException("One of the sources is null"), (SingleObserver) singleObserver);
                    return;
                }
                if (i2 == objArr.length) {
                    objArr = (SingleSource[]) Arrays.copyOf(objArr, (i2 >> 2) + i2);
                }
                int i3 = i2 + 1;
                objArr[i2] = singleSource;
                i2 = i3;
            }
            if (i2 == 0) {
                EmptyDisposable.m38052a(new NoSuchElementException(), (SingleObserver) singleObserver);
            } else if (i2 == 1) {
                objArr[0].subscribe(new MapSingleObserver(singleObserver, new SingletonArrayFunc(this)));
            } else {
                ZipCoordinator zipCoordinator = new ZipCoordinator(singleObserver, i2, this.f35864b);
                singleObserver.onSubscribe(zipCoordinator);
                while (i < i2 && zipCoordinator.mo5627b() == null) {
                    objArr[i].subscribe(zipCoordinator.f32403c[i]);
                    i++;
                }
            }
        } catch (Throwable th) {
            Exceptions.m26521b(th);
            EmptyDisposable.m38052a(th, (SingleObserver) singleObserver);
        }
    }
}
