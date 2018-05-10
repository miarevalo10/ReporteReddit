package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subjects.UnicastSubject;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableGroupJoin<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AbstractObservableWithUpstream<TLeft, R> {
    final ObservableSource<? extends TRight> f38016a;
    final Function<? super TLeft, ? extends ObservableSource<TLeftEnd>> f38017b;
    final Function<? super TRight, ? extends ObservableSource<TRightEnd>> f38018c;
    final BiFunction<? super TLeft, ? super Observable<TRight>, ? extends R> f38019d;

    interface JoinSupport {
        void mo5662a(LeftRightObserver leftRightObserver);

        void mo5663a(Throwable th);

        void mo5664a(boolean z, LeftRightEndObserver leftRightEndObserver);

        void mo5665a(boolean z, Object obj);

        void mo5666b(Throwable th);
    }

    static final class GroupJoinDisposable<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AtomicInteger implements Disposable, JoinSupport {
        static final Integer f31855n = Integer.valueOf(1);
        static final Integer f31856o = Integer.valueOf(2);
        static final Integer f31857p = Integer.valueOf(3);
        static final Integer f31858q = Integer.valueOf(4);
        final Observer<? super R> f31859a;
        final SpscLinkedArrayQueue<Object> f31860b = new SpscLinkedArrayQueue(Observable.bufferSize());
        final CompositeDisposable f31861c = new CompositeDisposable();
        final Map<Integer, UnicastSubject<TRight>> f31862d = new LinkedHashMap();
        final Map<Integer, TRight> f31863e = new LinkedHashMap();
        final AtomicReference<Throwable> f31864f = new AtomicReference();
        final Function<? super TLeft, ? extends ObservableSource<TLeftEnd>> f31865g;
        final Function<? super TRight, ? extends ObservableSource<TRightEnd>> f31866h;
        final BiFunction<? super TLeft, ? super Observable<TRight>, ? extends R> f31867i;
        final AtomicInteger f31868j;
        int f31869k;
        int f31870l;
        volatile boolean f31871m;

        GroupJoinDisposable(Observer<? super R> observer, Function<? super TLeft, ? extends ObservableSource<TLeftEnd>> function, Function<? super TRight, ? extends ObservableSource<TRightEnd>> function2, BiFunction<? super TLeft, ? super Observable<TRight>, ? extends R> biFunction) {
            this.f31859a = observer;
            this.f31865g = function;
            this.f31866h = function2;
            this.f31867i = biFunction;
            this.f31868j = new AtomicInteger(2);
        }

        public final void mo5626a() {
            if (!this.f31871m) {
                this.f31871m = true;
                this.f31861c.mo5626a();
                if (getAndIncrement() == 0) {
                    this.f31860b.clear();
                }
            }
        }

        public final boolean mo5627b() {
            return this.f31871m;
        }

        private void m32477a(Observer<?> observer) {
            Throwable a = ExceptionHelper.m26683a(this.f31864f);
            for (UnicastSubject onError : this.f31862d.values()) {
                onError.onError(a);
            }
            this.f31862d.clear();
            this.f31863e.clear();
            observer.onError(a);
        }

        private void m32478a(Throwable th, Observer<?> observer, SpscLinkedArrayQueue<?> spscLinkedArrayQueue) {
            Exceptions.m26521b(th);
            ExceptionHelper.m26684a(this.f31864f, th);
            spscLinkedArrayQueue.clear();
            this.f31861c.mo5626a();
            m32477a((Observer) observer);
        }

        private void m32479c() {
            if (getAndIncrement() == 0) {
                SpscLinkedArrayQueue spscLinkedArrayQueue = this.f31860b;
                Observer observer = this.f31859a;
                int i = 1;
                while (!this.f31871m) {
                    if (((Throwable) this.f31864f.get()) != null) {
                        spscLinkedArrayQueue.clear();
                        this.f31861c.mo5626a();
                        m32477a(observer);
                        return;
                    }
                    boolean z = this.f31868j.get() == 0;
                    Integer num = (Integer) spscLinkedArrayQueue.poll();
                    boolean z2 = num == null;
                    if (z && z2) {
                        for (UnicastSubject onComplete : this.f31862d.values()) {
                            onComplete.onComplete();
                        }
                        this.f31862d.clear();
                        this.f31863e.clear();
                        this.f31861c.mo5626a();
                        observer.onComplete();
                        return;
                    } else if (z2) {
                        i = addAndGet(-i);
                        if (i == 0) {
                            return;
                        }
                    } else {
                        Object poll = spscLinkedArrayQueue.poll();
                        UnicastSubject a;
                        int i2;
                        ObservableSource observableSource;
                        Disposable leftRightEndObserver;
                        if (num == f31855n) {
                            a = UnicastSubject.m38181a();
                            i2 = this.f31869k;
                            this.f31869k = i2 + 1;
                            this.f31862d.put(Integer.valueOf(i2), a);
                            try {
                                observableSource = (ObservableSource) ObjectHelper.m26573a(this.f31865g.apply(poll), "The leftEnd returned a null ObservableSource");
                                leftRightEndObserver = new LeftRightEndObserver(this, true, i2);
                                this.f31861c.mo5631a(leftRightEndObserver);
                                observableSource.subscribe(leftRightEndObserver);
                                if (((Throwable) this.f31864f.get()) != null) {
                                    spscLinkedArrayQueue.clear();
                                    this.f31861c.mo5626a();
                                    m32477a(observer);
                                    return;
                                }
                                try {
                                    observer.onNext(ObjectHelper.m26573a(this.f31867i.apply(poll, a), "The resultSelector returned a null value"));
                                    for (Object onNext : this.f31863e.values()) {
                                        a.onNext(onNext);
                                    }
                                } catch (Throwable th) {
                                    m32478a(th, observer, spscLinkedArrayQueue);
                                    return;
                                }
                            } catch (Throwable th2) {
                                m32478a(th2, observer, spscLinkedArrayQueue);
                                return;
                            }
                        } else if (num == f31856o) {
                            i2 = this.f31870l;
                            this.f31870l = i2 + 1;
                            this.f31863e.put(Integer.valueOf(i2), poll);
                            try {
                                observableSource = (ObservableSource) ObjectHelper.m26573a(this.f31866h.apply(poll), "The rightEnd returned a null ObservableSource");
                                leftRightEndObserver = new LeftRightEndObserver(this, false, i2);
                                this.f31861c.mo5631a(leftRightEndObserver);
                                observableSource.subscribe(leftRightEndObserver);
                                if (((Throwable) this.f31864f.get()) != null) {
                                    spscLinkedArrayQueue.clear();
                                    this.f31861c.mo5626a();
                                    m32477a(observer);
                                    return;
                                }
                                for (UnicastSubject onNext2 : this.f31862d.values()) {
                                    onNext2.onNext(poll);
                                }
                            } catch (Throwable th22) {
                                m32478a(th22, observer, spscLinkedArrayQueue);
                                return;
                            }
                        } else if (num == f31857p) {
                            r4 = (LeftRightEndObserver) poll;
                            a = (UnicastSubject) this.f31862d.remove(Integer.valueOf(r4.f31874c));
                            this.f31861c.mo5632b(r4);
                            if (a != null) {
                                a.onComplete();
                            }
                        } else if (num == f31858q) {
                            r4 = (LeftRightEndObserver) poll;
                            this.f31863e.remove(Integer.valueOf(r4.f31874c));
                            this.f31861c.mo5632b(r4);
                        }
                    }
                }
                spscLinkedArrayQueue.clear();
            }
        }

        public final void mo5663a(Throwable th) {
            if (ExceptionHelper.m26684a(this.f31864f, th)) {
                this.f31868j.decrementAndGet();
                m32479c();
                return;
            }
            RxJavaPlugins.m26757a(th);
        }

        public final void mo5662a(LeftRightObserver leftRightObserver) {
            this.f31861c.mo5633c(leftRightObserver);
            this.f31868j.decrementAndGet();
            m32479c();
        }

        public final void mo5665a(boolean z, Object obj) {
            synchronized (this) {
                this.f31860b.m35964a(z ? f31855n : f31856o, obj);
            }
            m32479c();
        }

        public final void mo5664a(boolean z, LeftRightEndObserver leftRightEndObserver) {
            synchronized (this) {
                this.f31860b.m35964a(z ? f31857p : f31858q, (Object) leftRightEndObserver);
            }
            m32479c();
        }

        public final void mo5666b(Throwable th) {
            if (ExceptionHelper.m26684a(this.f31864f, th)) {
                m32479c();
            } else {
                RxJavaPlugins.m26757a(th);
            }
        }
    }

    static final class LeftRightEndObserver extends AtomicReference<Disposable> implements Observer<Object>, Disposable {
        final JoinSupport f31872a;
        final boolean f31873b;
        final int f31874c;

        LeftRightEndObserver(JoinSupport joinSupport, boolean z, int i) {
            this.f31872a = joinSupport;
            this.f31873b = z;
            this.f31874c = i;
        }

        public final void mo5626a() {
            DisposableHelper.m32090a((AtomicReference) this);
        }

        public final boolean mo5627b() {
            return DisposableHelper.m32088a((Disposable) get());
        }

        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.m32092b(this, disposable);
        }

        public final void onNext(Object obj) {
            if (DisposableHelper.m32090a((AtomicReference) this) != null) {
                this.f31872a.mo5664a(this.f31873b, this);
            }
        }

        public final void onError(Throwable th) {
            this.f31872a.mo5666b(th);
        }

        public final void onComplete() {
            this.f31872a.mo5664a(this.f31873b, this);
        }
    }

    static final class LeftRightObserver extends AtomicReference<Disposable> implements Observer<Object>, Disposable {
        final JoinSupport f31875a;
        final boolean f31876b;

        LeftRightObserver(JoinSupport joinSupport, boolean z) {
            this.f31875a = joinSupport;
            this.f31876b = z;
        }

        public final void mo5626a() {
            DisposableHelper.m32090a((AtomicReference) this);
        }

        public final boolean mo5627b() {
            return DisposableHelper.m32088a((Disposable) get());
        }

        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.m32092b(this, disposable);
        }

        public final void onNext(Object obj) {
            this.f31875a.mo5665a(this.f31876b, obj);
        }

        public final void onError(Throwable th) {
            this.f31875a.mo5663a(th);
        }

        public final void onComplete() {
            this.f31875a.mo5662a(this);
        }
    }

    public ObservableGroupJoin(ObservableSource<TLeft> observableSource, ObservableSource<? extends TRight> observableSource2, Function<? super TLeft, ? extends ObservableSource<TLeftEnd>> function, Function<? super TRight, ? extends ObservableSource<TRightEnd>> function2, BiFunction<? super TLeft, ? super Observable<TRight>, ? extends R> biFunction) {
        super(observableSource);
        this.f38016a = observableSource2;
        this.f38017b = function;
        this.f38018c = function2;
        this.f38019d = biFunction;
    }

    protected final void subscribeActual(Observer<? super R> observer) {
        Object groupJoinDisposable = new GroupJoinDisposable(observer, this.f38017b, this.f38018c, this.f38019d);
        observer.onSubscribe(groupJoinDisposable);
        Disposable leftRightObserver = new LeftRightObserver(groupJoinDisposable, true);
        groupJoinDisposable.f31861c.mo5631a(leftRightObserver);
        Disposable leftRightObserver2 = new LeftRightObserver(groupJoinDisposable, false);
        groupJoinDisposable.f31861c.mo5631a(leftRightObserver2);
        this.source.subscribe(leftRightObserver);
        this.f38016a.subscribe(leftRightObserver2);
    }
}
