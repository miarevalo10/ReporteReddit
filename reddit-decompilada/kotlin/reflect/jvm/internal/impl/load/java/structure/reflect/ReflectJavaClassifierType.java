package kotlin.reflect.jvm.internal.impl.load.java.structure.reflect;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifier;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectJavaType.Factory;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* compiled from: ReflectJavaClassifierType.kt */
public final class ReflectJavaClassifierType extends ReflectJavaType implements JavaClassifierType {
    final Type f38463a;
    private final JavaClassifier f38464c;

    public final JavaAnnotation mo7092a(FqName fqName) {
        Intrinsics.m26847b(fqName, "fqName");
        return null;
    }

    public ReflectJavaClassifierType(Type type) {
        JavaClassifier reflectJavaClass;
        Intrinsics.m26847b(type, "reflectType");
        this.f38463a = type;
        type = this.f38463a;
        if (type instanceof Class) {
            reflectJavaClass = new ReflectJavaClass((Class) type);
        } else if (type instanceof TypeVariable) {
            reflectJavaClass = new ReflectJavaTypeParameter((TypeVariable) type);
        } else if (type instanceof ParameterizedType) {
            type = ((ParameterizedType) type).getRawType();
            if (type == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.Class<*>");
            }
            reflectJavaClass = new ReflectJavaClass((Class) type);
        } else {
            StringBuilder stringBuilder = new StringBuilder("Not a classifier type (");
            stringBuilder.append(type.getClass());
            stringBuilder.append("): ");
            stringBuilder.append(type);
            throw new IllegalStateException(stringBuilder.toString());
        }
        this.f38464c = reflectJavaClass;
    }

    public final Type aQ_() {
        return this.f38463a;
    }

    public final JavaClassifier mo7093b() {
        return this.f38464c;
    }

    public final String mo7096e() {
        StringBuilder stringBuilder = new StringBuilder("Type not found: ");
        stringBuilder.append(this.f38463a);
        throw new UnsupportedOperationException(stringBuilder.toString());
    }

    public final Collection<JavaAnnotation> mo7091a() {
        return CollectionsKt__CollectionsKt.m26790a();
    }

    public final String mo7097f() {
        return this.f38463a.toString();
    }

    public final boolean mo7095d() {
        Type type = this.f38463a;
        if (type instanceof Class) {
            if (((((Object[]) ((Class) type).getTypeParameters()).length == 0 ? 1 : 0) ^ 1) != 0) {
                return true;
            }
        }
        return false;
    }

    public final List<JavaType> mo7094c() {
        Iterable<Type> a = ReflectClassUtilKt.m27240a(this.f38463a);
        Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(a));
        for (Type a2 : a) {
            arrayList.add(Factory.m27256a(a2));
        }
        return (List) arrayList;
    }
}
