package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collection;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.ReadOnly;

public interface CallableDescriptor extends DeclarationDescriptorNonRoot, DeclarationDescriptorWithVisibility {
    CallableDescriptor aM_();

    KotlinType aN_();

    ReceiverParameterDescriptor mo7755d();

    ReceiverParameterDescriptor mo7756e();

    @ReadOnly
    List<TypeParameterDescriptor> mo7735f();

    List<ValueParameterDescriptor> mo7757k();

    boolean mo7758l();

    Collection<? extends CallableDescriptor> mo7609m();
}
