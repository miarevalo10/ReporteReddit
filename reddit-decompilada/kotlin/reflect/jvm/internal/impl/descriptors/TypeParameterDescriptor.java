package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;

public interface TypeParameterDescriptor extends ClassifierDescriptor {
    @Deprecated
    TypeParameterDescriptor mo7709a(TypeSubstitutor typeSubstitutor);

    boolean mo7711b();

    TypeConstructor mo7610c();

    TypeParameterDescriptor mo7712d();

    int mo7713g();

    List<KotlinType> mo7715j();

    Variance mo7716k();

    boolean mo7717l();
}
