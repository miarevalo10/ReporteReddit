package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;

public final class MaybePeek<T> extends AbstractMaybeWithUpstream<T, T> {
    final Consumer<? super Disposable> f37930b;
    final Consumer<? super T> f37931c;
    final Consumer<? super Throwable> f37932d;
    final Action f37933e;
    final Action f37934f;
    final Action f37935g;

    static final class MaybePeekObserver<T> implements MaybeObserver<T>, Disposable {
        final MaybeObserver<? super T> f31507a;
        final MaybePeek<T> f31508b;
        Disposable f31509c;

        MaybePeekObserver(MaybeObserver<? super T> maybeObserver, MaybePeek<T> maybePeek) {
            this.f31507a = maybeObserver;
            this.f31508b = maybePeek;
        }

        public final void mo5626a() {
            try {
                this.f31508b.f37935g.run();
            } catch (Throwable th) {
                Exceptions.m26521b(th);
                RxJavaPlugins.m26757a(th);
            }
            this.f31509c.mo5626a();
            this.f31509c = DisposableHelper.f31095a;
        }

        public final boolean mo5627b() {
            return this.f31509c.mo5627b();
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f31509c, disposable)) {
                try {
                    this.f31508b.f37930b.accept(disposable);
                    this.f31509c = disposable;
                    this.f31507a.onSubscribe(this);
                } catch (Throwable th) {
                    Exceptions.m26521b(th);
                    disposable.mo5626a();
                    this.f31509c = DisposableHelper.f31095a;
                    EmptyDisposable.m38050a(th, this.f31507a);
                }
            }
        }

        public final void onSuccess(T t) {
            if (this.f31509c != DisposableHelper.f31095a) {
                try {
                    this.f31508b.f37931c.accept(t);
                    this.f31509c = DisposableHelper.f31095a;
                    this.f31507a.onSuccess(t);
                    m32312c();
                } catch (T t2) {
                    Exceptions.m26521b(t2);
                    m32311a(t2);
                }
            }
        }

        public final void onError(Throwable th) {
            if (this.f31509c == DisposableHelper.f31095a) {
                RxJavaPlugins.m26757a(th);
            } else {
                m32311a(th);
            }
        }

        private void m32311a(Throwable th) {
            try {
                this.f31508b.f37932d.accept(th);
            } catch (Throwable th2) {
                Exceptions.m26521b(th2);
                th = new CompositeException(th, th2);
            }
            this.f31509c = DisposableHelper.f31095a;
            this.f31507a.onError(th);
            m32312c();
        }

        public final void onComplete() {
            if (this.f31509c != DisposableHelper.f31095a) {
                try {
                    this.f31508b.f37933e.run();
                    this.f31509c = DisposableHelper.f31095a;
                    this.f31507a.onComplete();
                    m32312c();
                } catch (Throwable th) {
                    Exceptions.m26521b(th);
                    m32311a(th);
                }
            }
        }

        private void m32312c() {
            try {
                this.f31508b.f37934f.run();
            } catch (Throwable th) {
                Exceptions.m26521b(th);
                RxJavaPlugins.m26757a(th);
            }
        }
    }

    public MaybePeek(MaybeSource<T> maybeSource, Consumer<? super Disposable> consumer, Consumer<? super T> consumer2, Consumer<? super Throwable> consumer3, Action action, Action action2, Action action3) {
        super(maybeSource);
        this.f37930b = consumer;
        this.f37931c = consumer2;
        this.f37932d = consumer3;
        this.f37933e = action;
        this.f37934f = action2;
        this.f37935g = action3;
    }

    protected final void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.a.subscribe(new MaybePeekObserver(maybeObserver, this));
    }
}
