package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* compiled from: NewCapturedType.kt */
public final class NewCapturedTypeConstructor implements TypeConstructor {
    List<? extends UnwrappedType> f33076a;
    private final TypeProjection f33077b;

    public final ClassifierDescriptor mo5724c() {
        return null;
    }

    public final boolean mo5725d() {
        return false;
    }

    public NewCapturedTypeConstructor(TypeProjection typeProjection, List<? extends UnwrappedType> list) {
        Intrinsics.m26847b(typeProjection, "projection");
        this.f33077b = typeProjection;
        this.f33076a = list;
    }

    public final List<TypeParameterDescriptor> mo5723b() {
        return CollectionsKt__CollectionsKt.m26790a();
    }

    public final KotlinBuiltIns mo5726e() {
        return TypeUtilsKt.m28060a(this.f33077b.mo6736c());
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("CapturedType(");
        stringBuilder.append(this.f33077b);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public final /* synthetic */ Collection aL_() {
        List list = this.f33076a;
        if (list == null) {
            list = CollectionsKt__CollectionsKt.m26790a();
        }
        return list;
    }
}
