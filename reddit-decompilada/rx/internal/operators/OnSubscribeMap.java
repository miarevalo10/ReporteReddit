package rx.internal.operators;

import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.exceptions.OnErrorThrowable;
import rx.functions.Func1;
import rx.plugins.RxJavaHooks;

public final class OnSubscribeMap<T, R> implements OnSubscribe<R> {
    final Observable<T> f41902a;
    final Func1<? super T, ? extends R> f41903b;

    static final class MapSubscriber<T, R> extends Subscriber<T> {
        final Subscriber<? super R> f41899a;
        final Func1<? super T, ? extends R> f41900b;
        boolean f41901c;

        public MapSubscriber(Subscriber<? super R> subscriber, Func1<? super T, ? extends R> func1) {
            this.f41899a = subscriber;
            this.f41900b = func1;
        }

        public final void a_(T t) {
            try {
                this.f41899a.a_(this.f41900b.call(t));
            } catch (Throwable th) {
                Exceptions.m43435b(th);
                this.f41662d.mo7893c();
                mo7904a(OnErrorThrowable.m43437a(th, t));
            }
        }

        public final void mo7904a(Throwable th) {
            if (this.f41901c) {
                RxJavaHooks.m43500a(th);
                return;
            }
            this.f41901c = true;
            this.f41899a.mo7904a(th);
        }

        public final void mo7906b() {
            if (!this.f41901c) {
                this.f41899a.mo7906b();
            }
        }

        public final void mo7929a(Producer producer) {
            this.f41899a.mo7929a(producer);
        }
    }

    public final /* synthetic */ void mo7899a(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        Subscriber mapSubscriber = new MapSubscriber(subscriber, this.f41903b);
        subscriber.m43809a((Subscription) mapSubscriber);
        this.f41902a.m43406a(mapSubscriber);
    }

    public OnSubscribeMap(Observable<T> observable, Func1<? super T, ? extends R> func1) {
        this.f41902a = observable;
        this.f41903b = func1;
    }
}
