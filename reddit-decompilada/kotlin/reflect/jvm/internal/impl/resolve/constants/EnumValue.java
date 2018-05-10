package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: constantValues.kt */
public final class EnumValue extends ConstantValue<ClassDescriptor> {
    public EnumValue(ClassDescriptor classDescriptor) {
        Intrinsics.m26847b(classDescriptor, "value");
        super(classDescriptor);
    }

    public final KotlinType mo5917a() {
        KotlinType a = DescriptorUtilsKt.m27739a((ClassDescriptor) mo5919b());
        if (a != null) {
            return a;
        }
        StringBuilder stringBuilder = new StringBuilder("Enum entry must have a class object type: ");
        stringBuilder.append((ClassDescriptor) mo5919b());
        throw new AssertionError(stringBuilder.toString());
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(mo5917a());
        stringBuilder.append(".");
        stringBuilder.append(((ClassDescriptor) mo5919b()).mo6689i());
        return stringBuilder.toString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((Intrinsics.m26845a(getClass(), obj != null ? obj.getClass() : null) ^ 1) != 0) {
            return null;
        }
        Object obj2 = (ClassDescriptor) mo5919b();
        if (obj != null) {
            return Intrinsics.m26845a(obj2, (ClassDescriptor) ((EnumValue) obj).mo5919b());
        }
        throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.resolve.constants.EnumValue");
    }

    public final int hashCode() {
        return mo5919b().hashCode();
    }
}
