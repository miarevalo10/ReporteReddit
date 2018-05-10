package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JavaDescriptorResolver;

/* compiled from: ModuleClassResolver.kt */
public final class SingleModuleClassResolver implements ModuleClassResolver {
    public JavaDescriptorResolver f32712a;

    public final ClassDescriptor mo5780a(JavaClass javaClass) {
        Intrinsics.m26847b(javaClass, "javaClass");
        JavaDescriptorResolver javaDescriptorResolver = this.f32712a;
        if (javaDescriptorResolver == null) {
            Intrinsics.m26844a("resolver");
        }
        return javaDescriptorResolver.m27747a(javaClass);
    }
}
