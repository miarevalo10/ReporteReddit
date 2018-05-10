package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscribers.SinglePostCompleteSubscriber;
import java.util.concurrent.Callable;
import org.reactivestreams.Subscriber;

public final class FlowableMapNotification<T, R> extends AbstractFlowableWithUpstream<T, R> {
    final Function<? super T, ? extends R> f37758a;
    final Function<? super Throwable, ? extends R> f37759b;
    final Callable<? extends R> f37760c;

    static final class MapNotificationSubscriber<T, R> extends SinglePostCompleteSubscriber<T, R> {
        final Function<? super T, ? extends R> f37755a;
        final Function<? super Throwable, ? extends R> f37756b;
        final Callable<? extends R> f37757c;

        MapNotificationSubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends R> function, Function<? super Throwable, ? extends R> function2, Callable<? extends R> callable) {
            super(subscriber);
            this.f37755a = function;
            this.f37756b = function2;
            this.f37757c = callable;
        }

        public final void onNext(T t) {
            try {
                t = ObjectHelper.m26573a(this.f37755a.apply(t), "The onNext publisher returned is null");
                this.g++;
                this.d.onNext(t);
            } catch (T t2) {
                Exceptions.m26521b(t2);
                this.d.onError(t2);
            }
        }

        public final void onError(Throwable th) {
            try {
                m36008b(ObjectHelper.m26573a(this.f37756b.apply(th), "The onError publisher returned is null"));
            } catch (Throwable th2) {
                Exceptions.m26521b(th2);
                this.d.onError(new CompositeException(th, th2));
            }
        }

        public final void onComplete() {
            try {
                m36008b(ObjectHelper.m26573a(this.f37757c.call(), "The onComplete publisher returned is null"));
            } catch (Throwable th) {
                Exceptions.m26521b(th);
                this.d.onError(th);
            }
        }
    }

    public FlowableMapNotification(Flowable<T> flowable, Function<? super T, ? extends R> function, Function<? super Throwable, ? extends R> function2, Callable<? extends R> callable) {
        super(flowable);
        this.f37758a = function;
        this.f37759b = function2;
        this.f37760c = callable;
    }

    protected final void subscribeActual(Subscriber<? super R> subscriber) {
        this.source.subscribe(new MapNotificationSubscriber(subscriber, this.f37758a, this.f37759b, this.f37760c));
    }
}
