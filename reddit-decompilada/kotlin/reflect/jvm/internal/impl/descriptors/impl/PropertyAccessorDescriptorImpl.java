package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;

public abstract class PropertyAccessorDescriptorImpl extends DeclarationDescriptorNonRootImpl implements PropertyAccessorDescriptor {
    static final /* synthetic */ boolean f40925f = true;
    public final boolean f40926a;
    public final boolean f40927b;
    public final boolean f40928c;
    public Visibility f40929d;
    public FunctionDescriptor f40930e;
    private final Modality f40931g;
    private final PropertyDescriptor f40932h;
    private final Kind f40933i;

    public final boolean mo7746A() {
        return false;
    }

    public final boolean mo7747B() {
        return false;
    }

    public abstract PropertyAccessorDescriptor mo7835E();

    public final boolean mo7753c() {
        return false;
    }

    public final boolean mo7758l() {
        return false;
    }

    public final boolean mo7743n() {
        return false;
    }

    public final boolean mo7744o() {
        return false;
    }

    public final boolean mo7763x() {
        return false;
    }

    public final boolean mo7764y() {
        return false;
    }

    public final boolean mo7765z() {
        return false;
    }

    public /* synthetic */ DeclarationDescriptor aJ_() {
        return mo7835E();
    }

    public /* synthetic */ CallableDescriptor aM_() {
        return mo7835E();
    }

    public /* synthetic */ DeclarationDescriptorWithSource aO_() {
        return mo7835E();
    }

    public final /* synthetic */ DeclarationDescriptor mo7079b(TypeSubstitutor typeSubstitutor) {
        return mo7754d(typeSubstitutor);
    }

    public /* synthetic */ CallableMemberDescriptor mo7759s() {
        return mo7835E();
    }

    public /* synthetic */ FunctionDescriptor mo7761v() {
        return mo7835E();
    }

    public PropertyAccessorDescriptorImpl(Modality modality, Visibility visibility, PropertyDescriptor propertyDescriptor, Annotations annotations, Name name, boolean z, boolean z2, boolean z3, Kind kind, SourceElement sourceElement) {
        if (modality == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"modality", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyAccessorDescriptorImpl", "<init>"}));
        } else if (visibility == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"visibility", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyAccessorDescriptorImpl", "<init>"}));
        } else if (propertyDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"correspondingProperty", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyAccessorDescriptorImpl", "<init>"}));
        } else if (annotations == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"annotations", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyAccessorDescriptorImpl", "<init>"}));
        } else if (name == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"name", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyAccessorDescriptorImpl", "<init>"}));
        } else if (sourceElement == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"source", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyAccessorDescriptorImpl", "<init>"}));
        } else {
            super(propertyDescriptor.aD_(), annotations, name, sourceElement);
            this.f40930e = null;
            this.f40931g = modality;
            this.f40929d = visibility;
            this.f40932h = propertyDescriptor;
            this.f40926a = z;
            this.f40927b = z2;
            this.f40928c = z3;
            this.f40933i = kind;
        }
    }

    public final boolean mo7823u() {
        return this.f40926a;
    }

    public final Kind mo7760t() {
        Kind kind = this.f40933i;
        if (kind != null) {
            return kind;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyAccessorDescriptorImpl", "getKind"}));
    }

    public final boolean mo7745p() {
        return this.f40927b;
    }

    public final boolean mo7752b() {
        return this.f40928c;
    }

    public final FunctionDescriptor mo7754d(TypeSubstitutor typeSubstitutor) {
        if (typeSubstitutor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"substitutor", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyAccessorDescriptorImpl", "substitute"}));
        }
        throw new UnsupportedOperationException();
    }

    public final List<TypeParameterDescriptor> mo7735f() {
        List<TypeParameterDescriptor> emptyList = Collections.emptyList();
        if (emptyList != null) {
            return emptyList;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyAccessorDescriptorImpl", "getTypeParameters"}));
    }

    public final Modality aG_() {
        Modality modality = this.f40931g;
        if (modality != null) {
            return modality;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyAccessorDescriptorImpl", "getModality"}));
    }

    public final Visibility mo7257j() {
        Visibility visibility = this.f40929d;
        if (visibility != null) {
            return visibility;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyAccessorDescriptorImpl", "getVisibility"}));
    }

    public final PropertyDescriptor mo7822D() {
        PropertyDescriptor propertyDescriptor = this.f40932h;
        if (propertyDescriptor != null) {
            return propertyDescriptor;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyAccessorDescriptorImpl", "getCorrespondingProperty"}));
    }

    public final ReceiverParameterDescriptor mo7755d() {
        return mo7822D().mo7755d();
    }

    public final ReceiverParameterDescriptor mo7756e() {
        return mo7822D().mo7756e();
    }

    public final CopyBuilder<? extends FunctionDescriptor> mo7736C() {
        throw new UnsupportedOperationException("Accessors must be copied by the corresponding property");
    }

    protected final Collection<PropertyAccessorDescriptor> m42955a(boolean z) {
        Collection<PropertyAccessorDescriptor> arrayList = new ArrayList(0);
        for (PropertyDescriptor propertyDescriptor : mo7822D().mo7609m()) {
            Object b = z ? propertyDescriptor.mo7826b() : propertyDescriptor.mo7827c();
            if (b != null) {
                arrayList.add(b);
            }
        }
        return arrayList;
    }

    public final void mo7749a(Collection<? extends CallableMemberDescriptor> collection) {
        if (collection == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"overriddenDescriptors", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyAccessorDescriptorImpl", "setOverriddenDescriptors"}));
        } else if (!f40925f && collection.isEmpty() == null) {
            throw new AssertionError("Overridden accessors should be empty");
        }
    }

    public final FunctionDescriptor mo7762w() {
        return this.f40930e;
    }

    public final /* synthetic */ CallableMemberDescriptor mo7748a(DeclarationDescriptor declarationDescriptor, Modality modality, Visibility visibility, Kind kind) {
        throw new UnsupportedOperationException("Accessors must be copied by the corresponding property");
    }
}
