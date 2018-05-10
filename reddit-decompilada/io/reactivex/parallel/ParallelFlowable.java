package io.reactivex.parallel;

import io.reactivex.Flowable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.parallel.ParallelFromPublisher;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Publisher;

public abstract class ParallelFlowable<T> {
    public static <T> ParallelFlowable<T> m26734a(Publisher<? extends T> publisher) {
        return m26736a(publisher, Runtime.getRuntime().availableProcessors(), Flowable.bufferSize());
    }

    public static <T> ParallelFlowable<T> m26735a(Publisher<? extends T> publisher, int i) {
        return m26736a(publisher, i, Flowable.bufferSize());
    }

    public static <T> ParallelFlowable<T> m26736a(Publisher<? extends T> publisher, int i, int i2) {
        ObjectHelper.m26573a((Object) publisher, "source");
        ObjectHelper.m26569a(i, "parallelism");
        ObjectHelper.m26569a(i2, "prefetch");
        return RxJavaPlugins.m26751a(new ParallelFromPublisher(publisher, i, i2));
    }
}
