package io.reactivex.internal.operators.observable;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableFlatMapCompletable<T> extends AbstractObservableWithUpstream<T, T> {
    final Function<? super T, ? extends CompletableSource> f38004a;
    final boolean f38005b;

    static final class FlatMapCompletableMainObserver<T> extends BasicIntQueueDisposable<T> implements Observer<T> {
        final Observer<? super T> f39584a;
        final AtomicThrowable f39585b = new AtomicThrowable();
        final Function<? super T, ? extends CompletableSource> f39586c;
        final boolean f39587d;
        final CompositeDisposable f39588e = new CompositeDisposable();
        Disposable f39589f;
        volatile boolean f39590g;

        final class InnerObserver extends AtomicReference<Disposable> implements CompletableObserver, Disposable {
            final /* synthetic */ FlatMapCompletableMainObserver f31798a;

            InnerObserver(FlatMapCompletableMainObserver flatMapCompletableMainObserver) {
                this.f31798a = flatMapCompletableMainObserver;
            }

            public final void onSubscribe(Disposable disposable) {
                DisposableHelper.m32092b(this, disposable);
            }

            public final void onComplete() {
                FlatMapCompletableMainObserver flatMapCompletableMainObserver = this.f31798a;
                flatMapCompletableMainObserver.f39588e.mo5633c(this);
                flatMapCompletableMainObserver.onComplete();
            }

            public final void onError(Throwable th) {
                FlatMapCompletableMainObserver flatMapCompletableMainObserver = this.f31798a;
                flatMapCompletableMainObserver.f39588e.mo5633c(this);
                flatMapCompletableMainObserver.onError(th);
            }

            public final void mo5626a() {
                DisposableHelper.m32090a((AtomicReference) this);
            }

            public final boolean mo5627b() {
                return DisposableHelper.m32088a((Disposable) get());
            }
        }

        public final int mo7033a(int i) {
            return i & 2;
        }

        public final void clear() {
        }

        public final boolean isEmpty() {
            return true;
        }

        public final T poll() throws Exception {
            return null;
        }

        FlatMapCompletableMainObserver(Observer<? super T> observer, Function<? super T, ? extends CompletableSource> function, boolean z) {
            this.f39584a = observer;
            this.f39586c = function;
            this.f39587d = z;
            lazySet(1);
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f39589f, disposable)) {
                this.f39589f = disposable;
                this.f39584a.onSubscribe(this);
            }
        }

        public final void onNext(T t) {
            try {
                CompletableSource completableSource = (CompletableSource) ObjectHelper.m26573a(this.f39586c.apply(t), "The mapper returned a null CompletableSource");
                getAndIncrement();
                Disposable innerObserver = new InnerObserver(this);
                if (!this.f39590g && this.f39588e.mo5631a(innerObserver)) {
                    completableSource.subscribe(innerObserver);
                }
            } catch (T t2) {
                Exceptions.m26521b(t2);
                this.f39589f.mo5626a();
                onError(t2);
            }
        }

        public final void onError(Throwable th) {
            if (!ExceptionHelper.m26684a(this.f39585b, th)) {
                RxJavaPlugins.m26757a(th);
            } else if (this.f39587d == null) {
                mo5626a();
                if (getAndSet(null) > null) {
                    this.f39584a.onError(ExceptionHelper.m26683a(this.f39585b));
                }
            } else if (decrementAndGet() == null) {
                this.f39584a.onError(ExceptionHelper.m26683a(this.f39585b));
            }
        }

        public final void onComplete() {
            if (decrementAndGet() == 0) {
                Throwable a = ExceptionHelper.m26683a(this.f39585b);
                if (a != null) {
                    this.f39584a.onError(a);
                    return;
                }
                this.f39584a.onComplete();
            }
        }

        public final void mo5626a() {
            this.f39590g = true;
            this.f39589f.mo5626a();
            this.f39588e.mo5626a();
        }

        public final boolean mo5627b() {
            return this.f39589f.mo5627b();
        }
    }

    public ObservableFlatMapCompletable(ObservableSource<T> observableSource, Function<? super T, ? extends CompletableSource> function, boolean z) {
        super(observableSource);
        this.f38004a = function;
        this.f38005b = z;
    }

    protected final void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new FlatMapCompletableMainObserver(observer, this.f38004a, this.f38005b));
    }
}
