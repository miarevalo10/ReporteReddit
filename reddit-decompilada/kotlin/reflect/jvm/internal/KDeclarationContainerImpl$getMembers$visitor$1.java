package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorVisitorEmptyBodies;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J!\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H\u0016¢\u0006\u0002\u0010\tJ!\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0003H\u0016¢\u0006\u0002\u0010\fJ!\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u0003H\u0016¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"kotlin/reflect/jvm/internal/KDeclarationContainerImpl$getMembers$visitor$1", "Lorg/jetbrains/kotlin/descriptors/impl/DeclarationDescriptorVisitorEmptyBodies;", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;)V", "visitConstructorDescriptor", "descriptor", "Lorg/jetbrains/kotlin/descriptors/ConstructorDescriptor;", "data", "(Lorg/jetbrains/kotlin/descriptors/ConstructorDescriptor;Lkotlin/Unit;)Lkotlin/reflect/jvm/internal/KCallableImpl;", "visitFunctionDescriptor", "Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;", "(Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;Lkotlin/Unit;)Lkotlin/reflect/jvm/internal/KCallableImpl;", "visitPropertyDescriptor", "Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;", "(Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;Lkotlin/Unit;)Lkotlin/reflect/jvm/internal/KCallableImpl;", "kotlin-reflection"}, k = 1, mv = {1, 1, 5})
/* compiled from: KDeclarationContainerImpl.kt */
public final class KDeclarationContainerImpl$getMembers$visitor$1 extends DeclarationDescriptorVisitorEmptyBodies<KCallableImpl<?>, Unit> {
    final /* synthetic */ KDeclarationContainerImpl f36031a;

    KDeclarationContainerImpl$getMembers$visitor$1(KDeclarationContainerImpl kDeclarationContainerImpl) {
        this.f36031a = kDeclarationContainerImpl;
    }

    public final /* synthetic */ Object mo5728a(ConstructorDescriptor constructorDescriptor, Object obj) {
        Unit unit = (Unit) obj;
        Intrinsics.m26847b(constructorDescriptor, "descriptor");
        Intrinsics.m26847b(unit, "data");
        StringBuilder stringBuilder = new StringBuilder("No constructors should appear in this scope: ");
        stringBuilder.append(constructorDescriptor);
        throw ((Throwable) new IllegalStateException(stringBuilder.toString()));
    }

    public final /* synthetic */ Object mo5729a(FunctionDescriptor functionDescriptor, Object obj) {
        Unit unit = (Unit) obj;
        Intrinsics.m26847b(functionDescriptor, "descriptor");
        Intrinsics.m26847b(unit, "data");
        return (KCallableImpl) new KFunctionImpl(this.f36031a, functionDescriptor);
    }

    public final /* synthetic */ Object mo5733a(PropertyDescriptor propertyDescriptor, Object obj) {
        Unit unit = (Unit) obj;
        Intrinsics.m26847b(propertyDescriptor, "descriptor");
        Intrinsics.m26847b(unit, "data");
        return KDeclarationContainerImpl.m36163a(this.f36031a, propertyDescriptor);
    }
}
