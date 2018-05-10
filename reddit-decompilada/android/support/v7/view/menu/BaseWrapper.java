package android.support.v7.view.menu;

public class BaseWrapper<T> {
    public final T f2017d;

    BaseWrapper(T t) {
        if (t == null) {
            throw new IllegalArgumentException("Wrapped Object can not be null.");
        }
        this.f2017d = t;
    }
}
