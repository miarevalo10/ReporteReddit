package kotlin.reflect.jvm.internal.impl.platform;

import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.builtins.CompanionObjectMapping;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.name.SpecialNames;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;

public class JavaToKotlinClassMap {
    public static final JavaToKotlinClassMap f25878a = new JavaToKotlinClassMap();
    static final /* synthetic */ boolean f25879d = true;
    public final Map<FqNameUnsafe, FqName> f25880b = new HashMap();
    public final Map<FqNameUnsafe, FqName> f25881c = new HashMap();
    private final Map<FqNameUnsafe, ClassId> f25882e = new HashMap();
    private final Map<FqNameUnsafe, ClassId> f25883f = new HashMap();

    private JavaToKotlinClassMap() {
        m27438a(Object.class, KotlinBuiltIns.f25420j.f25380a);
        m27438a(String.class, KotlinBuiltIns.f25420j.f25386g);
        m27438a(CharSequence.class, KotlinBuiltIns.f25420j.f25385f);
        m27437a(Throwable.class, KotlinBuiltIns.f25420j.f25398s);
        m27438a(Cloneable.class, KotlinBuiltIns.f25420j.f25382c);
        m27438a(Number.class, KotlinBuiltIns.f25420j.f25396q);
        m27437a(Comparable.class, KotlinBuiltIns.f25420j.f25399t);
        m27438a(Enum.class, KotlinBuiltIns.f25420j.f25397r);
        m27437a(Annotation.class, KotlinBuiltIns.f25420j.f25355B);
        m27436a(Iterable.class, ClassId.m27396a(KotlinBuiltIns.f25420j.f25365L), KotlinBuiltIns.f25420j.f25373T);
        m27436a(Iterator.class, ClassId.m27396a(KotlinBuiltIns.f25420j.f25364K), KotlinBuiltIns.f25420j.f25372S);
        m27436a(Collection.class, ClassId.m27396a(KotlinBuiltIns.f25420j.f25366M), KotlinBuiltIns.f25420j.f25374U);
        m27436a(List.class, ClassId.m27396a(KotlinBuiltIns.f25420j.f25367N), KotlinBuiltIns.f25420j.f25375V);
        m27436a(Set.class, ClassId.m27396a(KotlinBuiltIns.f25420j.f25369P), KotlinBuiltIns.f25420j.f25377X);
        m27436a(ListIterator.class, ClassId.m27396a(KotlinBuiltIns.f25420j.f25368O), KotlinBuiltIns.f25420j.f25376W);
        ClassId a = ClassId.m27396a(KotlinBuiltIns.f25420j.f25370Q);
        m27436a(Map.class, a, KotlinBuiltIns.f25420j.f25378Y);
        m27436a(Entry.class, a.m27397a(KotlinBuiltIns.f25420j.f25371R.m27412e()), KotlinBuiltIns.f25420j.f25379Z);
        int i = 0;
        for (JvmPrimitiveType jvmPrimitiveType : JvmPrimitiveType.values()) {
            m27439a(ClassId.m27396a(jvmPrimitiveType.m27758d()), ClassId.m27396a(KotlinBuiltIns.m26978b(jvmPrimitiveType.m27755a())));
        }
        CompanionObjectMapping companionObjectMapping = CompanionObjectMapping.f25352a;
        for (ClassId classId : CompanionObjectMapping.m26942a()) {
            StringBuilder stringBuilder = new StringBuilder("kotlin.jvm.internal.");
            stringBuilder.append(classId.m27400c().m27429a());
            stringBuilder.append("CompanionObject");
            m27439a(ClassId.m27396a(new FqName(stringBuilder.toString())), classId.m27397a(SpecialNames.f25872c));
        }
        while (i < 23) {
            StringBuilder stringBuilder2 = new StringBuilder("kotlin.jvm.functions.Function");
            stringBuilder2.append(i);
            m27439a(ClassId.m27396a(new FqName(stringBuilder2.toString())), KotlinBuiltIns.m26977b(i));
            Kind kind = Kind.f25458c;
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(kind.f25461d);
            stringBuilder2.append(".");
            stringBuilder2.append(kind.f25462e);
            String stringBuilder3 = stringBuilder2.toString();
            StringBuilder stringBuilder4 = new StringBuilder();
            stringBuilder4.append(stringBuilder3);
            stringBuilder4.append(i);
            m27440a(new FqName(stringBuilder4.toString()), ClassId.m27396a(new FqName(stringBuilder3)));
            i++;
        }
        m27440a(KotlinBuiltIns.f25420j.f25381b.m27420d(), m27435a(Void.class));
    }

