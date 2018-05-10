package io.reactivex.internal.util;

import org.reactivestreams.Subscriber;

public interface QueueDrain<T, U> {
    int mo7602a(int i);

    boolean mo7603a(Subscriber<? super U> subscriber, T t);

    boolean mo7604d();

    boolean mo7605e();

    Throwable mo7606h();

    long mo7607i();

    long mo7608j();
}
