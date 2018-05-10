package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.ChainedMemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope.Empty;

/* compiled from: LazyPackageViewDescriptorImpl.kt */
final class LazyPackageViewDescriptorImpl$memberScope$1 extends Lambda implements Function0<MemberScope> {
    final /* synthetic */ LazyPackageViewDescriptorImpl f38339a;

    LazyPackageViewDescriptorImpl$memberScope$1(LazyPackageViewDescriptorImpl lazyPackageViewDescriptorImpl) {
        this.f38339a = lazyPackageViewDescriptorImpl;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        if (this.f38339a.mo7083f().isEmpty()) {
            return Empty.f38819a;
        }
        Iterable<PackageFragmentDescriptor> f = this.f38339a.mo7083f();
        Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(f));
        for (PackageFragmentDescriptor aC_ : f) {
            arrayList.add(aC_.aC_());
        }
        List a = CollectionsKt___CollectionsKt.m41419a((Collection) (List) arrayList, (Object) new SubpackagesScope(this.f38339a.f38341a, this.f38339a.f38342b));
        StringBuilder stringBuilder = new StringBuilder("package view scope for ");
        stringBuilder.append(this.f38339a.f38342b);
        stringBuilder.append(" in ");
        stringBuilder.append(this.f38339a.f38341a.mo6689i());
        return new ChainedMemberScope(stringBuilder.toString(), a);
    }
}
