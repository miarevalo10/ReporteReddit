package kotlin.reflect.jvm.internal.impl.resolve;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker.TypeConstructorEquality;

/* compiled from: DescriptorEquivalenceForOverrides.kt */
final class C2581x10bda471 implements TypeConstructorEquality {
    final /* synthetic */ CallableDescriptor f32929a;
    final /* synthetic */ CallableDescriptor f32930b;

    C2581x10bda471(CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2) {
        this.f32929a = callableDescriptor;
        this.f32930b = callableDescriptor2;
    }

    public final /* synthetic */ boolean mo5914a(TypeConstructor typeConstructor, TypeConstructor typeConstructor2) {
        Intrinsics.m26847b(typeConstructor, "c1");
        Intrinsics.m26847b(typeConstructor2, "c2");
        if (Intrinsics.m26845a((Object) typeConstructor, (Object) typeConstructor2)) {
            return true;
        }
        typeConstructor = typeConstructor.mo5724c();
        typeConstructor2 = typeConstructor2.mo5724c();
        if (typeConstructor instanceof TypeParameterDescriptor) {
            if (typeConstructor2 instanceof TypeParameterDescriptor) {
                return DescriptorEquivalenceForOverrides.f26051a.m27624a((TypeParameterDescriptor) typeConstructor, (TypeParameterDescriptor) typeConstructor2, (Function2) new Function2<DeclarationDescriptor, DeclarationDescriptor, Boolean>() {
                    public final /* synthetic */ Object mo6497a(Object obj, Object obj2) {
                        obj = (Intrinsics.m26845a((DeclarationDescriptor) obj, this.f32929a) == null || Intrinsics.m26845a((DeclarationDescriptor) obj2, this.f32930b) == null) ? null : true;
                        return Boolean.valueOf(obj);
                    }
                });
            }
        }
        return null;
    }
}
