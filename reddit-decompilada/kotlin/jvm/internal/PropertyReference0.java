package kotlin.jvm.internal;

import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty0;
import kotlin.reflect.KProperty0.Getter;

public abstract class PropertyReference0 extends PropertyReference implements KProperty0 {
    protected final KCallable mo6660e() {
        return Reflection.m26855a(this);
    }

    public Object invoke() {
        return mo7073d();
    }

    public final Getter mo7067i() {
        return ((KProperty0) m36133j()).mo7067i();
    }
}
