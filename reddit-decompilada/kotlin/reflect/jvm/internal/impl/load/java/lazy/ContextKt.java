package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameterListOwner;

/* compiled from: context.kt */
public final class ContextKt {
    public static final LazyJavaResolverContext m27200a(LazyJavaResolverContext lazyJavaResolverContext, TypeParameterResolver typeParameterResolver) {
        Intrinsics.m26847b(lazyJavaResolverContext, "$receiver");
        Intrinsics.m26847b(typeParameterResolver, "typeParameterResolver");
        return new LazyJavaResolverContext(lazyJavaResolverContext.f25703b, typeParameterResolver);
    }

    public static final LazyJavaResolverContext m27199a(LazyJavaResolverContext lazyJavaResolverContext, JavaResolverComponents javaResolverComponents) {
        Intrinsics.m26847b(lazyJavaResolverContext, "$receiver");
        Intrinsics.m26847b(javaResolverComponents, "components");
        return new LazyJavaResolverContext(javaResolverComponents, lazyJavaResolverContext.f25704c);
    }

    public static final LazyJavaResolverContext m27198a(LazyJavaResolverContext lazyJavaResolverContext, DeclarationDescriptor declarationDescriptor, JavaTypeParameterListOwner javaTypeParameterListOwner, int i) {
        Intrinsics.m26847b(lazyJavaResolverContext, "$receiver");
        Intrinsics.m26847b(declarationDescriptor, "containingDeclaration");
        Intrinsics.m26847b(javaTypeParameterListOwner, "typeParameterOwner");
        return m27200a(lazyJavaResolverContext, (TypeParameterResolver) new LazyJavaTypeParameterResolver(lazyJavaResolverContext, declarationDescriptor, javaTypeParameterListOwner, i));
    }
}
