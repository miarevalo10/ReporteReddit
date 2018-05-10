package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeDelay<T> extends AbstractMaybeWithUpstream<T, T> {
    final long f37908b;
    final TimeUnit f37909c;
    final Scheduler f37910d;

    static final class DelayMaybeObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable, Runnable {
        final MaybeObserver<? super T> f31413a;
        final long f31414b;
        final TimeUnit f31415c;
        final Scheduler f31416d;
        T f31417e;
        Throwable f31418f;

        DelayMaybeObserver(MaybeObserver<? super T> maybeObserver, long j, TimeUnit timeUnit, Scheduler scheduler) {
            this.f31413a = maybeObserver;
            this.f31414b = j;
            this.f31415c = timeUnit;
            this.f31416d = scheduler;
        }

        public final void run() {
            Throwable th = this.f31418f;
            if (th != null) {
                this.f31413a.onError(th);
                return;
            }
            Object obj = this.f31417e;
            if (obj != null) {
                this.f31413a.onSuccess(obj);
            } else {
                this.f31413a.onComplete();
            }
        }

        public final void mo5626a() {
            DisposableHelper.m32090a((AtomicReference) this);
        }

        public final boolean mo5627b() {
            return DisposableHelper.m32088a((Disposable) get());
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32092b(this, disposable) != null) {
                this.f31413a.onSubscribe(this);
            }
        }

        public final void onSuccess(T t) {
            this.f31417e = t;
            m32248c();
        }

        public final void onError(Throwable th) {
            this.f31418f = th;
            m32248c();
        }

        public final void onComplete() {
            m32248c();
        }

        private void m32248c() {
            DisposableHelper.m32094c(this, this.f31416d.mo5630a(this, this.f31414b, this.f31415c));
        }
    }

    public MaybeDelay(MaybeSource<T> maybeSource, long j, TimeUnit timeUnit, Scheduler scheduler) {
        super(maybeSource);
        this.f37908b = j;
        this.f37909c = timeUnit;
        this.f37910d = scheduler;
    }

    protected final void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.a.subscribe(new DelayMaybeObserver(maybeObserver, this.f37908b, this.f37909c, this.f37910d));
    }
}
