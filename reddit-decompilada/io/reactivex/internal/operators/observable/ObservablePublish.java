package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservablePublish<T> extends ConnectableObservable<T> {
    final ObservableSource<T> f38038a;
    final AtomicReference<PublishObserver<T>> f38039b;
    final ObservableSource<T> f38040c;

    static final class InnerDisposable<T> extends AtomicReference<Object> implements Disposable {
        final Observer<? super T> f31970a;

        InnerDisposable(Observer<? super T> observer) {
            this.f31970a = observer;
        }

        public final boolean mo5627b() {
            return get() == this;
        }

        public final void mo5626a() {
            InnerDisposable andSet = getAndSet(this);
            if (andSet != null && andSet != this) {
                ((PublishObserver) andSet).m32534a(this);
            }
        }
    }

    static final class PublishObserver<T> implements Observer<T>, Disposable {
        static final InnerDisposable[] f31971b = new InnerDisposable[0];
        static final InnerDisposable[] f31972c = new InnerDisposable[0];
        final AtomicReference<PublishObserver<T>> f31973a;
        final AtomicReference<InnerDisposable<T>[]> f31974d = new AtomicReference(f31971b);
        final AtomicBoolean f31975e;
        final AtomicReference<Disposable> f31976f = new AtomicReference();

        PublishObserver(AtomicReference<PublishObserver<T>> atomicReference) {
            this.f31973a = atomicReference;
            this.f31975e = new AtomicBoolean();
        }

        public final void mo5626a() {
            if (this.f31974d.get() != f31972c && ((InnerDisposable[]) this.f31974d.getAndSet(f31972c)) != f31972c) {
                this.f31973a.compareAndSet(this, null);
                DisposableHelper.m32090a(this.f31976f);
            }
        }

        public final boolean mo5627b() {
            return this.f31974d.get() == f31972c;
        }

        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.m32092b(this.f31976f, disposable);
        }

        public final void onNext(T t) {
            for (InnerDisposable innerDisposable : (InnerDisposable[]) this.f31974d.get()) {
                innerDisposable.f31970a.onNext(t);
            }
        }

        public final void onError(Throwable th) {
            this.f31973a.compareAndSet(this, null);
            InnerDisposable[] innerDisposableArr = (InnerDisposable[]) this.f31974d.getAndSet(f31972c);
            if (innerDisposableArr.length != 0) {
                for (InnerDisposable innerDisposable : innerDisposableArr) {
                    innerDisposable.f31970a.onError(th);
                }
                return;
            }
            RxJavaPlugins.m26757a(th);
        }

        public final void onComplete() {
            this.f31973a.compareAndSet(this, null);
            for (InnerDisposable innerDisposable : (InnerDisposable[]) this.f31974d.getAndSet(f31972c)) {
                innerDisposable.f31970a.onComplete();
            }
        }

        final void m32534a(InnerDisposable<T> innerDisposable) {
            InnerDisposable[] innerDisposableArr;
            Object obj;
            do {
                innerDisposableArr = (InnerDisposable[]) this.f31974d.get();
                int length = innerDisposableArr.length;
                if (length != 0) {
                    int i = -1;
                    for (int i2 = 0; i2 < length; i2++) {
                        if (innerDisposableArr[i2].equals(innerDisposable)) {
                            i = i2;
                            break;
                        }
                    }
                    if (i >= 0) {
                        if (length == 1) {
                            obj = f31971b;
                        } else {
                            Object obj2 = new InnerDisposable[(length - 1)];
                            System.arraycopy(innerDisposableArr, 0, obj2, 0, i);
                            System.arraycopy(innerDisposableArr, i + 1, obj2, i, (length - i) - 1);
                            obj = obj2;
                        }
                    } else {
                        return;
                    }
                }
                return;
            } while (!this.f31974d.compareAndSet(innerDisposableArr, obj));
        }
    }

    static final class PublishSource<T> implements ObservableSource<T> {
        private final AtomicReference<PublishObserver<T>> f31977a;

        PublishSource(AtomicReference<PublishObserver<T>> atomicReference) {
            this.f31977a = atomicReference;
        }

        public final void subscribe(Observer<? super T> observer) {
            InnerDisposable innerDisposable = new InnerDisposable(observer);
            observer.onSubscribe(innerDisposable);
            while (true) {
                int i;
                observer = (PublishObserver) this.f31977a.get();
                if (observer == null || observer.mo5627b()) {
                    PublishObserver publishObserver = new PublishObserver(this.f31977a);
                    if (this.f31977a.compareAndSet(observer, publishObserver) != null) {
                        observer = publishObserver;
                    } else {
                        continue;
                    }
                }
                InnerDisposable[] innerDisposableArr;
                Object obj;
                do {
                    innerDisposableArr = (InnerDisposable[]) observer.f31974d.get();
                    i = 0;
                    if (innerDisposableArr == PublishObserver.f31972c) {
                        break;
                    }
                    int length = innerDisposableArr.length;
                    obj = new InnerDisposable[(length + 1)];
                    System.arraycopy(innerDisposableArr, 0, obj, 0, length);
                    obj[length] = innerDisposable;
                } while (!observer.f31974d.compareAndSet(innerDisposableArr, obj));
                i = 1;
                if (i != 0) {
                    break;
                }
            }
            if (!innerDisposable.compareAndSet(null, observer)) {
                observer.m32534a(innerDisposable);
            }
        }
    }

    public static <T> ConnectableObservable<T> m38137a(ObservableSource<T> observableSource) {
        AtomicReference atomicReference = new AtomicReference();
        return RxJavaPlugins.m26750a(new ObservablePublish(new PublishSource(atomicReference), observableSource, atomicReference));
    }

    private ObservablePublish(ObservableSource<T> observableSource, ObservableSource<T> observableSource2, AtomicReference<PublishObserver<T>> atomicReference) {
        this.f38040c = observableSource;
        this.f38038a = observableSource2;
        this.f38039b = atomicReference;
    }

    protected final void subscribeActual(Observer<? super T> observer) {
        this.f38040c.subscribe(observer);
    }

    public final void mo7053a(Consumer<? super Disposable> consumer) {
        Observer observer;
        PublishObserver publishObserver;
        do {
            observer = (PublishObserver) this.f38039b.get();
            if (observer != null && !observer.mo5627b()) {
                break;
            }
            publishObserver = new PublishObserver(this.f38039b);
        } while (!this.f38039b.compareAndSet(observer, publishObserver));
        observer = publishObserver;
        boolean z = true;
        if (observer.f31975e.get() || !observer.f31975e.compareAndSet(false, true)) {
            z = false;
        }
        try {
            consumer.accept(observer);
            if (z) {
                this.f38038a.subscribe(observer);
            }
        } catch (Throwable th) {
            Exceptions.m26521b(th);
            consumer = ExceptionHelper.m26682a(th);
        }
    }
}
