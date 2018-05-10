package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
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
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableRepeatWhen<T> extends AbstractObservableWithUpstream<T, T> {
    final Function<? super Observable<Object>, ? extends ObservableSource<?>> f38048a;

    static final class RepeatWhenObserver<T> extends AtomicInteger implements Observer<T>, Disposable {
        final Observer<? super T> f32007a;
        final AtomicInteger f32008b = new AtomicInteger();
        final AtomicThrowable f32009c = new AtomicThrowable();
        final Subject<Object> f32010d;
        final InnerRepeatObserver f32011e = new InnerRepeatObserver(this);
        final AtomicReference<Disposable> f32012f = new AtomicReference();
        final ObservableSource<T> f32013g;
        volatile boolean f32014h;

        final class InnerRepeatObserver extends AtomicReference<Disposable> implements Observer<Object> {
            final /* synthetic */ RepeatWhenObserver f32006a;

            InnerRepeatObserver(RepeatWhenObserver repeatWhenObserver) {
                this.f32006a = repeatWhenObserver;
            }

            public final void onSubscribe(Disposable disposable) {
                DisposableHelper.m32092b(this, disposable);
            }

            public final void onNext(Object obj) {
                this.f32006a.m32549c();
            }

            public final void onError(Throwable th) {
                AtomicInteger atomicInteger = this.f32006a;
                DisposableHelper.m32090a(atomicInteger.f32012f);
                HalfSerializer.m26687a(atomicInteger.f32007a, th, atomicInteger, atomicInteger.f32009c);
            }

            public final void onComplete() {
                AtomicInteger atomicInteger = this.f32006a;
                DisposableHelper.m32090a(atomicInteger.f32012f);
                HalfSerializer.m26688a(atomicInteger.f32007a, atomicInteger, atomicInteger.f32009c);
            }
        }

        RepeatWhenObserver(Observer<? super T> observer, Subject<Object> subject, ObservableSource<T> observableSource) {
            this.f32007a = observer;
            this.f32010d = subject;
            this.f32013g = observableSource;
        }

        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.m32094c(this.f32012f, disposable);
        }

        public final void onNext(T t) {
            HalfSerializer.m26686a(this.f32007a, (Object) t, (AtomicInteger) this, this.f32009c);
        }

        public final void onError(Throwable th) {
            DisposableHelper.m32090a(this.f32011e);
            HalfSerializer.m26687a(this.f32007a, th, (AtomicInteger) this, this.f32009c);
        }

        public final void onComplete() {
            this.f32014h = false;
            this.f32010d.onNext(Integer.valueOf(0));
        }

        public final boolean mo5627b() {
            return DisposableHelper.m32088a((Disposable) this.f32012f.get());
        }

        public final void mo5626a() {
            DisposableHelper.m32090a(this.f32012f);
            DisposableHelper.m32090a(this.f32011e);
        }

        final void m32549c() {
            if (this.f32008b.getAndIncrement() == 0) {
                while (!mo5627b()) {
                    if (!this.f32014h) {
                        this.f32014h = true;
                        this.f32013g.subscribe(this);
                    }
                    if (this.f32008b.decrementAndGet() == 0) {
                    }
                }
            }
        }
    }

    public ObservableRepeatWhen(ObservableSource<T> observableSource, Function<? super Observable<Object>, ? extends ObservableSource<?>> function) {
        super(observableSource);
        this.f38048a = function;
    }

    protected final void subscribeActual(Observer<? super T> observer) {
        Subject toSerialized = PublishSubject.create().toSerialized();
        try {
            ObservableSource observableSource = (ObservableSource) ObjectHelper.m26573a(this.f38048a.apply(toSerialized), "The handler returned a null ObservableSource");
            RepeatWhenObserver repeatWhenObserver = new RepeatWhenObserver(observer, toSerialized, this.source);
            observer.onSubscribe(repeatWhenObserver);
            observableSource.subscribe(repeatWhenObserver.f32011e);
            repeatWhenObserver.m32549c();
        } catch (Throwable th) {
            Exceptions.m26521b(th);
            EmptyDisposable.m38051a(th, (Observer) observer);
        }
    }
}
