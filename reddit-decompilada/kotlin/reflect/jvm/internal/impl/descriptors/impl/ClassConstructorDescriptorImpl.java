package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;

public class ClassConstructorDescriptorImpl extends FunctionDescriptorImpl implements ClassConstructorDescriptor {
    static final /* synthetic */ boolean f40899b = true;
    private static final Name f40900n = Name.m27426c("<init>");
    protected final boolean f40901a;

    public final /* bridge */ /* synthetic */ CallableMemberDescriptor mo7748a(DeclarationDescriptor declarationDescriptor, Modality modality, Visibility visibility, Kind kind) {
        return mo7817a(declarationDescriptor, modality, visibility, kind, false);
    }

    public /* synthetic */ FunctionDescriptorImpl mo7795a(DeclarationDescriptor declarationDescriptor, FunctionDescriptor functionDescriptor, Kind kind, Name name, Annotations annotations, SourceElement sourceElement) {
        return mo7837b(declarationDescriptor, functionDescriptor, kind, name, annotations, sourceElement);
    }

    public final /* synthetic */ DeclarationDescriptor aD_() {
        return m42884D();
    }

    public final /* synthetic */ DeclarationDescriptor aJ_() {
        return mo7812F();
    }

    public final /* synthetic */ CallableDescriptor aM_() {
        return mo7812F();
    }

    public final /* synthetic */ DeclarationDescriptorWithSource aO_() {
        return mo7812F();
    }

    public final /* synthetic */ DeclarationDescriptor mo7079b(TypeSubstitutor typeSubstitutor) {
        return mo7818a(typeSubstitutor);
    }

    public final /* synthetic */ FunctionDescriptor mo7797b(DeclarationDescriptor declarationDescriptor, Modality modality, Visibility visibility, Kind kind, boolean z) {
        return mo7817a(declarationDescriptor, modality, visibility, kind, z);
    }

    public final /* synthetic */ ConstructorDescriptor mo7819c(TypeSubstitutor typeSubstitutor) {
        return mo7818a(typeSubstitutor);
    }

    public final /* synthetic */ FunctionDescriptor mo7754d(TypeSubstitutor typeSubstitutor) {
        return mo7818a(typeSubstitutor);
    }

    public final /* synthetic */ CallableMemberDescriptor mo7759s() {
        return mo7812F();
    }

    public final /* synthetic */ ClassifierDescriptorWithTypeParameters mo7820u() {
        return m42884D();
    }

    public final /* synthetic */ FunctionDescriptor mo7761v() {
        return mo7812F();
    }

