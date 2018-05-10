package io.reactivex.internal.disposables;

import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicReferenceArray;

public final class ArrayCompositeDisposable extends AtomicReferenceArray<Disposable> implements Disposable {
    public ArrayCompositeDisposable() {
        super(2);
    }

    public final boolean m32086a(int i, Disposable disposable) {
        Disposable disposable2;
        do {
            disposable2 = (Disposable) get(i);
            if (disposable2 == DisposableHelper.f31095a) {
                disposable.mo5626a();
                return false;
            }
        } while (!compareAndSet(i, disposable2, disposable));
        if (disposable2 != null) {
            disposable2.mo5626a();
        }
        return true;
    }

    public final void mo5626a() {
        int i = 0;
        if (get(0) != DisposableHelper.f31095a) {
            int length = length();
            while (i < length) {
                if (((Disposable) get(i)) != DisposableHelper.f31095a) {
                    Disposable disposable = (Disposable) getAndSet(i, DisposableHelper.f31095a);
                    if (!(disposable == DisposableHelper.f31095a || disposable == null)) {
                        disposable.mo5626a();
                    }
                }
                i++;
            }
        }
    }

    public final boolean mo5627b() {
        return get(0) == DisposableHelper.f31095a;
    }
}
