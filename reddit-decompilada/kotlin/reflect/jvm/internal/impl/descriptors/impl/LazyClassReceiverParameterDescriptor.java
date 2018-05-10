package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ImplicitClassReceiver;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue;

public class LazyClassReceiverParameterDescriptor extends AbstractReceiverParameterDescriptor {
    private final ClassDescriptor f40915a;
    private final ImplicitClassReceiver f40916b;

    public LazyClassReceiverParameterDescriptor(ClassDescriptor classDescriptor) {
        if (classDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"descriptor", "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazyClassReceiverParameterDescriptor", "<init>"}));
        }
        this.f40915a = classDescriptor;
        this.f40916b = new ImplicitClassReceiver(classDescriptor);
    }

    public final ReceiverValue mo7821b() {
        ReceiverValue receiverValue = this.f40916b;
        if (receiverValue != null) {
            return receiverValue;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/LazyClassReceiverParameterDescriptor", "getValue"}));
    }

    public final DeclarationDescriptor aD_() {
        DeclarationDescriptor declarationDescriptor = this.f40915a;
        if (declarationDescriptor != null) {
            return declarationDescriptor;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/LazyClassReceiverParameterDescriptor", "getContainingDeclaration"}));
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("class ");
        stringBuilder.append(this.f40915a.mo6689i());
        stringBuilder.append("::this");
        return stringBuilder.toString();
    }
}
