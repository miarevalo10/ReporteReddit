package kotlin.jvm.internal;

import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty1;
import kotlin.reflect.KProperty1.Getter;

public abstract class PropertyReference1 extends PropertyReference implements KProperty1 {
    protected final KCallable mo6660e() {
        return Reflection.m26856a(this);
    }

    public final Object mo6492a(Object obj) {
        return mo7075b(obj);
    }

    public final Getter mo7068d() {
        return ((KProperty1) m36133j()).mo7068d();
    }
}
