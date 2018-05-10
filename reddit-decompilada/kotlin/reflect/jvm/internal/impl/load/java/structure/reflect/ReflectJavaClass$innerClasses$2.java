package kotlin.reflect.jvm.internal.impl.load.java.structure.reflect;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

/* compiled from: ReflectJavaClass.kt */
final class ReflectJavaClass$innerClasses$2 extends FunctionReference implements Function1<Class<?>, ReflectJavaClass> {
    public static final ReflectJavaClass$innerClasses$2 f38460a = new ReflectJavaClass$innerClasses$2();

    ReflectJavaClass$innerClasses$2() {
        super(1);
    }

    public final KDeclarationContainer mo6931a() {
        return Reflection.m26850a(ReflectJavaClass.class);
    }

    public final String mo5687b() {
        return "<init>";
    }

    public final String mo6932c() {
        return "<init>(Ljava/lang/Class;)V";
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        Class cls = (Class) obj;
        Intrinsics.m26847b(cls, "p1");
        return new ReflectJavaClass(cls);
    }
}
