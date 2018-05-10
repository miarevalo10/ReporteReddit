package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;

public final class ObservableDoOnEach<T> extends AbstractObservableWithUpstream<T, T> {
    final Consumer<? super T> f37990a;
    final Consumer<? super Throwable> f37991b;
    final Action f37992c;
    final Action f37993d;

    static final class DoOnEachObserver<T> implements Observer<T>, Disposable {
        final Observer<? super T> f31750a;
        final Consumer<? super T> f31751b;
        final Consumer<? super Throwable> f31752c;
        final Action f31753d;
        final Action f31754e;
        Disposable f31755f;
        boolean f31756g;

        DoOnEachObserver(Observer<? super T> observer, Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action, Action action2) {
            this.f31750a = observer;
            this.f31751b = consumer;
            this.f31752c = consumer2;
            this.f31753d = action;
            this.f31754e = action2;
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f31755f, disposable)) {
                this.f31755f = disposable;
                this.f31750a.onSubscribe(this);
            }
        }

        public final void mo5626a() {
            this.f31755f.mo5626a();
        }

        public final boolean mo5627b() {
            return this.f31755f.mo5627b();
        }

        public final void onNext(T t) {
            if (!this.f31756g) {
                try {
                    this.f31751b.accept(t);
                    this.f31750a.onNext(t);
                } catch (T t2) {
                    Exceptions.m26521b(t2);
                    this.f31755f.mo5626a();
                    onError(t2);
                }
            }
        }

        public final void onError(Throwable th) {
            if (this.f31756g) {
                RxJavaPlugins.m26757a(th);
                return;
            }
            this.f31756g = true;
            try {
                this.f31752c.accept(th);
            } catch (Throwable th2) {
                Exceptions.m26521b(th2);
                th = new CompositeException(th, th2);
            }
            this.f31750a.onError(th);
            try {
                this.f31754e.run();
            } catch (Throwable th3) {
                Exceptions.m26521b(th3);
                RxJavaPlugins.m26757a(th3);
            }
        }

        public final void onComplete() {
            if (!this.f31756g) {
                try {
                    this.f31753d.run();
                    this.f31756g = true;
                    this.f31750a.onComplete();
                    try {
                        this.f31754e.run();
                    } catch (Throwable th) {
                        Exceptions.m26521b(th);
                        RxJavaPlugins.m26757a(th);
                    }
                } catch (Throwable th2) {
                    Exceptions.m26521b(th2);
                    onError(th2);
                }
            }
        }
    }

    public ObservableDoOnEach(ObservableSource<T> observableSource, Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action, Action action2) {
        super(observableSource);
        this.f37990a = consumer;
        this.f37991b = consumer2;
        this.f37992c = action;
        this.f37993d = action2;
    }

    public final void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new DoOnEachObserver(observer, this.f37990a, this.f37991b, this.f37992c, this.f37993d));
    }
}
