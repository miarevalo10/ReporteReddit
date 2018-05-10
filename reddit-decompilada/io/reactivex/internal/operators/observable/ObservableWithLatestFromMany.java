package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.HalfSerializer;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;

public final class ObservableWithLatestFromMany<T, R> extends AbstractObservableWithUpstream<T, R> {
    final ObservableSource<?>[] f38130a;
    final Iterable<? extends ObservableSource<?>> f38131b;
    final Function<? super Object[], R> f38132c;

    final class SingletonArrayFunc implements Function<T, R> {
        final /* synthetic */ ObservableWithLatestFromMany f32278a;

        SingletonArrayFunc(ObservableWithLatestFromMany observableWithLatestFromMany) {
            this.f32278a = observableWithLatestFromMany;
        }

        public final R apply(T t) throws Exception {
            return ObjectHelper.m26573a(this.f32278a.f38132c.apply(new Object[]{t}), "The combiner returned a null value");
        }
    }

    static final class WithLatestFromObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {
        final Observer<? super R> f32279a;
        final Function<? super Object[], R> f32280b;
        final WithLatestInnerObserver[] f32281c;
        final AtomicReferenceArray<Object> f32282d;
        final AtomicReference<Disposable> f32283e;
        final AtomicThrowable f32284f;
        volatile boolean f32285g;

        WithLatestFromObserver(Observer<? super R> observer, Function<? super Object[], R> function, int i) {
            this.f32279a = observer;
            this.f32280b = function;
            observer = new WithLatestInnerObserver[i];
            for (function = null; function < i; function++) {
                observer[function] = new WithLatestInnerObserver(this, function);
            }
            this.f32281c = observer;
            this.f32282d = new AtomicReferenceArray(i);
            this.f32283e = new AtomicReference();
            this.f32284f = new AtomicThrowable();
        }

        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.m32092b(this.f32283e, disposable);
        }

        public final void onNext(T t) {
            if (!this.f32285g) {
                AtomicReferenceArray atomicReferenceArray = this.f32282d;
                int length = atomicReferenceArray.length();
                Object obj = new Object[(length + 1)];
                int i = 0;
                obj[0] = t;
                while (i < length) {
                    t = atomicReferenceArray.get(i);
                    if (t != null) {
                        i++;
                        obj[i] = t;
                    } else {
                        return;
                    }
                }
                try {
                    HalfSerializer.m26686a(this.f32279a, ObjectHelper.m26573a(this.f32280b.apply(obj), "combiner returned a null value"), (AtomicInteger) this, this.f32284f);
                } catch (T t2) {
                    Exceptions.m26521b(t2);
                    mo5626a();
                    onError(t2);
                }
            }
        }

        public final void onError(Throwable th) {
            if (this.f32285g) {
                RxJavaPlugins.m26757a(th);
                return;
            }
            this.f32285g = true;
            m32672a(-1);
            HalfSerializer.m26687a(this.f32279a, th, (AtomicInteger) this, this.f32284f);
        }

        public final void onComplete() {
            if (!this.f32285g) {
                this.f32285g = true;
                m32672a(-1);
                HalfSerializer.m26688a(this.f32279a, (AtomicInteger) this, this.f32284f);
            }
        }

        public final boolean mo5627b() {
            return DisposableHelper.m32088a((Disposable) this.f32283e.get());
        }

        public final void mo5626a() {
            DisposableHelper.m32090a(this.f32283e);
            for (AtomicReference a : this.f32281c) {
                DisposableHelper.m32090a(a);
            }
        }

        final void m32672a(int i) {
            WithLatestInnerObserver[] withLatestInnerObserverArr = this.f32281c;
            for (int i2 = 0; i2 < withLatestInnerObserverArr.length; i2++) {
                if (i2 != i) {
                    DisposableHelper.m32090a(withLatestInnerObserverArr[i2]);
                }
            }
        }
    }

    static final class WithLatestInnerObserver extends AtomicReference<Disposable> implements Observer<Object> {
        final WithLatestFromObserver<?, ?> f32286a;
        final int f32287b;
        boolean f32288c;

        WithLatestInnerObserver(WithLatestFromObserver<?, ?> withLatestFromObserver, int i) {
            this.f32286a = withLatestFromObserver;
            this.f32287b = i;
        }

        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.m32092b(this, disposable);
        }

        public final void onNext(Object obj) {
            if (!this.f32288c) {
                this.f32288c = true;
            }
            WithLatestFromObserver withLatestFromObserver = this.f32286a;
            withLatestFromObserver.f32282d.set(this.f32287b, obj);
        }

        public final void onError(Throwable th) {
            AtomicInteger atomicInteger = this.f32286a;
            int i = this.f32287b;
            atomicInteger.f32285g = true;
            DisposableHelper.m32090a(atomicInteger.f32283e);
            atomicInteger.m32672a(i);
            HalfSerializer.m26687a(atomicInteger.f32279a, th, atomicInteger, atomicInteger.f32284f);
        }

        public final void onComplete() {
            AtomicInteger atomicInteger = this.f32286a;
            int i = this.f32287b;
            if (!this.f32288c) {
                atomicInteger.f32285g = true;
                atomicInteger.m32672a(i);
                HalfSerializer.m26688a(atomicInteger.f32279a, atomicInteger, atomicInteger.f32284f);
            }
        }
    }

    public ObservableWithLatestFromMany(ObservableSource<T> observableSource, ObservableSource<?>[] observableSourceArr, Function<? super Object[], R> function) {
        super(observableSource);
        this.f38130a = observableSourceArr;
        this.f38131b = null;
        this.f38132c = function;
    }

    public ObservableWithLatestFromMany(ObservableSource<T> observableSource, Iterable<? extends ObservableSource<?>> iterable, Function<? super Object[], R> function) {
        super(observableSource);
        this.f38130a = null;
        this.f38131b = iterable;
        this.f38132c = function;
    }

    protected final void subscribeActual(Observer<? super R> observer) {
        Object[] objArr;
        int i;
        ObservableSource[] observableSourceArr = this.f38130a;
        int i2 = 0;
        if (observableSourceArr == null) {
            observableSourceArr = new ObservableSource[8];
            try {
                objArr = observableSourceArr;
                i = 0;
                for (ObservableSource observableSource : this.f38131b) {
                    if (i == objArr.length) {
                        objArr = (ObservableSource[]) Arrays.copyOf(objArr, (i >> 1) + i);
                    }
                    int i3 = i + 1;
                    objArr[i] = observableSource;
                    i = i3;
                }
            } catch (Throwable th) {
                Exceptions.m26521b(th);
                EmptyDisposable.m38051a(th, (Observer) observer);
                return;
            }
        }
        objArr = observableSourceArr;
        i = observableSourceArr.length;
        if (i == 0) {
            new ObservableMap(this.source, new SingletonArrayFunc(this)).subscribeActual(observer);
            return;
        }
        Observer withLatestFromObserver = new WithLatestFromObserver(observer, this.f38132c, i);
        observer.onSubscribe(withLatestFromObserver);
        observer = withLatestFromObserver.f32281c;
        AtomicReference atomicReference = withLatestFromObserver.f32283e;
        while (i2 < i && !DisposableHelper.m32088a((Disposable) atomicReference.get())) {
            if (withLatestFromObserver.f32285g) {
                break;
            }
            objArr[i2].subscribe(observer[i2]);
            i2++;
        }
        this.source.subscribe(withLatestFromObserver);
    }
}
