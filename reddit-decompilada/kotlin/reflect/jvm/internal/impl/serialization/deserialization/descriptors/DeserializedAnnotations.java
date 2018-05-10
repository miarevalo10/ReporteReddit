package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationWithTarget;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* compiled from: DeserializedAnnotations.kt */
public final class DeserializedAnnotations extends DeserializedAnnotationsWithPossibleTargets {
    public DeserializedAnnotations(StorageManager storageManager, final Function0<? extends List<? extends AnnotationDescriptor>> function0) {
        Intrinsics.m26847b(storageManager, "storageManager");
        Intrinsics.m26847b(function0, "compute");
        super(storageManager, new Function0<List<? extends AnnotationWithTarget>>() {
            public final /* synthetic */ Object invoke() {
                Iterable<AnnotationDescriptor> iterable = (Iterable) function0.invoke();
                Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
                for (AnnotationDescriptor annotationWithTarget : iterable) {
                    arrayList.add(new AnnotationWithTarget(annotationWithTarget, null));
                }
                return (List) arrayList;
            }
        });
    }
}
