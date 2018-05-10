package kotlin.reflect.jvm.internal.impl.resolve.constants;

import java.util.List;
import kotlin.TypeCastException;
import kotlin._Assertions;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: constantValues.kt */
public final class ArrayValue extends ConstantValue<List<? extends ConstantValue<?>>> {
    private final KotlinType f32936a;
    private final KotlinBuiltIns f32937b;

    public final KotlinType mo5917a() {
        return this.f32936a;
    }

    public ArrayValue(List<? extends ConstantValue<?>> list, KotlinType kotlinType, KotlinBuiltIns kotlinBuiltIns) {
        Intrinsics.m26847b(list, "value");
        Intrinsics.m26847b(kotlinType, "type");
        Intrinsics.m26847b(kotlinBuiltIns, "builtIns");
        super(list);
        this.f32936a = kotlinType;
        this.f32937b = kotlinBuiltIns;
        if (KotlinBuiltIns.m26982b(this.f32936a) == null) {
            if (KotlinBuiltIns.m26986c(this.f32936a) == null) {
                kotlinType = null;
                if (_Assertions.f25274a != null && r3 == null) {
                    kotlinType = new StringBuilder("Type should be an array, but was ");
                    kotlinType.append(this.f32936a);
                    kotlinType.append(": ");
                    kotlinType.append(list);
                    throw ((Throwable) new AssertionError(kotlinType.toString()));
                }
            }
        }
        kotlinType = true;
        if (_Assertions.f25274a != null) {
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((Intrinsics.m26845a(getClass(), obj != null ? obj.getClass() : null) ^ 1) != 0) {
            return null;
        }
        Object obj2 = (List) mo5919b();
        if (obj != null) {
            return Intrinsics.m26845a(obj2, (List) ((ArrayValue) obj).mo5919b());
        }
        throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.resolve.constants.ArrayValue");
    }

    public final int hashCode() {
        return mo5919b().hashCode();
    }
}
