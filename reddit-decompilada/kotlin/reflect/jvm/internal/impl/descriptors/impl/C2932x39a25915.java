package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;

/* compiled from: ModuleDescriptorImpl.kt */
final class C2932x39a25915 extends Lambda implements Function0<CompositePackageFragmentProvider> {
    final /* synthetic */ ModuleDescriptorImpl f38345a;

    C2932x39a25915(ModuleDescriptorImpl moduleDescriptorImpl) {
        this.f38345a = moduleDescriptorImpl;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        ModuleDependencies b = this.f38345a.f38349c;
        if (b == null) {
            StringBuilder stringBuilder = new StringBuilder("Dependencies of module ");
            stringBuilder.append(this.f38345a.m38333h());
            stringBuilder.append(" were not set before querying module content");
            throw new AssertionError(stringBuilder.toString());
        }
        List a = b.mo5758a();
        boolean contains = a.contains(this.f38345a);
        if (!_Assertions.f25274a || contains) {
            Iterable<ModuleDescriptorImpl> iterable = a;
            for (ModuleDescriptorImpl moduleDescriptorImpl : iterable) {
                boolean d = moduleDescriptorImpl.m38332g();
                if (_Assertions.f25274a && !d) {
                    StringBuilder stringBuilder2 = new StringBuilder("Dependency module ");
                    stringBuilder2.append(moduleDescriptorImpl.m38333h());
                    stringBuilder2.append(" was not initialized by the time contents of dependent module ");
                    stringBuilder2.append(this.f38345a.m38333h());
                    stringBuilder2.append(" were queried");
                    throw new AssertionError(stringBuilder2.toString());
                }
            }
            Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
            for (ModuleDescriptorImpl e : iterable) {
                PackageFragmentProvider e2 = e.f38350d;
                if (e2 == null) {
                    Intrinsics.m26842a();
                }
                arrayList.add(e2);
            }
            return new CompositePackageFragmentProvider((List) arrayList);
        }
        stringBuilder2 = new StringBuilder("Module ");
        stringBuilder2.append(this.f38345a.m38333h());
        stringBuilder2.append(" is not contained in his own dependencies, this is probably a misconfiguration");
        throw new AssertionError(stringBuilder2.toString());
    }
}
