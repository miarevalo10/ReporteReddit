package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* compiled from: JavaTypeResolver.kt */
final class JavaTypeResolver$transformJavaClassifierType$1 extends Lambda implements Function0<SimpleType> {
    final /* synthetic */ JavaClassifierType f38440a;

    JavaTypeResolver$transformJavaClassifierType$1(JavaClassifierType javaClassifierType) {
        this.f38440a = javaClassifierType;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        return m38407a();
    }

    public final SimpleType m38407a() {
        StringBuilder stringBuilder = new StringBuilder("Unresolved java class ");
        stringBuilder.append(this.f38440a.mo7097f());
        return ErrorUtils.m27943c(stringBuilder.toString());
    }
}
