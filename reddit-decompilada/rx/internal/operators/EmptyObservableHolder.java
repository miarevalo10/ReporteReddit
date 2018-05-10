package rx.internal.operators;

import rx.Observable;
import rx.Observable.OnSubscribe;

public enum EmptyObservableHolder implements OnSubscribe<Object> {
    ;
    
    static final Observable<Object> f41866b = null;

    private EmptyObservableHolder(String str) {
    }

    static {
        f41866b = Observable.m43391a(f41865a);
    }

    public static <T> Observable<T> m44011a() {
        return f41866b;
    }
}
