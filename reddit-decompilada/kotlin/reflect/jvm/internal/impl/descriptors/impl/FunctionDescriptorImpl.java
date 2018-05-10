package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationsKt;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.types.DescriptorSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;
import kotlin.reflect.jvm.internal.impl.utils.SmartSet;

public abstract class FunctionDescriptorImpl extends DeclarationDescriptorNonRootImpl implements FunctionDescriptor {
    private List<TypeParameterDescriptor> f40763a;
    private List<ValueParameterDescriptor> f40764b;
    protected ReceiverParameterDescriptor f40765c;
    public Visibility f40766d;
    public boolean f40767e;
    public boolean f40768f;
    public boolean f40769g;
    public boolean f40770h;
    public boolean f40771i;
    boolean f40772j;
    boolean f40773k;
    public boolean f40774l;
    protected Map<Object<?>, Object> f40775m;
    private KotlinType f40776n;
    private ReceiverParameterDescriptor f40777o;
    private Modality f40778p;
    private boolean f40779q;
    private boolean f40780r;
    private boolean f40781s;
    private boolean f40782t;
    private Collection<? extends FunctionDescriptor> f40783u;
    private volatile Function0<Set<FunctionDescriptor>> f40784v;
    private final FunctionDescriptor f40785w;
    private final Kind f40786x;
    private FunctionDescriptor f40787y;

    public class CopyConfiguration implements CopyBuilder<FunctionDescriptor> {
        protected TypeSubstitution f32646a;
        protected DeclarationDescriptor f32647b;
        protected Modality f32648c;
        protected Visibility f32649d;
        protected FunctionDescriptor f32650e;
        protected Kind f32651f;
        protected List<ValueParameterDescriptor> f32652g;
        protected KotlinType f32653h;
        protected ReceiverParameterDescriptor f32654i;
        protected KotlinType f32655j;
        protected Name f32656k;
        protected boolean f32657l;
        protected boolean f32658m;
        protected boolean f32659n;
        protected boolean f32660o;
        public Boolean f32661p;
        final /* synthetic */ FunctionDescriptorImpl f32662q;
        private boolean f32663r;
        private List<TypeParameterDescriptor> f32664s;
        private Annotations f32665t;
        private boolean f32666u;
        private SourceElement f32667v;
        private Map<Object<?>, Object> f32668w;

        public final /* synthetic */ CopyBuilder mo5741a(List list) {
            return m32998b(list);
        }

