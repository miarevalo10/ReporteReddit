package io.reactivex.internal.operators.observable;

import io.reactivex.Notification;
import io.reactivex.ObservableSource;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public final class BlockingObservableNext<T> implements Iterable<T> {
    final ObservableSource<T> f25107a;

    static final class NextIterator<T> implements Iterator<T> {
        private final NextObserver<T> f25100a;
        private final ObservableSource<T> f25101b;
        private T f25102c;
        private boolean f25103d = true;
        private boolean f25104e = true;
        private Throwable f25105f;
        private boolean f25106g;

        NextIterator(ObservableSource<T> observableSource, NextObserver<T> nextObserver) {
            this.f25101b = observableSource;
            this.f25100a = nextObserver;
        }

        public final boolean hasNext() {
            if (this.f25105f != null) {
                throw ExceptionHelper.m26682a(this.f25105f);
            } else if (!this.f25103d) {
                return false;
            } else {
                if (this.f25104e) {
                    if (!m26616a()) {
                        return false;
                    }
                }
                return true;
            }
        }

        private boolean m26616a() {
            if (!this.f25106g) {
                this.f25106g = true;
                this.f25100a.m35914c();
                new ObservableMaterialize(this.f25101b).subscribe(this.f25100a);
            }
            try {
                NextObserver nextObserver = this.f25100a;
                nextObserver.m35914c();
                BlockingHelper.m26675a();
                Notification notification = (Notification) nextObserver.f35625a.take();
                if (notification.m26487b()) {
                    this.f25104e = false;
                    this.f25102c = notification.m26488c();
                    return true;
                }
                this.f25103d = false;
                if (notification.m26486a()) {
                    return false;
                }
                this.f25105f = notification.m26489d();
                throw ExceptionHelper.m26682a(this.f25105f);
            } catch (Throwable e) {
                this.f25100a.mo5626a();
                this.f25105f = e;
                throw ExceptionHelper.m26682a(e);
            }
        }

        public final T next() {
            if (this.f25105f != null) {
                throw ExceptionHelper.m26682a(this.f25105f);
            } else if (hasNext()) {
                this.f25104e = true;
                return this.f25102c;
            } else {
                throw new NoSuchElementException("No more elements");
            }
        }

        public final void remove() {
            throw new UnsupportedOperationException("Read only iterator");
        }
    }

    static final class NextObserver<T> extends DisposableObserver<Notification<T>> {
        final BlockingQueue<Notification<T>> f35625a = new ArrayBlockingQueue(1);
        final AtomicInteger f35626b = new AtomicInteger();

        public final void onComplete() {
        }

        NextObserver() {
        }

        public final /* synthetic */ void onNext(Object obj) {
            obj = (Notification) obj;
            if (this.f35626b.getAndSet(0) == 1 || !obj.m26487b()) {
                while (!this.f35625a.offer(obj)) {
                    Notification notification = (Notification) this.f35625a.poll();
                    if (!(notification == null || notification.m26487b())) {
                        obj = notification;
                    }
                }
            }
        }

        public final void onError(Throwable th) {
            RxJavaPlugins.m26757a(th);
        }

        final void m35914c() {
            this.f35626b.set(1);
        }
    }

    public BlockingObservableNext(ObservableSource<T> observableSource) {
        this.f25107a = observableSource;
    }

    public final Iterator<T> iterator() {
        return new NextIterator(this.f25107a, new NextObserver());
    }
}
