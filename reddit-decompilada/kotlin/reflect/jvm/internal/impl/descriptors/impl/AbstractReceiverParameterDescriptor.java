package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.ParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.TransientReceiver;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;

public abstract class AbstractReceiverParameterDescriptor extends DeclarationDescriptorImpl implements ReceiverParameterDescriptor {
    private static final Name f40848a = Name.m27426c("<this>");

    public final ReceiverParameterDescriptor mo7755d() {
        return null;
    }

    public final ReceiverParameterDescriptor mo7756e() {
        return null;
    }

    public final boolean mo7758l() {
        return false;
    }

    public final /* synthetic */ DeclarationDescriptor aJ_() {
        return m42783c();
    }

    public final /* synthetic */ CallableDescriptor aM_() {
        return m42783c();
    }

    public final /* synthetic */ DeclarationDescriptor mo7079b(TypeSubstitutor typeSubstitutor) {
        return mo7794a(typeSubstitutor);
    }

    public AbstractReceiverParameterDescriptor() {
        Companion companion = Annotations.f32643a;
        super(Companion.m27115a(), f40848a);
    }

    public final <R, D> R mo7078a(DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d) {
        return declarationDescriptorVisitor.mo5736a((ReceiverParameterDescriptor) this, (Object) d);
    }

    public final List<TypeParameterDescriptor> mo7735f() {
        List<TypeParameterDescriptor> emptyList = Collections.emptyList();
        if (emptyList != null) {
            return emptyList;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractReceiverParameterDescriptor", "getTypeParameters"}));
    }

    public final KotlinType aN_() {
        return mo7777x();
    }

    public final KotlinType mo7777x() {
        KotlinType a = mo7821b().mo5715a();
        if (a != null) {
            return a;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractReceiverParameterDescriptor", "getType"}));
    }

    public final List<ValueParameterDescriptor> mo7757k() {
        List<ValueParameterDescriptor> emptyList = Collections.emptyList();
        if (emptyList != null) {
            return emptyList;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractReceiverParameterDescriptor", "getValueParameters"}));
    }

    public final Collection<? extends CallableDescriptor> mo7609m() {
        Collection emptySet = Collections.emptySet();
        if (emptySet != null) {
            return emptySet;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractReceiverParameterDescriptor", "getOverriddenDescriptors"}));
    }

    public final Visibility mo7257j() {
        Visibility visibility = Visibilities.f25509f;
        if (visibility != null) {
            return visibility;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractReceiverParameterDescriptor", "getVisibility"}));
    }

    private ParameterDescriptor m42783c() {
        if (this != null) {
            return this;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractReceiverParameterDescriptor", "getOriginal"}));
    }

    public final SourceElement mo7258r() {
        SourceElement sourceElement = SourceElement.f25498a;
        if (sourceElement != null) {
            return sourceElement;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractReceiverParameterDescriptor", "getSource"}));
    }

    public final ReceiverParameterDescriptor mo7794a(TypeSubstitutor typeSubstitutor) {
        if (typeSubstitutor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"substitutor", "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractReceiverParameterDescriptor", "substitute"}));
        } else if (typeSubstitutor.f26329b.mo5796a()) {
            return this;
        } else {
            if (aD_() instanceof ClassDescriptor) {
                typeSubstitutor = typeSubstitutor.m28005b(mo7777x(), Variance.f26339c);
            } else {
                typeSubstitutor = typeSubstitutor.m28005b(mo7777x(), Variance.f26337a);
            }
            if (typeSubstitutor == null) {
                return null;
            }
            return new ReceiverParameterDescriptorImpl(aD_(), new TransientReceiver(typeSubstitutor));
        }
    }
}
