package kotlin.reflect.jvm.internal.impl.load.java.structure.reflect;

import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.functions.Function11;
import kotlin.jvm.functions.Function12;
import kotlin.jvm.functions.Function13;
import kotlin.jvm.functions.Function14;
import kotlin.jvm.functions.Function15;
import kotlin.jvm.functions.Function16;
import kotlin.jvm.functions.Function17;
import kotlin.jvm.functions.Function18;
import kotlin.jvm.functions.Function19;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function20;
import kotlin.jvm.functions.Function21;
import kotlin.jvm.functions.Function22;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.functions.Function9;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: reflectClassUtil.kt */
public final class ReflectClassUtilKt {
    private static final List<KClass<? extends Object>> f25733a;
    private static final Map<Class<? extends Object>, Class<? extends Object>> f25734b;
    private static final Map<Class<? extends Object>, Class<? extends Object>> f25735c;
    private static final Map<Class<? extends Function<?>>, Integer> f25736d;

    public static final ClassLoader m27239a(Class<?> cls) {
        Intrinsics.m26847b(cls, "$receiver");
        cls = cls.getClassLoader();
        if (cls != null) {
            return cls;
        }
        Object systemClassLoader = ClassLoader.getSystemClassLoader();
        Intrinsics.m26843a(systemClassLoader, "ClassLoader.getSystemClassLoader()");
        return systemClassLoader;
    }

    public static final boolean m27241b(Class<?> cls) {
        Intrinsics.m26847b(cls, "$receiver");
        return Enum.class.isAssignableFrom(cls);
    }

    static {
        r1 = new KClass[8];
        int i = 0;
        r1[0] = Reflection.m26850a(Boolean.TYPE);
        r1[1] = Reflection.m26850a(Byte.TYPE);
        r1[2] = Reflection.m26850a(Character.TYPE);
        r1[3] = Reflection.m26850a(Double.TYPE);
        r1[4] = Reflection.m26850a(Float.TYPE);
        r1[5] = Reflection.m26850a(Integer.TYPE);
        r1[6] = Reflection.m26850a(Long.TYPE);
        r1[7] = Reflection.m26850a(Short.TYPE);
        List b = CollectionsKt__CollectionsKt.m26796b((Object[]) r1);
        f25733a = b;
        Iterable<KClass> iterable = b;
        Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
        for (KClass kClass : iterable) {
            arrayList.add(TuplesKt.m26780a(JvmClassMappingKt.m26833c(kClass), JvmClassMappingKt.m26832b(kClass)));
        }
        f25734b = MapsKt__MapsKt.m36117a((Iterable) (List) arrayList);
        iterable = f25733a;
        arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
        for (KClass kClass2 : iterable) {
            arrayList.add(TuplesKt.m26780a(JvmClassMappingKt.m26832b(kClass2), JvmClassMappingKt.m26833c(kClass2)));
        }
        f25735c = MapsKt__MapsKt.m36117a((Iterable) (List) arrayList);
        Iterable<Class> b2 = CollectionsKt__CollectionsKt.m26796b((Object[]) new Class[]{Function0.class, Function1.class, Function2.class, Function3.class, Function4.class, Function5.class, Function6.class, Function7.class, Function8.class, Function9.class, Function10.class, Function11.class, Function12.class, Function13.class, Function14.class, Function15.class, Function16.class, Function17.class, Function18.class, Function19.class, Function20.class, Function21.class, Function22.class});
        Collection arrayList2 = new ArrayList(CollectionsKt__IterablesKt.m32812b(b2));
        for (Class a : b2) {
            int i2 = i + 1;
            arrayList2.add(TuplesKt.m26780a(a, Integer.valueOf(i)));
            i = i2;
        }
        f25736d = MapsKt__MapsKt.m36117a((Iterable) (List) arrayList2);
    }

    public static final Class<?> m27242c(Class<?> cls) {
        Intrinsics.m26847b(cls, "$receiver");
        return (Class) f25734b.get(cls);
    }

    public static final Class<?> m27243d(Class<?> cls) {
        Intrinsics.m26847b(cls, "$receiver");
        return (Class) f25735c.get(cls);
    }

    public static final ClassId m27244e(Class<?> cls) {
        Intrinsics.m26847b(cls, "$receiver");
        StringBuilder stringBuilder;
        if (cls.isPrimitive()) {
            stringBuilder = new StringBuilder("Can't compute ClassId for primitive type: ");
            stringBuilder.append(cls);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (cls.isArray()) {
            stringBuilder = new StringBuilder("Can't compute ClassId for array type: ");
            stringBuilder.append(cls);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else {
            if (cls.getEnclosingMethod() == null && cls.getEnclosingConstructor() == null) {
                if (!(((CharSequence) cls.getSimpleName()).length() == 0)) {
                    Class declaringClass = cls.getDeclaringClass();
                    if (declaringClass != null) {
                        ClassId e = m27244e(declaringClass);
                        if (e != null) {
                            return e.m27397a(Name.m27424a(cls.getSimpleName()));
                        }
                    }
                    Object a = ClassId.m27396a(new FqName(cls.getName()));
                    Intrinsics.m26843a(a, "ClassId.topLevel(FqName(name))");
                    return a;
                }
            }
            FqName fqName = new FqName(cls.getName());
            return new ClassId(fqName.m27411d(), FqName.m27406b(fqName.m27412e()), true);
        }
    }

    public static final String m27245f(Class<?> cls) {
        Intrinsics.m26847b(cls, "$receiver");
        if (Intrinsics.m26845a((Object) cls, Void.TYPE)) {
            return "V";
        }
        cls = m27246g(cls).getName();
        if (cls == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        Object substring = ((String) cls).substring(1);
        Intrinsics.m26843a(substring, "(this as java.lang.String).substring(startIndex)");
        return StringsKt__StringsJVMKt.m41941a((String) substring, '.', '/');
    }

    public static final Class<?> m27246g(Class<?> cls) {
        Intrinsics.m26847b(cls, "$receiver");
        return Array.newInstance(cls, 0).getClass();
    }

    public static final List<Type> m27240a(Type type) {
        Intrinsics.m26847b(type, "$receiver");
        if (!(type instanceof ParameterizedType)) {
            return CollectionsKt__CollectionsKt.m26790a();
        }
        ParameterizedType parameterizedType = (ParameterizedType) type;
        if (parameterizedType.getOwnerType() == null) {
            return ArraysKt___ArraysKt.m36109i((Object[]) parameterizedType.getActualTypeArguments());
        }
        return SequencesKt___SequencesKt.m33713d(SequencesKt___SequencesKt.m33714d(SequencesKt__SequencesKt.m28142a(type, ReflectClassUtilKt$parameterizedTypeArguments$1.f38453a), ReflectClassUtilKt$parameterizedTypeArguments$2.f38454a));
    }
}
