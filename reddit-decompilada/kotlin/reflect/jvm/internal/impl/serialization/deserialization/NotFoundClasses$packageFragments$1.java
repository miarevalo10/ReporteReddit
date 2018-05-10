package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.EmptyPackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* compiled from: NotFoundClasses.kt */
final class NotFoundClasses$packageFragments$1 extends Lambda implements Function1<FqName, EmptyPackageFragmentDescriptor> {
    final /* synthetic */ NotFoundClasses f38854a;

    NotFoundClasses$packageFragments$1(NotFoundClasses notFoundClasses) {
        this.f38854a = notFoundClasses;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        FqName fqName = (FqName) obj;
        Intrinsics.m26847b(fqName, "fqName");
        return new EmptyPackageFragmentDescriptor(this.f38854a.f26265e, fqName);
    }
}
