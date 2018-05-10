package kotlin.reflect.jvm.internal.impl.types;

import java.util.Collection;
import java.util.List;
import kotlin.TypeCastException;
import kotlin._Assertions;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;

/* compiled from: TypeSubstitution.kt */
public final class IndexedParametersSubstitution extends TypeSubstitution {
    public final TypeParameterDescriptor[] f33068a;
    public final TypeProjection[] f33069b;
    private final boolean f33070c;

    public IndexedParametersSubstitution(TypeParameterDescriptor[] typeParameterDescriptorArr, TypeProjection[] typeProjectionArr, boolean z) {
        Intrinsics.m26847b(typeParameterDescriptorArr, "parameters");
        Intrinsics.m26847b(typeProjectionArr, "arguments");
        this.f33068a = typeParameterDescriptorArr;
        this.f33069b = typeProjectionArr;
        this.f33070c = z;
        typeParameterDescriptorArr = ((Object[]) this.f33068a).length <= ((Object[]) this.f33069b).length ? 1 : null;
        if (_Assertions.f25274a != null && typeParameterDescriptorArr == null) {
            typeParameterDescriptorArr = new StringBuilder("Number of arguments should not be less then number of parameters, but: parameters=");
            typeParameterDescriptorArr.append(((Object[]) this.f33068a).length);
            typeParameterDescriptorArr.append(", args=");
            typeParameterDescriptorArr.append(((Object[]) this.f33069b).length);
            throw ((Throwable) new AssertionError(typeParameterDescriptorArr.toString()));
        }
    }

    public IndexedParametersSubstitution(List<? extends TypeParameterDescriptor> list, List<? extends TypeProjection> list2) {
        Intrinsics.m26847b(list, "parameters");
        Intrinsics.m26847b(list2, "argumentsList");
        Collection collection = list;
        if (collection == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.util.Collection<T>");
        }
        collection = collection;
        list = collection.toArray(new TypeParameterDescriptor[collection.size()]);
        if (list == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        TypeParameterDescriptor[] typeParameterDescriptorArr = (TypeParameterDescriptor[]) ((Object[]) list);
        Collection collection2 = list2;
        if (collection2 == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.util.Collection<T>");
        }
        collection2 = collection2;
        list2 = collection2.toArray(new TypeProjection[collection2.size()]);
        if (list2 == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        this(typeParameterDescriptorArr, (TypeProjection[]) ((Object[]) list2));
    }

    public final boolean mo5796a() {
        return ((Object[]) this.f33069b).length == 0;
    }

    public final boolean mo5933b() {
        return this.f33070c;
    }

    public final TypeProjection mo5795a(KotlinType kotlinType) {
        Intrinsics.m26847b(kotlinType, "key");
        kotlinType = kotlinType.mo6743g().mo5724c();
        if (!(kotlinType instanceof TypeParameterDescriptor)) {
            kotlinType = null;
        }
        TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor) kotlinType;
        if (typeParameterDescriptor == null) {
            return null;
        }
        int g = typeParameterDescriptor.mo7713g();
        if (g >= ((Object[]) this.f33068a).length || Intrinsics.m26845a(this.f33068a[g].mo7610c(), typeParameterDescriptor.mo7610c()) == null) {
            return null;
        }
        return this.f33069b[g];
    }
}
