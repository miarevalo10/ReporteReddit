package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: LazyJavaStaticScope.kt */
public abstract class LazyJavaStaticScope extends LazyJavaScope {
    protected void mo7262a(Name name, Collection<PropertyDescriptor> collection) {
        Intrinsics.m26847b(name, "name");
        Intrinsics.m26847b(collection, "result");
    }

    public final /* bridge */ /* synthetic */ ReceiverParameterDescriptor mo7267d() {
        return null;
    }

    public LazyJavaStaticScope(LazyJavaResolverContext lazyJavaResolverContext) {
        Intrinsics.m26847b(lazyJavaResolverContext, "c");
        super(lazyJavaResolverContext);
    }

    protected final MethodSignatureData mo7260a(JavaMethod javaMethod, List<? extends TypeParameterDescriptor> list, KotlinType kotlinType, List<? extends ValueParameterDescriptor> list2) {
        Intrinsics.m26847b(javaMethod, "method");
        Intrinsics.m26847b(list, "methodTypeParameters");
        Intrinsics.m26847b(kotlinType, "returnType");
        Intrinsics.m26847b(list2, "valueParameters");
        return new MethodSignatureData(kotlinType, null, list2, list, false, CollectionsKt__CollectionsKt.m26790a());
    }
}
