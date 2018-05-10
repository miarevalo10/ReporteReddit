package kotlin.reflect.jvm.internal.impl.types;

import java.util.Collection;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import org.jetbrains.annotations.ReadOnly;

public interface TypeConstructor {
    @ReadOnly
    Collection<KotlinType> aL_();

    @ReadOnly
    List<TypeParameterDescriptor> mo5723b();

    ClassifierDescriptor mo5724c();

    boolean mo5725d();

    KotlinBuiltIns mo5726e();
}
