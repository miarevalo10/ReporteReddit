package kotlin.reflect.jvm.internal.impl.load.java.structure.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaConstructor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter;

/* compiled from: ReflectJavaConstructor.kt */
public final class ReflectJavaConstructor extends ReflectJavaMember implements JavaConstructor {
    public final Constructor<?> f39726a;

    public ReflectJavaConstructor(Constructor<?> constructor) {
        Intrinsics.m26847b(constructor, "member");
        this.f39726a = constructor;
    }

    public final List<JavaValueParameter> mo7285b() {
        Object genericParameterTypes = this.f39726a.getGenericParameterTypes();
        Object[] objArr = (Object[]) genericParameterTypes;
        if ((objArr.length == 0 ? 1 : 0) != 0) {
            return CollectionsKt__CollectionsKt.m26790a();
        }
        Class declaringClass = this.f39726a.getDeclaringClass();
        if (!(declaringClass.getDeclaringClass() == null || Modifier.isStatic(declaringClass.getModifiers()))) {
            genericParameterTypes = Arrays.copyOfRange(objArr, 1, objArr.length);
            Intrinsics.m26843a(genericParameterTypes, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
            genericParameterTypes = (Type[]) genericParameterTypes;
        }
        Object parameterAnnotations = this.f39726a.getParameterAnnotations();
        Object[] objArr2 = (Object[]) parameterAnnotations;
        Object[] objArr3 = (Object[]) genericParameterTypes;
        if (objArr2.length < objArr3.length) {
            StringBuilder stringBuilder = new StringBuilder("Illegal generic signature: ");
            stringBuilder.append(this.f39726a);
            throw new IllegalStateException(stringBuilder.toString());
        }
        if (objArr2.length > objArr3.length) {
            parameterAnnotations = Arrays.copyOfRange(objArr2, objArr2.length - objArr3.length, objArr2.length);
            Intrinsics.m26843a(parameterAnnotations, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
            parameterAnnotations = (Annotation[][]) parameterAnnotations;
        }
        Intrinsics.m26843a(genericParameterTypes, "realTypes");
        Intrinsics.m26843a(parameterAnnotations, "realAnnotations");
        return m38465a(genericParameterTypes, parameterAnnotations, this.f39726a.isVarArgs());
    }

    public final List<ReflectJavaTypeParameter> mo7284q() {
        Object[] objArr = (Object[]) this.f39726a.getTypeParameters();
        Collection arrayList = new ArrayList(objArr.length);
        for (Object obj : objArr) {
            Object obj2 = (TypeVariable) obj2;
            Intrinsics.m26843a(obj2, "it");
            arrayList.add(new ReflectJavaTypeParameter(obj2));
        }
        return (List) arrayList;
    }

    public final /* bridge */ /* synthetic */ Member mo7286c() {
        return this.f39726a;
    }
}
