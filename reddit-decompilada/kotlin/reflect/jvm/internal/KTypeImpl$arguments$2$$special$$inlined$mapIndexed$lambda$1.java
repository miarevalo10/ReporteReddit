package kotlin.reflect.jvm.internal;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KProperty;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Ljava/lang/reflect/Type;", "invoke"}, k = 3, mv = {1, 1, 5})
/* compiled from: KTypeImpl.kt */
final class KTypeImpl$arguments$2$$special$$inlined$mapIndexed$lambda$1 extends Lambda implements Function0<Type> {
    final /* synthetic */ int f38302a;
    final /* synthetic */ KTypeImpl$arguments$2 f38303b;
    final /* synthetic */ Lazy f38304c;
    final /* synthetic */ KProperty f38305d;

    KTypeImpl$arguments$2$$special$$inlined$mapIndexed$lambda$1(int i, KTypeImpl$arguments$2 kTypeImpl$arguments$2, Lazy lazy, KProperty kProperty) {
        this.f38302a = i;
        this.f38303b = kTypeImpl$arguments$2;
        this.f38304c = lazy;
        this.f38305d = kProperty;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        Type b = this.f38303b.f38307a.m32900b();
        Object componentType;
        if (b instanceof Class) {
            Class cls = (Class) b;
            componentType = cls.isArray() ? cls.getComponentType() : Object.class;
            Intrinsics.m26843a(componentType, "if (javaType.isArray) ja…Type else Any::class.java");
            return (Type) componentType;
        } else if (b instanceof GenericArrayType) {
            if (this.f38302a != 0) {
                r1 = new StringBuilder("Array type has been queried for a non-0th argument: ");
                r1.append(this.f38303b.f38307a);
                throw new KotlinReflectionInternalError(r1.toString());
            }
            componentType = ((GenericArrayType) b).getGenericComponentType();
            Intrinsics.m26843a(componentType, "javaType.genericComponentType");
            return componentType;
        } else if (b instanceof ParameterizedType) {
            componentType = (Type) ((List) this.f38304c.mo5678b()).get(this.f38302a);
            if (componentType instanceof WildcardType) {
                WildcardType wildcardType = (WildcardType) componentType;
                Type type = (Type) ArraysKt___ArraysKt.m36094b((Object[]) wildcardType.getLowerBounds());
                componentType = type == null ? (Type) ArraysKt___ArraysKt.m36082a((Object[]) wildcardType.getUpperBounds()) : type;
            }
            Intrinsics.m26843a(componentType, "if (argument !is Wildcar…ument.upperBounds.first()");
            return componentType;
        } else {
            r1 = new StringBuilder("Non-generic type has been queried for arguments: ");
            r1.append(this.f38303b.f38307a);
            throw new KotlinReflectionInternalError(r1.toString());
        }
    }
}
