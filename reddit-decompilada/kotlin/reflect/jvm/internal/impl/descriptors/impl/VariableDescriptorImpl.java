package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

public abstract class VariableDescriptorImpl extends DeclarationDescriptorNonRootImpl implements VariableDescriptor {
    static final /* synthetic */ boolean f40797i = true;
    protected KotlinType f40798h;

    public boolean mo7776A() {
        return false;
    }

    public ReceiverParameterDescriptor mo7755d() {
        return null;
    }

    public ReceiverParameterDescriptor mo7756e() {
        return null;
    }

    public boolean mo7758l() {
        return false;
    }

    public /* synthetic */ DeclarationDescriptor aJ_() {
        return mo7798C();
    }

    public /* synthetic */ CallableDescriptor aM_() {
        return mo7798C();
    }

    public /* synthetic */ DeclarationDescriptorWithSource aO_() {
        return mo7798C();
    }

    public VariableDescriptorImpl(DeclarationDescriptor declarationDescriptor, Annotations annotations, Name name, KotlinType kotlinType, SourceElement sourceElement) {
        if (declarationDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"containingDeclaration", "kotlin/reflect/jvm/internal/impl/descriptors/impl/VariableDescriptorImpl", "<init>"}));
        } else if (annotations == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"annotations", "kotlin/reflect/jvm/internal/impl/descriptors/impl/VariableDescriptorImpl", "<init>"}));
        } else if (name == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"name", "kotlin/reflect/jvm/internal/impl/descriptors/impl/VariableDescriptorImpl", "<init>"}));
        } else if (sourceElement == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"source", "kotlin/reflect/jvm/internal/impl/descriptors/impl/VariableDescriptorImpl", "<init>"}));
        } else {
            super(declarationDescriptor, annotations, name, sourceElement);
            this.f40798h = kotlinType;
        }
    }

    public final KotlinType mo7777x() {
        KotlinType kotlinType = this.f40798h;
        if (kotlinType != null) {
            return kotlinType;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/VariableDescriptorImpl", "getType"}));
    }

    public final void m42670a(KotlinType kotlinType) {
        if (f40797i || this.f40798h == null) {
            this.f40798h = kotlinType;
            return;
        }
        throw new AssertionError();
    }

    public VariableDescriptor mo7798C() {
        VariableDescriptor variableDescriptor = (VariableDescriptor) super.aO_();
        if (variableDescriptor != null) {
            return variableDescriptor;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/VariableDescriptorImpl", "getOriginal"}));
    }

    public final List<ValueParameterDescriptor> mo7757k() {
        List<ValueParameterDescriptor> emptyList = Collections.emptyList();
        if (emptyList != null) {
            return emptyList;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/VariableDescriptorImpl", "getValueParameters"}));
    }

    public Collection<? extends CallableDescriptor> mo7609m() {
        Collection emptySet = Collections.emptySet();
        if (emptySet != null) {
            return emptySet;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/VariableDescriptorImpl", "getOverriddenDescriptors"}));
    }

    public List<TypeParameterDescriptor> mo7735f() {
        List<TypeParameterDescriptor> emptyList = Collections.emptyList();
        if (emptyList != null) {
            return emptyList;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/VariableDescriptorImpl", "getTypeParameters"}));
    }

    public KotlinType aN_() {
        KotlinType x = mo7777x();
        if (x != null) {
            return x;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/VariableDescriptorImpl", "getReturnType"}));
    }
}
