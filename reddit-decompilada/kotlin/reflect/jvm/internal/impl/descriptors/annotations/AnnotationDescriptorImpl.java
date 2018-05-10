package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.Collections;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

public class AnnotationDescriptorImpl implements AnnotationDescriptor {
    private final KotlinType f32640a;
    private final Map<ValueParameterDescriptor, ConstantValue<?>> f32641b;
    private final SourceElement f32642c;

    public AnnotationDescriptorImpl(KotlinType kotlinType, Map<ValueParameterDescriptor, ConstantValue<?>> map, SourceElement sourceElement) {
        if (kotlinType == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"annotationType", "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationDescriptorImpl", "<init>"}));
        } else if (map == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"valueArguments", "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationDescriptorImpl", "<init>"}));
        } else if (sourceElement == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"source", "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationDescriptorImpl", "<init>"}));
        } else {
            this.f32640a = kotlinType;
            this.f32641b = Collections.unmodifiableMap(map);
            this.f32642c = sourceElement;
        }
    }

    public final KotlinType mo5719a() {
        KotlinType kotlinType = this.f32640a;
        if (kotlinType != null) {
            return kotlinType;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationDescriptorImpl", "getType"}));
    }

    public final Map<ValueParameterDescriptor, ConstantValue<?>> mo5720b() {
        Map<ValueParameterDescriptor, ConstantValue<?>> map = this.f32641b;
        if (map != null) {
            return map;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationDescriptorImpl", "getAllValueArguments"}));
    }

    public final SourceElement mo5721c() {
        SourceElement sourceElement = this.f32642c;
        if (sourceElement != null) {
            return sourceElement;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationDescriptorImpl", "getSource"}));
    }

    public String toString() {
        return DescriptorRenderer.f26012e.mo5891a((AnnotationDescriptor) this, null);
    }
}
