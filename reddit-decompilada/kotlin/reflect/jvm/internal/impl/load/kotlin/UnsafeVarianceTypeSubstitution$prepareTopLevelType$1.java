package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* compiled from: UnsafeVarianceTypeSubstitution.kt */
final class UnsafeVarianceTypeSubstitution$prepareTopLevelType$1 extends Lambda implements Function3<TypeParameterDescriptor, IndexedTypeHolder, Variance, Unit> {
    final /* synthetic */ List f38782a;

    UnsafeVarianceTypeSubstitution$prepareTopLevelType$1(List list) {
        this.f38782a = list;
        super(3);
    }

    public final /* synthetic */ Object mo6509a(Object obj, Object obj2, Object obj3) {
        IndexedTypeHolder indexedTypeHolder = (IndexedTypeHolder) obj2;
        Variance variance = (Variance) obj3;
        Intrinsics.m26847b((TypeParameterDescriptor) obj, "typeParameter");
        Intrinsics.m26847b(indexedTypeHolder, "indexedTypeHolder");
        Intrinsics.m26847b(variance, "errorPosition");
        this.f38782a.add(indexedTypeHolder.f32831b);
        return Unit.f25273a;
    }
}
