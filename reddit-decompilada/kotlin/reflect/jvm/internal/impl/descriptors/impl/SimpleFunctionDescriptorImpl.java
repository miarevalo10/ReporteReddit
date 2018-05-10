package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

public class SimpleFunctionDescriptorImpl extends FunctionDescriptorImpl implements SimpleFunctionDescriptor {
    public /* bridge */ /* synthetic */ CallableMemberDescriptor mo7748a(DeclarationDescriptor declarationDescriptor, Modality modality, Visibility visibility, Kind kind) {
        return mo7834a(declarationDescriptor, modality, visibility, kind, false);
    }

    public /* synthetic */ FunctionDescriptorImpl mo7796a(KotlinType kotlinType, ReceiverParameterDescriptor receiverParameterDescriptor, List list, List list2, KotlinType kotlinType2, Modality modality, Visibility visibility) {
        return mo7833b(kotlinType, receiverParameterDescriptor, list, list2, kotlinType2, modality, visibility);
    }

    public final /* synthetic */ DeclarationDescriptor aJ_() {
        return m42807u();
    }

    public final /* synthetic */ CallableDescriptor aM_() {
        return m42807u();
    }

    public final /* synthetic */ DeclarationDescriptorWithSource aO_() {
        return m42807u();
    }

    public /* synthetic */ FunctionDescriptor mo7797b(DeclarationDescriptor declarationDescriptor, Modality modality, Visibility visibility, Kind kind, boolean z) {
        return mo7834a(declarationDescriptor, modality, visibility, kind, z);
    }

    public final /* synthetic */ CallableMemberDescriptor mo7759s() {
        return m42807u();
    }

    public final /* synthetic */ FunctionDescriptor mo7761v() {
        return m42807u();
    }

