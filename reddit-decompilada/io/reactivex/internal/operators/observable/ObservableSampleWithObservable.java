package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.observers.SerializedObserver;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableSampleWithObservable<T> extends AbstractObservableWithUpstream<T, T> {
    final ObservableSource<?> f38064a;
    final boolean f38065b;

    static abstract class SampleMainObserver<T> extends AtomicReference<T> implements Observer<T>, Disposable {
        final Observer<? super T> f32061c;
        final ObservableSource<?> f32062d;
        final AtomicReference<Disposable> f32063e = new AtomicReference();
        Disposable f32064f;

        abstract void mo6648c();

        abstract void mo6649d();

        abstract void mo6650e();

        SampleMainObserver(Observer<? super T> observer, ObservableSource<?> observableSource) {
            this.f32061c = observer;
            this.f32062d = observableSource;
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f32064f, disposable)) {
                this.f32064f = disposable;
                this.f32061c.onSubscribe(this);
                if (this.f32063e.get() == null) {
                    this.f32062d.subscribe(new SamplerObserver(this));
                }
            }
        }

        public void onNext(T t) {
            lazySet(t);
        }

        public void onError(Throwable th) {
            DisposableHelper.m32090a(this.f32063e);
            this.f32061c.onError(th);
        }

        public void onComplete() {
            DisposableHelper.m32090a(this.f32063e);
            mo6648c();
        }

        public final void mo5626a() {
            DisposableHelper.m32090a(this.f32063e);
            this.f32064f.mo5626a();
        }

        public final boolean mo5627b() {
            return this.f32063e.get() == DisposableHelper.f31095a;
        }

        final void m32589f() {
            Object andSet = getAndSet(null);
            if (andSet != null) {
                this.f32061c.onNext(andSet);
            }
        }
    }

    static final class SamplerObserver<T> implements Observer<Object> {
        final SampleMainObserver<T> f32065a;

        SamplerObserver(SampleMainObserver<T> sampleMainObserver) {
            this.f32065a = sampleMainObserver;
        }

        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.m32092b(this.f32065a.f32063e, disposable);
        }

        public final void onNext(Object obj) {
            this.f32065a.mo6650e();
        }

        public final void onError(Throwable th) {
            SampleMainObserver sampleMainObserver = this.f32065a;
            sampleMainObserver.f32064f.mo5626a();
            sampleMainObserver.f32061c.onError(th);
        }

        public final void onComplete() {
            SampleMainObserver sampleMainObserver = this.f32065a;
            sampleMainObserver.f32064f.mo5626a();
            sampleMainObserver.mo6649d();
        }
    }

    static final class SampleMainEmitLast<T> extends SampleMainObserver<T> {
        final AtomicInteger f35721a = new AtomicInteger();
        volatile boolean f35722b;

        SampleMainEmitLast(Observer<? super T> observer, ObservableSource<?> observableSource) {
            super(observer, observableSource);
        }

        final void mo6648c() {
            this.f35722b = true;
            if (this.f35721a.getAndIncrement() == 0) {
                m32589f();
                this.c.onComplete();
            }
        }

        final void mo6649d() {
            this.f35722b = true;
            if (this.f35721a.getAndIncrement() == 0) {
                m32589f();
                this.c.onComplete();
            }
        }

        final void mo6650e() {
            if (this.f35721a.getAndIncrement() == 0) {
                do {
                    boolean z = this.f35722b;
                    m32589f();
                    if (z) {
                        this.c.onComplete();
                        return;
                    }
                } while (this.f35721a.decrementAndGet() != 0);
            }
        }
    }

    static final class SampleMainNoLast<T> extends SampleMainObserver<T> {
        SampleMainNoLast(Observer<? super T> observer, ObservableSource<?> observableSource) {
            super(observer, observableSource);
        }

        final void mo6648c() {
            this.c.onComplete();
        }

        final void mo6649d() {
            this.c.onComplete();
        }

        final void mo6650e() {
            m32589f();
        }
    }

    public ObservableSampleWithObservable(ObservableSource<T> observableSource, ObservableSource<?> observableSource2, boolean z) {
        super(observableSource);
        this.f38064a = observableSource2;
        this.f38065b = z;
    }

    public final void subscribeActual(Observer<? super T> observer) {
        Observer serializedObserver = new SerializedObserver(observer);
        if (this.f38065b != null) {
            this.source.subscribe(new SampleMainEmitLast(serializedObserver, this.f38064a));
        } else {
            this.source.subscribe(new SampleMainNoLast(serializedObserver, this.f38064a));
        }
    }
}
