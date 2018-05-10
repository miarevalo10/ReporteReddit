package rx.observers;

import java.util.Arrays;
import rx.Observer;
import rx.Subscriber;
import rx.exceptions.CompositeException;
import rx.exceptions.Exceptions;
import rx.exceptions.OnErrorFailedException;
import rx.exceptions.OnErrorNotImplementedException;
import rx.exceptions.UnsubscribeFailedException;
import rx.plugins.RxJavaHooks;

public class SafeSubscriber<T> extends Subscriber<T> {
    boolean f42034a;
    private final Subscriber<? super T> f42035b;

    public SafeSubscriber(Subscriber<? super T> subscriber) {
        super(subscriber);
        this.f42035b = subscriber;
    }

    public final void mo7906b() {
        UnsubscribeFailedException unsubscribeFailedException;
        if (!this.f42034a) {
            this.f42034a = true;
            try {
                this.f42035b.mo7906b();
                try {
                    this.f41662d.mo7893c();
                } catch (Throwable th) {
                    RxJavaHooks.m43500a(th);
                    unsubscribeFailedException = new UnsubscribeFailedException(th.getMessage(), th);
                }
            } catch (Throwable th2) {
                RxJavaHooks.m43500a(th2);
                unsubscribeFailedException = new UnsubscribeFailedException(th2.getMessage(), th2);
            }
        }
    }

    public final void mo7904a(Throwable th) {
        Exceptions.m43435b(th);
        if (!this.f42034a) {
            this.f42034a = true;
            RxJavaHooks.m43500a(th);
            try {
                this.f42035b.mo7904a(th);
                try {
                    this.f41662d.mo7893c();
                } catch (Throwable th2) {
                    RxJavaHooks.m43500a(th2);
                    OnErrorFailedException onErrorFailedException = new OnErrorFailedException(th2);
                }
            } catch (OnErrorNotImplementedException e) {
                this.f41662d.mo7893c();
                throw e;
            } catch (Throwable th3) {
                RxJavaHooks.m43500a(th3);
                OnErrorNotImplementedException onErrorNotImplementedException = new OnErrorNotImplementedException("Observer.onError not implemented and error while unsubscribing.", new CompositeException(Arrays.asList(new Throwable[]{th2, th3}), (byte) 0));
            }
        }
    }

    public final void a_(T t) {
        try {
            if (!this.f42034a) {
                this.f42035b.a_(t);
            }
        } catch (Throwable th) {
            Exceptions.m43432a(th, (Observer) this);
        }
    }
}
