package io.reactivex.internal.disposables;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;

public final class ObserverFullArbiter<T> extends FullArbiterPad1 implements Disposable {
    final Observer<? super T> f37619b;
    final SpscLinkedArrayQueue<Object> f37620c = new SpscLinkedArrayQueue(8);
    volatile Disposable f37621d = EmptyDisposable.INSTANCE;
    Disposable f37622e;
    volatile boolean f37623f;

    public ObserverFullArbiter(Observer<? super T> observer, Disposable disposable) {
        this.f37619b = observer;
        this.f37622e = disposable;
    }

    public final void mo5626a() {
        if (!this.f37623f) {
            this.f37623f = true;
            m38056c();
        }
    }

    public final boolean mo5627b() {
        Disposable disposable = this.f37622e;
        return disposable != null ? disposable.mo5627b() : this.f37623f;
    }

    private void m38056c() {
        Disposable disposable = this.f37622e;
        this.f37622e = null;
        if (disposable != null) {
            disposable.mo5626a();
        }
    }

    public final boolean m38060a(Disposable disposable) {
        if (this.f37623f) {
            return null;
        }
        this.f37620c.m35964a(this.f37621d, NotificationLite.m26695a(disposable));
        m38057d();
        return true;
    }

    public final boolean m38061a(T t, Disposable disposable) {
        if (this.f37623f) {
            return null;
        }
        this.f37620c.m35964a((Object) disposable, NotificationLite.m26696a((Object) t));
        m38057d();
        return true;
    }

    public final void m38059a(Throwable th, Disposable disposable) {
        if (this.f37623f) {
            RxJavaPlugins.m26757a(th);
            return;
        }
        this.f37620c.m35964a((Object) disposable, NotificationLite.m26697a(th));
        m38057d();
    }

    public final void m38062b(Disposable disposable) {
        this.f37620c.m35964a((Object) disposable, NotificationLite.m26694a());
        m38057d();
    }

    private void m38057d() {
        if (this.a.getAndIncrement() == 0) {
            SpscLinkedArrayQueue spscLinkedArrayQueue = this.f37620c;
            Observer observer = this.f37619b;
            int i = 1;
            while (true) {
                Disposable poll = spscLinkedArrayQueue.poll();
                if (poll != null) {
                    Object poll2 = spscLinkedArrayQueue.poll();
                    if (poll == this.f37621d) {
                        if (NotificationLite.m26705d(poll2)) {
                            poll = NotificationLite.m26708g(poll2);
                            this.f37621d.mo5626a();
                            if (this.f37623f) {
                                poll.mo5626a();
                            } else {
                                this.f37621d = poll;
                            }
                        } else if (NotificationLite.m26704c(poll2)) {
                            spscLinkedArrayQueue.clear();
                            m38056c();
                            Throwable f = NotificationLite.m26707f(poll2);
                            if (this.f37623f) {
                                RxJavaPlugins.m26757a(f);
                            } else {
                                this.f37623f = true;
                                observer.onError(f);
                            }
                        } else if (NotificationLite.m26701b(poll2)) {
                            spscLinkedArrayQueue.clear();
                            m38056c();
                            if (!this.f37623f) {
                                this.f37623f = true;
                                observer.onComplete();
                            }
                        } else {
                            observer.onNext(NotificationLite.m26706e(poll2));
                        }
                    }
                } else {
                    i = this.a.addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                }
            }
        }
    }
}
