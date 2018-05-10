package kotlin.reflect.jvm.internal.impl.load.kotlin.reflect;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.PackagePartProvider;
import kotlin.reflect.jvm.internal.impl.load.kotlin.ModuleMapping;
import kotlin.reflect.jvm.internal.impl.load.kotlin.PackageParts;

/* compiled from: RuntimePackagePartProvider.kt */
public final class RuntimePackagePartProvider implements PackagePartProvider {
    public final ConcurrentHashMap<String, ModuleMapping> f32851a = new ConcurrentHashMap();
    public final ClassLoader f32852b;

    public RuntimePackagePartProvider(ClassLoader classLoader) {
        Intrinsics.m26847b(classLoader, "classLoader");
        this.f32852b = classLoader;
    }

    public final List<String> mo5856a(String str) {
        Intrinsics.m26847b(str, "packageFqName");
        Collection arrayList = new ArrayList();
        for (ModuleMapping moduleMapping : this.f32851a.values()) {
            Intrinsics.m26847b(str, "packageFqName");
            PackageParts packageParts = (PackageParts) moduleMapping.f25805a.get(str);
            if (packageParts != null) {
                arrayList.add(packageParts);
            }
        }
        Collection collection = (Collection) new ArrayList();
        for (PackageParts a : (List) arrayList) {
            CollectionsKt__MutableCollectionsKt.m38194a(collection, (Iterable) a.m27356a());
        }
        return CollectionsKt___CollectionsKt.m41453r((List) collection);
    }
}
