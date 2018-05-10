package kotlin.reflect.jvm.internal.impl.load.java.structure.reflect;

import java.lang.reflect.Field;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

/* compiled from: ReflectJavaClass.kt */
final class ReflectJavaClass$fields$2 extends FunctionReference implements Function1<Field, ReflectJavaField> {
    public static final ReflectJavaClass$fields$2 f38458a = new ReflectJavaClass$fields$2();

    ReflectJavaClass$fields$2() {
        super(1);
    }

    public final KDeclarationContainer mo6931a() {
        return Reflection.m26850a(ReflectJavaField.class);
    }

    public final String mo5687b() {
        return "<init>";
    }

    public final String mo6932c() {
        return "<init>(Ljava/lang/reflect/Field;)V";
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        Field field = (Field) obj;
        Intrinsics.m26847b(field, "p1");
        return new ReflectJavaField(field);
    }
}
