package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collection;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;

public interface PropertyDescriptor extends CallableMemberDescriptor, VariableDescriptorWithAccessors {
    PropertyDescriptor mo7825a(TypeSubstitutor typeSubstitutor);

    PropertyGetterDescriptor mo7826b();

    PropertySetterDescriptor mo7827c();

    Collection<? extends PropertyDescriptor> mo7609m();

    List<PropertyAccessorDescriptor> mo7828u();

    PropertyDescriptor mo7829v();

    boolean mo7830w();
}
