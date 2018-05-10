package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: constantValues.kt */
public abstract class ConstantValue<T> {
    private final T f26088a;

    public abstract KotlinType mo5917a();

    public ConstantValue(T t) {
        this.f26088a = t;
    }

    public T mo5919b() {
        return this.f26088a;
    }

    public String toString() {
        return String.valueOf(mo5919b());
    }
}
