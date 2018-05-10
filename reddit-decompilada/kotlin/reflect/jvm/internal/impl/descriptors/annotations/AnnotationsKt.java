package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;

/* compiled from: Annotations.kt */
public final class AnnotationsKt {
    public static final boolean m27118a(AnnotationDescriptor annotationDescriptor, FqName fqName) {
        Intrinsics.m26847b(annotationDescriptor, "annotation");
        Intrinsics.m26847b(fqName, "fqName");
        annotationDescriptor = annotationDescriptor.mo5719a().mo6743g().mo5724c();
        return (!(annotationDescriptor instanceof ClassDescriptor) || Intrinsics.m26845a(fqName.m27409b(), DescriptorUtils.m27653c((DeclarationDescriptor) annotationDescriptor)) == null) ? null : true;
    }

    public static final Annotations m27117a(Annotations annotations, Annotations annotations2) {
        Intrinsics.m26847b(annotations, "first");
        Intrinsics.m26847b(annotations2, "second");
        if (annotations.mo6680a()) {
            return annotations2;
        }
        if (annotations2.mo6680a()) {
            return annotations;
        }
        return new CompositeAnnotations(annotations, annotations2);
    }
}
