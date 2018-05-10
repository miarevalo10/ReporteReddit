package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* compiled from: JavaTypeResolver.kt */
final class JavaTypeResolver$transformJavaClassifierType$2 extends Lambda implements Function1<Boolean, SimpleType> {
    final /* synthetic */ JavaTypeResolver f38441a;
    final /* synthetic */ JavaClassifierType f38442b;
    final /* synthetic */ JavaTypeAttributes f38443c;
    final /* synthetic */ boolean f38444d;
    final /* synthetic */ boolean f38445e;

    JavaTypeResolver$transformJavaClassifierType$2(JavaTypeResolver javaTypeResolver, JavaClassifierType javaClassifierType, JavaTypeAttributes javaTypeAttributes, boolean z, boolean z2) {
        this.f38441a = javaTypeResolver;
        this.f38442b = javaClassifierType;
        this.f38443c = javaTypeAttributes;
        this.f38444d = z;
        this.f38445e = z2;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        return m38409a(((Boolean) obj).booleanValue());
    }

    public final SimpleType m38409a(boolean z) {
        return this.f38441a.m27222a(this.f38442b, JavaTypeResolverKt.m27227a(this.f38443c, this.f38444d, this.f38445e, z));
    }
}
