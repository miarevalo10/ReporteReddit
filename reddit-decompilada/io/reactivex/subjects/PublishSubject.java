package io.reactivex.subjects;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class PublishSubject<T> extends Subject<T> {
    static final PublishDisposable[] EMPTY = new PublishDisposable[0];
    static final PublishDisposable[] TERMINATED = new PublishDisposable[0];
    Throwable error;
    final AtomicReference<PublishDisposable<T>[]> subscribers = new AtomicReference(EMPTY);

    static final class PublishDisposable<T> extends AtomicBoolean implements Disposable {
        final Observer<? super T> f32485a;
        final PublishSubject<T> f32486b;

        PublishDisposable(Observer<? super T> observer, PublishSubject<T> publishSubject) {
            this.f32485a = observer;
            this.f32486b = publishSubject;
        }

        public final void mo5626a() {
            if (compareAndSet(false, true)) {
                this.f32486b.remove(this);
            }
        }

        public final boolean mo5627b() {
            return get();
        }
    }

    public static <T> PublishSubject<T> create() {
        return new PublishSubject();
    }

    PublishSubject() {
    }

    public final void subscribeActual(Observer<? super T> observer) {
        PublishDisposable publishDisposable = new PublishDisposable(observer, this);
        observer.onSubscribe(publishDisposable);
        if (!add(publishDisposable)) {
            Throwable th = this.error;
            if (th != null) {
                observer.onError(th);
                return;
            }
            observer.onComplete();
        } else if (publishDisposable.mo5627b() != null) {
            remove(publishDisposable);
        }
    }

    final boolean add(PublishDisposable<T> publishDisposable) {
        PublishDisposable[] publishDisposableArr;
        Object obj;
        do {
            publishDisposableArr = (PublishDisposable[]) this.subscribers.get();
            if (publishDisposableArr == TERMINATED) {
                return false;
            }
            int length = publishDisposableArr.length;
            obj = new PublishDisposable[(length + 1)];
            System.arraycopy(publishDisposableArr, 0, obj, 0, length);
            obj[length] = publishDisposable;
        } while (!this.subscribers.compareAndSet(publishDisposableArr, obj));
        return true;
    }

    final void remove(PublishDisposable<T> publishDisposable) {
        PublishDisposable[] publishDisposableArr;
        Object obj;
        do {
            publishDisposableArr = (PublishDisposable[]) this.subscribers.get();
            if (publishDisposableArr != TERMINATED) {
                if (publishDisposableArr != EMPTY) {
                    int length = publishDisposableArr.length;
                    int i = -1;
                    for (int i2 = 0; i2 < length; i2++) {
                        if (publishDisposableArr[i2] == publishDisposable) {
                            i = i2;
                            break;
                        }
                    }
                    if (i >= 0) {
                        if (length == 1) {
                            obj = EMPTY;
                        } else {
                            Object obj2 = new PublishDisposable[(length - 1)];
                            System.arraycopy(publishDisposableArr, 0, obj2, 0, i);
                            System.arraycopy(publishDisposableArr, i + 1, obj2, i, (length - i) - 1);
                            obj = obj2;
                        }
                    } else {
                        return;
                    }
                }
            }
            return;
        } while (!this.subscribers.compareAndSet(publishDisposableArr, obj));
    }

    public final void onSubscribe(Disposable disposable) {
        if (this.subscribers.get() == TERMINATED) {
            disposable.mo5626a();
        }
    }

    public final void onNext(T t) {
        ObjectHelper.m26573a((Object) t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.subscribers.get() != TERMINATED) {
            for (PublishDisposable publishDisposable : (PublishDisposable[]) this.subscribers.get()) {
                if (!publishDisposable.get()) {
                    publishDisposable.f32485a.onNext(t);
                }
            }
        }
    }

    public final void onError(Throwable th) {
        ObjectHelper.m26573a((Object) th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.subscribers.get() == TERMINATED) {
            RxJavaPlugins.m26757a(th);
            return;
        }
        this.error = th;
        for (PublishDisposable publishDisposable : (PublishDisposable[]) this.subscribers.getAndSet(TERMINATED)) {
            if (publishDisposable.get()) {
                RxJavaPlugins.m26757a(th);
            } else {
                publishDisposable.f32485a.onError(th);
            }
        }
    }

    public final void onComplete() {
        if (this.subscribers.get() != TERMINATED) {
            for (PublishDisposable publishDisposable : (PublishDisposable[]) this.subscribers.getAndSet(TERMINATED)) {
                if (!publishDisposable.get()) {
                    publishDisposable.f32485a.onComplete();
                }
            }
        }
    }

    public final boolean hasObservers() {
        return ((PublishDisposable[]) this.subscribers.get()).length != 0;
    }

    public final Throwable getThrowable() {
        return this.subscribers.get() == TERMINATED ? this.error : null;
    }

    public final boolean hasThrowable() {
        return this.subscribers.get() == TERMINATED && this.error != null;
    }

    public final boolean hasComplete() {
        return this.subscribers.get() == TERMINATED && this.error == null;
    }
}
