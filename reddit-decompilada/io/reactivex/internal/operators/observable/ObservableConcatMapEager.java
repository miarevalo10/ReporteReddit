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
import io.reactivex.internal.observers.InnerQueuedObserver;
import io.reactivex.internal.observers.InnerQueuedObserverSupport;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableConcatMapEager<T, R> extends AbstractObservableWithUpstream<T, R> {
    final Function<? super T, ? extends ObservableSource<? extends R>> f37969a;
    final ErrorMode f37970b;
    final int f37971c;
    final int f37972d;

    static final class ConcatMapEagerMainObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable, InnerQueuedObserverSupport<R> {
        final Observer<? super R> f31687a;
        final Function<? super T, ? extends ObservableSource<? extends R>> f31688b;
        final int f31689c;
        final int f31690d;
        final ErrorMode f31691e;
        final AtomicThrowable f31692f = new AtomicThrowable();
        final ArrayDeque<InnerQueuedObserver<R>> f31693g = new ArrayDeque();
        SimpleQueue<T> f31694h;
        Disposable f31695i;
        volatile boolean f31696j;
        int f31697k;
        volatile boolean f31698l;
        InnerQueuedObserver<R> f31699m;
        int f31700n;

        ConcatMapEagerMainObserver(Observer<? super R> observer, Function<? super T, ? extends ObservableSource<? extends R>> function, int i, int i2, ErrorMode errorMode) {
            this.f31687a = observer;
            this.f31688b = function;
            this.f31689c = i;
            this.f31690d = i2;
            this.f31691e = errorMode;
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f31695i, disposable)) {
                this.f31695i = disposable;
                if (disposable instanceof QueueDisposable) {
                    QueueDisposable queueDisposable = (QueueDisposable) disposable;
                    int a = queueDisposable.mo7033a(3);
                    if (a == 1) {
                        this.f31697k = a;
                        this.f31694h = queueDisposable;
                        this.f31696j = true;
                        this.f31687a.onSubscribe(this);
                        mo5661c();
                        return;
                    } else if (a == 2) {
                        this.f31697k = a;
                        this.f31694h = queueDisposable;
                        this.f31687a.onSubscribe(this);
                        return;
                    }
                }
                this.f31694h = new SpscLinkedArrayQueue(this.f31690d);
                this.f31687a.onSubscribe(this);
            }
        }

        public final void onNext(T t) {
            if (this.f31697k == 0) {
                this.f31694h.offer(t);
            }
            mo5661c();
        }

        public final void onError(Throwable th) {
            if (ExceptionHelper.m26684a(this.f31692f, th)) {
                this.f31696j = true;
                mo5661c();
                return;
            }
            RxJavaPlugins.m26757a(th);
        }

        public final void onComplete() {
            this.f31696j = true;
            mo5661c();
        }

        public final void mo5626a() {
            this.f31698l = true;
            if (getAndIncrement() == 0) {
                this.f31694h.clear();
                m32398d();
            }
        }

        public final boolean mo5627b() {
            return this.f31698l;
        }

        private void m32398d() {
            InnerQueuedObserver innerQueuedObserver = this.f31699m;
            if (innerQueuedObserver != null) {
                innerQueuedObserver.mo5626a();
            }
            while (true) {
                innerQueuedObserver = (InnerQueuedObserver) this.f31693g.poll();
                if (innerQueuedObserver != null) {
                    innerQueuedObserver.mo5626a();
                } else {
                    return;
                }
            }
        }

        public final void mo5660a(InnerQueuedObserver<R> innerQueuedObserver, Throwable th) {
            if (ExceptionHelper.m26684a(this.f31692f, th)) {
                if (this.f31691e == ErrorMode.IMMEDIATE) {
                    this.f31695i.mo5626a();
                }
                innerQueuedObserver.f31161d = true;
                mo5661c();
                return;
            }
            RxJavaPlugins.m26757a(th);
        }

        public final void mo5661c() {
            if (getAndIncrement() == 0) {
                SimpleQueue simpleQueue = this.f31694h;
                ArrayDeque arrayDeque = this.f31693g;
                Observer observer = this.f31687a;
                ErrorMode errorMode = this.f31691e;
                int i = 1;
                while (true) {
                    int i2 = this.f31700n;
                    while (i2 != this.f31689c) {
                        if (this.f31698l) {
                            simpleQueue.clear();
                            m32398d();
                            return;
                        } else if (errorMode != ErrorMode.IMMEDIATE || ((Throwable) this.f31692f.get()) == null) {
                            try {
                                Object poll = simpleQueue.poll();
                                if (poll == null) {
                                    break;
                                }
                                ObservableSource observableSource = (ObservableSource) ObjectHelper.m26573a(this.f31688b.apply(poll), "The mapper returned a null ObservableSource");
                                Observer innerQueuedObserver = new InnerQueuedObserver(this, this.f31690d);
                                arrayDeque.offer(innerQueuedObserver);
                                observableSource.subscribe(innerQueuedObserver);
                                i2++;
                            } catch (Throwable th) {
                                Exceptions.m26521b(th);
                                this.f31695i.mo5626a();
                                simpleQueue.clear();
                                m32398d();
                                ExceptionHelper.m26684a(this.f31692f, th);
                                observer.onError(ExceptionHelper.m26683a(this.f31692f));
                                return;
                            }
                        } else {
                            simpleQueue.clear();
                            m32398d();
                            observer.onError(ExceptionHelper.m26683a(this.f31692f));
                            return;
                        }
                    }
                    this.f31700n = i2;
                    if (this.f31698l) {
                        simpleQueue.clear();
                        m32398d();
                        return;
                    } else if (errorMode != ErrorMode.IMMEDIATE || ((Throwable) this.f31692f.get()) == null) {
                        InnerQueuedObserver innerQueuedObserver2 = this.f31699m;
                        if (innerQueuedObserver2 == null) {
                            if (errorMode != ErrorMode.BOUNDARY || ((Throwable) this.f31692f.get()) == null) {
                                boolean z = this.f31696j;
                                InnerQueuedObserver innerQueuedObserver3 = (InnerQueuedObserver) arrayDeque.poll();
                                int i3 = innerQueuedObserver3 == null ? 1 : 0;
                                if (z && i3 != 0) {
                                    break;
                                }
                                if (i3 == 0) {
                                    this.f31699m = innerQueuedObserver3;
                                }
                                innerQueuedObserver2 = innerQueuedObserver3;
                            } else {
                                simpleQueue.clear();
                                m32398d();
                                observer.onError(ExceptionHelper.m26683a(this.f31692f));
                                return;
                            }
                        }
                        if (innerQueuedObserver2 != null) {
                            SimpleQueue simpleQueue2 = innerQueuedObserver2.f31160c;
                            while (!this.f31698l) {
                                boolean z2 = innerQueuedObserver2.f31161d;
                                if (errorMode != ErrorMode.IMMEDIATE || ((Throwable) this.f31692f.get()) == null) {
                                    try {
                                        Object poll2 = simpleQueue2.poll();
                                        int i4 = poll2 == null ? 1 : 0;
                                        if (z2 && i4 != 0) {
                                            this.f31699m = null;
                                            this.f31700n--;
                                        } else if (i4 == 0) {
                                            observer.onNext(poll2);
                                        }
                                    } catch (Throwable th2) {
                                        Exceptions.m26521b(th2);
                                        ExceptionHelper.m26684a(this.f31692f, th2);
                                        this.f31699m = null;
                                        this.f31700n--;
                                    }
                                } else {
                                    simpleQueue.clear();
                                    m32398d();
                                    observer.onError(ExceptionHelper.m26683a(this.f31692f));
                                    return;
                                }
                            }
                            simpleQueue.clear();
                            m32398d();
                            return;
                        }
                        i = addAndGet(-i);
                        if (i == 0) {
                            return;
                        }
                    } else {
                        simpleQueue.clear();
                        m32398d();
                        observer.onError(ExceptionHelper.m26683a(this.f31692f));
                        return;
                    }
                }
                if (((Throwable) this.f31692f.get()) != null) {
                    simpleQueue.clear();
                    m32398d();
                    observer.onError(ExceptionHelper.m26683a(this.f31692f));
                    return;
                }
                observer.onComplete();
            }
        }

        public final void mo5659a(InnerQueuedObserver<R> innerQueuedObserver, R r) {
            innerQueuedObserver.f31160c.offer(r);
            mo5661c();
        }

        public final void mo5658a(InnerQueuedObserver<R> innerQueuedObserver) {
            innerQueuedObserver.f31161d = true;
            mo5661c();
        }
    }

    public ObservableConcatMapEager(ObservableSource<T> observableSource, Function<? super T, ? extends ObservableSource<? extends R>> function, ErrorMode errorMode, int i, int i2) {
        super(observableSource);
        this.f37969a = function;
        this.f37970b = errorMode;
        this.f37971c = i;
        this.f37972d = i2;
    }

    protected final void subscribeActual(Observer<? super R> observer) {
        this.source.subscribe(new ConcatMapEagerMainObserver(observer, this.f37969a, this.f37971c, this.f37972d, this.f37970b));
    }
}
