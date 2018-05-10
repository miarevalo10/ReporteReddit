package kotlin.reflect.jvm.internal.impl.load.java.structure.reflect;

import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectJavaType.Factory;

/* compiled from: ReflectJavaMethod.kt */
public final class ReflectJavaMethod extends ReflectJavaMember implements JavaMethod {
    public final Method f39728a;

    public ReflectJavaMethod(Method method) {
        Intrinsics.m26847b(method, "member");
        this.f39728a = method;
    }

    public final List<JavaValueParameter> mo7290b() {
        Object genericParameterTypes = this.f39728a.getGenericParameterTypes();
        Intrinsics.m26843a(genericParameterTypes, "member.genericParameterTypes");
        Object parameterAnnotations = this.f39728a.getParameterAnnotations();
        Intrinsics.m26843a(parameterAnnotations, "member.parameterAnnotations");
        return m38465a(genericParameterTypes, parameterAnnotations, this.f39728a.isVarArgs());
    }

    public final /* synthetic */ JavaType aS_() {
        Factory factory = ReflectJavaType.f32758b;
        Object genericReturnType = this.f39728a.getGenericReturnType();
        Intrinsics.m26843a(genericReturnType, "member.genericReturnType");
        return Factory.m27256a(genericReturnType);
    }

    public final boolean mo7291e() {
        return this.f39728a.getDefaultValue() != null;
    }

    public final List<ReflectJavaTypeParameter> mo7284q() {
        Object[] objArr = (Object[]) this.f39728a.getTypeParameters();
        Collection arrayList = new ArrayList(objArr.length);
        for (Object obj : objArr) {
            Object obj2 = (TypeVariable) obj2;
            Intrinsics.m26843a(obj2, "it");
            arrayList.add(new ReflectJavaTypeParameter(obj2));
        }
        return (List) arrayList;
    }

    public final /* bridge */ /* synthetic */ Member mo7286c() {
        return this.f39728a;
    }
}
