package kotlin.reflect.jvm.internal.impl.types;

import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUseSiteTarget;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationWithTarget;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.text.StringsKt__StringBuilderKt;

/* compiled from: KotlinType.kt */
public abstract class SimpleType extends UnwrappedType {
    public abstract SimpleType mo7296b(Annotations annotations);

    public abstract SimpleType mo7297b(boolean z);

    public SimpleType() {
        super();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (AnnotationWithTarget annotationWithTarget : mo5718q().mo6683c()) {
            AnnotationDescriptor annotationDescriptor = annotationWithTarget.f25535a;
            AnnotationUseSiteTarget annotationUseSiteTarget = annotationWithTarget.f25536b;
            StringsKt__StringBuilderKt.m38740a(stringBuilder, "[", DescriptorRenderer.f26014g.mo5891a(annotationDescriptor, annotationUseSiteTarget), "] ");
        }
        stringBuilder.append(mo6743g());
        if (!mo6739a().isEmpty()) {
            CollectionsKt___CollectionsKt.m41410a(mo6739a(), stringBuilder, ", ", Operation.LESS_THAN, Operation.GREATER_THAN, 0, null, null, 112);
        }
        if (mo6741c()) {
            stringBuilder.append(Operation.EMPTY_PARAM);
        }
        Object stringBuilder2 = stringBuilder.toString();
        Intrinsics.m26843a(stringBuilder2, "StringBuilder().apply(builderAction).toString()");
        return stringBuilder2;
    }
}
