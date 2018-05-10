package io.reactivex.internal.operators.flowable;

import com.reddit.datalibrary.frontpage.job.RedditJobManager;
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
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableFlatMapCompletable<T> extends AbstractFlowableWithUpstream<T, T> {
    final Function<? super T, ? extends CompletableSource> f37725a;
    final int f37726b;
    final boolean f37727c;

    static final class FlatMapCompletableMainSubscriber<T> extends BasicIntQueueSubscription<T> implements FlowableSubscriber<T> {
        final Subscriber<? super T> f39428a;
        final AtomicThrowable f39429b = new AtomicThrowable();
        final Function<? super T, ? extends CompletableSource> f39430c;
        final boolean f39431d;
        final CompositeDisposable f39432e = new CompositeDisposable();
        final int f39433f;
        Subscription f39434g;
        volatile boolean f39435h;

        final class InnerConsumer extends AtomicReference<Disposable> implements CompletableObserver, Disposable {
            final /* synthetic */ FlatMapCompletableMainSubscriber f31261a;

            InnerConsumer(FlatMapCompletableMainSubscriber flatMapCompletableMainSubscriber) {
                this.f31261a = flatMapCompletableMainSubscriber;
            }

            public final void onSubscribe(Disposable disposable) {
                DisposableHelper.m32092b(this, disposable);
            }

            public final void onComplete() {
                FlatMapCompletableMainSubscriber flatMapCompletableMainSubscriber = this.f31261a;
                flatMapCompletableMainSubscriber.f39432e.mo5633c(this);
                flatMapCompletableMainSubscriber.onComplete();
            }

            public final void onError(Throwable th) {
                FlatMapCompletableMainSubscriber flatMapCompletableMainSubscriber = this.f31261a;
                flatMapCompletableMainSubscriber.f39432e.mo5633c(this);
                flatMapCompletableMainSubscriber.onError(th);
            }

            public final void mo5626a() {
                DisposableHelper.m32090a((AtomicReference) this);
            }

            public final boolean mo5627b() {
                return DisposableHelper.m32088a((Disposable) get());
            }
        }

        public final int mo7033a(int i) {
            return i & 2;
        }

        public final void clear() {
        }

        public final boolean isEmpty() {
            return true;
        }

        public final T poll() throws Exception {
            return null;
        }

        public final void request(long j) {
        }

        FlatMapCompletableMainSubscriber(Subscriber<? super T> subscriber, Function<? super T, ? extends CompletableSource> function, boolean z, int i) {
            this.f39428a = subscriber;
            this.f39430c = function;
            this.f39431d = z;
            this.f39433f = i;
            lazySet(1);
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32781a(this.f39434g, subscription)) {
                this.f39434g = subscription;
                this.f39428a.mo5623a(this);
                int i = this.f39433f;
                if (i == RedditJobManager.f10810d) {
                    subscription.request(Long.MAX_VALUE);
                    return;
                }
                subscription.request((long) i);
            }
        }

        public final void onNext(T t) {
            try {
                CompletableSource completableSource = (CompletableSource) ObjectHelper.m26573a(this.f39430c.apply(t), "The mapper returned a null CompletableSource");
                getAndIncrement();
                Disposable innerConsumer = new InnerConsumer(this);
                if (!this.f39435h && this.f39432e.mo5631a(innerConsumer)) {
                    completableSource.subscribe(innerConsumer);
                }
            } catch (T t2) {
                Exceptions.m26521b(t2);
                this.f39434g.cancel();
                onError(t2);
            }
        }

        public final void onError(Throwable th) {
            if (!ExceptionHelper.m26684a(this.f39429b, th)) {
                RxJavaPlugins.m26757a(th);
            } else if (this.f39431d == null) {
                cancel();
                if (getAndSet(null) > null) {
                    this.f39428a.onError(ExceptionHelper.m26683a(this.f39429b));
                }
            } else if (decrementAndGet() == null) {
                this.f39428a.onError(ExceptionHelper.m26683a(this.f39429b));
            } else if (this.f39433f != Integer.MAX_VALUE) {
                this.f39434g.request(1);
            }
        }

        public final void onComplete() {
            if (decrementAndGet() == 0) {
                Throwable a = ExceptionHelper.m26683a(this.f39429b);
                if (a != null) {
                    this.f39428a.onError(a);
                    return;
                } else {
                    this.f39428a.onComplete();
                    return;
                }
            }
            if (this.f39433f != RedditJobManager.f10810d) {
                this.f39434g.request(1);
            }
        }

        public final void cancel() {
            this.f39435h = true;
            this.f39434g.cancel();
            this.f39432e.mo5626a();
        }
    }

    public FlowableFlatMapCompletable(Flowable<T> flowable, Function<? super T, ? extends CompletableSource> function, boolean z, int i) {
        super(flowable);
        this.f37725a = function;
        this.f37727c = z;
        this.f37726b = i;
    }

    protected final void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe(new FlatMapCompletableMainSubscriber(subscriber, this.f37725a, this.f37727c, this.f37726b));
    }
}
