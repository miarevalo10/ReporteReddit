package kotlin.reflect.jvm.internal.impl.load.java.descriptors;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.SimpleFunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.util.OperatorChecks;

public class JavaMethodDescriptor extends SimpleFunctionDescriptorImpl implements JavaCallableMemberDescriptor {
    static final /* synthetic */ boolean f40953a = true;
    private ParameterNamesStatus f40954b;

    private enum ParameterNamesStatus {
        NON_STABLE_DECLARED(false, false),
        STABLE_DECLARED(true, false),
        NON_STABLE_SYNTHESIZED(false, true),
        STABLE_SYNTHESIZED(true, true);
        
        public final boolean f25683e;
        public final boolean f25684f;

        private ParameterNamesStatus(boolean z, boolean z2) {
            this.f25683e = z;
            this.f25684f = z2;
        }

        public static ParameterNamesStatus m27193a(boolean z, boolean z2) {
            z = z ? z2 ? STABLE_SYNTHESIZED : STABLE_DECLARED : z2 ? NON_STABLE_SYNTHESIZED : NON_STABLE_DECLARED;
            if (z) {
                return z;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor$ParameterNamesStatus", "get"}));
        }
    }

    protected final /* synthetic */ FunctionDescriptorImpl mo7795a(DeclarationDescriptor declarationDescriptor, FunctionDescriptor functionDescriptor, Kind kind, Name name, Annotations annotations, SourceElement sourceElement) {
        if (declarationDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"newOwner", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor", "createSubstitutedCopy"}));
        } else if (kind == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"kind", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor", "createSubstitutedCopy"}));
        } else if (annotations == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"annotations", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor", "createSubstitutedCopy"}));
        } else if (sourceElement == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"source", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor", "createSubstitutedCopy"}));
        } else {
            SimpleFunctionDescriptor simpleFunctionDescriptor = (SimpleFunctionDescriptor) functionDescriptor;
            if (name == null) {
                name = mo6689i();
            }
            FunctionDescriptorImpl javaMethodDescriptor = new JavaMethodDescriptor(declarationDescriptor, simpleFunctionDescriptor, annotations, name, kind, sourceElement);
            javaMethodDescriptor.m43014a(mo7831E(), mo7758l());
            return javaMethodDescriptor;
        }
    }

    public final /* synthetic */ FunctionDescriptorImpl mo7796a(KotlinType kotlinType, ReceiverParameterDescriptor receiverParameterDescriptor, List list, List list2, KotlinType kotlinType2, Modality modality, Visibility visibility) {
        return mo7833b(kotlinType, receiverParameterDescriptor, list, list2, kotlinType2, modality, visibility);
    }

    public final /* synthetic */ JavaCallableMemberDescriptor mo7832a(KotlinType kotlinType, List list, KotlinType kotlinType2) {
        if (kotlinType2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"enhancedReturnType", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor", "enhance"}));
        }
        JavaMethodDescriptor javaMethodDescriptor = (JavaMethodDescriptor) mo7736C().mo5741a(UtilKt.m27194a(list, mo7757k(), this)).mo5749a(kotlinType2).mo5753b(kotlinType).mo5754c().mo5752b().mo5757f();
        if (f40953a == null && javaMethodDescriptor == null) {
            list = new StringBuilder("null after substitution while enhancing ");
            list.append(toString());
            throw new AssertionError(list.toString());
        } else if (javaMethodDescriptor != null) {
            return javaMethodDescriptor;
        } else {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor", "enhance"}));
        }
    }

    private JavaMethodDescriptor(DeclarationDescriptor declarationDescriptor, SimpleFunctionDescriptor simpleFunctionDescriptor, Annotations annotations, Name name, Kind kind, SourceElement sourceElement) {
        if (declarationDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"containingDeclaration", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor", "<init>"}));
        } else if (annotations == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"annotations", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor", "<init>"}));
        } else if (name == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"name", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor", "<init>"}));
        } else if (kind == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"kind", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor", "<init>"}));
        } else if (sourceElement == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"source", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor", "<init>"}));
        } else {
            super(declarationDescriptor, simpleFunctionDescriptor, annotations, name, kind, sourceElement);
            this.f40954b = null;
        }
    }

    public static JavaMethodDescriptor m43009a(DeclarationDescriptor declarationDescriptor, Annotations annotations, Name name, SourceElement sourceElement) {
        if (declarationDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"containingDeclaration", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor", "createJavaMethod"}));
        } else if (annotations == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"annotations", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor", "createJavaMethod"}));
        } else if (name == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"name", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor", "createJavaMethod"}));
        } else if (sourceElement == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"source", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor", "createJavaMethod"}));
        } else {
            return new JavaMethodDescriptor(declarationDescriptor, null, annotations, name, Kind.DECLARATION, sourceElement);
        }
    }

    public final SimpleFunctionDescriptorImpl mo7833b(KotlinType kotlinType, ReceiverParameterDescriptor receiverParameterDescriptor, List<? extends TypeParameterDescriptor> list, List<ValueParameterDescriptor> list2, KotlinType kotlinType2, Modality modality, Visibility visibility) {
        if (list == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"typeParameters", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor", "initialize"}));
        } else if (list2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"unsubstitutedValueParameters", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor", "initialize"}));
        } else if (visibility == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"visibility", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor", "initialize"}));
        } else {
            kotlinType = super.mo7833b(kotlinType, receiverParameterDescriptor, list, list2, kotlinType2, modality, visibility);
            this.f40767e = OperatorChecks.f33093a.m28075a(kotlinType).f26375a;
            if (kotlinType != null) {
                return kotlinType;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor", "initialize"}));
        }
    }

    public final boolean mo7831E() {
        if (f40953a || this.f40954b != null) {
            return this.f40954b.f25683e;
        }
        StringBuilder stringBuilder = new StringBuilder("Parameter names status was not set: ");
        stringBuilder.append(this);
        throw new AssertionError(stringBuilder.toString());
    }

    public final boolean mo7758l() {
        if (f40953a || this.f40954b != null) {
            return this.f40954b.f25684f;
        }
        StringBuilder stringBuilder = new StringBuilder("Parameter names status was not set: ");
        stringBuilder.append(this);
        throw new AssertionError(stringBuilder.toString());
    }

    public final void m43014a(boolean z, boolean z2) {
        this.f40954b = ParameterNamesStatus.m27193a(z, z2);
    }
}
