package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: LazyJavaStaticClassScope.kt */
final class LazyJavaStaticClassScope$computeNonDeclaredFunctions$1 extends Lambda implements Function0<ClassifierDescriptor> {
    final /* synthetic */ LazyJavaStaticClassScope f38432a;
    final /* synthetic */ Name f38433b;

    LazyJavaStaticClassScope$computeNonDeclaredFunctions$1(LazyJavaStaticClassScope lazyJavaStaticClassScope, Name name) {
        this.f38432a = lazyJavaStaticClassScope;
        this.f38433b = name;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        return this.f38432a.f40291a.f40958c.mo6699c(this.f38433b, NoLookupLocation.f32682l);
    }
}
