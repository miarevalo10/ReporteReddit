package kotlin.reflect.jvm.internal.impl.load.java.components;

import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

public interface SignaturePropagator {
    public static final SignaturePropagator f25669a = new C25701();

    public static class PropagatedSignature {
        public final KotlinType f25663a;
        public final KotlinType f25664b;
        public final List<ValueParameterDescriptor> f25665c;
        public final List<TypeParameterDescriptor> f25666d;
        public final List<String> f25667e;
        public final boolean f25668f;

        public PropagatedSignature(KotlinType kotlinType, List<ValueParameterDescriptor> list, List<TypeParameterDescriptor> list2, List<String> list3) {
            if (kotlinType == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"returnType", "kotlin/reflect/jvm/internal/impl/load/java/components/SignaturePropagator$PropagatedSignature", "<init>"}));
            } else if (list == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"valueParameters", "kotlin/reflect/jvm/internal/impl/load/java/components/SignaturePropagator$PropagatedSignature", "<init>"}));
            } else if (list2 == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"typeParameters", "kotlin/reflect/jvm/internal/impl/load/java/components/SignaturePropagator$PropagatedSignature", "<init>"}));
            } else if (list3 == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"signatureErrors", "kotlin/reflect/jvm/internal/impl/load/java/components/SignaturePropagator$PropagatedSignature", "<init>"}));
            } else {
                this.f25663a = kotlinType;
                this.f25664b = null;
                this.f25665c = list;
                this.f25666d = list2;
                this.f25667e = list3;
                this.f25668f = false;
            }
        }
    }

    static class C25701 implements SignaturePropagator {
        C25701() {
        }

        public final PropagatedSignature mo5776a(JavaMethod javaMethod, ClassDescriptor classDescriptor, KotlinType kotlinType, List<ValueParameterDescriptor> list, List<TypeParameterDescriptor> list2) {
            if (javaMethod == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"method", "kotlin/reflect/jvm/internal/impl/load/java/components/SignaturePropagator$1", "resolvePropagatedSignature"}));
            } else if (classDescriptor == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"owner", "kotlin/reflect/jvm/internal/impl/load/java/components/SignaturePropagator$1", "resolvePropagatedSignature"}));
            } else if (kotlinType == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"returnType", "kotlin/reflect/jvm/internal/impl/load/java/components/SignaturePropagator$1", "resolvePropagatedSignature"}));
            } else if (list == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"valueParameters", "kotlin/reflect/jvm/internal/impl/load/java/components/SignaturePropagator$1", "resolvePropagatedSignature"}));
            } else if (list2 != null) {
                return new PropagatedSignature(kotlinType, list, list2, Collections.emptyList());
            } else {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"typeParameters", "kotlin/reflect/jvm/internal/impl/load/java/components/SignaturePropagator$1", "resolvePropagatedSignature"}));
            }
        }

        public final void mo5777a(CallableMemberDescriptor callableMemberDescriptor, List<String> list) {
            if (callableMemberDescriptor == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"descriptor", "kotlin/reflect/jvm/internal/impl/load/java/components/SignaturePropagator$1", "reportSignatureErrors"}));
            } else if (list == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"signatureErrors", "kotlin/reflect/jvm/internal/impl/load/java/components/SignaturePropagator$1", "reportSignatureErrors"}));
            } else {
                throw new UnsupportedOperationException("Should not be called");
            }
        }
    }

    PropagatedSignature mo5776a(JavaMethod javaMethod, ClassDescriptor classDescriptor, KotlinType kotlinType, List<ValueParameterDescriptor> list, List<TypeParameterDescriptor> list2);

    void mo5777a(CallableMemberDescriptor callableMemberDescriptor, List<String> list);
}
