package kotlin.reflect.jvm.internal.impl.descriptors.impl;

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
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

public class PropertyGetterDescriptorImpl extends PropertyAccessorDescriptorImpl implements PropertyGetterDescriptor {
    private KotlinType f40979g;
    private final PropertyGetterDescriptor f40980h;

    public final /* synthetic */ PropertyAccessorDescriptor mo7835E() {
        return m43063F();
    }

    public final /* synthetic */ DeclarationDescriptor aJ_() {
        return m43063F();
    }

    public final /* synthetic */ CallableDescriptor aM_() {
        return m43063F();
    }

    public final /* synthetic */ DeclarationDescriptorWithSource aO_() {
        return m43063F();
    }

    public final /* synthetic */ CallableMemberDescriptor mo7759s() {
        return m43063F();
    }

    public final /* synthetic */ FunctionDescriptor mo7761v() {
        return m43063F();
    }

    public PropertyGetterDescriptorImpl(PropertyDescriptor propertyDescriptor, Annotations annotations, Modality modality, Visibility visibility, boolean z, boolean z2, boolean z3, Kind kind, PropertyGetterDescriptor propertyGetterDescriptor, SourceElement sourceElement) {
        if (propertyDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"correspondingProperty", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyGetterDescriptorImpl", "<init>"}));
        } else if (annotations == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"annotations", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyGetterDescriptorImpl", "<init>"}));
        } else if (modality == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"modality", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyGetterDescriptorImpl", "<init>"}));
        } else if (visibility == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"visibility", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyGetterDescriptorImpl", "<init>"}));
        } else if (kind == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"kind", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyGetterDescriptorImpl", "<init>"}));
        } else if (sourceElement == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"source", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyGetterDescriptorImpl", "<init>"}));
        } else {
            PropertyGetterDescriptorImpl propertyGetterDescriptorImpl;
            PropertyGetterDescriptor propertyGetterDescriptor2;
            StringBuilder stringBuilder = new StringBuilder("<get-");
            stringBuilder.append(propertyDescriptor.mo6689i());
            stringBuilder.append(Operation.GREATER_THAN);
            super(modality, visibility, propertyDescriptor, annotations, Name.m27426c(stringBuilder.toString()), z, z2, z3, kind, sourceElement);
            if (propertyGetterDescriptor != null) {
                propertyGetterDescriptorImpl = this;
                propertyGetterDescriptor2 = propertyGetterDescriptor;
            } else {
                propertyGetterDescriptor2 = this;
            }
            propertyGetterDescriptorImpl.f40980h = propertyGetterDescriptor2;
        }
    }

    public final void m43066a(KotlinType kotlinType) {
        if (kotlinType == null) {
            kotlinType = mo7822D().mo7777x();
        }
        this.f40979g = kotlinType;
    }

    public final Collection<? extends PropertyGetterDescriptor> mo7609m() {
        return super.m42955a(true);
    }

    public final List<ValueParameterDescriptor> mo7757k() {
        List<ValueParameterDescriptor> emptyList = Collections.emptyList();
        if (emptyList != null) {
            return emptyList;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyGetterDescriptorImpl", "getValueParameters"}));
    }

    public final KotlinType aN_() {
        return this.f40979g;
    }

    public final <R, D> R mo7078a(DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d) {
        return declarationDescriptorVisitor.mo5734a((PropertyGetterDescriptor) this, (Object) d);
    }

    private PropertyGetterDescriptor m43063F() {
        PropertyGetterDescriptor propertyGetterDescriptor = this.f40980h;
        if (propertyGetterDescriptor != null) {
            return propertyGetterDescriptor;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyGetterDescriptorImpl", "getOriginal"}));
    }
}
