package io.reactivex.subjects;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleSubject<T> extends Single<T> implements SingleObserver<T> {
    static final SingleDisposable[] f35951b = new SingleDisposable[0];
    static final SingleDisposable[] f35952c = new SingleDisposable[0];
    final AtomicReference<SingleDisposable<T>[]> f35953a = new AtomicReference(f35951b);
    final AtomicBoolean f35954d = new AtomicBoolean();
    T f35955e;
    Throwable f35956f;

    static final class SingleDisposable<T> extends AtomicReference<SingleSubject<T>> implements Disposable {
        final SingleObserver<? super T> f32487a;

        SingleDisposable(SingleObserver<? super T> singleObserver, SingleSubject<T> singleSubject) {
            this.f32487a = singleObserver;
            lazySet(singleSubject);
        }

        public final void mo5626a() {
            SingleSubject singleSubject = (SingleSubject) getAndSet(null);
            if (singleSubject != null) {
                singleSubject.m36027a(this);
            }
        }

        public final boolean mo5627b() {
            return get() == null;
        }
    }

    public static <T> SingleSubject<T> m36026a() {
        return new SingleSubject();
    }

    SingleSubject() {
    }

    public final void onSubscribe(Disposable disposable) {
        if (this.f35953a.get() == f35952c) {
            disposable.mo5626a();
        }
    }

    public final void onSuccess(T t) {
        ObjectHelper.m26573a((Object) t, "onSuccess called with null. Null values are generally not allowed in 2.x operators and sources.");
        int i = 0;
        if (this.f35954d.compareAndSet(false, true)) {
            this.f35955e = t;
            SingleDisposable[] singleDisposableArr = (SingleDisposable[]) this.f35953a.getAndSet(f35952c);
            int length = singleDisposableArr.length;
            while (i < length) {
                singleDisposableArr[i].f32487a.onSuccess(t);
                i++;
            }
        }
    }

    public final void onError(Throwable th) {
        ObjectHelper.m26573a((Object) th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        int i = 0;
        if (this.f35954d.compareAndSet(false, true)) {
            this.f35956f = th;
            SingleDisposable[] singleDisposableArr = (SingleDisposable[]) this.f35953a.getAndSet(f35952c);
            int length = singleDisposableArr.length;
            while (i < length) {
                singleDisposableArr[i].f32487a.onError(th);
                i++;
            }
            return;
        }
        RxJavaPlugins.m26757a(th);
    }

    protected final void subscribeActual(SingleObserver<? super T> singleObserver) {
        int i;
        SingleDisposable singleDisposable = new SingleDisposable(singleObserver, this);
        singleObserver.onSubscribe(singleDisposable);
        SingleDisposable[] singleDisposableArr;
        Object obj;
        do {
            singleDisposableArr = (SingleDisposable[]) this.f35953a.get();
            i = 0;
            if (singleDisposableArr == f35952c) {
                break;
            }
            int length = singleDisposableArr.length;
            obj = new SingleDisposable[(length + 1)];
            System.arraycopy(singleDisposableArr, 0, obj, 0, length);
            obj[length] = singleDisposable;
        } while (!this.f35953a.compareAndSet(singleDisposableArr, obj));
        i = 1;
        if (i == 0) {
            Throwable th = this.f35956f;
            if (th != null) {
                singleObserver.onError(th);
                return;
            }
            singleObserver.onSuccess(this.f35955e);
        } else if (singleDisposable.mo5627b() != null) {
            m36027a(singleDisposable);
        }
    }

    final void m36027a(SingleDisposable<T> singleDisposable) {
        SingleDisposable[] singleDisposableArr;
        Object obj;
        do {
            singleDisposableArr = (SingleDisposable[]) this.f35953a.get();
            int length = singleDisposableArr.length;
            if (length != 0) {
                int i = -1;
                for (int i2 = 0; i2 < length; i2++) {
                    if (singleDisposableArr[i2] == singleDisposable) {
                        i = i2;
                        break;
                    }
                }
                if (i >= 0) {
                    if (length == 1) {
                        obj = f35951b;
                    } else {
                        Object obj2 = new SingleDisposable[(length - 1)];
                        System.arraycopy(singleDisposableArr, 0, obj2, 0, i);
                        System.arraycopy(singleDisposableArr, i + 1, obj2, i, (length - i) - 1);
                        obj = obj2;
                    }
                } else {
                    return;
                }
            }
            return;
        } while (!this.f35953a.compareAndSet(singleDisposableArr, obj));
    }
}
