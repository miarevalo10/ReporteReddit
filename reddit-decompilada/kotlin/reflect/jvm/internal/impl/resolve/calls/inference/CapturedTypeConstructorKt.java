package kotlin.reflect.jvm.internal.impl.resolve.calls.inference;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.types.IndexedParametersSubstitution;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.LazyWrappedType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* compiled from: CapturedTypeConstructor.kt */
public final class CapturedTypeConstructorKt {
    public static final boolean m27712a(KotlinType kotlinType) {
        Intrinsics.m26847b(kotlinType, "$receiver");
        return kotlinType.mo6743g() instanceof CapturedTypeConstructor;
    }

    public static /* synthetic */ TypeSubstitution m27711a(TypeSubstitution typeSubstitution) {
        Intrinsics.m26847b(typeSubstitution, "$receiver");
        if (!(typeSubstitution instanceof IndexedParametersSubstitution)) {
            return new CapturedTypeConstructorKt$wrapWithCapturingSubstitution$2(typeSubstitution, typeSubstitution);
        }
        IndexedParametersSubstitution indexedParametersSubstitution = (IndexedParametersSubstitution) typeSubstitution;
        TypeParameterDescriptor[] typeParameterDescriptorArr = indexedParametersSubstitution.f33068a;
        Iterable<Pair> b = ArraysKt___ArraysKt.m36096b((Object[]) indexedParametersSubstitution.f33069b, (Object[]) indexedParametersSubstitution.f33068a);
        Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(b));
        for (Pair pair : b) {
            arrayList.add(m27713b((TypeProjection) pair.f25267a, (TypeParameterDescriptor) pair.f25268b));
        }
        arrayList = (List) arrayList;
        typeSubstitution = arrayList.toArray(new TypeProjection[arrayList.size()]);
        if (typeSubstitution != null) {
            return new IndexedParametersSubstitution(typeParameterDescriptorArr, (TypeProjection[]) ((Object[]) typeSubstitution), true);
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    private static final TypeProjection m27713b(TypeProjection typeProjection, TypeParameterDescriptor typeParameterDescriptor) {
        if (typeParameterDescriptor != null) {
            if (!Intrinsics.m26845a(typeProjection.mo6735b(), Variance.f26337a)) {
                if (Intrinsics.m26845a(typeParameterDescriptor.mo7716k(), typeProjection.mo6735b()) == null) {
                    Intrinsics.m26847b(typeProjection, "typeProjection");
                    return (TypeProjection) new TypeProjectionImpl(new CapturedType(typeProjection));
                } else if (typeProjection.mo6734a() == null) {
                    return (TypeProjection) new TypeProjectionImpl(typeProjection.mo6736c());
                } else {
                    Object obj = LockBasedStorageManager.f33053a;
                    Intrinsics.m26843a(obj, "LockBasedStorageManager.NO_LOCKS");
                    return (TypeProjection) new TypeProjectionImpl(new LazyWrappedType(obj, new CapturedTypeConstructorKt$createCapturedIfNeeded$1(typeProjection)));
                }
            }
        }
        return typeProjection;
    }
}
