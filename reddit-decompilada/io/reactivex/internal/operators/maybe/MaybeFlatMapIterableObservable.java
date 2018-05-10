package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.BasicQueueDisposable;
import java.util.Iterator;

public final class MaybeFlatMapIterableObservable<T, R> extends Observable<R> {
    final MaybeSource<T> f35579a;
    final Function<? super T, ? extends Iterable<? extends R>> f35580b;

    static final class FlatMapIterableObserver<T, R> extends BasicQueueDisposable<R> implements MaybeObserver<T> {
        final Observer<? super R> f39521a;
        final Function<? super T, ? extends Iterable<? extends R>> f39522b;
        Disposable f39523c;
        volatile Iterator<? extends R> f39524d;
        volatile boolean f39525e;
        boolean f39526f;

        FlatMapIterableObserver(Observer<? super R> observer, Function<? super T, ? extends Iterable<? extends R>> function) {
            this.f39521a = observer;
            this.f39522b = function;
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f39523c, disposable)) {
                this.f39523c = disposable;
                this.f39521a.onSubscribe(this);
            }
        }

        public final void onSuccess(T t) {
            Observer observer = this.f39521a;
            try {
                t = ((Iterable) this.f39522b.apply(t)).iterator();
                if (t.hasNext()) {
                    this.f39524d = t;
                    if (this.f39526f) {
                        observer.onNext(null);
                        observer.onComplete();
                        return;
                    }
                    while (!this.f39525e) {
                        try {
                            observer.onNext(t.next());
                            if (!this.f39525e) {
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
                    return;
                }
                observer.onComplete();
            } catch (T t222) {
                Exceptions.m26521b(t222);
                observer.onError(t222);
            }
        }

        public final void onError(Throwable th) {
            this.f39523c = DisposableHelper.f31095a;
            this.f39521a.onError(th);
        }

        public final void onComplete() {
            this.f39521a.onComplete();
        }

        public final void mo5626a() {
            this.f39525e = true;
            this.f39523c.mo5626a();
            this.f39523c = DisposableHelper.f31095a;
        }

        public final boolean mo5627b() {
            return this.f39525e;
        }

        public final int mo7033a(int i) {
            if ((i & 2) == 0) {
                return 0;
            }
            this.f39526f = true;
            return 2;
        }

        public final void clear() {
            this.f39524d = null;
        }

        public final boolean isEmpty() {
            return this.f39524d == null;
        }

        public final R poll() throws Exception {
            Iterator it = this.f39524d;
            if (it == null) {
                return null;
            }
            R a = ObjectHelper.m26573a(it.next(), "The iterator returned a null value");
            if (!it.hasNext()) {
                this.f39524d = null;
            }
            return a;
        }
    }

    public MaybeFlatMapIterableObservable(MaybeSource<T> maybeSource, Function<? super T, ? extends Iterable<? extends R>> function) {
        this.f35579a = maybeSource;
        this.f35580b = function;
    }

    protected final void subscribeActual(Observer<? super R> observer) {
        this.f35579a.subscribe(new FlatMapIterableObserver(observer, this.f35580b));
    }
}
