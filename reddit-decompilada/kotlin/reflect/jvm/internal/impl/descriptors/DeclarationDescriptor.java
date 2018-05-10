package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;

public interface DeclarationDescriptor extends Named, Annotated {
    <R, D> R mo7078a(DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d);

    DeclarationDescriptor aD_();

    DeclarationDescriptor aJ_();

    DeclarationDescriptor mo7079b(TypeSubstitutor typeSubstitutor);
}
