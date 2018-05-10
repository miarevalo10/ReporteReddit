package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;

/* compiled from: JavaTypeResolver.kt */
public interface JavaTypeAttributes {

    /* compiled from: JavaTypeResolver.kt */
    public static final class DefaultImpls {
        public static JavaTypeFlexibility m27209a() {
            return JavaTypeFlexibility.f25716a;
        }

        public static RawBound m27210b() {
            return RawBound.f25725c;
        }
    }

    TypeUsage mo5786a();

    TypeUsage mo5787b();

    boolean mo5788c();

    JavaTypeFlexibility mo5789d();

    boolean mo5790e();

    Annotations mo5791f();

    boolean mo5792g();

    TypeParameterDescriptor mo5793h();

    RawBound mo5794i();
}
