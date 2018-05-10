package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.Variance;

public abstract class AbstractLazyTypeParameterDescriptor extends AbstractTypeParameterDescriptor {
    public AbstractLazyTypeParameterDescriptor(StorageManager storageManager, DeclarationDescriptor declarationDescriptor, Name name, Variance variance, boolean z, int i, SourceElement sourceElement, SupertypeLoopChecker supertypeLoopChecker) {
        if (storageManager == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"storageManager", "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractLazyTypeParameterDescriptor", "<init>"}));
        } else if (declarationDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"containingDeclaration", "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractLazyTypeParameterDescriptor", "<init>"}));
        } else if (name == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"name", "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractLazyTypeParameterDescriptor", "<init>"}));
        } else if (variance == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"variance", "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractLazyTypeParameterDescriptor", "<init>"}));
        } else if (sourceElement == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"source", "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractLazyTypeParameterDescriptor", "<init>"}));
        } else if (supertypeLoopChecker == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"supertypeLoopChecker", "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractLazyTypeParameterDescriptor", "<init>"}));
        } else {
            Companion companion = Annotations.f32643a;
            super(storageManager, declarationDescriptor, Companion.m27115a(), name, variance, z, i, sourceElement, supertypeLoopChecker);
        }
    }

    public String toString() {
        String str;
        String str2 = "%s%s%s";
        Object[] objArr = new Object[3];
        objArr[0] = this.f40719a ? "reified " : "";
        if (mo7716k() == Variance.f26337a) {
            str = "";
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(mo7716k());
            stringBuilder.append(" ");
            str = stringBuilder.toString();
        }
        objArr[1] = str;
        objArr[2] = mo6689i();
        return String.format(str2, objArr);
    }
}
