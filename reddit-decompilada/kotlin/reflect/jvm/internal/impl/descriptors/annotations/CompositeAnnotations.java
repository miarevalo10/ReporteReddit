package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.sequences.SequencesKt___SequencesKt;

/* compiled from: Annotations.kt */
public final class CompositeAnnotations implements Annotations {
    private final List<Annotations> f36053b;

    public CompositeAnnotations(List<? extends Annotations> list) {
        Intrinsics.m26847b(list, "delegates");
        this.f36053b = list;
    }

    public CompositeAnnotations(Annotations... annotationsArr) {
        Intrinsics.m26847b(annotationsArr, "delegates");
        this(ArraysKt___ArraysKt.m36109i((Object[]) annotationsArr));
    }

    public final boolean mo6680a() {
        for (Annotations a : this.f36053b) {
            if (!a.mo6680a()) {
                return false;
            }
        }
        return true;
    }

    public final boolean mo6682b(FqName fqName) {
        Intrinsics.m26847b(fqName, "fqName");
        Iterator a = CollectionsKt___CollectionsKt.m41455t(this.f36053b).mo5679a();
        while (a.hasNext()) {
            if (((Annotations) a.next()).mo6682b(fqName)) {
                return true;
            }
        }
        return null;
    }

    public final AnnotationDescriptor mo6679a(FqName fqName) {
        Intrinsics.m26847b(fqName, "fqName");
        return (AnnotationDescriptor) SequencesKt___SequencesKt.m33704a(SequencesKt___SequencesKt.m33718f(CollectionsKt___CollectionsKt.m41455t(this.f36053b), new CompositeAnnotations$findAnnotation$1(fqName)));
    }

    public final List<AnnotationWithTarget> mo6681b() {
        Collection arrayList = new ArrayList();
        for (Annotations b : this.f36053b) {
            CollectionsKt__MutableCollectionsKt.m38194a(arrayList, (Iterable) b.mo6681b());
        }
        return (List) arrayList;
    }

    public final List<AnnotationWithTarget> mo6683c() {
        Collection arrayList = new ArrayList();
        for (Annotations c : this.f36053b) {
            CollectionsKt__MutableCollectionsKt.m38194a(arrayList, (Iterable) c.mo6683c());
        }
        return (List) arrayList;
    }

    public final Iterator<AnnotationDescriptor> iterator() {
        return SequencesKt___SequencesKt.m33714d(CollectionsKt___CollectionsKt.m41455t(this.f36053b), CompositeAnnotations$iterator$1.f38331a).mo5679a();
    }
}
