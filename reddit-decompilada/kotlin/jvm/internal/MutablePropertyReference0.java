package kotlin.jvm.internal;

import kotlin.reflect.KCallable;
import kotlin.reflect.KMutableProperty0;
import kotlin.reflect.KProperty0.Getter;

public abstract class MutablePropertyReference0 extends MutablePropertyReference implements KMutableProperty0 {
    public MutablePropertyReference0(Object obj) {
        super(obj);
    }

    protected final KCallable mo6660e() {
        return Reflection.m26853a(this);
    }

    public Object invoke() {
        return mo7073d();
    }

    public final Getter mo7067i() {
        return ((KMutableProperty0) m36133j()).mo7067i();
    }
}
