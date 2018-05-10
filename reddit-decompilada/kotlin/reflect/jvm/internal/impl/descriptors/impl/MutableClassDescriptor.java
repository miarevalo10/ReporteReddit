package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ModalityKt;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
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

public class MutableClassDescriptor extends ClassDescriptorBase {
    public static final /* synthetic */ boolean f40917f = true;
    public Modality f40918a;
    public Visibility f40919b;
    public List<TypeParameterDescriptor> f40920c;
    private final ClassKind f40921g;
    private final boolean f40922h;
    private TypeConstructor f40923i;
    private final Collection<KotlinType> f40924j;

    public final ClassConstructorDescriptor aH_() {
        return null;
    }

    public final ClassDescriptor mo7769e() {
        return null;
    }

    public final boolean mo7772k() {
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

    public final /* synthetic */ Collection mo7770f() {
        return m42934x();
    }

    public MutableClassDescriptor(DeclarationDescriptor declarationDescriptor, ClassKind classKind, Name name, SourceElement sourceElement) {
        if (classKind == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"kind", "kotlin/reflect/jvm/internal/impl/descriptors/impl/MutableClassDescriptor", "<init>"}));
        } else if (name == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"name", "kotlin/reflect/jvm/internal/impl/descriptors/impl/MutableClassDescriptor", "<init>"}));
        } else if (sourceElement == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"source", "kotlin/reflect/jvm/internal/impl/descriptors/impl/MutableClassDescriptor", "<init>"}));
        } else {
            super(LockBasedStorageManager.f33053a, declarationDescriptor, name, sourceElement);
            this.f40924j = new ArrayList();
            if (f40917f == null && classKind == ClassKind.OBJECT) {
                throw new AssertionError("Fix isCompanionObject()");
            }
            this.f40921g = classKind;
            this.f40922h = false;
        }
    }

    public final Annotations mo5718q() {
        Companion companion = Annotations.f32643a;
        Annotations a = Companion.m27115a();
        if (a != null) {
            return a;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/MutableClassDescriptor", "getAnnotations"}));
    }

    public final Modality aG_() {
        Modality modality = this.f40918a;
        if (modality != null) {
            return modality;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/MutableClassDescriptor", "getModality"}));
    }

    public final ClassKind mo7771g() {
        ClassKind classKind = this.f40921g;
        if (classKind != null) {
            return classKind;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/MutableClassDescriptor", "getKind"}));
    }

    public final Visibility mo7257j() {
        Visibility visibility = this.f40919b;
        if (visibility != null) {
            return visibility;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/MutableClassDescriptor", "getVisibility"}));
    }

    public final boolean mo7742l() {
        return this.f40922h;
    }

    public final TypeConstructor mo7610c() {
        TypeConstructor typeConstructor = this.f40923i;
        if (typeConstructor != null) {
            return typeConstructor;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/MutableClassDescriptor", "getTypeConstructor"}));
    }

    private static Set<ClassConstructorDescriptor> m42934x() {
        Set<ClassConstructorDescriptor> emptySet = Collections.emptySet();
        if (emptySet != null) {
            return emptySet;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/MutableClassDescriptor", "getConstructors"}));
    }

    public final List<TypeParameterDescriptor> mo7719s() {
        List<TypeParameterDescriptor> list = this.f40920c;
        if (list != null) {
            return list;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/MutableClassDescriptor", "getDeclaredTypeParameters"}));
    }

    public final void m42949w() {
        if (f40917f || this.f40923i == null) {
            this.f40923i = new ClassTypeConstructorImpl(this, ModalityKt.m27079a(this), this.f40920c, this.f40924j);
            for (ClassConstructorDescriptor classConstructorDescriptor : m42934x()) {
                ((ClassConstructorDescriptorImpl) classConstructorDescriptor).m42608a(mo7714h());
            }
            return;
        }
        throw new AssertionError(this.f40923i);
    }

    public final MemberScope mo7768d() {
        MemberScope memberScope = Empty.f38819a;
        if (memberScope != null) {
            return memberScope;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/MutableClassDescriptor", "getUnsubstitutedMemberScope"}));
    }

    public final MemberScope mo7767b() {
        MemberScope memberScope = Empty.f38819a;
        if (memberScope != null) {
            return memberScope;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/MutableClassDescriptor", "getStaticScope"}));
    }

    public String toString() {
        return DeclarationDescriptorImpl.m36235a(this);
    }
}
