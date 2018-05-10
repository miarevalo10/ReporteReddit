package kotlin.reflect.jvm.internal;

import java.util.Collection;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.ReflectProperties.LazySoftVal;
import kotlin.reflect.jvm.internal.ReflectProperties.LazyVal;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001:\u0001+B\u0019\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0002J\u0016\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\b2\u0006\u0010$\u001a\u00020%H\u0016J\u0016\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\b2\u0006\u0010$\u001a\u00020%H\u0016J\b\u0010(\u001a\u00020)H\u0016J\b\u0010*\u001a\u00020\u0005H\u0016R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR)\u0010\f\u001a\u001d\u0012\u0014\u0012\u0012 \u000f*\b\u0018\u00010\u000eR\u00020\u00000\u000eR\u00020\u00000\r¢\u0006\u0002\b\u0010X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00140\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u000bR\u0018\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u00038TX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u001b8BX\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d¨\u0006,"}, d2 = {"Lkotlin/reflect/jvm/internal/KPackageImpl;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "jClass", "Ljava/lang/Class;", "moduleName", "", "(Ljava/lang/Class;Ljava/lang/String;)V", "constructorDescriptors", "", "Lorg/jetbrains/kotlin/descriptors/ConstructorDescriptor;", "getConstructorDescriptors", "()Ljava/util/Collection;", "data", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "Lkotlin/reflect/jvm/internal/KPackageImpl$Data;", "kotlin.jvm.PlatformType", "Lorg/jetbrains/annotations/NotNull;", "getJClass", "()Ljava/lang/Class;", "members", "Lkotlin/reflect/KCallable;", "getMembers", "methodOwner", "getMethodOwner", "getModuleName", "()Ljava/lang/String;", "scope", "Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;", "getScope", "()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;", "equals", "", "other", "", "getFunctions", "Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;", "name", "Lorg/jetbrains/kotlin/name/Name;", "getProperties", "Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;", "hashCode", "", "toString", "Data", "kotlin-reflection"}, k = 1, mv = {1, 1, 5})
/* compiled from: KPackageImpl.kt */
public final class KPackageImpl extends KDeclarationContainerImpl {
    final Class<?> f38266a;
    final String f38267b;
    private final LazyVal<Data> f38268d = ReflectProperties.m26918a((Function0) new KPackageImpl$data$1(this));

    @Metadata(bv = {1, 0, 1}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u001b\u0010\u0004\u001a\u00020\u00058FX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R%\u0010\n\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f0\u000b8FX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\t\u001a\u0004\b\r\u0010\u000eR\u001f\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u00118FX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lkotlin/reflect/jvm/internal/KPackageImpl$Data;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$Data;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "(Lkotlin/reflect/jvm/internal/KPackageImpl;)V", "descriptor", "Lorg/jetbrains/kotlin/descriptors/PackageViewDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PackageViewDescriptor;", "descriptor$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "members", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "getMembers", "()Ljava/util/Collection;", "members$delegate", "methodOwner", "Ljava/lang/Class;", "getMethodOwner", "()Ljava/lang/Class;", "methodOwner$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "kotlin-reflection"}, k = 1, mv = {1, 1, 5})
    /* compiled from: KPackageImpl.kt */
    private final class Data extends kotlin.reflect.jvm.internal.KDeclarationContainerImpl.Data {
        static final /* synthetic */ KProperty[] f32591c = new KProperty[]{Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(Data.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/PackageViewDescriptor;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(Data.class), "methodOwner", "getMethodOwner()Ljava/lang/Class;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(Data.class), "members", "getMembers()Ljava/util/Collection;"))};
        final LazySoftVal f32592a = ReflectProperties.m26919b((Function0) new KPackageImpl$Data$descriptor$2(this));
        final LazyVal f32593b = ReflectProperties.m26918a((Function0) new KPackageImpl$Data$methodOwner$2(this));
        final /* synthetic */ KPackageImpl f32594d;
        private final LazySoftVal f32595e = ReflectProperties.m26919b((Function0) new KPackageImpl$Data$members$2(this));

        public Data(KPackageImpl kPackageImpl) {
            this.f32594d = kPackageImpl;
            super(kPackageImpl);
        }
    }

    public KPackageImpl(Class<?> cls, String str) {
        Intrinsics.m26847b(cls, "jClass");
        Intrinsics.m26847b(str, "moduleName");
        this.f38266a = cls;
        this.f38267b = str;
    }

    public final Class<?> mo6657a() {
        return this.f38266a;
    }

    protected final Class<?> mo7072f() {
        return (Class) ((Data) this.f38268d.mo5694a()).f32593b.mo5694a();
    }

    private final MemberScope m38255c() {
        return ((PackageViewDescriptor) ((Data) this.f38268d.mo5694a()).f32592a.mo5694a()).mo7081c();
    }

    public final Collection<ConstructorDescriptor> mo7070b() {
        return CollectionsKt__CollectionsKt.m26790a();
    }

    public final Collection<PropertyDescriptor> mo7069a(Name name) {
        Intrinsics.m26847b(name, "name");
        return m38255c().mo6694a(name, NoLookupLocation.f32678h);
    }

    public final Collection<FunctionDescriptor> mo7071b(Name name) {
        Intrinsics.m26847b(name, "name");
        return m38255c().mo6698b(name, NoLookupLocation.f32678h);
    }

    public final boolean equals(Object obj) {
        return (!(obj instanceof KPackageImpl) || Intrinsics.m26845a(this.f38266a, ((KPackageImpl) obj).f38266a) == null) ? null : true;
    }

    public final int hashCode() {
        return this.f38266a.hashCode();
    }

    public final String toString() {
        String str;
        FqName a = ReflectClassUtilKt.m27244e(this.f38266a).m27398a();
        StringBuilder stringBuilder = new StringBuilder("package ");
        if (a.f25856b.f25861b.isEmpty()) {
            str = "<default>";
        } else {
            str = a.m27407a();
            Intrinsics.m26843a((Object) str, "fqName.asString()");
        }
        stringBuilder.append(str);
        return stringBuilder.toString();
    }
}