    protected SimpleFunctionDescriptorImpl(DeclarationDescriptor declarationDescriptor, SimpleFunctionDescriptor simpleFunctionDescriptor, Annotations annotations, Name name, Kind kind, SourceElement sourceElement) {
        if (declarationDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"containingDeclaration", "kotlin/reflect/jvm/internal/impl/descriptors/impl/SimpleFunctionDescriptorImpl", "<init>"}));
        } else if (annotations == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"annotations", "kotlin/reflect/jvm/internal/impl/descriptors/impl/SimpleFunctionDescriptorImpl", "<init>"}));
        } else if (name == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"name", "kotlin/reflect/jvm/internal/impl/descriptors/impl/SimpleFunctionDescriptorImpl", "<init>"}));
        } else if (kind == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"kind", "kotlin/reflect/jvm/internal/impl/descriptors/impl/SimpleFunctionDescriptorImpl", "<init>"}));
        } else if (sourceElement == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"source", "kotlin/reflect/jvm/internal/impl/descriptors/impl/SimpleFunctionDescriptorImpl", "<init>"}));
        } else {
            super(declarationDescriptor, simpleFunctionDescriptor, annotations, name, kind, sourceElement);
        }
    }

    public static SimpleFunctionDescriptorImpl m42798a(DeclarationDescriptor declarationDescriptor, Annotations annotations, Name name, Kind kind, SourceElement sourceElement) {
        if (declarationDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"containingDeclaration", "kotlin/reflect/jvm/internal/impl/descriptors/impl/SimpleFunctionDescriptorImpl", "create"}));
        } else if (annotations == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"annotations", "kotlin/reflect/jvm/internal/impl/descriptors/impl/SimpleFunctionDescriptorImpl", "create"}));
        } else if (name == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"name", "kotlin/reflect/jvm/internal/impl/descriptors/impl/SimpleFunctionDescriptorImpl", "create"}));
        } else if (kind == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"kind", "kotlin/reflect/jvm/internal/impl/descriptors/impl/SimpleFunctionDescriptorImpl", "create"}));
        } else if (sourceElement != null) {
            return new SimpleFunctionDescriptorImpl(declarationDescriptor, null, annotations, name, kind, sourceElement);
        } else {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"source", "kotlin/reflect/jvm/internal/impl/descriptors/impl/SimpleFunctionDescriptorImpl", "create"}));
        }
    }

    public SimpleFunctionDescriptorImpl mo7833b(KotlinType kotlinType, ReceiverParameterDescriptor receiverParameterDescriptor, List<? extends TypeParameterDescriptor> list, List<ValueParameterDescriptor> list2, KotlinType kotlinType2, Modality modality, Visibility visibility) {
        if (list == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"typeParameters", "kotlin/reflect/jvm/internal/impl/descriptors/impl/SimpleFunctionDescriptorImpl", "initialize"}));
        } else if (list2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"unsubstitutedValueParameters", "kotlin/reflect/jvm/internal/impl/descriptors/impl/SimpleFunctionDescriptorImpl", "initialize"}));
        } else if (visibility == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"visibility", "kotlin/reflect/jvm/internal/impl/descriptors/impl/SimpleFunctionDescriptorImpl", "initialize"}));
        } else if (list == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"typeParameters", "kotlin/reflect/jvm/internal/impl/descriptors/impl/SimpleFunctionDescriptorImpl", "initialize"}));
        } else if (list2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"unsubstitutedValueParameters", "kotlin/reflect/jvm/internal/impl/descriptors/impl/SimpleFunctionDescriptorImpl", "initialize"}));
        } else if (visibility == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"visibility", "kotlin/reflect/jvm/internal/impl/descriptors/impl/SimpleFunctionDescriptorImpl", "initialize"}));
        } else {
            super.mo7796a(kotlinType, receiverParameterDescriptor, list, list2, kotlinType2, modality, visibility);
            if (this == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/SimpleFunctionDescriptorImpl", "initialize"}));
            } else if (this != null) {
                return this;
            } else {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/SimpleFunctionDescriptorImpl", "initialize"}));
            }
        }
    }

    public final SimpleFunctionDescriptor m42807u() {
        SimpleFunctionDescriptor simpleFunctionDescriptor = (SimpleFunctionDescriptor) super.mo7761v();
        if (simpleFunctionDescriptor != null) {
            return simpleFunctionDescriptor;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/SimpleFunctionDescriptorImpl", "getOriginal"}));
    }

    public FunctionDescriptorImpl mo7795a(DeclarationDescriptor declarationDescriptor, FunctionDescriptor functionDescriptor, Kind kind, Name name, Annotations annotations, SourceElement sourceElement) {
        if (declarationDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"newOwner", "kotlin/reflect/jvm/internal/impl/descriptors/impl/SimpleFunctionDescriptorImpl", "createSubstitutedCopy"}));
        } else if (kind == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"kind", "kotlin/reflect/jvm/internal/impl/descriptors/impl/SimpleFunctionDescriptorImpl", "createSubstitutedCopy"}));
        } else if (annotations == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"annotations", "kotlin/reflect/jvm/internal/impl/descriptors/impl/SimpleFunctionDescriptorImpl", "createSubstitutedCopy"}));
        } else if (sourceElement == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"source", "kotlin/reflect/jvm/internal/impl/descriptors/impl/SimpleFunctionDescriptorImpl", "createSubstitutedCopy"}));
        } else {
            SimpleFunctionDescriptor simpleFunctionDescriptor = (SimpleFunctionDescriptor) functionDescriptor;
            if (name == null) {
                name = mo6689i();
            }
            return new SimpleFunctionDescriptorImpl(declarationDescriptor, simpleFunctionDescriptor, annotations, name, kind, sourceElement);
        }
    }

    public SimpleFunctionDescriptor mo7834a(DeclarationDescriptor declarationDescriptor, Modality modality, Visibility visibility, Kind kind, boolean z) {
        SimpleFunctionDescriptor simpleFunctionDescriptor = (SimpleFunctionDescriptor) super.mo7797b(declarationDescriptor, modality, visibility, kind, z);
        if (simpleFunctionDescriptor != null) {
            return simpleFunctionDescriptor;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/SimpleFunctionDescriptorImpl", "copy"}));
    }

    public CopyBuilder<? extends SimpleFunctionDescriptor> mo7736C() {
        CopyBuilder<? extends SimpleFunctionDescriptor> C = super.mo7736C();
        if (C != null) {
            return C;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/SimpleFunctionDescriptorImpl", "newCopyBuilder"}));
    }
}
