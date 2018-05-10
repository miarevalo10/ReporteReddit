package io.reactivex.internal.operators.observable;

import io.reactivex.Notification;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;

public final class BlockingObservableLatest<T> implements Iterable<T> {
    final ObservableSource<T> f25095a;

    static final class BlockingObservableLatestIterator<T> extends DisposableObserver<Notification<T>> implements Iterator<T> {
        Notification<T> f35621a;
        final Semaphore f35622b = new Semaphore(0);
        final AtomicReference<Notification<T>> f35623c = new AtomicReference();

        public final void onComplete() {
        }

        BlockingObservableLatestIterator() {
        }

        public final /* synthetic */ void onNext(Object obj) {
            if ((this.f35623c.getAndSet((Notification) obj) == null ? true : null) != null) {
                this.f35622b.release();
            }
        }

        public final void onError(Throwable th) {
            RxJavaPlugins.m26757a(th);
        }

        public final boolean hasNext() {
            if (this.f35621a == null || !NotificationLite.m26704c(this.f35621a.f24989a)) {
                if (this.f35621a == null) {
                    try {
                        BlockingHelper.m26675a();
                        this.f35622b.acquire();
                        Notification notification = (Notification) this.f35623c.getAndSet(null);
                        this.f35621a = notification;
                        if (NotificationLite.m26704c(notification.f24989a)) {
                            throw ExceptionHelper.m26682a(notification.m26489d());
                        }
                    } catch (Throwable e) {
                        mo5626a();
                        this.f35621a = Notification.m26484a(e);
                        throw ExceptionHelper.m26682a(e);
                    }
                }
                return this.f35621a.m26487b();
            }
            throw ExceptionHelper.m26682a(this.f35621a.m26489d());
        }

        public final T next() {
            if (hasNext()) {
                T c = this.f35621a.m26488c();
                this.f35621a = null;
                return c;
            }
            throw new NoSuchElementException();
        }

        public final void remove() {
            throw new UnsupportedOperationException("Read-only iterator.");
        }
    }

    public BlockingObservableLatest(ObservableSource<T> observableSource) {
        this.f25095a = observableSource;
    }

    public final Iterator<T> iterator() {
        Observer blockingObservableLatestIterator = new BlockingObservableLatestIterator();
        Observable.wrap(this.f25095a).materialize().subscribe(blockingObservableLatestIterator);
        return blockingObservableLatestIterator;
    }
}
