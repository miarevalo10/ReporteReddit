package kotlin.reflect.jvm.internal.impl.load.java.structure.reflect;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectJavaAnnotationOwner.DefaultImpls;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.sequences.SequencesKt___SequencesKt;

/* compiled from: ReflectJavaClass.kt */
public final class ReflectJavaClass extends ReflectJavaElement implements JavaClass, ReflectJavaAnnotationOwner, ReflectJavaModifierListOwner {
    public final Class<?> f39725a;

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

    public ReflectJavaClass(Class<?> cls) {
        Intrinsics.m26847b(cls, "klass");
        this.f39725a = cls;
    }

    public final int mo7105s() {
        return this.f39725a.getModifiers();
    }

    public final FqName mo7274b() {
        Object f = ReflectClassUtilKt.m27244e(this.f39725a).m27403f();
        Intrinsics.m26843a(f, "klass.classId.asSingleFqName()");
        return f;
    }

    public final Collection<JavaClassifierType> mo7275c() {
        if (Intrinsics.m26845a(this.f39725a, (Object) Object.class)) {
            return CollectionsKt__CollectionsKt.m26790a();
        }
        SpreadBuilder spreadBuilder = new SpreadBuilder();
        Object genericSuperclass = this.f39725a.getGenericSuperclass();
        if (genericSuperclass == null) {
            genericSuperclass = Object.class;
        }
        spreadBuilder.m26867b(genericSuperclass);
        genericSuperclass = this.f39725a.getGenericInterfaces();
        Intrinsics.m26843a(genericSuperclass, "klass.genericInterfaces");
        spreadBuilder.m26865a(genericSuperclass);
        Iterable<Type> b = CollectionsKt__CollectionsKt.m26796b((Object[]) (Type[]) spreadBuilder.m26866a(new Type[spreadBuilder.f25294a.size()]));
        Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(b));
        for (Type reflectJavaClassifierType : b) {
            arrayList.add(new ReflectJavaClassifierType(reflectJavaClassifierType));
        }
        return (List) arrayList;
    }

    public final Name mo7103p() {
        Object a = Name.m27424a(this.f39725a.getSimpleName());
        Intrinsics.m26843a(a, "Name.identifier(klass.simpleName)");
        return a;
    }

    public final List<ReflectJavaTypeParameter> mo7284q() {
        Object[] objArr = (Object[]) this.f39725a.getTypeParameters();
        Collection arrayList = new ArrayList(objArr.length);
        for (Object obj : objArr) {
            Object obj2 = (TypeVariable) obj2;
            Intrinsics.m26843a(obj2, "it");
            arrayList.add(new ReflectJavaTypeParameter(obj2));
        }
        return (List) arrayList;
    }

    public final boolean mo7278f() {
        return this.f39725a.isInterface();
    }

    public final boolean mo7279g() {
        return this.f39725a.isAnnotation();
    }

    public final boolean mo7280h() {
        return this.f39725a.isEnum();
    }

    public final boolean equals(Object obj) {
        return (!(obj instanceof ReflectJavaClass) || Intrinsics.m26845a(this.f39725a, ((ReflectJavaClass) obj).f39725a) == null) ? null : true;
    }

    public final int hashCode() {
        return this.f39725a.hashCode();
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getClass().getName());
        stringBuilder.append(": ");
        stringBuilder.append(this.f39725a);
        return stringBuilder.toString();
    }

    public final /* bridge */ /* synthetic */ AnnotatedElement mo7104r() {
        return this.f39725a;
    }

    public final /* synthetic */ Collection mo7276d() {
        return SequencesKt___SequencesKt.m33713d(SequencesKt___SequencesKt.m33716e(SequencesKt___SequencesKt.m33710b(ArraysKt___ArraysKt.m36114n((Object[]) this.f39725a.getDeclaredClasses()), ReflectJavaClass$innerClasses$1.f38459a), ReflectJavaClass$innerClasses$2.f38460a));
    }

    public final /* synthetic */ JavaClass mo7277e() {
        Class declaringClass = this.f39725a.getDeclaringClass();
        return declaringClass != null ? new ReflectJavaClass(declaringClass) : null;
    }

    public final /* synthetic */ Collection mo7281i() {
        return SequencesKt___SequencesKt.m33713d(SequencesKt___SequencesKt.m33716e(SequencesKt___SequencesKt.m33708a(ArraysKt___ArraysKt.m36114n((Object[]) this.f39725a.getDeclaredMethods()), (Function1) new ReflectJavaClass$methods$1(this)), ReflectJavaClass$methods$2.f38462a));
    }

    public final /* synthetic */ Collection mo7282j() {
        return SequencesKt___SequencesKt.m33713d(SequencesKt___SequencesKt.m33716e(SequencesKt___SequencesKt.m33708a(ArraysKt___ArraysKt.m36114n((Object[]) this.f39725a.getDeclaredFields()), (Function1) ReflectJavaClass$fields$1.f38457a), ReflectJavaClass$fields$2.f38458a));
    }

    public final /* synthetic */ Collection mo7283k() {
        return SequencesKt___SequencesKt.m33713d(SequencesKt___SequencesKt.m33716e(SequencesKt___SequencesKt.m33708a(ArraysKt___ArraysKt.m36114n((Object[]) this.f39725a.getDeclaredConstructors()), (Function1) ReflectJavaClass$constructors$1.f38455a), ReflectJavaClass$constructors$2.f38456a));
    }

    public final /* bridge */ /* synthetic */ Collection mo7091a() {
        return DefaultImpls.m27248a(this);
    }

    public static final /* synthetic */ boolean m39887a(Method method) {
        String name = method.getName();
        if (name != null) {
            int hashCode = name.hashCode();
            if (hashCode == -823812830) {
                return name.equals("values") && ((Object[]) method.getParameterTypes()).length == null;
            } else {
                if (hashCode == 231605032) {
                    if (name.equals("valueOf")) {
                        return Arrays.equals((Object[]) method.getParameterTypes(), (Object[]) new Class[]{String.class});
                    }
                }
            }
        }
        return false;
    }
}
