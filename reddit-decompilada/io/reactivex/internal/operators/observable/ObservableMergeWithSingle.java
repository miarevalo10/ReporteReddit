package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableMergeWithSingle<T> extends AbstractObservableWithUpstream<T, T> {
    final SingleSource<? extends T> f38031a;

    static final class MergeWithObserver<T> extends AtomicInteger implements Observer<T>, Disposable {
        final Observer<? super T> f31952a;
        final AtomicReference<Disposable> f31953b = new AtomicReference();
        final OtherObserver<T> f31954c = new OtherObserver(this);
        final AtomicThrowable f31955d = new AtomicThrowable();
        volatile SimplePlainQueue<T> f31956e;
        T f31957f;
        volatile boolean f31958g;
        volatile boolean f31959h;
        volatile int f31960i;

        static final class OtherObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T> {
            final MergeWithObserver<T> f31951a;

            OtherObserver(MergeWithObserver<T> mergeWithObserver) {
                this.f31951a = mergeWithObserver;
            }

            public final void onSubscribe(Disposable disposable) {
                DisposableHelper.m32092b(this, disposable);
            }

            public final void onSuccess(T t) {
                MergeWithObserver mergeWithObserver = this.f31951a;
                if (mergeWithObserver.compareAndSet(0, 1)) {
                    mergeWithObserver.f31952a.onNext(t);
                    mergeWithObserver.f31960i = 2;
                } else {
                    mergeWithObserver.f31957f = t;
                    mergeWithObserver.f31960i = 1;
                    if (mergeWithObserver.getAndIncrement() != null) {
                        return;
                    }
                }
                mergeWithObserver.m32528d();
            }

            public final void onError(Throwable th) {
                MergeWithObserver mergeWithObserver = this.f31951a;
                if (ExceptionHelper.m26684a(mergeWithObserver.f31955d, th)) {
                    DisposableHelper.m32090a(mergeWithObserver.f31953b);
                    mergeWithObserver.m32527c();
                    return;
                }
                RxJavaPlugins.m26757a(th);
            }
        }

        MergeWithObserver(Observer<? super T> observer) {
            this.f31952a = observer;
        }

        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.m32092b(this.f31953b, disposable);
        }

        public final void onNext(T t) {
            if (compareAndSet(0, 1)) {
                this.f31952a.onNext(t);
                if (decrementAndGet() == null) {
                    return;
                }
            }
            SimplePlainQueue simplePlainQueue = this.f31956e;
            if (simplePlainQueue == null) {
                simplePlainQueue = new SpscLinkedArrayQueue(Observable.bufferSize());
                this.f31956e = simplePlainQueue;
            }
            simplePlainQueue.offer(t);
            if (getAndIncrement() != null) {
                return;
            }
            m32528d();
        }

        public final void onError(Throwable th) {
            if (ExceptionHelper.m26684a(this.f31955d, th)) {
                DisposableHelper.m32090a(this.f31953b);
                m32527c();
                return;
            }
            RxJavaPlugins.m26757a(th);
        }

        public final void onComplete() {
            this.f31959h = true;
            m32527c();
        }

        public final boolean mo5627b() {
            return DisposableHelper.m32088a((Disposable) this.f31953b.get());
        }

        public final void mo5626a() {
            this.f31958g = true;
            DisposableHelper.m32090a(this.f31953b);
            DisposableHelper.m32090a(this.f31954c);
            if (getAndIncrement() == 0) {
                this.f31956e = null;
                this.f31957f = null;
            }
        }

        final void m32527c() {
            if (getAndIncrement() == 0) {
                m32528d();
            }
        }

        final void m32528d() {
            Observer observer = this.f31952a;
            int i = 1;
            while (!this.f31958g) {
                if (this.f31955d.get() != null) {
                    this.f31957f = null;
                    this.f31956e = null;
                    observer.onError(ExceptionHelper.m26683a(this.f31955d));
                    return;
                }
                int i2 = this.f31960i;
                if (i2 == 1) {
                    Object obj = this.f31957f;
                    this.f31957f = null;
                    this.f31960i = 2;
                    observer.onNext(obj);
                    i2 = 2;
                }
                boolean z = this.f31959h;
                SimplePlainQueue simplePlainQueue = this.f31956e;
                Object poll = simplePlainQueue != null ? simplePlainQueue.poll() : null;
                Object obj2 = poll == null ? 1 : null;
                if (z && obj2 != null && r3 == 2) {
                    this.f31956e = null;
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
            this.f31957f = null;
            this.f31956e = null;
        }
    }

    public ObservableMergeWithSingle(Observable<T> observable, SingleSource<? extends T> singleSource) {
        super(observable);
        this.f38031a = singleSource;
    }

    protected final void subscribeActual(Observer<? super T> observer) {
        MergeWithObserver mergeWithObserver = new MergeWithObserver(observer);
        observer.onSubscribe(mergeWithObserver);
        this.source.subscribe(mergeWithObserver);
        this.f38031a.subscribe(mergeWithObserver.f31954c);
    }
}
