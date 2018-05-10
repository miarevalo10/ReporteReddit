package kotlin.reflect.jvm.internal.impl.load.java.structure.reflect;

import java.util.Collection;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: ReflectJavaPackage.kt */
public final class ReflectJavaPackage extends ReflectJavaElement implements JavaPackage {
    private final FqName f36107a;

    public ReflectJavaPackage(FqName fqName) {
        Intrinsics.m26847b(fqName, "fqName");
        this.f36107a = fqName;
    }

    public final FqName mo6712a() {
        return this.f36107a;
    }

    public final Collection<JavaClass> mo6711a(Function1<? super Name, Boolean> function1) {
        Intrinsics.m26847b(function1, "nameFilter");
        return CollectionsKt__CollectionsKt.m26790a();
    }

    public final Collection<JavaPackage> mo6713b() {
        return CollectionsKt__CollectionsKt.m26790a();
    }

    public final boolean equals(Object obj) {
        return (!(obj instanceof ReflectJavaPackage) || Intrinsics.m26845a(this.f36107a, ((ReflectJavaPackage) obj).f36107a) == null) ? null : true;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getClass().getName());
        stringBuilder.append(": ");
        stringBuilder.append(this.f36107a);
        return stringBuilder.toString();
    }

    public final int hashCode() {
        return this.f36107a.hashCode();
    }
}
