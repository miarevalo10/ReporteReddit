package kotlin.reflect.jvm.internal;

import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KProperty;

@Metadata(bv = {1, 0, 1}, d1 = {"\u00000\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u001a6\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\bH\u0002\u001a$\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\t2\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0002\u001a\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u00012\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0002¨\u0006\u0012"}, d2 = {"createAnnotationInstance", "", "annotationClass", "Ljava/lang/Class;", "methods", "", "Ljava/lang/reflect/Method;", "values", "", "", "throwIllegalArgumentType", "", "index", "", "name", "expectedJvmType", "transformKotlinToJvm", "expectedType", "kotlin-reflection"}, k = 2, mv = {1, 1, 5})
/* compiled from: AnnotationConstructorCaller.kt */
public final class AnnotationConstructorCallerKt {
    public static final /* synthetic */ Object m26892a(Object obj, Class cls) {
        if (!(obj instanceof Class)) {
            if (obj instanceof KClass) {
                obj = JvmClassMappingKt.m26829a((KClass) obj);
            } else if (obj instanceof Object[]) {
                Object obj2 = (Object[]) obj;
                if (!(obj2 instanceof Class[])) {
                    if (!(obj2 instanceof KClass[])) {
                        obj = obj2;
                    } else if (obj == null) {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<kotlin.reflect.KClass<*>>");
                    } else {
                        Object[] objArr = (Object[]) ((KClass[]) obj);
                        Collection arrayList = new ArrayList(objArr.length);
                        for (Object obj3 : objArr) {
                            arrayList.add(JvmClassMappingKt.m26829a((KClass) obj3));
                        }
                        arrayList = (List) arrayList;
                        obj = arrayList.toArray(new Class[arrayList.size()]);
                        if (obj == null) {
                            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
                        }
                        obj = (Object[]) obj;
                    }
                }
            }
            if (cls.isInstance(obj) != null) {
                return obj;
            }
        }
        return null;
    }

    public static final /* synthetic */ Void m26893a(int i, String str, Class cls) {
        KClass a;
        if (Intrinsics.m26845a((Object) cls, (Object) Class.class)) {
            a = Reflection.m26850a(KClass.class);
        } else if (cls.isArray() && Intrinsics.m26845a(cls.getComponentType(), (Object) Class.class)) {
            a = Reflection.m26850a(KClass[].class);
        } else {
            a = JvmClassMappingKt.m26830a(cls);
        }
        if (Intrinsics.m26845a(a.mo6659c(), Reflection.m26850a(Object[].class).mo6659c())) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(a.mo6659c());
            stringBuilder.append(Operation.LESS_THAN);
            stringBuilder.append(JvmClassMappingKt.m26830a(JvmClassMappingKt.m26829a(a).getComponentType()).mo6659c());
            stringBuilder.append(Operation.GREATER_THAN);
            cls = stringBuilder.toString();
        } else {
            cls = a.mo6659c();
        }
        StringBuilder stringBuilder2 = new StringBuilder("Argument #");
        stringBuilder2.append(i);
        stringBuilder2.append(" ");
        stringBuilder2.append(str);
        stringBuilder2.append(" is not of the required type ");
        stringBuilder2.append(cls);
        throw new IllegalArgumentException(stringBuilder2.toString());
    }

    public static final /* synthetic */ Object m26891a(Class cls, List list, Map map) {
        AnnotationConstructorCallerKt$createAnnotationInstance$1 annotationConstructorCallerKt$createAnnotationInstance$1 = new AnnotationConstructorCallerKt$createAnnotationInstance$1(cls, list, map);
        Lazy a = LazyKt.m26777a((Function0) new C2919xa743ec88(map));
        KProperty kProperty = (KProperty) C3042xa743ec87.f40284a;
        Lazy a2 = LazyKt.m26777a((Function0) new C2921x4fc4299(cls, map));
        KProperty kProperty2 = (KProperty) C3043x4fc4298.f40285a;
        Object newProxyInstance = Proxy.newProxyInstance(cls.getClassLoader(), (Class[]) ((Object[]) new Class[]{cls}), new AnnotationConstructorCallerKt$createAnnotationInstance$2(cls, a2, kProperty2, a, kProperty, annotationConstructorCallerKt$createAnnotationInstance$1, map));
        Intrinsics.m26843a(newProxyInstance, "Proxy.newProxyInstance(a…        }\n        }\n    }");
        return newProxyInstance;
    }
}
