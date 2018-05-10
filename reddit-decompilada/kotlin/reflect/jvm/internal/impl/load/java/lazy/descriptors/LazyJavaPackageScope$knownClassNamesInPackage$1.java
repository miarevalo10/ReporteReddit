package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;

/* compiled from: LazyJavaPackageScope.kt */
final class LazyJavaPackageScope$knownClassNamesInPackage$1 extends Lambda implements Function0<Set<? extends String>> {
    final /* synthetic */ LazyJavaPackageScope f38412a;
    final /* synthetic */ LazyJavaResolverContext f38413b;

    LazyJavaPackageScope$knownClassNamesInPackage$1(LazyJavaPackageScope lazyJavaPackageScope, LazyJavaResolverContext lazyJavaResolverContext) {
        this.f38412a = lazyJavaPackageScope;
        this.f38413b = lazyJavaResolverContext;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        return this.f38413b.f25703b.f25686b.mo5799b(this.f38412a.f40287a.f40724d);
    }
}
