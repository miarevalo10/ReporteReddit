package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.Notification;
import io.reactivex.internal.subscribers.SinglePostCompleteSubscriber;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;

public final class FlowableMaterialize<T> extends AbstractFlowableWithUpstream<T, Notification<T>> {

    static final class MaterializeSubscriber<T> extends SinglePostCompleteSubscriber<T, Notification<T>> {
        protected final /* synthetic */ void mo7046a(Object obj) {
            Notification notification = (Notification) obj;
            if (NotificationLite.m26704c(notification.f24989a)) {
                RxJavaPlugins.m26757a(notification.m26489d());
            }
        }

        MaterializeSubscriber(Subscriber<? super Notification<T>> subscriber) {
            super(subscriber);
        }

        public final void onNext(T t) {
            this.g++;
            this.d.onNext(Notification.m26483a((Object) t));
        }

        public final void onError(Throwable th) {
            m36008b(Notification.m26484a(th));
        }

        public final void onComplete() {
            m36008b(Notification.m26485e());
        }
    }

    public FlowableMaterialize(Flowable<T> flowable) {
        super(flowable);
    }

    protected final void subscribeActual(Subscriber<? super Notification<T>> subscriber) {
        this.source.subscribe(new MaterializeSubscriber(subscriber));
    }
}
