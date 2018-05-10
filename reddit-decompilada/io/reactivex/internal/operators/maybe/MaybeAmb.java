package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;

public final class MaybeAmb<T> extends Maybe<T> {
    private final MaybeSource<? extends T>[] f35549a;
    private final Iterable<? extends MaybeSource<? extends T>> f35550b;

    static final class AmbMaybeObserver<T> extends AtomicBoolean implements MaybeObserver<T>, Disposable {
        final MaybeObserver<? super T> f31380a;
        final CompositeDisposable f31381b = new CompositeDisposable();

        AmbMaybeObserver(MaybeObserver<? super T> maybeObserver) {
            this.f31380a = maybeObserver;
        }

        public final void mo5626a() {
            if (compareAndSet(false, true)) {
                this.f31381b.mo5626a();
            }
        }

        public final boolean mo5627b() {
            return get();
        }

        public final void onSubscribe(Disposable disposable) {
            this.f31381b.mo5631a(disposable);
        }

        public final void onSuccess(T t) {
            if (compareAndSet(false, true)) {
                this.f31381b.mo5626a();
                this.f31380a.onSuccess(t);
            }
        }

        public final void onError(Throwable th) {
            if (compareAndSet(false, true)) {
                this.f31381b.mo5626a();
                this.f31380a.onError(th);
                return;
            }
            RxJavaPlugins.m26757a(th);
        }

        public final void onComplete() {
            if (compareAndSet(false, true)) {
                this.f31381b.mo5626a();
                this.f31380a.onComplete();
            }
        }
    }

    public MaybeAmb(MaybeSource<? extends T>[] maybeSourceArr, Iterable<? extends MaybeSource<? extends T>> iterable) {
        this.f35549a = maybeSourceArr;
        this.f35550b = iterable;
    }

    protected final void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        Object obj = this.f35549a;
        int i = 0;
        int i2;
        MaybeSource maybeSource;
        if (obj == null) {
            obj = new MaybeSource[8];
            try {
                i2 = 0;
                for (MaybeSource maybeSource2 : this.f35550b) {
                    if (maybeSource2 == null) {
                        EmptyDisposable.m38050a(new NullPointerException("One of the sources is null"), (MaybeObserver) maybeObserver);
                        return;
                    }
                    if (i2 == obj.length) {
                        Object obj2 = new MaybeSource[((i2 >> 2) + i2)];
                        System.arraycopy(obj, 0, obj2, 0, i2);
                        obj = obj2;
                    }
                    int i3 = i2 + 1;
                    obj[i2] = maybeSource2;
                    i2 = i3;
                }
            } catch (Throwable th) {
                Exceptions.m26521b(th);
                EmptyDisposable.m38050a(th, (MaybeObserver) maybeObserver);
                return;
            }
        }
        i2 = obj.length;
        Object ambMaybeObserver = new AmbMaybeObserver(maybeObserver);
        maybeObserver.onSubscribe(ambMaybeObserver);
        while (i < i2) {
            maybeSource2 = obj[i];
            if (!ambMaybeObserver.mo5627b()) {
                if (maybeSource2 == null) {
                    ambMaybeObserver.onError(new NullPointerException("One of the MaybeSources is null"));
                    return;
                } else {
                    maybeSource2.subscribe(ambMaybeObserver);
                    i++;
                }
            } else {
                return;
            }
        }
        if (i2 == 0) {
            maybeObserver.onComplete();
        }
    }
}
