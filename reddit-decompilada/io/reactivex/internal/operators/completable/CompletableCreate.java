package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableOnSubscribe;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class CompletableCreate extends Completable {
    final CompletableOnSubscribe f34720a;

    static final class Emitter extends AtomicReference<Disposable> implements Disposable {
        final CompletableObserver f31185a;

        Emitter(CompletableObserver completableObserver) {
            this.f31185a = completableObserver;
        }

        public final void mo5626a() {
            DisposableHelper.m32090a((AtomicReference) this);
        }

        public final boolean mo5627b() {
            return DisposableHelper.m32088a((Disposable) get());
        }
    }

    public CompletableCreate(CompletableOnSubscribe completableOnSubscribe) {
        this.f34720a = completableOnSubscribe;
    }

    protected final void subscribeActual(CompletableObserver completableObserver) {
        completableObserver.onSubscribe(new Emitter(completableObserver));
    }
}
