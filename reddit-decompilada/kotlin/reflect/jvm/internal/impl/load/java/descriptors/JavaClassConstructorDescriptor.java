package kotlin.reflect.jvm.internal.impl.load.java.descriptors;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassConstructorDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

public class JavaClassConstructorDescriptor extends ClassConstructorDescriptorImpl implements JavaCallableMemberDescriptor {
    static final /* synthetic */ boolean f40984n = true;
    private Boolean f40985o;
    private Boolean f40986p;

    protected final /* synthetic */ FunctionDescriptorImpl mo7795a(DeclarationDescriptor declarationDescriptor, FunctionDescriptor functionDescriptor, Kind kind, Name name, Annotations annotations, SourceElement sourceElement) {
        return m43081c(declarationDescriptor, functionDescriptor, kind, name, annotations, sourceElement);
    }

    public final /* synthetic */ JavaCallableMemberDescriptor mo7832a(KotlinType kotlinType, List list, KotlinType kotlinType2) {
        if (kotlinType2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"enhancedReturnType", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaClassConstructorDescriptor", "enhance"}));
        }
        JavaClassConstructorDescriptor c = m43081c(m42884D(), null, mo7760t(), null, mo5718q(), mo7258r());
        JavaClassConstructorDescriptor javaClassConstructorDescriptor = c;
        KotlinType kotlinType3 = kotlinType;
        KotlinType kotlinType4 = kotlinType2;
        javaClassConstructorDescriptor.mo7796a(kotlinType3, this.f40765c, mo7735f(), UtilKt.m27194a(list, mo7757k(), c), kotlinType4, aG_(), mo7257j());
        return c;
    }

    protected final /* synthetic */ ClassConstructorDescriptorImpl mo7837b(DeclarationDescriptor declarationDescriptor, FunctionDescriptor functionDescriptor, Kind kind, Name name, Annotations annotations, SourceElement sourceElement) {
        return m43081c(declarationDescriptor, functionDescriptor, kind, name, annotations, sourceElement);
    }

    private JavaClassConstructorDescriptor(ClassDescriptor classDescriptor, JavaClassConstructorDescriptor javaClassConstructorDescriptor, Annotations annotations, boolean z, Kind kind, SourceElement sourceElement) {
        if (classDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"containingDeclaration", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaClassConstructorDescriptor", "<init>"}));
        } else if (annotations == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"annotations", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaClassConstructorDescriptor", "<init>"}));
        } else if (kind == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"kind", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaClassConstructorDescriptor", "<init>"}));
        } else if (sourceElement == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"source", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaClassConstructorDescriptor", "<init>"}));
        } else {
            super(classDescriptor, javaClassConstructorDescriptor, annotations, z, kind, sourceElement);
            this.f40985o = null;
            this.f40986p = null;
        }
    }

    public static JavaClassConstructorDescriptor m43080a(ClassDescriptor classDescriptor, Annotations annotations, boolean z, SourceElement sourceElement) {
        if (classDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"containingDeclaration", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaClassConstructorDescriptor", "createJavaConstructor"}));
        } else if (annotations == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"annotations", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaClassConstructorDescriptor", "createJavaConstructor"}));
        } else if (sourceElement == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"source", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaClassConstructorDescriptor", "createJavaConstructor"}));
        } else {
            return new JavaClassConstructorDescriptor(classDescriptor, null, annotations, z, Kind.DECLARATION, sourceElement);
        }
    }

    public final boolean mo7831E() {
        if (f40984n || this.f40985o != null) {
            return this.f40985o.booleanValue();
        }
        StringBuilder stringBuilder = new StringBuilder("hasStableParameterNames was not set: ");
        stringBuilder.append(this);
        throw new AssertionError(stringBuilder.toString());
    }

    public final void mo7836a(boolean z) {
        this.f40985o = Boolean.valueOf(z);
    }

    public final boolean mo7758l() {
        if (f40984n || this.f40986p != null) {
            return this.f40986p.booleanValue();
        }
        StringBuilder stringBuilder = new StringBuilder("hasSynthesizedParameterNames was not set: ");
        stringBuilder.append(this);
        throw new AssertionError(stringBuilder.toString());
    }

    public final void mo7838b(boolean z) {
        this.f40986p = Boolean.valueOf(z);
    }

    private JavaClassConstructorDescriptor m43081c(DeclarationDescriptor declarationDescriptor, FunctionDescriptor functionDescriptor, Kind kind, Name name, Annotations annotations, SourceElement sourceElement) {
        if (declarationDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"newOwner", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaClassConstructorDescriptor", "createSubstitutedCopy"}));
        } else if (kind == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"kind", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaClassConstructorDescriptor", "createSubstitutedCopy"}));
        } else if (annotations == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"annotations", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaClassConstructorDescriptor", "createSubstitutedCopy"}));
        } else if (sourceElement == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"source", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaClassConstructorDescriptor", "createSubstitutedCopy"}));
        } else if (kind != Kind.DECLARATION && kind != Kind.SYNTHESIZED) {
            name = new StringBuilder("Attempt at creating a constructor that is not a declaration: \ncopy from: ");
            name.append(this);
            name.append("\nnewOwner: ");
            name.append(declarationDescriptor);
            name.append("\nkind: ");
            name.append(kind);
            throw new IllegalStateException(name.toString());
        } else if (f40984n || name == null) {
            ClassDescriptor classDescriptor = (ClassDescriptor) declarationDescriptor;
            JavaClassConstructorDescriptor javaClassConstructorDescriptor = (JavaClassConstructorDescriptor) functionDescriptor;
            if (classDescriptor == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"newOwner", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaClassConstructorDescriptor", "createDescriptor"}));
            } else if (kind == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"kind", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaClassConstructorDescriptor", "createDescriptor"}));
            } else if (sourceElement == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"sourceElement", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaClassConstructorDescriptor", "createDescriptor"}));
            } else if (annotations == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"annotations", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaClassConstructorDescriptor", "createDescriptor"}));
            } else {
                Name javaClassConstructorDescriptor2 = new JavaClassConstructorDescriptor(classDescriptor, javaClassConstructorDescriptor, annotations, this.a, kind, sourceElement);
                javaClassConstructorDescriptor2.mo7836a(mo7831E());
                javaClassConstructorDescriptor2.mo7838b(mo7758l());
                return javaClassConstructorDescriptor2;
            }
        } else {
            functionDescriptor = new StringBuilder("Attempt to rename constructor: ");
            functionDescriptor.append(this);
            throw new AssertionError(functionDescriptor.toString());
        }
    }
}
