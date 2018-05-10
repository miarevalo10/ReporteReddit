package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.observables.ConnectableObservable;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableAutoConnect<T> extends Observable<T> {
    final ConnectableObservable<? extends T> f35633a;
    final int f35634b = 2;
    final Consumer<? super Disposable> f35635c;
    final AtomicInteger f35636d;

    public ObservableAutoConnect(ConnectableObservable<? extends T> connectableObservable, Consumer<? super Disposable> consumer) {
        this.f35633a = connectableObservable;
        this.f35635c = consumer;
        this.f35636d = new AtomicInteger();
    }

    public final void subscribeActual(Observer<? super T> observer) {
        this.f35633a.subscribe((Observer) observer);
        if (this.f35636d.incrementAndGet() == this.f35634b) {
            this.f35633a.mo7053a(this.f35635c);
        }
    }
}
