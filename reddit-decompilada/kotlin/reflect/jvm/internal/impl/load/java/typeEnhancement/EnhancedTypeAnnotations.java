package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationWithTarget;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.DefaultImpls;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* compiled from: typeEnhancement.kt */
final class EnhancedTypeAnnotations implements Annotations {
    private final FqName f36110b;

    public final boolean mo6680a() {
        return false;
    }

    public EnhancedTypeAnnotations(FqName fqName) {
        Intrinsics.m26847b(fqName, "fqNameToMatch");
        this.f36110b = fqName;
    }

    public final /* synthetic */ AnnotationDescriptor mo6679a(FqName fqName) {
        Intrinsics.m26847b(fqName, "fqName");
        return (AnnotationDescriptor) (Intrinsics.m26845a((Object) fqName, this.f36110b) != null ? EnhancedTypeAnnotationDescriptor.f32759a : null);
    }

    public final boolean mo6682b(FqName fqName) {
        Intrinsics.m26847b(fqName, "fqName");
        return DefaultImpls.m27116a(this, fqName);
    }

    public final List<AnnotationWithTarget> mo6683c() {
        Iterable<AnnotationDescriptor> iterable = this;
        Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
        for (AnnotationDescriptor annotationWithTarget : iterable) {
            arrayList.add(new AnnotationWithTarget(annotationWithTarget, null));
        }
        return (List) arrayList;
    }

    public final List<AnnotationWithTarget> mo6681b() {
        return CollectionsKt__CollectionsKt.m26790a();
    }

    public final Iterator<AnnotationDescriptor> iterator() {
        return CollectionsKt__CollectionsKt.m26790a().iterator();
    }
}
