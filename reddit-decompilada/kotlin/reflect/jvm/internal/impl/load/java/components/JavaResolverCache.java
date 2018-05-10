package kotlin.reflect.jvm.internal.impl.load.java.components;

import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaElement;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.name.FqName;

public interface JavaResolverCache {
    public static final JavaResolverCache EMPTY = new C25691();

    static class C25691 implements JavaResolverCache {
        public final ClassDescriptor getClassResolvedFromSource(FqName fqName) {
            if (fqName != null) {
                return null;
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"fqName", "kotlin/reflect/jvm/internal/impl/load/java/components/JavaResolverCache$1", "getClassResolvedFromSource"}));
        }

        public final void recordClass(JavaClass javaClass, ClassDescriptor classDescriptor) {
            if (javaClass == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"javaClass", "kotlin/reflect/jvm/internal/impl/load/java/components/JavaResolverCache$1", "recordClass"}));
            } else if (classDescriptor == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"descriptor", "kotlin/reflect/jvm/internal/impl/load/java/components/JavaResolverCache$1", "recordClass"}));
            }
        }

        public final void recordConstructor(JavaElement javaElement, ConstructorDescriptor constructorDescriptor) {
            if (javaElement == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"element", "kotlin/reflect/jvm/internal/impl/load/java/components/JavaResolverCache$1", "recordConstructor"}));
            } else if (constructorDescriptor == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"descriptor", "kotlin/reflect/jvm/internal/impl/load/java/components/JavaResolverCache$1", "recordConstructor"}));
            }
        }

        public final void recordField(JavaField javaField, PropertyDescriptor propertyDescriptor) {
            if (javaField == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"field", "kotlin/reflect/jvm/internal/impl/load/java/components/JavaResolverCache$1", "recordField"}));
            } else if (propertyDescriptor == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"descriptor", "kotlin/reflect/jvm/internal/impl/load/java/components/JavaResolverCache$1", "recordField"}));
            }
        }

        public final void recordMethod(JavaMethod javaMethod, SimpleFunctionDescriptor simpleFunctionDescriptor) {
            if (javaMethod == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"method", "kotlin/reflect/jvm/internal/impl/load/java/components/JavaResolverCache$1", "recordMethod"}));
            } else if (simpleFunctionDescriptor == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"descriptor", "kotlin/reflect/jvm/internal/impl/load/java/components/JavaResolverCache$1", "recordMethod"}));
            }
        }

        C25691() {
        }
    }

    ClassDescriptor getClassResolvedFromSource(FqName fqName);

    void recordClass(JavaClass javaClass, ClassDescriptor classDescriptor);

    void recordConstructor(JavaElement javaElement, ConstructorDescriptor constructorDescriptor);

    void recordField(JavaField javaField, PropertyDescriptor propertyDescriptor);

    void recordMethod(JavaMethod javaMethod, SimpleFunctionDescriptor simpleFunctionDescriptor);
}
