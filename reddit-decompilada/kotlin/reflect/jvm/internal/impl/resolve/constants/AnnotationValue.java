package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: constantValues.kt */
public final class AnnotationValue extends ConstantValue<AnnotationDescriptor> {
    public AnnotationValue(AnnotationDescriptor annotationDescriptor) {
        Intrinsics.m26847b(annotationDescriptor, "value");
        super(annotationDescriptor);
    }

    public final KotlinType mo5917a() {
        Object a = ((AnnotationDescriptor) mo5919b()).mo5719a();
        Intrinsics.m26843a(a, "value.type");
        return a;
    }

    public final String toString() {
        return mo5919b().toString();
    }
}
