package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;

public abstract class VariableDescriptorWithInitializerImpl extends VariableDescriptorImpl {
    static final /* synthetic */ boolean f40859l = true;
    protected final boolean f40860j;
    protected NullableLazyValue<ConstantValue<?>> f40861k;

    public VariableDescriptorWithInitializerImpl(DeclarationDescriptor declarationDescriptor, Annotations annotations, Name name, boolean z, SourceElement sourceElement) {
        if (declarationDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"containingDeclaration", "kotlin/reflect/jvm/internal/impl/descriptors/impl/VariableDescriptorWithInitializerImpl", "<init>"}));
        } else if (annotations == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"annotations", "kotlin/reflect/jvm/internal/impl/descriptors/impl/VariableDescriptorWithInitializerImpl", "<init>"}));
        } else if (name == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"name", "kotlin/reflect/jvm/internal/impl/descriptors/impl/VariableDescriptorWithInitializerImpl", "<init>"}));
        } else if (sourceElement == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"source", "kotlin/reflect/jvm/internal/impl/descriptors/impl/VariableDescriptorWithInitializerImpl", "<init>"}));
        } else {
            super(declarationDescriptor, annotations, name, null, sourceElement);
            this.f40860j = z;
        }
    }

    public final boolean mo7807y() {
        return this.f40860j;
    }

    public final ConstantValue<?> mo7808z() {
        return this.f40861k != null ? (ConstantValue) this.f40861k.invoke() : null;
    }

    public final void m42825a(NullableLazyValue<ConstantValue<?>> nullableLazyValue) {
        if (nullableLazyValue == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"compileTimeInitializer", "kotlin/reflect/jvm/internal/impl/descriptors/impl/VariableDescriptorWithInitializerImpl", "setCompileTimeInitializer"}));
        } else if (f40859l || !this.f40860j) {
            this.f40861k = nullableLazyValue;
        } else {
            StringBuilder stringBuilder = new StringBuilder("Constant value for variable initializer should be recorded only for final variables: ");
            stringBuilder.append(mo6689i());
            throw new AssertionError(stringBuilder.toString());
        }
    }
}