    protected ClassConstructorDescriptorImpl(ClassDescriptor classDescriptor, ConstructorDescriptor constructorDescriptor, Annotations annotations, boolean z, Kind kind, SourceElement sourceElement) {
        if (classDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"containingDeclaration", "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassConstructorDescriptorImpl", "<init>"}));
        } else if (annotations == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"annotations", "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassConstructorDescriptorImpl", "<init>"}));
        } else if (kind == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"kind", "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassConstructorDescriptorImpl", "<init>"}));
        } else if (sourceElement == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"source", "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassConstructorDescriptorImpl", "<init>"}));
        } else {
            super(classDescriptor, constructorDescriptor, annotations, f40900n, kind, sourceElement);
            this.f40901a = z;
        }
    }

    public static ClassConstructorDescriptorImpl m42883a(ClassDescriptor classDescriptor, Annotations annotations, SourceElement sourceElement) {
        if (classDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"containingDeclaration", "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassConstructorDescriptorImpl", "create"}));
        } else if (annotations == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"annotations", "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassConstructorDescriptorImpl", "create"}));
        } else if (sourceElement == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"source", "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassConstructorDescriptorImpl", "create"}));
        } else {
            return new ClassConstructorDescriptorImpl(classDescriptor, null, annotations, true, Kind.DECLARATION, sourceElement);
        }
    }

    public final ClassConstructorDescriptorImpl m42889a(List<ValueParameterDescriptor> list, Visibility visibility) {
        if (list == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"unsubstitutedValueParameters", "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassConstructorDescriptorImpl", "initialize"}));
        } else if (visibility == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"visibility", "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassConstructorDescriptorImpl", "initialize"}));
        } else {
            m42890a((List) list, visibility, m42884D().mo7719s());
            return this;
        }
    }

    public final ClassDescriptor m42884D() {
        ClassDescriptor classDescriptor = (ClassDescriptor) super.aD_();
        if (classDescriptor != null) {
            return classDescriptor;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassConstructorDescriptorImpl", "getContainingDeclaration"}));
    }

    private ClassConstructorDescriptor mo7812F() {
        ClassConstructorDescriptor classConstructorDescriptor = (ClassConstructorDescriptor) super.mo7761v();
        if (classConstructorDescriptor != null) {
            return classConstructorDescriptor;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassConstructorDescriptorImpl", "getOriginal"}));
    }

    public final ClassConstructorDescriptor mo7818a(TypeSubstitutor typeSubstitutor) {
        if (typeSubstitutor != null) {
            return (ClassConstructorDescriptor) super.mo7754d(typeSubstitutor);
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"originalSubstitutor", "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassConstructorDescriptorImpl", "substitute"}));
    }

    public final <R, D> R mo7078a(DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d) {
        return declarationDescriptorVisitor.mo5728a((ConstructorDescriptor) this, (Object) d);
    }

    public final Collection<? extends FunctionDescriptor> mo7609m() {
        Collection emptySet = Collections.emptySet();
        if (emptySet != null) {
            return emptySet;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassConstructorDescriptorImpl", "getOverriddenDescriptors"}));
    }

    public final void mo7749a(Collection<? extends CallableMemberDescriptor> collection) {
        if (collection == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"overriddenDescriptors", "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassConstructorDescriptorImpl", "setOverriddenDescriptors"}));
        } else if (!f40899b && collection.isEmpty() == null) {
            throw new AssertionError("Constructors cannot override anything");
        }
    }

    public ClassConstructorDescriptorImpl mo7837b(DeclarationDescriptor declarationDescriptor, FunctionDescriptor functionDescriptor, Kind kind, Name name, Annotations annotations, SourceElement sourceElement) {
        if (declarationDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"newOwner", "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassConstructorDescriptorImpl", "createSubstitutedCopy"}));
        } else if (kind == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"kind", "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassConstructorDescriptorImpl", "createSubstitutedCopy"}));
        } else if (annotations == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"annotations", "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassConstructorDescriptorImpl", "createSubstitutedCopy"}));
        } else if (sourceElement == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"source", "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassConstructorDescriptorImpl", "createSubstitutedCopy"}));
        } else if (kind != Kind.DECLARATION && kind != Kind.SYNTHESIZED) {
            name = new StringBuilder("Attempt at creating a constructor that is not a declaration: \ncopy from: ");
            name.append(this);
            name.append("\nnewOwner: ");
            name.append(declarationDescriptor);
            name.append("\nkind: ");
            name.append(kind);
            throw new IllegalStateException(name.toString());
        } else if (f40899b != null || name == null) {
            return new ClassConstructorDescriptorImpl((ClassDescriptor) declarationDescriptor, this, annotations, this.f40901a, Kind.DECLARATION, sourceElement);
        } else {
            functionDescriptor = new StringBuilder("Attempt to rename constructor: ");
            functionDescriptor.append(this);
            throw new AssertionError(functionDescriptor.toString());
        }
    }

    public final ClassConstructorDescriptor mo7817a(DeclarationDescriptor declarationDescriptor, Modality modality, Visibility visibility, Kind kind, boolean z) {
        ClassConstructorDescriptor classConstructorDescriptor = (ClassConstructorDescriptor) super.mo7797b(declarationDescriptor, modality, visibility, kind, z);
        if (classConstructorDescriptor != null) {
            return classConstructorDescriptor;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassConstructorDescriptorImpl", "copy"}));
    }

    public final ClassConstructorDescriptorImpl m42890a(List<ValueParameterDescriptor> list, Visibility visibility, List<TypeParameterDescriptor> list2) {
        if (list == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"unsubstitutedValueParameters", "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassConstructorDescriptorImpl", "initialize"}));
        } else if (visibility == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"visibility", "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassConstructorDescriptorImpl", "initialize"}));
        } else if (list2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"typeParameterDescriptors", "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassConstructorDescriptorImpl", "initialize"}));
        } else {
            ReceiverParameterDescriptor u;
            ClassDescriptor D = m42884D();
            if (D.mo7742l()) {
                DeclarationDescriptor aD_ = D.aD_();
                if (aD_ instanceof ClassDescriptor) {
                    u = ((ClassDescriptor) aD_).mo7740u();
                    super.mo7796a(null, u, list2, list, null, Modality.f25488a, visibility);
                    return this;
                }
            }
            u = null;
            super.mo7796a(null, u, list2, list, null, Modality.f25488a, visibility);
            return this;
        }
    }
}
