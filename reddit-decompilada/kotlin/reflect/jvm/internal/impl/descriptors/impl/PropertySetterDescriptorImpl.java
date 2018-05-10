package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

public class PropertySetterDescriptorImpl extends PropertyAccessorDescriptorImpl implements PropertySetterDescriptor {
    public static final /* synthetic */ boolean f40981h = true;
    public ValueParameterDescriptor f40982g;
    private final PropertySetterDescriptor f40983i;

    public final /* synthetic */ PropertyAccessorDescriptor mo7835E() {
        return m43071F();
    }

    public final /* synthetic */ DeclarationDescriptor aJ_() {
        return m43071F();
    }

    public final /* synthetic */ CallableDescriptor aM_() {
        return m43071F();
    }

    public final /* synthetic */ DeclarationDescriptorWithSource aO_() {
        return m43071F();
    }

    public final /* synthetic */ CallableMemberDescriptor mo7759s() {
        return m43071F();
    }

    public final /* synthetic */ FunctionDescriptor mo7761v() {
        return m43071F();
    }

    public PropertySetterDescriptorImpl(PropertyDescriptor propertyDescriptor, Annotations annotations, Modality modality, Visibility visibility, boolean z, boolean z2, boolean z3, Kind kind, PropertySetterDescriptor propertySetterDescriptor, SourceElement sourceElement) {
        if (propertyDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"correspondingProperty", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertySetterDescriptorImpl", "<init>"}));
        } else if (annotations == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"annotations", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertySetterDescriptorImpl", "<init>"}));
        } else if (modality == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"modality", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertySetterDescriptorImpl", "<init>"}));
        } else if (visibility == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"visibility", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertySetterDescriptorImpl", "<init>"}));
        } else if (kind == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"kind", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertySetterDescriptorImpl", "<init>"}));
        } else if (sourceElement == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"source", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertySetterDescriptorImpl", "<init>"}));
        } else {
            PropertySetterDescriptorImpl propertySetterDescriptorImpl;
            PropertySetterDescriptor propertySetterDescriptor2;
            StringBuilder stringBuilder = new StringBuilder("<set-");
            stringBuilder.append(propertyDescriptor.mo6689i());
            stringBuilder.append(Operation.GREATER_THAN);
            super(modality, visibility, propertyDescriptor, annotations, Name.m27426c(stringBuilder.toString()), z, z2, z3, kind, sourceElement);
            if (propertySetterDescriptor != null) {
                propertySetterDescriptorImpl = this;
                propertySetterDescriptor2 = propertySetterDescriptor;
            } else {
                propertySetterDescriptor2 = this;
            }
            propertySetterDescriptorImpl.f40983i = propertySetterDescriptor2;
        }
    }

    public final void m43075a(ValueParameterDescriptor valueParameterDescriptor) {
        if (valueParameterDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{MediationRewardedVideoAdAdapter.CUSTOM_EVENT_SERVER_PARAMETER_FIELD, "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertySetterDescriptorImpl", "initialize"}));
        } else if (f40981h || this.f40982g == null) {
            this.f40982g = valueParameterDescriptor;
        } else {
            throw new AssertionError();
        }
    }

    public static ValueParameterDescriptorImpl m43072a(PropertySetterDescriptor propertySetterDescriptor, KotlinType kotlinType) {
        if (propertySetterDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"setterDescriptor", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertySetterDescriptorImpl", "createSetterParameter"}));
        } else if (kotlinType == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"type", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertySetterDescriptorImpl", "createSetterParameter"}));
        } else {
            Companion companion = Annotations.f32643a;
            return new ValueParameterDescriptorImpl(propertySetterDescriptor, null, 0, Companion.m27115a(), Name.m27426c("<set-?>"), kotlinType, false, false, false, null, SourceElement.f25498a);
        }
    }

    public final Collection<? extends PropertySetterDescriptor> mo7609m() {
        return super.m42955a(false);
    }

    public final List<ValueParameterDescriptor> mo7757k() {
        if (this.f40982g == null) {
            throw new IllegalStateException();
        }
        List<ValueParameterDescriptor> singletonList = Collections.singletonList(this.f40982g);
        if (singletonList != null) {
            return singletonList;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertySetterDescriptorImpl", "getValueParameters"}));
    }

    public final KotlinType aN_() {
        KotlinType x = DescriptorUtilsKt.m27745d(this).m27026x();
        if (x != null) {
            return x;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertySetterDescriptorImpl", "getReturnType"}));
    }

    public final <R, D> R mo7078a(DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d) {
        return declarationDescriptorVisitor.mo5735a((PropertySetterDescriptor) this, (Object) d);
    }

    private PropertySetterDescriptor m43071F() {
        PropertySetterDescriptor propertySetterDescriptor = this.f40983i;
        if (propertySetterDescriptor != null) {
            return propertySetterDescriptor;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertySetterDescriptorImpl", "getOriginal"}));
    }
}
