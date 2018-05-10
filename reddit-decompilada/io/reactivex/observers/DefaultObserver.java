package io.reactivex.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.util.EndConsumerHelper;

public abstract class DefaultObserver<T> implements Observer<T> {
    private Disposable f32467a;

    public final void onSubscribe(Disposable disposable) {
        if (EndConsumerHelper.m26678a(this.f32467a, disposable, getClass())) {
            this.f32467a = disposable;
        }
    }
}
