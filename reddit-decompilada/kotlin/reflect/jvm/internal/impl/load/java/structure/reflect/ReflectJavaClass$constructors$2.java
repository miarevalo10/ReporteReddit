package kotlin.reflect.jvm.internal.impl.load.java.structure.reflect;

import java.lang.reflect.Constructor;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

/* compiled from: ReflectJavaClass.kt */
final class ReflectJavaClass$constructors$2 extends FunctionReference implements Function1<Constructor<?>, ReflectJavaConstructor> {
    public static final ReflectJavaClass$constructors$2 f38456a = new ReflectJavaClass$constructors$2();

    ReflectJavaClass$constructors$2() {
        super(1);
    }

    public final KDeclarationContainer mo6931a() {
        return Reflection.m26850a(ReflectJavaConstructor.class);
    }

    public final String mo5687b() {
        return "<init>";
    }

    public final String mo6932c() {
        return "<init>(Ljava/lang/reflect/Constructor;)V";
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        Constructor constructor = (Constructor) obj;
        Intrinsics.m26847b(constructor, "p1");
        return new ReflectJavaConstructor(constructor);
    }
}
