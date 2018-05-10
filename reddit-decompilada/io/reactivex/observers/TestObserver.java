package io.reactivex.observers;

import io.reactivex.CompletableObserver;
import io.reactivex.MaybeObserver;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class TestObserver<T> extends BaseTestConsumer<T, TestObserver<T>> implements CompletableObserver, MaybeObserver<T>, Observer<T>, SingleObserver<T>, Disposable {
    private final Observer<? super T> f35940i;
    private final AtomicReference<Disposable> f35941j;
    private QueueDisposable<T> f35942k;

    enum EmptyObserver implements Observer<Object> {
        ;

        public final void onComplete() {
        }

        public final void onError(Throwable th) {
        }

        public final void onNext(Object obj) {
        }

        public final void onSubscribe(Disposable disposable) {
        }

        private EmptyObserver(String str) {
        }
    }

    public TestObserver() {
        this(EmptyObserver.f32480a);
    }

    private TestObserver(Observer<? super T> observer) {
        this.f35941j = new AtomicReference();
        this.f35940i = observer;
    }

    public void onSubscribe(Disposable disposable) {
        this.e = Thread.currentThread();
        if (disposable == null) {
            this.c.add(new NullPointerException("onSubscribe received a null Subscription"));
        } else if (this.f35941j.compareAndSet(null, disposable)) {
            if (this.g != 0 && (disposable instanceof QueueDisposable)) {
                this.f35942k = (QueueDisposable) disposable;
                int a = this.f35942k.mo7033a(this.g);
                this.h = a;
                if (a == 1) {
                    this.f = true;
                    this.e = Thread.currentThread();
                    while (true) {
                        try {
                            disposable = this.f35942k.poll();
                            if (disposable != null) {
                                this.b.add(disposable);
                            } else {
                                this.d++;
                                this.f35941j.lazySet(DisposableHelper.f31095a);
                                return;
                            }
                        } catch (Disposable disposable2) {
                            this.c.add(disposable2);
                            return;
                        }
                    }
                }
            }
            this.f35940i.onSubscribe(disposable2);
        } else {
            disposable2.mo5626a();
            if (this.f35941j.get() != DisposableHelper.f31095a) {
                List list = this.c;
                StringBuilder stringBuilder = new StringBuilder("onSubscribe received multiple subscriptions: ");
                stringBuilder.append(disposable2);
                list.add(new IllegalStateException(stringBuilder.toString()));
            }
        }
    }

    public void onNext(T t) {
        if (!this.f) {
            this.f = true;
            if (this.f35941j.get() == null) {
                this.c.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        this.e = Thread.currentThread();
        if (this.h == 2) {
            while (true) {
                try {
                    t = this.f35942k.poll();
                    if (t != null) {
                        this.b.add(t);
                    } else {
                        return;
                    }
                } catch (T t2) {
                    this.c.add(t2);
                    this.f35942k.mo5626a();
                    return;
                }
            }
        }
        this.b.add(t2);
        if (t2 == null) {
            this.c.add(new NullPointerException("onNext received a null value"));
        }
        this.f35940i.onNext(t2);
    }

    public void onError(Throwable th) {
        if (!this.f) {
            this.f = true;
            if (this.f35941j.get() == null) {
                this.c.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        try {
            this.e = Thread.currentThread();
            if (th == null) {
                this.c.add(new NullPointerException("onError received a null Throwable"));
            } else {
                this.c.add(th);
            }
            this.f35940i.onError(th);
        } finally {
            this.a.countDown();
        }
    }

    public void onComplete() {
        if (!this.f) {
            this.f = true;
            if (this.f35941j.get() == null) {
                this.c.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        try {
            this.e = Thread.currentThread();
            this.d++;
            this.f35940i.onComplete();
        } finally {
            this.a.countDown();
        }
    }

    public final void m36021c() {
        mo5626a();
    }

    public final void mo5626a() {
        DisposableHelper.m32090a(this.f35941j);
    }

    public final boolean mo5627b() {
        return DisposableHelper.m32088a((Disposable) this.f35941j.get());
    }

    public void onSuccess(T t) {
        onNext(t);
        onComplete();
    }
}
