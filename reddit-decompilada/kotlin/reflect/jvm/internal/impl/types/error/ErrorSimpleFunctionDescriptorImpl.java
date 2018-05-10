package kotlin.reflect.jvm.internal.impl.types.error;

import java.util.Collection;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.SimpleFunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils.ErrorScope;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;

public class ErrorSimpleFunctionDescriptorImpl extends SimpleFunctionDescriptorImpl {
    private final ErrorScope f40978a;

    class C25971 implements CopyBuilder<SimpleFunctionDescriptor> {
        final /* synthetic */ ErrorSimpleFunctionDescriptorImpl f33083a;

        C25971(ErrorSimpleFunctionDescriptorImpl errorSimpleFunctionDescriptorImpl) {
            this.f33083a = errorSimpleFunctionDescriptorImpl;
        }

        public final CopyBuilder<SimpleFunctionDescriptor> mo5743a(DeclarationDescriptor declarationDescriptor) {
            if (declarationDescriptor == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"owner", "kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl$1", "setOwner"}));
            } else if (this != null) {
                return this;
            } else {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl$1", "setOwner"}));
            }
        }

        public final CopyBuilder<SimpleFunctionDescriptor> mo5744a(Modality modality) {
            if (modality == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"modality", "kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl$1", "setModality"}));
            } else if (this != null) {
                return this;
            } else {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl$1", "setModality"}));
            }
        }

        public final CopyBuilder<SimpleFunctionDescriptor> mo5746a(Visibility visibility) {
            if (visibility == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"visibility", "kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl$1", "setVisibility"}));
            } else if (this != null) {
                return this;
            } else {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl$1", "setVisibility"}));
            }
        }

        public final CopyBuilder<SimpleFunctionDescriptor> mo5742a(Kind kind) {
            if (kind == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"kind", "kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl$1", "setKind"}));
            } else if (this != null) {
                return this;
            } else {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl$1", "setKind"}));
            }
        }

        public final CopyBuilder<SimpleFunctionDescriptor> mo5751a(boolean z) {
            if (this != null) {
                return this;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl$1", "setCopyOverrides"}));
        }

        public final CopyBuilder<SimpleFunctionDescriptor> mo5748a(Name name) {
            if (name == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"name", "kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl$1", "setName"}));
            } else if (this != null) {
                return this;
            } else {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl$1", "setName"}));
            }
        }

        public final CopyBuilder<SimpleFunctionDescriptor> mo5741a(List<ValueParameterDescriptor> list) {
            if (list == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"parameters", "kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl$1", "setValueParameters"}));
            } else if (this != null) {
                return this;
            } else {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl$1", "setValueParameters"}));
            }
        }

        public final CopyBuilder<SimpleFunctionDescriptor> mo5750a(TypeSubstitution typeSubstitution) {
            if (typeSubstitution == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"substitution", "kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl$1", "setSubstitution"}));
            } else if (this != null) {
                return this;
            } else {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl$1", "setSubstitution"}));
            }
        }

        public final CopyBuilder<SimpleFunctionDescriptor> mo5749a(KotlinType kotlinType) {
            if (kotlinType == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"type", "kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl$1", "setReturnType"}));
            } else if (this != null) {
                return this;
            } else {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl$1", "setReturnType"}));
            }
        }

        public final CopyBuilder<SimpleFunctionDescriptor> mo5753b(KotlinType kotlinType) {
            if (this != null) {
                return this;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl$1", "setExtensionReceiverType"}));
        }

        public final CopyBuilder<SimpleFunctionDescriptor> mo5745a(ReceiverParameterDescriptor receiverParameterDescriptor) {
            if (this != null) {
                return this;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl$1", "setDispatchReceiverParameter"}));
        }

        public final CopyBuilder<SimpleFunctionDescriptor> mo5740a() {
            if (this != null) {
                return this;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl$1", "setSignatureChange"}));
        }

        public final CopyBuilder<SimpleFunctionDescriptor> mo5752b() {
            if (this != null) {
                return this;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl$1", "setPreserveSourceElement"}));
        }

        public final CopyBuilder<SimpleFunctionDescriptor> mo5754c() {
            if (this != null) {
                return this;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl$1", "setDropOriginalInContainingParts"}));
        }

        public final CopyBuilder<SimpleFunctionDescriptor> mo5755d() {
            if (this != null) {
                return this;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl$1", "setHiddenToOvercomeSignatureClash"}));
        }

        public final CopyBuilder<SimpleFunctionDescriptor> mo5756e() {
            if (this != null) {
                return this;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl$1", "setHiddenForResolutionEverywhereBesideSupercalls"}));
        }

        public final CopyBuilder<SimpleFunctionDescriptor> mo5747a(Annotations annotations) {
            if (annotations == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"additionalAnnotations", "kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl$1", "setAdditionalAnnotations"}));
            } else if (this != null) {
                return this;
            } else {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl$1", "setAdditionalAnnotations"}));
            }
        }

        public final /* bridge */ /* synthetic */ FunctionDescriptor mo5757f() {
            return this.f33083a;
        }
    }

    public final boolean mo7747B() {
        return false;
    }

    public final void mo7749a(Collection<? extends CallableMemberDescriptor> collection) {
        if (collection == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"overriddenDescriptors", "kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl", "setOverriddenDescriptors"}));
        }
    }

    public final /* bridge */ /* synthetic */ CallableMemberDescriptor mo7748a(DeclarationDescriptor declarationDescriptor, Modality modality, Visibility visibility, Kind kind) {
        return mo7834a(declarationDescriptor, modality, visibility, kind, false);
    }

    public final /* synthetic */ FunctionDescriptor mo7797b(DeclarationDescriptor declarationDescriptor, Modality modality, Visibility visibility, Kind kind, boolean z) {
        return mo7834a(declarationDescriptor, modality, visibility, kind, z);
    }

    public ErrorSimpleFunctionDescriptorImpl(ClassDescriptor classDescriptor, ErrorScope errorScope) {
        if (classDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"containingDeclaration", "kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl", "<init>"}));
        } else if (errorScope == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"ownerScope", "kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl", "<init>"}));
        } else {
            Companion companion = Annotations.f32643a;
            super(classDescriptor, null, Companion.m27115a(), Name.m27426c("<ERROR FUNCTION>"), Kind.DECLARATION, SourceElement.f25498a);
            this.f40978a = errorScope;
        }
    }

    protected final FunctionDescriptorImpl mo7795a(DeclarationDescriptor declarationDescriptor, FunctionDescriptor functionDescriptor, Kind kind, Name name, Annotations annotations, SourceElement sourceElement) {
        if (declarationDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"newOwner", "kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl", "createSubstitutedCopy"}));
        } else if (kind == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"kind", "kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl", "createSubstitutedCopy"}));
        } else if (annotations == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"annotations", "kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl", "createSubstitutedCopy"}));
        } else if (sourceElement == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"source", "kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl", "createSubstitutedCopy"}));
        } else if (this != null) {
            return this;
        } else {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl", "createSubstitutedCopy"}));
        }
    }

    public final SimpleFunctionDescriptor mo7834a(DeclarationDescriptor declarationDescriptor, Modality modality, Visibility visibility, Kind kind, boolean z) {
        if (this != null) {
            return this;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl", "copy"}));
    }

    public final CopyBuilder<? extends SimpleFunctionDescriptor> mo7736C() {
        return new C25971(this);
    }
}
