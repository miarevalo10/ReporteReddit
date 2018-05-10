package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Collection;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: LazyJavaClassMemberScope.kt */
final class LazyJavaClassMemberScope$computeNonDeclaredProperties$2 extends Lambda implements Function1<Name, Collection<? extends SimpleFunctionDescriptor>> {
    final /* synthetic */ LazyJavaClassMemberScope f38391a;

    LazyJavaClassMemberScope$computeNonDeclaredProperties$2(LazyJavaClassMemberScope lazyJavaClassMemberScope) {
        this.f38391a = lazyJavaClassMemberScope;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        Name name = (Name) obj;
        Intrinsics.m26847b(name, "it");
        return LazyJavaClassMemberScope.m39857b(this.f38391a, name);
    }
}
