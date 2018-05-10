package io.reactivex.internal.operators.parallel;

import io.reactivex.parallel.ParallelFlowable;
import org.reactivestreams.Publisher;

public final class ParallelFromPublisher<T> extends ParallelFlowable<T> {
    final Publisher<? extends T> f32307a;
    final int f32308b;
    final int f32309c;

    public ParallelFromPublisher(Publisher<? extends T> publisher, int i, int i2) {
        this.f32307a = publisher;
        this.f32308b = i;
        this.f32309c = i2;
    }
}
