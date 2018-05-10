package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.Collection;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: ClassDescriptorFactory.kt */
public interface ClassDescriptorFactory {
    Collection<ClassDescriptor> mo5704a(FqName fqName);

    ClassDescriptor mo5705a(ClassId classId);

    boolean mo5706a(FqName fqName, Name name);
}
