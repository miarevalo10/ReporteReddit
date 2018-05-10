package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;

/* compiled from: CompanionObjectMapping.kt */
public final class CompanionObjectMapping {
    public static final CompanionObjectMapping f25352a = null;
    private static final LinkedHashSet<ClassId> f25353b = null;

    static {
        CompanionObjectMapping companionObjectMapping = new CompanionObjectMapping();
    }

    private CompanionObjectMapping() {
        f25352a = this;
        Iterable<PrimitiveType> iterable = PrimitiveType.f25436i;
        Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
        for (PrimitiveType b : iterable) {
            arrayList.add(KotlinBuiltIns.m26978b(b));
        }
        Iterable<FqName> a = CollectionsKt___CollectionsKt.m41419a((Collection) CollectionsKt___CollectionsKt.m41419a((Collection) (List) arrayList, (Object) KotlinBuiltIns.f25420j.f25386g.m27420d()), (Object) KotlinBuiltIns.f25420j.f25397r.m27420d());
        arrayList = new LinkedHashSet();
        for (FqName a2 : a) {
            arrayList.add(ClassId.m27396a(a2));
        }
        f25353b = (LinkedHashSet) arrayList;
    }

    public static Set<ClassId> m26942a() {
        Object unmodifiableSet = Collections.unmodifiableSet(f25353b);
        Intrinsics.m26843a(unmodifiableSet, "Collections.unmodifiableSet(classIds)");
        return unmodifiableSet;
    }

    public static boolean m26943a(ClassDescriptor classDescriptor) {
        Intrinsics.m26847b(classDescriptor, "classDescriptor");
        if (DescriptorUtils.m27657g(classDescriptor)) {
            Iterable iterable = f25353b;
            classDescriptor = DescriptorUtilsKt.m27736a((ClassifierDescriptorWithTypeParameters) classDescriptor);
            if (CollectionsKt___CollectionsKt.m41420a(iterable, (Object) classDescriptor != null ? classDescriptor.m27401d() : null) != null) {
                return true;
            }
        }
        return null;
    }
}
