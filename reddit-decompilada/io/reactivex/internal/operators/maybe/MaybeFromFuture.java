package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public final class MaybeFromFuture<T> extends Maybe<T> {
    final Future<? extends T> f35588a;
    final long f35589b;
    final TimeUnit f35590c;

    public MaybeFromFuture(Future<? extends T> future, long j, TimeUnit timeUnit) {
        this.f35588a = future;
        this.f35589b = j;
        this.f35590c = timeUnit;
    }

    protected final void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        Disposable a = Disposables.m26512a();
        maybeObserver.onSubscribe(a);
        if (!a.mo5627b()) {
            try {
                Object obj;
                if (this.f35589b <= 0) {
                    obj = this.f35588a.get();
                } else {
                    obj = this.f35588a.get(this.f35589b, this.f35590c);
                }
                if (!a.mo5627b()) {
                    if (obj == null) {
                        maybeObserver.onComplete();
                        return;
                    }
                    maybeObserver.onSuccess(obj);
                }
            } catch (Throwable e) {
                if (!a.mo5627b()) {
                    maybeObserver.onError(e);
                }
            } catch (ExecutionException e2) {
                if (!a.mo5627b()) {
                    maybeObserver.onError(e2.getCause());
                }
            } catch (Throwable e3) {
                if (!a.mo5627b()) {
                    maybeObserver.onError(e3);
                }
            }
        }
    }
}
