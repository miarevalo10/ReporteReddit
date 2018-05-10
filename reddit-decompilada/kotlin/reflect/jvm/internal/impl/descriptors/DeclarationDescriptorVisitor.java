package kotlin.reflect.jvm.internal.impl.descriptors;

public interface DeclarationDescriptorVisitor<R, D> {
    R mo5727a(ClassDescriptor classDescriptor, D d);

    R mo5728a(ConstructorDescriptor constructorDescriptor, D d);

    R mo5729a(FunctionDescriptor functionDescriptor, D d);

    R mo5730a(ModuleDescriptor moduleDescriptor, D d);

    R mo5731a(PackageFragmentDescriptor packageFragmentDescriptor, D d);

    R mo5732a(PackageViewDescriptor packageViewDescriptor, D d);

    R mo5733a(PropertyDescriptor propertyDescriptor, D d);

    R mo5734a(PropertyGetterDescriptor propertyGetterDescriptor, D d);

    R mo5735a(PropertySetterDescriptor propertySetterDescriptor, D d);

    R mo5736a(ReceiverParameterDescriptor receiverParameterDescriptor, D d);

    R mo5737a(TypeAliasDescriptor typeAliasDescriptor, D d);

    R mo5738a(TypeParameterDescriptor typeParameterDescriptor, D d);

    R mo5739a(ValueParameterDescriptor valueParameterDescriptor, D d);
}
