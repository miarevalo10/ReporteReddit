package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractLazyTypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotations;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolverKt;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* compiled from: LazyJavaTypeParameterDescriptor.kt */
public final class LazyJavaTypeParameterDescriptor extends AbstractLazyTypeParameterDescriptor {
    private final LazyJavaAnnotations f40862b = new LazyJavaAnnotations(this.f40863c, (JavaAnnotationOwner) this.f40864d);
    private final LazyJavaResolverContext f40863c;
    private final JavaTypeParameter f40864d;

    protected final void mo7774a(KotlinType kotlinType) {
        Intrinsics.m26847b(kotlinType, "type");
    }

    protected final List<KotlinType> mo7775m() {
        Collection b = this.f40864d.mo7292b();
        if (b.isEmpty()) {
            Object m = this.f40863c.f25703b.f25700p.mo7089b().m27015m();
            Intrinsics.m26843a(m, "c.module.builtIns.anyType");
            Object n = this.f40863c.f25703b.f25700p.mo7089b().m27016n();
            Intrinsics.m26843a(n, "c.module.builtIns.nullableAnyType");
            return CollectionsKt__CollectionsKt.m26791a((Object) KotlinTypeFactory.m27953a(m, n));
        }
        Iterable<JavaClassifierType> iterable = b;
        Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
        for (JavaClassifierType a : iterable) {
            arrayList.add(this.f40863c.f25702a.m27225a((JavaType) a, JavaTypeResolverKt.m27226a(TypeUsage.UPPER_BOUND, false, false, this, 3)));
        }
        return (List) arrayList;
    }

    public final /* bridge */ /* synthetic */ Annotations mo5718q() {
        return this.f40862b;
    }

    public LazyJavaTypeParameterDescriptor(LazyJavaResolverContext lazyJavaResolverContext, JavaTypeParameter javaTypeParameter, int i, DeclarationDescriptor declarationDescriptor) {
        Intrinsics.m26847b(lazyJavaResolverContext, "c");
        Intrinsics.m26847b(javaTypeParameter, "javaTypeParameter");
        Intrinsics.m26847b(declarationDescriptor, "containingDeclaration");
        super(lazyJavaResolverContext.f25703b.f25685a, declarationDescriptor, javaTypeParameter.mo7103p(), Variance.f26337a, false, i, SourceElement.f25498a, lazyJavaResolverContext.f25703b.f25698n);
        this.f40863c = lazyJavaResolverContext;
        this.f40864d = javaTypeParameter;
    }
}
