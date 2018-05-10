package com.instabug.library.core.eventbus;

import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;
import rx.internal.operators.OnSubscribeFilter;
import rx.internal.operators.OperatorCast;
import rx.internal.util.InternalObservableUtils;
import rx.subjects.PublishSubject;
import rx.subjects.Subject;

public class EventBus<T> {
    private final Subject<T, T> subject;

    protected EventBus() {
        this(PublishSubject.d());
    }

    protected EventBus(Subject<T, T> subject) {
        this.subject = subject;
    }

    public <E extends T> void post(E e) {
        this.subject.a_(e);
    }

    public Subscription subscribe(Action1<? super T> action1) {
        return this.subject.a(action1);
    }

    public <E extends T> Observable<E> observeEvents(Class<E> cls) {
        return Observable.a(new OnSubscribeFilter(this.subject, InternalObservableUtils.a(cls))).a(new OperatorCast(cls));
    }

    public boolean hasObservers() {
        return this.subject.e();
    }
}
