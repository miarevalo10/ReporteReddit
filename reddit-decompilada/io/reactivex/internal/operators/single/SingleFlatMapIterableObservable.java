package io.reactivex.internal.operators.single;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import java.util.Iterator;

public final class SingleFlatMapIterableObservable<T, R> extends Observable<R> {
    final SingleSource<T> f35814a;
    final Function<? super T, ? extends Iterable<? extends R>> f35815b;

    static final class FlatMapIterableObserver<T, R> extends BasicIntQueueDisposable<R> implements SingleObserver<T> {
        final Observer<? super R> f39681a;
        final Function<? super T, ? extends Iterable<? extends R>> f39682b;
        Disposable f39683c;
        volatile Iterator<? extends R> f39684d;
        volatile boolean f39685e;
        boolean f39686f;

        FlatMapIterableObserver(Observer<? super R> observer, Function<? super T, ? extends Iterable<? extends R>> function) {
            this.f39681a = observer;
            this.f39682b = function;
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f39683c, disposable)) {
                this.f39683c = disposable;
                this.f39681a.onSubscribe(this);
            }
        }

        public final void onSuccess(T t) {
            Observer observer = this.f39681a;
            try {
                t = ((Iterable) this.f39682b.apply(t)).iterator();
                if (!t.hasNext()) {
                    observer.onComplete();
                } else if (this.f39686f) {
                    this.f39684d = t;
                    observer.onNext(null);
                    observer.onComplete();
                } else {
                    while (!this.f39685e) {
                        try {
                            observer.onNext(t.next());
                            if (!this.f39685e) {
                                try {
                                    if (!t.hasNext()) {
                                        observer.onComplete();
                                        return;
                                    }
                                } catch (T t2) {
                                    Exceptions.m26521b(t2);
                                    observer.onError(t2);
                                    return;
                                }
                            }
                            return;
                        } catch (T t22) {
                            Exceptions.m26521b(t22);
                            observer.onError(t22);
                            return;
                        }
                    }
                }
            } catch (T t222) {
                Exceptions.m26521b(t222);
                this.f39681a.onError(t222);
            }
        }

        public final void onError(Throwable th) {
            this.f39683c = DisposableHelper.f31095a;
            this.f39681a.onError(th);
        }

        public final void mo5626a() {
            this.f39685e = true;
            this.f39683c.mo5626a();
            this.f39683c = DisposableHelper.f31095a;
        }

        public final boolean mo5627b() {
            return this.f39685e;
        }

        public final int mo7033a(int i) {
            if ((i & 2) == 0) {
                return 0;
            }
            this.f39686f = true;
            return 2;
        }

        public final void clear() {
            this.f39684d = null;
        }

        public final boolean isEmpty() {
            return this.f39684d == null;
        }

        public final R poll() throws Exception {
            Iterator it = this.f39684d;
            if (it == null) {
                return null;
            }
            R a = ObjectHelper.m26573a(it.next(), "The iterator returned a null value");
            if (!it.hasNext()) {
                this.f39684d = null;
            }
            return a;
        }
    }

    public SingleFlatMapIterableObservable(SingleSource<T> singleSource, Function<? super T, ? extends Iterable<? extends R>> function) {
        this.f35814a = singleSource;
        this.f35815b = function;
    }

    protected final void subscribeActual(Observer<? super R> observer) {
        this.f35814a.subscribe(new FlatMapIterableObserver(observer, this.f35815b));
    }
}
