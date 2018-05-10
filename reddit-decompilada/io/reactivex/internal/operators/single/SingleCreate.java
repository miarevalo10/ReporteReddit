package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleObserver;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleCreate<T> extends Single<T> {
    final SingleOnSubscribe<T> f35769a;

    static final class Emitter<T> extends AtomicReference<Disposable> implements SingleEmitter<T>, Disposable {
        final SingleObserver<? super T> f32316a;

        Emitter(SingleObserver<? super T> singleObserver) {
            this.f32316a = singleObserver;
        }

        public final void mo5674a(T t) {
            if (get() != DisposableHelper.f31095a) {
                Disposable disposable = (Disposable) getAndSet(DisposableHelper.f31095a);
                if (disposable != DisposableHelper.f31095a) {
                    if (t == null) {
                        try {
                            this.f32316a.onError(new NullPointerException("onSuccess called with null. Null values are generally not allowed in 2.x operators and sources."));
                        } catch (Throwable th) {
                            if (disposable != null) {
                                disposable.mo5626a();
                            }
                        }
                    } else {
                        this.f32316a.onSuccess(t);
                    }
                    if (disposable != null) {
                        disposable.mo5626a();
                    }
                }
            }
        }

        public final boolean m32689a(Throwable th) {
            if (get() != DisposableHelper.f31095a) {
                Disposable disposable = (Disposable) getAndSet(DisposableHelper.f31095a);
                if (disposable != DisposableHelper.f31095a) {
                    try {
                        this.f32316a.onError(th);
                        return true;
                    } finally {
                        if (disposable != null) {
                            disposable.mo5626a();
                        }
                    }
                }
            }
            return null;
        }

        public final void mo5626a() {
            DisposableHelper.m32090a((AtomicReference) this);
        }

        public final boolean mo5627b() {
            return DisposableHelper.m32088a((Disposable) get());
        }
    }

    public SingleCreate(SingleOnSubscribe<T> singleOnSubscribe) {
        this.f35769a = singleOnSubscribe;
    }

    protected final void subscribeActual(SingleObserver<? super T> singleObserver) {
        Emitter emitter = new Emitter(singleObserver);
        singleObserver.onSubscribe(emitter);
        try {
            this.f35769a.mo4947a(emitter);
        } catch (Throwable th) {
            Exceptions.m26521b(th);
            if (!emitter.m32689a(th)) {
                RxJavaPlugins.m26757a(th);
            }
        }
    }
}
