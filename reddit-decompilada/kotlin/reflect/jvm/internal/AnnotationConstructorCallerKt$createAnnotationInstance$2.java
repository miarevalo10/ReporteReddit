package kotlin.reflect.jvm.internal;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u000e\u0010\u0002\u001a\n \u0003*\u0004\u0018\u00010\u00010\u00012\u000e\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00050\u00052,\u0010\u0006\u001a(\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00010\u0001 \u0003*\u0014\u0012\u000e\b\u0001\u0012\n \u0003*\u0004\u0018\u00010\u00010\u0001\u0018\u00010\u00070\u0007H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"<anonymous>", "", "proxy", "kotlin.jvm.PlatformType", "method", "Ljava/lang/reflect/Method;", "args", "", "invoke", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 5})
/* compiled from: AnnotationConstructorCaller.kt */
final class AnnotationConstructorCallerKt$createAnnotationInstance$2 implements InvocationHandler {
    final /* synthetic */ Class f25315a;
    final /* synthetic */ Lazy f25316b;
    final /* synthetic */ KProperty f25317c;
    final /* synthetic */ Lazy f25318d;
    final /* synthetic */ KProperty f25319e;
    final /* synthetic */ AnnotationConstructorCallerKt$createAnnotationInstance$1 f25320f;
    final /* synthetic */ Map f25321g;

    AnnotationConstructorCallerKt$createAnnotationInstance$2(Class cls, Lazy lazy, KProperty kProperty, Lazy lazy2, KProperty kProperty2, AnnotationConstructorCallerKt$createAnnotationInstance$1 annotationConstructorCallerKt$createAnnotationInstance$1, Map map) {
        this.f25315a = cls;
        this.f25316b = lazy;
        this.f25317c = kProperty;
        this.f25318d = lazy2;
        this.f25319e = kProperty2;
        this.f25320f = annotationConstructorCallerKt$createAnnotationInstance$1;
        this.f25321g = map;
    }

    public final Object invoke(Object obj, Method method, Object[] objArr) {
        obj = method.getName();
        if (obj != null) {
            int hashCode = obj.hashCode();
            if (hashCode != -1776922004) {
                if (hashCode != 147696667) {
                    if (hashCode == 1444986633) {
                        if (obj.equals("annotationType")) {
                            return this.f25315a;
                        }
                    }
                } else if (obj.equals("hashCode")) {
                    return this.f25318d.mo5678b();
                }
            } else if (obj.equals("toString")) {
                return this.f25316b.mo5678b();
            }
        }
        if (Intrinsics.m26845a(obj, (Object) "equals")) {
            if (Intrinsics.m26845a(objArr != null ? Integer.valueOf(objArr.length) : null, Integer.valueOf(1))) {
                return Boolean.valueOf(this.f25320f.m38217b(ArraysKt___ArraysKt.m36103d(objArr)));
            }
        }
        if (this.f25321g.containsKey(obj)) {
            return this.f25321g.get(obj);
        }
        StringBuilder stringBuilder = new StringBuilder("Method is not supported: ");
        stringBuilder.append(method);
        stringBuilder.append(" (args: ");
        if (objArr == null) {
            objArr = (Object[]) new Object[null];
        }
        stringBuilder.append(ArraysKt___ArraysKt.m36109i(objArr));
        stringBuilder.append(")");
        throw ((Throwable) new KotlinReflectionInternalError(stringBuilder.toString()));
    }
}
