package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolver;

/* compiled from: context.kt */
public final class LazyJavaResolverContext {
    public final JavaTypeResolver f25702a = new JavaTypeResolver(this, this.f25704c);
    public final JavaResolverComponents f25703b;
    public final TypeParameterResolver f25704c;

    public LazyJavaResolverContext(JavaResolverComponents javaResolverComponents, TypeParameterResolver typeParameterResolver) {
        Intrinsics.m26847b(javaResolverComponents, "components");
        Intrinsics.m26847b(typeParameterResolver, "typeParameterResolver");
        this.f25703b = javaResolverComponents;
        this.f25704c = typeParameterResolver;
    }
}
