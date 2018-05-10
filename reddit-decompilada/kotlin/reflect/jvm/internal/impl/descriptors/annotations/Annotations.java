package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* compiled from: Annotations.kt */
public interface Annotations extends Iterable<AnnotationDescriptor>, KMappedMarker {
    public static final Companion f32643a = new Companion();

    /* compiled from: Annotations.kt */
    public static final class Companion {
        private static final Annotations f25537a = null;

        private Companion() {
            f25537a = new Annotations$Companion$EMPTY$1();
        }

        public static Annotations m27115a() {
            return f25537a;
        }

        public static AnnotationDescriptor m27114a(Annotations annotations, AnnotationUseSiteTarget annotationUseSiteTarget, FqName fqName) {
            Intrinsics.m26847b(annotations, "annotations");
            Intrinsics.m26847b(annotationUseSiteTarget, "target");
            Intrinsics.m26847b(fqName, "fqName");
            Iterable<AnnotationWithTarget> b = annotations.mo6681b();
            ArrayList arrayList = new ArrayList();
            for (AnnotationWithTarget annotationWithTarget : b) {
                arrayList = arrayList;
                if (Intrinsics.m26845a((Object) annotationUseSiteTarget, annotationWithTarget.f25536b)) {
                    arrayList.add(annotationWithTarget.f25535a);
                }
            }
            for (AnnotationUseSiteTarget annotationUseSiteTarget2 : arrayList) {
                if (AnnotationsKt.m27118a((AnnotationDescriptor) annotationUseSiteTarget2, fqName)) {
                    break;
                }
            }
            annotationUseSiteTarget2 = null;
            return (AnnotationDescriptor) annotationUseSiteTarget2;
        }
    }

    /* compiled from: Annotations.kt */
    public static final class DefaultImpls {
        public static boolean m27116a(Annotations annotations, FqName fqName) {
            Intrinsics.m26847b(fqName, "fqName");
            return annotations.mo6679a(fqName) != null ? true : null;
        }
    }

    AnnotationDescriptor mo6679a(FqName fqName);

    boolean mo6680a();

    List<AnnotationWithTarget> mo6681b();

    boolean mo6682b(FqName fqName);

    List<AnnotationWithTarget> mo6683c();
}
