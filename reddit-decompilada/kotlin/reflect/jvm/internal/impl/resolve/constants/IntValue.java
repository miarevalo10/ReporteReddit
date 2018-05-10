package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* compiled from: constantValues.kt */
public final class IntValue extends IntegerValueConstant<Integer> {
    private final SimpleType f36147a;

    public IntValue(int i, KotlinBuiltIns kotlinBuiltIns) {
        Intrinsics.m26847b(kotlinBuiltIns, "builtIns");
        super(Integer.valueOf(i));
        this.f36147a = kotlinBuiltIns.m27020r();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((Intrinsics.m26845a(getClass(), obj != null ? obj.getClass() : null) ^ 1) != 0) {
            return false;
        }
        if (obj == null) {
            throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.resolve.constants.IntValue");
        }
        if (((Number) mo5919b()).intValue() == ((Number) ((IntValue) obj).mo5919b()).intValue()) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return ((Number) mo5919b()).intValue();
    }

    public final /* bridge */ /* synthetic */ KotlinType mo5917a() {
        return this.f36147a;
    }
}
