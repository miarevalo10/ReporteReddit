package kotlin.reflect.jvm.internal.impl.load.java.descriptors;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstUtil;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyAccessorDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyGetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertySetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorWithInitializerImpl;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementKt;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

public class JavaPropertyDescriptor extends PropertyDescriptorImpl implements JavaCallableMemberDescriptor {
    private final boolean f40987m;

    public final boolean mo7758l() {
        return false;
    }

    private JavaPropertyDescriptor(DeclarationDescriptor declarationDescriptor, Annotations annotations, Modality modality, Visibility visibility, boolean z, Name name, SourceElement sourceElement, PropertyDescriptor propertyDescriptor, Kind kind, boolean z2) {
        if (declarationDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"containingDeclaration", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaPropertyDescriptor", "<init>"}));
        } else if (annotations == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"annotations", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaPropertyDescriptor", "<init>"}));
        } else if (modality == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"modality", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaPropertyDescriptor", "<init>"}));
        } else if (visibility == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"visibility", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaPropertyDescriptor", "<init>"}));
        } else if (name == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"name", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaPropertyDescriptor", "<init>"}));
        } else if (sourceElement == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"source", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaPropertyDescriptor", "<init>"}));
        } else if (kind == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"kind", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaPropertyDescriptor", "<init>"}));
        } else {
            super(declarationDescriptor, propertyDescriptor, annotations, modality, visibility, z, name, kind, sourceElement, false, false, false, false, false, false);
            this.f40987m = z2;
        }
    }

    public static JavaPropertyDescriptor m43089a(DeclarationDescriptor declarationDescriptor, Annotations annotations, Modality modality, Visibility visibility, boolean z, Name name, SourceElement sourceElement, boolean z2) {
        if (declarationDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"containingDeclaration", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaPropertyDescriptor", "create"}));
        } else if (annotations == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"annotations", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaPropertyDescriptor", "create"}));
        } else if (modality == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"modality", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaPropertyDescriptor", "create"}));
        } else if (visibility == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"visibility", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaPropertyDescriptor", "create"}));
        } else if (name == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"name", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaPropertyDescriptor", "create"}));
        } else if (sourceElement == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"source", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaPropertyDescriptor", "create"}));
        } else {
            return new JavaPropertyDescriptor(declarationDescriptor, annotations, modality, visibility, z, name, sourceElement, null, Kind.DECLARATION, z2);
        }
    }

    protected final PropertyDescriptorImpl mo7839a(DeclarationDescriptor declarationDescriptor, Modality modality, Visibility visibility, PropertyDescriptor propertyDescriptor, Kind kind) {
        VariableDescriptorWithInitializerImpl variableDescriptorWithInitializerImpl = this;
        if (declarationDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"newOwner", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaPropertyDescriptor", "createSubstitutedCopy"}));
        } else if (modality == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"newModality", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaPropertyDescriptor", "createSubstitutedCopy"}));
        } else if (visibility == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"newVisibility", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaPropertyDescriptor", "createSubstitutedCopy"}));
        } else if (kind == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"kind", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaPropertyDescriptor", "createSubstitutedCopy"}));
        } else {
            return new JavaPropertyDescriptor(declarationDescriptor, mo5718q(), modality, visibility, variableDescriptorWithInitializerImpl.f40860j, mo6689i(), SourceElement.f25498a, propertyDescriptor, kind, variableDescriptorWithInitializerImpl.f40987m);
        }
    }

    public final JavaCallableMemberDescriptor mo7832a(KotlinType kotlinType, List<KotlinType> list, KotlinType kotlinType2) {
        VariableDescriptorWithInitializerImpl variableDescriptorWithInitializerImpl = this;
        KotlinType kotlinType3 = kotlinType2;
        if (kotlinType3 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"enhancedReturnType", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaPropertyDescriptor", "enhance"}));
        }
        PropertyGetterDescriptorImpl propertyGetterDescriptorImpl;
        PropertySetterDescriptor propertySetterDescriptor;
        JavaPropertyDescriptor javaPropertyDescriptor = new JavaPropertyDescriptor(aD_(), mo5718q(), aG_(), mo7257j(), variableDescriptorWithInitializerImpl.f40860j, mo6689i(), mo7258r(), mo7829v(), mo7760t(), variableDescriptorWithInitializerImpl.f40987m);
        PropertyAccessorDescriptorImpl propertyAccessorDescriptorImpl = variableDescriptorWithInitializerImpl.f40938e;
        if (propertyAccessorDescriptorImpl != null) {
            propertyGetterDescriptorImpl = r3;
            PropertyGetterDescriptorImpl propertyGetterDescriptorImpl2 = new PropertyGetterDescriptorImpl(javaPropertyDescriptor, propertyAccessorDescriptorImpl.mo5718q(), propertyAccessorDescriptorImpl.aG_(), propertyAccessorDescriptorImpl.mo7257j(), propertyAccessorDescriptorImpl.f40926a, propertyAccessorDescriptorImpl.f40927b, propertyAccessorDescriptorImpl.f40928c, mo7760t(), propertyAccessorDescriptorImpl, propertyAccessorDescriptorImpl.mo7258r());
            propertyGetterDescriptorImpl.f40930e = propertyAccessorDescriptorImpl.f40930e;
            propertyGetterDescriptorImpl.m43066a(kotlinType3);
        } else {
            propertyGetterDescriptorImpl = null;
        }
        PropertySetterDescriptor propertySetterDescriptor2 = variableDescriptorWithInitializerImpl.f40939f;
        if (propertySetterDescriptor2 != null) {
            propertySetterDescriptor = r3;
            PropertySetterDescriptorImpl propertySetterDescriptorImpl = new PropertySetterDescriptorImpl(javaPropertyDescriptor, propertySetterDescriptor2.mo5718q(), propertySetterDescriptor2.aG_(), propertySetterDescriptor2.mo7257j(), propertySetterDescriptor2.mo7823u(), propertySetterDescriptor2.mo7745p(), propertySetterDescriptor2.mo7752b(), mo7760t(), propertySetterDescriptor2, propertySetterDescriptor2.mo7258r());
            propertySetterDescriptor.f40930e = propertySetterDescriptor.f40930e;
            propertySetterDescriptor.m43075a((ValueParameterDescriptor) propertySetterDescriptor2.mo7757k().get(0));
        } else {
            propertySetterDescriptor = null;
        }
        javaPropertyDescriptor.m42990a(propertyGetterDescriptorImpl, propertySetterDescriptor);
        javaPropertyDescriptor.f40940g = variableDescriptorWithInitializerImpl.f40940g;
        if (variableDescriptorWithInitializerImpl.k != null) {
            javaPropertyDescriptor.m42825a(variableDescriptorWithInitializerImpl.k);
        }
        javaPropertyDescriptor.mo7749a(mo7609m());
        javaPropertyDescriptor.m42991a(kotlinType2, mo7735f(), variableDescriptorWithInitializerImpl.f40937d, kotlinType);
        return javaPropertyDescriptor;
    }

    public final boolean mo7776A() {
        KotlinType x = mo7777x();
        return this.f40987m && ConstUtil.m27043a(x) && (!TypeEnhancementKt.m27279a(x) || KotlinBuiltIns.m26995k(x));
    }
}
