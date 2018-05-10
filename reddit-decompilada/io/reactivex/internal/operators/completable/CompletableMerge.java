package io.reactivex.internal.operators.completable;

import com.reddit.datalibrary.frontpage.job.RedditJobManager;
import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

public final class CompletableMerge extends Completable {
    final Publisher<? extends CompletableSource> f34755a;
    final int f34756b;
    final boolean f34757c;

    static final class CompletableMergeSubscriber extends AtomicInteger implements FlowableSubscriber<CompletableSource>, Disposable {
        final CompletableObserver f34749a;
        final int f34750b;
        final boolean f34751c;
        final AtomicThrowable f34752d = new AtomicThrowable();
        final CompositeDisposable f34753e = new CompositeDisposable();
        Subscription f34754f;

        final class MergeInnerObserver extends AtomicReference<Disposable> implements CompletableObserver, Disposable {
            final /* synthetic */ CompletableMergeSubscriber f31204a;

            MergeInnerObserver(CompletableMergeSubscriber completableMergeSubscriber) {
                this.f31204a = completableMergeSubscriber;
            }

            public final void onSubscribe(Disposable disposable) {
                DisposableHelper.m32092b(this, disposable);
            }

            public final void onError(Throwable th) {
                CompletableMergeSubscriber completableMergeSubscriber = this.f31204a;
                completableMergeSubscriber.f34753e.mo5633c(this);
                if (!completableMergeSubscriber.f34751c) {
                    completableMergeSubscriber.f34754f.cancel();
                    completableMergeSubscriber.f34753e.mo5626a();
                    if (!ExceptionHelper.m26684a(completableMergeSubscriber.f34752d, th)) {
                        RxJavaPlugins.m26757a(th);
                    } else if (completableMergeSubscriber.getAndSet(null) > null) {
                        completableMergeSubscriber.f34749a.onError(ExceptionHelper.m26683a(completableMergeSubscriber.f34752d));
                    }
                } else if (!ExceptionHelper.m26684a(completableMergeSubscriber.f34752d, th)) {
                    RxJavaPlugins.m26757a(th);
                } else if (completableMergeSubscriber.decrementAndGet() == null) {
                    completableMergeSubscriber.f34749a.onError(ExceptionHelper.m26683a(completableMergeSubscriber.f34752d));
                } else if (completableMergeSubscriber.f34750b != Integer.MAX_VALUE) {
                    completableMergeSubscriber.f34754f.request(1);
                }
            }

            public final void onComplete() {
                CompletableMergeSubscriber completableMergeSubscriber = this.f31204a;
                completableMergeSubscriber.f34753e.mo5633c(this);
                if (completableMergeSubscriber.decrementAndGet() == 0) {
                    Throwable th = (Throwable) completableMergeSubscriber.f34752d.get();
                    if (th != null) {
                        completableMergeSubscriber.f34749a.onError(th);
                        return;
                    } else {
                        completableMergeSubscriber.f34749a.onComplete();
                        return;
                    }
                }
                if (completableMergeSubscriber.f34750b != RedditJobManager.f10810d) {
                    completableMergeSubscriber.f34754f.request(1);
                }
            }

            public final boolean mo5627b() {
                return DisposableHelper.m32088a((Disposable) get());
            }

            public final void mo5626a() {
                DisposableHelper.m32090a((AtomicReference) this);
            }
        }

        public final /* synthetic */ void onNext(Object obj) {
            CompletableSource completableSource = (CompletableSource) obj;
            getAndIncrement();
            Disposable mergeInnerObserver = new MergeInnerObserver(this);
            this.f34753e.mo5631a(mergeInnerObserver);
            completableSource.subscribe(mergeInnerObserver);
        }

        CompletableMergeSubscriber(CompletableObserver completableObserver, int i, boolean z) {
            this.f34749a = completableObserver;
            this.f34750b = i;
            this.f34751c = z;
            lazySet(1);
        }

        public final void mo5626a() {
            this.f34754f.cancel();
            this.f34753e.mo5626a();
        }

        public final boolean mo5627b() {
            return this.f34753e.mo5627b();
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32781a(this.f34754f, subscription)) {
                this.f34754f = subscription;
                this.f34749a.onSubscribe(this);
                if (this.f34750b == RedditJobManager.f10810d) {
                    subscription.request(Long.MAX_VALUE);
                    return;
                }
                subscription.request((long) this.f34750b);
            }
        }

        public final void onError(Throwable th) {
            if (!this.f34751c) {
                this.f34753e.mo5626a();
                if (!ExceptionHelper.m26684a(this.f34752d, th)) {
                    RxJavaPlugins.m26757a(th);
                } else if (getAndSet(null) > null) {
                    this.f34749a.onError(ExceptionHelper.m26683a(this.f34752d));
                }
            } else if (!ExceptionHelper.m26684a(this.f34752d, th)) {
                RxJavaPlugins.m26757a(th);
            } else if (decrementAndGet() == null) {
                this.f34749a.onError(ExceptionHelper.m26683a(this.f34752d));
            }
        }

        public final void onComplete() {
            if (decrementAndGet() == 0) {
                if (((Throwable) this.f34752d.get()) != null) {
                    this.f34749a.onError(ExceptionHelper.m26683a(this.f34752d));
                    return;
                }
                this.f34749a.onComplete();
            }
        }
    }

    public CompletableMerge(Publisher<? extends CompletableSource> publisher, int i, boolean z) {
        this.f34755a = publisher;
        this.f34756b = i;
        this.f34757c = z;
    }

    public final void subscribeActual(CompletableObserver completableObserver) {
        this.f34755a.subscribe(new CompletableMergeSubscriber(completableObserver, this.f34756b, this.f34757c));
    }
}
