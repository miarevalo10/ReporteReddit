package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.reflect.jvm.internal.impl.builtins.CompanionObjectMapping;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.util.capitalizeDecapitalize.CapitalizeDecapitalizeKt;

public final class JvmAbi {
    public static final ClassId f25629a = ClassId.m27396a(new FqName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl"));

    public static boolean m27152a(String str) {
        if (str == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"name", "kotlin/reflect/jvm/internal/impl/load/java/JvmAbi", "isGetterName"}));
        }
        if (!str.startsWith("get")) {
            if (str.startsWith("is") == null) {
                return false;
            }
        }
        return true;
    }

    public static boolean m27154b(String str) {
        if (str != null) {
            return str.startsWith("set");
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"name", "kotlin/reflect/jvm/internal/impl/load/java/JvmAbi", "isSetterName"}));
    }

    public static String m27155c(String str) {
        if (str == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"propertyName", "kotlin/reflect/jvm/internal/impl/load/java/JvmAbi", "getterName"}));
        }
        if (!m27157e(str)) {
            StringBuilder stringBuilder = new StringBuilder("get");
            stringBuilder.append(CapitalizeDecapitalizeKt.m28082b(str));
            str = stringBuilder.toString();
        }
        if (str != null) {
            return str;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/load/java/JvmAbi", "getterName"}));
    }

    public static String m27156d(String str) {
        if (str == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"propertyName", "kotlin/reflect/jvm/internal/impl/load/java/JvmAbi", "setterName"}));
        }
        StringBuilder stringBuilder = new StringBuilder("set");
        stringBuilder.append(m27157e(str) ? str.substring(2) : CapitalizeDecapitalizeKt.m28082b(str));
        str = stringBuilder.toString();
        if (str != null) {
            return str;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/load/java/JvmAbi", "setterName"}));
    }

    private static boolean m27157e(String str) {
        if (!str.startsWith("is") || str.length() == 2) {
            return false;
        }
        str = str.charAt(2);
        if (97 <= str) {
            if (str <= 122) {
                return false;
            }
        }
        return true;
    }

    public static boolean m27153a(DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"companionObject", "kotlin/reflect/jvm/internal/impl/load/java/JvmAbi", "isCompanionObjectWithBackingFieldsInOuter"}));
        }
        if (DescriptorUtils.m27657g(declarationDescriptor) && DescriptorUtils.m27662l(declarationDescriptor.aD_())) {
            CompanionObjectMapping companionObjectMapping = CompanionObjectMapping.f25352a;
            if (CompanionObjectMapping.m26943a((ClassDescriptor) declarationDescriptor) == null) {
                return true;
            }
        }
        return false;
    }
}
