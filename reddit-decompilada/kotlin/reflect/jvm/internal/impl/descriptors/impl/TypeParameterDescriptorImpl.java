package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker.EMPTY;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.Variance;

public class TypeParameterDescriptorImpl extends AbstractTypeParameterDescriptor {
    private final Function1<KotlinType, Void> f40794b;
    private final List<KotlinType> f40795c;
    private boolean f40796d;

    public static TypeParameterDescriptor m42660a(DeclarationDescriptor declarationDescriptor, Annotations annotations, Variance variance, Name name, int i) {
        if (declarationDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"containingDeclaration", "kotlin/reflect/jvm/internal/impl/descriptors/impl/TypeParameterDescriptorImpl", "createWithDefaultBound"}));
        } else if (annotations == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"annotations", "kotlin/reflect/jvm/internal/impl/descriptors/impl/TypeParameterDescriptorImpl", "createWithDefaultBound"}));
        } else if (variance == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"variance", "kotlin/reflect/jvm/internal/impl/descriptors/impl/TypeParameterDescriptorImpl", "createWithDefaultBound"}));
        } else if (name == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"name", "kotlin/reflect/jvm/internal/impl/descriptors/impl/TypeParameterDescriptorImpl", "createWithDefaultBound"}));
        } else {
            annotations = m42661a(declarationDescriptor, annotations, false, variance, name, i, SourceElement.f25498a);
            annotations.m42665b(DescriptorUtilsKt.m27745d(declarationDescriptor).m27017o());
            annotations.m42667n();
            return annotations;
        }
    }

    public static TypeParameterDescriptorImpl m42661a(DeclarationDescriptor declarationDescriptor, Annotations annotations, boolean z, Variance variance, Name name, int i, SourceElement sourceElement) {
        if (declarationDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"containingDeclaration", "kotlin/reflect/jvm/internal/impl/descriptors/impl/TypeParameterDescriptorImpl", "createForFurtherModification"}));
        } else if (annotations == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"annotations", "kotlin/reflect/jvm/internal/impl/descriptors/impl/TypeParameterDescriptorImpl", "createForFurtherModification"}));
        } else if (variance == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"variance", "kotlin/reflect/jvm/internal/impl/descriptors/impl/TypeParameterDescriptorImpl", "createForFurtherModification"}));
        } else if (name == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"name", "kotlin/reflect/jvm/internal/impl/descriptors/impl/TypeParameterDescriptorImpl", "createForFurtherModification"}));
        } else if (sourceElement == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"source", "kotlin/reflect/jvm/internal/impl/descriptors/impl/TypeParameterDescriptorImpl", "createForFurtherModification"}));
        } else {
            EMPTY empty = EMPTY.f32638a;
            if (declarationDescriptor == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"containingDeclaration", "kotlin/reflect/jvm/internal/impl/descriptors/impl/TypeParameterDescriptorImpl", "createForFurtherModification"}));
            } else if (annotations == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"annotations", "kotlin/reflect/jvm/internal/impl/descriptors/impl/TypeParameterDescriptorImpl", "createForFurtherModification"}));
            } else if (variance == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"variance", "kotlin/reflect/jvm/internal/impl/descriptors/impl/TypeParameterDescriptorImpl", "createForFurtherModification"}));
            } else if (name == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"name", "kotlin/reflect/jvm/internal/impl/descriptors/impl/TypeParameterDescriptorImpl", "createForFurtherModification"}));
            } else if (sourceElement == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"source", "kotlin/reflect/jvm/internal/impl/descriptors/impl/TypeParameterDescriptorImpl", "createForFurtherModification"}));
            } else if (empty != null) {
                return new TypeParameterDescriptorImpl(declarationDescriptor, annotations, z, variance, name, i, sourceElement, empty);
            } else {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"supertypeLoopsResolver", "kotlin/reflect/jvm/internal/impl/descriptors/impl/TypeParameterDescriptorImpl", "createForFurtherModification"}));
            }
        }
    }

    private TypeParameterDescriptorImpl(DeclarationDescriptor declarationDescriptor, Annotations annotations, boolean z, Variance variance, Name name, int i, SourceElement sourceElement, SupertypeLoopChecker supertypeLoopChecker) {
        AbstractTypeParameterDescriptor abstractTypeParameterDescriptor = this;
        if (declarationDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"containingDeclaration", "kotlin/reflect/jvm/internal/impl/descriptors/impl/TypeParameterDescriptorImpl", "<init>"}));
        } else if (annotations == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"annotations", "kotlin/reflect/jvm/internal/impl/descriptors/impl/TypeParameterDescriptorImpl", "<init>"}));
        } else if (variance == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"variance", "kotlin/reflect/jvm/internal/impl/descriptors/impl/TypeParameterDescriptorImpl", "<init>"}));
        } else if (name == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"name", "kotlin/reflect/jvm/internal/impl/descriptors/impl/TypeParameterDescriptorImpl", "<init>"}));
        } else if (sourceElement == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"source", "kotlin/reflect/jvm/internal/impl/descriptors/impl/TypeParameterDescriptorImpl", "<init>"}));
        } else if (supertypeLoopChecker == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"supertypeLoopsChecker", "kotlin/reflect/jvm/internal/impl/descriptors/impl/TypeParameterDescriptorImpl", "<init>"}));
        } else {
            super(LockBasedStorageManager.f33053a, declarationDescriptor, annotations, name, variance, z, i, sourceElement, supertypeLoopChecker);
            abstractTypeParameterDescriptor.f40795c = new ArrayList(1);
            abstractTypeParameterDescriptor.f40796d = false;
            abstractTypeParameterDescriptor.f40794b = null;
        }
    }

    private void m42662o() {
        if (this.f40796d) {
            StringBuilder stringBuilder = new StringBuilder("Type parameter descriptor is already initialized: ");
            stringBuilder.append(m42663p());
            throw new IllegalStateException(stringBuilder.toString());
        }
    }

    private String m42663p() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(mo6689i());
        stringBuilder.append(" declared in ");
        stringBuilder.append(DescriptorUtils.m27653c(aD_()));
        return stringBuilder.toString();
    }

    public final void m42667n() {
        m42662o();
        this.f40796d = true;
    }

    public final void m42665b(KotlinType kotlinType) {
        if (kotlinType == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"bound", "kotlin/reflect/jvm/internal/impl/descriptors/impl/TypeParameterDescriptorImpl", "addUpperBound"}));
        }
        m42662o();
        if (!kotlinType.mo6742d()) {
            this.f40795c.add(kotlinType);
        }
    }

    protected final void mo7774a(KotlinType kotlinType) {
        if (kotlinType == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"type", "kotlin/reflect/jvm/internal/impl/descriptors/impl/TypeParameterDescriptorImpl", "reportSupertypeLoopError"}));
        } else if (this.f40794b != null) {
            this.f40794b.mo6492a(kotlinType);
        }
    }

    protected final List<KotlinType> mo7775m() {
        if (this.f40796d) {
            List<KotlinType> list = this.f40795c;
            if (list != null) {
                return list;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/TypeParameterDescriptorImpl", "resolveUpperBounds"}));
        }
        StringBuilder stringBuilder = new StringBuilder("Type parameter descriptor is not initialized: ");
        stringBuilder.append(m42663p());
        throw new IllegalStateException(stringBuilder.toString());
    }
}
