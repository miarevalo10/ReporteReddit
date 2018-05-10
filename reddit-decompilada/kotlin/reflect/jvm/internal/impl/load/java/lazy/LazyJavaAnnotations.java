package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationWithTarget;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.DefaultImpls;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaAnnotationMapper;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;

/* compiled from: LazyJavaAnnotations.kt */
public final class LazyJavaAnnotations implements Annotations {
    private final MemoizedFunctionToNullable<JavaAnnotation, AnnotationDescriptor> f36088b = this.f36089c.f25703b.f25685a.mo5930b((Function1) new LazyJavaAnnotations$annotationDescriptors$1(this));
    private final LazyJavaResolverContext f36089c;
    private final JavaAnnotationOwner f36090d;

    public LazyJavaAnnotations(LazyJavaResolverContext lazyJavaResolverContext, JavaAnnotationOwner javaAnnotationOwner) {
        Intrinsics.m26847b(lazyJavaResolverContext, "c");
        Intrinsics.m26847b(javaAnnotationOwner, "annotationOwner");
        this.f36089c = lazyJavaResolverContext;
        this.f36090d = javaAnnotationOwner;
    }

    public final boolean mo6682b(FqName fqName) {
        Intrinsics.m26847b(fqName, "fqName");
        return DefaultImpls.m27116a(this, fqName);
    }

    public final AnnotationDescriptor mo6679a(FqName fqName) {
        Intrinsics.m26847b(fqName, "fqName");
        JavaAnnotation a = this.f36090d.mo7092a(fqName);
        if (a != null) {
            AnnotationDescriptor annotationDescriptor = (AnnotationDescriptor) this.f36088b.mo6492a(a);
            if (annotationDescriptor != null) {
                return annotationDescriptor;
            }
        }
        JavaAnnotationMapper javaAnnotationMapper = JavaAnnotationMapper.f25649a;
        return JavaAnnotationMapper.m27182a(fqName, this.f36090d, this.f36089c);
    }

    public final List<AnnotationWithTarget> mo6681b() {
        return CollectionsKt__CollectionsKt.m26790a();
    }

    public final List<AnnotationWithTarget> mo6683c() {
        Iterable<AnnotationDescriptor> iterable = this;
        Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
        for (AnnotationDescriptor annotationWithTarget : iterable) {
            arrayList.add(new AnnotationWithTarget(annotationWithTarget, null));
        }
        return (List) arrayList;
    }

    public final Iterator<AnnotationDescriptor> iterator() {
        Sequence e = SequencesKt___SequencesKt.m33716e(CollectionsKt___CollectionsKt.m41455t(this.f36090d.mo7091a()), this.f36088b);
        JavaAnnotationMapper javaAnnotationMapper = JavaAnnotationMapper.f25649a;
        Object obj = KotlinBuiltIns.f25420j.f25403x;
        Intrinsics.m26843a(obj, "KotlinBuiltIns.FQ_NAMES.deprecated");
        return SequencesKt___SequencesKt.m33711c(SequencesKt___SequencesKt.m33707a(e, (Object) JavaAnnotationMapper.m27182a(obj, this.f36090d, this.f36089c))).mo5679a();
    }

    public final boolean mo6680a() {
        return !iterator().hasNext();
    }
}
