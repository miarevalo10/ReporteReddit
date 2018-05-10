package kotlin.reflect.jvm.internal.impl.types.typesApproximation;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;

/* compiled from: CapturedTypeApproximation.kt */
final class TypeArgument {
    final TypeParameterDescriptor f26372a;
    final KotlinType f26373b;
    final KotlinType f26374c;

    public TypeArgument(TypeParameterDescriptor typeParameterDescriptor, KotlinType kotlinType, KotlinType kotlinType2) {
        Intrinsics.m26847b(typeParameterDescriptor, "typeParameter");
        Intrinsics.m26847b(kotlinType, "inProjection");
        Intrinsics.m26847b(kotlinType2, "outProjection");
        this.f26372a = typeParameterDescriptor;
        this.f26373b = kotlinType;
        this.f26374c = kotlinType2;
    }

    public final boolean m28073a() {
        return KotlinTypeChecker.f26349a.mo5935a(this.f26373b, this.f26374c);
    }
}