        public final /* synthetic */ CopyBuilder mo5742a(Kind kind) {
            if (kind == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"kind", "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration", "setKind"}));
            }
            this.f32651f = kind;
            if (this != null) {
                return this;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration", "setKind"}));
        }

        public final /* synthetic */ CopyBuilder mo5743a(DeclarationDescriptor declarationDescriptor) {
            if (declarationDescriptor == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"owner", "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration", "setOwner"}));
            }
            this.f32647b = declarationDescriptor;
            if (this != null) {
                return this;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration", "setOwner"}));
        }

        public final /* synthetic */ CopyBuilder mo5744a(Modality modality) {
            if (modality == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"modality", "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration", "setModality"}));
            }
            this.f32648c = modality;
            if (this != null) {
                return this;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration", "setModality"}));
        }

        public final /* synthetic */ CopyBuilder mo5746a(Visibility visibility) {
            if (visibility == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"visibility", "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration", "setVisibility"}));
            }
            this.f32649d = visibility;
            if (this != null) {
                return this;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration", "setVisibility"}));
        }

        public final /* synthetic */ CopyBuilder mo5747a(Annotations annotations) {
            if (annotations == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"additionalAnnotations", "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration", "setAdditionalAnnotations"}));
            }
            this.f32665t = annotations;
            if (this != null) {
                return this;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration", "setAdditionalAnnotations"}));
        }

        public final /* synthetic */ CopyBuilder mo5748a(Name name) {
            if (name == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"name", "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration", "setName"}));
            }
            this.f32656k = name;
            if (this != null) {
                return this;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration", "setName"}));
        }

        public final /* synthetic */ CopyBuilder mo5749a(KotlinType kotlinType) {
            if (kotlinType == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"type", "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration", "setReturnType"}));
            }
            this.f32655j = kotlinType;
            if (this != null) {
                return this;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration", "setReturnType"}));
        }

        public final /* synthetic */ CopyBuilder mo5750a(TypeSubstitution typeSubstitution) {
            if (typeSubstitution == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"substitution", "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration", "setSubstitution"}));
            }
            this.f32646a = typeSubstitution;
            if (this != null) {
                return this;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration", "setSubstitution"}));
        }

        public CopyConfiguration(TypeSubstitution typeSubstitution, DeclarationDescriptor declarationDescriptor, Modality modality, Visibility visibility, Kind kind, List<ValueParameterDescriptor> list, KotlinType kotlinType, KotlinType kotlinType2, Name name) {
            if (declarationDescriptor == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"substitution", "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration", "<init>"}));
            } else if (modality == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"newOwner", "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration", "<init>"}));
            } else if (visibility == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"newModality", "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration", "<init>"}));
            } else if (kind == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"newVisibility", "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration", "<init>"}));
            } else if (list == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"kind", "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration", "<init>"}));
            } else if (kotlinType == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"newValueParameterDescriptors", "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration", "<init>"}));
            } else if (name == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"newReturnType", "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration", "<init>"}));
            } else {
                this.f32662q = typeSubstitution;
                this.f32650e = null;
                this.f32654i = this.f32662q.f40765c;
                this.f32657l = true;
                this.f32658m = false;
                this.f32659n = false;
                this.f32660o = false;
                this.f32663r = this.f32662q.f40772j;
                this.f32664s = null;
                this.f32665t = null;
                this.f32666u = this.f32662q.f40773k;
                this.f32668w = new LinkedHashMap();
                this.f32661p = null;
                this.f32646a = declarationDescriptor;
                this.f32647b = modality;
                this.f32648c = visibility;
                this.f32649d = kind;
                this.f32651f = list;
                this.f32652g = kotlinType;
                this.f32653h = kotlinType2;
                this.f32655j = name;
                this.f32656k = null;
            }
        }

        public final CopyConfiguration m32998b(List<ValueParameterDescriptor> list) {
            if (list == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"parameters", "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration", "setValueParameters"}));
            }
            this.f32652g = list;
            if (this != null) {
                return this;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration", "setValueParameters"}));
        }

        public final CopyConfiguration m32995a(FunctionDescriptor functionDescriptor) {
            this.f32650e = functionDescriptor;
            if (this != null) {
                return this;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration", "setOriginal"}));
        }

        public final FunctionDescriptor mo5757f() {
            return this.f32662q.mo7816a(this);
        }

        public final /* synthetic */ CopyBuilder mo5756e() {
            this.f32666u = true;
            if (this != null) {
                return this;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration", "setHiddenForResolutionEverywhereBesideSupercalls"}));
        }

        public final /* synthetic */ CopyBuilder mo5755d() {
            this.f32663r = true;
            if (this != null) {
                return this;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration", "setHiddenToOvercomeSignatureClash"}));
        }

        public final /* synthetic */ CopyBuilder mo5754c() {
            this.f32660o = true;
            if (this != null) {
                return this;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration", "setDropOriginalInContainingParts"}));
        }

        public final /* synthetic */ CopyBuilder mo5752b() {
            this.f32659n = true;
            if (this != null) {
                return this;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration", "setPreserveSourceElement"}));
        }

        public final /* synthetic */ CopyBuilder mo5740a() {
            this.f32658m = true;
            if (this != null) {
                return this;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration", "setSignatureChange"}));
        }

        public final /* synthetic */ CopyBuilder mo5745a(ReceiverParameterDescriptor receiverParameterDescriptor) {
            this.f32654i = receiverParameterDescriptor;
            if (this != null) {
                return this;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration", "setDispatchReceiverParameter"}));
        }

        public final /* synthetic */ CopyBuilder mo5753b(KotlinType kotlinType) {
            this.f32653h = kotlinType;
            if (this != null) {
                return this;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration", "setExtensionReceiverType"}));
        }

        public final /* synthetic */ CopyBuilder mo5751a(boolean z) {
            this.f32657l = z;
            if (this != null) {
                return this;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration", "setCopyOverrides"}));
        }
    }

    public abstract FunctionDescriptorImpl mo7795a(DeclarationDescriptor declarationDescriptor, FunctionDescriptor functionDescriptor, Kind kind, Name name, Annotations annotations, SourceElement sourceElement);

    public /* synthetic */ CallableMemberDescriptor mo7748a(DeclarationDescriptor declarationDescriptor, Modality modality, Visibility visibility, Kind kind) {
        return mo7797b(declarationDescriptor, modality, visibility, kind, false);
    }

    public /* synthetic */ DeclarationDescriptor aJ_() {
        return mo7761v();
    }

    public /* synthetic */ CallableDescriptor aM_() {
        return mo7761v();
    }

    public /* synthetic */ DeclarationDescriptorWithSource aO_() {
        return mo7761v();
    }

    public /* synthetic */ DeclarationDescriptor mo7079b(TypeSubstitutor typeSubstitutor) {
        return mo7754d(typeSubstitutor);
    }

    public /* synthetic */ CallableMemberDescriptor mo7759s() {
        return mo7761v();
    }

    protected FunctionDescriptorImpl(DeclarationDescriptor declarationDescriptor, FunctionDescriptor functionDescriptor, Annotations annotations, Name name, Kind kind, SourceElement sourceElement) {
        if (declarationDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"containingDeclaration", "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl", "<init>"}));
        } else if (annotations == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"annotations", "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl", "<init>"}));
        } else if (name == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"name", "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl", "<init>"}));
        } else if (kind == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"kind", "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl", "<init>"}));
        } else if (sourceElement == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"source", "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl", "<init>"}));
        } else {
            super(declarationDescriptor, annotations, name, sourceElement);
            this.f40766d = Visibilities.f25512i;
            this.f40767e = false;
            this.f40768f = false;
            this.f40769g = false;
            this.f40770h = false;
            this.f40771i = false;
            this.f40779q = false;
            this.f40780r = false;
            this.f40772j = false;
            this.f40773k = false;
            this.f40774l = false;
            this.f40781s = true;
            this.f40782t = false;
            this.f40783u = null;
            this.f40784v = null;
            this.f40787y = null;
            this.f40775m = null;
            if (functionDescriptor == null) {
                functionDescriptor = this;
            }
            this.f40785w = functionDescriptor;
            this.f40786x = kind;
        }
    }

    public FunctionDescriptorImpl mo7796a(KotlinType kotlinType, ReceiverParameterDescriptor receiverParameterDescriptor, List<? extends TypeParameterDescriptor> list, List<ValueParameterDescriptor> list2, KotlinType kotlinType2, Modality modality, Visibility visibility) {
        if (list == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"typeParameters", "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl", "initialize"}));
        } else if (list2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"unsubstitutedValueParameters", "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl", "initialize"}));
        } else if (visibility == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"visibility", "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl", "initialize"}));
        } else {
            this.f40763a = CollectionsKt.m28089a((Collection) list);
            this.f40764b = list2;
            this.f40776n = kotlinType2;
            this.f40778p = modality;
            this.f40766d = visibility;
            this.f40777o = DescriptorFactory.m27627a((CallableDescriptor) this, kotlinType);
            this.f40765c = receiverParameterDescriptor;
            for (kotlinType = null; kotlinType < list.size(); kotlinType++) {
                TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor) list.get(kotlinType);
                if (typeParameterDescriptor.mo7713g() != kotlinType) {
                    list2 = new StringBuilder();
                    list2.append(typeParameterDescriptor);
                    list2.append(" index is ");
                    list2.append(typeParameterDescriptor.mo7713g());
                    list2.append(" but position is ");
                    list2.append(kotlinType);
                    throw new IllegalStateException(list2.toString());
                }
            }
            for (kotlinType = null; kotlinType < list2.size(); kotlinType++) {
                ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor) list2.get(kotlinType);
                if (valueParameterDescriptor.mo7801c() != kotlinType + 0) {
                    list2 = new StringBuilder();
                    list2.append(valueParameterDescriptor);
                    list2.append("index is ");
                    list2.append(valueParameterDescriptor.mo7801c());
                    list2.append(" but position is ");
                    list2.append(kotlinType);
                    throw new IllegalStateException(list2.toString());
                }
            }
            if (this != null) {
                return this;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl", "initialize"}));
        }
    }

    public final void m42608a(KotlinType kotlinType) {
        if (kotlinType == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"unsubstitutedReturnType", "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl", "setReturnType"}));
        } else {
            this.f40776n = kotlinType;
        }
    }

    public void mo7836a(boolean z) {
        this.f40781s = z;
    }

    public void mo7838b(boolean z) {
        this.f40782t = z;
    }

    public final ReceiverParameterDescriptor mo7755d() {
        return this.f40777o;
    }

    public final ReceiverParameterDescriptor mo7756e() {
        return this.f40765c;
    }

    public final Modality aG_() {
        Modality modality = this.f40778p;
        if (modality != null) {
            return modality;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl", "getModality"}));
    }

    public final Visibility mo7257j() {
        Visibility visibility = this.f40766d;
        if (visibility != null) {
            return visibility;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl", "getVisibility"}));
    }

    public final boolean mo7764y() {
        if (this.f40767e) {
            return true;
        }
        for (FunctionDescriptor y : mo7761v().mo7609m()) {
            if (y.mo7764y()) {
                return true;
            }
        }
        return false;
    }

    public final boolean mo7765z() {
        if (this.f40768f) {
            return true;
        }
        for (FunctionDescriptor z : mo7761v().mo7609m()) {
            if (z.mo7765z()) {
                return true;
            }
        }
        return false;
    }

    public boolean mo7745p() {
        return this.f40769g;
    }

    public boolean mo7752b() {
        return this.f40770h;
    }

    public boolean mo7753c() {
        return this.f40771i;
    }

    public boolean mo7747B() {
        return this.f40774l;
    }

    public final boolean mo7743n() {
        return this.f40779q;
    }

    public final boolean mo7744o() {
        return this.f40780r;
    }

    public final boolean mo7763x() {
        return this.f40772j;
    }

    public void mo7749a(Collection<? extends CallableMemberDescriptor> collection) {
        if (collection == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"overriddenDescriptors", "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl", "setOverriddenDescriptors"}));
        }
        this.f40783u = collection;
        collection = this.f40783u.iterator();
        while (collection.hasNext()) {
            if (((FunctionDescriptor) collection.next()).mo7746A()) {
                this.f40773k = true;
                return;
            }
        }
    }

    public final List<TypeParameterDescriptor> mo7735f() {
        List<TypeParameterDescriptor> list = this.f40763a;
        if (list != null) {
            return list;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl", "getTypeParameters"}));
    }

    public final List<ValueParameterDescriptor> mo7757k() {
        List<ValueParameterDescriptor> list = this.f40764b;
        if (list != null) {
            return list;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl", "getValueParameters"}));
    }

    public boolean mo7831E() {
        return this.f40781s;
    }

    public boolean mo7758l() {
        return this.f40782t;
    }

    public final KotlinType aN_() {
        return this.f40776n;
    }

    public FunctionDescriptor mo7761v() {
        FunctionDescriptor v = this.f40785w == this ? this : this.f40785w.mo7761v();
        if (v != null) {
            return v;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl", "getOriginal"}));
    }

    public final Kind mo7760t() {
        Kind kind = this.f40786x;
        if (kind != null) {
            return kind;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl", "getKind"}));
    }

    public final boolean mo7746A() {
        return this.f40773k;
    }

    public CopyBuilder<? extends FunctionDescriptor> mo7736C() {
        return m42618e(TypeSubstitutor.f26327a);
    }

    protected final CopyConfiguration m42618e(TypeSubstitutor typeSubstitutor) {
        if (typeSubstitutor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"substitutor", "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl", "newCopyBuilder"}));
        }
        TypeSubstitution a = typeSubstitutor.m28004a();
        DeclarationDescriptor aD_ = aD_();
        Modality aG_ = aG_();
        Visibility j = mo7257j();
        Kind t = mo7760t();
        List k = mo7757k();
        if (this.f40777o == null) {
            typeSubstitutor = null;
        } else {
            typeSubstitutor = this.f40777o.mo7777x();
        }
        return new CopyConfiguration(this, a, aD_, aG_, j, t, k, typeSubstitutor, this.f40776n);
    }

    protected FunctionDescriptor mo7816a(CopyConfiguration copyConfiguration) {
        FunctionDescriptorImpl functionDescriptorImpl = this;
        CopyConfiguration copyConfiguration2 = copyConfiguration;
        if (copyConfiguration2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"configuration", "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl", "doSubstitute"}));
        }
        KotlinType kotlinType;
        ReceiverParameterDescriptor receiverParameterDescriptor;
        Annotations a = copyConfiguration.f32665t != null ? AnnotationsKt.m27117a(mo5718q(), copyConfiguration.f32665t) : mo5718q();
        DeclarationDescriptor declarationDescriptor = copyConfiguration2.f32647b;
        FunctionDescriptor functionDescriptor = copyConfiguration2.f32650e;
        Kind kind = copyConfiguration2.f32651f;
        Name name = copyConfiguration2.f32656k;
        boolean z = copyConfiguration2.f32659n;
        FunctionDescriptor functionDescriptor2 = copyConfiguration2.f32650e;
        SourceElement b = copyConfiguration.f32667v;
        if (b == null) {
            SourceElement r = z ? functionDescriptor2 != null ? functionDescriptor2.mo7258r() : mo7761v().mo7258r() : SourceElement.f25498a;
            if (r == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl", "getSourceToUseForCopy"}));
            }
            b = r;
        } else if (b == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl", "getSourceToUseForCopy"}));
        }
        FunctionDescriptor a2 = mo7795a(declarationDescriptor, functionDescriptor, kind, name, a, b);
        List f = copyConfiguration.f32664s == null ? mo7735f() : copyConfiguration.f32664s;
        List arrayList = new ArrayList(f.size());
        final TypeSubstitutor a3 = DescriptorSubstitutor.m27928a(f, copyConfiguration2.f32646a, a2, arrayList);
        if (copyConfiguration2.f32653h != null) {
            KotlinType b2 = a3.m28005b(copyConfiguration2.f32653h, Variance.f26338b);
            if (b2 == null) {
                return null;
            }
            kotlinType = b2;
        } else {
            kotlinType = null;
        }
        if (copyConfiguration2.f32654i != null) {
            ReceiverParameterDescriptor a4 = copyConfiguration2.f32654i.mo7794a(a3);
            if (a4 == null) {
                return null;
            }
            receiverParameterDescriptor = a4;
        } else {
            receiverParameterDescriptor = null;
        }
        List a5 = m42596a(a2, copyConfiguration2.f32652g, a3, copyConfiguration2.f32660o, copyConfiguration2.f32659n);
        if (a5 == null) {
            return null;
        }
        KotlinType b3 = a3.m28005b(copyConfiguration2.f32655j, Variance.f26339c);
        if (b3 == null) {
            return null;
        }
        a2.mo7796a(kotlinType, receiverParameterDescriptor, arrayList, a5, b3, copyConfiguration2.f32648c, copyConfiguration2.f32649d);
        a2.f40767e = functionDescriptorImpl.f40767e;
        a2.f40768f = functionDescriptorImpl.f40768f;
        a2.f40769g = functionDescriptorImpl.f40769g;
        a2.f40770h = functionDescriptorImpl.f40770h;
        a2.f40771i = functionDescriptorImpl.f40771i;
        a2.f40774l = functionDescriptorImpl.f40774l;
        a2.f40779q = functionDescriptorImpl.f40779q;
        a2.f40780r = functionDescriptorImpl.f40780r;
        a2.mo7836a(functionDescriptorImpl.f40781s);
        a2.f40772j = copyConfiguration.f32663r;
        a2.f40773k = copyConfiguration.f32666u;
        a2.mo7838b(copyConfiguration.f32661p != null ? copyConfiguration.f32661p.booleanValue() : functionDescriptorImpl.f40782t);
        if (!(copyConfiguration.f32668w.isEmpty() && functionDescriptorImpl.f40775m == null)) {
            Map g = copyConfiguration.f32668w;
            if (functionDescriptorImpl.f40775m != null) {
                for (Entry entry : functionDescriptorImpl.f40775m.entrySet()) {
                    if (!g.containsKey(entry.getKey())) {
                        g.put(entry.getKey(), entry.getValue());
                    }
                }
            }
            if (g.size() == 1) {
                a2.f40775m = Collections.singletonMap(g.keySet().iterator().next(), g.values().iterator().next());
            } else {
                a2.f40775m = g;
            }
        }
        if (copyConfiguration2.f32658m || functionDescriptorImpl.f40787y != null) {
            FunctionDescriptor functionDescriptor3;
            if (functionDescriptorImpl.f40787y != null) {
                functionDescriptor3 = functionDescriptorImpl.f40787y;
            } else {
                functionDescriptor3 = functionDescriptorImpl;
            }
            a2.f40787y = functionDescriptor3.mo7754d(a3);
        }
        if (copyConfiguration2.f32657l && !mo7761v().mo7609m().isEmpty()) {
            if (copyConfiguration2.f32646a.mo5796a()) {
                Function0 function0 = functionDescriptorImpl.f40784v;
                if (function0 != null) {
                    a2.f40784v = function0;
                } else {
                    a2.mo7749a(mo7609m());
                }
            } else {
                a2.f40784v = new Function0<Set<FunctionDescriptor>>(functionDescriptorImpl) {
                    final /* synthetic */ FunctionDescriptorImpl f36078b;

                    public /* synthetic */ Object invoke() {
                        SmartSet b = SmartSet.m28120b();
                        for (FunctionDescriptor d : this.f36078b.mo7609m()) {
                            b.add(d.mo7754d(a3));
                        }
                        return b;
                    }
                };
            }
        }
        return a2;
    }

    public FunctionDescriptor mo7797b(DeclarationDescriptor declarationDescriptor, Modality modality, Visibility visibility, Kind kind, boolean z) {
        declarationDescriptor = mo7736C().mo5743a(declarationDescriptor).mo5744a(modality).mo5746a(visibility).mo5742a(kind).mo5751a(z).mo5757f();
        if (declarationDescriptor != null) {
            return declarationDescriptor;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl", "copy"}));
    }

    public <R, D> R mo7078a(DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d) {
        return declarationDescriptorVisitor.mo5729a((FunctionDescriptor) this, (Object) d);
    }

    public static List<ValueParameterDescriptor> m42596a(FunctionDescriptor functionDescriptor, List<ValueParameterDescriptor> list, TypeSubstitutor typeSubstitutor, boolean z, boolean z2) {
        TypeSubstitutor typeSubstitutor2 = typeSubstitutor;
        if (list == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"unsubstitutedValueParameters", "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl", "getSubstitutedValueParameters"}));
        } else if (typeSubstitutor2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"substitutor", "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl", "getSubstitutedValueParameters"}));
        } else {
            List<ValueParameterDescriptor> arrayList = new ArrayList(list.size());
            for (ValueParameterDescriptor valueParameterDescriptor : list) {
                KotlinType kotlinType;
                KotlinType b = typeSubstitutor2.m28005b(valueParameterDescriptor.mo7777x(), Variance.f26338b);
                KotlinType n = valueParameterDescriptor.mo7803n();
                if (n == null) {
                    kotlinType = null;
                } else {
                    kotlinType = typeSubstitutor2.m28005b(n, Variance.f26338b);
                }
                if (b == null) {
                    return null;
                }
                arrayList.add(new ValueParameterDescriptorImpl(functionDescriptor, z ? null : valueParameterDescriptor, valueParameterDescriptor.mo7801c(), valueParameterDescriptor.mo5718q(), valueParameterDescriptor.mo6689i(), b, valueParameterDescriptor.mo7802h(), valueParameterDescriptor.mo7805p(), valueParameterDescriptor.mo7806s(), kotlinType, z2 ? valueParameterDescriptor.mo7258r() : SourceElement.f25498a));
            }
            return arrayList;
        }
    }

    public final FunctionDescriptor mo7762w() {
        return this.f40787y;
    }

    public Collection<? extends FunctionDescriptor> mo7609m() {
        Function0 function0 = this.f40784v;
        if (function0 != null) {
            this.f40783u = (Collection) function0.invoke();
            this.f40784v = null;
        }
        Collection<? extends FunctionDescriptor> emptyList = this.f40783u != null ? this.f40783u : Collections.emptyList();
        if (emptyList != null) {
            return emptyList;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl", "getOverriddenDescriptors"}));
    }

    public FunctionDescriptor mo7754d(TypeSubstitutor typeSubstitutor) {
        if (typeSubstitutor != null) {
            return typeSubstitutor.f26329b.mo5796a() ? this : m42618e(typeSubstitutor).m32995a(mo7761v()).mo5757f();
        } else {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"originalSubstitutor", "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl", "substitute"}));
        }
    }
}
