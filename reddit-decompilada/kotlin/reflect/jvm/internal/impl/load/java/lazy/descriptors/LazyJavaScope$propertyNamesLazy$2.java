package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;

/* compiled from: LazyJavaScope.kt */
final class LazyJavaScope$propertyNamesLazy$2 extends Lambda implements Function0<Set<? extends Name>> {
    final /* synthetic */ LazyJavaScope f38419a;

    LazyJavaScope$propertyNamesLazy$2(LazyJavaScope lazyJavaScope) {
        this.f38419a = lazyJavaScope;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        return this.f38419a.mo7259a(DescriptorKindFilter.f26121k);
    }
}
