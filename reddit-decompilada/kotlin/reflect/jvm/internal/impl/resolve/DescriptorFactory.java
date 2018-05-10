package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassConstructorDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyGetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertySetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ReceiverParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.SimpleFunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ExtensionReceiver;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.Variance;

public class DescriptorFactory {

    private static class DefaultClassConstructorDescriptor extends ClassConstructorDescriptorImpl {
        public DefaultClassConstructorDescriptor(ClassDescriptor classDescriptor, SourceElement sourceElement) {
            if (classDescriptor == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"containingClass", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory$DefaultClassConstructorDescriptor", "<init>"}));
            } else if (sourceElement == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"source", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory$DefaultClassConstructorDescriptor", "<init>"}));
            } else {
                Companion companion = Annotations.f32643a;
                super(classDescriptor, null, Companion.m27115a(), true, Kind.DECLARATION, sourceElement);
                m42889a((List) Collections.emptyList(), (Visibility) DescriptorUtils.m27649b(classDescriptor));
            }
        }
    }

    public static PropertySetterDescriptorImpl m27631a(PropertyDescriptor propertyDescriptor, Annotations annotations) {
        if (propertyDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"propertyDescriptor", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory", "createDefaultSetter"}));
        } else if (annotations == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"annotations", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory", "createDefaultSetter"}));
        } else {
            SourceElement r = propertyDescriptor.mo7258r();
            if (propertyDescriptor == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"propertyDescriptor", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory", "createSetter"}));
            } else if (annotations == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"annotations", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory", "createSetter"}));
            } else if (r != null) {
                return m27632a(propertyDescriptor, annotations, true, propertyDescriptor.mo7257j(), r);
            } else {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"sourceElement", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory", "createSetter"}));
            }
        }
    }

    public static PropertySetterDescriptorImpl m27632a(PropertyDescriptor propertyDescriptor, Annotations annotations, boolean z, Visibility visibility, SourceElement sourceElement) {
        if (propertyDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"propertyDescriptor", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory", "createSetter"}));
        } else if (annotations == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"annotations", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory", "createSetter"}));
        } else if (visibility == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"visibility", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory", "createSetter"}));
        } else if (sourceElement == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"sourceElement", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory", "createSetter"}));
        } else {
            PropertySetterDescriptor propertySetterDescriptorImpl = new PropertySetterDescriptorImpl(propertyDescriptor, annotations, propertyDescriptor.aG_(), visibility, z, false, false, Kind.DECLARATION, null, sourceElement);
            if (PropertySetterDescriptorImpl.f40981h || propertySetterDescriptorImpl.f40982g == null) {
                propertySetterDescriptorImpl.f40982g = PropertySetterDescriptorImpl.m43072a(propertySetterDescriptorImpl, propertySetterDescriptorImpl.mo7822D().aN_());
                return propertySetterDescriptorImpl;
            }
            throw new AssertionError();
        }
    }

    public static PropertyGetterDescriptorImpl m27634b(PropertyDescriptor propertyDescriptor, Annotations annotations) {
        if (propertyDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"propertyDescriptor", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory", "createDefaultGetter"}));
        } else if (annotations == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"annotations", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory", "createDefaultGetter"}));
        } else if (propertyDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"propertyDescriptor", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory", "createGetter"}));
        } else if (annotations != null) {
            return m27630a(propertyDescriptor, annotations, true, propertyDescriptor.mo7258r());
        } else {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"annotations", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory", "createGetter"}));
        }
    }

    public static PropertyGetterDescriptorImpl m27630a(PropertyDescriptor propertyDescriptor, Annotations annotations, boolean z, SourceElement sourceElement) {
        if (propertyDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"propertyDescriptor", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory", "createGetter"}));
        } else if (annotations == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"annotations", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory", "createGetter"}));
        } else if (sourceElement == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"sourceElement", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory", "createGetter"}));
        } else {
            return new PropertyGetterDescriptorImpl(propertyDescriptor, annotations, propertyDescriptor.aG_(), propertyDescriptor.mo7257j(), z, false, false, Kind.DECLARATION, null, sourceElement);
        }
    }

    public static ClassConstructorDescriptorImpl m27629a(ClassDescriptor classDescriptor, SourceElement sourceElement) {
        if (classDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"containingClass", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory", "createPrimaryConstructorForObject"}));
        } else if (sourceElement != null) {
            return new DefaultClassConstructorDescriptor(classDescriptor, sourceElement);
        } else {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"source", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory", "createPrimaryConstructorForObject"}));
        }
    }

    public static SimpleFunctionDescriptor m27628a(ClassDescriptor classDescriptor) {
        if (classDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"enumClass", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory", "createEnumValuesMethod"}));
        }
        Companion companion = Annotations.f32643a;
        classDescriptor = SimpleFunctionDescriptorImpl.m42798a((DeclarationDescriptor) classDescriptor, Companion.m27115a(), DescriptorUtils.f26052a, Kind.SYNTHESIZED, classDescriptor.mo7258r()).mo7833b(null, null, Collections.emptyList(), Collections.emptyList(), DescriptorUtilsKt.m27745d(classDescriptor).m27002a(Variance.f26337a, classDescriptor.mo7714h()), Modality.f25488a, Visibilities.f25508e);
        if (classDescriptor != null) {
            return classDescriptor;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory", "createEnumValuesMethod"}));
    }

    public static SimpleFunctionDescriptor m27633b(ClassDescriptor classDescriptor) {
        DeclarationDescriptor declarationDescriptor = classDescriptor;
        if (declarationDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"enumClass", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory", "createEnumValueOfMethod"}));
        }
        Companion companion = Annotations.f32643a;
        SimpleFunctionDescriptorImpl a = SimpleFunctionDescriptorImpl.m42798a(declarationDescriptor, Companion.m27115a(), DescriptorUtils.f26053b, Kind.SYNTHESIZED, classDescriptor.mo7258r());
        Companion companion2 = Annotations.f32643a;
        ValueParameterDescriptorImpl valueParameterDescriptorImpl = new ValueParameterDescriptorImpl(a, null, 0, Companion.m27115a(), Name.m27424a("value"), DescriptorUtilsKt.m27745d(classDescriptor).m27027y(), false, false, false, null, classDescriptor.mo7258r());
        SimpleFunctionDescriptor b = a.mo7833b(null, null, Collections.emptyList(), Collections.singletonList(valueParameterDescriptorImpl), classDescriptor.mo7714h(), Modality.f25488a, Visibilities.f25508e);
        if (b != null) {
            return b;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory", "createEnumValueOfMethod"}));
    }

    public static ReceiverParameterDescriptor m27627a(CallableDescriptor callableDescriptor, KotlinType kotlinType) {
        if (callableDescriptor != null) {
            return kotlinType == null ? null : new ReceiverParameterDescriptorImpl(callableDescriptor, new ExtensionReceiver(callableDescriptor, kotlinType));
        } else {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"owner", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory", "createExtensionReceiverParameterForCallable"}));
        }
    }
}
