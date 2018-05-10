package io.reactivex.internal.operators.observable;

import io.reactivex.Notification;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;

public final class ObservableDematerialize<T> extends AbstractObservableWithUpstream<Notification<T>, T> {

    static final class DematerializeObserver<T> implements Observer<Notification<T>>, Disposable {
        final Observer<? super T> f31745a;
        boolean f31746b;
        Disposable f31747c;

        public final /* synthetic */ void onNext(Object obj) {
            Notification notification = (Notification) obj;
            if (this.f31746b) {
                if (NotificationLite.m26704c(notification.f24989a)) {
                    RxJavaPlugins.m26757a(notification.m26489d());
                }
            } else if (NotificationLite.m26704c(notification.f24989a)) {
                this.f31747c.mo5626a();
                onError(notification.m26489d());
            } else if (notification.m26486a()) {
                this.f31747c.mo5626a();
                onComplete();
            } else {
                this.f31745a.onNext(notification.m26488c());
            }
        }

        DematerializeObserver(Observer<? super T> observer) {
            this.f31745a = observer;
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f31747c, disposable)) {
                this.f31747c = disposable;
                this.f31745a.onSubscribe(this);
            }
        }

        public final void mo5626a() {
            this.f31747c.mo5626a();
        }

        public final boolean mo5627b() {
            return this.f31747c.mo5627b();
        }

        public final void onError(Throwable th) {
            if (this.f31746b) {
                RxJavaPlugins.m26757a(th);
                return;
            }
            this.f31746b = true;
            this.f31745a.onError(th);
        }

        public final void onComplete() {
            if (!this.f31746b) {
                this.f31746b = true;
                this.f31745a.onComplete();
            }
        }
    }

    public ObservableDematerialize(ObservableSource<Notification<T>> observableSource) {
        super(observableSource);
    }

    public final void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new DematerializeObserver(observer));
    }
}
