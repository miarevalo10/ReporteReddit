package rx.subjects;

import rx.Observable.OnSubscribe;
import rx.Subscriber;
import rx.observers.SerializedObserver;

public class SerializedSubject<T, R> extends Subject<T, R> {
    private final SerializedObserver<T> f42047b;
    private final Subject<T, R> f42048c;

    class C31641 implements OnSubscribe<R> {
        final /* synthetic */ Subject f42046a;

        C31641(Subject subject) {
            this.f42046a = subject;
        }

        public final /* bridge */ /* synthetic */ void mo7899a(Object obj) {
            this.f42046a.m43406a((Subscriber) obj);
        }
    }

    public SerializedSubject(Subject<T, R> subject) {
        super(new C31641(subject));
        this.f42048c = subject;
        this.f42047b = new SerializedObserver(subject);
    }

    public final void mo7906b() {
        this.f42047b.mo7906b();
    }

    public final void mo7904a(Throwable th) {
        this.f42047b.mo7904a(th);
    }

    public final void a_(T t) {
        this.f42047b.a_(t);
    }

    public final boolean mo7932e() {
        return this.f42048c.mo7932e();
    }
}
