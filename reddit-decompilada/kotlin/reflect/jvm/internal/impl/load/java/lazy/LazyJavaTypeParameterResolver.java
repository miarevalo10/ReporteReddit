package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaTypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameterListOwner;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;

/* compiled from: resolvers.kt */
public final class LazyJavaTypeParameterResolver implements TypeParameterResolver {
    private final Map<JavaTypeParameter, Integer> f32707a;
    private final MemoizedFunctionToNullable<JavaTypeParameter, LazyJavaTypeParameterDescriptor> f32708b = this.f32709c.f25703b.f25685a.mo5930b((Function1) new LazyJavaTypeParameterResolver$resolve$1(this));
    private final LazyJavaResolverContext f32709c;
    private final DeclarationDescriptor f32710d;
    private final int f32711e;

    public LazyJavaTypeParameterResolver(LazyJavaResolverContext lazyJavaResolverContext, DeclarationDescriptor declarationDescriptor, JavaTypeParameterListOwner javaTypeParameterListOwner, int i) {
        Intrinsics.m26847b(lazyJavaResolverContext, "c");
        Intrinsics.m26847b(declarationDescriptor, "containingDeclaration");
        Intrinsics.m26847b(javaTypeParameterListOwner, "typeParameterOwner");
        this.f32709c = lazyJavaResolverContext;
        this.f32710d = declarationDescriptor;
        this.f32711e = i;
        this.f32707a = CollectionsKt.m28090a((Iterable) javaTypeParameterListOwner.mo7284q());
    }

    public final TypeParameterDescriptor mo5779a(JavaTypeParameter javaTypeParameter) {
        Intrinsics.m26847b(javaTypeParameter, "javaTypeParameter");
        LazyJavaTypeParameterDescriptor lazyJavaTypeParameterDescriptor = (LazyJavaTypeParameterDescriptor) this.f32708b.mo6492a(javaTypeParameter);
        if (lazyJavaTypeParameterDescriptor != null) {
            return lazyJavaTypeParameterDescriptor;
        }
        return this.f32709c.f25704c.mo5779a(javaTypeParameter);
    }
}
