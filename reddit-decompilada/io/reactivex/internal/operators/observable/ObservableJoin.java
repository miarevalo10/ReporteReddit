package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableJoin<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AbstractObservableWithUpstream<TLeft, R> {
    final ObservableSource<? extends TRight> f38020a;
    final Function<? super TLeft, ? extends ObservableSource<TLeftEnd>> f38021b;
    final Function<? super TRight, ? extends ObservableSource<TRightEnd>> f38022c;
    final BiFunction<? super TLeft, ? super TRight, ? extends R> f38023d;

    static final class JoinDisposable<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AtomicInteger implements Disposable, JoinSupport {
        static final Integer f31903n = Integer.valueOf(1);
        static final Integer f31904o = Integer.valueOf(2);
        static final Integer f31905p = Integer.valueOf(3);
        static final Integer f31906q = Integer.valueOf(4);
        final Observer<? super R> f31907a;
        final SpscLinkedArrayQueue<Object> f31908b = new SpscLinkedArrayQueue(Observable.bufferSize());
        final CompositeDisposable f31909c = new CompositeDisposable();
        final Map<Integer, TLeft> f31910d = new LinkedHashMap();
        final Map<Integer, TRight> f31911e = new LinkedHashMap();
        final AtomicReference<Throwable> f31912f = new AtomicReference();
        final Function<? super TLeft, ? extends ObservableSource<TLeftEnd>> f31913g;
        final Function<? super TRight, ? extends ObservableSource<TRightEnd>> f31914h;
        final BiFunction<? super TLeft, ? super TRight, ? extends R> f31915i;
        final AtomicInteger f31916j;
        int f31917k;
        int f31918l;
        volatile boolean f31919m;

        JoinDisposable(Observer<? super R> observer, Function<? super TLeft, ? extends ObservableSource<TLeftEnd>> function, Function<? super TRight, ? extends ObservableSource<TRightEnd>> function2, BiFunction<? super TLeft, ? super TRight, ? extends R> biFunction) {
            this.f31907a = observer;
            this.f31913g = function;
            this.f31914h = function2;
            this.f31915i = biFunction;
            this.f31916j = new AtomicInteger(2);
        }

        public final void mo5626a() {
            if (!this.f31919m) {
                this.f31919m = true;
                this.f31909c.mo5626a();
                if (getAndIncrement() == 0) {
                    this.f31908b.clear();
                }
            }
        }

        public final boolean mo5627b() {
            return this.f31919m;
        }

        private void m32501a(Observer<?> observer) {
            Throwable a = ExceptionHelper.m26683a(this.f31912f);
            this.f31910d.clear();
            this.f31911e.clear();
            observer.onError(a);
        }

        private void m32502a(Throwable th, Observer<?> observer, SpscLinkedArrayQueue<?> spscLinkedArrayQueue) {
            Exceptions.m26521b(th);
            ExceptionHelper.m26684a(this.f31912f, th);
            spscLinkedArrayQueue.clear();
            this.f31909c.mo5626a();
            m32501a((Observer) observer);
        }

        private void m32503c() {
            if (getAndIncrement() == 0) {
                SpscLinkedArrayQueue spscLinkedArrayQueue = this.f31908b;
                Observer observer = this.f31907a;
                int i = 1;
                while (!this.f31919m) {
                    if (((Throwable) this.f31912f.get()) != null) {
                        spscLinkedArrayQueue.clear();
                        this.f31909c.mo5626a();
                        m32501a(observer);
                        return;
                    }
                    boolean z = this.f31916j.get() == 0;
                    Integer num = (Integer) spscLinkedArrayQueue.poll();
                    boolean z2 = num == null;
                    if (z && z2) {
                        this.f31910d.clear();
                        this.f31911e.clear();
                        this.f31909c.mo5626a();
                        observer.onComplete();
                        return;
                    } else if (z2) {
                        i = addAndGet(-i);
                        if (i == 0) {
                            return;
                        }
                    } else {
                        Object poll = spscLinkedArrayQueue.poll();
                        if (num == f31903n) {
                            int i2 = this.f31917k;
                            this.f31917k = i2 + 1;
                            this.f31910d.put(Integer.valueOf(i2), poll);
                            try {
                                ObservableSource observableSource = (ObservableSource) ObjectHelper.m26573a(this.f31913g.apply(poll), "The leftEnd returned a null ObservableSource");
                                Disposable leftRightEndObserver = new LeftRightEndObserver(this, true, i2);
                                this.f31909c.mo5631a(leftRightEndObserver);
                                observableSource.subscribe(leftRightEndObserver);
                                if (((Throwable) this.f31912f.get()) != null) {
                                    spscLinkedArrayQueue.clear();
                                    this.f31909c.mo5626a();
                                    m32501a(observer);
                                    return;
                                }
                                for (Object apply : this.f31911e.values()) {
                                    try {
                                        observer.onNext(ObjectHelper.m26573a(this.f31915i.apply(poll, apply), "The resultSelector returned a null value"));
                                    } catch (Throwable th) {
                                        m32502a(th, observer, spscLinkedArrayQueue);
                                        return;
                                    }
                                }
                                continue;
                            } catch (Throwable th2) {
                                m32502a(th2, observer, spscLinkedArrayQueue);
                                return;
                            }
                        } else if (num == f31904o) {
                            int i3 = this.f31918l;
                            this.f31918l = i3 + 1;
                            this.f31911e.put(Integer.valueOf(i3), poll);
                            try {
                                ObservableSource observableSource2 = (ObservableSource) ObjectHelper.m26573a(this.f31914h.apply(poll), "The rightEnd returned a null ObservableSource");
                                Disposable leftRightEndObserver2 = new LeftRightEndObserver(this, false, i3);
                                this.f31909c.mo5631a(leftRightEndObserver2);
                                observableSource2.subscribe(leftRightEndObserver2);
                                if (((Throwable) this.f31912f.get()) != null) {
                                    spscLinkedArrayQueue.clear();
                                    this.f31909c.mo5626a();
                                    m32501a(observer);
                                    return;
                                }
                                for (Object apply2 : this.f31910d.values()) {
                                    try {
                                        observer.onNext(ObjectHelper.m26573a(this.f31915i.apply(apply2, poll), "The resultSelector returned a null value"));
                                    } catch (Throwable th22) {
                                        m32502a(th22, observer, spscLinkedArrayQueue);
                                        return;
                                    }
                                }
                                continue;
                            } catch (Throwable th222) {
                                m32502a(th222, observer, spscLinkedArrayQueue);
                                return;
                            }
                        } else if (num == f31905p) {
                            r4 = (LeftRightEndObserver) poll;
                            this.f31910d.remove(Integer.valueOf(r4.f31874c));
                            this.f31909c.mo5632b(r4);
                        } else {
                            r4 = (LeftRightEndObserver) poll;
                            this.f31911e.remove(Integer.valueOf(r4.f31874c));
                            this.f31909c.mo5632b(r4);
                        }
                    }
                }
                spscLinkedArrayQueue.clear();
            }
        }

        public final void mo5663a(Throwable th) {
            if (ExceptionHelper.m26684a(this.f31912f, th)) {
                this.f31916j.decrementAndGet();
                m32503c();
                return;
            }
            RxJavaPlugins.m26757a(th);
        }

        public final void mo5662a(LeftRightObserver leftRightObserver) {
            this.f31909c.mo5633c(leftRightObserver);
            this.f31916j.decrementAndGet();
            m32503c();
        }

        public final void mo5665a(boolean z, Object obj) {
            synchronized (this) {
                this.f31908b.m35964a(z ? f31903n : f31904o, obj);
            }
            m32503c();
        }

        public final void mo5664a(boolean z, LeftRightEndObserver leftRightEndObserver) {
            synchronized (this) {
                this.f31908b.m35964a(z ? f31905p : f31906q, (Object) leftRightEndObserver);
            }
            m32503c();
        }

        public final void mo5666b(Throwable th) {
            if (ExceptionHelper.m26684a(this.f31912f, th)) {
                m32503c();
            } else {
                RxJavaPlugins.m26757a(th);
            }
        }
    }

    public ObservableJoin(ObservableSource<TLeft> observableSource, ObservableSource<? extends TRight> observableSource2, Function<? super TLeft, ? extends ObservableSource<TLeftEnd>> function, Function<? super TRight, ? extends ObservableSource<TRightEnd>> function2, BiFunction<? super TLeft, ? super TRight, ? extends R> biFunction) {
        super(observableSource);
        this.f38020a = observableSource2;
        this.f38021b = function;
        this.f38022c = function2;
        this.f38023d = biFunction;
    }

    protected final void subscribeActual(Observer<? super R> observer) {
        Object joinDisposable = new JoinDisposable(observer, this.f38021b, this.f38022c, this.f38023d);
        observer.onSubscribe(joinDisposable);
        Disposable leftRightObserver = new LeftRightObserver(joinDisposable, true);
        joinDisposable.f31909c.mo5631a(leftRightObserver);
        Disposable leftRightObserver2 = new LeftRightObserver(joinDisposable, false);
        joinDisposable.f31909c.mo5631a(leftRightObserver2);
        this.source.subscribe(leftRightObserver);
        this.f38020a.subscribe(leftRightObserver2);
    }
}
