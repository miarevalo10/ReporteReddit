package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.ScalarSubscription;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public final class FlowableScalarXMap {

    static final class ScalarXMapFlowable<T, R> extends Flowable<R> {
        final T f35293a;
        final Function<? super T, ? extends Publisher<? extends R>> f35294b;

        ScalarXMapFlowable(T t, Function<? super T, ? extends Publisher<? extends R>> function) {
            this.f35293a = t;
            this.f35294b = function;
        }

        public final void subscribeActual(Subscriber<? super R> subscriber) {
            try {
                Publisher publisher = (Publisher) ObjectHelper.m26573a(this.f35294b.apply(this.f35293a), "The mapper returned a null Publisher");
                if (publisher instanceof Callable) {
                    try {
                        Object call = ((Callable) publisher).call();
                        if (call == null) {
                            EmptySubscription.m38161a((Subscriber) subscriber);
                            return;
                        } else {
                            subscriber.mo5623a(new ScalarSubscription(subscriber, call));
                            return;
                        }
                    } catch (Throwable th) {
                        Exceptions.m26521b(th);
                        EmptySubscription.m38160a(th, subscriber);
                        return;
                    }
                }
                publisher.subscribe(subscriber);
            } catch (Throwable th2) {
                EmptySubscription.m38160a(th2, subscriber);
            }
        }
    }

    public static <T, R> boolean m26613a(Publisher<T> publisher, Subscriber<? super R> subscriber, Function<? super T, ? extends Publisher<? extends R>> function) {
        if (!(publisher instanceof Callable)) {
            return null;
        }
        try {
            publisher = ((Callable) publisher).call();
            if (publisher == null) {
                EmptySubscription.m38161a((Subscriber) subscriber);
                return true;
            }
            try {
                publisher = (Publisher) ObjectHelper.m26573a(function.apply(publisher), "The mapper returned a null Publisher");
                if ((publisher instanceof Callable) != null) {
                    try {
                        publisher = ((Callable) publisher).call();
                        if (publisher == null) {
                            EmptySubscription.m38161a((Subscriber) subscriber);
                            return true;
                        }
                        subscriber.mo5623a(new ScalarSubscription(subscriber, publisher));
                    } catch (Publisher<T> publisher2) {
                        Exceptions.m26521b(publisher2);
                        EmptySubscription.m38160a(publisher2, subscriber);
                        return true;
                    }
                }
                publisher2.subscribe(subscriber);
                return true;
            } catch (Publisher<T> publisher22) {
                Exceptions.m26521b(publisher22);
                EmptySubscription.m38160a(publisher22, subscriber);
                return true;
            }
        } catch (Publisher<T> publisher222) {
            Exceptions.m26521b(publisher222);
            EmptySubscription.m38160a(publisher222, subscriber);
            return true;
        }
    }

    public static <T, U> Flowable<U> m26612a(T t, Function<? super T, ? extends Publisher<? extends U>> function) {
        return RxJavaPlugins.m26739a(new ScalarXMapFlowable(t, function));
    }
}
