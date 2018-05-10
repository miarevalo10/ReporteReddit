package io.reactivex.internal.fuseable;

import io.reactivex.FlowableSubscriber;

public interface ConditionalSubscriber<T> extends FlowableSubscriber<T> {
    boolean mo7052a(T t);
}
