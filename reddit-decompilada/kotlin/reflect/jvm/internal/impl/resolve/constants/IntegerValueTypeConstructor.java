package kotlin.reflect.jvm.internal.impl.resolve.constants;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;

/* compiled from: IntegerValueTypeConstructor.kt */
public final class IntegerValueTypeConstructor implements TypeConstructor {
    private final ArrayList<KotlinType> f32942a;
    private final long f32943b;
    private final KotlinBuiltIns f32944c;

    public final /* bridge */ /* synthetic */ ClassifierDescriptor mo5724c() {
        return null;
    }

    public final boolean mo5725d() {
        return false;
    }

    public final Collection<KotlinType> aL_() {
        return this.f32942a;
    }

    public final List<TypeParameterDescriptor> mo5723b() {
        return CollectionsKt__CollectionsKt.m26790a();
    }

    public final KotlinBuiltIns mo5726e() {
        return this.f32944c;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("IntegerValueType(");
        stringBuilder.append(this.f32943b);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
