package kotlin.jvm.internal;

import kotlin.reflect.KCallable;
import kotlin.reflect.KMutableProperty1;
import kotlin.reflect.KProperty1.Getter;

public abstract class MutablePropertyReference1 extends MutablePropertyReference implements KMutableProperty1 {
    protected final KCallable mo6660e() {
        return Reflection.m26854a(this);
    }

    public final Object mo6492a(Object obj) {
        return mo7075b(obj);
    }

    public final Getter mo7068d() {
        return ((KMutableProperty1) m36133j()).mo7068d();
    }
}
