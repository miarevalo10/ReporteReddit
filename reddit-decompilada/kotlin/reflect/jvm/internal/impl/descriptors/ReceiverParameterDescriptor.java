package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;

public interface ReceiverParameterDescriptor extends ParameterDescriptor {
    ReceiverParameterDescriptor mo7794a(TypeSubstitutor typeSubstitutor);

    ReceiverValue mo7821b();
}
