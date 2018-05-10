package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
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
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.DescriptorSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.utils.SmartSet;
import org.jetbrains.annotations.ReadOnly;

public class PropertyDescriptorImpl extends VariableDescriptorWithInitializerImpl implements PropertyDescriptor {
    public Visibility f40934a;
    protected final boolean f40935b;
    protected final boolean f40936c;
    protected ReceiverParameterDescriptor f40937d;
    protected PropertyGetterDescriptorImpl f40938e;
    protected PropertySetterDescriptor f40939f;
    protected boolean f40940g;
    private final Modality f40941m;
    private Collection<? extends PropertyDescriptor> f40942n;
    private final PropertyDescriptor f40943o;
    private final Kind f40944p;
    private final boolean f40945q;
    private final boolean f40946r;
    private final boolean f40947s;
    private final boolean f40948t;
    private ReceiverParameterDescriptor f40949u;
    private List<TypeParameterDescriptor> f40950v;

    public final /* synthetic */ VariableDescriptor mo7798C() {
        return mo7829v();
    }

    public final /* synthetic */ DeclarationDescriptor aJ_() {
        return mo7829v();
    }

    public final /* synthetic */ CallableDescriptor aM_() {
        return mo7829v();
    }

    public final /* synthetic */ DeclarationDescriptorWithSource aO_() {
        return mo7829v();
    }

    public final /* synthetic */ DeclarationDescriptor mo7079b(TypeSubstitutor typeSubstitutor) {
        return mo7825a(typeSubstitutor);
    }

    public final /* synthetic */ CallableMemberDescriptor mo7759s() {
        return mo7829v();
    }

    protected PropertyDescriptorImpl(DeclarationDescriptor declarationDescriptor, PropertyDescriptor propertyDescriptor, Annotations annotations, Modality modality, Visibility visibility, boolean z, Name name, Kind kind, SourceElement sourceElement, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        VariableDescriptorWithInitializerImpl variableDescriptorWithInitializerImpl = this;
        Modality modality2 = modality;
        Visibility visibility2 = visibility;
        Kind kind2 = kind;
        if (declarationDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"containingDeclaration", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl", "<init>"}));
        } else if (annotations == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"annotations", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl", "<init>"}));
        } else if (modality2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"modality", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl", "<init>"}));
        } else if (visibility2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"visibility", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl", "<init>"}));
        } else if (name == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"name", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl", "<init>"}));
        } else if (kind2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"kind", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl", "<init>"}));
        } else if (sourceElement == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"source", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl", "<init>"}));
        } else {
            super(declarationDescriptor, annotations, name, z, sourceElement);
            variableDescriptorWithInitializerImpl.f40942n = null;
            variableDescriptorWithInitializerImpl.f40941m = modality2;
            variableDescriptorWithInitializerImpl.f40934a = visibility2;
            variableDescriptorWithInitializerImpl.f40943o = propertyDescriptor == null ? variableDescriptorWithInitializerImpl : propertyDescriptor;
            variableDescriptorWithInitializerImpl.f40944p = kind2;
            variableDescriptorWithInitializerImpl.f40935b = z2;
            variableDescriptorWithInitializerImpl.f40945q = z3;
            variableDescriptorWithInitializerImpl.f40946r = z4;
            variableDescriptorWithInitializerImpl.f40947s = z5;
            variableDescriptorWithInitializerImpl.f40948t = z6;
            variableDescriptorWithInitializerImpl.f40936c = z7;
        }
    }

    public static PropertyDescriptorImpl m42981a(DeclarationDescriptor declarationDescriptor, Annotations annotations, Modality modality, Visibility visibility, Name name, Kind kind, SourceElement sourceElement) {
        if (declarationDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"containingDeclaration", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl", "create"}));
        } else if (annotations == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"annotations", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl", "create"}));
        } else if (modality == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"modality", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl", "create"}));
        } else if (visibility == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"visibility", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl", "create"}));
        } else if (name == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"name", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl", "create"}));
        } else if (kind == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"kind", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl", "create"}));
        } else if (sourceElement != null) {
            return new PropertyDescriptorImpl(declarationDescriptor, null, annotations, modality, visibility, true, name, kind, sourceElement, false, false, false, false, false, false);
        } else {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"source", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl", "create"}));
        }
    }

