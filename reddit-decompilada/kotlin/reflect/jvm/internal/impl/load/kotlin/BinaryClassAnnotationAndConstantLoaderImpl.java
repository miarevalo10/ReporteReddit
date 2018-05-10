package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUseSiteTarget;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationWithTarget;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValueFactory;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* compiled from: BinaryClassAnnotationAndConstantLoaderImpl.kt */
public final class BinaryClassAnnotationAndConstantLoaderImpl extends AbstractBinaryClassAnnotationAndConstantLoader<AnnotationDescriptor, ConstantValue<?>, AnnotationWithTarget> {
    private final AnnotationDeserializer f36112b = new AnnotationDeserializer(this.f36114d, this.f36115e);
    private final ConstantValueFactory f36113c = new ConstantValueFactory(this.f36114d.mo7089b());
    private final ModuleDescriptor f36114d;
    private final NotFoundClasses f36115e;

    public final /* synthetic */ Object mo6718a(Annotation annotation, NameResolver nameResolver) {
        Intrinsics.m26847b(annotation, "proto");
        Intrinsics.m26847b(nameResolver, "nameResolver");
        return this.f36112b.m27813a(annotation, nameResolver);
    }

    public BinaryClassAnnotationAndConstantLoaderImpl(ModuleDescriptor moduleDescriptor, NotFoundClasses notFoundClasses, StorageManager storageManager, KotlinClassFinder kotlinClassFinder) {
        Intrinsics.m26847b(moduleDescriptor, "module");
        Intrinsics.m26847b(notFoundClasses, "notFoundClasses");
        Intrinsics.m26847b(storageManager, "storageManager");
        Intrinsics.m26847b(kotlinClassFinder, "kotlinClassFinder");
        super(storageManager, kotlinClassFinder);
        this.f36114d = moduleDescriptor;
        this.f36115e = notFoundClasses;
    }

    protected final List<AnnotationWithTarget> mo6720a(List<? extends AnnotationDescriptor> list, List<? extends AnnotationDescriptor> list2, AnnotationUseSiteTarget annotationUseSiteTarget) {
        Intrinsics.m26847b(list, "propertyAnnotations");
        Intrinsics.m26847b(list2, "fieldAnnotations");
        Intrinsics.m26847b(annotationUseSiteTarget, "fieldUseSiteTarget");
        Iterable<AnnotationDescriptor> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
        for (AnnotationDescriptor annotationWithTarget : iterable) {
            arrayList.add(new AnnotationWithTarget(annotationWithTarget, null));
        }
        arrayList = (List) arrayList;
        Iterable<AnnotationDescriptor> iterable2 = list2;
        Collection arrayList2 = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable2));
        for (AnnotationDescriptor annotationWithTarget2 : iterable2) {
            arrayList2.add(new AnnotationWithTarget(annotationWithTarget2, annotationUseSiteTarget));
        }
        return CollectionsKt___CollectionsKt.m41423b(arrayList, (Iterable) (List) arrayList2);
    }

    protected final List<AnnotationWithTarget> mo6719a(List<? extends AnnotationDescriptor> list) {
        Intrinsics.m26847b(list, "annotations");
        Iterable<AnnotationDescriptor> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
        for (AnnotationDescriptor annotationWithTarget : iterable) {
            arrayList.add(new AnnotationWithTarget(annotationWithTarget, null));
        }
        return (List) arrayList;
    }

    protected final AnnotationArgumentVisitor mo6721a(ClassId classId, SourceElement sourceElement, List<AnnotationDescriptor> list) {
        Intrinsics.m26847b(classId, "annotationClassId");
        Intrinsics.m26847b(sourceElement, "source");
        Intrinsics.m26847b(list, "result");
        return new BinaryClassAnnotationAndConstantLoaderImpl$loadAnnotation$1(this, m36300a(classId), list, sourceElement);
    }

    private final ClassDescriptor m36300a(ClassId classId) {
        return FindClassInModuleKt.m27839a(this.f36114d, classId, this.f36115e);
    }
}
