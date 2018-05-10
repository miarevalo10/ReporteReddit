package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.List;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;

/* compiled from: findClassInModule.kt */
public final class FindClassInModuleKt {
    public static final ClassDescriptor m27838a(ModuleDescriptor moduleDescriptor, ClassId classId) {
        Intrinsics.m26847b(moduleDescriptor, "$receiver");
        Intrinsics.m26847b(classId, "classId");
        FqName a = classId.m27398a();
        Intrinsics.m26843a((Object) a, "classId.packageFqName");
        moduleDescriptor = moduleDescriptor.mo7087a(a);
        classId = classId.m27399b().m27414g();
        moduleDescriptor = moduleDescriptor.mo7081c();
        Object d = CollectionsKt___CollectionsKt.m41430d((List) classId);
        Intrinsics.m26843a(d, "segments.first()");
        moduleDescriptor = moduleDescriptor.mo6699c((Name) d, NoLookupLocation.f32688r);
        if (!(moduleDescriptor instanceof ClassDescriptor)) {
            moduleDescriptor = null;
        }
        moduleDescriptor = (ClassDescriptor) moduleDescriptor;
        if (moduleDescriptor == null) {
            return null;
        }
        for (Object d2 : classId.subList(1, classId.size())) {
            moduleDescriptor = moduleDescriptor.mo7739t();
            Intrinsics.m26843a(d2, "name");
            moduleDescriptor = moduleDescriptor.mo6699c(d2, NoLookupLocation.f32688r);
            if (!(moduleDescriptor instanceof ClassDescriptor)) {
                moduleDescriptor = null;
            }
            ClassDescriptor classDescriptor = (ClassDescriptor) moduleDescriptor;
            if (classDescriptor == null) {
                return null;
            }
        }
        return moduleDescriptor;
    }

    public static final ClassDescriptor m27839a(ModuleDescriptor moduleDescriptor, ClassId classId, NotFoundClasses notFoundClasses) {
        Intrinsics.m26847b(moduleDescriptor, "$receiver");
        Intrinsics.m26847b(classId, "classId");
        Intrinsics.m26847b(notFoundClasses, "notFoundClasses");
        moduleDescriptor = m27838a(moduleDescriptor, classId);
        if (moduleDescriptor != null) {
            return moduleDescriptor;
        }
        moduleDescriptor = notFoundClasses.m27860b(classId, SequencesKt___SequencesKt.m33713d(SequencesKt___SequencesKt.m33716e(SequencesKt__SequencesKt.m28142a(classId, (Function1) C2986x24bfe126.f38832a), C2987x24bfe127.f38833a))).mo5724c();
        if (moduleDescriptor != null) {
            return (ClassDescriptor) moduleDescriptor;
        }
        throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
    }

    public static final TypeAliasDescriptor m27840b(ModuleDescriptor moduleDescriptor, ClassId classId) {
        Intrinsics.m26847b(moduleDescriptor, "$receiver");
        Intrinsics.m26847b(classId, "classId");
        FqName a = classId.m27398a();
        Intrinsics.m26843a((Object) a, "classId.packageFqName");
        moduleDescriptor = moduleDescriptor.mo7087a(a);
        classId = classId.m27399b().m27414g();
        int size = classId.size() - 1;
        moduleDescriptor = moduleDescriptor.mo7081c();
        Object d = CollectionsKt___CollectionsKt.m41430d((List) classId);
        Intrinsics.m26843a(d, "segments.first()");
        moduleDescriptor = moduleDescriptor.mo6699c((Name) d, NoLookupLocation.f32688r);
        if (size == 0) {
            if ((moduleDescriptor instanceof TypeAliasDescriptor) == null) {
                moduleDescriptor = null;
            }
            return (TypeAliasDescriptor) moduleDescriptor;
        }
        if (!(moduleDescriptor instanceof ClassDescriptor)) {
            moduleDescriptor = null;
        }
        moduleDescriptor = (ClassDescriptor) moduleDescriptor;
        if (moduleDescriptor == null) {
            return null;
        }
        for (Object obj : classId.subList(1, size)) {
            moduleDescriptor = moduleDescriptor.mo7739t();
            Intrinsics.m26843a(obj, "name");
            moduleDescriptor = moduleDescriptor.mo6699c(obj, NoLookupLocation.f32688r);
            if (!(moduleDescriptor instanceof ClassDescriptor)) {
                moduleDescriptor = null;
            }
            ClassDescriptor classDescriptor = (ClassDescriptor) moduleDescriptor;
            if (classDescriptor == null) {
                return null;
            }
        }
        Object obj2 = (Name) classId.get(size);
        moduleDescriptor = moduleDescriptor.mo7768d();
        Intrinsics.m26843a(obj2, "lastName");
        moduleDescriptor = moduleDescriptor.mo6699c(obj2, NoLookupLocation.f32688r);
        if ((moduleDescriptor instanceof TypeAliasDescriptor) == null) {
            moduleDescriptor = null;
        }
        return (TypeAliasDescriptor) moduleDescriptor;
    }
}
