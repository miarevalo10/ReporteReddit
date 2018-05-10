package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;

/* compiled from: descriptorUtil.kt */
public final class DescriptorUtilKt {
    public static final ClassDescriptor m27058a(ModuleDescriptor moduleDescriptor, FqName fqName, LookupLocation lookupLocation) {
        Intrinsics.m26847b(moduleDescriptor, "$receiver");
        Intrinsics.m26847b(fqName, "fqName");
        Intrinsics.m26847b(lookupLocation, "lookupLocation");
        if (fqName.f25856b.f25861b.isEmpty()) {
            return null;
        }
        FqName d = fqName.m27411d();
        Intrinsics.m26843a((Object) d, "fqName.parent()");
        MemberScope c = moduleDescriptor.mo7087a(d).mo7081c();
        Object e = fqName.m27412e();
        Intrinsics.m26843a(e, "fqName.shortName()");
        ClassifierDescriptor c2 = c.mo6699c(e, lookupLocation);
        if (!(c2 instanceof ClassDescriptor)) {
            c2 = null;
        }
        ClassDescriptor classDescriptor = (ClassDescriptor) c2;
        if (classDescriptor != null) {
            return classDescriptor;
        }
        Object d2 = fqName.m27411d();
        Intrinsics.m26843a(d2, "fqName.parent()");
        moduleDescriptor = m27058a(moduleDescriptor, d2, lookupLocation);
        if (moduleDescriptor != null) {
            moduleDescriptor = moduleDescriptor.mo7739t();
            if (moduleDescriptor != null) {
                Object e2 = fqName.m27412e();
                Intrinsics.m26843a(e2, "fqName.shortName()");
                moduleDescriptor = moduleDescriptor.mo6699c(e2, lookupLocation);
                if ((moduleDescriptor instanceof ClassDescriptor) == null) {
                    moduleDescriptor = null;
                }
                return (ClassDescriptor) moduleDescriptor;
            }
        }
        moduleDescriptor = null;
        if ((moduleDescriptor instanceof ClassDescriptor) == null) {
            moduleDescriptor = null;
        }
        return (ClassDescriptor) moduleDescriptor;
    }
}
