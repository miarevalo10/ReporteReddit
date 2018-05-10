package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope.Empty;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.types.ClassTypeConstructorImpl;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;

public class ClassDescriptorImpl extends ClassDescriptorBase {
    static final /* synthetic */ boolean f40902a = true;
    private final Modality f40903b;
    private final ClassKind f40904c;
    private final TypeConstructor f40905f;
    private MemberScope f40906g;
    private Set<ClassConstructorDescriptor> f40907h;
    private ClassConstructorDescriptor f40908i;

    public final ClassDescriptor mo7769e() {
        return null;
    }

    public final boolean mo7772k() {
        return false;
    }

    public final boolean mo7742l() {
        return false;
    }

    public final boolean mo7773m() {
        return false;
    }

    public final boolean mo7743n() {
        return false;
    }

    public final boolean mo7744o() {
        return false;
    }

    public ClassDescriptorImpl(DeclarationDescriptor declarationDescriptor, Name name, Modality modality, ClassKind classKind, Collection<KotlinType> collection, SourceElement sourceElement) {
        if (declarationDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"containingDeclaration", "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorImpl", "<init>"}));
        } else if (name == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"name", "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorImpl", "<init>"}));
        } else if (modality == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"modality", "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorImpl", "<init>"}));
        } else if (classKind == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"kind", "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorImpl", "<init>"}));
        } else if (collection == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"supertypes", "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorImpl", "<init>"}));
        } else if (sourceElement == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"source", "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorImpl", "<init>"}));
        } else {
            super(LockBasedStorageManager.f33053a, declarationDescriptor, name, sourceElement);
            if (f40902a == null && modality == Modality.f25489b) {
                name = new StringBuilder("Implement getSealedSubclasses() for this class: ");
                name.append(getClass());
                throw new AssertionError(name.toString());
            }
            this.f40903b = modality;
            this.f40904c = classKind;
            this.f40905f = new ClassTypeConstructorImpl(this, false, Collections.emptyList(), collection);
        }
    }

    public final void m42902a(MemberScope memberScope, Set<ClassConstructorDescriptor> set, ClassConstructorDescriptor classConstructorDescriptor) {
        if (memberScope == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"unsubstitutedMemberScope", "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorImpl", "initialize"}));
        } else if (set == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"constructors", "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorImpl", "initialize"}));
        } else {
            this.f40906g = memberScope;
            this.f40907h = set;
            this.f40908i = classConstructorDescriptor;
        }
    }

    public final Annotations mo5718q() {
        Companion companion = Annotations.f32643a;
        Annotations a = Companion.m27115a();
        if (a != null) {
            return a;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorImpl", "getAnnotations"}));
    }

    public final TypeConstructor mo7610c() {
        TypeConstructor typeConstructor = this.f40905f;
        if (typeConstructor != null) {
            return typeConstructor;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorImpl", "getTypeConstructor"}));
    }

    public final Collection<ClassConstructorDescriptor> mo7770f() {
        Collection collection = this.f40907h;
        if (collection != null) {
            return collection;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorImpl", "getConstructors"}));
    }

    public final MemberScope mo7768d() {
        MemberScope memberScope = this.f40906g;
        if (memberScope != null) {
            return memberScope;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorImpl", "getUnsubstitutedMemberScope"}));
    }

    public final MemberScope mo7767b() {
        MemberScope memberScope = Empty.f38819a;
        if (memberScope != null) {
            return memberScope;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorImpl", "getStaticScope"}));
    }

    public final ClassKind mo7771g() {
        ClassKind classKind = this.f40904c;
        if (classKind != null) {
            return classKind;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorImpl", "getKind"}));
    }

    public final ClassConstructorDescriptor aH_() {
        return this.f40908i;
    }

    public final Modality aG_() {
        Modality modality = this.f40903b;
        if (modality != null) {
            return modality;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorImpl", "getModality"}));
    }

    public final Visibility mo7257j() {
        Visibility visibility = Visibilities.f25508e;
        if (visibility != null) {
            return visibility;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorImpl", "getVisibility"}));
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("class ");
        stringBuilder.append(mo6689i());
        return stringBuilder.toString();
    }

    public final List<TypeParameterDescriptor> mo7719s() {
        List<TypeParameterDescriptor> emptyList = Collections.emptyList();
        if (emptyList != null) {
            return emptyList;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorImpl", "getDeclaredTypeParameters"}));
    }
}
