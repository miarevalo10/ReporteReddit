package io.reactivex.internal.operators.observable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableConcatMapCompletable<T> extends Completable {
    final ObservableSource<T> f35648a;
    final Function<? super T, ? extends CompletableSource> f35649b;
    final int f35650c;

    static final class SourceObserver<T> extends AtomicInteger implements Observer<T>, Disposable {
        final CompletableObserver f31677a;
        final Function<? super T, ? extends CompletableSource> f31678b;
        final InnerObserver f31679c;
        final int f31680d;
        SimpleQueue<T> f31681e;
        Disposable f31682f;
        volatile boolean f31683g;
        volatile boolean f31684h;
        volatile boolean f31685i;
        int f31686j;

        static final class InnerObserver extends AtomicReference<Disposable> implements CompletableObserver {
            final CompletableObserver f31675a;
            final SourceObserver<?> f31676b;

            InnerObserver(CompletableObserver completableObserver, SourceObserver<?> sourceObserver) {
                this.f31675a = completableObserver;
                this.f31676b = sourceObserver;
            }

            public final void onSubscribe(Disposable disposable) {
                DisposableHelper.m32091a((AtomicReference) this, disposable);
            }

            public final void onError(Throwable th) {
                this.f31676b.mo5626a();
                this.f31675a.onError(th);
            }

            public final void onComplete() {
                SourceObserver sourceObserver = this.f31676b;
                sourceObserver.f31683g = false;
                sourceObserver.m32397c();
            }
        }

        SourceObserver(CompletableObserver completableObserver, Function<? super T, ? extends CompletableSource> function, int i) {
            this.f31677a = completableObserver;
            this.f31678b = function;
            this.f31680d = i;
            this.f31679c = new InnerObserver(completableObserver, this);
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f31682f, disposable)) {
                this.f31682f = disposable;
                if (disposable instanceof QueueDisposable) {
                    QueueDisposable queueDisposable = (QueueDisposable) disposable;
                    int a = queueDisposable.mo7033a(3);
                    if (a == 1) {
                        this.f31686j = a;
                        this.f31681e = queueDisposable;
                        this.f31685i = true;
                        this.f31677a.onSubscribe(this);
                        m32397c();
                        return;
                    } else if (a == 2) {
                        this.f31686j = a;
                        this.f31681e = queueDisposable;
                        this.f31677a.onSubscribe(this);
                        return;
                    }
                }
                this.f31681e = new SpscLinkedArrayQueue(this.f31680d);
                this.f31677a.onSubscribe(this);
            }
        }

        public final void onNext(T t) {
            if (!this.f31685i) {
                if (this.f31686j == 0) {
                    this.f31681e.offer(t);
                }
                m32397c();
            }
        }

        public final void onError(Throwable th) {
            if (this.f31685i) {
                RxJavaPlugins.m26757a(th);
                return;
            }
            this.f31685i = true;
            mo5626a();
            this.f31677a.onError(th);
        }

        public final void onComplete() {
            if (!this.f31685i) {
                this.f31685i = true;
                m32397c();
            }
        }

        public final boolean mo5627b() {
            return this.f31684h;
        }

        public final void mo5626a() {
            this.f31684h = true;
            DisposableHelper.m32090a(this.f31679c);
            this.f31682f.mo5626a();
            if (getAndIncrement() == 0) {
                this.f31681e.clear();
            }
        }

        final void m32397c() {
            if (getAndIncrement() == 0) {
                while (!this.f31684h) {
                    if (!this.f31683g) {
                        boolean z = this.f31685i;
                        try {
                            Object poll = this.f31681e.poll();
                            boolean z2 = poll == null;
                            if (z && z2) {
                                this.f31684h = true;
                                this.f31677a.onComplete();
                                return;
                            } else if (!z2) {
                                try {
                                    CompletableSource completableSource = (CompletableSource) ObjectHelper.m26573a(this.f31678b.apply(poll), "The mapper returned a null CompletableSource");
                                    this.f31683g = true;
                                    completableSource.subscribe(this.f31679c);
                                } catch (Throwable th) {
                                    Exceptions.m26521b(th);
                                    mo5626a();
                                    this.f31681e.clear();
                                    this.f31677a.onError(th);
                                    return;
                                }
                            }
                        } catch (Throwable th2) {
                            Exceptions.m26521b(th2);
                            mo5626a();
                            this.f31681e.clear();
                            this.f31677a.onError(th2);
                            return;
                        }
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
                this.f31681e.clear();
            }
        }
    }

    public ObservableConcatMapCompletable(ObservableSource<T> observableSource, Function<? super T, ? extends CompletableSource> function, int i) {
        this.f35648a = observableSource;
        this.f35649b = function;
        this.f35650c = Math.max(8, i);
    }

    public final void subscribeActual(CompletableObserver completableObserver) {
        this.f35648a.subscribe(new SourceObserver(completableObserver, this.f35649b, this.f35650c));
    }
}
