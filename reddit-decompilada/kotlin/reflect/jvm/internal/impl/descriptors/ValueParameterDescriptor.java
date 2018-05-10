package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collection;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: ValueParameterDescriptor.kt */
public interface ValueParameterDescriptor extends ParameterDescriptor, VariableDescriptor {
    ValueParameterDescriptor mo7799a(CallableDescriptor callableDescriptor, Name name, int i);

    CallableDescriptor mo7800b();

    int mo7801c();

    boolean mo7802h();

    Collection<ValueParameterDescriptor> mo7609m();

    KotlinType mo7803n();

    ValueParameterDescriptor mo7804o();

    boolean mo7805p();

    boolean mo7806s();
}
