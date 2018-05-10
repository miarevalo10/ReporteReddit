package io.reactivex.internal.operators.observable;

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
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.observers.SerializedObserver;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableConcatMap<T, U> extends AbstractObservableWithUpstream<T, U> {
    final Function<? super T, ? extends ObservableSource<? extends U>> f37966a;
    final int f37967b;
    final ErrorMode f37968c;

    static final class ConcatMapDelayErrorObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {
        final Observer<? super R> f31651a;
        final Function<? super T, ? extends ObservableSource<? extends R>> f31652b;
        final int f31653c;
        final AtomicThrowable f31654d = new AtomicThrowable();
        final DelayErrorInnerObserver<R> f31655e;
        final boolean f31656f;
        SimpleQueue<T> f31657g;
        Disposable f31658h;
        volatile boolean f31659i;
        volatile boolean f31660j;
        volatile boolean f31661k;
        int f31662l;

        static final class DelayErrorInnerObserver<R> extends AtomicReference<Disposable> implements Observer<R> {
            final Observer<? super R> f31649a;
            final ConcatMapDelayErrorObserver<?, R> f31650b;

            DelayErrorInnerObserver(Observer<? super R> observer, ConcatMapDelayErrorObserver<?, R> concatMapDelayErrorObserver) {
                this.f31649a = observer;
                this.f31650b = concatMapDelayErrorObserver;
            }

            public final void onSubscribe(Disposable disposable) {
                DisposableHelper.m32094c(this, disposable);
            }

            public final void onNext(R r) {
                this.f31649a.onNext(r);
            }

            public final void onError(Throwable th) {
                ConcatMapDelayErrorObserver concatMapDelayErrorObserver = this.f31650b;
                if (ExceptionHelper.m26684a(concatMapDelayErrorObserver.f31654d, th)) {
                    if (concatMapDelayErrorObserver.f31656f == null) {
                        concatMapDelayErrorObserver.f31658h.mo5626a();
                    }
                    concatMapDelayErrorObserver.f31659i = null;
                    concatMapDelayErrorObserver.m32391c();
                    return;
                }
                RxJavaPlugins.m26757a(th);
            }

            public final void onComplete() {
                ConcatMapDelayErrorObserver concatMapDelayErrorObserver = this.f31650b;
                concatMapDelayErrorObserver.f31659i = false;
                concatMapDelayErrorObserver.m32391c();
            }
        }

        ConcatMapDelayErrorObserver(Observer<? super R> observer, Function<? super T, ? extends ObservableSource<? extends R>> function, int i, boolean z) {
            this.f31651a = observer;
            this.f31652b = function;
            this.f31653c = i;
            this.f31656f = z;
            this.f31655e = new DelayErrorInnerObserver(observer, this);
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f31658h, disposable)) {
                this.f31658h = disposable;
                if (disposable instanceof QueueDisposable) {
                    QueueDisposable queueDisposable = (QueueDisposable) disposable;
                    int a = queueDisposable.mo7033a(3);
                    if (a == 1) {
                        this.f31662l = a;
                        this.f31657g = queueDisposable;
                        this.f31660j = true;
                        this.f31651a.onSubscribe(this);
                        m32391c();
                        return;
                    } else if (a == 2) {
                        this.f31662l = a;
                        this.f31657g = queueDisposable;
                        this.f31651a.onSubscribe(this);
                        return;
                    }
                }
                this.f31657g = new SpscLinkedArrayQueue(this.f31653c);
                this.f31651a.onSubscribe(this);
            }
        }

        public final void onNext(T t) {
            if (this.f31662l == 0) {
                this.f31657g.offer(t);
            }
            m32391c();
        }

        public final void onError(Throwable th) {
            if (ExceptionHelper.m26684a(this.f31654d, th)) {
                this.f31660j = true;
                m32391c();
                return;
            }
            RxJavaPlugins.m26757a(th);
        }

        public final void onComplete() {
            this.f31660j = true;
            m32391c();
        }

        public final boolean mo5627b() {
            return this.f31661k;
        }

        public final void mo5626a() {
            this.f31661k = true;
            this.f31658h.mo5626a();
            DisposableHelper.m32090a(this.f31655e);
        }

        final void m32391c() {
            if (getAndIncrement() == 0) {
                Observer observer = this.f31651a;
                SimpleQueue simpleQueue = this.f31657g;
                AtomicReference atomicReference = this.f31654d;
                while (true) {
                    if (!this.f31659i) {
                        if (this.f31661k) {
                            simpleQueue.clear();
                            return;
                        } else if (this.f31656f || ((Throwable) atomicReference.get()) == null) {
                            boolean z = this.f31660j;
                            try {
                                Object poll = simpleQueue.poll();
                                boolean z2 = poll == null;
                                if (z && z2) {
                                    break;
                                } else if (!z2) {
                                    try {
                                        ObservableSource observableSource = (ObservableSource) ObjectHelper.m26573a(this.f31652b.apply(poll), "The mapper returned a null ObservableSource");
                                        if (observableSource instanceof Callable) {
                                            try {
                                                Object call = ((Callable) observableSource).call();
                                                if (!(call == null || this.f31661k)) {
                                                    observer.onNext(call);
                                                }
                                            } catch (Throwable th) {
                                                Exceptions.m26521b(th);
                                                ExceptionHelper.m26684a(atomicReference, th);
                                            }
                                        } else {
                                            this.f31659i = true;
                                            observableSource.subscribe(this.f31655e);
                                        }
                                    } catch (Throwable th2) {
                                        Exceptions.m26521b(th2);
                                        this.f31661k = true;
                                        this.f31658h.mo5626a();
                                        simpleQueue.clear();
                                        ExceptionHelper.m26684a(atomicReference, th2);
                                        observer.onError(ExceptionHelper.m26683a(atomicReference));
                                        return;
                                    }
                                }
                            } catch (Throwable th3) {
                                Exceptions.m26521b(th3);
                                this.f31661k = true;
                                this.f31658h.mo5626a();
                                ExceptionHelper.m26684a(atomicReference, th3);
                                observer.onError(ExceptionHelper.m26683a(atomicReference));
                                return;
                            }
                        } else {
                            simpleQueue.clear();
                            this.f31661k = true;
                            observer.onError(ExceptionHelper.m26683a(atomicReference));
                            return;
                        }
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
                this.f31661k = true;
                Throwable th32 = ExceptionHelper.m26683a(atomicReference);
                if (th32 != null) {
                    observer.onError(th32);
                } else {
                    observer.onComplete();
                }
            }
        }
    }

    static final class SourceObserver<T, U> extends AtomicInteger implements Observer<T>, Disposable {
        final Observer<? super U> f31665a;
        final Function<? super T, ? extends ObservableSource<? extends U>> f31666b;
        final InnerObserver<U> f31667c;
        final int f31668d;
        SimpleQueue<T> f31669e;
        Disposable f31670f;
        volatile boolean f31671g;
        volatile boolean f31672h;
        volatile boolean f31673i;
        int f31674j;

        static final class InnerObserver<U> extends AtomicReference<Disposable> implements Observer<U> {
            final Observer<? super U> f31663a;
            final SourceObserver<?, ?> f31664b;

            InnerObserver(Observer<? super U> observer, SourceObserver<?, ?> sourceObserver) {
                this.f31663a = observer;
                this.f31664b = sourceObserver;
            }

            public final void onSubscribe(Disposable disposable) {
                DisposableHelper.m32091a((AtomicReference) this, disposable);
            }

            public final void onNext(U u) {
                this.f31663a.onNext(u);
            }

            public final void onError(Throwable th) {
                this.f31664b.mo5626a();
                this.f31663a.onError(th);
            }

            public final void onComplete() {
                SourceObserver sourceObserver = this.f31664b;
                sourceObserver.f31671g = false;
                sourceObserver.m32394c();
            }
        }

        SourceObserver(Observer<? super U> observer, Function<? super T, ? extends ObservableSource<? extends U>> function, int i) {
            this.f31665a = observer;
            this.f31666b = function;
            this.f31668d = i;
            this.f31667c = new InnerObserver(observer, this);
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f31670f, disposable)) {
                this.f31670f = disposable;
                if (disposable instanceof QueueDisposable) {
                    QueueDisposable queueDisposable = (QueueDisposable) disposable;
                    int a = queueDisposable.mo7033a(3);
                    if (a == 1) {
                        this.f31674j = a;
                        this.f31669e = queueDisposable;
                        this.f31673i = true;
                        this.f31665a.onSubscribe(this);
                        m32394c();
                        return;
                    } else if (a == 2) {
                        this.f31674j = a;
                        this.f31669e = queueDisposable;
                        this.f31665a.onSubscribe(this);
                        return;
                    }
                }
                this.f31669e = new SpscLinkedArrayQueue(this.f31668d);
                this.f31665a.onSubscribe(this);
            }
        }

        public final void onNext(T t) {
            if (!this.f31673i) {
                if (this.f31674j == 0) {
                    this.f31669e.offer(t);
                }
                m32394c();
            }
        }

        public final void onError(Throwable th) {
            if (this.f31673i) {
                RxJavaPlugins.m26757a(th);
                return;
            }
            this.f31673i = true;
            mo5626a();
            this.f31665a.onError(th);
        }

        public final void onComplete() {
            if (!this.f31673i) {
                this.f31673i = true;
                m32394c();
            }
        }

        public final boolean mo5627b() {
            return this.f31672h;
        }

        public final void mo5626a() {
            this.f31672h = true;
            DisposableHelper.m32090a(this.f31667c);
            this.f31670f.mo5626a();
            if (getAndIncrement() == 0) {
                this.f31669e.clear();
            }
        }

        final void m32394c() {
            if (getAndIncrement() == 0) {
                while (!this.f31672h) {
                    if (!this.f31671g) {
                        boolean z = this.f31673i;
                        try {
                            Object poll = this.f31669e.poll();
                            boolean z2 = poll == null;
                            if (z && z2) {
                                this.f31672h = true;
                                this.f31665a.onComplete();
                                return;
                            } else if (!z2) {
                                try {
                                    ObservableSource observableSource = (ObservableSource) ObjectHelper.m26573a(this.f31666b.apply(poll), "The mapper returned a null ObservableSource");
                                    this.f31671g = true;
                                    observableSource.subscribe(this.f31667c);
                                } catch (Throwable th) {
                                    Exceptions.m26521b(th);
                                    mo5626a();
                                    this.f31669e.clear();
                                    this.f31665a.onError(th);
                                    return;
                                }
                            }
                        } catch (Throwable th2) {
                            Exceptions.m26521b(th2);
                            mo5626a();
                            this.f31669e.clear();
                            this.f31665a.onError(th2);
                            return;
                        }
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
                this.f31669e.clear();
            }
        }
    }

    public ObservableConcatMap(ObservableSource<T> observableSource, Function<? super T, ? extends ObservableSource<? extends U>> function, int i, ErrorMode errorMode) {
        super(observableSource);
        this.f37966a = function;
        this.f37968c = errorMode;
        this.f37967b = Math.max(8, i);
    }

    public final void subscribeActual(Observer<? super U> observer) {
        if (!ObservableScalarXMap.m26648a(this.source, observer, this.f37966a)) {
            if (this.f37968c == ErrorMode.IMMEDIATE) {
                this.source.subscribe(new SourceObserver(new SerializedObserver(observer), this.f37966a, this.f37967b));
            } else {
                this.source.subscribe(new ConcatMapDelayErrorObserver(observer, this.f37966a, this.f37967b, this.f37968c == ErrorMode.END));
            }
        }
    }
}
