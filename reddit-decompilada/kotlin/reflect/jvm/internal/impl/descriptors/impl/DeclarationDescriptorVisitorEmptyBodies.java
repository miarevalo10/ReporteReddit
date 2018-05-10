package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;

public class DeclarationDescriptorVisitorEmptyBodies<R, D> implements DeclarationDescriptorVisitor<R, D> {
    public final R mo5727a(ClassDescriptor classDescriptor, D d) {
        return null;
    }

    public R mo5729a(FunctionDescriptor functionDescriptor, D d) {
        return null;
    }

    public final R mo5730a(ModuleDescriptor moduleDescriptor, D d) {
        return null;
    }

    public final R mo5731a(PackageFragmentDescriptor packageFragmentDescriptor, D d) {
        return null;
    }

    public final R mo5732a(PackageViewDescriptor packageViewDescriptor, D d) {
        return null;
    }

    public R mo5733a(PropertyDescriptor propertyDescriptor, D d) {
        return null;
    }

    public final R mo5736a(ReceiverParameterDescriptor receiverParameterDescriptor, D d) {
        return null;
    }

    public final R mo5737a(TypeAliasDescriptor typeAliasDescriptor, D d) {
        return null;
    }

    public final R mo5738a(TypeParameterDescriptor typeParameterDescriptor, D d) {
        return null;
    }

    public final R mo5739a(ValueParameterDescriptor valueParameterDescriptor, D d) {
        return null;
    }

    public R mo5728a(ConstructorDescriptor constructorDescriptor, D d) {
        return mo5729a((FunctionDescriptor) constructorDescriptor, (Object) d);
    }

    public final R mo5734a(PropertyGetterDescriptor propertyGetterDescriptor, D d) {
        return mo5729a((FunctionDescriptor) propertyGetterDescriptor, (Object) d);
    }

    public final R mo5735a(PropertySetterDescriptor propertySetterDescriptor, D d) {
        return mo5729a((FunctionDescriptor) propertySetterDescriptor, (Object) d);
    }
}
