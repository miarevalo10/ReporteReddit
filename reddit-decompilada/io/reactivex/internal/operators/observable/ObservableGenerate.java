package io.reactivex.internal.operators.observable;

import io.reactivex.Emitter;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

public final class ObservableGenerate<T, S> extends Observable<T> {
    final Callable<S> f35682a;
    final BiFunction<S, Emitter<T>, S> f35683b;
    final Consumer<? super S> f35684c;

    static final class GeneratorDisposable<T, S> implements Emitter<T>, Disposable {
        final Observer<? super T> f31830a;
        final BiFunction<S, ? super Emitter<T>, S> f31831b;
        final Consumer<? super S> f31832c;
        S f31833d;
        volatile boolean f31834e;
        boolean f31835f;
        boolean f31836g;

        GeneratorDisposable(Observer<? super T> observer, BiFunction<S, ? super Emitter<T>, S> biFunction, Consumer<? super S> consumer, S s) {
            this.f31830a = observer;
            this.f31831b = biFunction;
            this.f31832c = consumer;
            this.f31833d = s;
        }

        final void m32469b(S s) {
            try {
                this.f31832c.accept(s);
            } catch (Throwable th) {
                Exceptions.m26521b(th);
                RxJavaPlugins.m26757a(th);
            }
        }

        public final void mo5626a() {
            this.f31834e = true;
        }

        public final boolean mo5627b() {
            return this.f31834e;
        }

        public final void mo5641a(T t) {
            if (!this.f31835f) {
                if (this.f31836g) {
                    mo5642a(new IllegalStateException("onNext already called in this generate turn"));
                } else if (t == null) {
                    mo5642a(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                } else {
                    this.f31836g = true;
                    this.f31830a.onNext(t);
                }
            }
        }

        public final void mo5642a(Throwable th) {
            if (this.f31835f) {
                RxJavaPlugins.m26757a(th);
                return;
            }
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            this.f31835f = true;
            this.f31830a.onError(th);
        }

        public final void aA_() {
            if (!this.f31835f) {
                this.f31835f = true;
                this.f31830a.onComplete();
            }
        }
    }

    public ObservableGenerate(Callable<S> callable, BiFunction<S, Emitter<T>, S> biFunction, Consumer<? super S> consumer) {
        this.f35682a = callable;
        this.f35683b = biFunction;
        this.f35684c = consumer;
    }

    public final void subscribeActual(Observer<? super T> observer) {
        try {
            GeneratorDisposable generatorDisposable = new GeneratorDisposable(observer, this.f35683b, this.f35684c, this.f35682a.call());
            observer.onSubscribe(generatorDisposable);
            observer = generatorDisposable.f31833d;
            if (generatorDisposable.f31834e) {
                generatorDisposable.f31833d = null;
                generatorDisposable.m32469b(observer);
                return;
            }
            BiFunction biFunction = generatorDisposable.f31831b;
            while (!generatorDisposable.f31834e) {
                generatorDisposable.f31836g = false;
                try {
                    Observer<? super T> apply = biFunction.apply(observer, generatorDisposable);
                    if (generatorDisposable.f31835f != null) {
                        generatorDisposable.f31834e = true;
                        generatorDisposable.f31833d = null;
                        generatorDisposable.m32469b(apply);
                        return;
                    }
                    observer = apply;
                } catch (Throwable th) {
                    Exceptions.m26521b(th);
                    generatorDisposable.f31833d = null;
                    generatorDisposable.f31834e = true;
                    generatorDisposable.mo5642a(th);
                    generatorDisposable.m32469b(observer);
                    return;
                }
            }
            generatorDisposable.f31833d = null;
            generatorDisposable.m32469b(observer);
        } catch (Throwable th2) {
            Exceptions.m26521b(th2);
            EmptyDisposable.m38051a(th2, (Observer) observer);
        }
    }
}
