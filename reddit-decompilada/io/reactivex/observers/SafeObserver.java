package io.reactivex.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;

public final class SafeObserver<T> implements Observer<T>, Disposable {
    final Observer<? super T> f32471a;
    Disposable f32472b;
    boolean f32473c;

    public SafeObserver(Observer<? super T> observer) {
        this.f32471a = observer;
    }

    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.m32089a(this.f32472b, disposable)) {
            this.f32472b = disposable;
            try {
                this.f32471a.onSubscribe(this);
            } catch (Disposable disposable2) {
                Exceptions.m26521b(disposable2);
                RxJavaPlugins.m26757a(new CompositeException(th, disposable2));
            }
        }
    }

    public final void mo5626a() {
        this.f32472b.mo5626a();
    }

    public final boolean mo5627b() {
        return this.f32472b.mo5627b();
    }

    public final void onNext(T t) {
        if (!this.f32473c) {
            if (this.f32472b == null) {
                this.f32473c = true;
                t = new NullPointerException("Subscription not set!");
                try {
                    this.f32471a.onSubscribe(EmptyDisposable.INSTANCE);
                    try {
                        this.f32471a.onError(t);
                    } catch (Throwable th) {
                        Exceptions.m26521b(th);
                        RxJavaPlugins.m26757a(new CompositeException(t, th));
                    }
                } catch (Throwable th2) {
                    Exceptions.m26521b(th2);
                    RxJavaPlugins.m26757a(new CompositeException(t, th2));
                }
            } else if (t == null) {
                t = new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
                try {
                    this.f32472b.mo5626a();
                    onError(t);
                } catch (Throwable th22) {
                    Exceptions.m26521b(th22);
                    onError(new CompositeException(t, th22));
                }
            } else {
                try {
                    this.f32471a.onNext(t);
                } catch (Throwable th222) {
                    Exceptions.m26521b(th222);
                    onError(new CompositeException(t, th222));
                }
            }
        }
    }

    public final void onError(Throwable th) {
        if (this.f32473c) {
            RxJavaPlugins.m26757a(th);
            return;
        }
        this.f32473c = true;
        if (this.f32472b == null) {
            NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
            try {
                this.f32471a.onSubscribe(EmptyDisposable.INSTANCE);
                try {
                    this.f32471a.onError(new CompositeException(th, nullPointerException));
                    return;
                } catch (Throwable th2) {
                    Exceptions.m26521b(th2);
                    RxJavaPlugins.m26757a(new CompositeException(th, nullPointerException, th2));
                    return;
                }
            } catch (Throwable th22) {
                Exceptions.m26521b(th22);
                RxJavaPlugins.m26757a(new CompositeException(th, nullPointerException, th22));
                return;
            }
        }
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        }
        try {
            this.f32471a.onError(th);
        } catch (Throwable th3) {
            Exceptions.m26521b(th3);
            RxJavaPlugins.m26757a(new CompositeException(th, th3));
        }
    }

    public final void onComplete() {
        if (!this.f32473c) {
            this.f32473c = true;
            if (this.f32472b == null) {
                Throwable nullPointerException = new NullPointerException("Subscription not set!");
                try {
                    this.f32471a.onSubscribe(EmptyDisposable.INSTANCE);
                    try {
                        this.f32471a.onError(nullPointerException);
                        return;
                    } catch (Throwable th) {
                        Exceptions.m26521b(th);
                        RxJavaPlugins.m26757a(new CompositeException(nullPointerException, th));
                        return;
                    }
                } catch (Throwable th2) {
                    Exceptions.m26521b(th2);
                    RxJavaPlugins.m26757a(new CompositeException(nullPointerException, th2));
                    return;
                }
            }
            try {
                this.f32471a.onComplete();
            } catch (Throwable th3) {
                Exceptions.m26521b(th3);
                RxJavaPlugins.m26757a(th3);
            }
        }
    }
}
