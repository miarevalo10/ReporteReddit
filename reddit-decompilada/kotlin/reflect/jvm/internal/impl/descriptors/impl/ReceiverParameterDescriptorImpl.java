package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue;

public class ReceiverParameterDescriptorImpl extends AbstractReceiverParameterDescriptor {
    private final DeclarationDescriptor f40951a;
    private final ReceiverValue f40952b;

    public ReceiverParameterDescriptorImpl(DeclarationDescriptor declarationDescriptor, ReceiverValue receiverValue) {
        if (declarationDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"containingDeclaration", "kotlin/reflect/jvm/internal/impl/descriptors/impl/ReceiverParameterDescriptorImpl", "<init>"}));
        }
        this.f40951a = declarationDescriptor;
        this.f40952b = receiverValue;
    }

    public final ReceiverValue mo7821b() {
        ReceiverValue receiverValue = this.f40952b;
        if (receiverValue != null) {
            return receiverValue;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/ReceiverParameterDescriptorImpl", "getValue"}));
    }

    public final DeclarationDescriptor aD_() {
        DeclarationDescriptor declarationDescriptor = this.f40951a;
        if (declarationDescriptor != null) {
            return declarationDescriptor;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/ReceiverParameterDescriptorImpl", "getContainingDeclaration"}));
    }
}
