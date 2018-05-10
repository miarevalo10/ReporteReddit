package rx.subjects;

import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Observer;

public abstract class Subject<T, R> extends Observable<R> implements Observer<T> {
    public abstract boolean mo7932e();

    protected Subject(OnSubscribe<R> onSubscribe) {
        super(onSubscribe);
    }
}
