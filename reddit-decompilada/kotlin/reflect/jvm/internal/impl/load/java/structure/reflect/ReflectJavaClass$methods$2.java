package kotlin.reflect.jvm.internal.impl.load.java.structure.reflect;

import java.lang.reflect.Method;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

/* compiled from: ReflectJavaClass.kt */
final class ReflectJavaClass$methods$2 extends FunctionReference implements Function1<Method, ReflectJavaMethod> {
    public static final ReflectJavaClass$methods$2 f38462a = new ReflectJavaClass$methods$2();

    ReflectJavaClass$methods$2() {
        super(1);
    }

    public final KDeclarationContainer mo6931a() {
        return Reflection.m26850a(ReflectJavaMethod.class);
    }

    public final String mo5687b() {
        return "<init>";
    }

    public final String mo6932c() {
        return "<init>(Ljava/lang/reflect/Method;)V";
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        Method method = (Method) obj;
        Intrinsics.m26847b(method, "p1");
        return new ReflectJavaMethod(method);
    }
}
