package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: LazyJavaPackageScope.kt */
final class LazyJavaPackageScope$computeNonDeclaredFunctions$1 extends Lambda implements Function0<ClassDescriptor> {
    final /* synthetic */ LazyJavaPackageScope f38410a;
    final /* synthetic */ Name f38411b;

    LazyJavaPackageScope$computeNonDeclaredFunctions$1(LazyJavaPackageScope lazyJavaPackageScope, Name name) {
        this.f38410a = lazyJavaPackageScope;
        this.f38411b = name;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        return this.f38410a.m41500d(this.f38411b, NoLookupLocation.f32682l);
    }
}
