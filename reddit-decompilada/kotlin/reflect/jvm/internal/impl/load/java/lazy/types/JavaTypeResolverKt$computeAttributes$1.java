package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;

/* compiled from: JavaTypeResolver.kt */
public final class JavaTypeResolverKt$computeAttributes$1 implements JavaTypeAttributes {
    final /* synthetic */ JavaTypeAttributes f32731a;
    final /* synthetic */ boolean f32732b;
    final /* synthetic */ boolean f32733c;
    final /* synthetic */ boolean f32734d;
    private final JavaTypeFlexibility f32735e;
    private final RawBound f32736f;
    private final /* synthetic */ JavaTypeAttributes f32737g = this.f32731a;

    public final TypeUsage mo5786a() {
        return this.f32737g.mo5786a();
    }

    public final TypeUsage mo5787b() {
        return this.f32737g.mo5787b();
    }

    public final boolean mo5788c() {
        return this.f32737g.mo5788c();
    }

    public final boolean mo5790e() {
        return this.f32737g.mo5790e();
    }

    public final Annotations mo5791f() {
        return this.f32737g.mo5791f();
    }

    public final boolean mo5792g() {
        return this.f32737g.mo5792g();
    }

    public final TypeParameterDescriptor mo5793h() {
        return this.f32737g.mo5793h();
    }

    JavaTypeResolverKt$computeAttributes$1(JavaTypeAttributes javaTypeAttributes, boolean z, boolean z2, boolean z3) {
        this.f32731a = javaTypeAttributes;
        this.f32732b = z;
        this.f32733c = z2;
        this.f32734d = z3;
        javaTypeAttributes = !z ? JavaTypeFlexibility.f25716a : z2 ? JavaTypeFlexibility.f25718c : JavaTypeFlexibility.f25717b;
        this.f32735e = javaTypeAttributes;
        javaTypeAttributes = !z3 ? RawBound.f25725c : z2 ? RawBound.f25723a : RawBound.f25724b;
        this.f32736f = javaTypeAttributes;
    }

    public final JavaTypeFlexibility mo5789d() {
        return this.f32735e;
    }

    public final RawBound mo5794i() {
        return this.f32736f;
    }
}
