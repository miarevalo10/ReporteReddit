package io.reactivex.internal.operators.flowable;

import com.reddit.datalibrary.frontpage.job.RedditJobManager;
import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public final class FlowableFlatMapCompletableCompletable<T> extends Completable implements FuseToFlowable<T> {
    final Flowable<T> f35037a;
    final Function<? super T, ? extends CompletableSource> f35038b;
    final int f35039c;
    final boolean f35040d;

    static final class FlatMapCompletableMainSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Disposable {
        final CompletableObserver f35029a;
        final AtomicThrowable f35030b = new AtomicThrowable();
        final Function<? super T, ? extends CompletableSource> f35031c;
        final boolean f35032d;
        final CompositeDisposable f35033e = new CompositeDisposable();
        final int f35034f;
        Subscription f35035g;
        volatile boolean f35036h;

        final class InnerObserver extends AtomicReference<Disposable> implements CompletableObserver, Disposable {
            final /* synthetic */ FlatMapCompletableMainSubscriber f31262a;

            InnerObserver(FlatMapCompletableMainSubscriber flatMapCompletableMainSubscriber) {
                this.f31262a = flatMapCompletableMainSubscriber;
            }

            public final void onSubscribe(Disposable disposable) {
                DisposableHelper.m32092b(this, disposable);
            }

            public final void onComplete() {
                FlatMapCompletableMainSubscriber flatMapCompletableMainSubscriber = this.f31262a;
                flatMapCompletableMainSubscriber.f35033e.mo5633c(this);
                flatMapCompletableMainSubscriber.onComplete();
            }

            public final void onError(Throwable th) {
                FlatMapCompletableMainSubscriber flatMapCompletableMainSubscriber = this.f31262a;
                flatMapCompletableMainSubscriber.f35033e.mo5633c(this);
                flatMapCompletableMainSubscriber.onError(th);
            }

            public final void mo5626a() {
                DisposableHelper.m32090a((AtomicReference) this);
            }

            public final boolean mo5627b() {
                return DisposableHelper.m32088a((Disposable) get());
            }
        }

        FlatMapCompletableMainSubscriber(CompletableObserver completableObserver, Function<? super T, ? extends CompletableSource> function, boolean z, int i) {
            this.f35029a = completableObserver;
            this.f35031c = function;
            this.f35032d = z;
            this.f35034f = i;
            lazySet(1);
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32781a(this.f35035g, subscription)) {
                this.f35035g = subscription;
                this.f35029a.onSubscribe(this);
                int i = this.f35034f;
                if (i == RedditJobManager.f10810d) {
                    subscription.request(Long.MAX_VALUE);
                    return;
                }
                subscription.request((long) i);
            }
        }

        public final void onNext(T t) {
            try {
                CompletableSource completableSource = (CompletableSource) ObjectHelper.m26573a(this.f35031c.apply(t), "The mapper returned a null CompletableSource");
                getAndIncrement();
                Disposable innerObserver = new InnerObserver(this);
                if (!this.f35036h && this.f35033e.mo5631a(innerObserver)) {
                    completableSource.subscribe(innerObserver);
                }
            } catch (T t2) {
                Exceptions.m26521b(t2);
                this.f35035g.cancel();
                onError(t2);
            }
        }

        public final void onError(Throwable th) {
            if (!ExceptionHelper.m26684a(this.f35030b, th)) {
                RxJavaPlugins.m26757a(th);
            } else if (this.f35032d == null) {
                mo5626a();
                if (getAndSet(null) > null) {
                    this.f35029a.onError(ExceptionHelper.m26683a(this.f35030b));
                }
            } else if (decrementAndGet() == null) {
                this.f35029a.onError(ExceptionHelper.m26683a(this.f35030b));
            } else if (this.f35034f != Integer.MAX_VALUE) {
                this.f35035g.request(1);
            }
        }

        public final void onComplete() {
            if (decrementAndGet() == 0) {
                Throwable a = ExceptionHelper.m26683a(this.f35030b);
                if (a != null) {
                    this.f35029a.onError(a);
                    return;
                } else {
                    this.f35029a.onComplete();
                    return;
                }
            }
            if (this.f35034f != RedditJobManager.f10810d) {
                this.f35035g.request(1);
            }
        }

        public final void mo5626a() {
            this.f35036h = true;
            this.f35035g.cancel();
            this.f35033e.mo5626a();
        }

        public final boolean mo5627b() {
            return this.f35033e.mo5627b();
        }
    }

    public FlowableFlatMapCompletableCompletable(Flowable<T> flowable, Function<? super T, ? extends CompletableSource> function, boolean z, int i) {
        this.f35037a = flowable;
        this.f35038b = function;
        this.f35040d = z;
        this.f35039c = i;
    }

    protected final void subscribeActual(CompletableObserver completableObserver) {
        this.f35037a.subscribe(new FlatMapCompletableMainSubscriber(completableObserver, this.f35038b, this.f35040d, this.f35039c));
    }

    public final Flowable<T> mo6616a() {
        return RxJavaPlugins.m26739a(new FlowableFlatMapCompletable(this.f35037a, this.f35038b, this.f35040d, this.f35039c));
    }
}
