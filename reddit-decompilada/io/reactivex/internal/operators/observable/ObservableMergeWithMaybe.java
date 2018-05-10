package io.reactivex.internal.operators.observable;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableMergeWithMaybe<T> extends AbstractObservableWithUpstream<T, T> {
    final MaybeSource<? extends T> f38030a;

    static final class MergeWithObserver<T> extends AtomicInteger implements Observer<T>, Disposable {
        final Observer<? super T> f31942a;
        final AtomicReference<Disposable> f31943b = new AtomicReference();
        final OtherObserver<T> f31944c = new OtherObserver(this);
        final AtomicThrowable f31945d = new AtomicThrowable();
        volatile SimplePlainQueue<T> f31946e;
        T f31947f;
        volatile boolean f31948g;
        volatile boolean f31949h;
        volatile int f31950i;

        static final class OtherObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T> {
            final MergeWithObserver<T> f31941a;

            OtherObserver(MergeWithObserver<T> mergeWithObserver) {
                this.f31941a = mergeWithObserver;
            }

            public final void onSubscribe(Disposable disposable) {
                DisposableHelper.m32092b(this, disposable);
            }

            public final void onSuccess(T t) {
                MergeWithObserver mergeWithObserver = this.f31941a;
                if (mergeWithObserver.compareAndSet(0, 1)) {
                    mergeWithObserver.f31942a.onNext(t);
                    mergeWithObserver.f31950i = 2;
                } else {
                    mergeWithObserver.f31947f = t;
                    mergeWithObserver.f31950i = 1;
                    if (mergeWithObserver.getAndIncrement() != null) {
                        return;
                    }
                }
                mergeWithObserver.m32524d();
            }

            public final void onError(Throwable th) {
                MergeWithObserver mergeWithObserver = this.f31941a;
                if (ExceptionHelper.m26684a(mergeWithObserver.f31945d, th)) {
                    DisposableHelper.m32090a(mergeWithObserver.f31943b);
                    mergeWithObserver.m32523c();
                    return;
                }
                RxJavaPlugins.m26757a(th);
            }

            public final void onComplete() {
                MergeWithObserver mergeWithObserver = this.f31941a;
                mergeWithObserver.f31950i = 2;
                mergeWithObserver.m32523c();
            }
        }

        MergeWithObserver(Observer<? super T> observer) {
            this.f31942a = observer;
        }

        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.m32092b(this.f31943b, disposable);
        }

        public final void onNext(T t) {
            if (compareAndSet(0, 1)) {
                this.f31942a.onNext(t);
                if (decrementAndGet() == null) {
                    return;
                }
            }
            SimplePlainQueue simplePlainQueue = this.f31946e;
            if (simplePlainQueue == null) {
                simplePlainQueue = new SpscLinkedArrayQueue(Observable.bufferSize());
                this.f31946e = simplePlainQueue;
            }
            simplePlainQueue.offer(t);
            if (getAndIncrement() != null) {
                return;
            }
            m32524d();
        }

        public final void onError(Throwable th) {
            if (ExceptionHelper.m26684a(this.f31945d, th)) {
                DisposableHelper.m32090a(this.f31943b);
                m32523c();
                return;
            }
            RxJavaPlugins.m26757a(th);
        }

        public final void onComplete() {
            this.f31949h = true;
            m32523c();
        }

        public final boolean mo5627b() {
            return DisposableHelper.m32088a((Disposable) this.f31943b.get());
        }

        public final void mo5626a() {
            this.f31948g = true;
            DisposableHelper.m32090a(this.f31943b);
            DisposableHelper.m32090a(this.f31944c);
            if (getAndIncrement() == 0) {
                this.f31946e = null;
                this.f31947f = null;
            }
        }

        final void m32523c() {
            if (getAndIncrement() == 0) {
                m32524d();
            }
        }

        final void m32524d() {
            Observer observer = this.f31942a;
            int i = 1;
            while (!this.f31948g) {
                if (this.f31945d.get() != null) {
                    this.f31947f = null;
                    this.f31946e = null;
                    observer.onError(ExceptionHelper.m26683a(this.f31945d));
                    return;
                }
                int i2 = this.f31950i;
                if (i2 == 1) {
                    Object obj = this.f31947f;
                    this.f31947f = null;
                    this.f31950i = 2;
                    observer.onNext(obj);
                    i2 = 2;
                }
                boolean z = this.f31949h;
                SimplePlainQueue simplePlainQueue = this.f31946e;
                Object poll = simplePlainQueue != null ? simplePlainQueue.poll() : null;
                Object obj2 = poll == null ? 1 : null;
                if (z && obj2 != null && r3 == 2) {
                    this.f31946e = null;
                    observer.onComplete();
                    return;
                } else if (obj2 == null) {
                    observer.onNext(poll);
                } else {
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                }
            }
            this.f31947f = null;
            this.f31946e = null;
        }
    }

    public ObservableMergeWithMaybe(Observable<T> observable, MaybeSource<? extends T> maybeSource) {
        super(observable);
        this.f38030a = maybeSource;
    }

    protected final void subscribeActual(Observer<? super T> observer) {
        MergeWithObserver mergeWithObserver = new MergeWithObserver(observer);
        observer.onSubscribe(mergeWithObserver);
        this.source.subscribe(mergeWithObserver);
        this.f38030a.subscribe(mergeWithObserver.f31944c);
    }
}
