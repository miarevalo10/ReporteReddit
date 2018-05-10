package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiConsumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

public final class ObservableCollect<T, U> extends AbstractObservableWithUpstream<T, U> {
    final Callable<? extends U> f37964a;
    final BiConsumer<? super U, ? super T> f37965b;

    static final class CollectObserver<T, U> implements Observer<T>, Disposable {
        final Observer<? super U> f31626a;
        final BiConsumer<? super U, ? super T> f31627b;
        final U f31628c;
        Disposable f31629d;
        boolean f31630e;

        CollectObserver(Observer<? super U> observer, U u, BiConsumer<? super U, ? super T> biConsumer) {
            this.f31626a = observer;
            this.f31627b = biConsumer;
            this.f31628c = u;
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f31629d, disposable)) {
                this.f31629d = disposable;
                this.f31626a.onSubscribe(this);
            }
        }

        public final void mo5626a() {
            this.f31629d.mo5626a();
        }

        public final boolean mo5627b() {
            return this.f31629d.mo5627b();
        }

        public final void onNext(T t) {
            if (!this.f31630e) {
                try {
                    this.f31627b.mo4825a(this.f31628c, t);
                } catch (T t2) {
                    this.f31629d.mo5626a();
                    onError(t2);
                }
            }
        }

        public final void onError(Throwable th) {
            if (this.f31630e) {
                RxJavaPlugins.m26757a(th);
                return;
            }
            this.f31630e = true;
            this.f31626a.onError(th);
        }

        public final void onComplete() {
            if (!this.f31630e) {
                this.f31630e = true;
                this.f31626a.onNext(this.f31628c);
                this.f31626a.onComplete();
            }
        }
    }

    public ObservableCollect(ObservableSource<T> observableSource, Callable<? extends U> callable, BiConsumer<? super U, ? super T> biConsumer) {
        super(observableSource);
        this.f37964a = callable;
        this.f37965b = biConsumer;
    }

    protected final void subscribeActual(Observer<? super U> observer) {
        try {
            this.source.subscribe(new CollectObserver(observer, ObjectHelper.m26573a(this.f37964a.call(), "The initialSupplier returned a null value"), this.f37965b));
        } catch (Throwable th) {
            EmptyDisposable.m38051a(th, (Observer) observer);
        }
    }
}
