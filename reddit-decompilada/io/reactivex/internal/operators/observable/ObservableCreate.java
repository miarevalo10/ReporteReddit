package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableCreate<T> extends Observable<T> {
    final ObservableOnSubscribe<T> f35653a;

    static final class CreateEmitter<T> extends AtomicReference<Disposable> implements ObservableEmitter<T>, Disposable {
        final Observer<? super T> f35652a;

        CreateEmitter(Observer<? super T> observer) {
            this.f35652a = observer;
        }

        public final void mo5641a(T t) {
            if (t == null) {
                mo5642a(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                return;
            }
            if (!mo5627b()) {
                this.f35652a.onNext(t);
            }
        }

        public final void mo5642a(Throwable th) {
            if (!m35919b(th)) {
                RxJavaPlugins.m26757a(th);
            }
        }

        private boolean m35919b(Throwable th) {
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            if (mo5627b()) {
                return null;
            }
            try {
                this.f35652a.onError(th);
                return true;
            } finally {
                mo5626a();
            }
        }

        public final void aA_() {
            if (!mo5627b()) {
                try {
                    this.f35652a.onComplete();
                } finally {
                    DisposableHelper.m32090a((AtomicReference) this);
                }
            }
        }

        public final void mo5626a() {
            DisposableHelper.m32090a((AtomicReference) this);
        }

        public final boolean mo5627b() {
            return DisposableHelper.m32088a((Disposable) get());
        }
    }

    public ObservableCreate(ObservableOnSubscribe<T> observableOnSubscribe) {
        this.f35653a = observableOnSubscribe;
    }

    protected final void subscribeActual(Observer<? super T> observer) {
        CreateEmitter createEmitter = new CreateEmitter(observer);
        observer.onSubscribe(createEmitter);
        try {
            this.f35653a.mo4493a(createEmitter);
        } catch (Throwable th) {
            Exceptions.m26521b(th);
            createEmitter.mo5642a(th);
        }
    }
}
