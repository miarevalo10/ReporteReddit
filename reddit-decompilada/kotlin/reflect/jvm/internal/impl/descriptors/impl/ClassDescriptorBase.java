package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

public abstract class ClassDescriptorBase extends AbstractClassDescriptor {
    private final DeclarationDescriptor f40849a;
    private final SourceElement f40850b;
    private final boolean f40851c;

    protected ClassDescriptorBase(StorageManager storageManager, DeclarationDescriptor declarationDescriptor, Name name, SourceElement sourceElement) {
        if (storageManager == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"storageManager", "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorBase", "<init>"}));
        } else if (declarationDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"containingDeclaration", "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorBase", "<init>"}));
        } else if (name == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"name", "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorBase", "<init>"}));
        } else if (sourceElement == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"source", "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorBase", "<init>"}));
        } else {
            super(storageManager, name);
            this.f40849a = declarationDescriptor;
            this.f40850b = sourceElement;
            this.f40851c = false;
        }
    }

    public boolean mo7745p() {
        return this.f40851c;
    }

    public final DeclarationDescriptor aD_() {
        DeclarationDescriptor declarationDescriptor = this.f40849a;
        if (declarationDescriptor != null) {
            return declarationDescriptor;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorBase", "getContainingDeclaration"}));
    }

    public final SourceElement mo7258r() {
        SourceElement sourceElement = this.f40850b;
        if (sourceElement != null) {
            return sourceElement;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorBase", "getSource"}));
    }
}
