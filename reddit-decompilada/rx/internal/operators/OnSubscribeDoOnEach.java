package rx.internal.operators;

import java.util.Arrays;
import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Observer;
import rx.Subscriber;
import rx.exceptions.CompositeException;
import rx.exceptions.Exceptions;
import rx.plugins.RxJavaHooks;

public class OnSubscribeDoOnEach<T> implements OnSubscribe<T> {
    private final Observer<? super T> f41888a;
    private final Observable<T> f41889b;

    private static final class DoOnEachSubscriber<T> extends Subscriber<T> {
        private final Subscriber<? super T> f41885a;
        private final Observer<? super T> f41886b;
        private boolean f41887c;

        DoOnEachSubscriber(Subscriber<? super T> subscriber, Observer<? super T> observer) {
            super(subscriber);
            this.f41885a = subscriber;
            this.f41886b = observer;
        }

        public final void mo7906b() {
            if (!this.f41887c) {
                try {
                    this.f41886b.mo7906b();
                    this.f41887c = true;
                    this.f41885a.mo7906b();
                } catch (Throwable th) {
                    Exceptions.m43432a(th, (Observer) this);
                }
            }
        }

        public final void mo7904a(Throwable th) {
            if (this.f41887c) {
                RxJavaHooks.m43500a(th);
                return;
            }
            this.f41887c = true;
            try {
                this.f41886b.mo7904a(th);
                this.f41885a.mo7904a(th);
            } catch (Throwable th2) {
                Exceptions.m43435b(th2);
                this.f41885a.mo7904a(new CompositeException(Arrays.asList(new Throwable[]{th, th2}), (byte) 0));
            }
        }

        public final void a_(T t) {
            if (!this.f41887c) {
                try {
                    this.f41886b.a_(t);
                    this.f41885a.a_(t);
                } catch (Throwable th) {
                    Exceptions.m43433a(th, this, t);
                }
            }
        }
    }

    public final /* synthetic */ void mo7899a(Object obj) {
        this.f41889b.m43406a(new DoOnEachSubscriber((Subscriber) obj, this.f41888a));
    }

    public OnSubscribeDoOnEach(Observable<T> observable, Observer<? super T> observer) {
        this.f41889b = observable;
        this.f41888a = observer;
    }
}