    public final void m42991a(KotlinType kotlinType, @ReadOnly List<? extends TypeParameterDescriptor> list, ReceiverParameterDescriptor receiverParameterDescriptor, KotlinType kotlinType2) {
        if (kotlinType == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"outType", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl", "setType"}));
        } else if (list == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"typeParameters", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl", "setType"}));
        } else {
            kotlinType2 = DescriptorFactory.m27627a((CallableDescriptor) this, kotlinType2);
            if (kotlinType == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"outType", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl", "setType"}));
            } else if (list == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"typeParameters", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl", "setType"}));
            } else {
                m42670a(kotlinType);
                this.f40950v = new ArrayList(list);
                this.f40949u = kotlinType2;
                this.f40937d = receiverParameterDescriptor;
            }
        }
    }

    public final void m42990a(PropertyGetterDescriptorImpl propertyGetterDescriptorImpl, PropertySetterDescriptor propertySetterDescriptor) {
        this.f40938e = propertyGetterDescriptorImpl;
        this.f40939f = propertySetterDescriptor;
    }

    public final List<TypeParameterDescriptor> mo7735f() {
        List<TypeParameterDescriptor> list = this.f40950v;
        if (list != null) {
            return list;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl", "getTypeParameters"}));
    }

    public final ReceiverParameterDescriptor mo7755d() {
        return this.f40949u;
    }

    public final ReceiverParameterDescriptor mo7756e() {
        return this.f40937d;
    }

    public final KotlinType aN_() {
        KotlinType x = mo7777x();
        if (x != null) {
            return x;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl", "getReturnType"}));
    }

    public final Modality aG_() {
        Modality modality = this.f40941m;
        if (modality != null) {
            return modality;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl", "getModality"}));
    }

    public final Visibility mo7257j() {
        Visibility visibility = this.f40934a;
        if (visibility != null) {
            return visibility;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl", "getVisibility"}));
    }

    public final PropertySetterDescriptor mo7827c() {
        return this.f40939f;
    }

    public final boolean mo7830w() {
        return this.f40935b;
    }

    public boolean mo7776A() {
        return this.f40945q;
    }

    public boolean mo7745p() {
        return this.f40948t;
    }

    public final boolean mo7824B() {
        return this.f40936c;
    }

    public final List<PropertyAccessorDescriptor> mo7828u() {
        List<PropertyAccessorDescriptor> arrayList = new ArrayList(2);
        if (this.f40938e != null) {
            arrayList.add(this.f40938e);
        }
        if (this.f40939f != null) {
            arrayList.add(this.f40939f);
        }
        return arrayList;
    }

    private PropertyDescriptor m42979a(TypeSubstitutor typeSubstitutor, DeclarationDescriptor declarationDescriptor, Modality modality, Visibility visibility, PropertyDescriptor propertyDescriptor, boolean z, Kind kind) {
        PropertyDescriptorImpl propertyDescriptorImpl = this;
        Kind kind2 = kind;
        if (typeSubstitutor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"originalSubstitutor", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl", "doSubstitute"}));
        } else if (declarationDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"newOwner", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl", "doSubstitute"}));
        } else if (modality == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"newModality", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl", "doSubstitute"}));
        } else if (visibility == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"newVisibility", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl", "doSubstitute"}));
        } else if (kind2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"kind", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl", "doSubstitute"}));
        } else {
            PropertyDescriptor a = mo7839a(declarationDescriptor, modality, visibility, propertyDescriptor, kind2);
            List f = mo7735f();
            List arrayList = new ArrayList(f.size());
            TypeSubstitutor a2 = DescriptorSubstitutor.m27928a(f, typeSubstitutor.m28004a(), a, arrayList);
            KotlinType b = a2.m28005b(mo7777x(), Variance.f26339c);
            if (b == null) {
                return null;
            }
            KotlinType b2;
            PropertyGetterDescriptorImpl propertyGetterDescriptorImpl;
            boolean z2;
            boolean z3;
            Kind kind3;
            PropertySetterDescriptor propertySetterDescriptor;
            ReceiverParameterDescriptor receiverParameterDescriptor = propertyDescriptorImpl.f40937d;
            if (receiverParameterDescriptor != null) {
                receiverParameterDescriptor = receiverParameterDescriptor.mo7794a(a2);
                if (receiverParameterDescriptor == null) {
                    return null;
                }
            }
            receiverParameterDescriptor = null;
            if (propertyDescriptorImpl.f40949u != null) {
                b2 = a2.m28005b(propertyDescriptorImpl.f40949u.mo7777x(), Variance.f26338b);
                if (b2 == null) {
                    return null;
                }
            }
            b2 = null;
            a.m42991a(b, arrayList, receiverParameterDescriptor, b2);
            if (propertyDescriptorImpl.f40938e == null) {
                propertyGetterDescriptorImpl = null;
                z2 = false;
                z3 = true;
                kind3 = kind2;
            } else {
                Annotations q = propertyDescriptorImpl.f40938e.mo5718q();
                Visibility a3 = m42980a(propertyDescriptorImpl.f40938e.mo7257j(), kind2);
                z2 = false;
                z3 = true;
                kind3 = kind2;
                PropertyAccessorDescriptorImpl propertyGetterDescriptorImpl2 = new PropertyGetterDescriptorImpl(a, q, modality, a3, propertyDescriptorImpl.f40938e.f40926a, propertyDescriptorImpl.f40938e.f40927b, propertyDescriptorImpl.f40938e.f40928c, kind3, propertyDescriptor == null ? null : propertyDescriptor.mo7826b(), SourceElement.f25498a);
            }
            if (propertyGetterDescriptorImpl != null) {
                b2 = propertyDescriptorImpl.f40938e.aN_();
                propertyGetterDescriptorImpl.f40930e = m42978a(a2, propertyDescriptorImpl.f40938e);
                propertyGetterDescriptorImpl.m43066a(b2 != null ? a2.m28005b(b2, Variance.f26339c) : null);
            }
            if (propertyDescriptorImpl.f40939f == null) {
                propertySetterDescriptor = null;
            } else {
                propertySetterDescriptor = new PropertySetterDescriptorImpl(a, propertyDescriptorImpl.f40939f.mo5718q(), modality, m42980a(propertyDescriptorImpl.f40939f.mo7257j(), kind3), propertyDescriptorImpl.f40939f.mo7823u(), propertyDescriptorImpl.f40939f.mo7745p(), propertyDescriptorImpl.f40939f.mo7752b(), kind3, propertyDescriptor == null ? null : propertyDescriptor.mo7827c(), SourceElement.f25498a);
            }
            if (propertySetterDescriptor != null) {
                List a4 = FunctionDescriptorImpl.m42596a(propertySetterDescriptor, propertyDescriptorImpl.f40939f.mo7757k(), a2, z2, z2);
                if (a4 == null) {
                    a.f40940g = z3;
                    a4 = Collections.singletonList(PropertySetterDescriptorImpl.m43072a(propertySetterDescriptor, DescriptorUtilsKt.m27745d(declarationDescriptor).m27014l()));
                }
                if (a4.size() != z3) {
                    throw new IllegalStateException();
                }
                propertySetterDescriptor.f40930e = m42978a(a2, propertyDescriptorImpl.f40939f);
                propertySetterDescriptor.m43075a((ValueParameterDescriptor) a4.get(z2));
            }
            a.m42990a(propertyGetterDescriptorImpl, propertySetterDescriptor);
            if (z) {
                Collection b3 = SmartSet.m28120b();
                for (PropertyDescriptor a5 : mo7609m()) {
                    b3.add(a5.mo7825a(a2));
                }
                a.mo7749a(b3);
            }
            return a;
        }
    }

    private static Visibility m42980a(Visibility visibility, Kind kind) {
        return (kind != Kind.FAKE_OVERRIDE || Visibilities.m27096a(visibility.mo5763b()) == null) ? visibility : Visibilities.f25511h;
    }

    private static FunctionDescriptor m42978a(TypeSubstitutor typeSubstitutor, PropertyAccessorDescriptor propertyAccessorDescriptor) {
        if (typeSubstitutor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"substitutor", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl", "getSubstitutedInitialSignatureDescriptor"}));
        } else if (propertyAccessorDescriptor != null) {
            return propertyAccessorDescriptor.mo7762w() != null ? propertyAccessorDescriptor.mo7762w().mo7754d(typeSubstitutor) : null;
        } else {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"accessorDescriptor", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl", "getSubstitutedInitialSignatureDescriptor"}));
        }
    }

    public PropertyDescriptorImpl mo7839a(DeclarationDescriptor declarationDescriptor, Modality modality, Visibility visibility, PropertyDescriptor propertyDescriptor, Kind kind) {
        VariableDescriptorWithInitializerImpl variableDescriptorWithInitializerImpl = this;
        if (declarationDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"newOwner", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl", "createSubstitutedCopy"}));
        } else if (modality == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"newModality", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl", "createSubstitutedCopy"}));
        } else if (visibility == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"newVisibility", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl", "createSubstitutedCopy"}));
        } else if (kind == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"kind", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl", "createSubstitutedCopy"}));
        } else {
            Annotations q = mo5718q();
            boolean z = variableDescriptorWithInitializerImpl.f40860j;
            Name i = mo6689i();
            SourceElement sourceElement = SourceElement.f25498a;
            boolean z2 = variableDescriptorWithInitializerImpl.f40935b;
            boolean A = mo7776A();
            boolean z3 = variableDescriptorWithInitializerImpl.f40946r;
            return new PropertyDescriptorImpl(declarationDescriptor, propertyDescriptor, q, modality, visibility, z, i, kind, sourceElement, z2, A, z3, variableDescriptorWithInitializerImpl.f40947s, mo7745p(), variableDescriptorWithInitializerImpl.f40936c);
        }
    }

    public final <R, D> R mo7078a(DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d) {
        return declarationDescriptorVisitor.mo5733a((PropertyDescriptor) this, (Object) d);
    }

    public final PropertyDescriptor mo7829v() {
        PropertyDescriptor v = this.f40943o == this ? this : this.f40943o.mo7829v();
        if (v != null) {
            return v;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl", "getOriginal"}));
    }

    public final Kind mo7760t() {
        Kind kind = this.f40944p;
        if (kind != null) {
            return kind;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl", "getKind"}));
    }

    public final boolean mo7743n() {
        return this.f40946r;
    }

    public final boolean mo7744o() {
        return this.f40947s;
    }

    public final void mo7749a(Collection<? extends CallableMemberDescriptor> collection) {
        if (collection == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"overriddenDescriptors", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl", "setOverriddenDescriptors"}));
        } else {
            this.f40942n = collection;
        }
    }

    public final Collection<? extends PropertyDescriptor> mo7609m() {
        Collection<? extends PropertyDescriptor> emptyList = this.f40942n != null ? this.f40942n : Collections.emptyList();
        if (emptyList != null) {
            return emptyList;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl", "getOverriddenDescriptors"}));
    }

    public final PropertyDescriptor mo7825a(TypeSubstitutor typeSubstitutor) {
        if (typeSubstitutor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"originalSubstitutor", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl", "substitute"}));
        } else if (typeSubstitutor.f26329b.mo5796a()) {
            return this;
        } else {
            return m42979a(typeSubstitutor, aD_(), this.f40941m, this.f40934a, mo7829v(), true, mo7760t());
        }
    }

    public final /* bridge */ /* synthetic */ PropertyGetterDescriptor mo7826b() {
        return this.f40938e;
    }

    public final /* synthetic */ CallableMemberDescriptor mo7748a(DeclarationDescriptor declarationDescriptor, Modality modality, Visibility visibility, Kind kind) {
        declarationDescriptor = m42979a(TypeSubstitutor.f26327a, declarationDescriptor, modality, visibility, null, false, kind);
        if (declarationDescriptor != null) {
            return declarationDescriptor;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl", "copy"}));
    }
}
