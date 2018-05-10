package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;

/* compiled from: ValueParameterDescriptorImpl.kt */
public class ValueParameterDescriptorImpl extends VariableDescriptorImpl implements ValueParameterDescriptor {
    public static final Companion f40852a = new Companion();
    private final ValueParameterDescriptor f40853b;
    private final int f40854c;
    private final boolean f40855d;
    private final boolean f40856e;
    private final boolean f40857f;
    private final KotlinType f40858g;

    /* compiled from: ValueParameterDescriptorImpl.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    public final boolean mo7807y() {
        return false;
    }

    public final /* bridge */ /* synthetic */ ConstantValue mo7808z() {
        return null;
    }

    public ValueParameterDescriptorImpl(CallableDescriptor callableDescriptor, ValueParameterDescriptor valueParameterDescriptor, int i, Annotations annotations, Name name, KotlinType kotlinType, boolean z, boolean z2, boolean z3, KotlinType kotlinType2, SourceElement sourceElement) {
        CallableDescriptor callableDescriptor2 = callableDescriptor;
        Intrinsics.m26847b(callableDescriptor2, "containingDeclaration");
        Annotations annotations2 = annotations;
        Intrinsics.m26847b(annotations2, "annotations");
        Name name2 = name;
        Intrinsics.m26847b(name2, "name");
        KotlinType kotlinType3 = kotlinType;
        Intrinsics.m26847b(kotlinType3, "outType");
        SourceElement sourceElement2 = sourceElement;
        Intrinsics.m26847b(sourceElement2, "source");
        super(callableDescriptor2, annotations2, name2, kotlinType3, sourceElement2);
        this.f40854c = i;
        this.f40855d = z;
        this.f40856e = z2;
        this.f40857f = z3;
        this.f40858g = kotlinType2;
        r6.f40853b = valueParameterDescriptor == null ? (ValueParameterDescriptor) r6 : valueParameterDescriptor;
    }

    public final /* synthetic */ VariableDescriptor mo7798C() {
        return mo7804o();
    }

    public final /* synthetic */ DeclarationDescriptor aD_() {
        return mo7800b();
    }

    public final /* synthetic */ DeclarationDescriptor aJ_() {
        return mo7804o();
    }

    public final /* synthetic */ CallableDescriptor aM_() {
        return mo7804o();
    }

    public final /* synthetic */ DeclarationDescriptorWithSource aO_() {
        return mo7804o();
    }

    public final /* synthetic */ DeclarationDescriptor mo7079b(TypeSubstitutor typeSubstitutor) {
        Intrinsics.m26847b(typeSubstitutor, "substitutor");
        if (typeSubstitutor.f26329b.mo5796a() != null) {
            return this;
        }
        throw ((Throwable) new UnsupportedOperationException());
    }

    public final int mo7801c() {
        return this.f40854c;
    }

    public final boolean mo7805p() {
        return this.f40856e;
    }

    public final boolean mo7806s() {
        return this.f40857f;
    }

    public final KotlinType mo7803n() {
        return this.f40858g;
    }

    public final CallableDescriptor mo7800b() {
        DeclarationDescriptor aD_ = super.aD_();
        if (aD_ != null) {
            return (CallableDescriptor) aD_;
        }
        throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.CallableDescriptor");
    }

    public final boolean mo7802h() {
        if (this.f40855d) {
            CallableDescriptor b = mo7800b();
            if (b == null) {
                throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.CallableMemberDescriptor");
            } else if (((CallableMemberDescriptor) b).mo7760t().m27041a()) {
                return true;
            }
        }
        return false;
    }

    public final ValueParameterDescriptor mo7804o() {
        return this.f40853b == ((ValueParameterDescriptorImpl) this) ? this : this.f40853b.mo7804o();
    }

    public final <R, D> R mo7078a(DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d) {
        Intrinsics.m26847b(declarationDescriptorVisitor, "visitor");
        return declarationDescriptorVisitor.mo5739a((ValueParameterDescriptor) this, (Object) d);
    }

    public final ValueParameterDescriptor mo7799a(CallableDescriptor callableDescriptor, Name name, int i) {
        CallableDescriptor callableDescriptor2 = callableDescriptor;
        Intrinsics.m26847b(callableDescriptor2, "newOwner");
        Name name2 = name;
        Intrinsics.m26847b(name2, "newName");
        Object q = mo5718q();
        Intrinsics.m26843a(q, "annotations");
        Object x = mo7777x();
        Intrinsics.m26843a(x, "type");
        boolean h = mo7802h();
        boolean z = this.f40856e;
        boolean z2 = this.f40857f;
        KotlinType kotlinType = this.f40858g;
        Object obj = SourceElement.f25498a;
        Intrinsics.m26843a(obj, "SourceElement.NO_SOURCE");
        return new ValueParameterDescriptorImpl(callableDescriptor2, null, i, q, name2, x, h, z, z2, kotlinType, obj);
    }

    public final Visibility mo7257j() {
        return Visibilities.f25509f;
    }

    public final Collection<ValueParameterDescriptor> mo7609m() {
        Iterable<CallableDescriptor> m = mo7800b().mo7609m();
        Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(m));
        for (CallableDescriptor k : m) {
            arrayList.add((ValueParameterDescriptor) k.mo7757k().get(this.f40854c));
        }
        return (List) arrayList;
    }
}
