package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;

/* compiled from: Annotations.kt */
public final class FilteredAnnotations implements Annotations {
    private final Annotations f36054b;
    private final Function1<FqName, Boolean> f36055c;

    public FilteredAnnotations(Annotations annotations, Function1<? super FqName, Boolean> function1) {
        Intrinsics.m26847b(annotations, "delegate");
        Intrinsics.m26847b(function1, "fqNameFilter");
        this.f36054b = annotations;
        this.f36055c = function1;
    }

    public final boolean mo6682b(FqName fqName) {
        Intrinsics.m26847b(fqName, "fqName");
        return ((Boolean) this.f36055c.mo6492a(fqName)).booleanValue() ? this.f36054b.mo6682b(fqName) : null;
    }

    public final AnnotationDescriptor mo6679a(FqName fqName) {
        Intrinsics.m26847b(fqName, "fqName");
        return ((Boolean) this.f36055c.mo6492a(fqName)).booleanValue() ? this.f36054b.mo6679a(fqName) : null;
    }

    public final List<AnnotationWithTarget> mo6681b() {
        Collection arrayList = new ArrayList();
        for (Object next : this.f36054b.mo6681b()) {
            if (m36222a(((AnnotationWithTarget) next).f25535a)) {
                arrayList.add(next);
            }
        }
        return (List) arrayList;
    }

    public final List<AnnotationWithTarget> mo6683c() {
        Collection arrayList = new ArrayList();
        for (Object next : this.f36054b.mo6683c()) {
            if (m36222a(((AnnotationWithTarget) next).f25535a)) {
                arrayList.add(next);
            }
        }
        return (List) arrayList;
    }

    public final Iterator<AnnotationDescriptor> iterator() {
        Collection arrayList = new ArrayList();
        for (Object next : this.f36054b) {
            if (m36222a((AnnotationDescriptor) next)) {
                arrayList.add(next);
            }
        }
        return ((List) arrayList).iterator();
    }

    private final boolean m36222a(AnnotationDescriptor annotationDescriptor) {
        annotationDescriptor = annotationDescriptor.mo5719a().mo6743g().mo5724c();
        if (annotationDescriptor != null) {
            FqNameUnsafe c = DescriptorUtils.m27653c((DeclarationDescriptor) annotationDescriptor);
            if (c.m27419c()) {
                Function1 function1 = this.f36055c;
                Object d = c.m27420d();
                Intrinsics.m26843a(d, "fqName.toSafe()");
                if (((Boolean) function1.mo6492a(d)).booleanValue() != null) {
                    annotationDescriptor = 1;
                    if (annotationDescriptor == null) {
                        return true;
                    }
                }
            }
            annotationDescriptor = null;
            if (annotationDescriptor == null) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final boolean mo6680a() {
        return !iterator().hasNext();
    }
}
