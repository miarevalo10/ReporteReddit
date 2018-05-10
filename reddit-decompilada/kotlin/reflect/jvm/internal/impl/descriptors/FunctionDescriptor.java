package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collection;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;

public interface FunctionDescriptor extends CallableMemberDescriptor {

    public interface CopyBuilder<D extends FunctionDescriptor> {
        CopyBuilder<D> mo5740a();

        CopyBuilder<D> mo5741a(List<ValueParameterDescriptor> list);

        CopyBuilder<D> mo5742a(Kind kind);

        CopyBuilder<D> mo5743a(DeclarationDescriptor declarationDescriptor);

        CopyBuilder<D> mo5744a(Modality modality);

        CopyBuilder<D> mo5745a(ReceiverParameterDescriptor receiverParameterDescriptor);

        CopyBuilder<D> mo5746a(Visibility visibility);

        CopyBuilder<D> mo5747a(Annotations annotations);

        CopyBuilder<D> mo5748a(Name name);

        CopyBuilder<D> mo5749a(KotlinType kotlinType);

        CopyBuilder<D> mo5750a(TypeSubstitution typeSubstitution);

        CopyBuilder<D> mo5751a(boolean z);

        CopyBuilder<D> mo5752b();

        CopyBuilder<D> mo5753b(KotlinType kotlinType);

        CopyBuilder<D> mo5754c();

        CopyBuilder<D> mo5755d();

        CopyBuilder<D> mo5756e();

        D mo5757f();
    }

    boolean mo7746A();

    boolean mo7747B();

    CopyBuilder<? extends FunctionDescriptor> mo7736C();

    DeclarationDescriptor aD_();

    boolean mo7752b();

    boolean mo7753c();

    FunctionDescriptor mo7754d(TypeSubstitutor typeSubstitutor);

    Collection<? extends FunctionDescriptor> mo7609m();

    FunctionDescriptor mo7761v();

    FunctionDescriptor mo7762w();

    boolean mo7763x();

    boolean mo7764y();

    boolean mo7765z();
}
