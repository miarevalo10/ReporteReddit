package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collection;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import org.jetbrains.annotations.ReadOnly;

public interface ClassDescriptor extends ClassOrPackageFragmentDescriptor, ClassifierDescriptorWithTypeParameters {
    MemberScope mo7737a(List<? extends TypeProjection> list);

    MemberScope mo7738a(TypeSubstitution typeSubstitution);

    DeclarationDescriptor aD_();

    Modality aG_();

    ClassConstructorDescriptor aH_();

    MemberScope mo7767b();

    MemberScope mo7768d();

    ClassDescriptor mo7769e();

    @ReadOnly
    Collection<ClassConstructorDescriptor> mo7770f();

    ClassKind mo7771g();

    SimpleType mo7714h();

    Visibility mo7257j();

    boolean mo7772k();

    boolean mo7773m();

    @ReadOnly
    List<TypeParameterDescriptor> mo7719s();

    MemberScope mo7739t();

    ReceiverParameterDescriptor mo7740u();

    ClassDescriptor mo7741v();
}
