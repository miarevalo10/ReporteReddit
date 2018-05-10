package io.reactivex.internal.operators.observable;

import com.reddit.frontpage.presentation.modtools.bottomsheet.modqueueoptions.ModQueueOptionsPresenter;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class BlockingObservableIterable<T> implements Iterable<T> {
    final ObservableSource<? extends T> f25093a;
    final int f25094b;

    static final class BlockingObservableIterator<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable, Iterator<T> {
        final SpscLinkedArrayQueue<T> f31557a;
        final Lock f31558b = new ReentrantLock();
        final Condition f31559c = this.f31558b.newCondition();
        volatile boolean f31560d;
        Throwable f31561e;

        BlockingObservableIterator(int i) {
            this.f31557a = new SpscLinkedArrayQueue(i);
        }

        public final boolean hasNext() {
            while (true) {
                Throwable th;
                boolean z = this.f31560d;
                boolean isEmpty = this.f31557a.isEmpty();
                if (z) {
                    th = this.f31561e;
                    if (th != null) {
                        throw ExceptionHelper.m26682a(th);
                    } else if (isEmpty) {
                        return false;
                    }
                }
                if (!isEmpty) {
                    return true;
                }
                BlockingHelper.m26675a();
                this.f31558b.lock();
                while (!this.f31560d && this.f31557a.isEmpty()) {
                    try {
                        this.f31559c.await();
                    } catch (Throwable th2) {
                        DisposableHelper.m32090a((AtomicReference) this);
                        m32347c();
                        throw ExceptionHelper.m26682a(th2);
                    } catch (Throwable th3) {
                        this.f31558b.unlock();
                    }
                }
                this.f31558b.unlock();
            }
        }

        public final T next() {
            if (hasNext()) {
                return this.f31557a.poll();
            }
            throw new NoSuchElementException();
        }

        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.m32092b(this, disposable);
        }

        public final void onNext(T t) {
            this.f31557a.offer(t);
            m32347c();
        }

        public final void onError(Throwable th) {
            this.f31561e = th;
            this.f31560d = true;
            m32347c();
        }

        public final void onComplete() {
            this.f31560d = true;
            m32347c();
        }

        private void m32347c() {
            this.f31558b.lock();
            try {
                this.f31559c.signalAll();
            } finally {
                this.f31558b.unlock();
            }
        }

        public final void remove() {
            throw new UnsupportedOperationException(ModQueueOptionsPresenter.ACTION_REMOVE);
        }

        public final void mo5626a() {
            DisposableHelper.m32090a((AtomicReference) this);
        }

        public final boolean mo5627b() {
            return DisposableHelper.m32088a((Disposable) get());
        }
    }

    public BlockingObservableIterable(ObservableSource<? extends T> observableSource, int i) {
        this.f25093a = observableSource;
        this.f25094b = i;
    }

    public final Iterator<T> iterator() {
        Object blockingObservableIterator = new BlockingObservableIterator(this.f25094b);
        this.f25093a.subscribe(blockingObservableIterator);
        return blockingObservableIterator;
    }
}
