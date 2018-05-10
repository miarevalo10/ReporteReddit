package rx.observers;

import rx.Observer;
import rx.Subscriber;

public class SerializedSubscriber<T> extends Subscriber<T> {
    private final Observer<T> f42036a;

    public SerializedSubscriber(Subscriber<? super T> subscriber) {
        this(subscriber, (byte) 0);
    }

    private SerializedSubscriber(Subscriber<? super T> subscriber, byte b) {
        super(subscriber, (byte) 1);
        this.f42036a = new SerializedObserver(subscriber);
    }

    public final void mo7906b() {
        this.f42036a.mo7906b();
    }

    public final void mo7904a(Throwable th) {
        this.f42036a.mo7904a(th);
    }

    public final void a_(T t) {
        this.f42036a.a_(t);
    }
}
