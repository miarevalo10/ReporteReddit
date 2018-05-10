package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;

/* compiled from: ClassConstructorDescriptor.kt */
public interface ClassConstructorDescriptor extends ConstructorDescriptor {
    ClassConstructorDescriptor mo7817a(DeclarationDescriptor declarationDescriptor, Modality modality, Visibility visibility, Kind kind, boolean z);

    ClassConstructorDescriptor mo7818a(TypeSubstitutor typeSubstitutor);
}
