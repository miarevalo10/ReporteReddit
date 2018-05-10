package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicReference;

public final class BlockingObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable {
    public static final Object f31136a = new Object();
    final Queue<Object> f31137b;

    public BlockingObserver(Queue<Object> queue) {
        this.f31137b = queue;
    }

    public final void onSubscribe(Disposable disposable) {
        DisposableHelper.m32092b(this, disposable);
    }

    public final void onNext(T t) {
        this.f31137b.offer(NotificationLite.m26696a((Object) t));
    }

    public final void onError(Throwable th) {
        this.f31137b.offer(NotificationLite.m26697a(th));
    }

    public final void onComplete() {
        this.f31137b.offer(NotificationLite.m26694a());
    }

    public final void mo5626a() {
        if (DisposableHelper.m32090a((AtomicReference) this)) {
            this.f31137b.offer(f31136a);
        }
    }

    public final boolean mo5627b() {
        return get() == DisposableHelper.f31095a;
    }
}
