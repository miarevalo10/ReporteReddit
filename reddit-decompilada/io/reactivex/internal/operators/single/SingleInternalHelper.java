package io.reactivex.internal.operators.single;

import io.reactivex.Observable;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
import org.reactivestreams.Publisher;

public final class SingleInternalHelper {

    enum NoSuchElementCallable implements Callable<NoSuchElementException> {
        ;

        private NoSuchElementCallable(String str) {
        }
    }

    enum ToFlowable implements Function<SingleSource, Publisher> {
        ;

        private ToFlowable(String str) {
        }
    }

    enum ToObservable implements Function<SingleSource, Observable> {
        ;

        private ToObservable(String str) {
        }
    }

    public static <T> Callable<NoSuchElementException> m26651a() {
        return NoSuchElementCallable.f25151a;
    }

    public static <T> Function<SingleSource<? extends T>, Publisher<? extends T>> m26652b() {
        return ToFlowable.f32366a;
    }

    public static <T> Function<SingleSource<? extends T>, Observable<? extends T>> m26653c() {
        return ToObservable.f32368a;
    }
}
