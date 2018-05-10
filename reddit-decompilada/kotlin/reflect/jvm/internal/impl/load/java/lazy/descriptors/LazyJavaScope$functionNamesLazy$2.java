package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;

/* compiled from: LazyJavaScope.kt */
final class LazyJavaScope$functionNamesLazy$2 extends Lambda implements Function0<Set<? extends Name>> {
    final /* synthetic */ LazyJavaScope f38416a;

    LazyJavaScope$functionNamesLazy$2(LazyJavaScope lazyJavaScope) {
        this.f38416a = lazyJavaScope;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        return this.f38416a.mo7264b(DescriptorKindFilter.f26120j, null);
    }
}
