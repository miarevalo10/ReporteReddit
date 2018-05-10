package io.reactivex.internal.util;

import io.reactivex.Observer;

public interface ObservableQueueDrain<T, U> {
    int mo7034a(int i);

    void mo7035a(Observer<? super U> observer, T t);

    boolean mo7036c();

    boolean mo7037d();

    Throwable mo7038g();
}
