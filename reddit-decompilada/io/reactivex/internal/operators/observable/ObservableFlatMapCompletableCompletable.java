package io.reactivex.internal.operators.observable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableFlatMapCompletableCompletable<T> extends Completable implements FuseToObservable<T> {
    final ObservableSource<T> f35669a;
    final Function<? super T, ? extends CompletableSource> f35670b;
    final boolean f35671c;

    static final class FlatMapCompletableMainObserver<T> extends AtomicInteger implements Observer<T>, Disposable {
        final CompletableObserver f31800a;
        final AtomicThrowable f31801b = new AtomicThrowable();
        final Function<? super T, ? extends CompletableSource> f31802c;
        final boolean f31803d;
        final CompositeDisposable f31804e = new CompositeDisposable();
        Disposable f31805f;
        volatile boolean f31806g;

        final class InnerObserver extends AtomicReference<Disposable> implements CompletableObserver, Disposable {
            final /* synthetic */ FlatMapCompletableMainObserver f31799a;

            InnerObserver(FlatMapCompletableMainObserver flatMapCompletableMainObserver) {
                this.f31799a = flatMapCompletableMainObserver;
            }

            public final void onSubscribe(Disposable disposable) {
                DisposableHelper.m32092b(this, disposable);
            }

            public final void onComplete() {
                FlatMapCompletableMainObserver flatMapCompletableMainObserver = this.f31799a;
                flatMapCompletableMainObserver.f31804e.mo5633c(this);
                flatMapCompletableMainObserver.onComplete();
            }

            public final void onError(Throwable th) {
                FlatMapCompletableMainObserver flatMapCompletableMainObserver = this.f31799a;
                flatMapCompletableMainObserver.f31804e.mo5633c(this);
                flatMapCompletableMainObserver.onError(th);
            }

            public final void mo5626a() {
                DisposableHelper.m32090a((AtomicReference) this);
            }

            public final boolean mo5627b() {
                return DisposableHelper.m32088a((Disposable) get());
            }
        }

        FlatMapCompletableMainObserver(CompletableObserver completableObserver, Function<? super T, ? extends CompletableSource> function, boolean z) {
            this.f31800a = completableObserver;
            this.f31802c = function;
            this.f31803d = z;
            lazySet(1);
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f31805f, disposable)) {
                this.f31805f = disposable;
                this.f31800a.onSubscribe(this);
            }
        }

        public final void onNext(T t) {
            try {
                CompletableSource completableSource = (CompletableSource) ObjectHelper.m26573a(this.f31802c.apply(t), "The mapper returned a null CompletableSource");
                getAndIncrement();
                Disposable innerObserver = new InnerObserver(this);
                if (!this.f31806g && this.f31804e.mo5631a(innerObserver)) {
                    completableSource.subscribe(innerObserver);
                }
            } catch (T t2) {
                Exceptions.m26521b(t2);
                this.f31805f.mo5626a();
                onError(t2);
            }
        }

        public final void onError(Throwable th) {
            if (!ExceptionHelper.m26684a(this.f31801b, th)) {
                RxJavaPlugins.m26757a(th);
            } else if (this.f31803d == null) {
                mo5626a();
                if (getAndSet(null) > null) {
                    this.f31800a.onError(ExceptionHelper.m26683a(this.f31801b));
                }
            } else if (decrementAndGet() == null) {
                this.f31800a.onError(ExceptionHelper.m26683a(this.f31801b));
            }
        }

        public final void onComplete() {
            if (decrementAndGet() == 0) {
                Throwable a = ExceptionHelper.m26683a(this.f31801b);
                if (a != null) {
                    this.f31800a.onError(a);
                    return;
                }
                this.f31800a.onComplete();
            }
        }

        public final void mo5626a() {
            this.f31806g = true;
            this.f31805f.mo5626a();
            this.f31804e.mo5626a();
        }

        public final boolean mo5627b() {
            return this.f31805f.mo5627b();
        }
    }

    public ObservableFlatMapCompletableCompletable(ObservableSource<T> observableSource, Function<? super T, ? extends CompletableSource> function, boolean z) {
        this.f35669a = observableSource;
        this.f35670b = function;
        this.f35671c = z;
    }

    protected final void subscribeActual(CompletableObserver completableObserver) {
        this.f35669a.subscribe(new FlatMapCompletableMainObserver(completableObserver, this.f35670b, this.f35671c));
    }

    public final Observable<T> mo6641a() {
        return RxJavaPlugins.m26742a(new ObservableFlatMapCompletable(this.f35669a, this.f35670b, this.f35671c));
    }
}
