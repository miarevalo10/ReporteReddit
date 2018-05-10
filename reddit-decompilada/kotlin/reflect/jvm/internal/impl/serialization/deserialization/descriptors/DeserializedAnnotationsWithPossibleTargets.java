package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationWithTarget;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.DefaultImpls;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.sequences.SequencesKt___SequencesKt;

/* compiled from: DeserializedAnnotations.kt */
public class DeserializedAnnotationsWithPossibleTargets implements Annotations {
    private final NotNullLazyValue<List<AnnotationWithTarget>> f36165b;

    public DeserializedAnnotationsWithPossibleTargets(StorageManager storageManager, Function0<? extends List<AnnotationWithTarget>> function0) {
        Intrinsics.m26847b(storageManager, "storageManager");
        Intrinsics.m26847b(function0, "compute");
        this.f36165b = storageManager.mo5926a((Function0) new DeserializedAnnotationsWithPossibleTargets$annotations$1(function0));
    }

    public final boolean mo6682b(FqName fqName) {
        Intrinsics.m26847b(fqName, "fqName");
        return DefaultImpls.m27116a(this, fqName);
    }

    public final boolean mo6680a() {
        return ((List) this.f36165b.invoke()).isEmpty();
    }

    public final AnnotationDescriptor mo6679a(FqName fqName) {
        Intrinsics.m26847b(fqName, "fqName");
        for (Object next : (Iterable) this.f36165b.invoke()) {
            Object obj;
            AnnotationWithTarget annotationWithTarget = (AnnotationWithTarget) next;
            if (annotationWithTarget.f25536b == null) {
                ClassifierDescriptor c = annotationWithTarget.f25535a.mo5719a().mo6743g().mo5724c();
                if ((c instanceof ClassDescriptor) && Intrinsics.m26845a(fqName.m27409b(), DescriptorUtils.m27653c(c))) {
                    obj = 1;
                    continue;
                    if (obj != null) {
                        break;
                    }
                }
            }
            obj = null;
            continue;
            if (obj != null) {
                break;
            }
        }
        Object next2 = null;
        AnnotationWithTarget annotationWithTarget2 = (AnnotationWithTarget) next2;
        if (annotationWithTarget2 != null) {
            return annotationWithTarget2.f25535a;
        }
        return null;
    }

    public final List<AnnotationWithTarget> mo6681b() {
        Collection arrayList = new ArrayList();
        for (Object next : (Iterable) this.f36165b.invoke()) {
            if ((((AnnotationWithTarget) next).f25536b != null ? 1 : null) != null) {
                arrayList.add(next);
            }
        }
        return (List) arrayList;
    }

    public final List<AnnotationWithTarget> mo6683c() {
        return (List) this.f36165b.invoke();
    }

    public Iterator<AnnotationDescriptor> iterator() {
        return SequencesKt___SequencesKt.m33716e(SequencesKt___SequencesKt.m33708a(CollectionsKt___CollectionsKt.m41455t((Iterable) this.f36165b.invoke()), (Function1) DeserializedAnnotationsWithPossibleTargets$iterator$1.f38869a), DeserializedAnnotationsWithPossibleTargets$iterator$2.f38870a).mo5679a();
    }
}
