package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.SubstitutingScope;
import kotlin.reflect.jvm.internal.impl.types.ClassTypeConstructorImpl;
import kotlin.reflect.jvm.internal.impl.types.DescriptorSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.Variance;

public class LazySubstitutingClassDescriptor implements ClassDescriptor {
    private final ClassDescriptor f40788a;
    private final TypeSubstitutor f40789b;
    private TypeSubstitutor f40790c;
    private List<TypeParameterDescriptor> f40791d;
    private List<TypeParameterDescriptor> f40792e;
    private TypeConstructor f40793f;

    class C27551 implements Function1<TypeParameterDescriptor, Boolean> {
        final /* synthetic */ LazySubstitutingClassDescriptor f36079a;

        C27551(LazySubstitutingClassDescriptor lazySubstitutingClassDescriptor) {
            this.f36079a = lazySubstitutingClassDescriptor;
        }

        public final /* synthetic */ Object mo6492a(Object obj) {
            return Boolean.valueOf(((TypeParameterDescriptor) obj).mo7711b() ^ 1);
        }
    }

    public final /* synthetic */ ClassifierDescriptor aI_() {
        return mo7741v();
    }

    public final /* synthetic */ DeclarationDescriptor aJ_() {
        return mo7741v();
    }

    public final /* synthetic */ DeclarationDescriptor mo7079b(TypeSubstitutor typeSubstitutor) {
        if (typeSubstitutor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"substitutor", "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazySubstitutingClassDescriptor", "substitute"}));
        } else if (!typeSubstitutor.f26329b.mo5796a()) {
            return new LazySubstitutingClassDescriptor(this, TypeSubstitutor.m27998a(typeSubstitutor.m28004a(), m42634w().m28004a()));
        } else {
            if (this != null) {
                return this;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/LazySubstitutingClassDescriptor", "substitute"}));
        }
    }

    public LazySubstitutingClassDescriptor(ClassDescriptor classDescriptor, TypeSubstitutor typeSubstitutor) {
        this.f40788a = classDescriptor;
        this.f40789b = typeSubstitutor;
    }

    private TypeSubstitutor m42634w() {
        if (this.f40790c == null) {
            if (this.f40789b.f26329b.mo5796a()) {
                this.f40790c = this.f40789b;
            } else {
                List b = this.f40788a.mo7610c().mo5723b();
                this.f40791d = new ArrayList(b.size());
                this.f40790c = DescriptorSubstitutor.m27928a(b, this.f40789b.m28004a(), this, this.f40791d);
                this.f40792e = CollectionsKt___CollectionsKt.m41427c(this.f40791d, new C27551(this));
            }
        }
        return this.f40790c;
    }

    public final TypeConstructor mo7610c() {
        TypeConstructor c = this.f40788a.mo7610c();
        if (!this.f40789b.f26329b.mo5796a()) {
            if (this.f40793f == null) {
                TypeSubstitutor w = m42634w();
                Collection<KotlinType> aL_ = c.aL_();
                Collection arrayList = new ArrayList(aL_.size());
                for (KotlinType b : aL_) {
                    arrayList.add(w.m28005b(b, Variance.f26337a));
                }
                this.f40793f = new ClassTypeConstructorImpl(this, c.mo5725d(), this.f40791d, arrayList);
            }
            c = this.f40793f;
            if (c != null) {
                return c;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/LazySubstitutingClassDescriptor", "getTypeConstructor"}));
        } else if (c != null) {
            return c;
        } else {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/LazySubstitutingClassDescriptor", "getTypeConstructor"}));
        }
    }

    public final MemberScope mo7737a(List<? extends TypeProjection> list) {
        if (list == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"typeArguments", "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazySubstitutingClassDescriptor", "getMemberScope"}));
        }
        list = this.f40788a.mo7737a((List) list);
        if (!this.f40789b.f26329b.mo5796a()) {
            return new SubstitutingScope(list, m42634w());
        }
        if (list != null) {
            return list;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/LazySubstitutingClassDescriptor", "getMemberScope"}));
    }

    public final MemberScope mo7738a(TypeSubstitution typeSubstitution) {
        if (typeSubstitution == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"typeSubstitution", "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazySubstitutingClassDescriptor", "getMemberScope"}));
        }
        typeSubstitution = this.f40788a.mo7738a(typeSubstitution);
        if (!this.f40789b.f26329b.mo5796a()) {
            return new SubstitutingScope(typeSubstitution, m42634w());
        }
        if (typeSubstitution != null) {
            return typeSubstitution;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/LazySubstitutingClassDescriptor", "getMemberScope"}));
    }

    public final MemberScope mo7768d() {
        MemberScope d = this.f40788a.mo7768d();
        if (!this.f40789b.f26329b.mo5796a()) {
            return new SubstitutingScope(d, m42634w());
        }
        if (d != null) {
            return d;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/LazySubstitutingClassDescriptor", "getUnsubstitutedMemberScope"}));
    }

    public final MemberScope mo7767b() {
        MemberScope b = this.f40788a.mo7767b();
        if (b != null) {
            return b;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/LazySubstitutingClassDescriptor", "getStaticScope"}));
    }

    public final SimpleType mo7714h() {
        return KotlinTypeFactory.m27950a(mo5718q(), this, TypeUtils.m28006a(mo7610c().mo5723b()));
    }

    public final ReceiverParameterDescriptor mo7740u() {
        throw new UnsupportedOperationException();
    }

    public final Collection<ClassConstructorDescriptor> mo7770f() {
        Collection<ClassConstructorDescriptor> f = this.f40788a.mo7770f();
        Collection<ClassConstructorDescriptor> arrayList = new ArrayList(f.size());
        for (ClassConstructorDescriptor classConstructorDescriptor : f) {
            arrayList.add(classConstructorDescriptor.mo7817a(this, classConstructorDescriptor.aG_(), classConstructorDescriptor.mo7257j(), classConstructorDescriptor.mo7760t(), false).mo7818a(m42634w()));
        }
        return arrayList;
    }

    public final Annotations mo5718q() {
        Annotations q = this.f40788a.mo5718q();
        if (q != null) {
            return q;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/LazySubstitutingClassDescriptor", "getAnnotations"}));
    }

    public final Name mo6689i() {
        Name i = this.f40788a.mo6689i();
        if (i != null) {
            return i;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/LazySubstitutingClassDescriptor", "getName"}));
    }

    public final ClassDescriptor mo7741v() {
        ClassDescriptor v = this.f40788a.mo7741v();
        if (v != null) {
            return v;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/LazySubstitutingClassDescriptor", "getOriginal"}));
    }

    public final DeclarationDescriptor aD_() {
        DeclarationDescriptor aD_ = this.f40788a.aD_();
        if (aD_ != null) {
            return aD_;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/LazySubstitutingClassDescriptor", "getContainingDeclaration"}));
    }

    public final ClassDescriptor mo7769e() {
        return this.f40788a.mo7769e();
    }

    public final ClassKind mo7771g() {
        ClassKind g = this.f40788a.mo7771g();
        if (g != null) {
            return g;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/LazySubstitutingClassDescriptor", "getKind"}));
    }

    public final Modality aG_() {
        Modality aG_ = this.f40788a.aG_();
        if (aG_ != null) {
            return aG_;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/LazySubstitutingClassDescriptor", "getModality"}));
    }

    public final Visibility mo7257j() {
        Visibility j = this.f40788a.mo7257j();
        if (j != null) {
            return j;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/LazySubstitutingClassDescriptor", "getVisibility"}));
    }

    public final boolean mo7742l() {
        return this.f40788a.mo7742l();
    }

    public final boolean mo7773m() {
        return this.f40788a.mo7773m();
    }

    public final boolean mo7745p() {
        return this.f40788a.mo7745p();
    }

    public final boolean mo7772k() {
        return this.f40788a.mo7772k();
    }

    public final boolean mo7743n() {
        return this.f40788a.mo7743n();
    }

    public final boolean mo7744o() {
        return this.f40788a.mo7744o();
    }

    public final <R, D> R mo7078a(DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d) {
        return declarationDescriptorVisitor.mo5727a((ClassDescriptor) this, (Object) d);
    }

    public final MemberScope mo7739t() {
        MemberScope t = this.f40788a.mo7739t();
        if (t != null) {
            return t;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/LazySubstitutingClassDescriptor", "getUnsubstitutedInnerClassesScope"}));
    }

    public final ClassConstructorDescriptor aH_() {
        return this.f40788a.aH_();
    }

    public final SourceElement mo7258r() {
        SourceElement sourceElement = SourceElement.f25498a;
        if (sourceElement != null) {
            return sourceElement;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/LazySubstitutingClassDescriptor", "getSource"}));
    }

    public final List<TypeParameterDescriptor> mo7719s() {
        m42634w();
        List<TypeParameterDescriptor> list = this.f40792e;
        if (list != null) {
            return list;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/LazySubstitutingClassDescriptor", "getDeclaredTypeParameters"}));
    }
}
