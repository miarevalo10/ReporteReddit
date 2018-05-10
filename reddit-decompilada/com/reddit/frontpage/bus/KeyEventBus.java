package com.reddit.frontpage.bus;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

public class KeyEventBus {
    private final Subject<Integer> bus = PublishSubject.create();

    KeyEventBus() {
    }

    public Observable<Integer> getBus() {
        return this.bus;
    }

    public void post(int i) {
        this.bus.onNext(Integer.valueOf(i));
    }
}
