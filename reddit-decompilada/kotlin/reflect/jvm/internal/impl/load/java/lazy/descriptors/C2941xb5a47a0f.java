package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Collection;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: LazyJavaClassMemberScope.kt */
final class C2941xb5a47a0f extends Lambda implements Function1<Name, Collection<? extends SimpleFunctionDescriptor>> {
    final /* synthetic */ LazyJavaClassMemberScope f38399a;
    final /* synthetic */ SimpleFunctionDescriptor f38400b;

    C2941xb5a47a0f(LazyJavaClassMemberScope lazyJavaClassMemberScope, SimpleFunctionDescriptor simpleFunctionDescriptor) {
        this.f38399a = lazyJavaClassMemberScope;
        this.f38400b = simpleFunctionDescriptor;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        Name name = (Name) obj;
        if (Intrinsics.m26845a(this.f38400b.mo6689i(), (Object) name)) {
            return CollectionsKt__CollectionsKt.m26791a(this.f38400b);
        }
        return CollectionsKt___CollectionsKt.m41423b(LazyJavaClassMemberScope.m39842a(this.f38399a, name), (Iterable) LazyJavaClassMemberScope.m39857b(this.f38399a, name));
    }
}
