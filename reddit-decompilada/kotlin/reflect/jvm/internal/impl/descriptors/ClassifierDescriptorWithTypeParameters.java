package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.List;
import org.jetbrains.annotations.ReadOnly;

public interface ClassifierDescriptorWithTypeParameters extends ClassifierDescriptor, DeclarationDescriptorWithVisibility, MemberDescriptor {
    boolean mo7742l();

    @ReadOnly
    List<TypeParameterDescriptor> mo7719s();
}
