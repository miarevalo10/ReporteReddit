package kotlin.reflect.jvm.internal.impl.load.java.structure.reflect;

import java.lang.reflect.Method;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: ReflectJavaClass.kt */
final class ReflectJavaClass$methods$1 extends Lambda implements Function1<Method, Boolean> {
    final /* synthetic */ ReflectJavaClass f38461a;

    ReflectJavaClass$methods$1(ReflectJavaClass reflectJavaClass) {
        this.f38461a = reflectJavaClass;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        Method method = (Method) obj;
        boolean z = false;
        if (!method.isSynthetic()) {
            if (this.f38461a.f39725a.isEnum()) {
                Intrinsics.m26843a((Object) method, "method");
                if (ReflectJavaClass.m39887a(method) != null) {
                }
            }
            z = true;
        }
        return Boolean.valueOf(z);
    }
}
