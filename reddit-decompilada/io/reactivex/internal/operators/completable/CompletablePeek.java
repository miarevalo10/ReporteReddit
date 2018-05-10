package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;

public final class CompletablePeek extends Completable {
    final CompletableSource f34767a;
    final Consumer<? super Disposable> f34768b;
    final Consumer<? super Throwable> f34769c;
    final Action f34770d;
    final Action f34771e;
    final Action f34772f;
    final Action f34773g;

    final class CompletableObserverImplementation implements CompletableObserver, Disposable {
        final CompletableObserver f31220a;
        Disposable f31221b;
        final /* synthetic */ CompletablePeek f31222c;

        CompletableObserverImplementation(CompletablePeek completablePeek, CompletableObserver completableObserver) {
            this.f31222c = completablePeek;
            this.f31220a = completableObserver;
        }

        public final void onSubscribe(Disposable disposable) {
            try {
                this.f31222c.f34768b.accept(disposable);
                if (DisposableHelper.m32089a(this.f31221b, disposable)) {
                    this.f31221b = disposable;
                    this.f31220a.onSubscribe(this);
                }
            } catch (Throwable th) {
                Exceptions.m26521b(th);
                disposable.mo5626a();
                this.f31221b = DisposableHelper.f31095a;
                EmptyDisposable.m38049a(th, this.f31220a);
            }
        }

        public final void onError(Throwable th) {
            if (this.f31221b == DisposableHelper.f31095a) {
                RxJavaPlugins.m26757a(th);
                return;
            }
            try {
                this.f31222c.f34769c.accept(th);
                this.f31222c.f34771e.run();
            } catch (Throwable th2) {
                Exceptions.m26521b(th2);
                th = new CompositeException(th, th2);
            }
            this.f31220a.onError(th);
            m32161c();
        }

        public final void onComplete() {
            if (this.f31221b != DisposableHelper.f31095a) {
                try {
                    this.f31222c.f34770d.run();
                    this.f31222c.f34771e.run();
                    this.f31220a.onComplete();
                    m32161c();
                } catch (Throwable th) {
                    Exceptions.m26521b(th);
                    this.f31220a.onError(th);
                }
            }
        }

        private void m32161c() {
            try {
                this.f31222c.f34772f.run();
            } catch (Throwable th) {
                Exceptions.m26521b(th);
                RxJavaPlugins.m26757a(th);
            }
        }

        public final void mo5626a() {
            try {
                this.f31222c.f34773g.run();
            } catch (Throwable th) {
                Exceptions.m26521b(th);
                RxJavaPlugins.m26757a(th);
            }
            this.f31221b.mo5626a();
        }

        public final boolean mo5627b() {
            return this.f31221b.mo5627b();
        }
    }

    public CompletablePeek(CompletableSource completableSource, Consumer<? super Disposable> consumer, Consumer<? super Throwable> consumer2, Action action, Action action2, Action action3, Action action4) {
        this.f34767a = completableSource;
        this.f34768b = consumer;
        this.f34769c = consumer2;
        this.f34770d = action;
        this.f34771e = action2;
        this.f34772f = action3;
        this.f34773g = action4;
    }

    protected final void subscribeActual(CompletableObserver completableObserver) {
        this.f34767a.subscribe(new CompletableObserverImplementation(this, completableObserver));
    }
}
