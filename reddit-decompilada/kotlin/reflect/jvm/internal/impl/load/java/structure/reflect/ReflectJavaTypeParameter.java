package kotlin.reflect.jvm.internal.impl.load.java.structure.reflect;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectJavaAnnotationOwner.DefaultImpls;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: ReflectJavaTypeParameter.kt */
public final class ReflectJavaTypeParameter extends ReflectJavaElement implements JavaTypeParameter, ReflectJavaAnnotationOwner {
    private final TypeVariable<?> f39729a;

    public final /* synthetic */ JavaAnnotation mo7092a(FqName fqName) {
        Intrinsics.m26847b(fqName, "fqName");
        return DefaultImpls.m27249a(this, fqName);
    }

    public ReflectJavaTypeParameter(TypeVariable<?> typeVariable) {
        Intrinsics.m26847b(typeVariable, "typeVariable");
        this.f39729a = typeVariable;
    }

    public final AnnotatedElement mo7104r() {
        TypeVariable typeVariable = this.f39729a;
        if (!(typeVariable instanceof AnnotatedElement)) {
            typeVariable = null;
        }
        return (AnnotatedElement) typeVariable;
    }

    public final Name mo7103p() {
        Object a = Name.m27424a(this.f39729a.getName());
        Intrinsics.m26843a(a, "Name.identifier(typeVariable.name)");
        return a;
    }

    public final boolean equals(Object obj) {
        return (!(obj instanceof ReflectJavaTypeParameter) || Intrinsics.m26845a(this.f39729a, ((ReflectJavaTypeParameter) obj).f39729a) == null) ? null : true;
    }

    public final int hashCode() {
        return this.f39729a.hashCode();
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getClass().getName());
        stringBuilder.append(": ");
        stringBuilder.append(this.f39729a);
        return stringBuilder.toString();
    }

    public final /* synthetic */ Collection mo7292b() {
        Object obj;
        Object[] objArr = (Object[]) this.f39729a.getBounds();
        Collection arrayList = new ArrayList(objArr.length);
        for (Object obj2 : objArr) {
            Object obj22 = (Type) obj22;
            Intrinsics.m26843a(obj22, "bound");
            arrayList.add(new ReflectJavaClassifierType(obj22));
        }
        List list = (List) arrayList;
        ReflectJavaClassifierType reflectJavaClassifierType = (ReflectJavaClassifierType) CollectionsKt___CollectionsKt.m41443i(list);
        if (reflectJavaClassifierType != null) {
            obj = reflectJavaClassifierType.f38463a;
        } else {
            obj = null;
        }
        if (Intrinsics.m26845a(obj, (Object) Object.class)) {
            list = CollectionsKt__CollectionsKt.m26790a();
        }
        return list;
    }

    public final /* bridge */ /* synthetic */ Collection mo7091a() {
        return DefaultImpls.m27248a(this);
    }
}
