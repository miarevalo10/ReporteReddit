package org.reactivestreams;

public interface Subscriber<T> {
    void mo5623a(Subscription subscription);

    void onComplete();

    void onError(Throwable th);

    void onNext(T t);
}
