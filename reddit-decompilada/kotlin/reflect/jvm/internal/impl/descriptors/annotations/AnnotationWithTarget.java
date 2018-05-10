package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnnotationWithTarget.kt */
public final class AnnotationWithTarget {
    public final AnnotationDescriptor f25535a;
    public final AnnotationUseSiteTarget f25536b;

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof AnnotationWithTarget) {
                AnnotationWithTarget annotationWithTarget = (AnnotationWithTarget) obj;
                if (Intrinsics.m26845a(this.f25535a, annotationWithTarget.f25535a) && Intrinsics.m26845a(this.f25536b, annotationWithTarget.f25536b)) {
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        AnnotationDescriptor annotationDescriptor = this.f25535a;
        int i = 0;
        int hashCode = (annotationDescriptor != null ? annotationDescriptor.hashCode() : 0) * 31;
        AnnotationUseSiteTarget annotationUseSiteTarget = this.f25536b;
        if (annotationUseSiteTarget != null) {
            i = annotationUseSiteTarget.hashCode();
        }
        return hashCode + i;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("AnnotationWithTarget(annotation=");
        stringBuilder.append(this.f25535a);
        stringBuilder.append(", target=");
        stringBuilder.append(this.f25536b);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public AnnotationWithTarget(AnnotationDescriptor annotationDescriptor, AnnotationUseSiteTarget annotationUseSiteTarget) {
        Intrinsics.m26847b(annotationDescriptor, "annotation");
        this.f25535a = annotationDescriptor;
        this.f25536b = annotationUseSiteTarget;
    }
}
