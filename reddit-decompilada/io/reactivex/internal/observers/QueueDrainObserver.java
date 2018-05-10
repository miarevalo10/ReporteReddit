package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.util.ObservableQueueDrain;
import io.reactivex.internal.util.QueueDrainHelper;

public abstract class QueueDrainObserver<T, U, V> extends QueueDrainSubscriberPad2 implements Observer<T>, ObservableQueueDrain<U, V> {
    protected final Observer<? super V> f37629a;
    protected final SimplePlainQueue<U> f37630b;
    protected volatile boolean f37631c;
    protected volatile boolean f37632d;
    protected Throwable f37633e;

    public void mo7035a(Observer<? super V> observer, U u) {
    }

    public QueueDrainObserver(Observer<? super V> observer, SimplePlainQueue<U> simplePlainQueue) {
        this.f37629a = observer;
        this.f37630b = simplePlainQueue;
    }

    public final boolean mo7036c() {
        return this.f37631c;
    }

    public final boolean mo7037d() {
        return this.f37632d;
    }

    public final boolean m38074e() {
        return this.f.getAndIncrement() == 0;
    }

    public final boolean m38075f() {
        return this.f.get() == 0 && this.f.compareAndSet(0, 1);
    }

    protected final void m38070a(U u, Disposable disposable) {
        Observer observer = this.f37629a;
        SimplePlainQueue simplePlainQueue = this.f37630b;
        if (this.f.get() == 0 && this.f.compareAndSet(0, 1)) {
            mo7035a(observer, (Object) u);
            if (mo7034a(-1) == null) {
                return;
            }
        }
        simplePlainQueue.offer(u);
        if (m38074e() == null) {
            return;
        }
        QueueDrainHelper.m26726a(simplePlainQueue, observer, disposable, (ObservableQueueDrain) this);
    }

    protected final void m38071b(U u, Disposable disposable) {
        Observer observer = this.f37629a;
        SimplePlainQueue simplePlainQueue = this.f37630b;
        if (this.f.get() != 0 || !this.f.compareAndSet(0, 1)) {
            simplePlainQueue.offer(u);
            if (m38074e() == null) {
                return;
            }
        } else if (simplePlainQueue.isEmpty()) {
            mo7035a(observer, (Object) u);
            if (mo7034a(-1) == null) {
                return;
            }
        } else {
            simplePlainQueue.offer(u);
        }
        QueueDrainHelper.m26726a(simplePlainQueue, observer, disposable, (ObservableQueueDrain) this);
    }

    public final Throwable mo7038g() {
        return this.f37633e;
    }

    public final int mo7034a(int i) {
        return this.f.addAndGet(i);
    }
}
