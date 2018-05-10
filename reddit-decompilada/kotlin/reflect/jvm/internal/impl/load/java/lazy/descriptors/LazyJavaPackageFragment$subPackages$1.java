package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* compiled from: LazyJavaPackageFragment.kt */
final class LazyJavaPackageFragment$subPackages$1 extends Lambda implements Function0<List<? extends FqName>> {
    final /* synthetic */ LazyJavaPackageFragment f38407a;

    LazyJavaPackageFragment$subPackages$1(LazyJavaPackageFragment lazyJavaPackageFragment) {
        this.f38407a = lazyJavaPackageFragment;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        Iterable<JavaPackage> b = this.f38407a.f40805h.mo6713b();
        Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(b));
        for (JavaPackage a : b) {
            arrayList.add(a.mo6712a());
        }
        return (List) arrayList;
    }
}
