package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;

public final class SingleDoOnSubscribe<T> extends Single<T> {
    final SingleSource<T> f35801a;
    final Consumer<? super Disposable> f35802b;

    static final class DoOnSubscribeSingleObserver<T> implements SingleObserver<T> {
        final SingleObserver<? super T> f32344a;
        final Consumer<? super Disposable> f32345b;
        boolean f32346c;

        DoOnSubscribeSingleObserver(SingleObserver<? super T> singleObserver, Consumer<? super Disposable> consumer) {
            this.f32344a = singleObserver;
            this.f32345b = consumer;
        }

        public final void onSubscribe(Disposable disposable) {
            try {
                this.f32345b.accept(disposable);
                this.f32344a.onSubscribe(disposable);
            } catch (Throwable th) {
                Exceptions.m26521b(th);
                this.f32346c = true;
                disposable.mo5626a();
                EmptyDisposable.m38052a(th, this.f32344a);
            }
        }

        public final void onSuccess(T t) {
            if (!this.f32346c) {
                this.f32344a.onSuccess(t);
            }
        }

        public final void onError(Throwable th) {
            if (this.f32346c) {
                RxJavaPlugins.m26757a(th);
            } else {
                this.f32344a.onError(th);
            }
        }
    }

    public SingleDoOnSubscribe(SingleSource<T> singleSource, Consumer<? super Disposable> consumer) {
        this.f35801a = singleSource;
        this.f35802b = consumer;
    }

    protected final void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f35801a.subscribe(new DoOnSubscribeSingleObserver(singleObserver, this.f35802b));
    }
}
