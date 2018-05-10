package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.internal.functions.ObjectHelper;
import org.reactivestreams.Publisher;

abstract class AbstractFlowableWithUpstream<T, R> extends Flowable<R> {
    protected final Flowable<T> source;

    AbstractFlowableWithUpstream(Flowable<T> flowable) {
        this.source = (Flowable) ObjectHelper.m26573a((Object) flowable, "source is null");
    }

    public final Publisher<T> source() {
        return this.source;
    }
}
