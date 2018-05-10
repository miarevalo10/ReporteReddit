package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.Arrays;

public final class MaybeZipIterable<T, R> extends Maybe<R> {
    final Iterable<? extends MaybeSource<? extends T>> f35619a;
    final Function<? super Object[], ? extends R> f35620b;

    final class SingletonArrayFunc implements Function<T, R> {
        final /* synthetic */ MaybeZipIterable f31556a;

        SingletonArrayFunc(MaybeZipIterable maybeZipIterable) {
            this.f31556a = maybeZipIterable;
        }

        public final R apply(T t) throws Exception {
            return ObjectHelper.m26573a(this.f31556a.f35620b.apply(new Object[]{t}), "The zipper returned a null value");
        }
    }

    public MaybeZipIterable(Iterable<? extends MaybeSource<? extends T>> iterable, Function<? super Object[], ? extends R> function) {
        this.f35619a = iterable;
        this.f35620b = function;
    }

    protected final void subscribeActual(MaybeObserver<? super R> maybeObserver) {
        MaybeSource[] maybeSourceArr = new MaybeSource[8];
        try {
            int i = 0;
            Object[] objArr = maybeSourceArr;
            int i2 = 0;
            for (MaybeSource maybeSource : this.f35619a) {
                if (maybeSource == null) {
                    EmptyDisposable.m38050a(new NullPointerException("One of the sources is null"), (MaybeObserver) maybeObserver);
                    return;
                }
                if (i2 == objArr.length) {
                    objArr = (MaybeSource[]) Arrays.copyOf(objArr, (i2 >> 2) + i2);
                }
                int i3 = i2 + 1;
                objArr[i2] = maybeSource;
                i2 = i3;
            }
            if (i2 == 0) {
                EmptyDisposable.m38047a((MaybeObserver) maybeObserver);
            } else if (i2 == 1) {
                objArr[0].subscribe(new MapMaybeObserver(maybeObserver, new SingletonArrayFunc(this)));
            } else {
                ZipCoordinator zipCoordinator = new ZipCoordinator(maybeObserver, i2, this.f35620b);
                maybeObserver.onSubscribe(zipCoordinator);
                while (i < i2 && zipCoordinator.mo5627b() == null) {
                    objArr[i].subscribe(zipCoordinator.f31552c[i]);
                    i++;
                }
            }
        } catch (Throwable th) {
            Exceptions.m26521b(th);
            EmptyDisposable.m38050a(th, (MaybeObserver) maybeObserver);
        }
    }
}
