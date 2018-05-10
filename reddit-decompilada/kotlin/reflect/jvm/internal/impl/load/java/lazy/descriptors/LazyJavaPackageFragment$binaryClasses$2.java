package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.PackagePartProvider;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: LazyJavaPackageFragment.kt */
final class LazyJavaPackageFragment$binaryClasses$2 extends Lambda implements Function0<Map<String, ? extends KotlinJvmBinaryClass>> {
    final /* synthetic */ LazyJavaPackageFragment f38405a;

    LazyJavaPackageFragment$binaryClasses$2(LazyJavaPackageFragment lazyJavaPackageFragment) {
        this.f38405a = lazyJavaPackageFragment;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        PackagePartProvider packagePartProvider = this.f38405a.f40804g.f25703b.f25697m;
        Object a = this.f38405a.f40724d.m27407a();
        Intrinsics.m26843a(a, "fqName.asString()");
        Iterable<String> a2 = packagePartProvider.mo5856a(a);
        Collection arrayList = new ArrayList();
        for (String str : a2) {
            KotlinJvmBinaryClass a3 = this.f38405a.f40804g.f25703b.f25687c.mo5855a(new ClassId(this.f38405a.f40724d, Name.m27424a(str)));
            Object a4 = a3 != null ? TuplesKt.m26780a(str, a3) : null;
            if (a4 != null) {
                arrayList.add(a4);
            }
        }
        return MapsKt__MapsKt.m36117a((Iterable) (List) arrayList);
    }
}