    public final ClassId m27442a(FqName fqName) {
        if (fqName != null) {
            return (ClassId) this.f25882e.get(fqName.m27409b());
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"fqName", "kotlin/reflect/jvm/internal/impl/platform/JavaToKotlinClassMap", "mapJavaToKotlin"}));
    }

    public final ClassDescriptor m27441a(FqName fqName, KotlinBuiltIns kotlinBuiltIns) {
        if (fqName == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"fqName", "kotlin/reflect/jvm/internal/impl/platform/JavaToKotlinClassMap", "mapJavaToKotlin"}));
        } else if (kotlinBuiltIns == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"builtIns", "kotlin/reflect/jvm/internal/impl/platform/JavaToKotlinClassMap", "mapJavaToKotlin"}));
        } else {
            fqName = m27442a(fqName);
            return fqName != null ? kotlinBuiltIns.m26998a(fqName.m27403f()) : null;
        }
    }

    public final ClassId m27443a(FqNameUnsafe fqNameUnsafe) {
        if (fqNameUnsafe != null) {
            return (ClassId) this.f25883f.get(fqNameUnsafe);
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"kotlinFqName", "kotlin/reflect/jvm/internal/impl/platform/JavaToKotlinClassMap", "mapKotlinToJava"}));
    }

    private void m27436a(Class<?> cls, ClassId classId, FqName fqName) {
        if (classId == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"kotlinReadOnlyClassId", "kotlin/reflect/jvm/internal/impl/platform/JavaToKotlinClassMap", "addMutableReadOnlyPair"}));
        } else if (fqName == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"kotlinMutableFqName", "kotlin/reflect/jvm/internal/impl/platform/JavaToKotlinClassMap", "addMutableReadOnlyPair"}));
        } else {
            ClassId a = m27435a((Class) cls);
            m27439a(a, classId);
            m27440a(fqName, a);
            cls = classId.m27403f();
            this.f25880b.put(fqName.m27409b(), cls);
            this.f25881c.put(cls.m27409b(), fqName);
        }
    }

    private void m27439a(ClassId classId, ClassId classId2) {
        if (classId == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"javaClassId", "kotlin/reflect/jvm/internal/impl/platform/JavaToKotlinClassMap", "add"}));
        } else if (classId2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"kotlinClassId", "kotlin/reflect/jvm/internal/impl/platform/JavaToKotlinClassMap", "add"}));
        } else if (classId == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"javaClassId", "kotlin/reflect/jvm/internal/impl/platform/JavaToKotlinClassMap", "addJavaToKotlin"}));
        } else if (classId2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"kotlinClassId", "kotlin/reflect/jvm/internal/impl/platform/JavaToKotlinClassMap", "addJavaToKotlin"}));
        } else {
            this.f25882e.put(classId.m27403f().m27409b(), classId2);
            m27440a(classId2.m27403f(), classId);
        }
    }

    private void m27438a(Class<?> cls, FqNameUnsafe fqNameUnsafe) {
        if (fqNameUnsafe == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"kotlinFqName", "kotlin/reflect/jvm/internal/impl/platform/JavaToKotlinClassMap", "addTopLevel"}));
        } else {
            m27437a((Class) cls, fqNameUnsafe.m27420d());
        }
    }

    private void m27437a(Class<?> cls, FqName fqName) {
        if (cls == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"javaClass", "kotlin/reflect/jvm/internal/impl/platform/JavaToKotlinClassMap", "addTopLevel"}));
        } else if (fqName == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"kotlinFqName", "kotlin/reflect/jvm/internal/impl/platform/JavaToKotlinClassMap", "addTopLevel"}));
        } else {
            m27439a(m27435a((Class) cls), ClassId.m27396a(fqName));
        }
    }

    private void m27440a(FqName fqName, ClassId classId) {
        if (fqName == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"kotlinFqNameUnsafe", "kotlin/reflect/jvm/internal/impl/platform/JavaToKotlinClassMap", "addKotlinToJava"}));
        } else if (classId == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"javaClassId", "kotlin/reflect/jvm/internal/impl/platform/JavaToKotlinClassMap", "addKotlinToJava"}));
        } else {
            this.f25883f.put(fqName.m27409b(), classId);
        }
    }

    private static ClassId m27435a(Class<?> cls) {
        if (cls == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"clazz", "kotlin/reflect/jvm/internal/impl/platform/JavaToKotlinClassMap", "classId"}));
        } else if (f25879d || !(cls.isPrimitive() || cls.isArray())) {
            Class declaringClass = cls.getDeclaringClass();
            return declaringClass == null ? ClassId.m27396a(new FqName(cls.getCanonicalName())) : m27435a(declaringClass).m27397a(Name.m27424a(cls.getSimpleName()));
        } else {
            StringBuilder stringBuilder = new StringBuilder("Invalid class: ");
            stringBuilder.append(cls);
            throw new AssertionError(stringBuilder.toString());
        }
    }

    public final boolean m27444a(ClassDescriptor classDescriptor) {
        if (classDescriptor != null) {
            return this.f25880b.containsKey(DescriptorUtils.m27653c(classDescriptor));
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"mutable", "kotlin/reflect/jvm/internal/impl/platform/JavaToKotlinClassMap", "isMutable"}));
    }

    public final boolean m27445b(ClassDescriptor classDescriptor) {
        if (classDescriptor != null) {
            return this.f25881c.containsKey(DescriptorUtils.m27653c(classDescriptor));
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"readOnly", "kotlin/reflect/jvm/internal/impl/platform/JavaToKotlinClassMap", "isReadOnly"}));
    }

    public static ClassDescriptor m27434a(ClassDescriptor classDescriptor, Map<FqNameUnsafe, FqName> map, String str) {
        if (classDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"descriptor", "kotlin/reflect/jvm/internal/impl/platform/JavaToKotlinClassMap", "convertToOppositeMutability"}));
        } else if (map == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"map", "kotlin/reflect/jvm/internal/impl/platform/JavaToKotlinClassMap", "convertToOppositeMutability"}));
        } else {
            FqName fqName = (FqName) map.get(DescriptorUtils.m27653c(classDescriptor));
            if (fqName == null) {
                StringBuilder stringBuilder = new StringBuilder("Given class ");
                stringBuilder.append(classDescriptor);
                stringBuilder.append(" is not a ");
                stringBuilder.append(str);
                stringBuilder.append(" collection");
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            classDescriptor = DescriptorUtilsKt.m27745d(classDescriptor).m26998a(fqName);
            if (classDescriptor != null) {
                return classDescriptor;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/platform/JavaToKotlinClassMap", "convertToOppositeMutability"}));
        }
    }

    public final ClassDescriptor m27446c(ClassDescriptor classDescriptor) {
        if (classDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"readOnly", "kotlin/reflect/jvm/internal/impl/platform/JavaToKotlinClassMap", "convertReadOnlyToMutable"}));
        }
        classDescriptor = m27434a(classDescriptor, this.f25881c, "read-only");
        if (classDescriptor != null) {
            return classDescriptor;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/platform/JavaToKotlinClassMap", "convertReadOnlyToMutable"}));
    }
}
