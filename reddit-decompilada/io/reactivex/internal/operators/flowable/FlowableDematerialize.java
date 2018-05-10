package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Notification;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableDematerialize<T> extends AbstractFlowableWithUpstream<Notification<T>, T> {

    static final class DematerializeSubscriber<T> implements FlowableSubscriber<Notification<T>>, Subscription {
        final Subscriber<? super T> f34974a;
        boolean f34975b;
        Subscription f34976c;

        public final /* synthetic */ void onNext(Object obj) {
            Notification notification = (Notification) obj;
            if (this.f34975b) {
                if (NotificationLite.m26704c(notification.f24989a)) {
                    RxJavaPlugins.m26757a(notification.m26489d());
                }
            } else if (NotificationLite.m26704c(notification.f24989a)) {
                this.f34976c.cancel();
                onError(notification.m26489d());
            } else if (notification.m26486a()) {
                this.f34976c.cancel();
                onComplete();
            } else {
                this.f34974a.onNext(notification.m26488c());
            }
        }

        DematerializeSubscriber(Subscriber<? super T> subscriber) {
            this.f34974a = subscriber;
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32781a(this.f34976c, subscription)) {
                this.f34976c = subscription;
                this.f34974a.mo5623a(this);
            }
        }

        public final void onError(Throwable th) {
            if (this.f34975b) {
                RxJavaPlugins.m26757a(th);
                return;
            }
            this.f34975b = true;
            this.f34974a.onError(th);
        }

        public final void onComplete() {
            if (!this.f34975b) {
                this.f34975b = true;
                this.f34974a.onComplete();
            }
        }

        public final void request(long j) {
            this.f34976c.request(j);
        }

        public final void cancel() {
            this.f34976c.cancel();
        }
    }

    public FlowableDematerialize(Flowable<Notification<T>> flowable) {
        super(flowable);
    }

    protected final void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe(new DematerializeSubscriber(subscriber));
    }
}
