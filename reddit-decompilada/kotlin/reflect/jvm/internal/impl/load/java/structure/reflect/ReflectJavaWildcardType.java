package kotlin.reflect.jvm.internal.impl.load.java.structure.reflect;

import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaWildcardType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectJavaType.Factory;

/* compiled from: ReflectJavaWildcardType.kt */
public final class ReflectJavaWildcardType extends ReflectJavaType implements JavaWildcardType {
    private final WildcardType f36109a;

    public ReflectJavaWildcardType(WildcardType wildcardType) {
        Intrinsics.m26847b(wildcardType, "reflectType");
        this.f36109a = wildcardType;
    }

    public final /* synthetic */ JavaType mo6715a() {
        Type[] upperBounds = this.f36109a.getUpperBounds();
        Type[] lowerBounds = this.f36109a.getLowerBounds();
        Object[] objArr = (Object[]) upperBounds;
        if (objArr.length <= 1) {
            Object[] objArr2 = (Object[]) lowerBounds;
            if (objArr2.length <= 1) {
                ReflectJavaType reflectJavaType = null;
                Object d;
                if (objArr2.length == 1) {
                    d = ArraysKt___ArraysKt.m36103d(objArr2);
                    Intrinsics.m26843a(d, "lowerBounds.single()");
                    reflectJavaType = Factory.m27256a((Type) d);
                } else if (objArr.length == 1) {
                    d = (Type) ArraysKt___ArraysKt.m36103d(objArr);
                    if ((Intrinsics.m26845a(d, (Object) Object.class) ^ 1) != 0) {
                        Intrinsics.m26843a(d, "ub");
                        reflectJavaType = Factory.m27256a(d);
                    }
                    reflectJavaType = reflectJavaType;
                }
                return reflectJavaType;
            }
        }
        StringBuilder stringBuilder = new StringBuilder("Wildcard types with many bounds are not yet supported: ");
        stringBuilder.append(this.f36109a);
        throw new UnsupportedOperationException(stringBuilder.toString());
    }

    public final boolean mo6716b() {
        return Intrinsics.m26845a((Type) ArraysKt___ArraysKt.m36094b((Object[]) this.f36109a.getUpperBounds()), (Object) Object.class) ^ 1;
    }

    public final /* bridge */ /* synthetic */ Type aQ_() {
        return this.f36109a;
    }
}
