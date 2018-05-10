package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope.Companion;

/* compiled from: LazyJavaScope.kt */
final class LazyJavaScope$allDescriptors$1 extends Lambda implements Function0<List<? extends DeclarationDescriptor>> {
    final /* synthetic */ LazyJavaScope f38414a;

    LazyJavaScope$allDescriptors$1(LazyJavaScope lazyJavaScope) {
        this.f38414a = lazyJavaScope;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        LazyJavaScope lazyJavaScope = this.f38414a;
        DescriptorKindFilter descriptorKindFilter = DescriptorKindFilter.f26113c;
        Companion companion = MemberScope.f32953f;
        return lazyJavaScope.m38388a(descriptorKindFilter, Companion.m27788a(), (LookupLocation) NoLookupLocation.f32683m);
    }
}
