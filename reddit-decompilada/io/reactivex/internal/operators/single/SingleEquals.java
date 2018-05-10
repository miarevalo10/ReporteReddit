package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;

public final class SingleEquals<T> extends Single<Boolean> {
    final SingleSource<? extends T> f35805a;
    final SingleSource<? extends T> f35806b;

    static class InnerObserver<T> implements SingleObserver<T> {
        final int f32349a;
        final CompositeDisposable f32350b;
        final Object[] f32351c;
        final SingleObserver<? super Boolean> f32352d;
        final AtomicInteger f32353e;

        InnerObserver(int i, CompositeDisposable compositeDisposable, Object[] objArr, SingleObserver<? super Boolean> singleObserver, AtomicInteger atomicInteger) {
            this.f32349a = i;
            this.f32350b = compositeDisposable;
            this.f32351c = objArr;
            this.f32352d = singleObserver;
            this.f32353e = atomicInteger;
        }

        public void onSubscribe(Disposable disposable) {
            this.f32350b.mo5631a(disposable);
        }

        public void onSuccess(T t) {
            this.f32351c[this.f32349a] = t;
            if (this.f32353e.incrementAndGet() == 2) {
                this.f32352d.onSuccess(Boolean.valueOf(ObjectHelper.m26574a(this.f32351c[0], this.f32351c[1])));
            }
        }

        public void onError(Throwable th) {
            int i;
            do {
                i = this.f32353e.get();
                if (i >= 2) {
                    RxJavaPlugins.m26757a(th);
                    return;
                }
            } while (!this.f32353e.compareAndSet(i, 2));
            this.f32350b.mo5626a();
            this.f32352d.onError(th);
        }
    }

    public SingleEquals(SingleSource<? extends T> singleSource, SingleSource<? extends T> singleSource2) {
        this.f35805a = singleSource;
        this.f35806b = singleSource2;
    }

    protected final void subscribeActual(SingleObserver<? super Boolean> singleObserver) {
        AtomicInteger atomicInteger = new AtomicInteger();
        Object[] objArr = new Object[]{null, null};
        Disposable compositeDisposable = new CompositeDisposable();
        singleObserver.onSubscribe(compositeDisposable);
        Disposable disposable = compositeDisposable;
        Object[] objArr2 = objArr;
        SingleObserver<? super Boolean> singleObserver2 = singleObserver;
        AtomicInteger atomicInteger2 = atomicInteger;
        this.f35805a.subscribe(new InnerObserver(0, disposable, objArr2, singleObserver2, atomicInteger2));
        this.f35806b.subscribe(new InnerObserver(1, disposable, objArr2, singleObserver2, atomicInteger2));
    }
}
