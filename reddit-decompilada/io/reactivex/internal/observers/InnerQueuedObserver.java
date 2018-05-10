package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.util.QueueDrainHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class InnerQueuedObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable {
    final InnerQueuedObserverSupport<T> f31158a;
    final int f31159b;
    public SimpleQueue<T> f31160c;
    public volatile boolean f31161d;
    int f31162e;

    public InnerQueuedObserver(InnerQueuedObserverSupport<T> innerQueuedObserverSupport, int i) {
        this.f31158a = innerQueuedObserverSupport;
        this.f31159b = i;
    }

    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.m32092b(this, disposable)) {
            if (disposable instanceof QueueDisposable) {
                QueueDisposable queueDisposable = (QueueDisposable) disposable;
                int a = queueDisposable.mo7033a(3);
                if (a == 1) {
                    this.f31162e = a;
                    this.f31160c = queueDisposable;
                    this.f31161d = true;
                    this.f31158a.mo5658a(this);
                    return;
                } else if (a == 2) {
                    this.f31162e = a;
                    this.f31160c = queueDisposable;
                    return;
                }
            }
            this.f31160c = QueueDrainHelper.m26725a(-this.f31159b);
        }
    }

    public final void onNext(T t) {
        if (this.f31162e == 0) {
            this.f31158a.mo5659a(this, (Object) t);
        } else {
            this.f31158a.mo5661c();
        }
    }

    public final void onError(Throwable th) {
        this.f31158a.mo5660a(this, th);
    }

    public final void onComplete() {
        this.f31158a.mo5658a(this);
    }

    public final void mo5626a() {
        DisposableHelper.m32090a((AtomicReference) this);
    }

    public final boolean mo5627b() {
        return DisposableHelper.m32088a((Disposable) get());
    }
}
