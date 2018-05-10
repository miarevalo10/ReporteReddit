package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.CountDownLatch;

public abstract class BlockingBaseObserver<T> extends CountDownLatch implements Observer<T>, Disposable {
    T f31128a;
    Throwable f31129b;
    Disposable f31130c;
    volatile boolean f31131d;

    public BlockingBaseObserver() {
        super(1);
    }

    public final void onSubscribe(Disposable disposable) {
        this.f31130c = disposable;
        if (this.f31131d) {
            disposable.mo5626a();
        }
    }

    public final void onComplete() {
        countDown();
    }

    public final void mo5626a() {
        this.f31131d = true;
        Disposable disposable = this.f31130c;
        if (disposable != null) {
            disposable.mo5626a();
        }
    }

    public final boolean mo5627b() {
        return this.f31131d;
    }

    public final T m32114c() {
        if (getCount() != 0) {
            try {
                BlockingHelper.m26675a();
                await();
            } catch (Throwable e) {
                mo5626a();
                throw ExceptionHelper.m26682a(e);
            }
        }
        Throwable e2 = this.f31129b;
        if (e2 == null) {
            return this.f31128a;
        }
        throw ExceptionHelper.m26682a(e2);
    }
}
