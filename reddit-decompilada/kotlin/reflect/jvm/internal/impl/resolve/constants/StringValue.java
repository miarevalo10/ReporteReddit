package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* compiled from: constantValues.kt */
public final class StringValue extends ConstantValue<String> {
    private final SimpleType f32947a;

    public StringValue(String str, KotlinBuiltIns kotlinBuiltIns) {
        Intrinsics.m26847b(str, "value");
        Intrinsics.m26847b(kotlinBuiltIns, "builtIns");
        super(str);
        this.f32947a = kotlinBuiltIns.m27027y();
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("\"");
        stringBuilder.append((String) mo5919b());
        stringBuilder.append("\"");
        return stringBuilder.toString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if ((Intrinsics.m26845a(getClass(), obj.getClass()) ^ 1) == 0) {
                Object obj2 = (String) mo5919b();
                if (obj != null) {
                    return Intrinsics.m26845a(obj2, (String) ((StringValue) obj).mo5919b()) ^ 1;
                }
                throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.resolve.constants.StringValue");
            }
        }
        return null;
    }

    public final int hashCode() {
        return ((String) mo5919b()).hashCode();
    }

    public final /* bridge */ /* synthetic */ KotlinType mo5917a() {
        return this.f32947a;
    }
}
