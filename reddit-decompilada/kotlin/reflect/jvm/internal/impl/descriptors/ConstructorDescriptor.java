package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;

public interface ConstructorDescriptor extends FunctionDescriptor {
    ConstructorDescriptor mo7819c(TypeSubstitutor typeSubstitutor);

    List<TypeParameterDescriptor> mo7735f();

    ClassifierDescriptorWithTypeParameters mo7820u();
}
