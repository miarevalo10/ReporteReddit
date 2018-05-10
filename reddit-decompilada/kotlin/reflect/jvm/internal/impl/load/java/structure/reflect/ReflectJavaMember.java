package kotlin.reflect.jvm.internal.impl.load.java.structure.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Member;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMember;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectJavaAnnotationOwner.DefaultImpls;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectJavaType.Factory;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.name.SpecialNames;

/* compiled from: ReflectJavaMember.kt */
public abstract class ReflectJavaMember extends ReflectJavaElement implements JavaMember, ReflectJavaAnnotationOwner, ReflectJavaModifierListOwner {
    public abstract Member mo7286c();

    public final /* synthetic */ JavaAnnotation mo7092a(FqName fqName) {
        Intrinsics.m26847b(fqName, "fqName");
        return DefaultImpls.m27249a(this, fqName);
    }

    public final boolean mo7099l() {
        return ReflectJavaModifierListOwner.DefaultImpls.m27252a(this);
    }

    public final boolean mo7100m() {
        return ReflectJavaModifierListOwner.DefaultImpls.m27253b(this);
    }

    public final boolean mo7101n() {
        return ReflectJavaModifierListOwner.DefaultImpls.m27254c(this);
    }

    public final Visibility mo7102o() {
        return ReflectJavaModifierListOwner.DefaultImpls.m27255d(this);
    }

    public final AnnotatedElement mo7104r() {
        Member c = mo7286c();
        if (c != null) {
            return (AnnotatedElement) c;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.reflect.AnnotatedElement");
    }

    public final int mo7105s() {
        return mo7286c().getModifiers();
    }

    public final Name mo7103p() {
        String name = mo7286c().getName();
        if (name != null) {
            return Name.m27424a(name);
        }
        Object obj = SpecialNames.f25870a;
        Intrinsics.m26843a(obj, "SpecialNames.NO_NAME_PROVIDED");
        return obj;
    }

    protected final List<JavaValueParameter> m38465a(Type[] typeArr, Annotation[][] annotationArr, boolean z) {
        Intrinsics.m26847b(typeArr, "parameterTypes");
        Intrinsics.m26847b(annotationArr, "parameterAnnotations");
        Object[] objArr = (Object[]) typeArr;
        ArrayList arrayList = new ArrayList(objArr.length);
        Java8ParameterNamesLoader java8ParameterNamesLoader = Java8ParameterNamesLoader.f25731a;
        List a = Java8ParameterNamesLoader.m27237a(mo7286c());
        int length = typeArr.length - 1;
        if (length >= 0) {
            int i = 0;
            while (true) {
                Factory factory = ReflectJavaType.f32758b;
                ReflectJavaType a2 = Factory.m27256a(typeArr[i]);
                String str = a != null ? (String) a.get(i) : null;
                boolean z2 = z && i == ArraysKt___ArraysKt.m36107g(objArr);
                arrayList.add(new ReflectJavaValueParameter(a2, annotationArr[i], str, z2));
                if (i == length) {
                    break;
                }
                i++;
            }
        }
        return arrayList;
    }

    public boolean equals(Object obj) {
        return (!(obj instanceof ReflectJavaMember) || Intrinsics.m26845a(mo7286c(), ((ReflectJavaMember) obj).mo7286c()) == null) ? null : true;
    }

    public int hashCode() {
        return mo7286c().hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getClass().getName());
        stringBuilder.append(": ");
        stringBuilder.append(mo7286c());
        return stringBuilder.toString();
    }

    public final /* synthetic */ JavaClass mo7098d() {
        Object declaringClass = mo7286c().getDeclaringClass();
        Intrinsics.m26843a(declaringClass, "member.declaringClass");
        return new ReflectJavaClass(declaringClass);
    }

    public final /* bridge */ /* synthetic */ Collection mo7091a() {
        return DefaultImpls.m27248a(this);
    }
}
