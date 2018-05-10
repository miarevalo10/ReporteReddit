package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.DefaultImpls;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;

/* compiled from: AnnotationsImpl.kt */
public final class AnnotationsImpl implements Annotations {
    public static final Companion f36050b = new Companion();
    private final List<AnnotationDescriptor> f36051c;
    private final List<AnnotationWithTarget> f36052d;

    /* compiled from: AnnotationsImpl.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    public final boolean mo6682b(FqName fqName) {
        Intrinsics.m26847b(fqName, "fqName");
        return DefaultImpls.m27116a(this, fqName);
    }

    public AnnotationsImpl(List<? extends AnnotationDescriptor> list) {
        Intrinsics.m26847b(list, "annotations");
        this.f36051c = list;
        Iterable<AnnotationDescriptor> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
        for (AnnotationDescriptor annotationWithTarget : iterable) {
            arrayList.add(new AnnotationWithTarget(annotationWithTarget, null));
        }
        this.f36052d = (List) arrayList;
    }

    public final boolean mo6680a() {
        return this.f36052d.isEmpty();
    }

    public final AnnotationDescriptor mo6679a(FqName fqName) {
        Intrinsics.m26847b(fqName, "fqName");
        for (Object next : this.f36051c) {
            Object obj;
            ClassifierDescriptor c = ((AnnotationDescriptor) next).mo5719a().mo6743g().mo5724c();
            if ((c instanceof ClassDescriptor) && Intrinsics.m26845a(fqName.m27409b(), DescriptorUtils.m27653c(c))) {
                obj = 1;
                continue;
            } else {
                obj = null;
                continue;
            }
            if (obj != null) {
                break;
            }
        }
        Object next2 = null;
        return (AnnotationDescriptor) next2;
    }

    public final List<AnnotationWithTarget> mo6681b() {
        Collection arrayList = new ArrayList();
        for (Object next : this.f36052d) {
            if ((((AnnotationWithTarget) next).f25536b != null ? 1 : null) != null) {
                arrayList.add(next);
            }
        }
        Iterable<AnnotationWithTarget> iterable = (List) arrayList;
        Collection arrayList2 = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
        for (AnnotationWithTarget annotationWithTarget : iterable) {
            AnnotationDescriptor annotationDescriptor = annotationWithTarget.f25535a;
            AnnotationUseSiteTarget annotationUseSiteTarget = annotationWithTarget.f25536b;
            if (annotationUseSiteTarget == null) {
                Intrinsics.m26842a();
            }
            arrayList2.add(new AnnotationWithTarget(annotationDescriptor, annotationUseSiteTarget));
        }
        return (List) arrayList2;
    }

    public final List<AnnotationWithTarget> mo6683c() {
        return this.f36052d;
    }

    public final Iterator<AnnotationDescriptor> iterator() {
        return this.f36051c.iterator();
    }

    public final String toString() {
        return this.f36051c.toString();
    }
}
